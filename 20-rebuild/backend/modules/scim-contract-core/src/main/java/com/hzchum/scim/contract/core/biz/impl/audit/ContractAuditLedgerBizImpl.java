package com.hzchum.scim.contract.core.biz.impl.audit;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.ApproveTemplateVersionsFlowEnum;
import com.hzchum.scim.common.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierInvoiceBiz;
import com.hzchum.scim.contract.core.api.biz.audit.ContractAuditLedgerBiz;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.AuditTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AssetTypeEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.enums.payment.OrderClassEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCollection;
import com.hzchum.scim.contract.core.api.pojo._do.ContractInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractSettlement;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierSettlement;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractCollectionDisburse;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseType;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCredit;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCreditDetail;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractProjectAssetInjection;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractReimbursementFee;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractTestingFee;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWageFee;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWaterElectricityPropertyFee;
import com.hzchum.scim.contract.core.api.pojo._do.finance.SecurityDepositAndManagementCost;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectSettlementDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.SupplierSettlementDto;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.AuditUserDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractAuditLedgerDto;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractCollectionAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractFeeBaseInfo;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractReimbursementFeeAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractTestingFeeAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractWageFeeAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractWaterElectricityFeeAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.InsourcingAuditDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.InsourcingDetailAuditDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.SelfemployedAuditDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.SupplierInvoicePurchaseAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.SupplierInvoiceSubOrderAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.SupplierSettlementEchoAuditDto;
import com.hzchum.scim.contract.core.api.pojo.dto.project.ProjectSupplierDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectOutputInvoiceDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SelfEmployedPaymentAndFinishDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierAuditSelfEmployedDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSelfEmployedDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementEchoDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.saveSupplierPaymentDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ProjectSettlementSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.AddContractAuditDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.ContractAuditLedgerQueryParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.FillFeeAuditSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.PaymentInvoiceDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.ProjectCollectionAuditParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.PurchaseInvoiceAuditDetailParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.PurchaseInvoiceAuditParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.SettleAuditSaveDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.SubOrderInvoiceAuditParam;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractInvoiceService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractSettlementService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.contract.core.api.service.finance.ContractCollectionDisburseService;
import com.hzchum.scim.contract.core.api.service.finance.ContractExpenseTypeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditDetailService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditService;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectAssetInjectionService;
import com.hzchum.scim.contract.core.api.service.finance.ContractReimbursementFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractTestingFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractWageFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractWaterElectricityPropertyFeeService;
import com.hzchum.scim.contract.core.api.service.finance.SecurityDepositAndManagementCostService;
import com.hzchum.scim.contract.core.api.utils.ProjectFinanceUtils;
import com.hzchum.scim.contract.core.biz.impl.ContractSupplierPaymentBizImpl;
import com.hzchum.scim.contract.core.mapper.audit.ContractAuditLedgerMapper;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.scm.core.api.enums.PurchaseStatusEnum;
import com.hzchum.scim.scm.core.api.enums.SubOrderStatusEnum;
import com.hzchum.scim.scm.core.api.enums.SubSupplyTypeEnum;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.utils.ProjectSerialNumberUtils;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.SysSupplierPaymentAttribute;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinanceAmountLimitConfigDTO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.SysSupplierPaymentAttributeService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.InvoiceTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractAuditLedgerBizImpl
   extends IBizImpl<ContractAuditLedgerService, ContractAuditLedgerMapper, ContractAuditLedger>
   implements ContractAuditLedgerBiz {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private UserService userService;
   @Resource
   private SysSupplierPaymentAttributeService supplierPaymentAttributeService;
   @Autowired
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private SubcontractOrderService subcontractOrderService;
   @Autowired
   private ContractGivingCreditService givingCreditService;
   @Resource
   private ContractGivingCreditDetailService givingCreditDetailService;
   @Autowired
   private SupplierPaymentService supplierPaymentService;
   @Autowired
   private SupplierInvoiceService supplierInvoiceService;
   @Resource
   private ContractSupplierInvoiceBiz supplierInvoiceBiz;
   @Autowired
   private ContractSupplierPaymentBizImpl contractSupplierPaymentBiz;
   @Autowired
   private BranchCompanyService branchCompanyService;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private ContractCollectionService contractCollectionService;
   @Autowired
   private ContractInvoiceService contractInvoiceService;
   @Autowired
   private ContractSettlementService contractSettlementService;
   @Resource
   private ContractTestingFeeService contractTestingFeeService;
   @Resource
   private ContractWaterElectricityPropertyFeeService waterElectricityPropertyFeeService;
   @Resource
   private ContractExpenseTypeService contractExpenseTypeService;
   @Resource
   private ContractReimbursementFeeService reimbursementFeeService;
   @Resource
   private ContractWageFeeService contractWageFeeService;
   @Autowired
   private WmsApproveRecordService approveRecordService;
   @Autowired
   private WmsApproveRecordDetailService approveRecordDetailService;
   @Resource
   private InboundService inboundService;
   @Autowired
   private SysDictionaryService sysDictionaryService;
   @Autowired
   private AttachmentService attachmentService;
   @Resource
   private ContractInvoiceService invoiceService;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ConfigService configService;
   @Resource
   private SupplierSettlementService supplierSettlementService;
   @Resource
   private WmsApproveRecordService approvalsService;
   @Resource
   private WmsApproveRecordDetailService approvalsDetailService;
   @Resource
   private ContractProjectAssetInjectionService assetInjectionService;
   @Resource
   private SecurityDepositAndManagementCostService costService;
   @Resource
   private ProjectSerialNumberUtils projectSerialNumberUtils;
   @Resource
   private ContractSupplierInvoiceBiz instructorInvoiceBiz;
   @Resource
   private ContractCollectionDisburseService contractCollectionDisburseService;
   @Resource
   private MaterialInventoryService materialInventoryService;
   @Resource
   private MesBuildingTaskService taskService;
   @Resource
   private MesEnclosureTaskService enclosureTaskService;
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechEnclosureService enclosureService;
   @Resource
   private ProjectFinanceUtils projectFinanceUtils;

   @Override
   public PageVO<ContractAuditLedgerDto> listAuditLedger(ContractAuditLedgerQueryParam param, Integer pageNumber, Integer pageSize) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<ContractAuditLedger> ledgerList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractAuditLedger.class)
               .eq(param.getPaymentEnum() != null, ContractAuditLedger::getPaymentEnum, param.getPaymentEnum())
               .eq(param.getAuditStatusEnum() != null, ContractAuditLedger::getAuditStatusEnum, param.getAuditStatusEnum())
               .eq(param.getProjectAttribute() != null, ContractAuditLedger::getProjectAttribute, param.getProjectAttribute())
               .eq(param.getInitiatorId() != null, ContractAuditLedger::getInitiatorId, param.getInitiatorId())
               .eq(param.getProjectManagerId() != null, ContractAuditLedger::getProjectManagerId, param.getProjectManagerId())
               .eq(param.getSupplierId() != null, ContractAuditLedger::getSupplierId, param.getSupplierId())
               .eq(param.getWrittenById() != null, ContractAuditLedger::getWrittenById, param.getWrittenById())
               .like(param.getOaNumber() != null, ContractAuditLedger::getOaNumber, param.getOaNumber())
               .apply(param.getTime() != null, "date_format(filing_date,'%Y-%m') = date_format({0},'%Y-%m')", param.getTime())
               .apply(param.getProjectId() != null, "find_in_set({0}, project_id)", param.getProjectId())
               .orderByAsc(ContractAuditLedger::getAuditStatusEnum)
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (ledgerList.isEmpty()) {
         return new PageVO<>();
      }

      List<ContractAuditLedgerDto> ledgerDtoList = this.getContractAuditLedgerDtos(ledgerList);
      return new PageVO<>(page, ledgerDtoList);
   }

   private Boolean getBoolFinalApprove(Long auditId) {
      if (auditId == null) {
         return true;
      }

      ContractAuditLedger auditLedger = this.baseService.getById(auditId);
      if (auditLedger == null) {
         return true;
      }

      Integer approveProcessTypeEnumV2 = null;
      if (auditLedger.getPaymentEnum().equals(AuditPaymentEnum.PROCUREMENT_PAYMENT.getType())) {
         approveProcessTypeEnumV2 = ApproveProcessTypeEnumV2.SELF_BUYING_PAYMENT_AUDIT.getType();
      } else if (auditLedger.getPaymentEnum().equals(AuditPaymentEnum.INCOMING_INVOICES.getType())) {
         approveProcessTypeEnumV2 = auditLedger.getAuditType().equals(AuditTypeEnum.PAYMENT_APPROVE.getType())
            ? ApproveProcessTypeEnumV2.SELF_BUYING_INVOICE_AUDIT.getType()
            : ApproveProcessTypeEnumV2.OUTSOURCING_ORDER_INVOICE_AUDIT.getType();
      } else if (auditLedger.getPaymentEnum().equals(AuditPaymentEnum.PURCHASE_SETTLEMENT.getType())) {
         approveProcessTypeEnumV2 = ApproveProcessTypeEnumV2.SELF_BUYING_SETTLEANACCOUNT_AUDIT.getType();
      } else if (auditLedger.getPaymentEnum().equals(AuditPaymentEnum.PURCHASE_PRE_SETTLEMENT.getType())) {
         approveProcessTypeEnumV2 = ApproveProcessTypeEnumV2.SELF_BUYING_PRE_SETTLE_AUDIT.getType();
      } else if (auditLedger.getPaymentEnum().equals(AuditPaymentEnum.SUBCONTRACT_PAYMENT.getType())) {
         approveProcessTypeEnumV2 = ApproveProcessTypeEnumV2.OUTSOURCING_ORDER_PAYMENT_AUDIT.getType();
      } else if (auditLedger.getPaymentEnum().equals(AuditPaymentEnum.SUBCONTRACT_SETTLEMENT.getType())) {
         approveProcessTypeEnumV2 = ApproveProcessTypeEnumV2.OUTSOURCING_ORDER_SETTLE_AUDIT.getType();
      } else if (auditLedger.getPaymentEnum().equals(AuditPaymentEnum.SUBCONTRACT_PRE_SETTLEMENT.getType())) {
         approveProcessTypeEnumV2 = ApproveProcessTypeEnumV2.OUTSOURCING_ORDER_PRE_SETTLE_AUDIT.getType();
      } else if (auditLedger.getPaymentEnum().equals(AuditPaymentEnum.OUTGOING_INVOICES.getType())) {
         approveProcessTypeEnumV2 = ApproveProcessTypeEnumV2.CONTRACT_INVOICE_AUDIT.getType();
      } else if (auditLedger.getPaymentEnum().equals(AuditPaymentEnum.PROJECT_SETTLEMENT.getType())) {
         approveProcessTypeEnumV2 = ApproveProcessTypeEnumV2.CONTRACT_SETTLEMENT_AUDIT.getType();
      } else if (auditLedger.getPaymentEnum().equals(AuditPaymentEnum.PROJECT_PRE_SETTLEMENT.getType())) {
         approveProcessTypeEnumV2 = ApproveProcessTypeEnumV2.CONTRACT_PRE_SETTLEMENT_AUDIT.getType();
      } else if (auditLedger.getPaymentEnum().equals(AuditPaymentEnum.PROJECT_COLLECTION.getType())) {
         approveProcessTypeEnumV2 = ApproveProcessTypeEnumV2.CONTRACT_COLLECTION_AUDIT.getType();
      }

      if (approveProcessTypeEnumV2 == null) {
         return true;
      }

      Long currentUserId = UserUtil.getCurrentUserId();
      List<WmsApproveRecordDetail> approveRecordDetailList = this.approvalsDetailService
         .list(
            Wrappers.lambdaQuery(WmsApproveRecordDetail.class)
               .eq(WmsApproveRecordDetail::getDataId, auditId)
               .eq(WmsApproveRecordDetail::getApproveProcessType, approveProcessTypeEnumV2)
               .in(
                  WmsApproveRecordDetail::getFlowType,
                  ApproveTemplateVersionsFlowEnum.ALL_SIGN.getType(),
                  ApproveTemplateVersionsFlowEnum.OR_SIGN.getType(),
                  ApproveTemplateVersionsFlowEnum.A_SIGN.getType()
               )
               .orderByDesc(WmsApproveRecordDetail::getFlowId)
         );
      if (approveRecordDetailList.isEmpty()) {
         return true;
      }

      Map<Long, List<WmsApproveRecordDetail>> collect = approveRecordDetailList.stream()
         .filter(detail -> detail.getFlowId() != null)
         .collect(Collectors.groupingBy(WmsApproveRecordDetail::getFlowId));
      if (collect.isEmpty()) {
         return true;
      }

      Long maxFlowId = Collections.max(collect.keySet());
      List<WmsApproveRecordDetail> detailList = collect.get(maxFlowId);
      Integer flowType = detailList.get(0).getFlowType();
      if (flowType.equals(ApproveTemplateVersionsFlowEnum.ALL_SIGN.getType())) {
         List<WmsApproveRecordDetail> underwayList = detailList.stream()
            .filter(d -> d.getStatus().equals(ApproveRecordStatusEnum.UNDERWAY.getType()))
            .collect(Collectors.toList());
         return underwayList.size() == 1 && underwayList.get(0).getCheckUserId().equals(currentUserId);
      }

      if (!flowType.equals(ApproveTemplateVersionsFlowEnum.OR_SIGN.getType())) {
         return detailList.stream()
            .allMatch(detail -> detail.getStatus().equals(ApproveRecordStatusEnum.UNDERWAY.getType()) && detail.getCheckUserId().equals(currentUserId));
      }

      boolean allUnSign = detailList.stream().allMatch(detail -> detail.getStatus().equals(ApproveRecordStatusEnum.UNDERWAY.getType()));
      return allUnSign && detailList.stream().anyMatch(detail -> detail.getCheckUserId().equals(currentUserId));
   }

   @NotNull
   private List<ContractAuditLedgerDto> getContractAuditLedgerDtos(List<ContractAuditLedger> ledgerList) {
      Map<Long, ContractProject> projectMap = this.projectService.list().stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      List<ContractAuditLedgerDto> ledgerDtoList = new ArrayList<>();
      ledgerList.forEach(
         auditLedger -> {
            ContractAuditLedgerDto ledgerDto = BeanUtil.copy(auditLedger, ContractAuditLedgerDto.class);
            ledgerDto.setProjectAttribute(
               ObjectUtils.isNotEmpty(ledgerDto.getProjectAttribute()) ? ledgerDto.getProjectAttribute() : auditLedger.getProjectAttribute()
            );
            if (ObjectUtils.isNotEmpty(auditLedger.getProjectId())) {
               String projectName = Arrays.stream(auditLedger.getProjectId().split(","))
                  .distinct()
                  .map(a -> projectMap.get(Long.valueOf(a)))
                  .map(project -> project.getSerialNumber() + "-" + project.getShortName())
                  .collect(Collectors.joining("/"));
               ledgerDto.setProjectName(projectName);
            }

            Supplier supplier = supplierMap.get(auditLedger.getSupplierId());
            ledgerDto.setSupplierName(supplier != null ? supplier.getName() : "");
            if (auditLedger.getWrittenById() != null) {
               ledgerDto.setWrittenByName(userMap.get(auditLedger.getWrittenById()) != null ? userMap.get(auditLedger.getWrittenById()).getName() : "");
            }

            if (auditLedger.getInitiatorId() != null) {
               ledgerDto.setInitiatorName(userMap.get(auditLedger.getInitiatorId()) != null ? userMap.get(auditLedger.getInitiatorId()).getName() : "");
            }

            if (auditLedger.getProjectManagerId() != null) {
               ledgerDto.setProjectManagerName(
                  userMap.get(auditLedger.getProjectManagerId()) != null ? userMap.get(auditLedger.getProjectManagerId()).getName() : ""
               );
            }

            if (ObjectUtils.isNotEmpty(ledgerDto.getContractSignBodyId())) {
               ledgerDto.setContractSignBodyName(
                  ObjectUtils.isNotEmpty(branchCompanyMap.get(ledgerDto.getContractSignBodyId()).getShortName())
                     ? branchCompanyMap.get(ledgerDto.getContractSignBodyId()).getShortName()
                     : branchCompanyMap.get(ledgerDto.getContractSignBodyId()).getName()
               );
            }

            ledgerDto.setAttachments(this.attachmentService.listByIds(auditLedger.getAttachmentIds()));
            ledgerDtoList.add(ledgerDto);
         }
      );
      return ledgerDtoList;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean procurementAudit(AddContractAuditDtoParam param) {
      ContractAuditLedger contractAuditLedger = this.baseMapper
         .selectOne(Wrappers.lambdaQuery(ContractAuditLedger.class).eq(ContractAuditLedger::getId, param.getAuditId()));
      Preconditions.checkArgument(contractAuditLedger != null, "审批信息有误");
      Preconditions.checkArgument(contractAuditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "审核状态有误!");
      SupplierPayment supplierPayment = this.supplierPaymentService.getById(Long.valueOf(contractAuditLedger.getPaymentId()));
      Preconditions.checkArgument(supplierPayment != null, "付款信息不存在");
      ContractProject project = this.projectService.getById(contractAuditLedger.getProjectId());
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(contractAuditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(contractAuditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         Preconditions.checkArgument(param.getActuallyPayAmount() != null, "实付金额不能为空");
         Preconditions.checkArgument(param.getPaymentType() != null, "付款类型不能为空");
         Preconditions.checkArgument(supplierPayment.getPaymentAmount().compareTo(param.getActuallyPayAmount()) >= 0, "实付金额不能大于申请金额");
         supplierPayment.setActuallyPaymentAmount(param.getActuallyPayAmount());
         supplierPayment.setPaymentReasonId(String.valueOf(param.getPaymentType()));
         String approvalSerialNumber = this.getApprovalSerialNumber("Z");
         supplierPayment.setApprovalSerialNumber(approvalSerialNumber);
         supplierPayment.setAuditStatus(param.getAuditStatusEnum());
         supplierPayment.setAuditTime(LocalDateTime.now());
         supplierPayment.setAuditUserId(UserUtil.getCurrentUserId());
         supplierPayment.setAuditUserName(UserUtil.getCurrentName());
         this.supplierPaymentService.updateById(supplierPayment);
         if (param.getActuallyPayAmount().compareTo(supplierPayment.getPaymentAmount()) != 0) {
            this.revocationPayment(project, supplierPayment);
            this.contractSupplierPaymentBiz.deductProjectMoney(project, supplierPayment);
         } else {
            this.successPaymentUpdateAuditStatus(supplierPayment.getId());
         }

         contractAuditLedger.setActuallyPayAmount(param.getActuallyPayAmount());
         contractAuditLedger.setPaymentType(param.getPaymentType());
         contractAuditLedger.setVoucherNumber(param.getVoucherNumber());
         contractAuditLedger.setProjectAttribute(project.getProjectAttribute());
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         this.baseMapper.updateById(contractAuditLedger);
      }

      if (param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())) {
         supplierPayment.setAuditStatus(param.getAuditStatusEnum());
         supplierPayment.setAuditTime(LocalDateTime.now());
         supplierPayment.setAuditUserId(UserUtil.getCurrentUserId());
         supplierPayment.setAuditUserName(UserUtil.getCurrentName());
         this.supplierPaymentService.updateById(supplierPayment);
         this.revocationPayment(project, supplierPayment);
         contractAuditLedger.setProjectAttribute(project.getProjectAttribute());
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         this.baseMapper.updateById(contractAuditLedger);
      }

      return true;
   }

   private String getApprovalSerialNumber(String mark) {
      try {
         Object number = this.redisUtils.get("supplierPaymentNumber");
         if (ObjectUtils.isEmpty(number)) {
            this.projectSerialNumberUtils.redisSaveSerialNumber();
            number = this.redisUtils.get("supplierPaymentNumber");
         }

         String supplierPaymentNumber = this.projectSerialNumberUtils.dateUtil(number.toString());
         String approvalSerialNumber = mark + supplierPaymentNumber;
         this.redisUtils.incr("supplierPaymentNumber", 1L);
         return approvalSerialNumber;
      } catch (Exception e) {
         throw new IllegalArgumentException("获取流水号失败");
      }
   }

   private void revocationPayment(ContractProject project, SupplierPayment supplierPayment) {
      this.revocationCollectionDisburse(supplierPayment);
      this.revocationInjection(project, supplierPayment);
      this.revocationGiving(supplierPayment);
   }

   private void successPaymentUpdateAuditStatus(Long supplierPaymentId) {
      this.contractCollectionDisburseService
         .update(
            Wrappers.lambdaUpdate(ContractCollectionDisburse.class)
               .eq(ContractCollectionDisburse::getPaymentId, supplierPaymentId)
               .set(ContractCollectionDisburse::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      this.assetInjectionService
         .update(
            Wrappers.lambdaUpdate(ContractProjectAssetInjection.class)
               .eq(ContractProjectAssetInjection::getPaymentId, supplierPaymentId)
               .eq(ContractProjectAssetInjection::getIncomeOrDisburse, false)
               .set(ContractProjectAssetInjection::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      this.givingCreditDetailService
         .update(
            Wrappers.lambdaUpdate(ContractGivingCreditDetail.class)
               .eq(ContractGivingCreditDetail::getSupplierPaymentId, supplierPaymentId)
               .set(ContractGivingCreditDetail::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
   }

   private void revocationCollectionDisburse(SupplierPayment supplierPayment) {
      List<ContractCollectionDisburse> collectionDisburseList = this.contractCollectionDisburseService
         .list(Wrappers.lambdaQuery(ContractCollectionDisburse.class).eq(ContractCollectionDisburse::getPaymentId, supplierPayment.getId()));
      if (CollectionUtils.isNotEmpty(collectionDisburseList)) {
         Set<Long> projectIds = collectionDisburseList.stream().map(ContractCollectionDisburse::getPaymentProjectId).collect(Collectors.toSet());
         Map<Long, ContractProject> projectMap = this.projectService
            .listByIds(projectIds)
            .stream()
            .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
         collectionDisburseList.forEach(c -> {
            ContractProject project = projectMap.get(c.getPaymentProjectId());
            if (c.getAssetType().equals(AssetTypeEnum.COMPANY_INJECTION.getType())) {
               project.setContractSignBodyCollectBalance(project.getContractSignBodyCollectBalance().add(c.getUseAmount()));
               project.setContractSignBodyAmount(project.getContractSignBodyAmount().add(c.getUseAmount()));
            } else {
               project.setProjectManagerCollectBalance(project.getProjectManagerCollectBalance().add(c.getUseAmount()));
               project.setProjectManagerAmount(project.getProjectManagerAmount().add(c.getUseAmount()));
            }

            project.setCollectionSummary(project.getCollectionSummary().add(c.getUseAmount()));
            if (supplierPayment.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())) {
               this.contractCollectionDisburseService.removeById(c.getId());
            } else {
               c.setAuditStatus(supplierPayment.getAuditStatus());
               this.contractCollectionDisburseService.updateById(c);
            }
         });
         this.projectService.updateBatchById(projectMap.values());
      }
   }

   private void revocationInjection(ContractProject project, SupplierPayment supplierPayment) {
      List<ContractProjectAssetInjection> assetInjectionList = this.assetInjectionService
         .list(
            Wrappers.lambdaQuery(ContractProjectAssetInjection.class)
               .eq(ContractProjectAssetInjection::getPaymentId, supplierPayment.getId())
               .eq(ContractProjectAssetInjection::getIncomeOrDisburse, false)
         );
      assetInjectionList.forEach(ass -> {
         if (ass.getAssetType().equals(AssetTypeEnum.COMPANY_INJECTION.getType())) {
            project.setContractSignBodyInjectionBalance(project.getContractSignBodyInjectionBalance().add(ass.getAssetAmount()));
            project.setContractSignBodyAmount(project.getContractSignBodyAmount().add(ass.getAssetAmount()));
         } else {
            project.setProjectManagerInjectionBalance(project.getProjectManagerInjectionBalance().add(ass.getAssetAmount()));
            project.setProjectManagerAmount(project.getProjectManagerAmount().add(ass.getAssetAmount()));
         }

         project.setCollectionSummary(project.getCollectionSummary().add(ass.getAssetAmount()));
         if (supplierPayment.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())) {
            this.assetInjectionService.removeById(ass.getId());
         } else {
            ass.setAuditStatus(supplierPayment.getAuditStatus());
            this.assetInjectionService.updateById(ass);
         }
      });
      this.projectService.updateById(project);
   }

   private void revocationGiving(SupplierPayment supplierPayment) {
      ContractGivingCreditDetail givingCreditDetail = this.givingCreditDetailService
         .getOne(Wrappers.lambdaQuery(ContractGivingCreditDetail.class).eq(ContractGivingCreditDetail::getSupplierPaymentId, supplierPayment.getId()));
      if (givingCreditDetail != null) {
         ContractGivingCredit givingCredit = this.givingCreditService.getById(givingCreditDetail.getCreditId());
         if (supplierPayment.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())) {
            this.givingCreditDetailService.removeById(givingCreditDetail.getId());
         } else {
            givingCreditDetail.setAuditStatus(supplierPayment.getAuditStatus());
            this.givingCreditDetailService.updateById(givingCreditDetail);
         }

         givingCredit.setUsedCredit(givingCredit.getUsedCredit().subtract(givingCreditDetail.getUseAmount()));
         givingCredit.setRemainingSum(givingCredit.getRemainingSum().add(givingCreditDetail.getUseAmount()));
         this.givingCreditService.updateById(givingCredit);
      }
   }

   private String dateUtil() {
      LocalDateTime now = LocalDateTime.now();
      int year = now.getYear() % 100;
      String month = String.format("%02d", now.getMonthValue());
      String day = String.format("%02d", now.getDayOfMonth());
      return year + month + day;
   }

   @Override
   public List<AuditUserDTO> getAuditList(Long auditId) {
      ContractAuditLedger contractAuditLedger = this.baseMapper.selectById(auditId);
      Preconditions.checkArgument(ObjectUtil.isNotNull(contractAuditLedger), "审批信息不存在");
      return this.baseMapper.getAuditList(contractAuditLedger.getApproveRecordId());
   }

   @Override
   public ContractCollectionAuditDTO getProjectCollectionAuditInfo(Long auditId) {
      ContractAuditLedger auditLedger = this.baseMapper.selectById(auditId);
      Preconditions.checkArgument(auditLedger != null, "审批信息不存在");
      Boolean button = this.procurementAudit(auditLedger.getApproveRecordId());
      ContractCollection collection = this.contractCollectionService
         .getOne(Wrappers.lambdaQuery(ContractCollection.class).eq(ContractCollection::getId, auditLedger.getPaymentId()));
      Preconditions.checkArgument(collection != null, "收款记录不存在!");
      ContractProject project = this.projectService.getById(collection.getProjectId());
      Preconditions.checkArgument(project != null, "项目数据不存在!");
      ProjectInfo projectInfo = BeanUtil.copy(project, ProjectInfo.class);
      if (projectInfo.getProjectManagerId() == null) {
         projectInfo.setProjectManagerId(project.getSalesLeaderId() != null ? project.getSalesLeaderId() : project.getSignerId());
         projectInfo.setProjectManagerName(this.userService.getNameById(projectInfo.getProjectManagerId()));
      }

      ContractCollectionAuditDTO collectionAuditDTO = BeanUtil.copy(collection, ContractCollectionAuditDTO.class);
      collectionAuditDTO.setProject(projectInfo);
      collectionAuditDTO.setAttachmentList(this.attachmentService.listByIds(collection.getAttachmentIds()));
      collectionAuditDTO.setAuditId(auditLedger.getId());
      collectionAuditDTO.setPassButton(button);
      collectionAuditDTO.setBoolCancel(false);
      collectionAuditDTO.setPaymentEnum(AuditPaymentEnum.PROJECT_COLLECTION.getType());
      collectionAuditDTO.setBoolFinalApprover(this.getBoolFinalApprove(auditId));
      return collectionAuditDTO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean projectCollectionAudit(ProjectCollectionAuditParam param) {
      ContractAuditLedger auditLedger = this.baseService.getById(param.getAuditId());
      Preconditions.checkArgument(auditLedger != null, "审批信息不存在");
      Preconditions.checkArgument(auditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "收款记录已审批!");
      ContractCollection collection = this.contractCollectionService.getById(auditLedger.getPaymentId());
      Preconditions.checkArgument(collection != null, "收款记录不存在!");
      Preconditions.checkArgument(collection.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "收款记录已审批!");
      ContractProject project = this.projectService.getById(auditLedger.getProjectId());
      Preconditions.checkArgument(project != null, "项目信息有误!");
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(auditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(auditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         Preconditions.checkArgument(param.getCollectionAmount() != null, "收款金额不能为空!");
         Preconditions.checkArgument(param.getCollectionAmount().compareTo(collection.getCollectionAmount()) <= 0, "实收金额不能超过申请金额!");
         BigDecimal collectionAmount = this.contractCollectionService
            .list(
               Wrappers.lambdaQuery(ContractCollection.class)
                  .eq(ContractCollection::getProjectId, project.getId())
                  .eq(ContractCollection::getCollectionUnitId, collection.getCollectionUnitId())
                  .eq(ContractCollection::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .map(ContractCollection::getCollectionAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         if (project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()) && !financeAmountLimitConfig.getBoolAllowOverContractAmount()) {
            Preconditions.checkArgument(collectionAmount.add(param.getCollectionAmount()).compareTo(project.getContractAmount()) <= 0, "收款总额不能超过项目合同额!");
         }

         if (project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) && !financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
            Preconditions.checkArgument(collectionAmount.add(param.getCollectionAmount()).compareTo(project.getSettlementAmount()) <= 0, "收款总额不能超过结算额!");
         }

         collection.setAuditStatus(param.getAuditStatusEnum());
         collection.setAuditorId(UserUtil.getCurrentUserId());
         collection.setAuditorName(UserUtil.getCurrentName());
         collection.setAuditTime(LocalDateTime.now());
         collection.setCollectionAmount(param.getCollectionAmount());
         this.contractCollectionService.updateById(collection);
         auditLedger.setWrittenById(UserUtil.getCurrentUserId());
         auditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         auditLedger.setSubmitDate(LocalDateTime.now());
         auditLedger.setApprovalTime(LocalDateTime.now());
         auditLedger.setActuallyPayAmount(param.getCollectionAmount());
         this.baseService.updateById(auditLedger);
         Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
         if (!boolTwoLevelUnit || collection.getCollectionUnitId().equals(project.getContractSignBodyId())) {
            project.setCollectionAmount(project.getCollectionAmount().add(param.getCollectionAmount()));
            this.projectService.updateById(project);
         }
      }

      if (param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())) {
         collection.setAuditStatus(param.getAuditStatusEnum());
         collection.setAuditTime(LocalDateTime.now());
         collection.setAuditorId(UserUtil.getCurrentUserId());
         collection.setAuditorName(UserUtil.getCurrentName());
         this.contractCollectionService.updateById(collection);
         auditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         auditLedger.setApprovalTime(LocalDateTime.now());
         auditLedger.setSubmitDate(LocalDateTime.now());
         auditLedger.setWrittenById(UserUtil.getCurrentUserId());
         this.baseService.updateById(auditLedger);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean outputInvoiceAudit(PaymentInvoiceDTOParam param) {
      ContractAuditLedger contractAuditLedger = this.baseMapper.selectById(param.getAuditId());
      Preconditions.checkArgument(ObjectUtil.isNotNull(contractAuditLedger), "审批信息不存在");
      Preconditions.checkArgument(contractAuditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "销项发票已审批!");
      ContractInvoice invoice = this.contractInvoiceService.getById(contractAuditLedger.getPaymentId());
      Preconditions.checkArgument(invoice != null, "发票信息不存在!");
      Preconditions.checkArgument(invoice.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "发票记录已审批!");
      ContractProject project = this.projectService.getById(Long.valueOf(contractAuditLedger.getProjectId()));
      Preconditions.checkArgument(project != null, "发票项目信息有误!");
      FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
      if (param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         if (!invoice.getInvoiceType().equals(InvoiceTypeEnum.RECEIPT.getType())) {
            Preconditions.checkArgument(StringUtils.isNotBlank(param.getTaxRateTypeValue()), "税率类型不能为空!");
            Preconditions.checkArgument(StringUtils.isNotBlank(param.getInvoiceNumber()), "发票号码不能为空!");
            SysDictionary dictionary = this.sysDictionaryService
               .getOne(
                  Wrappers.lambdaQuery(SysDictionary.class)
                     .eq(SysDictionary::getName, DictionaryEnum.INVOICE_TAX_RATE.getName())
                     .eq(SysDictionary::getValue, param.getTaxRateTypeValue())
               );
            Preconditions.checkArgument(dictionary != null, "税率类型不存在!");
            param.setTaxRate(new BigDecimal(dictionary.getLabel()));
         } else {
            param.setTaxRate(BigDecimal.ZERO);
         }
      }

      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(contractAuditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(contractAuditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         Preconditions.checkArgument(param.getPracticalInvoice() != null, "实开发票金额不能为空!");
         Preconditions.checkArgument(param.getPracticalInvoice().compareTo(invoice.getInvoiceAmount()) <= 0, "实开票额不能超过申请金额!");
         BigDecimal invoiceAmount = this.contractInvoiceService
            .list(
               Wrappers.lambdaQuery(ContractInvoice.class)
                  .eq(ContractInvoice::getProjectId, project.getId())
                  .eq(ContractInvoice::getInvoiceUnitId, invoice.getInvoiceUnitId())
                  .eq(ContractInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .map(ContractInvoice::getActualInvoiceAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         if (project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()) && !financeAmountLimitConfig.getBoolAllowOverContractAmount()) {
            Preconditions.checkArgument(invoiceAmount.add(param.getPracticalInvoice()).compareTo(project.getContractAmount()) <= 0, "开票总额不能超过项目合同额!");
         }

         if (project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) && !financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
            Preconditions.checkArgument(invoiceAmount.add(param.getPracticalInvoice()).compareTo(project.getSettlementAmount()) <= 0, "开票总额不能超过结算额!");
         }

         invoice.setAuditStatus(param.getAuditStatusEnum());
         invoice.setAuditorId(UserUtil.getCurrentUserId());
         invoice.setAuditorName(UserUtil.getCurrentName());
         invoice.setAuditTime(LocalDateTime.now());
         invoice.setInvoiceNo(param.getInvoiceNumber());
         invoice.setActualInvoiceAmount(param.getPracticalInvoice());
         invoice.setTaxRateTypeValue(param.getTaxRateTypeValue());
         invoice.setTaxRate(param.getTaxRate());
         invoice.setTax(invoice.getActualInvoiceAmount().multiply(param.getTaxRate()).divide(BigDecimal.valueOf(100L), 4, RoundingMode.HALF_UP));
         this.contractInvoiceService.updateById(invoice);
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setActuallyPayAmount(param.getPracticalInvoice());
         this.baseMapper.updateById(contractAuditLedger);
         Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
         if (!boolTwoLevelUnit || invoice.getInvoiceUnitId().equals(project.getContractSignBodyId())) {
            project.setInvoiceAmount(project.getInvoiceAmount().add(param.getPracticalInvoice()));
            this.projectService.updateById(project);
         }
      }

      if (param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())) {
         invoice.setAuditStatus(param.getAuditStatusEnum());
         invoice.setAuditTime(LocalDateTime.now());
         invoice.setAuditorId(UserUtil.getCurrentUserId());
         invoice.setAuditorName(UserUtil.getCurrentName());
         this.contractInvoiceService.updateById(invoice);
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         this.baseService.updateById(contractAuditLedger);
      }

      return Boolean.TRUE;
   }

   @Override
   public Boolean printDownload(Long auditId, HttpServletResponse response) {
      ContractAuditLedger contractAuditLedger = this.baseMapper.selectById(auditId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(contractAuditLedger), "审批信息不存在");
      Map<Long, ContractProject> projectMap = this.projectService.list().stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      if (contractAuditLedger.getPaymentEnum().equals(AuditPaymentEnum.PROCUREMENT_PAYMENT.getType())) {
         SelfemployedAuditDetail auditDetail = this.getSelfEmployedAuditDetail(auditId);
         Map<String, Object> stringObjectMap = BeanUtil.beanToMap(auditDetail);
         List<SupplierSelfEmployedDto> list = auditDetail.getSupplierAuditSelfEmployedDto().getList();
         stringObjectMap.put("paymentEnum", auditDetail.getPaymentEnum());
         stringObjectMap.put("passButton", auditDetail.getPassButton());
         stringObjectMap.put("projectAttribute", auditDetail.getProjectAttribute());
         String exportFileName = ProjectAttributeEnum.getNameByType(contractAuditLedger.getProjectAttribute())
            + AuditPaymentEnum.PROCUREMENT_PAYMENT.getName()
            + ".xlsx";
         String resourcePath = "files/SelfSupport.xlsx";
         String tempFileName = "SelfSupport";
         if (CollectionUtils.isNotEmpty(auditDetail.getSupplierAuditSelfEmployedDto().getSerialNumber())) {
            StringBuilder sb = new StringBuilder();

            for (String string : auditDetail.getSupplierAuditSelfEmployedDto().getSerialNumber()) {
               sb.append(string).append("+");
            }

            stringObjectMap.put("serialNumber", sb);
         }

         if (CollectionUtils.isNotEmpty(auditDetail.getSupplierAuditSelfEmployedDto().getProjectName())) {
            StringBuilder sb = new StringBuilder();

            for (String string : auditDetail.getSupplierAuditSelfEmployedDto().getProjectName()) {
               sb.append(string).append("+");
            }

            stringObjectMap.put("projectName", sb);
         }

         List<AuditUserDTO> auditList = this.getAuditList(auditId);
         auditList.stream().forEach(item -> item.setApproveTypeName(ApproveTemplateVersionsFlowEnum.getName(item.getApproveType())));
         ClassPathResource resource = new ClassPathResource(resourcePath);
         File file = null;

         try (InputStream inputStream = resource.getInputStream()) {
            file = File.createTempFile(tempFileName, "xlsx");
            FileUtil.copyInputStreamToFile(inputStream, file);
         } catch (IOException e) {
            e.printStackTrace();
         }

         stringObjectMap.put("auditList", auditList);
         stringObjectMap.put("list", list);
         TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
         params.setColForEach(true);
         Workbook workbook = ExcelExportUtil.exportExcel(params, stringObjectMap);
         PoiUtils.downLoadExcel(exportFileName, response, workbook);
         return true;
      } else if (contractAuditLedger.getPaymentEnum().equals(AuditPaymentEnum.INCOMING_INVOICES.getType())) {
         SupplierInvoiceSubOrderAuditDTO settlementEchoDtos = this.getSupplierSettlementEchoDtos(auditId);
         Map<String, Object> stringObjectMap = BeanUtil.beanToMap(settlementEchoDtos);
         List<SupplierSettlementEchoDto> echoDtoList = settlementEchoDtos.getSupplierSettlementEchoDtoList();
         stringObjectMap.put("paymentEnum", settlementEchoDtos.getPaymentEnum());
         stringObjectMap.put("passButton", settlementEchoDtos.getPassButton());
         stringObjectMap.put("projectAttribute", settlementEchoDtos.getProjectAttribute());
         stringObjectMap.put("basicClassName", BasicClassEnum.getNameByType(settlementEchoDtos.getBasicClass()));
         if (CollectionUtils.isNotEmpty(settlementEchoDtos.getSerialNumber())) {
            StringBuilder sb = new StringBuilder();

            for (String string : settlementEchoDtos.getSerialNumber()) {
               sb.append(string).append("+");
            }

            stringObjectMap.put("serialNumber", sb);
         }

         String resourcePath = "files/InputInvoice.xlsx";
         String tempFileName = "InputInvoice";
         String exportFileName = ProjectAttributeEnum.getNameByType(contractAuditLedger.getProjectAttribute())
            + AuditPaymentEnum.INCOMING_INVOICES.getName()
            + ".xlsx";
         List<AuditUserDTO> auditList = this.getAuditList(auditId);
         auditList.stream().forEach(item -> item.setApproveTypeName(ApproveTemplateVersionsFlowEnum.getName(item.getApproveType())));
         ClassPathResource resource = new ClassPathResource(resourcePath);
         File file = null;

         try (InputStream inputStream = resource.getInputStream()) {
            file = File.createTempFile(tempFileName, "xlsx");
            FileUtil.copyInputStreamToFile(inputStream, file);
         } catch (IOException e) {
            e.printStackTrace();
         }

         stringObjectMap.put("auditList", auditList);
         stringObjectMap.put("list", echoDtoList);
         TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
         params.setColForEach(true);
         Workbook workbook = ExcelExportUtil.exportExcel(params, stringObjectMap);
         PoiUtils.downLoadExcel(exportFileName, response, workbook);
         return true;
      } else if (contractAuditLedger.getPaymentEnum().equals(AuditPaymentEnum.OUTGOING_INVOICES.getType())) {
         InsourcingAuditDetail settlementEchoDtos = this.getInsourcingAuditDetail(auditId);
         Map<String, Object> stringObjectMap = BeanUtil.beanToMap(settlementEchoDtos);
         stringObjectMap.put("paymentEnum", settlementEchoDtos.getPaymentEnum());
         stringObjectMap.put("passButton", settlementEchoDtos.getPassButton());
         stringObjectMap.put("projectAttribute", settlementEchoDtos.getProjectAttribute());
         stringObjectMap.put("projectManagerName", settlementEchoDtos.getOutputInvoice().getProjectManagerName());
         if (ObjectUtils.isEmpty(settlementEchoDtos.getOutputInvoice().getProjectManagerName())) {
            ContractProject contractProject = projectMap.get(settlementEchoDtos.getOutputInvoice().getProjectId());
            String projectManagerName = "";
            if (contractProject.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
               projectManagerName = userMap.get(contractProject.getSalesLeaderId()).getName();
            } else {
               projectManagerName = userMap.get(contractProject.getProjectManagerId()).getName();
            }

            stringObjectMap.put("projectManagerName", projectManagerName);
         }

         String resourcePath = "files/OutputInvoice.xlsx";
         String tempFileName = "OutputInvoice";
         String exportFileName = AuditPaymentEnum.OUTGOING_INVOICES.getName() + ".xlsx";
         if (ObjectUtils.isNotEmpty(settlementEchoDtos.getOutputInvoice().getProjectId())) {
            ContractProject contractProject = projectMap.get(settlementEchoDtos.getOutputInvoice().getProjectId());
            exportFileName = contractProject.getShortName() + "-" + AuditPaymentEnum.OUTGOING_INVOICES.getName() + ".xlsx";
         }

         List<AuditUserDTO> auditList = this.getAuditList(auditId);
         auditList.stream().forEach(item -> item.setApproveTypeName(ApproveTemplateVersionsFlowEnum.getName(item.getApproveType())));
         ClassPathResource resource = new ClassPathResource(resourcePath);
         File file = null;

         try (InputStream inputStream = resource.getInputStream()) {
            file = File.createTempFile(tempFileName, "xlsx");
            FileUtil.copyInputStreamToFile(inputStream, file);
         } catch (IOException e) {
            e.printStackTrace();
         }

         stringObjectMap.put("auditList", auditList);
         TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
         params.setColForEach(true);
         Workbook workbook = ExcelExportUtil.exportExcel(params, stringObjectMap);
         PoiUtils.downLoadExcel(exportFileName, response, workbook);
         return true;
      } else {
         return Boolean.TRUE;
      }
   }

   @Override
   public PrintVO<List<ContractAuditLedgerDto>> printDownloadAll(ContractAuditLedgerQueryParam param) {
      List<ContractAuditLedger> ledgerList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractAuditLedger.class)
               .eq(param.getPaymentEnum() != null, ContractAuditLedger::getPaymentEnum, param.getPaymentEnum())
               .eq(param.getAuditStatusEnum() != null, ContractAuditLedger::getAuditStatusEnum, param.getAuditStatusEnum())
               .eq(param.getProjectAttribute() != null, ContractAuditLedger::getProjectAttribute, param.getProjectAttribute())
               .eq(param.getInitiatorId() != null, ContractAuditLedger::getInitiatorId, param.getInitiatorId())
               .eq(param.getProjectManagerId() != null, ContractAuditLedger::getProjectManagerId, param.getProjectManagerId())
               .eq(param.getSupplierId() != null, ContractAuditLedger::getSupplierId, param.getSupplierId())
               .eq(param.getWrittenById() != null, ContractAuditLedger::getWrittenById, param.getWrittenById())
               .like(param.getOaNumber() != null, ContractAuditLedger::getOaNumber, param.getOaNumber())
               .apply(param.getTime() != null, "date_format(filing_date,'%Y-%m') = date_format({0},'%Y-%m')", param.getTime())
               .apply(param.getProjectId() != null, "find_in_set({0}, project_id)", param.getProjectId())
               .orderByAsc(ContractAuditLedger::getAuditStatusEnum)
               .orderByDesc(BaseEntity::getCreateTime)
         );
      List<ContractAuditLedgerDto> contractAuditLedgerDtos = this.getContractAuditLedgerDtos(ledgerList);
      PrintVO<List<ContractAuditLedgerDto>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      YearMonth month = param.getTime() == null ? null : YearMonth.from(param.getTime());
      header.put("dateInterval", month == null ? "全部" : month.atDay(1) + "至" + month.atEndOfMonth());
      printVO.setHeader(header);
      printVO.setTable(contractAuditLedgerDtos);
      return printVO;
   }

   @Override
   public SelfemployedAuditDetail getSelfEmployedAuditDetail(Long auditId) {
      ContractAuditLedger contractAuditLedger = this.baseMapper
         .selectOne(Wrappers.lambdaQuery(ContractAuditLedger.class).eq(ContractAuditLedger::getId, auditId));
      Preconditions.checkArgument(contractAuditLedger != null, "审批信息不存在");
      Boolean button = false;
      if (contractAuditLedger.getApproveRecordId() != null) {
         button = this.procurementAudit(contractAuditLedger.getApproveRecordId());
      }

      List<SupplierPayment> supplierPaymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getId, Arrays.stream(contractAuditLedger.getPaymentId().split(",")).map(Long::valueOf).collect(Collectors.toList()))
         );
      Map<Long, SupplierPayment> paymentMap = supplierPaymentList.stream().collect(Collectors.toMap(SupplierPayment::getOrderId, Function.identity()));
      List<Long> contractIds = Arrays.stream(contractAuditLedger.getContractId().split(",")).map(Long::valueOf).collect(Collectors.toList());
      List<SupplierSelfEmployedDto> supplierPaymentDtoList = new ArrayList<>();
      if (contractAuditLedger.getAuditType() == null || AuditTypeEnum.PAYMENT_APPROVE.getType().equals(contractAuditLedger.getAuditType())) {
         SelfEmployedPaymentAndFinishDTO dto = this.supplierPaymentService.getSupplierPaymentList(contractIds);
         dto.getInvoiceDto().forEach(a -> {
            SupplierPayment supplierPayment = paymentMap.get(a.getOrderId());
            a.setPaymentAmount(supplierPayment.getPaymentAmount());
            if (!supplierPayment.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType())) {
               a.setIsStatus(Boolean.TRUE);
               a.setActualAmountPaid(supplierPayment.getActuallyPaymentAmount());
            } else {
               a.setIsStatus(Boolean.FALSE);
            }

            supplierPaymentDtoList.add(a);
         });
      }

      BigDecimal projectCollectionAmount = BigDecimal.ZERO;
      BigDecimal projectDisburseAmount = BigDecimal.ZERO;
      String subcontractClassName = null;
      if (AuditTypeEnum.SUB_CONTRACT_APPROVE.getType().equals(contractAuditLedger.getAuditType())) {
         List<SubcontractOrder> subcontractOrderList = this.subcontractOrderService.listByIds(contractIds);
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(subcontractOrderList), "分包订单不存在");
         subcontractClassName = subcontractOrderList.get(0).getSubcontractClassName();
         Map<Long, BigDecimal> orderIdPaymentAmountMap = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .in(SupplierPayment::getOrderId, contractIds)
                  .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .collect(
               Collectors.groupingBy(
                  SupplierPayment::getOrderId,
                  Collectors.mapping(SupplierPayment::getActuallyPaymentAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
               )
            );
         Map<Long, BigDecimal> orderIdInvoiceAmountMap = this.supplierInvoiceService
            .list(
               Wrappers.lambdaQuery(SupplierInvoice.class)
                  .in(SupplierInvoice::getOrderId, contractIds)
                  .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                  .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .collect(
               Collectors.groupingBy(
                  SupplierInvoice::getOrderId,
                  Collectors.mapping(SupplierInvoice::getActualInvoiceAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
               )
            );
         subcontractOrderList.forEach(
            order -> {
               SupplierPayment supplierPayment = paymentMap.get(order.getId());
               SupplierSelfEmployedDto dto = SupplierSelfEmployedDto.builder()
                  .orderId(order.getId())
                  .contractSignBodyId(order.getBranchCompanyId())
                  .contractSignBodyName(this.branchCompanyService.getNameById(order.getBranchCompanyId()))
                  .purchaseContractNumber(order.getSerialNumber())
                  .paymentAmountSum(orderIdPaymentAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO))
                  .invoiceAmountSum(orderIdInvoiceAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO))
                  .contractAmount(order.getAmount())
                  .paymentAmount(supplierPayment.getPaymentAmount())
                  .projectNames(this.projectService.getByIdFromCache(order.getProjectId()).getName())
                  .actualAmountPaid(supplierPayment.getActuallyPaymentAmount())
                  .isStatus(!supplierPayment.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()))
                  .build();
               supplierPaymentDtoList.add(dto);
            }
         );
         Set<Long> projectIds = subcontractOrderList.stream().map(SubcontractOrder::getProjectId).collect(Collectors.toSet());
         List<ContractProject> projectList = this.projectService.listByIds(projectIds);
         projectCollectionAmount = projectList.stream().map(ContractProject::getCollectionAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      }

      List<String> projectNameList = new ArrayList<>();
      if (ObjectUtils.isNotEmpty(contractAuditLedger.getProjectId())) {
         List<Long> longList = Arrays.stream(contractAuditLedger.getProjectId().split(",")).map(Long::valueOf).collect(Collectors.toList());
         List<ContractProject> projectList = this.projectService.list(Wrappers.lambdaQuery(ContractProject.class).in(ContractProject::getId, longList));
         projectNameList = projectList.stream().map(cp -> cp.getSerialNumber() + "_" + cp.getShortName()).collect(Collectors.toList());
      }

      User user = this.userService.getById(contractAuditLedger.getInitiatorId());
      Supplier supplier = this.supplierService.getById(contractAuditLedger.getSupplierId());
      String attachmentIds = supplierPaymentList.get(0).getAttachmentIds();
      List<AttachmentDTO> attachmentDtoList = this.attachmentService.listByIds(attachmentIds);
      SupplierAuditSelfEmployedDto selfEmployedDto = SupplierAuditSelfEmployedDto.builder()
         .list(supplierPaymentDtoList)
         .createDate(contractAuditLedger.getFilingDate())
         .createUserId(contractAuditLedger.getInitiatorId())
         .createUserName(user != null ? user.getName() : null)
         .branchCompanyName(supplierPaymentDtoList.stream().map(SupplierSelfEmployedDto::getContractSignBodyName).collect(Collectors.joining("/")))
         .supplierId(contractAuditLedger.getSupplierId())
         .supplierName(supplier != null ? supplier.getName() : null)
         .basicClassName(subcontractClassName)
         .projectName(projectNameList)
         .projectCollectionAmount(projectCollectionAmount)
         .projectDisburseAmount(projectDisburseAmount)
         .paymentAmount(supplierPaymentDtoList.stream().map(SupplierSelfEmployedDto::getPaymentAmount).reduce(BigDecimal.ZERO, BigDecimal::add))
         .totalPaymentAmount(supplierPaymentDtoList.stream().map(SupplierSelfEmployedDto::getPaymentAmountSum).reduce(BigDecimal.ZERO, BigDecimal::add))
         .amount(supplierPaymentDtoList.stream().map(SupplierSelfEmployedDto::getContractAmount).reduce(BigDecimal.ZERO, BigDecimal::add))
         .serialNumber(Arrays.stream(contractAuditLedger.getContractNumber().split(",")).collect(Collectors.toList()))
         .paymentBank(supplierPaymentList.get(0).getPaymentBank())
         .paymentBankAccount(supplierPaymentList.get(0).getPaymentBankAccount())
         .paymentType(supplierPaymentList.get(0).getPaymentReasonId() != null ? Integer.valueOf(supplierPaymentList.get(0).getPaymentReasonId()) : null)
         .paymentDate(supplierPaymentList.get(0).getPaymentDate())
         .paymentAttributeId(supplierPaymentList.get(0).getPaymentAttributeId())
         .paymentAttributeName(supplierPaymentList.get(0).getPaymentAttributeName())
         .remark(supplierPaymentList.get(0).getRemark())
         .attachmentIds(attachmentIds)
         .attachmentDtoList(attachmentDtoList)
         .attachments(attachmentDtoList)
         .build();
      return SelfemployedAuditDetail.builder()
         .paymentEnum(contractAuditLedger.getPaymentEnum())
         .passButton(false)
         .projectAttribute(ProjectAttributeEnum.SELF_SUPPORT.getType())
         .supplierAuditSelfEmployedDto(selfEmployedDto)
         .boolFinalApprover(this.getBoolFinalApprove(auditId))
         .build();
   }

   @Override
   public InsourcingAuditDetail getInsourcingAuditDetail(Long auditId) {
      ContractAuditLedger contractAuditLedger = this.baseMapper
         .selectOne(Wrappers.lambdaQuery(ContractAuditLedger.class).eq(ContractAuditLedger::getId, auditId));
      Preconditions.checkArgument(contractAuditLedger != null, "审批信息不存在");
      Boolean button = this.procurementAudit(contractAuditLedger.getApproveRecordId());
      ContractInvoice projectInvoice = this.contractInvoiceService
         .getOne(Wrappers.lambdaQuery(ContractInvoice.class).eq(ContractInvoice::getId, contractAuditLedger.getPaymentId()));
      Preconditions.checkArgument(projectInvoice != null, "发票记录不存在!");
      ContractProject project = this.projectService.getById(projectInvoice.getProjectId());
      Preconditions.checkArgument(project != null, "发票项目数据不存在!");
      ProjectOutputInvoiceDto invoiceDto = ProjectOutputInvoiceDto.builder()
         .applyDate(projectInvoice.getInvoiceDate())
         .applyUserId(projectInvoice.getWrittenById())
         .applyName(projectInvoice.getWrittenByName())
         .auditorId(projectInvoice.getAuditorId())
         .auditorName(projectInvoice.getAuditorName())
         .applyAmount(
            projectInvoice.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())
               ? projectInvoice.getActualInvoiceAmount()
               : projectInvoice.getInvoiceAmount()
         )
         .actualInvoiceAmount(projectInvoice.getActualInvoiceAmount())
         .projectId(projectInvoice.getProjectId())
         .taxRateTypeValue(projectInvoice.getTaxRateTypeValue())
         .taxRate(projectInvoice.getTaxRate())
         .invoiceNumber(projectInvoice.getInvoiceNo())
         .invoiceType(projectInvoice.getInvoiceType())
         .projectName(project.getSerialNumber() + project.getShortName())
         .branchCompanyId(project.getContractSignBodyId())
         .branchCompanyName(this.branchCompanyService.getNameById(project.getContractSignBodyId()))
         .invoiceUnitId(projectInvoice.getInvoiceUnitId())
         .invoiceUnit(projectInvoice.getInvoiceUnit())
         .collectionUnit(projectInvoice.getCollectionUnit())
         .amount(project.getContractAmount())
         .invoiceAmount(project.getInvoiceAmount())
         .paymentAmount(project.getCollectionAmount())
         .attachmentIds(projectInvoice.getAttachments())
         .attachmentList(this.attachmentService.listByIds(projectInvoice.getAttachments()))
         .attachments(this.attachmentService.listByIds(projectInvoice.getAttachments()))
         .remark(projectInvoice.getRemark())
         .build();
      if (!project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         invoiceDto.setProjectManagerId(project.getProjectManagerId());
         invoiceDto.setProjectManagerName(this.userService.getNameById(project.getProjectManagerId()));
      } else {
         Long salesLeaderId = project.getSalesLeaderId() != null ? project.getSalesLeaderId() : project.getSignerId();
         invoiceDto.setSalesLeaderId(salesLeaderId);
         invoiceDto.setSalesLeaderName(this.userService.getNameById(salesLeaderId));
      }

      return InsourcingAuditDetail.builder()
         .passButton(button)
         .paymentEnum(contractAuditLedger.getPaymentEnum())
         .projectAttribute(contractAuditLedger.getProjectAttribute())
         .outputInvoice(invoiceDto)
         .boolFinalApprover(this.getBoolFinalApprove(auditId))
         .build();
   }

   @Override
   public InsourcingDetailAuditDetail getInsourcingDetailAuditDetail(Long auditId) {
      ContractAuditLedger contractAuditLedger = this.baseMapper
         .selectOne(Wrappers.lambdaQuery(ContractAuditLedger.class).eq(ContractAuditLedger::getId, auditId));
      Preconditions.checkArgument(contractAuditLedger != null, "审批信息不存在");
      Boolean button = this.procurementAudit(contractAuditLedger.getApproveRecordId());
      Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      ContractProject project = null;
      BigDecimal projectSupplierAmount = BigDecimal.ZERO;
      BigDecimal supplierAmount = BigDecimal.ZERO;
      Long supplierId = null;
      Long branchCompanyId = null;
      Integer type = null;
      String serialNumber = null;
      if (contractAuditLedger.getPaymentEnum().equals(AuditPaymentEnum.PROCUREMENT_PAYMENT.getType())) {
         PurchaseOrder purchaseOrder = this.purchaseOrderService
            .getOne(Wrappers.lambdaQuery(PurchaseOrder.class).eq(PurchaseOrder::getId, contractAuditLedger.getContractId()));
         Preconditions.checkArgument(purchaseOrder != null, "采购订单不存在");
         if (StringUtils.isNotBlank(purchaseOrder.getProjectIds())) {
            String[] split = purchaseOrder.getProjectIds().split(",");
            project = this.projectService.getById(split[0]);
         }

         List<SupplierPayment> paymentList = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .eq(SupplierPayment::getProjectId, project.getId())
                  .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            );
         projectSupplierAmount = paymentList.stream()
            .map(SupplierPayment::getActuallyPaymentAmount)
            .filter(ObjectUtils::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         supplierAmount = paymentList.stream()
            .filter(supplier -> supplier.getOrderId().equals(purchaseOrder.getId()))
            .map(SupplierPayment::getActuallyPaymentAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         supplierId = purchaseOrder.getSupplierId();
         branchCompanyId = purchaseOrder.getBranchCompanyId();
         type = purchaseOrder.getBasicClass();
         serialNumber = purchaseOrder.getSerialNumber();
      } else if (contractAuditLedger.getPaymentEnum().equals(AuditPaymentEnum.SUBCONTRACT_PAYMENT.getType())) {
         SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(contractAuditLedger.getContractId());
         Preconditions.checkArgument(ObjectUtils.isNotEmpty(subcontractOrder), "分包订单不存在");
         if (ObjectUtils.isNotEmpty(subcontractOrder.getProjectId())) {
            project = this.projectService.getById(subcontractOrder.getProjectId());
         }

         List<SupplierPayment> paymentList = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .eq(SupplierPayment::getProjectId, project.getId())
                  .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            );
         projectSupplierAmount = paymentList.stream()
            .map(SupplierPayment::getActuallyPaymentAmount)
            .filter(ObjectUtils::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         supplierAmount = paymentList.stream()
            .filter(supplier -> supplier.getOrderId().equals(subcontractOrder.getId()))
            .map(SupplierPayment::getActuallyPaymentAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         supplierId = subcontractOrder.getSupplierId();
         branchCompanyId = subcontractOrder.getBranchCompanyId();
         type = Math.toIntExact(subcontractOrder.getSubcontractClassId());
         serialNumber = subcontractOrder.getSerialNumber();
      }

      if (contractAuditLedger.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
         Preconditions.checkArgument(ObjectUtils.isNotEmpty(project), "项目不存在");
      }

      ContractGivingCredit givingCredit = this.givingCreditService
         .getOne(
            Wrappers.lambdaQuery(ContractGivingCredit.class)
               .eq(ContractGivingCredit::getAccreditingPartyId, project.getProjectManagerId())
               .eq(ContractGivingCredit::getProjectId, project.getId())
               .eq(ContractGivingCredit::getStatus, 0)
         );
      BigDecimal remainingSum = givingCredit != null ? givingCredit.getRemainingSum() : BigDecimal.ZERO;
      List<SecurityDepositAndManagementCost> costList = this.costService
         .list(Wrappers.lambdaQuery(SecurityDepositAndManagementCost.class).eq(SecurityDepositAndManagementCost::getProjectId, project.getId()));
      if (CollectionUtils.isNotEmpty(costList)) {
         Map<Integer, List<SecurityDepositAndManagementCost>> listMap = costList.stream()
            .collect(Collectors.groupingBy(SecurityDepositAndManagementCost::getAmountType));
         BigDecimal securityDeductIncome = CollectionUtils.isNotEmpty(listMap.get(1))
            ? listMap.get(1)
               .stream()
               .filter(a -> ObjectUtils.isNotEmpty(a.getSecurityDeductIncome()))
               .map(SecurityDepositAndManagementCost::getSecurityDeductIncome)
               .reduce(BigDecimal.ZERO, BigDecimal::add)
            : BigDecimal.ZERO;
         BigDecimal securityRecord = CollectionUtils.isNotEmpty(listMap.get(1))
            ? listMap.get(1)
               .stream()
               .filter(a -> ObjectUtils.isNotEmpty(a.getSecurityRecord()))
               .map(SecurityDepositAndManagementCost::getSecurityRecord)
               .reduce(BigDecimal.ZERO, BigDecimal::add)
            : BigDecimal.ZERO;
         BigDecimal managementDeductIncome = CollectionUtils.isNotEmpty(listMap.get(2))
            ? listMap.get(2)
               .stream()
               .filter(a -> ObjectUtils.isNotEmpty(a.getManagementDeductIncome()))
               .map(SecurityDepositAndManagementCost::getManagementDeductIncome)
               .reduce(BigDecimal.ZERO, BigDecimal::add)
            : BigDecimal.ZERO;
         BigDecimal managementRecord = CollectionUtils.isNotEmpty(listMap.get(2))
            ? listMap.get(2)
               .stream()
               .filter(a -> ObjectUtils.isNotEmpty(a.getManagementRecord()))
               .map(SecurityDepositAndManagementCost::getManagementRecord)
               .reduce(BigDecimal.ZERO, BigDecimal::add)
            : BigDecimal.ZERO;
         projectSupplierAmount = projectSupplierAmount.add(securityDeductIncome.subtract(securityRecord).add(managementDeductIncome.subtract(managementRecord)));
      }

      BigDecimal collectionSummary = BigDecimal.ZERO;
      BigDecimal projectCollectionSummary = BigDecimal.ZERO;
      BigDecimal projectManagerAmount = BigDecimal.ZERO;
      BigDecimal projectManagerPayment = BigDecimal.ZERO;
      BigDecimal contractSignBodyAmount = BigDecimal.ZERO;
      BigDecimal contractSignBodyPayment = BigDecimal.ZERO;
      if (contractAuditLedger.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
         projectCollectionSummary = ObjectUtils.isNotEmpty(project.getCollectionSummary()) ? project.getCollectionSummary() : BigDecimal.ZERO;
         collectionSummary = this.projectService
            .list(
               Wrappers.lambdaQuery(ContractProject.class)
                  .eq(ContractProject::getProjectManagerId, project.getProjectManagerId())
                  .eq(ContractProject::getProjectAttribute, contractAuditLedger.getProjectAttribute())
            )
            .stream()
            .map(ContractProject::getCollectionSummary)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         List<ContractProjectAssetInjection> injectionList = this.assetInjectionService
            .list(Wrappers.lambdaQuery(ContractProjectAssetInjection.class).eq(ContractProjectAssetInjection::getProjectId, project.getId()));
         if (CollectionUtils.isNotEmpty(injectionList)) {
            Map<Boolean, List<ContractProjectAssetInjection>> isList = injectionList.stream()
               .collect(Collectors.groupingBy(ContractProjectAssetInjection::getIncomeOrDisburse));
            projectManagerAmount = CollectionUtils.isNotEmpty(isList.get(Boolean.TRUE))
               ? isList.get(Boolean.TRUE)
                  .stream()
                  .filter(a -> ObjectUtils.isNotEmpty(a.getProjectManagerId()))
                  .map(ContractProjectAssetInjection::getProjectManagerScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
            projectManagerPayment = CollectionUtils.isNotEmpty(isList.get(Boolean.FALSE))
               ? isList.get(Boolean.FALSE)
                  .stream()
                  .filter(a -> ObjectUtils.isNotEmpty(a.getProjectManagerId()))
                  .map(ContractProjectAssetInjection::getProjectManagerScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
            contractSignBodyAmount = CollectionUtils.isNotEmpty(isList.get(Boolean.TRUE))
               ? isList.get(Boolean.TRUE)
                  .stream()
                  .filter(a -> ObjectUtils.isNotEmpty(a.getContractSignBodyId()))
                  .map(ContractProjectAssetInjection::getContractSignBodyScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
            contractSignBodyPayment = CollectionUtils.isNotEmpty(isList.get(Boolean.FALSE))
               ? isList.get(Boolean.FALSE)
                  .stream()
                  .filter(a -> ObjectUtils.isNotEmpty(a.getContractSignBodyId()))
                  .map(ContractProjectAssetInjection::getContractSignBodyScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
            collectionSummary = collectionSummary.add(projectManagerAmount.add(contractSignBodyAmount))
               .subtract(projectManagerPayment.add(contractSignBodyPayment));
         }
      } else {
         projectCollectionSummary = ObjectUtils.isNotEmpty(project.getProjectManagerAmount())
            ? project.getProjectManagerAmount()
               .add(ObjectUtils.isNotEmpty(project.getContractSignBodyAmount()) ? project.getContractSignBodyAmount() : BigDecimal.ZERO)
            : (ObjectUtils.isNotEmpty(project.getContractSignBodyAmount()) ? project.getContractSignBodyAmount() : BigDecimal.ZERO);
         collectionSummary = collectionSummary.add(project.getProjectManagerAmount().add(project.getContractSignBodyAmount()));
         List<ContractProjectAssetInjection> injectionList = this.assetInjectionService
            .list(Wrappers.lambdaQuery(ContractProjectAssetInjection.class).eq(ContractProjectAssetInjection::getProjectId, project.getId()));
         if (CollectionUtils.isNotEmpty(injectionList)) {
            Map<Boolean, List<ContractProjectAssetInjection>> isList = injectionList.stream()
               .collect(Collectors.groupingBy(ContractProjectAssetInjection::getIncomeOrDisburse));
            projectManagerAmount = CollectionUtils.isNotEmpty(isList.get(Boolean.TRUE))
               ? isList.get(Boolean.TRUE)
                  .stream()
                  .filter(a -> ObjectUtils.isNotEmpty(a.getProjectManagerId()) && ObjectUtils.isNotEmpty(a.getProjectManagerScale()))
                  .map(ContractProjectAssetInjection::getProjectManagerScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
            projectManagerPayment = CollectionUtils.isNotEmpty(isList.get(Boolean.FALSE))
               ? isList.get(Boolean.FALSE)
                  .stream()
                  .filter(a -> ObjectUtils.isNotEmpty(a.getProjectManagerId()) && ObjectUtils.isNotEmpty(a.getProjectManagerScale()))
                  .map(ContractProjectAssetInjection::getProjectManagerScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
            contractSignBodyAmount = CollectionUtils.isNotEmpty(isList.get(Boolean.TRUE))
               ? isList.get(Boolean.TRUE)
                  .stream()
                  .filter(a -> ObjectUtils.isNotEmpty(a.getContractSignBodyId()) && ObjectUtils.isNotEmpty(a.getContractSignBodyScale()))
                  .map(ContractProjectAssetInjection::getContractSignBodyScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
            contractSignBodyPayment = CollectionUtils.isNotEmpty(isList.get(Boolean.FALSE))
               ? isList.get(Boolean.FALSE)
                  .stream()
                  .filter(a -> ObjectUtils.isNotEmpty(a.getContractSignBodyId()) && ObjectUtils.isNotEmpty(a.getContractSignBodyScale()))
                  .map(ContractProjectAssetInjection::getContractSignBodyScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
            collectionSummary = collectionSummary.add(projectManagerAmount.add(contractSignBodyAmount))
               .subtract(projectManagerPayment.add(contractSignBodyPayment));
         }
      }

      SupplierPayment supplierPayment = this.supplierPaymentService
         .getOne(Wrappers.lambdaQuery(SupplierPayment.class).eq(SupplierPayment::getId, contractAuditLedger.getPaymentId()));
      ProjectSupplierDto supplierDto = ProjectSupplierDto.builder()
         .project(
            ProjectInfo.builder().id(project.getId()).name(project.getName()).shortName(project.getShortName()).serialNumber(project.getSerialNumber()).build()
         )
         .createTime(contractAuditLedger.getCreateTime())
         .contractAmount(project.getContractAmount())
         .projectAttribute(project.getProjectAttribute())
         .personalCredit(remainingSum)
         .collectionSummary(project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType()) ? null : collectionSummary)
         .projectIncome(project.getCollectionAmount())
         .projectExpenditure(projectSupplierAmount)
         .contractExpenditure(supplierAmount)
         .contractCollectionSummary(
            projectCollectionSummary.add(projectManagerAmount.add(contractSignBodyAmount)).subtract(projectManagerPayment.add(contractSignBodyPayment))
         )
         .contractSignBodyId(project.getContractSignBodyId())
         .contractSignBodyName(branchCompanyMap.get(contractAuditLedger.getContractSignBodyId()).getName())
         .projectManagerName(userMap.get(contractAuditLedger.getProjectManagerId()).getName())
         .supplierName(supplierMap.get(supplierId).getName())
         .branchCompanyId(branchCompanyId)
         .paymentAmount(supplierPayment.getPaymentAmount())
         .paymentBank(supplierPayment.getPaymentBank())
         .paymentDate(supplierPayment.getPaymentDate())
         .paymentBankAccount(supplierPayment.getPaymentBankAccount())
         .paymentType(supplierPayment.getPaymentReasonId() != null ? Integer.valueOf(supplierPayment.getPaymentReasonId()) : null)
         .serialNumber(Arrays.asList(serialNumber))
         .amount(project.getContractAmount())
         .attachmentIds(supplierPayment.getAttachmentIds())
         .userName(userMap.get(supplierPayment.getApplyUserId()).getName())
         .build();
      if (contractAuditLedger.getPaymentEnum().equals(AuditPaymentEnum.SUBCONTRACT_PAYMENT.getType())) {
         supplierDto.setSubcontractClassId((long)type.intValue());
      } else {
         supplierDto.setBasicClass(type);
      }

      if (contractAuditLedger.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         supplierDto.setActualPayment(supplierPayment.getActuallyPaymentAmount());
      }

      if (StringUtils.isNotBlank(supplierPayment.getAttachmentIds())) {
         List<Long> attachmentId = Arrays.stream(supplierPayment.getAttachmentIds().split(",")).map(Long::parseLong).collect(Collectors.toList());
         supplierDto.setAttachmentId(attachmentId.get(0));
         List<AttachmentDTO> attachmentDTOList = this.attachmentService.listByIds(supplierPayment.getAttachmentIds());
         supplierDto.setAttachmentDto(attachmentDTOList.isEmpty() ? null : attachmentDTOList.get(0));
      }

      return InsourcingDetailAuditDetail.builder()
         .paymentEnum(contractAuditLedger.getPaymentEnum())
         .projectAttribute(project.getProjectAttribute())
         .passButton(button)
         .projectSupplierDto(supplierDto)
         .build();
   }

   public Boolean procurementAudit(Long approveRecordId) {
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(approveRecordId);
      List<WmsApproveRecordDetail> wmsApproveRecordDetailsUnderway = this.approveRecordDetailService
         .list(
            (Wrapper<WmsApproveRecordDetail>)(new LambdaQueryWrapper<WmsApproveRecordDetail>()
                  .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, wmsApproveRecord.getSerialNumber()))
               .eq(WmsApproveRecordDetail::getStatus, ApproveRecordStatusEnum.UNDERWAY.getType())
         );
      if (CollectionUtils.isNotEmpty(wmsApproveRecordDetailsUnderway)) {
         WmsApproveRecordDetail wmsApproveRecordDetail1 = wmsApproveRecordDetailsUnderway.stream()
            .filter(w -> ObjectUtil.isNotEmpty(w.getCheckUserId()) && w.getCheckUserId().equals(UserUtil.getCurrentUserId()))
            .findAny()
            .orElse(null);
         return ObjectUtil.isNotEmpty(wmsApproveRecordDetail1);
      } else {
         return false;
      }
   }

   @Override
   public SupplierInvoicePurchaseAuditDTO getPurchaseInvoiceAuditInfo(Long auditId) {
      ContractAuditLedger contractAuditLedger = this.baseMapper
         .selectOne(Wrappers.lambdaQuery(ContractAuditLedger.class).eq(ContractAuditLedger::getId, auditId));
      Preconditions.checkArgument(contractAuditLedger != null, "审批信息不存在");
      List<Long> supplierInvoiceIds = Arrays.stream(contractAuditLedger.getPaymentId().split(",")).map(Long::valueOf).collect(Collectors.toList());
      List<SupplierInvoice> supplierInvoiceList = this.supplierInvoiceService.listByIds(supplierInvoiceIds);
      Map<Long, SupplierInvoice> orderIdSupplierInvoiceMap = supplierInvoiceList.stream()
         .collect(Collectors.toMap(SupplierInvoice::getOrderId, Function.identity()));
      List<Long> orderIds = Arrays.stream(contractAuditLedger.getContractId().split(",")).map(Long::valueOf).collect(Collectors.toList());
      List<PurchaseOrder> purchaseOrderList = this.purchaseOrderService.listByIds(orderIds);
      List<String> projectNameList = this.projectService
         .listByIds(contractAuditLedger.getProjectId())
         .stream()
         .map(ProjectInfo::getShortName)
         .collect(Collectors.toList());
      Map<Long, BigDecimal> orderIdPaymentAmountMap = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getOrderId, orderIds)
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(SupplierPayment::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add))
         );
      Map<Long, BigDecimal> orderIdInvoiceAmountMap = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .in(SupplierInvoice::getOrderId, orderIds)
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(SupplierInvoice::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierInvoice::getActualInvoiceAmount, BigDecimal::add))
         );
      Boolean button = this.procurementAudit(contractAuditLedger.getApproveRecordId());
      Set<Integer> basicClassList = purchaseOrderList.stream().map(PurchaseOrder::getBasicClass).collect(Collectors.toSet());
      int basicClass = 0;

      for (Integer bs : basicClassList) {
         if (basicClass == 0) {
            basicClass = bs;
         } else {
            basicClass |= bs;
         }
      }

      SupplierInvoicePurchaseAuditDTO supplierInvoicePurchaseAuditDTO = SupplierInvoicePurchaseAuditDTO.builder()
         .passButton(button)
         .paymentEnum(contractAuditLedger.getPaymentEnum())
         .applyUserId(contractAuditLedger.getInitiatorId())
         .applyUserName(this.userService.getNameById(contractAuditLedger.getInitiatorId()))
         .projectName(projectNameList.isEmpty() ? null : StringUtils.join(projectNameList, ","))
         .projectAttribute(contractAuditLedger.getProjectAttribute())
         .serialNumber(Arrays.stream(contractAuditLedger.getContractNumber().split("/")).collect(Collectors.toList()))
         .supplierName(this.supplierService.getNameById(contractAuditLedger.getSupplierId()))
         .basicClass(basicClass)
         .invoiceSerialNumber(supplierInvoiceList.get(0).getInvoiceSerialNumber())
         .invoiceAmount(supplierInvoiceList.stream().map(SupplierInvoice::getInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add))
         .actualInvoiceAmount(contractAuditLedger.getActuallyPayAmount())
         .remark(supplierInvoiceList.get(0).getRemark())
         .attachments(this.attachmentService.listByIds(supplierInvoiceList.get(0).getAttachmentIds()))
         .boolFinalApprover(this.getBoolFinalApprove(auditId))
         .build();
      Map<Long, BigDecimal> purchaseInboundAmountMap = this.inboundService.getPurchaseActualInboundAmountMap(orderIds);
      List<SupplierSelfEmployedDto> orderInvoiceList = purchaseOrderList.stream()
         .map(
            purchaseOrder -> {
               SupplierInvoice supplierInvoice = orderIdSupplierInvoiceMap.get(purchaseOrder.getId());
               BranchCompany company = this.branchCompanyService.getById(purchaseOrder.getBranchCompanyId());
               return SupplierSelfEmployedDto.builder()
                  .orderId(purchaseOrder.getId())
                  .contractSignBodyId(purchaseOrder.getBranchCompanyId())
                  .contractSignBodyName(company == null ? "/" : (StringUtils.isNotBlank(company.getShortName()) ? company.getShortName() : company.getName()))
                  .purchaseContractNumber(purchaseOrder.getSerialNumber())
                  .contractAmount(purchaseOrder.getAmount())
                  .inboundAmountSum(purchaseInboundAmountMap.get(purchaseOrder.getId()))
                  .storageAmountSum(purchaseInboundAmountMap.get(purchaseOrder.getId()))
                  .paymentAmountSum(orderIdPaymentAmountMap.getOrDefault(purchaseOrder.getId(), BigDecimal.ZERO))
                  .invoiceAmountSum(orderIdInvoiceAmountMap.getOrDefault(purchaseOrder.getId(), BigDecimal.ZERO))
                  .invoiceAmount(supplierInvoice.getInvoiceAmount())
                  .actualInvoiceAmount(supplierInvoice.getActualInvoiceAmount())
                  .isStatus(!contractAuditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()))
                  .build();
            }
         )
         .collect(Collectors.toList());
      supplierInvoicePurchaseAuditDTO.setOrderInvoiceList(orderInvoiceList);
      return supplierInvoicePurchaseAuditDTO;
   }

   @Override
   public SupplierInvoiceSubOrderAuditDTO getSupplierSettlementEchoDtos(Long auditId) {
      ContractAuditLedger contractAuditLedger = this.baseMapper
         .selectOne(Wrappers.lambdaQuery(ContractAuditLedger.class).eq(ContractAuditLedger::getId, auditId));
      Preconditions.checkArgument(contractAuditLedger != null, "审批信息不存在");
      SupplierInvoice serviceOne = this.supplierInvoiceService
         .getOne(Wrappers.lambdaQuery(SupplierInvoice.class).eq(SupplierInvoice::getId, contractAuditLedger.getPaymentId()));
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(serviceOne), "审批单未获取开票信息");
      Boolean button = this.procurementAudit(contractAuditLedger.getApproveRecordId());
      SupplierInvoiceSubOrderAuditDTO build = SupplierInvoiceSubOrderAuditDTO.builder()
         .passButton(button)
         .paymentEnum(contractAuditLedger.getPaymentEnum())
         .projectAttribute(contractAuditLedger.getProjectAttribute())
         .build();
      if (contractAuditLedger.getAuditType().equals(AuditTypeEnum.PAYMENT_APPROVE.getType())) {
         PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(serviceOne.getOrderId());
         Preconditions.checkArgument(purchaseOrder != null, "采购订单不存在!");
         BranchCompany branchCompany = this.branchCompanyService.getById(purchaseOrder.getBranchCompanyId());
         Supplier supplier = this.supplierService.getById(purchaseOrder.getSupplierId());
         build.setBranchCompanyName(branchCompany != null ? branchCompany.getName() : "");
         build.setAmount(purchaseOrder.getAmount());
         build.setBasicClass(purchaseOrder.getBasicClass());
         build.setSettlementAmount(purchaseOrder.getSettlementAmount());
         build.setSupplierName(supplier != null ? supplier.getName() : "");
         if (StringUtils.isNotBlank(purchaseOrder.getProjectIds())) {
            Set<Long> projectIds = Arrays.stream(StringUtils.split(purchaseOrder.getProjectIds(), ",")).map(Long::valueOf).collect(Collectors.toSet());
            List<ContractProject> projectList = this.projectService.listByIds(projectIds);
            Set<String> salesLeaderNameList = new HashSet<>();
            Set<String> projectManagerNameList = new HashSet<>();
            List<String> projectNameList = new ArrayList<>();
            projectList.forEach(cp -> {
               if (cp.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
                  Long salesLeaderIdx = cp.getSalesLeaderId() != null ? cp.getSalesLeaderId() : cp.getSignerId();
                  String salesLeaderName = this.userService.getNameById(salesLeaderIdx);
                  if (StringUtils.isNotBlank(salesLeaderName)) {
                     salesLeaderNameList.add(salesLeaderName);
                  }
               } else {
                  String projectManagerName = this.userService.getNameById(cp.getProjectManagerId());
                  if (StringUtils.isNotBlank(projectManagerName)) {
                     projectManagerNameList.add(projectManagerName);
                  }
               }

               projectNameList.add(cp.getName());
            });
            build.setSalesLeaderName(StringUtils.join(salesLeaderNameList, "/"));
            build.setProjectManagerName(StringUtils.join(projectManagerNameList, "/"));
            build.setProjectName(StringUtils.join(projectNameList, "/"));
         }
      } else {
         if (!contractAuditLedger.getAuditType().equals(AuditTypeEnum.SUB_CONTRACT_APPROVE.getType())) {
            throw new BusinessException("审批单类型有误!");
         }

         SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(serviceOne.getOrderId());
         Preconditions.checkArgument(subcontractOrder != null, "采购订单不存在!");
         BranchCompany branchCompany = this.branchCompanyService.getById(subcontractOrder.getBranchCompanyId());
         ContractProject project = this.projectService.getById(subcontractOrder.getProjectId());
         Preconditions.checkArgument(project != null, "分包订单所属项目不存在!");
         Supplier supplier = this.supplierService.getById(subcontractOrder.getSupplierId());
         build.setBranchCompanyName(branchCompany != null ? branchCompany.getName() : "");
         build.setProjectName(project.getName());
         build.setAmount(subcontractOrder.getAmount());
         build.setSettlementAmount(subcontractOrder.getSettlementAmount());
         build.setSupplierName(supplier != null ? supplier.getName() : "");
         build.setBasicClass(subcontractOrder.getSubcontractClassId().intValue());
         SubSupplyTypeEnum supplyTypeEnum = SubSupplyTypeEnum.getByType(subcontractOrder.getSubcontractClassId());
         build.setBasicClassName(supplyTypeEnum != null ? supplyTypeEnum.getName() : "");
         if (project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
            Long salesLeaderId = project.getSalesLeaderId() != null ? project.getSalesLeaderId() : project.getSignerId();
            build.setSalesLeaderName(this.userService.getNameById(salesLeaderId));
         } else {
            build.setProjectManagerName(this.userService.getNameById(project.getProjectManagerId()));
         }
      }

      List<SupplierSettlementEchoDto> dtoList = new ArrayList<>();
      List<SupplierPayment> paymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(SupplierPayment::getOrderId, contractAuditLedger.getContractId())
         );
      paymentList.forEach(
         a -> {
            SupplierSettlementEchoDto settlementEchoDto = new SupplierSettlementEchoDto()
               .setPaymentAmount(a.getActuallyPaymentAmount())
               .setPaymentDate(a.getPaymentDate().atStartOfDay());
            dtoList.add(settlementEchoDto);
         }
      );
      List<SupplierInvoice> invoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, contractAuditLedger.getContractId())
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      invoiceList.forEach(
         a -> {
            SupplierSettlementEchoDto settlementEchoDto = new SupplierSettlementEchoDto()
               .setInvoiceDate(a.getReceiveInvoiceDate().atStartOfDay())
               .setInvoiceAmount(a.getActualInvoiceAmount());
            dtoList.add(settlementEchoDto);
         }
      );
      List<AttachmentDTO> attachmentDTOList = this.attachmentService.listByIds(serviceOne.getAttachmentIds());
      build.setAttachments(attachmentDTOList);
      build.setApplyUserId(serviceOne.getApplyUserId());
      build.setApplyUserName(this.userService.getNameById(serviceOne.getApplyUserId()));
      build.setSupplierSettlementEchoDtoList(dtoList);
      build.setInvoiceAmount(
         serviceOne.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()) ? serviceOne.getActualInvoiceAmount() : serviceOne.getInvoiceAmount()
      );
      build.setSerialNumber(Collections.singletonList(serviceOne.getInvoiceSerialNumber()));
      build.setInvoiceSerialNumber(serviceOne.getInvoiceSerialNumber());
      build.setRemark(serviceOne.getRemark());
      build.setBoolFinalApprover(this.getBoolFinalApprove(auditId));
      return build;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean procurementSelfAudit(AddContractAuditDtoParam param) {
      ContractAuditLedger contractAuditLedger = this.baseMapper.selectById(param.getAuditId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(contractAuditLedger), "审批单不存在");
      Preconditions.checkArgument(contractAuditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "审核状态有误");
      List<Long> paymentIdList = Arrays.stream(contractAuditLedger.getPaymentId().split(",")).map(Long::valueOf).collect(Collectors.toList());
      List<SupplierPayment> paymentList = this.supplierPaymentService
         .list(Wrappers.lambdaQuery(SupplierPayment.class).in(SupplierPayment::getId, paymentIdList));
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(paymentList), "付款信息不存在");
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(contractAuditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(contractAuditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         Preconditions.checkArgument(param.getSupplierPayment() != null, "付款信息不能为空");
         Map<Long, BigDecimal> map = param.getSupplierPayment()
            .stream()
            .collect(Collectors.toMap(saveSupplierPaymentDto::getSupplierPaymentId, saveSupplierPaymentDto::getMoneyAmount));
         List<Long> orderIdList = Arrays.stream(contractAuditLedger.getContractId().split(",")).map(Long::valueOf).collect(Collectors.toList());
         Map<Long, PurchaseOrder> orderMap = this.purchaseOrderService
            .listByIds(orderIdList)
            .stream()
            .collect(Collectors.toMap(PurchaseOrder::getId, Function.identity()));
         Map<Long, BigDecimal> orderIdPaymentAmountMap = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .in(SupplierPayment::getOrderId, orderIdList)
                  .in(
                     SupplierPayment::getPropertyType,
                     SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(),
                     SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
                  )
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .collect(
               Collectors.groupingBy(
                  SupplierPayment::getOrderId,
                  Collectors.mapping(SupplierPayment::getActuallyPaymentAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
               )
            );
         Map<Long, SupplierSettlement> orderIdSettleMap = this.supplierSettlementService
            .list(
               Wrappers.lambdaQuery(SupplierSettlement.class)
                  .in(SupplierSettlement::getOrderId, orderIdList)
                  .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
                  .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
            )
            .stream()
            .collect(Collectors.toMap(SupplierSettlement::getOrderId, Function.identity()));
         paymentList.forEach(
            supplierPayment -> {
               BigDecimal actuallyPaymentAmount = map.get(supplierPayment.getOrderId());
               Preconditions.checkArgument(actuallyPaymentAmount != null, "实付金额不能为空!");
               BigDecimal paymentAmount = orderIdPaymentAmountMap.getOrDefault(supplierPayment.getOrderId(), BigDecimal.ZERO);
               PurchaseOrder order = orderMap.get(supplierPayment.getOrderId());
               Preconditions.checkArgument(order != null, "未查询到订单数据!");
               if (order.getSettlementStatus() == null || order.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())) {
                  if (!financeAmountLimitConfig.getBoolAllowOverContractAmount()) {
                     Preconditions.checkArgument(actuallyPaymentAmount.add(paymentAmount).compareTo(order.getAmount()) <= 0, "订单付款总额不能超过订单合同额!");
                  }

                  if (!financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
                     SupplierSettlement settlement = orderIdSettleMap.get(supplierPayment.getOrderId());
                     Preconditions.checkArgument(
                        settlement == null || actuallyPaymentAmount.add(paymentAmount).compareTo(settlement.getAmount()) <= 0, "订单付款总额不能超过订单申请结算额!"
                     );
                  }
               }

               if (order.getSettlementStatus() != null
                  && order.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
                  && !financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
                  Preconditions.checkArgument(actuallyPaymentAmount.add(paymentAmount).compareTo(order.getSettlementAmount()) <= 0, "订单付款总额不能超过订单结算额!");
               }

               supplierPayment.setPaymentReasonId(param.getPaymentType() != null ? String.valueOf(param.getPaymentType()) : null);
               supplierPayment.setPaymentDate(param.getPaymentDate().toLocalDate());
               supplierPayment.setActuallyPaymentAmount(map.get(supplierPayment.getOrderId()));
               supplierPayment.setPaymentBank(param.getPaymentBank());
               supplierPayment.setPaymentBankAccount(param.getPaymentBankAccount());
               supplierPayment.setAuditStatus(param.getAuditStatusEnum());
               supplierPayment.setAuditUserId(UserUtil.getCurrentUserId());
               supplierPayment.setAuditUserName(UserUtil.getCurrentName());
               supplierPayment.setAuditTime(LocalDateTime.now());
            }
         );
         contractAuditLedger.setActuallyPayAmount(param.getActuallyPayAmount());
         contractAuditLedger.setVoucherNumber(param.getVoucherNumber());
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         this.baseMapper.updateById(contractAuditLedger);
         this.supplierPaymentService.updateBatchById(paymentList);
      }

      if (!isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         Preconditions.checkArgument(param.getSupplierPayment() != null, "付款信息不能为空");
         Map<Long, BigDecimal> map = param.getSupplierPayment()
            .stream()
            .collect(Collectors.toMap(saveSupplierPaymentDto::getSupplierPaymentId, saveSupplierPaymentDto::getMoneyAmount));
         paymentList.forEach(supplierPayment -> {
            supplierPayment.setPaymentReasonId(param.getPaymentType() != null ? String.valueOf(param.getPaymentType()) : null);
            supplierPayment.setPaymentDate(param.getPaymentDate().toLocalDate());
            supplierPayment.setActuallyPaymentAmount(map.get(supplierPayment.getOrderId()));
            supplierPayment.setPaymentBank(param.getPaymentBank());
            supplierPayment.setPaymentBankAccount(param.getPaymentBankAccount());
         });
         this.supplierPaymentService.updateBatchById(paymentList);
      }

      if (param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())) {
         paymentList.forEach(supplierPayment -> {
            supplierPayment.setAuditStatus(param.getAuditStatusEnum());
            supplierPayment.setAuditUserId(UserUtil.getCurrentUserId());
            supplierPayment.setAuditUserName(UserUtil.getCurrentName());
            supplierPayment.setAuditTime(LocalDateTime.now());
            this.supplierPaymentService.updateById(supplierPayment);
         });
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         this.baseMapper.updateById(contractAuditLedger);
         this.supplierPaymentService.updateBatchById(paymentList);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean invoiceAudit(PurchaseInvoiceAuditParam param) {
      ContractAuditLedger auditLedger = this.baseMapper.selectById(param.getAuditId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(auditLedger), "审批单不存在");
      Preconditions.checkArgument(auditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "审批状态已发生变化，请刷新重试!");
      Set<Long> invoiceIds = Arrays.stream(auditLedger.getPaymentId().split(",")).map(Long::valueOf).collect(Collectors.toSet());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(invoiceIds), "审批记录数据有误!");
      List<SupplierInvoice> supplierInvoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .in(SupplierInvoice::getId, invoiceIds)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(supplierInvoiceList.size() == invoiceIds.size(), "审批记录数据有误!");
      Map<Long, SupplierInvoice> invoiceMap = supplierInvoiceList.stream().collect(Collectors.toMap(SupplierInvoice::getOrderId, Function.identity()));
      Set<Long> orderIds = Arrays.stream(auditLedger.getContractId().split(",")).map(Long::valueOf).collect(Collectors.toSet());
      Set<Long> auditOrderIds = param.getOrderInvoiceList().stream().map(PurchaseInvoiceAuditDetailParam::getOrderId).collect(Collectors.toSet());
      Preconditions.checkArgument(param.getOrderInvoiceList().size() == auditOrderIds.size(), "审批订单重复!");
      Preconditions.checkArgument(auditOrderIds.containsAll(orderIds) && orderIds.containsAll(auditOrderIds), "审批订单有误!");
      List<PurchaseOrder> purchaseOrderList = this.purchaseOrderService.listByIds(orderIds);
      Preconditions.checkArgument(purchaseOrderList.size() == orderIds.size(), "审批记录数据有误!");
      Map<Long, PurchaseOrder> purchaseOrderMap = purchaseOrderList.stream().collect(Collectors.toMap(PurchaseOrder::getId, Function.identity()));
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(auditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(auditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         Map<Long, BigDecimal> orderIdActualInvoiceAmountMap = this.supplierInvoiceService
            .list(
               Wrappers.lambdaQuery(SupplierInvoice.class)
                  .eq(SupplierInvoice::getOrderId, orderIds)
                  .in(
                     SupplierInvoice::getPropertyType,
                     SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(),
                     SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
                  )
                  .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .collect(
               Collectors.groupingBy(
                  SupplierInvoice::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierInvoice::getActualInvoiceAmount, BigDecimal::add)
               )
            );
         FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
         param.getOrderInvoiceList()
            .forEach(
               orderInvoiceAuditParam -> {
                  SupplierInvoice invoice = invoiceMap.get(orderInvoiceAuditParam.getOrderId());
                  Preconditions.checkArgument(invoice != null, "开票记录不存在!");
                  Preconditions.checkArgument(orderInvoiceAuditParam.getActualInvoiceAmount() != null, "实开发票金额必填!");
                  Preconditions.checkArgument(orderInvoiceAuditParam.getActualInvoiceAmount().compareTo(BigDecimal.ZERO) != 0, "实开发票金额不能为0");
                  Preconditions.checkArgument(orderInvoiceAuditParam.getActualInvoiceAmount().compareTo(invoice.getInvoiceAmount()) <= 0, "实开票额不能超过申请票额!");
                  PurchaseOrder purchaseOrder = purchaseOrderMap.get(orderInvoiceAuditParam.getOrderId());
                  if (purchaseOrder.getSettlementStatus() != null && !purchaseOrder.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())) {
                     Preconditions.checkArgument(
                        financeAmountLimitConfig.getBoolAllowOverSettleAmount()
                           || orderInvoiceAuditParam.getActualInvoiceAmount()
                                 .add(orderIdActualInvoiceAmountMap.getOrDefault(orderInvoiceAuditParam.getOrderId(), BigDecimal.ZERO))
                                 .compareTo(purchaseOrder.getSettlementAmount())
                              <= 0,
                        "收票总额不能超过订单已结算额!"
                     );
                  } else {
                     Preconditions.checkArgument(
                        financeAmountLimitConfig.getBoolAllowOverContractAmount()
                           || orderInvoiceAuditParam.getActualInvoiceAmount()
                                 .add(orderIdActualInvoiceAmountMap.getOrDefault(orderInvoiceAuditParam.getOrderId(), BigDecimal.ZERO))
                                 .compareTo(purchaseOrder.getAmount())
                              <= 0,
                        "收票总额不能超过订单合同额!"
                     );
                  }

                  invoice.setActualInvoiceAmount(orderInvoiceAuditParam.getActualInvoiceAmount());
                  invoice.setInvoiceSerialNumber(param.getInvoiceSerialNumber());
                  invoice.setAuditStatus(param.getAuditStatusEnum());
                  invoice.setAuditUserId(UserUtil.getCurrentUserId());
                  invoice.setAuditUserName(UserUtil.getCurrentName());
                  invoice.setAuditTime(LocalDateTime.now());
                  invoice.setRemark(param.getRemark());
               }
            );
         this.supplierInvoiceService.updateBatchById(supplierInvoiceList);
         auditLedger.setActuallyPayAmount(
            param.getOrderInvoiceList().stream().map(PurchaseInvoiceAuditDetailParam::getActualInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
         );
         auditLedger.setWrittenById(UserUtil.getCurrentUserId());
         auditLedger.setSubmitDate(LocalDateTime.now());
         auditLedger.setApprovalTime(LocalDateTime.now());
         auditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         this.baseMapper.updateById(auditLedger);
      }

      if (param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())) {
         param.getOrderInvoiceList().forEach(orderInvoiceAuditParam -> {
            SupplierInvoice invoice = invoiceMap.get(orderInvoiceAuditParam.getOrderId());
            Preconditions.checkArgument(invoice != null, "开票记录不存在!");
            invoice.setAuditStatus(param.getAuditStatusEnum());
            invoice.setAuditUserId(UserUtil.getCurrentUserId());
            invoice.setAuditUserName(UserUtil.getCurrentName());
            invoice.setAuditTime(LocalDateTime.now());
            invoice.setRemark(param.getRemark());
         });
         this.supplierInvoiceService.updateBatchById(supplierInvoiceList);
         auditLedger.setWrittenById(UserUtil.getCurrentUserId());
         auditLedger.setSubmitDate(LocalDateTime.now());
         auditLedger.setApprovalTime(LocalDateTime.now());
         auditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         this.baseMapper.updateById(auditLedger);
      }

      return Boolean.TRUE;
   }

   @Override
   public ContractAuditLedgerDto getAuditDetail(Long auditId) {
      WmsApproveRecord byId = this.approveRecordService.getById(auditId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(byId), "审批单不存在");
      ContractAuditLedger contractAuditLedger = this.baseMapper.selectById(byId.getDataId());
      List<ContractAuditLedgerDto> contractAuditLedgerDtos = this.getContractAuditLedgerDtos(Arrays.asList(contractAuditLedger));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(contractAuditLedgerDtos));
      return contractAuditLedgerDtos.get(0);
   }

   @Override
   public Boolean procurementAudit(Integer paymentEnum, BigDecimal amount, Integer branchCompanyId) {
      return null;
   }

   @Override
   public SupplierSettlementEchoAuditDto settlementAuditDetail(Long auditId) {
      ContractAuditLedger contractAuditLedger = this.baseMapper.selectById(auditId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(contractAuditLedger), "审批单不存在");
      SupplierSettlement supplierSettlement = this.supplierSettlementService.getById(contractAuditLedger.getPaymentId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(supplierSettlement), "结算单不存在");
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(supplierSettlement.getOrderId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(purchaseOrder), "采购订单不存在");
      Boolean button = false;
      if (contractAuditLedger.getApproveRecordId() != null && contractAuditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType())) {
         button = this.procurementAudit(contractAuditLedger.getApproveRecordId());
      }

      List<SupplierPayment> paymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, purchaseOrder.getId())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      List<SupplierInvoice> invoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, purchaseOrder.getId())
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      List<SupplierSettlementEchoDto> recording = new ArrayList<>();
      invoiceList.forEach(
         item -> {
            SupplierSettlementEchoDto settlementEchoDto = new SupplierSettlementEchoDto()
               .setInvoiceAmount(item.getActualInvoiceAmount())
               .setInvoiceDate(item.getReceiveInvoiceDate().atStartOfDay());
            recording.add(settlementEchoDto);
         }
      );
      paymentList.forEach(
         item -> {
            SupplierSettlementEchoDto settlementEchoDto = new SupplierSettlementEchoDto()
               .setPaymentAmount(item.getActuallyPaymentAmount())
               .setPaymentDate(item.getPaymentDate().atStartOfDay());
            recording.add(settlementEchoDto);
         }
      );
      String projectName = null;
      if (ObjectUtils.isNotEmpty(purchaseOrder.getProjectIds())) {
         List<Long> projectIds = Arrays.stream(purchaseOrder.getProjectIds().split(",")).map(Long::valueOf).collect(Collectors.toList());
         List<ContractProject> projectList = this.projectService.list(Wrappers.lambdaQuery(ContractProject.class).in(ContractProject::getId, projectIds));
         projectName = projectList.stream().map(item -> item.getSerialNumber() + item.getShortName()).collect(Collectors.joining(","));
      }

      return SupplierSettlementEchoAuditDto.builder()
         .passButton(button)
         .paymentEnum(contractAuditLedger.getPaymentEnum())
         .supplierSettlementEchoDtoList(recording)
         .amount(purchaseOrder.getAmount())
         .applyUserId(supplierSettlement.getApplyUserId())
         .applyUserName(supplierSettlement.getApplyUserName())
         .projectManagerName(userMap.get(supplierSettlement.getApplyUserId()).getName())
         .salesLeaderName(userMap.get(supplierSettlement.getApplyUserId()).getName())
         .projectAttribute(purchaseOrder.getProjectAttribute())
         .branchCompanyId(purchaseOrder.getBranchCompanyId())
         .branchCompanyName(branchCompanyMap.get(purchaseOrder.getBranchCompanyId()).getShortName())
         .basicClass(purchaseOrder.getBasicClass())
         .settlementAmount(supplierSettlement.getAmount())
         .inboundAmountSum(
            this.inboundService.getActualInboundAmount(supplierSettlement.getOrderId(), purchaseOrder.getOrderPlace(), purchaseOrder.getPurchaseType())
         )
         .projectName(projectName)
         .attachments(this.attachmentService.listByIds(supplierSettlement.getAttachmentIds()))
         .remark(supplierSettlement.getRemark())
         .boolFinalApprover(this.getBoolFinalApprove(auditId))
         .build();
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean settlementAudit(SettleAuditSaveDtoParam param) {
      ContractAuditLedger contractAuditLedger = this.baseMapper.selectById(param.getAuditId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(contractAuditLedger), "审批单不存在");
      Preconditions.checkArgument(contractAuditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "审批状态已发生变化，请刷新重试!");
      SupplierSettlement settlement = this.supplierSettlementService.getById(contractAuditLedger.getPaymentId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(settlement), "结算单不存在");
      Preconditions.checkArgument(settlement.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "审批数据审批状态错误");
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(settlement.getOrderId());
      Preconditions.checkArgument(purchaseOrder != null, "采购订单不存在!");
      Preconditions.checkArgument(purchaseOrder.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()), "审批数据已结算");
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(contractAuditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(contractAuditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         param.setSettlementAmount(param.getSettlementAmount() == null ? settlement.getAmount() : param.getSettlementAmount());
         Preconditions.checkArgument(param.getSettlementAmount().compareTo(BigDecimal.ZERO) > 0, "实际结算金额有误!");
         Preconditions.checkArgument(param.getSettlementAmount().compareTo(settlement.getAmount()) <= 0, "实际结算金额不能大于申请金额!");
         BigDecimal preSettlementAmount = this.supplierSettlementService
            .list(
               Wrappers.lambdaQuery(SupplierSettlement.class)
                  .eq(SupplierSettlement::getOrderId, settlement.getOrderId())
                  .eq(SupplierSettlement::getBoolPreSettlement, true)
                  .ne(SupplierSettlement::getId, settlement.getId())
                  .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
                  .in(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .map(SupplierSettlement::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         if (settlement.getBoolPreSettlement()) {
            BigDecimal actualInboundAmount = this.inboundService
               .getActualInboundAmount(settlement.getOrderId(), purchaseOrder.getOrderPlace(), purchaseOrder.getPurchaseType());
            Preconditions.checkArgument(preSettlementAmount.add(param.getSettlementAmount()).compareTo(actualInboundAmount) <= 0, "预结算总额不能大于订单入库额!");
         } else {
            Preconditions.checkArgument(preSettlementAmount.compareTo(param.getSettlementAmount()) <= 0, "实际结算金额不能小于预结算总额(含未审批)!");
            FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
            if (!financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
               BigDecimal paymentAmount = this.supplierPaymentService
                  .list(
                     Wrappers.lambdaQuery(SupplierPayment.class)
                        .eq(SupplierPayment::getOrderId, settlement.getOrderId())
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
               Preconditions.checkArgument(param.getSettlementAmount().compareTo(paymentAmount) >= 0, "实际结算金额不能小于付款总额(含未审批)!");
               BigDecimal invoiceAmount = this.supplierInvoiceService
                  .list(
                     Wrappers.lambdaQuery(SupplierInvoice.class)
                        .eq(SupplierInvoice::getOrderId, settlement.getOrderId())
                        .in(
                           SupplierInvoice::getPropertyType,
                           SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(),
                           SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
                        )
                        .in(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
                  )
                  .stream()
                  .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getInvoiceAmount() : s.getActualInvoiceAmount())
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               Preconditions.checkArgument(param.getSettlementAmount().compareTo(invoiceAmount) >= 0, "实际结算金额不能小于收票总额(含未审批)!");
            }
         }

         contractAuditLedger.setActuallyPayAmount(param.getSettlementAmount());
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         this.baseService.updateById(contractAuditLedger);
         if (!settlement.getBoolPreSettlement()) {
            purchaseOrder.setSettlementStatus(SettlementStatusEnum.SETTLED.getType());
            purchaseOrder.setSettlementAmount(param.getSettlementAmount());
            purchaseOrder.setPurchaseStatus(PurchaseStatusEnum.FINISH.getType());
            this.purchaseOrderService.updateById(purchaseOrder);
         }

         settlement.setAmount(param.getSettlementAmount());
         settlement.setAuditStatus(param.getAuditStatusEnum());
         settlement.setAuditTime(LocalDateTime.now());
         settlement.setAuditUserId(UserUtil.getCurrentUserId());
         settlement.setAuditUserName(UserUtil.getCurrentName());
         this.supplierSettlementService.updateById(settlement);
      }

      if (param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())) {
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         this.baseService.updateById(contractAuditLedger);
         settlement.setAuditStatus(AuditStatusEnum.FAILED.getType());
         settlement.setAuditTime(LocalDateTime.now());
         settlement.setAuditUserId(UserUtil.getCurrentUserId());
         settlement.setAuditUserName(UserUtil.getCurrentName());
         this.supplierSettlementService.updateById(settlement);
      }

      return Boolean.TRUE;
   }

   @Override
   public Map<String, Object> checkBeforeProjectSettlement(Long projectId) {
      Map<String, Object> map = new HashMap<>(16);
      List<MaterialInventory> materialInventoryList = this.materialInventoryService
         .list(Wrappers.lambdaQuery(MaterialInventory.class).eq(MaterialInventory::getProjectId, projectId));
      if (CollectionUtils.isNotEmpty(materialInventoryList)) {
         map.put("boolCheckPassed", false);
         map.put("type", ContractAuditLedgerBizImpl.typeEnum.ONE.getType());
         return map;
      } else {
         Map<Integer, BigDecimal> typeQuantityMap = this.warehouseSummaryService
            .list(Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class).eq(MesBuildingWarehouseSummary::getProjectId, projectId))
            .stream()
            .collect(
               Collectors.groupingBy(
                  MesBuildingWarehouseSummary::getType, Collectors.reducing(BigDecimal.ZERO, MesBuildingWarehouseSummary::getQuantity, BigDecimal::add)
               )
            );
         BigDecimal intoQuantity = typeQuantityMap.getOrDefault(WarehouseTypeEnum.INTO.getType(), BigDecimal.ZERO);
         BigDecimal outQuantity = typeQuantityMap.getOrDefault(WarehouseTypeEnum.OUT.getType(), BigDecimal.ZERO);
         if (outQuantity.compareTo(intoQuantity) < 0) {
            map.put("boolCheckPassed", false);
            map.put("type", ContractAuditLedgerBizImpl.typeEnum.TWO.getType());
            return map;
         } else {
            List<MesBuildingTask> artifactTaskList = this.taskService
               .list(
                  Wrappers.lambdaQuery(MesBuildingTask.class)
                     .eq(MesBuildingTask::getProjectId, projectId)
                     .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
               );
            if (artifactTaskList.stream().anyMatch(s -> s.getTaskQuantity() > s.getCompleteQuantity())) {
               map.put("boolCheckPassed", false);
               map.put("type", ContractAuditLedgerBizImpl.typeEnum.THREE.getType());
               return map;
            } else {
               List<MesEnclosureTask> enclosureTaskList = this.enclosureTaskService
                  .list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getProjectId, projectId));
               if (enclosureTaskList.stream().anyMatch(s -> s.getTaskQuantity() > s.getCompleteQuantity())) {
                  map.put("boolCheckPassed", false);
                  map.put("type", ContractAuditLedgerBizImpl.typeEnum.THREE.getType());
                  return map;
               } else {
                  int artifactSum = this.artifactService
                     .list(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getProjectId, projectId))
                     .stream()
                     .mapToInt(TechArtifact::getQuantity)
                     .sum();
                  int enclosureSum = this.enclosureService
                     .list(Wrappers.lambdaQuery(TechEnclosure.class).eq(TechEnclosure::getProjectId, projectId))
                     .stream()
                     .mapToInt(TechEnclosure::getQuantity)
                     .sum();
                  int artifactTaskSum = artifactTaskList.stream().mapToInt(MesBuildingTask::getTaskQuantity).sum();
                  int enclosureTaskSum = enclosureTaskList.stream().mapToInt(MesEnclosureTask::getTaskQuantity).sum();
                  if (artifactTaskSum + enclosureTaskSum < artifactSum + enclosureSum) {
                     map.put("boolCheckPassed", false);
                     map.put("type", ContractAuditLedgerBizImpl.typeEnum.FOUR.getType());
                     return map;
                  } else {
                     map.put("boolCheckPassed", true);
                     map.put("type", null);
                     return map;
                  }
               }
            }
         }
      }
   }

   @Override
   public ProjectSettlementDTO getProjectDetail(Long auditId, Long projectId, Integer level) {
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      ContractAuditLedger contractAuditLedger = null;
      Boolean button = false;
      ContractProject project;
      BranchCompany company;
      if (auditId != null) {
         contractAuditLedger = this.baseMapper.selectById(auditId);
         Preconditions.checkArgument(ObjectUtils.isNotEmpty(contractAuditLedger), "审批单不存在");
         project = this.projectService.getById(contractAuditLedger.getProjectId());
         Preconditions.checkArgument(ObjectUtils.isNotEmpty(project), "项目不存在");
         if (contractAuditLedger.getApproveRecordId() != null && contractAuditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType())) {
            button = this.procurementAudit(contractAuditLedger.getApproveRecordId());
         }

         company = this.branchCompanyService.getById(project.getContractSignBodyId());
         Preconditions.checkArgument(company != null, "项目签约主体未查询到!");
      } else {
         if (!ObjectUtils.isNotEmpty(projectId)) {
            throw new BusinessException("参数错误");
         }

         project = this.projectService.getById(projectId);
         Preconditions.checkArgument(ObjectUtils.isNotEmpty(project), "项目不存在");
         if (!boolTwoLevelUnit) {
            level = null;
         } else {
            Preconditions.checkArgument(level != null || !project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType()), "单位等级未知!");
         }

         company = this.branchCompanyService.getById(project.getContractSignBodyId());
         Preconditions.checkArgument(company != null, "项目签约主体未查询到!");
         Preconditions.checkArgument(level == null || level.equals(company.getLevel()), "该项目不能在此结算!");
      }

      NameInfo nameInfo;
      if (project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         nameInfo = NameInfo.builder().id(project.getSignerId()).name(this.userService.getNameById(project.getSignerId())).build();
      } else {
         nameInfo = NameInfo.builder().id(project.getProjectManagerId()).name(this.userService.getNameById(project.getProjectManagerId())).build();
      }

      ProjectSettlementDTO build = ProjectSettlementDTO.builder()
         .passButton(button)
         .paymentEnum(contractAuditLedger != null ? contractAuditLedger.getPaymentEnum() : null)
         .projectManager(nameInfo)
         .project(
            ProjectInfo.builder()
               .id(project.getId())
               .name(project.getName())
               .shortName(project.getShortName())
               .projectAttribute(project.getProjectAttribute())
               .serialNumber(project.getSerialNumber())
               .projectManagerId(project.getProjectManagerId())
               .build()
         )
         .branchComment(NameInfo.builder().id(project.getContractSignBodyId()).name(company.getShortName()).build())
         .customerUnit(project.getCustomerUnit())
         .contractProjectAmount(project.getContractAmount())
         .paymentAmount(project.getCollectionAmount())
         .paymentRate(
            project.getContractAmount().compareTo(BigDecimal.ZERO) != 0
               ? project.getCollectionAmount().divide(project.getContractAmount(), 8, RoundingMode.DOWN).multiply(BigDecimal.valueOf(100L))
               : BigDecimal.ZERO
         )
         .invoiceAmount(project.getInvoiceAmount())
         .invoiceRate(
            project.getContractAmount().compareTo(BigDecimal.ZERO) != 0
               ? project.getInvoiceAmount().divide(project.getContractAmount(), 8, RoundingMode.DOWN).multiply(BigDecimal.valueOf(100L))
               : BigDecimal.ZERO
         )
         .attachmentId(contractAuditLedger != null ? contractAuditLedger.getAttachmentId() : null)
         .attachmentIds(contractAuditLedger != null ? contractAuditLedger.getAttachmentIds() : null)
         .attachments(contractAuditLedger != null ? this.attachmentService.listByIds(contractAuditLedger.getAttachmentIds()) : Collections.emptyList())
         .boolFinalApprover(this.getBoolFinalApprove(auditId))
         .build();
      if (auditId == null) {
         BigDecimal amount = project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())
            ? project.getContractAmount()
            : project.getSettlementAmount();
         build.setRemainderPayment(
            amount.subtract(project.getCollectionAmount()).compareTo(BigDecimal.ZERO) >= 0 ? amount.subtract(project.getCollectionAmount()) : BigDecimal.ZERO
         );
         build.setRemainderInvoice(
            amount.subtract(project.getInvoiceAmount()).compareTo(BigDecimal.ZERO) >= 0 ? amount.subtract(project.getInvoiceAmount()) : BigDecimal.ZERO
         );
      } else {
         build.setSettlementAmount(contractAuditLedger.getApplyAmount());
         build.setSettlementTime(contractAuditLedger.getFilingDate());
         if (contractAuditLedger.getPaymentEnum().equals(AuditPaymentEnum.PROJECT_SETTLEMENT.getType())) {
            build.setRemainderPayment(contractAuditLedger.getApplyAmount().subtract(project.getCollectionAmount()));
            build.setRemainderInvoice(contractAuditLedger.getApplyAmount().subtract(project.getInvoiceAmount()));
         } else {
            BigDecimal amount = project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())
               ? project.getContractAmount()
               : project.getSettlementAmount();
            build.setRemainderPayment(
               amount.subtract(project.getCollectionAmount()).compareTo(BigDecimal.ZERO) >= 0
                  ? amount.subtract(project.getCollectionAmount())
                  : BigDecimal.ZERO
            );
            build.setRemainderInvoice(
               amount.subtract(project.getInvoiceAmount()).compareTo(BigDecimal.ZERO) >= 0 ? amount.subtract(project.getInvoiceAmount()) : BigDecimal.ZERO
            );
         }

         build.setAttachmentId(contractAuditLedger.getAttachmentId());
         build.setAttachmentIds(contractAuditLedger.getAttachmentIds());
         build.setAttachments(this.attachmentService.listByIds(contractAuditLedger.getAttachmentIds()));
      }

      return build;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveProjectSettlement(ProjectSettlementSaveParam param) {
      Preconditions.checkArgument(param.getSettlementAmount().compareTo(BigDecimal.ZERO) > 0, "项目结算额必须大于0!!");
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()), "项目已结算!");
      ContractAuditLedger contractAuditLedger = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(ContractAuditLedger.class)
               .isNotNull(ContractAuditLedger::getProjectId)
               .eq(ContractAuditLedger::getPaymentEnum, AuditPaymentEnum.PROJECT_SETTLEMENT.getType())
               .eq(ContractAuditLedger::getProjectId, param.getProjectId())
               .eq(ContractAuditLedger::getAuditStatusEnum, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(ObjectUtils.isEmpty(contractAuditLedger), "项目结算正在审批中!");
      BigDecimal preSettlementAmount = this.contractSettlementService
         .list(
            Wrappers.lambdaQuery(ContractSettlement.class)
               .eq(ContractSettlement::getProjectId, param.getProjectId())
               .in(ContractSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .map(ContractSettlement::getAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      Preconditions.checkArgument(param.getSettlementAmount().compareTo(preSettlementAmount) >= 0, "结算金额不能小于预结算总金额(含未审批)!");
      FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
      if (!financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
         BigDecimal collectionAmount = this.contractCollectionService
            .list(
               Wrappers.lambdaQuery(ContractCollection.class)
                  .eq(ContractCollection::getProjectId, param.getProjectId())
                  .eq(ContractCollection::getCollectionUnitId, project.getContractSignBodyId())
                  .in(ContractCollection::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .map(ContractCollection::getCollectionAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(param.getSettlementAmount().compareTo(collectionAmount) >= 0, "项目结算额不能小于收款总额(含未审批)!");
         BigDecimal invoiceAmount = this.contractInvoiceService
            .list(
               Wrappers.lambdaQuery(ContractInvoice.class)
                  .eq(ContractInvoice::getProjectId, param.getProjectId())
                  .eq(ContractInvoice::getInvoiceUnitId, project.getContractSignBodyId())
                  .in(ContractInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .map(c -> c.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? c.getInvoiceAmount() : c.getActualInvoiceAmount())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(param.getSettlementAmount().compareTo(invoiceAmount) >= 0, "项目结算额不能小于开票总额(含未审批)!");
      }

      Long projectManagerId;
      if (project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         projectManagerId = project.getSignerId() != null ? project.getSignerId() : project.getSalesLeaderId();
      } else {
         projectManagerId = project.getProjectManagerId();
      }

      ContractAuditLedger build = ContractAuditLedger.builder()
         .contractId(project.getId().toString())
         .paymentEnum(AuditPaymentEnum.PROJECT_SETTLEMENT.getType())
         .projectAttribute(project.getProjectAttribute())
         .projectId(String.valueOf(project.getId()))
         .contractSignBodyId(project.getContractSignBodyId())
         .projectManagerId(projectManagerId)
         .initiatorId(UserUtil.getCurrentUserId())
         .contractNumber(project.getSerialNumber())
         .filingDate(param.getSettlementTime())
         .applyAmount(param.getSettlementAmount())
         .auditStatusEnum(AuditStatusEnum.AUDITING.getType())
         .auditType(AuditTypeEnum.CONTRACT_APPROVE.getType())
         .submitDate(LocalDateTime.now())
         .attachmentIds(CollectionUtils.isNotEmpty(param.getAttachmentId()) ? StringUtils.join(param.getAttachmentId(), ",") : null)
         .build();
      this.baseMapper.insert(build);
      WmsApproveRecord record = this.approvalsService
         .createRecord(
            build.getId(), project.getSerialNumber(), ApproveProcessTypeEnumV2.CONTRACT_SETTLEMENT_AUDIT.getType(), null, null, null, true, null, null, null
         );
      build.setApproveRecordId(record.getId());
      this.baseMapper.updateById(build);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean projectSettlementAudit(SettleAuditSaveDtoParam param) {
      ContractAuditLedger contractAuditLedger = this.baseMapper.selectById(param.getAuditId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(contractAuditLedger), "审批记录不存在");
      Preconditions.checkArgument(Objects.equals(contractAuditLedger.getPaymentEnum(), AuditPaymentEnum.PROJECT_SETTLEMENT.getType()), "审批单结算类型不匹配");
      Preconditions.checkArgument(contractAuditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "审批状态已发生变化，请刷新重试!");
      ContractProject project = this.projectService.getById(contractAuditLedger.getProjectId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(project), "项目不存在");
      Preconditions.checkArgument(project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()), "项目已结算");
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(contractAuditLedger.getApproveRecordId());
      Preconditions.checkArgument(wmsApproveRecord != null
         && Objects.equals(wmsApproveRecord.getDataId(), contractAuditLedger.getId())
         && Objects.equals(wmsApproveRecord.getApproveProcessType(), ApproveProcessTypeEnumV2.CONTRACT_SETTLEMENT_AUDIT.getType()), "审批流程与结算单不匹配");
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(contractAuditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         contractAuditLedger.setActuallyPayAmount(contractAuditLedger.getApplyAmount());
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         this.baseMapper.updateById(contractAuditLedger);
         project.setSettlementAmount(contractAuditLedger.getApplyAmount());
         project.setSettlementStatus(SettlementStatusEnum.SETTLED.getType());
         project.setStatus(ProjectStatusEnum.COMPLETED.getType());
         project.setCompleteDate(contractAuditLedger.getFilingDate().toLocalDate());
         this.projectService.updateById(project);
         this.redisUtils.del("simpleProjectList");
      }

      if (param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())) {
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         this.baseMapper.updateById(contractAuditLedger);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean subcontractSelfAudit(AddContractAuditDtoParam param) {
      ContractAuditLedger contractAuditLedger = this.baseMapper.selectById(param.getAuditId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(contractAuditLedger), "审批单不存在");
      Preconditions.checkArgument(contractAuditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "该审批单已审批");
      SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(contractAuditLedger.getContractId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(subcontractOrder), "合同不存在");
      SupplierPayment payment = this.supplierPaymentService.getById(contractAuditLedger.getPaymentId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(payment), "付款单不存在");
      Preconditions.checkArgument(payment.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "付款单状态错误");
      String paymentAttributeName = null;
      if (param.getPaymentAttributeId() != null) {
         SysSupplierPaymentAttribute paymentAttribute = this.supplierPaymentAttributeService.getById(param.getPaymentAttributeId());
         Preconditions.checkArgument(paymentAttribute != null, "付款属性不存在!");
         Preconditions.checkArgument(paymentAttribute.getBoolEnableStatus(), "付款属性已禁用!");
         paymentAttributeName = paymentAttribute.getName();
      }

      Preconditions.checkArgument(contractAuditLedger.getApplyAmount().compareTo(param.getActuallyPayAmount()) >= 0, "付款金额不能大于申请金额");
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(contractAuditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(contractAuditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         BigDecimal paymentAmount = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .in(SupplierPayment::getOrderId, subcontractOrder.getId())
                  .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .map(SupplierPayment::getActuallyPaymentAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
         if (!subcontractOrder.getBoolSettlementStatus()) {
            if (!financeAmountLimitConfig.getBoolAllowOverContractAmount()) {
               Preconditions.checkArgument(paymentAmount.add(param.getActuallyPayAmount()).compareTo(subcontractOrder.getAmount()) <= 0, "付款总额不能大于合同额!");
            }

            if (!financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
               SupplierSettlement settlement = this.supplierSettlementService
                  .getOne(
                     Wrappers.lambdaQuery(SupplierSettlement.class)
                        .in(SupplierSettlement::getOrderId, subcontractOrder.getId())
                        .eq(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
                        .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
                  );
               Preconditions.checkArgument(
                  settlement == null || paymentAmount.add(param.getActuallyPayAmount()).compareTo(settlement.getAmount()) <= 0, "付款总额不能大于申请结算额!"
               );
            }
         }

         if (subcontractOrder.getBoolSettlementStatus() && !financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
            Preconditions.checkArgument(paymentAmount.add(param.getActuallyPayAmount()).compareTo(subcontractOrder.getSettlementAmount()) <= 0, "付款总额不能大于结算额!");
         }

         payment.setAuditStatus(param.getAuditStatusEnum());
         payment.setPaymentDate(param.getPaymentDate().toLocalDate());
         payment.setPaymentReasonId(param.getPaymentType().toString());
         payment.setActuallyPaymentAmount(param.getActuallyPayAmount());
         payment.setPaymentBank(param.getPaymentBank());
         payment.setPaymentBankAccount(param.getPaymentBankAccount());
         payment.setPaymentAttributeId(param.getPaymentAttributeId());
         payment.setPaymentAttributeName(paymentAttributeName);
         payment.setAuditUserId(UserUtil.getCurrentUserId());
         payment.setAuditUserName(UserUtil.getCurrentName());
         payment.setAuditTime(LocalDateTime.now());
         this.supplierPaymentService.updateById(payment);
         contractAuditLedger.setActuallyPayAmount(param.getActuallyPayAmount());
         contractAuditLedger.setPaymentType(param.getPaymentType());
         contractAuditLedger.setVoucherNumber(param.getVoucherNumber());
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         this.baseMapper.updateById(contractAuditLedger);
      }

      if (!isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         payment.setPaymentDate(param.getPaymentDate().toLocalDate());
         payment.setPaymentReasonId(param.getPaymentType().toString());
         payment.setActuallyPaymentAmount(param.getActuallyPayAmount());
         payment.setPaymentBank(param.getPaymentBank());
         payment.setPaymentBankAccount(param.getPaymentBankAccount());
         payment.setPaymentAttributeId(param.getPaymentAttributeId());
         payment.setPaymentAttributeName(paymentAttributeName);
         this.supplierPaymentService.updateById(payment);
      }

      if (param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())) {
         payment.setAuditStatus(param.getAuditStatusEnum());
         payment.setAuditUserId(UserUtil.getCurrentUserId());
         payment.setAuditUserName(UserUtil.getCurrentName());
         payment.setAuditTime(LocalDateTime.now());
         this.supplierPaymentService.updateById(payment);
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         this.baseMapper.updateById(contractAuditLedger);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean subcontractSelfInvoiceAudit(SubOrderInvoiceAuditParam param) {
      ContractAuditLedger contractAuditLedger = this.baseMapper.selectById(param.getAuditId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(contractAuditLedger), "审批单不存在");
      Preconditions.checkArgument(!contractAuditLedger.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType()), "该审批单已审批");
      SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(contractAuditLedger.getContractId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(subcontractOrder), "合同不存在");
      SupplierInvoice invoice = this.supplierInvoiceService.getById(contractAuditLedger.getPaymentId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(invoice), "发票不存在");
      Preconditions.checkArgument(!invoice.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()), "发票状态错误");
      Preconditions.checkArgument(contractAuditLedger.getApplyAmount().compareTo(param.getInvoiceAmount()) >= 0, "实际收票金额不能大于申请金额");
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(contractAuditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(contractAuditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         BigDecimal invoiceAmount = this.supplierInvoiceService
            .list(
               Wrappers.lambdaQuery(SupplierInvoice.class)
                  .in(SupplierInvoice::getOrderId, subcontractOrder.getId())
                  .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                  .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .map(SupplierInvoice::getActualInvoiceAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
         if (!subcontractOrder.getBoolSettlementStatus()) {
            if (!financeAmountLimitConfig.getBoolAllowOverContractAmount()) {
               Preconditions.checkArgument(invoiceAmount.add(param.getInvoiceAmount()).compareTo(subcontractOrder.getAmount()) <= 0, "收票总额不能大于合同额!");
            }

            if (!financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
               SupplierSettlement settlement = this.supplierSettlementService
                  .getOne(
                     Wrappers.lambdaQuery(SupplierSettlement.class)
                        .in(SupplierSettlement::getOrderId, subcontractOrder.getId())
                        .in(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
                        .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
                  );
               Preconditions.checkArgument(
                  settlement == null || invoiceAmount.add(param.getInvoiceAmount()).compareTo(settlement.getAmount()) <= 0, "收票总额不能大于申请结算额!"
               );
            }
         }

         if (subcontractOrder.getBoolSettlementStatus() && !financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
            Preconditions.checkArgument(invoiceAmount.add(param.getInvoiceAmount()).compareTo(subcontractOrder.getSettlementAmount()) <= 0, "收款总额不能大于结算额!");
         }

         invoice.setActualInvoiceAmount(param.getInvoiceAmount());
         invoice.setInvoiceSerialNumber(param.getInvoiceSerialNumber());
         invoice.setAuditStatus(param.getAuditStatusEnum());
         invoice.setAuditUserId(UserUtil.getCurrentUserId());
         invoice.setAuditUserName(UserUtil.getCurrentName());
         invoice.setAuditTime(LocalDateTime.now());
         this.supplierInvoiceService.updateById(invoice);
         contractAuditLedger.setActuallyPayAmount(param.getInvoiceAmount());
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         this.baseMapper.updateById(contractAuditLedger);
      }

      if (param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())) {
         invoice.setAuditStatus(param.getAuditStatusEnum());
         invoice.setAuditUserId(UserUtil.getCurrentUserId());
         invoice.setApplyUserName(UserUtil.getCurrentName());
         invoice.setAuditTime(LocalDateTime.now());
         this.supplierInvoiceService.updateById(invoice);
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         this.baseMapper.updateById(contractAuditLedger);
      }

      return Boolean.TRUE;
   }

   @Override
   public SupplierSettlementDto subcontractSettlementAuditDetail(Long auditId) {
      ContractAuditLedger auditLedger = this.baseMapper.selectById(auditId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(auditLedger), "审批单不存在");
      SupplierSettlement settlement = this.supplierSettlementService.getById(auditLedger.getPaymentId());
      Preconditions.checkArgument(settlement != null, "结算记录不存在!");
      ContractProject project = this.projectService.getById(auditLedger.getProjectId());
      Boolean button = this.procurementAudit(auditLedger.getApproveRecordId());
      SupplierSettlementDto settlementDto = this.supplierInvoiceBiz.getSubcontractSelfList(Long.valueOf(auditLedger.getContractId()), auditId);
      settlementDto.setPassButton(button);
      settlementDto.setPaymentEnum(auditLedger.getPaymentEnum());
      settlementDto.setApplyUserId(settlement.getApplyUserId());
      settlementDto.setApplyUserName(settlement.getApplyUserName());
      settlementDto.setApplyDate(settlement.getApplyDate());
      settlementDto.setProjectId(Long.valueOf(auditLedger.getProjectId()));
      settlementDto.setProjectName(project.getSerialNumber() + "_" + project.getName());
      settlementDto.setSettlementAmount(settlement.getAmount());
      settlementDto.setRemark(settlement.getRemark());
      settlementDto.setAttachmentList(this.attachmentService.listByIds(settlement.getAttachmentIds()));
      settlementDto.setBoolFinalApprover(this.getBoolFinalApprove(auditId));
      return settlementDto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean subcontractOrderSettlementAudit(SettleAuditSaveDtoParam param) {
      ContractAuditLedger contractAuditLedger = this.baseMapper.selectById(param.getAuditId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(contractAuditLedger), "审批单不存在");
      Preconditions.checkArgument(contractAuditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "数据审批状态错误!");
      SupplierSettlement settlement = this.supplierSettlementService.getById(contractAuditLedger.getPaymentId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(settlement), "结算单不存在");
      Preconditions.checkArgument(settlement.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "审批数据审批状态错误");
      SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(settlement.getOrderId());
      Preconditions.checkArgument(subcontractOrder != null, "分包订单不存在!");
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(contractAuditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(contractAuditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         param.setSettlementAmount(param.getSettlementAmount() == null ? settlement.getAmount() : param.getSettlementAmount());
         Preconditions.checkArgument(param.getSettlementAmount().compareTo(BigDecimal.ZERO) > 0, "结算额有误!");
         Preconditions.checkArgument(param.getSettlementAmount().compareTo(settlement.getAmount()) <= 0, "实际结算额不能大于申请金额!");
         BigDecimal preSettlementAmount = this.supplierSettlementService
            .list(
               Wrappers.lambdaQuery(SupplierSettlement.class)
                  .eq(SupplierSettlement::getOrderId, settlement.getOrderId())
                  .eq(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
                  .eq(SupplierSettlement::getBoolPreSettlement, true)
                  .in(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .map(SupplierSettlement::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(param.getSettlementAmount().compareTo(preSettlementAmount) >= 0, "实际结算额不能小于预结算总额()!");
         FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
         if (!financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
            BigDecimal totalPaymentAmount = this.supplierPaymentService
               .list(
                  Wrappers.lambdaQuery(SupplierPayment.class)
                     .eq(SupplierPayment::getOrderId, subcontractOrder.getId())
                     .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                     .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               )
               .stream()
               .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getPaymentAmount() : s.getActuallyPaymentAmount())
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            Preconditions.checkArgument(param.getSettlementAmount().compareTo(totalPaymentAmount) >= 0, "结算额不能小于付款总额!");
            BigDecimal totalInvoiceAmount = this.supplierInvoiceService
               .list(
                  Wrappers.lambdaQuery(SupplierInvoice.class)
                     .eq(SupplierInvoice::getOrderId, subcontractOrder.getId())
                     .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                     .in(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               )
               .stream()
               .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getInvoiceAmount() : s.getActualInvoiceAmount())
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            Preconditions.checkArgument(param.getSettlementAmount().compareTo(totalInvoiceAmount) >= 0, "结算额不能小于收票总额!");
         }

         settlement.setAmount(param.getSettlementAmount());
         settlement.setAuditStatus(param.getAuditStatusEnum());
         settlement.setAuditUserId(UserUtil.getCurrentUserId());
         settlement.setAuditUserName(UserUtil.getCurrentName());
         settlement.setAuditTime(LocalDateTime.now());
         this.supplierSettlementService.updateById(settlement);
         contractAuditLedger.setActuallyPayAmount(param.getSettlementAmount());
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         this.baseService.updateById(contractAuditLedger);
         subcontractOrder.setBoolSettlementStatus(true);
         subcontractOrder.setOrderStatus(SubOrderStatusEnum.SETTLEMENTSTATUS.getType());
         subcontractOrder.setSettlementAmount(param.getSettlementAmount());
         this.subcontractOrderService.updateById(subcontractOrder);
      }

      if (param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())) {
         settlement.setAuditStatus(param.getAuditStatusEnum());
         settlement.setAuditUserId(UserUtil.getCurrentUserId());
         settlement.setAuditUserName(UserUtil.getCurrentName());
         settlement.setAuditTime(LocalDateTime.now());
         this.supplierSettlementService.updateById(settlement);
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         this.baseService.updateById(contractAuditLedger);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean subcontractAudit(AddContractAuditDtoParam param) {
      ContractAuditLedger contractAuditLedger = this.baseMapper.selectById(param.getAuditId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(contractAuditLedger), "审批记录不存在");
      ContractProject project = this.projectService.getById(contractAuditLedger.getProjectId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(project), "项目不存在");
      Preconditions.checkArgument(contractAuditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "审批状态错误");
      SupplierPayment supplierPayment = this.supplierPaymentService
         .getOne(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .eq(SupplierPayment::getId, Long.valueOf(contractAuditLedger.getPaymentId()))
         );
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(supplierPayment), "付款记录不存在");
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(contractAuditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(contractAuditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         Preconditions.checkArgument(param.getActuallyPayAmount() != null, "实付金额不能为空");
         Preconditions.checkArgument(param.getPaymentDate() != null, "付款日期不能为空");
         Preconditions.checkArgument(param.getActuallyPayAmount().compareTo(contractAuditLedger.getApplyAmount()) <= 0, "实付金额不能大于申请金额");
         contractAuditLedger.setActuallyPayAmount(param.getActuallyPayAmount());
         contractAuditLedger.setPaymentType(param.getPaymentType());
         contractAuditLedger.setPaymentDate(param.getPaymentDate());
         contractAuditLedger.setVoucherNumber(param.getVoucherNumber());
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         this.baseMapper.updateById(contractAuditLedger);
         supplierPayment.setAuditStatus(param.getAuditStatusEnum());
         supplierPayment.setPaymentReasonId(param.getPaymentType() != null ? param.getPaymentType().toString() : supplierPayment.getPaymentReasonId());

         try {
            Object number = this.redisUtils.get("supplierPaymentNumber");
            if (ObjectUtils.isEmpty(number)) {
               this.projectSerialNumberUtils.redisSaveSerialNumber();
               number = this.redisUtils.get("supplierPaymentNumber");
            }

            String supplierPaymentNumber = this.projectSerialNumberUtils.dateUtil(number.toString());
            supplierPayment.setApprovalSerialNumber("Z" + supplierPaymentNumber);
            this.redisUtils.incr("supplierPaymentNumber", 1L);
         } catch (Exception e) {
            throw new IllegalArgumentException("获取流水号失败");
         }

         supplierPayment.setActuallyPaymentAmount(param.getActuallyPayAmount());
         supplierPayment.setAuditTime(LocalDateTime.now());
         supplierPayment.setAuditUserId(UserUtil.getCurrentUserId());
         supplierPayment.setAuditUserName(UserUtil.getCurrentName());
         Map<String, BigDecimal> decimalMap = this.contractSupplierPaymentBiz.assetInjectionCheck(project.getId());
         BigDecimal injectAmount = BigDecimal.ZERO;
         if (project.getProjectAttribute().equals(com.hzchum.scim.contract.core.api.enums.ProjectAttributeEnum.JOINT_VENTURE.getType())) {
            injectAmount = decimalMap.get("projectManager").add(decimalMap.get("contractSignBody"));
            BigDecimal projectManagerAmount = ObjectUtils.isNotEmpty(project.getProjectManagerAmount()) ? project.getProjectManagerAmount() : BigDecimal.ZERO;
            BigDecimal contractSignBodyAmount = ObjectUtils.isNotEmpty(project.getContractSignBodyAmount())
               ? project.getContractSignBodyAmount()
               : BigDecimal.ZERO;
            supplierPayment.setResidualAmount(
               projectManagerAmount.add(contractSignBodyAmount).compareTo(param.getActuallyPayAmount()) >= 0
                  ? injectAmount.add(projectManagerAmount.add(contractSignBodyAmount).subtract(param.getActuallyPayAmount()))
                  : injectAmount
            );
         } else if (project.getProjectAttribute().equals(com.hzchum.scim.contract.core.api.enums.ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
            injectAmount = decimalMap.get("projectManager");
            BigDecimal projectManagerAmount = ObjectUtils.isNotEmpty(project.getCollectionSummary()) ? project.getCollectionSummary() : BigDecimal.ZERO;
            supplierPayment.setResidualAmount(
               projectManagerAmount.compareTo(param.getActuallyPayAmount()) >= 0
                  ? projectManagerAmount.subtract(param.getActuallyPayAmount()).add(injectAmount)
                  : injectAmount
            );
         }

         this.supplierPaymentService.updateById(supplierPayment);
         if (supplierPayment.getPaymentAmount().compareTo(param.getActuallyPayAmount()) != 0) {
            this.revocationPayment(project, supplierPayment);
            this.contractSupplierPaymentBiz.deductProjectMoney(project, supplierPayment);
         }
         this.successPaymentUpdateAuditStatus(supplierPayment.getId());
      }

      if (param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())) {
         supplierPayment.setAuditStatus(param.getAuditStatusEnum());
         supplierPayment.setAuditTime(LocalDateTime.now());
         supplierPayment.setAuditUserId(UserUtil.getCurrentUserId());
         supplierPayment.setAuditUserName(UserUtil.getCurrentName());
         this.supplierPaymentService.updateById(supplierPayment);
         contractAuditLedger.setProjectAttribute(project.getProjectAttribute());
         contractAuditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setWrittenById(UserUtil.getCurrentUserId());
         contractAuditLedger.setSubmitDate(LocalDateTime.now());
         this.baseMapper.updateById(contractAuditLedger);
         this.revocationPayment(project, supplierPayment);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean subcontractInvoiceAudit(PaymentInvoiceDTOParam param) {
      ContractAuditLedger auditLedger = this.baseMapper.selectById(param.getAuditId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(auditLedger), "审批单不存在");
      Preconditions.checkArgument(auditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "审核状态有误");
      SupplierInvoice invoice = this.supplierInvoiceService
         .getOne(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getId, auditLedger.getPaymentId())
               .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(invoice), "发票信息不存在");
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(auditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(auditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         SubcontractOrder purchaseOrder = this.subcontractOrderService.getById(invoice.getOrderId());
         Preconditions.checkArgument(ObjectUtils.isNotEmpty(purchaseOrder), "采购合同信息不存在");
         if (purchaseOrder.getBoolSettlementStatus()) {
            List<SupplierInvoice> invoiceList = this.supplierInvoiceService
               .list(
                  Wrappers.lambdaQuery(SupplierInvoice.class)
                     .eq(SupplierInvoice::getOrderId, invoice.getOrderId())
                     .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                     .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               );
            BigDecimal var8 = invoiceList.stream().map(SupplierInvoice::getActualInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
         }

         invoice.setId(invoice.getId());
         invoice.setActualInvoiceAmount(param.getPracticalInvoice());
         invoice.setAuditStatus(param.getAuditStatusEnum());
         invoice.setAuditUserId(UserUtil.getCurrentUserId());
         invoice.setAuditTime(LocalDateTime.now());
         invoice.setRemark(param.getRemark());
         this.supplierInvoiceService.updateById(invoice);
         auditLedger.setActuallyPayAmount(param.getPracticalInvoice());
         auditLedger.setWrittenById(UserUtil.getCurrentUserId());
         auditLedger.setSubmitDate(LocalDateTime.now());
         auditLedger.setApprovalTime(LocalDateTime.now());
         auditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         this.baseMapper.updateById(auditLedger);
      }

      if (param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())) {
         this.supplierInvoiceService
            .updateById(
               SupplierInvoice.builder()
                  .id(invoice.getId())
                  .invoiceAmount(param.getPracticalInvoice())
                  .auditStatus(param.getAuditStatusEnum())
                  .auditUserId(UserUtil.getCurrentUserId())
                  .auditTime(LocalDateTime.now())
                  .remark(param.getRemark())
                  .build()
            );
         auditLedger.setProjectAttribute(auditLedger.getProjectAttribute());
         auditLedger.setActuallyPayAmount(param.getPracticalInvoice());
         auditLedger.setWrittenById(UserUtil.getCurrentUserId());
         auditLedger.setSubmitDate(LocalDateTime.now());
         auditLedger.setApprovalTime(LocalDateTime.now());
         auditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         this.baseMapper.updateById(auditLedger);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean subcontractOrderSettlementAudit(Long auditId, Integer auditStatusEnum, BigDecimal actuallyPayAmount) {
      ContractAuditLedger contractAuditLedger = this.baseMapper.selectById(auditId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(contractAuditLedger), "审批单不存在");
      Preconditions.checkArgument(
         contractAuditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType())
            && !contractAuditLedger.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType()),
         "审批数据审批状态错误"
      );
      SupplierSettlement settlement = this.supplierSettlementService.getById(contractAuditLedger.getPaymentId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(settlement), "结算单不存在");
      Preconditions.checkArgument(
         settlement.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) || settlement.getAuditStatus().equals(AuditStatusEnum.FAILED.getType()),
         "审批数据审批状态错误"
      );
      SubcontractOrder purchaseOrder = this.subcontractOrderService.getById(settlement.getOrderId());
      Preconditions.checkArgument(!purchaseOrder.getBoolSettlementStatus(), "审批数据已结算");
      List<SupplierPayment> paymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, settlement.getOrderId())
               .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      BigDecimal paymentAmount = paymentList.stream().map(SupplierPayment::getActuallyPaymentAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      Preconditions.checkArgument(settlement.getAmount().compareTo(paymentAmount) >= 0, "结算金额不能小于付款总金额");
      List<SupplierInvoice> invoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, settlement.getOrderId())
               .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      BigDecimal invoiceAmount = invoiceList.stream().map(SupplierInvoice::getActualInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      Preconditions.checkArgument(settlement.getAmount().compareTo(invoiceAmount) >= 0, "结算金额不能小于发票总金额");
      settlement.setUpdateTime(LocalDateTime.now());
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(contractAuditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(contractAuditLedger.getId(), auditStatusEnum, null, wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && auditStatusEnum.equals(AuditStatusEnum.SUCCEED.getType())) {
         settlement.setAuditStatus(AuditStatusEnum.SUCCEED.getType());
         settlement.setAmount(actuallyPayAmount);
         purchaseOrder.setBoolSettlementStatus(Boolean.TRUE);
         purchaseOrder.setOrderStatus(SubOrderStatusEnum.SETTLEMENTSTATUS.getType());
         purchaseOrder.setSettlementAmount(contractAuditLedger.getActuallyPayAmount());
         contractAuditLedger.setActuallyPayAmount(settlement.getAmount());
         contractAuditLedger.setActuallyPayAmount(actuallyPayAmount);
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setAuditStatusEnum(auditStatusEnum);
      }

      if (auditStatusEnum.equals(AuditStatusEnum.FAILED.getType())) {
         settlement.setAuditStatus(AuditStatusEnum.FAILED.getType());
         purchaseOrder.setBoolSettlementStatus(Boolean.FALSE);
         contractAuditLedger.setActuallyPayAmount(null);
         contractAuditLedger.setApprovalTime(LocalDateTime.now());
         contractAuditLedger.setAuditStatusEnum(auditStatusEnum);
      }

      this.supplierSettlementService.updateById(settlement);
      this.subcontractOrderService.updateById(purchaseOrder);
      this.baseMapper.updateById(contractAuditLedger);
      return Boolean.TRUE;
   }

   @Override
   public Boolean subcontractOrderPreSettlementAudit(SettleAuditSaveDtoParam param) {
      ContractAuditLedger auditLedger = this.baseMapper.selectById(param.getAuditId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(auditLedger), "审批数据不存在!");
      Preconditions.checkArgument(auditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "审批数据状态错误!");
      SupplierSettlement settlement = this.supplierSettlementService.getById(auditLedger.getPaymentId());
      Preconditions.checkArgument(settlement != null, "结算单不存在");
      Preconditions.checkArgument(settlement.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "审批数据状态错误");
      SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(settlement.getOrderId());
      Preconditions.checkArgument(subcontractOrder != null, "分包订单不存在!");
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(auditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(auditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType()) || param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())
         )
       {
         if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
            Preconditions.checkArgument(param.getSettlementAmount() != null, "结算额不能为空!");
            Preconditions.checkArgument(param.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0, "结算额有误!");
            Preconditions.checkArgument(param.getSettlementAmount().compareTo(settlement.getAmount()) <= 0, "实际结算额不能大于申请金额!");
            settlement.setAmount(param.getSettlementAmount());
            auditLedger.setActuallyPayAmount(param.getSettlementAmount());
         }

         settlement.setAuditStatus(param.getAuditStatusEnum());
         settlement.setAuditUserId(UserUtil.getCurrentUserId());
         settlement.setAuditUserName(UserUtil.getCurrentName());
         settlement.setAuditTime(LocalDateTime.now());
         this.supplierSettlementService.updateById(settlement);
         auditLedger.setApprovalTime(LocalDateTime.now());
         auditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         auditLedger.setWrittenById(UserUtil.getCurrentUserId());
         auditLedger.setSubmitDate(LocalDateTime.now());
         this.baseService.updateById(auditLedger);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean projectPreSettlementAudit(SettleAuditSaveDtoParam param) {
      ContractAuditLedger auditLedger = this.baseService.getById(param.getAuditId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(auditLedger), "审批记录不存在");
      Preconditions.checkArgument(Objects.equals(auditLedger.getPaymentEnum(), AuditPaymentEnum.PROJECT_PRE_SETTLEMENT.getType()), "审批单结算类型不匹配");
      Preconditions.checkArgument(auditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "审批状态已发生变化!!请刷新重试!!");
      ContractSettlement settlement = this.contractSettlementService.getById(auditLedger.getPaymentId());
      Preconditions.checkArgument(settlement != null, "预结算数据丢失!!");
      Preconditions.checkArgument(Objects.equals(String.valueOf(settlement.getProjectId()), auditLedger.getProjectId()), "预结算项目与审批单不匹配");
      Preconditions.checkArgument(settlement.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "数据审批状态已发生变化!!请刷新重试!!");
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(auditLedger.getApproveRecordId());
      Preconditions.checkArgument(wmsApproveRecord != null
         && Objects.equals(wmsApproveRecord.getDataId(), auditLedger.getId())
         && Objects.equals(wmsApproveRecord.getApproveProcessType(), ApproveProcessTypeEnumV2.CONTRACT_PRE_SETTLEMENT_AUDIT.getType()), "审批流程与结算单不匹配");
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(auditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType()) || param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())
         )
       {
         if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
            auditLedger.setActuallyPayAmount(auditLedger.getApplyAmount());
         }

         auditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         auditLedger.setApprovalTime(LocalDateTime.now());
         auditLedger.setWrittenById(UserUtil.getCurrentUserId());
         auditLedger.setSubmitDate(LocalDateTime.now());
         this.baseService.updateById(auditLedger);
         settlement.setAuditStatus(param.getAuditStatusEnum());
         settlement.setAuditUserId(UserUtil.getCurrentUserId());
         settlement.setAuditUserName(UserUtil.getCurrentName());
         settlement.setAuditTime(LocalDateTime.now());
         this.contractSettlementService.updateById(settlement);
      }

      return true;
   }

   @Override
   public ContractTestingFeeAuditDTO getTestingFeeInfo(Long auditId) {
      ContractAuditLedger auditLedger = this.baseService.getById(auditId);
      Preconditions.checkArgument(auditLedger != null, "审批记录不存在!");
      Preconditions.checkArgument(auditLedger.getPaymentEnum().equals(AuditPaymentEnum.TESTING_FEE.getType()), "审批单费用类型不匹配");
      ContractTestingFee testingFee = this.contractTestingFeeService.getById(auditLedger.getPaymentId());
      Preconditions.checkArgument(testingFee != null, "检测费记录不存在!");
      ContractTestingFeeAuditDTO dto = BeanUtil.copy(testingFee, ContractTestingFeeAuditDTO.class);
      dto.setBranchCompanyName(this.branchCompanyService.getNameById(testingFee.getBranchCompanyId()));
      SysDictionary dictionary = this.sysDictionaryService.getById(testingFee.getTestingFeeTypeId());
      dto.setTestingFeeTypeName(dictionary != null ? dictionary.getLabel() : null);
      dto.setUserName(this.userService.getNameById(testingFee.getUserId()));
      this.setApproveInfo(auditLedger, dto);
      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean auditTestingFee(FillFeeAuditSaveParam param) {
      ContractAuditLedger auditLedger = this.baseService.getById(param.getAuditId());
      Preconditions.checkArgument(auditLedger != null, "审批记录不存在!!");
      Preconditions.checkArgument(auditLedger.getPaymentEnum().equals(AuditPaymentEnum.TESTING_FEE.getType()), "审批单费用类型不匹配");
      ContractTestingFee testingFee = this.contractTestingFeeService.getById(auditLedger.getPaymentId());
      Preconditions.checkArgument(testingFee != null, "检测费记录不存在!!");
      Preconditions.checkArgument(
         auditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType())
            && testingFee.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()),
         "检测费记录已审批!!请刷新重试!!"
      );
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(auditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(auditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType()) || param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())
         )
       {
         if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
            auditLedger.setActuallyPayAmount(auditLedger.getApplyAmount());
         }

         auditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         auditLedger.setApprovalTime(LocalDateTime.now());
         auditLedger.setWrittenById(UserUtil.getCurrentUserId());
         auditLedger.setSubmitDate(LocalDateTime.now());
         this.baseService.updateById(auditLedger);
         testingFee.setAuditStatusEnum(param.getAuditStatusEnum());
         testingFee.setAuditorId(UserUtil.getCurrentUserId());
         testingFee.setAuditorName(UserUtil.getCurrentName());
         testingFee.setAuditTime(LocalDateTime.now());
         this.contractTestingFeeService.updateById(testingFee);
      }

      return true;
   }

   @Override
   public ContractWaterElectricityFeeAuditDTO getWaterElectricityFeeInfo(Long auditId) {
      ContractAuditLedger auditLedger = this.baseService.getById(auditId);
      Preconditions.checkArgument(auditLedger != null, "审批记录不存在!");
      Preconditions.checkArgument(auditLedger.getPaymentEnum().equals(AuditPaymentEnum.WATER_ELECTRICITY_FEE.getType()), "审批单费用类型不匹配");
      ContractWaterElectricityPropertyFee fee = this.waterElectricityPropertyFeeService.getById(auditLedger.getPaymentId());
      Preconditions.checkArgument(fee != null, "水电物业费记录不存在!");
      ContractWaterElectricityFeeAuditDTO dto = BeanUtil.copy(fee, ContractWaterElectricityFeeAuditDTO.class);
      dto.setBranchCompanyName(this.branchCompanyService.getNameById(fee.getBranchCompanyId()));
      dto.setUserName(this.userService.getNameById(fee.getUserId()));
      this.setApproveInfo(auditLedger, dto);
      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean auditWaterElectricityFee(FillFeeAuditSaveParam param) {
      ContractAuditLedger auditLedger = this.baseService.getById(param.getAuditId());
      Preconditions.checkArgument(auditLedger != null, "审批记录不存在!!");
      Preconditions.checkArgument(auditLedger.getPaymentEnum().equals(AuditPaymentEnum.WATER_ELECTRICITY_FEE.getType()), "审批单费用类型不匹配");
      ContractWaterElectricityPropertyFee fee = this.waterElectricityPropertyFeeService.getById(auditLedger.getPaymentId());
      Preconditions.checkArgument(fee != null, "水电物业费记录不存在!!");
      Preconditions.checkArgument(
         auditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()) && fee.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()),
         "水电费记录已审批!!请刷新重试!!"
      );
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(auditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(auditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType()) || param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())
         )
       {
         if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
            auditLedger.setActuallyPayAmount(auditLedger.getApplyAmount());
         }

         auditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         auditLedger.setApprovalTime(LocalDateTime.now());
         auditLedger.setWrittenById(UserUtil.getCurrentUserId());
         auditLedger.setSubmitDate(LocalDateTime.now());
         this.baseService.updateById(auditLedger);
         fee.setAuditStatusEnum(param.getAuditStatusEnum());
         fee.setAuditorId(UserUtil.getCurrentUserId());
         fee.setAuditorName(UserUtil.getCurrentName());
         fee.setAuditTime(LocalDateTime.now());
         this.waterElectricityPropertyFeeService.updateById(fee);
      }

      return true;
   }

   @Override
   public ContractReimbursementFeeAuditDTO getReimbursementFeeInfo(Long auditId) {
      ContractAuditLedger auditLedger = this.baseService.getById(auditId);
      Preconditions.checkArgument(auditLedger != null, "审批记录不存在!");
      Preconditions.checkArgument(auditLedger.getPaymentEnum().equals(AuditPaymentEnum.REIMBURSEMENT_FEE.getType()), "审批单费用类型不匹配");
      ContractReimbursementFee fee = this.reimbursementFeeService.getById(auditLedger.getPaymentId());
      Preconditions.checkArgument(fee != null, "报销费用记录不存在!");
      ContractReimbursementFeeAuditDTO dto = BeanUtil.copy(fee, ContractReimbursementFeeAuditDTO.class);
      dto.setBranchCompanyName(this.branchCompanyService.getNameById(fee.getBranchCompanyId()));
      Department department = this.departmentService.getById(fee.getDeptId());
      dto.setDeptName(department != null ? department.getName() : null);
      ContractExpenseType expenseType = this.contractExpenseTypeService.getById(fee.getExpenseTypeId());
      dto.setExpenseTypeName(expenseType != null ? expenseType.getName() : null);
      dto.setReimburserName(this.userService.getNameById(fee.getReimburserId()));
      dto.setWrittenByName(this.userService.getNameById(fee.getWrittenById()));
      this.setApproveInfo(auditLedger, dto);
      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean auditReimbursementFee(FillFeeAuditSaveParam param) {
      ContractAuditLedger auditLedger = this.baseService.getById(param.getAuditId());
      Preconditions.checkArgument(auditLedger != null, "审批记录不存在!!");
      Preconditions.checkArgument(auditLedger.getPaymentEnum().equals(AuditPaymentEnum.REIMBURSEMENT_FEE.getType()), "审批单费用类型不匹配");
      ContractReimbursementFee fee = this.reimbursementFeeService.getById(auditLedger.getPaymentId());
      Preconditions.checkArgument(fee != null, "报销费用记录不存在!!");
      Preconditions.checkArgument(
         auditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()) && fee.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()),
         "报销费用记录已审批!!请刷新重试!!"
      );
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(auditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(auditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType()) || param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())
         )
       {
         if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
            auditLedger.setActuallyPayAmount(auditLedger.getApplyAmount());
         }

         auditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         auditLedger.setApprovalTime(LocalDateTime.now());
         auditLedger.setWrittenById(UserUtil.getCurrentUserId());
         auditLedger.setSubmitDate(LocalDateTime.now());
         this.baseService.updateById(auditLedger);
         fee.setAuditStatusEnum(param.getAuditStatusEnum());
         fee.setAuditorId(UserUtil.getCurrentUserId());
         fee.setAuditorName(UserUtil.getCurrentName());
         fee.setAuditTime(LocalDateTime.now());
         this.reimbursementFeeService.updateById(fee);
      }

      return true;
   }

   @Override
   public ContractWageFeeAuditDTO getWageFeeInfo(Long auditId) {
      ContractAuditLedger auditLedger = this.baseService.getById(auditId);
      Preconditions.checkArgument(auditLedger != null, "审批记录不存在!");
      Preconditions.checkArgument(auditLedger.getPaymentEnum().equals(AuditPaymentEnum.STAFF_WAGE.getType()), "审批单费用类型不匹配");
      ContractWageFee fee = this.contractWageFeeService.getById(auditLedger.getPaymentId());
      Preconditions.checkArgument(fee != null, "工资填报记录不存在!");
      ContractWageFeeAuditDTO dto = BeanUtil.copy(fee, ContractWageFeeAuditDTO.class);
      dto.setBranchCompanyName(this.branchCompanyService.getNameById(fee.getBranchCompanyId()));
      ContractExpenseType expenseType = this.contractExpenseTypeService.getById(fee.getExpenseTypeId());
      dto.setExpenseTypeName(expenseType != null ? expenseType.getName() : null);
      dto.setFounderName(this.userService.getNameById(fee.getFounderId()));
      this.setApproveInfo(auditLedger, dto);
      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean auditWageFee(FillFeeAuditSaveParam param) {
      ContractAuditLedger auditLedger = this.baseService.getById(param.getAuditId());
      Preconditions.checkArgument(auditLedger != null, "审批记录不存在!!");
      Preconditions.checkArgument(auditLedger.getPaymentEnum().equals(AuditPaymentEnum.STAFF_WAGE.getType()), "审批单费用类型不匹配");
      ContractWageFee fee = this.contractWageFeeService.getById(auditLedger.getPaymentId());
      Preconditions.checkArgument(fee != null, "工资费用记录不存在!!");
      Preconditions.checkArgument(
         auditLedger.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()) && fee.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()),
         "工资记录已审批!!请刷新重试!!"
      );
      WmsApproveRecord wmsApproveRecord = this.approveRecordService.getById(auditLedger.getApproveRecordId());
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(auditLedger.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType()) || param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())
         )
       {
         if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
            auditLedger.setActuallyPayAmount(auditLedger.getApplyAmount());
         }

         auditLedger.setAuditStatusEnum(param.getAuditStatusEnum());
         auditLedger.setApprovalTime(LocalDateTime.now());
         auditLedger.setWrittenById(UserUtil.getCurrentUserId());
         auditLedger.setSubmitDate(LocalDateTime.now());
         this.baseService.updateById(auditLedger);
         fee.setAuditStatusEnum(param.getAuditStatusEnum());
         fee.setAuditorId(UserUtil.getCurrentUserId());
         fee.setAuditorName(UserUtil.getCurrentName());
         fee.setAuditTime(LocalDateTime.now());
         this.contractWageFeeService.updateById(fee);
      }

      return true;
   }

   private void setApproveInfo(ContractAuditLedger auditLedger, ContractFeeBaseInfo dto) {
      dto.setAuditId(auditLedger.getId());
      dto.setApproveRecordId(auditLedger.getApproveRecordId());
      Boolean button = this.procurementAudit(auditLedger.getApproveRecordId());
      dto.setPassButton(button);
      dto.setPaymentEnum(auditLedger.getPaymentEnum());
      dto.setBoolFinalApprover(this.getBoolFinalApprove(auditLedger.getId()));
   }

   private enum typeEnum {
      ONE(1, "存在物料库存"),
      TWO(2, "存在成品库存"),
      THREE(3, "存在生产中产品"),
      FOUR(4, "存在未生产产品");

      private final Integer type;
      private final String name;

      public Integer getType() {
         return this.type;
      }

      public String getName() {
         return this.name;
      }

      typeEnum(final Integer type, final String name) {
         this.type = type;
         this.name = name;
      }
   }
}
