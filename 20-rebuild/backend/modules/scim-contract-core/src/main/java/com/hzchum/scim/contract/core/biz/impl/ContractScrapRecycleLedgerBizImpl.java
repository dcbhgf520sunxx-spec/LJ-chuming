package com.hzchum.scim.contract.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.business.core.api.enums.EnclosurePricingMannerEnum;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.HandleMethodEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.biz.ContractScrapRecycleLedgerBiz;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractRecycleInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractRecyclePaymentDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractReturnLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractReturnProductDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecycleInvoiceAuditParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecycleInvoiceSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecycleInvoiceUpdateParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecyclePaymentAuditParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecyclePaymentSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecyclePaymentUpdateParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductChild;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductMain;
import com.hzchum.scim.project.core.api.service.ProjectReturnProductChildService;
import com.hzchum.scim.project.core.api.service.ProjectReturnProductMainService;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BankAccount;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.service.BankAccountService;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractScrapRecycleLedgerBizImpl implements ContractScrapRecycleLedgerBiz {
   private final ContractProjectService projectService;
   private final PlanMonomerService monomerService;
   private final PlanAreaService areaService;
   private final EnclosurePlanService enclosurePlanService;
   private final SysDictionaryService dictionaryService;
   private final AttachmentService attachmentService;
   private final ProjectReturnProductMainService returnProductMainService;
   private final ProjectReturnProductChildService returnProductChildService;
   private final BranchCompanyService branchCompanyService;
   private final BankAccountService bankAccountService;
   private final SupplierPaymentService supplierPaymentService;
   private final SupplierInvoiceService supplierInvoiceService;
   private final TechArtifactService artifactService;
   private final TechEnclosureService enclosureService;
   private final TechStandardPartService standardPartService;

   @Override
   public List<ContractReturnLedgerDTO> listScrapRecycleLedger(LocalDate startDate, LocalDate endDate, Long branchCompanyId, String customerUnit) {
      List<ProjectReturnProductMain> returnMainList = this.returnProductMainService
         .list(
            Wrappers.lambdaQuery(ProjectReturnProductMain.class)
               .eq(ProjectReturnProductMain::getHandleMethod, HandleMethodEnum.RECYCLE.getType())
               .eq(ProjectReturnProductMain::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(branchCompanyId != null, ProjectReturnProductMain::getBranchCompanyId, branchCompanyId)
               .like(customerUnit != null, ProjectReturnProductMain::getCustomerUnit, customerUnit)
               .apply(startDate != null, "DATE(audit_time) >= {0}", startDate)
               .apply(endDate != null, "DATE(audit_time) <= {0}", endDate)
         );
      if (returnMainList.isEmpty()) {
         return Collections.emptyList();
      }

      Set<Long> branchCompanyIds = returnMainList.stream().map(ProjectReturnProductMain::getBranchCompanyId).collect(Collectors.toSet());
      Set<String> customerUnitList = returnMainList.stream().map(ProjectReturnProductMain::getCustomerUnit).collect(Collectors.toSet());
      Map<Long, Map<String, BigDecimal>> totalAmountMap = this.returnProductMainService
         .list(
            Wrappers.lambdaQuery(ProjectReturnProductMain.class)
               .eq(ProjectReturnProductMain::getHandleMethod, HandleMethodEnum.RECYCLE.getType())
               .eq(ProjectReturnProductMain::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .in(ProjectReturnProductMain::getBranchCompanyId, branchCompanyIds)
               .in(ProjectReturnProductMain::getCustomerUnit, customerUnitList)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               ProjectReturnProductMain::getBranchCompanyId,
               Collectors.groupingBy(
                  ProjectReturnProductMain::getCustomerUnit, Collectors.reducing(BigDecimal.ZERO, ProjectReturnProductMain::getTotalAmount, BigDecimal::add)
               )
            )
         );
      Map<Long, Map<String, Map<Integer, List<SupplierPayment>>>> paymentMap = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.RECYCLE_FINISHED_FEE.getType())
               .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               .in(SupplierPayment::getPaymentUnitId, branchCompanyIds)
               .in(SupplierPayment::getReceivingUnit, customerUnitList)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               SupplierPayment::getPaymentUnitId,
               Collectors.groupingBy(SupplierPayment::getReceivingUnit, Collectors.groupingBy(SupplierPayment::getAuditStatus))
            )
         );
      Map<Long, Map<String, Map<Integer, List<SupplierInvoice>>>> invoiceMap = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.RECYCLE_FINISHED_FEE.getType())
               .in(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               .in(SupplierInvoice::getBranchCompanyId, branchCompanyIds)
               .in(SupplierInvoice::getSupplierName, customerUnitList)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               SupplierInvoice::getBranchCompanyId,
               Collectors.groupingBy(SupplierInvoice::getSupplierName, Collectors.groupingBy(SupplierInvoice::getAuditStatus))
            )
         );
      Map<Long, String> branchCompanyMap = this.branchCompanyService.list().stream().collect(Collectors.toMap(BranchCompany::getId, BranchCompany::getName));
      Map<Long, Map<String, List<ProjectReturnProductMain>>> returnListMap = returnMainList.stream()
         .collect(Collectors.groupingBy(ProjectReturnProductMain::getBranchCompanyId, Collectors.groupingBy(ProjectReturnProductMain::getCustomerUnit)));
      List<ContractReturnLedgerDTO> returnLedgerList = new ArrayList<>(returnListMap.values().stream().mapToInt(map -> map.keySet().size()).sum());
      returnListMap.forEach(
         (branchId, customerUnitMap) -> {
            String branchName = branchCompanyMap.get(branchId);
            customerUnitMap.forEach(
               (ct, list) -> {
                  Map<Integer, List<SupplierPayment>> auditStatusPaymentListMap = paymentMap.getOrDefault(branchId, Collections.emptyMap())
                     .getOrDefault(ct, Collections.emptyMap());
                  Map<Integer, List<SupplierInvoice>> auditStatusInvoiceListMap = invoiceMap.getOrDefault(branchId, Collections.emptyMap())
                     .getOrDefault(ct, Collections.emptyMap());
                  BigDecimal totalAmount = totalAmountMap.get(branchId).get(ct);
                  BigDecimal paymentAmount = auditStatusPaymentListMap.getOrDefault(AuditStatusEnum.SUCCEED.getType(), Collections.emptyList())
                     .stream()
                     .map(SupplierPayment::getActuallyPaymentAmount)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  BigDecimal invoiceAmount = auditStatusInvoiceListMap.getOrDefault(AuditStatusEnum.SUCCEED.getType(), Collections.emptyList())
                     .stream()
                     .map(SupplierInvoice::getInvoiceAmount)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  ContractReturnLedgerDTO ledgerDTO = ContractReturnLedgerDTO.builder()
                     .branchCompanyId(branchId)
                     .branchCompanyName(branchName)
                     .customerUnit(ct)
                     .totalAmount(totalAmount.setScale(2, RoundingMode.HALF_UP))
                     .paymentAmount(paymentAmount.setScale(2, RoundingMode.HALF_UP))
                     .paymentRate(paymentAmount.multiply(BigDecimal.valueOf(100L)).divide(totalAmount, 2, RoundingMode.HALF_UP))
                     .invoiceAmount(invoiceAmount.setScale(2, RoundingMode.HALF_UP))
                     .invoiceRate(invoiceAmount.multiply(BigDecimal.valueOf(100L)).divide(totalAmount, 2, RoundingMode.HALF_UP))
                     .unCheckPaymentCount(auditStatusPaymentListMap.getOrDefault(AuditStatusEnum.AUDITING.getType(), Collections.emptyList()).size())
                     .unCheckInvoiceCount(auditStatusInvoiceListMap.getOrDefault(AuditStatusEnum.AUDITING.getType(), Collections.emptyList()).size())
                     .build();
                  returnLedgerList.add(ledgerDTO);
               }
            );
         }
      );
      return returnLedgerList;
   }

   @Override
   public PrintVO<List<ContractReturnLedgerDTO>> printListScrapRecycleLedger(LocalDate startDate, LocalDate endDate, Long branchCompanyId, String customerUnit) {
      PrintVO<List<ContractReturnLedgerDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<ContractReturnLedgerDTO> ledgerList = this.listScrapRecycleLedger(startDate, endDate, branchCompanyId, customerUnit);
      printVO.setTable(ledgerList);
      return printVO;
   }

   @Override
   public BigDecimal getRecycleTotalAmount(Long branchCompanyId, String customerUnit) {
      return this.returnProductMainService
         .list(
            Wrappers.lambdaQuery(ProjectReturnProductMain.class)
               .eq(ProjectReturnProductMain::getHandleMethod, HandleMethodEnum.RECYCLE.getType())
               .eq(ProjectReturnProductMain::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(branchCompanyId != null, ProjectReturnProductMain::getBranchCompanyId, branchCompanyId)
               .like(customerUnit != null, ProjectReturnProductMain::getCustomerUnit, customerUnit)
         )
         .stream()
         .map(ProjectReturnProductMain::getTotalAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .setScale(2, RoundingMode.HALF_UP);
   }

   @Override
   public PageVO<ContractReturnProductDTO> pageListReturnProduct(
      Long branchCompanyId, String customerUnit, Long projectId, Integer handleMethod, Integer pageNumber, Integer pageSize
   ) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<ContractReturnProductDTO> resultList = this.getProductList(branchCompanyId, customerUnit, projectId, handleMethod);
      return new PageVO<>(page, resultList);
   }

   private List<ContractReturnProductDTO> getProductList(Long branchCompanyId, String customerUnit, Long projectId, Integer handleMethod) {
      List<ProjectReturnProductChild> returnChildList = this.returnProductChildService
         .list(
            Wrappers.lambdaQuery(ProjectReturnProductChild.class)
               .eq(handleMethod != null, ProjectReturnProductChild::getHandleMethod, handleMethod)
               .eq(ProjectReturnProductChild::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(branchCompanyId != null, ProjectReturnProductChild::getBranchCompanyId, branchCompanyId)
               .eq(customerUnit != null, ProjectReturnProductChild::getCustomerUnit, customerUnit)
               .eq(projectId != null, ProjectReturnProductChild::getProjectId, projectId)
               .orderByDesc(ProjectReturnProductChild::getId)
         );
      if (returnChildList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, String> mainIdSnMap = this.returnProductMainService
         .listByIds(returnChildList.stream().map(ProjectReturnProductChild::getMainId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(ProjectReturnProductMain::getId, ProjectReturnProductMain::getSerialNumber));
      Map<Integer, List<Long>> productTypeProductIdsMap = returnChildList.stream()
         .collect(
            Collectors.groupingBy(ProjectReturnProductChild::getProductType, Collectors.mapping(ProjectReturnProductChild::getProductId, Collectors.toList()))
         );
      Map<Long, TechArtifact> artifactMap = new HashMap<>(
         productTypeProductIdsMap.getOrDefault(ProductTypeEnum.ARTIFACT.getType(), Collections.emptyList()).size()
      );
      Map<Long, TechEnclosure> enclosureMap = new HashMap<>(
         productTypeProductIdsMap.getOrDefault(ProductTypeEnum.ENCLOSURE.getType(), Collections.emptyList()).size()
      );
      Map<Long, TechStandardPart> standardPartMap = new HashMap<>(
         productTypeProductIdsMap.getOrDefault(ProductTypeEnum.AUXILIARY_MATERIAL.getType(), Collections.emptyList()).size()
      );
      productTypeProductIdsMap.forEach(
         (productType, productIds) -> {
            if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
               artifactMap.putAll(this.artifactService.listByIds(productIds).stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity())));
            }

            if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
               enclosureMap.putAll(this.enclosureService.listByIds(productIds).stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity())));
            }

            if (productType.equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
               standardPartMap.putAll(
                  this.standardPartService.listByIds(productIds).stream().collect(Collectors.toMap(TechStandardPart::getId, Function.identity()))
               );
            }
         }
      );
      Map<Long, ProjectInfo> projectMap = this.projectService
         .listInfoByIdList(returnChildList.stream().map(ProjectReturnProductChild::getProjectId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
      Map<Long, NameInfo> monomerMap = this.monomerService
         .listNameInfo(returnChildList.stream().map(ProjectReturnProductChild::getMonomerId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      Map<Long, NameInfo> areaMap = this.areaService
         .listSimpleByIds(returnChildList.stream().map(ProjectReturnProductChild::getAreaId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      Map<Long, NameInfo> planMap = this.enclosurePlanService
         .listByIds(returnChildList.stream().map(ProjectReturnProductChild::getPlanId).collect(Collectors.toSet()))
         .stream()
         .map(s -> NameInfo.builder().id(s.getId()).name(s.getName()).build())
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      List<ContractReturnProductDTO> returnProductList = new ArrayList<>(returnChildList.size());
      returnChildList.forEach(
         returnChild -> {
            ContractReturnProductDTO dto = BeanUtil.copy(returnChild, ContractReturnProductDTO.class);
            dto.setHandleSerialNumber(mainIdSnMap.get(returnChild.getMainId()));
            dto.setProject(projectMap.get(returnChild.getProjectId()));
            dto.setMonomer(monomerMap.get(returnChild.getMonomerId()));
            dto.setArea(areaMap.get(returnChild.getAreaId()));
            if (returnChild.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               TechArtifact artifact = artifactMap.get(returnChild.getProductId());
               dto.setName(artifact.getName());
               dto.setSerialNumber(artifact.getSerialNumber());
               dto.setSpecification(artifact.getSpecification());
               dto.setMaterial(artifact.getMaterial());
               dto.setLength(artifact.getLength().divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
               dto.setMeasureUnit("件");
               dto.setMete(artifact.getNetWeight().multiply(returnChild.getQuantity()).divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
               dto.setAccountingUnit("吨");
            }

            if (returnChild.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
               TechEnclosure enclosure = enclosureMap.get(returnChild.getProductId());
               dto.setArea(planMap.get(returnChild.getPlanId()));
               dto.setName(enclosure.getName());
               dto.setSerialNumber(enclosure.getSerialNumber());
               dto.setSpecification(enclosure.getPlate());
               dto.setMaterial(enclosure.getMaterial());
               dto.setLength(enclosure.getLength().divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
               dto.setMeasureUnit("张");
               if (returnChild.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())) {
                  dto.setMete(enclosure.getLength().multiply(returnChild.getQuantity()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
                  dto.setAccountingUnit("米");
               } else {
                  dto.setMete(
                     enclosure.getSurfaceArea()
                        .multiply(returnChild.getQuantity())
                        .multiply(returnChild.getUnitPrice())
                        .divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP)
                  );
                  dto.setAccountingUnit("平方米");
               }
            }

            if (returnChild.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
               TechStandardPart standardPart = standardPartMap.get(returnChild.getProductId());
               dto.setName(standardPart.getName());
               dto.setSpecification(standardPart.getSpecification());
               dto.setMete(standardPart.getMete().multiply(returnChild.getQuantity()).divide(standardPart.getQuantity(), 2, RoundingMode.HALF_UP));
               dto.setPricingManner(null);
               dto.setMeasureUnit(standardPart.getMeasureUnit());
               dto.setAccountingUnit(standardPart.getAccountingUnit());
            }

            returnProductList.add(dto);
         }
      );
      return returnProductList;
   }

   @Override
   public PrintVO<List<ContractReturnProductDTO>> printListReturnProduct(Long branchCompanyId, String customerUnit, Long projectId, Integer handleMethod) {
      PrintVO<List<ContractReturnProductDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (branchCompanyId != null) {
         BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
         header.put("branchCompanyName", branchCompany.getName());
      }

      if (customerUnit != null) {
         header.put("customerUnit", customerUnit);
      }

      if (projectId != null) {
         header.put("project", this.projectService.getSimpleById(projectId));
         header.put("title", "回厂返修费用");
      }

      printVO.setHeader(header);
      List<ContractReturnProductDTO> returnProductList = this.getProductList(branchCompanyId, customerUnit, projectId, handleMethod);
      printVO.setTable(returnProductList);
      return printVO;
   }

   @Override
   public PageVO<ContractRecyclePaymentDTO> pageListPayment(
      Long branchCompanyId, String customerUnit, Integer auditStatus, Integer pageNumber, Integer pageSize
   ) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<ContractRecyclePaymentDTO> paymentList = this.getPaymentList(branchCompanyId, customerUnit, auditStatus);
      return new PageVO<>(page, paymentList);
   }

   private List<ContractRecyclePaymentDTO> getPaymentList(Long branchCompanyId, String customerUnit, Integer auditStatus) {
      List<SupplierPayment> paymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.RECYCLE_FINISHED_FEE.getType())
               .eq(auditStatus != null, SupplierPayment::getAuditStatus, auditStatus)
               .eq(branchCompanyId != null, SupplierPayment::getPaymentUnitId, branchCompanyId)
               .eq(customerUnit != null, SupplierPayment::getReceivingUnit, customerUnit)
               .orderByDesc(SupplierPayment::getPaymentDate)
               .orderByDesc(SupplierPayment::getId)
         );
      return paymentList.isEmpty() ? Collections.emptyList() : paymentList.stream().map(s -> {
         ContractRecyclePaymentDTO dto = BeanUtil.copy(s, ContractRecyclePaymentDTO.class);
         dto.setAttachments(this.attachmentService.listByIds(s.getAttachmentIds()));
         return dto;
      }).collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<ContractRecyclePaymentDTO>> printListPayment(Long branchCompanyId, String customerUnit, Integer auditStatus) {
      PrintVO<List<ContractRecyclePaymentDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
      header.put("branchCompanyName", branchCompany.getName());
      header.put("customerUnit", customerUnit);
      printVO.setHeader(header);
      List<ContractRecyclePaymentDTO> paymentList = this.getPaymentList(branchCompanyId, customerUnit, auditStatus);
      printVO.setTable(paymentList);
      return printVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveReturnPayment(List<RecyclePaymentSaveParam> params) {
      params.forEach(
         param -> {
            BranchCompany branchCompany = this.branchCompanyService.getById(param.getBranchCompanyId());
            Preconditions.checkArgument(branchCompany != null, "付款单位不存在!");
            if (StringUtils.isNotBlank(param.getPaymentBank())) {
               Map<String, Map<String, BankAccount>> bankAccountListMap = this.bankAccountService
                  .list(Wrappers.lambdaQuery(BankAccount.builder().branchCompanyId(param.getBranchCompanyId()).build()))
                  .stream()
                  .collect(Collectors.groupingBy(BankAccount::getDepositBank, Collectors.toMap(BankAccount::getAccount, Function.identity())));
               Preconditions.checkArgument(bankAccountListMap.containsKey(param.getPaymentBank()), "付款银行不存在!");
               Map<String, BankAccount> bankAccountMap = bankAccountListMap.get(param.getPaymentBank());
               Preconditions.checkArgument(
                  StringUtils.isBlank(param.getPaymentBankAccount()) || bankAccountMap.containsKey(param.getPaymentBankAccount()), "付款银行账号有误!"
               );
            }

            SysDictionary dictionary = this.dictionaryService.getByNameAndValue(DictionaryEnum.PAYMENT_REASON.getName(), param.getPaymentReasonId());
            Preconditions.checkArgument(dictionary != null, "付款事由不存在");
            SupplierPayment supplierPayment = BeanUtil.copy(param, SupplierPayment.class);
            supplierPayment.setPropertyType(SupplierPropertyTypeEnum.RECYCLE_FINISHED_FEE.getType());
            supplierPayment.setReceivingUnitId(0L);
            supplierPayment.setReceivingUnit(param.getCustomerUnit());
            supplierPayment.setPaymentUnitId(param.getBranchCompanyId());
            supplierPayment.setPaymentUnit(branchCompany.getName());
            supplierPayment.setPaymentReasonName(dictionary.getLabel());
            supplierPayment.setAttachmentIds(CollectionUtils.isEmpty(param.getAttachmentIds()) ? null : StringUtils.join(param.getAttachmentIds(), ","));
            supplierPayment.setAuditStatus(AuditStatusEnum.AUDITING.getType());
            supplierPayment.setApplyUserId(UserUtil.getCurrentUserId());
            supplierPayment.setApplyUserName(UserUtil.getCurrentName());
            this.supplierPaymentService.save(supplierPayment);
         }
      );
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateReturnPayment(List<RecyclePaymentUpdateParam> params) {
      params.forEach(
         param -> {
            SupplierPayment supplierPayment = this.supplierPaymentService.getById(param.getId());
            Preconditions.checkArgument(supplierPayment != null, "付款记录不存在!");
            Preconditions.checkArgument(!supplierPayment.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()), "付款已审核通过!修改失败!");
            Preconditions.checkArgument(supplierPayment.getPropertyType().equals(SupplierPropertyTypeEnum.RECYCLE_FINISHED_FEE.getType()), "付款记录出现错误!!");
            if (!param.getBranchCompanyId().equals(supplierPayment.getPaymentUnitId())) {
               BranchCompany company = this.branchCompanyService.getById(param.getBranchCompanyId());
               Preconditions.checkArgument(company != null, "付款单位不存在!");
               supplierPayment.setPaymentUnitId(param.getBranchCompanyId());
               supplierPayment.setPaymentUnit(company.getName());
            }

            if (StringUtils.isNotBlank(param.getPaymentBank())) {
               Map<String, Map<String, BankAccount>> bankAccountListMap = this.bankAccountService
                  .list(Wrappers.lambdaQuery(BankAccount.builder().branchCompanyId(supplierPayment.getPaymentUnitId()).build()))
                  .stream()
                  .collect(Collectors.groupingBy(BankAccount::getDepositBank, Collectors.toMap(BankAccount::getAccount, Function.identity())));
               Preconditions.checkArgument(bankAccountListMap.containsKey(param.getPaymentBank()), "付款银行不存在!");
               Map<String, BankAccount> bankAccountMap = bankAccountListMap.get(param.getPaymentBank());
               Preconditions.checkArgument(
                  StringUtils.isBlank(param.getPaymentBankAccount()) || bankAccountMap.containsKey(param.getPaymentBankAccount()), "付款银行账号有误!"
               );
            }

            if (!param.getPaymentReasonId().equals(supplierPayment.getPaymentReasonId())) {
               SysDictionary dictionary = this.dictionaryService.getByNameAndValue(DictionaryEnum.PAYMENT_REASON.getName(), param.getPaymentReasonId());
               Preconditions.checkArgument(dictionary != null, "付款事由不存在");
               supplierPayment.setPaymentReasonName(dictionary.getLabel());
            }

            BeanUtil.copy(param, supplierPayment);
            supplierPayment.setAttachmentIds(CollectionUtils.isEmpty(param.getAttachmentIds()) ? null : StringUtils.join(param.getAttachmentIds(), ","));
            supplierPayment.setAuditStatus(AuditStatusEnum.AUDITING.getType());
            supplierPayment.setAuditUserId(null);
            supplierPayment.setAuditUserName(null);
            supplierPayment.setAuditTime(null);
            this.supplierPaymentService.updateById(supplierPayment);
         }
      );
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean auditReturnPayment(RecyclePaymentAuditParam param) {
      SupplierPayment supplierPayment = this.supplierPaymentService.getById(param.getId());
      Preconditions.checkArgument(supplierPayment != null, "付款记录不存在!");
      Preconditions.checkArgument(supplierPayment.getPropertyType().equals(SupplierPropertyTypeEnum.RECYCLE_FINISHED_FEE.getType()), "付款记录出现错误!!");
      Preconditions.checkArgument(supplierPayment.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "付款记录已审核!!请刷新页面重试!!");
      Preconditions.checkArgument(
         AuditStatusEnum.SUCCEED.getType().equals(param.getAuditStatus()) || AuditStatusEnum.FAILED.getType().equals(param.getAuditStatus()), "审核状态传值错误!"
      );
      supplierPayment.setAuditStatus(param.getAuditStatus());
      if (param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())) {
         supplierPayment.setActuallyPaymentAmount(supplierPayment.getApplyAmount());
      }

      supplierPayment.setAuditUserId(UserUtil.getCurrentUserId());
      supplierPayment.setAuditUserName(UserUtil.getCurrentName());
      supplierPayment.setAuditTime(LocalDateTime.now());
      this.supplierPaymentService.updateById(supplierPayment);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean removeReturnPayment(List<Long> ids) {
      ids.forEach(id -> {
         SupplierPayment supplierPayment = this.supplierPaymentService.getById(id);
         Preconditions.checkArgument(supplierPayment != null, "付款记录不存在!!");
         Preconditions.checkArgument(!supplierPayment.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()), "本次付款已通过审核!删除失败!");
         Preconditions.checkArgument(supplierPayment.getPropertyType().equals(SupplierPropertyTypeEnum.RECYCLE_FINISHED_FEE.getType()), "付款记录出现错误!!");
         this.supplierPaymentService.removeById(id);
      });
      return true;
   }

   @Override
   public PageVO<ContractRecycleInvoiceDTO> pageListInvoice(
      Long branchCompanyId, String customerUnit, Integer auditStatus, Integer pageNumber, Integer pageSize
   ) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<ContractRecycleInvoiceDTO> invoiceList = this.getInvoiceList(branchCompanyId, customerUnit, auditStatus);
      return new PageVO<>(page, invoiceList);
   }

   private List<ContractRecycleInvoiceDTO> getInvoiceList(Long branchCompanyId, String customerUnit, Integer auditStatus) {
      List<SupplierInvoice> supplierInvoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.RECYCLE_FINISHED_FEE.getType())
               .eq(branchCompanyId != null, SupplierInvoice::getBranchCompanyId, branchCompanyId)
               .eq(customerUnit != null, SupplierInvoice::getSupplierName, customerUnit)
               .eq(auditStatus != null, SupplierInvoice::getAuditStatus, auditStatus)
         );
      return supplierInvoiceList.isEmpty()
         ? Collections.emptyList()
         : supplierInvoiceList.stream()
            .map(
               s -> {
                  ContractRecycleInvoiceDTO dto = BeanUtil.copy(s, ContractRecycleInvoiceDTO.class);
                  dto.setTax(s.getInvoiceAmount().multiply(s.getTaxRate()).divide(s.getTaxRate().add(BigDecimal.valueOf(100L)), 2, RoundingMode.HALF_UP));
                  dto.setAmountExcludingTax(
                     s.getInvoiceAmount().multiply(BigDecimal.valueOf(100L)).divide(s.getTaxRate().add(BigDecimal.valueOf(100L)), 2, RoundingMode.HALF_UP)
                  );
                  dto.setAttachments(this.attachmentService.listByIds(s.getAttachmentIds()));
                  return dto;
               }
            )
            .collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<ContractRecycleInvoiceDTO>> printListInvoice(Long branchCompanyId, String customerUnit, Integer auditStatus) {
      PrintVO<List<ContractRecycleInvoiceDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
      header.put("branchCompanyName", branchCompany.getName());
      header.put("customerUnit", customerUnit);
      printVO.setHeader(header);
      List<ContractRecycleInvoiceDTO> invoiceList = this.getInvoiceList(branchCompanyId, customerUnit, auditStatus);
      printVO.setTable(invoiceList);
      return printVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveInvoice(List<RecycleInvoiceSaveParam> params) {
      params.forEach(param -> {
         Preconditions.checkArgument(param.getBoolIncludeTax() || param.getTaxRate() == null || param.getTaxRate().compareTo(BigDecimal.ZERO) == 0, "税率有误!");
         Preconditions.checkArgument(!param.getBoolIncludeTax() || param.getTaxRate() != null, "税率不能为空!");
         BranchCompany branchCompany = this.branchCompanyService.getById(param.getBranchCompanyId());
         Preconditions.checkArgument(branchCompany != null, "收票单位不存在!");
         SupplierInvoice supplierInvoice = BeanUtil.copy(param, SupplierInvoice.class);
         supplierInvoice.setPropertyType(SupplierPropertyTypeEnum.RECYCLE_FINISHED_FEE.getType());
         supplierInvoice.setBranchCompanyName(branchCompany.getName());
         supplierInvoice.setSupplierId(0L);
         supplierInvoice.setSupplierName(param.getCustomerUnit());
         supplierInvoice.setAttachmentIds(CollectionUtils.isEmpty(param.getAttachmentIds()) ? null : StringUtils.join(param.getAttachmentIds(), ","));
         supplierInvoice.setApplyUserId(UserUtil.getCurrentUserId());
         supplierInvoice.setApplyUserName(UserUtil.getCurrentName());
         supplierInvoice.setAuditStatus(AuditStatusEnum.AUDITING.getType());
         this.supplierInvoiceService.save(supplierInvoice);
      });
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateInvoice(List<RecycleInvoiceUpdateParam> paramList) {
      paramList.forEach(param -> {
         Preconditions.checkArgument(param.getBoolIncludeTax() || param.getTaxRate() == null || param.getTaxRate().compareTo(BigDecimal.ZERO) == 0, "税率有误!");
         Preconditions.checkArgument(!param.getBoolIncludeTax() || param.getTaxRate() != null, "税率不能为空!");
         SupplierInvoice supplierInvoice = this.supplierInvoiceService.getById(param.getId());
         Preconditions.checkArgument(supplierInvoice != null, "收票记录不存在!");
         Preconditions.checkArgument(!supplierInvoice.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()), "收票记录已通过审核!修改失败!");
         Preconditions.checkArgument(SupplierPropertyTypeEnum.RECYCLE_FINISHED_FEE.getType().equals(supplierInvoice.getPropertyType()), "收票记录出现错误!!请刷新重试!!");
         BeanUtil.copy(param, supplierInvoice);
         supplierInvoice.setAttachmentIds(CollectionUtils.isEmpty(param.getAttachmentIds()) ? null : StringUtils.join(param.getAttachmentIds(), ","));
         supplierInvoice.setAuditStatus(AuditStatusEnum.AUDITING.getType());
         supplierInvoice.setAuditUserId(null);
         supplierInvoice.setAuditUserName(null);
         supplierInvoice.setAuditTime(null);
         this.supplierInvoiceService.updateById(supplierInvoice);
      });
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean auditInvoice(RecycleInvoiceAuditParam param) {
      SupplierInvoice supplierInvoice = this.supplierInvoiceService.getById(param.getId());
      Preconditions.checkArgument(supplierInvoice != null, "收票记录不存在!");
      Preconditions.checkArgument(SupplierPropertyTypeEnum.RECYCLE_FINISHED_FEE.getType().equals(supplierInvoice.getPropertyType()), "收票记录出现错误!!请刷新重试!!");
      Preconditions.checkArgument(supplierInvoice.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "收票记录已审核!!请刷新重试!!");
      Preconditions.checkArgument(
         AuditStatusEnum.SUCCEED.getType().equals(param.getAuditStatus()) || AuditStatusEnum.FAILED.getType().equals(param.getAuditStatus()), "审核状态传值错误!"
      );
      if (param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())) {
         supplierInvoice.setActualInvoiceAmount(supplierInvoice.getInvoiceAmount());
      }

      supplierInvoice.setAuditStatus(param.getAuditStatus());
      supplierInvoice.setAuditUserId(UserUtil.getCurrentUserId());
      supplierInvoice.setAuditUserName(UserUtil.getCurrentName());
      supplierInvoice.setAuditTime(LocalDateTime.now());
      this.supplierInvoiceService.updateById(supplierInvoice);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean removeInvoice(List<Long> ids) {
      ids.forEach(id -> {
         SupplierInvoice supplierInvoice = this.supplierInvoiceService.getById(id);
         Preconditions.checkArgument(supplierInvoice != null, "收票记录不存在!");
         Preconditions.checkArgument(SupplierPropertyTypeEnum.RECYCLE_FINISHED_FEE.getType().equals(supplierInvoice.getPropertyType()), "收票记录出现错误!!请刷新重试!!");
         Preconditions.checkArgument(!supplierInvoice.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()), "收票记录已通过审核!删除失败!");
         this.supplierInvoiceService.removeById(id);
      });
      return true;
   }

   public ContractScrapRecycleLedgerBizImpl(
      final ContractProjectService projectService,
      final PlanMonomerService monomerService,
      final PlanAreaService areaService,
      final EnclosurePlanService enclosurePlanService,
      final SysDictionaryService dictionaryService,
      final AttachmentService attachmentService,
      final ProjectReturnProductMainService returnProductMainService,
      final ProjectReturnProductChildService returnProductChildService,
      final BranchCompanyService branchCompanyService,
      final BankAccountService bankAccountService,
      final SupplierPaymentService supplierPaymentService,
      final SupplierInvoiceService supplierInvoiceService,
      final TechArtifactService artifactService,
      final TechEnclosureService enclosureService,
      final TechStandardPartService standardPartService
   ) {
      this.projectService = projectService;
      this.monomerService = monomerService;
      this.areaService = areaService;
      this.enclosurePlanService = enclosurePlanService;
      this.dictionaryService = dictionaryService;
      this.attachmentService = attachmentService;
      this.returnProductMainService = returnProductMainService;
      this.returnProductChildService = returnProductChildService;
      this.branchCompanyService = branchCompanyService;
      this.bankAccountService = bankAccountService;
      this.supplierPaymentService = supplierPaymentService;
      this.supplierInvoiceService = supplierInvoiceService;
      this.artifactService = artifactService;
      this.enclosureService = enclosureService;
      this.standardPartService = standardPartService;
   }
}
