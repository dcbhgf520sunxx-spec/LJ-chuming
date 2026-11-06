package com.hzchum.scim.mes.building.core.biz.impl.factory;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingCutConfigBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.CuttingType;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingProductProcessLinkDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingCutConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.CutSubTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingCutConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingCutConfigDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingCutConfigService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.team.MesBuildingMachinePartTeamDetailService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingCutConfigMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachineHoleRadiusLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechMachineHoleRadiusLinkService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingCutConfigBizImpl
   extends IBizImpl<MesBuildingCutConfigService, MesBuildingCutConfigMapper, MesBuildingCutConfig>
   implements MesBuildingCutConfigBiz {
   @Resource
   private MesBuildingMachinePartSchedulingService machinePartSchedulingService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechMachineHoleRadiusLinkService techMachineHoleRadiusLinkService;
   @Resource
   private MesBuildingProcessService processService;
   @Resource
   private MesBuildingProductProcessService productProcessService;
   @Resource
   private MesBuildingProductProcessLinkService productProcessLinkService;
   @Autowired
   private MesBuildingCutConfigService mesBuildingCutConfigService;
   @Resource
   private SysDictionaryService sysDictionaryService;
   @Resource
   private MesBuildingProcessService mesBuildingProcessService;
   @Autowired
   private MesBuildingMachinePartTeamDetailService mesBuildingMachinePartTeamDetailService;

   @Override
   public List<MesBuildingCutConfigDTO> listByCondition(String name, Boolean boolNestCutEnum) {
      List<MesBuildingCutConfig> cutConfigs = this.list(
         (Wrapper<MesBuildingCutConfig>)((Wrappers.<MesBuildingCutConfig>lambdaQuery()
                  .eq(boolNestCutEnum != null, MesBuildingCutConfig::getBoolNestCutEnum, boolNestCutEnum))
               .eq(StringUtils.isNotBlank(name), MesBuildingCutConfig::getName, name))
            .orderByDesc(MesBuildingCutConfig::getBoolNestCutEnum)
      );
      if (CollectionUtil.isEmpty(cutConfigs)) {
         return null;
      }

      List<MesBuildingCutConfigDTO> cutConfigDTOS = cutConfigs.stream().map(e -> BeanUtil.copy(e, MesBuildingCutConfigDTO.class)).collect(Collectors.toList());
      List<MesBuildingProcess> mesBuildingProcessList = this.mesBuildingProcessService.list();
      cutConfigDTOS.forEach(e -> mesBuildingProcessList.forEach(mesBuildingCutConfig -> {
         if (e.getName().equals(mesBuildingCutConfig.getId().toString())) {
            e.setName(mesBuildingCutConfig.getId().toString());
            e.setCutTypeName(mesBuildingCutConfig.getName());
            e.setCutTypeId(mesBuildingCutConfig.getId());
         }
      }));
      return cutConfigDTOS;
   }

   @Override
   public Map<Boolean, List<MesBuildingCutConfigDTO>> getCutConfigList() {
      List<MesBuildingCutConfig> cutConfigs = this.list();
      if (CollectionUtil.isNotEmpty(cutConfigs)) {
         List<MesBuildingCutConfigDTO> cutConfigDTOS = cutConfigs.stream()
            .map(e -> BeanUtil.copy(e, MesBuildingCutConfigDTO.class))
            .collect(Collectors.toList());
         return cutConfigDTOS.stream().collect(Collectors.groupingBy(MesBuildingCutConfigDTO::getBoolNestCutEnum));
      } else {
         return new HashMap<>();
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveCutConfig(MesBuildingCutConfigDTOParam dtoParam) {
      List<MesBuildingCutConfig> list = this.list((Wrapper<MesBuildingCutConfig>)Wrappers.<MesBuildingCutConfig>lambdaQuery().eq(MesBuildingCutConfig::getName, dtoParam.getName()));
      Preconditions.checkArgument(CollectionUtil.isEmpty(list), "新增失败,切割形式已存在!!!");
      this.baseService
         .save(
            MesBuildingCutConfig.builder()
               .name(dtoParam.getName())
               .boolNestCutEnum(dtoParam.getBoolNestCutEnum())
               .minThickness(dtoParam.getMinThickness())
               .maxThickness(dtoParam.getMaxThickness())
               .cuttingHolesJoint(dtoParam.getCuttingHolesJoint())
               .boolDrillHole(dtoParam.getBoolDrillHole())
               .build()
         );
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateCutConfig(MesBuildingCutConfigDTOParam dtoParam) {
      MesBuildingCutConfig cutConfig = this.baseService.getById(dtoParam.getId());
      Preconditions.checkArgument(cutConfig != null, "修改失败，切割配置不存在");
      if (StringUtils.isNotBlank(dtoParam.getName()) && !cutConfig.getName().equals(dtoParam.getName())) {
         List<MesBuildingCutConfig> list = this.list(
            (Wrapper<MesBuildingCutConfig>)Wrappers.<MesBuildingCutConfig>lambdaQuery().eq(MesBuildingCutConfig::getName, dtoParam.getName())
         );
         Preconditions.checkArgument(CollectionUtil.isEmpty(list), "修改失败,切割形式已存在!!!");
         List<MesBuildingMachinePartScheduling> schedulingList = this.machinePartSchedulingService
            .list((Wrapper<MesBuildingMachinePartScheduling>)new LambdaQueryWrapper<MesBuildingMachinePartScheduling>().in(MesBuildingMachinePartScheduling::getCutConfigId, dtoParam.getId()));
         Preconditions.checkArgument(CollectionUtil.isEmpty(schedulingList), "无法修改,切割配置已被使用!!!");
         cutConfig.setName(dtoParam.getName());
      }

      cutConfig.setBoolDrillHole(dtoParam.getBoolDrillHole());
      if (dtoParam.getMinThickness() != null && !dtoParam.getMinThickness().equals(cutConfig.getMinThickness())) {
         cutConfig.setMinThickness(dtoParam.getMinThickness());
      }

      if (dtoParam.getMaxThickness() != null && !dtoParam.getMaxThickness().equals(cutConfig.getMaxThickness())) {
         cutConfig.setMaxThickness(dtoParam.getMaxThickness());
      }

      if (dtoParam.getCuttingHolesJoint() != null && !dtoParam.getCuttingHolesJoint().equals(cutConfig.getCuttingHolesJoint())) {
         cutConfig.setCuttingHolesJoint(dtoParam.getCuttingHolesJoint());
      }

      if (dtoParam.getBoolNestCutEnum() != null) {
         cutConfig.setBoolNestCutEnum(dtoParam.getBoolNestCutEnum());
      }

      if (dtoParam.getBoolDrillHole() != 2) {
         cutConfig.setCuttingHolesJoint(BigDecimal.ZERO);
      }

      this.baseService.updateById(cutConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean removeCutConfig(List<Long> ids) {
      List<MesBuildingMachinePartScheduling> schedulingList = this.machinePartSchedulingService
         .list((Wrapper<MesBuildingMachinePartScheduling>)new LambdaQueryWrapper<MesBuildingMachinePartScheduling>().in(MesBuildingMachinePartScheduling::getCutConfigId, ids));
      Preconditions.checkArgument(CollectionUtil.isEmpty(schedulingList), "无法删除,切割配置已被使用!!!");
      this.removeByIds(ids);
      return Boolean.TRUE;
   }

   @Override
   public List<CutSubTypeDTO> getCutSubTypes(String boolNestCutEnum) {
      List<CutSubTypeDTO> cutSubTypeDTOList = new ArrayList<>();
      Map<Integer, String> cutSubTypes = CuttingType.getCutSubTypes(boolNestCutEnum);

      for (Entry<Integer, String> entry : cutSubTypes.entrySet()) {
         CutSubTypeDTO cutSubTypeDTO = new CutSubTypeDTO();
         cutSubTypeDTO.setId((long)entry.getKey().intValue());
         cutSubTypeDTO.setName(entry.getValue().toString());
         cutSubTypeDTOList.add(cutSubTypeDTO);
      }

      return cutSubTypeDTOList;
   }

   @Override
   public List<MesBuildingCutConfigDTO> listCondition() {
      List<MesBuildingCutConfig> cutConfigs = this.baseMapper.selectList(new LambdaQueryWrapper<>());
      return CollectionUtil.isNotEmpty(cutConfigs)
         ? cutConfigs.stream().map(e -> BeanUtil.copy(e, MesBuildingCutConfigDTO.class)).collect(Collectors.toList())
         : null;
   }

   @Override
   public Boolean getBoolDrillHole(Long productId, Long cutConfigId) {
      TechMachinePart machinePart = this.machinePartService.getById(productId);
      Preconditions.checkArgument(machinePart != null, "零件清单不存在!!!");
      if (machinePart.getSpecPrefix().equals("P") || machinePart.getSpecPrefix().equals("PL") && machinePart.getBoolProcess()) {
         if (!machinePart.getBoolHaveHole()) {
            return Boolean.FALSE;
         }

         List<MesBuildingProcess> mesBuildingProcesses = this.processService
            .list(
               (Wrapper<MesBuildingProcess>)(new LambdaQueryWrapper<MesBuildingProcess>().eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType()))
                  .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
            );
         List<MesBuildingProductProcessLinkDO> processLinkDOS = this.productProcessLinkService
            .getProcessListByTypeIdAndProductType(machinePart.getSteelId(), com.hzchum.scim.common.core.api.enums.ProductTypeEnum.MACHINE_PART.getType());
         if (CollectionUtils.isNotEmpty(mesBuildingProcesses) && CollectionUtils.isNotEmpty(processLinkDOS)) {
            Map<Long, MesBuildingProductProcessLinkDO> linkDOMap = processLinkDOS.stream()
               .collect(Collectors.toMap(MesBuildingProductProcessLinkDO::getProcessId, e -> (MesBuildingProductProcessLinkDO)e));

            for (MesBuildingProcess mesBuildingProcess : mesBuildingProcesses) {
               if (linkDOMap.get(mesBuildingProcess.getId()) != null) {
                  MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(cutConfigId);
                  List<MesBuildingCutConfig> mesBuildingCutConfigList = this.mesBuildingCutConfigService
                     .list(
                        (Wrapper<MesBuildingCutConfig>)new LambdaQueryWrapper<MesBuildingCutConfig>()
                           .eq(MesBuildingCutConfig::getName, mesBuildingMachinePartTeamDetail.getDeviceType())
                     );
                  Preconditions.checkArgument(CollectionUtil.isNotEmpty(mesBuildingCutConfigList), "切割配置不存在");
                  MesBuildingCutConfig cutConfig = mesBuildingCutConfigList.get(0);
                  Preconditions.checkArgument(cutConfig != null, "切割配置不存在");
                  int minThickness = Integer.parseInt(cutConfig.getMinThickness());
                  int maxThickness = Integer.parseInt(cutConfig.getMaxThickness());
                  int partThickness = Integer.parseInt(machinePart.getThick());
                  if (partThickness >= minThickness && partThickness <= maxThickness) {
                     List<TechMachineHoleRadiusLink> holeRadiusLinks = this.techMachineHoleRadiusLinkService
                        .list(
                           (Wrapper<TechMachineHoleRadiusLink>)(new LambdaQueryWrapper<TechMachineHoleRadiusLink>()
                                 .eq(TechMachineHoleRadiusLink::getMonomerId, machinePart.getMonomerId()))
                              .eq(TechMachineHoleRadiusLink::getSerialNumber, machinePart.getSerialNumber())
                        );
                     if (CollectionUtils.isNotEmpty(holeRadiusLinks)) {
                        for (TechMachineHoleRadiusLink holeRadiusLink : holeRadiusLinks) {
                           if (cutConfig.getBoolDrillHole() == 0) {
                              return Boolean.TRUE;
                           }

                           if (cutConfig.getBoolDrillHole() == 1) {
                              return Boolean.FALSE;
                           }

                           if (holeRadiusLink.getRadius().compareTo(cutConfig.getCuttingHolesJoint()) <= 0) {
                              return Boolean.TRUE;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return Boolean.FALSE;
   }

   @Override
   public Map<Long, Boolean> getBoolDrillHoleFast(List<Long> productIdList, Long cutConfigId) {
      List<TechMachinePart> machinePartList = this.machinePartService.listByIds(productIdList);
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(machinePartList), "零件清单不存在!!!");
      machinePartList = machinePartList.stream().filter(TechMachinePart::getBoolHaveHole).collect(Collectors.toList());
      Map<Long, Boolean> boolDrillHoleMap = new HashMap<>();
      if (CollectionUtil.isEmpty(machinePartList)) {
         return boolDrillHoleMap;
      }

      List<Long> monomerIdList = machinePartList.stream().map(TechMachinePart::getMonomerId).collect(Collectors.toList());
      List<String> serialNumberList = machinePartList.stream().map(TechMachinePart::getSerialNumber).collect(Collectors.toList());
      List<TechMachineHoleRadiusLink> techMachineHoleRadiusLinkList = this.techMachineHoleRadiusLinkService
         .list(
            (Wrapper<TechMachineHoleRadiusLink>)(new LambdaQueryWrapper<TechMachineHoleRadiusLink>().in(TechMachineHoleRadiusLink::getMonomerId, monomerIdList))
               .in(TechMachineHoleRadiusLink::getSerialNumber, serialNumberList)
         );
      Map<String, List<TechMachineHoleRadiusLink>> techMachineHoleRadiusLinkMap = techMachineHoleRadiusLinkList.stream()
         .collect(Collectors.groupingBy(link -> link.getMonomerId() + "-" + link.getSerialNumber()));
      MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(cutConfigId);
      if (1 != mesBuildingMachinePartTeamDetail.getPartType()) {
         return boolDrillHoleMap;
      }

      List<MesBuildingCutConfig> mesBuildingCutConfigList = this.mesBuildingCutConfigService
         .list((Wrapper<MesBuildingCutConfig>)new LambdaQueryWrapper<MesBuildingCutConfig>().eq(MesBuildingCutConfig::getName, mesBuildingMachinePartTeamDetail.getDeviceType()));
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(mesBuildingCutConfigList), "切割配置不存在");
      MesBuildingCutConfig cutConfig = mesBuildingCutConfigList.get(0);
      BigDecimal minThickness = new BigDecimal(cutConfig.getMinThickness());
      BigDecimal maxThickness = new BigDecimal(cutConfig.getMaxThickness());

      for (TechMachinePart techMachinePart : machinePartList) {
         BigDecimal partThickness = new BigDecimal(techMachinePart.getThick());
         if (partThickness.compareTo(minThickness) >= 0 && partThickness.compareTo(maxThickness) <= 0) {
            List<TechMachineHoleRadiusLink> holeRadiusLinks = techMachineHoleRadiusLinkMap.get(
               techMachinePart.getMonomerId() + "-" + techMachinePart.getSerialNumber()
            );
            if (CollectionUtils.isNotEmpty(holeRadiusLinks)) {
               for (TechMachineHoleRadiusLink holeRadiusLink : holeRadiusLinks) {
                  if (cutConfig.getBoolDrillHole().equals(0)) {
                     boolDrillHoleMap.put(techMachinePart.getId(), Boolean.TRUE);
                  } else if (cutConfig.getBoolDrillHole().equals(1)) {
                     boolDrillHoleMap.put(techMachinePart.getId(), Boolean.FALSE);
                  } else if (holeRadiusLink.getRadius().compareTo(cutConfig.getCuttingHolesJoint()) <= 0) {
                     boolDrillHoleMap.put(techMachinePart.getId(), Boolean.TRUE);
                  }
               }
            }
         }
      }

      return boolDrillHoleMap;
   }

   @Override
   public Boolean getBoolDrillHoleNew(Long productId, Long cutConfigId, Long productProcessId) {
      TechMachinePart machinePart = this.machinePartService.getById(productId);
      Preconditions.checkArgument(machinePart != null, "零件清单不存在!!!");
      if (machinePart.getSpecPrefix().equals("P") || machinePart.getSpecPrefix().equals("PL") && machinePart.getBoolProcess()) {
         if (!machinePart.getBoolHaveHole()) {
            return Boolean.FALSE;
         }

         List<MesBuildingProcess> mesBuildingProcesses = this.processService
            .list(
               (Wrapper<MesBuildingProcess>)(new LambdaQueryWrapper<MesBuildingProcess>().eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType()))
                  .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
            );
         List<MesBuildingProductProcessLink> processLinkDOS = this.productProcessLinkService
            .list((Wrapper<MesBuildingProductProcessLink>)new LambdaQueryWrapper<MesBuildingProductProcessLink>().eq(MesBuildingProductProcessLink::getProductProcessId, productProcessId));
         if (CollectionUtils.isNotEmpty(mesBuildingProcesses) && CollectionUtils.isNotEmpty(processLinkDOS)) {
            Map<Long, MesBuildingProductProcessLink> linkDOMap = processLinkDOS.stream()
               .collect(Collectors.toMap(MesBuildingProductProcessLink::getProcessId, e -> (MesBuildingProductProcessLink)e));

            for (MesBuildingProcess mesBuildingProcess : mesBuildingProcesses) {
               if (linkDOMap.get(mesBuildingProcess.getId()) != null) {
                  MesBuildingProductProcessLink mesBuildingProductProcessLink = linkDOMap.get(mesBuildingProcess.getId());
                  MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(cutConfigId);
                  List<MesBuildingCutConfig> mesBuildingCutConfigList = this.mesBuildingCutConfigService
                     .list(
                        (Wrapper<MesBuildingCutConfig>)new LambdaQueryWrapper<MesBuildingCutConfig>()
                           .eq(MesBuildingCutConfig::getName, mesBuildingMachinePartTeamDetail.getDeviceType())
                     );
                  Preconditions.checkArgument(CollectionUtil.isNotEmpty(mesBuildingCutConfigList), "切割配置不存在");
                  MesBuildingCutConfig cutConfig = mesBuildingCutConfigList.get(0);
                  Preconditions.checkArgument(cutConfig != null, "切割配置不存在");
                  int minThickness = Integer.parseInt(cutConfig.getMinThickness());
                  int maxThickness = Integer.parseInt(cutConfig.getMaxThickness());
                  int partThickness = Integer.parseInt(machinePart.getThick());
                  if (partThickness >= minThickness && partThickness <= maxThickness) {
                     List<TechMachineHoleRadiusLink> holeRadiusLinks = this.techMachineHoleRadiusLinkService
                        .list(
                           (Wrapper<TechMachineHoleRadiusLink>)(new LambdaQueryWrapper<TechMachineHoleRadiusLink>()
                                 .eq(TechMachineHoleRadiusLink::getMonomerId, machinePart.getMonomerId()))
                              .eq(TechMachineHoleRadiusLink::getSerialNumber, machinePart.getSerialNumber())
                        );
                     if (CollectionUtils.isNotEmpty(holeRadiusLinks)) {
                        for (TechMachineHoleRadiusLink holeRadiusLink : holeRadiusLinks) {
                           if (cutConfig.getBoolDrillHole() == 0) {
                              return Boolean.TRUE;
                           }

                           if (cutConfig.getBoolDrillHole() == 1) {
                              return Boolean.FALSE;
                           }

                           if (holeRadiusLink.getRadius().compareTo(cutConfig.getCuttingHolesJoint()) <= 0) {
                              return Boolean.TRUE;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return Boolean.FALSE;
   }

   @Override
   public Map<Long, Boolean> getBoolDrillHoleNewFast(List<Long> productIdList, Long cutConfigId, Long productProcessId) {
      List<TechMachinePart> machinePartList = this.machinePartService.listByIds(productIdList);
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(machinePartList), "零件清单不存在!!!");
      machinePartList = machinePartList.stream().filter(TechMachinePart::getBoolHaveHole).collect(Collectors.toList());
      Map<Long, Boolean> boolDrillHoleMap = new HashMap<>();
      if (CollectionUtil.isEmpty(machinePartList)) {
         return boolDrillHoleMap;
      }

      for (TechMachinePart processLinkDOS : machinePartList) {
         ;
      }

      List<MesBuildingProcess> mesBuildingProcesses = this.processService
         .list(
            (Wrapper<MesBuildingProcess>)(new LambdaQueryWrapper<MesBuildingProcess>().eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType()))
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
         );
      List<MesBuildingProductProcessLink> processLinkDOS = this.productProcessLinkService
         .list((Wrapper<MesBuildingProductProcessLink>)new LambdaQueryWrapper<MesBuildingProductProcessLink>().eq(MesBuildingProductProcessLink::getProductProcessId, productProcessId));
      if (CollectionUtils.isNotEmpty(mesBuildingProcesses) && CollectionUtils.isNotEmpty(processLinkDOS)) {
         Map<Long, MesBuildingProductProcessLink> linkDOMap = processLinkDOS.stream()
            .collect(Collectors.toMap(MesBuildingProductProcessLink::getProcessId, e -> (MesBuildingProductProcessLink)e));

         for (MesBuildingProcess mesBuildingProcess : mesBuildingProcesses) {
            if (linkDOMap.get(mesBuildingProcess.getId()) != null) {
               MesBuildingProductProcessLink mesBuildingProductProcessLink = linkDOMap.get(mesBuildingProcess.getId());
               MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(cutConfigId);
               List<MesBuildingCutConfig> mesBuildingCutConfigList = this.mesBuildingCutConfigService
                  .list(
                     (Wrapper<MesBuildingCutConfig>)new LambdaQueryWrapper<MesBuildingCutConfig>()
                        .eq(MesBuildingCutConfig::getName, mesBuildingMachinePartTeamDetail.getDeviceType())
                  );
               Preconditions.checkArgument(CollectionUtil.isNotEmpty(mesBuildingCutConfigList), "切割配置不存在");
               MesBuildingCutConfig cutConfig = mesBuildingCutConfigList.get(0);
               Preconditions.checkArgument(cutConfig != null, "切割配置不存在");
               int minThickness = Integer.parseInt(cutConfig.getMinThickness());
               int maxThickness = Integer.parseInt(cutConfig.getMaxThickness());

               for (TechMachinePart techMachinePart : machinePartList) {
                  int partThickness = Integer.parseInt(techMachinePart.getThick());
                  if (partThickness >= minThickness && partThickness <= maxThickness) {
                     List<TechMachineHoleRadiusLink> holeRadiusLinks = this.techMachineHoleRadiusLinkService
                        .list(
                           (Wrapper<TechMachineHoleRadiusLink>)(new LambdaQueryWrapper<TechMachineHoleRadiusLink>()
                                 .eq(TechMachineHoleRadiusLink::getMonomerId, techMachinePart.getMonomerId()))
                              .eq(TechMachineHoleRadiusLink::getSerialNumber, techMachinePart.getSerialNumber())
                        );
                     if (CollectionUtils.isNotEmpty(holeRadiusLinks)) {
                        for (TechMachineHoleRadiusLink holeRadiusLink : holeRadiusLinks) {
                           if (cutConfig.getBoolDrillHole().equals(0)) {
                              boolDrillHoleMap.put(techMachinePart.getId(), Boolean.TRUE);
                           } else if (cutConfig.getBoolDrillHole().equals(1)) {
                              boolDrillHoleMap.put(techMachinePart.getId(), Boolean.FALSE);
                           } else if (holeRadiusLink.getRadius().compareTo(cutConfig.getCuttingHolesJoint()) <= 0) {
                              boolDrillHoleMap.put(techMachinePart.getId(), Boolean.TRUE);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return boolDrillHoleMap;
   }

   @Override
   public Boolean getBoolDrillHole(Long productId, Long cutConfigId, String thick) {
      TechMachinePart machinePart = this.machinePartService.getById(productId);
      Preconditions.checkArgument(machinePart != null, "零件清单不存在!!!");
      if (!machinePart.getBoolHaveHole()) {
         return Boolean.FALSE;
      }

      MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(cutConfigId);
      List<MesBuildingCutConfig> mesBuildingCutConfigList = this.mesBuildingCutConfigService
         .list((Wrapper<MesBuildingCutConfig>)new LambdaQueryWrapper<MesBuildingCutConfig>().eq(MesBuildingCutConfig::getName, mesBuildingMachinePartTeamDetail.getDeviceType()));
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(mesBuildingCutConfigList), "切割配置不存在");
      MesBuildingCutConfig cutConfig = mesBuildingCutConfigList.get(0);
      int minThickness = Integer.parseInt(cutConfig.getMinThickness());
      int maxThickness = Integer.parseInt(cutConfig.getMaxThickness());
      int partThickness = Integer.parseInt(machinePart.getThick());
      if (partThickness >= minThickness && partThickness <= maxThickness) {
         List<TechMachineHoleRadiusLink> holeRadiusLinks = this.techMachineHoleRadiusLinkService
            .list(
               (Wrapper<TechMachineHoleRadiusLink>)(new LambdaQueryWrapper<TechMachineHoleRadiusLink>()
                     .eq(TechMachineHoleRadiusLink::getMonomerId, machinePart.getMonomerId()))
                  .eq(TechMachineHoleRadiusLink::getSerialNumber, machinePart.getSerialNumber())
            );
         if (CollectionUtils.isNotEmpty(holeRadiusLinks)) {
            for (TechMachineHoleRadiusLink holeRadiusLink : holeRadiusLinks) {
               if (cutConfig.getBoolDrillHole() == 0) {
                  return Boolean.TRUE;
               }

               if (cutConfig.getBoolDrillHole() == 1) {
                  return Boolean.FALSE;
               }

               if (holeRadiusLink.getRadius().compareTo(cutConfig.getCuttingHolesJoint()) <= 0) {
                  return Boolean.TRUE;
               }
            }
         }
      }

      return Boolean.FALSE;
   }

   @Override
   public Map<Long, Integer> getBoolDrillHolePartIdMap(List<Long> partIdList, Long cutConfigId, String thick) {
      Map<Long, Integer> drillQuantityMap = new HashMap<>();
      List<TechMachinePart> machinePartList = this.machinePartService
         .list(
            Wrappers.lambdaQuery(TechMachinePart.class)
               .eq(TechMachinePart::getBoolProcess, Boolean.TRUE)
               .eq(TechMachinePart::getBoolHaveHole, Boolean.TRUE)
               .in(TechMachinePart::getId, partIdList)
         );
      if (machinePartList.size() == 0) {
         return new HashMap<>();
      }

      Preconditions.checkArgument(machinePartList != null && machinePartList.size() != 0, "零件清单不存在!!!");
      List<Long> monomerIdList = machinePartList.stream().map(TechMachinePart::getMonomerId).collect(Collectors.toList());
      List<String> serialNumberList = machinePartList.stream().map(TechMachinePart::getSerialNumber).collect(Collectors.toList());
      List<TechMachineHoleRadiusLink> techMachineHoleRadiusLinkList = this.techMachineHoleRadiusLinkService
         .list(
            (Wrapper<TechMachineHoleRadiusLink>)(new LambdaQueryWrapper<TechMachineHoleRadiusLink>().in(TechMachineHoleRadiusLink::getMonomerId, monomerIdList))
               .in(TechMachineHoleRadiusLink::getSerialNumber, serialNumberList)
         );
      Map<String, List<TechMachineHoleRadiusLink>> techMachineHoleRadiusLinkMap = techMachineHoleRadiusLinkList.stream()
         .collect(Collectors.groupingBy(link -> link.getMonomerId() + "-" + link.getSerialNumber()));
      MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(cutConfigId);
      List<MesBuildingCutConfig> mesBuildingCutConfigList = this.mesBuildingCutConfigService
         .list((Wrapper<MesBuildingCutConfig>)new LambdaQueryWrapper<MesBuildingCutConfig>().eq(MesBuildingCutConfig::getName, mesBuildingMachinePartTeamDetail.getDeviceType()));
      MesBuildingProcess mesBuildingProcess = this.mesBuildingProcessService.getById(mesBuildingMachinePartTeamDetail.getDeviceType());
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(mesBuildingCutConfigList), "钻孔工艺未配置，请到钻孔工艺配置中配置：" + mesBuildingProcess.getName());
      MesBuildingCutConfig cutConfig = mesBuildingCutConfigList.get(0);
      Preconditions.checkArgument(cutConfig != null, "切割配置不存在");
      int minThickness = Integer.parseInt(cutConfig.getMinThickness());
      int maxThickness = Integer.parseInt(cutConfig.getMaxThickness());
      int partThickness = Integer.parseInt(thick);
      if (partThickness >= minThickness && partThickness <= maxThickness) {
         MesBuildingCutConfig finalCutConfig = cutConfig;
         machinePartList.forEach(e -> {
            List<TechMachineHoleRadiusLink> holeRadiusLinks = techMachineHoleRadiusLinkMap.get(e.getMonomerId() + "-" + e.getSerialNumber());
            if (CollectionUtils.isNotEmpty(holeRadiusLinks)) {
               for (TechMachineHoleRadiusLink holeRadiusLink : holeRadiusLinks) {
                  if (finalCutConfig.getBoolDrillHole() == 0) {
                     drillQuantityMap.merge(e.getId(), holeRadiusLink.getQuantity(), Integer::sum);
                  } else if (finalCutConfig.getBoolDrillHole() != 1 && holeRadiusLink.getRadius().compareTo(finalCutConfig.getCuttingHolesJoint()) <= 0) {
                     drillQuantityMap.merge(e.getId(), holeRadiusLink.getQuantity(), Integer::sum);
                  }
               }
            }
         });
      }

      return drillQuantityMap;
   }

   @Override
   public List<Long> getBoolDrillHolePartIdList(List<Long> partIdList, Long cutConfigId, String thick) {
      List<Long> drillPartIdList = new ArrayList<>();
      List<TechMachinePart> machinePartList = this.machinePartService
         .list(
            Wrappers.lambdaQuery(TechMachinePart.class)
               .eq(TechMachinePart::getBoolProcess, Boolean.TRUE)
               .eq(TechMachinePart::getBoolHaveHole, Boolean.TRUE)
               .in(TechMachinePart::getId, partIdList)
         );
      if (machinePartList.size() == 0) {
         return new ArrayList<>();
      }

      MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(cutConfigId);
      List<MesBuildingCutConfig> mesBuildingCutConfigList = this.mesBuildingCutConfigService
         .list((Wrapper<MesBuildingCutConfig>)new LambdaQueryWrapper<MesBuildingCutConfig>().eq(MesBuildingCutConfig::getName, mesBuildingMachinePartTeamDetail.getDeviceType()));
      MesBuildingCutConfig cutConfig = mesBuildingCutConfigList.get(0);
      Preconditions.checkArgument(cutConfig != null, "切割配置不存在");
      int minThickness = Integer.parseInt(cutConfig.getMinThickness());
      int maxThickness = Integer.parseInt(cutConfig.getMaxThickness());
      int partThickness = Integer.parseInt(thick);
      if (partThickness >= minThickness && partThickness <= maxThickness) {
         machinePartList.forEach(
            e -> {
               List<TechMachineHoleRadiusLink> holeRadiusLinks = this.techMachineHoleRadiusLinkService
                  .list(
                     (Wrapper<TechMachineHoleRadiusLink>)(new LambdaQueryWrapper<TechMachineHoleRadiusLink>()
                           .eq(TechMachineHoleRadiusLink::getMonomerId, e.getMonomerId()))
                        .eq(TechMachineHoleRadiusLink::getSerialNumber, e.getSerialNumber())
                  );
               if (CollectionUtils.isNotEmpty(holeRadiusLinks)) {
                  for (TechMachineHoleRadiusLink holeRadiusLink : holeRadiusLinks) {
                     if (cutConfig.getBoolDrillHole() == 0) {
                        drillPartIdList.add(e.getId());
                     } else if (cutConfig.getBoolDrillHole() != 1 && holeRadiusLink.getRadius().compareTo(cutConfig.getCuttingHolesJoint()) <= 0) {
                        drillPartIdList.add(e.getId());
                     }
                  }
               }
            }
         );
      }

      return drillPartIdList;
   }
}
