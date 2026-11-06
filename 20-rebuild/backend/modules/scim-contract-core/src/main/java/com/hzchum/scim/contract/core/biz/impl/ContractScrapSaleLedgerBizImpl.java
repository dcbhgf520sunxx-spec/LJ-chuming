package com.hzchum.scim.contract.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.business.core.api.enums.EnclosurePricingMannerEnum;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.WasteHandleMethodEnum;
import com.hzchum.scim.contract.core.api.biz.ContractScrapSaleLedgerBiz;
import com.hzchum.scim.contract.core.api.enums.CollectionTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCollection;
import com.hzchum.scim.contract.core.api.pojo._do.ContractInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.ContractWaste;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractReturnProductDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteLedgerDTO;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractInvoiceService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractWasteService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductChild;
import com.hzchum.scim.project.core.api.pojo._do.ProjectWasteProductChild;
import com.hzchum.scim.project.core.api.pojo._do.ProjectWasteProductMain;
import com.hzchum.scim.project.core.api.service.ProjectReturnProductChildService;
import com.hzchum.scim.project.core.api.service.ProjectWasteProductChildService;
import com.hzchum.scim.project.core.api.service.ProjectWasteProductMainService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ContractScrapSaleLedgerBizImpl implements ContractScrapSaleLedgerBiz {
   private final BranchCompanyService branchCompanyService;
   private final ContractWasteService contractWasteService;
   private final ContractProjectService projectService;
   private final ProjectWasteProductMainService wasteProductMainService;
   private final ProjectWasteProductChildService wasteProductChildService;
   private final ProjectReturnProductChildService returnProductChildService;
   private final ContractCollectionService collectionService;
   private final ContractInvoiceService invoiceService;
   private final TechArtifactService artifactService;
   private final TechEnclosureService enclosureService;
   private final TechStandardPartService standardPartService;

   @Override
   public List<ContractWasteLedgerDTO> listScrapSaleLedger(LocalDate startDate, LocalDate endDate, Long branchCompanyId, Long contractWasteId) {
      List<ProjectWasteProductMain> productMainList = this.wasteProductMainService
         .list(
            Wrappers.lambdaQuery(ProjectWasteProductMain.class)
               .eq(ProjectWasteProductMain::getWasteHandleMethod, WasteHandleMethodEnum.WASTE_SALE.getType())
               .eq(ProjectWasteProductMain::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(branchCompanyId != null, ProjectWasteProductMain::getBranchCompanyId, branchCompanyId)
               .eq(contractWasteId != null, ProjectWasteProductMain::getContractWasteId, contractWasteId)
               .apply(startDate != null, "DATE(audit_time) >= {0}", startDate)
               .apply(endDate != null, "DATE(audit_time) <= {0}", endDate)
         );
      if (productMainList.isEmpty()) {
         return Collections.emptyList();
      }

      Set<Long> branchCompanyIds = productMainList.stream().map(ProjectWasteProductMain::getBranchCompanyId).collect(Collectors.toSet());
      Set<Long> contractWasteIds = productMainList.stream().map(ProjectWasteProductMain::getContractWasteId).collect(Collectors.toSet());
      Map<Long, Map<Long, BigDecimal>> totalAmountMap = this.wasteProductMainService
         .list(
            Wrappers.lambdaQuery(ProjectWasteProductMain.class)
               .eq(ProjectWasteProductMain::getWasteHandleMethod, WasteHandleMethodEnum.WASTE_SALE.getType())
               .eq(ProjectWasteProductMain::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .in(ProjectWasteProductMain::getBranchCompanyId, branchCompanyIds)
               .in(ProjectWasteProductMain::getContractWasteId, contractWasteIds)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               ProjectWasteProductMain::getBranchCompanyId,
               Collectors.groupingBy(
                  ProjectWasteProductMain::getContractWasteId, Collectors.reducing(BigDecimal.ZERO, ProjectWasteProductMain::getTotalAmount, BigDecimal::add)
               )
            )
         );
      Map<Long, Map<Long, Map<Integer, List<ContractCollection>>>> collectionMap = this.collectionService
         .list(
            Wrappers.lambdaQuery(ContractCollection.class)
               .eq(ContractCollection::getType, CollectionTypeEnum.SCRAP_COLLECTION.getType())
               .in(ContractCollection::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               .in(ContractCollection::getCollectionUnitId, branchCompanyIds)
               .in(ContractCollection::getContractWasteId, contractWasteIds)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               ContractCollection::getCollectionUnitId,
               Collectors.groupingBy(ContractCollection::getContractWasteId, Collectors.groupingBy(ContractCollection::getAuditStatus))
            )
         );
      Map<Long, Map<Long, Map<Integer, List<ContractInvoice>>>> invoiceMap = this.invoiceService
         .list(
            Wrappers.lambdaQuery(ContractInvoice.class)
               .eq(ContractInvoice::getType, CollectionTypeEnum.SCRAP_COLLECTION.getType())
               .in(ContractInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               .in(ContractInvoice::getInvoiceUnitId, branchCompanyIds)
               .in(ContractInvoice::getContractWasteId, contractWasteIds)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               ContractInvoice::getInvoiceUnitId,
               Collectors.groupingBy(ContractInvoice::getContractWasteId, Collectors.groupingBy(ContractInvoice::getAuditStatus))
            )
         );
      Map<Long, String> branchCompanyMap = this.branchCompanyService.list().stream().collect(Collectors.toMap(BranchCompany::getId, BranchCompany::getName));
      Map<Long, ContractWaste> contractWasteMap = this.contractWasteService
         .list()
         .stream()
         .collect(Collectors.toMap(ContractWaste::getId, Function.identity()));
      Map<Long, Set<Long>> collect = productMainList.stream()
         .collect(
            Collectors.groupingBy(
               ProjectWasteProductMain::getBranchCompanyId, Collectors.mapping(ProjectWasteProductMain::getContractWasteId, Collectors.toSet())
            )
         );
      List<ContractWasteLedgerDTO> contractWasteLedgerList = new ArrayList<>(collect.values().stream().mapToInt(Set::size).sum());
      collect.forEach(
         (branchId, wasteIds) -> {
            String branchCompanyName = branchCompanyMap.get(branchId);
            wasteIds.forEach(
               wasteId -> {
                  ContractWaste contractWaste = contractWasteMap.get(wasteId);
                  Map<Integer, List<ContractCollection>> auditStatusCollectionListMap = collectionMap.getOrDefault(branchId, Collections.emptyMap())
                     .getOrDefault(wasteId, Collections.emptyMap());
                  Map<Integer, List<ContractInvoice>> auditStatusInvoiceListMap = invoiceMap.getOrDefault(branchId, Collections.emptyMap())
                     .getOrDefault(wasteId, Collections.emptyMap());
                  BigDecimal totalAmount = totalAmountMap.get(branchId).get(wasteId);
                  BigDecimal collectionAmount = auditStatusCollectionListMap.getOrDefault(AuditStatusEnum.SUCCEED.getType(), Collections.emptyList())
                     .stream()
                     .map(ContractCollection::getCollectionAmount)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  BigDecimal invoiceAmount = auditStatusInvoiceListMap.getOrDefault(AuditStatusEnum.SUCCEED.getType(), Collections.emptyList())
                     .stream()
                     .map(ContractInvoice::getInvoiceAmount)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  ContractWasteLedgerDTO ledgerDTO = ContractWasteLedgerDTO.builder()
                     .branchCompanyId(branchId)
                     .branchCompanyName(branchCompanyName)
                     .contractWasteId(wasteId)
                     .purchaser(contractWaste.getPurchaser())
                     .totalAmount(totalAmount)
                     .collectionAmount(collectionAmount)
                     .collectionRate(collectionAmount.multiply(BigDecimal.valueOf(100L)).divide(totalAmount, 2, RoundingMode.HALF_UP))
                     .invoiceAmount(invoiceAmount)
                     .invoiceRate(invoiceAmount.multiply(BigDecimal.valueOf(100L)).divide(totalAmount, 2, RoundingMode.HALF_UP))
                     .unCheckCollectionCount(auditStatusCollectionListMap.getOrDefault(AuditStatusEnum.AUDITING.getType(), Collections.emptyList()).size())
                     .unCheckInvoiceCount(auditStatusInvoiceListMap.getOrDefault(AuditStatusEnum.AUDITING.getType(), Collections.emptyList()).size())
                     .build();
                  contractWasteLedgerList.add(ledgerDTO);
               }
            );
         }
      );
      return contractWasteLedgerList;
   }

   @Override
   public BigDecimal getSaleAmount(Long branchCompanyId, Long contractWasteId) {
      List<ProjectWasteProductMain> productMainList = this.wasteProductMainService
         .list(
            Wrappers.lambdaQuery(ProjectWasteProductMain.class)
               .eq(branchCompanyId != null, ProjectWasteProductMain::getBranchCompanyId, branchCompanyId)
               .eq(contractWasteId != null, ProjectWasteProductMain::getContractWasteId, contractWasteId)
               .eq(ProjectWasteProductMain::getWasteHandleMethod, WasteHandleMethodEnum.WASTE_SALE.getType())
               .eq(ProjectWasteProductMain::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      return productMainList.stream().map(ProjectWasteProductMain::getTotalAmount).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_UP);
   }

   @Override
   public PrintVO<List<ContractWasteLedgerDTO>> printListScrapSaleLedger(LocalDate startDate, LocalDate endDate, Long branchCompanyId, Long contractWasteId) {
      PrintVO<List<ContractWasteLedgerDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<ContractWasteLedgerDTO> wasteLedgerDTOList = this.listScrapSaleLedger(startDate, endDate, branchCompanyId, contractWasteId);
      printVO.setTable(wasteLedgerDTOList);
      return printVO;
   }

   @Override
   public BigDecimal getWasteCost(Long branchCompanyId, Long contractWasteId) {
      List<ProjectWasteProductChild> wasteChildList = this.wasteProductChildService
         .list(
            Wrappers.lambdaQuery(ProjectWasteProductChild.class)
               .eq(branchCompanyId != null, ProjectWasteProductChild::getBranchCompanyId, branchCompanyId)
               .eq(contractWasteId != null, ProjectWasteProductChild::getContractWasteId, contractWasteId)
               .eq(ProjectWasteProductChild::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .orderByDesc(ProjectWasteProductChild::getId)
         );
      if (wasteChildList.isEmpty()) {
         return BigDecimal.ZERO;
      }

      Set<Long> returnChildIds = wasteChildList.stream().map(ProjectWasteProductChild::getMesBuildingReturnWarehouseRecordId).collect(Collectors.toSet());
      Map<Long, ProjectReturnProductChild> returnChildMap = this.returnProductChildService
         .listByIds(returnChildIds)
         .stream()
         .collect(Collectors.toMap(ProjectReturnProductChild::getId, Function.identity()));
      return wasteChildList.stream()
         .map(
            wasteChild -> {
               ProjectReturnProductChild returnChild = returnChildMap.get(wasteChild.getMesBuildingReturnWarehouseRecordId());
               return wasteChild.getQuantity().equals(returnChild.getQuantity())
                  ? returnChild.getTotalAmount()
                  : returnChild.getTotalAmount().multiply(wasteChild.getQuantity()).divide(returnChild.getQuantity(), 8, RoundingMode.HALF_UP);
            }
         )
         .reduce(BigDecimal.ZERO, BigDecimal::divide)
         .setScale(2, RoundingMode.HALF_UP);
   }

   @Override
   public PageVO<ContractReturnProductDTO> pageListWasteProduct(
      Long branchCompanyId, Long contractWasteId, Long useProjectId, Integer wasteHandleMethod, Integer pageNumber, Integer pageSize
   ) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<ContractReturnProductDTO> dtoList = this.getWasteProductList(branchCompanyId, contractWasteId, useProjectId, wasteHandleMethod);
      return new PageVO<>(page, dtoList);
   }

   private List<ContractReturnProductDTO> getWasteProductList(Long branchCompanyId, Long contractWasteId, Long useProjectId, Integer wasteHandleMethod) {
      List<ProjectWasteProductChild> productChildList = this.wasteProductChildService
         .list(
            Wrappers.lambdaQuery(ProjectWasteProductChild.class)
               .eq(ProjectWasteProductChild::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(wasteHandleMethod != null, ProjectWasteProductChild::getWasteHandleMethod, wasteHandleMethod)
               .eq(branchCompanyId != null, ProjectWasteProductChild::getBranchCompanyId, branchCompanyId)
               .eq(contractWasteId != null, ProjectWasteProductChild::getContractWasteId, contractWasteId)
               .eq(useProjectId != null, ProjectWasteProductChild::getUseProjectId, useProjectId)
               .orderByDesc(ProjectWasteProductChild::getId)
         );
      if (productChildList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, String> mainIdSnMap = this.wasteProductMainService
         .listByIds(productChildList.stream().map(ProjectWasteProductChild::getMainId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(ProjectWasteProductMain::getId, ProjectWasteProductMain::getSerialNumber));
      Map<Long, ProjectReturnProductChild> returnChildMap = this.returnProductChildService
         .listByIds(productChildList.stream().map(ProjectWasteProductChild::getMesBuildingReturnWarehouseRecordId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(ProjectReturnProductChild::getId, Function.identity()));
      Map<Integer, List<Long>> productTypeProductIdsMap = productChildList.stream()
         .collect(
            Collectors.groupingBy(ProjectWasteProductChild::getProductType, Collectors.mapping(ProjectWasteProductChild::getProductId, Collectors.toList()))
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
      List<ContractReturnProductDTO> dtoList = new ArrayList<>(productChildList.size());
      productChildList.forEach(
         wasteChild -> {
            ProjectReturnProductChild returnChild = returnChildMap.get(wasteChild.getMesBuildingReturnWarehouseRecordId());
            ContractReturnProductDTO dto = BeanUtil.copy(wasteChild, ContractReturnProductDTO.class);
            dto.setHandleSerialNumber(mainIdSnMap.get(wasteChild.getMainId()));
            dto.setPricingManner(returnChild.getPricingManner());
            dto.setUnitPrice(returnChild.getUnitPrice());
            if (wasteChild.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               TechArtifact artifact = artifactMap.get(wasteChild.getProductId());
               dto.setName(artifact.getName());
               dto.setSerialNumber(artifact.getSerialNumber());
               dto.setSpecification(artifact.getSpecification());
               dto.setMaterial(artifact.getMaterial());
               dto.setLength(artifact.getLength().divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
               dto.setMeasureUnit("件");
               dto.setMete(artifact.getNetWeight().multiply(wasteChild.getQuantity()).divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
               dto.setAccountingUnit("吨");
               dto.setTotalAmount(
                  artifact.getNetWeight()
                     .multiply(wasteChild.getQuantity())
                     .multiply(returnChild.getUnitPrice())
                     .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP)
               );
            }

            if (wasteChild.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
               TechEnclosure enclosure = enclosureMap.get(wasteChild.getProductId());
               dto.setName(enclosure.getName());
               dto.setSerialNumber(enclosure.getSerialNumber());
               dto.setSpecification(enclosure.getPlate());
               dto.setMaterial(enclosure.getMaterial());
               dto.setLength(enclosure.getLength().divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
               dto.setMeasureUnit("张");
               if (returnChild.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())) {
                  dto.setMete(enclosure.getLength().multiply(wasteChild.getQuantity()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
                  dto.setAccountingUnit("米");
                  dto.setTotalAmount(
                     enclosure.getLength()
                        .multiply(wasteChild.getQuantity())
                        .multiply(returnChild.getUnitPrice())
                        .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP)
                  );
               } else {
                  dto.setMete(
                     enclosure.getSurfaceArea()
                        .multiply(wasteChild.getQuantity())
                        .multiply(returnChild.getUnitPrice())
                        .divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP)
                  );
                  dto.setAccountingUnit("平方米");
               }
            }

            if (wasteChild.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
               TechStandardPart standardPart = standardPartMap.get(wasteChild.getProductId());
               dto.setName(standardPart.getName());
               dto.setSpecification(standardPart.getSpecification());
               dto.setMeasureUnit(standardPart.getMeasureUnit());
               dto.setAccountingUnit(standardPart.getAccountingUnit());
               dto.setTotalAmount(
                  standardPart.getMete()
                     .multiply(wasteChild.getQuantity())
                     .multiply(returnChild.getUnitPrice())
                     .divide(standardPart.getQuantity(), 2, RoundingMode.HALF_UP)
               );
            }

            dtoList.add(dto);
         }
      );
      return dtoList;
   }

   @Override
   public PrintVO<List<ContractReturnProductDTO>> printListWasteProduct(
      Long branchCompanyId, Long contractWasteId, Long useProjectId, Integer wasteHandleMethod
   ) {
      PrintVO<List<ContractReturnProductDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (branchCompanyId != null) {
         BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
         header.put("branchCompanyName", branchCompany.getName());
      }

      if (contractWasteId != null) {
         ContractWaste contractWaste = this.contractWasteService.getById(contractWasteId);
         header.put("purchaser", contractWaste.getPurchaser());
      }

      if (useProjectId != null) {
         header.put("project", this.projectService.getSimpleById(useProjectId));
         header.put("title", "废品二次利用费用");
      }

      printVO.setHeader(header);
      List<ContractReturnProductDTO> productList = this.getWasteProductList(branchCompanyId, contractWasteId, useProjectId, wasteHandleMethod);
      printVO.setTable(productList);
      return printVO;
   }

   public ContractScrapSaleLedgerBizImpl(
      final BranchCompanyService branchCompanyService,
      final ContractWasteService contractWasteService,
      final ContractProjectService projectService,
      final ProjectWasteProductMainService wasteProductMainService,
      final ProjectWasteProductChildService wasteProductChildService,
      final ProjectReturnProductChildService returnProductChildService,
      final ContractCollectionService collectionService,
      final ContractInvoiceService invoiceService,
      final TechArtifactService artifactService,
      final TechEnclosureService enclosureService,
      final TechStandardPartService standardPartService
   ) {
      this.branchCompanyService = branchCompanyService;
      this.contractWasteService = contractWasteService;
      this.projectService = projectService;
      this.wasteProductMainService = wasteProductMainService;
      this.wasteProductChildService = wasteProductChildService;
      this.returnProductChildService = returnProductChildService;
      this.collectionService = collectionService;
      this.invoiceService = invoiceService;
      this.artifactService = artifactService;
      this.enclosureService = enclosureService;
      this.standardPartService = standardPartService;
   }
}
