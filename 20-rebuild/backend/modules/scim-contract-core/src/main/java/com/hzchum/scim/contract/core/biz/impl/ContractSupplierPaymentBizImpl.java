package com.hzchum.scim.contract.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.vo.StatisticsPageVO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierPaymentBiz;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.AuditTypeEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AssetTypeEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.enums.finance.StatusEnum;
import com.hzchum.scim.contract.core.api.enums.payment.OrderClassEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPaymentInvoiceDetailTypeEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPaymentDetail;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierSettlement;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractCollectionDisburse;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCredit;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCreditDetail;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractProjectAssetInjection;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractProjectDisburseDetail;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractProjectManagerMoneyInterests;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.OutsourcingBookDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.PurchaseStandingBookDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SelfEmployedPaymentAndFinishDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierJointlyOwnedProjectDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierPaymentDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierPaymentDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierPaymentRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSelfEmployedDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.saveSupplierPaymentDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PaymentCheckDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PaymentFindDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchasePaymentSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseSupplierPaymentInsourcingAddDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseSupplierPaymentSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseSupplierPaymentUpdateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SubOrderPaymentAddDtoParam;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentDetailService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.contract.core.api.service.finance.ContractCollectionDisburseService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditDetailService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditService;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectAssetInjectionService;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectDisburseDetailService;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectManagerMoneyInterestsService;
import com.hzchum.scim.contract.core.api.service.finance.SecurityDepositAndManagementCostService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.scm.core.api.enums.PurchaseEnum;
import com.hzchum.scim.scm.core.api.enums.SupplyTypeEnum;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.BriefPurchaseOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseSupplierSummaryDTO;
import com.hzchum.scim.scm.core.api.service.LogisticsOrderService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.utils.ProjectSerialNumberUtils;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.MessagePushUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo._do.BankAccount;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.SysSupplierPaymentAttribute;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinanceAmountLimitConfigDTO;
import com.hzchum.scim.system.core.api.service.BankAccountService;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.SysSupplierPaymentAttributeService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Reject;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundRecordDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.UnitService;
import com.hzchum.scim.wms.core.api.service.wmsUse.AnnualContractService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.RejectService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsAdjustDetailService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class ContractSupplierPaymentBizImpl implements ContractSupplierPaymentBiz {
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private LogisticsOrderService logisticsOrderService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private SysSupplierPaymentAttributeService supplierPaymentAttributeService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private InboundService inboundService;
   @Resource
   private SupplierSettlementService supplierSettlementService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private BankAccountService bankAccountService;
   @Resource
   private InboundDetailService inboundDetailService;
   @Resource
   private WmsAdjustDetailService wmsAdjustDetailService;
   @Resource
   private SupplierInvoiceService supplierInvoiceService;
   @Resource
   private SupplierPaymentDetailService supplierPaymentDetailService;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private RejectService rejectService;
   @Resource
   private UnitService unitService;
   @Resource
   private MeasureService measureService;
   @Resource
   private ClassificationService classificationService;
   @Resource
   private MesBuildingCargoListService cargoListService;
   @Resource
   private SubcontractOrderService subcontractOrderService;
   @Resource
   private ContractGivingCreditService givingCreditService;
   @Resource
   private ContractProjectDisburseDetailService discountService;
   @Resource
   private ContractGivingCreditDetailService givingCreditDetailService;
   @Resource
   private ContractAuditLedgerService auditLedgerService;
   @Resource
   private ContractProjectManagerMoneyInterestsService moneyInterestsService;
   @Resource
   private WmsApproveRecordService approvalsService;
   @Resource
   private WmsApproveRecordDetailService approvalsDetailService;
   @Resource
   private ContractProjectAssetInjectionService assetInjectionService;
   @Resource
   private UserService userService;
   @Resource
   private ConfigService configService;
   @Resource
   private ContractCollectionService collectionService;
   @Resource
   private ContractCollectionDisburseService contractCollectionDisburseService;
   @Resource
   private AnnualContractService annualContractService;
   @Resource
   private PlanMonomerService memoService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private SecurityDepositAndManagementCostService securityDepositAndManagementCostService;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ProjectSerialNumberUtils projectSerialNumberUtils;
   @Resource
   private SysPushFlowConfigBiz sysPushFlowConfigBiz;
   @Resource
   private NotificationTemplateDetailsUtils detailsUtils;
   @Resource
   private MessagePushUtil messagePushUtil;

   @Override
   public PageVO<SupplierPaymentRecordDTO> pageOrderPayments(
      Integer purchaseType,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      String serialNumber,
      Long supplierId,
      String supplierName,
      Long projectId,
      Integer settlementStatus,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<SupplierPaymentRecordDTO> records = this.purchaseOrderService
         .listByCondition(startDate, endDate, basicClass, purchaseType, supplierId, supplierName, serialNumber, projectId, settlementStatus);
      if (CollectionUtils.isNotEmpty(records)) {
         List<Long> orderIds = records.stream().map(SupplierPaymentRecordDTO::getId).collect(Collectors.toList());
         List<Long> projectIds = new ArrayList<>(32);
         records.stream()
            .filter(s -> StringUtils.isNotBlank(s.getProjectIds()))
            .map(s -> StringUtils.split(s.getProjectIds(), ","))
            .map(stringArr -> Arrays.stream(stringArr).map(Long::parseLong).collect(Collectors.toList()))
            .forEach(projectIds::addAll);
         List<ProjectInfo> projectInfoList = new ArrayList<>(32);
         if (CollectionUtils.isNotEmpty(projectIds)) {
            List<ProjectInfo> projectInfos = this.projectService.listSimpleByIdList(projectIds);
            projectInfoList.addAll(projectInfos);
         }

         Map<Long, List<Inbound>> orderIdListMap = this.inboundService
            .list(Wrappers.lambdaQuery(Inbound.class).eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).in(Inbound::getPurchaseId, orderIds))
            .stream()
            .collect(Collectors.groupingBy(Inbound::getPurchaseId));
         Map<Long, BigDecimal> orderIdInboundAmountMap = new HashMap<>(32);
         orderIdListMap.forEach((orderId, list) -> {
            BigDecimal bigDecimal = list.stream().map(Inbound::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            orderIdInboundAmountMap.put(orderId, bigDecimal);
         });
         Map<Long, List<Reject>> orderIdRejectListMap = this.rejectService
            .list(Wrappers.lambdaQuery(Reject.class).eq(Reject::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).in(Reject::getPurchaseOrderId, orderIds))
            .stream()
            .collect(Collectors.groupingBy(Reject::getPurchaseOrderId));
         Map<Long, BigDecimal> orderIdRejectAmountMap = new HashMap<>(32);
         orderIdRejectListMap.forEach((orderId, list) -> {
            BigDecimal bigDecimal = list.stream().map(Reject::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            orderIdRejectAmountMap.put(orderId, bigDecimal);
         });
         Map<Long, List<SupplierPayment>> orderIdPaymentListMap = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .in(SupplierPayment::getOrderId, orderIds)
                  .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .collect(Collectors.groupingBy(SupplierPayment::getOrderId));
         Map<Long, SupplierPayment> orderIdLastPaymentMap = new HashMap<>(32);
         orderIdPaymentListMap.forEach(
            (orderId, paymentList) -> {
               SupplierPayment supplierPayment = paymentList.stream()
                  .sorted(Comparator.<SupplierPayment, Long>comparing(SupplierPayment::getId).reversed())
                  .limit(1L)
                  .collect(Collectors.toList())
                  .get(0);
               orderIdLastPaymentMap.put(orderId, supplierPayment);
            }
         );
         Map<Long, SupplierSettlement> settlementMap = this.supplierSettlementService
            .list(
               Wrappers.lambdaQuery(SupplierSettlement.class)
                  .in(SupplierSettlement::getOrderId, orderIds)
                  .eq(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType())
                  .in(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .collect(Collectors.toMap(SupplierSettlement::getOrderId, Function.identity()));
         records.forEach(
            order -> {
               if (StringUtils.isNotBlank(order.getProjectIds())) {
                  List<String> idList = Arrays.stream(order.getProjectIds().split(",")).collect(Collectors.toList());
                  order.setProjects(projectInfoList.stream().filter(s -> idList.contains(s.getId().toString())).collect(Collectors.toList()));
               }

               BigDecimal finalInboundAmount = orderIdInboundAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO)
                  .subtract(orderIdRejectAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO));
               order.setInboundAmount(finalInboundAmount);
               SupplierPayment lastPayment = orderIdLastPaymentMap.get(order.getId());
               if (lastPayment != null) {
                  order.setLastPaymentTime(lastPayment.getCreateTime());
                  order.setLastPaymentAmount(lastPayment.getActuallyPaymentAmount());
               }

               if (settlementMap.get(order.getId()) != null) {
                  SupplierSettlement settlement = settlementMap.get(order.getId());
                  order.setAttachmentDTOS(this.attachmentService.listByIds(settlement.getAttachmentIds()));
                  order.setSettlementRemark(settlement.getRemark());
               }
            }
         );
      }

      return new PageVO<>(records);
   }

   @Override
   public PageVO<SupplierPaymentRecordDTO> pageOrderPaymentsV2(
      Integer purchaseType,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      String serialNumber,
      Long supplierId,
      String supplierName,
      Long projectId,
      Integer settlementStatus,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<SupplierPaymentRecordDTO> records = this.purchaseOrderService
         .listByCondition(startDate, endDate, basicClass, purchaseType, supplierId, supplierName, serialNumber, projectId, settlementStatus);
      if (CollectionUtils.isNotEmpty(records)) {
         List<Long> orderIds = records.stream().map(SupplierPaymentRecordDTO::getId).collect(Collectors.toList());
         List<Long> projectIds = new ArrayList<>(32);
         records.stream()
            .filter(s -> StringUtils.isNotBlank(s.getProjectIds()))
            .map(s -> StringUtils.split(s.getProjectIds(), ","))
            .map(stringArr -> Arrays.stream(stringArr).map(Long::parseLong).collect(Collectors.toList()))
            .forEach(projectIds::addAll);
         List<ProjectInfo> projectInfoList = new ArrayList<>(32);
         if (CollectionUtils.isNotEmpty(projectIds)) {
            List<ProjectInfo> projectInfos = this.projectService.listSimpleByIdList(projectIds);
            projectInfoList.addAll(projectInfos);
         }

         Map<Long, List<Inbound>> orderIdListMap = this.inboundService
            .list(Wrappers.lambdaQuery(Inbound.class).eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).in(Inbound::getPurchaseId, orderIds))
            .stream()
            .collect(Collectors.groupingBy(Inbound::getPurchaseId));
         Map<Long, BigDecimal> orderIdInboundAmountMap = new HashMap<>(32);
         orderIdListMap.forEach((orderId, list) -> {
            BigDecimal bigDecimal = list.stream().map(Inbound::getAmountNoFreight).filter(ObjectUtil::isNotEmpty).reduce(BigDecimal.ZERO, BigDecimal::add);
            orderIdInboundAmountMap.put(orderId, bigDecimal);
         });
         Map<Long, List<Reject>> orderIdRejectListMap = this.rejectService
            .list(Wrappers.lambdaQuery(Reject.class).eq(Reject::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).in(Reject::getPurchaseOrderId, orderIds))
            .stream()
            .collect(Collectors.groupingBy(Reject::getPurchaseOrderId));
         Map<Long, BigDecimal> orderIdRejectAmountMap = new HashMap<>(32);
         orderIdRejectListMap.forEach((orderId, list) -> {
            BigDecimal bigDecimal = list.stream().map(Reject::getAmountNoFreight).filter(ObjectUtil::isNotEmpty).reduce(BigDecimal.ZERO, BigDecimal::add);
            orderIdRejectAmountMap.put(orderId, bigDecimal);
         });
         Map<Long, List<SupplierPayment>> orderIdPaymentListMap = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .in(SupplierPayment::getOrderId, orderIds)
                  .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .collect(Collectors.groupingBy(SupplierPayment::getOrderId));
         Map<Long, SupplierPayment> orderIdLastPaymentMap = new HashMap<>(32);
         orderIdPaymentListMap.forEach(
            (orderId, paymentList) -> {
               SupplierPayment supplierPayment = paymentList.stream()
                  .sorted(Comparator.<SupplierPayment, Long>comparing(SupplierPayment::getId).reversed())
                  .limit(1L)
                  .collect(Collectors.toList())
                  .get(0);
               orderIdLastPaymentMap.put(orderId, supplierPayment);
            }
         );
         Map<Long, SupplierSettlement> settlementMap = this.supplierSettlementService
            .list(
               Wrappers.lambdaQuery(SupplierSettlement.class)
                  .in(SupplierSettlement::getOrderId, orderIds)
                  .eq(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType())
                  .in(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .collect(Collectors.toMap(SupplierSettlement::getOrderId, Function.identity()));
         records.forEach(
            order -> {
               if (StringUtils.isNotBlank(order.getProjectIds())) {
                  List<String> idList = Arrays.stream(order.getProjectIds().split(",")).collect(Collectors.toList());
                  order.setProjects(projectInfoList.stream().filter(s -> idList.contains(s.getId().toString())).collect(Collectors.toList()));
               }

               BigDecimal finalInboundAmount = orderIdInboundAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO)
                  .subtract(orderIdRejectAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO));
               order.setInboundAmount(finalInboundAmount);
               SupplierPayment lastPayment = orderIdLastPaymentMap.get(order.getId());
               if (lastPayment != null) {
                  order.setLastPaymentTime(lastPayment.getCreateTime());
                  order.setLastPaymentAmount(lastPayment.getActuallyPaymentAmount());
               }

               if (settlementMap.get(order.getId()) != null) {
                  SupplierSettlement settlement = settlementMap.get(order.getId());
                  order.setAttachmentDTOS(this.attachmentService.listByIds(settlement.getAttachmentIds()));
                  order.setSettlementRemark(settlement.getRemark());
               }
            }
         );
      }

      return new PageVO<>(records);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printPurchaseOrderPayInfo(
      Integer purchaseType,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      String serialNumber,
      Long supplierId,
      String supplierName,
      Integer settlementStatus
   ) {
      List<Map<String, Object>> mapList = this.listPrintExport(
         purchaseType, startDate, endDate, basicClass, serialNumber, supplierId, supplierName, settlementStatus
      );
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   private List<Map<String, Object>> listPrintExport(
      Integer purchaseType,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      String serialNumber,
      Long supplierId,
      String supplierName,
      Integer settlementStatus
   ) {
      List<SupplierPaymentRecordDTO> recordList = this.purchaseOrderService
         .listByCondition(startDate, endDate, basicClass, purchaseType, supplierId, supplierName, serialNumber, null, settlementStatus);
      if (CollectionUtils.isNotEmpty(recordList)) {
         recordList.forEach(s -> {
            Map<String, BigDecimal> amountMap = this.inboundService.getAmount(s.getId());
            s.setInboundAmount(amountMap != null ? amountMap.get("amount") : BigDecimal.ZERO);
         });
      }

      return recordList.stream().map(s -> {
         Map<String, Object> map = new HashMap<>();
         map.put("createTime", DateTimeUtil.getLocalDateStr(s.getCreateTime().toLocalDate()));
         map.put("serialNumber", s.getSerialNumber());
         map.put("supplierName", s.getSupplierName());
         map.put("basicClass", BasicClassEnum.getNameStr(s.getBasicClass()));
         map.put("supplyType", SupplyTypeEnum.getNameByType(s.getSupplyType()));
         if (s.getSupplyType().equals(SupplyTypeEnum.SELF.getType())) {
            map.put("amount", s.getAmount().setScale(2, RoundingMode.HALF_UP));
            map.put("inboundAmount", s.getInboundAmount().setScale(2, RoundingMode.HALF_UP));
            map.put("paymentAmount", s.getPaymentAmount().setScale(2, RoundingMode.HALF_UP));
            map.put("paymentRate", s.getPaymentAmount().multiply(BigDecimal.valueOf(100L)).divide(s.getAmount(), 2, RoundingMode.HALF_UP) + "%");
            map.put("invoiceAmount", s.getInvoiceAmount().setScale(2, RoundingMode.HALF_UP));
            map.put("invoiceRate", s.getInvoiceAmount().multiply(BigDecimal.valueOf(100L)).divide(s.getAmount(), 2, RoundingMode.HALF_UP) + "%");
         } else {
            map.put("amount", "/");
            map.put("inboundAmount", "/");
            map.put("paymentAmount", "/");
            map.put("paymentRate", "/");
            map.put("invoiceAmount", "/");
            map.put("invoiceRate", "/");
         }

         return map;
      }).collect(Collectors.toList());
   }

   @Override
   public void exportPurchaseOrderPayInfoList(
      Integer purchaseType,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      String serialNumber,
      Long supplierId,
      String supplierName,
      Integer settlementStatus,
      HttpServletResponse response
   ) {
      List<Map<String, Object>> purchaseOrderMapList = this.listPrintExport(
         purchaseType, startDate, endDate, basicClass, serialNumber, supplierId, supplierName, settlementStatus
      );
      Map<String, Object> map = new HashMap<>();
      map.put("purchaseOrderMapList", purchaseOrderMapList);
      String resourcePath = "files/PurchaseOrderPayInfoTemplate.xlsx";
      String tempFileName = "PurchaseOrderPayInfoTemplate";
      String exportFileName = "采购订单-付款台账.xlsx";
      PoiUtils.downLoadExcel(resourcePath, tempFileName, exportFileName, map, response);
   }

   @Override
   public PageVO<PurchaseSupplierSummaryDTO> pageSupplierPayments(
      String supplierName, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<PurchaseSupplierSummaryDTO> supplierSummaryDTOS = this.listSupplierPaymentGroupSupplierName(supplierName, startDate, endDate);
      return new PageVO<>(supplierSummaryDTOS);
   }

   private List<PurchaseSupplierSummaryDTO> listSupplierPaymentGroupSupplierName(String supplierName, LocalDate startDate, LocalDate endDate) {
      List<PurchaseSupplierSummaryDTO> supplierSummaryDTOS = this.purchaseOrderService.listBySupplierSum(supplierName, startDate, endDate);
      if (CollectionUtils.isNotEmpty(supplierSummaryDTOS)) {
         List<Long> supplierIds = supplierSummaryDTOS.stream().map(PurchaseSupplierSummaryDTO::getSupplierId).collect(Collectors.toList());
         Map<Long, BigDecimal> supplierIdAmountMap = this.purchaseOrderService
            .list(
               Wrappers.lambdaQuery(PurchaseOrder.class)
                  .in(PurchaseOrder::getSupplierId, supplierIds)
                  .eq(PurchaseOrder::getSupplyType, SupplyTypeEnum.SELF.getType())
            )
            .stream()
            .collect(
               Collectors.groupingBy(
                  PurchaseOrder::getSupplierId, Collectors.mapping(PurchaseOrder::getAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
               )
            );
         Map<Long, BigDecimal> supplierIdSettlementAmountMap = this.supplierSettlementService
            .getSupplierSettlementAmountMap(OrderClassEnum.MATERIAL_ORDER.getType(), supplierIds, null, null);
         Map<Long, BigDecimal> supplierIdPaymentAmountMap = this.supplierPaymentService
            .getSupplierPaymentAmountMap(SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), supplierIds, null, null);
         Map<Long, BigDecimal> supplierIdInvoiceAmountMap = this.supplierInvoiceService
            .getSupplierInvoiceAmountMap(SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), supplierIds, null, null);
         Map<Long, BigDecimal> inboundAmountSumMap = this.inboundService.getInboundAmountSumMap(supplierIds, null, null);
         supplierSummaryDTOS.forEach(s -> {
            s.setAmount(supplierIdAmountMap.get(s.getSupplierId()));
            s.setSettlementAmount(supplierIdSettlementAmountMap.getOrDefault(s.getSupplierId(), BigDecimal.ZERO));
            s.setPaymentAmount(supplierIdPaymentAmountMap.getOrDefault(s.getSupplierId(), BigDecimal.ZERO));
            s.setInvoiceAmount(supplierIdInvoiceAmountMap.getOrDefault(s.getSupplierId(), BigDecimal.ZERO));
            s.setInboundAmount(inboundAmountSumMap.getOrDefault(s.getSupplierId(), BigDecimal.ZERO));
         });
      }

      return supplierSummaryDTOS;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printSupplierPayments(String supplierName, LocalDate startDate, LocalDate endDate) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (startDate != null || endDate != null) {
         String statisticsDate;
         if (startDate == null) {
            String endDateStr = DateTimeUtil.getLocalDateStr(endDate);
            statisticsDate = endDateStr + "以前";
         } else if (endDate == null) {
            String startDateStr = DateTimeUtil.getLocalDateStr(startDate);
            statisticsDate = startDateStr + "至今";
         } else {
            statisticsDate = DateTimeUtil.getLocalDateStr(startDate) + "/" + DateTimeUtil.getLocalDateStr(endDate);
         }

         header.put("statisticsDate", statisticsDate);
      }

      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.listSupplierPaymentGroupSupplierName(supplierName, startDate, endDate)
         .stream()
         .map(BeanUtil::beanToMap)
         .collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PageVO<SupplierPaymentDTO> ledgerPayment(PaymentFindDTOParam param, Integer pageNumber, Integer pageSize) {
      Page<SupplierPayment> selectPage = this.supplierPaymentService
         .page(
            new Page<>(pageNumber.intValue(), pageSize.intValue()),
            (Wrapper<SupplierPayment>)(((((Wrappers.<SupplierPayment>lambdaQuery()
                              .ge(param.getStartDate() != null, SupplierPayment::getPaymentDate, param.getStartDate()))
                           .le(param.getEndDate() != null, SupplierPayment::getPaymentDate, param.getEndDate()))
                        .like(param.getPaymentUnit() != null, SupplierPayment::getPaymentUnit, param.getPaymentUnit()))
                     .like(param.getReceivingUnit() != null, SupplierPayment::getReceivingUnit, param.getReceivingUnit()))
                  .eq(param.getAuditStatus() != null, SupplierPayment::getAuditStatus, param.getAuditStatus()))
               .orderByDesc(BaseEntity::getCreateTime)
         );
      List<SupplierPaymentDTO> paymentDTOList = selectPage.getRecords().stream().map(s -> {
         SupplierPaymentDTO paymentDTO = BeanUtil.copy(s, SupplierPaymentDTO.class);
         paymentDTO.setAttachments(this.attachmentService.listByIds(s.getAttachmentIds()));
         this.setProjectNameOrderSN(paymentDTO);
         return paymentDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(paymentDTOList, selectPage));
   }

   private void setProjectNameOrderSN(SupplierPaymentDTO paymentDTO) {
      if (paymentDTO.getPropertyType().equals(SupplierPropertyTypeEnum.TRANSPORT_FEE.getType())) {
         List<SupplierPaymentDetail> paymentDetails = this.supplierPaymentDetailService
            .list(Wrappers.lambdaQuery(SupplierPaymentDetail.class).eq(SupplierPaymentDetail::getSupplierPaymentId, paymentDTO.getId()));
         List<String> serialNumberList = new ArrayList<>();
         List<String> projectNameList = new ArrayList<>();
         paymentDetails.forEach(d -> {
            if (d.getType().equals(SupplierPaymentInvoiceDetailTypeEnum.MATERIALS_PURCHASE.getType())) {
               PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(d.getPurchaseId());
               if (purchaseOrder != null) {
                  serialNumberList.add(purchaseOrder.getSerialNumber());
               }
            }

            if (d.getType().equals(SupplierPaymentInvoiceDetailTypeEnum.MANUFACTURES_SHIP.getType())) {
               ProjectInfo projectInfo = this.projectService.getSimpleById(d.getProjectId());
               if (projectInfo != null) {
                  projectNameList.add(projectInfo.getShortName());
               }
            }
         });
         paymentDTO.setSerialNumberList(serialNumberList);
         paymentDTO.setProjectNameList(projectNameList);
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printLedgerPayment(PaymentFindDTOParam param) {
      List<SupplierPayment> paymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .ge(param.getStartDate() != null, SupplierPayment::getPaymentDate, param.getStartDate())
               .le(param.getEndDate() != null, SupplierPayment::getPaymentDate, param.getEndDate())
               .like(param.getPaymentUnit() != null, SupplierPayment::getPaymentUnit, param.getPaymentUnit())
               .like(param.getReceivingUnit() != null, SupplierPayment::getReceivingUnit, param.getReceivingUnit())
               .eq(param.getAuditStatus() != null, SupplierPayment::getAuditStatus, param.getAuditStatus())
               .orderByDesc(BaseEntity::getCreateTime)
         );
      List<SupplierPaymentDTO> paymentDTOList = paymentList.stream().map(p -> {
         SupplierPaymentDTO paymentDTO = BeanUtil.copy(p, SupplierPaymentDTO.class);
         this.setProjectNameOrderSN(paymentDTO);
         return paymentDTO;
      }).collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (param.getStartDate() != null || param.getEndDate() != null) {
         String statisticsDate;
         if (param.getStartDate() == null) {
            String endDateStr = DateTimeUtil.getLocalDateStr(param.getEndDate());
            statisticsDate = endDateStr + "以前";
         } else if (param.getEndDate() == null) {
            String startDateStr = DateTimeUtil.getLocalDateStr(param.getStartDate());
            statisticsDate = startDateStr + "至今";
         } else {
            statisticsDate = DateTimeUtil.getLocalDateStr(param.getStartDate()) + "/" + DateTimeUtil.getLocalDateStr(param.getEndDate());
         }

         header.put("statisticsDate", statisticsDate);
      }

      printVO.setHeader(header);
      List<Map<String, Object>> mapList = paymentDTOList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PageVO<InboundRecordDTO> listInboundRecord(
      Long purchaseId,
      Long supplierId,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      Long classifyId,
      String classifyName,
      String purchaseSn,
      Long inboundId,
      String inboundSn,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<InboundRecordDTO> inboundRecordDTOS = this.listInboundByCondition(
         purchaseId, supplierId, startDate, endDate, basicClass, classifyId, classifyName, purchaseSn, inboundId, inboundSn
      );
      return new PageVO<>(inboundRecordDTOS);
   }

   @Override
   public PageVO<InboundRecordDTO> listInboundRecordV2(
      Long purchaseId,
      Long supplierId,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      Long classifyId,
      String classifyName,
      String purchaseSn,
      Long inboundId,
      String inboundSn,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<InboundRecordDTO> inboundRecordDTOS = this.listInboundByConditionV2(
         purchaseId, supplierId, startDate, endDate, basicClass, classifyId, classifyName, purchaseSn, inboundId, inboundSn
      );
      return new PageVO<>(inboundRecordDTOS);
   }

   private List<InboundRecordDTO> listInboundByCondition(
      Long purchaseId,
      Long supplierId,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      Long classifyId,
      String classifyName,
      String purchaseSn,
      Long inboundId,
      String inboundSn
   ) {
      List<InboundRecordDTO> inboundRecordDTOS = this.inboundDetailService
         .listInboundRecord(purchaseId, supplierId, startDate, endDate, basicClass, classifyId, classifyName, purchaseSn, inboundId, inboundSn);
      inboundRecordDTOS.forEach(
         i -> {
            i.setQuantity(i.getQuantity() != null ? i.getQuantity() : BigDecimal.ZERO);
            i.setQuantity(i.getQuantity().subtract(i.getRejectQuantity() != null ? i.getRejectQuantity() : BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP));
            i.setMete(i.getMete().subtract(i.getRejectMete() != null ? i.getRejectMete() : BigDecimal.ZERO));
            i.setAmount(i.getUnitPrice() == null ? BigDecimal.ZERO : i.getUnitPrice().multiply(i.getMete()).setScale(2, RoundingMode.HALF_UP));
            i.setAmountExcludingVat(
               i.getUnitPriceExcludingVat() == null ? BigDecimal.ZERO : i.getUnitPriceExcludingVat().multiply(i.getMete()).setScale(2, RoundingMode.HALF_UP)
            );
            i.setInputVat(i.getAmount().subtract(i.getAmountExcludingVat()).setScale(2, RoundingMode.HALF_UP));
         }
      );
      return inboundRecordDTOS;
   }

   private List<InboundRecordDTO> listInboundByConditionV2(
      Long purchaseId,
      Long supplierId,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      Long classifyId,
      String classifyName,
      String purchaseSn,
      Long inboundId,
      String inboundSn
   ) {
      List<InboundRecordDTO> inboundRecordDTOS = this.inboundDetailService
         .listInboundRecord(purchaseId, supplierId, startDate, endDate, basicClass, classifyId, classifyName, purchaseSn, inboundId, inboundSn);
      inboundRecordDTOS.forEach(
         i -> {
            i.setQuantity(i.getQuantity() != null ? i.getQuantity() : BigDecimal.ZERO);
            i.setQuantity(i.getQuantity().subtract(i.getRejectQuantity() != null ? i.getRejectQuantity() : BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP));
            i.setMete(i.getMete().subtract(i.getRejectMete() != null ? i.getRejectMete() : BigDecimal.ZERO));
            i.setAmount(i.getUnitPrice() == null ? BigDecimal.ZERO : i.getUnitPrice().multiply(i.getMete()).setScale(2, RoundingMode.HALF_UP));
            i.setAmountExcludingVat(
               i.getUnitPriceExcludingVat() == null ? BigDecimal.ZERO : i.getUnitPriceExcludingVat().multiply(i.getMete()).setScale(2, RoundingMode.HALF_UP)
            );
            i.setInputVat(i.getAmount().subtract(i.getAmountExcludingVat()).setScale(2, RoundingMode.HALF_UP));
            i.setAmountNoFreight(
               i.getUnitPriceNoFreight() == null ? BigDecimal.ZERO : i.getUnitPriceNoFreight().multiply(i.getMete()).setScale(2, RoundingMode.HALF_UP)
            );
            i.setAmountExcludingVATNoFreight(
               i.getUnitPriceExcludingVATNoFreight() == null
                  ? BigDecimal.ZERO
                  : i.getUnitPriceExcludingVATNoFreight().multiply(i.getMete()).setScale(2, RoundingMode.HALF_UP)
            );
            i.setInputVATNoFreight(i.getAmountNoFreight().subtract(i.getAmountExcludingVATNoFreight()).setScale(2, RoundingMode.HALF_UP));
         }
      );
      return inboundRecordDTOS;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printInboundRecord(
      Long purchaseId,
      Long supplierId,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      Long classifyId,
      String classifyName,
      String purchaseSn,
      Long inboundId,
      String inboundSn
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (purchaseId != null) {
         PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(purchaseId);
         header.put("serialNumber", purchaseOrder.getSerialNumber());
         Supplier supplier = this.supplierService.getById(purchaseOrder.getSupplierId());
         header.put("supplierName", supplier != null ? supplier.getName() : "");
         header.put("signingTime", purchaseOrder.getCreateTime());
         header.put("amount", purchaseOrder.getAmount());
      }

      if (supplierId != null) {
         BigDecimal amountSum = this.purchaseOrderService.getPurchaseAmountSum(null, null, supplierId, null, null);
         Supplier supplier = this.supplierService.getById(supplierId);
         header.put("supplierName", supplier != null ? supplier.getName() : "");
         header.put("amount", amountSum);
      }

      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.listInboundByCondition(
            purchaseId, supplierId, startDate, endDate, basicClass, classifyId, classifyName, purchaseSn, inboundId, inboundSn
         )
         .stream()
         .map(i -> {
            if (BasicClassEnum.STEEL_PLATE.getType().equals(i.getBasicClass())) {
               i.setSpecification(i.getThickness() + "*" + i.getWidth() + "*" + i.getLength() + "*" + i.getSpecification());
            }

            if (BasicClassEnum.COLOR_ROLL.getType().equals(i.getBasicClass())) {
               if (StringUtils.isNotBlank(i.getSpecification())) {
                  i.setSpecification(i.getThickness() + "*" + i.getWidth() + "*" + i.getSpecification());
               } else if (StringUtils.isNotBlank(i.getColor())) {
                  i.setSpecification(i.getThickness() + "*" + i.getWidth() + "*" + i.getColor());
               } else {
                  i.setSpecification(i.getThickness() + "*" + i.getWidth());
               }
            }

            if (BasicClassEnum.SECTION_STEEL.getType().equals(i.getBasicClass()) && i.getLength() != null) {
               i.setSpecification(i.getLength() + "*" + i.getSpecification());
            }

            return BeanUtil.beanToMap(i);
         })
         .collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public StatisticsPageVO supplierOrAcceptanceRecord(
      String year, Long supplierId, Long classifyId, Long purchaseOrderId, List<LocalDateTime> inboundTime, Integer pageNumber, Integer pageSize, int type
   ) {
      List<Long> classifyIds = null;
      if (classifyId != null) {
         Classification classification = this.classificationService.getById(classifyId);
         if (!classification.getBoolLastEnum()) {
            classifyIds = this.classificationService.getLastSubject(classifyId).stream().map(Classification::getId).collect(Collectors.toList());
         } else {
            classifyIds = Collections.singletonList(classifyId);
         }
      }

      List<InboundDetailDTO> detailDTOS = this.inboundDetailService.getDetailList(year, supplierId, classifyIds, purchaseOrderId, inboundTime);
      BigDecimal supplierReconciliationAmount = detailDTOS.stream()
         .map(InboundDetailDTO::getAmountExcludingVAT)
         .filter(ObjectUtil::isNotEmpty)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal supplierReconciliationAmountNoFreight = detailDTOS.stream()
         .map(InboundDetailDTO::getAmountExcludingVATNoFreight)
         .filter(ObjectUtil::isNotEmpty)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      com.github.pagehelper.Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<InboundDetailDTO> detailList = this.inboundDetailService.getDetailList(year, supplierId, classifyIds, purchaseOrderId, inboundTime);
      StatisticsPageVO statisticsPageVO;
      if (type == 1) {
         List<InboundDetailDTO> list = this.mergeDto(detailDTOS);
         com.github.pagehelper.Page<InboundDetailDTO> page1 = CommonUtil.getPage(pageNumber, pageSize, list);
         statisticsPageVO = new StatisticsPageVO<>(page1, page1.getResult());
      } else {
         statisticsPageVO = new StatisticsPageVO<>(page, detailList);
      }

      statisticsPageVO.setSupplierReconciliationAmount(supplierReconciliationAmount);
      statisticsPageVO.setSupplierReconciliationAmountNoFreight(supplierReconciliationAmountNoFreight);
      statisticsPageVO.setProject(detailList.stream().map(InboundDetailDTO::getProject).distinct().filter(Objects::nonNull).collect(Collectors.toList()));
      return statisticsPageVO;
   }

   @NotNull
   private List<InboundDetailDTO> mergeDto(List<InboundDetailDTO> detailList) {
      Map<String, InboundDetailDTO> map = new HashMap<>();

      for (InboundDetailDTO inboundDetailDTO : detailList) {
         StringBuilder sb = new StringBuilder(inboundDetailDTO.getClassifyId() + "");
         if (!BasicClassEnum.STEEL_PLATE.getType().equals(inboundDetailDTO.getBasicClass())
            && !BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetailDTO.getBasicClass())) {
            sb.append("-").append(inboundDetailDTO.getSpecification()).append("-").append(inboundDetailDTO.getUnitPrice());
         } else {
            sb.append("-")
               .append(inboundDetailDTO.getThickness())
               .append("-")
               .append(inboundDetailDTO.getSpecification())
               .append("-")
               .append(inboundDetailDTO.getUnitPrice());
         }

         String s = sb.toString();
         InboundDetailDTO dto = map.get(s);
         if (dto != null) {
            if (dto.getQuantity() != null) {
               dto.setQuantity(dto.getQuantity().add(inboundDetailDTO.getQuantity()));
            }

            dto.setMete(dto.getMete().add(inboundDetailDTO.getMete()));
            dto.setAmountExcludingVAT(dto.getAmountExcludingVAT().add(inboundDetailDTO.getAmountExcludingVAT()));
            dto.setInboundTime(inboundDetailDTO.getInboundTime());
            dto.setAmountExcludingVATNoFreight(
               ObjectUtil.isNotEmpty(inboundDetailDTO.getAmountExcludingVATNoFreight())
                  ? dto.getAmountExcludingVATNoFreight().add(inboundDetailDTO.getAmountExcludingVATNoFreight())
                  : dto.getAmountExcludingVATNoFreight()
            );
         } else {
            dto = inboundDetailDTO;
         }

         map.put(s, dto);
      }

      List<InboundDetailDTO> list = new ArrayList<>();

      for (Entry<String, InboundDetailDTO> dtoEntry : map.entrySet()) {
         list.add(dtoEntry.getValue());
      }

      list.sort(Comparator.comparing(InboundDetailDTO::getInboundTime));
      return list;
   }

   @Override
   public void supplierAndAcceptanceExport(
      String year, Long supplierId, Long classifyId, Long purchaseOrderId, List<LocalDateTime> dates, int type, HttpServletResponse response
   ) {
      List<Long> classifyIds = null;
      if (classifyId != null) {
         Classification classification = this.classificationService.getById(classifyId);
         if (!classification.getBoolLastEnum()) {
            classifyIds = this.classificationService.getLastSubject(classifyId).stream().map(Classification::getId).collect(Collectors.toList());
         } else {
            classifyIds = Collections.singletonList(classifyId);
         }
      }

      BriefPurchaseOrderDTO purchaseOrder = this.purchaseOrderService.selectById(purchaseOrderId);
      List<InboundDetailDTO> list = this.inboundDetailService.getDetailList(year, supplierId, classifyIds, purchaseOrderId, dates);
      HashMap<String, Object> map = new HashMap<>(16);
      String resourcePath = "";
      String tempFileName = "";
      String exportFileName = "";
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
      List<String> projectNames = null;
      if (type == 2) {
         resourcePath = "files/AcceptanceRecord.xlsx";
         tempFileName = "AcceptanceRecord";
         exportFileName = "验收单.xlsx";
      } else {
         resourcePath = "files/SupplierReconciliation.xlsx";
         tempFileName = "SupplierReconciliation";
         exportFileName = "供应商对账单.xlsx";
         list = this.mergeDto(list);
         if (CollectionUtil.isNotEmpty(dates)) {
            String a = dateTimeFormatter.format(dates.get(0));
            String b = dateTimeFormatter.format(dates.get(1));
            map.put("date", a + "~" + b);
         }

         projectNames = new ArrayList<>();
      }

      BigDecimal totalQuantity = BigDecimal.ZERO;
      BigDecimal totalMete = BigDecimal.ZERO;
      BigDecimal totalAmount = BigDecimal.ZERO;
      List<Map<String, Object>> mapList = new ArrayList<>();

      for (int i = 0; i < list.size(); i++) {
         Map<String, Object> mapObject = new HashMap<>();
         InboundDetailDTO detailDO = list.get(i);
         mapObject.put("id", i + 1);
         mapObject.put("className", detailDO.getClassifyName());
         String spec = this.setSpec(BeanUtil.copy(detailDO, InboundDetail.class), type == 2);
         if (BasicClassEnum.checkIsSteel(detailDO.getBasicClass())) {
            mapObject.put("spec", StrUtil.isNotBlank(spec) ? spec : "-");
            if (BasicClassEnum.SECTION_STEEL.getType().equals(detailDO.getBasicClass())) {
               String[] split = detailDO.getSpecification().split(" \\* ");
               if (split.length > 1) {
                  String cz = split[1];
                  mapObject.put("cz", cz);
               } else {
                  mapObject.put("cz", "-");
               }
            } else {
               mapObject.put("cz", StrUtil.isNotBlank(detailDO.getSpecification()) ? detailDO.getSpecification() : "-");
            }
         } else {
            mapObject.put("spec", StrUtil.isNotBlank(spec) ? spec : "-");
         }

         Measure measure = this.getMeasure(detailDO.getClassifyId());
         String measureUnit = measure.getMeasureUnit();
         String accountingUnit = measure.getAccountingUnit();
         mapObject.put("mUnit", StrUtil.isNotBlank(measureUnit) ? measureUnit : "-");
         if (detailDO.getQuantity() != null) {
            BigDecimal quantity = this.unitConversion(detailDO.getQuantity(), measureUnit, measure.getMeasurePrecision()).get(1);
            mapObject.put("quantity", quantity.toPlainString());
            totalQuantity = totalQuantity.add(quantity);
         } else {
            mapObject.put("quantity", "-");
         }

         BigDecimal precision;
         BigDecimal mete;
         if (BasicClassEnum.checkIsSteel(detailDO.getBasicClass())) {
            mapObject.put("aUnit", "吨");
            precision = UnitsPrecisionEnum.getByName("吨");
            mete = detailDO.getMete().divide(precision, 3, 4);
         } else {
            mapObject.put("aUnit", accountingUnit);
            Map<Integer, BigDecimal> decimalMap = this.unitConversion(detailDO.getMete(), accountingUnit, measure.getAccountingPrecision());
            mete = decimalMap.get(1);
            precision = decimalMap.get(2);
         }

         mapObject.put("mete", mete.toPlainString());
         totalMete = totalMete.add(mete);
         if (projectNames != null && detailDO.getProject() != null) {
            ProjectInfo project = detailDO.getProject();
            String name = project.getSerialNumber() + "-" + project.getShortName();
            if (!projectNames.contains(name)) {
               projectNames.add(name);
            }
         }

         mapObject.put("project", detailDO.getProject() != null ? detailDO.getProject().getName() : "-");
         mapObject.put("monomer", detailDO.getMonomerName() != null ? detailDO.getMonomerName() : "-");
         mapObject.put("area", detailDO.getAreaName() != null ? detailDO.getAreaName() : "-");
         mapObject.put("inboundTime", DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss").format(detailDO.getInboundTime()));
         if (detailDO.getAmount() != null) {
            mapObject.put("unitPrice", detailDO.getUnitPriceExcludingVAT().multiply(precision).setScale(20, 4).stripTrailingZeros().toPlainString());
            mapObject.put("amount", detailDO.getAmountExcludingVAT().setScale(2, 4));
            totalAmount = totalAmount.add(detailDO.getAmountExcludingVAT());
         } else {
            mapObject.put("unitPrice", "-");
            mapObject.put("amount", "-");
         }

         mapList.add(mapObject);
      }

      map.put("mapList", mapList);
      map.put("supplierName", purchaseOrder.getSupplier().getName());
      map.put("orderSN", purchaseOrder.getSerialNumber());
      if (projectNames != null) {
         map.put("projectName", StrUtil.join(",", projectNames));
      }

      map.put("totalQuantity", totalQuantity.toPlainString());
      map.put("totalMete", totalMete.toPlainString());
      map.put("totalAmount", totalAmount.setScale(2, 4));
      InputStream inputStream = null;
      File file = null;

      try {
         org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
         inputStream = resource.getInputStream();
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (Exception e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      assert file != null;
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath());
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.wmsDownLoadExcel(exportFileName, response, workbook, "");
   }

   @Override
   public void supplierAndAcceptanceExportV2(
      String year, Long supplierId, Long classifyId, Long purchaseOrderId, List<LocalDateTime> dates, int type, HttpServletResponse response
   ) {
      List<Long> classifyIds = null;
      if (classifyId != null) {
         Classification classification = this.classificationService.getById(classifyId);
         if (!classification.getBoolLastEnum()) {
            classifyIds = this.classificationService.getLastSubject(classifyId).stream().map(Classification::getId).collect(Collectors.toList());
         } else {
            classifyIds = Collections.singletonList(classifyId);
         }
      }

      BriefPurchaseOrderDTO purchaseOrder = this.purchaseOrderService.selectById(purchaseOrderId);
      List<InboundDetailDTO> list = this.inboundDetailService.getDetailList(year, supplierId, classifyIds, purchaseOrderId, dates);
      HashMap<String, Object> map = new HashMap<>(16);
      String resourcePath = "";
      String tempFileName = "";
      String exportFileName = "";
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
      List<String> projectNames = null;
      if (type == 2) {
         resourcePath = "files/AcceptanceRecord.xlsx";
         tempFileName = "AcceptanceRecord";
         exportFileName = "验收单.xlsx";
      } else {
         resourcePath = "files/SupplierReconciliation.xlsx";
         tempFileName = "SupplierReconciliation";
         exportFileName = "供应商对账单.xlsx";
         list = this.mergeDto(list);
         if (CollectionUtil.isNotEmpty(dates)) {
            String a = dateTimeFormatter.format(dates.get(0));
            String b = dateTimeFormatter.format(dates.get(1));
            map.put("date", a + "~" + b);
         }

         projectNames = new ArrayList<>();
      }

      BigDecimal totalQuantity = BigDecimal.ZERO;
      BigDecimal totalMete = BigDecimal.ZERO;
      BigDecimal totalAmount = BigDecimal.ZERO;
      List<Map<String, Object>> mapList = new ArrayList<>();

      for (int i = 0; i < list.size(); i++) {
         Map<String, Object> mapObject = new HashMap<>();
         InboundDetailDTO detailDO = list.get(i);
         mapObject.put("id", i + 1);
         mapObject.put("className", detailDO.getClassifyName());
         String spec = this.setSpec(BeanUtil.copy(detailDO, InboundDetail.class), type == 2);
         if (BasicClassEnum.checkIsSteel(detailDO.getBasicClass())) {
            mapObject.put("spec", StrUtil.isNotBlank(spec) ? spec : "-");
            if (BasicClassEnum.SECTION_STEEL.getType().equals(detailDO.getBasicClass())) {
               String[] split = detailDO.getSpecification().split(" \\* ");
               if (split.length > 1) {
                  String cz = split[1];
                  mapObject.put("cz", cz);
               } else {
                  mapObject.put("cz", "-");
               }
            } else {
               mapObject.put("cz", StrUtil.isNotBlank(detailDO.getSpecification()) ? detailDO.getSpecification() : "-");
            }
         } else {
            mapObject.put("spec", StrUtil.isNotBlank(spec) ? spec : "-");
         }

         Measure measure = this.getMeasure(detailDO.getClassifyId());
         String measureUnit = measure.getMeasureUnit();
         String accountingUnit = measure.getAccountingUnit();
         mapObject.put("mUnit", StrUtil.isNotBlank(measureUnit) ? measureUnit : "-");
         if (detailDO.getQuantity() != null) {
            BigDecimal quantity = this.unitConversion(detailDO.getQuantity(), measureUnit, measure.getMeasurePrecision()).get(1);
            mapObject.put("quantity", quantity.toPlainString());
            totalQuantity = totalQuantity.add(quantity);
         } else {
            mapObject.put("quantity", "-");
         }

         BigDecimal precision;
         BigDecimal mete;
         if (BasicClassEnum.checkIsSteel(detailDO.getBasicClass())) {
            mapObject.put("aUnit", "吨");
            precision = UnitsPrecisionEnum.getByName("吨");
            mete = detailDO.getMete().divide(precision, 3, 4);
         } else {
            mapObject.put("aUnit", accountingUnit);
            Map<Integer, BigDecimal> decimalMap = this.unitConversion(detailDO.getMete(), accountingUnit, measure.getAccountingPrecision());
            mete = decimalMap.get(1);
            precision = decimalMap.get(2);
         }

         mapObject.put("mete", mete.toPlainString());
         totalMete = totalMete.add(mete);
         if (projectNames != null && detailDO.getProject() != null) {
            ProjectInfo project = detailDO.getProject();
            String name = project.getSerialNumber() + "-" + project.getShortName();
            if (!projectNames.contains(name)) {
               projectNames.add(name);
            }
         }

         mapObject.put("project", detailDO.getProject() != null ? detailDO.getProject().getName() : "-");
         mapObject.put("monomer", detailDO.getMonomerName() != null ? detailDO.getMonomerName() : "-");
         mapObject.put("area", detailDO.getAreaName() != null ? detailDO.getAreaName() : "-");
         mapObject.put("inboundTime", DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss").format(detailDO.getInboundTime()));
         if (detailDO.getAmountNoFreight() != null) {
            mapObject.put(
               "unitPrice",
               ObjectUtil.isNotEmpty(detailDO.getUnitPriceExcludingVATNoFreight())
                  ? detailDO.getUnitPriceExcludingVATNoFreight().multiply(precision).setScale(20, 4).stripTrailingZeros().toPlainString()
                  : BigDecimal.ZERO
            );
            mapObject.put(
               "amount",
               ObjectUtil.isNotEmpty(detailDO.getAmountExcludingVATNoFreight()) ? detailDO.getAmountExcludingVATNoFreight().setScale(2, 4) : BigDecimal.ZERO
            );
            totalAmount = totalAmount.add(
               ObjectUtil.isNotEmpty(detailDO.getAmountExcludingVATNoFreight()) ? detailDO.getAmountExcludingVATNoFreight() : BigDecimal.ZERO
            );
         } else {
            mapObject.put("unitPrice", "-");
            mapObject.put("amount", "-");
         }

         mapList.add(mapObject);
      }

      map.put("mapList", mapList);
      map.put("supplierName", purchaseOrder.getSupplier().getName());
      map.put("orderSN", purchaseOrder.getSerialNumber());
      if (projectNames != null) {
         map.put("projectName", StrUtil.join(",", projectNames));
      }

      map.put("totalQuantity", totalQuantity.toPlainString());
      map.put("totalMete", totalMete.toPlainString());
      map.put("totalAmount", totalAmount.setScale(2, 4));
      InputStream inputStream = null;
      File file = null;

      try {
         org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
         inputStream = resource.getInputStream();
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (Exception e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      assert file != null;
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath());
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.wmsDownLoadExcel(exportFileName, response, workbook, "");
   }

   @Override
   public Map<String, BigDecimal> supplierReconciliationSummary(String year, Long supplierId) {
      Map<String, BigDecimal> map = new HashMap<>();
      List<PurchaseOrder> list = this.purchaseOrderService
         .list(
            (Wrappers.<PurchaseOrder>lambdaQuery().eq(supplierId != null, PurchaseOrder::getSupplierId, supplierId))
               .last(StrUtil.isNotBlank(year), "and DATE_FORMAT(create_time,'%Y') = " + year)
         );
      map.put("totalOrder", BigDecimal.valueOf(list.size()));
      map.put("totalAmount", list.stream().map(PurchaseOrder::getAmount).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add));
      map.put(
         "totalActualAmount",
         this.inboundDetailService
            .getDetailList(year, supplierId, null, null, null)
            .stream()
            .map(InboundDetailDTO::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
      );
      return map;
   }

   @Override
   public Map<String, BigDecimal> supplierReconciliationSummaryV2(String year, Long supplierId) {
      Map<String, BigDecimal> map = new HashMap<>();
      List<PurchaseOrder> list = this.purchaseOrderService
         .list(
            (Wrappers.<PurchaseOrder>lambdaQuery().eq(supplierId != null, PurchaseOrder::getSupplierId, supplierId))
               .last(StrUtil.isNotBlank(year), "and DATE_FORMAT(create_time,'%Y') = " + year)
         );
      map.put("totalOrder", BigDecimal.valueOf(list.size()));
      map.put("totalAmount", list.stream().map(PurchaseOrder::getAmount).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add));
      map.put(
         "totalActualAmount",
         this.inboundDetailService
            .getDetailList(year, supplierId, null, null, null)
            .stream()
            .map(InboundDetailDTO::getAmountNoFreight)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
      );
      return map;
   }

   private String setSpec(InboundDetail detail, Boolean b) {
      StringBuilder sb = new StringBuilder("");
      String thickness = detail.getThickness() != null ? detail.getThickness().stripTrailingZeros().toPlainString() : null;
      String width = detail.getWidth() != null ? detail.getWidth().stripTrailingZeros().toPlainString() : null;
      String length = detail.getLength() != null ? detail.getLength().stripTrailingZeros().toPlainString() : null;
      String spec = detail.getSpecification();
      boolean notBlank = StrUtil.isNotBlank(spec);
      if (BasicClassEnum.STEEL_PLATE.getType().equals(detail.getBasicClass())) {
         sb.append(thickness).append("*").append(width).append("*").append(length);
         if (notBlank && b) {
            sb.append(" * ").append(spec);
         }
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(detail.getBasicClass())) {
         if (notBlank && b) {
            sb.append(spec);
         } else {
            sb.append(spec.split(" \\* ")[0]);
         }
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(detail.getBasicClass())) {
         sb.append(thickness).append("*").append(width);
         if (notBlank && b) {
            sb.append(" * ").append(spec);
         }
      } else if (BasicClassEnum.checkNotSteel(detail.getBasicClass()) && notBlank) {
         sb.append(spec);
      }

      return sb.toString();
   }

   private Measure getMeasure(Long pid) {
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, pid));
      if (m.getAccountingUnit() != null) {
         return m;
      }

      Classification classification = this.classificationService.getById(pid);
      return this.getMeasure(classification.getParentId());
   }

   private Map<Integer, BigDecimal> unitConversion(BigDecimal value, String unit, Integer scale) {
      Unit u = this.unitService.getOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, unit));
      Map<Integer, BigDecimal> map = new HashMap<>();
      if (UnitEnum.DIGIT.getType().equals(u.getType())) {
         map.put(2, BigDecimal.ONE);
         map.put(1, new BigDecimal(value.stripTrailingZeros().toPlainString()));
      } else {
         BigDecimal precision = UnitsPrecisionEnum.getByName(unit);
         map.put(1, value.divide(precision, scale, 4));
         map.put(2, precision);
      }

      return map;
   }

   @Override
   public PageVO<SupplierPaymentDTO> listPayment(
      Long orderId,
      Integer propertyType,
      Long paymentUnitId,
      Long supplierId,
      Integer auditStatus,
      LocalDate startDate,
      LocalDate endDate,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<SupplierPayment> list = this.supplierPaymentService
         .listByCondition(orderId, propertyType, paymentUnitId, supplierId, auditStatus, startDate, endDate);
      List<SupplierPaymentDTO> paymentDTOList = list.stream()
         .map(
            supplierPayment -> {
               SupplierPaymentDTO paymentDTO = BeanUtil.copy(supplierPayment, SupplierPaymentDTO.class);
               paymentDTO.setAttachments(this.attachmentService.listByIds(supplierPayment.getAttachmentIds()));
               if (supplierPayment.getPropertyType().equals(SupplierPropertyTypeEnum.TRANSPORT_FEE.getType())) {
                  List<SupplierPaymentDetail> paymentDetailList = this.supplierPaymentDetailService
                     .list(Wrappers.lambdaQuery(SupplierPaymentDetail.class).eq(SupplierPaymentDetail::getSupplierPaymentId, supplierPayment.getId()));
                  List<SupplierPaymentDetailDTO> detailDTOList = paymentDetailList.stream()
                     .map(
                        d -> {
                           SupplierPaymentDetailDTO detailDTO = BeanUtil.copy(d, SupplierPaymentDetailDTO.class);
                           detailDTO.setPaymentAmount(
                              this.supplierPaymentService
                                 .getSumPayment(
                                    d.getReceivingUnitId(), d.getPaymentUnitId(), SupplierPropertyTypeEnum.TRANSPORT_FEE.getType(), d.getType(), null
                                 )
                           );
                           if (d.getType().equals(SupplierPaymentInvoiceDetailTypeEnum.MATERIALS_PURCHASE.getType())) {
                              detailDTO.setSerialNumber(this.purchaseOrderService.getById(d.getPurchaseId()).getSerialNumber());
                              detailDTO.setFreight(this.logisticsOrderService.getSumFreight(d.getPurchaseId(), null, null, null, null));
                           }

                           if (d.getType().equals(SupplierPaymentInvoiceDetailTypeEnum.MANUFACTURES_SHIP.getType())) {
                              detailDTO.setProjectName(this.projectService.getSimpleById(d.getProjectId()).getName());
                              detailDTO.setFreight(this.cargoListService.getShipFeeSum(d.getReceivingUnitId(), d.getProjectId(), null, null));
                           }

                           return detailDTO;
                        }
                     )
                     .collect(Collectors.toList());
                  paymentDTO.setPaymentDetails(detailDTOList);
               }

               return paymentDTO;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(paymentDTOList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printPaymentList(
      Long orderId, Integer propertyType, Long paymentUnitId, Long supplierId, Integer auditStatus, LocalDate startDate, LocalDate endDate
   ) {
      List<Map<String, Object>> mapList = this.supplierPaymentService
         .listPaymentMap(orderId, propertyType, paymentUnitId, supplierId, auditStatus, startDate, endDate);
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (propertyType.equals(SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())) {
         if (orderId != null) {
            PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(orderId);
            header.put("serialNumber", purchaseOrder.getSerialNumber());
            Supplier supplier = this.supplierService.getById(purchaseOrder.getSupplierId());
            header.put("supplierName", supplier != null ? supplier.getName() : "");
            header.put("signingTime", purchaseOrder.getSigningTime());
            header.put("amount", purchaseOrder.getAmount());
         }

         if (supplierId != null) {
            Supplier supplier = this.supplierService.getById(supplierId);
            header.put("supplierName", supplier != null ? supplier.getName() : "");
            BigDecimal amountSum = this.purchaseOrderService.getPurchaseAmountSum(null, null, supplierId, null, null);
            header.put("amount", amountSum);
         }
      }

      if (propertyType.equals(SupplierPropertyTypeEnum.TRANSPORT_FEE.getType())) {
      }

      if (propertyType.equals(SupplierPropertyTypeEnum.SUB_FEE.getType())) {
         SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(orderId);
         header.put("serialNumber", subcontractOrder.getSerialNumber());
         Supplier supplier = this.supplierService.getById(subcontractOrder.getSupplierId());
         header.put("supplierName", supplier != null ? supplier.getName() : "");
         header.put("signingTime", subcontractOrder.getSignDate());
         header.put("amount", subcontractOrder.getAmount());
      }

      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveSupplierPayment(PurchaseSupplierPaymentSaveDTOParam param) {
      PurchaseOrder order = this.purchaseOrderService.getById(param.getOrderId());
      Preconditions.checkArgument(order != null, "订单不存在");
      Integer count = this.supplierPaymentService
         .count(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())
               .eq(SupplierPayment::getOrderId, param.getOrderId())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(count == 0, "新增付款失败,订单存在未审核的付款记录");
      this.checkSettlementInfo(order, param.getApplyAmount());
      SupplierPayment payment = BeanUtil.copy(param, SupplierPayment.class);
      payment.setSerialNumber(order.getSerialNumber());
      payment.setPaymentUnitId(order.getBranchCompanyId());
      payment.setPropertyType(SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType());
      BranchCompany branchCompany = this.branchCompanyService.getById(order.getBranchCompanyId());
      payment.setPaymentUnit(branchCompany != null ? branchCompany.getName() : null);
      SysDictionary dictionary = this.dictionaryService.getByNameAndValue(DictionaryEnum.PAYMENT_REASON.getName(), param.getPaymentReasonId());
      payment.setPaymentReasonName(dictionary != null ? dictionary.getLabel() : null);
      payment.setReceivingUnitId(order.getSupplierId());
      Supplier supplier = this.supplierService.getById(order.getSupplierId());
      Preconditions.checkArgument(supplier != null, "订单供应商不存在");
      payment.setReceivingUnit(supplier.getName());
      payment.setReceiveBank(supplier.getBankName());
      payment.setReceiveBankAccount(supplier.getBankAccount());
      payment.setApplyUserId(UserUtil.getCurrentUserId());
      payment.setApplyUserName(UserUtil.getCurrentName());
      payment.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      if (CollectionUtils.isNotEmpty(param.getAttachmentIds())) {
         String attachments = StringUtils.join(param.getAttachmentIds(), ",");
         payment.setAttachmentIds(attachments);
      }

      this.supplierPaymentService.save(payment);
      return true;
   }

   private void checkSettlementInfo(PurchaseOrder order, BigDecimal applyAmount) {
      if (order.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())) {
         SupplierSettlement supplierSettlement = this.supplierSettlementService
            .getOne(
               Wrappers.lambdaQuery(SupplierSettlement.class)
                  .eq(SupplierSettlement::getOrderId, order.getId())
                  .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            );
         BigDecimal paidPaymentAmount = this.supplierPaymentService
            .getPaidPaymentAmount(order.getId(), SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType());
         Preconditions.checkArgument(paidPaymentAmount.add(applyAmount).compareTo(supplierSettlement.getAmount()) <= 0, "新增付款失败,付款金额不能超过结算金额");
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updatePayment(PurchaseSupplierPaymentUpdateDTOParam param) {
      SupplierPayment payment = this.supplierPaymentService.getById(param.getId());
      Preconditions.checkArgument(payment != null, "修改失败,付款申请不存在!");
      Preconditions.checkArgument(payment.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "修改失败,付款申请已审核!");
      PurchaseOrder order = this.purchaseOrderService.getById(param.getOrderId());
      Preconditions.checkArgument(order != null, "订单不存在");
      this.checkSettlementInfo(order, param.getApplyAmount());
      payment.setSerialNumber(order.getSerialNumber());
      BranchCompany branchCompany = this.branchCompanyService.getById(order.getBranchCompanyId());
      payment.setPaymentUnit(branchCompany != null ? branchCompany.getName() : null);
      Supplier supplier = this.supplierService.getById(order.getSupplierId());
      Preconditions.checkArgument(supplier != null, "订单供应商不存在");
      payment.setReceivingUnitId(order.getSupplierId());
      payment.setReceivingUnit(supplier.getName());
      payment.setReceiveBank(supplier.getBankName());
      payment.setReceiveBankAccount(supplier.getBankAccount());
      SysDictionary dictionary = this.dictionaryService.getByNameAndValue(DictionaryEnum.PAYMENT_REASON.getName(), param.getPaymentReasonId());
      payment.setPaymentReasonName(dictionary != null ? dictionary.getLabel() : null);
      BeanUtil.copy(param, payment);
      String join = StringUtils.join(param.getAttachmentIds(), ",");
      this.attachmentService.replaceAttachment(payment.getAttachmentIds(), join);
      payment.setAttachmentIds(join);
      this.supplierPaymentService.updateById(payment);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean auditSupplierPayment(PaymentCheckDTOParam param) {
      Preconditions.checkArgument(!param.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "审核状态有误!");
      SupplierPayment payment = this.supplierPaymentService.getById(param.getId());
      Preconditions.checkArgument(payment != null, "付款填报信息不存在");
      Preconditions.checkArgument(payment.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "该付款填报已审核!");
      payment.setAuditStatus(param.getAuditStatus());
      payment.setAuditUserId(UserUtil.getCurrentUserId());
      payment.setAuditUserName(UserUtil.getCurrentName());
      payment.setAuditTime(LocalDateTime.now());
      if (param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())) {
         BeanUtil.copy(param, payment);
      }

      if (payment.getPropertyType().equals(SupplierPropertyTypeEnum.TRANSPORT_FEE.getType())) {
         List<SupplierPaymentDetail> paymentDetails = this.supplierPaymentDetailService
            .list(Wrappers.lambdaQuery(SupplierPaymentDetail.class).eq(SupplierPaymentDetail::getSupplierPaymentId, param.getId()));
         paymentDetails.forEach(pd -> {
            pd.setAuditStatus(param.getAuditStatus());
            if (param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())) {
               pd.setActuallyPaymentAmount(pd.getApplyAmount());
            }

            this.supplierPaymentDetailService.updateById(pd);
         });
      }

      this.supplierPaymentService.updateById(payment);
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deletePayment(List<Long> ids) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(ids), "未选中任何付款申请!");
      ids.forEach(id -> {
         SupplierPayment supplierPayment = this.supplierPaymentService.getById(id);
         Preconditions.checkArgument(supplierPayment != null, "删除失败,付款申请不存在!");
         Preconditions.checkArgument(supplierPayment.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "删除失败,付款申请已审核!");
         this.attachmentService.deleteIds(supplierPayment.getAttachmentIds());
         if (supplierPayment.getPropertyType().equals(SupplierPropertyTypeEnum.TRANSPORT_FEE.getType())) {
            this.supplierPaymentDetailService.remove(Wrappers.lambdaQuery(SupplierPaymentDetail.class).eq(SupplierPaymentDetail::getSupplierPaymentId, id));
         }

         this.supplierPaymentService.removeById(id);
      });
      return true;
   }

   @Transactional
   @Override
   public ResultVO addOaSelfOwned(PurchasePaymentSaveParam param) {
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      List<Long> longList = param.getSupplierPayment().stream().map(saveSupplierPaymentDto::getSupplierPaymentId).collect(Collectors.toList());
      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService.list(Wrappers.lambdaQuery(PurchaseOrder.class).in(PurchaseOrder::getId, longList));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(purchaseOrders), "采购订单不存在");
      Preconditions.checkArgument(param.getAttachmentId() == null || param.getAttachmentId().size() <= 10, "附件数量超出限制(至多10个)!");
      Set<Long> settlementAuditingOrderIds = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .in(SupplierSettlement::getOrderId, longList)
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         )
         .stream()
         .map(SupplierSettlement::getOrderId)
         .collect(Collectors.toSet());
      Preconditions.checkArgument(settlementAuditingOrderIds.isEmpty(), "订单正在结算审批中,提交失败!");
      String attachmentIds = StringUtils.join(param.getAttachmentId(), ",");
      List<PurchaseOrder> settlement = purchaseOrders.stream()
         .filter(a -> a.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(settlement)) {
         Map<Long, BigDecimal> map = param.getSupplierPayment()
            .stream()
            .collect(Collectors.toMap(saveSupplierPaymentDto::getSupplierPaymentId, saveSupplierPaymentDto::getMoneyAmount));
         List<SupplierPayment> paymentList = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .in(SupplierPayment::getOrderId, settlement.stream().map(PurchaseOrder::getId).collect(Collectors.toList()))
                  .in(
                     SupplierPayment::getPropertyType,
                     SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(),
                     SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
                  )
                  .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            );
         Map<Long, BigDecimal> collectMap = paymentList.stream()
            .collect(
               Collectors.groupingBy(
                  SupplierPayment::getOrderId,
                  Collectors.reducing(
                     BigDecimal.ZERO,
                     s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getPaymentAmount() : s.getActuallyPaymentAmount(),
                     BigDecimal::add
                  )
               )
            );
         settlement.forEach(
            a -> Preconditions.checkArgument(
               a.getSettlementAmount().compareTo(collectMap.getOrDefault(a.getId(), BigDecimal.ZERO).add(map.get(a.getId()))) >= 0, "付款金额不能大于结算金额"
            )
         );
      }

      List<Long> paymentIds = new ArrayList<>();
      Map<Long, saveSupplierPaymentDto> paymentDtoMap = param.getSupplierPayment()
         .stream()
         .collect(Collectors.toMap(saveSupplierPaymentDto::getSupplierPaymentId, Function.identity()));
      purchaseOrders.forEach(
         a -> {
            Preconditions.checkArgument(
               a.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType()) && a.getDataStatus().equals(DataStatusEnum.SUCCEED.getType()), "订单当前状态不允许付款!"
            );
            if (paymentDtoMap.get(a.getId()) != null) {
               saveSupplierPaymentDto supplierPaymentDto = paymentDtoMap.get(a.getId());
               Preconditions.checkArgument(
                  supplierPaymentDto.getMoneyAmount() != null && supplierPaymentDto.getMoneyAmount().compareTo(BigDecimal.ZERO) != 0, "付款金额有误!"
               );
               SupplierPayment payment = BeanUtil.copy(param, SupplierPayment.class);
               payment.setOrderId(a.getId());
               payment.setSerialNumber(a.getSerialNumber());
               payment.setPropertyType(
                  a.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())
                     ? SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType()
                     : SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
               );
               payment.setSupplierId(a.getSupplierId());
               payment.setBranchCompanyId(a.getBranchCompanyId());
               payment.setPaymentUnitId(a.getBranchCompanyId());
               payment.setAuditStatus(AuditStatusEnum.AUDITING.getType());
               payment.setPaymentDate(LocalDate.from(param.getApplyDate()));
               payment.setPaymentAmount(paymentDtoMap.get(a.getId()).getMoneyAmount());
               payment.setApplyAmount(paymentDtoMap.get(a.getId()).getMoneyAmount());
               payment.setApplyUserId(param.getApplicantId() != null ? param.getApplicantId() : UserUtil.getCurrentUserId());
               payment.setAttachmentIds(attachmentIds);
               payment.setBoolDeleteEnum(Boolean.TRUE);
               this.supplierPaymentService.save(payment);
               paymentIds.add(payment.getId());
            }
         }
      );
      Set<String> projectIdsSet = purchaseOrders.stream().map(PurchaseOrder::getProjectIds).filter(StringUtils::isNotBlank).collect(Collectors.toSet());
      ContractAuditLedger contractAuditLedger = new ContractAuditLedger()
         .setProjectAttribute(ProjectAttributeEnum.SELF_SUPPORT.getType())
         .setContractId(StringUtils.join(purchaseOrders.stream().map(PurchaseOrder::getId).collect(Collectors.toList()), ","))
         .setPaymentId(StringUtils.join(paymentIds, ","))
         .setPaymentEnum(AuditPaymentEnum.PROCUREMENT_PAYMENT.getType())
         .setFilingDate(param.getApplyDate())
         .setContractSignBodyId(purchaseOrders.get(0).getBranchCompanyId())
         .setProjectId(projectIdsSet.isEmpty() ? null : StringUtils.join(projectIdsSet, ","))
         .setInitiatorId(param.getApplicantId() != null ? param.getApplicantId() : UserUtil.getCurrentUserId())
         .setWrittenById(param.getApplicantId() != null ? param.getApplicantId() : UserUtil.getCurrentUserId())
         .setSubmitDate(LocalDateTime.now())
         .setContractNumber(StringUtils.join(purchaseOrders.stream().map(PurchaseOrder::getSerialNumber).collect(Collectors.toList()), "/"))
         .setSupplierId(param.getSupplierId())
         .setAuditStatusEnum(AuditStatusEnum.AUDITING.getType())
         .setAuditType(AuditTypeEnum.PAYMENT_APPROVE.getType())
         .setAttachmentIds(attachmentIds)
         .setApplyAmount(param.getSupplierPayment().stream().map(saveSupplierPaymentDto::getMoneyAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
      String projectIds = purchaseOrders.stream()
         .filter(a -> StringUtils.isNotBlank(a.getProjectIds()))
         .map(PurchaseOrder::getProjectIds)
         .collect(Collectors.joining(","));
      if (StringUtils.isNotBlank(projectIds)) {
         List<Long> projectIdList = Arrays.stream(projectIds.split(","))
            .map(Long::valueOf)
            .collect(Collectors.toList())
            .stream()
            .distinct()
            .collect(Collectors.toList());
         List<ContractProject> projectList = this.projectService
            .list(Wrappers.lambdaQuery(ContractProject.class).in(!longList.isEmpty(), ContractProject::getId, projectIdList));
         Map<Long, ContractProject> projectMap;
         if (CollectionUtil.isNotEmpty(projectList)) {
            projectMap = projectList.stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
         } else {
            projectMap = null;
         }

         if (projectMap != null) {
            contractAuditLedger.setProjectId(StringUtils.join(projectIds, ","));
         }
      }

      if (purchaseOrders.size() == 1 && ObjectUtils.isNotEmpty(purchaseOrders.get(0).getProjectIds())) {
         List<Long> projectId = Arrays.stream(purchaseOrders.get(0).getProjectIds().split(",")).map(Long::valueOf).collect(Collectors.toList());
         if (projectId.size() == 1) {
            ContractProject contractProject = this.projectService.getById(projectId.get(0));
            contractAuditLedger.setProjectManagerId(contractProject.getSalesLeaderId());
         }
      }

      contractAuditLedger.setBoolDeleteEnum(Boolean.TRUE);
      this.auditLedgerService.save(contractAuditLedger);
      build.setCode(20000L);
      build.setData(contractAuditLedger.getId());
      return build;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean addSelfOwned(PurchasePaymentSaveParam param) {
      Set<Long> longList = param.getSupplierPayment().stream().map(saveSupplierPaymentDto::getSupplierPaymentId).collect(Collectors.toSet());
      Preconditions.checkArgument(longList.size() == param.getSupplierPayment().size(), "选择订单出现重复!");
      Preconditions.checkArgument(
         param.getSupplierPayment().stream().allMatch(s -> s.getMoneyAmount() != null && s.getMoneyAmount().compareTo(BigDecimal.ZERO) != 0), "订单付款金额有误!"
      );
      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService.listByIds(longList);
      Preconditions.checkArgument(purchaseOrders.size() == longList.size(), "采购订单不存在!");
      Preconditions.checkArgument(
         purchaseOrders.stream()
            .anyMatch(
               order -> order.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType()) && order.getDataStatus().equals(DataStatusEnum.SUCCEED.getType())
            ),
         "订单正在审批中,暂时不允许付款!"
      );
      Preconditions.checkArgument(param.getAttachmentId() == null || param.getAttachmentId().size() <= 10, "附件数量超出限制(至多10个)!");
      String attachmentIds = CollectionUtils.isNotEmpty(param.getAttachmentId()) ? StringUtils.join(param.getAttachmentId(), ",") : null;
      Map<Long, SupplierSettlement> orderIdSettleMap = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .in(SupplierSettlement::getOrderId, longList)
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         )
         .stream()
         .collect(Collectors.toMap(SupplierSettlement::getOrderId, Function.identity()));
      Map<Long, BigDecimal> oldOrderIdPaymentAmountMap = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getOrderId, longList)
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               SupplierPayment::getOrderId,
               Collectors.reducing(
                  BigDecimal.ZERO,
                  s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getPaymentAmount() : s.getActuallyPaymentAmount(),
                  BigDecimal::add
               )
            )
         );
      Map<Long, BigDecimal> orderIdPaymentAmountMap = param.getSupplierPayment()
         .stream()
         .collect(Collectors.toMap(saveSupplierPaymentDto::getSupplierPaymentId, saveSupplierPaymentDto::getMoneyAmount));
      FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
      purchaseOrders.forEach(
         purchaseOrder -> {
            BigDecimal paymentAmount = oldOrderIdPaymentAmountMap.getOrDefault(purchaseOrder.getId(), BigDecimal.ZERO);
            BigDecimal thisPaymentAmount = orderIdPaymentAmountMap.get(purchaseOrder.getId());
            if (purchaseOrder.getSettlementStatus() == null || purchaseOrder.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())) {
               if (!financeAmountLimitConfig.getBoolAllowOverContractAmount()) {
                  Preconditions.checkArgument(paymentAmount.add(thisPaymentAmount).compareTo(purchaseOrder.getAmount()) <= 0, "付款总额(含未审批)不能大于合同额!");
               }

               if (!financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
                  SupplierSettlement settlement = orderIdSettleMap.get(purchaseOrder.getId());
                  Preconditions.checkArgument(
                     settlement == null || paymentAmount.add(thisPaymentAmount).compareTo(settlement.getAmount()) <= 0, "付款总额(含未审批)不能大于结算申请额!"
                  );
               }
            }

            if (SettlementStatusEnum.SETTLED.getType().equals(purchaseOrder.getSettlementStatus()) && !financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
               Preconditions.checkArgument(paymentAmount.add(thisPaymentAmount).compareTo(purchaseOrder.getSettlementAmount()) <= 0, "付款总额(含未审批)不能大于结算额!");
            }
         }
      );
      List<SupplierPayment> paymentList = new ArrayList<>(16);
      purchaseOrders.forEach(
         order -> {
            SupplierPayment payment = BeanUtil.copy(param, SupplierPayment.class);
            payment.setOrderId(order.getId());
            payment.setPropertyType(
               order.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())
                  ? SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType()
                  : SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
            );
            payment.setSupplierId(order.getSupplierId());
            payment.setBranchCompanyId(order.getBranchCompanyId());
            payment.setPaymentUnitId(order.getBranchCompanyId());
            payment.setAuditStatus(AuditStatusEnum.AUDITING.getType());
            payment.setPaymentDate(LocalDate.from(param.getApplyDate()));
            payment.setPaymentAmount(orderIdPaymentAmountMap.get(order.getId()));
            payment.setApplyAmount(orderIdPaymentAmountMap.get(order.getId()));
            payment.setApplyUserId(param.getApplicantId() != null ? param.getApplicantId() : UserUtil.getCurrentUserId());
            payment.setAttachmentIds(attachmentIds);
            paymentList.add(payment);
         }
      );
      this.supplierPaymentService.saveBatch(paymentList);
      Set<Long> projectIds = new HashSet<>();
      purchaseOrders.forEach(
         purchaseOrder -> {
            if (StringUtils.isNotBlank(purchaseOrder.getProjectIds())) {
               List<Long> pidList = Arrays.stream(StringUtils.split(purchaseOrder.getProjectIds(), ","))
                  .filter(StringUtils::isNotBlank)
                  .map(Long::valueOf)
                  .collect(Collectors.toList());
               projectIds.addAll(pidList);
            }
         }
      );
      Long projectManagerId = null;
      if (CollectionUtils.isNotEmpty(projectIds)) {
         ContractProject project = this.projectService.listByIds(projectIds).stream().findFirst().orElse(null);
         if (project != null) {
            projectManagerId = project.getSalesLeaderId() != null ? project.getSalesLeaderId() : project.getSignerId();
         }
      }

      List<String> serialNumberList = purchaseOrders.stream().map(PurchaseOrder::getSerialNumber).collect(Collectors.toList());
      String dataSerialNumber = serialNumberList.size() == 1 ? serialNumberList.get(0) : serialNumberList.get(0) + "等";
      ContractAuditLedger contractAuditLedger = new ContractAuditLedger()
         .setProjectAttribute(ProjectAttributeEnum.SELF_SUPPORT.getType())
         .setContractId(StringUtils.join(purchaseOrders.stream().map(PurchaseOrder::getId).collect(Collectors.toList()), ","))
         .setPaymentId(StringUtils.join(paymentList.stream().map(SupplierPayment::getId).collect(Collectors.toList()), ","))
         .setPaymentEnum(AuditPaymentEnum.PROCUREMENT_PAYMENT.getType())
         .setFilingDate(param.getApplyDate())
         .setContractSignBodyId(purchaseOrders.get(0).getBranchCompanyId())
         .setProjectId(projectIds.isEmpty() ? null : StringUtils.join(projectIds, ","))
         .setProjectManagerId(projectManagerId)
         .setInitiatorId(param.getApplicantId() != null ? param.getApplicantId() : UserUtil.getCurrentUserId())
         .setContractNumber(dataSerialNumber)
         .setSupplierId(param.getSupplierId())
         .setAuditStatusEnum(AuditStatusEnum.AUDITING.getType())
         .setAuditType(AuditTypeEnum.PAYMENT_APPROVE.getType())
         .setAttachmentIds(attachmentIds)
         .setApplyAmount(param.getSupplierPayment().stream().map(saveSupplierPaymentDto::getMoneyAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
      this.auditLedgerService.save(contractAuditLedger);
      WmsApproveRecord record = this.approvalsService
         .createRecord(
            contractAuditLedger.getId(),
            dataSerialNumber,
            ApproveProcessTypeEnumV2.SELF_BUYING_PAYMENT_AUDIT.getType(),
            null,
            null,
            null,
            true,
            null,
            null,
            null
         );
      contractAuditLedger.setApproveRecordId(record.getId());
      this.auditLedgerService.updateById(contractAuditLedger);
      return true;
   }

   @Override
   public PageVO<PurchaseStandingBookDTO> listInboundV2(
      Long supplierId, Integer settlementStatus, String serialNumber, Integer basicClass, Long branchCompanyId, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<PurchaseStandingBookDTO> orderList = this.purchaseOrderService
         .getSecondaryUnitAll(supplierId, settlementStatus, serialNumber, basicClass, branchCompanyId);
      if (CollectionUtils.isEmpty(orderList)) {
         return new PageVO<>(orderList);
      }

      List<Long> orderIds = orderList.stream().map(PurchaseStandingBookDTO::getOrderId).collect(Collectors.toList());
      Map<Long, BigDecimal> purchaseActualInboundAmountMap = this.inboundService.getPurchaseActualInboundAmountMap(orderIds);
      orderList.forEach(order -> order.setPurchaseAmount(purchaseActualInboundAmountMap.getOrDefault(order.getOrderId(), BigDecimal.ZERO)));
      return new PageVO<>(orderList);
   }

   @Override
   public PageVO<OutsourcingBookDTO> outsourcingList(
      LocalDateTime year, Integer type, String serialNumber, String projectName, String supplierName, Integer pageNumber, Integer pageSize
   ) {
      List<BranchCompany> branchCompanyList = this.branchCompanyService.list(Wrappers.lambdaQuery(BranchCompany.class).eq(BranchCompany::getLevel, 1));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(branchCompanyList), "请先配置一级单位");
      List<ContractProject> projectList = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .apply(ObjectUtils.isNotEmpty(year), "date_format(create_time,'%Y') = date_format({0},'%Y')", year)
               .in(ContractProject::getContractSignBodyId, branchCompanyList.stream().map(BranchCompany::getId).collect(Collectors.toList()))
               .like(ObjectUtils.isNotEmpty(projectName), ContractProject::getName, projectName)
         );
      if (CollectionUtils.isEmpty(projectList)) {
         return new PageVO<>();
      }

      Map<Long, ContractProject> projectMap = projectList.stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      List<PlanMonomer> monomerList = this.memoService
         .list(
            Wrappers.lambdaQuery(PlanMonomer.class)
               .in(PlanMonomer::getProjectId, projectList.stream().map(ContractProject::getId).collect(Collectors.toList()))
         );
      if (CollectionUtils.isNotEmpty(monomerList)) {
         return new PageVO<>();
      }

      Map<Long, List<PlanArea>> areaMap = null;
      if (CollectionUtils.isNotEmpty(monomerList)) {
         List<PlanArea> areaList = this.areaService
            .list(Wrappers.lambdaQuery(PlanArea.class).in(PlanArea::getMonomerId, monomerList.stream().map(PlanMonomer::getId).collect(Collectors.toList())));
         areaMap = areaList.stream().collect(Collectors.groupingBy(PlanArea::getMonomerId));
      }

      List<PurchaseOrder> orderList = this.purchaseOrderService.list(Wrappers.lambdaQuery(PurchaseOrder.class).isNotNull(PurchaseOrder::getProjectIds));
      List<OutsourcingBookDTO> list = new ArrayList<>();

      for (PlanMonomer monomer : monomerList) {
         ContractProject project = projectMap.get(monomer.getProjectId());
         List<PlanArea> planAreas = ObjectUtils.isNotEmpty(areaMap) ? areaMap.get(monomer.getId()) : null;
         String areaName = null;
         if (CollectionUtils.isNotEmpty(planAreas)) {
            List<String> names = planAreas.stream().map(PlanArea::getName).collect(Collectors.toList());
            areaName = names.stream().collect(Collectors.joining("/"));
         }

         OutsourcingBookDTO build = OutsourcingBookDTO.builder()
            .projectAttributeEnum(project.getProjectAttribute())
            .project(
               ProjectInfo.builder()
                  .id(project.getId())
                  .name(project.getName())
                  .serialNumber(project.getSerialNumber())
                  .shortName(project.getShortName())
                  .build()
            )
            .monomerId(monomer.getId())
            .monomerName(monomer.getName())
            .areaName(areaName)
            .planCreateTime(monomer.getCreateTime())
            .build();
         list.add(build);
      }

      if (ObjectUtils.isNotEmpty(type)) {
      }

      return null;
   }

   @Override
   public SelfEmployedPaymentAndFinishDTO getPaymentDetailById(List<Long> orderIds) {
      List<SubcontractOrder> subcontractOrderList = this.subcontractOrderService
         .list(
            Wrappers.lambdaQuery(SubcontractOrder.class)
               .in(SubcontractOrder::getId, orderIds)
               .eq(SubcontractOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(subcontractOrderList), "分包合同不存在");
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      List<ContractProject> projectList = this.projectService
         .listByIds(subcontractOrderList.stream().map(SubcontractOrder::getProjectId).collect(Collectors.toSet()));
      Map<Long, ContractProject> projectMap = projectList.stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      orderIds = subcontractOrderList.stream().map(SubcontractOrder::getId).collect(Collectors.toList());
      List<SupplierPayment> paymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getOrderId, orderIds)
               .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      Map<Long, BigDecimal> paymentAmountMap = paymentList.stream()
         .collect(
            Collectors.groupingBy(SupplierPayment::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add))
         );
      Map<Long, BigDecimal> invoiceAmountMap = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .in(SupplierInvoice::getOrderId, orderIds)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(SupplierInvoice::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierInvoice::getActualInvoiceAmount, BigDecimal::add))
         );
      List<SupplierSelfEmployedDto> invoiceDtoList = new ArrayList<>();
      subcontractOrderList.forEach(
         a -> {
            ContractProject project = projectMap.get(a.getProjectId());
            invoiceDtoList.add(
               SupplierSelfEmployedDto.builder()
                  .orderId(a.getId())
                  .contractSignBodyId(a.getBranchCompanyId())
                  .contractSignBodyName(branchCompanyMap.get(a.getBranchCompanyId()).getName())
                  .purchaseContractNumber(a.getSerialNumber())
                  .paymentAmountSum(paymentAmountMap.getOrDefault(a.getId(), BigDecimal.ZERO))
                  .invoiceAmountSum(invoiceAmountMap.getOrDefault(a.getId(), BigDecimal.ZERO))
                  .contractAmount(a.getAmount())
                  .projectNames(project != null ? project.getName() : "")
                  .build()
            );
         }
      );
      String projectName = projectList.stream().map(ContractProject::getShortName).collect(Collectors.joining("/"));
      List<BankAccount> bankAccountList = this.bankAccountService
         .list(
            Wrappers.lambdaQuery(BankAccount.class)
               .in(BankAccount::getBranchCompanyId, subcontractOrderList.stream().map(SubcontractOrder::getBranchCompanyId).collect(Collectors.toSet()))
         );
      Map<String, String> bankAccountMap = bankAccountList.stream()
         .collect(Collectors.toMap(BankAccount::getDepositBank, BankAccount::getAccount, (s1, s2) -> s2));
      return SelfEmployedPaymentAndFinishDTO.builder().invoiceDto(invoiceDtoList).projectName(projectName).paymentDto(bankAccountMap).build();
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean addSelfOwnedSubcontractPayment(SubOrderPaymentAddDtoParam param) {
      Preconditions.checkArgument(param.getSupplierPayment() != null && param.getSupplierPayment().size() == 1, "仅支持一个订单进行付款!");
      List<Long> orderIds = param.getSupplierPayment().stream().map(saveSupplierPaymentDto::getSupplierPaymentId).collect(Collectors.toList());
      List<SubcontractOrder> orderList = this.subcontractOrderService.listByIds(orderIds);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(orderList), "分包订单不存在!");
      SysSupplierPaymentAttribute paymentAttribute = this.supplierPaymentAttributeService.getById(param.getPaymentAttributeId());
      Preconditions.checkArgument(paymentAttribute != null, "付款属性未创建!");
      Preconditions.checkArgument(paymentAttribute.getBoolEnableStatus(), "付款属性已禁用!");
      Map<Long, BigDecimal> thisPaymentAmountMap = param.getSupplierPayment()
         .stream()
         .collect(Collectors.toMap(saveSupplierPaymentDto::getSupplierPaymentId, saveSupplierPaymentDto::getMoneyAmount));
      Map<Long, BigDecimal> oldPaymentAmountMap = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getOrderId, orderIds)
               .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               SupplierPayment::getOrderId,
               Collectors.reducing(
                  BigDecimal.ZERO,
                  s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getPaymentAmount() : s.getActuallyPaymentAmount(),
                  BigDecimal::add
               )
            )
         );
      List<Long> paymentIds = new ArrayList<>();
      String attachmentIds = CollectionUtils.isNotEmpty(param.getAttachmentId()) ? StringUtils.join(param.getAttachmentId(), ",") : null;
      FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
      orderList.forEach(
         order -> {
            BigDecimal thisPaymentAmount = thisPaymentAmountMap.get(order.getId());
            Preconditions.checkArgument(thisPaymentAmount != null && thisPaymentAmount.compareTo(BigDecimal.ZERO) != 0, "付款额有误!");
            BigDecimal paymentAmount = oldPaymentAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO);
            if (!order.getBoolSettlementStatus()) {
               if (!financeAmountLimitConfig.getBoolAllowOverContractAmount()) {
                  Preconditions.checkArgument(paymentAmount.add(thisPaymentAmount).compareTo(order.getAmount()) <= 0, "付款总额(含未审批)不能大于订单合同额!");
               }

               if (!financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
                  SupplierSettlement settlement = this.supplierSettlementService
                     .getOne(
                        Wrappers.lambdaQuery(SupplierSettlement.class)
                           .eq(SupplierSettlement::getOrderId, order.getId())
                           .eq(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
                           .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
                     );
                  Preconditions.checkArgument(
                     settlement == null || paymentAmount.add(thisPaymentAmount).compareTo(settlement.getAmount()) <= 0, "付款总额(含未审批)不能大于结算申请额!"
                  );
               }
            }

            if (order.getBoolSettlementStatus() && !financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
               Preconditions.checkArgument(paymentAmount.add(thisPaymentAmount).compareTo(order.getSettlementAmount()) <= 0, "付款总额(含未审批)不能大于订单结算额!");
            }

            SupplierPayment payment = new SupplierPayment();
            payment.setOrderId(order.getId());
            payment.setPropertyType(SupplierPropertyTypeEnum.SUB_FEE.getType());
            payment.setBranchCompanyId(order.getBranchCompanyId());
            payment.setPaymentUnitId(order.getBranchCompanyId());
            payment.setSupplierId(order.getSupplierId());
            payment.setAuditStatus(AuditStatusEnum.AUDITING.getType());
            payment.setPaymentDate(LocalDate.from(param.getApplyDate()));
            payment.setPaymentAmount(thisPaymentAmount);
            payment.setApplyAmount(thisPaymentAmount);
            payment.setPaymentAttributeId(param.getPaymentAttributeId());
            payment.setPaymentAttributeName(paymentAttribute.getName());
            payment.setApplyUserId(param.getApplicantId() != null ? param.getApplicantId() : UserUtil.getCurrentUserId());
            payment.setApplyUserName(param.getApplicantId() != null ? this.userService.getNameById(param.getApplicantId()) : UserUtil.getCurrentName());
            payment.setAttachmentIds(attachmentIds);
            payment.setPaymentBank(param.getPaymentBank());
            payment.setPaymentBankAccount(param.getPaymentBankAccount());
            payment.setRemark(param.getRemark());
            this.supplierPaymentService.save(payment);
            paymentIds.add(payment.getId());
         }
      );
      ContractProject project = this.projectService.getById(orderList.get(0).getProjectId());
      ContractAuditLedger contractAuditLedger = new ContractAuditLedger()
         .setAuditType(AuditTypeEnum.SUB_CONTRACT_APPROVE.getType())
         .setProjectAttribute(ProjectAttributeEnum.SELF_SUPPORT.getType())
         .setContractId(StringUtils.join(orderList.stream().map(SubcontractOrder::getId).collect(Collectors.toList()), ","))
         .setPaymentId(StringUtils.join(paymentIds, ","))
         .setPaymentEnum(AuditPaymentEnum.SUBCONTRACT_PAYMENT.getType())
         .setFilingDate(param.getApplyDate())
         .setContractSignBodyId(orderList.get(0).getBranchCompanyId())
         .setProjectId(StringUtils.join(orderList.stream().map(SubcontractOrder::getProjectId).collect(Collectors.toList()), ","))
         .setProjectManagerId(project.getSalesLeaderId() != null ? project.getSalesLeaderId() : project.getSignerId())
         .setInitiatorId(param.getApplicantId() != null ? param.getApplicantId() : UserUtil.getCurrentUserId())
         .setContractNumber(StringUtils.join(orderList.stream().map(SubcontractOrder::getSerialNumber).collect(Collectors.toList()), "/"))
         .setSupplierId(orderList.get(0).getSupplierId())
         .setAuditStatusEnum(AuditStatusEnum.AUDITING.getType())
         .setApplyAmount(param.getSupplierPayment().stream().map(saveSupplierPaymentDto::getMoneyAmount).reduce(BigDecimal.ZERO, BigDecimal::add))
         .setPaymentDate(param.getApplyDate())
         .setAttachmentIds(attachmentIds);
      this.auditLedgerService.save(contractAuditLedger);
      WmsApproveRecord record = this.approvalsService
         .createRecord(
            contractAuditLedger.getId(),
            contractAuditLedger.getContractNumber(),
            ApproveProcessTypeEnumV2.OUTSOURCING_ORDER_PAYMENT_AUDIT.getType(),
            null,
            null,
            null,
            true,
            null,
            null,
            null
         );
      contractAuditLedger.setApproveRecordId(record.getId());
      this.auditLedgerService.updateById(contractAuditLedger);
      return true;
   }

   @Override
   public Map<Long, String> getSubcontractSupplierInfo(Long supplierId, Long projectId, Boolean boolSettleUse) {
      List<SubcontractOrder> subcontractOrders = this.subcontractOrderService
         .list(
            Wrappers.lambdaQuery(SubcontractOrder.class)
               .eq(SubcontractOrder::getSupplierId, supplierId)
               .eq(projectId != null, SubcontractOrder::getProjectId, projectId)
               .eq(boolSettleUse, SubcontractOrder::getBoolSettlementStatus, false)
               .eq(SubcontractOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
               .orderByDesc(SubcontractOrder::getId)
         );
      if (boolSettleUse && CollectionUtils.isNotEmpty(subcontractOrders)) {
         List<Long> auditOrderIds = this.supplierSettlementService
            .list(
               Wrappers.lambdaQuery(SupplierSettlement.class)
                  .in(SupplierSettlement::getOrderId, subcontractOrders.stream().map(SubcontractOrder::getId).collect(Collectors.toList()))
                  .eq(SupplierSettlement::getBoolPreSettlement, false)
                  .eq(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
                  .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
            )
            .stream()
            .map(SupplierSettlement::getOrderId)
            .collect(Collectors.toList());
         subcontractOrders = subcontractOrders.stream().filter(s -> !auditOrderIds.contains(s.getId())).collect(Collectors.toList());
      }

      return subcontractOrders.stream().collect(Collectors.toMap(SubcontractOrder::getId, SubcontractOrder::getSerialNumber));
   }

   @Override
   public List<SupplierJointlyOwnedProjectDto> getProjectByManagerId(Long projectManagerId) {
      List<ContractProject> projectList = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .eq(ContractProject::getProjectManagerId, projectManagerId)
               .apply("project_attribute != {0}", ProjectAttributeEnum.SELF_SUPPORT.getType())
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (projectList.isEmpty()) {
         return null;
      }

      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      List<SupplierJointlyOwnedProjectDto> dto = new ArrayList<>();
      projectList.forEach(
         list -> dto.add(
            SupplierJointlyOwnedProjectDto.builder()
               .project(
                  ProjectInfo.builder()
                     .id(list.getId())
                     .name(list.getName())
                     .shortName(list.getShortName())
                     .serialNumber(list.getSerialNumber())
                     .projectAttribute(list.getProjectAttribute())
                     .build()
               )
               .projectManagerId(list.getProjectManagerId())
               .projectManagerName(userMap.get(list.getProjectManagerId()).getName())
               .projectManagerRatio(list.getProjectManagerScale())
               .signeeId(list.getContractSignBodyId())
               .signeeName(branchCompanyMap.get(list.getContractSignBodyId()).getName())
               .signeeRatio(list.getContractSignBodyScale())
               .build()
         )
      );
      return dto;
   }

   @Override
   public Map<Long, String> getSupplierByManagerIdAndProjectId(Long projectManagerId, Long projectId) {
      HashMap<Long, String> map = new HashMap<>();
      Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .isNotNull(PurchaseOrder::getProjectIds)
               .eq(PurchaseOrder::getProjectManagerId, projectManagerId)
               .apply("project_attribute != {0}", ProjectAttributeEnum.SELF_SUPPORT.getType())
         )
         .stream()
         .filter(order -> Arrays.asList(order.getProjectIds().split(",")).contains(projectId.toString()))
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(orderList)) {
         return null;
      }

      orderList.forEach(order -> map.put(order.getSupplierId(), supplierMap.get(order.getSupplierId()).getShortName()));
      return map;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO addOaSupplierPayment(PurchaseSupplierPaymentInsourcingAddDTOParam param) {
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      PurchaseOrder purchaseOrderOne = this.purchaseOrderService
         .getOne(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .eq(PurchaseOrder::getId, param.getOrderId())
               .in(PurchaseOrder::getProjectAttribute, ProjectAttributeEnum.JOINT_VENTURE.getType(), ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())
         );
      Preconditions.checkArgument(purchaseOrderOne != null, "采购订单不存在!");
      Preconditions.checkArgument(
         purchaseOrderOne.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType())
            && purchaseOrderOne.getDataStatus().equals(DataStatusEnum.SUCCEED.getType()),
         "订单当前状态不允许付款!"
      );
      ContractProject project = this.projectService.getById(Long.valueOf(purchaseOrderOne.getProjectIds()));
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(
         project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())
            || project.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType()),
         "订单所属项目非内包/合营项目!"
      );
      if (purchaseOrderOne.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())) {
         BigDecimal sumAmount = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .eq(SupplierPayment::getOrderId, purchaseOrderOne.getId())
                  .in(
                     SupplierPayment::getPropertyType,
                     SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(),
                     SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
                  )
                  .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getPaymentAmount() : s.getActuallyPaymentAmount())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(sumAmount.add(param.getPaymentAmount()).compareTo(purchaseOrderOne.getSettlementAmount()) <= 0, "付款金额之和不能大于结算额!");
      }

      List<SupplierSettlement> auditingSettlementList = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, param.getOrderId())
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(auditingSettlementList.isEmpty(), "订单正在结算审批中,暂不允许申请付款!");
      SupplierPayment supplierPayment = this.savePayment(param, project, purchaseOrderOne);
      this.deductProjectMoney(project, supplierPayment);
      this.saveAudit(supplierPayment, param, project, purchaseOrderOne);
      ContractAuditLedger audit = new ContractAuditLedger()
         .setAuditType(AuditTypeEnum.PAYMENT_APPROVE.getType())
         .setProjectAttribute(project.getProjectAttribute())
         .setContractId(purchaseOrderOne.getId().toString())
         .setPaymentId(supplierPayment.getId().toString())
         .setContractSignBodyId(purchaseOrderOne.getBranchCompanyId())
         .setPaymentEnum(AuditPaymentEnum.PROCUREMENT_PAYMENT.getType())
         .setFilingDate(param.getApplyDate())
         .setInitiatorId(param.getApplicantId() != null ? param.getApplicantId() : UserUtil.getCurrentUserId())
         .setContractNumber(purchaseOrderOne.getSerialNumber())
         .setProjectId(project.getId().toString())
         .setProjectManagerId(project.getProjectManagerId() != null ? project.getProjectManagerId() : null)
         .setSupplierId(param.getSupplierId())
         .setApplyAmount(param.getPaymentAmount())
         .setAuditStatusEnum(AuditStatusEnum.AUDITING.getType())
         .setAttachmentIds(supplierPayment.getAttachmentIds());
      audit.setBoolDeleteEnum(Boolean.TRUE);
      this.auditLedgerService.save(audit);
      build.setCode(20000L);
      build.setData(audit.getId());
      return build;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean addSupplierPayment(PurchaseSupplierPaymentInsourcingAddDTOParam param) {
      PurchaseOrder purchaseOrderOne = this.purchaseOrderService
         .getOne(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .eq(PurchaseOrder::getId, param.getOrderId())
               .in(PurchaseOrder::getProjectAttribute, ProjectAttributeEnum.JOINT_VENTURE.getType(), ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())
         );
      Preconditions.checkArgument(purchaseOrderOne != null, "采购订单不存在!");
      Preconditions.checkArgument(
         purchaseOrderOne.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType())
            && purchaseOrderOne.getDataStatus().equals(DataStatusEnum.SUCCEED.getType()),
         "订单当前状态不允许付款!"
      );
      ContractProject project = this.projectService.getById(Long.valueOf(purchaseOrderOne.getProjectIds()));
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(
         project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())
            || project.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType()),
         "订单所属项目非内包/合营项目!"
      );
      if (purchaseOrderOne.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())) {
         BigDecimal sumAmount = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .eq(SupplierPayment::getOrderId, purchaseOrderOne.getId())
                  .in(
                     SupplierPayment::getPropertyType,
                     SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(),
                     SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
                  )
                  .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getPaymentAmount() : s.getActuallyPaymentAmount())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(sumAmount.add(param.getPaymentAmount()).compareTo(purchaseOrderOne.getSettlementAmount()) <= 0, "付款金额之和不能大于结算额!");
      }

      List<SupplierSettlement> auditingSettlementList = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, param.getOrderId())
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(auditingSettlementList.isEmpty(), "订单正在结算审批中,暂不允许申请付款!");
      SupplierPayment supplierPayment = this.savePayment(param, project, purchaseOrderOne);
      this.deductProjectMoney(project, supplierPayment);
      this.saveAudit(supplierPayment, param, project, purchaseOrderOne);
      return true;
   }

   @Override
   public void deductProjectMoney(ContractProject project, SupplierPayment supplierPayment) {
      if (project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
         this.deductContractSignBody(project, supplierPayment);
         this.deductProjectManager(project, supplierPayment);
      }

      if (project.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
         this.deductProjectManager(project, supplierPayment);
      }

      this.projectService.updateById(project);
   }

   private void deductContractSignBody(ContractProject project, SupplierPayment supplierPayment) {
      BigDecimal amount = supplierPayment.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType())
         ? supplierPayment.getPaymentAmount()
         : supplierPayment.getActuallyPaymentAmount();
      BigDecimal branchCompanyPaymentAmount = amount.multiply(project.getContractSignBodyScale()).divide(BigDecimal.valueOf(100L), 4, RoundingMode.HALF_UP);
      Preconditions.checkArgument(project.getContractSignBodyAmount().compareTo(branchCompanyPaymentAmount) >= 0, "合同签订主体账户额度不足!");
      if (project.getContractSignBodyCollectBalance().compareTo(branchCompanyPaymentAmount) >= 0) {
         this.saveCollectionDisburse(
            branchCompanyPaymentAmount,
            project.getId(),
            AssetTypeEnum.COMPANY_INJECTION.getType(),
            project.getContractSignBodyId(),
            project.getId(),
            supplierPayment
         );
         project.setContractSignBodyCollectBalance(project.getContractSignBodyCollectBalance().subtract(branchCompanyPaymentAmount));
      } else if (project.getContractSignBodyCollectBalance().compareTo(BigDecimal.ZERO) == 0) {
         this.saveAssetInjection(AssetTypeEnum.COMPANY_INJECTION.getType(), branchCompanyPaymentAmount, supplierPayment);
         project.setContractSignBodyInjectionBalance(project.getContractSignBodyInjectionBalance().subtract(branchCompanyPaymentAmount));
      } else {
         this.saveCollectionDisburse(
            project.getContractSignBodyCollectBalance(),
            project.getId(),
            AssetTypeEnum.COMPANY_INJECTION.getType(),
            project.getContractSignBodyId(),
            project.getId(),
            supplierPayment
         );
         BigDecimal reduceInjectionAmount = branchCompanyPaymentAmount.subtract(project.getContractSignBodyCollectBalance());
         this.saveAssetInjection(AssetTypeEnum.COMPANY_INJECTION.getType(), reduceInjectionAmount, supplierPayment);
         project.setContractSignBodyCollectBalance(BigDecimal.ZERO);
         project.setContractSignBodyInjectionBalance(project.getContractSignBodyInjectionBalance().subtract(reduceInjectionAmount));
      }

      project.setContractSignBodyAmount(project.getContractSignBodyAmount().subtract(branchCompanyPaymentAmount));
      project.setCollectionSummary(project.getCollectionSummary().subtract(branchCompanyPaymentAmount));
   }

   private void deductProjectManager(ContractProject project, SupplierPayment supplierPayment) {
      BigDecimal totalAmount = supplierPayment.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType())
         ? supplierPayment.getPaymentAmount()
         : supplierPayment.getActuallyPaymentAmount();
      BigDecimal projectManagerPaymentAmount = totalAmount.multiply(project.getProjectManagerScale()).divide(BigDecimal.valueOf(100L), 4, RoundingMode.HALF_UP);
      if (project.getProjectManagerAmount().compareTo(projectManagerPaymentAmount) >= 0) {
         if (project.getProjectManagerCollectBalance().compareTo(projectManagerPaymentAmount) >= 0) {
            this.saveCollectionDisburse(
               projectManagerPaymentAmount,
               project.getId(),
               AssetTypeEnum.MANAGER_INJECTION.getType(),
               project.getProjectManagerId(),
               project.getId(),
               supplierPayment
            );
            project.setProjectManagerCollectBalance(project.getProjectManagerCollectBalance().subtract(projectManagerPaymentAmount));
         } else if (project.getProjectManagerCollectBalance().compareTo(BigDecimal.ZERO) == 0) {
            this.saveAssetInjection(AssetTypeEnum.MANAGER_INJECTION.getType(), projectManagerPaymentAmount, supplierPayment);
            project.setProjectManagerInjectionBalance(project.getProjectManagerInjectionBalance().subtract(projectManagerPaymentAmount));
         } else {
            this.saveCollectionDisburse(
               project.getProjectManagerCollectBalance(),
               project.getId(),
               AssetTypeEnum.MANAGER_INJECTION.getType(),
               project.getProjectManagerId(),
               project.getId(),
               supplierPayment
            );
            BigDecimal reduceInjectionAmount = projectManagerPaymentAmount.subtract(project.getProjectManagerCollectBalance());
            this.saveAssetInjection(AssetTypeEnum.MANAGER_INJECTION.getType(), reduceInjectionAmount, supplierPayment);
            project.setProjectManagerCollectBalance(BigDecimal.ZERO);
            project.setProjectManagerInjectionBalance(project.getProjectManagerInjectionBalance().subtract(reduceInjectionAmount));
         }

         project.setProjectManagerAmount(project.getProjectManagerAmount().subtract(projectManagerPaymentAmount));
         project.setCollectionSummary(project.getCollectionSummary().subtract(projectManagerPaymentAmount));
      }

      if (project.getProjectManagerAmount().compareTo(projectManagerPaymentAmount) < 0) {
         List<ContractProject> otherProjectList = Collections.emptyList();
         if (project.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
            otherProjectList = this.projectService
               .list(
                  Wrappers.lambdaQuery(ContractProject.class)
                     .eq(ContractProject::getProjectAttribute, ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())
                     .eq(ContractProject::getProjectManagerId, project.getProjectManagerId())
                     .ne(ContractProject::getId, project.getId())
                     .orderByDesc(ContractProject::getProjectManagerCollectBalance)
               );
         }

         BigDecimal otherProjectCollectionBalance = otherProjectList.stream()
            .map(ContractProject::getProjectManagerCollectBalance)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         ContractGivingCredit givingCredit = this.givingCreditService
            .getOne(
               Wrappers.lambdaQuery(ContractGivingCredit.class)
                  .eq(ContractGivingCredit::getProjectId, supplierPayment.getProjectId())
                  .eq(ContractGivingCredit::getStatus, StatusEnum.ENABLED.getType())
                  .lt(ContractGivingCredit::getStartDate, LocalDate.now().plusDays(1L).atStartOfDay())
                  .ge(ContractGivingCredit::getClosingDate, LocalDate.now().atStartOfDay())
            );
         BigDecimal remainingSum = givingCredit != null ? givingCredit.getRemainingSum() : BigDecimal.ZERO;
         Preconditions.checkArgument(
            project.getProjectManagerAmount().add(otherProjectCollectionBalance).add(remainingSum).compareTo(projectManagerPaymentAmount) >= 0,
            "项目经理可用额度,不足支付金额!"
         );
         if (project.getProjectManagerCollectBalance().compareTo(BigDecimal.ZERO) > 0) {
            this.saveCollectionDisburse(
               project.getProjectManagerCollectBalance(),
               project.getId(),
               AssetTypeEnum.MANAGER_INJECTION.getType(),
               project.getProjectManagerId(),
               project.getId(),
               supplierPayment
            );
         }

         if (project.getProjectManagerInjectionBalance().compareTo(BigDecimal.ZERO) > 0) {
            this.saveAssetInjection(AssetTypeEnum.MANAGER_INJECTION.getType(), project.getProjectManagerInjectionBalance(), supplierPayment);
         }

         project.setCollectionSummary(project.getCollectionSummary().subtract(project.getProjectManagerAmount()));
         project.setProjectManagerCollectBalance(BigDecimal.ZERO);
         project.setProjectManagerInjectionBalance(BigDecimal.ZERO);
         project.setProjectManagerAmount(BigDecimal.ZERO);
         BigDecimal missingAmount = projectManagerPaymentAmount.subtract(project.getProjectManagerAmount());
         if (otherProjectCollectionBalance.compareTo(BigDecimal.ZERO) > 0) {
            for (ContractProject otherProject : otherProjectList) {
               if (missingAmount.compareTo(BigDecimal.ZERO) > 0) {
                  BigDecimal useAmount;
                  if (otherProject.getProjectManagerCollectBalance().compareTo(missingAmount) >= 0) {
                     useAmount = missingAmount;
                     otherProject.setProjectManagerCollectBalance(otherProject.getProjectManagerCollectBalance().subtract(missingAmount));
                     otherProject.setProjectManagerAmount(otherProject.getProjectManagerAmount().subtract(missingAmount));
                     otherProject.setCollectionSummary(otherProject.getCollectionSummary().subtract(missingAmount));
                     missingAmount = BigDecimal.ZERO;
                  } else {
                     useAmount = otherProject.getProjectManagerCollectBalance();
                     otherProject.setProjectManagerCollectBalance(BigDecimal.ZERO);
                     otherProject.setProjectManagerAmount(otherProject.getProjectManagerAmount().subtract(otherProject.getProjectManagerCollectBalance()));
                     otherProject.setCollectionSummary(otherProject.getCollectionSummary().subtract(otherProject.getProjectManagerCollectBalance()));
                     missingAmount = missingAmount.subtract(otherProject.getProjectManagerCollectBalance());
                  }

                  this.saveCollectionDisburse(
                     useAmount,
                     project.getId(),
                     AssetTypeEnum.MANAGER_INJECTION.getType(),
                     project.getProjectManagerId(),
                     otherProject.getId(),
                     supplierPayment
                  );
                  this.projectService.updateById(otherProject);
               }
            }
         }

         if (missingAmount.compareTo(BigDecimal.ZERO) > 0 && givingCredit != null) {
            this.saveGivingCredit(givingCredit, supplierPayment, missingAmount);
         }
      }
   }

   private void saveCollectionDisburse(
      BigDecimal useAmount, Long projectId, Integer assetType, Long assetOwnerId, Long paymentProjectId, SupplierPayment supplierPayment
   ) {
      ContractCollectionDisburse collectionDisburse = ContractCollectionDisburse.builder()
         .projectId(projectId)
         .assetType(assetType)
         .assetOwnerId(assetOwnerId)
         .useAmount(useAmount)
         .paymentId(supplierPayment.getId())
         .paymentProjectId(paymentProjectId)
         .userId(supplierPayment.getApplyUserId())
         .auditStatus(supplierPayment.getAuditStatus())
         .build();
      this.contractCollectionDisburseService.save(collectionDisburse);
   }

   private void saveAssetInjection(Integer assetType, BigDecimal assetAmount, SupplierPayment supplierPayment) {
      ContractProjectAssetInjection assetInjection = ContractProjectAssetInjection.builder()
         .assetInjectionTime(LocalDateTime.now())
         .assetType(assetType)
         .assetAmount(assetAmount)
         .projectId(supplierPayment.getProjectId())
         .assetOwnerId(
            assetType.equals(AssetTypeEnum.COMPANY_INJECTION.getType()) ? supplierPayment.getBranchCompanyId() : supplierPayment.getProjectManagerId()
         )
         .incomeOrDisburse(false)
         .paymentId(supplierPayment.getId())
         .creatorUserId(supplierPayment.getApplyUserId())
         .userId(UserUtil.getCurrentUserId())
         .auditStatus(supplierPayment.getAuditStatus())
         .build();
      this.assetInjectionService.save(assetInjection);
   }

   private void saveGivingCredit(ContractGivingCredit givingCredit, SupplierPayment supplierPayment, BigDecimal useAmount) {
      ContractGivingCreditDetail givingCreditDetail = ContractGivingCreditDetail.builder()
         .userId(supplierPayment.getApplyUserId())
         .creditId(givingCredit.getId())
         .projectId(givingCredit.getProjectId())
         .orderId(supplierPayment.getOrderId())
         .supplierPaymentId(supplierPayment.getId())
         .useDate(LocalDateTime.now())
         .useAmount(useAmount)
         .annualInterest(givingCredit.getAnnualInterest())
         .monthlyInterest(givingCredit.getMonthlyInterest())
         .dayInterest(givingCredit.getDayInterest())
         .paymentReasonId(supplierPayment.getPaymentReasonId())
         .auditStatus(supplierPayment.getAuditStatus())
         .build();
      this.givingCreditDetailService.save(givingCreditDetail);
      givingCredit.setUsedCredit(givingCredit.getUsedCredit().add(useAmount));
      givingCredit.setRemainingSum(givingCredit.getRemainingSum().subtract(useAmount));
      this.givingCreditService.updateById(givingCredit);
   }

   private SupplierPayment savePayment(PurchaseSupplierPaymentInsourcingAddDTOParam param, ContractProject project, PurchaseOrder purchaseOrderOne) {
      SupplierPayment payment = BeanUtil.copy(param, SupplierPayment.class);
      if (param.getAttachmentId() != null) {
         payment.setAttachmentIds(StringUtils.join(param.getAttachmentId(), ","));
      }

      payment.setOrderId(purchaseOrderOne.getId());
      payment.setProjectId(payment.getProjectId());
      payment.setProjectAttribute(project.getProjectAttribute());
      payment.setPropertyType(
         purchaseOrderOne.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())
            ? SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType()
            : SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
      );
      payment.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      payment.setPaymentDate(LocalDate.from(param.getApplyDate()));
      payment.setBranchCompanyId(purchaseOrderOne.getBranchCompanyId());
      payment.setSupplierId(purchaseOrderOne.getSupplierId());
      payment.setPaymentUnitId(project.getContractSignBodyId());
      payment.setApplyAmount(param.getPaymentAmount());
      payment.setApplyUserId(param.getApplicantId() != null ? param.getApplicantId() : UserUtil.getCurrentUserId());
      payment.setRemark(param.getRemark());
      payment.setPaymentBank(param.getPaymentBank());
      payment.setPaymentAmount(param.getPaymentAmount());
      payment.setAttachmentIds(param.getAttachmentId() != null ? String.valueOf(param.getAttachmentId()) : null);
      this.supplierPaymentService.save(payment);
      return payment;
   }

   private void saveAudit(
      SupplierPayment supplierPayment, PurchaseSupplierPaymentInsourcingAddDTOParam param, ContractProject project, PurchaseOrder purchaseOrderOne
   ) {
      ContractAuditLedger audit = new ContractAuditLedger()
         .setAuditType(AuditTypeEnum.PAYMENT_APPROVE.getType())
         .setProjectAttribute(project.getProjectAttribute())
         .setContractId(purchaseOrderOne.getId().toString())
         .setPaymentId(supplierPayment.getId().toString())
         .setContractSignBodyId(purchaseOrderOne.getBranchCompanyId())
         .setPaymentEnum(AuditPaymentEnum.PROCUREMENT_PAYMENT.getType())
         .setFilingDate(param.getApplyDate())
         .setInitiatorId(param.getApplicantId() != null ? param.getApplicantId() : UserUtil.getCurrentUserId())
         .setContractNumber(purchaseOrderOne.getSerialNumber())
         .setProjectId(project.getId().toString())
         .setProjectManagerId(project.getProjectManagerId() != null ? project.getProjectManagerId() : null)
         .setSupplierId(param.getSupplierId())
         .setApplyAmount(param.getPaymentAmount())
         .setAuditStatusEnum(AuditStatusEnum.AUDITING.getType())
         .setAttachmentIds(supplierPayment.getAttachmentIds());
      this.auditLedgerService.save(audit);
      WmsApproveRecord record = this.approvalsService
         .createRecord(
            audit.getId(), audit.getContractNumber(), ApproveProcessTypeEnumV2.INNER_PACKAGE_PAYMENT_AUDIT.getType(), null, null, null, true, null, null, null
         );
      audit.setApproveRecordId(record.getId());
      this.auditLedgerService.updateById(audit);
      List<WmsApproveRecordDetail> one = this.approvalsDetailService
         .list(Wrappers.lambdaQuery(WmsApproveRecordDetail.class).eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, record.getSerialNumber()));
      List<WmsApproveRecordDetail> collect = one.stream().filter(a -> a.getStatus().equals(AuditStatusEnum.SUCCEED.getType())).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(collect)) {
         WmsApproveRecordDetail detail = collect.get(0);
         detail.setOpinion(param.getRemark());
         this.approvalsDetailService.updateById(detail);
      }
   }

   @Override
   public Map<String, BigDecimal> assetInjectionCheck(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      List<ContractProjectAssetInjection> assetInjectionList = this.assetInjectionService
         .list(Wrappers.lambdaQuery(ContractProjectAssetInjection.class).eq(ContractProjectAssetInjection::getProjectId, projectId));
      Map<String, BigDecimal> map = new HashMap<>();
      map.put("projectManager", BigDecimal.ZERO);
      map.put("contractSignBody", BigDecimal.ZERO);
      if (CollectionUtils.isNotEmpty(assetInjectionList)) {
         BigDecimal projectManagerScale = assetInjectionList.stream()
            .filter(a -> ObjectUtils.isNotNull(a.getProjectManagerId()))
            .filter(a -> a.getIncomeOrDisburse().equals(Boolean.TRUE))
            .filter(a -> a.getProjectManagerId().equals(project.getProjectManagerId()))
            .map(ContractProjectAssetInjection::getProjectManagerScale)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal projectManagerScaleDisburse = assetInjectionList.stream()
            .filter(a -> ObjectUtils.isNotNull(a.getProjectManagerId()))
            .filter(a -> a.getIncomeOrDisburse().equals(Boolean.FALSE))
            .filter(a -> a.getProjectManagerId().equals(project.getProjectManagerId()))
            .filter(a -> ObjectUtils.isNotEmpty(a.getProjectManagerScale()))
            .map(ContractProjectAssetInjection::getProjectManagerScale)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal projectManager = projectManagerScale.subtract(projectManagerScaleDisburse);
         map.put("projectManager", ObjectUtils.isNotNull(projectManager) ? projectManager : BigDecimal.ZERO);
         if (project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
            BigDecimal contractSignBodyScale = assetInjectionList.stream()
               .filter(a -> ObjectUtils.isNotNull(a.getContractSignBodyId()))
               .filter(a -> a.getIncomeOrDisburse().equals(Boolean.TRUE))
               .filter(a -> a.getContractSignBodyId().equals(project.getContractSignBodyId()))
               .map(ContractProjectAssetInjection::getContractSignBodyScale)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal contractSignBodyScaleDisburse = assetInjectionList.stream()
               .filter(a -> ObjectUtils.isNotNull(a.getContractSignBodyId()))
               .filter(a -> a.getIncomeOrDisburse().equals(Boolean.FALSE))
               .filter(a -> a.getContractSignBodyId().equals(project.getContractSignBodyId()))
               .filter(a -> ObjectUtils.isNotEmpty(a.getContractSignBodyScale()))
               .map(ContractProjectAssetInjection::getContractSignBodyScale)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal contractSignBody = contractSignBodyScale.subtract(contractSignBodyScaleDisburse);
            map.put("contractSignBody", ObjectUtils.isNotEmpty(contractSignBody) ? contractSignBody : BigDecimal.ZERO);
         }

         return map;
      } else {
         return map;
      }
   }

   private void saveMoneyInterests(Long projectManagerId, Long projectId, BigDecimal amountPaid) {
      List<ContractProjectManagerMoneyInterests> moneyInterestsList = this.moneyInterestsService
         .list(Wrappers.lambdaQuery(ContractProjectManagerMoneyInterests.class).eq(ContractProjectManagerMoneyInterests::getProjectManagerId, projectManagerId));
      moneyInterestsList.sort(Comparator.<ContractProjectManagerMoneyInterests, java.time.LocalDateTime>comparing(BaseEntity::getCreateTime).reversed());
      if (moneyInterestsList.isEmpty()) {
         ContractProjectManagerMoneyInterests interests = ContractProjectManagerMoneyInterests.builder()
            .userId(UserUtil.getCurrentUserId())
            .projectManagerId(projectManagerId)
            .expenditure(amountPaid)
            .remainingSum(BigDecimal.ZERO.subtract(amountPaid))
            .projectId(projectId)
            .liabilities(amountPaid)
            .build();
         this.moneyInterestsService.save(interests);
      } else {
         ContractProjectManagerMoneyInterests interestsCopy = BeanUtil.copy(moneyInterestsList.get(0), ContractProjectManagerMoneyInterests.class);
         ContractProjectManagerMoneyInterests interests = ContractProjectManagerMoneyInterests.builder()
            .userId(UserUtil.getCurrentUserId())
            .projectManagerId(projectManagerId)
            .expenditure(amountPaid)
            .projectId(projectId)
            .build();
         if (interestsCopy.getRemainingSum().compareTo(amountPaid) >= 0) {
            interests.setRemainingSum(interestsCopy.getRemainingSum().subtract(amountPaid));
            this.moneyInterestsService.save(interests);
         } else {
            if (interestsCopy.getRemainingSum().compareTo(BigDecimal.ZERO) > 0) {
               interests.setRemainingSum(interestsCopy.getRemainingSum().subtract(amountPaid));
               interests.setLiabilities(amountPaid.add(interestsCopy.getLiabilities()));
            } else {
               interests.setLiabilities(amountPaid.subtract(interestsCopy.getRemainingSum()));
               interests.setRemainingSum(interestsCopy.getRemainingSum().subtract(amountPaid));
            }

            interestsCopy.setLiabilitiesDay((int)ChronoUnit.DAYS.between(interestsCopy.getCreateTime(), LocalDateTime.now().plusDays(1L)));
            if (interestsCopy.getLiabilities() != null && !interestsCopy.getLiabilities().equals(BigDecimal.ZERO)) {
               interestsCopy.setDailyAmount(interestsCopy.getLiabilities().multiply(BigDecimal.valueOf(interestsCopy.getLiabilitiesDay().intValue())));
            }

            this.moneyInterestsService.updateById(interestsCopy);
            this.moneyInterestsService.save(interests);
         }
      }
   }

   @Override
   public Map<Long, String> getSupplierNumber(Long projectManagerId, Long projectId, Long supplierId) {
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .eq(PurchaseOrder::getSupplierId, supplierId)
               .eq(PurchaseOrder::getProjectManagerId, projectManagerId)
               .eq(PurchaseOrder::getProjectIds, String.valueOf(projectId))
         );
      return orderList.stream().collect(Collectors.toMap(PurchaseOrder::getId, PurchaseOrder::getSerialNumber));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean addPacketsPayment(PurchaseSupplierPaymentInsourcingAddDTOParam param) {
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(project), "项目不存在");
      SubcontractOrder order = this.subcontractOrderService
         .getOne(
            Wrappers.lambdaQuery(SubcontractOrder.class)
               .eq(SubcontractOrder::getId, param.getOrderId())
               .eq(SubcontractOrder::getSupplierId, param.getSupplierId())
               .ne(SubcontractOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
         );
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(order), "分包合同不存在");
      if (order.getBoolSettlementStatus()) {
         List<SupplierPayment> paymentList = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .eq(SupplierPayment::getOrderId, order.getId())
                  .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                  .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            );
         BigDecimal paymentAmount = paymentList.stream()
            .map(SupplierPayment::getPaymentAmount)
            .filter(ObjectUtils::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(paymentAmount.add(param.getPaymentAmount()).compareTo(order.getSettlementAmount()) <= 0, "付款金额(含未审批)不能大于结算额!");
      }

      SupplierPayment payment = BeanUtil.copy(param, SupplierPayment.class);
      if (ObjectUtils.isNotEmpty(param.getAttachmentId())) {
         payment.setAttachmentIds(param.getAttachmentId().toString());
      }

      payment.setOrderId(param.getOrderId());
      payment.setProjectId(param.getProjectId());
      payment.setProjectManagerId(param.getProjectManagerId());
      payment.setProjectAttribute(project.getProjectAttribute());
      payment.setPropertyType(SupplierPropertyTypeEnum.SUB_FEE.getType());
      payment.setBranchCompanyId(order.getBranchCompanyId());
      payment.setSupplierId(order.getSupplierId());
      payment.setPaymentUnitId(order.getBranchCompanyId());
      payment.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      payment.setPaymentDate(LocalDate.from(param.getApplyDate()));
      payment.setApplyAmount(param.getPaymentAmount());
      payment.setApplyUserId(UserUtil.getCurrentUserId());
      payment.setRemark(param.getRemark());
      payment.setPaymentBank(param.getPaymentBank());
      payment.setPaymentAmount(param.getPaymentAmount());
      this.supplierPaymentService.save(payment);
      this.deductProjectMoney(project, payment);
      ContractAuditLedger audit = new ContractAuditLedger()
         .setAuditType(AuditTypeEnum.SUB_CONTRACT_APPROVE.getType())
         .setProjectAttribute(project.getProjectAttribute())
         .setContractId(order.getId().toString())
         .setPaymentId(payment.getId().toString())
         .setContractSignBodyId(order.getBranchCompanyId())
         .setPaymentEnum(AuditPaymentEnum.SUBCONTRACT_PAYMENT.getType())
         .setFilingDate(param.getApplyDate())
         .setInitiatorId(param.getApplicantId() != null ? param.getApplicantId() : UserUtil.getCurrentUserId())
         .setContractNumber(order.getSerialNumber())
         .setProjectId(project.getId().toString())
         .setProjectManagerId(project.getProjectManagerId() != null ? project.getProjectManagerId() : null)
         .setSupplierId(param.getSupplierId())
         .setApplyAmount(param.getPaymentAmount())
         .setAuditStatusEnum(AuditStatusEnum.AUDITING.getType());
      this.auditLedgerService.save(audit);
      WmsApproveRecord record = this.approvalsService
         .createRecord(
            audit.getId(),
            audit.getContractNumber(),
            ApproveProcessTypeEnumV2.OUTSOURCING_ORDER_PAYMENT_AUDIT.getType(),
            null,
            null,
            null,
            true,
            null,
            null,
            null
         );
      audit.setApproveRecordId(record.getId());
      this.auditLedgerService.updateById(audit);
      List<WmsApproveRecordDetail> one = this.approvalsDetailService
         .list(Wrappers.lambdaQuery(WmsApproveRecordDetail.class).eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, record.getSerialNumber()));
      List<WmsApproveRecordDetail> collect = one.stream().filter(b -> b.getStatus().equals(AuditStatusEnum.SUCCEED.getType())).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(collect)) {
         WmsApproveRecordDetail detail = collect.get(0);
         detail.setOpinion(param.getRemark());
         this.approvalsDetailService.updateById(detail);
      }

      return Boolean.TRUE;
   }

   public void amountCheck(PurchaseSupplierPaymentInsourcingAddDTOParam param, ContractProject project) {
      Long supplierId = param.getSupplierId();
      if (param.getPaymentEnum().equals(AuditPaymentEnum.PROCUREMENT_PAYMENT.getType())) {
         PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(param.getOrderId());
         Preconditions.checkArgument(ObjectUtils.isNotEmpty(purchaseOrder), "采购合同不存在");
         supplierId = purchaseOrder.getSupplierId();
      } else {
         SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(param.getOrderId());
         Preconditions.checkArgument(ObjectUtils.isNotEmpty(subcontractOrder), "采购合同不存在");
         supplierId = subcontractOrder.getSupplierId();
      }

      ContractGivingCredit givingCredit = this.givingCreditService
         .getOne(
            Wrappers.lambdaQuery(ContractGivingCredit.class)
               .eq(ContractGivingCredit::getAccreditingPartyId, param.getProjectManagerId())
               .eq(ContractGivingCredit::getStatus, 0)
               .apply("date_format(closing_date,'%Y-%m-%d') >= date_format({0},'%Y-%m-%d')", LocalDateTime.now())
         );
      List<ContractProject> projectManagerCollectionSummary = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .eq(ContractProject::getProjectManagerId, param.getProjectManagerId())
               .eq(ContractProject::getProjectAttribute, ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())
               .apply("project_attribute != {0}", ProjectAttributeEnum.SELF_SUPPORT.getType())
         );
      BigDecimal paymentAmount = param.getPaymentAmount();
      BigDecimal payment = BigDecimal.ZERO;
      BigDecimal collectionSummary = BigDecimal.ZERO;
      if (project.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
         collectionSummary = project.getCollectionSummary();
         if (project.getCollectionSummary().compareTo(BigDecimal.ZERO) >= 0) {
            if (project.getCollectionSummary().compareTo(paymentAmount) >= 0) {
               payment = paymentAmount;
               project.setCollectionSummary(project.getCollectionSummary().subtract(paymentAmount));
               paymentAmount = BigDecimal.ZERO;
            } else {
               payment = project.getCollectionSummary();
               paymentAmount = paymentAmount.subtract(project.getCollectionSummary());
               project.setCollectionSummary(BigDecimal.ZERO);
            }

            this.projectService.updateById(project);
         }
      }

      if (project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
         this.jointVenturePayment(param, project, paymentAmount, givingCredit);
      } else if (project.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
         List<ContractProject> projectList = projectManagerCollectionSummary.stream()
            .filter(b -> !b.getId().equals(param.getProjectId()))
            .filter(b -> b.getCollectionSummary() != null)
            .collect(Collectors.toList());
         List<ContractProject> list = projectList.stream()
            .sorted(Comparator.comparing(ContractProject::getCollectionSummary).reversed())
            .collect(Collectors.toList());
         if (paymentAmount.compareTo(BigDecimal.ZERO) > 0) {
            Map<String, BigDecimal> decimalMap = this.assetInjectionCheck(project.getId());
            if (ObjectUtils.isNotEmpty(decimalMap) && decimalMap.get("projectManager").compareTo(BigDecimal.ZERO) > 0) {
               BigDecimal projectManager = decimalMap.get("projectManager");
               ContractProjectAssetInjection saveInjection = ContractProjectAssetInjection.builder()
                  .assetInjectionTime(LocalDateTime.now())
                  .collectionDepositBank(param.getPaymentBank())
                  .projectId(project.getId())
                  .assetInjectionEnum(param.getPaymentReasonId())
                  .paymentId(param.getPaymentId())
                  .incomeOrDisburse(Boolean.FALSE)
                  .remark(this.supplierService.getById(supplierId).getShortName())
                  .build();

               try {
                  Object number = this.redisUtils.get("supplierPaymentNumber");
                  if (ObjectUtils.isEmpty(number)) {
                     this.projectSerialNumberUtils.redisSaveSerialNumber();
                     number = this.redisUtils.get("supplierPaymentNumber");
                  }

                  String supplierPaymentNumber = this.projectSerialNumberUtils.dateUtil(number.toString());
                  saveInjection.setVoucherNumber("Z" + supplierPaymentNumber);
                  this.redisUtils.incr("supplierPaymentNumber", 1L);
               } catch (Exception e) {
                  throw new IllegalArgumentException("获取流水号失败");
               }

               this.projectManagerInjection(param, project, paymentAmount.compareTo(projectManager) > 0 ? projectManager : paymentAmount, saveInjection);
               payment = paymentAmount.compareTo(projectManager) > 0 ? payment.add(projectManager) : payment.add(paymentAmount);
               paymentAmount = projectManager.compareTo(paymentAmount) >= 0 ? BigDecimal.ZERO : paymentAmount.subtract(projectManager);
            }
         }

         if (paymentAmount.compareTo(BigDecimal.ZERO) > 0) {
            for (ContractProject amount : list) {
               if (paymentAmount.compareTo(BigDecimal.ZERO) != 0) {
                  ContractProjectManagerMoneyInterests build = ContractProjectManagerMoneyInterests.builder()
                     .projectId(amount.getId())
                     .projectManagerId(amount.getProjectManagerId())
                     .build();
                  Map<String, BigDecimal> decimalMap = this.assetInjectionCheck(amount.getId());
                  if (amount.getCollectionSummary().compareTo(paymentAmount) >= 0) {
                     amount.setCollectionSummary(amount.getCollectionSummary().subtract(paymentAmount));
                     this.saveDiscount(amount.getId(), param, amount.getCollectionSummary().subtract(paymentAmount));
                     build.setExpenditure(paymentAmount);
                     build.setRemainingSum(amount.getCollectionSummary().add(decimalMap.get("projectManager")));
                     paymentAmount = BigDecimal.ZERO;
                     this.moneyInterestsService.save(build);
                  } else if (amount.getCollectionSummary().compareTo(BigDecimal.ZERO) > 0) {
                     build.setExpenditure(amount.getCollectionSummary());
                     build.setRemainingSum(decimalMap.get("projectManager"));
                     paymentAmount = paymentAmount.subtract(amount.getCollectionSummary());
                     this.saveDiscount(amount.getId(), param, amount.getCollectionSummary());
                     amount.setCollectionSummary(BigDecimal.ZERO);
                     this.moneyInterestsService.save(build);
                  }

                  this.projectService.updateById(amount);
               }
            }
         }

         if (paymentAmount.compareTo(BigDecimal.ZERO) > 0) {
            if (project.getCollectionSummary().compareTo(BigDecimal.ZERO) < 0) {
               Preconditions.checkArgument(givingCredit.getRemainingSum().add(project.getCollectionSummary()).compareTo(paymentAmount) >= 0, "授信余额不足");
            }

            Preconditions.checkArgument(ObjectUtils.isNotEmpty(givingCredit), "该项目没有授信");
            Preconditions.checkArgument(givingCredit.getRemainingSum().compareTo(paymentAmount) >= 0, "该项目授信余额不足");
            payment = payment.add(paymentAmount);
            givingCredit.setRemainingSum(givingCredit.getRemainingSum().subtract(paymentAmount));
            this.givingCreditService.updateById(givingCredit);
            this.givingCreditDetailService
               .save(
                  new ContractGivingCreditDetail()
                     .setPaymentReasonId(param.getPaymentReasonId())
                     .setUseAmount(paymentAmount)
                     .setCreditId(givingCredit.getId())
                     .setProjectId(project.getId())
                     .setPurchaseId(param.getOrderId())
                     .setUserId(UserUtil.getCurrentUserId())
               );
            this.interestOnFunds(param, paymentAmount, payment);
         } else if (collectionSummary.compareTo(project.getCollectionSummary()) != 0) {
            this.interestOnFunds(param, BigDecimal.ZERO, payment);
         }
      }
   }

   private void jointVenturePayment(
      PurchaseSupplierPaymentInsourcingAddDTOParam param, ContractProject project, BigDecimal paymentAmount, ContractGivingCredit givingCredit
   ) {
      Map<String, BigDecimal> decimalMap = this.assetInjectionCheck(project.getId());
      BigDecimal amount = paymentAmount;
      ContractProjectAssetInjection saveInjection = ContractProjectAssetInjection.builder()
         .assetInjectionTime(LocalDateTime.now())
         .collectionDepositBank(param.getPaymentBank())
         .projectId(project.getId())
         .assetInjectionEnum(param.getPaymentReasonId())
         .projectManagerId(project.getProjectManagerId())
         .projectManagerScale(BigDecimal.ZERO)
         .contractSignBodyId(project.getContractSignBodyId())
         .contractSignBodyScale(BigDecimal.ZERO)
         .paymentId(param.getPaymentId())
         .incomeOrDisburse(Boolean.FALSE)
         .build();

      try {
         Object number = this.redisUtils.get("supplierPaymentNumber");
         if (ObjectUtils.isEmpty(number)) {
            this.projectSerialNumberUtils.redisSaveSerialNumber();
            number = this.redisUtils.get("supplierPaymentNumber");
         }

         String supplierPaymentNumber = this.projectSerialNumberUtils.dateUtil(number.toString());
         saveInjection.setVoucherNumber("Z" + supplierPaymentNumber);
         this.redisUtils.incr("supplierPaymentNumber", 1L);
      } catch (Exception e) {
         throw new IllegalArgumentException("获取流水号失败");
      }

      BigDecimal contractSignBodyScaleUnpaAmount = amount.multiply(project.getContractSignBodyScale())
         .divide(BigDecimal.valueOf(100L), 4, RoundingMode.HALF_UP);
      BigDecimal projectManagerScaleUnpaAmount = amount.multiply(project.getProjectManagerScale()).divide(BigDecimal.valueOf(100L), 4, RoundingMode.HALF_UP);
      if (ObjectUtils.isNotEmpty(project.getProjectManagerAmount())) {
         if (project.getProjectManagerAmount().compareTo(projectManagerScaleUnpaAmount) >= 0) {
            project.setProjectManagerAmount(project.getProjectManagerAmount().subtract(projectManagerScaleUnpaAmount));
            projectManagerScaleUnpaAmount = BigDecimal.ZERO;
         } else {
            projectManagerScaleUnpaAmount = projectManagerScaleUnpaAmount.subtract(project.getProjectManagerAmount());
            project.setProjectManagerAmount(BigDecimal.ZERO);
         }
      }

      if (ObjectUtils.isNotEmpty(decimalMap)
         && ObjectUtils.isNotEmpty(decimalMap.get("projectManager"))
         && projectManagerScaleUnpaAmount.compareTo(BigDecimal.ZERO) > 0) {
         BigDecimal projectManager = decimalMap.get("projectManager");
         if (projectManager.compareTo(projectManagerScaleUnpaAmount) >= 0) {
            saveInjection.setProjectManagerId(project.getProjectManagerId());
            saveInjection.setProjectManagerScale(projectManagerScaleUnpaAmount);
            projectManagerScaleUnpaAmount = BigDecimal.ZERO;
         } else {
            saveInjection.setProjectManagerId(project.getProjectManagerId());
            saveInjection.setProjectManagerScale(projectManager);
            projectManagerScaleUnpaAmount = projectManagerScaleUnpaAmount.subtract(projectManager);
         }
      }

      if (ObjectUtils.isNotEmpty(project.getContractSignBodyAmount())) {
         if (project.getContractSignBodyAmount().compareTo(contractSignBodyScaleUnpaAmount) >= 0) {
            project.setContractSignBodyAmount(project.getContractSignBodyAmount().subtract(contractSignBodyScaleUnpaAmount));
            contractSignBodyScaleUnpaAmount = BigDecimal.ZERO;
         } else {
            contractSignBodyScaleUnpaAmount = contractSignBodyScaleUnpaAmount.subtract(project.getContractSignBodyAmount());
            project.setContractSignBodyAmount(BigDecimal.ZERO);
         }

         if (CollectionUtils.isNotEmpty(decimalMap) && contractSignBodyScaleUnpaAmount.compareTo(BigDecimal.ZERO) > 0) {
            Preconditions.checkArgument(
               ObjectUtils.isNotEmpty(decimalMap.get("contractSignBody")) && decimalMap.get("contractSignBody").compareTo(contractSignBodyScaleUnpaAmount) >= 0,
               "签约主体支付金额不足"
            );
            saveInjection.setContractSignBodyId(project.getContractSignBodyId());
            saveInjection.setContractSignBodyScale(contractSignBodyScaleUnpaAmount);
            contractSignBodyScaleUnpaAmount = BigDecimal.ZERO;
         }
      }

      if (saveInjection.getProjectManagerScale().compareTo(BigDecimal.ZERO) > 0 || saveInjection.getContractSignBodyScale().compareTo(BigDecimal.ZERO) > 0) {
         this.assetInjectionService.save(saveInjection);
      }

      if (projectManagerScaleUnpaAmount.compareTo(BigDecimal.ZERO) > 0) {
         Preconditions.checkArgument(
            ObjectUtils.isNotEmpty(givingCredit) && givingCredit.getRemainingSum().compareTo(projectManagerScaleUnpaAmount) >= 0, "项目经理额度不足"
         );
      }

      if (projectManagerScaleUnpaAmount.compareTo(BigDecimal.ZERO) > 0) {
         givingCredit.setRemainingSum(givingCredit.getRemainingSum().subtract(projectManagerScaleUnpaAmount));
         this.givingCreditService.updateById(givingCredit);
         ContractGivingCreditDetail creditDetail = new ContractGivingCreditDetail()
            .setPaymentReasonId(param.getPaymentReasonId())
            .setUseAmount(projectManagerScaleUnpaAmount)
            .setCreditId(givingCredit.getId())
            .setProjectId(project.getId())
            .setPurchaseId(param.getOrderId())
            .setAuditStatus(AuditStatusEnum.SUCCEED.getType());
         this.givingCreditDetailService.save(creditDetail);
      }

      this.jointlyOwnedInsourcing(param, project, givingCredit);
      this.projectService.updateById(project);
   }

   public void jointlyOwnedInsourcing(PurchaseSupplierPaymentInsourcingAddDTOParam param, ContractProject project, ContractGivingCredit givingCredit) {
      List<ContractProjectManagerMoneyInterests> interestsList = this.moneyInterestsService
         .list(
            Wrappers.lambdaQuery(ContractProjectManagerMoneyInterests.class)
               .eq(ContractProjectManagerMoneyInterests::getProjectManagerId, param.getProjectManagerId())
               .eq(ContractProjectManagerMoneyInterests::getProjectId, param.getProjectId())
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (CollectionUtils.isNotEmpty(interestsList)) {
         ContractProjectManagerMoneyInterests interests = interestsList.get(0);
         BigDecimal liabilities = BigDecimal.ZERO;
         if (ObjectUtils.isNotEmpty(givingCredit) && givingCredit.getRemainingSum().compareTo(givingCredit.getLineOfCredit()) != 0) {
            liabilities = givingCredit.getLineOfCredit().subtract(givingCredit.getRemainingSum());
         }

         ContractProjectManagerMoneyInterests build = ContractProjectManagerMoneyInterests.builder()
            .userId(UserUtil.getCurrentUserId())
            .expenditure(param.getPaymentAmount())
            .projectId(param.getProjectId())
            .projectManagerId(param.getProjectManagerId())
            .build();
         build.setRemainingSum(interests.getRemainingSum().subtract(build.getExpenditure()));
         if (project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
            BigDecimal liabilitiesAmount = ObjectUtils.isNotEmpty(interests.getLiabilities()) ? interests.getLiabilities() : BigDecimal.ZERO;
            build.setRemainingSum(
               liabilitiesAmount.compareTo(BigDecimal.ZERO) > 0
                  ? build.getRemainingSum().add(liabilities.subtract(liabilitiesAmount))
                  : build.getRemainingSum().add(liabilities)
            );
         }

         build.setLiabilities(liabilities);
         this.moneyInterestsService.save(build);
         if (interests.getLiabilities() != null && interests.getLiabilities().compareTo(BigDecimal.ZERO) > 0) {
            build.setLiabilities(build.getRemainingSum().compareTo(BigDecimal.ZERO) >= 0 ? BigDecimal.ZERO : build.getRemainingSum().abs());
            interests.setLiabilitiesDay((int)ChronoUnit.DAYS.between(interests.getCreateTime(), LocalDateTime.now().plusDays(1L)));
            interests.setDailyAmount(liabilities.multiply(BigDecimal.valueOf(interests.getLiabilitiesDay().intValue())));
         }

         this.moneyInterestsService.updateById(interests);
      }
   }

   public void interestOnFunds(PurchaseSupplierPaymentInsourcingAddDTOParam param, BigDecimal paymentAmount, BigDecimal paymentSum) {
      List<ContractProjectManagerMoneyInterests> interestsList = this.moneyInterestsService
         .list(
            Wrappers.lambdaQuery(ContractProjectManagerMoneyInterests.class)
               .eq(ContractProjectManagerMoneyInterests::getProjectManagerId, param.getProjectManagerId())
               .eq(ContractProjectManagerMoneyInterests::getProjectId, param.getProjectId())
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (CollectionUtils.isNotEmpty(interestsList)) {
         ContractProjectManagerMoneyInterests interests = interestsList.get(0);
         BigDecimal liabilities = ObjectUtils.isNotEmpty(interests.getLiabilities()) ? interests.getLiabilities() : BigDecimal.ZERO;
         ContractProjectManagerMoneyInterests build = ContractProjectManagerMoneyInterests.builder()
            .expenditure(param.getPaymentAmount())
            .projectId(param.getProjectId())
            .projectManagerId(param.getProjectManagerId())
            .build();
         build.setLiabilities(liabilities.add(paymentAmount));
         build.setRemainingSum(
            paymentAmount.compareTo(BigDecimal.ZERO) > 0 ? paymentAmount.add(liabilities).negate() : interests.getRemainingSum().subtract(paymentSum)
         );
         if (liabilities.compareTo(BigDecimal.ZERO) >= 0) {
            interests.setLiabilitiesDay((int)ChronoUnit.DAYS.between(interests.getCreateTime(), LocalDateTime.now().plusDays(1L)));
            interests.setDailyAmount(liabilities.multiply(BigDecimal.valueOf(interests.getLiabilitiesDay().intValue())));
            this.moneyInterestsService.updateById(interests);
         }

         this.moneyInterestsService.save(build);
      } else {
         this.moneyInterestsService
            .save(
               ContractProjectManagerMoneyInterests.builder()
                  .expenditure(param.getPaymentAmount())
                  .remainingSum(param.getPaymentAmount().negate())
                  .liabilities(param.getPaymentAmount().abs())
                  .projectId(param.getProjectId())
                  .projectManagerId(param.getProjectManagerId())
                  .build()
            );
      }
   }

   private void projectManagerInjection(
      PurchaseSupplierPaymentInsourcingAddDTOParam param,
      ContractProject project,
      BigDecimal projectManagerScaleUnpaid,
      ContractProjectAssetInjection injection
   ) {
      injection.setProjectManagerId(project.getProjectManagerId());
      injection.setProjectManagerScale(projectManagerScaleUnpaid);
      this.assetInjectionService.save(injection);
   }

   public void saveDiscount(Long projectId, PurchaseSupplierPaymentInsourcingAddDTOParam param, BigDecimal collectionSummary) {
      Preconditions.checkArgument(param.getOrderId() != null, "采购订单id不能为空");
      ContractProjectDisburseDetail disburseDetail = new ContractProjectDisburseDetail()
         .setProjectId(projectId)
         .setSupplierId(param.getSupplierId())
         .setUserId(UserUtil.getCurrentUserId())
         .setPurchaseContractNumber(param.getPurchaseContractNumber())
         .setExpenseType(SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())
         .setPurchaseDetailId(param.getOrderId())
         .setExpenseMoney(collectionSummary)
         .setProjectManagerId(param.getProjectManagerId())
         .setPaymentBank(param.getPaymentBank())
         .setPaymentBankAccount(param.getPaymentBankAccount())
         .setRemark(param.getRemark());
      this.discountService.save(disburseDetail);
   }
}
