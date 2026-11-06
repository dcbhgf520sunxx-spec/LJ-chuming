package com.hzchum.scim.mes.building.core.biz.impl.wages;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.mes.building.core.api.biz.statistica.MesBuildingGroupRivetWeldConfigBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.biz.wages.MesBuildingPriceChangeBiz;
import com.hzchum.scim.mes.building.core.api.biz.wages.MesBuildingProduceTeamReportPriceBiz;
import com.hzchum.scim.mes.building.core.api.enums.PaintingTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingPriceChange;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingProduceTeamReportPrice;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.put.ChangeProductWageDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingCoatingConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingStructureProcessPriceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.ProductTypeSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.ProductWageDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.StudSleeveDTO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingCoatingConfigService;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingPriceChangeService;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingTechArtifactAuxiliaryPriceService;
import com.hzchum.scim.mes.building.core.mapper.wages.MesBuildingPriceChangeMapper;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingPriceChangeBizImpl
   extends IBizImpl<MesBuildingPriceChangeService, MesBuildingPriceChangeMapper, MesBuildingPriceChange>
   implements MesBuildingPriceChangeBiz {
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private MesBuildingGroupRivetWeldConfigBiz weldConfigBiz;
   @Autowired
   private MesBuildingProduceTeamReportPriceBiz reportPriceBiz;
   @Autowired
   private PlanAreaService areaService;
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingCoatingConfigService coatingConfigService;
   @Autowired
   private MesBuildingTechArtifactAuxiliaryPriceService mesBuildingTechArtifactAuxiliaryPriceService;

   @Override
   public List<ProductTypeSummaryDTO> getProductTypeList(Long projectId, Long monomerId, Long areaId, Integer taskTypeEnum) {
      return this.baseService
         .getProductTypeList(projectId, monomerId, areaId, taskTypeEnum)
         .stream()
         .map(e -> BeanUtil.copy(e, ProductTypeSummaryDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingProcess> getProductTypeProcessList(Long configId, Integer taskTypeEnum) {
      return this.utilsBiz.getProcessListByConfigIdAndTaskTypeEnum(configId, taskTypeEnum);
   }

   @Override
   public List<ProductWageDTO> getProductPriceList(Long configId, Long processId, Long projectId, Long monomerId, Long areaId, Integer taskTypeEnum) {
      Map<Long, PlanArea> areaMap = this.areaService
         .list(Wrappers.lambdaQuery(PlanArea.class).eq(PlanArea::getProjectId, projectId))
         .stream()
         .collect(Collectors.toMap(PlanArea::getId, Function.identity()));
      Map<Long, PlanMonomer> monomerMap = this.monomerService
         .list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projectId))
         .stream()
         .collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      if (taskTypeEnum.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<TechAssemble> assembleList = this.assembleService
            .list(
               Wrappers.lambdaQuery(TechAssemble.class)
                  .eq(TechAssemble::getAssembleConfigId, configId)
                  .eq(TechAssemble::getBoolProcess, Boolean.TRUE)
                  .eq(projectId != null, TechAssemble::getProjectId, projectId)
                  .eq(monomerId != null, TechAssemble::getMonomerId, monomerId)
                  .eq(areaId != null, TechAssemble::getAreaId, areaId)
                  .orderByAsc(TechAssemble::getMonomerId, TechAssemble::getAreaId)
            );
         Map<Long, MesBuildingPriceChange> changeWageMap = this.baseService
            .list(
               Wrappers.lambdaQuery(MesBuildingPriceChange.class)
                  .eq(MesBuildingPriceChange::getProductId, assembleList.stream().map(TechAssemble::getId).collect(Collectors.toList()))
                  .eq(MesBuildingPriceChange::getProductType, taskTypeEnum)
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingPriceChange::getProductId, Function.identity()));
         Map<Long, MesBuildingStructureProcessPriceDTO> configWageMap = this.weldConfigBiz
            .getWeldConfigPriceMap(assembleList.stream().map(TechAssemble::getId).collect(Collectors.toList()), TaskTypeEnum.ASSEMBLE.getType(), processId);
         return assembleList.stream()
            .map(
               e -> {
                  ProductWageDTO dto = ProductWageDTO.builder()
                     .id(e.getId())
                     .length(e.getLength())
                     .quantity(e.getQuantity())
                     .area(AreaDetailDO.builder().id(e.getAreaId()).name(areaMap.get(e.getAreaId()).getName()).build())
                     .monomer(MonomerDetailDO.builder().id(e.getMonomerId()).name(monomerMap.get(e.getMonomerId()).getName()).build())
                     .serialNumber(e.getSerialNumber())
                     .material(e.getMaterial())
                     .specification(e.getSpecification())
                     .netWeight(e.getNetWeight())
                     .surfaceArea(e.getSurfaceArea())
                     .build();
                  if (configWageMap.get(e.getId()) != null) {
                     dto.setWage(configWageMap.get(e.getId()).getPrice());
                     dto.setWageQuotaType(configWageMap.get(e.getId()).getWageQuotaType());
                     if (changeWageMap.get(e.getId()) != null) {
                        dto.setWage(changeWageMap.get(e.getId()).getWage());
                        dto.setWageQuotaType(changeWageMap.get(e.getId()).getWageQuotaType());
                     }
                  }

                  return dto;
               }
            )
            .collect(Collectors.toList());
      } else if (taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
         MesBuildingProcess process = this.processService.getById(processId);
         Preconditions.checkArgument(process != null, "操作失败！工序不存在");
         List<TechArtifact> artifactList = this.artifactService
            .list(
               Wrappers.lambdaQuery(TechArtifact.class)
                  .eq(TechArtifact::getStructureClassId, configId)
                  .eq(projectId != null, TechArtifact::getProjectId, projectId)
                  .eq(monomerId != null, TechArtifact::getMonomerId, monomerId)
                  .eq(areaId != null, TechArtifact::getAreaId, areaId)
                  .eq(process.getType().equals(ProcessTypeEnum.PAINT.getType()), TechArtifact::getBoolCoatingEnum, Boolean.TRUE)
                  .orderByAsc(TechArtifact::getMonomerId, TechArtifact::getAreaId)
            );
         Map<Long, MesBuildingPriceChange> changeWageMap = this.baseService
            .list(
               Wrappers.lambdaQuery(MesBuildingPriceChange.class)
                  .eq(MesBuildingPriceChange::getProductId, artifactList.stream().map(TechArtifact::getId).collect(Collectors.toList()))
                  .eq(MesBuildingPriceChange::getProductType, taskTypeEnum)
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingPriceChange::getProductId, Function.identity()));
         Map<Long, MesBuildingStructureProcessPriceDTO> configWageMap = this.weldConfigBiz
            .getWeldConfigPriceMap(artifactList.stream().map(TechArtifact::getId).collect(Collectors.toList()), TaskTypeEnum.ASSEMBLE.getType(), processId);
         Map<Integer, MesBuildingCoatingConfigDTO> coatingConfigMap = this.coatingConfigService
            .list()
            .stream()
            .map(config -> BeanUtil.copy(config, MesBuildingCoatingConfigDTO.class))
            .collect(Collectors.toMap(MesBuildingCoatingConfigDTO::getType, Function.identity()));
         return artifactList.stream()
            .map(
               e -> {
                  ProductWageDTO dto = ProductWageDTO.builder()
                     .id(e.getId())
                     .length(e.getLength())
                     .quantity(e.getQuantity())
                     .area(AreaDetailDO.builder().id(e.getAreaId()).name(areaMap.get(e.getAreaId()).getName()).build())
                     .monomer(MonomerDetailDO.builder().id(e.getMonomerId()).name(monomerMap.get(e.getMonomerId()).getName()).build())
                     .serialNumber(e.getSerialNumber())
                     .material(e.getMaterial())
                     .specification(e.getSpecification())
                     .netWeight(e.getNetWeight())
                     .surfaceArea(e.getSurfaceArea())
                     .build();
                  if (configWageMap.get(e.getId()) != null) {
                     dto.setWage(configWageMap.get(e.getId()).getPrice());
                     dto.setWageQuotaType(configWageMap.get(e.getId()).getWageQuotaType());
                     dto.setPrimerWage(coatingConfigMap.get(PaintingTypeEnum.PRIMER.getType()).getUnitPrice());
                     dto.setIntermediatePaintWage(coatingConfigMap.get(PaintingTypeEnum.INTERMEDIATE_PAINT.getType()).getUnitPrice());
                     dto.setTopcoatWage(coatingConfigMap.get(PaintingTypeEnum.TOPCOAT.getType()).getUnitPrice());
                     if (changeWageMap.get(e.getId()) != null) {
                        dto.setWage(changeWageMap.get(e.getId()).getWage());
                        dto.setWageQuotaType(changeWageMap.get(e.getId()).getWageQuotaType());
                        dto.setPrimerWage(changeWageMap.get(e.getId()).getPrimerWage());
                        dto.setIntermediatePaintWage(changeWageMap.get(e.getId()).getIntermediatePaintWage());
                        dto.setTopcoatWage(changeWageMap.get(e.getId()).getTopcoatWage());
                     }
                  }

                  return dto;
               }
            )
            .collect(Collectors.toList());
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public PageVO<ProductWageDTO> getProductPricePage(
      Long configId,
      Long processId,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer taskTypeEnum,
      Integer pageNumber,
      Integer pageSize
   ) {
      Map<Long, PlanArea> areaMap = this.areaService
         .list(Wrappers.lambdaQuery(PlanArea.class).eq(PlanArea::getProjectId, projectId))
         .stream()
         .collect(Collectors.toMap(PlanArea::getId, Function.identity()));
      Map<Long, PlanMonomer> monomerMap = this.monomerService
         .list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projectId))
         .stream()
         .collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      if (taskTypeEnum.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         PageHelper.startPage(pageNumber, pageSize);
         List<TechAssemble> assembleList = this.assembleService
            .list(
               Wrappers.lambdaQuery(TechAssemble.class)
                  .eq(TechAssemble::getAssembleConfigId, configId)
                  .eq(TechAssemble::getBoolProcess, Boolean.TRUE)
                  .eq(projectId != null, TechAssemble::getProjectId, projectId)
                  .eq(monomerId != null, TechAssemble::getMonomerId, monomerId)
                  .eq(areaId != null, TechAssemble::getAreaId, areaId)
                  .like(serialNumber != null, TechAssemble::getSerialNumber, serialNumber)
                  .orderByAsc(TechAssemble::getMonomerId, TechAssemble::getAreaId)
            );
         if (assembleList.size() == 0) {
            return new PageVO<>();
         }

         Map<Long, MesBuildingPriceChange> changeWageMap = this.baseService
            .list(
               Wrappers.lambdaQuery(MesBuildingPriceChange.class)
                  .in(MesBuildingPriceChange::getProductId, assembleList.stream().map(TechAssemble::getId).collect(Collectors.toList()))
                  .eq(MesBuildingPriceChange::getProductType, taskTypeEnum)
                  .eq(MesBuildingPriceChange::getProcessId, processId)
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingPriceChange::getProductId, Function.identity()));
         Map<Long, MesBuildingStructureProcessPriceDTO> configWageMap = this.weldConfigBiz
            .getWeldConfigPriceMap(assembleList.stream().map(TechAssemble::getId).collect(Collectors.toList()), TaskTypeEnum.ASSEMBLE.getType(), processId);
         return new PageVO<>(
            assembleList.stream()
               .map(
                  e -> {
                     ProductWageDTO dto = ProductWageDTO.builder()
                        .id(e.getId())
                        .length(e.getLength())
                        .quantity(e.getQuantity())
                        .area(AreaDetailDO.builder().id(e.getAreaId()).name(areaMap.get(e.getAreaId()).getName()).build())
                        .monomer(MonomerDetailDO.builder().id(e.getMonomerId()).name(monomerMap.get(e.getMonomerId()).getName()).build())
                        .serialNumber(e.getSerialNumber())
                        .material(e.getMaterial())
                        .specification(e.getSpecification())
                        .netWeight(e.getNetWeight())
                        .grossWeight(e.getNetWeight())
                        .surfaceArea(e.getSurfaceArea())
                        .build();
                     if (configWageMap.get(e.getId()) != null) {
                        dto.setWage(configWageMap.get(e.getId()).getPrice());
                        dto.setWageQuotaType(configWageMap.get(e.getId()).getWageQuotaType());
                        if (changeWageMap.get(e.getId()) != null) {
                           dto.setWage(changeWageMap.get(e.getId()).getWage());
                           dto.setWageQuotaType(changeWageMap.get(e.getId()).getWageQuotaType());
                        }
                     }

                     return dto;
                  }
               )
               .collect(Collectors.toList())
         );
      } else if (taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
         MesBuildingProcess process = this.processService.getById(processId);
         Preconditions.checkArgument(process != null, "操作失败！工序不存在");
         PageHelper.startPage(pageNumber, pageSize);
         List<TechArtifact> artifactList = this.artifactService
            .list(
               Wrappers.lambdaQuery(TechArtifact.class)
                  .eq(TechArtifact::getStructureClassId, configId)
                  .eq(projectId != null, TechArtifact::getProjectId, projectId)
                  .eq(monomerId != null, TechArtifact::getMonomerId, monomerId)
                  .eq(areaId != null, TechArtifact::getAreaId, areaId)
                  .like(serialNumber != null, TechArtifact::getSerialNumber, serialNumber)
                  .eq(process.getType().equals(ProcessTypeEnum.PAINT.getType()), TechArtifact::getBoolCoatingEnum, Boolean.TRUE)
                  .orderByAsc(TechArtifact::getMonomerId, TechArtifact::getAreaId)
            );
         if (artifactList.size() == 0) {
            return new PageVO<>();
         }

         Map<Long, MesBuildingPriceChange> changeWageMap = this.baseService
            .list(
               Wrappers.lambdaQuery(MesBuildingPriceChange.class)
                  .in(MesBuildingPriceChange::getProductId, artifactList.stream().map(TechArtifact::getId).collect(Collectors.toList()))
                  .eq(MesBuildingPriceChange::getProductType, taskTypeEnum)
                  .eq(MesBuildingPriceChange::getProcessId, processId)
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingPriceChange::getProductId, Function.identity()));
         Map<Long, MesBuildingStructureProcessPriceDTO> configWageMap = this.weldConfigBiz
            .getWeldConfigPriceMap(artifactList.stream().map(TechArtifact::getId).collect(Collectors.toList()), TaskTypeEnum.ARTIFACT.getType(), processId);
         Map<Integer, MesBuildingCoatingConfigDTO> coatingConfigMap = this.coatingConfigService
            .list()
            .stream()
            .map(config -> BeanUtil.copy(config, MesBuildingCoatingConfigDTO.class))
            .collect(Collectors.toMap(MesBuildingCoatingConfigDTO::getType, Function.identity()));
         return new PageVO<>(
            artifactList.stream()
               .map(
                  e -> {
                     ProductWageDTO dto = ProductWageDTO.builder()
                        .id(e.getId())
                        .length(e.getLength())
                        .quantity(e.getQuantity())
                        .area(AreaDetailDO.builder().id(e.getAreaId()).name(areaMap.get(e.getAreaId()).getName()).build())
                        .monomer(MonomerDetailDO.builder().id(e.getMonomerId()).name(monomerMap.get(e.getMonomerId()).getName()).build())
                        .serialNumber(e.getSerialNumber())
                        .material(e.getMaterial())
                        .specification(e.getSpecification())
                        .netWeight(e.getNetWeight())
                        .grossWeight(e.getGrossWeight())
                        .surfaceArea(e.getSurfaceArea())
                        .build();
                     if (process.getType().equals(ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType()) && configWageMap.get(e.getId()) != null) {
                        dto.setWage(configWageMap.get(e.getId()).getPrice());
                        dto.setWageQuotaType(configWageMap.get(e.getId()).getWageQuotaType());
                        if (changeWageMap.get(e.getId()) != null) {
                           dto.setWage(changeWageMap.get(e.getId()).getWage());
                           dto.setWageQuotaType(changeWageMap.get(e.getId()).getWageQuotaType());
                        }
                     }

                     if (process.getType().equals(ProcessTypeEnum.PAINT.getType())) {
                        if (coatingConfigMap.get(PaintingTypeEnum.PRIMER.getType()) != null) {
                           dto.setPrimerWage(coatingConfigMap.get(PaintingTypeEnum.PRIMER.getType()).getUnitPrice());
                           dto.setPrimerWageQuotaType(coatingConfigMap.get(PaintingTypeEnum.PRIMER.getType()).getMeasureUnit());
                           if (changeWageMap.get(e.getId()) != null && changeWageMap.get(e.getId()).getPrimerWage() != null) {
                              dto.setPrimerWage(changeWageMap.get(e.getId()).getPrimerWage());
                           }
                        }

                        if (coatingConfigMap.get(PaintingTypeEnum.INTERMEDIATE_PAINT.getType()) != null) {
                           dto.setIntermediatePaintWage(coatingConfigMap.get(PaintingTypeEnum.INTERMEDIATE_PAINT.getType()).getUnitPrice());
                           dto.setIntermediatePaintWageQuotaType(coatingConfigMap.get(PaintingTypeEnum.INTERMEDIATE_PAINT.getType()).getMeasureUnit());
                           if (changeWageMap.get(e.getId()) != null && changeWageMap.get(e.getId()).getIntermediatePaintWage() != null) {
                              dto.setIntermediatePaintWage(changeWageMap.get(e.getId()).getIntermediatePaintWage());
                           }
                        }

                        if (coatingConfigMap.get(PaintingTypeEnum.TOPCOAT.getType()) != null) {
                           dto.setTopcoatWage(coatingConfigMap.get(PaintingTypeEnum.TOPCOAT.getType()).getUnitPrice());
                           dto.setTopcoatWageQuotaType(coatingConfigMap.get(PaintingTypeEnum.TOPCOAT.getType()).getMeasureUnit());
                           if (changeWageMap.get(e.getId()) != null && changeWageMap.get(e.getId()).getTopcoatWage() != null) {
                              dto.setTopcoatWage(changeWageMap.get(e.getId()).getTopcoatWage());
                           }
                        }
                     }

                     return dto;
                  }
               )
               .collect(Collectors.toList())
         );
      } else {
         return new PageVO<>();
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean changeProductWage(List<ChangeProductWageDTOParam> dtoParamList) {
      dtoParamList.forEach(
         e -> {
            MesBuildingPriceChange change = this.baseService
               .getOne(
                  Wrappers.lambdaQuery(MesBuildingPriceChange.class)
                     .eq(MesBuildingPriceChange::getProductId, e.getId())
                     .eq(MesBuildingPriceChange::getProductType, e.getTaskTypeEnum())
                     .eq(MesBuildingPriceChange::getProcessId, e.getProcessId())
               );
            if (change != null) {
               change.setWage(e.getWage());
               change.setWageQuotaType(e.getWageQuotaType());
               change.setPrimerWage(e.getPrimerWage());
               change.setIntermediatePaintWage(e.getIntermediatePaintWage());
               change.setTopcoatWage(e.getTopcoatWage());
               this.baseService.updateById(change);
               this.updateProcessPrice(change);
            } else {
               MesBuildingPriceChange newChange = MesBuildingPriceChange.builder()
                  .wage(e.getWage())
                  .wageQuotaType(e.getWageQuotaType())
                  .processId(e.getProcessId())
                  .productId(e.getId())
                  .productType(e.getTaskTypeEnum())
                  .primerWage(e.getWage())
                  .intermediatePaintWage(e.getIntermediatePaintWage())
                  .topcoatWage(e.getTopcoatWage())
                  .userId(UserUtil.getCurrentUserId())
                  .wageQuotaType(e.getWageQuotaType())
                  .build();
               this.baseService.save(newChange);
               this.updateProcessPrice(newChange);
            }
         }
      );
      return Boolean.TRUE;
   }

   @Override
   public PageVO<StudSleeveDTO> studSleevePage(
      Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer auxiliaryTypeEnum, Integer pageNumber, Integer pageSize
   ) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.studSleeveList(projectId, startDate, endDate, auxiliaryTypeEnum));
   }

   @Override
   public List<StudSleeveDTO> studSleeveList(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer auxiliaryTypeEnum) {
      return this.mesBuildingTechArtifactAuxiliaryPriceService.studSleeveList(projectId, startDate, endDate, auxiliaryTypeEnum);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> studSleevePrint(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer auxiliaryTypeEnum) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      String date = startDate != null && endDate != null ? DateTimeUtil.getLocalDateStr(startDate) + "-" + DateTimeUtil.getLocalDateStr(endDate) : "全部";
      header.put("date", date);
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.studSleeveList(projectId, startDate, endDate, auxiliaryTypeEnum)
         .stream()
         .map(BeanUtil::beanToMap)
         .collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   private Boolean updateProcessPrice(MesBuildingPriceChange change) {
      List<MesBuildingProduceTeamReportPrice> teamReportPriceList = this.reportPriceBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReportPrice.class)
               .eq(MesBuildingProduceTeamReportPrice::getProcessId, change.getProcessId())
               .eq(MesBuildingProduceTeamReportPrice::getProductId, change.getProductId())
               .eq(MesBuildingProduceTeamReportPrice::getTaskTypeEnum, change.getProductType())
         );
      teamReportPriceList.forEach(e -> {
         e.setWage(change.getWage());
         e.setWageQuotaType(change.getWageQuotaType());
         if (e.getPaintingTypeEnum() != null && e.getPaintingTypeEnum().equals(PaintingTypeEnum.PRIMER.getType())) {
            e.setUnitPrice(change.getPrimerWage());
            e.setWage(change.getPrimerWage());
         }

         if (e.getPaintingTypeEnum() != null && e.getPaintingTypeEnum().equals(PaintingTypeEnum.INTERMEDIATE_PAINT.getType())) {
            e.setUnitPrice(change.getIntermediatePaintWage());
            e.setWage(change.getIntermediatePaintWage());
         }

         if (e.getPaintingTypeEnum() != null && e.getPaintingTypeEnum().equals(PaintingTypeEnum.TOPCOAT.getType())) {
            e.setUnitPrice(change.getTopcoatWage());
            e.setWage(change.getTopcoatWage());
         }

         this.reportPriceBiz.updateById(this.calculationProcessPrice(e));
      });
      return Boolean.TRUE;
   }

   private MesBuildingProduceTeamReportPrice calculationProcessPrice(MesBuildingProduceTeamReportPrice teamReportPrice) {
      if (teamReportPrice.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         TechArtifact product = this.artifactService.getById(teamReportPrice.getProductId());
         if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
            teamReportPrice.setPrice(
               product.getNetWeight()
                  .multiply(BigDecimal.valueOf(teamReportPrice.getQuantity().intValue()))
                  .divide(BigDecimal.valueOf(1000L))
                  .multiply(teamReportPrice.getWage())
            );
         }

         if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
            teamReportPrice.setPrice(
               product.getLength()
                  .multiply(BigDecimal.valueOf(teamReportPrice.getQuantity().intValue()))
                  .divide(BigDecimal.valueOf(1000L))
                  .multiply(teamReportPrice.getWage())
            );
         }

         if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
            teamReportPrice.setPrice(
               product.getSurfaceArea()
                  .multiply(BigDecimal.valueOf(teamReportPrice.getQuantity().intValue()))
                  .divide(BigDecimal.valueOf(1000000L))
                  .multiply(teamReportPrice.getWage())
            );
         }

         if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
            teamReportPrice.setPrice(teamReportPrice.getWage().multiply(BigDecimal.valueOf(teamReportPrice.getQuantity().intValue())));
         }
      }

      if (teamReportPrice.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         TechAssemble product = this.assembleService.getById(teamReportPrice.getProductId());
         if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
            teamReportPrice.setPrice(
               product.getNetWeight()
                  .multiply(BigDecimal.valueOf(teamReportPrice.getQuantity().intValue()))
                  .divide(BigDecimal.valueOf(1000L), 4, 4)
                  .multiply(teamReportPrice.getWage())
            );
         }

         if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
            teamReportPrice.setPrice(
               product.getLength()
                  .multiply(BigDecimal.valueOf(teamReportPrice.getQuantity().intValue()))
                  .divide(BigDecimal.valueOf(1000L), 4, 4)
                  .multiply(teamReportPrice.getWage())
            );
         }

         if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
            teamReportPrice.setPrice(
               product.getSurfaceArea()
                  .multiply(BigDecimal.valueOf(teamReportPrice.getQuantity().intValue()))
                  .divide(BigDecimal.valueOf(1000000L), 4, 4)
                  .multiply(teamReportPrice.getWage())
            );
         }

         if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
            teamReportPrice.setPrice(teamReportPrice.getWage().multiply(BigDecimal.valueOf(teamReportPrice.getQuantity().intValue())));
         }
      }

      return teamReportPrice;
   }
}
