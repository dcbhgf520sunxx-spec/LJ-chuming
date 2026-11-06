package com.hzchum.scim.scm.core.biz;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.payment.OrderClassEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.enums.visa.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierSettlement;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectPaymentAllDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.SupplierLedgerParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.contract.core.api.utils.ProjectFinanceUtils;
import com.hzchum.scim.scm.core.api.biz.PurchaseOrderBiz;
import com.hzchum.scim.scm.core.api.enums.LogisticsPayerEnum;
import com.hzchum.scim.scm.core.api.enums.SubSupplyTypeEnum;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.BriefIdAndNameDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierInvoiceDetailDto;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierPaymentDetailDto;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderQueryDtoParamV2;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.scm.core.mapper.PurchaseOrderDetailMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Reject;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.RejectService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderBizImpl implements PurchaseOrderBiz {
   private static final Logger log = LoggerFactory.getLogger(PurchaseOrderBizImpl.class);
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private UserService userService;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private SubcontractOrderService subcontractOrderService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private InboundService inboundService;
   @Resource
   private RejectService rejectService;
   @Resource
   private InboundManufacturedService inboundManufacturedService;
   @Resource
   private PurchaseOrderDetailMapper purchaseOrderDetailMapper;
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private SupplierInvoiceService supplierInvoiceService;
   @Resource
   private SupplierSettlementService supplierSettlementService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ProjectFinanceUtils projectFinanceUtils;

   @Override
   public PageVO<PurchaseOrderDTO> getProjectSupplierLedger(SupplierLedgerParam param, Integer pageNumber, Integer pageSize) {
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      if (param.getBranchCompanyId() != null) {
         BranchCompany branchCompany = this.branchCompanyService.getById(param.getBranchCompanyId());
         Preconditions.checkArgument(branchCompany != null, "当前单位不存在!请刷新后重试!!");
         param.setLevel(branchCompany.getLevel());
      } else if (boolTwoLevelUnit) {
         Preconditions.checkArgument(param.getLevel() != null, "单位等级未知!无法操作!");
      } else {
         param.setLevel(null);
      }

      PageHelper.startPage(pageNumber, pageSize);
      if (param.getPurchaseType() != null && param.getPurchaseType().equals(4)) {
         return new PageVO<>();
      } else if (param.getPurchaseType() != null && param.getPurchaseType().equals(8)) {
         return this.getSubOrderList(param, pageNumber, pageSize);
      } else {
         return param.getPurchaseType() != null && param.getPurchaseType().equals(16) ? new PageVO<>() : this.getPurchaseOrderList(param, pageNumber, pageSize);
      }
   }

   private PageVO<PurchaseOrderDTO> getPurchaseOrderList(SupplierLedgerParam param, Integer pageNumber, Integer pageSize) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .eq(PurchaseOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
               .apply(param.getProjectId() != null, "find_in_set({0}, project_ids)", param.getProjectId())
               .eq(param.getPurchaseType() != null, PurchaseOrder::getPurchaseType, param.getPurchaseType())
               .eq(param.getSupplierId() != null, PurchaseOrder::getSupplierId, param.getSupplierId())
               .apply(param.getYear() != null, "YEAR(create_time) = YEAR({0})", param.getYear())
               .like(StringUtils.isNotBlank(param.getSerialNumber()), PurchaseOrder::getSerialNumber, param.getSerialNumber())
               .eq(PurchaseOrder::getDataStatus, DataStatusEnum.SUCCEED.getType())
               .eq(param.getSettlementStatus() != null, PurchaseOrder::getSettlementStatus, param.getSettlementStatus())
               .eq(param.getBranchCompanyId() != null, PurchaseOrder::getBranchCompanyId, param.getBranchCompanyId())
               .eq(param.getLevel() != null, PurchaseOrder::getLevel, param.getLevel())
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (orderList.isEmpty()) {
         return new PageVO<>();
      }

      List<Long> orderIds = orderList.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
      Map<Long, BigDecimal> supplierPaymentMap = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getOrderId, orderIds)
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(SupplierPayment::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add))
         );
      Map<Long, BigDecimal> supplierInvoiceMap = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .in(SupplierInvoice::getOrderId, orderIds)
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               SupplierInvoice::getOrderId,
               Collectors.reducing(
                  BigDecimal.ZERO, s -> s.getActualInvoiceAmount() != null ? s.getActualInvoiceAmount() : s.getInvoiceAmount(), BigDecimal::add
               )
            )
         );
      Map<Long, BigDecimal> orderIdInboundAmountMap = this.inboundService
         .list(Wrappers.lambdaQuery(Inbound.class).eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).in(Inbound::getPurchaseId, orderIds))
         .stream()
         .filter(s -> s.getAmountNoFreight() != null)
         .collect(Collectors.groupingBy(Inbound::getPurchaseId, Collectors.reducing(BigDecimal.ZERO, Inbound::getAmountNoFreight, BigDecimal::add)));
      Map<Long, BigDecimal> orderIdInboundManufacturedAmountMap = this.inboundManufacturedService
         .list(
            Wrappers.lambdaQuery(InboundManufactured.class)
               .eq(InboundManufactured::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
               .in(InboundManufactured::getPurchaseId, orderIds)
         )
         .stream()
         .filter(s -> s.getAmount() != null)
         .collect(
            Collectors.groupingBy(InboundManufactured::getPurchaseId, Collectors.reducing(BigDecimal.ZERO, InboundManufactured::getAmount, BigDecimal::add))
         );
      Map<Long, BigDecimal> orderIdRejectAmountMap = this.rejectService
         .list(Wrappers.lambdaQuery(Reject.class).eq(Reject::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).in(Reject::getPurchaseOrderId, orderIds))
         .stream()
         .filter(s -> s.getAmountNoFreight() != null)
         .collect(Collectors.groupingBy(Reject::getPurchaseOrderId, Collectors.reducing(BigDecimal.ZERO, Reject::getAmountNoFreight, BigDecimal::add)));
      Map<Long, BigDecimal> orderIdAdjustAmountMap = this.purchaseOrderService.getOrderIdAdjustAmountMap(orderIds);
      Map<Long, List<PurchaseOrderDetail>> orderDetailMap = this.purchaseOrderDetailMapper
         .selectList(Wrappers.lambdaQuery(PurchaseOrderDetail.class).in(PurchaseOrderDetail::getPurchaseId, orderIds))
         .stream()
         .collect(Collectors.groupingBy(PurchaseOrderDetail::getPurchaseId));
      Map<Long, BigDecimal> orderIdReceiveAmountMap = new HashMap<>(32);
      orderDetailMap.forEach(
         (purchaseId, orderDetailList) -> {
            BigDecimal purchaseOrderAmount = orderDetailList.stream()
               .filter(orderDetail -> orderDetail.getUnitPrice() != null)
               .filter(orderDetail -> orderDetail.getActualReceivedMete() != null)
               .map(orderDetail -> orderDetail.getActualReceivedMete().multiply(orderDetail.getUnitPrice()).setScale(2, 4))
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            orderIdReceiveAmountMap.put(purchaseId, purchaseOrderAmount);
         }
      );
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      Map<Long, BriefIdAndNameDTO> supplierIdMap = this.supplierService
         .listByIds(orderList.stream().map(PurchaseOrder::getSupplierId).collect(Collectors.toSet()))
         .stream()
         .map(s -> BeanUtil.copy(s, BriefIdAndNameDTO.class))
         .collect(Collectors.toMap(BriefIdAndNameDTO::getId, Function.identity()));
      List<PurchaseOrderDTO> purchaseOrderDtoList = orderList.stream()
         .map(
            order -> {
               PurchaseOrderDTO orderDTO = BeanUtil.copy(order, PurchaseOrderDTO.class);
               BigDecimal adjustAmount = orderIdAdjustAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO);
               orderDTO.setInboundAmount(
                  orderIdInboundAmountMap.getOrDefault(orderDTO.getId(), BigDecimal.ZERO)
                     .subtract(orderIdRejectAmountMap.getOrDefault(orderDTO.getId(), BigDecimal.ZERO))
                     .add(adjustAmount)
                     .setScale(2, RoundingMode.HALF_UP)
               );
               BigDecimal inboundAmount1 = orderIdInboundAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO);
               BigDecimal inboundAmount2 = orderIdInboundManufacturedAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO);
               BigDecimal inboundAmount3 = orderIdReceiveAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO);
               BigDecimal inboundAmount = inboundAmount1.add(inboundAmount2)
                  .add(inboundAmount3)
                  .subtract(orderIdRejectAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO))
                  .add(adjustAmount)
                  .setScale(2, RoundingMode.HALF_UP);
               orderDTO.setInboundAmount(inboundAmount);
               orderDTO.setCumulativeInvoice(supplierInvoiceMap.getOrDefault(order.getId(), BigDecimal.ZERO));
               orderDTO.setCumulativePayment(supplierPaymentMap.getOrDefault(order.getId(), BigDecimal.ZERO));
               if (order.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())) {
                  orderDTO.setInvoiceRate(
                     order.getAmount().compareTo(BigDecimal.ZERO) != 0
                        ? supplierInvoiceMap.getOrDefault(order.getId(), BigDecimal.ZERO)
                           .multiply(BigDecimal.valueOf(100L))
                           .divide(order.getAmount(), 2, RoundingMode.HALF_UP)
                        : BigDecimal.ZERO
                  );
                  orderDTO.setPaymentRate(
                     order.getAmount().compareTo(BigDecimal.ZERO) != 0
                        ? supplierPaymentMap.getOrDefault(order.getId(), BigDecimal.ZERO)
                           .multiply(BigDecimal.valueOf(100L))
                           .divide(order.getAmount(), 2, RoundingMode.HALF_UP)
                        : BigDecimal.ZERO
                  );
               } else {
                  orderDTO.setInvoiceRate(
                     order.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0
                        ? supplierInvoiceMap.getOrDefault(order.getId(), BigDecimal.ZERO)
                           .multiply(BigDecimal.valueOf(100L))
                           .divide(order.getSettlementAmount(), 2, RoundingMode.HALF_UP)
                        : BigDecimal.ZERO
                  );
                  orderDTO.setPaymentRate(
                     order.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0
                        ? supplierPaymentMap.getOrDefault(order.getId(), BigDecimal.ZERO)
                           .multiply(BigDecimal.valueOf(100L))
                           .divide(order.getSettlementAmount(), 2, RoundingMode.HALF_UP)
                        : BigDecimal.ZERO
                  );
               }

               BranchCompany branchCompany = branchCompanyMap.get(order.getBranchCompanyId());
               orderDTO.setBranchCompany(
                  BriefIdAndNameDTO.builder().id(order.getBranchCompanyId()).name(branchCompany != null ? branchCompany.getName() : "/").build()
               );
               orderDTO.setSupplier(supplierIdMap.get(order.getSupplierId()));
               List<ProjectInfo> projectInfos = this.projectService.listByIds(order.getProjectIds());
               orderDTO.setProjects(projectInfos);
               return orderDTO;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(page, purchaseOrderDtoList);
   }

   private PageVO<PurchaseOrderDTO> getSubOrderList(SupplierLedgerParam param, Integer pageNumber, Integer pageSize) {
      SubcontractOrderQueryDtoParamV2 paramV2 = BeanUtil.copy(param, SubcontractOrderQueryDtoParamV2.class);
      paramV2.setProjectAttribute(Collections.singletonList(ProjectAttributeEnum.SELF_SUPPORT.getType()));
      paramV2.setAuditTypeEnum(AuditStatusEnum.SUCCEED.getType());
      paramV2.setBoolSettlementStatus(param.getSettlementStatus() != null ? param.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) : null);
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<SubcontractOrder> subcontractOrderList = this.subcontractOrderService.getPageList(paramV2);
      if (subcontractOrderList.isEmpty()) {
         return new PageVO<>();
      }

      List<ProjectInfo> projectInfos = this.projectService
         .listInfoByIdList(subcontractOrderList.stream().map(SubcontractOrder::getProjectId).collect(Collectors.toSet()));
      Map<Long, ProjectInfo> projectInfoMap = projectInfos.stream().collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
      List<Long> orderIds = subcontractOrderList.stream().map(SubcontractOrder::getId).collect(Collectors.toList());
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      Map<Long, BigDecimal> supplierPaymentMap = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .in(SupplierPayment::getOrderId, orderIds)
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
         )
         .stream()
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()))
         .collect(
            Collectors.groupingBy(
               SupplierPayment::getOrderId,
               Collectors.mapping(SupplierPayment::getActuallyPaymentAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
      Map<Long, BigDecimal> supplierInvoiceMap = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .in(SupplierInvoice::getOrderId, orderIds)
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
         )
         .stream()
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()))
         .collect(
            Collectors.groupingBy(
               SupplierInvoice::getOrderId, Collectors.mapping(SupplierInvoice::getActualInvoiceAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
      List<PurchaseOrderDTO> subOrderDTOList = subcontractOrderList.stream()
         .map(
            s -> {
               SubSupplyTypeEnum subSupplyTypeEnum = SubSupplyTypeEnum.getByType(s.getSubcontractClassId());
               BranchCompany branchCompany = branchCompanyMap.get(s.getBranchCompanyId());
               PurchaseOrderDTO dto = PurchaseOrderDTO.builder()
                  .id(s.getId())
                  .purchaseType(8)
                  .createTime(s.getCreateTime())
                  .branchCompany(BriefIdAndNameDTO.builder().id(s.getBranchCompanyId()).name(branchCompany != null ? branchCompany.getName() : "/").build())
                  .supplier(BriefIdAndNameDTO.builder().id(s.getSupplierId()).name(s.getSupplierName()).build())
                  .serialNumber(s.getSerialNumber())
                  .projects(Collections.singletonList(projectInfoMap.get(s.getProjectId())))
                  .basicClass(s.getSubcontractClassId().intValue())
                  .basicClassName(subSupplyTypeEnum != null ? subSupplyTypeEnum.getName() : "/")
                  .amount(s.getAmount())
                  .settlementStatus(s.getBoolSettlementStatus() ? SettlementStatusEnum.SETTLED.getType() : SettlementStatusEnum.UN_SETTLED.getType())
                  .settlementAmount(s.getSettlementAmount())
                  .cumulativePayment(supplierPaymentMap.getOrDefault(s.getId(), BigDecimal.ZERO))
                  .cumulativeInvoice(supplierInvoiceMap.getOrDefault(s.getId(), BigDecimal.ZERO))
                  .build();
               if (!s.getBoolSettlementStatus()) {
                  dto.setPaymentRate(dto.getCumulativePayment().multiply(BigDecimal.valueOf(100L)).divide(dto.getAmount(), 4, RoundingMode.DOWN));
                  dto.setInvoiceRate(dto.getCumulativeInvoice().multiply(BigDecimal.valueOf(100L)).divide(dto.getAmount(), 4, RoundingMode.DOWN));
               } else {
                  dto.setPaymentRate(dto.getCumulativePayment().multiply(BigDecimal.valueOf(100L)).divide(dto.getSettlementAmount(), 4, RoundingMode.DOWN));
                  dto.setInvoiceRate(dto.getCumulativeInvoice().multiply(BigDecimal.valueOf(100L)).divide(dto.getSettlementAmount(), 4, RoundingMode.DOWN));
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(page, subOrderDTOList);
   }

   @Override
   public PageVO<SupplierPaymentDetailDto> getPaymentDetail(Long orderId, Integer pageNumber, Integer pageSize) {
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(orderId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(purchaseOrder), "采购订单不存在");
      PageHelper.startPage(pageNumber, pageSize);
      List<SupplierPayment> paymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, orderId)
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .orderByDesc(SupplierPayment::getPaymentDate)
         );
      if (CollectionUtils.isEmpty(paymentList)) {
         return new PageVO<>();
      }

      List<SupplierPaymentDetailDto> dto = new ArrayList<>();
      Map<Long, User> userMap = this.userService
         .listByIds(paymentList.stream().map(SupplierPayment::getApplyUserId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(User::getId, Function.identity()));
      BranchCompany branchCompany = this.branchCompanyService.getById(purchaseOrder.getBranchCompanyId());
      Supplier supplier = this.supplierService.getById(purchaseOrder.getSupplierId());
      paymentList.forEach(
         payment -> dto.add(
            SupplierPaymentDetailDto.builder()
               .paymentDate(payment.getPaymentDate().atStartOfDay())
               .paymentType(payment.getPaymentReasonId() != null ? Integer.valueOf(payment.getPaymentReasonId()) : 0)
               .paymentAmount(payment.getActuallyPaymentAmount())
               .contractSignBody(NameInfo.builder().id(purchaseOrder.getBranchCompanyId()).name(branchCompany.getName()).build())
               .paymentBank(payment.getPaymentBank())
               .supplierId(purchaseOrder.getSupplierId())
               .supplierName(supplier.getName())
               .paymentPerson(NameInfo.builder().id(payment.getApplyUserId()).name(userMap.get(payment.getApplyUserId()).getName()).build())
               .auditUser(NameInfo.builder().id(payment.getAuditUserId()).name(payment.getAuditUserName()).build())
               .attachmentList(this.attachmentService.listByIds(payment.getAttachmentIds()))
               .attachments(this.attachmentService.listByIds(payment.getAttachmentIds()))
               .build()
         )
      );
      return new PageVO<>(PageUtils.getPageInfo(dto, paymentList));
   }

   @Override
   public PrintVO<List<SupplierPaymentDetailDto>> getPaymentDetailDownload(Long orderId) {
      PrintVO<List<SupplierPaymentDetailDto>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(orderId);
      Preconditions.checkArgument(purchaseOrder != null, "采购订单不存在!");
      this.setPrintHeader(header, purchaseOrder);
      List<SupplierPayment> paymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, orderId)
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .orderByDesc(SupplierPayment::getPaymentDate)
         );
      List<SupplierPaymentDetailDto> detailDtoList = Collections.emptyList();
      if (CollectionUtils.isNotEmpty(paymentList)) {
         Map<Long, User> userMap = this.userService
            .listByIds(paymentList.stream().map(SupplierPayment::getApplyUserId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(User::getId, Function.identity()));
         BranchCompany branchCompany = this.branchCompanyService.getById(purchaseOrder.getBranchCompanyId());
         Supplier supplier = this.supplierService.getById(purchaseOrder.getSupplierId());
         detailDtoList = paymentList.stream()
            .map(
               payment -> {
                  User user = userMap.get(payment.getApplyUserId());
                  return SupplierPaymentDetailDto.builder()
                     .paymentDate(payment.getPaymentDate().atStartOfDay())
                     .paymentType(Integer.valueOf(payment.getPaymentReasonId()))
                     .paymentAmount(payment.getActuallyPaymentAmount())
                     .contractSignBody(
                        NameInfo.builder().id(purchaseOrder.getBranchCompanyId()).name(branchCompany != null ? branchCompany.getName() : "").build()
                     )
                     .supplierId(purchaseOrder.getSupplierId())
                     .supplierName(supplier.getName())
                     .paymentBank(payment.getPaymentBank())
                     .paymentPerson(NameInfo.builder().id(payment.getApplyUserId()).name(user != null ? user.getName() : "").build())
                     .auditUser(NameInfo.builder().id(payment.getAuditUserId()).name(payment.getAuditUserName()).build())
                     .build();
               }
            )
            .collect(Collectors.toList());
      }

      printVO.setHeader(header);
      printVO.setTable(detailDtoList);
      return printVO;
   }

   private void setPrintHeader(Map<String, Object> header, PurchaseOrder purchaseOrder) {
      List<ProjectInfo> projectInfoList = this.projectService.listByIds(purchaseOrder.getProjectIds());
      header.put("serialNumber", purchaseOrder.getSerialNumber());
      header.put("applicantName", purchaseOrder.getApplicantName());
      header.put("createTime", purchaseOrder.getCreateTime());
      header.put("branchCompany", this.branchCompanyService.getNameById(purchaseOrder.getBranchCompanyId()));
      header.put("supplier", this.supplierService.getNameById(purchaseOrder.getSupplierId()));
      header.put("project", projectInfoList.stream().map(s -> s.getSerialNumber() + "_" + s.getShortName()).collect(Collectors.joining("/")));
      header.put("amount", purchaseOrder.getAmount());
      header.put("mete", purchaseOrder.getMete());
      header.put("meteUnit", purchaseOrder.getMeteUnit());
      header.put(
         "settlementStatus",
         purchaseOrder.getSettlementStatus() != null && purchaseOrder.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) ? "已结算" : "未结算"
      );
      header.put("settlementAmount", purchaseOrder.getSettlementAmount());
      header.put(
         "inboundAmount",
         this.inboundService
            .getActualInboundAmount(purchaseOrder.getId(), purchaseOrder.getOrderPlace(), purchaseOrder.getPurchaseType())
            .setScale(2, RoundingMode.HALF_UP)
      );
      header.put("basicClass", BasicClassEnum.getNameStr(purchaseOrder.getBasicClass()).replace("、", "|"));
      BigDecimal freight1 = this.inboundService
         .list(
            Wrappers.lambdaQuery(Inbound.class)
               .eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
               .eq(Inbound::getPurchaseId, purchaseOrder.getId())
         )
         .stream()
         .map(Inbound::getFreight)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal freight2 = this.inboundManufacturedService
         .list(
            Wrappers.lambdaQuery(InboundManufactured.class)
               .eq(InboundManufactured::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
               .eq(InboundManufactured::getPurchaseId, purchaseOrder.getId())
         )
         .stream()
         .map(InboundManufactured::getFreight)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put(
         "freight",
         LogisticsPayerEnum.DEMAND.getType().equals(purchaseOrder.getLogisticsPayerType()) ? freight1.add(freight2).setScale(2, RoundingMode.HALF_UP) : null
      );
      String logisticsPayerType = LogisticsPayerEnum.getNameByType(purchaseOrder.getLogisticsPayerType());
      header.put("logisticsPayerType", logisticsPayerType != null ? logisticsPayerType : "/");
      BigDecimal paymentAmount = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(SupplierPayment::getOrderId, purchaseOrder.getId())
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
         )
         .stream()
         .map(SupplierPayment::getActuallyPaymentAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal invoiceAmount = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(SupplierInvoice::getOrderId, purchaseOrder.getId())
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
         )
         .stream()
         .map(SupplierInvoice::getActualInvoiceAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("cumulativePayment", paymentAmount);
      BigDecimal paymentRate = purchaseOrder.getSettlementStatus() != null
            && purchaseOrder.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
         ? paymentAmount.multiply(BigDecimal.valueOf(100L)).divide(purchaseOrder.getSettlementAmount(), 2, RoundingMode.HALF_UP)
         : (
            purchaseOrder.getAmount().compareTo(BigDecimal.ZERO) > 0
               ? paymentAmount.multiply(BigDecimal.valueOf(100L)).divide(purchaseOrder.getAmount(), 2, RoundingMode.HALF_UP)
               : BigDecimal.ZERO
         );
      header.put("paymentRate", paymentRate);
      header.put("cumulativeInvoice", invoiceAmount);
      BigDecimal invoiceRate = purchaseOrder.getSettlementStatus() != null
            && purchaseOrder.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
         ? invoiceAmount.multiply(BigDecimal.valueOf(100L)).divide(purchaseOrder.getSettlementAmount(), 2, RoundingMode.HALF_UP)
         : (
            purchaseOrder.getAmount().compareTo(BigDecimal.ZERO) > 0
               ? invoiceAmount.multiply(BigDecimal.valueOf(100L)).divide(purchaseOrder.getAmount(), 2, RoundingMode.HALF_UP)
               : BigDecimal.ZERO
         );
      header.put("invoiceRate", invoiceRate);
   }

   @Override
   public PageVO<SupplierInvoiceDetailDto> getInvoiceDetail(Long orderId, Integer pageNumber, Integer pageSize) {
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(orderId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(purchaseOrder), "采购订单不存在");
      PageHelper.startPage(pageNumber, pageSize);
      List<SupplierInvoice> invoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, orderId)
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .orderByDesc(SupplierInvoice::getReceiveInvoiceDate)
         );
      if (CollectionUtils.isEmpty(invoiceList)) {
         return new PageVO<>();
      }

      List<SupplierInvoiceDetailDto> dto = new ArrayList<>();
      BranchCompany branchCompany = this.branchCompanyService.getById(purchaseOrder.getBranchCompanyId());
      Supplier supplier = this.supplierService.getById(purchaseOrder.getSupplierId());
      Map<Long, User> userMap = this.userService
         .listByIds(invoiceList.stream().map(SupplierInvoice::getApplyUserId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(User::getId, Function.identity()));
      invoiceList.forEach(
         invoice -> {
            User user = userMap.get(invoice.getApplyUserId());
            dto.add(
               SupplierInvoiceDetailDto.builder()
                  .invoiceAmount(invoice.getActualInvoiceAmount())
                  .taxRate(invoice.getTaxRate())
                  .invoiceDate(invoice.getReceiveInvoiceDate().atStartOfDay())
                  .invoiceType(invoice.getInvoiceType())
                  .invoiceNumber(invoice.getInvoiceSerialNumber())
                  .invoiceSignBody(NameInfo.builder().id(purchaseOrder.getBranchCompanyId()).name(branchCompany.getName()).build())
                  .supplierId(purchaseOrder.getSupplierId())
                  .supplierName(supplier.getName())
                  .paymentPerson(NameInfo.builder().id(invoice.getApplyUserId()).name(user != null ? user.getName() : "").build())
                  .auditUser(NameInfo.builder().id(invoice.getAuditUserId()).name(invoice.getAuditUserName()).build())
                  .attachmentList(this.attachmentService.listByIds(invoice.getAttachmentIds()))
                  .attachments(this.attachmentService.listByIds(invoice.getAttachmentIds()))
                  .build()
            );
         }
      );
      return new PageVO<>(PageUtils.getPageInfo(dto, invoiceList));
   }

   @Override
   public List<SupplierSettlementDTO> listSettleDetail(Long orderId, Boolean boolPreSettlement) {
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(orderId);
      Preconditions.checkArgument(purchaseOrder != null, "订单不存在!");
      BranchCompany branchCompany = this.branchCompanyService.getById(purchaseOrder.getBranchCompanyId());
      Supplier supplier = this.supplierService.getById(purchaseOrder.getSupplierId());
      List<ProjectInfo> projectInfos = this.projectService.listByIds(purchaseOrder.getProjectIds());
      List<SupplierSettlement> settlementList = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
               .eq(SupplierSettlement::getOrderId, orderId)
               .eq(boolPreSettlement != null, SupplierSettlement::getBoolPreSettlement, boolPreSettlement)
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      return settlementList.stream().map(s -> {
         SupplierSettlementDTO settlementDTO = BeanUtil.copy(s, SupplierSettlementDTO.class);
         settlementDTO.setOrderSerialNumber(purchaseOrder.getSerialNumber());
         settlementDTO.setSupplierId(purchaseOrder.getSupplierId());
         settlementDTO.setSupplierName(supplier != null ? supplier.getName() : "");
         settlementDTO.setBranchCompanyId(purchaseOrder.getBranchCompanyId());
         settlementDTO.setBranchCompanyName(branchCompany != null ? branchCompany.getName() : "");
         settlementDTO.setProjectName(StringUtils.join(projectInfos.stream().map(ProjectInfo::getShortName).collect(Collectors.toList()), "/"));
         settlementDTO.setAttachments(this.attachmentService.listByIds(s.getAttachmentIds()));
         return settlementDTO;
      }).collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<SupplierSettlementDTO>> printListSettleDetail(Long orderId, Boolean boolPreSettlement) {
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(orderId);
      Preconditions.checkArgument(purchaseOrder != null, "订单不存在!");
      List<SupplierSettlementDTO> listSettleDetail = this.listSettleDetail(orderId, boolPreSettlement);
      PrintVO<List<SupplierSettlementDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      this.setPrintHeader(header, purchaseOrder);
      printVO.setHeader(header);
      printVO.setTable(listSettleDetail);
      return printVO;
   }

   @Override
   public PrintVO<List<SupplierInvoiceDetailDto>> getInvoiceDetailDownload(Long orderId) {
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(orderId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(purchaseOrder), "采购订单不存在");
      PrintVO<List<SupplierInvoiceDetailDto>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      this.setPrintHeader(header, purchaseOrder);
      List<SupplierInvoice> invoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, orderId)
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .orderByDesc(SupplierInvoice::getReceiveInvoiceDate)
         );
      List<SupplierInvoiceDetailDto> detailDtoList = Collections.emptyList();
      if (CollectionUtils.isNotEmpty(invoiceList)) {
         BranchCompany branchCompany = this.branchCompanyService.getById(purchaseOrder.getBranchCompanyId());
         Supplier supplier = this.supplierService.getById(purchaseOrder.getSupplierId());
         Map<Long, User> userMap = this.userService
            .listByIds(invoiceList.stream().map(SupplierInvoice::getApplyUserId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(User::getId, Function.identity()));
         detailDtoList = invoiceList.stream()
            .map(
               invoice -> {
                  User user = userMap.get(invoice.getApplyUserId());
                  return SupplierInvoiceDetailDto.builder()
                     .invoiceAmount(invoice.getActualInvoiceAmount())
                     .taxRate(invoice.getTaxRate())
                     .invoiceDate(invoice.getReceiveInvoiceDate().atStartOfDay())
                     .invoiceType(invoice.getInvoiceType())
                     .invoiceNumber(invoice.getInvoiceSerialNumber())
                     .invoiceSignBody(NameInfo.builder().id(invoice.getBranchCompanyId()).name(branchCompany.getName()).build())
                     .supplierId(purchaseOrder.getSupplierId())
                     .supplierName(supplier.getName())
                     .paymentPerson(NameInfo.builder().id(invoice.getApplyUserId()).name(user != null ? user.getName() : "").build())
                     .auditUser(NameInfo.builder().id(invoice.getAuditUserId()).name(invoice.getAuditUserName()).build())
                     .build();
               }
            )
            .collect(Collectors.toList());
      }

      printVO.setHeader(header);
      printVO.setTable(detailDtoList);
      return printVO;
   }

   @Override
   public List<String> getOrderNumber(Integer level, Integer purchaseType, Long branchCompanyId) {
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      if (branchCompanyId != null) {
         BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
         Preconditions.checkArgument(branchCompany != null, "当前单位不存在!!请刷新后重试!!");
         level = branchCompany.getLevel();
      } else if (boolTwoLevelUnit) {
         Preconditions.checkArgument(level != null, "单位等级未知!无法操作!");
      } else {
         level = null;
      }

      if (purchaseType != null && purchaseType.equals(4)) {
         return Collections.emptyList();
      }

      if (purchaseType != null && purchaseType.equals(8)) {
         List<SubcontractOrder> subcontractOrderList = this.subcontractOrderService
            .list(
               Wrappers.lambdaQuery(SubcontractOrder.class)
                  .eq(SubcontractOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
                  .eq(branchCompanyId != null, SubcontractOrder::getBranchCompanyId, branchCompanyId)
                  .apply(level != null, "level & {0} > 0 ", level)
                  .orderByDesc(SubcontractOrder::getId)
            );
         return subcontractOrderList.stream().map(SubcontractOrder::getSerialNumber).collect(Collectors.toList());
      }

      if (purchaseType != null && purchaseType.equals(16)) {
         return Collections.emptyList();
      }

      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .eq(PurchaseOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
               .eq(branchCompanyId != null, PurchaseOrder::getBranchCompanyId, branchCompanyId)
               .eq(level != null, PurchaseOrder::getLevel, level)
               .eq(purchaseType != null, PurchaseOrder::getPurchaseType, purchaseType)
               .eq(PurchaseOrder::getDataStatus, DataStatusEnum.SUCCEED.getType())
               .eq(PurchaseOrder::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
               .orderByDesc(PurchaseOrder::getId)
         );
      return orderList.stream().map(PurchaseOrder::getSerialNumber).distinct().collect(Collectors.toList());
   }

   @Override
   public PageVO<ProjectPaymentAllDTO> projectPaymentAll(
      Long projectId, Long supplierId, String number, LocalDateTime startTime, LocalDateTime endTime, Integer pageNumber, Integer pageSize
   ) {
      List<ProjectPaymentAllDTO> projectPaymentAllDTOS = this.getProjectPaymentAllDTOS(projectId, supplierId, number, startTime, endTime);
      PageVO<ProjectPaymentAllDTO> pageVO = new PageVO<>(PageUtils.getPage(projectPaymentAllDTOS, pageNumber, pageSize));
      pageVO.setTotalElements(projectPaymentAllDTOS.size());
      return pageVO;
   }

   @NotNull
   private List<ProjectPaymentAllDTO> getProjectPaymentAllDTOS(Long projectId, Long supplierId, String number, LocalDateTime startTime, LocalDateTime endTime) {
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .ne(PurchaseOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
               .eq(ObjectUtils.isNotEmpty(supplierId), PurchaseOrder::getSupplierId, supplierId)
               .like(ObjectUtils.isNotEmpty(number), PurchaseOrder::getSerialNumber, number)
               .apply(
                  ObjectUtils.isNotEmpty(startTime) && ObjectUtils.isNotEmpty(endTime),
                  "date_format(create_time,'%Y-%m-%d') between {0} and {1}",
                  startTime,
                  endTime
               )
               .isNotNull(PurchaseOrder::getProjectIds)
         )
         .stream()
         .filter(a -> Arrays.asList(a.getProjectIds()).contains(projectId.toString()))
         .collect(Collectors.toList());
      List<SubcontractOrder> subcontractOrders = this.subcontractOrderService
         .list(
            Wrappers.lambdaQuery(SubcontractOrder.class)
               .eq(SubcontractOrder::getProjectId, projectId)
               .eq(ObjectUtils.isNotEmpty(supplierId), SubcontractOrder::getSupplierId, supplierId)
               .like(ObjectUtils.isNotEmpty(number), SubcontractOrder::getSerialNumber, number)
         );
      List<ProjectPaymentAllDTO> projectPaymentAllDTOS = new ArrayList<>();
      Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      if (CollectionUtils.isNotEmpty(orderList)) {
         List<SupplierPayment> paymentList = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .in(SupplierPayment::getOrderId, orderList.stream().map(PurchaseOrder::getId).collect(Collectors.toList()))
                  .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            );
         Map<Long, PurchaseOrder> orderMap = orderList.stream().collect(Collectors.toMap(PurchaseOrder::getId, Function.identity()));

         for (SupplierPayment payment : paymentList) {
            projectPaymentAllDTOS.add(
               ProjectPaymentAllDTO.builder()
                  .id(payment.getId())
                  .paymentTime(payment.getAuditTime())
                  .supplier(
                     SupplierInfo.builder().supplierId(payment.getSupplierId()).supplierName(supplierMap.get(payment.getSupplierId()).getShortName()).build()
                  )
                  .contractNumber(orderMap.get(payment.getOrderId()).getSerialNumber())
                  .voucherNumber(payment.getApprovalSerialNumber())
                  .paymentAmount(payment.getActuallyPaymentAmount())
                  .approvalNumber(payment.getApprovalSerialNumber())
                  .user(NameInfo.builder().id(payment.getApplyUserId()).name(userMap.get(payment.getApplyUserId()).getName()).build())
                  .build()
            );
         }
      }

      if (CollectionUtils.isNotEmpty(subcontractOrders)) {
         List<SupplierPayment> paymentList = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .in(SupplierPayment::getOrderId, subcontractOrders.stream().map(SubcontractOrder::getId).collect(Collectors.toList()))
                  .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                  .apply(
                     ObjectUtils.isNotEmpty(startTime) && ObjectUtils.isNotEmpty(endTime),
                     "date_format(audit_time,'%Y-%m-%d') between {0} and {1}",
                     startTime,
                     endTime
                  )
            );
         Map<Long, SubcontractOrder> subcontractOrderMap = subcontractOrders.stream().collect(Collectors.toMap(SubcontractOrder::getId, Function.identity()));

         for (SupplierPayment payment : paymentList) {
            projectPaymentAllDTOS.add(
               ProjectPaymentAllDTO.builder()
                  .id(payment.getId())
                  .paymentTime(payment.getAuditTime())
                  .supplier(
                     SupplierInfo.builder().supplierId(payment.getSupplierId()).supplierName(supplierMap.get(payment.getSupplierId()).getShortName()).build()
                  )
                  .contractNumber(subcontractOrderMap.get(payment.getOrderId()).getSerialNumber())
                  .voucherNumber(payment.getApprovalSerialNumber())
                  .paymentAmount(payment.getActuallyPaymentAmount())
                  .approvalNumber(payment.getApprovalSerialNumber())
                  .user(NameInfo.builder().id(payment.getApplyUserId()).name(userMap.get(payment.getApplyUserId()).getName()).build())
                  .build()
            );
         }
      }

      projectPaymentAllDTOS.sort(Comparator.comparing(ProjectPaymentAllDTO::getPaymentTime).reversed());
      return projectPaymentAllDTOS;
   }

   @Override
   public PrintVO orderPaymentDownload(Long projectId, Long supplierId, String number, LocalDateTime startTime, LocalDateTime endTime) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      List<ProjectPaymentAllDTO> projectPaymentAllDTOS = this.getProjectPaymentAllDTOS(projectId, supplierId, number, startTime, endTime);
      if (CollectionUtils.isNotEmpty(projectPaymentAllDTOS)) {
         printVO.setTable(projectPaymentAllDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      }

      printVO.setHeader(header);
      return printVO;
   }

   private List<PurchaseOrderDTO> getSubcontractOrderList(
      Long projectId, Long supplierId, String serialNumber, Integer settlementStatus, Integer year, Integer level
   ) {
      List<Long> projectIds = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .eq(ObjectUtils.isNotEmpty(projectId), ContractProject::getId, projectId)
               .apply("level & {0} > 0", level)
               .eq(ContractProject::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
         )
         .stream()
         .map(ContractProject::getId)
         .collect(Collectors.toList());
      List<SubcontractOrder> list = this.subcontractOrderService
         .list(
            Wrappers.lambdaQuery(SubcontractOrder.class)
               .eq(ObjectUtils.isNotEmpty(projectId), SubcontractOrder::getProjectId, projectId)
               .eq(ObjectUtils.isNotEmpty(supplierId), SubcontractOrder::getSupplierId, supplierId)
               .eq(ObjectUtils.isNotEmpty(serialNumber), SubcontractOrder::getSerialNumber, serialNumber)
               .apply(ObjectUtils.isNotEmpty(year), "date_format(create_time, '%Y') = {0}", year)
               .in(ObjectUtils.isNotEmpty(projectIds), SubcontractOrder::getProjectId, projectIds)
         );
      if (CollectionUtils.isEmpty(list)) {
         return new ArrayList<>();
      }

      Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      Map<Long, ContractProject> projectMap = this.projectService.list().stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      Map<Long, BigDecimal> paymentAmountMap = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .eq(SupplierPayment::getOrderId, list.stream().map(SubcontractOrder::getId).collect(Collectors.toList()))
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(SupplierPayment::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add))
         );
      Map<Long, BigDecimal> invoiceAmountMap = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .in(SupplierInvoice::getOrderId, list.stream().map(SubcontractOrder::getId).collect(Collectors.toList()))
               .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(SupplierInvoice::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierInvoice::getActualInvoiceAmount, BigDecimal::add))
         );
      return list.stream()
         .map(
            a -> {
               List<ProjectInfo> projects = new ArrayList<>();
               projects.add(
                  ProjectInfo.builder()
                     .id(a.getProjectId())
                     .shortName(projectMap.get(a.getProjectId()).getShortName())
                     .name(projectMap.get(a.getProjectId()).getName())
                     .serialNumber(projectMap.get(a.getProjectId()).getSerialNumber())
                     .build()
               );
               return PurchaseOrderDTO.builder()
                  .id(a.getId())
                  .settlementStatus(a.getBoolSettlementStatus() ? SettlementStatusEnum.SETTLED.getType() : SettlementStatusEnum.UN_SETTLED.getType())
                  .createTime(a.getCreateTime())
                  .serialNumber(a.getSerialNumber())
                  .projects(projects)
                  .projectAttribute(projectMap.get(a.getProjectId()).getProjectAttribute())
                  .branchCompany(
                     BriefIdAndNameDTO.builder()
                        .id(a.getBranchCompanyId())
                        .name(branchCompanyMap.get(a.getBranchCompanyId()).getName())
                        .shortName(branchCompanyMap.get(a.getBranchCompanyId()).getShortName())
                        .build()
                  )
                  .settlementAmount(a.getBoolSettlementStatus() ? a.getSettlementAmount() : null)
                  .cumulativePayment(paymentAmountMap.get(a.getId()))
                  .cumulativeInvoice(invoiceAmountMap.get(a.getId()))
                  .paymentRate(
                     a.getBoolSettlementStatus()
                        ? a.getSettlementAmount().divide(paymentAmountMap.get(a.getId()), 4, 4)
                        : (
                           ObjectUtils.isNotEmpty(paymentAmountMap.get(a.getId()))
                              ? a.getAmount().divide(paymentAmountMap.get(a.getId()), 4, 4)
                              : BigDecimal.ZERO
                        )
                  )
                  .invoiceRate(
                     a.getBoolSettlementStatus()
                        ? a.getSettlementAmount().divide(invoiceAmountMap.get(a.getId()), 4, 4)
                        : (
                           ObjectUtils.isNotEmpty(invoiceAmountMap.get(a.getId()))
                              ? a.getAmount().divide(invoiceAmountMap.get(a.getId()), 4, 4)
                              : BigDecimal.ZERO
                        )
                  )
                  .build();
            }
         )
         .collect(Collectors.toList());
   }

   @NotNull
   private List<PurchaseOrderDTO> getPurchaseOrderDTOPageVO(
      Long projectId, Long supplierId, String serialNumber, Integer settlementStatus, Integer purchaseType, Integer year, Integer level
   ) {
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .eq(ObjectUtils.isNotEmpty(purchaseType), PurchaseOrder::getPurchaseType, purchaseType)
               .eq(ObjectUtils.isNotEmpty(supplierId), PurchaseOrder::getSupplierId, supplierId)
               .apply(ObjectUtils.isNotEmpty(year), "date_format(create_time, '%Y') = {0}", year)
               .eq(ObjectUtils.isNotEmpty(serialNumber), PurchaseOrder::getSerialNumber, serialNumber)
               .eq(PurchaseOrder::getDataStatus, DataStatusEnum.SUCCEED.getType())
               .orderByDesc(PurchaseOrder::getSigningTime)
         );
      List<PurchaseOrder> purchaseOrders = orderList.stream().filter(a -> ObjectUtils.isEmpty(a.getProjectIds())).collect(Collectors.toList());
      orderList = orderList.stream().filter(a -> ObjectUtils.isNotEmpty(a.getProjectIds())).collect(Collectors.toList());
      orderList.forEach(
         purchaseOrder -> purchaseOrder.setSettlementStatus(
            ObjectUtils.isNotEmpty(purchaseOrder.getSettlementStatus()) ? purchaseOrder.getSettlementStatus() : SettlementStatusEnum.UN_SETTLED.getType()
         )
      );
      List<Long> branchCompanyIds = this.branchCompanyService
         .list(Wrappers.lambdaQuery(BranchCompany.class).eq(BranchCompany::getLevel, level))
         .stream()
         .map(BranchCompany::getId)
         .collect(Collectors.toList());
      orderList = orderList.stream().filter(a -> branchCompanyIds.contains(a.getBranchCompanyId())).collect(Collectors.toList());
      purchaseOrders = purchaseOrders.stream().filter(a -> branchCompanyIds.contains(a.getBranchCompanyId())).collect(Collectors.toList());
      if (ObjectUtils.isNotEmpty(settlementStatus)) {
         orderList = orderList.stream().filter(a -> a.getSettlementStatus().equals(settlementStatus)).collect(Collectors.toList());
      }

      if (ObjectUtils.isNotEmpty(projectId)) {
         orderList = orderList.stream().filter(a -> Arrays.asList(a.getProjectIds().split(",")).contains(projectId.toString())).collect(Collectors.toList());
      }

      List<ContractProject> projectList = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .eq(ContractProject::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
               .apply("level & {0} > 0", level)
         );
      List<String> longList = projectList.stream().map(ContractProject::getId).map(String::valueOf).collect(Collectors.toList());
      orderList = orderList.stream().filter(a -> Arrays.stream(a.getProjectIds().split(",")).anyMatch(longList::contains)).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(orderList)) {
         return new ArrayList<>();
      }

      List<Long> orderIds = orderList.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
      Map<Long, BigDecimal> supplierPaymentMap = new HashMap<>();
      Map<Long, BigDecimal> supplierInvoiceMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(orderIds)) {
         List<SupplierPayment> paymentList = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .in(SupplierPayment::getOrderId, orderIds)
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                  .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())
            );
         supplierPaymentMap = paymentList.stream()
            .filter(ObjectUtils::isNotEmpty)
            .filter(a -> ObjectUtils.isNotEmpty(a.getActuallyPaymentAmount()))
            .collect(
               Collectors.groupingBy(
                  SupplierPayment::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add)
               )
            );
         List<SupplierInvoice> invoiceList = this.supplierInvoiceService
            .list(
               Wrappers.lambdaQuery(SupplierInvoice.class)
                  .in(SupplierInvoice::getOrderId, orderIds)
                  .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())
                  .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            );
         supplierInvoiceMap = invoiceList.stream()
            .filter(ObjectUtils::isNotEmpty)
            .filter(a -> ObjectUtils.isNotEmpty(a.getActualInvoiceAmount()))
            .collect(
               Collectors.groupingBy(
                  SupplierInvoice::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierInvoice::getActualInvoiceAmount, BigDecimal::add)
               )
            );
      }

      Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      Map<Long, ContractProject> projectMap = this.projectService.list().stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      List<PurchaseOrderDTO> dto = new ArrayList<>();

      for (PurchaseOrder order : orderList) {
         PurchaseOrderDTO copy = BeanUtil.copy(order, PurchaseOrderDTO.class);
         if (ObjectUtils.isNotEmpty(supplierInvoiceMap.get(order.getId()))) {
            copy.setCumulativeInvoice(supplierInvoiceMap.get(order.getId()));
            copy.setInvoiceRate(supplierInvoiceMap.get(order.getId()).divide(copy.getAmount(), 4, RoundingMode.DOWN).multiply(BigDecimal.valueOf(100L)));
         }

         if (ObjectUtils.isNotEmpty(supplierPaymentMap.get(order.getId()))) {
            copy.setCumulativePayment(supplierPaymentMap.get(order.getId()));
            copy.setPaymentRate(supplierPaymentMap.get(order.getId()).divide(copy.getAmount(), 4, RoundingMode.DOWN).multiply(BigDecimal.valueOf(100L)));
         }

         if (ObjectUtils.isNotEmpty(order.getProjectIds())) {
            List<Long> projectIds = Arrays.stream(order.getProjectIds().split(",")).map(Long::valueOf).collect(Collectors.toList());
            List<ProjectInfo> projects = new ArrayList<>();

            for (Long id : projectIds) {
               projects.add(
                  ProjectInfo.builder()
                     .id(id)
                     .shortName(projectMap.get(id).getShortName())
                     .name(projectMap.get(id).getName())
                     .serialNumber(projectMap.get(id).getSerialNumber())
                     .build()
               );
            }

            copy.setProjects(projects);
         }

         if (order.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())) {
            copy.setInvoiceRate(
               supplierInvoiceMap.get(order.getId()).divide(copy.getSettlementAmount(), 4, RoundingMode.DOWN).multiply(BigDecimal.valueOf(100L))
            );
            copy.setPaymentRate(
               supplierPaymentMap.get(order.getId()).divide(copy.getSettlementAmount(), 4, RoundingMode.DOWN).multiply(BigDecimal.valueOf(100L))
            );
         }

         copy.setSupplier(
            BriefIdAndNameDTO.builder()
               .id(order.getSupplierId())
               .name(supplierMap.get(order.getSupplierId()).getName())
               .shortName(supplierMap.get(order.getSupplierId()).getShortName())
               .build()
         );
         dto.add(copy);
      }

      return dto;
   }

   @NotNull
   private List<SupplierPaymentDetailDto> getSupplierPaymentDetailDtos(List<SupplierPayment> paymentList, PurchaseOrder purchaseOrder) {
      List<SupplierPaymentDetailDto> dto = new ArrayList<>();
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      paymentList.forEach(
         payment -> {
            BranchCompany branchCompany = branchCompanyMap.get(purchaseOrder.getBranchCompanyId());
            String name = ObjectUtils.isNotEmpty(branchCompany.getShortName()) ? branchCompany.getShortName() : branchCompany.getName();
            dto.add(
               SupplierPaymentDetailDto.builder()
                  .paymentDate(payment.getPaymentDate().atStartOfDay())
                  .paymentType(payment.getPaymentReasonId() != null ? Integer.valueOf(payment.getPaymentReasonId()) : 0)
                  .paymentAmount(payment.getActuallyPaymentAmount())
                  .contractSignBody(NameInfo.builder().id(purchaseOrder.getBranchCompanyId()).name(name).build())
                  .paymentBank(payment.getPaymentBank())
                  .paymentPerson(NameInfo.builder().id(payment.getApplyUserId()).name(userMap.get(payment.getApplyUserId()).getName()).build())
                  .attachmentList(this.attachmentService.listByIds(payment.getAttachmentIds()))
                  .build()
            );
         }
      );
      return dto;
   }
}
