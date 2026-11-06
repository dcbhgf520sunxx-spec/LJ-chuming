package com.hzchum.scim.business.core.utils;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.business.core.api.enums.NewPricingMannerEnum;
import com.hzchum.scim.business.core.api.enums.PricingUnitTypeEnum;
import com.hzchum.scim.business.core.api.enums.PricingWeightTypeEnum;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceDetail;
import com.hzchum.scim.business.core.api.service.BusinessPriceDetailService;
import com.hzchum.scim.business.core.api.utils.BusinessPriceUtils;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.BranchCompanyLevelEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.CargoListProductLinkPriceDTO;
import com.hzchum.scim.contract.core.api.enums.StructureMeasureModeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import org.springframework.stereotype.Component;

@Component
public class BusinessPriceUtilsImpl implements BusinessPriceUtils {
   private final ContractProjectService projectService;
   private final ProjectBranchCompanyLinkService projectBranchCompanyLinkService;
   private final TechArtifactService artifactService;
   private final TechEnclosureService enclosureService;
   private final TechStandardPartService standardPartService;
   private final MesBuildingCargoListService cargoListService;
   private final MesBuildingCargoListProductLinkService cargoListProductLinkService;
   private final BusinessPriceDetailService businessPriceDetailService;
   private final MesBuildingFactoryService factoryService;

   @Override
   public List<CargoListProductLinkPriceDTO> getCargoLinkPrice(Collection<Long> cargoListIds) {
      if (CollectionUtils.isEmpty(cargoListIds)) {
         return Collections.emptyList();
      }

      List<MesBuildingCargoListProductLink> cargoListProductLinkList = this.cargoListProductLinkService
         .list(Wrappers.lambdaQuery(MesBuildingCargoListProductLink.class).in(MesBuildingCargoListProductLink::getCargoListId, cargoListIds));
      return this.getCargoLinkPrice(cargoListProductLinkList);
   }

   @Override
   public List<CargoListProductLinkPriceDTO> getCargoLinkPrice(List<MesBuildingCargoListProductLink> cargoListProductLinkList) {
      cargoListProductLinkList = cargoListProductLinkList.stream()
         .filter(s -> !s.getWarehouseType().equals(WarehouseTypeProductReturnEnum.REPAIR.getType()))
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(cargoListProductLinkList)) {
         return Collections.emptyList();
      }

      Map<Long, List<ProjectBranchCompanyLink>> projectIdLinkListMap = this.projectBranchCompanyLinkService
         .list(
            Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
               .eq(ProjectBranchCompanyLink::getBranchCompanyLevel, BranchCompanyLevelEnum.SECONDARY_UNIT.getType())
         )
         .stream()
         .collect(Collectors.groupingBy(ProjectBranchCompanyLink::getProjectId));
      Set<Long> branchCompanyIds = this.factoryService.list().stream().map(MesBuildingFactory::getBranchCompanyId).collect(Collectors.toSet());
      Map<Long, Long> projectIdBranchCompanyIdMap = new HashMap<>(projectIdLinkListMap.keySet().size());
      projectIdLinkListMap.forEach(
         (projectId, linkList) -> {
            if (linkList.size() == 1) {
               projectIdBranchCompanyIdMap.put(projectId, linkList.get(0).getBranchCompanyId());
            } else {
               Long branchCompanyId = linkList.stream()
                  .map(ProjectBranchCompanyLink::getBranchCompanyId)
                  .filter(branchCompanyIds::contains)
                  .findFirst()
                  .orElse(null);
               projectIdBranchCompanyIdMap.put(projectId, branchCompanyId);
            }
         }
      );
      List<Long> cargoLinkIds = cargoListProductLinkList.stream().map(MesBuildingCargoListProductLink::getId).collect(Collectors.toList());
      List<Integer> productTypeList = Arrays.asList(
         ProductTypeEnum.ARTIFACT.getType(), ProductTypeEnum.ENCLOSURE.getType(), ProductTypeEnum.AUXILIARY_MATERIAL.getType()
      );
      Map<Integer, List<MesBuildingCargoListProductLink>> productTypeLinksMap = cargoListProductLinkList.stream()
         .filter(s -> productTypeList.contains(s.getProductType()))
         .collect(Collectors.groupingBy(MesBuildingCargoListProductLink::getProductType));
      Map<Long, Integer> projectStructureMeasureModeMap = this.projectService
         .list()
         .stream()
         .collect(
            Collectors.toMap(
               ContractProject::getId, s -> s.getStructureMeasureMode() != null ? s.getStructureMeasureMode() : StructureMeasureModeEnum.THEORY.getType()
            )
         );
      List<CargoListProductLinkPriceDTO> cargoListProductLinkPriceDTOList = new ArrayList<>(cargoListProductLinkList.size());
      productTypeLinksMap.forEach(
         (productType, productLinks) -> {
            Set<Long> productIds = productLinks.stream().map(MesBuildingCargoListProductLink::getProductId).collect(Collectors.toSet());
            Map<Long, List<MesBuildingCargoListProductLink>> productIdLinkListMap = this.cargoListProductLinkService
               .list(
                  Wrappers.lambdaQuery(MesBuildingCargoListProductLink.class)
                     .eq(MesBuildingCargoListProductLink::getProductType, productType)
                     .in(MesBuildingCargoListProductLink::getProductId, productIds)
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingCargoListProductLink::getProductId));
            Map<Long, List<BusinessPriceDetail>> productIdPriceDetailListMap = this.businessPriceDetailService
               .list(
                  Wrappers.lambdaQuery(BusinessPriceDetail.class)
                     .eq(BusinessPriceDetail::getProductType, productType)
                     .in(BusinessPriceDetail::getProductId, productIds)
                     .eq(BusinessPriceDetail::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               )
               .stream()
               .filter(de -> de.getBranchCompanyId().equals(projectIdBranchCompanyIdMap.get(de.getProjectId())))
               .collect(Collectors.groupingBy(BusinessPriceDetail::getProductId));
            if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
               Map<Long, TechArtifact> artifactMap = this.artifactService
                  .listByIds(productIds)
                  .stream()
                  .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
               productIds.forEach(
                  productId -> {
                     TechArtifact artifact = artifactMap.get(productId);
                     List<MesBuildingCargoListProductLink> productLinkList = productIdLinkListMap.getOrDefault(productId, Collections.emptyList());
                     List<BusinessPriceDetail> businessPriceDetails = productIdPriceDetailListMap.getOrDefault(productId, Collections.emptyList())
                        .stream()
                        .sorted(Comparator.comparing(BusinessPriceDetail::getBusinessPriceId).thenComparing(BusinessPriceDetail::getId))
                        .collect(Collectors.toList());
                     List<CargoListProductLinkPriceDTO> productLinkPriceDTOList = this.setArtifactPrice(
                        artifact, projectStructureMeasureModeMap.get(artifact.getProjectId()), productLinkList, businessPriceDetails
                     );
                     cargoListProductLinkPriceDTOList.addAll(productLinkPriceDTOList);
                  }
               );
            }

            if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
               Map<Long, TechEnclosure> enclosureMap = this.enclosureService
                  .listByIds(productIds)
                  .stream()
                  .collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
               productIds.forEach(
                  productId -> {
                     TechEnclosure enclosure = enclosureMap.get(productId);
                     List<MesBuildingCargoListProductLink> productLinkList = productIdLinkListMap.get(productId);
                     List<BusinessPriceDetail> businessPriceDetails = productIdPriceDetailListMap.getOrDefault(productId, Collections.emptyList())
                        .stream()
                        .sorted(Comparator.comparing(BusinessPriceDetail::getBusinessPriceId).thenComparing(BusinessPriceDetail::getId))
                        .collect(Collectors.toList());
                     List<CargoListProductLinkPriceDTO> productLinkPriceDTOList = this.setEnclosurePrice(enclosure, productLinkList, businessPriceDetails);
                     cargoListProductLinkPriceDTOList.addAll(productLinkPriceDTOList);
                  }
               );
            }

            if (productType.equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
               Map<Long, TechStandardPart> standardPartMap = this.standardPartService
                  .listByIds(productIds)
                  .stream()
                  .collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
               productIds.forEach(
                  productId -> {
                     TechStandardPart standardPart = standardPartMap.get(productId);
                     List<MesBuildingCargoListProductLink> productLinkList = productIdLinkListMap.get(productId);
                     List<BusinessPriceDetail> businessPriceDetails = productIdPriceDetailListMap.getOrDefault(productId, Collections.emptyList())
                        .stream()
                        .sorted(Comparator.comparing(BusinessPriceDetail::getBusinessPriceId).thenComparing(BusinessPriceDetail::getId))
                        .collect(Collectors.toList());
                     List<CargoListProductLinkPriceDTO> productLinkPriceDTOList = this.setStandardPartPrice(standardPart, productLinkList, businessPriceDetails);
                     cargoListProductLinkPriceDTOList.addAll(productLinkPriceDTOList);
                  }
               );
            }
         }
      );
      Map<String, List<CargoListProductLinkPriceDTO>> collect = cargoListProductLinkPriceDTOList.stream()
         .filter(c -> cargoLinkIds.contains(c.getId()))
         .collect(Collectors.groupingBy(s -> s.getId() + "_" + s.getBusinessPriceDetailId()));
      List<CargoListProductLinkPriceDTO> resultList = new ArrayList<>(collect.keySet().size());
      collect.forEach(
         (k, v) -> {
            CargoListProductLinkPriceDTO linkPriceDTO = CargoListProductLinkPriceDTO.builder()
               .id(v.get(0).getId())
               .cargoListId(v.get(0).getCargoListId())
               .productType(v.get(0).getProductType())
               .productId(v.get(0).getProductId())
               .businessPriceId(v.get(0).getBusinessPriceId())
               .businessPriceDetailId(v.get(0).getBusinessPriceDetailId())
               .pricingMannerEnum(v.get(0).getPricingMannerEnum())
               .pricingUnitTypeEnum(v.get(0).getPricingUnitTypeEnum())
               .pricingWeightTypeEnum(v.get(0).getPricingWeightTypeEnum())
               .unitPrice(v.get(0).getUnitPrice())
               .quantity(v.stream().map(CargoListProductLinkPriceDTO::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add))
               .mete(v.stream().map(CargoListProductLinkPriceDTO::getMete).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add))
               .totalPrice(v.stream().map(CargoListProductLinkPriceDTO::getTotalPrice).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add))
               .build();
            resultList.add(linkPriceDTO);
         }
      );
      return resultList;
   }

   @Override
   public List<CargoListProductLinkPriceDTO> getCargoLinkPriceByLinkIds(Collection<Long> cargoListProductLinkIds) {
      List<MesBuildingCargoListProductLink> cargoListProductLinkList = this.cargoListProductLinkService.listByIds(cargoListProductLinkIds);
      return this.getCargoLinkPrice(cargoListProductLinkList);
   }

   private List<CargoListProductLinkPriceDTO> setArtifactPrice(
      TechArtifact artifact, Integer structureMeasureMode, List<MesBuildingCargoListProductLink> linkList, List<BusinessPriceDetail> businessPriceDetails
   ) {
      int sum = linkList.stream().mapToInt(s -> s.getQuantity().intValue()).sum();
      List<CargoListProductLinkPriceDTO> productLinkPriceDTOS = new ArrayList<>(sum);
      List<BusinessPriceDetail> newPriceDetailList = this.getNewPriceDetail(businessPriceDetails);
      linkList.forEach(
         link -> {
            for (int i = 0; i < link.getQuantity().intValue(); i++) {
               CargoListProductLinkPriceDTO productLinkPriceDTO = CargoListProductLinkPriceDTO.builder()
                  .id(link.getId())
                  .cargoListId(link.getCargoListId())
                  .productType(link.getProductType())
                  .productId(link.getProductId())
                  .quantity(BigDecimal.ONE)
                  .businessPriceId(0L)
                  .businessPriceDetailId(0L)
                  .pricingMannerEnum(0)
                  .pricingUnitTypeEnum(0)
                  .pricingWeightTypeEnum(0)
                  .build();
               if (!newPriceDetailList.isEmpty()
                  && !link.getBoolCancelShip()
                  && !link.getWarehouseType().equals(WarehouseTypeProductReturnEnum.REPAIR.getType())) {
                  BusinessPriceDetail priceDetail = newPriceDetailList.get(0);
                  productLinkPriceDTO.setBusinessPriceId(priceDetail.getBusinessPriceId());
                  productLinkPriceDTO.setBusinessPriceDetailId(priceDetail.getId());
                  productLinkPriceDTO.setPricingMannerEnum(priceDetail.getPricingMannerEnum());
                  productLinkPriceDTO.setPricingUnitTypeEnum(priceDetail.getPricingUnitTypeEnum());
                  productLinkPriceDTO.setPricingWeightTypeEnum(priceDetail.getPricingWeightTypeEnum());
                  productLinkPriceDTO.setUnitPrice(priceDetail.getUnitPrice());
                  if (structureMeasureMode.equals(StructureMeasureModeEnum.POUND.getType())) {
                     BigDecimal totalMete = priceDetail.getPricingUnitTypeEnum().equals(PricingUnitTypeEnum.KG.getType())
                        ? link.getWeight()
                        : link.getWeight().divide(BigDecimal.valueOf(1000L), 16, RoundingMode.HALF_UP);
                     productLinkPriceDTO.setMete(totalMete);
                     productLinkPriceDTO.setTotalPrice(totalMete.multiply(priceDetail.getUnitPrice()));
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
                     productLinkPriceDTO.setMete(totalMete);
                     productLinkPriceDTO.setTotalPrice(totalMete.multiply(priceDetail.getUnitPrice()));
                  } else if (priceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.LENGTH.getType())) {
                     productLinkPriceDTO.setMete(artifact.getLength().divide(BigDecimal.valueOf(1000L), 16, RoundingMode.HALF_UP));
                     productLinkPriceDTO.setTotalPrice(
                        artifact.getLength().multiply(priceDetail.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 16, RoundingMode.HALF_UP)
                     );
                  } else if (priceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.QUANTITY.getType())) {
                     productLinkPriceDTO.setMete(BigDecimal.ONE);
                     productLinkPriceDTO.setTotalPrice(priceDetail.getUnitPrice());
                  }

                  newPriceDetailList.remove(0);
               }

               productLinkPriceDTOS.add(productLinkPriceDTO);
            }
         }
      );
      return productLinkPriceDTOS;
   }

   private List<CargoListProductLinkPriceDTO> setEnclosurePrice(
      TechEnclosure enclosure, List<MesBuildingCargoListProductLink> linkList, List<BusinessPriceDetail> businessPriceDetails
   ) {
      int sum = linkList.stream().mapToInt(s -> s.getQuantity().intValue()).sum();
      List<CargoListProductLinkPriceDTO> productLinkPriceDTOS = new ArrayList<>(sum * 2);
      List<BusinessPriceDetail> newPriceDetailList = this.getNewPriceDetail(businessPriceDetails);
      linkList.forEach(
         link -> {
            for (int i = 0; i < link.getQuantity().intValue(); i++) {
               CargoListProductLinkPriceDTO productLinkPriceDTO = CargoListProductLinkPriceDTO.builder()
                  .id(link.getId())
                  .cargoListId(link.getCargoListId())
                  .productType(link.getProductType())
                  .productId(link.getProductId())
                  .quantity(BigDecimal.ONE)
                  .businessPriceId(0L)
                  .businessPriceDetailId(0L)
                  .pricingMannerEnum(0)
                  .pricingUnitTypeEnum(0)
                  .pricingWeightTypeEnum(0)
                  .build();
               if (!newPriceDetailList.isEmpty()) {
                  BusinessPriceDetail priceDetail = newPriceDetailList.get(0);
                  productLinkPriceDTO.setBusinessPriceId(priceDetail.getBusinessPriceId());
                  productLinkPriceDTO.setBusinessPriceDetailId(priceDetail.getId());
                  productLinkPriceDTO.setPricingMannerEnum(priceDetail.getPricingMannerEnum());
                  productLinkPriceDTO.setPricingUnitTypeEnum(priceDetail.getPricingUnitTypeEnum());
                  productLinkPriceDTO.setUnitPrice(priceDetail.getUnitPrice());
                  if (priceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.LENGTH.getType())) {
                     productLinkPriceDTO.setMete(enclosure.getLength().divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP));
                     productLinkPriceDTO.setTotalPrice(
                        enclosure.getLength().multiply(priceDetail.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP)
                     );
                  } else if (priceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.AREA.getType())) {
                     productLinkPriceDTO.setMete(enclosure.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP));
                     productLinkPriceDTO.setTotalPrice(
                        enclosure.getSurfaceArea().multiply(priceDetail.getUnitPrice()).divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP)
                     );
                  } else if (priceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.QUANTITY.getType())) {
                     productLinkPriceDTO.setMete(BigDecimal.ONE);
                     productLinkPriceDTO.setTotalPrice(priceDetail.getUnitPrice());
                  } else if (priceDetail.getPricingMannerEnum().equals(NewPricingMannerEnum.WEIGHT.getType())) {
                     BigDecimal totalMete = priceDetail.getPricingUnitTypeEnum().equals(PricingUnitTypeEnum.KG.getType())
                        ? enclosure.getWeight()
                        : enclosure.getWeight().divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP);
                     productLinkPriceDTO.setMete(totalMete);
                     productLinkPriceDTO.setTotalPrice(totalMete.multiply(priceDetail.getUnitPrice()));
                  }

                  newPriceDetailList.remove(0);
               }

               productLinkPriceDTOS.add(productLinkPriceDTO);
            }
         }
      );
      return productLinkPriceDTOS;
   }

   private List<CargoListProductLinkPriceDTO> setStandardPartPrice(
      TechStandardPart standardPart, List<MesBuildingCargoListProductLink> linkList, List<BusinessPriceDetail> businessPriceDetails
   ) {
      BigDecimal sum = linkList.stream().map(MesBuildingCargoListProductLink::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
      List<CargoListProductLinkPriceDTO> shipmentInfoDTOList = new ArrayList<>(sum.intValue() * 2);
      Map<Long, BusinessPriceDetail> priceDetailIdMap = businessPriceDetails.stream()
         .collect(Collectors.toMap(BusinessPriceDetail::getId, Function.identity()));
      Map<Long, BigDecimal> priceDetailIdQuantityMap = new LinkedHashMap<>(businessPriceDetails.size());
      businessPriceDetails.forEach(priceDetail -> {
         BigDecimal var10000 = priceDetailIdQuantityMap.put(priceDetail.getId(), priceDetail.getQuantity());
      });
      linkList.forEach(link -> this.setStandardPartPrice(standardPart, link, priceDetailIdMap, priceDetailIdQuantityMap, shipmentInfoDTOList));
      return shipmentInfoDTOList;
   }

   private void setStandardPartPrice(
      TechStandardPart standardPart,
      MesBuildingCargoListProductLink link,
      Map<Long, BusinessPriceDetail> priceDetailIdMap,
      Map<Long, BigDecimal> priceDetailIdQuantityMap,
      List<CargoListProductLinkPriceDTO> shipmentInfoDTOList
   ) {
      if (CollectionUtils.isNotEmpty(priceDetailIdQuantityMap)) {
         CargoListProductLinkPriceDTO shipmentInfoDTO = CargoListProductLinkPriceDTO.builder()
            .id(link.getId())
            .cargoListId(link.getCargoListId())
            .productType(link.getProductType())
            .productId(link.getProductId())
            .businessPriceId(0L)
            .businessPriceDetailId(0L)
            .pricingMannerEnum(0)
            .pricingUnitTypeEnum(0)
            .pricingWeightTypeEnum(0)
            .build();
         Long priceDetailId = priceDetailIdMap.keySet().iterator().next();
         BigDecimal priceDetailQuantity = priceDetailIdQuantityMap.get(priceDetailId);
         BusinessPriceDetail priceDetail = priceDetailIdMap.get(priceDetailId);
         shipmentInfoDTO.setBusinessPriceId(priceDetail.getBusinessPriceId());
         shipmentInfoDTO.setBusinessPriceDetailId(priceDetail.getBusinessPriceId());
         shipmentInfoDTO.setUnitPrice(priceDetail.getUnitPrice());
         if (link.getQuantity().compareTo(priceDetailQuantity) >= 0) {
            shipmentInfoDTO.setQuantity(priceDetail.getQuantity());
            shipmentInfoDTO.setMete(priceDetail.getQuantity().multiply(standardPart.getMete()).divide(standardPart.getQuantity(), 8, RoundingMode.HALF_UP));
            shipmentInfoDTO.setTotalPrice(
               priceDetail.getQuantity()
                  .multiply(standardPart.getMete())
                  .multiply(priceDetail.getUnitPrice())
                  .divide(standardPart.getQuantity(), 8, RoundingMode.HALF_UP)
            );
            shipmentInfoDTOList.add(shipmentInfoDTO);
            priceDetailIdQuantityMap.remove(priceDetailId);
            link.setQuantity(link.getQuantity().subtract(priceDetailQuantity));
            this.setStandardPartPrice(standardPart, link, priceDetailIdMap, priceDetailIdQuantityMap, shipmentInfoDTOList);
         } else {
            shipmentInfoDTO.setQuantity(link.getQuantity());
            shipmentInfoDTO.setMete(link.getQuantity().multiply(standardPart.getMete()).divide(standardPart.getQuantity(), 8, RoundingMode.HALF_UP));
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
         CargoListProductLinkPriceDTO shipmentInfoDTO = CargoListProductLinkPriceDTO.builder()
            .id(link.getId())
            .cargoListId(link.getCargoListId())
            .productType(link.getProductType())
            .productId(link.getProductId())
            .quantity(link.getQuantity())
            .businessPriceId(0L)
            .businessPriceDetailId(0L)
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
         int detailQuantity = businessPriceDetail.getQuantity().intValue();

         for (int i = 0; i < detailQuantity; i++) {
            BusinessPriceDetail newPriceDetail = BeanUtil.copy(businessPriceDetail, BusinessPriceDetail.class);
            newPriceDetail.setQuantity(BigDecimal.ONE);
            newBusinessPriceDetails.add(newPriceDetail);
         }
      });
      return newBusinessPriceDetails;
   }

   public BusinessPriceUtilsImpl(
      final ContractProjectService projectService,
      final ProjectBranchCompanyLinkService projectBranchCompanyLinkService,
      final TechArtifactService artifactService,
      final TechEnclosureService enclosureService,
      final TechStandardPartService standardPartService,
      final MesBuildingCargoListService cargoListService,
      final MesBuildingCargoListProductLinkService cargoListProductLinkService,
      final BusinessPriceDetailService businessPriceDetailService,
      final MesBuildingFactoryService factoryService
   ) {
      this.projectService = projectService;
      this.projectBranchCompanyLinkService = projectBranchCompanyLinkService;
      this.artifactService = artifactService;
      this.enclosureService = enclosureService;
      this.standardPartService = standardPartService;
      this.cargoListService = cargoListService;
      this.cargoListProductLinkService = cargoListProductLinkService;
      this.businessPriceDetailService = businessPriceDetailService;
      this.factoryService = factoryService;
   }
}
