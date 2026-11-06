package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.AnnualContract;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AnnualContractDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.AnnualContractDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.AnnualContractService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.mapper.wmsUse.AnnualContractMapper;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnnualContractServiceImpl extends ServiceImpl<AnnualContractMapper, AnnualContract> implements AnnualContractService {
   @Resource
   private SupplierService supplierService;
   @Resource
   AttachmentService attachmentService;
   @Resource
   PurchaseOrderService purchaseOrderService;
   @Resource
   InboundService inboundService;

   @Override
   public PageVO<AnnualContractDTO> pageInfo(Integer pageNumber, Integer pageSize, List<String> sort, Boolean status, Long supplierId) {
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<AnnualContract> pageInfo = PageHelper.<AnnualContract>startPage(pageNumber, pageSize, s)
         .doSelectPageInfo(() -> this.listInfo(status, supplierId));
      List<PurchaseOrder> purchaseOrderList = new ArrayList<>();
      List<Inbound> inbounds = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(pageInfo.getList())) {
         List<Long> annualContractIds = pageInfo.getList().stream().map(AnnualContract::getId).collect(Collectors.toList());
         purchaseOrderList = this.purchaseOrderService
            .list(
               (Wrapper<PurchaseOrder>)(new LambdaQueryWrapper<PurchaseOrder>().eq(PurchaseOrder::getDataStatus, DataStatusEnum.SUCCEED.getType()))
                  .in(PurchaseOrder::getAnnualContractId, annualContractIds)
            );
         if (CollectionUtil.isNotEmpty(purchaseOrderList)) {
            List<Long> purchaseOrderIds = purchaseOrderList.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
            inbounds = this.inboundService
               .list(
                  (Wrapper<Inbound>)(new LambdaQueryWrapper<Inbound>().eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()))
                     .in(Inbound::getPurchaseId, purchaseOrderIds)
               );
         }
      }

      List<PurchaseOrder> finalPurchaseOrderList = purchaseOrderList;
      List<Inbound> finalInbounds = inbounds;
      List<AnnualContractDTO> collect = pageInfo.getList()
         .stream()
         .map(
            annualContract -> {
               AnnualContractDTO dto = BeanUtil.copy(annualContract, AnnualContractDTO.class, "attachments");
               BigDecimal amount = BigDecimal.ZERO;
               BigDecimal lastYearAmount = BigDecimal.ZERO;
               BigDecimal thisYearAmount = BigDecimal.ZERO;
               List<PurchaseOrder> purchaseOrders = finalPurchaseOrderList.stream()
                  .filter(p -> p.getAnnualContractId().equals(annualContract.getId()))
                  .collect(Collectors.toList());
               if (CollectionUtil.isNotEmpty(purchaseOrders)) {
                  List<Long> puIds = purchaseOrders.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
                  List<Inbound> inboundList = finalInbounds.stream().filter(i -> puIds.contains(i.getPurchaseId())).collect(Collectors.toList());
                  amount = inboundList.stream().map(Inbound::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
                  dto.setAmount(amount);
                  LocalDateTime lastYearStart = LocalDateTime.of(LocalDate.now().minusYears(1L).getYear(), 1, 1, 0, 0, 0);
                  LocalDateTime lastYearEnd = LocalDateTime.of(LocalDate.now().minusYears(1L).getYear(), 12, 31, 23, 59, 59);
                  LocalDateTime thisYearStart = LocalDateTime.of(LocalDate.now().getYear(), 1, 1, 0, 0, 0);
                  LocalDateTime thisYearEnd = LocalDateTime.of(LocalDate.now().getYear(), 12, 31, 23, 59, 59);
                  lastYearAmount = inboundList.stream()
                     .filter(i -> i.getReviewTime().isAfter(lastYearStart.minusSeconds(1L)) && i.getReviewTime().isBefore(lastYearEnd.plusSeconds(1L)))
                     .map(Inbound::getAmount)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  dto.setLastYearAmount(lastYearAmount);
                  thisYearAmount = inboundList.stream()
                     .filter(i -> i.getReviewTime().isAfter(thisYearStart.minusSeconds(1L)) && i.getReviewTime().isBefore(thisYearEnd.plusSeconds(1L)))
                     .map(Inbound::getAmount)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  dto.setThisYearAmount(thisYearAmount);
               }

               String shortName = this.supplierService.getById(annualContract.getSupplierId()).getShortName();
               dto.setSupplierName(shortName);
               dto.setCreateTime(annualContract.getCreateTime());
               if (StrUtil.isNotBlank(annualContract.getAttachments())) {
                  List<AttachmentDTO> attachmentDTOS = this.attachmentService.listByIds(annualContract.getAttachments());
                  dto.setAttachments(attachmentDTOS);
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(pageInfo, collect);
   }

   @Override
   public Boolean updateAnnualContract(AnnualContractDTOParam param) {
      AnnualContract annualContract = this.baseMapper.selectById(param.getId());
      List<AnnualContract> annualContracts = this.baseMapper
         .selectList(
            (Wrapper<AnnualContract>)((new LambdaQueryWrapper<AnnualContract>()
                     .eq(AnnualContract::getSupplierId, annualContract.getSupplierId()))
                  .eq(AnnualContract::getStatus, Boolean.FALSE))
               .ne(AnnualContract::getId, annualContract.getId())
         );
      Preconditions.checkArgument(CollectionUtil.isEmpty(annualContracts), "存在未结算的年度合同，修改失败");
      LocalDateTime startTime = LocalDateTimeUtil.beginOfDay(param.getTimeStart());
      param.setTimeStart(startTime);
      LocalDateTime endTime = LocalDateTimeUtil.endOfDay(param.getTimeEnd());
      param.setTimeEnd(endTime);
      List<PurchaseOrder> list = this.purchaseOrderService
         .list(new LambdaQueryWrapper<PurchaseOrder>().eq(annualContract.getId() != null, PurchaseOrder::getAnnualContractId, annualContract.getId()));
      String basicClassName = null;
      if (CollectionUtil.isNotEmpty(param.getDelBasicClassList())) {
         for (Integer basicClass : param.getDelBasicClassList()) {
            List<PurchaseOrder> collect = list.stream().filter(l -> (l.getBasicClass() & basicClass) >= 1).collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(collect)) {
               String nameByType = BasicClassEnum.getNameByType(basicClass);
               basicClassName = nameByType + "-";
            }
         }
      }

      Preconditions.checkArgument(ObjectUtil.isEmpty(basicClassName), "物料分类已被使用，禁止删除！！！物料为：" + basicClassName);
      PurchaseOrder purchaseOrderMin = list.stream().min(Comparator.comparing(BaseEntity::getCreateTime)).orElse(null);
      PurchaseOrder purchaseOrderMax = list.stream().max(Comparator.comparing(BaseEntity::getCreateTime)).orElse(null);
      if (ObjectUtil.isNotEmpty(purchaseOrderMin)) {
         LocalDateTime start = LocalDateTimeUtil.beginOfDay(param.getTimeStart());
         LocalDateTime end = LocalDateTimeUtil.endOfDay(param.getTimeEnd());
         if (start.isAfter(purchaseOrderMin.getCreateTime()) || end.isBefore(purchaseOrderMax.getCreateTime())) {
            Preconditions.checkArgument(
               false, "有效期时间段更改失败，绑定该年度合同的自合营采购单最小创建时间为：" + purchaseOrderMin.getCreateTime() + "最大创建时间为：" + purchaseOrderMax.getCreateTime()
            );
         }
      }

      if (CollectionUtil.isNotEmpty(list)) {
         Preconditions.checkArgument(
            param.getSupplierId().equals(annualContract.getSupplierId()) && param.getSerialNumber().equals(annualContract.getSerialNumber()),
            "该年度合同有采购订单,仅支持修改有效期和附件"
         );
      }

      AnnualContract copy = BeanUtil.copy(param, AnnualContract.class, "attachments");
      copy.setAttachments(CollectionUtil.isNotEmpty(param.getAttachments()) ? StrUtil.join(",", param.getAttachments()) : null);
      copy.setId(annualContract.getId());
      copy.setUpdateTime(LocalDateTime.now());
      this.baseMapper.updateById(copy);
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean addAnnualContract(AnnualContractDTOParam param) {
      List<AnnualContract> annualContracts = this.baseMapper
         .selectList(
            (Wrapper<AnnualContract>)(new LambdaQueryWrapper<AnnualContract>().eq(AnnualContract::getSupplierId, param.getSupplierId()))
               .eq(AnnualContract::getStatus, Boolean.FALSE)
         );
      Preconditions.checkArgument(CollectionUtil.isEmpty(annualContracts), "存在未结算的年度合同，添加失败");
      LocalDateTime startTime = LocalDateTimeUtil.beginOfDay(param.getTimeStart());
      param.setTimeStart(startTime);
      LocalDateTime endTime = LocalDateTimeUtil.endOfDay(param.getTimeEnd());
      param.setTimeEnd(endTime);
      AnnualContract copy = BeanUtil.copy(param, AnnualContract.class, "attachments");
      copy.setAttachments(CollectionUtil.isNotEmpty(param.getAttachments()) ? StrUtil.join(",", param.getAttachments()) : null);
      String shortName = this.supplierService.getOne(new LambdaQueryWrapper<Supplier>().eq(true, Supplier::getId, copy.getSupplierId())).getShortName();
      copy.setSupplierName(shortName);
      SecurityUser currentUser = UserUtil.getCurrentUser();
      copy.setApplicantId(currentUser.getId());
      copy.setApplicantName(currentUser.getName());
      copy.setStatus(Boolean.FALSE);
      this.baseMapper.insert(copy);
      return true;
   }

   @Override
   public Boolean deleteAnnualContract(Long id) {
      AnnualContract annualContract = this.baseMapper.selectById(id);
      List<PurchaseOrder> list = this.purchaseOrderService
         .list((Wrapper<PurchaseOrder>)new LambdaQueryWrapper<PurchaseOrder>().eq(PurchaseOrder::getAnnualContractId, annualContract.getId()));
      Preconditions.checkArgument(list.size() == 0, "该年度合同已有采购订单不能删除");
      this.baseMapper.deleteById(id);
      return true;
   }

   @Override
   public Boolean updateAnnualContractStatus(Long id, Boolean status) {
      AnnualContract annualContract = this.baseMapper.selectById(id);
      List<AnnualContract> annualContracts = this.baseMapper
         .selectList(
            (Wrapper<AnnualContract>)((new LambdaQueryWrapper<AnnualContract>()
                     .eq(AnnualContract::getSupplierId, annualContract.getSupplierId()))
                  .eq(AnnualContract::getStatus, Boolean.FALSE))
               .ne(AnnualContract::getId, id)
         );
      Preconditions.checkArgument(CollectionUtil.isEmpty(annualContracts), "存在未结算的年度合同，修改失败");
      Preconditions.checkArgument(annualContract.getTimeEnd().isAfter(LocalDateTime.now()), "当前合同已经到期，不能修改状态");
      annualContract.setStatus(status);
      return this.baseMapper.updateById(annualContract) == 1;
   }

   public List<AnnualContract> listInfo(Boolean status, Long supplierId) {
      return this.baseMapper
         .selectList(
            (new LambdaQueryWrapper<AnnualContract>().eq(status != null, AnnualContract::getStatus, status))
               .eq(supplierId != null, AnnualContract::getSupplierId, supplierId)
         );
   }
}
