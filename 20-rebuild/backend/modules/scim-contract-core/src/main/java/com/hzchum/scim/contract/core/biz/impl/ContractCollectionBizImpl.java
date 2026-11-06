package com.hzchum.scim.contract.core.biz.impl;

import cn.hutool.core.date.DatePattern;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.BranchCompanyLevelEnum;
import com.hzchum.scim.common.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.CostSummaryValueDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.DateTimeUtil;
import com.hzchum.scim.contract.core.api.biz.ContractCollectionBiz;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.AuditTypeEnum;
import com.hzchum.scim.contract.core.api.enums.CollectionTypeEnum;
import com.hzchum.scim.contract.core.api.enums.PayTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AmountOperationTypeEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.enums.finance.MoneyTypeEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCollection;
import com.hzchum.scim.contract.core.api.pojo._do.ContractInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractWaste;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCredit;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCreditDetail;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCreditReturn;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractManagementCost;
import com.hzchum.scim.contract.core.api.pojo._do.finance.SecurityDepositAndManagementCost;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionWarningDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ManufactureCostDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.SaveContractDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCheckDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCollectionQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCollectionSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ContractCollectionUpdateDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractInvoiceService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractWasteService;
import com.hzchum.scim.contract.core.api.service.ManufactureCostService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditDetailService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditReturnService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditService;
import com.hzchum.scim.contract.core.api.service.finance.ContractManagementCostService;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectAssetInjectionService;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectManagerMoneyInterestsService;
import com.hzchum.scim.contract.core.api.service.finance.SecurityDepositAndManagementCostService;
import com.hzchum.scim.contract.core.api.utils.ProjectFinanceUtils;
import com.hzchum.scim.scm.core.api.enums.PurchaseEnum;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.utils.ProjectSerialNumberUtils;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BankAccount;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinanceAmountLimitConfigDTO;
import com.hzchum.scim.system.core.api.service.BankAccountService;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractCollectionBizImpl implements ContractCollectionBiz {
   private static final Logger log = LoggerFactory.getLogger(ContractCollectionBizImpl.class);
   @Resource
   private ContractCollectionService collectionService;
   @Resource
   private ContractInvoiceService contractInvoiceService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private BankAccountService bankAccountService;
   @Resource
   private ConfigService configService;
   @Resource
   private UserService userService;
   @Resource
   private SecurityDepositAndManagementCostService securityDepositAndManagementCostService;
   @Resource
   private ContractManagementCostService managementCostService;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private ContractWasteService contractWasteService;
   @Resource
   private ContractProjectManagerMoneyInterestsService moneyInterestsService;
   @Resource
   private ContractGivingCreditService contractGivingCreditService;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private SupplierPaymentService paymentService;
   @Resource
   private ContractGivingCreditDetailService givingCreditDetailService;
   @Resource
   private ContractGivingCreditReturnService givingCreditReturnService;
   @Resource
   private ProjectSerialNumberUtils projectSerialNumberUtils;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ContractProjectAssetInjectionService contractProjectAssetInjectionService;
   @Resource
   private ContractAuditLedgerService contractAuditLedgerService;
   @Resource
   private WmsApproveRecordService approvalsService;
   @Resource
   private ProjectBranchCompanyLinkService projectBranchCompanyLinkService;
   @Resource
   private ManufactureCostService manufactureCostService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ProjectFinanceUtils projectFinanceUtils;

   @Override
   public PageVO<ContractCollectionDTO> pageList(ContractCollectionQueryDtoParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.collectionService.listCollection(param));
   }

   @Override
   public BigDecimal getSummaryCollection(ContractCollectionQueryDtoParam param) {
      List<ContractCollectionDTO> collectionList = this.collectionService.listCollection(param);
      return collectionList.stream().map(ContractCollectionDTO::getCollectionAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printList(ContractCollectionQueryDtoParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (CollectionTypeEnum.PROJECT_COLLECTION.getType().equals(param.getType())) {
         ProjectInfo project = this.projectService.getSimpleById(param.getProjectId());
         header.put("project", project);
      }

      if (CollectionTypeEnum.WASTE_COLLECTION.getType().equals(param.getType()) || CollectionTypeEnum.SCRAP_COLLECTION.getType().equals(param.getType())) {
         ContractWaste contractWaste = this.contractWasteService.getById(param.getContractWasteId());
         header.put("contractWaste", contractWaste);
         BranchCompany branchCompany = this.branchCompanyService.getById(param.getCollectionUnitId());
         header.put("branchCompany", branchCompany);
      }

      if (param.getStartDate() != null && param.getEndDate() != null) {
         header.put("statisticsDate", DateTimeUtil.localDateToString(param.getStartDate()) + "~" + DateTimeUtil.localDateToString(param.getEndDate()));
      }

      if (param.getStartDate() != null && param.getEndDate() != null) {
         header.put("statisticsDate", DateTimeUtil.localDateToString(param.getStartDate()) + "~" + DateTimeUtil.localDateToString(param.getEndDate()));
      }

      List<ContractCollectionDTO> collectionDTOList = this.collectionService.listCollection(param);
      BigDecimal totalAmount = collectionDTOList.stream().map(ContractCollectionDTO::getCollectionAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("totalAmount", totalAmount);
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = collectionDTOList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveList(Integer type, List<ContractCollectionSaveDTOParam> params) {
      Preconditions.checkArgument(CollectionTypeEnum.boolContain(type), "收款类型有误!");
      List<BranchCompany> branchCompanyList = this.branchCompanyService
         .listByIds(params.stream().map(ContractCollectionSaveDTOParam::getCollectionUnitId).collect(Collectors.toSet()));
      Map<Long, BranchCompany> branchCompanyMap = branchCompanyList.stream().collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      Map<String, String> valueLabelMap = this.dictionaryService.getValueLabelByName(DictionaryEnum.PAYMENT_REASON.getName());
      params.forEach(param -> {
         this.checkSave(type, param);
         ContractCollection collection = BeanUtil.copy(param, ContractCollection.class);
         collection.setType(type);
         BranchCompany branchCompany = branchCompanyMap.get(param.getCollectionUnitId());
         Preconditions.checkArgument(branchCompany != null, "收款单位不存在!");
         collection.setCollectionUnit(branchCompany.getName());
         Preconditions.checkArgument(valueLabelMap.containsKey(param.getCollectionReason()), "收款是由未配置!");
         this.checkBank(collection);
         if (param.getCollectionMode().equals(PayTypeEnum.ACCEPTANCE_DRAFT.getType()) && CollectionUtils.isNotEmpty(param.getAcceptanceDraftDTOList())) {
            collection.setAcceptanceDraftJson(JSON.toJSONString(param.getAcceptanceDraftDTOList()));
         }

         collection.setWrittenById(UserUtil.getCurrentUserId());
         collection.setWrittenByName(UserUtil.getCurrentName());
         collection.setAuditStatus(AuditStatusEnum.AUDITING.getType());
         this.collectionService.save(collection);
      });
      return Boolean.TRUE;
   }

   private void checkSave(Integer type, ContractCollectionSaveDTOParam param) {
      if (type.equals(CollectionTypeEnum.PROJECT_COLLECTION.getType())) {
         ContractProject project = this.projectService.getById(param.getProjectId());
         Preconditions.checkArgument(project != null, "项目不存在!");
         param.setContractWasteId(0L);
      } else {
         ContractWaste contractWaste = this.contractWasteService.getById(param.getContractWasteId());
         Preconditions.checkArgument(contractWaste != null, "废料合同不存在!");
         param.setProjectId(0L);
      }
   }

   private void checkBank(ContractCollection collection) {
      if (collection.getCollectionBankAccountId() != null) {
         BankAccount bankAccount = this.bankAccountService
            .getOne(
               Wrappers.lambdaQuery(BankAccount.builder().branchCompanyId(collection.getCollectionUnitId()).id(collection.getCollectionBankAccountId()).build())
            );
         Preconditions.checkArgument(bankAccount != null, "银行账号不存在!");
         collection.setCollectionDepositBank(bankAccount.getDepositBank());
         collection.setCollectionBankAccount(bankAccount.getAccount());
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean auditCollection(ContractCheckDtoParam param) {
      ContractCollection collection = this.collectionService.getById(param.getId());
      Preconditions.checkArgument(collection != null, "收款信息不存在");
      Preconditions.checkArgument(collection.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "收款信息已审核!");
      collection.setAuditStatus(param.getAuditStatus());
      collection.setAuditorId(UserUtil.getCurrentUserId());
      collection.setAuditorName(UserUtil.getCurrentName());
      collection.setAuditTime(LocalDateTime.now());
      this.collectionService.updateById(collection);
      if (collection.getType().equals(CollectionTypeEnum.PROJECT_COLLECTION.getType()) && param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())) {
         ContractProject project = this.projectService.getById(collection.getProjectId());
         BigDecimal collectionAmount = this.collectionService.getCollectionAmount(collection.getProjectId());
         project.setCollectionAmount(collectionAmount);
         this.projectService.updateById(project);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateCollection(ContractCollectionUpdateDTOParam param) {
      ContractCollection collection = this.collectionService.getById(param.getId());
      Preconditions.checkArgument(collection != null, "收款记录不存在!");
      Preconditions.checkArgument(collection.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "只有未审核状态,才可以重新编辑!");
      BeanUtil.copy(param, collection);
      this.checkBank(collection);
      SysDictionary dictionary = this.dictionaryService.getByNameAndValue(DictionaryEnum.PAYMENT_REASON.getName(), param.getCollectionReason());
      Preconditions.checkArgument(dictionary != null, "收款是由未配置!");
      if (param.getCollectionMode().equals(PayTypeEnum.ACCEPTANCE_DRAFT.getType()) && CollectionUtils.isNotEmpty(param.getAcceptanceDraftDTOList())) {
         collection.setAcceptanceDraftJson(JSON.toJSONString(param.getAcceptanceDraftDTOList()));
      }

      collection.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      collection.setLastEditorUserId(UserUtil.getCurrentUserId());
      this.collectionService.updateById(collection);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteCollection(Long id) {
      ContractCollection collection = this.collectionService.getById(id);
      Preconditions.checkArgument(collection != null, "收款信息不存在!");
      Preconditions.checkArgument(collection.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "收款信息已审核,不能删除!");
      this.collectionService.removeById(id);
      return true;
   }

   @Override
   public PageVO<ContractCollectionWarningDTO> listCollectionWarning(Integer year, Long projectId, Boolean boolArrears, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.collectionService.listCollectionWarning(year, projectId, boolArrears));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printCollectionWarnings(Integer year, Long projectId, Boolean boolArrears) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (year != null) {
         header.put("year", year);
      }

      if (projectId != null) {
         ProjectInfo project = this.projectService.getSimpleById(projectId);
         header.put("project", project);
      }

      printVO.setHeader(header);
      printVO.setTable(
         this.collectionService.listCollectionWarning(year, projectId, boolArrears).stream().map(BeanUtil::beanToMap).collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public SaveContractDto getProject(Long projectId, Integer level) {
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      if (boolTwoLevelUnit) {
         Preconditions.checkArgument(level != null, "单位等级未知!");
      } else {
         level = BranchCompanyLevelEnum.SECONDARY_UNIT.getType();
      }

      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(project), "项目不存在!");
      ProjectBranchCompanyLink branchCompanyLink = this.projectBranchCompanyLinkService
         .getOne(
            Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
               .eq(ProjectBranchCompanyLink::getProjectId, projectId)
               .eq(ProjectBranchCompanyLink::getBranchCompanyLevel, level)
         );
      Preconditions.checkArgument(branchCompanyLink != null, "收款单位有误!");
      BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyLink.getBranchCompanyId());
      Preconditions.checkArgument(branchCompany != null, "收款单位不存在!");
      List<BankAccount> bankAccountList = this.bankAccountService
         .list(Wrappers.lambdaQuery(BankAccount.builder().branchCompanyId(branchCompany.getId()).build()));
      List<ContractCollection> list = this.collectionService
         .list(
            Wrappers.lambdaQuery(ContractCollection.class)
               .eq(ContractCollection::getProjectId, projectId)
               .eq(ContractCollection::getCollectionUnitId, branchCompany.getId())
               .eq(ContractCollection::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .orderByDesc(ContractCollection::getId)
         );
      SaveContractDto saveContractDto = new SaveContractDto()
         .setProjectName(project.getSerialNumber() + project.getShortName())
         .setCollectionUnitId(branchCompany.getId())
         .setCollectionUnit(branchCompany.getName())
         .setProjectAttribute(project.getProjectAttribute())
         .setUserId(UserUtil.getCurrentUserId())
         .setUserName(UserUtil.getCurrentName())
         .setPaymentUnit(
            project.getContractSignBodyId().equals(branchCompany.getId())
               ? project.getCustomerUnit()
               : this.branchCompanyService.getNameById(project.getContractSignBodyId())
         )
         .setCollectionAmountSum(list.stream().map(ContractCollection::getCollectionAmount).reduce(BigDecimal.ZERO, BigDecimal::add))
         .setCollectionDepositBankList(bankAccountList.stream().map(BankAccount::getDepositBank).collect(Collectors.toList()));
      if (!list.isEmpty()) {
         saveContractDto.setPaymentDepositBank(list.get(0).getPaymentDepositBank());
         saveContractDto.setCollectionDepositBank(list.get(0).getCollectionDepositBank());
      }

      if (project.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
         saveContractDto.setProjectManagerId(project.getProjectManagerId());
         saveContractDto.setProjectManagerName(this.userService.getNameById(project.getProjectManagerId()));
      }

      return saveContractDto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveCollection(ContractCollectionSaveDTOParam param) {
      Preconditions.checkArgument(param.getCollectionAmount().compareTo(BigDecimal.ZERO) != 0, "收款金额不能为0!");
      Preconditions.checkArgument(param.getCollectionDate().isBefore(LocalDate.now().plusDays(1L)), "收款日期不能大于今天!");
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "收款项目不存在!");
      BranchCompany branchCompany = this.branchCompanyService.getById(param.getCollectionUnitId());
      Preconditions.checkArgument(branchCompany != null, "收款单位不存在!");
      ProjectBranchCompanyLink link = this.projectBranchCompanyLinkService
         .getOne(
            Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
               .eq(ProjectBranchCompanyLink::getProjectId, param.getProjectId())
               .eq(ProjectBranchCompanyLink::getBranchCompanyId, param.getCollectionUnitId())
         );
      Preconditions.checkArgument(link != null, "收款单位有误!");
      BigDecimal collectionAmount = this.collectionService
         .list(
            Wrappers.lambdaQuery(ContractCollection.class)
               .eq(ContractCollection::getProjectId, param.getProjectId())
               .eq(ContractCollection::getCollectionUnitId, param.getCollectionUnitId())
               .in(ContractCollection::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .map(ContractCollection::getCollectionAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
      if (project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())) {
         if (!financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
            List<ContractAuditLedger> auditLedgerList = this.contractAuditLedgerService
               .list(
                  Wrappers.lambdaQuery(ContractAuditLedger.class)
                     .eq(ContractAuditLedger::getPaymentEnum, AuditPaymentEnum.PROJECT_SETTLEMENT.getType())
                     .eq(ContractAuditLedger::getProjectId, String.valueOf(param.getProjectId()))
                     .eq(ContractAuditLedger::getAuditStatusEnum, AuditStatusEnum.AUDITING.getType())
               );
            Preconditions.checkArgument(auditLedgerList.isEmpty(), "项目结算正在审批中,提交失败!");
         }

         if (!financeAmountLimitConfig.getBoolAllowOverContractAmount()) {
            Preconditions.checkArgument(collectionAmount.add(param.getCollectionAmount()).compareTo(project.getContractAmount()) <= 0, "收款金额总和(含未审批)不能大于项目合同额!");
         }
      }

      if (project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) && !financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
         Preconditions.checkArgument(collectionAmount.add(param.getCollectionAmount()).compareTo(project.getSettlementAmount()) <= 0, "收款金额总和(含未审批)不能大于项目结算额!");
      }

      String userName = UserUtil.getCurrentName();
      if (param.getWrittenById() != null) {
         User user = this.userService.getById(param.getWrittenById());
         Preconditions.checkArgument(user != null, "填报人不存在!");
         userName = user.getName();
      }

      ContractCollection collection = BeanUtil.copy(param, ContractCollection.class);
      collection.setCollectionUnitId(branchCompany.getId());
      collection.setCollectionUnit(branchCompany.getName());
      collection.setProjectAttribute(project.getProjectAttribute());
      collection.setProjectManagerId(project.getProjectManagerId());
      if (param.getCollectionMode().equals(PayTypeEnum.ACCEPTANCE_DRAFT.getType()) && CollectionUtils.isNotEmpty(param.getAcceptanceDraftDTOList())) {
         collection.setAcceptanceDraftJson(JSON.toJSONString(param.getAcceptanceDraftDTOList()));
      }

      collection.setWrittenById(param.getWrittenById() != null ? param.getWrittenById() : UserUtil.getCurrentUserId());
      collection.setWrittenByName(userName);
      collection.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      Set<Long> attachmentIdSet = new HashSet<>(16);
      if (CollectionUtils.isNotEmpty(param.getAccessoryId())) {
         attachmentIdSet.addAll(param.getAccessoryId());
      }

      if (CollectionUtils.isNotEmpty(param.getAttachmentId())) {
         attachmentIdSet.addAll(param.getAttachmentId());
      }

      String attachmentIds = attachmentIdSet.isEmpty() ? null : StringUtils.join(attachmentIdSet, ",");
      collection.setAccessoryId(attachmentIds);
      collection.setAttachmentIds(attachmentIds);
      collection.setCollectionReason(String.valueOf(param.getCollectionMode()));
      String voucherNumber = this.getCollectionVoucherNumber("S");
      collection.setVoucherNumber(voucherNumber);
      this.collectionService.save(collection);
      ContractAuditLedger auditLedger = ContractAuditLedger.builder()
         .projectAttribute(project.getProjectAttribute())
         .paymentEnum(AuditPaymentEnum.PROJECT_COLLECTION.getType())
         .projectId(String.valueOf(param.getProjectId()))
         .contractNumber(project.getSerialNumber())
         .contractSignBodyId(project.getContractSignBodyId())
         .auditStatusEnum(AuditStatusEnum.AUDITING.getType())
         .auditType(AuditTypeEnum.CONTRACT_APPROVE.getType())
         .projectManagerId(project.getSignerId())
         .paymentId(String.valueOf(collection.getId()))
         .filingDate(param.getCollectionDate().atStartOfDay())
         .initiatorId(param.getWrittenById() != null ? param.getWrittenById() : UserUtil.getCurrentUserId())
         .applyAmount(param.getCollectionAmount())
         .build();
      this.contractAuditLedgerService.save(auditLedger);
      WmsApproveRecord record = this.approvalsService
         .createRecord(
            auditLedger.getId(),
            auditLedger.getContractNumber(),
            ApproveProcessTypeEnumV2.CONTRACT_COLLECTION_AUDIT.getType(),
            null,
            null,
            null,
            false,
            null,
            null,
            null
         );
      auditLedger.setApproveRecordId(record.getId());
      if (record.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType())) {
         collection.setAuditStatus(AuditStatusEnum.SUCCEED.getType());
         collection.setAuditTime(LocalDateTime.now());
         collection.setAuditorId(collection.getWrittenById());
         collection.setAuditorName(userName);
         this.collectionService.updateById(collection);
         if (collection.getCollectionUnitId().equals(project.getContractSignBodyId())) {
            project.setCollectionAmount(project.getCollectionAmount().add(collection.getCollectionAmount()));
         }

         auditLedger.setWrittenById(UserUtil.getCurrentUserId());
         auditLedger.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
         auditLedger.setSubmitDate(LocalDateTime.now());
         auditLedger.setApprovalTime(LocalDateTime.now());
         auditLedger.setActuallyPayAmount(param.getCollectionAmount());
      }

      if (project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())
         || project.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
         this.saveCollectionDeduct(project, collection);
         if (project.getProjectManagerCollectBalance().compareTo(BigDecimal.ZERO) > 0) {
            this.saveReturnGivingCredit(project, collection);
         }
      }

      this.projectService.updateById(project);
      this.contractAuditLedgerService.updateById(auditLedger);
      return Boolean.TRUE;
   }

   private String getCollectionVoucherNumber(String markLetter) {
      try {
         Object number = this.redisUtils.get("supplierPaymentNumber");
         if (ObjectUtils.isEmpty(number)) {
            this.projectSerialNumberUtils.redisSaveSerialNumber();
            number = this.redisUtils.get("supplierPaymentNumber");
         }

         String supplierPaymentNumber = this.projectSerialNumberUtils.dateUtil(number.toString());
         String voucherNumber = markLetter + supplierPaymentNumber;
         this.redisUtils.incr("supplierPaymentNumber", 1L);
         return voucherNumber;
      } catch (Exception e) {
         throw new RuntimeException("获取流水号失败");
      }
   }

   private void saveCollectionDeduct(ContractProject project, ContractCollection collection) {
      if (collection.getCollectionAmount().compareTo(BigDecimal.ZERO) < 0) {
         BigDecimal contractSignBodyReturnAmount = collection.getCollectionAmount()
            .multiply(project.getContractSignBodyScale())
            .divide(BigDecimal.valueOf(100L), 4, RoundingMode.HALF_UP);
         BigDecimal projectManagerReturnAmount = collection.getCollectionAmount()
            .multiply(project.getProjectManagerScale())
            .divide(BigDecimal.valueOf(100L), 4, RoundingMode.HALF_UP);
         Preconditions.checkArgument(
            project.getContractSignBodyCollectBalance().add(contractSignBodyReturnAmount).compareTo(BigDecimal.ZERO) >= 0, "合同主体收款余额不足，不能进行负收款!"
         );
         Preconditions.checkArgument(
            project.getProjectManagerCollectBalance().add(projectManagerReturnAmount).compareTo(BigDecimal.ZERO) >= 0, "项目经理收款余额不足，不能进行负收款!"
         );
      }

      BigDecimal companyCollectionAmount = collection.getCollectionAmount()
         .multiply(project.getContractSignBodyScale())
         .divide(BigDecimal.valueOf(100L), 4, RoundingMode.HALF_UP);
      project.setContractSignBodyCollectBalance(project.getContractSignBodyCollectBalance().add(companyCollectionAmount));
      project.setContractSignBodyAmount(project.getContractSignBodyAmount().add(companyCollectionAmount));
      BigDecimal projectManagerCollectionAmount = collection.getCollectionAmount()
         .multiply(project.getProjectManagerScale())
         .divide(BigDecimal.valueOf(100L), 4, RoundingMode.HALF_UP);
      BigDecimal managementFee = projectManagerCollectionAmount.multiply(project.getManagementFeeRate())
         .divide(BigDecimal.valueOf(100L), 4, RoundingMode.HALF_UP);
      List<ContractManagementCost> managementCostList = this.managementCostService
         .list(
            Wrappers.lambdaQuery(ContractManagementCost.class)
               .eq(ContractManagementCost::getProjectId, collection.getProjectId())
               .lt(ContractManagementCost::getStartTime, LocalDate.now().plusDays(1L).atStartOfDay())
               .orderByDesc(ContractManagementCost::getStartTime)
               .orderByDesc(ContractManagementCost::getId)
         );
      if (CollectionUtils.isNotEmpty(managementCostList)) {
         managementFee = projectManagerCollectionAmount.multiply(managementCostList.get(0).getCashDeposit())
            .divide(BigDecimal.valueOf(100L), 4, RoundingMode.HALF_UP);
      }

      this.saveManagementFeeEarnestMoney(project, collection, MoneyTypeEnum.MANAGEMENT_COST.getType(), managementFee);
      BigDecimal earnestMoney = BigDecimal.ZERO;
      if (project.getMarginAmount().compareTo(project.getCollectionMarginAmount()) > 0) {
         BigDecimal projectManagerEarnestMoney = project.getMarginAmount()
            .multiply(project.getProjectManagerScale())
            .divide(BigDecimal.valueOf(100L), 4, RoundingMode.HALF_UP);
         BigDecimal actualEarnestMoney = projectManagerEarnestMoney.subtract(project.getCollectionMarginAmount());
         if (project.getProjectManagerCollectBalance().add(projectManagerCollectionAmount).subtract(managementFee).compareTo(actualEarnestMoney) >= 0) {
            earnestMoney = actualEarnestMoney;
            this.saveManagementFeeEarnestMoney(project, collection, MoneyTypeEnum.SECURITY_DEPOSIT.getType(), actualEarnestMoney);
            project.setCollectionMarginAmount(project.getCollectionMarginAmount().add(actualEarnestMoney));
         }
      }

      BigDecimal projectManagerActualCollectionAmount = projectManagerCollectionAmount.subtract(managementFee).subtract(earnestMoney);
      project.setProjectManagerCollectBalance(project.getProjectManagerCollectBalance().add(projectManagerActualCollectionAmount));
      project.setProjectManagerAmount(project.getProjectManagerAmount().add(projectManagerActualCollectionAmount));
      project.setCollectionSummary(project.getCollectionSummary().add(companyCollectionAmount).add(projectManagerActualCollectionAmount));
   }

   private void saveManagementFeeEarnestMoney(ContractProject project, ContractCollection collection, Integer amountType, BigDecimal amount) {
      String markLetter = amountType.equals(MoneyTypeEnum.SECURITY_DEPOSIT.getType()) ? "B" : "G";
      String managementVoucherNumber = this.getCollectionVoucherNumber(markLetter);
      SecurityDepositAndManagementCost managementCost = SecurityDepositAndManagementCost.builder()
         .projectId(project.getId())
         .dateTime(LocalDateTime.now())
         .userId(collection.getWrittenById())
         .income(collection.getCollectionAmount())
         .voucherNumber(managementVoucherNumber)
         .amountType(amountType)
         .amountOperationTypeEnum(AmountOperationTypeEnum.DEDUCT.getType())
         .collectionId(collection.getId())
         .amount(amount)
         .managementDeductIncome(amountType.equals(MoneyTypeEnum.MANAGEMENT_COST.getType()) ? amount : null)
         .managementFeeRate(amountType.equals(MoneyTypeEnum.MANAGEMENT_COST.getType()) ? project.getManagementFeeRate() : null)
         .securityDeductIncome(amountType.equals(MoneyTypeEnum.SECURITY_DEPOSIT.getType()) ? amount : null)
         .rate(amountType.equals(MoneyTypeEnum.MANAGEMENT_COST.getType()) ? project.getManagementFeeRate().toString() : null)
         .remark("收款时,扣除" + MoneyTypeEnum.getByName(amountType))
         .auditStatus(collection.getAuditStatus())
         .build();
      this.securityDepositAndManagementCostService.save(managementCost);
   }

   private void saveReturnGivingCredit(ContractProject project, ContractCollection collection) {
      List<ContractGivingCreditDetail> givingCreditDetailList = this.givingCreditDetailService
         .list(Wrappers.lambdaQuery(ContractGivingCreditDetail.class).eq(ContractGivingCreditDetail::getProjectId, project.getId()))
         .stream()
         .filter(s -> s.getUseAmount().compareTo(s.getReturnPrincipalAmount()) > 0)
         .collect(Collectors.toList());
      if (!givingCreditDetailList.isEmpty()) {
         List<ContractGivingCredit> givingCreditList = this.contractGivingCreditService
            .listByIds(givingCreditDetailList.stream().map(ContractGivingCreditDetail::getCreditId).collect(Collectors.toSet()));
         Map<Long, ContractGivingCredit> givingCreditMap = givingCreditList.stream()
            .collect(Collectors.toMap(ContractGivingCredit::getId, Function.identity()));
         givingCreditDetailList.forEach(
            givingCreditDetail -> {
               if (project.getProjectManagerCollectBalance().compareTo(BigDecimal.ZERO) > 0) {
                  BigDecimal unReturnPrincipal = givingCreditDetail.getUseAmount().subtract(givingCreditDetail.getReturnPrincipalAmount());
                  BigDecimal principalAmount = project.getProjectManagerCollectBalance().compareTo(unReturnPrincipal) >= 0
                     ? unReturnPrincipal
                     : project.getProjectManagerCollectBalance();
                  ContractGivingCreditReturn newReturn = ContractGivingCreditReturn.builder()
                     .givingCreditDetailId(givingCreditDetail.getId())
                     .collectionId(collection.getId())
                     .projectId(project.getId())
                     .projectAttribute(project.getProjectAttribute())
                     .projectManagerId(project.getProjectManagerId())
                     .returnTime(collection.getCollectionDate().atStartOfDay())
                     .principalAmount(principalAmount)
                     .interestAmount(BigDecimal.ZERO)
                     .amount(principalAmount)
                     .auditStatus(collection.getAuditStatus())
                     .build();
                  this.givingCreditReturnService.save(newReturn);
                  givingCreditDetail.setReturnPrincipalAmount(givingCreditDetail.getReturnInterestAmount().add(newReturn.getPrincipalAmount()));
                  this.givingCreditDetailService.updateById(givingCreditDetail);
                  ContractGivingCredit givingCredit = givingCreditMap.get(givingCreditDetail.getCreditId());
                  givingCredit.setUsedCredit(givingCredit.getUsedCredit().subtract(newReturn.getPrincipalAmount()));
                  givingCredit.setRemainingSum(givingCredit.getRemainingSum().add(newReturn.getPrincipalAmount()));
                  project.setProjectManagerCollectBalance(project.getProjectManagerCollectBalance().subtract(newReturn.getAmount()));
               }
            }
         );
         this.contractGivingCreditService.updateBatchById(givingCreditList);
      }
   }

   private Map<Integer, BigDecimal> getResiduePrincipalInterestAmount(
      ContractGivingCreditDetail givingCreditDetail, List<ContractGivingCreditReturn> returnList
   ) {
      LocalDateTime startDate = givingCreditDetail.getUseDate();

      for (ContractGivingCreditReturn r : returnList) {
         int intDays = Math.toIntExact(Duration.between(startDate.toLocalDate(), r.getReturnTime().toLocalDate()).toDays());
         startDate = r.getReturnTime();
      }

      Map<Integer, BigDecimal> map = new HashMap<>();
      map.put(1, BigDecimal.ZERO);
      map.put(2, BigDecimal.ZERO);
      return map;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> downloadCollectionLedger(Long projectId, Integer level) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
      Preconditions.checkArgument(branchCompany != null, "项目签定主体不存在!");
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      if (boolTwoLevelUnit && project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         Preconditions.checkArgument(level != null, "单位等级未知!");
      } else {
         level = null;
      }

      Long collectionId = this.getCollectionId(projectId, level);
      List<ContractCollection> contractCollections = this.collectionService.listCollectionLedger(projectId, collectionId);
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
      BigDecimal accumulatedCollection = contractCollections.stream().map(ContractCollection::getCollectionAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("accumulatedCollection", accumulatedCollection);
      BigDecimal accumulatedInvoice = this.contractInvoiceService
         .listPageLedger(projectId, collectionId)
         .stream()
         .map(ContractInvoice::getActualInvoiceAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("accumulatedInvoice", accumulatedInvoice);
      if (project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         if (BranchCompanyLevelEnum.PRIMARY_UNIT.getType().equals(level)) {
            Map<Long, BigDecimal> projectFirstLevelUnitCostMap = this.projectFinanceUtils.getProjectFirstLevelUnitCost(Collections.singletonList(projectId));
            header.put("accumulatedCost", projectFirstLevelUnitCostMap.get(projectId).setScale(2, RoundingMode.HALF_UP));
            header.put("availableBalance", accumulatedCollection.subtract(projectFirstLevelUnitCostMap.get(projectId)).setScale(2, RoundingMode.HALF_UP));
         } else {
            List<ManufactureCostDTO> manufactureCostDTOList = this.manufactureCostService.manufactureCostList(null, projectId, null, true);
            header.put("accumulatedCost", manufactureCostDTOList.get(0).getCumulativeCost().setScale(2, RoundingMode.HALF_UP));
            header.put("availableBalance", accumulatedCollection.subtract(manufactureCostDTOList.get(0).getCumulativeCost()).setScale(2, RoundingMode.HALF_UP));
         }

      }

      if (level != null && !branchCompany.getLevel().equals(level)) {
         header.put("contractAmount", "/");
         header.put("settlementAmount", "/");
         header.put("advancesReceived", "/");
         header.put("collectionRatio", "/");
         header.put("invoiceRatio", "/");
      } else {
         header.put("contractAmount", project.getContractAmount());
         header.put("settlementAmount", project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) ? project.getSettlementAmount() : "/");
         BigDecimal collectionRatio = project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
            ? accumulatedCollection.multiply(BigDecimal.valueOf(100L)).divide(project.getSettlementAmount(), 2, RoundingMode.HALF_UP)
            : accumulatedCollection.multiply(BigDecimal.valueOf(100L)).divide(project.getContractAmount(), 2, RoundingMode.HALF_UP);
         BigDecimal invoiceRatio = project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
            ? accumulatedInvoice.multiply(BigDecimal.valueOf(100L)).divide(project.getSettlementAmount(), 2, RoundingMode.HALF_UP)
            : accumulatedInvoice.multiply(BigDecimal.valueOf(100L)).divide(project.getContractAmount(), 2, RoundingMode.HALF_UP);
         header.put("collectionRatio", collectionRatio + "%");
         header.put("invoiceRatio", invoiceRatio + "%");
         BigDecimal advancesReceived = project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())
            ? project.getContractAmount().subtract(accumulatedCollection)
            : project.getSettlementAmount().subtract(accumulatedCollection);
         header.put("advancesReceived", advancesReceived.compareTo(BigDecimal.ZERO) >= 0 ? advancesReceived : BigDecimal.ZERO);
      }

      printVO.setHeader(header);
      printVO.setTable(contractCollections.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PageVO<ContractCollectionV2DTO> listCollectionLedger(Long projectId, Integer level, Integer pageNumber, Integer pageSize) {
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      if (boolTwoLevelUnit && project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         Preconditions.checkArgument(level != null, "单位等级未知!");
      } else {
         level = null;
      }

      Long collectionId = this.getCollectionId(projectId, level);
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<ContractCollection> contractCollections = this.collectionService.listCollectionLedger(projectId, collectionId);
      List<ContractCollectionV2DTO> collectionV2DTOList = contractCollections.stream().map(c -> {
         ContractCollectionV2DTO collectionV2DTO = BeanUtil.copy(c, ContractCollectionV2DTO.class);
         String attachmentIds = StringUtils.isNotBlank(c.getAttachmentIds()) ? c.getAttachmentIds() : c.getAccessoryId();
         collectionV2DTO.setAttachments(this.attachmentService.listByIds(attachmentIds));
         return collectionV2DTO;
      }).collect(Collectors.toList());
      return new PageVO<>(page, collectionV2DTOList);
   }

   @Override
   public List<CostSummaryValueDTO> getProjectDisburse(Long projectId, List<LocalDate> yearMonthDateList) {
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .eq(PurchaseOrder::getProjectIds, String.valueOf(projectId))
               .eq(PurchaseOrder::getPurchaseType, PurchaseEnum.FINISHED_GOODS.getType())
               .eq(PurchaseOrder::getLevel, BranchCompanyLevelEnum.SECONDARY_UNIT.getType())
         );
      Map<LocalDate, BigDecimal> localDatePaymentAmountMap = new HashMap<>(16);
      if (CollectionUtils.isNotEmpty(orderList)) {
         List<SupplierPayment> paymentList = this.paymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .in(SupplierPayment::getOrderId, orderList.stream().map(PurchaseOrder::getId).collect(Collectors.toList()))
                  .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            );
         Map<LocalDate, BigDecimal> collect = paymentList.stream()
            .collect(
               Collectors.groupingBy(
                  sp -> sp.getPaymentDate().withDayOfMonth(1), Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add)
               )
            );
         localDatePaymentAmountMap.putAll(collect);
      }

      List<CostSummaryValueDTO> resultList = new ArrayList<>(16);
      yearMonthDateList.forEach(
         yearMonthDate -> {
            CostSummaryValueDTO result = CostSummaryValueDTO.builder()
               .yearMonth(yearMonthDate.format(DatePattern.NORM_MONTH_FORMATTER))
               .costMonthTotal(localDatePaymentAmountMap.getOrDefault(yearMonthDate, BigDecimal.ZERO))
               .build();
            resultList.add(result);
         }
      );
      return resultList;
   }

   private Long getCollectionId(Long projectId, Integer level) {
      Long collectionId = null;
      if (level != null) {
         Preconditions.checkArgument(StringUtils.isNotBlank(BranchCompanyLevelEnum.getNameByType(level)), "项目单位等级有误!");
         List<ProjectBranchCompanyLink> projectBranchCompanyLinkList = this.projectBranchCompanyLinkService
            .list(Wrappers.lambdaQuery(ProjectBranchCompanyLink.builder().projectId(projectId).branchCompanyLevel(level).build()));
         Preconditions.checkArgument(!projectBranchCompanyLinkList.isEmpty(), "该项目未关联该等级单位!");
         collectionId = projectBranchCompanyLinkList.get(0).getBranchCompanyId();
      }

      return collectionId;
   }
}
