package com.hzchum.scim.contract.core.biz.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.biz.finance.ContractGivingCreditDetailBiz;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCreditDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractGivingCreditDetailDto;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditDetailService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditService;
import com.hzchum.scim.contract.core.mapper.finance.ContractGivingCreditDetailMapper;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ContractGivingCreditDetailBizImpl
   extends IBizImpl<ContractGivingCreditDetailService, ContractGivingCreditDetailMapper, ContractGivingCreditDetail>
   implements ContractGivingCreditDetailBiz {
   @Resource
   private UserService userService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PurchaseOrderService orderService;
   @Resource
   private ContractGivingCreditService givingCreditService;
   @Resource private SupplierPaymentService supplierPaymentService;
   @Resource private SubcontractOrderService subcontractOrderService;

   @Override
   public PageVO<ContractGivingCreditDetailDto> pageSize(
      Long creditId, LocalDateTime startDate, LocalDateTime endDate, Integer auditStatus, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ContractGivingCreditDetail> detailList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractGivingCreditDetail.class).eq(ContractGivingCreditDetail::getCreditId, creditId).orderByDesc(BaseEntity::getCreateTime)
         );
      if (detailList.isEmpty()) {
         return new PageVO<>();
      }

      Map<Long, PurchaseOrder> purchaseOrderMap = this.orderService.list().stream().collect(Collectors.toMap(PurchaseOrder::getId, Function.identity()));
      Set<Long> paymentIds = detailList.stream().map(ContractGivingCreditDetail::getSupplierPaymentId)
         .filter(id -> id != null && id > 0).collect(Collectors.toSet());
      Map<Long, SupplierPayment> paymentMap = paymentIds.isEmpty() ? Collections.emptyMap() : this.supplierPaymentService
         .listByIds(paymentIds).stream().collect(Collectors.toMap(SupplierPayment::getId, Function.identity()));
      Set<Long> subcontractIds = paymentMap.values().stream()
         .filter(payment -> Objects.equals(payment.getPropertyType(), SupplierPropertyTypeEnum.SUB_FEE.getType()))
         .map(SupplierPayment::getOrderId).filter(Objects::nonNull).collect(Collectors.toSet());
      Map<Long, SubcontractOrder> subcontractMap = subcontractIds.isEmpty() ? Collections.emptyMap() : this.subcontractOrderService
         .listByIds(subcontractIds).stream().collect(Collectors.toMap(SubcontractOrder::getId, Function.identity()));
      Map<Long, User> userMap = this.userService.list(Wrappers.lambdaQuery(User.class)).stream().collect(Collectors.toMap(User::getId, Function.identity()));
      Map<Long, ContractProject> projectMap = this.projectService
         .list(Wrappers.lambdaQuery(ContractProject.class))
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      List<ContractGivingCreditDetailDto> dto = new ArrayList<>();

      for (ContractGivingCreditDetail a : detailList) {
         ContractGivingCreditDetailDto detailDto = BeanUtil.copy(a, ContractGivingCreditDetailDto.class);
         SupplierPayment payment = paymentMap.get(a.getSupplierPaymentId());
         if (payment != null && Objects.equals(payment.getOrderId(), a.getOrderId())
               && Objects.equals(payment.getProjectId(), a.getProjectId())) {
            if (Objects.equals(payment.getPropertyType(), SupplierPropertyTypeEnum.SUB_FEE.getType())) {
               SubcontractOrder order = subcontractMap.get(payment.getOrderId());
               if (order != null && Objects.equals(order.getProjectId(), a.getProjectId())) detailDto.setPurchaseNumber(order.getSerialNumber());
            } else if (Objects.equals(payment.getPropertyType(), SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())
                  || Objects.equals(payment.getPropertyType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())) {
               PurchaseOrder order = purchaseOrderMap.get(payment.getOrderId());
               if (order != null) detailDto.setPurchaseNumber(order.getSerialNumber());
            }
         } else if (a.getPurchaseId() != null && (payment == null
               || Objects.equals(payment.getOrderId(), a.getPurchaseId())
                  && (Objects.equals(payment.getPropertyType(), SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())
                     || Objects.equals(payment.getPropertyType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())))) {
            PurchaseOrder order = purchaseOrderMap.get(a.getPurchaseId());
            if (order != null) detailDto.setPurchaseNumber(order.getSerialNumber());
         }
         ContractProject contractProject = projectMap.get(a.getProjectId());
         if (contractProject != null) {
            ProjectInfo info = new ProjectInfo();
            info.setId(contractProject.getId());
            info.setName(contractProject.getName());
            info.setShortName(contractProject.getShortName());
            detailDto.setProject(info);
         }

         User user = userMap.get(a.getUserId());
         if (user != null) {
            NameInfo nameInfo = new NameInfo();
            nameInfo.setId(user.getId());
            nameInfo.setName(user.getName());
            detailDto.setUser(nameInfo);
         }

         dto.add(detailDto);
      }

      return new PageVO<>(dto);
   }
}
