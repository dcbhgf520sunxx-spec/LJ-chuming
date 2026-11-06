package com.hzchum.scim.plan.core.manager;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductSectionNameEnum;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.plan.core.api.enums.AuxiliaryUsePropertyEnum;
import com.hzchum.scim.plan.core.api.enums.ImportTypeEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryReviewedEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryTypeEnum;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.enums.OperationTypeEnum;
import com.hzchum.scim.plan.core.api.manager.TechUtilInventoryBridgeManager;
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
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ZnljBridgeImportTemplateDtoParam;
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
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TechUtilInventoryBridgeManagerImpl implements TechUtilInventoryBridgeManager {
   private final TechArtifactService artifactService;
   private final TechAssembleService assembleService;
   private final TechMachinePartService machinePartService;
   private final TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   private final TechAssembleDetailService assembleDetailService;
   private final TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   private final TechStandardPartService standardPartService;
   private final TechArtifactStandardPartLinkService artifactStandardPartLinkService;
   private final MesTechInventoryOperationService mesTechInventoryOperationService;
   private final TechArtifactRecordService artifactRecordService;
   private final TechAssembleRecordService assembleRecordService;
   private final TechMachinePartRecordService machinePartRecordService;
   private final TechAssembleDetailRecordService assembleDetailRecordService;
   private final TechArtifactMachinePartLinkRecordService artifactMachinePartLinkRecordService;
   private final TechArtifactStandardPartLinkRecordService artifactStandardPartLinkRecordService;
   private final TechAssembleMachinePartLinkRecordService assembleMachinePartLinkRecordService;
   private final TechStandardPartRecordService standardPartRecordService;

   @Override
   public List<ArtifactBoxImportDTO> getBridgeConversionList(
      List<MistakeExportDTO> mistakeExportDTOList,
      List<ZnljBridgeImportTemplateDtoParam> importDTOS,
      TechConfigUtilsDTO utilsDTO,
      Long monomerId,
      Integer importType
   ) {
      this.checkFieldBlankNull(
         importDTOS, utilsDTO.getAssembleSpecMap(), utilsDTO.getMachinePartSpecMap(), utilsDTO.getSectionMachinePartSpecMap(), mistakeExportDTOList, utilsDTO
      );
      if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         return null;
      }

      List<List<ZnljBridgeImportTemplateDtoParam>> artifactImportLists = this.convertFirst(importDTOS);
      List<ArtifactBoxImportDTO> artifactBoxImportDTOS = this.convertSecondBox(artifactImportLists, utilsDTO, importType, mistakeExportDTOList);
      if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         return null;
      }

      this.checkInMonomer(artifactBoxImportDTOS, monomerId, mistakeExportDTOList, importType);
      this.checkInMonomerPendingApproval(artifactBoxImportDTOS, monomerId, InventoryTypeEnum.BRIDGE.getType(), mistakeExportDTOList);
      return CollectionUtils.isNotEmpty(mistakeExportDTOList) ? null : artifactBoxImportDTOS;
   }

   private void checkInMonomer(
      List<ArtifactBoxImportDTO> artifactBoxDtoParamList, Long monomerId, List<MistakeExportDTO> mistakeExportDTOList, Integer importType
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
      artifactBoxDtoParamList.forEach(
         artifactBoxDtoParam -> {
            artifactBoxDtoParam.setBoolComposeAssemble(false);
            TechArtifact monomerArtifact = monomerArtifactSnMap.get(artifactBoxDtoParam.getSerialNumber());
            List<TechArtifact> artifacts = artifactSnListMap.get(artifactBoxDtoParam.getSerialNumber());
            if (monomerArtifact != null && artifacts.size() == 1 && ImportTypeEnum.REUTILIZATION.getType().equals(importType)) {
               artifactBoxDtoParam.setBoolSameNumber(Boolean.TRUE);
            }

            if (monomerArtifact != null
               && (artifacts.size() == 1 && ImportTypeEnum.REUTILIZATION.getType().equals(importType) || ImportTypeEnum.ADD_IMPORT.getType().equals(importType))
               )
             {
               this.checkArtifactEqual(monomerArtifact, artifactBoxDtoParam, mistakeExportDTOList);
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
                           if (assembleMachinePartLinks.size() != assembleElementMachinePartList.size()) {
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
      List<ArtifactBoxImportDTO> artifactBoxDtoParamList, Long monomerId, Integer inventoryTypeEnum, List<MistakeExportDTO> mistakeExportDTOList
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
                  this.checkRecordArtifactEqual(monomerArtifact, artifactBoxDtoParam, mistakeExportDTOList);
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

                              this.checkRecordAssembleEqual(assemble, assembleImportDtoParam, mistakeExportDTOList);
                              if (CollectionUtils.isNotEmpty(assembleImportDtoParam.getAssembleElementMachinePartList())) {
                                 assembleImportDtoParam.getAssembleElementMachinePartList().forEach(machinePartDtoParam -> {
                                    TechMachinePartRecord machinePart = monomerMachinePartSnMap.get(machinePartDtoParam.getSerialNumber());
                                    if (machinePart != null) {
                                       this.checkRecordPartEqual(machinePart, machinePartDtoParam, mistakeExportDTOList);
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
                        this.checkRecordPartEqual(machinePart, machinePartDtoParam, mistakeExportDTOList);
                     }
                  });
               }
            }
         );
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

   private void checkRecordPartEqual(
      TechMachinePartRecord monomerMachinePart, MachinePartImportDtoParam machinePartImportDtoParam, List<MistakeExportDTO> mistakeExportDTOList
   ) {
      if (!monomerMachinePart.getSpecPrefix().equals(machinePartImportDtoParam.getSpecPrefix())) {
         mistakeExportDTOList.add(new MistakeExportDTO(machinePartImportDtoParam.getOrderNo(), "零件规格和同单体内相同编号零件{未审核}规格前缀不一致!"));
      }

      if (!monomerMachinePart.getMaterial().equals(machinePartImportDtoParam.getMaterial())) {
         mistakeExportDTOList.add(new MistakeExportDTO(machinePartImportDtoParam.getOrderNo(), "零件材质和同单体内相同编号零件{未审核}材质不一致!"));
      }
   }

   private void checkAssembleEqual(TechAssemble monomerAssemble, InventoryAssembleImportDTO assembleImportDtoParam, List<MistakeExportDTO> mistakeExportDTOList) {
      if (!monomerAssemble.getSpecification().equals(assembleImportDtoParam.getSpecification())) {
         mistakeExportDTOList.add(new MistakeExportDTO(assembleImportDtoParam.getOrderNo(), "单元件规格和同单体内相同编号单元件规格不一致!"));
      }

      if (!monomerAssemble.getMaterial().equals(assembleImportDtoParam.getMaterial())) {
         mistakeExportDTOList.add(new MistakeExportDTO(assembleImportDtoParam.getOrderNo(), "单元件材质和同单体内相同编号单元件材质不一致!"));
      }
   }

   private void checkRecordAssembleEqual(
      TechAssembleRecord monomerAssemble, InventoryAssembleImportDTO assembleImportDtoParam, List<MistakeExportDTO> mistakeExportDTOList
   ) {
      if (!monomerAssemble.getSpecification().equals(assembleImportDtoParam.getSpecification())) {
         mistakeExportDTOList.add(new MistakeExportDTO(assembleImportDtoParam.getOrderNo(), "部件规格和同单体内相同编号部件{未审核}规格不一致!"));
      }

      if (!monomerAssemble.getMaterial().equals(assembleImportDtoParam.getMaterial())) {
         mistakeExportDTOList.add(new MistakeExportDTO(assembleImportDtoParam.getOrderNo(), "部件材质和同单体内相同编号部件{未审核}材质不一致!"));
      }
   }

   private void checkArtifactEqual(TechArtifact artifact, ArtifactBoxImportDTO artifactBoxDtoParam, List<MistakeExportDTO> mistakeExportDTOList) {
      if (!artifact.getName().equals(artifactBoxDtoParam.getName())) {
         mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "箱体名称和同单体内相同编号箱体名称不一致!"));
      }

      if (!artifact.getSpecification().equals(artifactBoxDtoParam.getSpecification())) {
         mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "箱体规格和同单体内相同编号箱体规格不一致!"));
      }

      if (!artifact.getMaterial().equals(artifactBoxDtoParam.getMaterial())) {
         mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "箱体材质和同单体内相同编号箱体材质不一致!"));
      }
   }

   private void checkRecordArtifactEqual(TechArtifactRecord artifact, ArtifactBoxImportDTO artifactBoxDtoParam, List<MistakeExportDTO> mistakeExportDTOList) {
      if (!artifact.getName().equals(artifactBoxDtoParam.getName())) {
         mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "构件名称和同单体内导入相同编号构件{未审核}名称不一致!"));
      }

      if (!artifact.getSpecification().equals(artifactBoxDtoParam.getSpecification()) && !artifact.getBoolComposeAssemble()) {
         mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "构件规格和同单体内相同编号构件{未审核}规格不一致!"));
      }

      if (!artifact.getMaterial().equals(artifactBoxDtoParam.getMaterial())) {
         mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxDtoParam.getOrderNo(), "构件材质和同单体内相同编号构件{未审核}材质不一致!"));
      }
   }

   private List<ArtifactBoxImportDTO> convertSecondBox(
      List<List<ZnljBridgeImportTemplateDtoParam>> artifactImportLists,
      TechConfigUtilsDTO utilsDTO,
      Integer importTypeEnum,
      List<MistakeExportDTO> mistakeExportDTOList
   ) {
      Map<String, Long> commonStructureSpecMap = utilsDTO.getCommonStructureSpecMap();
      Map<String, Map<String, Long>> smallStructureSpecSnMap = utilsDTO.getSmallArtifactNameMap();
      List<ArtifactBoxImportDTO> artifactBoxImportMiddleDtoParamList = new ArrayList<>(512);
      Map<String, Long> elementSpecMap = utilsDTO.getAssembleSpecMap();
      Map<String, Long> machinePartSpecMap = utilsDTO.getMachinePartSpecMap();
      Map<String, Long> sectionMachinePartSpecMap = utilsDTO.getSectionMachinePartSpecMap();
      Map<Integer, Map<String, Long>> standardPartConfigMap = utilsDTO.getStandardPartConfigMap();
      Map<String, Long> standardPartNameAndIdMap = standardPartConfigMap.get(ProductSectionNameEnum.PRODUCT_NAME.getType());
      List<String> mesArtifactClassNameList = utilsDTO.getMesArtifactClassNameList();
      Set<String> artifactSnSet = new HashSet<>(36);
      artifactImportLists.forEach(
         importList -> {
            ZnljBridgeImportTemplateDtoParam artifactTemplateDtoParam = importList.get(0);
            ArtifactBoxImportDTO artifactBoxImportDtoParam = BeanUtil.copy(artifactTemplateDtoParam, ArtifactBoxImportDTO.class);
            if (!mesArtifactClassNameList.contains(artifactTemplateDtoParam.getStructureType())) {
               if (artifactBoxImportDtoParam.getStructureType() == null) {
                  mistakeExportDTOList.add(new MistakeExportDTO(artifactTemplateDtoParam.getOrderNo(), "构件类别不可为空"));
               } else {
                  mistakeExportDTOList.add(
                     new MistakeExportDTO(artifactTemplateDtoParam.getOrderNo(), "构件的类别[" + artifactBoxImportDtoParam.getStructureType() + "]不在构件类别配置!")
                  );
               }
            }

            artifactBoxImportDtoParam.setBuildingType(InventoryTypeEnum.BRIDGE.getType());
            artifactBoxImportDtoParam.setBoolOnePartLine(Boolean.FALSE);
            artifactBoxImportDtoParam.setSerialNumber(artifactTemplateDtoParam.getArtifactNo());
            String artifactSpecPrefix = TechUtils.getSpecPrefix(artifactBoxImportDtoParam.getSpecification());
            artifactBoxImportDtoParam.setSpecPrefix(artifactSpecPrefix);
            artifactBoxImportDtoParam.setBoolSchedulingEnum(Boolean.TRUE);
            artifactBoxImportDtoParam.setBoolAllPartSendDirectly(Boolean.FALSE);
            artifactBoxImportDtoParam.setBoolSinglePartEnum(Boolean.FALSE);
            artifactBoxImportDtoParam.setBoolCoatingEnum(Boolean.FALSE);
            if (artifactSnSet.contains(artifactBoxImportDtoParam.getSerialNumber())) {
               mistakeExportDTOList.add(
                  TechUtils.buildMistakeByOrderNoDTO(artifactBoxImportDtoParam.getOrderNo(), "构件编号" + artifactBoxImportDtoParam.getSerialNumber() + "重复!")
               );
            }

            artifactSnSet.add(artifactBoxImportDtoParam.getSerialNumber());
            if (smallStructureSpecSnMap.containsKey(artifactSpecPrefix)
               && smallStructureSpecSnMap.get(artifactSpecPrefix).containsKey(artifactBoxImportDtoParam.getName())) {
               Long structureClassId = smallStructureSpecSnMap.get(artifactSpecPrefix).get(artifactBoxImportDtoParam.getName());
               artifactBoxImportDtoParam.setStructureClassId(structureClassId);
               artifactBoxImportDtoParam.setArtifactType(ArtifactTypeEnum.SMALL.getType());
               artifactBoxImportDtoParam.setCodingType(CodingTypeEnum.BATCH.getType());
            } else if (commonStructureSpecMap.containsKey(artifactSpecPrefix)) {
               Long structureClassId = commonStructureSpecMap.get(artifactSpecPrefix);
               artifactBoxImportDtoParam.setStructureClassId(structureClassId);
               artifactBoxImportDtoParam.setArtifactType(ArtifactTypeEnum.COMMON.getType());
               artifactBoxImportDtoParam.setCodingType(CodingTypeEnum.SINGLE.getType());
            } else {
               mistakeExportDTOList.add(
                  new MistakeExportDTO(
                     artifactTemplateDtoParam.getOrderNo(), "桥梁构件的规格前缀[" + artifactSpecPrefix + "和名称" + artifactTemplateDtoParam.getName() + "] 未定义!"
                  )
               );
            }

            if (artifactTemplateDtoParam.getBoolCoatingEnum() == null) {
               artifactBoxImportDtoParam.setBoolCoatingEnum(Boolean.TRUE);
            } else {
               artifactBoxImportDtoParam.setBoolCoatingEnum(artifactTemplateDtoParam.getBoolCoatingEnum());
            }

            artifactBoxImportDtoParam.setSpecPrefix(TechUtils.getSpecPrefix(artifactBoxImportDtoParam.getSpecification()));
            List<InventoryAssembleImportDTO> elementAssembleDtoParamList = new ArrayList<>(32);
            List<MachinePartImportDtoParam> machinePartDtoParamList = new ArrayList<>(32);
            Map<String, MachinePartImportDtoParam> artifactMachinePartDtoParamListMap = new HashMap<>();
            List<StandardPartImportDTOParam> standardPartDtoParamList = new ArrayList<>(16);
            Set<String> elementSnList = new HashSet<>(64);
            Set<String> partSnList = new HashSet<>(64);
            this.buildStandardPartDTOList(
               mistakeExportDTOList,
               (List<ZnljBridgeImportTemplateDtoParam>)importList,
               artifactTemplateDtoParam,
               standardPartNameAndIdMap,
               standardPartDtoParamList
            );
            List<ZnljBridgeImportTemplateDtoParam> elementAndPartImportList = importList.stream()
               .skip(1L)
               .filter(importTemplateDtoParam -> !standardPartNameAndIdMap.containsKey(importTemplateDtoParam.getName()))
               .collect(Collectors.toList());
            InventoryAssembleImportDTO elementDtoParam = null;

            for (int i = 1; i <= elementAndPartImportList.size(); i++) {
               ZnljBridgeImportTemplateDtoParam templateDtoParam = importList.get(i);
               if (i == 1 && StringUtils.isBlank(templateDtoParam.getElementNo())) {
               }

               if (StringUtils.isNotBlank(templateDtoParam.getElementNo())) {
                  partSnList = new HashSet<>();
                  if (elementDtoParam != null) {
                     elementDtoParam.setAssembleElementMachinePartList(machinePartDtoParamList);
                     elementAssembleDtoParamList.add(elementDtoParam);
                  }

                  if (templateDtoParam.getQuantity() % artifactTemplateDtoParam.getQuantity() > 0) {
                     mistakeExportDTOList.add(new MistakeExportDTO(templateDtoParam.getOrderNo(), "单元件数量必须是箱体数量的整数倍!"));
                  }

                  String specPrefix = TechUtils.getSpecPrefix(templateDtoParam.getSpecification());
                  if (!elementSpecMap.containsKey(specPrefix)) {
                     mistakeExportDTOList.add(new MistakeExportDTO(templateDtoParam.getOrderNo(), "单元件规格前缀类型[" + specPrefix + "]未定义!"));
                  }

                  if (elementSnList.contains(templateDtoParam.getElementNo())) {
                     mistakeExportDTOList.add(new MistakeExportDTO(templateDtoParam.getOrderNo(), "单元件编号重复!"));
                  }

                  elementSnList.add(templateDtoParam.getElementNo());
                  elementDtoParam = BeanUtil.copy(templateDtoParam, InventoryAssembleImportDTO.class);
                  elementDtoParam.setSerialNumber(templateDtoParam.getElementNo());
                  elementDtoParam.setProductClassificationEnum(ProductClassificationEnum.ASSEMBLE.getType());
                  elementDtoParam.setSpecPrefix(specPrefix);
                  machinePartDtoParamList = new ArrayList<>(32);
               } else if (elementDtoParam != null) {
                  if (!"零件类".equals(templateDtoParam.getStructureType()) && templateDtoParam.getQuantity() % elementDtoParam.getQuantity() > 0) {
                     mistakeExportDTOList.add(new MistakeExportDTO(templateDtoParam.getOrderNo(), "零件数量必须是单元件数量的整数倍!"));
                  }

                  String specPrefix = TechUtils.getSpecPrefix(templateDtoParam.getSpecification());
                  if (StringUtils.isBlank(specPrefix)) {
                     specPrefix = templateDtoParam.getSpecPrefix();
                  }

                  if (!machinePartSpecMap.containsKey(specPrefix) && !sectionMachinePartSpecMap.containsKey(specPrefix)) {
                     mistakeExportDTOList.add(new MistakeExportDTO(templateDtoParam.getOrderNo(), "零件规格前缀类型[" + specPrefix + "]未定义!"));
                  }

                  if (partSnList.contains(templateDtoParam.getSerialNumber())) {
                     mistakeExportDTOList.add(new MistakeExportDTO(templateDtoParam.getOrderNo(), "零件编号重复!"));
                  }

                  partSnList.add(templateDtoParam.getSerialNumber());
                  MachinePartImportDtoParam machinePartDtoParam = BeanUtil.copy(templateDtoParam, MachinePartImportDtoParam.class);
                  machinePartDtoParam.setBoolSendDirectly(Boolean.FALSE);
                  machinePartDtoParam.setSpecPrefix(specPrefix);
                  machinePartDtoParam.setProductClassificationEnum(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType());
                  machinePartDtoParam.setRelationType(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType());
                  if (machinePartDtoParam.getTotalGrossWeight() == null) {
                     if (machinePartDtoParam.getGrossWeight() == null) {
                        mistakeExportDTOList.add(new MistakeExportDTO(templateDtoParam.getOrderNo(), "请检查零件规格是否正确!"));
                     } else {
                        machinePartDtoParam.setTotalGrossWeight(
                           machinePartDtoParam.getGrossWeight().multiply(BigDecimal.valueOf(machinePartDtoParam.getQuantity().intValue()))
                        );
                     }
                  }

                  this.setPartArea(machinePartDtoParam, templateDtoParam);
                  if (machinePartSpecMap.containsKey(specPrefix)) {
                     machinePartDtoParam.setSteelPlateTypeEnum(SteelPlateTypeEnum.PRIMARY_MEMBER.getType());
                     machinePartDtoParam.setSteelId(machinePartSpecMap.get(specPrefix));
                     machinePartDtoParam.setRelationType(MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType());
                  } else if (sectionMachinePartSpecMap.containsKey(specPrefix)) {
                     machinePartDtoParam.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECTIONSTEEL.getType());
                     machinePartDtoParam.setSteelId(sectionMachinePartSpecMap.get(specPrefix));
                     machinePartDtoParam.setProductClassificationEnum(ProductClassificationEnum.SECTION_PRODUCT.getType());
                     machinePartDtoParam.setRelationType(MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType());
                  }

                  if (!"零件类".equals(machinePartDtoParam.getStructureType())) {
                     machinePartDtoParam.setQuantityRatio(machinePartDtoParam.getQuantity() / elementDtoParam.getQuantity());
                     machinePartDtoParamList.add(machinePartDtoParam);
                  }

                  if ("零件类".equals(machinePartDtoParam.getStructureType())) {
                     machinePartDtoParam.setRelationType(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType());
                     machinePartDtoParam.setBoolSendDirectly(Boolean.TRUE);
                     MachinePartImportDtoParam partImportDtoParam = artifactMachinePartDtoParamListMap.get(machinePartDtoParam.getSerialNumber());
                     if (partImportDtoParam == null) {
                        artifactMachinePartDtoParamListMap.put(machinePartDtoParam.getSerialNumber(), machinePartDtoParam);
                     } else {
                        partImportDtoParam.setQuantity(partImportDtoParam.getQuantity() + machinePartDtoParam.getQuantity());
                     }
                  }
               } else {
                  String specPrefix = TechUtils.getSpecPrefix(templateDtoParam.getSpecification());
                  if (StringUtils.isBlank(specPrefix)) {
                     specPrefix = templateDtoParam.getSpecPrefix();
                  }

                  if (!machinePartSpecMap.containsKey(specPrefix) && !sectionMachinePartSpecMap.containsKey(specPrefix)) {
                     mistakeExportDTOList.add(new MistakeExportDTO(templateDtoParam.getOrderNo(), "零件规格前缀类型[" + specPrefix + "]未定义!"));
                  }

                  if (partSnList.contains(templateDtoParam.getSerialNumber())) {
                     mistakeExportDTOList.add(new MistakeExportDTO(templateDtoParam.getOrderNo(), "零件编号重复!"));
                  }

                  partSnList.add(templateDtoParam.getSerialNumber());
                  MachinePartImportDtoParam machinePartDtoParam = BeanUtil.copy(templateDtoParam, MachinePartImportDtoParam.class);
                  machinePartDtoParam.setSpecPrefix(specPrefix);
                  machinePartDtoParam.setBoolSendDirectly(Boolean.FALSE);
                  machinePartDtoParam.setProductClassificationEnum(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType());
                  machinePartDtoParam.setRelationType(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType());
                  if (machinePartDtoParam.getTotalGrossWeight() == null) {
                     if (machinePartDtoParam.getGrossWeight() == null) {
                        mistakeExportDTOList.add(new MistakeExportDTO(templateDtoParam.getOrderNo(), "请检查零件规格是否正确!"));
                     } else {
                        machinePartDtoParam.setTotalGrossWeight(
                           machinePartDtoParam.getGrossWeight().multiply(BigDecimal.valueOf(machinePartDtoParam.getQuantity().intValue()))
                        );
                     }
                  }

                  this.setPartArea(machinePartDtoParam, templateDtoParam);
                  if (machinePartSpecMap.containsKey(specPrefix)) {
                     machinePartDtoParam.setSteelPlateTypeEnum(SteelPlateTypeEnum.PRIMARY_MEMBER.getType());
                     machinePartDtoParam.setSteelId(machinePartSpecMap.get(specPrefix));
                     machinePartDtoParam.setRelationType(MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType());
                  } else if (sectionMachinePartSpecMap.containsKey(specPrefix)) {
                     machinePartDtoParam.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECTIONSTEEL.getType());
                     machinePartDtoParam.setSteelId(sectionMachinePartSpecMap.get(specPrefix));
                     machinePartDtoParam.setProductClassificationEnum(ProductClassificationEnum.SECTION_PRODUCT.getType());
                     machinePartDtoParam.setRelationType(MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType());
                  }

                  machinePartDtoParam.setRelationType(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType());
                  MachinePartImportDtoParam partImportDtoParam = artifactMachinePartDtoParamListMap.get(machinePartDtoParam.getSerialNumber());
                  if (partImportDtoParam == null) {
                     artifactMachinePartDtoParamListMap.put(machinePartDtoParam.getSerialNumber(), machinePartDtoParam);
                  } else {
                     partImportDtoParam.setQuantity(partImportDtoParam.getQuantity() + machinePartDtoParam.getQuantity());
                  }
               }
            }

            if (elementDtoParam != null) {
               elementDtoParam.setAssembleElementMachinePartList(machinePartDtoParamList);
               elementAssembleDtoParamList.add(elementDtoParam);
            }

            if (CollectionUtils.isNotEmpty(elementAssembleDtoParamList)) {
               for (InventoryAssembleImportDTO assembleImportDto : elementAssembleDtoParamList) {
                  assembleImportDto.setBoolPossessPlateWeb(Boolean.TRUE);
                  this.setAssembleWeightArea(assembleImportDto);
               }
            }

            artifactBoxImportDtoParam.setAssembleImportDtoParamList(elementAssembleDtoParamList);
            if (CollectionUtils.isNotEmpty(artifactMachinePartDtoParamListMap)) {
               List<MachinePartImportDtoParam> artifactPartImportDtoParams = new ArrayList<>(artifactMachinePartDtoParamListMap.values());
               if (CollectionUtils.isNotEmpty(artifactPartImportDtoParams)) {
                  for (MachinePartImportDtoParam artifactPartImportDtoParam : artifactPartImportDtoParams) {
                     if (artifactPartImportDtoParam.getQuantity() % artifactBoxImportDtoParam.getQuantity() > 0) {
                        mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxImportDtoParam.getOrderNo(), "零件类零件的数量必须是构件数量的整数倍!"));
                     }
                  }
               }

               artifactBoxImportDtoParam.setMachinePartImportDtoParamList(artifactPartImportDtoParams);
            }

            artifactBoxImportDtoParam.setStandardPartImportDTOParamList(standardPartDtoParamList);
            this.setWeightArea(artifactBoxImportDtoParam);
            artifactBoxImportMiddleDtoParamList.add(artifactBoxImportDtoParam);
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
            .filter(e -> CollectionUtils.isNotEmpty(e.getAssembleElementMachinePartList()))
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
                              new MistakeExportDTO(null, "相同的名称和编号的单元件" + importDTO.getName() + "--" + importDTO.getSerialNumber() + "的零件种类必须一致!")
                           );
                        }

                        if (importDTO.getAssembleElementMachinePartList()
                           .stream()
                           .anyMatch(p -> !machinePartImportDtoParamMap.containsKey(p.getSerialNumber()))) {
                           mistakeExportDTOList.add(
                              new MistakeExportDTO(null, "相同的名称和编号的单元件" + importDTO.getName() + "--" + importDTO.getSerialNumber() + "的零件编号必须一致!")
                           );
                        } else if (importDTO.getAssembleElementMachinePartList()
                           .stream()
                           .anyMatch(p -> !machinePartImportDtoParamMap.get(p.getSerialNumber()).getQuantityRatio().equals(p.getQuantityRatio()))) {
                           mistakeExportDTOList.add(
                              new MistakeExportDTO(null, "相同的名称和编号的单元件" + importDTO.getName() + "--" + importDTO.getSerialNumber() + "的的零件比例必须一致!")
                           );
                        }
                     }
                  }
               }
            );
         }
      }
   }

   private void setPartArea(MachinePartImportDtoParam machinePartImportDtoParam, ZnljBridgeImportTemplateDtoParam templateParam) {
      BigDecimal totalTopPaintArea = templateParam.getTotalTopPaintArea() != null && templateParam.getTotalTopPaintArea().compareTo(BigDecimal.ZERO) > 0
         ? templateParam.getTotalTopPaintArea().multiply(BigDecimal.valueOf(1000000L))
         : BigDecimal.ZERO;
      BigDecimal topPaintArea = totalTopPaintArea.divide(BigDecimal.valueOf(templateParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      machinePartImportDtoParam.setTopPaintArea(topPaintArea);
      machinePartImportDtoParam.setTotalTopPaintArea(totalTopPaintArea);
      BigDecimal totalInnerPaintArea = templateParam.getTotalInnerPaintArea() != null && templateParam.getTotalInnerPaintArea().compareTo(BigDecimal.ZERO) > 0
         ? templateParam.getTotalInnerPaintArea().multiply(BigDecimal.valueOf(1000000L))
         : BigDecimal.ZERO;
      BigDecimal innerPaintArea = totalInnerPaintArea.divide(BigDecimal.valueOf(templateParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      machinePartImportDtoParam.setInnerPaintArea(innerPaintArea);
      machinePartImportDtoParam.setTotalInnerPaintArea(totalInnerPaintArea);
      BigDecimal totalOuterPaintArea = templateParam.getTotalOuterPaintArea() != null && templateParam.getTotalOuterPaintArea().compareTo(BigDecimal.ZERO) > 0
         ? templateParam.getTotalOuterPaintArea().multiply(BigDecimal.valueOf(1000000L))
         : BigDecimal.ZERO;
      BigDecimal outerPaintArea = totalOuterPaintArea.divide(BigDecimal.valueOf(templateParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      machinePartImportDtoParam.setOuterPaintArea(outerPaintArea);
      machinePartImportDtoParam.setTotalOuterPaintArea(totalOuterPaintArea);
      BigDecimal totalURibPaintArea = templateParam.getTotalURibPaintArea() != null && templateParam.getTotalURibPaintArea().compareTo(BigDecimal.ZERO) > 0
         ? templateParam.getTotalURibPaintArea().multiply(BigDecimal.valueOf(1000000L))
         : BigDecimal.ZERO;
      BigDecimal uRibPaintArea = totalURibPaintArea.divide(BigDecimal.valueOf(templateParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      machinePartImportDtoParam.setURibPaintArea(uRibPaintArea);
      machinePartImportDtoParam.setTotalURibPaintArea(totalURibPaintArea);
   }

   private void setWeightArea(ArtifactBoxImportDTO artifactImportDtoParam) {
      List<InventoryAssembleImportDTO> assembleImportDtoParamList = artifactImportDtoParam.getAssembleImportDtoParamList();
      List<MachinePartImportDtoParam> machinePartImportDtoParamList = CollectionUtils.isEmpty(artifactImportDtoParam.getMachinePartImportDtoParamList())
         ? new ArrayList<>()
         : artifactImportDtoParam.getMachinePartImportDtoParamList().stream().filter(e -> !e.getBoolSendDirectly()).collect(Collectors.toList());
      BigDecimal totalNetWeight = assembleImportDtoParamList.stream()
         .map(ArtifactPartImportCommonDTO::getTotalNetWeight)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal netWeight = totalNetWeight.divide(BigDecimal.valueOf(artifactImportDtoParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      BigDecimal partTotalNetWeight = CollectionUtils.isEmpty(machinePartImportDtoParamList)
         ? BigDecimal.ZERO
         : machinePartImportDtoParamList.stream().map(ArtifactPartImportCommonDTO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal partNetWeight = partTotalNetWeight.compareTo(BigDecimal.ZERO) == 0
         ? BigDecimal.ZERO
         : partTotalNetWeight.divide(BigDecimal.valueOf(artifactImportDtoParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      artifactImportDtoParam.setNetWeight(netWeight.add(partNetWeight));
      artifactImportDtoParam.setTotalNetWeight(totalNetWeight.add(partTotalNetWeight));
      BigDecimal totalGrossWeight = assembleImportDtoParamList.stream()
         .map(ArtifactPartImportCommonDTO::getTotalGrossWeight)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal grossWeight = totalGrossWeight.divide(BigDecimal.valueOf(artifactImportDtoParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      BigDecimal partTotalGrossWeight = CollectionUtils.isEmpty(machinePartImportDtoParamList)
         ? BigDecimal.ZERO
         : machinePartImportDtoParamList.stream().map(ArtifactPartImportCommonDTO::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal partGrossWeight = partTotalGrossWeight.compareTo(BigDecimal.ZERO) == 0
         ? BigDecimal.ZERO
         : partTotalGrossWeight.divide(BigDecimal.valueOf(artifactImportDtoParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      artifactImportDtoParam.setGrossWeight(grossWeight.add(partGrossWeight));
      artifactImportDtoParam.setTotalGrossWeight(totalGrossWeight.add(partTotalGrossWeight));
      BigDecimal totalTopPaintArea = assembleImportDtoParamList.stream()
         .map(ArtifactPartImportCommonDTO::getTotalTopPaintArea)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal partTotalTopPaintArea = CollectionUtils.isEmpty(machinePartImportDtoParamList)
         ? BigDecimal.ZERO
         : machinePartImportDtoParamList.stream().map(ArtifactPartImportCommonDTO::getTotalTopPaintArea).reduce(BigDecimal.ZERO, BigDecimal::add);
      totalTopPaintArea = totalTopPaintArea.add(partTotalTopPaintArea);
      BigDecimal topPaintArea = totalTopPaintArea.divide(BigDecimal.valueOf(artifactImportDtoParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      artifactImportDtoParam.setTopPaintArea(topPaintArea);
      artifactImportDtoParam.setTotalTopPaintArea(totalTopPaintArea);
      BigDecimal totalInnerPaintArea = assembleImportDtoParamList.stream()
         .map(ArtifactPartImportCommonDTO::getTotalInnerPaintArea)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal partTotalInnerPaintArea = CollectionUtils.isEmpty(machinePartImportDtoParamList)
         ? BigDecimal.ZERO
         : machinePartImportDtoParamList.stream().map(ArtifactPartImportCommonDTO::getTotalInnerPaintArea).reduce(BigDecimal.ZERO, BigDecimal::add);
      totalInnerPaintArea = totalInnerPaintArea.add(partTotalInnerPaintArea);
      BigDecimal innerPaintArea = totalInnerPaintArea.divide(BigDecimal.valueOf(artifactImportDtoParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      artifactImportDtoParam.setInnerPaintArea(innerPaintArea);
      artifactImportDtoParam.setTotalInnerPaintArea(totalInnerPaintArea);
      BigDecimal totalOuterPaintArea = assembleImportDtoParamList.stream()
         .map(ArtifactPartImportCommonDTO::getTotalOuterPaintArea)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal partTotalOuterPaintArea = CollectionUtils.isEmpty(machinePartImportDtoParamList)
         ? BigDecimal.ZERO
         : machinePartImportDtoParamList.stream().map(ArtifactPartImportCommonDTO::getTotalOuterPaintArea).reduce(BigDecimal.ZERO, BigDecimal::add);
      totalOuterPaintArea = totalOuterPaintArea.add(partTotalOuterPaintArea);
      BigDecimal outerPaintArea = totalOuterPaintArea.divide(BigDecimal.valueOf(artifactImportDtoParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      artifactImportDtoParam.setOuterPaintArea(outerPaintArea);
      artifactImportDtoParam.setTotalOuterPaintArea(totalOuterPaintArea);
      BigDecimal totalURibPaintArea = assembleImportDtoParamList.stream()
         .map(ArtifactPartImportCommonDTO::getTotalURibPaintArea)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal partTotalURibPaintArea = CollectionUtils.isEmpty(machinePartImportDtoParamList)
         ? BigDecimal.ZERO
         : machinePartImportDtoParamList.stream().map(ArtifactPartImportCommonDTO::getTotalURibPaintArea).reduce(BigDecimal.ZERO, BigDecimal::add);
      totalURibPaintArea = totalURibPaintArea.add(partTotalURibPaintArea);
      BigDecimal uRibPaintArea = totalURibPaintArea.divide(BigDecimal.valueOf(artifactImportDtoParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      artifactImportDtoParam.setURibPaintArea(uRibPaintArea);
      artifactImportDtoParam.setTotalURibPaintArea(totalURibPaintArea);
   }

   private void setAssembleWeightArea(InventoryAssembleImportDTO elementImportDtoParam) {
      List<MachinePartImportDtoParam> assembleElementMachinePartList = elementImportDtoParam.getAssembleElementMachinePartList();
      BigDecimal totalNetWeight = assembleElementMachinePartList.stream()
         .filter(s -> !"零件类".equals(StringUtils.deleteWhitespace(s.getStructureType())))
         .map(ArtifactPartImportCommonDTO::getTotalNetWeight)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal netWeight = totalNetWeight.divide(BigDecimal.valueOf(elementImportDtoParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      elementImportDtoParam.setNetWeight(netWeight);
      elementImportDtoParam.setTotalNetWeight(totalNetWeight);
      BigDecimal totalGrossWeight = assembleElementMachinePartList.stream()
         .filter(s -> !"零件类".equals(StringUtils.deleteWhitespace(s.getStructureType())))
         .map(ArtifactPartImportCommonDTO::getTotalGrossWeight)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal grossWeight = totalGrossWeight.divide(BigDecimal.valueOf(elementImportDtoParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      elementImportDtoParam.setGrossWeight(grossWeight);
      elementImportDtoParam.setTotalGrossWeight(totalGrossWeight);
      BigDecimal totalTopPaintArea = assembleElementMachinePartList.stream()
         .map(ArtifactPartImportCommonDTO::getTotalTopPaintArea)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal topPaintArea = totalTopPaintArea.divide(BigDecimal.valueOf(elementImportDtoParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      elementImportDtoParam.setTopPaintArea(topPaintArea);
      elementImportDtoParam.setTotalTopPaintArea(totalTopPaintArea);
      BigDecimal totalInnerPaintArea = assembleElementMachinePartList.stream()
         .map(ArtifactPartImportCommonDTO::getTotalInnerPaintArea)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal innerPaintArea = totalInnerPaintArea.divide(BigDecimal.valueOf(elementImportDtoParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      elementImportDtoParam.setInnerPaintArea(innerPaintArea);
      elementImportDtoParam.setTotalInnerPaintArea(totalInnerPaintArea);
      BigDecimal totalOuterPaintArea = assembleElementMachinePartList.stream()
         .map(ArtifactPartImportCommonDTO::getTotalOuterPaintArea)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal outerPaintArea = totalOuterPaintArea.divide(BigDecimal.valueOf(elementImportDtoParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      elementImportDtoParam.setOuterPaintArea(outerPaintArea);
      elementImportDtoParam.setTotalOuterPaintArea(totalOuterPaintArea);
      BigDecimal totalURibPaintArea = assembleElementMachinePartList.stream()
         .map(ArtifactPartImportCommonDTO::getTotalURibPaintArea)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal uRibPaintArea = totalURibPaintArea.divide(BigDecimal.valueOf(elementImportDtoParam.getQuantity().intValue()), 8, RoundingMode.HALF_UP);
      elementImportDtoParam.setURibPaintArea(uRibPaintArea);
      elementImportDtoParam.setTotalURibPaintArea(totalURibPaintArea);
   }

   private void buildStandardPartDTOList(
      List<MistakeExportDTO> mistakeExportDTOList,
      List<ZnljBridgeImportTemplateDtoParam> importList,
      ZnljBridgeImportTemplateDtoParam artifactTemplateDtoParam,
      Map<String, Long> standardPartNameAndIdMap,
      List<StandardPartImportDTOParam> standardPartDtoParamList
   ) {
      List<ZnljBridgeImportTemplateDtoParam> importStandardPartList = importList.stream()
         .skip(1L)
         .filter(importTemplateDtoParam -> standardPartNameAndIdMap.containsKey(importTemplateDtoParam.getName()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(importStandardPartList)) {
         importStandardPartList.forEach(templateDtoParam -> {
            if (!AuxiliaryUsePropertyEnum.isNameExist(templateDtoParam.getRemark())) {
               mistakeExportDTOList.add(new MistakeExportDTO(templateDtoParam.getOrderNo(), templateDtoParam.getName() + "的备注必须填写[工厂]或[工地]!"));
            }

            if (templateDtoParam.getQuantity() % artifactTemplateDtoParam.getQuantity() > 0) {
               mistakeExportDTOList.add(new MistakeExportDTO(templateDtoParam.getOrderNo(), "辅材数量必须是箱体数量的整数倍!"));
            }
         });
      }

      Map<String, List<ZnljBridgeImportTemplateDtoParam>> importStandardPartMap = importStandardPartList.stream()
         .collect(Collectors.groupingBy(e -> e.getName() + e.getSpecification() + e.getRemark()));
      importStandardPartMap.forEach((name, standardList) -> {
         StandardPartImportDTOParam standardPartImportDTOParam = BeanUtil.copy(standardList.get(0), StandardPartImportDTOParam.class);
         standardPartImportDTOParam.setSerialNumber(standardList.get(0).getSerialNumber());
         standardPartImportDTOParam.setQuantity(standardList.stream().mapToInt(ZnljBridgeImportTemplateDtoParam::getQuantity).sum());
         standardPartImportDTOParam.setUseProperty(AuxiliaryUsePropertyEnum.getTypeByName(standardPartImportDTOParam.getRemark()));
         standardPartImportDTOParam.setProductClassificationEnum(ProductClassificationEnum.AUXILIARY_MATERIAL.getType());
         standardPartDtoParamList.add(standardPartImportDTOParam);
      });
   }

   private List<List<ZnljBridgeImportTemplateDtoParam>> convertFirst(List<ZnljBridgeImportTemplateDtoParam> templateDtoParamList) {
      List<List<ZnljBridgeImportTemplateDtoParam>> importListList = new ArrayList<>(512);
      List<ZnljBridgeImportTemplateDtoParam> importList = null;

      for (ZnljBridgeImportTemplateDtoParam templateDtoParam : templateDtoParamList) {
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

   private void checkFieldBlankNull(
      List<ZnljBridgeImportTemplateDtoParam> importDTOS,
      Map<String, Long> assembleSpecMap,
      Map<String, Long> machinePartSpecMap,
      Map<String, Long> sectionMachinePartSpecMap,
      List<MistakeExportDTO> mistakeExportDTOList,
      TechConfigUtilsDTO utilsDTO
   ) {
      Map<String, ZnljBridgeImportTemplateDtoParam> machinePartImportDtoMap = new LinkedHashMap<>(4096);
      Map<String, ZnljBridgeImportTemplateDtoParam> eleMenttImportDtoMap = new LinkedHashMap<>(4096);
      Map<Integer, Map<String, Long>> standardPartConfigMap = utilsDTO.getStandardPartConfigMap();
      Map<String, Long> standardPartNameAndIdMap = standardPartConfigMap.get(ProductSectionNameEnum.PRODUCT_NAME.getType());

      for (ZnljBridgeImportTemplateDtoParam importDTO : importDTOS) {
         com.hzchum.pangu.common.util.StringUtils.removeTrimSpaces(importDTO, null);
         Integer orderNo = importDTO.getOrderNo();
         Boolean boolStandardPart = standardPartNameAndIdMap.containsKey(importDTO.getName());
         Boolean boolArtifact = StringUtils.isNotBlank(importDTO.getArtifactNo())
            && StringUtils.isAllBlank(importDTO.getSerialNumber(), importDTO.getElementNo());
         Boolean boolElement = StringUtils.isNotBlank(importDTO.getElementNo())
            && StringUtils.isAllBlank(importDTO.getArtifactNo(), importDTO.getSerialNumber());
         Boolean boolPart = StringUtils.isNotBlank(importDTO.getSerialNumber())
            && StringUtils.isAllBlank(importDTO.getArtifactNo(), importDTO.getElementNo())
            && !boolStandardPart;
         List<Boolean> booleanList = Arrays.asList(boolArtifact, boolElement, boolPart, boolStandardPart);
         if (booleanList.stream().filter(b -> b).count() != 1L) {
            mistakeExportDTOList.add(new MistakeExportDTO(orderNo, "箱体编号|单元编号|零件编号,必须有且仅有一个存在!"));
         } else {
            if (StringUtils.isNotBlank(importDTO.getArtifactNo())) {
               this.checkArtifactField(importDTO, mistakeExportDTOList);
            }

            if (StringUtils.isNotBlank(importDTO.getSerialNumber())) {
               this.checkMachinePartAssembleField(importDTO, machinePartSpecMap, sectionMachinePartSpecMap, mistakeExportDTOList);
               if (machinePartImportDtoMap.containsKey(importDTO.getSerialNumber())) {
                  ZnljBridgeImportTemplateDtoParam dtoParam = machinePartImportDtoMap.get(importDTO.getSerialNumber());
                  if (StringUtils.isNotBlank(dtoParam.getSpecification())
                     && StringUtils.isNotBlank(importDTO.getSpecification())
                     && !dtoParam.getSpecification().equals(importDTO.getSpecification())) {
                     mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "相同零件编号(" + importDTO.getSerialNumber() + ")的规格必须保持一致!"));
                  }

                  if (StringUtils.isNotBlank(dtoParam.getMaterial())
                     && StringUtils.isNotBlank(importDTO.getMaterial())
                     && !dtoParam.getMaterial().equals(importDTO.getMaterial())) {
                     mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "相同零件编号(" + importDTO.getSerialNumber() + ")的材质必须保持一致!"));
                  }

                  if (StringUtils.isNotBlank(dtoParam.getName())
                     && StringUtils.isNotBlank(importDTO.getName())
                     && !dtoParam.getName().equals(importDTO.getName())) {
                     mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "相同零件编号(" + importDTO.getSerialNumber() + ")的名称必须保持一致!"));
                  }
               } else {
                  machinePartImportDtoMap.put(importDTO.getSerialNumber(), importDTO);
               }
            }

            if (StringUtils.isNotBlank(importDTO.getElementNo())) {
               this.checkElementAssembleField(importDTO, assembleSpecMap, mistakeExportDTOList);
               if (eleMenttImportDtoMap.containsKey(importDTO.getElementNo())) {
                  ZnljBridgeImportTemplateDtoParam dtoParam = eleMenttImportDtoMap.get(importDTO.getElementNo());
                  if (StringUtils.isNotBlank(dtoParam.getSpecification())
                     && StringUtils.isNotBlank(importDTO.getSpecification())
                     && !dtoParam.getSpecification().equals(importDTO.getSpecification())) {
                     mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "相同单元件编号(" + importDTO.getElementNo() + ")的规格必须保持一致!"));
                  }

                  if (StringUtils.isNotBlank(dtoParam.getMaterial())
                     && StringUtils.isNotBlank(importDTO.getMaterial())
                     && !dtoParam.getMaterial().equals(importDTO.getMaterial())) {
                     mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "相同单元件编号(" + importDTO.getElementNo() + ")的材质必须保持一致!"));
                  }

                  if (StringUtils.isNotBlank(dtoParam.getName())
                     && StringUtils.isNotBlank(importDTO.getName())
                     && !dtoParam.getName().equals(importDTO.getName())) {
                     mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "相同单元件编号(" + importDTO.getElementNo() + ")的名称必须保持一致!"));
                  }
               } else {
                  eleMenttImportDtoMap.put(importDTO.getElementNo(), importDTO);
               }
            }
         }
      }
   }

   private void checkMachinePartAssembleField(
      ZnljBridgeImportTemplateDtoParam importDTO,
      Map<String, Long> machinePartSpecMap,
      Map<String, Long> sectionMachinePartSpecMap,
      List<MistakeExportDTO> mistakeExportDTOList
   ) {
      Integer orderNo = importDTO.getOrderNo();
      if (StringUtils.isBlank(importDTO.getName())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")的名称不能为空!"));
      }

      if (importDTO.getNetWeight() == null || importDTO.getNetWeight().compareTo(BigDecimal.ZERO) <= 0) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")单净重有误!"));
      }

      if (importDTO.getLength() == null || importDTO.getLength().compareTo(BigDecimal.ZERO) <= 0) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")的长度必须存在且大于0!"));
      }

      if (importDTO.getQuantity() == null || importDTO.getQuantity() <= 0) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")的数量不能为空且大于0!"));
      }

      if (StringUtils.isBlank(importDTO.getSpecification())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")的规格不能为空!"));
      } else if (Character.isDigit(importDTO.getSpecification().charAt(0))) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")的规格前缀不能为数字!"));
      } else if (!TechUtils.checkSpecification(importDTO.getSpecification())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")的规格中两组数字之间存在非法符号!"));
      } else {
         String specPrefix = TechUtils.getSpecPrefix(importDTO.getSpecification());
         if (StringUtils.isBlank(specPrefix)) {
            if (importDTO.getSpecification().startsWith("□")) {
               specPrefix = "□";
            } else {
               mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件规格无法解析!"));
            }
         }

         importDTO.setSpecPrefix(specPrefix);
      }

      if (StringUtils.isNotBlank(importDTO.getSpecPrefix())
         && !machinePartSpecMap.containsKey(importDTO.getSpecPrefix())
         && !sectionMachinePartSpecMap.containsKey(importDTO.getSpecPrefix())) {
         mistakeExportDTOList.add(
            TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")的规格前缀[" + importDTO.getSpecPrefix() + "]未定义!")
         );
      }

      if (StringUtils.isNotBlank(importDTO.getSpecPrefix())) {
         if (StringUtils.isBlank(importDTO.getMaterial())) {
            mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")的材质不能为空!"));
         }

         if (machinePartSpecMap.containsKey(importDTO.getSpecPrefix())) {
            if (importDTO.getThickness() == null || importDTO.getThickness().compareTo(BigDecimal.ZERO) <= 0) {
               mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")厚度值有误!"));
            }

            if (importDTO.getWidth() == null || importDTO.getWidth().compareTo(BigDecimal.ZERO) <= 0) {
               mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")宽度值有误!"));
            }

            if (importDTO.getLength() != null && importDTO.getWidth() != null && importDTO.getThickness() != null) {
               BigDecimal grossWeight = importDTO.getLength()
                  .multiply(importDTO.getWidth())
                  .multiply(importDTO.getThickness())
                  .multiply(new BigDecimal("7.85"))
                  .divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP);
               importDTO.setGrossWeight(grossWeight);
               if (importDTO.getQuantity() != null && importDTO.getQuantity() > 0) {
                  importDTO.setTotalGrossWeight(grossWeight.multiply(BigDecimal.valueOf(importDTO.getQuantity().intValue())));
               }
            }
         }

         if (sectionMachinePartSpecMap.containsKey(importDTO.getSpecPrefix())
            && (importDTO.getGrossWeight() == null || importDTO.getGrossWeight().compareTo(BigDecimal.ZERO) <= 0)) {
            mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "零件编号(" + importDTO.getSerialNumber() + ")单毛重有误!"));
         }

         if (importDTO.getQuantity() != null && importDTO.getQuantity() > 0 && importDTO.getNetWeight() != null) {
            importDTO.setTotalNetWeight(importDTO.getNetWeight().multiply(BigDecimal.valueOf(importDTO.getQuantity().intValue())));
         }
      }
   }

   private void checkElementAssembleField(
      ZnljBridgeImportTemplateDtoParam importDTO, Map<String, Long> assembleSpecMap, List<MistakeExportDTO> mistakeExportDTOList
   ) {
      Integer orderNo = importDTO.getOrderNo();
      if (StringUtils.isBlank(importDTO.getName())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "单元件编号(" + importDTO.getElementNo() + ")的名称不能为空!"));
      }

      if (importDTO.getLength() == null || importDTO.getLength().compareTo(BigDecimal.ZERO) <= 0) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "单元件编号(" + importDTO.getElementNo() + ")的长度必须存在且大于0!"));
      }

      if (importDTO.getQuantity() == null || importDTO.getQuantity() <= 0) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "单元件编号(" + importDTO.getElementNo() + ")的数量不能为空且大于0!"));
      }

      if (StringUtils.isBlank(importDTO.getSpecification())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "单元件编号(" + importDTO.getElementNo() + ")的规格不能为空!"));
      } else if (Character.isDigit(importDTO.getSpecification().charAt(0))) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "单元件编号(" + importDTO.getElementNo() + ")的规格前缀不能为数字!"));
      } else if (!TechUtils.checkSpecification(importDTO.getSpecification())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "单元件编号(" + importDTO.getElementNo() + ")的规格中两组数字之间存在非法符号!"));
      } else {
         String specPrefix = TechUtils.getSpecPrefix(importDTO.getSpecification());
         importDTO.setSpecPrefix(specPrefix);
      }

      if (StringUtils.isNotBlank(importDTO.getSpecPrefix()) && !assembleSpecMap.containsKey(importDTO.getSpecPrefix())) {
         mistakeExportDTOList.add(
            TechUtils.buildMistakeByOrderNoDTO(orderNo, "单元件编号(" + importDTO.getElementNo() + ")的规格前缀[" + importDTO.getSpecPrefix() + "]未定义!")
         );
      }

      if (StringUtils.isNotBlank(importDTO.getSpecPrefix()) && StringUtils.isBlank(importDTO.getMaterial())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "单元件编号(" + importDTO.getElementNo() + ")的材质不能为空!"));
      }
   }

   private void checkArtifactField(ZnljBridgeImportTemplateDtoParam importDTO, List<MistakeExportDTO> mistakeExportDTOList) {
      Integer orderNo = importDTO.getOrderNo();
      if (StringUtils.isBlank(importDTO.getName())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "箱体编号(" + importDTO.getArtifactNo() + ")的名称不能为空!"));
      }

      Boolean boolContainEnglishLetter = com.hzchum.pangu.common.util.StringUtils.boolContainEnglishLetter(importDTO.getArtifactNo());
      if (!boolContainEnglishLetter) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "箱体编号(" + importDTO.getArtifactNo() + ")未包含英文字母!"));
      }

      if (StringUtils.isBlank(importDTO.getStructureType())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "箱体编号(" + importDTO.getArtifactNo() + ")的箱体结构类型不能为空!"));
      }

      if (StringUtils.isBlank(importDTO.getSpecification())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "箱体编号(" + importDTO.getArtifactNo() + ")的规格不能为空!"));
      } else if (Character.isDigit(importDTO.getSpecification().charAt(0))) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "箱体编号(" + importDTO.getArtifactNo() + ")的规格前缀不能为数字!"));
      } else if (!TechUtils.checkSpecification(importDTO.getSpecification())) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "箱体编号(" + importDTO.getArtifactNo() + ")的规格中两组数字之间存在非法符号!"));
      } else {
         String specPrefix = TechUtils.getSpecPrefix(importDTO.getSpecification());
         importDTO.setSpecPrefix(specPrefix);
      }

      if (importDTO.getLength() == null || importDTO.getLength().compareTo(BigDecimal.ZERO) <= 0) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "箱体编号(" + importDTO.getArtifactNo() + ")的长度不能为空且必须大于0!"));
      }

      if (importDTO.getQuantity() == null || importDTO.getQuantity() <= 0) {
         mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(orderNo, "箱体编号(" + importDTO.getArtifactNo() + ")的数量不能为空且必须大于0!"));
      }
   }

   public TechUtilInventoryBridgeManagerImpl(
      final TechArtifactService artifactService,
      final TechAssembleService assembleService,
      final TechMachinePartService machinePartService,
      final TechArtifactMachinePartLinkService artifactMachinePartLinkService,
      final TechAssembleDetailService assembleDetailService,
      final TechAssembleMachinePartLinkService assembleMachinePartLinkService,
      final TechStandardPartService standardPartService,
      final TechArtifactStandardPartLinkService artifactStandardPartLinkService,
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
      this.standardPartService = standardPartService;
      this.artifactStandardPartLinkService = artifactStandardPartLinkService;
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
