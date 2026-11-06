package com.hzchum.scim.business.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.scim.business.core.api.biz.BusinessProjectTrackingBiz;
import com.hzchum.scim.business.core.api.enums.NewPricingMannerEnum;
import com.hzchum.scim.business.core.api.enums.PricingUnitTypeEnum;
import com.hzchum.scim.business.core.api.enums.PricingWeightTypeEnum;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceDetail;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessProjectInfoDTO;
import com.hzchum.scim.business.core.api.pojo.dto.ShipmentInfoDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessShipListQueryParam;
import com.hzchum.scim.business.core.api.service.BusinessPriceDetailService;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReturnProductStatusEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.enums.StructureMeasureModeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCollection;
import com.hzchum.scim.contract.core.api.pojo._do.ContractInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceV2DTO;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractInvoiceService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.ShipmentStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductLink;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.enclosure.core.api.enums.cargoList.CargoListStatusEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
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
import com.hzchum.scim.project.core.api.service.ProjectReturnProductChildService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class BusinessProjectTrackingBizImpl implements BusinessProjectTrackingBiz {
   @Resource
   private ProjectBranchCompanyLinkService projectBranchCompanyLinkService;
   private final AttachmentService attachmentService;
   private final ContractProjectService projectService;
   private final PlanMonomerService monomerService;
   private final PlanAreaService areaService;
   private final EnclosurePlanService enclosurePlanService;
   private final TechArtifactService artifactService;
   private final TechEnclosureService enclosureService;
   private final TechStandardPartService standardPartService;
   private final ContractCollectionService contractCollectionService;
   private final ContractInvoiceService contractInvoiceService;
   private final MesBuildingCargoListService cargoListService;
   private final MesBuildingCargoListProductLinkService cargoListProductLinkService;
   private final BusinessPriceDetailService businessPriceDetailService;
   private final ProjectReturnProductChildService returnProductChildService;

   private void checkProjectUnit(Long projectId, Long branchCompanyId) {
      Preconditions.checkArgument(projectId != null && branchCompanyId != null, "项目和单位不能为空!");
      Preconditions.checkArgument(this.projectBranchCompanyLinkService.count(Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
         .eq(ProjectBranchCompanyLink::getProjectId, projectId).eq(ProjectBranchCompanyLink::getBranchCompanyId, branchCompanyId)) > 0,
         "单位不属于当前项目!请刷新页面重试!");
   }

   @Override
   public BusinessProjectInfoDTO getOrderTrackingProjectInfo(Long projectId, Long branchCompanyId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      this.checkProjectUnit(projectId, branchCompanyId);
      BusinessProjectInfoDTO projectInfoDTO = BeanUtil.copy(project, BusinessProjectInfoDTO.class);
      if (project.getSigningDate() == null) {
         projectInfoDTO.setSigningDate(project.getCreateTime().toLocalDate());
      }

      LocalDate localDate = LocalDate.now();
      LocalDate lastLocalDate = localDate.minusMonths(1L);
      List<ContractCollection> collectionList = this.contractCollectionService.listCollectionLedger(projectId, branchCompanyId);
      BigDecimal collectionAmount = collectionList.stream().map(ContractCollection::getCollectionAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal thisMonthCollectionAmount = collectionList.stream()
         .filter(c -> c.getCollectionDate().getMonthValue() == localDate.getMonthValue() && c.getCollectionDate().getYear() == localDate.getYear())
         .map(ContractCollection::getCollectionAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal lastMonthCollectionAmount = collectionList.stream()
         .filter(c -> c.getCollectionDate().getMonthValue() == lastLocalDate.getMonthValue() && c.getCollectionDate().getYear() == lastLocalDate.getYear())
         .map(ContractCollection::getCollectionAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      List<ContractInvoice> invoiceList = this.contractInvoiceService.listPageLedger(projectId, branchCompanyId);
      BigDecimal invoiceAmount = invoiceList.stream().map(ContractInvoice::getActualInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal thisMonthInvoiceAmount = invoiceList.stream()
         .filter(c -> c.getInvoiceDate().getMonthValue() == localDate.getMonthValue() && c.getInvoiceDate().getYear() == localDate.getYear())
         .map(ContractInvoice::getActualInvoiceAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal lastMonthInvoiceAmount = invoiceList.stream()
         .filter(c -> c.getInvoiceDate().getMonthValue() == lastLocalDate.getMonthValue() && c.getInvoiceDate().getYear() == lastLocalDate.getYear())
         .map(ContractInvoice::getActualInvoiceAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BusinessShipListQueryParam param = BusinessShipListQueryParam.builder().projectId(projectId).branchCompanyId(branchCompanyId).build();
      List<ShipmentInfoDTO> shipList = this.projectShipList(param);
      BigDecimal shipAmount = shipList.stream().map(ShipmentInfoDTO::getTotalPrice).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal thisMonthShipAmount = shipList.stream()
         .filter(s -> s.getAuditTime().getYear() == localDate.getYear() && s.getAuditTime().getMonthValue() == localDate.getMonthValue())
         .map(ShipmentInfoDTO::getTotalPrice)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal lastMonthShipAmount = shipList.stream()
         .filter(s -> s.getAuditTime().getYear() == lastLocalDate.getYear() && s.getAuditTime().getMonthValue() == lastLocalDate.getMonthValue())
         .map(ShipmentInfoDTO::getTotalPrice)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      projectInfoDTO.setCollectionAmount(collectionAmount);
      projectInfoDTO.setLastMonthCollectionAmount(lastMonthCollectionAmount);
      projectInfoDTO.setThisMonthCollectionAmount(thisMonthCollectionAmount);
      projectInfoDTO.setInvoiceAmount(invoiceAmount);
      projectInfoDTO.setLastMonthInvoiceAmount(lastMonthInvoiceAmount);
      projectInfoDTO.setThisMonthInvoiceAmount(thisMonthInvoiceAmount);
      projectInfoDTO.setShipAmount(shipAmount);
      projectInfoDTO.setLastMonthShipAmount(lastMonthShipAmount);
      projectInfoDTO.setThisMonthShipAmount(thisMonthShipAmount);
      return projectInfoDTO;
   }

   @Override
   public PageVO<ContractCollectionV2DTO> projectCollectionList(Long projectId, Long branchCompanyId, Integer monthType, Integer pageNumber, Integer pageSize) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      List<ContractCollectionV2DTO> projectCollectionList = this.getProjectCollectionList(projectId, branchCompanyId, monthType);
      return PageUtil.listPage(pageNumber, pageSize, projectCollectionList);
   }

   private List<ContractCollectionV2DTO> getProjectCollectionList(Long projectId, Long branchCompanyId, Integer monthType) {
      this.checkProjectUnit(projectId, branchCompanyId);
      List<ContractCollection> collectionList = this.contractCollectionService.listCollectionLedger(projectId, branchCompanyId);
      LocalDate localDate = LocalDate.now();
      Integer monthValue = null;
      Integer yearValue = null;
      if (monthType != null) {
         monthValue = monthType == 1 ? localDate.getMonthValue() : localDate.minusMonths(1L).getMonthValue();
         yearValue = monthType == 1 ? localDate.getYear() : localDate.minusMonths(1L).getYear();
      }

      Integer finalMonthValue = monthValue;
      Integer finalYearValue = yearValue;
      return collectionList.stream()
         .filter(c -> monthType == null || c.getCollectionDate().getMonthValue() == finalMonthValue && c.getCollectionDate().getYear() == finalYearValue)
         .map(c -> {
            ContractCollectionV2DTO collectionV2DTO = BeanUtil.copy(c, ContractCollectionV2DTO.class);
            String attachmentIds = StringUtils.isNotBlank(c.getAttachmentIds()) ? c.getAttachmentIds() : c.getAccessoryId();
            collectionV2DTO.setAttachments(this.attachmentService.listByIds(attachmentIds));
            return collectionV2DTO;
         })
         .collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<ContractCollectionV2DTO>> projectCollectionListPrint(Long projectId, Long branchCompanyId, Integer monthType) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      List<ContractCollectionV2DTO> projectCollectionList = this.getProjectCollectionList(projectId, branchCompanyId, monthType);
      PrintVO<List<ContractCollectionV2DTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put(
         "project",
         ProjectInfo.builder().id(project.getId()).name(project.getName()).shortName(project.getShortName()).serialNumber(project.getSerialNumber()).build()
      );
      printVO.setHeader(header);
      printVO.setTable(projectCollectionList);
      return printVO;
   }

   @Override
   public PageVO<ContractInvoiceV2DTO> projectInvoiceList(Long projectId, Long branchCompanyId, Integer monthType, Integer pageNumber, Integer pageSize) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      List<ContractInvoiceV2DTO> invoiceV2DTOList = this.getProjectInvoiceList(projectId, branchCompanyId, monthType);
      return PageUtil.listPage(pageNumber, pageSize, invoiceV2DTOList);
   }

   private List<ContractInvoiceV2DTO> getProjectInvoiceList(Long projectId, Long branchCompanyId, Integer monthType) {
      this.checkProjectUnit(projectId, branchCompanyId);
      List<ContractInvoice> contractInvoiceList = this.contractInvoiceService.listPageLedger(projectId, branchCompanyId);
      LocalDate localDate = LocalDate.now();
      Integer monthValue = null;
      Integer yearValue = null;
      if (monthType != null) {
         monthValue = monthType == 1 ? localDate.getMonthValue() : localDate.minusMonths(1L).getMonthValue();
         yearValue = monthType == 1 ? localDate.getYear() : localDate.minusMonths(1L).getYear();
      }

      Integer finalMonthValue = monthValue;
      Integer finalYearValue = yearValue;
      return contractInvoiceList.stream()
         .filter(c -> monthType == null || c.getInvoiceDate().getMonthValue() == finalMonthValue && c.getInvoiceDate().getYear() == finalYearValue)
         .map(c -> {
            ContractInvoiceV2DTO invoiceV2DTO = BeanUtil.copy(c, ContractInvoiceV2DTO.class);
            invoiceV2DTO.setAttachments(this.attachmentService.listByIds(c.getAttachments()));
            return invoiceV2DTO;
         })
         .collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<ContractInvoiceV2DTO>> projectInvoiceListPrint(Long projectId, Long branchCompanyId, Integer monthType) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      List<ContractInvoiceV2DTO> invoiceV2DTOList = this.getProjectInvoiceList(projectId, branchCompanyId, monthType);
      PrintVO<List<ContractInvoiceV2DTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put(
         "project",
         ProjectInfo.builder().id(project.getId()).name(project.getName()).shortName(project.getShortName()).serialNumber(project.getSerialNumber()).build()
      );
      printVO.setHeader(header);
      printVO.setTable(invoiceV2DTOList);
      return printVO;
   }

   @Override
   public PageVO<ShipmentInfoDTO> projectShipPageList(BusinessShipListQueryParam param, Integer pageNumber, Integer pageSize) {
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在!");
      List<ShipmentInfoDTO> shipmentInfoDTOList = this.projectShipList(param);
      if (param.getMonthType() != null) {
         LocalDate localDate = LocalDate.now();
         int monthValue = param.getMonthType() == 1 ? localDate.getMonthValue() : localDate.minusMonths(1L).getMonthValue();
         int yearValue = param.getMonthType() == 1 ? localDate.getYear() : localDate.minusMonths(1L).getYear();
         shipmentInfoDTOList = shipmentInfoDTOList.stream()
            .filter(s -> param.getMonthType() == null || s.getAuditTime().getYear() == yearValue && s.getAuditTime().getMonthValue() == monthValue)
            .collect(Collectors.toList());
      }

      return PageUtil.listPage(pageNumber, pageSize, shipmentInfoDTOList);
   }

   @Override
   public PrintVO<List<ShipmentInfoDTO>> projectShipPageListPrint(BusinessShipListQueryParam param) {
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在!");
      List<ShipmentInfoDTO> shipmentInfoDTOList = this.projectShipList(param);
      if (param.getMonthType() != null) {
         LocalDate localDate = LocalDate.now();
         int monthValue = param.getMonthType() == 1 ? localDate.getMonthValue() : localDate.minusMonths(1L).getMonthValue();
         int yearValue = param.getMonthType() == 1 ? localDate.getYear() : localDate.minusMonths(1L).getYear();
         shipmentInfoDTOList = shipmentInfoDTOList.stream()
            .filter(s -> param.getMonthType() == null || s.getAuditTime().getYear() == yearValue && s.getAuditTime().getMonthValue() == monthValue)
            .collect(Collectors.toList());
      }

      PrintVO<List<ShipmentInfoDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put(
         "project",
         ProjectInfo.builder().id(project.getId()).name(project.getName()).shortName(project.getShortName()).serialNumber(project.getSerialNumber()).build()
      );
      printVO.setHeader(header);
      printVO.setTable(shipmentInfoDTOList);
      return printVO;
   }

   private List<ShipmentInfoDTO> projectShipList(BusinessShipListQueryParam param) {
      this.checkProjectUnit(param.getProjectId(), param.getBranchCompanyId());
      List<MesBuildingCargoList> cargoListList = this.cargoListService
         .list(
            Wrappers.lambdaQuery(MesBuildingCargoList.class)
               .eq(MesBuildingCargoList::getProjectId, param.getProjectId())
               .in(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType(), CargoListStatusEnum.RECEIPT.getType())
               .eq(MesBuildingCargoList::getDeliveryStatus, ShipmentStatusEnum.DELIVERY.getType())
               .apply(param.getProductType() != null, "product_type & {0} > 0", param.getProductType())
         );
      if (cargoListList.isEmpty()) {
         return Collections.emptyList();
      }

      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在!");
      Map<Long, MesBuildingCargoList> cargoListMap = cargoListList.stream().collect(Collectors.toMap(MesBuildingCargoList::getId, Function.identity()));
      List<MesBuildingCargoListProductLink> cargoListProductLinkList = this.cargoListProductLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingCargoListProductLink.class)
               .in(MesBuildingCargoListProductLink::getCargoListId, cargoListMap.keySet())
               .in(
                  MesBuildingCargoListProductLink::getProductType,
                  ProductTypeEnum.ARTIFACT.getType(),
                  ProductTypeEnum.ENCLOSURE.getType(),
                  ProductTypeEnum.AUXILIARY_MATERIAL.getType()
               )
               .eq(param.getProductType() != null, MesBuildingCargoListProductLink::getProductType, param.getProductType())
               .ne(MesBuildingCargoListProductLink::getWarehouseType, WarehouseTypeProductReturnEnum.REPAIR.getType())
               .orderByDesc(MesBuildingCargoListProductLink::getId)
         );
      Map<Long, Long> linkIdReturnCountMap = new HashMap<>(cargoListProductLinkList.size());
      if (CollectionUtils.isNotEmpty(cargoListProductLinkList)) {
         Set<Long> linkIds = cargoListProductLinkList.stream().map(MesBuildingCargoListProductLink::getId).collect(Collectors.toSet());
         Map<Long, Long> collect = this.returnProductChildService
            .list(
               Wrappers.lambdaQuery(ProjectReturnProductChild.class)
                  .eq(ProjectReturnProductChild::getStatus, ReturnProductStatusEnum.SHIPPED.getType())
                  .eq(ProjectReturnProductChild::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                  .eq(param.getHandleMethod() != null, ProjectReturnProductChild::getHandleMethod, param.getHandleMethod())
                  .in(ProjectReturnProductChild::getCargoLinkId, linkIds)
            )
            .stream()
            .collect(Collectors.groupingBy(ProjectReturnProductChild::getCargoLinkId, Collectors.counting()));
         linkIdReturnCountMap.putAll(collect);
         if (param.getHandleMethod() != null) {
            cargoListProductLinkList = cargoListProductLinkList.stream().filter(link -> collect.containsKey(link.getId())).collect(Collectors.toList());
         }
      }

      if (cargoListProductLinkList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Integer, Set<Long>> productTypeProductIdsMap = cargoListProductLinkList.stream()
         .collect(
            Collectors.groupingBy(
               MesBuildingCargoListProductLink::getProductType, Collectors.mapping(MesBuildingCargoListProductLink::getProductId, Collectors.toSet())
            )
         );
      Map<Long, TechArtifact> artifactMap = new HashMap<>(
         productTypeProductIdsMap.getOrDefault(ProductTypeEnum.ARTIFACT.getType(), Collections.emptySet()).size() * 2
      );
      Map<Long, TechEnclosure> enclosureMap = new HashMap<>(
         productTypeProductIdsMap.getOrDefault(ProductTypeEnum.ENCLOSURE.getType(), Collections.emptySet()).size() * 2
      );
      Map<Long, TechStandardPart> standardPartMap = new HashMap<>(
         productTypeProductIdsMap.getOrDefault(ProductTypeEnum.AUXILIARY_MATERIAL.getType(), Collections.emptySet()).size() * 2
      );
      productTypeProductIdsMap.forEach(
         (productType, productIdsx) -> {
            if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
               artifactMap.putAll(
                  this.artifactService
                     .listByIds(productIdsx)
                     .stream()
                     .filter(artifact -> param.getMonomerId() == null || artifact.getMonomerId().equals(param.getMonomerId()))
                     .filter(artifact -> param.getAreaId() == null || artifact.getAreaId().equals(param.getAreaId()))
                     .filter(artifact -> StringUtils.isBlank(param.getName()) || artifact.getName().contains(param.getName()))
                     .filter(artifact -> StringUtils.isBlank(param.getSerialNumber()) || artifact.getSerialNumber().contains(param.getSerialNumber()))
                     .filter(artifact -> StringUtils.isBlank(param.getSpecification()) || artifact.getSpecification().contains(param.getSpecification()))
                     .filter(artifact -> StringUtils.isBlank(param.getMaterial()) || artifact.getMaterial().contains(param.getMaterial()))
                     .collect(Collectors.toMap(TechArtifact::getId, Function.identity()))
               );
            }

            if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
               enclosureMap.putAll(
                  this.enclosureService
                     .listByIds(productIdsx)
                     .stream()
                     .filter(enclosure -> param.getCategory() == null || enclosure.getCategory().equals(param.getCategory()))
                     .filter(enclosure -> param.getEnclosurePlanId() == null || enclosure.getEnclosurePlanId().equals(param.getEnclosurePlanId()))
                     .filter(enclosure -> StringUtils.isBlank(param.getName()) || enclosure.getName().contains(param.getName()))
                     .filter(enclosure -> StringUtils.isBlank(param.getSerialNumber()) || enclosure.getSerialNumber().contains(param.getSerialNumber()))
                     .filter(enclosure -> StringUtils.isBlank(param.getSpecification()) || enclosure.getPlate().contains(param.getSpecification()))
                     .filter(enclosure -> StringUtils.isBlank(param.getMaterial()) || enclosure.getMaterial().contains(param.getMaterial()))
                     .collect(Collectors.toMap(TechEnclosure::getId, Function.identity()))
               );
            }

            if (productType.equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
               standardPartMap.putAll(
                  this.standardPartService
                     .listByIds(productIdsx)
                     .stream()
                     .filter(standardPart -> param.getMonomerId() == null || standardPart.getMonomerId().equals(param.getMonomerId()))
                     .filter(standardPart -> param.getAreaId() == null || standardPart.getAreaId().equals(param.getAreaId()))
                     .filter(standardPart -> StringUtils.isBlank(param.getName()) || standardPart.getName().contains(param.getName()))
                     .filter(standardPart -> StringUtils.isBlank(param.getSerialNumber()) || standardPart.getSerialNumber().contains(param.getSerialNumber()))
                     .filter(
                        standardPart -> StringUtils.isBlank(param.getSpecification()) || standardPart.getSpecification().contains(param.getSpecification())
                     )
                     .collect(Collectors.toMap(TechStandardPart::getId, Function.identity()))
               );
            }
         }
      );
      cargoListProductLinkList = cargoListProductLinkList.stream().filter(link -> {
         if (link.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            return artifactMap.containsKey(link.getProductId());
         } else if (link.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            return enclosureMap.containsKey(link.getProductId());
         } else {
            return link.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType()) ? standardPartMap.containsKey(link.getProductId()) : true;
         }
      }).collect(Collectors.toList());
      if (cargoListProductLinkList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, NameInfo> monomerMap = this.monomerService
         .list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, param.getProjectId()))
         .stream()
         .map(m -> NameInfo.builder().id(m.getId()).name(m.getName()).build())
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      Map<Long, NameInfo> areaMap = this.areaService
         .list(Wrappers.lambdaQuery(PlanArea.class).eq(PlanArea::getProjectId, param.getProjectId()))
         .stream()
         .map(m -> NameInfo.builder().id(m.getId()).name(m.getName()).build())
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      Set<Integer> productTypeList = cargoListProductLinkList.stream().map(MesBuildingCargoListProductLink::getProductType).collect(Collectors.toSet());
      Set<Long> productIds = cargoListProductLinkList.stream().map(MesBuildingCargoListProductLink::getProductId).collect(Collectors.toSet());
      List<BusinessPriceDetail> businessPriceDetailList = this.businessPriceDetailService
         .list(
            Wrappers.lambdaQuery(BusinessPriceDetail.class)
               .eq(BusinessPriceDetail::getProjectId, param.getProjectId())
               .eq(BusinessPriceDetail::getBranchCompanyId, param.getBranchCompanyId())
               .in(BusinessPriceDetail::getProductType, productTypeList)
               .in(BusinessPriceDetail::getProductId, productIds)
               .eq(BusinessPriceDetail::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .orderByAsc(BusinessPriceDetail::getId)
         );
      Map<Integer, Map<Long, List<BusinessPriceDetail>>> productTypeProductIdPriceDetailMap = businessPriceDetailList.stream()
         .collect(Collectors.groupingBy(BusinessPriceDetail::getProductType, Collectors.groupingBy(BusinessPriceDetail::getProductId)));
      Map<Integer, Map<Long, List<MesBuildingCargoListProductLink>>> productTypeProductIdLinkListMap = cargoListProductLinkList.stream()
         .collect(Collectors.groupingBy(MesBuildingCargoListProductLink::getProductType, Collectors.groupingBy(MesBuildingCargoListProductLink::getProductId)));
      List<ShipmentInfoDTO> shipmentInfoDTOList = new ArrayList<>(cargoListProductLinkList.stream().mapToInt(s -> s.getQuantity().intValue()).sum() * 2);
      productTypeProductIdLinkListMap.forEach(
         (productType, productIdLinkListMap) -> {
            Map<Long, List<BusinessPriceDetail>> productIdPriceDetailsMap = productTypeProductIdPriceDetailMap.getOrDefault(productType, Collections.emptyMap());
            productIdLinkListMap.forEach(
               (productId, linkList) -> {
                  List<BusinessPriceDetail> businessPriceDetails = productIdPriceDetailsMap.getOrDefault(productId, Collections.emptyList());
                  businessPriceDetails = businessPriceDetails.stream()
                     .sorted(Comparator.comparing(BusinessPriceDetail::getBusinessPriceId).thenComparing(BusinessPriceDetail::getId))
                     .collect(Collectors.toList());
                  if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
                     TechArtifact artifact = artifactMap.get(productId);
                     NameInfo monomer = monomerMap.get(artifact.getMonomerId());
                     NameInfo area = areaMap.get(artifact.getAreaId());
                     List<ShipmentInfoDTO> shipmentInfoDTOS = this.setArtifactPrice(
                        artifact,
                        project.getStructureMeasureMode(),
                        monomer,
                        area,
                        cargoListMap,
                        (List<MesBuildingCargoListProductLink>)linkList,
                        businessPriceDetails
                     );
                     shipmentInfoDTOList.addAll(shipmentInfoDTOS);
                  }

                  if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
                     TechEnclosure enclosure = enclosureMap.get(productId);
                     NameInfo monomer = monomerMap.get(enclosure.getMonomerId());
                     NameInfo area = areaMap.get(enclosure.getAreaId());
                     List<ShipmentInfoDTO> shipmentInfoDTOS = this.setEnclosurePrice(
                        enclosure, monomer, area, cargoListMap, (List<MesBuildingCargoListProductLink>)linkList, businessPriceDetails
                     );
                     shipmentInfoDTOList.addAll(shipmentInfoDTOS);
                  }

                  if (productType.equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
                     TechStandardPart standardPart = standardPartMap.get(productId);
                     NameInfo monomer = monomerMap.get(standardPart.getMonomerId());
                     NameInfo area = areaMap.get(standardPart.getAreaId());
                     List<ShipmentInfoDTO> shipmentInfoDTOS = this.setStandardPartPrice(
                        standardPart, monomer, area, cargoListMap, (List<MesBuildingCargoListProductLink>)linkList, businessPriceDetails
                     );
                     shipmentInfoDTOList.addAll(shipmentInfoDTOS);
                  }
               }
            );
         }
      );
      Map<String, List<ShipmentInfoDTO>> collect = shipmentInfoDTOList.stream()
         .collect(
            Collectors.groupingBy(
               s -> s.getCargoListProductLinkId()
                  + "_"
                  + s.getPricingMannerEnum()
                  + "_"
                  + s.getPricingUnitTypeEnum()
                  + "_"
                  + s.getPricingWeightTypeEnum()
                  + "_"
                  + (s.getUnitPrice() != null ? s.getUnitPrice() : 0)
            )
         );
      List<ShipmentInfoDTO> resultList = new ArrayList<>(cargoListProductLinkList.size() * 2);
      collect.forEach(
         (key, list) -> {
            ShipmentInfoDTO shipmentInfoDTO = list.get(0);
            shipmentInfoDTO.setBoolExistReturn(linkIdReturnCountMap.getOrDefault(shipmentInfoDTO.getCargoListProductLinkId(), 0L) > 0L);
            shipmentInfoDTO.setQuantity(list.stream().map(ShipmentInfoDTO::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add));
            shipmentInfoDTO.setTotalMete(
               shipmentInfoDTO.getTotalMete() == null ? null : list.stream().map(ShipmentInfoDTO::getTotalMete).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            shipmentInfoDTO.setTotalPrice(
               shipmentInfoDTO.getTotalPrice() == null ? null : list.stream().map(ShipmentInfoDTO::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            resultList.add(shipmentInfoDTO);
         }
      );
      return resultList.stream()
         .sorted(Comparator.comparing(ShipmentInfoDTO::getCargoListProductLinkId).reversed().thenComparing(ShipmentInfoDTO::getPricingMannerEnum))
         .collect(Collectors.toList());
   }

   private List<ShipmentInfoDTO> setArtifactPrice(
      TechArtifact artifact,
      Integer structureMeasureMode,
      NameInfo monomer,
      NameInfo area,
      Map<Long, MesBuildingCargoList> cargoListMap,
      List<MesBuildingCargoListProductLink> linkList,
      List<BusinessPriceDetail> businessPriceDetails
   ) {
      int sum = linkList.stream().mapToInt(s -> s.getQuantity().intValue()).sum();
      List<ShipmentInfoDTO> shipmentInfoDTOList = new ArrayList<>(sum * 2);
      List<BusinessPriceDetail> newPriceDetailList = this.getNewPriceDetail(businessPriceDetails);
      linkList.forEach(
         link -> {
            MesBuildingCargoList cargoList = cargoListMap.get(link.getCargoListId());

            for (int i = 0; i < link.getQuantity().intValue(); i++) {
               ShipmentInfoDTO shipmentInfoDTO = ShipmentInfoDTO.builder()
                  .monomer(monomer)
                  .area(area)
                  .productType(link.getProductType())
                  .productId(link.getProductId())
                  .cargoListId(link.getCargoListId())
                  .cargoListProductLinkId(link.getId())
                  .name(artifact.getName())
                  .serialNumber(artifact.getSerialNumber())
                  .specification(artifact.getSpecification())
                  .material(artifact.getMaterial())
                  .length(artifact.getLength())
                  .measure("件")
                  .quantity(BigDecimal.ONE)
                  .licensePlate(cargoList.getLicensePlate())
                  .auditTime(cargoList.getAuditTime())
                  .boolAllPartSendDirectly(artifact.getBoolAllPartSendDirectly())
                  .pricingMannerEnum(0)
                  .pricingUnitTypeEnum(0)
                  .pricingWeightTypeEnum(0)
                  .build();
               if (!newPriceDetailList.isEmpty()) {
                  BusinessPriceDetail priceDetail = newPriceDetailList.get(0);
                  shipmentInfoDTO.setPricingMannerEnum(priceDetail.getPricingMannerEnum());
                  shipmentInfoDTO.setPricingUnitTypeEnum(priceDetail.getPricingUnitTypeEnum());
                  shipmentInfoDTO.setPricingWeightTypeEnum(priceDetail.getPricingWeightTypeEnum());
                  shipmentInfoDTO.setNuclear(PricingUnitTypeEnum.getNameByType(priceDetail.getPricingUnitTypeEnum()));
                  shipmentInfoDTO.setUnitPrice(priceDetail.getUnitPrice());
                  if (StructureMeasureModeEnum.POUND.getType().equals(structureMeasureMode)) {
                     BigDecimal totalMete = priceDetail.getPricingUnitTypeEnum().equals(PricingUnitTypeEnum.KG.getType())
                        ? link.getWeight()
                        : link.getWeight().divide(BigDecimal.valueOf(1000L), 16, RoundingMode.HALF_UP);
                     shipmentInfoDTO.setTotalMete(totalMete);
                     shipmentInfoDTO.setTotalPrice(totalMete.multiply(priceDetail.getUnitPrice()));
                  } else if (priceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.WEIGHT.getType())) {
                     BigDecimal singleWeight = priceDetail.getPricingWeightTypeEnum().equals(PricingWeightTypeEnum.NET_WEIGHT.getType())
                        ? artifact.getNetWeight()
                        : (
                           priceDetail.getPricingWeightTypeEnum().equals(PricingWeightTypeEnum.GROSS_WEIGHT.getType())
                              ? artifact.getGrossWeight()
                              : artifact.getDrawingWeight()
                        );
                     BigDecimal totalMete = priceDetail.getPricingUnitTypeEnum().equals(PricingUnitTypeEnum.KG.getType())
                        ? singleWeight
                        : singleWeight.divide(BigDecimal.valueOf(1000L), 16, RoundingMode.HALF_UP);
                     shipmentInfoDTO.setTotalMete(totalMete);
                     shipmentInfoDTO.setTotalPrice(totalMete.multiply(priceDetail.getUnitPrice()));
                  } else if (priceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.LENGTH.getType())) {
                     shipmentInfoDTO.setTotalMete(artifact.getLength().divide(BigDecimal.valueOf(1000L), 16, RoundingMode.HALF_UP));
                     shipmentInfoDTO.setTotalPrice(
                        artifact.getLength().multiply(priceDetail.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP)
                     );
                  } else if (priceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.QUANTITY.getType())) {
                     shipmentInfoDTO.setTotalMete(BigDecimal.ONE);
                     shipmentInfoDTO.setTotalPrice(priceDetail.getUnitPrice());
                  }

                  newPriceDetailList.remove(0);
               }

               shipmentInfoDTOList.add(shipmentInfoDTO);
            }
         }
      );
      return shipmentInfoDTOList;
   }

   private List<ShipmentInfoDTO> setEnclosurePrice(
      TechEnclosure enclosure,
      NameInfo monomer,
      NameInfo area,
      Map<Long, MesBuildingCargoList> cargoListMap,
      List<MesBuildingCargoListProductLink> linkList,
      List<BusinessPriceDetail> businessPriceDetails
   ) {
      int sum = linkList.stream().mapToInt(s -> s.getQuantity().intValue()).sum();
      List<ShipmentInfoDTO> shipmentInfoDTOList = new ArrayList<>(sum * 2);
      List<BusinessPriceDetail> newPriceDetailList = this.getNewPriceDetail(businessPriceDetails);
      linkList.forEach(
         link -> {
            MesBuildingCargoList cargoList = cargoListMap.get(link.getCargoListId());

            for (int i = 0; i < link.getQuantity().intValue(); i++) {
               ShipmentInfoDTO shipmentInfoDTO = ShipmentInfoDTO.builder()
                  .monomer(monomer)
                  .area(area)
                  .productType(link.getProductType())
                  .productId(link.getProductId())
                  .cargoListId(link.getCargoListId())
                  .cargoListProductLinkId(link.getId())
                  .name(enclosure.getName())
                  .serialNumber(enclosure.getSerialNumber())
                  .specification(enclosure.getPlate())
                  .material(enclosure.getMaterial())
                  .length(enclosure.getLength())
                  .measure("张")
                  .quantity(BigDecimal.ONE)
                  .licensePlate(cargoList.getLicensePlate())
                  .auditTime(cargoList.getAuditTime())
                  .pricingMannerEnum(0)
                  .pricingUnitTypeEnum(0)
                  .pricingWeightTypeEnum(0)
                  .build();
               if (!newPriceDetailList.isEmpty()) {
                  BusinessPriceDetail priceDetail = newPriceDetailList.get(0);
                  shipmentInfoDTO.setPricingMannerEnum(priceDetail.getPricingMannerEnum());
                  shipmentInfoDTO.setPricingUnitTypeEnum(priceDetail.getPricingUnitTypeEnum());
                  shipmentInfoDTO.setNuclear(PricingUnitTypeEnum.getNameByType(priceDetail.getPricingUnitTypeEnum()));
                  shipmentInfoDTO.setUnitPrice(priceDetail.getUnitPrice());
                  if (priceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.LENGTH.getType())) {
                     shipmentInfoDTO.setTotalMete(enclosure.getLength().divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP));
                     shipmentInfoDTO.setTotalPrice(
                        enclosure.getLength().multiply(priceDetail.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP)
                     );
                  } else if (priceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.AREA.getType())) {
                     shipmentInfoDTO.setTotalMete(enclosure.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP));
                     shipmentInfoDTO.setTotalPrice(
                        enclosure.getSurfaceArea().multiply(priceDetail.getUnitPrice()).divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP)
                     );
                  } else if (priceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.QUANTITY.getType())) {
                     shipmentInfoDTO.setTotalMete(BigDecimal.ONE);
                     shipmentInfoDTO.setTotalPrice(priceDetail.getUnitPrice());
                  } else if (priceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.WEIGHT.getType())) {
                     BigDecimal totalMete = priceDetail.getPricingUnitTypeEnum().equals(PricingUnitTypeEnum.KG.getType())
                        ? enclosure.getWeight()
                        : enclosure.getWeight().divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP);
                     shipmentInfoDTO.setTotalMete(totalMete);
                     shipmentInfoDTO.setTotalPrice(totalMete.multiply(priceDetail.getUnitPrice()));
                  }

                  newPriceDetailList.remove(0);
               }

               shipmentInfoDTOList.add(shipmentInfoDTO);
            }
         }
      );
      return shipmentInfoDTOList;
   }

   private List<ShipmentInfoDTO> setStandardPartPrice(
      TechStandardPart standardPart,
      NameInfo monomer,
      NameInfo area,
      Map<Long, MesBuildingCargoList> cargoListMap,
      List<MesBuildingCargoListProductLink> linkList,
      List<BusinessPriceDetail> businessPriceDetails
   ) {
      int sum = linkList.stream().mapToInt(s -> s.getQuantity().intValue()).sum();
      List<ShipmentInfoDTO> shipmentInfoDTOList = new ArrayList<>(sum * 2);
      Map<Long, BusinessPriceDetail> priceDetailIdMap = businessPriceDetails.stream()
         .collect(Collectors.toMap(BusinessPriceDetail::getId, Function.identity()));
      Map<Long, BigDecimal> priceDetailIdQuantityMap = new LinkedHashMap<>(businessPriceDetails.size());
      businessPriceDetails.forEach(priceDetail -> {
         BigDecimal var10000 = priceDetailIdQuantityMap.put(priceDetail.getId(), priceDetail.getQuantity());
      });
      linkList.forEach(link -> {
         MesBuildingCargoList cargoList = cargoListMap.get(link.getCargoListId());
         this.setStandardPartPrice(standardPart, monomer, area, link, cargoList, priceDetailIdMap, priceDetailIdQuantityMap, shipmentInfoDTOList);
      });
      return shipmentInfoDTOList;
   }

   private void setStandardPartPrice(
      TechStandardPart standardPart,
      NameInfo monomer,
      NameInfo area,
      MesBuildingCargoListProductLink link,
      MesBuildingCargoList cargoList,
      Map<Long, BusinessPriceDetail> priceDetailIdMap,
      Map<Long, BigDecimal> priceDetailIdQuantityMap,
      List<ShipmentInfoDTO> shipmentInfoDTOList
   ) {
      if (CollectionUtils.isNotEmpty(priceDetailIdQuantityMap)) {
         ShipmentInfoDTO shipmentInfoDTO = ShipmentInfoDTO.builder()
            .monomer(monomer)
            .area(area)
            .productType(link.getProductType())
            .productId(link.getProductId())
            .cargoListId(link.getCargoListId())
            .cargoListProductLinkId(link.getId())
            .name(standardPart.getName())
            .serialNumber(standardPart.getSerialNumber())
            .specification(standardPart.getSpecification())
            .measure(standardPart.getMeasureUnit())
            .nuclear(standardPart.getAccountingUnit())
            .totalMete(standardPart.getMete().multiply(link.getQuantity()).divide(standardPart.getQuantity(), 8, RoundingMode.HALF_UP))
            .licensePlate(cargoList.getLicensePlate())
            .auditTime(cargoList.getAuditTime())
            .pricingMannerEnum(0)
            .pricingUnitTypeEnum(0)
            .pricingWeightTypeEnum(0)
            .build();
         Long priceDetailId = priceDetailIdMap.keySet().iterator().next();
         BigDecimal priceDetailQuantity = priceDetailIdQuantityMap.get(priceDetailId);
         BusinessPriceDetail priceDetail = priceDetailIdMap.get(priceDetailId);
         shipmentInfoDTO.setUnitPrice(priceDetail.getUnitPrice());
         if (link.getQuantity().compareTo(priceDetailQuantity) >= 0) {
            shipmentInfoDTO.setQuantity(priceDetail.getQuantity());
            shipmentInfoDTO.setTotalPrice(
               priceDetail.getQuantity()
                  .multiply(standardPart.getMete())
                  .multiply(priceDetail.getUnitPrice())
                  .divide(standardPart.getQuantity(), 8, RoundingMode.HALF_UP)
            );
            shipmentInfoDTOList.add(shipmentInfoDTO);
            priceDetailIdQuantityMap.remove(priceDetailId);
            link.setQuantity(link.getQuantity().subtract(priceDetailQuantity));
            this.setStandardPartPrice(standardPart, monomer, area, link, cargoList, priceDetailIdMap, priceDetailIdQuantityMap, shipmentInfoDTOList);
         } else {
            shipmentInfoDTO.setQuantity(link.getQuantity());
            shipmentInfoDTO.setTotalPrice(
               link.getQuantity()
                  .multiply(standardPart.getMete())
                  .multiply(priceDetail.getUnitPrice())
                  .divide(standardPart.getQuantity(), 8, RoundingMode.HALF_UP)
            );
            priceDetailIdQuantityMap.put(priceDetailId, priceDetailQuantity.subtract(link.getQuantity()));
            shipmentInfoDTOList.add(shipmentInfoDTO);
         }
      } else {
         ShipmentInfoDTO shipmentInfoDTO = ShipmentInfoDTO.builder()
            .monomer(monomer)
            .area(area)
            .productType(link.getProductType())
            .productId(link.getProductId())
            .cargoListId(link.getCargoListId())
            .cargoListProductLinkId(link.getId())
            .name(standardPart.getName())
            .serialNumber(standardPart.getSerialNumber())
            .specification(standardPart.getSpecification())
            .quantity(link.getQuantity())
            .measure(standardPart.getMeasureUnit())
            .nuclear(standardPart.getAccountingUnit())
            .totalMete(standardPart.getMete().multiply(link.getQuantity()).divide(standardPart.getQuantity(), 8, RoundingMode.HALF_UP))
            .licensePlate(cargoList.getLicensePlate())
            .auditTime(cargoList.getAuditTime())
            .pricingMannerEnum(0)
            .pricingUnitTypeEnum(0)
            .pricingWeightTypeEnum(0)
            .build();
         shipmentInfoDTOList.add(shipmentInfoDTO);
      }
   }

   private List<BusinessPriceDetail> getNewPriceDetail(List<BusinessPriceDetail> businessPriceDetails) {
      List<BusinessPriceDetail> newBusinessPriceDetails = new LinkedList<>();
      businessPriceDetails.forEach(businessPriceDetail -> {
         Integer detailQuantity = businessPriceDetail.getQuantity().intValue();

         for (int i = 0; i < detailQuantity; i++) {
            BusinessPriceDetail newPriceDetail = BeanUtil.copy(businessPriceDetail, BusinessPriceDetail.class);
            newPriceDetail.setQuantity(BigDecimal.ONE);
            newBusinessPriceDetails.add(newPriceDetail);
         }
      });
      return newBusinessPriceDetails;
   }

   public BusinessProjectTrackingBizImpl(
      final AttachmentService attachmentService,
      final ContractProjectService projectService,
      final PlanMonomerService monomerService,
      final PlanAreaService areaService,
      final EnclosurePlanService enclosurePlanService,
      final TechArtifactService artifactService,
      final TechEnclosureService enclosureService,
      final TechStandardPartService standardPartService,
      final ContractCollectionService contractCollectionService,
      final ContractInvoiceService contractInvoiceService,
      final MesBuildingCargoListService cargoListService,
      final MesBuildingCargoListProductLinkService cargoListProductLinkService,
      final BusinessPriceDetailService businessPriceDetailService,
      final ProjectReturnProductChildService returnProductChildService
   ) {
      this.attachmentService = attachmentService;
      this.projectService = projectService;
      this.monomerService = monomerService;
      this.areaService = areaService;
      this.enclosurePlanService = enclosurePlanService;
      this.artifactService = artifactService;
      this.enclosureService = enclosureService;
      this.standardPartService = standardPartService;
      this.contractCollectionService = contractCollectionService;
      this.contractInvoiceService = contractInvoiceService;
      this.cargoListService = cargoListService;
      this.cargoListProductLinkService = cargoListProductLinkService;
      this.businessPriceDetailService = businessPriceDetailService;
      this.returnProductChildService = returnProductChildService;
   }
}
