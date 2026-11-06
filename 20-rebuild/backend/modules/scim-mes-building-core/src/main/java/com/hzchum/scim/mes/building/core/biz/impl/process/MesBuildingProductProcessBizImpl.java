package com.hzchum.scim.mes.building.core.biz.impl.process;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.mes.building.core.api.biz.process.MesBuildingProductProcessBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.statistica.SpecPrefixEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssistNumberDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.ApplyAllClassListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.AssembleConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.AssembleSpecDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProductProcessLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.SteelClassificationProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.StructureClassificationProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.StructureParentTypeProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.TypeProcessSelectDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingProductProcessDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingProductProcessLinkDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.ProductProcessApplyAllDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingFabricatedPartConfigService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistNumberDetailService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.biz.SysSteelClassificationBiz;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassification;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassificationMatch;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSerialNumberPrefix;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleSpecDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.StructureClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationMatchDTOParam;
import com.hzchum.scim.system.core.api.service.SysAssembleClassifyLinkService;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import com.hzchum.scim.system.core.api.service.SysAssembleSpecService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationMatchService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureSerialNumberPrefixService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingProductProcessBizImpl implements MesBuildingProductProcessBiz {
   @Autowired
   private MesBuildingProductProcessLinkService productProcessLinkService;
   @Autowired
   private MesBuildingProductProcessService productProcessService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Resource
   private SysAssembleConfigService assembleConfigService;
   @Resource
   private SysStructureClassificationService structureClassificationService;
   @Autowired
   private SysSteelClassificationBiz steelClassificationBiz;
   @Resource
   private MesBuildingFabricatedPartConfigService mesBuildingFabricatedPartConfigService;
   @Resource
   private SysSteelClassificationService sysSteelClassificationService;
   @Resource
   private TechMachinePartService techMachinePartService;
   @Resource
   private TechAssembleService techAssembleService;
   @Resource
   private SysSteelClassificationMatchService sysSteelClassificationMatchService;
   @Resource
   private MesBuildingProcessService mesBuildingProcessService;
   @Resource
   private SysAssembleSpecService assembleSpecService;
   @Resource
   private SysAssembleClassifyLinkService assembleClassifyLinkService;
   @Autowired
   private SysStructureSerialNumberPrefixService structureSerialNumberPrefixService;
   @Resource
   MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingAssistService assistService;
   @Autowired
   private MesBuildingAssistNumberDetailService assistNumberDetailService;

   @Override
   public PageVO<StructureParentTypeProcessDTO> artifactProcessPage(
      Integer productionLineType,
      String classificationName,
      String specPrefix,
      Integer mesProductEnum,
      String typeAndPrefixName,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> classificationIds = this.structureClassificationService
         .selectIdsByCondition(productionLineType, classificationName, null, null, mesProductEnum, typeAndPrefixName);
      if (CollectionUtils.isEmpty(classificationIds)) {
         return new PageVO<>();
      }

      List<StructureClassificationDTO> d = this.structureClassificationService.listByCondition(classificationIds);
      List<StructureClassificationProcessDTO> dtoList = d.stream()
         .map(e -> BeanUtil.copy(e, StructureClassificationProcessDTO.class))
         .collect(Collectors.toList());
      List<StructureParentTypeProcessDTO> parentTypeDTOS = dtoList.stream()
         .filter(s -> s.getProductionLineTypeEnum().equals(ProductionLineTypeEnum.TRADITIONAL_LINE.getType()))
         .map(
            s -> StructureParentTypeProcessDTO.builder()
               .productionLineTypeEnum(s.getProductionLineTypeEnum())
               .parentType(s.getParentType())
               .structureClassificationList(Collections.singletonList(s))
               .build()
         )
         .collect(Collectors.toList());
      dtoList.stream()
         .filter(s -> s.getProductionLineTypeEnum().equals(ProductionLineTypeEnum.SMART_LINE.getType()))
         .collect(Collectors.groupingBy(StructureClassificationProcessDTO::getParentType))
         .forEach(
            (parentType, structureClassDTOList) -> {
               StructureParentTypeProcessDTO parentTypeDTO = StructureParentTypeProcessDTO.builder()
                  .productionLineTypeEnum(ProductionLineTypeEnum.SMART_LINE.getType())
                  .parentType(parentType)
                  .structureClassificationList((List<StructureClassificationProcessDTO>)structureClassDTOList)
                  .build();
               parentTypeDTOS.add(parentTypeDTO);
            }
         );
      parentTypeDTOS.forEach(
         e -> e.getStructureClassificationList()
            .forEach(
               item -> item.setProductProcessLinkList(
                  this.productProcessLinkService
                     .getProcessListByTypeIdAndProductType(item.getId(), ProductTypeEnum.ARTIFACT.getType())
                     .stream()
                     .map(process -> BeanUtil.copy(process, MesBuildingProductProcessLinkDTO.class))
                     .collect(Collectors.toList())
               )
            )
      );
      return new PageVO<>(PageUtils.getPageVO(parentTypeDTOS, pageNumber, pageSize));
   }

   @Override
   public PageVO<StructureClassificationProcessDTO> artifactProcessPage2(
      String classificationName, String specPrefix, Integer artifactType, Integer mesProductEnum, Integer pageNumber, Integer pageSize
   ) {
      List<StructureClassificationDTO> classList = this.structureClassificationService.listByCondition2(classificationName, null, artifactType, mesProductEnum);
      List<StructureClassificationProcessDTO> dtoList = classList.stream()
         .map(e -> BeanUtil.copy(e, StructureClassificationProcessDTO.class))
         .collect(Collectors.toList());
      Map<Long, List<MesBuildingProductProcessLinkDTO>> listMap = this.productProcessLinkService
         .getProcessListByTypeIdAndProductType(null, ProductTypeEnum.ARTIFACT.getType())
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingProductProcessLinkDTO.class))
         .collect(Collectors.groupingBy(MesBuildingProductProcessLinkDTO::getTypeId));
      int count = this.productionLineService.count();
      dtoList.forEach(item -> {
         if (listMap.get(item.getId()) != null) {
            Long quantity = listMap.get(item.getId()).stream().map(MesBuildingProductProcessLinkDTO::getLineId).distinct().count();
            if (count <= quantity) {
               item.setHasProcess(Boolean.TRUE);
            } else {
               item.setHasProcess(Boolean.FALSE);
            }
         } else {
            item.setHasProcess(Boolean.FALSE);
         }
      });
      return PageUtil.listPage(pageNumber, pageSize, dtoList);
   }

   @Override
   public List<StructureClassificationProcessDTO> artifactProcessList(
      Integer productionLineType, String classificationName, String specPrefix, Integer mesProductEnum
   ) {
      List<Long> classificationIds = this.structureClassificationService
         .selectIdsByCondition(productionLineType, classificationName, specPrefix, null, mesProductEnum, null);
      if (CollectionUtils.isEmpty(classificationIds)) {
         return new ArrayList<>();
      }

      List<StructureClassificationDTO> classificationDTOS = this.structureClassificationService.listByCondition(classificationIds);
      List<StructureClassificationProcessDTO> dtoList = classificationDTOS.stream()
         .map(e -> BeanUtil.copy(e, StructureClassificationProcessDTO.class))
         .collect(Collectors.toList());
      dtoList.forEach(
         item -> item.setProductProcessLinkList(
            this.productProcessLinkService
               .getProcessListByTypeIdAndProductType(item.getId(), ProductTypeEnum.ARTIFACT.getType())
               .stream()
               .filter(e -> ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType() == e.getType())
               .map(process -> BeanUtil.copy(process, MesBuildingProductProcessLinkDTO.class))
               .collect(Collectors.toList())
         )
      );
      return dtoList;
   }

   @Override
   public PageVO<AssembleConfigDTO> assembleProcessPage(
      Boolean boolSectionSteel,
      Integer productionLineType,
      String name,
      String specPrefix,
      Integer mesProductEnum,
      String sectionAndNameAndType,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.assembleConfigService
            .listByCondition(boolSectionSteel, productionLineType, name, specPrefix, mesProductEnum, sectionAndNameAndType)
            .stream()
            .map(
               e -> {
                  AssembleConfigDTO dto = BeanUtil.copy(e, AssembleConfigDTO.class);
                  List<AssembleSpecDTO> assembleSpecDTOS = this.assembleSpecService
                     .listByCondition(e.getId(), null, mesProductEnum)
                     .stream()
                     .map(a -> AssembleSpecDTO.builder().specPrefix(a.getSpecPrefix()).build())
                     .collect(Collectors.toList());
                  dto.setAssembleSpecList(assembleSpecDTOS);
                  dto.setProductProcessLinkList(
                     this.productProcessLinkService
                        .getProcessListByTypeIdAndProductType(e.getId(), ProductTypeEnum.ASSEMBLE.getType())
                        .stream()
                        .map(process -> BeanUtil.copy(process, MesBuildingProductProcessLinkDTO.class))
                        .collect(Collectors.toList())
                  );
                  return dto;
               }
            )
            .collect(Collectors.toList())
      );
   }

   @Override
   public PageVO<AssembleConfigDTO> assembleProcessPage2(
      Long lineId, String name, String specPrefix, Integer mesProductEnum, Integer pageNumber, Integer pageSize
   ) {
      List<AssembleConfigDTO> configDTOList = this.assembleConfigService
         .listByCondition2(name, null, mesProductEnum)
         .stream()
         .map(e -> BeanUtil.copy(e, AssembleConfigDTO.class))
         .collect(Collectors.toList());
      new PageVO<>(configDTOList);
      Map<Long, List<AssembleSpecDTOParam>> specMap = this.assembleSpecService
         .listByCondition(null, null, mesProductEnum)
         .stream()
         .collect(Collectors.groupingBy(AssembleSpecDTOParam::getAssembleConfigId));
      Map<Long, List<MesBuildingProductProcessLinkDTO>> processMap = this.productProcessLinkService
         .getProcessListByTypeIdAndProductType(null, ProductTypeEnum.ASSEMBLE.getType())
         .stream()
         .map(process -> BeanUtil.copy(process, MesBuildingProductProcessLinkDTO.class))
         .collect(Collectors.groupingBy(MesBuildingProductProcessLinkDTO::getTypeId));
      int count = this.productionLineService.count();
      configDTOList.forEach(
         dto -> {
            List<AssembleSpecDTO> assembleSpecDTOS = specMap.get(dto.getId())
               .stream()
               .map(a -> AssembleSpecDTO.builder().specPrefix(a.getSpecPrefix()).build())
               .collect(Collectors.toList());
            dto.setAssembleSpecList(assembleSpecDTOS);
            if (processMap.get(dto.getId()) != null) {
               Long quantity = processMap.get(dto.getId()).stream().map(MesBuildingProductProcessLinkDTO::getLineId).distinct().count();
               if (count <= quantity) {
                  dto.setHasProcess(Boolean.TRUE);
               } else {
                  dto.setHasProcess(Boolean.FALSE);
               }
            } else {
               dto.setHasProcess(Boolean.FALSE);
            }
         }
      );
      return PageUtil.listPage(pageNumber, pageSize, configDTOList);
   }

   @Override
   public List<AssembleConfigDTO> assembleProcessList(Integer productionLineType, String name, String specPrefix, Integer mesProductEnum) {
      List<com.hzchum.scim.system.core.api.pojo.dto.AssembleConfigDTO> assembleConfigDTOS = this.assembleConfigService
         .listByConditionConfig(productionLineType, name, specPrefix, mesProductEnum);
      return CollectionUtils.isEmpty(assembleConfigDTOS)
         ? new ArrayList<>()
         : assembleConfigDTOS.stream()
            .map(
               e -> {
                  AssembleConfigDTO dto = BeanUtil.copy(e, AssembleConfigDTO.class);
                  List<AssembleSpecDTO> assembleSpecDTOS = new ArrayList<>();
                  e.getAssembleSpecList().forEach(a -> {
                     AssembleSpecDTO build = AssembleSpecDTO.builder().specPrefix(a.getSpecPrefix()).build();
                     assembleSpecDTOS.add(build);
                  });
                  dto.setAssembleSpecList(assembleSpecDTOS);
                  dto.setProductProcessLinkList(
                     this.productProcessLinkService
                        .getProcessListByTypeIdAndProductType(e.getId(), ProductTypeEnum.ASSEMBLE.getType())
                        .stream()
                        .filter(p -> ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType() == p.getType())
                        .map(process -> BeanUtil.copy(process, MesBuildingProductProcessLinkDTO.class))
                        .collect(Collectors.toList())
                  );
                  return dto;
               }
            )
            .collect(Collectors.toList());
   }

   @Override
   public List<SteelClassificationProcessDTO> machinePartProcessList(Integer productClassificationEnum, Integer mesProductEnum, String sectionAndNameAndType) {
      return this.steelClassificationBiz
         .list(productClassificationEnum, mesProductEnum, sectionAndNameAndType)
         .stream()
         .map(
            e -> {
               SteelClassificationProcessDTO dto = BeanUtil.copy(e, SteelClassificationProcessDTO.class);
               dto.setProductProcessLinkList(
                  this.productProcessLinkService
                     .getProcessListByTypeIdAndProductType(e.getId(), ProductTypeEnum.MACHINE_PART.getType())
                     .stream()
                     .map(process -> BeanUtil.copy(process, MesBuildingProductProcessLinkDTO.class))
                     .collect(Collectors.toList())
               );
               return dto;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<String> manufactureParList(Integer mesProductEnum) {
      List<SteelClassificationProcessDTO> steelClassificationProcessDTOS = this.machinePartProcessList(null, mesProductEnum, null);
      List<String> list = new ArrayList<>();

      for (SteelClassificationProcessDTO processDTO : steelClassificationProcessDTOS) {
         if (!CollectionUtils.isEmpty(processDTO.getProductProcessLinkList())) {
            list.addAll(processDTO.getLinks().stream().map(SteelClassificationMatchDTOParam::getKeyword).collect(Collectors.toList()));
         }
      }

      return list;
   }

   @Override
   public PageVO<SteelClassificationProcessDTO> oldMachinePartProcessList(Integer mesProductEnum, Integer pageNumber, Integer pageSize) {
      List<SteelClassificationDTO> dtoList = this.steelClassificationBiz.list(null, mesProductEnum, null);
      Map<Long, List<MesBuildingProductProcessLinkDTO>> listMap = this.productProcessLinkService
         .getProcessListByTypeIdAndProductType(null, ProductTypeEnum.MACHINE_PART.getType())
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingProductProcessLinkDTO.class))
         .collect(Collectors.groupingBy(MesBuildingProductProcessLinkDTO::getTypeId));
      int count = this.productionLineService.count();
      List<SteelClassificationProcessDTO> dtos = dtoList.stream().map(e -> {
         SteelClassificationProcessDTO dto = BeanUtil.copy(e, SteelClassificationProcessDTO.class);
         if (listMap.get(dto.getId()) != null) {
            Long quantity = listMap.get(dto.getId()).stream().map(MesBuildingProductProcessLinkDTO::getLineId).distinct().count();
            if (count <= quantity) {
               dto.setHasProcess(Boolean.TRUE);
            } else {
               dto.setHasProcess(Boolean.FALSE);
            }
         } else {
            dto.setHasProcess(Boolean.FALSE);
         }

         return dto;
      }).collect(Collectors.toList());
      return PageUtil.listPage(pageNumber, pageSize, dtos);
   }

   @Override
   public List<MesBuildingProductProcessLinkDTO> classConfigProcessLink(Long prodLineId, Long classId, Integer taskTypeEnum) {
      return this.productProcessLinkService.findProcessLinkByLineAndClass(prodLineId, classId, taskTypeEnum);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateProductProcess(MesBuildingProductProcessDTOParam dtoParam) {
      if (ProductTypeEnum.ARTIFACT.getType().equals(dtoParam.getProductType())) {
         List<MesBuildingProductProcessLinkDTOParam> processLinkList = dtoParam.getProcessLinkList();
         if (CollectionUtils.isNotEmpty(processLinkList)) {
            List<MesBuildingProcess> mesBuildingProcesses = this.mesBuildingProcessService
               .listByIds(processLinkList.stream().map(MesBuildingProductProcessLinkDTOParam::getId).collect(Collectors.toSet()));
            List<MesBuildingProcess> processes = mesBuildingProcesses.stream()
               .filter(e -> e.getType().equals(ProcessTypeEnum.PAINT.getType()))
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(processes)) {
               Preconditions.checkArgument(processes.size() == 1, "油漆类工序不能配置多个!!!");
               if (processLinkList.size() > 1) {
                  Map<Long, MesBuildingProductProcessLinkDTOParam> dtoParamMap = processLinkList.stream()
                     .collect(Collectors.toMap(MesBuildingProductProcessLinkDTOParam::getId, e -> (MesBuildingProductProcessLinkDTOParam)e));
                  Integer sequence = processLinkList.stream()
                     .sorted(Comparator.comparing(MesBuildingProductProcessLinkDTOParam::getSequence).reversed())
                     .collect(Collectors.toList())
                     .get(0)
                     .getSequence();
                  Preconditions.checkArgument(dtoParamMap.get(processes.get(0).getId()).getSequence().equals(sequence), "油漆类工序需排列在末尾!!!");
               }
            }
         }
      }

      MesBuildingProductProcess oldProductProcess = this.productProcessService
         .getOne(
            (Wrapper<MesBuildingProductProcess>)(Wrappers.<MesBuildingProductProcess>lambdaQuery().eq(MesBuildingProductProcess::getTypeId, dtoParam.getTypeId()))
               .eq(MesBuildingProductProcess::getProductType, dtoParam.getProductType())
         );
      if (this.checkProductProcessLinkChange(dtoParam, oldProductProcess)) {
         if (oldProductProcess != null) {
            this.productProcessService.removeById(oldProductProcess.getId());
            Preconditions.checkArgument(
               this.taskService
                  .list((Wrapper<MesBuildingTask>)Wrappers.<MesBuildingTask>lambdaQuery().eq(MesBuildingTask::getProductProcessId, oldProductProcess.getId()))
                  .stream()
                  .noneMatch(t -> t.getCompleteQuantity() < t.getTaskQuantity()),
               "操作失败，有未完成的任务"
            );
            this.productProcessLinkService
               .remove(
                  (Wrapper<MesBuildingProductProcessLink>)Wrappers.<MesBuildingProductProcessLink>lambdaQuery()
                     .eq(MesBuildingProductProcessLink::getProductProcessId, oldProductProcess.getId())
               );
         }

         if (dtoParam.getProcessLinkList() != null && dtoParam.getProcessLinkList().size() != 0) {
            if (ProductTypeEnum.MACHINE_PART.getType().equals(dtoParam.getProductType())) {
               SysSteelClassification steelClassification = this.sysSteelClassificationService.getById(dtoParam.getTypeId());
               Preconditions.checkArgument(steelClassification != null, "零件特征定义不存在");
               if (CollectionUtils.isNotEmpty(dtoParam.getProcessLinkList())) {
                  Preconditions.checkArgument(!BasicClassEnum.GENERAL_MATERIAL.getType().equals(steelClassification.getBasicClass()), "修改失败,零件特征为成品零件");
               }

               List<SysSteelClassificationMatch> classificationMatches = this.sysSteelClassificationMatchService
                  .list((Wrapper<SysSteelClassificationMatch>)new LambdaQueryWrapper<SysSteelClassificationMatch>().eq(SysSteelClassificationMatch::getSteelId, dtoParam.getTypeId()));
               SysSteelClassificationMatch match = classificationMatches.get(0);
               if (!SpecPrefixEnum.isExist(match.getKeyword())) {
                  Preconditions.checkArgument(dtoParam.getProcessLinkList().size() == 1, "该零件类型不能配置多道工序!!!");
                  MesBuildingProcess process = this.mesBuildingProcessService.getById(dtoParam.getProcessLinkList().get(0).getId());
                  Preconditions.checkArgument(!ProcessTypeEnum.DRILL_HOLE.getType().equals(process.getType()), "该零件类型不能配置钻孔工序!!!");
               }

               if (dtoParam.getProcessLinkList().size() == 1) {
                  MesBuildingProcess process = this.mesBuildingProcessService.getById(dtoParam.getProcessLinkList().get(0).getId());
                  Preconditions.checkArgument(!ProcessTypeEnum.DRILL_HOLE.getType().equals(process.getType()), "零件钻孔工序不能单独配置!!!");
               }

               if (dtoParam.getProcessLinkList().size() == 2) {
                  dtoParam.getProcessLinkList().forEach(link -> {
                     MesBuildingProcess processx = this.mesBuildingProcessService.getById(link.getId());
                     if (ProcessTypeEnum.MAKINGS.getType().equals(processx.getType())) {
                        link.setSequence(0);
                     }

                     if (ProcessTypeEnum.DRILL_HOLE.getType().equals(processx.getType())) {
                        link.setSequence(1);
                     }
                  });
               }
            }

            MesBuildingProductProcess newProductProcess = MesBuildingProductProcess.builder()
               .productType(dtoParam.getProductType())
               .typeId(dtoParam.getClassId())
               .userId(UserUtil.getCurrentUserId())
               .build();
            this.productProcessService.save(newProductProcess);
            dtoParam.getProcessLinkList()
               .forEach(
                  e -> this.productProcessLinkService
                     .save(
                        MesBuildingProductProcessLink.builder()
                           .processId(e.getId())
                           .productProcessId(newProductProcess.getId())
                           .sequence(e.getSequence())
                           .nodeTime(e.getNodeTime())
                           .build()
                     )
               );
         }
      } else if (dtoParam.getProcessLinkList().size() != 0) {
         dtoParam.getProcessLinkList()
            .forEach(
               e -> this.productProcessLinkService
                  .update(
                     Wrappers.lambdaUpdate(MesBuildingProductProcessLink.class)
                        .eq(MesBuildingProductProcessLink::getProductProcessId, oldProductProcess.getId())
                        .eq(MesBuildingProductProcessLink::getProcessId, e.getId())
                        .set(MesBuildingProductProcessLink::getNodeTime, e.getNodeTime() != null ? e.getNodeTime() : 0)
                  )
            );
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateProductProcess2(MesBuildingProductProcessDTOParam dtoParam) {
      if (dtoParam == null) {
         return Boolean.FALSE;
      }

      Map<Integer, List<MesBuildingProductProcessLinkDTOParam>> sequenceMap = dtoParam.getProcessLinkList()
         .stream()
         .collect(Collectors.groupingBy(s -> s.getSequence()));
      AtomicInteger seq = new AtomicInteger(0);
      sequenceMap.entrySet().stream().sorted(Entry.comparingByKey()).forEach(entry -> {
         for (MesBuildingProductProcessLinkDTOParam param : entry.getValue()) {
            param.setSequence(seq.get());
         }

         seq.incrementAndGet();
      });
      this.utilsBiz.checkFactoryAndWorkshopAndProductionLineAndProcessIsExist(null, null, dtoParam.getLineId(), null, null, null);
      Preconditions.checkArgument(
         dtoParam.getProcessLinkList().stream().filter(e -> e.getProcessId() != null && e.getTeamId() != null).count() == dtoParam.getProcessLinkList().size(),
         "请检查传参"
      );
      if (dtoParam.getProcessLinkList().size() > 1) {
         int processSum = (int)dtoParam.getProcessLinkList().stream().map(MesBuildingProductProcessLinkDTOParam::getProcessId).distinct().count();
         Preconditions.checkArgument(processSum == dtoParam.getProcessLinkList().size(), "工序重复，请检查后添加");
         Map<Integer, List<MesBuildingProductProcessLinkDTOParam>> LinkMap = dtoParam.getProcessLinkList()
            .stream()
            .collect(Collectors.groupingBy(MesBuildingProductProcessLinkDTOParam::getSequence));
         List<Integer> sequenceList = dtoParam.getProcessLinkList()
            .stream()
            .map(MesBuildingProductProcessLinkDTOParam::getSequence)
            .collect(Collectors.toList());
         Integer maxSequence = Collections.max(sequenceList);
         Integer minSequence = Collections.min(sequenceList);
         int parallelCount = (int)LinkMap.entrySet().stream().filter(e -> e.getValue().size() > 1).count();
         Preconditions.checkArgument(LinkMap.get(minSequence).size() == 1, "首道工序不能配置并行工序");
         Preconditions.checkArgument(LinkMap.get(maxSequence).size() == 1, "最后一道工序不能配置并行工序");
         Preconditions.checkArgument(parallelCount <= 1, "并行工序只能出现一次");
         this.utilsBiz
            .checkBatchClassIdOrProcessIdsOrTeamIds(
               Arrays.asList(dtoParam.getClassId()),
               dtoParam.getProductType(),
               dtoParam.getProcessLinkList().stream().map(MesBuildingProductProcessLinkDTOParam::getProcessId).collect(Collectors.toList()),
               dtoParam.getProcessLinkList().stream().map(MesBuildingProductProcessLinkDTOParam::getTeamId).collect(Collectors.toList()),
               dtoParam.getLineId()
            );
      }

      if (ProductTypeEnum.ARTIFACT.getType().equals(dtoParam.getProductType())) {
         List<MesBuildingProductProcessLinkDTOParam> processLinkList = dtoParam.getProcessLinkList();
         if (CollectionUtils.isNotEmpty(processLinkList)) {
            List<MesBuildingProcess> mesBuildingProcesses = this.mesBuildingProcessService
               .listByIds(processLinkList.stream().map(MesBuildingProductProcessLinkDTOParam::getProcessId).collect(Collectors.toSet()));
            List<MesBuildingProcess> processes = mesBuildingProcesses.stream()
               .filter(e -> e.getType().equals(ProcessTypeEnum.PAINT.getType()))
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(processes)) {
               Preconditions.checkArgument(processes.size() == 1, "油漆类工序不能配置多个!!!");
               if (processLinkList.size() > 1) {
                  Map<Long, MesBuildingProductProcessLinkDTOParam> dtoParamMap = processLinkList.stream()
                     .collect(Collectors.toMap(MesBuildingProductProcessLinkDTOParam::getProcessId, e -> (MesBuildingProductProcessLinkDTOParam)e));
                  Integer sequence = processLinkList.stream()
                     .sorted(Comparator.comparing(MesBuildingProductProcessLinkDTOParam::getSequence).reversed())
                     .collect(Collectors.toList())
                     .get(0)
                     .getSequence();
                  Preconditions.checkArgument(dtoParamMap.get(processes.get(0).getId()).getSequence().equals(sequence), "油漆类工序需排列在末尾!!!");
               }
            }
         }
      }

      MesBuildingProductProcess oldProductProcess = this.productProcessService
         .getOne(
            (Wrapper<MesBuildingProductProcess>)(((Wrappers.<MesBuildingProductProcess>lambdaQuery()
                        .eq(MesBuildingProductProcess::getTypeId, dtoParam.getClassId()))
                     .eq(MesBuildingProductProcess::getProductionLineId, dtoParam.getLineId()))
                  .eq(MesBuildingProductProcess::getProductType, dtoParam.getProductType()))
               .eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE)
         );
      if (oldProductProcess != null) {
         List<MesBuildingProductProcessLink> oldLinkList = this.productProcessLinkService
            .list(
               (Wrapper<MesBuildingProductProcessLink>)(Wrappers.<MesBuildingProductProcessLink>lambdaQuery()
                     .eq(MesBuildingProductProcessLink::getProductProcessId, oldProductProcess.getId()))
                  .orderByAsc(MesBuildingProductProcessLink::getSequence)
            );
         this.adjustAssociatedTeamsOfTaskProcess(dtoParam, oldLinkList, dtoParam.getProcessLinkList());
      }

      if (this.checkProductProcessLinkChange(dtoParam, oldProductProcess)) {
         if (oldProductProcess != null) {
            List<MesBuildingTask> taskList = this.taskService
               .list((Wrapper<MesBuildingTask>)new LambdaQueryWrapper<MesBuildingTask>().eq(MesBuildingTask::getProductProcessId, oldProductProcess.getId()));
            if (CollectionUtils.isNotEmpty(taskList)) {
               oldProductProcess.setBoolHistory(Boolean.TRUE);
               List<MesBuildingProductProcessLink> productProcessLinks = this.productProcessLinkService
                  .list(
                     (Wrapper<MesBuildingProductProcessLink>)new LambdaQueryWrapper<MesBuildingProductProcessLink>()
                        .eq(MesBuildingProductProcessLink::getProductProcessId, oldProductProcess.getId())
                  );
               productProcessLinks.forEach(e -> e.setBoolHistory(Boolean.TRUE));
               this.productProcessLinkService.updateBatchById(productProcessLinks);
               this.productProcessService.updateById(oldProductProcess);
            } else {
               this.productProcessService.removeById(oldProductProcess.getId());
               this.productProcessLinkService
                  .remove(
                     (Wrapper<MesBuildingProductProcessLink>)Wrappers.<MesBuildingProductProcessLink>lambdaQuery()
                        .eq(MesBuildingProductProcessLink::getProductProcessId, oldProductProcess.getId())
                  );
            }
         }

         if (dtoParam.getProcessLinkList() != null && dtoParam.getProcessLinkList().size() != 0) {
            if (ProductTypeEnum.MACHINE_PART.getType().equals(dtoParam.getProductType())) {
               SysSteelClassification steelClassification = this.sysSteelClassificationService.getById(dtoParam.getClassId());
               Preconditions.checkArgument(steelClassification != null, "零件特征定义不存在");
               if (CollectionUtils.isNotEmpty(dtoParam.getProcessLinkList())) {
                  Preconditions.checkArgument(!BasicClassEnum.GENERAL_MATERIAL.getType().equals(steelClassification.getBasicClass()), "修改失败,零件特征为成品零件");
               }

               List<SysSteelClassificationMatch> classificationMatches = this.sysSteelClassificationMatchService
                  .list((Wrapper<SysSteelClassificationMatch>)new LambdaQueryWrapper<SysSteelClassificationMatch>().eq(SysSteelClassificationMatch::getSteelId, dtoParam.getClassId()));
               SysSteelClassificationMatch match = classificationMatches.get(0);
               if (!SpecPrefixEnum.isExist(match.getKeyword())) {
                  Preconditions.checkArgument(dtoParam.getProcessLinkList().size() == 1, "该零件类型不能配置多道工序!!!");
                  MesBuildingProcess process = this.mesBuildingProcessService.getById(dtoParam.getProcessLinkList().get(0).getProcessId());
                  Preconditions.checkArgument(!ProcessTypeEnum.DRILL_HOLE.getType().equals(process.getType()), "该零件类型不能配置钻孔工序!!!");
               }

               if (dtoParam.getProcessLinkList().size() == 1) {
                  MesBuildingProcess process = this.mesBuildingProcessService.getById(dtoParam.getProcessLinkList().get(0).getProcessId());
                  Preconditions.checkArgument(!ProcessTypeEnum.DRILL_HOLE.getType().equals(process.getType()), "零件钻孔工序不能单独配置!!!");
               }

               if (dtoParam.getProcessLinkList().size() == 2) {
                  dtoParam.getProcessLinkList().forEach(link -> {
                     MesBuildingProcess processx = this.mesBuildingProcessService.getById(link.getProcessId());
                     if (ProcessTypeEnum.MAKINGS.getType().equals(processx.getType())) {
                        link.setSequence(0);
                     }

                     if (ProcessTypeEnum.DRILL_HOLE.getType().equals(processx.getType())) {
                        link.setSequence(1);
                     }
                  });
               }
            }

            MesBuildingProductProcess newProductProcess = MesBuildingProductProcess.builder()
               .productType(dtoParam.getProductType())
               .typeId(dtoParam.getClassId())
               .workshopId(dtoParam.getShopId())
               .productionLineId(dtoParam.getLineId())
               .userId(UserUtil.getCurrentUserId())
               .build();
            this.productProcessService.save(newProductProcess);
            Optional<Integer> duplicateSequenceOpt = dtoParam.getProcessLinkList()
               .stream()
               .collect(Collectors.groupingBy(MesBuildingProductProcessLinkDTOParam::getSequence))
               .entrySet()
               .stream()
               .filter(entry -> entry.getValue().size() > 1)
               .map(Entry::getKey)
               .findFirst();
            dtoParam.getProcessLinkList()
               .forEach(
                  e -> {
                     boolean isParallelProcess = duplicateSequenceOpt.isPresent() && duplicateSequenceOpt.get().equals(e.getSequence());
                     this.productProcessLinkService
                        .save(
                           MesBuildingProductProcessLink.builder()
                              .processId(e.getProcessId())
                              .productProcessId(newProductProcess.getId())
                              .sequence(e.getSequence())
                              .nodeTime(e.getNodeTime())
                              .teamId(e.getTeamId())
                              .partProdMode(e.getPartProdMode())
                              .boolFixedProcess(e.getBoolFixedProcess())
                              .boolParallelProcess(isParallelProcess)
                              .build()
                        );
                  }
               );
         }
      } else if (dtoParam.getProcessLinkList().size() != 0) {
         dtoParam.getProcessLinkList()
            .forEach(
               e -> this.productProcessLinkService
                  .update(
                     Wrappers.lambdaUpdate(MesBuildingProductProcessLink.class)
                        .eq(MesBuildingProductProcessLink::getProductProcessId, oldProductProcess.getId())
                        .eq(MesBuildingProductProcessLink::getProcessId, e.getId())
                        .set(MesBuildingProductProcessLink::getNodeTime, e.getNodeTime() != null ? e.getNodeTime() : 0)
                  )
            );
      }

      return Boolean.TRUE;
   }

   private Boolean adjustAssociatedTeamsOfTaskProcess(
      MesBuildingProductProcessDTOParam dtoParam, List<MesBuildingProductProcessLink> oldLinkList, List<MesBuildingProductProcessLinkDTOParam> newLinkList
   ) {
      dtoParam.setTypeId(dtoParam.getTypeId() == null ? dtoParam.getClassId() : dtoParam.getTypeId());
      Map<Long, Long> newMap = newLinkList.stream().collect(Collectors.toMap(e -> e.getProcessId(), s -> s.getTeamId()));
      List<Long> newProcessIds = newLinkList.stream().map(e -> e.getProcessId()).collect(Collectors.toList());
      List<MesBuildingProductProcessLink> needUpdateList = oldLinkList.stream()
         .filter(e -> newProcessIds.contains(e.getProcessId()) && e.getTeamId() != newMap.get(e.getProcessId()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(needUpdateList)) {
         needUpdateList.forEach(e -> e.setTeamId(newMap.get(e.getProcessId())));
         this.productProcessLinkService.updateBatchById(needUpdateList);
         List<Long> needUpdateProcessIds = needUpdateList.stream().map(e -> e.getProcessId()).collect(Collectors.toList());
         List<MesBuildingTaskProcess> processes = this.taskProcessService.findProcessByProductPorcess(dtoParam, needUpdateProcessIds);
         processes.stream().forEach(e -> e.setTeamId(newMap.get(e.getProcessId())));
         this.taskProcessService.updateBatchById(processes);
         List<MesBuildingAssist> assistList = this.assistService.findAssistProcessByProductPorcess(dtoParam, needUpdateProcessIds);
         if (CollectionUtils.isNotEmpty(assistList)) {
            List<Long> assistIds = assistList.stream().map(MesBuildingAssist::getId).collect(Collectors.toList());
            List<MesBuildingAssistNumberDetail> assistNumberDetails = this.assistNumberDetailService
               .list((Wrapper<MesBuildingAssistNumberDetail>)new LambdaQueryWrapper<MesBuildingAssistNumberDetail>().in(MesBuildingAssistNumberDetail::getAssistId, assistIds));
            if (CollectionUtils.isNotEmpty(assistNumberDetails)) {
               assistNumberDetails.forEach(e -> e.setTeamId(newMap.get(e.getProcessId())));
            }

            assistList.forEach(e -> e.setTeamId(newMap.get(e.getProcessId())));
            this.assistService.updateBatchById(assistList);
            this.assistNumberDetailService.updateBatchById(assistNumberDetails);
         }
      }

      return false;
   }

   private Boolean checkProductProcessLinkChange(MesBuildingProductProcessDTOParam dtoParam, MesBuildingProductProcess oldProductProcess) {
      if (oldProductProcess == null) {
         return Boolean.TRUE;
      }

      List<MesBuildingProductProcessLink> oldLinkList = this.productProcessLinkService
         .list(
            (Wrapper<MesBuildingProductProcessLink>)(Wrappers.<MesBuildingProductProcessLink>lambdaQuery()
                  .eq(MesBuildingProductProcessLink::getProductProcessId, oldProductProcess.getId()))
               .orderByAsc(MesBuildingProductProcessLink::getSequence)
         );
      if ((oldLinkList.size() == 0 || dtoParam.getProcessLinkList() != null) && oldLinkList.size() == dtoParam.getProcessLinkList().size()) {
         AtomicReference<Boolean> flg = new AtomicReference<>(Boolean.FALSE);
         Collection<List<MesBuildingProductProcessLinkDTOParam>> dtoValueGroup = dtoParam.getProcessLinkList()
            .stream()
            .collect(Collectors.groupingBy(MesBuildingProductProcessLinkDTOParam::getSequence))
            .values();
         Collection<List<MesBuildingProductProcessLink>> oldValueGroup = oldLinkList.stream()
            .collect(Collectors.groupingBy(MesBuildingProductProcessLink::getSequence))
            .values();
         List<MesBuildingProductProcessLinkDTOParam> sameProcess = dtoValueGroup.stream()
            .filter(item -> item.size() > 1)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         List<MesBuildingProductProcessLink> oldSameProcess = oldValueGroup.stream()
            .filter(item -> item.size() > 1)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(sameProcess) && CollectionUtils.isNotEmpty(oldSameProcess)) {
            Map<Long, Long> processTeamIdMap = sameProcess.stream().collect(Collectors.toMap(e -> e.getProcessId(), s -> s.getTeamId()));

            for (MesBuildingProductProcessLink process : oldSameProcess) {
               Long teamId = processTeamIdMap.get(process.getProcessId());
               if (teamId != null) {
                  flg.set(Boolean.TRUE);
                  return flg.get();
               }
            }
         }

         List<MesBuildingProductProcessLinkDTOParam> newProcess = dtoValueGroup.stream()
            .filter(item -> item.size() == 1)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         List<MesBuildingProductProcessLink> oldProcess = oldValueGroup.stream()
            .filter(item -> item.size() == 1)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         Map<Long, MesBuildingProductProcessLink> oldProcessMap = oldProcess.stream().collect(Collectors.toMap(e -> e.getProcessId(), Function.identity()));

         for (MesBuildingProductProcessLinkDTOParam newDTO : newProcess) {
            MesBuildingProductProcessLink oldLink = oldProcessMap.get(newDTO.getProcessId());
            if (oldLink == null || newDTO.getSequence() != oldLink.getSequence()) {
               flg.set(Boolean.TRUE);
               return flg.get();
            }

            if (dtoParam.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType()) && oldLink.getPartProdMode() != newDTO.getPartProdMode()) {
               flg.set(Boolean.TRUE);
               return flg.get();
            }
         }

         return flg.get();
      } else {
         return Boolean.TRUE;
      }
   }

   private Boolean checksOnlyChangeInTheTeam(MesBuildingProductProcessDTOParam dtoParam, MesBuildingProductProcess oldProductProcess) {
      List<MesBuildingProductProcessLink> oldLinkList = this.productProcessLinkService
         .list(
            (Wrapper<MesBuildingProductProcessLink>)(Wrappers.<MesBuildingProductProcessLink>lambdaQuery()
                  .eq(MesBuildingProductProcessLink::getProductProcessId, oldProductProcess.getId()))
               .orderByAsc(MesBuildingProductProcessLink::getSequence)
         );
      if ((oldLinkList.size() == 0 || dtoParam.getProcessLinkList() != null) && oldLinkList.size() == dtoParam.getProcessLinkList().size()) {
         AtomicReference<Boolean> flg = new AtomicReference<>(Boolean.FALSE);
         Collection<List<MesBuildingProductProcessLinkDTOParam>> dtoValueGroup = dtoParam.getProcessLinkList()
            .stream()
            .collect(Collectors.groupingBy(MesBuildingProductProcessLinkDTOParam::getSequence))
            .values();
         Collection<List<MesBuildingProductProcessLink>> oldValueGroup = oldLinkList.stream()
            .collect(Collectors.groupingBy(MesBuildingProductProcessLink::getSequence))
            .values();
         List<MesBuildingProductProcessLinkDTOParam> sameProcess = dtoValueGroup.stream()
            .filter(item -> item.size() > 1)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         List<MesBuildingProductProcessLink> oldSameProcess = oldValueGroup.stream()
            .filter(item -> item.size() > 1)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(sameProcess) && CollectionUtils.isNotEmpty(oldSameProcess)) {
            Map<Long, Long> processTeamIdMap = sameProcess.stream().collect(Collectors.toMap(e -> e.getProcessId(), s -> s.getTeamId()));

            for (MesBuildingProductProcessLink process : oldSameProcess) {
               Long teamId = processTeamIdMap.get(process.getProcessId());
               if (teamId != null && process.getTeamId() != teamId) {
                  flg.set(Boolean.TRUE);
                  return flg.get();
               }
            }
         }

         List<MesBuildingProductProcessLinkDTOParam> newProcess = dtoValueGroup.stream()
            .filter(item -> item.size() == 1)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         List<MesBuildingProductProcessLink> oldProcess = oldValueGroup.stream()
            .filter(item -> item.size() == 1)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         Map<Long, MesBuildingProductProcessLink> oldProcessMap = oldProcess.stream().collect(Collectors.toMap(e -> e.getProcessId(), Function.identity()));

         for (MesBuildingProductProcessLinkDTOParam newDTO : newProcess) {
            MesBuildingProductProcessLink oldLink = oldProcessMap.get(newDTO.getProcessId());
            if (oldLink != null && newDTO.getSequence() == oldLink.getSequence() && newDTO.getTeamId() != oldLink.getTeamId()) {
               flg.set(Boolean.TRUE);
               return flg.get();
            }
         }

         return flg.get();
      } else {
         return Boolean.FALSE;
      }
   }

   @Override
   public List<TypeProcessSelectDTO> artifactTypeProcessSelect(Integer artifactClassification, Integer mesProductEnum) {
      if (artifactClassification != null) {
         Preconditions.checkArgument(
            CollUtil.newArrayList(ProductClassificationEnum.PRIMARY_MEMBER.getType(), ProductClassificationEnum.SECONDARY_MEMBER.getType())
               .contains(artifactClassification),
            "构件分类不存在"
         );
      }

      return this.structureClassificationService
         .list(
            Wrappers.lambdaQuery(SysStructureClassification.class)
               .eq(artifactClassification != null, SysStructureClassification::getArtifactType, artifactClassification)
               .eq(SysStructureClassification::getMesProductEnum, mesProductEnum)
         )
         .stream()
         .map(
            t -> {
               TypeProcessSelectDTO selectDTO = new TypeProcessSelectDTO();
               selectDTO.setTypeId(t.getId());
               selectDTO.setTypeName(t.getClassificationName());
               selectDTO.setArtifactClassification(t.getArtifactType());
               List<NameInfo> processList = this.productProcessLinkService
                  .getProcessListByTypeIdAndProductType(t.getId(), ProductTypeEnum.ARTIFACT.getType())
                  .stream()
                  .map(p -> {
                     NameInfo process = new NameInfo();
                     process.setId(p.getProcessId());
                     process.setName(p.getName());
                     return process;
                  })
                  .distinct()
                  .collect(Collectors.toList());
               selectDTO.setProcessList(processList);
               List<String> artifactNameList = this.structureSerialNumberPrefixService
                  .listByStructureClassificationId(t.getId())
                  .stream()
                  .map(SysStructureSerialNumberPrefix::getSerialNumberPrefix)
                  .collect(Collectors.toList());
               selectDTO.setArtifactNameList(artifactNameList);
               return selectDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<TypeProcessSelectDTO> assembleTypeProcessSelect(Integer mesProductEnum) {
      return this.assembleConfigService
         .list((Wrapper<SysAssembleConfig>)new LambdaQueryWrapper<SysAssembleConfig>().eq(SysAssembleConfig::getMesProductEnum, mesProductEnum))
         .stream()
         .map(
            t -> {
               TypeProcessSelectDTO selectDTO = new TypeProcessSelectDTO();
               selectDTO.setTypeId(t.getId());
               selectDTO.setTypeName(t.getName());
               List<NameInfo> processList = this.productProcessLinkService
                  .getProcessListByTypeIdAndProductType(t.getId(), ProductTypeEnum.ASSEMBLE.getType())
                  .stream()
                  .map(p -> {
                     NameInfo process = new NameInfo();
                     process.setId(p.getProcessId());
                     process.setName(p.getName());
                     return process;
                  })
                  .distinct()
                  .collect(Collectors.toList());
               selectDTO.setProcessList(processList);
               return selectDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<TypeProcessSelectDTO> machinePartTypeProcessSelect(Integer machinePartClassification, Integer mesProductEnum) {
      if (machinePartClassification != null) {
         Preconditions.checkArgument(
            CollUtil.newArrayList(ProductClassificationEnum.SECTION_PRODUCT.getType(), ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType())
               .contains(machinePartClassification),
            "零件分类不存在"
         );
      }

      return this.sysSteelClassificationService
         .list(
            Wrappers.lambdaQuery(SysSteelClassification.class)
               .eq(machinePartClassification != null, SysSteelClassification::getProductClassificationEnum, machinePartClassification)
               .eq(SysSteelClassification::getMesProductEnum, mesProductEnum)
         )
         .stream()
         .map(
            t -> {
               TypeProcessSelectDTO selectDTO = new TypeProcessSelectDTO();
               selectDTO.setTypeId(t.getId());
               selectDTO.setTypeName(t.getName());
               selectDTO.setMachinePartClassification(t.getProductClassificationEnum());
               List<NameInfo> processList = this.productProcessLinkService
                  .getProcessListByTypeIdAndProductType(t.getId(), ProductTypeEnum.MACHINE_PART.getType())
                  .stream()
                  .map(p -> {
                     NameInfo process = new NameInfo();
                     process.setId(p.getProcessId());
                     process.setName(p.getName());
                     return process;
                  })
                  .distinct()
                  .collect(Collectors.toList());
               selectDTO.setProcessList(processList);
               return selectDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<ApplyAllClassListDTO> applyAllClassList(Long lineId, Integer taskTypeEnum, Integer mesProductEnum) {
      List<?> classList = null;
      Map<Long, List<MesBuildingProductProcess>> productProcessMap = null;
      switch (taskTypeEnum) {
         case 1:
            classList = this.sysSteelClassificationService
               .list((Wrapper<SysSteelClassification>)new LambdaQueryWrapper<SysSteelClassification>().eq(SysSteelClassification::getMesProductEnum, mesProductEnum));
            productProcessMap = this.getProductProcessMap(lineId, ProductTypeEnum.MACHINE_PART.getType());
            break;
         case 2:
            classList = this.structureClassificationService
               .list((Wrapper<SysStructureClassification>)new LambdaQueryWrapper<SysStructureClassification>().eq(SysStructureClassification::getMesProductEnum, mesProductEnum));
            productProcessMap = this.getProductProcessMap(lineId, ProductTypeEnum.ARTIFACT.getType());
            break;
         case 16:
            classList = this.assembleConfigService
               .list((Wrapper<SysAssembleConfig>)new LambdaQueryWrapper<SysAssembleConfig>().eq(SysAssembleConfig::getMesProductEnum, mesProductEnum));
            productProcessMap = this.getProductProcessMap(lineId, ProductTypeEnum.ASSEMBLE.getType());
            break;
         default:
            return Collections.emptyList();
      }

      if (classList == null) {
         return Collections.emptyList();
      }

      Map<Long, List<MesBuildingProductProcess>> finalProductProcessMap = productProcessMap;
      return classList.stream().map(item -> {
         ApplyAllClassListDTO dto = new ApplyAllClassListDTO();
         dto.setId(this.getLongId(item));
         dto.setClassName(this.getStringName(item));
         dto.setHasProcess(finalProductProcessMap != null && finalProductProcessMap.containsKey(dto.getId()));
         return dto;
      }).collect(Collectors.toList());
   }

   private Map<Long, List<MesBuildingProductProcess>> getProductProcessMap(Long lineId, Integer productType) {
      return this.productProcessService
         .list(
            Wrappers.lambdaQuery(MesBuildingProductProcess.class)
               .eq(MesBuildingProductProcess::getProductionLineId, lineId)
               .eq(MesBuildingProductProcess::getProductType, productType)
         )
         .stream()
         .collect(Collectors.groupingBy(MesBuildingProductProcess::getTypeId));
   }

   private Long getLongId(Object item) {
      if (item instanceof SysStructureClassification) {
         return ((SysStructureClassification)item).getId();
      } else if (item instanceof SysAssembleConfig) {
         return ((SysAssembleConfig)item).getId();
      } else if (item instanceof SysSteelClassification) {
         return ((SysSteelClassification)item).getId();
      } else {
         throw new IllegalArgumentException("Unsupported item type: " + item.getClass().getName());
      }
   }

   private String getStringName(Object item) {
      if (item instanceof SysStructureClassification) {
         return ((SysStructureClassification)item).getClassificationName();
      } else if (item instanceof SysAssembleConfig) {
         return ((SysAssembleConfig)item).getName();
      } else if (item instanceof SysSteelClassification) {
         return ((SysSteelClassification)item).getName();
      } else {
         throw new IllegalArgumentException("Unsupported item type: " + item.getClass().getName());
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean ApplyAll(ProductProcessApplyAllDTOParam dtoParam) {
      MesBuildingProductProcess productProcess = this.productProcessService.getById(dtoParam.getProductProcessId());
      Preconditions.checkArgument(productProcess != null, "当前种类工序流程不存在");
      Preconditions.checkArgument(!productProcess.getBoolHistory(), "当前种类工序流程不存在");
      Preconditions.checkArgument(productProcess.getProductType() == dtoParam.getTaskTypeEnum(), "当前种类工序流程类型不匹配");
      List<MesBuildingProductProcess> processList = this.productProcessService
         .list(
            Wrappers.lambdaQuery(MesBuildingProductProcess.class)
               .eq(MesBuildingProductProcess::getProductionLineId, productProcess.getProductionLineId())
               .eq(MesBuildingProductProcess::getProductType, productProcess.getProductType())
               .eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE)
         );
      Preconditions.checkArgument(processList.stream().allMatch(p -> !dtoParam.getClassIds().contains(p.getTypeId())), "当前种类工序流程已存在");
      List<MesBuildingProductProcessLink> processLinks = this.productProcessLinkService
         .list(Wrappers.lambdaQuery(MesBuildingProductProcessLink.class).eq(MesBuildingProductProcessLink::getProductProcessId, dtoParam.getProductProcessId()));

      for (Long classId : dtoParam.getClassIds()) {
         MesBuildingProductProcess copyProcess = BeanUtil.copy(productProcess, MesBuildingProductProcess.class);
         copyProcess.setTypeId(classId);
         copyProcess.setUserId(UserUtil.getCurrentUserId());
         this.productProcessService.save(copyProcess);

         for (MesBuildingProductProcessLink processLink : processLinks) {
            MesBuildingProductProcessLink copyProcessLink = BeanUtil.copy(processLink, MesBuildingProductProcessLink.class);
            copyProcessLink.setProductProcessId(copyProcess.getId());
            this.productProcessLinkService.save(copyProcessLink);
         }
      }

      return Boolean.TRUE;
   }
}
