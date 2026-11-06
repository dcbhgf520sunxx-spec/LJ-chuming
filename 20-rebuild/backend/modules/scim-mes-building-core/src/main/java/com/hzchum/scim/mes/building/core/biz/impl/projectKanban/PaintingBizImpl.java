package com.hzchum.scim.mes.building.core.biz.impl.projectKanban;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.projectKanban.PaintingBiz;
import com.hzchum.scim.mes.building.core.api.biz.wages.MesBuildingProduceTeamReportPriceBiz;
import com.hzchum.scim.mes.building.core.api.enums.PaintingTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.projectKanban.MesBuildingPainting;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingProduceTeamReportPrice;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactPaintingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactTypePaintingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.PaintingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.PaintingSettingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.util.ProductSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.ArtifactPaintingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.PaintingDTOParam;
import com.hzchum.scim.mes.building.core.api.service.projectKanban.MesBuildingPaintingService;
import com.hzchum.scim.mes.building.core.mapper.projectKanban.MesBuildingPaintingMapper;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class PaintingBizImpl extends IBizImpl<MesBuildingPaintingService, MesBuildingPaintingMapper, MesBuildingPainting> implements PaintingBiz {
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private PlanAreaService areaService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private SysStructureClassificationService classificationService;
   @Autowired
   private MesBuildingProduceTeamReportPriceBiz priceBiz;

   @Override
   public List<PaintingSettingDTO> settingList(Long projectId, Long monomerId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "操作失败:id不正确");
      List<PlanMonomer> monomerList = this.monomerService
         .list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projectId).eq(monomerId != null, PlanMonomer::getId, monomerId));
      if (monomerList.size() == 0) {
         return new ArrayList<>();
      }

      Map<Long, List<MesBuildingPainting>> paintingListMap = this.list(
            Wrappers.lambdaQuery(MesBuildingPainting.class)
               .in(MesBuildingPainting::getMonomerId, monomerList.stream().map(PlanMonomer::getId).collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.groupingBy(MesBuildingPainting::getMonomerId));
      Map<Long, List<TechArtifact>> surfaceAreaListMap = this.artifactService
         .list(
            Wrappers.lambdaQuery(TechArtifact.class)
               .in(TechArtifact::getMonomerId, monomerList.stream().map(PlanMonomer::getId).collect(Collectors.toList()))
               .isNotNull(TechArtifact::getStructureClassId)
         )
         .stream()
         .collect(Collectors.groupingBy(TechArtifact::getMonomerId));
      return monomerList.stream()
         .map(
            e -> {
               PaintingSettingDTO dto = PaintingSettingDTO.builder()
                  .project(BeanUtil.copy(project, ProjectDetailDO.class))
                  .monomer(MonomerDetailDO.builder().id(e.getId()).name(e.getName()).build())
                  .build();
               if (paintingListMap.get(e.getId()) != null) {
                  paintingListMap.get(e.getId()).forEach(pating -> {
                     if (pating.getPaintingType().equals(PaintingTypeEnum.PRIMER.getType())) {
                        dto.setPrimerPainting(BeanUtil.copy(pating, PaintingDTO.class));
                     } else if (pating.getPaintingType().equals(PaintingTypeEnum.INTERMEDIATE_PAINT.getType())) {
                        dto.setIntermediatePainting(BeanUtil.copy(pating, PaintingDTO.class));
                     } else if (pating.getPaintingType().equals(PaintingTypeEnum.TOPCOAT.getType())) {
                        dto.setTopcoatPainting(BeanUtil.copy(pating, PaintingDTO.class));
                     }
                  });
               }

               if (surfaceAreaListMap.get(e.getId()) != null) {
                  dto.setSurfaceArea(
                     surfaceAreaListMap.get(e.getId())
                        .stream()
                        .map(product -> product.getSurfaceArea().multiply(BigDecimal.valueOf(product.getQuantity().intValue())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                  );
               } else {
                  dto.setSurfaceArea(BigDecimal.ZERO);
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public Boolean settingPainting(PaintingDTOParam dtoParam) {
      List<PlanMonomer> monomerList = this.monomerService
         .list(
            Wrappers.lambdaQuery(PlanMonomer.class)
               .eq(PlanMonomer::getProjectId, dtoParam.getProjectId())
               .eq(dtoParam.getMonomerId() != null, PlanMonomer::getId, dtoParam.getMonomerId())
         );
      monomerList.forEach(
         e -> {
            MesBuildingPainting painting = this.getOne(
               Wrappers.lambdaQuery(MesBuildingPainting.class)
                  .eq(MesBuildingPainting::getMonomerId, e.getId())
                  .eq(MesBuildingPainting::getPaintingType, dtoParam.getPaintingType())
            );
            if (painting == null) {
               painting = MesBuildingPainting.builder()
                  .loss(dtoParam.getLoss())
                  .thickness(dtoParam.getThickness())
                  .volumeSolids(dtoParam.getVolumeSolids())
                  .paintingType(dtoParam.getPaintingType())
                  .projectId(dtoParam.getProjectId())
                  .monomerId(e.getId())
                  .build();
               this.save(painting);
            } else {
               painting.setThickness(dtoParam.getThickness());
               painting.setLoss(dtoParam.getLoss());
               painting.setVolumeSolids(dtoParam.getVolumeSolids());
               this.updateById(painting);
            }
         }
      );
      return Boolean.TRUE;
   }

   @Override
   public List<ArtifactTypePaintingDTO> artifactTypePainting(Long projectId, Long monomerId) {
      Map<Long, Map<Long, List<TechArtifact>>> surfaceAreaListMap = this.artifactService
         .list(
            Wrappers.lambdaQuery(TechArtifact.class)
               .eq(TechArtifact::getProjectId, projectId)
               .isNotNull(TechArtifact::getStructureClassId)
               .eq(monomerId != null, TechArtifact::getMonomerId, monomerId)
         )
         .stream()
         .collect(Collectors.groupingBy(TechArtifact::getStructureClassId, Collectors.groupingBy(TechArtifact::getMonomerId)));
      if (surfaceAreaListMap.keySet().size() == 0) {
         return new ArrayList<>();
      }

      Map<Long, List<MesBuildingPainting>> paintingMapList = this.list(
            Wrappers.lambdaQuery(MesBuildingPainting.class)
               .eq(MesBuildingPainting::getProjectId, projectId)
               .eq(monomerId != null, MesBuildingPainting::getMonomerId, monomerId)
         )
         .stream()
         .collect(Collectors.groupingBy(MesBuildingPainting::getMonomerId));
      List<SysStructureClassification> classificationList = this.classificationService.listByIds(surfaceAreaListMap.keySet());
      return classificationList.stream()
         .map(
            e -> {
               ArtifactTypePaintingDTO dto = ArtifactTypePaintingDTO.builder()
                  .config(IdAndNameDO.builder().id(e.getId()).name(e.getClassificationName()).build())
                  .surfaceArea(
                     surfaceAreaListMap.get(e.getId())
                        .values()
                        .stream()
                        .map(
                           techArtifacts -> techArtifacts.stream()
                              .map(techArtifact -> techArtifact.getSurfaceArea().multiply(BigDecimal.valueOf(techArtifact.getQuantity().intValue())))
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                        )
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                  )
                  .build();
               surfaceAreaListMap.get(e.getId())
                  .keySet()
                  .forEach(
                     monomer -> {
                        if (paintingMapList.get(monomer) != null) {
                           paintingMapList.get(monomer)
                              .forEach(
                                 painting -> {
                                    BigDecimal surfaceArea = surfaceAreaListMap.get(e.getId())
                                       .get(monomer)
                                       .stream()
                                       .map(techArtifact -> techArtifact.getSurfaceArea().multiply(BigDecimal.valueOf(techArtifact.getQuantity().intValue())))
                                       .reduce(BigDecimal.ZERO, BigDecimal::add);
                                    if (painting.getPaintingType().equals(PaintingTypeEnum.PRIMER.getType())) {
                                       if (dto.getPrimerMeasure() == null) {
                                          dto.setPrimerMeasure(BigDecimal.ZERO);
                                       }

                                       dto.setPrimerMeasure(
                                          dto.getPrimerMeasure()
                                             .add(
                                                surfaceArea.divide(new BigDecimal(1000000), 10, 0)
                                                   .multiply(painting.getThickness())
                                                   .divide(
                                                      painting.getVolumeSolids()
                                                         .multiply(new BigDecimal(10))
                                                         .multiply(new BigDecimal(1).subtract(painting.getLoss())),
                                                      10,
                                                      0
                                                   )
                                             )
                                       );
                                    } else if (painting.getPaintingType().equals(PaintingTypeEnum.INTERMEDIATE_PAINT.getType())) {
                                       if (dto.getIntermediateMeasure() == null) {
                                          dto.setIntermediateMeasure(BigDecimal.ZERO);
                                       }

                                       dto.setIntermediateMeasure(
                                          dto.getIntermediateMeasure()
                                             .add(
                                                surfaceArea.divide(new BigDecimal(1000000), 10, 0)
                                                   .multiply(painting.getThickness())
                                                   .divide(
                                                      painting.getVolumeSolids()
                                                         .multiply(new BigDecimal(10))
                                                         .multiply(new BigDecimal(1).subtract(painting.getLoss())),
                                                      10,
                                                      0
                                                   )
                                             )
                                       );
                                    } else if (painting.getPaintingType().equals(PaintingTypeEnum.TOPCOAT.getType())) {
                                       if (dto.getTopcoatMeasure() == null) {
                                          dto.setTopcoatMeasure(BigDecimal.ZERO);
                                       }

                                       dto.setTopcoatMeasure(
                                          dto.getTopcoatMeasure()
                                             .add(
                                                surfaceArea.divide(new BigDecimal(1000000), 10, 0)
                                                   .multiply(painting.getThickness())
                                                   .divide(
                                                      painting.getVolumeSolids()
                                                         .multiply(new BigDecimal(10))
                                                         .multiply(new BigDecimal(1).subtract(painting.getLoss())),
                                                      10,
                                                      0
                                                   )
                                             )
                                       );
                                    }
                                 }
                              );
                        }
                     }
                  );
               return dto;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<ArtifactPaintingDTO> artifactList(Long projectId, Long monomerId, Long configId, Long areaId, String serialNumber) {
      List<TechArtifact> artifactList = this.artifactService
         .list(
            Wrappers.lambdaQuery(TechArtifact.class)
               .eq(projectId != null, TechArtifact::getProjectId, projectId)
               .eq(monomerId != null, TechArtifact::getMonomerId, monomerId)
               .eq(TechArtifact::getStructureClassId, configId)
               .eq(areaId != null, TechArtifact::getAreaId, areaId)
               .like(serialNumber != null, TechArtifact::getSerialNumber, serialNumber)
         );
      if (artifactList.size() == 0) {
         return new ArrayList<>();
      }

      Map<Long, PlanArea> areaMap = this.areaService
         .listByIds(artifactList.stream().map(TechArtifact::getAreaId).distinct().collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(PlanArea::getId, Function.identity()));
      Map<Long, PlanMonomer> monomerMap = this.monomerService
         .listByIds(artifactList.stream().map(TechArtifact::getMonomerId).distinct().collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      return artifactList.stream().map(e -> {
         ArtifactPaintingDTO dto = BeanUtil.copy(e, ArtifactPaintingDTO.class);
         dto.setMonomer(MonomerDetailDO.builder().id(e.getMonomerId()).name(monomerMap.get(e.getMonomerId()).getName()).build());
         dto.setArea(AreaDetailDO.builder().id(e.getAreaId()).name(areaMap.get(e.getAreaId()).getName()).build());
         return dto;
      }).collect(Collectors.toList());
   }

   @Override
   public PageVO<ArtifactPaintingDTO> artifactPage(
      Long projectId, Long monomerId, Long configId, Long areaId, String serialNumber, Integer pageNumber, Integer pageSize
   ) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.artifactList(projectId, monomerId, configId, areaId, serialNumber));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean artifactSetting(List<ArtifactPaintingDTOParam> collect) {
      collect.forEach(
         e -> {
            TechArtifact artifact = this.artifactService.getById(e.getId());
            Preconditions.checkArgument(artifact != null, "操作失败：参数不正确");
            artifact.setSurfaceArea(e.getSurfaceArea());
            this.artifactService.updateById(artifact);
            this.priceBiz
               .list(
                  Wrappers.lambdaQuery(MesBuildingProduceTeamReportPrice.class)
                     .eq(MesBuildingProduceTeamReportPrice::getProductId, artifact.getId())
                     .eq(MesBuildingProduceTeamReportPrice::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
                     .eq(MesBuildingProduceTeamReportPrice::getWageQuotaType, WageQuotaTypeEnum.AREA_PRICE.getType())
               )
               .forEach(
                  price -> {
                     price.setPrice(
                        price.getWage()
                           .multiply(artifact.getSurfaceArea())
                           .multiply(BigDecimal.valueOf(price.getQuantity().intValue()))
                           .divide(BigDecimal.valueOf(1000000L))
                     );
                     this.priceBiz.updateById(price);
                  }
               );
         }
      );
      return Boolean.TRUE;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> artifactTypePaintingPrint(Long projectId, Long monomerId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (projectId != null) {
         header.put("project", this.projectService.getSimpleById(projectId));
      }

      if (monomerId != null) {
         header.put("monomer", BeanUtil.copy(this.monomerService.getById(monomerId), NameInfo.class));
      }

      printVO.setHeader(header);
      List<ArtifactTypePaintingDTO> doList = this.artifactTypePainting(projectId, monomerId);
      printVO.setTable(doList.stream().map(item -> BeanUtil.beanToMap(item)).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public ProductSummaryDTO artifactSummary(Long projectId, Long monomerId, Long configId, Long areaId, String serialNumber) {
      List<ArtifactPaintingDTO> artifactList = this.artifactList(projectId, monomerId, configId, areaId, serialNumber);
      return ProductSummaryDTO.builder()
         .quantity(artifactList.stream().mapToInt(ArtifactPaintingDTO::getQuantity).sum())
         .surfaceArea(
            artifactList.stream()
               .map(e -> e.getSurfaceArea().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
               .reduce(BigDecimal.ZERO, BigDecimal::add)
         )
         .build();
   }
}
