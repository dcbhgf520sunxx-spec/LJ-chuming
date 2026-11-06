package com.hzchum.scim.contract.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.business.core.api.biz.BusinessBiz;
import com.hzchum.scim.contract.core.api.biz.ContractCollectionInvoiceBiz;
import com.hzchum.scim.contract.core.api.biz.finance.ContractProjectDisburseDetailBiz;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.ContractDefinitionTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ContractTypeEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractChange;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCollection;
import com.hzchum.scim.contract.core.api.pojo._do.ContractInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectLedgerSumDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectSimpleDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectLedgerQueryDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractChangeService;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractInvoiceService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectAssetInjectionService;
import com.hzchum.scim.contract.core.api.service.finance.ContractReimbursementFeeService;
import com.hzchum.scim.contract.core.api.utils.ProjectFinanceUtils;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ContractCollectionInvoiceBizImpl implements ContractCollectionInvoiceBiz {
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ContractCollectionService collectionService;
   @Resource
   private ContractInvoiceService invoiceService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private ContractChangeService contractChangeService;
   @Resource
   private BusinessBiz businessBiz;
   @Resource
   private UserService userService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private ContractProjectDisburseDetailBiz disburseDetailBiz;
   @Resource
   private SupplierSettlementService supplierSettlementService;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private SubcontractOrderService subcontractOrderService;
   @Resource
   private ContractProjectAssetInjectionService assetInjectionService;
   @Resource
   private SupplierInvoiceService supplierInvoiceService;
   @Resource
   private ContractReimbursementFeeService reimbursementFeeService;
   @Resource
   private ProjectFinanceUtils projectFinanceUtils;

   @Override
   public PageVO<ContractProjectLedgerDTO> listProjectLedger(ProjectLedgerQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      SecurityUser user = UserUtil.getCurrentUser();
      param.setUserId(user.isAdmin() ? null : user.getId());
      PageHelper.startPage(pageNumber, pageSize);
      List<ContractProjectLedgerDTO> contractProjectLedgerDTOS = this.listProjectLedgerByCondition(param);

      for (ContractProjectLedgerDTO contractProjectLedgerDTO : contractProjectLedgerDTOS) {
         Integer contractType = contractProjectLedgerDTO.getContractType();
         if (contractType != null && contractType.equals(ContractTypeEnum.MASTER_CONTRACT.getType())) {
            contractProjectLedgerDTO.setContractDefinitionType(ContractDefinitionTypeEnum.CONTRACT.getType());
         }

         if (contractType != null && contractType.equals(ContractTypeEnum.REPLENISHMENT_CONTRACT.getType())
            || Objects.equals(contractType, ContractTypeEnum.QUANTITY_ADDITION_CONTRACT.getType())) {
            contractProjectLedgerDTO.setContractDefinitionType(ContractDefinitionTypeEnum.REPLENISHMENT_CONTRACT.getType());
         }

         if (contractProjectLedgerDTO.getSalesLeaderId() != null) {
            contractProjectLedgerDTO.setSalesLeaderName(this.userService.getNameById(contractProjectLedgerDTO.getSalesLeaderId()));
         }
      }

      return new PageVO<>(contractProjectLedgerDTOS);
   }

   private List<ContractProjectLedgerDTO> listProjectLedgerByCondition(ProjectLedgerQueryDTOParam param) {
      List<ContractProjectLedgerDTO> projectLedgerDTOS = this.projectService.listProjectLedger(param);
      if (CollectionUtils.isNotEmpty(projectLedgerDTOS)) {
         List<Long> projectIds = projectLedgerDTOS.stream().map(ContractProjectLedgerDTO::getId).collect(Collectors.toList());
         Map<Long, BigDecimal> projectShipAmountMap = this.businessBiz.getProjectShipAmountMap(projectIds);
         int scale = 4;
         projectLedgerDTOS.forEach(
            p -> {
               if (p.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())) {
                  p.setCollectionRate(
                     p.getContractAmount().compareTo(BigDecimal.ZERO) != 0
                        ? p.getCollectionAmount().divide(p.getContractAmount(), scale, RoundingMode.HALF_UP)
                        : BigDecimal.ZERO
                  );
                  p.setInvoiceRate(
                     p.getContractAmount().compareTo(BigDecimal.ZERO) != 0
                        ? p.getInvoiceAmount().divide(p.getContractAmount(), scale, RoundingMode.HALF_UP)
                        : BigDecimal.ZERO
                  );
               } else {
                  p.setCollectionRate(p.getCollectionAmount().divide(p.getSettlementAmount(), scale, RoundingMode.HALF_UP));
                  p.setInvoiceRate(p.getInvoiceAmount().divide(p.getSettlementAmount(), scale, RoundingMode.HALF_UP));
               }

               p.setDeliverInstallAmount(projectShipAmountMap.getOrDefault(p.getId(), BigDecimal.ZERO));
               BigDecimal managementFee = p.getContractAmount()
                  .multiply(p.getManagementFeeRate())
                  .divide(BigDecimal.valueOf(100L), scale, RoundingMode.HALF_UP);
               p.setAvailableBalance(p.getCollectionAmount().subtract(p.getDeliverInstallAmount()).subtract(managementFee));
            }
         );
      }

      return projectLedgerDTOS;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printProjectLedgerList(ProjectLedgerQueryDTOParam queryDTOParam) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (queryDTOParam.getYear() != null) {
         header.put("year", queryDTOParam.getYear());
      }

      printVO.setHeader(header);
      SecurityUser user = UserUtil.getCurrentUser();
      queryDTOParam.setUserId(user.isAdmin() ? null : user.getId());
      List<ContractProjectLedgerDTO> contractProjectLedgerDTOS = this.listProjectLedgerByCondition(queryDTOParam);
      List<Map<String, Object>> mapList = contractProjectLedgerDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public ContractProjectLedgerSumDTO getProjectSum(ProjectLedgerQueryDTOParam param) {
      SecurityUser user = UserUtil.getCurrentUser();
      param.setUserId(user.isAdmin() ? null : user.getId());
      List<ContractProjectLedgerDTO> ledgerDTOList = this.projectService.listProjectLedger(param);
      BigDecimal contractAmountSum = BigDecimal.ZERO;
      BigDecimal settlementAmountSum = BigDecimal.ZERO;
      BigDecimal collectionAmountSum = BigDecimal.ZERO;
      BigDecimal invoiceAmountSum = BigDecimal.ZERO;

      for (ContractProjectLedgerDTO ledgerDTO : ledgerDTOList) {
         contractAmountSum = contractAmountSum.add(ledgerDTO.getContractAmount());
         settlementAmountSum = settlementAmountSum.add(ledgerDTO.getSettlementAmount());
         collectionAmountSum = collectionAmountSum.add(ledgerDTO.getCollectionAmount());
         invoiceAmountSum = invoiceAmountSum.add(ledgerDTO.getInvoiceAmount());
      }

      return ContractProjectLedgerSumDTO.builder()
         .contractAmountSum(contractAmountSum)
         .settlementAmountSum(settlementAmountSum)
         .collectionAmountSum(collectionAmountSum)
         .invoiceAmountSum(invoiceAmountSum)
         .build();
   }

   @Override
   public ProjectSimpleDTO getProjectFinanceInfo(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      ProjectSimpleDTO simpleDTO = BeanUtil.copy(project, ProjectSimpleDTO.class);
      simpleDTO.setHaveCollectionAmount(this.collectionService.getCollectionAmount(projectId));
      simpleDTO.setHaveInvoiceAmount(this.invoiceService.getInvoiceAmount(projectId));
      Map<String, Object> map = new HashMap<>();
      map.put("companyId", project.getContractSignBodyId());
      map.put("companyName", this.branchCompanyService.getNameById(project.getContractSignBodyId()));
      simpleDTO.setCompanyBankAccountList(Collections.singletonList(map));
      return simpleDTO;
   }

   @Override
   public ContractInvoiceCollectionDTO getProjectInvoiceCollection(Long projectId) {
      return this.projectService.getProjectCollectionVoiceInfo(projectId);
   }

   @Override
   public void checkProjectChanging(Long projectId) {
      int count = this.contractChangeService
         .count(
            Wrappers.lambdaQuery(ContractChange.class)
               .eq(ContractChange::getProjectId, projectId)
               .eq(ContractChange::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(count == 0, "项目合同信息修改,正在审核中");
      count = this.collectionService
         .count(
            Wrappers.lambdaQuery(ContractCollection.class)
               .eq(ContractCollection::getProjectId, projectId)
               .eq(ContractCollection::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(count == 0, "项目收款正在审核中");
      count = this.invoiceService
         .count(
            Wrappers.lambdaQuery(ContractInvoice.class)
               .eq(ContractInvoice::getProjectId, projectId)
               .eq(ContractInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(count == 0, "项目开票正在审核中");
   }
}
