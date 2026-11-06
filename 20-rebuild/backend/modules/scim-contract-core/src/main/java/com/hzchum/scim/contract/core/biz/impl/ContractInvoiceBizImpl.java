package com.hzchum.scim.contract.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.BranchCompanyLevelEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.DateTimeUtil;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.biz.ContractInvoiceBiz;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.AuditTypeEnum;
import com.hzchum.scim.contract.core.api.enums.CreateInvoiceTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AmountTypeEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.enums.payment.InvoiceTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCollection;
import com.hzchum.scim.contract.core.api.pojo._do.ContractInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractWaste;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractProjectAssetInjection;
import com.hzchum.scim.contract.core.api.pojo._do.finance.SecurityDepositAndManagementCost;
import com.hzchum.scim.contract.core.api.pojo.dto.CollectionDetailsDto;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectIncomeAndExpenses;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectIncomingAndOutgoingsDto;
import com.hzchum.scim.contract.core.api.pojo.dto.SaveInvoiceDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCheckDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractInvoiceQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractInvoiceSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractInvoiceSaveParamV2;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ContractInvoiceEditDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractInvoiceService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractWasteService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectAssetInjectionService;
import com.hzchum.scim.contract.core.api.service.finance.SecurityDepositAndManagementCostService;
import com.hzchum.scim.contract.core.api.utils.ProjectFinanceUtils;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.utils.ProjectSerialNumberUtils;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinanceAmountLimitConfigDTO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractInvoiceBizImpl implements ContractInvoiceBiz {
   private static final Logger log = LoggerFactory.getLogger(ContractInvoiceBizImpl.class);
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ContractCollectionService collectionService;
   @Resource
   private ContractInvoiceService invoiceService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private UserService userService;
   @Resource
   private ContractCollectionService contractCollectionService;
   @Resource
   private SecurityDepositAndManagementCostService securityDepositAndManagementCostService;
   @Resource
   private ContractWasteService contractWasteService;
   @Resource
   private ConfigService configService;
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private ContractAuditLedgerService contractAuditLedgerService;
   @Resource
   private WmsApproveRecordService approvalsService;
   @Resource
   private ContractProjectAssetInjectionService injectorService;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ProjectSerialNumberUtils projectSerialNumberUtils;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private ProjectBranchCompanyLinkService projectBranchCompanyLinkService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ProjectFinanceUtils projectFinanceUtils;

   @Override
   public PageVO<ContractInvoiceDTO> pageList(ContractInvoiceQueryDtoParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.invoiceService.listInvoice(param));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printList(ContractInvoiceQueryDtoParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (CreateInvoiceTypeEnum.PROJECT_COLLECTION.getType().equals(param.getType())) {
         ProjectInfo project = this.projectService.getSimpleById(param.getProjectId());
         header.put("project", project);
      }

      if (CreateInvoiceTypeEnum.WASTE_COLLECTION.getType().equals(param.getType())) {
         ContractWaste contractWaste = this.contractWasteService.getById(param.getContractWasteId());
         header.put("contractWaste", contractWaste);
         BranchCompany branchCompany = this.branchCompanyService.getById(param.getInvoiceUnitId());
         header.put("branchCompany", branchCompany);
      }

      if (param.getStartDate() != null && param.getEndDate() != null) {
         header.put("statisticsDate", DateTimeUtil.localDateToString(param.getStartDate()) + "~" + DateTimeUtil.localDateToString(param.getEndDate()));
      }

      List<ContractInvoiceDTO> invoiceDTOS = this.invoiceService.listInvoice(param);
      BigDecimal totalAmount = invoiceDTOS.stream().map(ContractInvoiceDTO::getInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("totalAmount", totalAmount);
      printVO.setHeader(header);
      printVO.setTable(invoiceDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public BigDecimal getSummaryInvoice(ContractInvoiceQueryDtoParam param) {
      List<ContractInvoiceDTO> invoiceDTOList = this.invoiceService.listInvoice(param);
      return invoiceDTOList.stream().map(ContractInvoiceDTO::getInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveList(Integer type, List<ContractInvoiceSaveDTOParam> paramList) {
      Preconditions.checkArgument(CreateInvoiceTypeEnum.boolContain(type), "开票类型有误!");
      paramList.forEach(param -> {
         this.checkSave(type, param);
         ContractInvoice invoice = BeanUtil.copy(param, ContractInvoice.class);
         invoice.setType(type);
         BranchCompany branchCompany = this.branchCompanyService.getById(param.getInvoiceUnitId());
         Preconditions.checkArgument(branchCompany != null, "开票单位不存在!");
         invoice.setInvoiceUnit(branchCompany.getName());
         Preconditions.checkArgument(param.getBoolIncludeTax() || param.getTaxRate() == null || param.getTaxRate().compareTo(BigDecimal.ZERO) == 0, "税率有误!");
         Preconditions.checkArgument(!param.getBoolIncludeTax() || param.getTaxRate() != null, "税率不能为空!");
         invoice.setInvoiceType(param.getInvoiceType() != null ? param.getInvoiceType() : 0);
         invoice.setTaxRate(param.getTaxRate() != null ? param.getTaxRate() : BigDecimal.ZERO);
         BigDecimal actualTaxRate = invoice.getTaxRate().divide(BigDecimal.valueOf(100L), 4, RoundingMode.HALF_UP);
         BigDecimal tax = param.getInvoiceAmount().multiply(actualTaxRate).divide(BigDecimal.ONE.add(actualTaxRate), 4, RoundingMode.HALF_UP);
         invoice.setTax(tax);
         invoice.setWrittenById(UserUtil.getCurrentUserId());
         invoice.setWrittenByName(UserUtil.getCurrentName());
         invoice.setAuditStatus(AuditStatusEnum.AUDITING.getType());
         invoice.setAttachments(CollectionUtils.isEmpty(param.getAttachmentIds()) ? null : StringUtils.join(param.getAttachmentIds(), ","));
         this.invoiceService.save(invoice);
      });
      return true;
   }

   private void checkSave(Integer type, ContractInvoiceSaveDTOParam param) {
      if (type.equals(CreateInvoiceTypeEnum.PROJECT_COLLECTION.getType())) {
         Preconditions.checkArgument(param.getProjectId() != null, "项目id不能为空!");
         ContractProject project = this.projectService.getById(param.getProjectId());
         Preconditions.checkArgument(project != null, "项目不存在!");
         param.setContractWasteId(0L);
      } else {
         Preconditions.checkArgument(param.getContractWasteId() != null, "废料合同id不能为空!");
         ContractWaste contractWaste = this.contractWasteService.getById(param.getContractWasteId());
         Preconditions.checkArgument(contractWaste != null, "废料合同不存在!");
         param.setProjectId(0L);
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean auditInvoice(ContractCheckDtoParam param) {
      ContractInvoice invoice = this.invoiceService.getById(param.getId());
      Preconditions.checkArgument(invoice != null, "开票填报信息不存在!");
      Preconditions.checkArgument(invoice.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "开票信息已审核!");
      invoice.setAuditStatus(param.getAuditStatus());
      invoice.setAuditorId(UserUtil.getCurrentUserId());
      invoice.setAuditorName(UserUtil.getCurrentName());
      invoice.setAuditTime(LocalDateTime.now());
      invoice.setActualInvoiceAmount(param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()) ? invoice.getInvoiceAmount() : null);
      this.invoiceService.updateById(invoice);
      if (invoice.getType().equals(CreateInvoiceTypeEnum.PROJECT_COLLECTION.getType()) && param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())) {
         ContractProject project = this.projectService.getById(invoice.getProjectId());
         Preconditions.checkArgument(project != null, "项目不存在!");
         project.setInvoiceAmount(this.invoiceService.getInvoiceAmount(invoice.getProjectId()));
         this.projectService.updateById(project);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateInvoice(ContractInvoiceEditDTOParam param) {
      ContractInvoice invoice = this.invoiceService.getById(param.getId());
      Preconditions.checkArgument(invoice != null, "开票填报信息不存在!");
      Preconditions.checkArgument(invoice.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "只有待审核状态,才能重新编辑!");
      BeanUtil.copy(param, invoice);
      Preconditions.checkArgument(param.getInvoiceType().equals(InvoiceTypeEnum.RECEIPTS.getType()) || param.getTaxRate() != null, "税率不能为空!");
      invoice.setInvoiceType(param.getInvoiceType() == null ? 0 : param.getInvoiceType());
      Preconditions.checkArgument(param.getBoolIncludeTax() || param.getTaxRate() == null || param.getTaxRate().compareTo(BigDecimal.ZERO) == 0, "税率有误!");
      Preconditions.checkArgument(!param.getBoolIncludeTax() || param.getTaxRate() != null, "税率不能为空!");
      invoice.setTaxRate(param.getTaxRate() == null ? BigDecimal.ZERO : param.getTaxRate());
      BigDecimal actualTaxRate = invoice.getTaxRate().divide(BigDecimal.valueOf(100L), 4, RoundingMode.HALF_UP);
      BigDecimal tax = param.getInvoiceAmount().multiply(actualTaxRate).divide(BigDecimal.ONE.add(actualTaxRate), 4, RoundingMode.HALF_UP);
      invoice.setTax(tax);
      invoice.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      invoice.setLastEditorUserId(UserUtil.getCurrentUserId());
      invoice.setAttachments(CollectionUtils.isEmpty(param.getAttachmentIds()) ? null : StringUtils.join(param.getAttachmentIds(), ","));
      this.invoiceService.updateById(invoice);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delete(Long id) {
      ContractInvoice invoice = this.invoiceService.getById(id);
      Preconditions.checkArgument(invoice != null, "删除失败,开票记录不存在");
      Preconditions.checkArgument(invoice.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "删除失败,开票记录已审核");
      this.invoiceService.removeById(id);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveInvoice(ContractInvoiceSaveParamV2 param) {
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在!");
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      if (boolTwoLevelUnit) {
         Preconditions.checkArgument(param.getLevel() != null, "单位等级未知!");
      } else {
         param.setLevel(BranchCompanyLevelEnum.SECONDARY_UNIT.getType());
      }

      Preconditions.checkArgument(param.getInvoiceAmount().compareTo(BigDecimal.ZERO) != 0, "发票额不能为0!");
      Preconditions.checkArgument(InvoiceTypeEnum.isExist(param.getInvoiceType()), "发票类型有误!");
      param.setTaxRate(BigDecimal.ZERO);
      if (!param.getInvoiceType().equals(InvoiceTypeEnum.RECEIPTS.getType())) {
         Preconditions.checkArgument(StringUtils.isNotBlank(param.getTaxRateTypeValue()), "税率类型不能为空!");
         Preconditions.checkArgument(StringUtils.isNotBlank(param.getInvoiceNo()), "发票号码不能为空！");
         SysDictionary dictionary = this.dictionaryService
            .getOne(
               Wrappers.lambdaQuery(SysDictionary.class)
                  .eq(SysDictionary::getName, DictionaryEnum.INVOICE_TAX_RATE.getName())
                  .eq(SysDictionary::getValue, param.getTaxRateTypeValue())
            );
         Preconditions.checkArgument(dictionary != null, "税率类型不存在!");
         param.setTaxRate(new BigDecimal(dictionary.getLabel()));
      }

      param.setInvoiceNo(param.getInvoiceNo() != null ? param.getInvoiceNo() : "");
      ProjectBranchCompanyLink link = this.projectBranchCompanyLinkService
         .getOne(
            Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
               .eq(ProjectBranchCompanyLink::getProjectId, param.getProjectId())
               .eq(ProjectBranchCompanyLink::getBranchCompanyLevel, param.getLevel())
         );
      Preconditions.checkArgument(link != null, "开票单位有误!");
      BranchCompany branchCompany = this.branchCompanyService.getById(link.getBranchCompanyId());
      Preconditions.checkArgument(branchCompany != null, "开票单位不存在!");
      BigDecimal invoiceAmount = this.invoiceService
         .list(
            Wrappers.lambdaQuery(ContractInvoice.class)
               .eq(ContractInvoice::getProjectId, param.getProjectId())
               .eq(ContractInvoice::getInvoiceUnitId, branchCompany.getId())
               .in(ContractInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getInvoiceAmount() : s.getActualInvoiceAmount())
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
      if (project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())) {
         if (!financeAmountLimitConfig.getBoolAllowOverContractAmount()) {
            Preconditions.checkArgument(invoiceAmount.add(param.getInvoiceAmount()).compareTo(project.getContractAmount()) <= 0, "开票总额(含未审批)不能大于项目合同额!");
         }

         if (!financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
            ContractAuditLedger contractAuditLedger = this.contractAuditLedgerService
               .getOne(
                  Wrappers.lambdaQuery(ContractAuditLedger.class)
                     .eq(ContractAuditLedger::getPaymentEnum, AuditPaymentEnum.PROJECT_SETTLEMENT.getType())
                     .eq(ContractAuditLedger::getAuditStatusEnum, AuditStatusEnum.AUDITING.getType())
                     .eq(ContractAuditLedger::getProjectId, String.valueOf(param.getProjectId()))
               );
            Preconditions.checkArgument(
               contractAuditLedger == null || invoiceAmount.add(param.getInvoiceAmount()).compareTo(contractAuditLedger.getApplyAmount()) <= 0,
               "该项目已发起结算审批，暂不允许开票!"
            );
         }
      }

      if (project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) && !financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
         Preconditions.checkArgument(invoiceAmount.add(param.getInvoiceAmount()).compareTo(project.getSettlementAmount()) <= 0, "开票总额(含未审批)不能大于项目结算额!");
      }

      ContractInvoice invoice = BeanUtil.copy(param, ContractInvoice.class);
      invoice.setProjectId(param.getProjectId());
      invoice.setInvoiceUnitId(branchCompany.getId());
      invoice.setInvoiceUnit(branchCompany.getName());
      invoice.setTax(param.getInvoiceAmount().multiply(param.getTaxRate()).divide(BigDecimal.valueOf(100L), 4, RoundingMode.HALF_UP));
      invoice.setWrittenById(param.getWrittenById() != null ? param.getWrittenById() : UserUtil.getCurrentUserId());
      invoice.setWrittenByName(param.getWrittenById() != null ? this.userService.getNameById(param.getWrittenById()) : UserUtil.getCurrentName());
      invoice.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      invoice.setAttachments(StringUtils.join(param.getAttachmentId(), ","));
      this.invoiceService.save(invoice);
      ContractAuditLedger contractAuditLedger = ContractAuditLedger.builder()
         .projectAttribute(project.getProjectAttribute())
         .paymentEnum(AuditPaymentEnum.OUTGOING_INVOICES.getType())
         .projectId(String.valueOf(invoice.getProjectId()))
         .contractNumber(project.getSerialNumber())
         .contractSignBodyId(project.getContractSignBodyId())
         .auditStatusEnum(AuditStatusEnum.AUDITING.getType())
         .auditType(AuditTypeEnum.CONTRACT_APPROVE.getType())
         .projectManagerId(project.getSignerId())
         .paymentId(String.valueOf(invoice.getId()))
         .filingDate(param.getInvoiceDate())
         .initiatorId(param.getWrittenById() != null ? param.getWrittenById() : UserUtil.getCurrentUserId())
         .applyAmount(invoice.getInvoiceAmount())
         .build();
      this.contractAuditLedgerService.save(contractAuditLedger);
      WmsApproveRecord record = this.approvalsService
         .createRecord(
            contractAuditLedger.getId(),
            contractAuditLedger.getContractNumber(),
            ApproveProcessTypeEnumV2.CONTRACT_INVOICE_AUDIT.getType(),
            null,
            null,
            null,
            true,
            null,
            null,
            null
         );
      contractAuditLedger.setApproveRecordId(record.getId());
      this.contractAuditLedgerService.updateById(contractAuditLedger);
      return true;
   }

   @Override
   public SaveInvoiceDto getProject(Long projectId, Integer level) {
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      if (boolTwoLevelUnit && project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         Preconditions.checkArgument(level != null, "单位等级未知!");
      } else {
         level = BranchCompanyLevelEnum.SECONDARY_UNIT.getType();
      }

      Preconditions.checkArgument(project != null, "项目不存在!");
      ProjectBranchCompanyLink projectBranchCompanyLink = this.projectBranchCompanyLinkService
         .getOne(
            Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
               .eq(ProjectBranchCompanyLink::getProjectId, projectId)
               .eq(ProjectBranchCompanyLink::getBranchCompanyLevel, level)
         );
      Preconditions.checkArgument(projectBranchCompanyLink != null, "开票单位有误!");
      BranchCompany branchCompany = this.branchCompanyService.getById(projectBranchCompanyLink.getBranchCompanyId());
      Preconditions.checkArgument(branchCompany != null, "开票单位不存在!");
      List<ContractInvoice> invoiceList = this.invoiceService
         .list(
            Wrappers.lambdaQuery(ContractInvoice.class)
               .eq(ContractInvoice::getProjectId, projectId)
               .eq(ContractInvoice::getInvoiceUnitId, branchCompany.getId())
               .eq(ContractInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      return new SaveInvoiceDto()
         .setUserId(UserUtil.getCurrentUserId())
         .setUserName(UserUtil.getCurrentName())
         .setProjectName(project.getSerialNumber() + "-" + project.getShortName())
         .setInvoiceUnitId(branchCompany.getId())
         .setInvoiceUnit(branchCompany.getName())
         .setProjectManagerId(project.getProjectManagerId())
         .setProjectManagerName(this.userService.getNameById(project.getProjectManagerId()))
         .setProjectAttribute(project.getProjectAttribute())
         .setCollectionUnit(
            project.getContractSignBodyId().equals(branchCompany.getId())
               ? project.getCustomerUnit()
               : this.branchCompanyService.getNameById(project.getContractSignBodyId())
         )
         .setCollectionAmountSum(invoiceList.stream().map(ContractInvoice::getInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
   }

   @Override
   public PrintVO downloadInvoice(Long projectId, Integer level) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
      Preconditions.checkArgument(branchCompany != null, "项目签定主体不存在!");
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      Preconditions.checkArgument(project != null, "项目不存在!");
      if (boolTwoLevelUnit && project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         Preconditions.checkArgument(level != null, "单位等级未知!");
      } else {
         level = null;
      }

      Long invoiceUnitId = this.getInvoiceUnitId(projectId, level);
      List<ContractInvoice> contractInvoiceList = this.invoiceService.listPageLedger(projectId, invoiceUnitId);
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put(
         "project",
         ProjectInfo.builder().id(projectId).name(project.getName()).shortName(project.getShortName()).serialNumber(project.getSerialNumber()).build()
      );
      header.put("signingDate", project.getSigningDate() != null ? project.getSigningDate() : project.getCreateTime().toLocalDate());
      Long salesLeaderId = project.getSalesLeaderId() != null ? project.getSalesLeaderId() : project.getSignerId();
      header.put("salesLeader", this.userService.getNameById(salesLeaderId));
      header.put(
         "projectStatus",
         project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) ? "已结算" : ProjectStatusEnum.getNameByType(project.getStatus())
      );
      List<ContractCollection> contractCollections = this.collectionService.listCollectionLedger(projectId, invoiceUnitId);
      BigDecimal accumulatedCollection = contractCollections.stream().map(ContractCollection::getCollectionAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("accumulatedCollection", accumulatedCollection);
      BigDecimal accumulatedInvoice = contractInvoiceList.stream().map(ContractInvoice::getActualInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("accumulatedInvoice", accumulatedInvoice);
      if (BranchCompanyLevelEnum.PRIMARY_UNIT.getType().equals(level)) {
         Map<Long, BigDecimal> projectFirstLevelUnitCostMap = this.projectFinanceUtils.getProjectFirstLevelUnitCost(Collections.singletonList(projectId));
         header.put("accumulatedCost", projectFirstLevelUnitCostMap.get(projectId).setScale(2, RoundingMode.HALF_UP));
         header.put("availableBalance", accumulatedCollection.subtract(projectFirstLevelUnitCostMap.get(projectId)).setScale(2, RoundingMode.HALF_UP));
      }

      if (level != null && !branchCompany.getLevel().equals(level)) {
         header.put("contractAmount", "/");
         header.put("settlementAmount", "/");
         header.put("advancesReceived", "/");
      } else {
         header.put("contractAmount", project.getContractAmount());
         header.put("settlementAmount", project.getSettlementAmount());
         BigDecimal collectionRatio = project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
            ? accumulatedCollection.multiply(BigDecimal.valueOf(100L)).divide(project.getSettlementAmount(), 2, RoundingMode.HALF_UP)
            : accumulatedCollection.multiply(BigDecimal.valueOf(100L)).divide(project.getContractAmount(), 2, RoundingMode.HALF_UP);
         BigDecimal invoiceRatio = project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
            ? accumulatedInvoice.multiply(BigDecimal.valueOf(100L)).divide(project.getSettlementAmount(), 2, RoundingMode.HALF_UP)
            : accumulatedInvoice.multiply(BigDecimal.valueOf(100L)).divide(project.getContractAmount(), 2, RoundingMode.HALF_UP);
         header.put("collectionRatio", collectionRatio);
         header.put("invoiceRatio", invoiceRatio);
         BigDecimal advancesReceived = project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())
            ? project.getContractAmount().subtract(accumulatedCollection)
            : project.getSettlementAmount().subtract(accumulatedCollection);
         header.put("advancesReceived", advancesReceived.compareTo(BigDecimal.ZERO) >= 0 ? advancesReceived : BigDecimal.ZERO);
      }

      printVO.setHeader(header);
      printVO.setTable(contractInvoiceList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PageVO<ContractInvoiceV2DTO> listPageLedger(Long projectId, Integer level, Integer pageNumber, Integer pageSize) {
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      if (boolTwoLevelUnit && project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         Preconditions.checkArgument(level != null, "单位等级未知!");
      } else {
         level = null;
      }

      Long invoiceUnitId = this.getInvoiceUnitId(projectId, level);
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<ContractInvoice> contractInvoices = this.invoiceService.listPageLedger(projectId, invoiceUnitId);
      List<ContractInvoiceV2DTO> invoiceV2DTOList = contractInvoices.stream().map(c -> {
         ContractInvoiceV2DTO invoiceV2DTO = BeanUtil.copy(c, ContractInvoiceV2DTO.class);
         invoiceV2DTO.setAttachments(this.attachmentService.listByIds(c.getAttachments()));
         return invoiceV2DTO;
      }).collect(Collectors.toList());
      return new PageVO<>(page, invoiceV2DTOList);
   }

   private Long getInvoiceUnitId(Long projectId, Integer level) {
      Long invoiceUnitId = null;
      if (level != null) {
         Preconditions.checkArgument(StringUtils.isNotBlank(BranchCompanyLevelEnum.getNameByType(level)), "项目单位等级有误!");
         List<ProjectBranchCompanyLink> projectBranchCompanyLinkList = this.projectBranchCompanyLinkService
            .list(Wrappers.lambdaQuery(ProjectBranchCompanyLink.builder().projectId(projectId).branchCompanyLevel(level).build()));
         Preconditions.checkArgument(!projectBranchCompanyLinkList.isEmpty(), "该项目未关联该等级单位!");
         invoiceUnitId = projectBranchCompanyLinkList.get(0).getBranchCompanyId();
      }

      return invoiceUnitId;
   }

   @Override
   public PageVO<ProjectIncomeAndExpenses> projectIncomeAndExpensesList(
      Long projectId, String remark, Integer collectionMode, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize
   ) {
      List<ProjectIncomeAndExpenses> filterList = this.getProjectIncomeAndExpenses(projectId, remark, collectionMode, startDate, endDate);
      List<ProjectIncomeAndExpenses> page = PageUtils.getPage(
         filterList.stream().sorted(Comparator.comparing(ProjectIncomeAndExpenses::getStartDate).reversed()).collect(Collectors.toList()), pageNumber, pageSize
      );
      PageVO<ProjectIncomeAndExpenses> objectPageVO = new PageVO<>(page);
      objectPageVO.setTotalElements(filterList.size());
      return objectPageVO;
   }

   @NotNull
   private List<ProjectIncomeAndExpenses> getProjectIncomeAndExpenses(
      Long projectId, String remark, Integer collectionMode, LocalDate startDate, LocalDate endDate
   ) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(project), "项目不存在!");
      List<ProjectIncomeAndExpenses> list = new ArrayList<>();
      List<ContractCollection> contractCollectionList = this.contractCollectionService
         .selectIncomeAndExpenses(projectId, remark, collectionMode, startDate, endDate);
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .isNotNull(PurchaseOrder::getProjectIds)
               .eq(PurchaseOrder::getProjectAttribute, project.getProjectAttribute())
         )
         .stream()
         .filter(order -> Arrays.asList(order.getProjectIds().split(",")).contains(projectId.toString()))
         .collect(Collectors.toList());
      Map<Long, PurchaseOrder> orderMap = orderList.stream().collect(Collectors.toMap(PurchaseOrder::getId, Function.identity()));
      List<SupplierPayment> paymentList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(orderList)) {
         List<Long> orderIds = orderList.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
         paymentList = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .in(SupplierPayment::getOrderId, orderIds)
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                  .apply(startDate != null && endDate != null, "date_format(create_time,'%Y-%m-%d') between {0} and {1}", startDate, endDate)
            );
      }

      List<SecurityDepositAndManagementCost> seAndMaCostList = this.securityDepositAndManagementCostService
         .list(
            Wrappers.lambdaQuery(SecurityDepositAndManagementCost.class)
               .like(remark != null, SecurityDepositAndManagementCost::getRemark, remark)
               .eq(SecurityDepositAndManagementCost::getProjectId, projectId)
               .apply(startDate != null && endDate != null, "date_format(create_time,'%Y-%m-%d') between {0} and {1}", startDate, endDate)
         );
      contractCollectionList.forEach(
         collection -> list.add(
            new ProjectIncomeAndExpenses()
               .setId(collection.getProjectId())
               .setRemark(collection.getPaymentUnit())
               .setStartDate(collection.getCollectionDate().atStartOfDay())
               .setIncome(collection.getCollectionAmount())
               .setIncomeType(collection.getCollectionMode())
         )
      );
      seAndMaCostList.stream()
         .filter(s -> s.getAmountType() == 1)
         .forEach(
            seAndMaCost -> list.add(
               new ProjectIncomeAndExpenses()
                  .setRemark("保证金")
                  .setId(seAndMaCost.getProjectId())
                  .setStartDate(seAndMaCost.getDateTime())
                  .setIncome(seAndMaCost.getSecurityRecord())
                  .setId(seAndMaCost.getProjectId())
                  .setStartDate(seAndMaCost.getDateTime())
                  .setExpense(seAndMaCost.getSecurityDeductIncome())
            )
         );
      seAndMaCostList.stream()
         .filter(s -> s.getAmountType() == 2)
         .forEach(
            seAndMaCost -> list.add(
               new ProjectIncomeAndExpenses()
                  .setRemark("管理费")
                  .setId(seAndMaCost.getProjectId())
                  .setStartDate(seAndMaCost.getDateTime())
                  .setIncome(seAndMaCost.getManagementRecord())
                  .setId(seAndMaCost.getProjectId())
                  .setStartDate(seAndMaCost.getDateTime())
                  .setExpense(seAndMaCost.getManagementDeductIncome())
            )
         );
      if (CollectionUtils.isNotEmpty(paymentList)) {
         paymentList.forEach(
            a -> list.add(
               new ProjectIncomeAndExpenses()
                  .setId(projectId)
                  .setExpenseType(Integer.valueOf(a.getPaymentReasonId()))
                  .setRemark(orderMap.get(a.getOrderId()).getSerialNumber())
                  .setStartDate(a.getPaymentDate().atStartOfDay())
                  .setExpense(a.getActuallyPaymentAmount())
            )
         );
      }

      List<ProjectIncomeAndExpenses> listDto = list;
      List<ProjectIncomeAndExpenses> filterList = new ArrayList<>();
      if (ObjectUtils.isNotEmpty(collectionMode)) {
         listDto = listDto.stream().filter(a -> a.getIncomeType() != null || a.getExpenseType() != null).collect(Collectors.toList());
         filterList.addAll(
            listDto.stream()
               .filter(a -> ObjectUtils.isNotEmpty(a.getExpenseType()))
               .filter(a -> a.getExpenseType().equals(collectionMode))
               .collect(Collectors.toList())
         );
         filterList.addAll(
            listDto.stream()
               .filter(a -> ObjectUtils.isNotEmpty(a.getIncomeType()))
               .filter(a -> a.getIncomeType().equals(collectionMode))
               .collect(Collectors.toList())
         );
         return filterList;
      } else {
         return ObjectUtils.isNotEmpty(remark)
            ? listDto.stream().filter(a -> ObjectUtils.isNotEmpty(a.getRemark())).filter(a -> a.getRemark().equals(remark)).collect(Collectors.toList())
            : listDto;
      }
   }

   @Override
   public ProjectIncomingAndOutgoingsDto projectIncomeAndExpenses(
      String projectAttribute, Long projectManagerId, Long projectId, LocalDate startDate, LocalDate endDate
   ) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      BigDecimal paymentAmount = BigDecimal.ZERO;
      if (!project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         BigDecimal bigDecimal = this.lumpSumSystem(project);
         BigDecimal managementFee = this.getManagementFee(project);
         BigDecimal securityDepositSum = this.SecurityDepositSum(project);
         paymentAmount = bigDecimal.add(managementFee).add(securityDepositSum);
      } else {
         BigDecimal selfEmployedBigDecimal = this.getSelfEmployedBigDecimal(projectId);
         BigDecimal managementFee = this.getManagementFee(project);
         paymentAmount = selfEmployedBigDecimal.add(managementFee);
      }

      Map<Object, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      List<ContractCollection> collectionList = this.contractCollectionService
         .list(
            Wrappers.lambdaQuery(ContractCollection.class)
               .eq(ContractCollection::getProjectId, projectId)
               .eq(ContractCollection::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      BigDecimal income = BigDecimal.ZERO;
      if (CollectionUtils.isNotEmpty(collectionList)) {
         income = collectionList.stream().map(ContractCollection::getCollectionAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      }

      List<ContractInvoice> invoiceList = this.invoiceService
         .list(
            Wrappers.lambdaQuery(ContractInvoice.class)
               .eq(ContractInvoice::getProjectId, projectId)
               .eq(ContractInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      BigDecimal expense = BigDecimal.ZERO;
      if (CollectionUtils.isNotEmpty(invoiceList)) {
         expense = invoiceList.stream().map(ContractInvoice::getActualInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      }

      CollectionDetailsDto detailsDto = new CollectionDetailsDto()
         .setContractAmount(project.getContractAmount())
         .setCashSurplus(project.getCollectionSummary())
         .setProjectId(projectId)
         .setInvoiceAmountSum(expense)
         .setContractAmountSum(income);
      if (!project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         projectManagerId = projectManagerId != null ? projectManagerId : project.getSalesLeaderId();
      }

      if (project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())) {
         detailsDto.setContractAmountRate(
            project.getContractAmount().compareTo(BigDecimal.ZERO) != 0
               ? income.divide(project.getContractAmount(), 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L))
               : BigDecimal.ZERO
         );
         detailsDto.setInvoiceAmountRate(
            project.getContractAmount().compareTo(BigDecimal.ZERO) != 0
               ? expense.divide(project.getContractAmount(), 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L))
               : BigDecimal.ZERO
         );
      } else {
         detailsDto.setContractAmountRate(
            project.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0
               ? income.divide(project.getSettlementAmount(), 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L))
               : BigDecimal.ZERO
         );
         detailsDto.setInvoiceAmountRate(
            project.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0
               ? expense.divide(project.getSettlementAmount(), 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L))
               : BigDecimal.ZERO
         );
      }

      BigDecimal contractSignBodyAmount = BigDecimal.ZERO;
      BigDecimal projectManagerAmount = BigDecimal.ZERO;
      BigDecimal projectManagerScale = BigDecimal.ZERO;
      BigDecimal contractSignBodyScale = BigDecimal.ZERO;
      if (!project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         List<ContractProjectAssetInjection> list = this.injectorService
            .list(Wrappers.lambdaQuery(ContractProjectAssetInjection.class).eq(ContractProjectAssetInjection::getProjectId, projectId));
         if (CollectionUtils.isNotEmpty(list)) {
            Map<Boolean, List<ContractProjectAssetInjection>> projectManagerMap = list.stream()
               .filter(a -> ObjectUtils.isNotEmpty(a.getProjectManagerId()))
               .collect(Collectors.groupingBy(ContractProjectAssetInjection::getIncomeOrDisburse));
            Map<Boolean, List<ContractProjectAssetInjection>> contractSignBodyMap = list.stream()
               .filter(a -> ObjectUtils.isNotEmpty(a.getContractSignBodyId()))
               .collect(Collectors.groupingBy(ContractProjectAssetInjection::getIncomeOrDisburse));
            BigDecimal projectManagerIncome = BigDecimal.ZERO;
            if (ObjectUtils.isNotEmpty(projectManagerMap.get(Boolean.TRUE))) {
               projectManagerIncome = projectManagerMap.get(Boolean.TRUE)
                  .stream()
                  .map(ContractProjectAssetInjection::getProjectManagerScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
            }

            BigDecimal projectManagerDisburse = BigDecimal.ZERO;
            if (ObjectUtils.isNotEmpty(projectManagerMap.get(Boolean.FALSE))) {
               projectManagerDisburse = projectManagerMap.get(Boolean.FALSE)
                  .stream()
                  .map(ContractProjectAssetInjection::getProjectManagerScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
            }

            projectManagerAmount = projectManagerIncome.subtract(projectManagerDisburse);
            if (project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
               projectManagerScale = ObjectUtils.isNotEmpty(project.getProjectManagerAmount())
                  ? project.getProjectManagerAmount().add(projectManagerAmount)
                  : projectManagerAmount;
            } else {
               projectManagerScale = projectManagerAmount.add(project.getCollectionSummary());
            }

            if (project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
               BigDecimal contractSignBodyIncome = BigDecimal.ZERO;
               if (ObjectUtils.isNotEmpty(contractSignBodyMap.get(Boolean.TRUE))) {
                  contractSignBodyIncome = contractSignBodyMap.get(Boolean.TRUE)
                     .stream()
                     .filter(a -> ObjectUtils.isNotEmpty(a.getContractSignBodyScale()))
                     .map(ContractProjectAssetInjection::getContractSignBodyScale)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
               }

               BigDecimal contractSignBodyDisburse = BigDecimal.ZERO;
               if (ObjectUtils.isNotEmpty(contractSignBodyMap.get(Boolean.FALSE))) {
                  contractSignBodyDisburse = contractSignBodyMap.get(Boolean.FALSE)
                     .stream()
                     .filter(a -> ObjectUtils.isNotEmpty(a.getContractSignBodyScale()))
                     .map(ContractProjectAssetInjection::getContractSignBodyScale)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
               }

               contractSignBodyAmount = contractSignBodyIncome.subtract(contractSignBodyDisburse);
               contractSignBodyScale = ObjectUtils.isNotEmpty(project.getContractSignBodyAmount())
                  ? project.getContractSignBodyAmount().add(contractSignBodyAmount)
                  : contractSignBodyAmount;
            }
         } else if (project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
            projectManagerScale = ObjectUtils.isNotEmpty(project.getProjectManagerAmount()) ? project.getProjectManagerAmount() : BigDecimal.ZERO;
            contractSignBodyScale = ObjectUtils.isNotEmpty(project.getContractSignBodyAmount()) ? project.getContractSignBodyAmount() : BigDecimal.ZERO;
         } else {
            projectManagerScale = ObjectUtils.isNotEmpty(project.getCollectionSummary()) ? project.getCollectionSummary() : BigDecimal.ZERO;
         }
      }

      return new ProjectIncomingAndOutgoingsDto()
         .setProjectId(projectId)
         .setProjectManagerAmount(projectManagerScale)
         .setProjectManagerScale(project.getProjectManagerScale())
         .setProjectManagerName(
            ObjectUtils.isNotEmpty(userMap.get(project.getProjectManagerId())) ? userMap.get(project.getProjectManagerId()).getName() : null
         )
         .setContractSignBodyScale(project.getContractSignBodyScale())
         .setContractSignBodyAmount(contractSignBodyScale)
         .setContractSignBodyName(
            ObjectUtils.isNotEmpty(branchCompanyMap.get(project.getContractSignBodyId()))
               ? branchCompanyMap.get(project.getContractSignBodyId()).getName()
               : null
         )
         .setProjectAttribute(project.getProjectAttribute())
         .setProjectName(project.getSerialNumber() + "-" + project.getName())
         .setDate(project.getStartDate() + "-" + LocalDate.now())
         .setIncome(income)
         .setRemainingSum(contractSignBodyScale.add(projectManagerScale))
         .setProjectManagerId(projectManagerId)
         .setExpense(paymentAmount)
         .setCollectionDetailsDto(detailsDto);
   }

   private BigDecimal lumpSumSystem(ContractProject project) {
      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService
         .list(Wrappers.lambdaQuery(PurchaseOrder.class).isNotNull(PurchaseOrder::getProjectIds))
         .stream()
         .filter(order -> Arrays.asList(order.getProjectIds().split(",")).contains(project.getId().toString()))
         .collect(Collectors.toList());
      BigDecimal paymentAmount = BigDecimal.ZERO;
      if (CollectionUtils.isNotEmpty(purchaseOrders)) {
         Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
            .list()
            .stream()
            .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
         List<Long> orderIds = purchaseOrders.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(orderIds)) {
            List<SupplierPayment> paymentList = this.supplierPaymentService
               .list(Wrappers.lambdaQuery(SupplierPayment.class).in(SupplierPayment::getOrderId, orderIds));
            paymentAmount = paymentList.stream()
               .filter(a -> a.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()))
               .filter(ObjectUtils::isNotEmpty)
               .map(SupplierPayment::getActuallyPaymentAmount)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
         }
      }

      return paymentAmount;
   }

   @NotNull
   private BigDecimal getManagementFee(ContractProject project) {
      List<SecurityDepositAndManagementCost> costList = this.securityDepositAndManagementCostService
         .list(
            Wrappers.lambdaQuery(SecurityDepositAndManagementCost.class)
               .eq(SecurityDepositAndManagementCost::getAmountType, AmountTypeEnum.MANAGEMENT_COST.getType())
               .eq(SecurityDepositAndManagementCost::getProjectId, project.getId())
         );
      BigDecimal managementDeductIncome = BigDecimal.ZERO;
      BigDecimal managementRecord = BigDecimal.ZERO;
      if (!costList.isEmpty()) {
         managementDeductIncome = costList.stream()
            .filter(a -> a.getManagementDeductIncome() != null)
            .map(SecurityDepositAndManagementCost::getManagementDeductIncome)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         managementRecord = costList.stream()
            .filter(a -> a.getManagementRecord() != null)
            .map(SecurityDepositAndManagementCost::getManagementRecord)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      }

      return managementDeductIncome.subtract(managementRecord);
   }

   @NotNull
   private BigDecimal SecurityDepositSum(ContractProject project) {
      List<SecurityDepositAndManagementCost> costList = this.securityDepositAndManagementCostService
         .list(
            Wrappers.lambdaQuery(SecurityDepositAndManagementCost.class)
               .eq(SecurityDepositAndManagementCost::getAmountType, AmountTypeEnum.SECURITY_DEPOSIT.getType())
               .eq(SecurityDepositAndManagementCost::getProjectId, project.getId())
         );
      if (costList.isEmpty()) {
         return BigDecimal.ZERO;
      }

      BigDecimal securityDeductIncome = costList.stream()
         .filter(a -> a.getSecurityDeductIncome() != null)
         .map(SecurityDepositAndManagementCost::getSecurityDeductIncome)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal securityRecord = costList.stream()
         .filter(a -> a.getSecurityRecord() != null)
         .map(SecurityDepositAndManagementCost::getSecurityRecord)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      return securityDeductIncome.subtract(securityRecord);
   }

   @NotNull
   private BigDecimal getSelfEmployedBigDecimal(Long projectId) {
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list(Wrappers.lambdaQuery(BranchCompany.class).eq(BranchCompany::getIsParent, 1))
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      ContractProject project = this.projectService.getById(projectId);
      Long branchCompany = null;
      if (branchCompanyMap.get(project.getContractSignBodyId()) != null) {
         branchCompany = project.getContractSignBodyId();
      }

      BigDecimal paymentAmount = BigDecimal.ZERO;
      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .isNotNull(PurchaseOrder::getProjectIds)
               .eq(branchCompany != null, PurchaseOrder::getBranchCompanyId, branchCompany)
         )
         .stream()
         .filter(order -> Arrays.asList(order.getProjectIds().split(",")).contains(projectId.toString()))
         .collect(Collectors.toList());
      if (!purchaseOrders.isEmpty()) {
         List<Long> orderIds = purchaseOrders.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
         List<SupplierPayment> paymentList = this.supplierPaymentService
            .list(Wrappers.lambdaQuery(SupplierPayment.class).in(SupplierPayment::getOrderId, orderIds));
         paymentAmount = paymentList.stream()
            .filter(a -> a.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()) && a.getPaymentAmount() != null)
            .map(SupplierPayment::getPaymentAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      }

      return paymentAmount;
   }

   private String getInvoiceVoucherNumber() {
      try {
         Object number = this.redisUtils.get("supplierPaymentNumber");
         if (ObjectUtils.isEmpty(number)) {
            this.projectSerialNumberUtils.redisSaveSerialNumber();
            number = this.redisUtils.get("supplierPaymentNumber");
         }

         String supplierPaymentNumber = this.projectSerialNumberUtils.dateUtil(number.toString());
         String voucherNumber = "F" + supplierPaymentNumber;
         this.redisUtils.incr("supplierPaymentNumber", 1L);
         return voucherNumber;
      } catch (Exception e) {
         throw new IllegalArgumentException("获取流水号失败");
      }
   }

   @Override
   public SaveInvoiceDto getProject(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      List<ContractInvoice> invoiceList = this.invoiceService
         .list(
            Wrappers.lambdaQuery(ContractInvoice.class)
               .eq(ContractInvoice::getProjectId, projectId)
               .eq(BaseEntity::getBoolDeleteEnum, 0)
               .eq(ContractInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      invoiceList.sort(Comparator.<ContractInvoice, java.time.LocalDateTime>comparing(BaseEntity::getCreateTime).reversed());
      SaveInvoiceDto saveInvoiceDto = new SaveInvoiceDto()
         .setUserId(UserUtil.getCurrentUserId())
         .setUserName(UserUtil.getCurrentName())
         .setProjectName(project.getSerialNumber() + "-" + project.getShortName())
         .setInvoiceUnit(this.branchCompanyService.getNameById(project.getContractSignBodyId()))
         .setProjectManagerId(project.getProjectManagerId())
         .setProjectManagerName(this.userService.getNameById(project.getProjectManagerId()))
         .setProjectAttribute(project.getProjectAttribute())
         .setCollectionUnit(!invoiceList.isEmpty() ? invoiceList.get(0).getCollectionUnit() : project.getCustomerUnit());
      if (!invoiceList.isEmpty()) {
         BigDecimal invoiceAmount = invoiceList.stream().map(ContractInvoice::getInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
         saveInvoiceDto.setCollectionAmountSum(invoiceAmount);
      }

      return saveInvoiceDto;
   }

   @Override
   public Map<Integer, String> acquisitionStatement(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(project), "项目不存在!");
      HashMap<Integer, String> map = new HashMap<>();
      List<ContractCollection> list = this.contractCollectionService.selectIncomeAndExpenses(projectId, null, null, null, null);
      List<ContractCollection> collectionList = new ArrayList<>(
         list.stream().collect(Collectors.toMap(ContractCollection::getPaymentUnit, Function.identity(), (existing, replacement) -> existing)).values()
      );
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .isNotNull(PurchaseOrder::getProjectIds)
               .eq(PurchaseOrder::getProjectAttribute, project.getProjectAttribute())
         )
         .stream()
         .filter(order -> Arrays.asList(order.getProjectIds().split(",")).contains(projectId.toString()))
         .collect(Collectors.toList());
      orderList = new ArrayList<>(
         orderList.stream().collect(Collectors.toMap(PurchaseOrder::getSerialNumber, Function.identity(), (existing, replacement) -> existing)).values()
      );
      if (!collectionList.isEmpty()) {
         for (int i = 0; i < collectionList.size(); i++) {
            map.put(i + 1, collectionList.get(i).getPaymentUnit());
         }
      }

      if (CollectionUtils.isNotEmpty(orderList)) {
         for (int i = 0; i < orderList.size(); i++) {
            map.put(map.size(), orderList.get(i).getSerialNumber());
         }
      }

      map.put(list.size() + 1, "保证金");
      map.put(list.size() + 2, "管理费");
      map.put(list.size() + 3, "资金利息");
      return map;
   }

   @Override
   public PrintVO downloadIncomeAndExpensesList(Long projectId, String remark, Integer collectionMode, LocalDate startDate, LocalDate endDate) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      List<ProjectIncomeAndExpenses> projectIncomeAndExpenses = this.getProjectIncomeAndExpenses(projectId, remark, collectionMode, startDate, endDate);
      header.put("startDate", startDate);
      header.put("endDate", endDate);
      header.put("userId", UserUtil.getCurrentUser().getId());
      header.put("userName", UserUtil.getCurrentUser().getName());
      header.put("phone", UserUtil.getCurrentUser().getPhone());
      printVO.setHeader(header);
      printVO.setTable(projectIncomeAndExpenses.stream().map(a -> BeanUtil.beanToMap(a)).collect(Collectors.toList()));
      return printVO;
   }
}
