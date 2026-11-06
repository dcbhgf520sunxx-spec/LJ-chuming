package com.hzchum.scim.mes.building.core.biz.impl.productionAnalysis;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.mes.building.core.api.biz.productionAnalysis.ProjectMaterialRequisitionAnalysisBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.productionAnalysis.ProjectMaterialRequisitionAnalysisDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis.ProjectPartsAndRequisitionDTO;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectPickingDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectPickingMeteListDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryProjectPickingDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProjectMaterialRequisitionAnalysisBizImpl implements ProjectMaterialRequisitionAnalysisBiz {
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Resource
   private TechArtifactService techArtifactService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private OutboundService outboundService;

   @Override
   public BigDecimal productionCompanySummary(ProjectMaterialRequisitionAnalysisDOParam param) {
      List<MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService
         .list(
            ((((new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                           .eq(MesBuildingWarehouseSummary::getProjectId, param.getProjectId()))
                        .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType()))
                     .eq(MesBuildingWarehouseSummary::getWarehouseType, WarehouseTypeProductReturnEnum.NORMAL.getType()))
                  .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ARTIFACT.getType()))
               .eq(param.getWorkShopId() != null, MesBuildingWarehouseSummary::getWorkshopId, param.getWorkShopId())
         );
      if (CollectionUtils.isEmpty(warehouseSummaryList)) {
         return BigDecimal.ZERO;
      }

      Map<Long, TechArtifact> artifactMap = this.techArtifactService
         .listByIds(warehouseSummaryList.stream().map(MesBuildingWarehouseSummary::getProductId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactMap), "查询失败,构件清单异常!");
      return warehouseSummaryList.stream()
         .map(summary -> artifactMap.get(summary.getProductId()).getNetWeight().multiply(summary.getQuantity()))
         .reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public List<ProjectPartsAndRequisitionDTO> getProjectPartsAndRequisitionList(ProjectMaterialRequisitionAnalysisDOParam param) {
      List<ProjectPartsAndRequisitionDTO> partsAndRequisitionDTOS = new ArrayList<>();
      List<TechMachinePart> techMachineParts = this.machinePartService
         .list(
            ((new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getProjectId, param.getProjectId()))
                  .eq(param.getProductClassificationEnum() != null, TechMachinePart::getProductClassificationEnum, param.getProductClassificationEnum()))
               .select(
                  TechMachinePart::getId,
                  TechMachinePart::getProductClassificationEnum,
                  TechMachinePart::getSteelSpec,
                  TechMachinePart::getMaterial,
                  TechMachinePart::getNetWeight,
                  TechMachinePart::getGrossWeight,
                  TechMachinePart::getQuantity
               )
         );
      if (CollectionUtils.isEmpty(techMachineParts)) {
         return partsAndRequisitionDTOS;
      }

      QueryProjectPickingDTOParam projectPickingDTOParam = QueryProjectPickingDTOParam.builder()
         .projectId(param.getProjectId())
         .workShopId(param.getWorkShopId())
         .build();
      ProjectPickingMeteListDTO projectPickingMeteListDTO = this.outboundService.PickingMete(projectPickingDTOParam);
      Map<String, List<TechMachinePart>> machinePartClassListMap = techMachineParts.stream()
         .collect(Collectors.groupingBy(e -> e.getProductClassificationEnum() + "-" + e.getSteelSpec().replaceFirst("^[A-Za-z]+", "") + "-" + e.getMaterial()));
      machinePartClassListMap.forEach(
         (classAndThickAndMaterial, partList) -> {
            TechMachinePart part = partList.get(0);
            String steelSpec = part.getSteelSpec();
            Integer productClassificationEnum = part.getProductClassificationEnum();
            ProjectPartsAndRequisitionDTO projectPartsAndRequisitionDTO = ProjectPartsAndRequisitionDTO.builder()
               .productClassificationEnum(part.getProductClassificationEnum())
               .material(part.getMaterial())
               .steelSpec(part.getSteelSpec())
               .totalNetWeight(
                  partList.stream()
                     .map(e -> e.getNetWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
                     .reduce(BigDecimal.ZERO, BigDecimal::add)
               )
               .totalGrossWeight(
                  partList.stream()
                     .map(e -> e.getGrossWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
                     .reduce(BigDecimal.ZERO, BigDecimal::add)
               )
               .receiveWeight(BigDecimal.ZERO)
               .build();
            if (productClassificationEnum.equals(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType())
               && projectPickingMeteListDTO != null
               && CollectionUtils.isNotEmpty(projectPickingMeteListDTO.getProjectPickingSteelMeteList())) {
               List<ProjectPickingDTO> projectPickingSteelMeteList = projectPickingMeteListDTO.getProjectPickingSteelMeteList();
               List<ProjectPickingDTO> projectPickingDTOS = projectPickingSteelMeteList.stream()
                  .filter(e -> e.getThickness().compareTo(BigDecimal.valueOf(Double.parseDouble(steelSpec))) == 0)
                  .filter(e -> StrUtil.isBlank(part.getMaterial()) ? StrUtil.isBlank(e.getSpecification()) : part.getMaterial().equals(e.getSpecification()))
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(projectPickingDTOS)) {
                  BigDecimal meteCount = projectPickingDTOS.stream()
                     .map(ProjectPickingDTO::getMeteCount)
                     .reduce(BigDecimal.ZERO, BigDecimal::add)
                     .divide(BigDecimal.valueOf(1000L), 3, 4);
                  projectPartsAndRequisitionDTO.setReceiveWeight(meteCount);
                  // Some original outbound records have no recorded theoretical weight.
                  // Preserve an unknown total rather than treating missing measurements as zero.
                  if (projectPickingDTOS.stream().allMatch(e -> e.getActualTheoryWeight() != null)) {
                     BigDecimal actualTheoryWeight = projectPickingDTOS.stream()
                        .map(ProjectPickingDTO::getActualTheoryWeight)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(1000L), 3, 4);
                     projectPartsAndRequisitionDTO.setActualTheoryWeight(actualTheoryWeight);
                  }
               }
            }

            if (productClassificationEnum.equals(ProductClassificationEnum.SECTION_PRODUCT.getType())
               && projectPickingMeteListDTO != null
               && CollectionUtils.isNotEmpty(projectPickingMeteListDTO.getProjectPickingSectionSteelMeteList())) {
               List<ProjectPickingDTO> projectPickingSectionSteelMeteList = projectPickingMeteListDTO.getProjectPickingSectionSteelMeteList();
               List<ProjectPickingDTO> projectPickingDTOS = projectPickingSectionSteelMeteList.stream().filter(e -> {
                  String noPrefixSpec = steelSpec.replaceFirst("^[A-Za-z]+", "");
                  String doNotSectionSteelSpec = StrUtil.subBefore(e.getSpecification(), " * ", true);
                  return doNotSectionSteelSpec.equals(noPrefixSpec) || doNotSectionSteelSpec.equals(steelSpec);
               }).filter(e -> e.getSpecification().contains(part.getMaterial())).collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(projectPickingDTOS)) {
                  BigDecimal meteCount = projectPickingDTOS.stream()
                     .map(ProjectPickingDTO::getMeteCount)
                     .reduce(BigDecimal.ZERO, BigDecimal::add)
                     .divide(BigDecimal.valueOf(1000L), 3, 4);
                  projectPartsAndRequisitionDTO.setReceiveWeight(meteCount);
                  projectPartsAndRequisitionDTO.setActualTheoryWeight(meteCount);
               }
            }

            if (projectPartsAndRequisitionDTO.getTotalNetWeight().compareTo(BigDecimal.ZERO) != 0) {
               projectPartsAndRequisitionDTO.setWastageRate(
                  projectPartsAndRequisitionDTO.getTotalNetWeight()
                     .subtract(projectPartsAndRequisitionDTO.getReceiveWeight())
                     .divide(projectPartsAndRequisitionDTO.getTotalNetWeight(), 5, 4)
                     .multiply(BigDecimal.valueOf(100L))
               );
            }

            partsAndRequisitionDTOS.add(projectPartsAndRequisitionDTO);
         }
      );
      return partsAndRequisitionDTOS.stream()
         .sorted(Comparator.comparing(ProjectPartsAndRequisitionDTO::getProductClassificationEnum))
         .collect(Collectors.toList());
   }
}
