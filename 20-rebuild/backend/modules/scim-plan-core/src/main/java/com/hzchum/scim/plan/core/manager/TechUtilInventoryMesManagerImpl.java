package com.hzchum.scim.plan.core.manager;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductSectionNameEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.plan.core.api.enums.AuxiliaryUsePropertyEnum;
import com.hzchum.scim.plan.core.api.enums.ImportTypeEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryReviewedEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryTypeEnum;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.enums.OperationTypeEnum;
import com.hzchum.scim.plan.core.api.manager.TechUtilInventoryMesManager;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactStandardPartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo._do.check.MesTechInventoryOperation;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechArtifactMachinePartLinkRecord;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechArtifactRecord;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechArtifactStandardPartLinkRecord;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechAssembleDetailRecord;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechAssembleMachinePartLinkRecord;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechAssembleRecord;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechMachinePartRecord;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechStandardPartRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechConfigUtilsDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactBoxImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactPartImportCommonDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.InventoryAssembleImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.MachinePartImportDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.StandardPartImportDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ZnljArtifactMachinePartImportTemplateDtoParam;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechArtifactStandardPartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.plan.core.api.service.check.MesTechInventoryOperationService;
import com.hzchum.scim.plan.core.api.service.check.TechArtifactMachinePartLinkRecordService;
import com.hzchum.scim.plan.core.api.service.check.TechArtifactRecordService;
import com.hzchum.scim.plan.core.api.service.check.TechArtifactStandardPartLinkRecordService;
import com.hzchum.scim.plan.core.api.service.check.TechAssembleDetailRecordService;
import com.hzchum.scim.plan.core.api.service.check.TechAssembleMachinePartLinkRecordService;
import com.hzchum.scim.plan.core.api.service.check.TechAssembleRecordService;
import com.hzchum.scim.plan.core.api.service.check.TechMachinePartRecordService;
import com.hzchum.scim.plan.core.api.service.check.TechStandardPartRecordService;
import com.hzchum.scim.plan.core.api.util.TechUtils;
import com.hzchum.scim.system.core.api.common.enums.ArtifactTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.pojo.dto.InventoryConfigurationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.InventoryConfigurationDetailDTO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TechUtilInventoryMesManagerImpl implements TechUtilInventoryMesManager {
   private final List<String> SEND_DIRECTLY_MARK_LIST = Arrays.asList("直发件类", "次构件类");
   private final TechArtifactService artifactService;
   private final TechAssembleService assembleService;
   private final TechMachinePartService machinePartService;
   private final TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   private final TechAssembleDetailService assembleDetailService;
   private final TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   private final TechArtifactStandardPartLinkService artifactStandardPartLinkService;
   private final TechStandardPartService standardPartService;
   private final ConfigService configService;
   private final SysStructureClassificationService structureClassificationService;
   private final MesTechInventoryOperationService mesTechInventoryOperationService;
   private final TechArtifactRecordService artifactRecordService;
   private final TechAssembleRecordService assembleRecordService;
   private final TechMachinePartRecordService machinePartRecordService;
   private final TechAssembleDetailRecordService assembleDetailRecordService;
   private final TechArtifactMachinePartLinkRecordService artifactMachinePartLinkRecordService;
   private final TechArtifactStandardPartLinkRecordService artifactStandardPartLinkRecordService;
   private final TechAssembleMachinePartLinkRecordService assembleMachinePartLinkRecordService;
   private final TechStandardPartRecordService standardPartRecordService;
   private final String specialMaterial = "Q235B-HW,Q355B-HW,不锈钢,钢板网,橡胶垫块,钢格栅";

   @Override
   public List<ArtifactBoxImportDTO> getMesConversionList(
      List<MistakeExportDTO> mistakeExportDTOList,
      List<ZnljArtifactMachinePartImportTemplateDtoParam> importDTOS,
      TechConfigUtilsDTO utilsDTO,
      Long monomerId,
      Integer importType
   ) {
      InventoryConfigurationDTO configurationDTO = this.configService.getListInventoryConfiguration();
      Map<Integer, InventoryConfigurationDetailDTO> configurationDetailDTOMap = configurationDTO.getDetailDTOList()
         .stream()
         .collect(Collectors.toMap(InventoryConfigurationDetailDTO::getProductType, Function.identity()));
      this.checkFieldBlankNull(
         importDTOS,
         utilsDTO.getAssembleSpecMap(),
         utilsDTO.getMachinePartSpecMap(),
         utilsDTO.getSectionMachinePartSpecMap(),
         utilsDTO.getSteelClassSpecNameLinkMap(),
         mistakeExportDTOList,
         utilsDTO,
         configurationDetailDTOMap
      );
      if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         return null;
      }

      List<List<ZnljArtifactMachinePartImportTemplateDtoParam>> artifactImportLists = this.convertFirst(importDTOS);
      List<ArtifactBoxImportDTO> artifactBoxImportDTOS = this.convertSecondArtifact(artifactImportLists, utilsDTO, importType, mistakeExportDTOList);
      if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         return null;
      }

      this.checkInMonomer(artifactBoxImportDTOS, monomerId, mistakeExportDTOList, importType, configurationDetailDTOMap);
      this.checkInMonomerPendingApproval(
         artifactBoxImportDTOS,
         monomerId,
         InventoryTypeEnum.MES.getType(),
         utilsDTO.getBoolComposeAssembleClassIds(),
         configurationDetailDTOMap,
         mistakeExportDTOList
      );
      return CollectionUtils.isNotEmpty(mistakeExportDTOList) ? null : artifactBoxImportDTOS;
   }

   private void checkInMonomer(
      List<ArtifactBoxImportDTO> artifactBoxDtoParamList,
      Long monomerId,
      List<MistakeExportDTO> mistakeExportDTOList,
      Integer importType,
      Map<Integer, InventoryConfigurationDetailDTO> configurationDetailDTOMap
   ) {
      Map<String, TechArtifact> monomerArtifactSnMap = this.artifactService
         .list(
            Wrappers.lambdaQuery(TechArtifact.class)
               .in(TechArtifact::getMonomerId, monomerId)
               .in(
                  TechArtifact::getSerialNumber,
                  artifactBoxDtoParamList.stream().map(ArtifactPartImportCommonDTO::getSerialNumber).collect(Collectors.toList())
               )
         )
         .stream()
         .collect(Collectors.toMap(TechArtifact::getSerialNumber, Function.identity(), (s1, s2) -> s1));
      Map<String, List<TechArtifact>> artifactSnListMap = this.artifactService
         .list(
            Wrappers.lambdaQuery(TechArtifact.class)
               .eq(TechArtifact::getMonomerId, monomerId)
               .in(
                  TechArtifact::getSerialNumber,
                  artifactBoxDtoParamList.stream().map(ArtifactPartImportCommonDTO::getSerialNumber).collect(Collectors.toList())
               )
         )
         .stream()
         .collect(Collectors.groupingBy(TechArtifact::getSerialNumber));
      Map<String, TechAssemble> monomerAssembleSnMap = this.assembleService
         .list(Wrappers.lambdaQuery(TechAssemble.builder().monomerId(monomerId).build()))
         .stream()
         .collect(Collectors.toMap(TechAssemble::getSerialNumber, Function.identity(), (s1, s2) -> s1));
      Map<String, TechMachinePart> monomerMachinePartSnMap = this.machinePartService
         .list(Wrappers.lambdaQuery(TechMachinePart.builder().monomerId(monomerId).build()))
         .stream()
         .collect(Collectors.toMap(TechMachinePart::getSerialNumber, Function.identity(), (s1, s2) -> s1));
      List<TechAssembleDetail> monomerAssembleDetailList = Collections.emptyList();
      List<TechArtifactMachinePartLink> monomerArtifactMachinePartLinkList = Collections.emptyList();
      List<TechAssembleMachinePartLink> monomerAssembleMachinePartLinkList = Collections.emptyList();
      List<TechArtifactStandardPartLink> monomerArtifactStandardPartLinkList = Collections.emptyList();
      Map<Long, TechAssemble> monomerAssembleIdMap = new HashMap<>();
      Map<Long, TechMachinePart> monomerPartIdMap = new HashMap<>();
      Map<Long, TechMachinePart> monomerAssemblePartIdMap = new HashMap<>();
      Map<Long, TechStandardPart> monomerStandardPartIdMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(monomerArtifactSnMap)) {
         List<Long> artifactIds = monomerArtifactSnMap.values().stream().map(TechArtifact::getId).collect(Collectors.toList());
         monomerAssembleDetailList = this.assembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, artifactIds));
         monomerArtifactMachinePartLinkList = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artifactIds));
         monomerArtifactStandardPartLinkList = this.artifactStandardPartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactStandardPartLink.class).in(TechArtifactStandardPartLink::getArtifactId, artifactIds));
         if (CollectionUtils.isNotEmpty(monomerAssembleDetailList)) {
            monomerAssembleIdMap = this.assembleService
               .listByIds(monomerAssembleDetailList.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()))
               .stream()
               .collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         }
      }

      if (CollectionUtils.isNotEmpty(monomerAssembleSnMap)) {
         List<Long> assembleIds = monomerAssembleSnMap.values().stream().map(TechAssemble::getId).collect(Collectors.toList());
         monomerAssembleMachinePartLinkList = this.assembleMachinePartLinkService
            .list((Wrapper<TechAssembleMachinePartLink>)new LambdaQueryWrapper<TechAssembleMachinePartLink>().in(TechAssembleMachinePartLink::getAssembleId, assembleIds));
         if (CollectionUtils.isNotEmpty(monomerAssembleMachinePartLinkList)) {
            monomerAssemblePartIdMap = this.machinePartService
               .listByIds(monomerAssembleMachinePartLinkList.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toList()))
               .stream()
               .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         }
      }

      if (CollectionUtils.isNotEmpty(monomerArtifactMachinePartLinkList)) {
         monomerPartIdMap = this.machinePartService
            .listByIds(monomerArtifactMachinePartLinkList.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      }

      if (CollectionUtils.isNotEmpty(monomerArtifactStandardPartLinkList)) {
         monomerStandardPartIdMap = this.standardPartService
            .listByIds(monomerArtifactStandardPartLinkList.stream().map(TechArtifactStandardPartLink::getId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
      }

      Map<Long, List<TechAssembleDetail>> monomerArtifactIdAssembleDetailListMap = monomerAssembleDetailList.stream()
         .collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
      Map<Long, List<TechArtifactMachinePartLink>> monomerArtifactIdLinkListMap = monomerArtifactMachinePartLinkList.stream()
         .collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
      Map<Long, List<TechArtifactStandardPartLink>> monomerArtifactStandardPartLinkListMap = monomerArtifactStandardPartLinkList.stream()
         .collect(Collectors.groupingBy(TechArtifactStandardPartLink::getArtifactId));
      Map<Long, List<TechAssembleMachinePartLink>> monomerAssembleIdAssembleMachinePartLinkMap = monomerAssembleMachinePartLinkList.stream()
         .collect(Collectors.groupingBy(TechAssembleMachinePartLink::getAssembleId));
      Map<Long, TechAssemble> finalMonomerAssembleIdMap = monomerAssembleIdMap;
      Map<Long, TechMachinePart> finalMonomerPartIdMap = monomerPartIdMap;
      Map<Long, TechMachinePart> finalMonomerAssemblePartIdMap = monomerAssemblePartIdMap;
      Map<Long, TechStandardPart> finalMonomerStandardPartIdMap = monomerStandardPartIdMap;
      artifactBoxDtoParamList.forEach(
         artifactBoxDtoParam -> {
            artifactBoxDtoParam.setBoolComposeAssemble(false);
            artifactBoxDtoParam.setBoolSameNumber(Boolean.FALSE);
            TechArtifact monomerArtifact = monomerArtifactSnMap.get(artifactBoxDtoParam.getSerialNumber());
            List<TechArtifact> artifacts = artifactSnListMap.get(artifactBoxDtoParam.getSerialNumber());
            if (monomerArtifact != null && artifacts.size() == 1 && ImportTypeEnum.REUTILIZATION.getType().equals(importType)) {
               artifactBoxDtoParam.setBoolSameNumber(Boolean.TRUE);
            }

            if (monomerArtifact != null
               && (artifacts.size() > 1 && ImportTypeEnum.REUTILIZATION.getType().equals(importType) || ImportTypeEnum.ADD_IMPORT.getType().equals(importType))
               )
             {
               this.extractedArtifact(
                  mistakeExportDTOList,
                  artifactBoxDtoParam,
                  monomerArtifact,
                  monomerArtifactIdAssembleDetailListMap,
                  monomerArtifactIdLinkListMap,
                  monomerArtifactStandardPartLinkListMap,
                  finalMonomerAssembleIdMap,
                  monomerAssembleIdAssembleMachinePartLinkMap,
                  finalMonomerAssemblePartIdMap,
                  finalMonomerPartIdMap,
                  finalMonomerStandardPartIdMap
               );
               if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
                  return;
               }

               this.checkArtifactEqual(monomerArtifact, artifactBoxDtoParam, mistakeExportDTOList, configurationDetailDTOMap);
               List<TechAssembleDetail> monomerAssembleDetails = monomerArtifactIdAssembleDetailListMap.getOrDefault(
                  monomerArtifact.getId(), Collections.emptyList()
               );
               List<TechArtifactMachinePartLink> monomerMachinePartLinks = monomerArtifactIdLinkListMap.getOrDefault(
                  monomerArtifact.getId(), Collections.emptyList()
               );
               if (monomerAssembleDetails.size() != artifactBoxDtoParam.getAssembleImportDtoParamList().size()) {
                  mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "构件使用的部件种类,和同单体内相同编号构件不一致!"));
               }

               if (monomerMachinePartLinks.size() != artifactBoxDtoParam.getMachinePartImportDtoParamList().size()) {
                  mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "构件使用的零件种类,和同单体内相同编号构件不一致!"));
               }

               List<InventoryAssembleImportDTO> assembleImportDtoParamList = artifactBoxDtoParam.getAssembleImportDtoParamList();
               if (CollectionUtils.isNotEmpty(monomerAssembleDetails)) {
                  Map<String, InventoryAssembleImportDTO> assembleImportDtoParamMap = assembleImportDtoParamList.stream()
                     .collect(Collectors.toMap(ArtifactPartImportCommonDTO::getSerialNumber, Function.identity()));
                  monomerAssembleDetails.forEach(
                     monomerAssembleDetail -> {
                        TechAssemble assemble = finalMonomerAssembleIdMap.get(monomerAssembleDetail.getAssembleId());
                        if (!assembleImportDtoParamMap.containsKey(assemble.getSerialNumber())) {
                           mistakeExportDTOList.add(
                              TechUtils.buildMistakeByOrderNoDTO(
                                 artifactBoxDtoParam.getOrderNo(), "构件编号(" + artifactBoxDtoParam.getSerialNumber() + ")在本单体内已存在,本次导入所使用的部件,必须与其保持一致!"
                              )
                           );
                        } else {
                           InventoryAssembleImportDTO assembleImportDtoParam = assembleImportDtoParamMap.get(assemble.getSerialNumber());
                           if (assembleImportDtoParam.getQuantity() / artifactBoxDtoParam.getQuantity() != monomerAssembleDetail.getQuantity()) {
                              mistakeExportDTOList.add(
                                 TechUtils.buildMistakeByOrderNoDTO(
                                    artifactBoxDtoParam.getOrderNo(), "构件编号(" + artifactBoxDtoParam.getSerialNumber() + ")在本单体内已存在,本次导入的零部件数量比例,必须与其保持一致!"
                                 )
                              );
                           }
                        }
                     }
                  );
               }

               List<MachinePartImportDtoParam> machinePartImportDtoParamList = artifactBoxDtoParam.getMachinePartImportDtoParamList();
               if (CollectionUtils.isNotEmpty(monomerMachinePartLinks)) {
                  Map<String, MachinePartImportDtoParam> machinePartImportDtoParamMap = machinePartImportDtoParamList.stream()
                     .collect(Collectors.toMap(ArtifactPartImportCommonDTO::getSerialNumber, Function.identity()));
                  monomerMachinePartLinks.forEach(
                     monomerPartLink -> {
                        TechMachinePart machinePart = finalMonomerPartIdMap.get(monomerPartLink.getMachinePartId());
                        if (!machinePartImportDtoParamMap.containsKey(machinePart.getSerialNumber())) {
                           mistakeExportDTOList.add(
                              TechUtils.buildMistakeByOrderNoDTO(
                                 artifactBoxDtoParam.getOrderNo(), "构件编号(" + artifactBoxDtoParam.getSerialNumber() + ")在本单体内已存在,本次导入所使用的零件,必须与其保持一致!"
                              )
                           );
                        } else {
                           MachinePartImportDtoParam machinePartImportDtoParam = machinePartImportDtoParamMap.get(machinePart.getSerialNumber());
                           if (machinePartImportDtoParam.getQuantity() / artifactBoxDtoParam.getQuantity() != monomerPartLink.getQuantity()) {
                              mistakeExportDTOList.add(
                                 TechUtils.buildMistakeByOrderNoDTO(
                                    artifactBoxDtoParam.getOrderNo(), "构件编号(" + artifactBoxDtoParam.getSerialNumber() + ")在本单体内已存在,本次导入的零件数量比例,必须与其保持一致!"
                                 )
                              );
                           }
                        }
                     }
                  );
               }
            }

            if (CollectionUtils.isNotEmpty(artifactBoxDtoParam.getAssembleImportDtoParamList())) {
               artifactBoxDtoParam.getAssembleImportDtoParamList()
                  .forEach(
                     assembleImportDtoParam -> {
                        TechAssemble assemble = monomerAssembleSnMap.get(assembleImportDtoParam.getSerialNumber());
                        if (assemble != null) {
                           List<MachinePartImportDtoParam> assembleElementMachinePartList = assembleImportDtoParam.getAssembleElementMachinePartList();
                           List<TechAssembleMachinePartLink> assembleMachinePartLinks = monomerAssembleIdAssembleMachinePartLinkMap.getOrDefault(
                              assemble.getId(), Collections.emptyList()
                           );
                           if (assembleMachinePartLinks.size()
                              != (CollectionUtils.isEmpty(assembleElementMachinePartList) ? 0 : assembleElementMachinePartList.size())) {
                              mistakeExportDTOList.add(new MistakeExportDTO(assembleImportDtoParam.getOrderNo(), "部件下的零件种类,和同单体内相同编号部件不一致!"));
                           }

                           if (CollectionUtils.isNotEmpty(assembleMachinePartLinks)) {
                              Map<String, MachinePartImportDtoParam> assembleElementMachinePartMap = assembleElementMachinePartList.stream()
                                 .collect(Collectors.toMap(ArtifactPartImportCommonDTO::getSerialNumber, Function.identity()));
                              assembleMachinePartLinks.forEach(
                                 monomerAssembleMachinePartLink -> {
                                    TechMachinePart machinePart = finalMonomerAssemblePartIdMap.get(monomerAssembleMachinePartLink.getMachinePartId());
                                    if (!assembleElementMachinePartMap.containsKey(machinePart.getSerialNumber())) {
                                       mistakeExportDTOList.add(
                                          TechUtils.buildMistakeByOrderNoDTO(
                                             assembleImportDtoParam.getOrderNo(),
                                             "部件编号(" + assembleImportDtoParam.getSerialNumber() + ")在本单体内已存在,本次导入所使用的零件,必须与其保持一致!"
                                          )
                                       );
                                    } else {
                                       MachinePartImportDtoParam machinePartImportDtoParam = assembleElementMachinePartMap.get(machinePart.getSerialNumber());
                                       if (machinePartImportDtoParam.getQuantity() / assembleImportDtoParam.getQuantity()
                                          != monomerAssembleMachinePartLink.getQuantity()) {
                                          mistakeExportDTOList.add(
                                             TechUtils.buildMistakeByOrderNoDTO(
                                                assembleImportDtoParam.getOrderNo(),
                                                "部件编号(" + assembleImportDtoParam.getSerialNumber() + ")在本单体内已存在,本次导入的零件数量比例,必须与其保持一致!"
                                             )
                                          );
                                       }
                                    }
                                 }
                              );
                           }

                           this.checkAssembleEqual(assemble, assembleImportDtoParam, mistakeExportDTOList);
                           if (CollectionUtils.isNotEmpty(assembleImportDtoParam.getAssembleElementMachinePartList())) {
                              assembleImportDtoParam.getAssembleElementMachinePartList().forEach(machinePartDtoParam -> {
                                 TechMachinePart machinePart = monomerMachinePartSnMap.get(machinePartDtoParam.getSerialNumber());
                                 if (machinePart != null) {
                                    this.checkPartEqual(machinePart, machinePartDtoParam, mistakeExportDTOList);
                                 }
                              });
                           }
                        }
                     }
                  );
            }

            if (CollectionUtils.isNotEmpty(artifactBoxDtoParam.getMachinePartImportDtoParamList())) {
               artifactBoxDtoParam.getMachinePartImportDtoParamList().forEach(machinePartDtoParam -> {
                  TechMachinePart machinePart = monomerMachinePartSnMap.get(machinePartDtoParam.getSerialNumber());
                  if (machinePart != null) {
                     this.checkPartEqual(machinePart, machinePartDtoParam, mistakeExportDTOList);
                  }
               });
            }
         }
      );
   }

   private void checkInMonomerPendingApproval(
      List<ArtifactBoxImportDTO> artifactBoxDtoParamList,
      Long monomerId,
      Integer inventoryTypeEnum,
      List<Long> boolComposeAssembleClassIds,
      Map<Integer, InventoryConfigurationDetailDTO> configurationDetailDTOMap,
      List<MistakeExportDTO> mistakeExportDTOList
   ) {
      List<MesTechInventoryOperation> techInventoryOperations = this.mesTechInventoryOperationService
         .list(
            (Wrapper<MesTechInventoryOperation>)(((new LambdaQueryWrapper<MesTechInventoryOperation>()
                        .eq(MesTechInventoryOperation::getMonomerId, monomerId))
                     .eq(MesTechInventoryOperation::getInventoryReviewedEnum, InventoryReviewedEnum.UNAUDITED.getType()))
                  .eq(MesTechInventoryOperation::getBuildingType, inventoryTypeEnum))
               .eq(MesTechInventoryOperation::getOperationTypeEnum, OperationTypeEnum.ADD_IMPORT.getType())
         );
      if (!CollectionUtils.isEmpty(techInventoryOperations)) {
         List<Long> operationIds = techInventoryOperations.stream().map(MesTechInventoryOperation::getId).collect(Collectors.toList());
         Map<String, TechArtifactRecord> monomerArtifactSnMap = this.artifactRecordService
            .list(
               (Wrapper<TechArtifactRecord>)((new LambdaQueryWrapper<TechArtifactRecord>().eq(TechArtifactRecord::getMonomerId, monomerId))
                     .in(
                        TechArtifactRecord::getInventoryOperationId,
                        techInventoryOperations.stream().map(MesTechInventoryOperation::getId).collect(Collectors.toList())
                     ))
                  .in(
                     TechArtifactRecord::getSerialNumber,
                     artifactBoxDtoParamList.stream().map(ArtifactPartImportCommonDTO::getSerialNumber).collect(Collectors.toList())
                  )
            )
            .stream()
            .collect(Collectors.toMap(TechArtifactRecord::getSerialNumber, Function.identity(), (s1, s2) -> s1));
         Map<String, TechAssembleRecord> monomerAssembleSnMap = this.assembleRecordService
            .list(
               (Wrapper<TechAssembleRecord>)(new LambdaQueryWrapper<TechAssembleRecord>().eq(TechAssembleRecord::getMonomerId, monomerId))
                  .in(TechAssembleRecord::getInventoryOperationId, operationIds)
            )
            .stream()
            .collect(Collectors.toMap(TechAssembleRecord::getSerialNumber, Function.identity(), (s1, s2) -> s1));
         Map<String, TechMachinePartRecord> monomerMachinePartSnMap = this.machinePartRecordService
            .list(
               (Wrapper<TechMachinePartRecord>)(new LambdaQueryWrapper<TechMachinePartRecord>().eq(TechMachinePartRecord::getMonomerId, monomerId))
                  .in(TechMachinePartRecord::getInventoryOperationId, operationIds)
            )
            .stream()
            .collect(Collectors.toMap(TechMachinePartRecord::getSerialNumber, Function.identity(), (s1, s2) -> s1));
         List<TechAssembleDetailRecord> monomerAssembleDetailList = Collections.emptyList();
         List<TechArtifactMachinePartLinkRecord> monomerArtifactMachinePartLinkList = Collections.emptyList();
         List<TechAssembleMachinePartLinkRecord> monomerAssembleMachinePartLinkList = Collections.emptyList();
         List<TechArtifactStandardPartLinkRecord> monomerArtifactStandardPartLinkList = Collections.emptyList();
         Map<Long, TechAssembleRecord> monomerAssembleIdMap = new HashMap<>();
         Map<Long, TechMachinePartRecord> monomerPartIdMap = new HashMap<>();
         Map<Long, TechMachinePartRecord> monomerAssemblePartIdMap = new HashMap<>();
         Map<Long, TechStandardPartRecord> monomerStandardPartIdMap = new HashMap<>();
         if (CollectionUtils.isNotEmpty(monomerArtifactSnMap)) {
            List<Long> artifactIds = monomerArtifactSnMap.values().stream().map(TechArtifactRecord::getId).collect(Collectors.toList());
            monomerAssembleDetailList = this.assembleDetailRecordService
               .list(Wrappers.lambdaQuery(TechAssembleDetailRecord.class).in(TechAssembleDetailRecord::getArtifactRecordId, artifactIds));
            monomerArtifactMachinePartLinkList = this.artifactMachinePartLinkRecordService
               .list(Wrappers.lambdaQuery(TechArtifactMachinePartLinkRecord.class).in(TechArtifactMachinePartLinkRecord::getArtifactRecordId, artifactIds));
            monomerArtifactStandardPartLinkList = this.artifactStandardPartLinkRecordService
               .list(Wrappers.lambdaQuery(TechArtifactStandardPartLinkRecord.class).in(TechArtifactStandardPartLinkRecord::getArtifactRecordId, artifactIds));
            if (CollectionUtils.isNotEmpty(monomerAssembleDetailList)) {
               monomerAssembleIdMap = this.assembleRecordService
                  .listByIds(monomerAssembleDetailList.stream().map(TechAssembleDetailRecord::getAssembleRecordId).collect(Collectors.toList()))
                  .stream()
                  .collect(Collectors.toMap(TechAssembleRecord::getId, Function.identity()));
            }
         }

         if (CollectionUtils.isNotEmpty(monomerAssembleSnMap)) {
            List<Long> assembleIds = monomerAssembleSnMap.values().stream().map(TechAssembleRecord::getId).collect(Collectors.toList());
            monomerAssembleMachinePartLinkList = this.assembleMachinePartLinkRecordService
               .list(
                  (Wrapper<TechAssembleMachinePartLinkRecord>)new LambdaQueryWrapper<TechAssembleMachinePartLinkRecord>().in(TechAssembleMachinePartLinkRecord::getAssembleRecordId, assembleIds)
               );
            if (CollectionUtils.isNotEmpty(monomerAssembleMachinePartLinkList)) {
               monomerAssemblePartIdMap = this.machinePartRecordService
                  .listByIds(
                     monomerAssembleMachinePartLinkList.stream().map(TechAssembleMachinePartLinkRecord::getMachinePartRecordId).collect(Collectors.toList())
                  )
                  .stream()
                  .collect(Collectors.toMap(TechMachinePartRecord::getId, Function.identity()));
            }
         }

         if (CollectionUtils.isNotEmpty(monomerArtifactMachinePartLinkList)) {
            monomerPartIdMap = this.machinePartRecordService
               .listByIds(
                  monomerArtifactMachinePartLinkList.stream().map(TechArtifactMachinePartLinkRecord::getMachinePartRecordId).collect(Collectors.toList())
               )
               .stream()
               .collect(Collectors.toMap(TechMachinePartRecord::getId, Function.identity()));
         }

         if (CollectionUtils.isNotEmpty(monomerArtifactStandardPartLinkList)) {
            monomerStandardPartIdMap = this.standardPartRecordService
               .listByIds(monomerArtifactStandardPartLinkList.stream().map(TechArtifactStandardPartLinkRecord::getId).collect(Collectors.toList()))
               .stream()
               .collect(Collectors.toMap(TechStandardPartRecord::getId, Function.identity()));
         }

         Map<Long, List<TechAssembleDetailRecord>> monomerArtifactIdAssembleDetailListMap = monomerAssembleDetailList.stream()
            .collect(Collectors.groupingBy(TechAssembleDetailRecord::getArtifactRecordId));
         Map<Long, List<TechArtifactMachinePartLinkRecord>> monomerArtifactIdLinkListMap = monomerArtifactMachinePartLinkList.stream()
            .collect(Collectors.groupingBy(TechArtifactMachinePartLinkRecord::getArtifactRecordId));
         Map<Long, List<TechArtifactStandardPartLinkRecord>> monomerArtifactStandardPartLinkListMap = monomerArtifactStandardPartLinkList.stream()
            .collect(Collectors.groupingBy(TechArtifactStandardPartLinkRecord::getArtifactRecordId));
         Map<Long, List<TechAssembleMachinePartLinkRecord>> monomerAssembleIdAssembleMachinePartLinkMap = monomerAssembleMachinePartLinkList.stream()
            .collect(Collectors.groupingBy(TechAssembleMachinePartLinkRecord::getAssembleRecordId));
         Map<Long, TechAssembleRecord> finalMonomerAssembleIdMap = monomerAssembleIdMap;
         Map<Long, TechMachinePartRecord> finalMonomerPartIdMap = monomerPartIdMap;
         Map<Long, TechMachinePartRecord> finalMonomerAssemblePartIdMap = monomerAssemblePartIdMap;
         artifactBoxDtoParamList.forEach(
            artifactBoxDtoParam -> {
               artifactBoxDtoParam.setBoolComposeAssemble(false);
               TechArtifactRecord monomerArtifact = monomerArtifactSnMap.get(artifactBoxDtoParam.getSerialNumber());
               if (monomerArtifact != null) {
                  this.checkRecordArtifactEqual(monomerArtifact, artifactBoxDtoParam, configurationDetailDTOMap, mistakeExportDTOList);
                  List<TechAssembleDetailRecord> monomerAssembleDetails = monomerArtifactIdAssembleDetailListMap.getOrDefault(
                     monomerArtifact.getId(), Collections.emptyList()
                  );
                  List<TechArtifactMachinePartLinkRecord> monomerMachinePartLinks = monomerArtifactIdLinkListMap.getOrDefault(
                     monomerArtifact.getId(), Collections.emptyList()
                  );
                  if (monomerAssembleDetails.size() != artifactBoxDtoParam.getAssembleImportDtoParamList().size()) {
                     mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "构件使用的部件种类,和同单体内相同编号构件{未审核}不一致!"));
                  }

                  if (monomerMachinePartLinks.size() != artifactBoxDtoParam.getMachinePartImportDtoParamList().size()) {
                     mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "构件使用的零件种类,和同单体内相同编号构件{未审核}不一致!"));
                  }

                  List<InventoryAssembleImportDTO> assembleImportDtoParamList = artifactBoxDtoParam.getAssembleImportDtoParamList();
                  if (CollectionUtils.isNotEmpty(monomerAssembleDetails)) {
                     Map<String, InventoryAssembleImportDTO> assembleImportDtoParamMap = assembleImportDtoParamList.stream()
                        .collect(Collectors.toMap(ArtifactPartImportCommonDTO::getSerialNumber, Function.identity()));
                     monomerAssembleDetails.forEach(
                        monomerAssembleDetail -> {
                           TechAssembleRecord assemble = finalMonomerAssembleIdMap.get(monomerAssembleDetail.getAssembleRecordId());
                           if (!assembleImportDtoParamMap.containsKey(assemble.getSerialNumber())) {
                              mistakeExportDTOList.add(
                                 TechUtils.buildMistakeByOrderNoDTO(
                                    artifactBoxDtoParam.getOrderNo(), "构件编号(" + artifactBoxDtoParam.getSerialNumber() + ")在本单体内已存在{未审核},本次导入所使用的部件,必须与其保持一致!"
                                 )
                              );
                           } else {
                              InventoryAssembleImportDTO assembleImportDtoParam = assembleImportDtoParamMap.get(assemble.getSerialNumber());
                              if (assembleImportDtoParam.getQuantity() / artifactBoxDtoParam.getQuantity() != monomerAssembleDetail.getQuantity()) {
                                 mistakeExportDTOList.add(
                                    TechUtils.buildMistakeByOrderNoDTO(
                                       artifactBoxDtoParam.getOrderNo(),
                                       "构件编号(" + artifactBoxDtoParam.getSerialNumber() + ")在本单体内已存在{未审核},本次导入的零部件数量比例,必须与其保持一致!"
                                    )
                                 );
                              }
                           }
                        }
                     );
                  }

                  if (InventoryTypeEnum.MES.getType().equals(inventoryTypeEnum)) {
                     List<MachinePartImportDtoParam> machinePartImportDtoParamList = artifactBoxDtoParam.getMachinePartImportDtoParamList();
                     if (CollectionUtils.isNotEmpty(monomerMachinePartLinks)) {
                        Map<String, MachinePartImportDtoParam> machinePartImportDtoParamMap = machinePartImportDtoParamList.stream()
                           .collect(Collectors.toMap(ArtifactPartImportCommonDTO::getSerialNumber, Function.identity()));
                        monomerMachinePartLinks.forEach(
                           monomerPartLink -> {
                              TechMachinePartRecord machinePart = finalMonomerPartIdMap.get(monomerPartLink.getMachinePartRecordId());
                              if (!machinePartImportDtoParamMap.containsKey(machinePart.getSerialNumber())) {
                                 mistakeExportDTOList.add(
                                    TechUtils.buildMistakeByOrderNoDTO(
                                       artifactBoxDtoParam.getOrderNo(), "构件编号(" + artifactBoxDtoParam.getSerialNumber() + ")在本单体内已存在,本次导入所使用的零件,必须与其保持一致!"
                                    )
                                 );
                              } else {
                                 MachinePartImportDtoParam machinePartImportDtoParam = machinePartImportDtoParamMap.get(machinePart.getSerialNumber());
                                 if (machinePartImportDtoParam.getQuantity() / artifactBoxDtoParam.getQuantity() != monomerPartLink.getQuantity()) {
                                    mistakeExportDTOList.add(
                                       TechUtils.buildMistakeByOrderNoDTO(
                                          artifactBoxDtoParam.getOrderNo(), "构件编号(" + artifactBoxDtoParam.getSerialNumber() + ")在本单体内已存在,本次导入的零件数量比例,必须与其保持一致!"
                                       )
                                    );
                                 }
                              }
                           }
                        );
                     }
                  }
               }

               if (CollectionUtils.isNotEmpty(artifactBoxDtoParam.getAssembleImportDtoParamList())) {
                  artifactBoxDtoParam.getAssembleImportDtoParamList()
                     .forEach(
                        assembleImportDtoParam -> {
                           TechAssembleRecord assemble = monomerAssembleSnMap.get(assembleImportDtoParam.getSerialNumber());
                           if (assemble != null) {
                              List<MachinePartImportDtoParam> assembleElementMachinePartList = assembleImportDtoParam.getAssembleElementMachinePartList();
                              List<TechAssembleMachinePartLinkRecord> assembleMachinePartLinks = monomerAssembleIdAssembleMachinePartLinkMap.getOrDefault(
                                 assemble.getId(), Collections.emptyList()
                              );
                              if (CollectionUtils.isNotEmpty(assembleMachinePartLinks)) {
                                 if (CollectionUtils.isNotEmpty(assembleElementMachinePartList)
                                    && assembleMachinePartLinks.size() != assembleElementMachinePartList.size()) {
                                    mistakeExportDTOList.add(new MistakeExportDTO(assembleImportDtoParam.getOrderNo(), "部件下的零件种类,和同单体内相同编号部件{未审核}不一致!"));
                                    return;
                                 }

                                 Map<String, MachinePartImportDtoParam> assembleElementMachinePartMap = assembleElementMachinePartList.stream()
                                    .collect(Collectors.toMap(ArtifactPartImportCommonDTO::getSerialNumber, Function.identity()));
                                 assembleMachinePartLinks.forEach(
                                    monomerAssembleMachinePartLink -> {
                                       TechMachinePartRecord machinePart = finalMonomerAssemblePartIdMap.get(
                                          monomerAssembleMachinePartLink.getMachinePartRecordId()
                                       );
                                       if (!assembleElementMachinePartMap.containsKey(machinePart.getSerialNumber())) {
                                          mistakeExportDTOList.add(
                                             TechUtils.buildMistakeByOrderNoDTO(
                                                assembleImportDtoParam.getOrderNo(),
                                                "部件编号(" + assembleImportDtoParam.getSerialNumber() + ")在本单体内已存在{未审核},本次导入所使用的零件,必须与其保持一致!"
                                             )
                                          );
                                       } else {
                                          MachinePartImportDtoParam machinePartImportDtoParam = assembleElementMachinePartMap.get(machinePart.getSerialNumber());
                                          if (machinePartImportDtoParam.getQuantity() / assembleImportDtoParam.getQuantity()
                                             != monomerAssembleMachinePartLink.getQuantity()) {
                                             mistakeExportDTOList.add(
                                                TechUtils.buildMistakeByOrderNoDTO(
                                                   assembleImportDtoParam.getOrderNo(),
                                                   "部件编号(" + assembleImportDtoParam.getSerialNumber() + ")在本单体内已存在{未审核},本次导入的零件数量比例,必须与其保持一致!"
                                                )
                                             );
                                          }
                                       }
                                    }
                                 );
                              }

                              this.checkRecordAssembleEqual(assemble, assembleImportDtoParam, configurationDetailDTOMap, mistakeExportDTOList);
                              if (CollectionUtils.isNotEmpty(assembleImportDtoParam.getAssembleElementMachinePartList())) {
                                 assembleImportDtoParam.getAssembleElementMachinePartList().forEach(machinePartDtoParam -> {
                                    TechMachinePartRecord machinePart = monomerMachinePartSnMap.get(machinePartDtoParam.getSerialNumber());
                                    if (machinePart != null) {
                                       this.checkRecordPartEqual(machinePart, machinePartDtoParam, configurationDetailDTOMap, mistakeExportDTOList);
                                    }
                                 });
                              }
                           }
                        }
                     );
               }

               if (CollectionUtils.isNotEmpty(artifactBoxDtoParam.getMachinePartImportDtoParamList())) {
                  artifactBoxDtoParam.getMachinePartImportDtoParamList().forEach(machinePartDtoParam -> {
                     TechMachinePartRecord machinePart = monomerMachinePartSnMap.get(machinePartDtoParam.getSerialNumber());
                     if (machinePart != null) {
                        this.checkRecordPartEqual(machinePart, machinePartDtoParam, configurationDetailDTOMap, mistakeExportDTOList);
                     }
                  });
               }
            }
         );
      }
   }

   private void extractedArtifact(
      List<MistakeExportDTO> mistakeExportDTOList,
      ArtifactBoxImportDTO artifactBoxDtoParam,
      TechArtifact monomerArtifact,
      Map<Long, List<TechAssembleDetail>> monomerArtifactIdAssembleDetailListMap,
      Map<Long, List<TechArtifactMachinePartLink>> monomerArtifactIdLinkListMap,
      Map<Long, List<TechArtifactStandardPartLink>> monomerArtifactStandardPartLinkListMap,
      Map<Long, TechAssemble> finalMonomerAssembleIdMap,
      Map<Long, List<TechAssembleMachinePartLink>> monomerAssembleIdAssembleMachinePartLinkMap,
      Map<Long, TechMachinePart> finalMonomerAssemblePartIdMap,
      Map<Long, TechMachinePart> finalMonomerPartIdMap,
      Map<Long, TechStandardPart> finalMonomerStandardPartIdMap
   ) {
      if (monomerArtifact.getBoolComposeAssemble()) {
         artifactBoxDtoParam.setSpecification(monomerArtifact.getSpecification());
         artifactBoxDtoParam.setSpecPrefix(monomerArtifact.getSpecPrefix());
         artifactBoxDtoParam.setBoolComposeAssemble(Boolean.TRUE);
         artifactBoxDtoParam.setStructureClassId(monomerArtifact.getStructureClassId());
         List<InventoryAssembleImportDTO> newAssembleImportDtoParamList = new ArrayList<>();
         List<TechAssembleDetail> monomerAssembleDetails = monomerArtifactIdAssembleDetailListMap.get(monomerArtifact.getId());
         if (CollectionUtils.isEmpty(monomerAssembleDetails)) {
            mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "操作失败,同单体下该构件的部件数据不一致!"));
         }

         List<TechArtifactMachinePartLink> monomerPartLinkList = monomerArtifactIdLinkListMap.getOrDefault(monomerArtifact.getId(), null);
         List<TechArtifactStandardPartLink> monomerStandPartLinkList = monomerArtifactStandardPartLinkListMap.getOrDefault(monomerArtifact.getId(), null);
         if (CollectionUtils.isNotEmpty(monomerAssembleDetails)) {
            monomerAssembleDetails.forEach(assembleDetail -> {
               TechAssemble assemble = finalMonomerAssembleIdMap.get(assembleDetail.getAssembleId());
               InventoryAssembleImportDTO copy = BeanUtil.copy(assemble, InventoryAssembleImportDTO.class);
               copy.setQuantity(assembleDetail.getQuantity() * artifactBoxDtoParam.getQuantity());
               copy.setOrderNo(artifactBoxDtoParam.getQuantity());
               copy.setBoolPossessPlateWeb(Boolean.TRUE);
               copy.setProductClassificationEnum(ProductClassificationEnum.ASSEMBLE.getType());
               List<MachinePartImportDtoParam> assemblePartImportDtoParams = new ArrayList<>();
               List<TechAssembleMachinePartLink> techAssembleMachinePartLinks = monomerAssembleIdAssembleMachinePartLinkMap.get(assemble.getId());
               if (CollectionUtils.isEmpty(techAssembleMachinePartLinks)) {
                  mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "操作失败,同单体下该构件的部件翼腹板数据不一致!"));
               }

               if (CollectionUtils.isNotEmpty(techAssembleMachinePartLinks)) {
                  techAssembleMachinePartLinks.forEach(assemblePartLink -> {
                     TechMachinePart assemblePart = finalMonomerAssemblePartIdMap.get(assemblePartLink.getMachinePartId());
                     MachinePartImportDtoParam assemblePartImportDtoParam = BeanUtil.copy(assemblePart, MachinePartImportDtoParam.class);
                     assemblePartImportDtoParam.setOrderNo(artifactBoxDtoParam.getOrderNo());
                     assemblePartImportDtoParam.setQuantityRatio(assemblePartLink.getQuantity());
                     assemblePartImportDtoParam.setQuantity(assemblePartLink.getQuantity() * copy.getQuantity());
                     assemblePartImportDtoParams.add(assemblePartImportDtoParam);
                  });
               }

               copy.setAssembleElementMachinePartList(assemblePartImportDtoParams);
               newAssembleImportDtoParamList.add(copy);
            });
         }

         artifactBoxDtoParam.setAssembleImportDtoParamList(newAssembleImportDtoParamList);
         List<MachinePartImportDtoParam> newPartImportDtoParams = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(monomerPartLinkList)) {
            monomerPartLinkList.forEach(partLink -> {
               TechMachinePart part = finalMonomerPartIdMap.get(partLink.getMachinePartId());
               MachinePartImportDtoParam partImportDtoParam = BeanUtil.copy(part, MachinePartImportDtoParam.class);
               partImportDtoParam.setOrderNo(artifactBoxDtoParam.getOrderNo());
               partImportDtoParam.setQuantity(partLink.getQuantity() * artifactBoxDtoParam.getQuantity());
               newPartImportDtoParams.add(partImportDtoParam);
            });
            artifactBoxDtoParam.setMachinePartImportDtoParamList(newPartImportDtoParams);
         }

         List<StandardPartImportDTOParam> newStandPartImportDtoParams = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(monomerStandPartLinkList)) {
            monomerStandPartLinkList.forEach(partStandLink -> {
               TechStandardPart standardPart = finalMonomerStandardPartIdMap.get(partStandLink.getStandardPartId());
               StandardPartImportDTOParam partStandImportDtoParam = BeanUtil.copy(standardPart, StandardPartImportDTOParam.class);
               partStandImportDtoParam.setOrderNo(artifactBoxDtoParam.getOrderNo());
               partStandImportDtoParam.setQuantity(partStandLink.getQuantity() * artifactBoxDtoParam.getQuantity());
               newStandPartImportDtoParams.add(partStandImportDtoParam);
            });
            artifactBoxDtoParam.setStandardPartImportDTOParamList(newStandPartImportDtoParams);
         }
      }
   }

   private void checkPartEqual(
      TechMachinePart monomerMachinePart, MachinePartImportDtoParam machinePartImportDtoParam, List<MistakeExportDTO> mistakeExportDTOList
   ) {
      if (!monomerMachinePart.getSpecPrefix().equals(machinePartImportDtoParam.getSpecPrefix())) {
         mistakeExportDTOList.add(new MistakeExportDTO(machinePartImportDtoParam.getOrderNo(), "零件规格和同单体内相同编号零件规格前缀不一致!"));
      }

      if (!monomerMachinePart.getMaterial().equals(machinePartImportDtoParam.getMaterial())) {
         mistakeExportDTOList.add(new MistakeExportDTO(machinePartImportDtoParam.getOrderNo(), "零件材质和同单体内相同编号零件材质不一致!"));
      }
   }

   private void checkAssembleEqual(TechAssemble monomerAssemble, InventoryAssembleImportDTO assembleImportDtoParam, List<MistakeExportDTO> mistakeExportDTOList) {
      if (!monomerAssemble.getSpecification().equals(assembleImportDtoParam.getSpecification())) {
         mistakeExportDTOList.add(new MistakeExportDTO(assembleImportDtoParam.getOrderNo(), "部件规格和同单体内相同编号部件规格不一致!"));
      }

      if (!monomerAssemble.getMaterial().equals(assembleImportDtoParam.getMaterial())) {
         mistakeExportDTOList.add(new MistakeExportDTO(assembleImportDtoParam.getOrderNo(), "部件材质和同单体内相同编号部件材质不一致!"));
      }
   }

   private void checkRecordPartEqual(
      TechMachinePartRecord monomerMachinePart,
      MachinePartImportDtoParam machinePartImportDtoParam,
      Map<Integer, InventoryConfigurationDetailDTO> configurationDetailDTOMap,
      List<MistakeExportDTO> mistakeExportDTOList
   ) {
      if (!monomerMachinePart.getSpecPrefix().equals(machinePartImportDtoParam.getSpecPrefix())) {
         mistakeExportDTOList.add(new MistakeExportDTO(machinePartImportDtoParam.getOrderNo(), "零件规格和同单体内相同编号零件{未审核}规格前缀不一致!"));
      }

      if (!monomerMachinePart.getMaterial().equals(machinePartImportDtoParam.getMaterial())) {
         mistakeExportDTOList.add(new MistakeExportDTO(machinePartImportDtoParam.getOrderNo(), "零件材质和同单体内相同编号零件{未审核}材质不一致!"));
      }
   }

   private void checkRecordAssembleEqual(
      TechAssembleRecord monomerAssemble,
      InventoryAssembleImportDTO assembleImportDtoParam,
      Map<Integer, InventoryConfigurationDetailDTO> configurationDetailDTOMap,
      List<MistakeExportDTO> mistakeExportDTOList
   ) {
      if (!monomerAssemble.getSpecification().equals(assembleImportDtoParam.getSpecification())) {
         mistakeExportDTOList.add(new MistakeExportDTO(assembleImportDtoParam.getOrderNo(), "部件规格和同单体内相同编号部件{未审核}规格不一致!"));
      }

      if (!monomerAssemble.getMaterial().equals(assembleImportDtoParam.getMaterial())) {
         mistakeExportDTOList.add(new MistakeExportDTO(assembleImportDtoParam.getOrderNo(), "部件材质和同单体内相同编号部件{未审核}材质不一致!"));
      }
   }

   private void checkArtifactEqual(
      TechArtifact artifact,
      ArtifactBoxImportDTO artifactBoxDtoParam,
      List<MistakeExportDTO> mistakeExportDTOList,
      Map<Integer, InventoryConfigurationDetailDTO> configurationDetailDTOMap
   ) {
      InventoryConfigurationDetailDTO configurationDetailDTO = configurationDetailDTOMap.get(ProductTypeEnum.ARTIFACT.getType());
      if (!artifact.getName().equals(artifactBoxDtoParam.getName())) {
         mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "构件名称和同单体内相同编号构件名称不一致!"));
      }

      if (!artifact.getSpecification().equals(artifactBoxDtoParam.getSpecification())) {
         mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "构件规格和同单体内相同编号构件规格不一致!"));
      }

      if (!artifact.getMaterial().equals(artifactBoxDtoParam.getMaterial())) {
         mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "构件材质和同单体内相同编号构件材质不一致!"));
      }

      if (artifact.getLength().setScale(0, RoundingMode.HALF_UP).compareTo(artifactBoxDtoParam.getLength().setScale(0, RoundingMode.HALF_UP)) != 0) {
         BigDecimal negate = artifact.getLength().subtract(artifactBoxDtoParam.getLength());
         if (configurationDetailDTO.getLength().compareTo(negate.compareTo(BigDecimal.ZERO) < 0 ? negate.negate() : negate) < 0) {
            mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "构件长度和同单体内相同编号构件长度不一致(超过误差范围)!"));
         }
      }
   }

   private void checkRecordArtifactEqual(
      TechArtifactRecord artifact,
      ArtifactBoxImportDTO artifactBoxDtoParam,
      Map<Integer, InventoryConfigurationDetailDTO> configurationDetailDTOMap,
      List<MistakeExportDTO> mistakeExportDTOList
   ) {
      InventoryConfigurationDetailDTO configurationDetailDTO = configurationDetailDTOMap.get(ProductTypeEnum.ARTIFACT.getType());
      if (!artifact.getName().equals(artifactBoxDtoParam.getName())) {
         mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "构件名称和同单体内导入相同编号构件{未审核}名称不一致!"));
      }

      if (!artifact.getSpecification().equals(artifactBoxDtoParam.getSpecification()) && !artifact.getBoolComposeAssemble()) {
         mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "构件规格和同单体内相同编号构件{未审核}规格不一致!"));
      }

      if (!artifact.getMaterial().equals(artifactBoxDtoParam.getMaterial())) {
         mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "构件材质和同单体内相同编号构件{未审核}材质不一致!"));
      }

      if (artifact.getLength().setScale(0, RoundingMode.HALF_UP).compareTo(artifactBoxDtoParam.getLength().setScale(0, RoundingMode.HALF_UP)) != 0) {
         BigDecimal negate = artifact.getLength().subtract(artifactBoxDtoParam.getLength());
         if (configurationDetailDTO.getLength().compareTo(negate.compareTo(BigDecimal.ZERO) < 0 ? negate.negate() : negate) < 0) {
            mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "构件长度和同单体内相同编号构件{未审核}长度不一致(超过误差范围)!"));
         }
      }
   }

   private List<ArtifactBoxImportDTO> convertSecondArtifact(
      List<List<ZnljArtifactMachinePartImportTemplateDtoParam>> artifactImportLists,
      TechConfigUtilsDTO utilsDTO,
      Integer importTypeEnum,
      List<MistakeExportDTO> mistakeExportDTOList
   ) {
      Map<Long, SysStructureClassification> sysStructureClassificationMap = this.structureClassificationService
         .list()
         .stream()
         .collect(Collectors.toMap(SysStructureClassification::getId, Function.identity()));
      List<String> specialMaterialList = Arrays.stream("Q235B-HW,Q355B-HW,不锈钢,钢板网,橡胶垫块,钢格栅".split(",")).collect(Collectors.toList());
      Map<String, Map<String, Long>> steelClassSpecNameLinkMap = utilsDTO.getSteelClassSpecNameLinkMap();
      List<ArtifactBoxImportDTO> artifactBoxImportMiddleDtoParamList = new ArrayList<>(512);
      Map<String, Long> commonStructureSpecMap = utilsDTO.getCommonStructureSpecMap();
      List<Long> purlinClassIds = utilsDTO.getPurlinClassIds();
      Map<String, Map<String, Long>> smallStructureSpecSnMap = utilsDTO.getSmallArtifactNameMap();
      Map<String, Long> assembleSpecMap = utilsDTO.getAssembleSpecMap();
      Map<String, Long> machinePartSpecMap = utilsDTO.getMachinePartSpecMap();
      Map<String, Long> sectionMachinePartSpecMap = utilsDTO.getSectionMachinePartSpecMap();
      Map<Integer, Map<String, Long>> standardPartConfigMap = utilsDTO.getStandardPartConfigMap();
      Map<String, Long> standardPartNameAndIdMap = standardPartConfigMap.get(ProductSectionNameEnum.PRODUCT_NAME.getType());
      List<String> mesArtifactClassNameList = utilsDTO.getMesArtifactClassNameList();
      Set<String> artifactSnSet = new HashSet<>(36);
      artifactImportLists.forEach(
         importList -> {
            ZnljArtifactMachinePartImportTemplateDtoParam artifactTemplateDtoParam = importList.get(0);
            ArtifactBoxImportDTO artifactBoxMiddleDtoParam = BeanUtil.copy(artifactTemplateDtoParam, ArtifactBoxImportDTO.class);
            if (!mesArtifactClassNameList.contains(artifactTemplateDtoParam.getStructureType())) {
               if (artifactBoxMiddleDtoParam.getStructureType() == null) {
                  mistakeExportDTOList.add(new MistakeExportDTO(artifactTemplateDtoParam.getOrderNo(), "构件类别不可为空"));
               } else {
                  mistakeExportDTOList.add(
                     new MistakeExportDTO(artifactTemplateDtoParam.getOrderNo(), "构件的类别[" + artifactBoxMiddleDtoParam.getStructureType() + "]不在构件类别配置!")
                  );
               }
            }

            artifactBoxMiddleDtoParam.setBuildingType(InventoryTypeEnum.MES.getType());
            artifactBoxMiddleDtoParam.setSerialNumber(artifactTemplateDtoParam.getArtifactNo());
            artifactBoxMiddleDtoParam.setBoolSinglePartEnum(Boolean.FALSE);
            artifactBoxMiddleDtoParam.setBoolCoatingEnum(Boolean.FALSE);
            String artifactSpecPrefix = TechUtils.getSpecPrefix(artifactBoxMiddleDtoParam.getSpecification());
            if (StringUtils.isBlank(artifactSpecPrefix)) {
               mistakeExportDTOList.add(
                  new MistakeExportDTO(artifactTemplateDtoParam.getOrderNo(), "构件的规格[" + artifactBoxMiddleDtoParam.getSpecification() + "]无法解析出规格前缀!")
               );
            } else {
               artifactBoxMiddleDtoParam.setSpecPrefix(artifactSpecPrefix);
               artifactBoxMiddleDtoParam.setBoolSchedulingEnum(Boolean.TRUE);
               artifactBoxMiddleDtoParam.setBoolAllPartSendDirectly(Boolean.FALSE);
               artifactBoxMiddleDtoParam.setSerialNumberPrefix(artifactBoxMiddleDtoParam.getName());
               if (artifactSnSet.contains(artifactBoxMiddleDtoParam.getSerialNumber())) {
                  mistakeExportDTOList.add(
                     TechUtils.buildMistakeByOrderNoDTO(artifactBoxMiddleDtoParam.getOrderNo(), "构件编号" + artifactBoxMiddleDtoParam.getSerialNumber() + "重复!")
                  );
               }

               artifactSnSet.add(artifactBoxMiddleDtoParam.getSerialNumber());
               if (smallStructureSpecSnMap.containsKey(artifactSpecPrefix)
                  && smallStructureSpecSnMap.get(artifactSpecPrefix).containsKey(artifactBoxMiddleDtoParam.getName())) {
                  Long structureClassId = smallStructureSpecSnMap.get(artifactSpecPrefix).get(artifactBoxMiddleDtoParam.getName());
                  artifactBoxMiddleDtoParam.setStructureClassId(structureClassId);
                  artifactBoxMiddleDtoParam.setArtifactType(ArtifactTypeEnum.SMALL.getType());
                  artifactBoxMiddleDtoParam.setBoolPurlineClass(purlinClassIds.contains(structureClassId));
                  SysStructureClassification classification = sysStructureClassificationMap.get(structureClassId);
                  artifactBoxMiddleDtoParam.setCodingType(classification.getCodingType());
                  artifactBoxMiddleDtoParam.setBoolAllPartSendDirectly(Boolean.FALSE);
               } else if (commonStructureSpecMap.containsKey(artifactSpecPrefix)) {
                  Long structureClassId = commonStructureSpecMap.get(artifactSpecPrefix);
                  artifactBoxMiddleDtoParam.setStructureClassId(structureClassId);
                  artifactBoxMiddleDtoParam.setArtifactType(ArtifactTypeEnum.COMMON.getType());
                  artifactBoxMiddleDtoParam.setCodingType(CodingTypeEnum.SINGLE.getType());
               } else {
                  artifactBoxMiddleDtoParam.setArtifactType(0);
                  if (ImportTypeEnum.ADD_IMPORT.getType().equals(importTypeEnum) && !artifactSpecPrefix.equals("PL")) {
                     mistakeExportDTOList.add(
                        new MistakeExportDTO(
                           artifactTemplateDtoParam.getOrderNo(), "构件的规格前缀[" + artifactSpecPrefix + "和名称" + artifactTemplateDtoParam.getName() + "] 未定义!"
                        )
                     );
                  }

                  if (ImportTypeEnum.REUTILIZATION.getType().equals(importTypeEnum)) {
                     mistakeExportDTOList.add(
                        TechUtils.buildMistakeByOrderNoDTO(
                           artifactTemplateDtoParam.getOrderNo(), "构件的规格前缀[" + artifactSpecPrefix + "和名称" + artifactTemplateDtoParam.getName() + "] 未定义!"
                        )
                     );
                  }
               }

               if (artifactTemplateDtoParam.getBoolCoatingEnum() == null) {
                  artifactBoxMiddleDtoParam.setBoolCoatingEnum(Boolean.TRUE);
               } else {
                  artifactBoxMiddleDtoParam.setBoolCoatingEnum(artifactTemplateDtoParam.getBoolCoatingEnum());
               }

               Map<String, InventoryAssembleImportDTO> assembleDtoParamListMap = new HashMap<>();
               AtomicReference<InventoryAssembleImportDTO> assembleImportDTO = new AtomicReference<>();
               List<MachinePartImportDtoParam> machinePartDtoParamList = new ArrayList<>(32);
               List<StandardPartImportDTOParam> standardPartDtoParamList = new ArrayList<>(16);
               Set<String> plateSnSet = new HashSet<>(36);
               this.buildStandardPartDTOList(
                  mistakeExportDTOList,
                  (List<ZnljArtifactMachinePartImportTemplateDtoParam>)importList,
                  artifactTemplateDtoParam,
                  standardPartNameAndIdMap,
                  standardPartDtoParamList
               );
               List<ZnljArtifactMachinePartImportTemplateDtoParam> assembleAndPartImportList = importList.stream()
                  .skip(1L)
                  .filter(importTemplateDtoParam -> !standardPartNameAndIdMap.containsKey(importTemplateDtoParam.getName()))
                  .collect(Collectors.toList());
               AtomicReference<Set<String>> assemblePlateSnSet = new AtomicReference<>(new HashSet<>(36));
               assembleAndPartImportList.forEach(
                  templateDtoParam -> {
                     if (templateDtoParam.getQuantity() % artifactTemplateDtoParam.getQuantity() > 0) {
                        mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(templateDtoParam.getOrderNo(), "零部件数量必须是构件数量的整数倍!"));
                     }

                     String specPrefix = TechUtils.getSpecPrefix(templateDtoParam.getSpecification());
                     if (!assembleSpecMap.containsKey(specPrefix)
                        && !machinePartSpecMap.containsKey(specPrefix)
                        && !sectionMachinePartSpecMap.containsKey(specPrefix)
                        && (
                           !steelClassSpecNameLinkMap.containsKey(specPrefix)
                              || !steelClassSpecNameLinkMap.get(specPrefix).containsKey(templateDtoParam.getName())
                        )) {
                        mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(templateDtoParam.getOrderNo(), "零部件规格前缀类型[" + specPrefix + "]未定义!"));
                     }

                     if (assembleSpecMap.containsKey(specPrefix)) {
                        assemblePlateSnSet.set(new HashSet<>());
                        InventoryAssembleImportDTO assembleImportDtoParam = BeanUtil.copy(templateDtoParam, InventoryAssembleImportDTO.class);
                        if (assembleDtoParamListMap.get(templateDtoParam.getSerialNumber()) != null) {
                           mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(templateDtoParam.getOrderNo(), "部件编号重复!"));
                           return;
                        }

                        assembleImportDTO.set(assembleImportDtoParam);
                        assembleImportDtoParam.setSpecPrefix(specPrefix);
                        assembleImportDtoParam.setProductClassificationEnum(ProductClassificationEnum.ASSEMBLE.getType());
                        assembleImportDtoParam.setBoolPossessPlateWeb(Boolean.FALSE);
                        assembleImportDtoParam.setBoolSendDirectly(
                           this.SEND_DIRECTLY_MARK_LIST.contains(assembleImportDtoParam.getStructureType())
                              || artifactBoxMiddleDtoParam.getBoolAllPartSendDirectly()
                        );
                        assembleImportDtoParam.setBoolAllPartSendDirectly(artifactBoxMiddleDtoParam.getBoolAllPartSendDirectly());
                        assembleDtoParamListMap.put(assembleImportDtoParam.getSerialNumber(), assembleImportDtoParam);
                     } else {
                        if (StringUtils.isBlank(templateDtoParam.getRecognitionCode())) {
                           if (plateSnSet.contains(templateDtoParam.getSerialNumber())) {
                              mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(templateDtoParam.getOrderNo(), "构件下的零件编号重复!"));
                           }

                           plateSnSet.add(templateDtoParam.getSerialNumber());
                        } else {
                           if (assemblePlateSnSet.get().contains(templateDtoParam.getSerialNumber())) {
                              mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(templateDtoParam.getOrderNo(), "部件下的翼腹板编号重复!"));
                           }

                           assemblePlateSnSet.get().add(templateDtoParam.getSerialNumber());
                        }

                        MachinePartImportDtoParam machinePartImportDtoParam = BeanUtil.copy(templateDtoParam, MachinePartImportDtoParam.class);
                        machinePartImportDtoParam.setSpecPrefix(specPrefix);
                        machinePartImportDtoParam.setProductClassificationEnum(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType());
                        machinePartImportDtoParam.setBoolSendDirectly(Boolean.FALSE);
                        machinePartImportDtoParam.setBoolAllPartSendDirectly(Boolean.FALSE);
                        if (StringUtils.isNotBlank(templateDtoParam.getRecognitionCode())) {
                           InventoryAssembleImportDTO assembleImport = assembleImportDTO.get();
                           if (assembleImport == null) {
                              mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(templateDtoParam.getOrderNo(), "翼腹板零件未匹配到相应的部件!"));
                              return;
                           }

                           if (machinePartImportDtoParam.getQuantity() % assembleImport.getQuantity() > 0) {
                              mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(templateDtoParam.getOrderNo(), "翼腹版数量必须是部件数量的整数倍!"));
                           }

                           machinePartImportDtoParam.setName(templateDtoParam.getRecognitionCode());
                           machinePartImportDtoParam.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECONDARY_MEMBER.getType());
                           machinePartImportDtoParam.setRelationType(MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType());
                           machinePartImportDtoParam.setSteelId(steelClassSpecNameLinkMap.get(specPrefix).get(templateDtoParam.getRecognitionCode()));
                           machinePartImportDtoParam.setQuantityRatio(machinePartImportDtoParam.getQuantity() / assembleImport.getQuantity());
                           if (!specialMaterialList.contains(machinePartImportDtoParam.getMaterial())) {
                              BigDecimal grossWeight = machinePartImportDtoParam.getThickness()
                                 .multiply(machinePartImportDtoParam.getWidth())
                                 .multiply(machinePartImportDtoParam.getLength())
                                 .multiply(BigDecimal.valueOf(7.85))
                                 .divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP);
                              machinePartImportDtoParam.setGrossWeight(grossWeight);
                           } else {
                              machinePartImportDtoParam.setGrossWeight(
                                 machinePartImportDtoParam.getGrossWeight() != null ? machinePartImportDtoParam.getGrossWeight() : BigDecimal.ZERO
                              );
                           }

                           machinePartImportDtoParam.setNetWeight(
                              machinePartImportDtoParam.getNetWeight() != null ? machinePartImportDtoParam.getNetWeight() : BigDecimal.ZERO
                           );
                           InventoryAssembleImportDTO plateWebAssemble = assembleDtoParamListMap.get(assembleImport.getSerialNumber());
                           plateWebAssemble.setBoolPossessPlateWeb(Boolean.TRUE);
                           List<MachinePartImportDtoParam> assembleElementMachinePartList = plateWebAssemble.getAssembleElementMachinePartList();
                           if (assembleElementMachinePartList == null) {
                              assembleElementMachinePartList = new ArrayList<>();
                           }

                           assembleElementMachinePartList.add(machinePartImportDtoParam);
                           plateWebAssemble.setAssembleElementMachinePartList(assembleElementMachinePartList);
                        } else if (machinePartSpecMap.containsKey(specPrefix)) {
                           if (!specialMaterialList.contains(machinePartImportDtoParam.getMaterial())) {
                              BigDecimal grossWeight = machinePartImportDtoParam.getThickness()
                                 .multiply(machinePartImportDtoParam.getWidth())
                                 .multiply(machinePartImportDtoParam.getLength())
                                 .multiply(BigDecimal.valueOf(7.85))
                                 .divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP);
                              machinePartImportDtoParam.setGrossWeight(grossWeight);
                           } else {
                              machinePartImportDtoParam.setGrossWeight(
                                 machinePartImportDtoParam.getGrossWeight() != null ? machinePartImportDtoParam.getGrossWeight() : BigDecimal.ZERO
                              );
                           }

                           machinePartImportDtoParam.setSteelPlateTypeEnum(SteelPlateTypeEnum.PRIMARY_MEMBER.getType());
                           machinePartImportDtoParam.setRelationType(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType());
                           machinePartImportDtoParam.setSteelId(machinePartSpecMap.get(specPrefix));
                           machinePartImportDtoParam.setBoolSendDirectly(
                              this.SEND_DIRECTLY_MARK_LIST.contains(machinePartImportDtoParam.getStructureType())
                                 || artifactBoxMiddleDtoParam.getBoolAllPartSendDirectly()
                           );
                           machinePartImportDtoParam.setBoolAllPartSendDirectly(artifactBoxMiddleDtoParam.getBoolAllPartSendDirectly());
                           machinePartDtoParamList.add(machinePartImportDtoParam);
                        } else if (sectionMachinePartSpecMap.containsKey(specPrefix)) {
                           machinePartImportDtoParam.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECTIONSTEEL.getType());
                           machinePartImportDtoParam.setRelationType(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType());
                           machinePartImportDtoParam.setProductClassificationEnum(ProductClassificationEnum.SECTION_PRODUCT.getType());
                           machinePartImportDtoParam.setSteelId(sectionMachinePartSpecMap.get(specPrefix));
                           machinePartImportDtoParam.setBoolAllPartSendDirectly(artifactBoxMiddleDtoParam.getBoolAllPartSendDirectly());
                           machinePartImportDtoParam.setBoolSendDirectly(
                              this.SEND_DIRECTLY_MARK_LIST.contains(machinePartImportDtoParam.getStructureType())
                                 || artifactBoxMiddleDtoParam.getBoolAllPartSendDirectly()
                           );
                           machinePartDtoParamList.add(machinePartImportDtoParam);
                        }
                     }
                  }
               );
               if (CollectionUtils.isNotEmpty(assembleDtoParamListMap)) {
                  for (InventoryAssembleImportDTO assembleImportDto : assembleDtoParamListMap.values()) {
                     this.correctAssembleWeightArea(assembleImportDto);
                     if (assembleImportDto.getGrossWeight() == null || assembleImportDto.getGrossWeight().compareTo(BigDecimal.ZERO) <= 0) {
                        mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(assembleImportDto.getOrderNo(), "部件单毛重不能为空或者为0，请检查清单(例如翼腹板识别码没有正确标识)!"));
                     }
                  }
               }

               artifactBoxMiddleDtoParam.setAssembleImportDtoParamList(new ArrayList<>(assembleDtoParamListMap.values()));
               artifactBoxMiddleDtoParam.setMachinePartImportDtoParamList(machinePartDtoParamList);
               artifactBoxMiddleDtoParam.setStandardPartImportDTOParamList(standardPartDtoParamList);
               artifactBoxMiddleDtoParam.setBoolOnePartLine(Boolean.FALSE);
               List<MachinePartImportDtoParam> partImportDtoParams = machinePartDtoParamList.stream()
                  .filter(e -> e.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.PRIMARY_MEMBER.getType()))
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(partImportDtoParams) && partImportDtoParams.size() == 1) {
                  artifactBoxMiddleDtoParam.setBoolOnePartLine(Boolean.TRUE);
               }

               if (artifactBoxMiddleDtoParam.getBoolOnePartLine() && artifactBoxMiddleDtoParam.getStructureClassId() == null) {
                  mistakeExportDTOList.add(
                     new MistakeExportDTO(
                        artifactTemplateDtoParam.getOrderNo(), "构件的规格前缀[" + artifactSpecPrefix + artifactTemplateDtoParam.getName() + "] 名称未定义!"
                     )
                  );
               }

               if (CollectionUtils.isEmpty(artifactBoxMiddleDtoParam.getAssembleImportDtoParamList())
                  && artifactBoxMiddleDtoParam.getMachinePartImportDtoParamList().size() == 1) {
                  artifactBoxMiddleDtoParam.setBoolSinglePartEnum(Boolean.TRUE);
                  if (artifactBoxMiddleDtoParam.getStructureClassId() == null) {
                     mistakeExportDTOList.add(
                        new MistakeExportDTO(
                           artifactTemplateDtoParam.getOrderNo(), "构件的规格前缀[" + artifactSpecPrefix + "和名称" + artifactTemplateDtoParam.getName() + "] 未定义!"
                        )
                     );
                  }
               }

               this.correctArtifactWeightArea(artifactBoxMiddleDtoParam);
               artifactBoxMiddleDtoParam.setBoolCoatingEnum(artifactBoxMiddleDtoParam.getSurfaceArea().compareTo(BigDecimal.ZERO) > 0);
               artifactBoxImportMiddleDtoParamList.add(artifactBoxMiddleDtoParam);
            }
         }
      );
      this.extractedAssembleList(mistakeExportDTOList, artifactBoxImportMiddleDtoParamList);
      return artifactBoxImportMiddleDtoParamList;
   }

   private void extractedAssembleList(List<MistakeExportDTO> mistakeExportDTOList, List<ArtifactBoxImportDTO> artifactBoxImportMiddleDtoParamList) {
      List<InventoryAssembleImportDTO> assembleImportDTOList = artifactBoxImportMiddleDtoParamList.stream()
         .map(ArtifactBoxImportDTO::getAssembleImportDtoParamList)
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(assembleImportDTOList)) {
         Map<String, List<InventoryAssembleImportDTO>> assembleImportDTOListMap = assembleImportDTOList.stream()
            .filter(InventoryAssembleImportDTO::getBoolPossessPlateWeb)
            .collect(Collectors.groupingBy(e -> e.getSerialNumber() + e.getName()));
         if (CollectionUtils.isNotEmpty(assembleImportDTOListMap) && CollectionUtils.isEmpty(mistakeExportDTOList)) {
            assembleImportDTOListMap.forEach(
               (serialNumberAndName, dtoList) -> {
                  if (dtoList.size() > 1) {
                     List<MachinePartImportDtoParam> assembleElementMachinePartList = dtoList.get(0).getAssembleElementMachinePartList();
                     Map<String, MachinePartImportDtoParam> machinePartImportDtoParamMap = assembleElementMachinePartList.stream()
                        .collect(Collectors.toMap(ArtifactPartImportCommonDTO::getSerialNumber, Function.identity()));

                     for (InventoryAssembleImportDTO importDTO : dtoList.stream().skip(1L).collect(Collectors.toList())) {
                        if (importDTO.getAssembleElementMachinePartList().size() != assembleElementMachinePartList.size()) {
                           mistakeExportDTOList.add(
                              new MistakeExportDTO(null, "相同的名称和编号部件" + importDTO.getName() + "--" + importDTO.getSerialNumber() + "的翼腹板种类必须一致!")
                           );
                        }

                        if (importDTO.getAssembleElementMachinePartList()
                           .stream()
                           .anyMatch(p -> !machinePartImportDtoParamMap.containsKey(p.getSerialNumber()))) {
                           mistakeExportDTOList.add(
                              new MistakeExportDTO(null, "相同的名称和编号部件" + importDTO.getName() + "--" + importDTO.getSerialNumber() + "的翼腹板编号必须一致!")
                           );
                        } else if (importDTO.getAssembleElementMachinePartList()
                           .stream()
                           .anyMatch(p -> !machinePartImportDtoParamMap.get(p.getSerialNumber()).getQuantityRatio().equals(p.getQuantityRatio()))) {
                           mistakeExportDTOList.add(
                              new MistakeExportDTO(null, "相同的名称和编号部件" + importDTO.getName() + "--" + importDTO.getSerialNumber() + "的翼腹板比例必须一致!")
                           );
                        }
                     }
                  }
               }
            );
         }
      }
   }

   private void correctArtifactWeightArea(ArtifactBoxImportDTO artifactImportDTO) {
      List<MachinePartImportDtoParam> partImportDtoParams = artifactImportDTO.getMachinePartImportDtoParamList()
         .stream()
         .filter(e -> !e.getBoolSendDirectly())
         .collect(Collectors.toList());
      BigDecimal partTotalNetWeight = CollectionUtils.isEmpty(partImportDtoParams)
         ? BigDecimal.ZERO
         : partImportDtoParams.stream()
            .map(m -> m.getNetWeight().multiply(BigDecimal.valueOf(m.getQuantity().intValue())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal assembleTotalNetWeight = artifactImportDTO.getAssembleImportDtoParamList()
         .stream()
         .map(m -> m.getNetWeight().multiply(BigDecimal.valueOf(m.getQuantity().intValue())))
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal netWeight = partTotalNetWeight.add(assembleTotalNetWeight)
         .divide(BigDecimal.valueOf(artifactImportDTO.getQuantity().intValue()), 4, RoundingMode.HALF_UP);
      BigDecimal partTotalGrossWeight = CollectionUtils.isEmpty(partImportDtoParams)
         ? BigDecimal.ZERO
         : partImportDtoParams.stream()
            .map(m -> m.getGrossWeight() == null ? BigDecimal.ZERO : m.getGrossWeight().multiply(BigDecimal.valueOf(m.getQuantity().intValue())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal assembleTotalGrossWeight = artifactImportDTO.getAssembleImportDtoParamList()
         .stream()
         .map(m -> m.getGrossWeight() == null ? BigDecimal.ZERO : m.getGrossWeight().multiply(BigDecimal.valueOf(m.getQuantity().intValue())))
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal grossWeight = partTotalGrossWeight.add(assembleTotalGrossWeight)
         .divide(BigDecimal.valueOf(artifactImportDTO.getQuantity().intValue()), 4, RoundingMode.HALF_UP);
      BigDecimal partTotalSurfaceArea = CollectionUtils.isEmpty(partImportDtoParams)
         ? BigDecimal.ZERO
         : partImportDtoParams.stream()
            .map(m -> m.getSurfaceArea().multiply(BigDecimal.valueOf(m.getQuantity().intValue())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal assembleTotalSurfaceArea = artifactImportDTO.getAssembleImportDtoParamList()
         .stream()
         .map(m -> m.getSurfaceArea().multiply(BigDecimal.valueOf(m.getQuantity().intValue())))
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal surfaceArea = partTotalSurfaceArea.add(assembleTotalSurfaceArea)
         .divide(BigDecimal.valueOf(artifactImportDTO.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      BigDecimal partTotalFlangeArea = CollectionUtils.isEmpty(partImportDtoParams)
         ? BigDecimal.ZERO
         : partImportDtoParams.stream()
            .map(e -> e.getTopFlangeArea() == null ? BigDecimal.ZERO : e.getTopFlangeArea().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal assembleTotalFlangeArea = artifactImportDTO.getAssembleImportDtoParamList()
         .stream()
         .map(e -> e.getTopFlangeArea() == null ? BigDecimal.ZERO : e.getTopFlangeArea().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal topFlangeArea = partTotalFlangeArea.add(assembleTotalFlangeArea);
      artifactImportDTO.setNetWeight(netWeight);
      artifactImportDTO.setGrossWeight(grossWeight);
      artifactImportDTO.setSurfaceArea(surfaceArea);
      artifactImportDTO.setTopFlangeArea(topFlangeArea.divide(BigDecimal.valueOf(artifactImportDTO.getQuantity().intValue())));
      List<InventoryAssembleImportDTO> assembleImportDtoParamList = artifactImportDTO.getAssembleImportDtoParamList();
      BigDecimal partTotalInnerPaintArea = CollectionUtils.isEmpty(partImportDtoParams)
         ? BigDecimal.ZERO
         : partImportDtoParams.stream()
            .map(e -> e.getTotalInnerPaintArea() == null ? BigDecimal.ZERO : e.getTotalInnerPaintArea())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal assembleTotalInnerPaintArea = CollectionUtils.isEmpty(assembleImportDtoParamList)
         ? BigDecimal.ZERO
         : assembleImportDtoParamList.stream()
            .map(e -> e.getTotalInnerPaintArea() == null ? BigDecimal.ZERO : e.getTotalInnerPaintArea())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      partTotalInnerPaintArea = partTotalInnerPaintArea.add(assembleTotalInnerPaintArea);
      BigDecimal innerPaintArea = partTotalInnerPaintArea.divide(BigDecimal.valueOf(artifactImportDTO.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      artifactImportDTO.setInnerPaintArea(innerPaintArea);
      artifactImportDTO.setTotalInnerPaintArea(partTotalInnerPaintArea);
      BigDecimal partTotalOuterPaintArea = CollectionUtils.isEmpty(partImportDtoParams)
         ? BigDecimal.ZERO
         : partImportDtoParams.stream()
            .map(e -> e.getTotalOuterPaintArea() == null ? BigDecimal.ZERO : e.getTotalOuterPaintArea())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal assembleTotalOuterPaintArea = CollectionUtils.isEmpty(assembleImportDtoParamList)
         ? BigDecimal.ZERO
         : assembleImportDtoParamList.stream()
            .map(e -> e.getTotalOuterPaintArea() == null ? BigDecimal.ZERO : e.getTotalOuterPaintArea())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      partTotalOuterPaintArea = partTotalOuterPaintArea.add(assembleTotalOuterPaintArea);
      BigDecimal outerPaintArea = partTotalOuterPaintArea.divide(BigDecimal.valueOf(artifactImportDTO.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      artifactImportDTO.setOuterPaintArea(outerPaintArea);
      artifactImportDTO.setTotalOuterPaintArea(partTotalOuterPaintArea);
   }

   private List<List<ZnljArtifactMachinePartImportTemplateDtoParam>> convertFirst(List<ZnljArtifactMachinePartImportTemplateDtoParam> templateDtoParamList) {
      List<List<ZnljArtifactMachinePartImportTemplateDtoParam>> importListList = new ArrayList<>(512);
      List<ZnljArtifactMachinePartImportTemplateDtoParam> importList = null;

      for (ZnljArtifactMachinePartImportTemplateDtoParam templateDtoParam : templateDtoParamList) {
         if (StringUtils.isNotBlank(templateDtoParam.getArtifactNo())) {
            if (importList != null) {
               importListList.add(importList);
            }

            importList = new ArrayList<>(64);
            importList.add(templateDtoParam);
         } else if (importList != null) {
            importList.add(templateDtoParam);
         }
      }

      if (importList != null) {
         importListList.add(importList);
      }

      return importListList;
   }

   private void correctAssembleWeightArea(InventoryAssembleImportDTO assembleImportDto) {
      if (CollectionUtils.isNotEmpty(assembleImportDto.getAssembleElementMachinePartList())) {
         BigDecimal grossWeight = assembleImportDto.getAssembleElementMachinePartList()
            .stream()
            .map(m -> m.getGrossWeight().multiply(BigDecimal.valueOf(m.getQuantity().intValue())))
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(assembleImportDto.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
         BigDecimal surfaceArea = assembleImportDto.getAssembleElementMachinePartList()
            .stream()
            .map(m -> m.getSurfaceArea().multiply(BigDecimal.valueOf(m.getQuantity().intValue())))
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(assembleImportDto.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
         BigDecimal topFlangeArea = assembleImportDto.getAssembleElementMachinePartList()
            .stream()
            .map(e -> e.getTopFlangeArea().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         assembleImportDto.setNetWeight(
            assembleImportDto.getTotalNetWeight().divide(BigDecimal.valueOf(assembleImportDto.getQuantity().intValue()), 8, RoundingMode.HALF_UP)
         );
         assembleImportDto.setGrossWeight(grossWeight);
         assembleImportDto.setSurfaceArea(surfaceArea);
         assembleImportDto.setTopFlangeArea(topFlangeArea.divide(BigDecimal.valueOf(assembleImportDto.getQuantity().intValue())));
         if (assembleImportDto.getNetWeight() != null) {
            assembleImportDto.setTotalNetWeight(assembleImportDto.getNetWeight().multiply(BigDecimal.valueOf(assembleImportDto.getQuantity().intValue())));
         }

         if (assembleImportDto.getGrossWeight() != null) {
            assembleImportDto.setTotalGrossWeight(assembleImportDto.getGrossWeight().multiply(BigDecimal.valueOf(assembleImportDto.getQuantity().intValue())));
         }

         BigDecimal partTotalInnerPaintArea = CollectionUtils.isEmpty(assembleImportDto.getAssembleElementMachinePartList())
            ? BigDecimal.ZERO
            : assembleImportDto.getAssembleElementMachinePartList()
               .stream()
               .map(e -> e.getTotalInnerPaintArea() == null ? BigDecimal.ZERO : e.getTotalInnerPaintArea())
               .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal innerPaintArea = partTotalInnerPaintArea.divide(BigDecimal.valueOf(assembleImportDto.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
         assembleImportDto.setInnerPaintArea(innerPaintArea);
         assembleImportDto.setTotalInnerPaintArea(partTotalInnerPaintArea);
         BigDecimal partTotalOuterPaintArea = CollectionUtils.isEmpty(assembleImportDto.getAssembleElementMachinePartList())
            ? BigDecimal.ZERO
            : assembleImportDto.getAssembleElementMachinePartList()
               .stream()
               .map(e -> e.getTotalOuterPaintArea() == null ? BigDecimal.ZERO : e.getTotalOuterPaintArea())
               .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal outerPaintArea = partTotalOuterPaintArea.divide(BigDecimal.valueOf(assembleImportDto.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
         assembleImportDto.setOuterPaintArea(outerPaintArea);
         assembleImportDto.setTotalOuterPaintArea(partTotalOuterPaintArea);
      }
   }

   private void checkFieldBlankNull(
      List<ZnljArtifactMachinePartImportTemplateDtoParam> importDTOS,
      Map<String, Long> assembleSpecMap,
      Map<String, Long> machinePartSpecMap,
      Map<String, Long> sectionMachinePartSpecMap,
      Map<String, Map<String, Long>> steelClassSpecNameLinkMap,
      List<MistakeExportDTO> mistakeExportDTOList,
      TechConfigUtilsDTO utilsDTO,
      Map<Integer, InventoryConfigurationDetailDTO> configurationDetailDTOMap
   ) {
      InventoryConfigurationDetailDTO partConfigurationDetailDTO = configurationDetailDTOMap.get(ProductTypeEnum.MACHINE_PART.getType());
      Map<String, String> snStructureTypeMap = new LinkedHashMap<>(2048);
      Map<String, ZnljArtifactMachinePartImportTemplateDtoParam> machinePartImportDtoMap = new LinkedHashMap<>(4096);
      Map<Integer, Map<String, Long>> standardPartConfigMap = utilsDTO.getStandardPartConfigMap();
      Map<String, Long> standardPartNameAndIdMap = standardPartConfigMap.get(ProductSectionNameEnum.PRODUCT_NAME.getType());

      for (ZnljArtifactMachinePartImportTemplateDtoParam importDTO : importDTOS) {
         com.hzchum.pangu.common.util.StringUtils.removeTrimSpaces(importDTO, null);
         Boolean boolArtifact = StringUtils.isNotBlank(importDTO.getArtifactNo()) && StringUtils.isAllBlank(importDTO.getSerialNumber());
         importDTO.setDrawingWeight(importDTO.getDrawingWeight() != null ? importDTO.getDrawingWeight() : BigDecimal.ZERO);
         BigDecimal surfaceArea = importDTO.getSurfaceArea() != null
            ? importDTO.getSurfaceArea()
            : (importDTO.getSurfaceArea2() != null ? importDTO.getSurfaceArea2() : importDTO.getSurfaceArea3());
         BigDecimal topFlangeArea = importDTO.getTopFlangeArea() != null
            ? importDTO.getTopFlangeArea()
            : (importDTO.getTopFlangeArea2() != null ? importDTO.getTopFlangeArea2() : importDTO.getTopFlangeArea3());
         if (importDTO.getQuantity() != null && importDTO.getQuantity() > 0) {
            importDTO.setSurfaceArea(
               surfaceArea != null
                  ? surfaceArea.multiply(BigDecimal.valueOf(1000000L)).divide(BigDecimal.valueOf(importDTO.getQuantity().intValue()), 0, RoundingMode.HALF_UP)
                  : BigDecimal.ZERO
            );
            importDTO.setTopFlangeArea(
               topFlangeArea != null
                  ? topFlangeArea.multiply(BigDecimal.valueOf(1000000L))
                     .divide(BigDecimal.valueOf(importDTO.getQuantity().intValue()), 0, RoundingMode.HALF_UP)
                  : BigDecimal.ZERO
            );
         }

         Integer orderNo = importDTO.getOrderNo();
         Boolean boolStandardPart = standardPartNameAndIdMap.containsKey(importDTO.getName());
         Boolean boolPart = StringUtils.isNotBlank(importDTO.getSerialNumber()) && StringUtils.isAllBlank(importDTO.getArtifactNo()) && !boolStandardPart;
         List<Boolean> booleanList = Arrays.asList(boolArtifact, boolPart, boolStandardPart);
         if (booleanList.stream().filter(b -> b).count() != 1L) {
            mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "构件编号|零件编号,必须有且仅有一个存在!!!"));
         } else {
            if (StringUtils.isNotBlank(importDTO.getArtifactNo())) {
               this.checkArtifactField(importDTO, mistakeExportDTOList);
            }

            if (StringUtils.isNotBlank(importDTO.getSerialNumber())) {
               this.checkMachinePartAssembleField(
                  importDTO,
                  assembleSpecMap,
                  machinePartSpecMap,
                  sectionMachinePartSpecMap,
                  snStructureTypeMap,
                  steelClassSpecNameLinkMap,
                  mistakeExportDTOList
               );
               if (machinePartImportDtoMap.containsKey(importDTO.getSerialNumber())) {
                  ZnljArtifactMachinePartImportTemplateDtoParam dtoParam = machinePartImportDtoMap.get(importDTO.getSerialNumber());
                  if (StringUtils.isNotBlank(dtoParam.getSpecification())
                     && StringUtils.isNotBlank(importDTO.getSpecification())
                     && !dtoParam.getSpecification().equals(importDTO.getSpecification())
                     && !SteelPlateTypeEnum.PRIMARY_MEMBER.getType().equals(dtoParam.getSteelPlateTypeEnum())) {
                     mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "相同零件编号(" + importDTO.getSerialNumber() + ")的规格必须保持一致!"));
                  }

                  if (SteelPlateTypeEnum.PRIMARY_MEMBER.getType().equals(dtoParam.getSteelPlateTypeEnum())) {
                     String partThick = TechUtils.getMachinePartThick(dtoParam.getSpecification());
                     String width = dtoParam.getSpecification().split("\\*")[1];
                     String partDTOThick = TechUtils.getMachinePartThick(importDTO.getSpecification());
                     String partDTOWidth = importDTO.getSpecification().split("\\*")[1];
                     if (!this.isValidDecimal(partThick) || !this.isValidDecimal(partDTOThick)) {
                        mistakeExportDTOList.add(new MistakeExportDTO(importDTO.getOrderNo(), "相同零件编号规格不一致!"));
                     }

                     if (CollectionUtils.isEmpty(mistakeExportDTOList)) {
                        BigDecimal thickSubtract = new BigDecimal(partThick).subtract(new BigDecimal(partDTOThick));
                        if (partConfigurationDetailDTO.getThickness()
                              .compareTo(thickSubtract.compareTo(BigDecimal.ZERO) < 0 ? thickSubtract.negate() : thickSubtract)
                           < 0) {
                           mistakeExportDTOList.add(new MistakeExportDTO(importDTO.getOrderNo(), "相同零件编号厚度不一致(超出误差范围)!"));
                        }

                        BigDecimal widthSubtract = new BigDecimal(width).subtract(new BigDecimal(partDTOWidth));
                        if (partConfigurationDetailDTO.getWidth()
                              .compareTo(widthSubtract.compareTo(BigDecimal.ZERO) < 0 ? widthSubtract.negate() : widthSubtract)
                           < 0) {
                           mistakeExportDTOList.add(new MistakeExportDTO(importDTO.getOrderNo(), "相同零件编号宽度不一致(超出误差范围)!"));
                        }

                        importDTO.setSpecification(dtoParam.getSpecification());
                     }
                  }

                  if (StringUtils.isNotBlank(dtoParam.getMaterial())
                     && StringUtils.isNotBlank(importDTO.getMaterial())
                     && !dtoParam.getMaterial().equals(importDTO.getMaterial())) {
                     mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "相同零件编号(" + importDTO.getSerialNumber() + ")的材质必须保持一致!"));
                  }
               } else {
                  machinePartImportDtoMap.put(importDTO.getSerialNumber(), importDTO);
               }
            }
         }
      }
   }

   private boolean isValidDecimal(String input) {
      return input != null && !input.isEmpty() ? input.matches("-?\\d+(\\.\\d+)?") : false;
   }

   private void checkArtifactField(ZnljArtifactMachinePartImportTemplateDtoParam importDTO, List<MistakeExportDTO> mistakeExportDTOList) {
      Integer orderNo = importDTO.getOrderNo();
      if (StringUtils.isBlank(importDTO.getName())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "构件编号(" + importDTO.getArtifactNo() + ")的名称不能为空!"));
      }

      Boolean boolContainEnglishLetter = com.hzchum.pangu.common.util.StringUtils.boolContainEnglishLetter(importDTO.getArtifactNo());
      if (!boolContainEnglishLetter) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "构件编号(" + importDTO.getArtifactNo() + ")未包含英文字母!"));
      }

      if (StringUtils.isBlank(importDTO.getStructureType())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "构件编号(" + importDTO.getArtifactNo() + ")的结构类型不可为空!"));
      }

      if (StringUtils.isNotBlank(importDTO.getStructureType()) && "直发件类".contains(importDTO.getStructureType())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "构件编号(" + importDTO.getArtifactNo() + ")的结构类型不可填写[直发件类]!"));
      }

      if (StringUtils.isNotBlank(importDTO.getRecognitionCode())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "构件编号(" + importDTO.getArtifactNo() + ")不可填写识别码!"));
      }

      if (StringUtils.isBlank(importDTO.getSpecification())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "构件编号(" + importDTO.getArtifactNo() + ")的规格不能为空!"));
      } else if (Character.isDigit(importDTO.getSpecification().charAt(0))) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "构件编号(" + importDTO.getArtifactNo() + ")的规格前缀不能为数字!"));
      } else if (!TechUtils.checkSpecification(importDTO.getSpecification())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "构件编号(" + importDTO.getArtifactNo() + ")的规格中两组数字之间存在非法符号!"));
      } else {
         String specPrefix = TechUtils.getSpecPrefix(importDTO.getSpecification());
         importDTO.setSpecPrefix(specPrefix);
      }

      if (StringUtils.isBlank(importDTO.getMaterial())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "构件编号(" + importDTO.getArtifactNo() + ")的材质不能为空!"));
      }

      if (importDTO.getLength() == null || importDTO.getLength().compareTo(BigDecimal.ZERO) <= 0) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "构件编号(" + importDTO.getArtifactNo() + ")的长度不能为空且必须大于0!"));
      }

      if (importDTO.getQuantity() == null || importDTO.getQuantity() <= 0) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "构件编号(" + importDTO.getArtifactNo() + ")的数量不能为空且必须大于0!"));
      }

      if (importDTO.getDrawingWeight().compareTo(BigDecimal.ZERO) < 0) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "构件编号(" + importDTO.getArtifactNo() + ")的图纸单重不能为负数!"));
      }
   }

   private void checkMachinePartAssembleField(
      ZnljArtifactMachinePartImportTemplateDtoParam importDTO,
      Map<String, Long> assembleSpecMap,
      Map<String, Long> machinePartSpecMap,
      Map<String, Long> sectionMachinePartSpecMap,
      Map<String, String> snStructureTypeMap,
      Map<String, Map<String, Long>> steelClassSpecNameLinkMap,
      List<MistakeExportDTO> mistakeExportDTOList
   ) {
      List<String> specialMaterialList = Arrays.stream("Q235B-HW,Q355B-HW,不锈钢,钢板网,橡胶垫块,钢格栅".split(",")).collect(Collectors.toList());
      Integer orderNo = importDTO.getOrderNo();
      if (!this.SEND_DIRECTLY_MARK_LIST.contains(importDTO.getStructureType())) {
         if (snStructureTypeMap.containsKey(importDTO.getSerialNumber())) {
            String structureType = snStructureTypeMap.get(importDTO.getSerialNumber());
            if (!Objects.equals(structureType, importDTO.getStructureType())) {
               mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")出现多种的结构类型!"));
            }
         } else {
            snStructureTypeMap.put(importDTO.getSerialNumber(), importDTO.getStructureType());
         }
      }

      if (StringUtils.isBlank(importDTO.getSpecification())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")的规格不能为空!"));
      } else if (Character.isDigit(importDTO.getSpecification().charAt(0))) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")的规格前缀不能为数字!"));
      } else if (!TechUtils.checkSpecification(importDTO.getSpecification())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")的规格中两组数字之间必须是* . -这三种"));
      } else {
         String specPrefix = TechUtils.getSpecPrefix(importDTO.getSpecification());
         importDTO.setSpecPrefix(specPrefix);
      }

      if (StringUtils.isNotBlank(importDTO.getSpecPrefix())
         && !assembleSpecMap.containsKey(importDTO.getSpecPrefix())
         && !machinePartSpecMap.containsKey(importDTO.getSpecPrefix())
         && !sectionMachinePartSpecMap.containsKey(importDTO.getSpecPrefix())) {
         mistakeExportDTOList.add(
            TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")的规格前缀[" + importDTO.getSpecPrefix() + "]未定义!")
         );
      }

      if (StringUtils.isNotBlank(importDTO.getRecognitionCode())) {
         if (steelClassSpecNameLinkMap.containsKey(importDTO.getSpecPrefix())
            && steelClassSpecNameLinkMap.get(importDTO.getSpecPrefix()).containsKey(importDTO.getRecognitionCode())) {
            if (this.SEND_DIRECTLY_MARK_LIST.contains(importDTO.getStructureType())) {
               mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")判断为翼腹板,结构类型不可为[直发件类]!"));
            }

            if (importDTO.getThickness() == null || importDTO.getThickness().compareTo(BigDecimal.ZERO) <= 0) {
               mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")判断为翼腹板,厚度值有误!"));
            }

            if (importDTO.getWidth() == null || importDTO.getWidth().compareTo(BigDecimal.ZERO) <= 0) {
               mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")判断为翼腹板,宽度值有误!"));
            }

            if (specialMaterialList.contains(importDTO.getMaterial())
               && (importDTO.getGrossWeight() == null || importDTO.getGrossWeight().compareTo(BigDecimal.ZERO) <= 0)) {
               mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "翼腹板编号(" + importDTO.getSerialNumber() + ")单毛重有误!"));
            }
         } else {
            mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")判断为翼腹板,相应的识别码未在零件特征定义中设置!"));
         }
      }

      if (StringUtils.isBlank(importDTO.getRecognitionCode()) && StringUtils.isNotBlank(importDTO.getSpecPrefix())) {
         if (machinePartSpecMap.containsKey(importDTO.getSpecPrefix())) {
            if (importDTO.getThickness() == null || importDTO.getThickness().compareTo(BigDecimal.ZERO) <= 0) {
               mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")厚度值有误!"));
            }

            if (importDTO.getWidth() == null || importDTO.getWidth().compareTo(BigDecimal.ZERO) <= 0) {
               mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")宽度值有误!"));
            }

            if (importDTO.getNetWeight() == null || importDTO.getNetWeight().compareTo(BigDecimal.ZERO) <= 0) {
               mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")单净重有误!"));
            }

            if (specialMaterialList.contains(importDTO.getMaterial())
               && (importDTO.getGrossWeight() == null || importDTO.getGrossWeight().compareTo(BigDecimal.ZERO) <= 0)) {
               mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")单毛重有误!"));
            }

            importDTO.setSteelPlateTypeEnum(SteelPlateTypeEnum.PRIMARY_MEMBER.getType());
         }

         if (sectionMachinePartSpecMap.containsKey(importDTO.getSpecPrefix())) {
            if (importDTO.getNetWeight() == null || importDTO.getNetWeight().compareTo(BigDecimal.ZERO) <= 0) {
               mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")单净重有误!"));
            }

            if (importDTO.getGrossWeight() == null || importDTO.getGrossWeight().compareTo(BigDecimal.ZERO) <= 0) {
               mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")单毛重有误!"));
            }

            importDTO.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECTIONSTEEL.getType());
         }

         if (assembleSpecMap.containsKey(importDTO.getSpecPrefix())
            && (importDTO.getTotalNetWeight() == null || importDTO.getTotalNetWeight().compareTo(BigDecimal.ZERO) <= 0)) {
            mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")总净重有误!"));
         }
      }

      if (StringUtils.isBlank(importDTO.getMaterial())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")的材质不能为空!"));
      }

      if (importDTO.getLength() == null || importDTO.getLength().compareTo(BigDecimal.ZERO) <= 0) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")的长度必须存在且大于0!"));
      }

      if (importDTO.getQuantity() == null || importDTO.getQuantity() <= 0) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")的数量不能为空且大于0!"));
      }
   }

   private void buildStandardPartDTOList(
      List<MistakeExportDTO> mistakeExportDTOList,
      List<ZnljArtifactMachinePartImportTemplateDtoParam> importList,
      ZnljArtifactMachinePartImportTemplateDtoParam artifactTemplateDtoParam,
      Map<String, Long> standardPartNameAndIdMap,
      List<StandardPartImportDTOParam> standardPartDtoParamList
   ) {
      List<ZnljArtifactMachinePartImportTemplateDtoParam> importStandardPartList = importList.stream()
         .skip(1L)
         .filter(importTemplateDtoParam -> standardPartNameAndIdMap.containsKey(importTemplateDtoParam.getName()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(importStandardPartList)) {
         importStandardPartList.forEach(templateDtoParam -> {
            if (!AuxiliaryUsePropertyEnum.isNameExist(templateDtoParam.getRemark())) {
               mistakeExportDTOList.add(new MistakeExportDTO(templateDtoParam.getOrderNo(), templateDtoParam.getName() + "的备注必须填写[工厂]或[工地]!"));
            }

            if (templateDtoParam.getQuantity() % artifactTemplateDtoParam.getQuantity() > 0) {
               mistakeExportDTOList.add(new MistakeExportDTO(templateDtoParam.getOrderNo(), "辅材数量必须是构件数量的整数倍!"));
            }
         });
      }

      Map<String, List<ZnljArtifactMachinePartImportTemplateDtoParam>> importStandardPartMap = importStandardPartList.stream()
         .collect(Collectors.groupingBy(e -> e.getName() + e.getSpecification() + e.getRemark()));
      importStandardPartMap.forEach((name, standardList) -> {
         StandardPartImportDTOParam standardPartImportDTOParam = BeanUtil.copy(standardList.get(0), StandardPartImportDTOParam.class);
         standardPartImportDTOParam.setSerialNumber(standardList.get(0).getSerialNumber());
         standardPartImportDTOParam.setQuantity(standardList.stream().mapToInt(ZnljArtifactMachinePartImportTemplateDtoParam::getQuantity).sum());
         standardPartImportDTOParam.setUseProperty(AuxiliaryUsePropertyEnum.getTypeByName(standardPartImportDTOParam.getRemark()));
         standardPartImportDTOParam.setProductClassificationEnum(ProductClassificationEnum.AUXILIARY_MATERIAL.getType());
         standardPartDtoParamList.add(standardPartImportDTOParam);
      });
   }

   public TechUtilInventoryMesManagerImpl(
      final TechArtifactService artifactService,
      final TechAssembleService assembleService,
      final TechMachinePartService machinePartService,
      final TechArtifactMachinePartLinkService artifactMachinePartLinkService,
      final TechAssembleDetailService assembleDetailService,
      final TechAssembleMachinePartLinkService assembleMachinePartLinkService,
      final TechArtifactStandardPartLinkService artifactStandardPartLinkService,
      final TechStandardPartService standardPartService,
      final ConfigService configService,
      final SysStructureClassificationService structureClassificationService,
      final MesTechInventoryOperationService mesTechInventoryOperationService,
      final TechArtifactRecordService artifactRecordService,
      final TechAssembleRecordService assembleRecordService,
      final TechMachinePartRecordService machinePartRecordService,
      final TechAssembleDetailRecordService assembleDetailRecordService,
      final TechArtifactMachinePartLinkRecordService artifactMachinePartLinkRecordService,
      final TechArtifactStandardPartLinkRecordService artifactStandardPartLinkRecordService,
      final TechAssembleMachinePartLinkRecordService assembleMachinePartLinkRecordService,
      final TechStandardPartRecordService standardPartRecordService
   ) {
      this.artifactService = artifactService;
      this.assembleService = assembleService;
      this.machinePartService = machinePartService;
      this.artifactMachinePartLinkService = artifactMachinePartLinkService;
      this.assembleDetailService = assembleDetailService;
      this.assembleMachinePartLinkService = assembleMachinePartLinkService;
      this.artifactStandardPartLinkService = artifactStandardPartLinkService;
      this.standardPartService = standardPartService;
      this.configService = configService;
      this.structureClassificationService = structureClassificationService;
      this.mesTechInventoryOperationService = mesTechInventoryOperationService;
      this.artifactRecordService = artifactRecordService;
      this.assembleRecordService = assembleRecordService;
      this.machinePartRecordService = machinePartRecordService;
      this.assembleDetailRecordService = assembleDetailRecordService;
      this.artifactMachinePartLinkRecordService = artifactMachinePartLinkRecordService;
      this.artifactStandardPartLinkRecordService = artifactStandardPartLinkRecordService;
      this.assembleMachinePartLinkRecordService = assembleMachinePartLinkRecordService;
      this.standardPartRecordService = standardPartRecordService;
   }
}
