package com.hzchum.scim.mes.building.core.biz.impl.craft;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.craft.MesBuildingPaintCalculateRecordBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesBuildingPaintCalculateArtifact;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesBuildingPaintCalculateConsumption;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesBuildingPaintCalculateRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesBuildingPaintCalculateConsumptionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesBuildingPaintCalculateRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesBuildingPaintTechnologyDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesBuildingPaintTechnologyDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesBuildingPaintTechnologyProjectGroupDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintStructureClassDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintTechnologyArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesBuildingPaintCalculateConsumptionSaveParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesBuildingPaintCalculateRecordSaveParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesBuildingPaintTechnologyQueryParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintTechnologyArtifactQueryParam;
import com.hzchum.scim.mes.building.core.api.service.craft.MesBuildingPaintCalculateArtifactService;
import com.hzchum.scim.mes.building.core.api.service.craft.MesBuildingPaintCalculateConsumptionService;
import com.hzchum.scim.mes.building.core.api.service.craft.MesBuildingPaintCalculateRecordService;
import com.hzchum.scim.mes.building.core.api.service.craft.MesPaintConfigService;
import com.hzchum.scim.mes.building.core.mapper.craft.MesBuildingPaintCalculateRecordMapper;
import com.hzchum.scim.plan.core.api.enums.RangeTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechPaintTechnology;
import com.hzchum.scim.plan.core.api.pojo._do.TechPaintTechnologyArtifactLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechPaintTechnologyDetail;
import com.hzchum.scim.plan.core.api.pojo.dto.craft.TechPaintTechnologyDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.craft.TechPaintTechnologyProjectGroupDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologyQueryParam;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechPaintTechnologyArtifactLinkService;
import com.hzchum.scim.plan.core.api.service.TechPaintTechnologyDetailService;
import com.hzchum.scim.plan.core.api.service.TechPaintTechnologyService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
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
public class MesBuildingPaintCalculateRecordBizImpl
   extends IBizImpl<MesBuildingPaintCalculateRecordService, MesBuildingPaintCalculateRecordMapper, MesBuildingPaintCalculateRecord>
   implements MesBuildingPaintCalculateRecordBiz {
   private final ContractProjectService projectService;
   private final PlanMonomerService monomerService;
   private final PlanAreaService areaService;
   private final TechArtifactService artifactService;
   private final MesPaintConfigService paintConfigService;
   private final TechPaintTechnologyService paintTechnologyService;
   private final TechPaintTechnologyDetailService paintTechnologyDetailService;
   private final TechPaintTechnologyArtifactLinkService paintTechnologyArtifactLinkService;
   private final MesBuildingPaintCalculateConsumptionService paintCalculateConsumptionService;
   private final MesBuildingPaintCalculateArtifactService paintCalculateArtifactService;
   private final SysStructureClassificationService structureClassificationService;

   @Override
   public PageVO<MesBuildingPaintTechnologyProjectGroupDTO> pageListProjectPaintTechnology(
      MesBuildingPaintTechnologyQueryParam param, Integer pageNumber, Integer pageSize
   ) {
      TechPaintTechnologyQueryParam queryParam = BeanUtil.copy(param, TechPaintTechnologyQueryParam.class);
      List<TechPaintTechnologyProjectGroupDTO> technologyProjectGroupList = this.paintTechnologyService.listPaintTechnologyGroupByProject(queryParam);
      if (technologyProjectGroupList.isEmpty()) {
         return new PageVO<>();
      }

      List<Long> projectIds = technologyProjectGroupList.stream().map(TechPaintTechnologyProjectGroupDTO::getProjectId).collect(Collectors.toList());
      Map<Long, Map<Long, Map<Long, Integer>>> projectIdMonomerIdArtifactIdQuantityMap = this.artifactService
         .list(Wrappers.lambdaQuery(TechArtifact.class).in(TechArtifact::getProjectId, projectIds))
         .stream()
         .collect(
            Collectors.groupingBy(
               TechArtifact::getProjectId, Collectors.groupingBy(TechArtifact::getMonomerId, Collectors.toMap(TechArtifact::getId, TechArtifact::getQuantity))
            )
         );
      List<Long> paintTechnologyIds = new ArrayList<>(technologyProjectGroupList.size() * 4);
      technologyProjectGroupList.forEach(project -> project.getPaintTechnologyList().forEach(t -> paintTechnologyIds.add(t.getId())));
      Map<Long, TechPaintTechnology> paintTechnologyMap = this.paintTechnologyService
         .listByIds(paintTechnologyIds)
         .stream()
         .collect(Collectors.toMap(TechPaintTechnology::getId, Function.identity()));
      Map<Long, List<TechPaintTechnologyDetailDTO>> paintTechnologyIdDetailsMap = this.paintTechnologyDetailService
         .list(Wrappers.lambdaQuery(TechPaintTechnologyDetail.class).in(TechPaintTechnologyDetail::getPaintTechnologyId, paintTechnologyIds))
         .stream()
         .map(s -> BeanUtil.copy(s, TechPaintTechnologyDetailDTO.class))
         .collect(Collectors.groupingBy(TechPaintTechnologyDetailDTO::getPaintTechnologyId));
      Map<Long, Integer> paintTechnologyIdQuantityMap = new HashMap<>(paintTechnologyIds.size());
      List<Long> manualTechnologyIds = paintTechnologyIds.stream()
         .map(paintTechnologyMap::get)
         .filter(s -> s.getRangeTypeEnum().equals(RangeTypeEnum.MANUAL.getType()))
         .map(TechPaintTechnology::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(manualTechnologyIds)) {
         List<TechPaintTechnologyArtifactLink> paintTechnologyArtifactLinkList = this.paintTechnologyArtifactLinkService
            .list(Wrappers.lambdaQuery(TechPaintTechnologyArtifactLink.class).in(TechPaintTechnologyArtifactLink::getPaintTechnologyId, manualTechnologyIds));
         Map<Long, Integer> collect = paintTechnologyArtifactLinkList.stream()
            .collect(
               Collectors.groupingBy(
                  TechPaintTechnologyArtifactLink::getPaintTechnologyId,
                  Collectors.summingInt(
                     link -> projectIdMonomerIdArtifactIdQuantityMap.getOrDefault(link.getProjectId(), Collections.emptyMap())
                        .getOrDefault(link.getMonomerId(), Collections.emptyMap())
                        .getOrDefault(link.getArtifactId(), 0)
                  )
               )
            );
         paintTechnologyIdQuantityMap.putAll(collect);
      }

      List<TechPaintTechnology> monomerPaintTechnologyList = paintTechnologyIds.stream()
         .map(paintTechnologyMap::get)
         .filter(s -> s.getRangeTypeEnum().equals(RangeTypeEnum.MONOMER.getType()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(monomerPaintTechnologyList)) {
         monomerPaintTechnologyList.forEach(
            pt -> {
               Map<Long, Integer> artifactIdQuantityMap = projectIdMonomerIdArtifactIdQuantityMap.getOrDefault(pt.getProjectId(), Collections.emptyMap())
                  .getOrDefault(pt.getMonomerId(), Collections.emptyMap());
               int sum = artifactIdQuantityMap.values().stream().mapToInt(Integer::intValue).sum();
               paintTechnologyIdQuantityMap.put(pt.getId(), sum);
            }
         );
      }

      List<TechPaintTechnology> projectPaintTechnologyList = paintTechnologyIds.stream()
         .map(paintTechnologyMap::get)
         .filter(s -> s.getRangeTypeEnum().equals(RangeTypeEnum.PROJECT.getType()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(projectPaintTechnologyList)) {
         projectPaintTechnologyList.forEach(
            pt -> {
               Map<Long, Map<Long, Integer>> monomerIdArtifactIdQuantityMap = projectIdMonomerIdArtifactIdQuantityMap.getOrDefault(
                  pt.getProjectId(), Collections.emptyMap()
               );
               int sum = monomerIdArtifactIdQuantityMap.values().stream().mapToInt(map -> map.values().stream().mapToInt(Integer::intValue).sum()).sum();
               paintTechnologyIdQuantityMap.put(pt.getId(), sum);
            }
         );
      }

      Map<Long, Integer> paintTechnologyIdCalculateQuantityMap = this.paintCalculateArtifactService
         .list(Wrappers.lambdaQuery(MesBuildingPaintCalculateArtifact.class).in(MesBuildingPaintCalculateArtifact::getPaintTechnologyId, paintTechnologyIds))
         .stream()
         .filter(
            link -> projectIdMonomerIdArtifactIdQuantityMap.getOrDefault(link.getProjectId(), Collections.emptyMap())
               .getOrDefault(link.getMonomerId(), Collections.emptyMap())
               .containsKey(link.getArtifactId())
         )
         .collect(
            Collectors.groupingBy(
               MesBuildingPaintCalculateArtifact::getPaintTechnologyId, Collectors.summingInt(MesBuildingPaintCalculateArtifact::getQuantity)
            )
         );
      Map<Long, BigDecimal> paintTechnologyIdWeightMap = this.paintCalculateConsumptionService
         .list(
            Wrappers.lambdaQuery(MesBuildingPaintCalculateConsumption.class).in(MesBuildingPaintCalculateConsumption::getPaintTechnologyId, paintTechnologyIds)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               MesBuildingPaintCalculateConsumption::getPaintTechnologyId,
               Collectors.reducing(BigDecimal.ZERO, MesBuildingPaintCalculateConsumption::getPaintWeight, BigDecimal::add)
            )
         );
      List<MesBuildingPaintTechnologyProjectGroupDTO> resultList = new ArrayList<>(technologyProjectGroupList.size());
      technologyProjectGroupList.forEach(
         project -> {
            Map<Long, Map<Long, Integer>> monomerIdArtifactIdQuantityMap = projectIdMonomerIdArtifactIdQuantityMap.getOrDefault(
               project.getProjectId(), Collections.emptyMap()
            );
            int sum = monomerIdArtifactIdQuantityMap.values().stream().mapToInt(map -> map.values().stream().mapToInt(Integer::intValue).sum()).sum();
            MesBuildingPaintTechnologyProjectGroupDTO resultDto = new MesBuildingPaintTechnologyProjectGroupDTO();
            resultDto.setProjectId(project.getProjectId());
            resultDto.setProject(project.getProject());
            resultDto.setTotalQuantity(sum);
            List<MesBuildingPaintTechnologyDTO> paintTechnologyList = new ArrayList<>(project.getPaintTechnologyList().size());
            project.getPaintTechnologyList()
               .forEach(
                  pt -> {
                     MesBuildingPaintTechnologyDTO copy = BeanUtil.copy(pt, MesBuildingPaintTechnologyDTO.class);
                     List<TechPaintTechnologyDetailDTO> technologyDetailDTOList = paintTechnologyIdDetailsMap.get(pt.getId());
                     List<MesBuildingPaintTechnologyDetailDTO> paintTechnologyDetailList = technologyDetailDTOList.stream()
                        .map(s -> BeanUtil.copy(s, MesBuildingPaintTechnologyDetailDTO.class))
                        .collect(Collectors.toList());
                     copy.setPaintTechnologyDetailList(paintTechnologyDetailList);
                     Integer relationQuantity = paintTechnologyIdQuantityMap.getOrDefault(pt.getId(), 0);
                     copy.setQuantity(relationQuantity);
                     copy.setPaintWeight(paintTechnologyIdWeightMap.getOrDefault(pt.getId(), BigDecimal.ZERO));
                     Integer calculateQuantity = paintTechnologyIdCalculateQuantityMap.getOrDefault(pt.getId(), 0);
                     copy.setPaintCalculateStatus(
                        calculateQuantity >= relationQuantity
                           ? MesBuildingPaintCalculateRecordBizImpl.PaintCalculateStatusEnum.ALL.getType()
                           : (
                              calculateQuantity == 0
                                 ? MesBuildingPaintCalculateRecordBizImpl.PaintCalculateStatusEnum.NOT.getType()
                                 : MesBuildingPaintCalculateRecordBizImpl.PaintCalculateStatusEnum.PART.getType()
                           )
                     );
                     paintTechnologyList.add(copy);
                  }
               );
            resultDto.setPaintTechnologyList(paintTechnologyList);
            resultList.add(resultDto);
         }
      );
      if (param.getPaintCalculateStatus() != null) {
         List<MesBuildingPaintTechnologyProjectGroupDTO> newResultList = resultList.stream()
            .peek(
               result -> {
                  List<MesBuildingPaintTechnologyDTO> collect = result.getPaintTechnologyList()
                     .stream()
                     .filter(pt -> param.getPaintCalculateStatus().equals(pt.getPaintCalculateStatus()))
                     .collect(Collectors.toList());
                  result.setPaintTechnologyList(collect);
               }
            )
            .filter(s -> CollectionUtils.isNotEmpty(s.getPaintTechnologyList()))
            .collect(Collectors.toList());
         return PageUtil.listPage(pageNumber, pageSize, newResultList);
      } else {
         return PageUtil.listPage(pageNumber, pageSize, resultList);
      }
   }

   @Override
   public List<MesPaintStructureClassDTO> getUnCalculateStructureClassList(Long paintTechnologyId) {
      TechPaintTechnology paintTechnology = this.paintTechnologyService.getById(paintTechnologyId);
      Preconditions.checkArgument(paintTechnology != null, "涂装工艺未创建!");
      List<TechArtifact> artifactList = this.getRelationArtifactList(paintTechnology);
      if (artifactList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, Integer> artifactIdCalculateQuantityMap = this.paintCalculateArtifactService
         .list(Wrappers.lambdaQuery(MesBuildingPaintCalculateArtifact.class).eq(MesBuildingPaintCalculateArtifact::getPaintTechnologyId, paintTechnologyId))
         .stream()
         .collect(
            Collectors.groupingBy(MesBuildingPaintCalculateArtifact::getArtifactId, Collectors.summingInt(MesBuildingPaintCalculateArtifact::getQuantity))
         );
      artifactList = artifactList.stream()
         .filter(artifact -> artifactIdCalculateQuantityMap.getOrDefault(artifact.getId(), 0) < artifact.getQuantity())
         .peek(artifact -> {
            int residualQuantity = artifact.getQuantity() - artifactIdCalculateQuantityMap.getOrDefault(artifact.getId(), 0);
            artifact.setQuantity(residualQuantity);
         })
         .collect(Collectors.toList());
      if (artifactList.isEmpty()) {
         return Collections.emptyList();
      }

      List<Long> structureClassIds = artifactList.stream().map(TechArtifact::getStructureClassId).distinct().sorted().collect(Collectors.toList());
      Map<Long, Integer> structureClassIdTotalQuantityMap = artifactList.stream()
         .collect(Collectors.groupingBy(TechArtifact::getStructureClassId, Collectors.summingInt(TechArtifact::getQuantity)));
      Map<Long, BigDecimal> structureClassIdTotalAreaMap = artifactList.stream()
         .collect(
            Collectors.groupingBy(
               TechArtifact::getStructureClassId,
               Collectors.reducing(
                  BigDecimal.ZERO,
                  a -> a.getSurfaceArea().multiply(BigDecimal.valueOf(a.getQuantity().intValue())).divide(BigDecimal.valueOf(1000000L)),
                  BigDecimal::add
               )
            )
         );
      Map<Long, String> structureClassIdNameMap = this.structureClassificationService
         .listByIds(structureClassIds)
         .stream()
         .collect(Collectors.toMap(SysStructureClassification::getId, SysStructureClassification::getClassificationName));
      List<MesPaintStructureClassDTO> structureClassList = new ArrayList<>(structureClassIds.size());
      structureClassIds.forEach(
         id -> {
            MesPaintStructureClassDTO structureClassDTO = MesPaintStructureClassDTO.builder()
               .structureClassId(id)
               .structureClassName(structureClassIdNameMap.get(id))
               .quantity(structureClassIdTotalQuantityMap.get(id))
               .totalArea(structureClassIdTotalAreaMap.getOrDefault(id, BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP))
               .build();
            structureClassList.add(structureClassDTO);
         }
      );
      return structureClassList;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean savePaintCalculateRecord(MesBuildingPaintCalculateRecordSaveParam param) {
      TechPaintTechnology paintTechnology = this.paintTechnologyService.getById(param.getPaintTechnologyId());
      Preconditions.checkArgument(paintTechnology != null, "涂装工艺未创建!");
      Map<Integer, TechPaintTechnologyDetail> paintingTypeEnumDetailMap = this.paintTechnologyDetailService
         .list(Wrappers.lambdaQuery(TechPaintTechnologyDetail.class).eq(TechPaintTechnologyDetail::getPaintTechnologyId, param.getPaintTechnologyId()))
         .stream()
         .collect(Collectors.toMap(TechPaintTechnologyDetail::getPaintingTypeEnum, Function.identity()));
      Set<Long> paintConfigIds = param.getPaintCalculateConsumptionList()
         .stream()
         .map(MesBuildingPaintCalculateConsumptionSaveParam::getPaintConfigId)
         .collect(Collectors.toSet());
      Map<Long, MesPaintConfig> paintConfigMap = this.paintConfigService
         .listByIds(paintConfigIds)
         .stream()
         .collect(Collectors.toMap(MesPaintConfig::getId, Function.identity()));
      Map<Integer, List<MesBuildingPaintCalculateConsumptionSaveParam>> paintingTypeEnumConsumptionMap = param.getPaintCalculateConsumptionList()
         .stream()
         .collect(Collectors.groupingBy(MesBuildingPaintCalculateConsumptionSaveParam::getPaintingTypeEnum));
      paintingTypeEnumConsumptionMap.forEach((paintingTypeEnum, consumptionSaveParamList) -> {
         Preconditions.checkArgument(consumptionSaveParamList.size() == 1, "喷漆类型出现重复!");
         Preconditions.checkArgument(paintingTypeEnumDetailMap.containsKey(paintingTypeEnum), "喷漆类型出错!");
         Long paintConfigId = consumptionSaveParamList.get(0).getPaintConfigId();
         Preconditions.checkArgument(paintConfigMap.get(paintConfigId) != null, "油漆品牌和材质选择有误!");
      });
      if (param.getId() != null) {
         MesBuildingPaintCalculateRecord calculateRecord = this.baseService.getById(param.getId());
         Preconditions.checkArgument(calculateRecord != null, "原有工艺单不存在!");
         Map<Integer, MesBuildingPaintCalculateConsumption> calculateConsumptionMap = this.paintCalculateConsumptionService
            .list(
               Wrappers.lambdaQuery(MesBuildingPaintCalculateConsumption.class)
                  .eq(MesBuildingPaintCalculateConsumption::getPaintCalculateRecordId, param.getId())
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingPaintCalculateConsumption::getPaintingTypeEnum, Function.identity()));
         paintingTypeEnumConsumptionMap.forEach((paintingTypeEnum, consumptionSaveParamList) -> {
            MesBuildingPaintCalculateConsumptionSaveParam consumptionSaveParam = consumptionSaveParamList.get(0);
            MesBuildingPaintCalculateConsumption calculateConsumption = calculateConsumptionMap.get(paintingTypeEnum);
            calculateConsumption.setTotalArea(calculateConsumption.getTotalArea().add(consumptionSaveParam.getTotalArea()));
            calculateConsumption.setGroupQuantity(calculateConsumption.getGroupQuantity().add(consumptionSaveParam.getGroupQuantity()));
            calculateConsumption.setPaintWeight(calculateConsumption.getPaintWeight().add(consumptionSaveParam.getPaintWeight()));
         });
         this.paintCalculateConsumptionService.updateBatchById(calculateConsumptionMap.values());
      } else {
         MesBuildingPaintCalculateRecord record = MesBuildingPaintCalculateRecord.builder()
            .paintTechnologyId(param.getPaintTechnologyId())
            .serialNumber(paintTechnology.getSerialNumber() + "-" + (paintTechnology.getMaxCalculateNumber() + 1))
            .projectId(paintTechnology.getProjectId())
            .createUserId(UserUtil.getCurrentUserId())
            .createUserName(UserUtil.getCurrentName())
            .build();
         this.baseService.save(record);
         param.setId(record.getId());
         paintTechnology.setMaxCalculateNumber(paintTechnology.getMaxCalculateNumber() + 1);
         this.paintTechnologyService.updateById(paintTechnology);
         param.getPaintCalculateConsumptionList().forEach(consumptionSaveParam -> {
            MesPaintConfig paintConfig = paintConfigMap.get(consumptionSaveParam.getPaintConfigId());
            TechPaintTechnologyDetail paintTechnologyDetail = paintingTypeEnumDetailMap.get(consumptionSaveParam.getPaintingTypeEnum());
            MesBuildingPaintCalculateConsumption consumption = BeanUtil.copy(consumptionSaveParam, MesBuildingPaintCalculateConsumption.class);
            consumption.setProjectId(paintTechnology.getProjectId());
            consumption.setPaintTechnologyId(param.getPaintTechnologyId());
            consumption.setPaintCalculateRecordId(record.getId());
            consumption.setPaintType(paintConfig.getPaintType());
            consumption.setPaintBrand(paintConfig.getPaintBrand());
            consumption.setPaintColor(paintTechnologyDetail.getPaintColor());
            this.paintCalculateConsumptionService.save(consumption);
         });
      }

      this.saveCalculateArtifact(paintTechnology, param.getId(), param.getStructureClassIdList());
      return true;
   }

   private void saveCalculateArtifact(TechPaintTechnology paintTechnology, Long recordId, Collection<Long> structureClassIdList) {
      List<TechArtifact> artifactList = this.getRelationArtifactList(paintTechnology);
      Map<Long, Map<Long, Integer>> structureClassIdArtifactIdQuantityMap = artifactList.stream()
         .collect(Collectors.groupingBy(TechArtifact::getStructureClassId, Collectors.toMap(TechArtifact::getId, TechArtifact::getQuantity)));
      Map<Long, Map<Long, Integer>> structureClassIdArtifactIdCalculateQuantityMap = this.paintCalculateArtifactService
         .list(
            Wrappers.lambdaQuery(MesBuildingPaintCalculateArtifact.class).eq(MesBuildingPaintCalculateArtifact::getPaintTechnologyId, paintTechnology.getId())
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               MesBuildingPaintCalculateArtifact::getStructureClassId,
               Collectors.groupingBy(MesBuildingPaintCalculateArtifact::getArtifactId, Collectors.summingInt(MesBuildingPaintCalculateArtifact::getQuantity))
            )
         );
      Map<Long, TechArtifact> artifactMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      structureClassIdList.forEach(
         structureClassId -> {
            Map<Long, Integer> artifactIdQuantityMap = structureClassIdArtifactIdQuantityMap.get(structureClassId);
            Preconditions.checkArgument(artifactIdQuantityMap != null, "构件类型有误!");
            int sumRelationQuantity = artifactIdQuantityMap.values().stream().mapToInt(Integer::intValue).sum();
            Map<Long, Integer> artifactIdCalculateQuantityMap = structureClassIdArtifactIdCalculateQuantityMap.getOrDefault(
               structureClassId, Collections.emptyMap()
            );
            int sumCalculateQuantity = artifactIdCalculateQuantityMap.values().stream().mapToInt(Integer::intValue).sum();
            Preconditions.checkArgument(sumRelationQuantity > sumCalculateQuantity, "构件数量不足!");
            List<MesBuildingPaintCalculateArtifact> paintCalculateArtifactList = new ArrayList<>(artifactIdQuantityMap.size());
            artifactIdQuantityMap.forEach(
               (artifactId, totalQuantity) -> {
                  Integer calculateQuantity = artifactIdCalculateQuantityMap.getOrDefault(artifactId, 0);
                  if (totalQuantity > calculateQuantity) {
                     TechArtifact artifact = artifactMap.get(artifactId);
                     MesBuildingPaintCalculateArtifact paintCalculateArtifact = MesBuildingPaintCalculateArtifact.builder()
                        .paintTechnologyId(paintTechnology.getId())
                        .paintCalculateRecordId(recordId)
                        .structureClassId(structureClassId)
                        .projectId(artifact.getProjectId())
                        .monomerId(artifact.getMonomerId())
                        .areaId(artifact.getAreaId())
                        .artifactId(artifactId)
                        .quantity(totalQuantity - calculateQuantity)
                        .build();
                     paintCalculateArtifactList.add(paintCalculateArtifact);
                  }
               }
            );
            this.paintCalculateArtifactService.saveBatch(paintCalculateArtifactList);
         }
      );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean removeCalculateRecord(List<Long> calculateRecordIds) {
      calculateRecordIds.forEach(id -> {
         MesBuildingPaintCalculateRecord calculateRecord = this.baseService.getById(id);
         Preconditions.checkArgument(calculateRecord != null, "计算记录不存在!");
         this.paintCalculateConsumptionService.remove(Wrappers.lambdaQuery(MesBuildingPaintCalculateConsumption.builder().paintCalculateRecordId(id).build()));
         this.paintCalculateArtifactService.remove(Wrappers.lambdaQuery(MesBuildingPaintCalculateArtifact.builder().paintCalculateRecordId(id).build()));
         calculateRecord.setRemoveUserId(UserUtil.getCurrentUserId());
         calculateRecord.setRemoveUserName(UserUtil.getCurrentName());
         calculateRecord.setRemoveTime(LocalDateTime.now());
         this.baseService.updateById(calculateRecord);
         this.baseService.removeById(id);
      });
      return true;
   }

   @Override
   public List<MesBuildingPaintCalculateRecordDTO> listPaintCalculateRecord(Long paintTechnologyId) {
      TechPaintTechnology paintTechnology = this.paintTechnologyService.getById(paintTechnologyId);
      Preconditions.checkArgument(paintTechnology != null, "涂装工艺不存在!");
      ProjectInfo projectInfo = this.projectService.getSimpleById(paintTechnology.getProjectId());
      List<MesBuildingPaintCalculateRecord> paintCalculateRecordList = this.baseService
         .list(Wrappers.lambdaQuery(MesBuildingPaintCalculateRecord.class).eq(MesBuildingPaintCalculateRecord::getPaintTechnologyId, paintTechnologyId));
      List<MesBuildingPaintCalculateRecordDTO> paintCalculateRecordDTOList = new ArrayList<>(paintCalculateRecordList.size());
      if (CollectionUtils.isNotEmpty(paintCalculateRecordList)) {
         Map<Long, List<MesBuildingPaintCalculateConsumptionDTO>> recordIdCalculateConsumptionListMap = this.paintCalculateConsumptionService
            .list(
               Wrappers.lambdaQuery(MesBuildingPaintCalculateConsumption.class)
                  .eq(MesBuildingPaintCalculateConsumption::getPaintTechnologyId, paintTechnologyId)
            )
            .stream()
            .map(c -> BeanUtil.copy(c, MesBuildingPaintCalculateConsumptionDTO.class))
            .collect(Collectors.groupingBy(MesBuildingPaintCalculateConsumptionDTO::getPaintCalculateRecordId));
         List<MesBuildingPaintCalculateArtifact> paintCalculateArtifactList = this.paintCalculateArtifactService
            .list(Wrappers.lambdaQuery(MesBuildingPaintCalculateArtifact.class).eq(MesBuildingPaintCalculateArtifact::getPaintTechnologyId, paintTechnologyId));
         List<TechArtifact> artifactList = this.artifactService
            .listByIds(paintCalculateArtifactList.stream().map(MesBuildingPaintCalculateArtifact::getArtifactId).collect(Collectors.toSet()));
         Map<Long, BigDecimal> artifactIdWeightMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getId, TechArtifact::getNetWeight));
         Map<Long, BigDecimal> artifactIdSurfaceAreaMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getId, TechArtifact::getSurfaceArea));
         Map<Long, Map<Long, Integer>> recordIdStructureClassIdQuantityMap = paintCalculateArtifactList.stream()
            .collect(
               Collectors.groupingBy(
                  MesBuildingPaintCalculateArtifact::getPaintCalculateRecordId,
                  Collectors.groupingBy(
                     MesBuildingPaintCalculateArtifact::getStructureClassId, Collectors.summingInt(MesBuildingPaintCalculateArtifact::getQuantity)
                  )
               )
            );
         Map<Long, Map<Long, BigDecimal>> recordIdStructureClassIdAreaMap = paintCalculateArtifactList.stream()
            .collect(
               Collectors.groupingBy(
                  MesBuildingPaintCalculateArtifact::getPaintCalculateRecordId,
                  Collectors.groupingBy(
                     MesBuildingPaintCalculateArtifact::getStructureClassId,
                     Collectors.reducing(
                        BigDecimal.ZERO,
                        s -> artifactIdSurfaceAreaMap.getOrDefault(s.getArtifactId(), BigDecimal.ZERO)
                           .multiply(BigDecimal.valueOf(s.getQuantity().intValue()))
                           .divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP),
                        BigDecimal::add
                     )
                  )
               )
            );
         Map<Long, Map<Long, BigDecimal>> recordIdStructureClassIdTonMap = paintCalculateArtifactList.stream()
            .collect(
               Collectors.groupingBy(
                  MesBuildingPaintCalculateArtifact::getPaintCalculateRecordId,
                  Collectors.groupingBy(
                     MesBuildingPaintCalculateArtifact::getStructureClassId,
                     Collectors.reducing(
                        BigDecimal.ZERO,
                        s -> artifactIdWeightMap.getOrDefault(s.getArtifactId(), BigDecimal.ZERO)
                           .multiply(BigDecimal.valueOf(s.getQuantity().intValue()))
                           .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP),
                        BigDecimal::add
                     )
                  )
               )
            );
         Map<Long, String> structureClassIdNameMap = this.structureClassificationService
            .list()
            .stream()
            .collect(Collectors.toMap(SysStructureClassification::getId, SysStructureClassification::getClassificationName));
         paintCalculateRecordList.forEach(
            record -> {
               Map<Long, Integer> structureClassIdQuantityMap = recordIdStructureClassIdQuantityMap.get(record.getId());
               List<MesPaintStructureClassDTO> structureClassList = new ArrayList<>(structureClassIdQuantityMap.size());
               structureClassIdQuantityMap.forEach(
                  (structureClassId, totalQuantity) -> {
                     MesPaintStructureClassDTO structureClassDTO = MesPaintStructureClassDTO.builder()
                        .projectId(record.getProjectId())
                        .structureClassId(structureClassId)
                        .structureClassName(structureClassIdNameMap.get(structureClassId))
                        .quantity(totalQuantity)
                        .totalWeight(recordIdStructureClassIdTonMap.get(record.getId()).get(structureClassId))
                        .totalArea(recordIdStructureClassIdAreaMap.get(record.getId()).get(structureClassId))
                        .build();
                     structureClassList.add(structureClassDTO);
                  }
               );
               MesBuildingPaintCalculateRecordDTO recordDTO = MesBuildingPaintCalculateRecordDTO.builder()
                  .id(record.getId())
                  .projectId(record.getProjectId())
                  .project(projectInfo)
                  .serialNumber(record.getSerialNumber())
                  .createUserId(record.getCreateUserId())
                  .createUserName(record.getCreateUserName())
                  .createTime(record.getCreateTime())
                  .paintCalculateConsumptionList(recordIdCalculateConsumptionListMap.get(record.getId()))
                  .structureClassList(structureClassList)
                  .build();
               paintCalculateRecordDTOList.add(recordDTO);
            }
         );
      }

      return paintCalculateRecordDTOList;
   }

   @Override
   public PrintVO<List<MesPaintStructureClassDTO>> printListPaintCalculateRecord(Long calculateRecordId) {
      MesBuildingPaintCalculateRecord paintCalculateRecord = this.baseService.getById(calculateRecordId);
      Preconditions.checkArgument(paintCalculateRecord != null, "油漆计算记录不存在!");
      List<MesBuildingPaintCalculateConsumption> consumptionList = this.paintCalculateConsumptionService
         .list(
            Wrappers.lambdaQuery(MesBuildingPaintCalculateConsumption.class)
               .eq(MesBuildingPaintCalculateConsumption::getPaintCalculateRecordId, calculateRecordId)
         );
      List<MesBuildingPaintCalculateArtifact> paintCalculateArtifactList = this.paintCalculateArtifactService
         .list(
            Wrappers.lambdaQuery(MesBuildingPaintCalculateArtifact.class).eq(MesBuildingPaintCalculateArtifact::getPaintCalculateRecordId, calculateRecordId)
         );
      Set<Long> artifactIds = paintCalculateArtifactList.stream().map(MesBuildingPaintCalculateArtifact::getArtifactId).collect(Collectors.toSet());
      List<TechArtifact> artifactList = this.artifactService.listByIds(artifactIds);
      Map<Long, BigDecimal> artifactIdWeightMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getId, TechArtifact::getNetWeight));
      Map<Long, BigDecimal> artifactIdSurfaceAreaMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getId, TechArtifact::getSurfaceArea));
      Map<Long, Integer> structureClassIdQuantityMap = paintCalculateArtifactList.stream()
         .collect(
            Collectors.groupingBy(MesBuildingPaintCalculateArtifact::getStructureClassId, Collectors.summingInt(MesBuildingPaintCalculateArtifact::getQuantity))
         );
      Map<Long, BigDecimal> structureClassIdTonMap = paintCalculateArtifactList.stream()
         .collect(
            Collectors.groupingBy(
               MesBuildingPaintCalculateArtifact::getStructureClassId,
               Collectors.reducing(
                  BigDecimal.ZERO,
                  s -> artifactIdWeightMap.getOrDefault(s.getArtifactId(), BigDecimal.ZERO)
                     .multiply(BigDecimal.valueOf(s.getQuantity().intValue()))
                     .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP),
                  BigDecimal::add
               )
            )
         );
      Map<Long, BigDecimal> structureClassIdAreaMap = paintCalculateArtifactList.stream()
         .collect(
            Collectors.groupingBy(
               MesBuildingPaintCalculateArtifact::getStructureClassId,
               Collectors.reducing(
                  BigDecimal.ZERO,
                  s -> artifactIdSurfaceAreaMap.getOrDefault(s.getArtifactId(), BigDecimal.ZERO)
                     .multiply(BigDecimal.valueOf(s.getQuantity().intValue()))
                     .divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP),
                  BigDecimal::add
               )
            )
         );
      Map<Long, String> structureClassIdNameMap = this.structureClassificationService
         .listByIds(structureClassIdQuantityMap.keySet())
         .stream()
         .collect(Collectors.toMap(SysStructureClassification::getId, SysStructureClassification::getClassificationName));
      List<MesPaintStructureClassDTO> structureClassList = new ArrayList<>(structureClassIdQuantityMap.size());
      structureClassIdQuantityMap.forEach(
         (structureClassId, totalQuantity) -> {
            MesPaintStructureClassDTO structureClassDTO = MesPaintStructureClassDTO.builder()
               .projectId(paintCalculateRecord.getProjectId())
               .structureClassId(structureClassId)
               .structureClassName(structureClassIdNameMap.get(structureClassId))
               .quantity(totalQuantity)
               .totalWeight(structureClassIdTonMap.get(structureClassId))
               .totalArea(structureClassIdAreaMap.get(structureClassId))
               .build();
            structureClassList.add(structureClassDTO);
         }
      );
      PrintVO<List<MesPaintStructureClassDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("serialNumber", paintCalculateRecord.getSerialNumber());
      header.put("consumptionList", consumptionList);
      printVO.setHeader(header);
      printVO.setTable(structureClassList);
      return printVO;
   }

   @Override
   public PageVO<MesPaintTechnologyArtifactDTO> calculateRecordArtifactList(MesPaintTechnologyArtifactQueryParam param, Integer pageNumber, Integer pageSize) {
      MesBuildingPaintCalculateRecord paintCalculateRecord = this.baseService.getById(param.getCalculateRecordId());
      Preconditions.checkArgument(paintCalculateRecord != null, "油漆计算记录不存在!");
      param.setProjectId(paintCalculateRecord.getProjectId());
      List<MesPaintTechnologyArtifactDTO> calculateRecordStructureClassArtifactList = this.getCalculateRecordStructureClassArtifactList(param);
      return PageUtil.listPage(pageNumber, pageSize, calculateRecordStructureClassArtifactList);
   }

   private List<MesPaintTechnologyArtifactDTO> getCalculateRecordStructureClassArtifactList(MesPaintTechnologyArtifactQueryParam param) {
      List<MesBuildingPaintCalculateArtifact> calculateArtifactList = this.paintCalculateArtifactService
         .list(
            Wrappers.lambdaQuery(MesBuildingPaintCalculateArtifact.class)
               .eq(param.getCalculateRecordId() != null, MesBuildingPaintCalculateArtifact::getPaintCalculateRecordId, param.getCalculateRecordId())
               .eq(param.getStructureClassId() != null, MesBuildingPaintCalculateArtifact::getStructureClassId, param.getStructureClassId())
               .eq(param.getProjectId() != null, MesBuildingPaintCalculateArtifact::getProjectId, param.getProjectId())
               .eq(param.getMonomerId() != null, MesBuildingPaintCalculateArtifact::getMonomerId, param.getMonomerId())
               .eq(param.getAreaId() != null, MesBuildingPaintCalculateArtifact::getAreaId, param.getAreaId())
         );
      if (calculateArtifactList.isEmpty()) {
         return Collections.emptyList();
      }

      List<Long> artifactIds = calculateArtifactList.stream().map(MesBuildingPaintCalculateArtifact::getArtifactId).collect(Collectors.toList());
      List<TechArtifact> artifactList = this.artifactService
         .list(
            Wrappers.lambdaQuery(TechArtifact.class)
               .in(TechArtifact::getId, artifactIds)
               .eq(param.getProjectId() != null, TechArtifact::getProjectId, param.getProjectId())
               .eq(param.getMonomerId() != null, TechArtifact::getMonomerId, param.getMonomerId())
               .eq(param.getAreaId() != null, TechArtifact::getAreaId, param.getAreaId())
               .like(StringUtils.isNotBlank(param.getSerialNumber()), TechArtifact::getSerialNumber, param.getSerialNumber())
         );
      if (artifactList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, TechArtifact> artifactMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      Map<Long, NameInfo> monomerMap = this.monomerService
         .list(Wrappers.lambdaQuery(PlanMonomer.builder().projectId(param.getProjectId()).build()))
         .stream()
         .map(m -> NameInfo.builder().id(m.getId()).name(m.getName()).build())
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      Map<Long, NameInfo> areaMap = this.areaService
         .list(Wrappers.lambdaQuery(PlanArea.builder().projectId(param.getProjectId()).build()))
         .stream()
         .map(m -> NameInfo.builder().id(m.getId()).name(m.getName()).build())
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      List<MesPaintTechnologyArtifactDTO> calculateRecordStructureClassArtifactList = new ArrayList<>(calculateArtifactList.size());
      calculateArtifactList.forEach(
         ca -> {
            TechArtifact artifact = artifactMap.get(ca.getArtifactId());
            MesPaintTechnologyArtifactDTO copy = MesPaintTechnologyArtifactDTO.builder()
               .artifactId(ca.getArtifactId())
               .quantity(ca.getQuantity())
               .monomer(monomerMap.get(ca.getMonomerId()))
               .area(areaMap.get(ca.getAreaId()))
               .build();
            if (artifact != null) {
               copy.setName(artifact.getName());
               copy.setSerialNumber(artifact.getSerialNumber());
               copy.setSpecification(artifact.getSpecification());
               copy.setSurfaceArea(artifact.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP));
               copy.setTotalArea(
                  artifact.getSurfaceArea()
                     .multiply(BigDecimal.valueOf(ca.getQuantity().intValue()))
                     .divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP)
               );
            }

            calculateRecordStructureClassArtifactList.add(copy);
         }
      );
      return calculateRecordStructureClassArtifactList;
   }

   @Override
   public PrintVO<List<MesPaintTechnologyArtifactDTO>> printCalculateRecordArtifactList(MesPaintTechnologyArtifactQueryParam param) {
      MesBuildingPaintCalculateRecord paintCalculateRecord = this.baseService.getById(param.getCalculateRecordId());
      Preconditions.checkArgument(paintCalculateRecord != null, "油漆计算记录不存在!");
      PrintVO<List<MesPaintTechnologyArtifactDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("project", this.projectService.getSimpleById(paintCalculateRecord.getProjectId()));
      header.put("serialNumber", paintCalculateRecord.getSerialNumber());
      header.put("createUserName", paintCalculateRecord.getCreateUserName());
      header.put("createTime", paintCalculateRecord.getCreateTime());
      printVO.setHeader(header);
      param.setProjectId(paintCalculateRecord.getProjectId());
      List<MesPaintTechnologyArtifactDTO> calculateRecordStructureClassArtifactList = this.getCalculateRecordStructureClassArtifactList(param);
      printVO.setTable(calculateRecordStructureClassArtifactList);
      return printVO;
   }

   private List<TechArtifact> getRelationArtifactList(TechPaintTechnology paintTechnology) {
      List<TechArtifact> artifactList;
      if (paintTechnology.getRangeTypeEnum().equals(RangeTypeEnum.MANUAL.getType())) {
         List<TechPaintTechnologyArtifactLink> linkList = this.paintTechnologyArtifactLinkService
            .list(
               Wrappers.lambdaQuery(TechPaintTechnologyArtifactLink.class).eq(TechPaintTechnologyArtifactLink::getPaintTechnologyId, paintTechnology.getId())
            );
         List<Long> artifactIds = linkList.stream().map(TechPaintTechnologyArtifactLink::getArtifactId).collect(Collectors.toList());
         artifactList = this.artifactService.listByIds(artifactIds);
      } else if (paintTechnology.getRangeTypeEnum().equals(RangeTypeEnum.PROJECT.getType())) {
         artifactList = this.artifactService.list(Wrappers.lambdaQuery(TechArtifact.builder().projectId(paintTechnology.getProjectId()).build()));
      } else {
         artifactList = this.artifactService.list(Wrappers.lambdaQuery(TechArtifact.builder().monomerId(paintTechnology.getMonomerId()).build()));
      }

      return artifactList;
   }

   public MesBuildingPaintCalculateRecordBizImpl(
      final ContractProjectService projectService,
      final PlanMonomerService monomerService,
      final PlanAreaService areaService,
      final TechArtifactService artifactService,
      final MesPaintConfigService paintConfigService,
      final TechPaintTechnologyService paintTechnologyService,
      final TechPaintTechnologyDetailService paintTechnologyDetailService,
      final TechPaintTechnologyArtifactLinkService paintTechnologyArtifactLinkService,
      final MesBuildingPaintCalculateConsumptionService paintCalculateConsumptionService,
      final MesBuildingPaintCalculateArtifactService paintCalculateArtifactService,
      final SysStructureClassificationService structureClassificationService
   ) {
      this.projectService = projectService;
      this.monomerService = monomerService;
      this.areaService = areaService;
      this.artifactService = artifactService;
      this.paintConfigService = paintConfigService;
      this.paintTechnologyService = paintTechnologyService;
      this.paintTechnologyDetailService = paintTechnologyDetailService;
      this.paintTechnologyArtifactLinkService = paintTechnologyArtifactLinkService;
      this.paintCalculateConsumptionService = paintCalculateConsumptionService;
      this.paintCalculateArtifactService = paintCalculateArtifactService;
      this.structureClassificationService = structureClassificationService;
   }

   private enum PaintCalculateStatusEnum {
      NOT(1),
      PART(2),
      ALL(4);

      private final Integer type;

      public Integer getType() {
         return this.type;
      }

      PaintCalculateStatusEnum(final Integer type) {
         this.type = type;
      }
   }
}
