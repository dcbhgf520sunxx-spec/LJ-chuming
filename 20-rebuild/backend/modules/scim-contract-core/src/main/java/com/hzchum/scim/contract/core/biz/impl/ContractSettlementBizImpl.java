package com.hzchum.scim.contract.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.BranchCompanyLevelEnum;
import com.hzchum.scim.common.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.biz.ContractSettlementBiz;
import com.hzchum.scim.contract.core.api.enums.AuditTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCollection;
import com.hzchum.scim.contract.core.api.pojo._do.ContractInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractSettlement;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractSettlementDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ManufactureCostDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ProjectSettlementSaveParam;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractInvoiceService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractSettlementService;
import com.hzchum.scim.contract.core.api.service.ManufactureCostService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.contract.core.api.utils.ProjectFinanceUtils;
import com.hzchum.scim.contract.core.mapper.ContractSettlementMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractSettlementBizImpl
   extends IBizImpl<ContractSettlementService, ContractSettlementMapper, ContractSettlement>
   implements ContractSettlementBiz {
   private final AttachmentService attachmentService;
   private final ContractProjectService projectService;
   private final ProjectBranchCompanyLinkService projectBranchCompanyLinkService;
   private final BranchCompanyService branchCompanyService;
   private final ContractCollectionService contractCollectionService;
   private final ContractInvoiceService contractInvoiceService;
   private final ManufactureCostService manufactureCostService;
   private final ContractAuditLedgerService auditLedgerService;
   private final WmsApproveRecordService approveRecordService;
   private final ProjectFinanceUtils projectFinanceUtils;
   private final UserService userService;

   @Override
   public List<ContractSettlementDTO> listProjectSettlement(Long projectId, Integer level, Long branchCompanyId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      if (branchCompanyId != null) {
         if (!project.getContractSignBodyId().equals(branchCompanyId)) {
            return Collections.emptyList();
         }
      } else if (boolTwoLevelUnit) {
         Preconditions.checkArgument(level != null, "单位等级不能为空!");
         BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
         Preconditions.checkArgument(branchCompany != null, "项目签订主体不存在!");
         if (!branchCompany.getLevel().equals(level)) {
            return Collections.emptyList();
         }
      }

      List<ContractSettlement> projectSettlementList = this.baseService
         .list(
            Wrappers.lambdaQuery(ContractSettlement.class)
               .eq(ContractSettlement::getProjectId, projectId)
               .eq(ContractSettlement::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .orderByAsc(ContractSettlement::getId)
         );
      return projectSettlementList.stream().map(s -> {
         ContractSettlementDTO dto = BeanUtil.copy(s, ContractSettlementDTO.class);
         dto.setAttachmentList(this.attachmentService.listByIds(s.getAttachmentIds()));
         return dto;
      }).collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<ContractSettlementDTO>> printListProjectSettlement(Long projectId, Integer level, Long branchCompanyId) {
      PrintVO<List<ContractSettlementDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
      Preconditions.checkArgument(branchCompany != null, "项目主体不存在!");
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      if (branchCompanyId != null) {
         Preconditions.checkArgument(project.getContractSignBodyId().equals(branchCompanyId), "项目不能在当前单位下进行该操作!!");
         level = branchCompany.getLevel();
      } else if (boolTwoLevelUnit) {
         Preconditions.checkArgument(branchCompany.getLevel().equals(level), "项目不能在当前单位下进行该操作!!");
      } else {
         level = branchCompany.getLevel();
      }

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
      BigDecimal accumulatedCollection = this.contractCollectionService
         .listCollectionLedger(projectId, project.getContractSignBodyId())
         .stream()
         .map(ContractCollection::getCollectionAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("accumulatedCollection", accumulatedCollection);
      BigDecimal accumulatedInvoice = this.contractInvoiceService
         .listPageLedger(projectId, project.getContractSignBodyId())
         .stream()
         .map(ContractInvoice::getActualInvoiceAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("accumulatedInvoice", accumulatedInvoice);
      if (BranchCompanyLevelEnum.PRIMARY_UNIT.getType().equals(level)) {
         Map<Long, BigDecimal> projectFirstLevelUnitCostMap = this.projectFinanceUtils.getProjectFirstLevelUnitCost(Collections.singletonList(projectId));
         header.put("accumulatedCost", projectFirstLevelUnitCostMap.get(projectId).setScale(2, RoundingMode.HALF_UP));
         header.put("availableBalance", accumulatedCollection.subtract(projectFirstLevelUnitCostMap.get(projectId)).setScale(2, RoundingMode.HALF_UP));
      } else {
         List<ManufactureCostDTO> manufactureCostDTOList = this.manufactureCostService.manufactureCostList(null, projectId, null, true);
         header.put("accumulatedCost", manufactureCostDTOList.get(0).getCumulativeCost().setScale(2, RoundingMode.HALF_UP));
         header.put("availableBalance", accumulatedCollection.subtract(manufactureCostDTOList.get(0).getCumulativeCost()).setScale(2, RoundingMode.HALF_UP));
      }

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
      printVO.setHeader(header);
      printVO.setTable(this.listProjectSettlement(projectId, level, branchCompanyId));
      return printVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean savePreSettlement(ProjectSettlementSaveParam param) {
      Preconditions.checkArgument(param.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0, "项目结算额不能为0!");
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在!");
      Preconditions.checkArgument(project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()), "项目已结算!!");
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      if (param.getBranchCompanyId() != null) {
         Preconditions.checkArgument(project.getContractSignBodyId().equals(param.getBranchCompanyId()), "该项目不能在本单位下办理预结算!!请刷新重试!!");
      } else if (boolTwoLevelUnit) {
         Preconditions.checkArgument(param.getLevel() != null, "单位等级未知!");
         BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
         Preconditions.checkArgument(branchCompany != null, "项目签订主体不存在!");
         Preconditions.checkArgument(branchCompany.getLevel().equals(param.getLevel()), "该项目不能在当前单位下办理预结算!!");
      }

      List<ContractAuditLedger> auditLedgerList = this.auditLedgerService
         .list(
            Wrappers.lambdaQuery(ContractAuditLedger.class)
               .isNotNull(ContractAuditLedger::getProjectId)
               .eq(ContractAuditLedger::getPaymentEnum, AuditPaymentEnum.PROJECT_SETTLEMENT.getType())
               .eq(ContractAuditLedger::getProjectId, param.getProjectId())
               .eq(ContractAuditLedger::getAuditStatusEnum, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(auditLedgerList.isEmpty(), "项目结算正在审批中!!");
      String attachmentIds = CollectionUtils.isNotEmpty(param.getAttachmentId()) ? StringUtils.join(param.getAttachmentId(), ",") : null;
      ContractSettlement preSettlement = ContractSettlement.builder()
         .projectId(param.getProjectId())
         .amount(param.getSettlementAmount())
         .settlementDate(param.getSettlementTime().toLocalDate())
         .createUserId(UserUtil.getCurrentUserId())
         .createUserName(UserUtil.getCurrentName())
         .auditStatus(AuditStatusEnum.AUDITING.getType())
         .attachmentIds(attachmentIds)
         .remark(param.getRemark())
         .build();
      boolean save = this.baseService.save(preSettlement);
      Long projectManagerId;
      if (project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         projectManagerId = project.getSignerId() != null ? project.getSignerId() : project.getSalesLeaderId();
      } else {
         projectManagerId = project.getProjectManagerId();
      }

      ContractAuditLedger build = ContractAuditLedger.builder()
         .contractId(project.getId().toString())
         .auditType(AuditTypeEnum.CONTRACT_APPROVE.getType())
         .paymentEnum(AuditPaymentEnum.PROJECT_PRE_SETTLEMENT.getType())
         .projectAttribute(project.getProjectAttribute())
         .paymentId(preSettlement.getId().toString())
         .projectId(String.valueOf(param.getProjectId()))
         .contractSignBodyId(project.getContractSignBodyId())
         .projectManagerId(projectManagerId)
         .initiatorId(UserUtil.getCurrentUserId())
         .contractNumber(project.getSerialNumber())
         .filingDate(param.getSettlementTime())
         .applyAmount(param.getSettlementAmount())
         .auditStatusEnum(AuditStatusEnum.AUDITING.getType())
         .submitDate(LocalDateTime.now())
         .attachmentIds(attachmentIds)
         .build();
      this.auditLedgerService.save(build);
      WmsApproveRecord record = this.approveRecordService
         .createRecord(
            build.getId(),
            project.getSerialNumber(),
            ApproveProcessTypeEnumV2.CONTRACT_PRE_SETTLEMENT_AUDIT.getType(),
            null,
            null,
            null,
            true,
            null,
            null,
            null
         );
      build.setApproveRecordId(record.getId());
      this.auditLedgerService.updateById(build);
      return save;
   }

   public ContractSettlementBizImpl(
      final AttachmentService attachmentService,
      final ContractProjectService projectService,
      final ProjectBranchCompanyLinkService projectBranchCompanyLinkService,
      final BranchCompanyService branchCompanyService,
      final ContractCollectionService contractCollectionService,
      final ContractInvoiceService contractInvoiceService,
      final ManufactureCostService manufactureCostService,
      final ContractAuditLedgerService auditLedgerService,
      final WmsApproveRecordService approveRecordService,
      final ProjectFinanceUtils projectFinanceUtils,
      final UserService userService
   ) {
      this.attachmentService = attachmentService;
      this.projectService = projectService;
      this.projectBranchCompanyLinkService = projectBranchCompanyLinkService;
      this.branchCompanyService = branchCompanyService;
      this.contractCollectionService = contractCollectionService;
      this.contractInvoiceService = contractInvoiceService;
      this.manufactureCostService = manufactureCostService;
      this.auditLedgerService = auditLedgerService;
      this.approveRecordService = approveRecordService;
      this.projectFinanceUtils = projectFinanceUtils;
      this.userService = userService;
   }
}
