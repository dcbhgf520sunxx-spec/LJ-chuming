package com.hzchum.scim.mes.building.core.biz.impl.product;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.biz.product.MesProductBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProductSumInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProductSumInfoDTO.ProductSumInfoDTOBuilder;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class MesProductBizImpl implements MesProductBiz {
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechEnclosureService enclosureService;
   @Resource
   private TechStandardPartService techStandardPartService;
   @Resource
   private TechMachinePartService partService;
   @Resource
   private MesBuildingCargoListProductLinkService cargoListProductLinkService;

   @Override
   public ProductSumInfoDTO getInfoByProduct(Long productId, Integer productType, BigDecimal quantity) {
      ProductSumInfoDTOBuilder builder = ProductSumInfoDTO.builder().quantity(quantity).productType(productType);
      BigDecimal netWeight = BigDecimal.ZERO;
      BigDecimal grossWeight = BigDecimal.ZERO;
      BigDecimal length = BigDecimal.ZERO;
      BigDecimal surfaceArea = BigDecimal.ZERO;
      BigDecimal totalNetWeight = BigDecimal.ZERO;
      BigDecimal totalGrossWeight = BigDecimal.ZERO;
      BigDecimal totalLength = BigDecimal.ZERO;
      Integer category = 0;
      Integer relationType = 0;
      BigDecimal mete = BigDecimal.ZERO;
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         TechArtifact artifact = this.artifactService.getById(productId);
         Preconditions.checkArgument(artifact != null, "失败：未查询到相关产品");
         totalNetWeight = artifact.getNetWeight().multiply(quantity);
         totalGrossWeight = artifact.getGrossWeight().multiply(quantity);
         netWeight = artifact.getNetWeight();
         grossWeight = artifact.getGrossWeight();
      }

      if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         TechAssemble assemble = this.assembleService.getById(productId);
         Preconditions.checkArgument(assemble != null, "失败：未查询到相关部件");
         totalNetWeight = assemble.getNetWeight().multiply(quantity);
         totalGrossWeight = assemble.getGrossWeight().multiply(quantity);
         netWeight = assemble.getNetWeight();
         grossWeight = assemble.getGrossWeight();
      }

      if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         TechEnclosure enclosure = this.enclosureService.getById(productId);
         Preconditions.checkArgument(enclosure != null, "失败：未查询到相关产品");
         totalLength = enclosure.getLength().multiply(quantity);
         netWeight = enclosure.getWeight();
         totalNetWeight = enclosure.getWeight().multiply(quantity);
         totalGrossWeight = enclosure.getWeight().multiply(quantity);
         surfaceArea = enclosure.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP);
         length = enclosure.getLength();
         category = enclosure.getCategory();
      }

      if (productType.equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
         TechStandardPart standardPart = this.techStandardPartService.getById(productId);
         Preconditions.checkArgument(standardPart != null, "配套件不存在!!!");
         relationType = standardPart.getRelationType();
         if (standardPart.getMete() != null) {
            mete = standardPart.getMete().divide(standardPart.getQuantity(), 4, RoundingMode.HALF_UP).multiply(quantity);
            netWeight = standardPart.getMete().divide(standardPart.getQuantity(), 5, RoundingMode.HALF_UP);
            if (standardPart.getBoolWeightTypeEnum()) {
               if ("吨".equals(standardPart.getAccountingUnit())) {
                  totalNetWeight = mete.multiply(BigDecimal.valueOf(1000L));
                  totalGrossWeight = mete.multiply(BigDecimal.valueOf(1000L));
               } else {
                  totalNetWeight = mete;
                  totalGrossWeight = mete;
               }
            }
         }
      }

      if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         TechMachinePart part = this.partService.getById(productId);
         Preconditions.checkArgument(part != null, "失败：未查询到相关产品");
         if (part.getBoolAllPartSendDirectly()) {
            totalNetWeight = part.getNetWeight().multiply(quantity);
            totalGrossWeight = part.getGrossWeight().multiply(quantity);
            netWeight = part.getNetWeight();
            grossWeight = part.getGrossWeight();
         }
      }

      return builder.category(category)
         .netWeight(netWeight)
         .grossWeight(grossWeight)
         .length(length)
         .surfaceArea(surfaceArea)
         .totalNetWeight(totalNetWeight)
         .totalGrossWeight(totalGrossWeight)
         .enclLength(totalLength)
         .relationType(relationType)
         .mete(mete)
         .build();
   }

   @Override
   public ProductSumInfoDTO getInfoByCargoListId(Long cargoListId) {
      AtomicReference<BigDecimal> quantity = new AtomicReference<>(BigDecimal.ZERO);
      AtomicReference<Integer> productType = new AtomicReference<>(0);
      AtomicReference<Integer> category = new AtomicReference<>(0);
      AtomicReference<Integer> relationType = new AtomicReference<>(0);
      AtomicReference<BigDecimal> totalNetWeight = new AtomicReference<>(BigDecimal.ZERO);
      AtomicReference<BigDecimal> totalGrossWeight = new AtomicReference<>(BigDecimal.ZERO);
      List<MesBuildingCargoListProductLink> cargoListProductLinks = this.cargoListProductLinkService
         .list(
            (Wrapper<MesBuildingCargoListProductLink>)(new LambdaQueryWrapper<MesBuildingCargoListProductLink>()
                  .eq(MesBuildingCargoListProductLink::getCargoListId, cargoListId))
               .eq(MesBuildingCargoListProductLink::getBoolCancelShip, Boolean.FALSE)
         );
      if (CollectionUtils.isNotEmpty(cargoListProductLinks)) {
         Map<Integer, List<MesBuildingCargoListProductLink>> cargoListProductLinksMap = cargoListProductLinks.stream()
            .collect(Collectors.groupingBy(MesBuildingCargoListProductLink::getProductType));
         cargoListProductLinksMap.forEach(
            (cargoProductType, cargoListProductLinkList) -> {
               if (ProductTypeEnum.ARTIFACT.getType().equals(cargoProductType)) {
                  List<Long> productIds = cargoListProductLinkList.stream()
                     .map(MesBuildingCargoListProductLink::getProductId)
                     .distinct()
                     .collect(Collectors.toList());
                  List<TechArtifact> artifacts = this.artifactService.listByIds(productIds);
                  Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifacts) && artifacts.size() == productIds.size(), "操作失败,构件清单不存在!");
                  Map<Long, TechArtifact> artifactMap = artifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
                  quantity.updateAndGet(
                     v -> v.add(cargoListProductLinkList.stream().map(MesBuildingCargoListProductLink::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add))
                  );
                  totalNetWeight.set(
                     totalNetWeight.get()
                        .add(
                           cargoListProductLinkList.stream()
                              .map(e -> artifactMap.get(e.getProductId()).getNetWeight().multiply(e.getQuantity()))
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                        )
                  );
                  totalGrossWeight.set(
                     totalGrossWeight.get()
                        .add(
                           cargoListProductLinkList.stream()
                              .map(e -> artifactMap.get(e.getProductId()).getGrossWeight().multiply(e.getQuantity()))
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                        )
                  );
                  productType.set(productType.get() | cargoProductType);
               }

               if (ProductTypeEnum.ASSEMBLE.getType().equals(cargoProductType)) {
                  List<Long> productIds = cargoListProductLinkList.stream()
                     .map(MesBuildingCargoListProductLink::getProductId)
                     .distinct()
                     .collect(Collectors.toList());
                  List<TechAssemble> assembles = this.assembleService.listByIds(productIds);
                  Preconditions.checkArgument(CollectionUtils.isNotEmpty(assembles) && assembles.size() == productIds.size(), "操作失败,部件清单不存在!");
                  Map<Long, TechAssemble> assembleMap = assembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
                  quantity.updateAndGet(
                     v -> v.add(cargoListProductLinkList.stream().map(MesBuildingCargoListProductLink::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add))
                  );
                  totalNetWeight.set(
                     totalNetWeight.get().add(cargoListProductLinkList.stream()
                        .map(e -> assembleMap.get(e.getProductId()).getNetWeight().multiply(e.getQuantity()))
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                  );
                  totalGrossWeight.set(
                     totalGrossWeight.get().add(cargoListProductLinkList.stream()
                        .map(e -> assembleMap.get(e.getProductId()).getGrossWeight().multiply(e.getQuantity()))
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                  );
                  productType.set(productType.get() | cargoProductType);
               }

               if (ProductTypeEnum.MACHINE_PART.getType().equals(cargoProductType)) {
                  List<Long> productIds = cargoListProductLinkList.stream()
                     .map(MesBuildingCargoListProductLink::getProductId)
                     .distinct()
                     .collect(Collectors.toList());
                  List<TechMachinePart> machinePartList = this.partService.listByIds(productIds);
                  Preconditions.checkArgument(CollectionUtils.isNotEmpty(machinePartList) && machinePartList.size() == productIds.size(), "操作失败,零件清单不存在!");
                  Map<Long, TechMachinePart> machinePartMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
                  quantity.updateAndGet(
                     v -> v.add(cargoListProductLinkList.stream().map(MesBuildingCargoListProductLink::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add))
                  );
                  totalNetWeight.set(
                     totalNetWeight.get()
                        .add(
                           cargoListProductLinkList.stream()
                              .map(e -> machinePartMap.get(e.getProductId()).getNetWeight().multiply(e.getQuantity()))
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                        )
                  );
                  totalGrossWeight.set(
                     totalGrossWeight.get()
                        .add(
                           cargoListProductLinkList.stream()
                              .map(e -> machinePartMap.get(e.getProductId()).getGrossWeight().multiply(e.getQuantity()))
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                        )
                  );
                  productType.set(productType.get() | cargoProductType);
               }

               if (ProductTypeEnum.ENCLOSURE.getType().equals(cargoProductType)) {
                  List<Long> productIds = cargoListProductLinkList.stream()
                     .map(MesBuildingCargoListProductLink::getProductId)
                     .distinct()
                     .collect(Collectors.toList());
                  List<TechEnclosure> enclosures = this.enclosureService.listByIds(productIds);
                  Preconditions.checkArgument(CollectionUtils.isNotEmpty(enclosures) && enclosures.size() == productIds.size(), "操作失败,围护清单不存在!");
                  Map<Long, TechEnclosure> enclosureMap = enclosures.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
                  quantity.updateAndGet(
                     v -> v.add(cargoListProductLinkList.stream().map(MesBuildingCargoListProductLink::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add))
                  );
                  totalNetWeight.set(
                     totalNetWeight.get()
                        .add(
                           cargoListProductLinkList.stream()
                              .map(e -> enclosureMap.get(e.getProductId()).getWeight().multiply(e.getQuantity()))
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                        )
                  );
                  totalGrossWeight.set(
                     totalGrossWeight.get()
                        .add(
                           cargoListProductLinkList.stream()
                              .map(e -> enclosureMap.get(e.getProductId()).getWeight().multiply(e.getQuantity()))
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                        )
                  );
                  productType.set(productType.get() | cargoProductType);
               }

               if (ProductTypeEnum.AUXILIARY_MATERIAL.getType().equals(cargoProductType)) {
                  List<Long> productIds = cargoListProductLinkList.stream()
                     .map(MesBuildingCargoListProductLink::getProductId)
                     .distinct()
                     .collect(Collectors.toList());
                  List<TechStandardPart> standardPartList = this.techStandardPartService.listByIds(productIds);
                  Preconditions.checkArgument(CollectionUtils.isNotEmpty(standardPartList) && standardPartList.size() == productIds.size(), "操作失败,配套件清单不存在!");
                  Map<Long, TechStandardPart> standardPartMap = standardPartList.stream()
                     .collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
                  quantity.updateAndGet(
                     v -> v.add(cargoListProductLinkList.stream().map(MesBuildingCargoListProductLink::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add))
                  );
                  productType.set(productType.get() | cargoProductType);

                  for (MesBuildingCargoListProductLink link : cargoListProductLinkList) {
                     TechStandardPart standardPart = standardPartMap.get(link.getProductId());
                     if (standardPart.getMete() != null) {
                        BigDecimal mete = standardPart.getMete().divide(standardPart.getQuantity(), 4, RoundingMode.HALF_UP).multiply(link.getQuantity());
                        if (standardPart.getBoolWeightTypeEnum()) {
                           if ("吨".equals(standardPart.getAccountingUnit())) {
                              totalNetWeight.set(totalNetWeight.get().add(mete.multiply(BigDecimal.valueOf(1000L))));
                              totalGrossWeight.set(totalGrossWeight.get().add(mete.multiply(BigDecimal.valueOf(1000L))));
                           } else {
                              totalNetWeight.set(totalNetWeight.get().add(mete));
                              totalGrossWeight.set(totalGrossWeight.get().add(mete));
                           }
                        }
                     }
                  }

                  productType.set(productType.get() | cargoProductType);
               }
            }
         );
      }

      return ProductSumInfoDTO.builder()
         .productType(productType.get())
         .category(category.get())
         .relationType(relationType.get())
         .quantity(quantity.get())
         .totalGrossWeight(totalGrossWeight.get())
         .totalNetWeight(totalNetWeight.get())
         .build();
   }
}
