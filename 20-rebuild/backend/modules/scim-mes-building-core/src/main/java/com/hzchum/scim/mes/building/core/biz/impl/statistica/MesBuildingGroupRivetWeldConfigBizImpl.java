package com.hzchum.scim.mes.building.core.biz.impl.statistica;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.biz.statistica.MesBuildingGroupRivetWeldConfigBiz;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingArtifactTypeConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingAssembleProcessPrice;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingAssembleRiveWeldLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingStructureClassificationTypeLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingStructureProcessPrice;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingStructureProcessPriceDTO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingArtifactTypeConfigService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingAssembleProcessPriceService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingAssembleRiveWeldLinkService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingStructureClassificationTypeLinkService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingStructureProcessPriceService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechAssembleUtilDTO;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.util.TechUtils;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingGroupRivetWeldConfigBizImpl implements MesBuildingGroupRivetWeldConfigBiz {
   @Resource
   private TechArtifactService techArtifactService;
   @Resource
   private TechAssembleService techAssembleService;
   @Resource
   private MesBuildingAssembleRiveWeldLinkService mesBuildingAssembleRiveWeldLinkService;
   @Resource
   private MesBuildingAssembleProcessPriceService mesBuildingAssembleProcessPriceService;
   @Resource
   private MesBuildingProcessService mesBuildingProcessService;
   @Resource
   private MesBuildingArtifactTypeConfigService mesBuildingArtifactTypeConfigService;
   @Resource
   private MesBuildingStructureClassificationTypeLinkService mesBuildingStructureClassificationTypeLinkService;
   @Resource
   private MesBuildingStructureProcessPriceService mesBuildingStructureProcessPriceService;

   @Override
   public MesBuildingStructureProcessPriceDTO getWeldConfigPrice(Long productId, Integer taskTypeEnum, Long processId) {
      MesBuildingProcess process = this.mesBuildingProcessService.getById(processId);
      Preconditions.checkArgument(process != null, "工序不存在");
      MesBuildingStructureProcessPriceDTO processPriceDTO = null;
      if (TaskTypeEnum.ARTIFACT.getType().equals(taskTypeEnum)) {
         TechArtifact artifact = this.techArtifactService.getById(productId);
         Preconditions.checkArgument(artifact != null, "构件产品不存在!!!");
         MesBuildingArtifactTypeConfig artifactTypeConfig = this.mesBuildingArtifactTypeConfigService
            .getOne(
               (Wrapper<MesBuildingArtifactTypeConfig>)new LambdaQueryWrapper<MesBuildingArtifactTypeConfig>()
                  .apply("find_in_set({0},inventory_name)", this.getMaxSerialNumber(artifact.getSerialNumber()))
            );
         if (artifactTypeConfig == null) {
            return null;
         }

         BigDecimal bigDecimal = isDigit(TechUtils.getSpecList(artifact.getSpecification())[0])
            ? new BigDecimal(TechUtils.getSpecList(artifact.getSpecification())[0])
            : BigDecimal.ZERO;
         MesBuildingStructureClassificationTypeLink typeLink = this.mesBuildingStructureClassificationTypeLinkService
            .getOne(
               (Wrapper<MesBuildingStructureClassificationTypeLink>)(((new LambdaQueryWrapper<MesBuildingStructureClassificationTypeLink>()
                           .eq(MesBuildingStructureClassificationTypeLink::getArtifactTypeId, artifactTypeConfig.getId()))
                        .eq(MesBuildingStructureClassificationTypeLink::getStructureClassificationId, artifact.getStructureClassId()))
                     .le(MesBuildingStructureClassificationTypeLink::getMinNumerical, bigDecimal))
                  .ge(MesBuildingStructureClassificationTypeLink::getMaxNumerical, bigDecimal)
            );
         if (typeLink == null) {
            return null;
         }

         MesBuildingStructureProcessPrice structureProcessPrice = this.mesBuildingStructureProcessPriceService
            .getOne(
               (Wrapper<MesBuildingStructureProcessPrice>)(new LambdaQueryWrapper<MesBuildingStructureProcessPrice>()
                     .eq(MesBuildingStructureProcessPrice::getStructureTypeLinkId, typeLink.getId()))
                  .eq(MesBuildingStructureProcessPrice::getProcessId, processId)
            );
         if (structureProcessPrice == null) {
            return null;
         }

         processPriceDTO = BeanUtil.copy(structureProcessPrice, MesBuildingStructureProcessPriceDTO.class);
      }

      if (TaskTypeEnum.ASSEMBLE.getType().equals(taskTypeEnum)) {
         TechAssemble assemble = this.techAssembleService.getById(productId);
         Preconditions.checkArgument(assemble != null, "部件产品不存在!!!");
         if (!assemble.getBoolProcess()) {
            return null;
         }

         BigDecimal bigDecimal = isDigit(TechUtils.getSpecList(assemble.getSpecification())[0])
            ? new BigDecimal(TechUtils.getSpecList(assemble.getSpecification())[0])
            : BigDecimal.ZERO;
         MesBuildingAssembleRiveWeldLink riveWeldLink = this.mesBuildingAssembleRiveWeldLinkService
            .getOne(
               (Wrapper<MesBuildingAssembleRiveWeldLink>)((new LambdaQueryWrapper<MesBuildingAssembleRiveWeldLink>()
                        .eq(MesBuildingAssembleRiveWeldLink::getSysAssembleId, assemble.getAssembleConfigId()))
                     .le(MesBuildingAssembleRiveWeldLink::getMinNumerical, bigDecimal))
                  .ge(MesBuildingAssembleRiveWeldLink::getMaxNumerical, bigDecimal)
            );
         if (riveWeldLink == null) {
            return null;
         }

         MesBuildingAssembleProcessPrice assembleProcessPrice = this.mesBuildingAssembleProcessPriceService
            .getOne(
               (Wrapper<MesBuildingAssembleProcessPrice>)(new LambdaQueryWrapper<MesBuildingAssembleProcessPrice>()
                     .eq(MesBuildingAssembleProcessPrice::getAssembleLinkId, riveWeldLink.getId()))
                  .eq(MesBuildingAssembleProcessPrice::getProcessId, processId)
            );
         if (assembleProcessPrice == null) {
            return null;
         }

         processPriceDTO = BeanUtil.copy(assembleProcessPrice, MesBuildingStructureProcessPriceDTO.class);
      }

      return processPriceDTO;
   }

   @Override
   public Map<Long, MesBuildingStructureProcessPriceDTO> getWeldConfigPriceMap(List<Long> productIds, Integer taskTypeEnum, Long processId) {
      if (productIds.size() == 0) {
         return new HashMap<>();
      }

      Map<Long, MesBuildingStructureProcessPriceDTO> priceDTOMap = new HashMap<>();
      MesBuildingProcess process = this.mesBuildingProcessService.getById(processId);
      Preconditions.checkArgument(process != null, "工序不存在");
      if (TaskTypeEnum.ARTIFACT.getType().equals(taskTypeEnum)) {
         List<TechArtifact> techArtifacts = this.techArtifactService.listByIds(productIds);
         Preconditions.checkArgument(CollectionUtil.isNotEmpty(techArtifacts), "构件产品不存在!!!");
         List<TechArtifactDTO> artifactDTOS = techArtifacts.stream().map(e -> BeanUtil.copy(e, TechArtifactDTO.class)).collect(Collectors.toList());
         List<TechArtifactDTO> collect = artifactDTOS.stream()
            .map(e -> e.setSerialNumber(this.getMaxSerialNumber(e.getSerialNumber())))
            .collect(Collectors.toList());
         Map<String, List<TechArtifactDTO>> artifactSerialNumberMap = collect.stream()
            .filter(e -> StringUtils.isNotBlank(e.getSerialNumber()))
            .collect(Collectors.groupingBy(TechArtifactDTO::getSerialNumber));
         artifactSerialNumberMap.forEach(
            (serialNumber, techArtifactList) -> {
               MesBuildingArtifactTypeConfig artifactTypeConfig = this.mesBuildingArtifactTypeConfigService
                  .getOne((Wrapper<MesBuildingArtifactTypeConfig>)new LambdaQueryWrapper<MesBuildingArtifactTypeConfig>().apply("find_in_set({0},inventory_name)", serialNumber));
               if (artifactTypeConfig == null) {
                  for (TechArtifactDTO techArtifact : techArtifactList) {
                     priceDTOMap.put(techArtifact.getId(), null);
                  }
               }

               if (artifactTypeConfig != null) {
                  Map<String, List<TechArtifactDTO>> artifactStructureClassIdMap = techArtifactList.stream()
                     .collect(Collectors.groupingBy(TechArtifactDTO::getSpecification));
                  artifactStructureClassIdMap.forEach(
                     (specification, techList) -> {
                        MesBuildingStructureProcessPriceDTO processPriceDTO = null;
                        BigDecimal bigDecimal = new BigDecimal(TechUtils.getSpecList(specification)[0]);
                        Long structureClassId = techList.get(0).getStructureClassId();
                        MesBuildingStructureClassificationTypeLink typeLink = this.mesBuildingStructureClassificationTypeLinkService
                           .getOne(
                              (Wrapper<MesBuildingStructureClassificationTypeLink>)(((new LambdaQueryWrapper<MesBuildingStructureClassificationTypeLink>()
                                          .eq(MesBuildingStructureClassificationTypeLink::getArtifactTypeId, artifactTypeConfig.getId()))
                                       .eq(MesBuildingStructureClassificationTypeLink::getStructureClassificationId, structureClassId))
                                    .le(MesBuildingStructureClassificationTypeLink::getMinNumerical, bigDecimal))
                                 .ge(MesBuildingStructureClassificationTypeLink::getMaxNumerical, bigDecimal)
                           );
                        if (typeLink != null) {
                           MesBuildingStructureProcessPrice structureProcessPrice = this.mesBuildingStructureProcessPriceService
                              .getOne(
                                 (Wrapper<MesBuildingStructureProcessPrice>)(new LambdaQueryWrapper<MesBuildingStructureProcessPrice>()
                                       .eq(MesBuildingStructureProcessPrice::getStructureTypeLinkId, typeLink.getId()))
                                    .eq(MesBuildingStructureProcessPrice::getProcessId, processId)
                              );
                           if (structureProcessPrice != null) {
                              processPriceDTO = BeanUtil.copy(structureProcessPrice, MesBuildingStructureProcessPriceDTO.class);
                           }
                        }

                        for (TechArtifactDTO techArtifactx : techList) {
                           priceDTOMap.put(techArtifactx.getId(), processPriceDTO);
                        }
                     }
                  );
               }
            }
         );
      }

      if (TaskTypeEnum.ASSEMBLE.getType().equals(taskTypeEnum)) {
         List<TechAssemble> assembleList = this.techAssembleService.listByIds(productIds);
         Preconditions.checkArgument(CollectionUtil.isNotEmpty(assembleList), "部件产品不存在!!!");
         List<TechAssembleUtilDTO> techAssembleUtilDTOS = assembleList.stream()
            .map(e -> BeanUtil.copy(e, TechAssembleUtilDTO.class))
            .collect(Collectors.toList());
         Map<Boolean, List<TechAssembleUtilDTO>> boolProcessMap = techAssembleUtilDTOS.stream()
            .collect(Collectors.groupingBy(TechAssembleUtilDTO::getBoolProcess));
         boolProcessMap.forEach(
            (boolProcess, assembleDTOList) -> {
               if (!boolProcess) {
                  for (TechAssembleUtilDTO dto : assembleDTOList) {
                     priceDTOMap.put(dto.getId(), null);
                  }
               }

               if (boolProcess) {
                  Map<String, List<TechAssembleUtilDTO>> assembleSpecificationMap = assembleDTOList.stream()
                     .collect(Collectors.groupingBy(TechAssembleUtilDTO::getSpecification));
                  assembleSpecificationMap.forEach(
                     (specification, assembleUtilDTOS) -> {
                        MesBuildingStructureProcessPriceDTO processPriceDTO = null;
                        BigDecimal bigDecimal = new BigDecimal(TechUtils.getSpecList(specification)[0]);
                        Long assembleConfigId = assembleUtilDTOS.get(0).getAssembleConfigId();
                        MesBuildingAssembleRiveWeldLink riveWeldLink = this.mesBuildingAssembleRiveWeldLinkService
                           .getOne(
                              (Wrapper<MesBuildingAssembleRiveWeldLink>)((new LambdaQueryWrapper<MesBuildingAssembleRiveWeldLink>()
                                       .eq(MesBuildingAssembleRiveWeldLink::getSysAssembleId, assembleConfigId))
                                    .le(MesBuildingAssembleRiveWeldLink::getMinNumerical, bigDecimal))
                                 .ge(MesBuildingAssembleRiveWeldLink::getMaxNumerical, bigDecimal)
                           );
                        if (riveWeldLink != null) {
                           MesBuildingAssembleProcessPrice assembleProcessPrice = this.mesBuildingAssembleProcessPriceService
                              .getOne(
                                 (Wrapper<MesBuildingAssembleProcessPrice>)(new LambdaQueryWrapper<MesBuildingAssembleProcessPrice>()
                                       .eq(MesBuildingAssembleProcessPrice::getAssembleLinkId, riveWeldLink.getId()))
                                    .eq(MesBuildingAssembleProcessPrice::getProcessId, processId)
                              );
                           if (assembleProcessPrice != null) {
                              processPriceDTO = BeanUtil.copy(assembleProcessPrice, MesBuildingStructureProcessPriceDTO.class);
                           }
                        }

                        for (TechAssembleUtilDTO assembleUtilDTO : assembleUtilDTOS) {
                           priceDTOMap.put(assembleUtilDTO.getId(), processPriceDTO);
                        }
                     }
                  );
               }
            }
         );
      }

      return priceDTOMap;
   }

   private String getMaxSerialNumber(String serialNumber) {
      Pattern pattern = Pattern.compile("\\d");
      Matcher matcher = pattern.matcher(serialNumber);
      String str = matcher.replaceAll("");
      int max = 0;
      String maxValue = null;
      String[] split = str.split("-");

      for (String aSplit : split) {
         if (aSplit.toCharArray().length > max) {
            maxValue = aSplit;
            max = aSplit.toCharArray().length;
         }
      }

      return maxValue;
   }

   public static boolean isDigit(String strNum) {
      if (StringUtils.isBlank(strNum)) {
         return false;
      }

      Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
      Matcher matcher = pattern.matcher(strNum);
      return matcher.matches();
   }
}
