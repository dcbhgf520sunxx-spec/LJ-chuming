package com.hzchum.scim.plan.core.manager;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.plan.core.api.enums.AuxiliaryUsePropertyEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryTypeEnum;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.enums.RangeOfActionEnum;
import com.hzchum.scim.plan.core.api.enums.SourcePartEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.manager.TechUtilInventoryBridgeManager;
import com.hzchum.scim.plan.core.api.manager.TechUtilInventoryGridManager;
import com.hzchum.scim.plan.core.api.manager.TechUtilInventoryMesManager;
import com.hzchum.scim.plan.core.api.manager.TechUtilManager;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactSpecAmend;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactStandardPartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
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
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechAreaProductInfoDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechConfigUtilsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechMonomerDrawInfoDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactBoxImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.InventoryArtifactBoxDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.InventoryAssembleDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.InventoryAssembleImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.InventoryMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.InventoryStandardPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.MachinePartImportDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ZnljArtifactMachinePartImportTemplateDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ZnljBridgeImportTemplateDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ZnljGridImportTemplateDtoParam;
import com.hzchum.scim.plan.core.api.pojo.vo.TechAssemblyAutomaticCombinationVO;
import com.hzchum.scim.plan.core.api.pojo.vo.TemplatePanelAssemblyConfigVO;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechArtifactSpecAmendService;
import com.hzchum.scim.plan.core.api.service.TechArtifactStandardPartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechMachineHoleRadiusLinkService;
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
import com.hzchum.scim.system.core.api.common.enums.SmallArtifactClassEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesArtifactClass;
import com.hzchum.scim.system.core.api.pojo._do.MesSectionWarehouseConfigDetail;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleSpec;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassSpecNameLink;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassificationMatch;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpec;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpecNumberLink;
import com.hzchum.scim.system.core.api.pojo.dto.InventoryConfigurationDetailDTO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.MesArtifactClassService;
import com.hzchum.scim.system.core.api.service.MesSectionWarehouseConfigDetailService;
import com.hzchum.scim.system.core.api.service.SysAssembleSpecService;
import com.hzchum.scim.system.core.api.service.SysInventoryConfigurationService;
import com.hzchum.scim.system.core.api.service.SysSteelClassSpecNameLinkService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationMatchService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureSpecNumberLinkService;
import com.hzchum.scim.system.core.api.service.SysStructureSpecService;
import com.hzchum.scim.system.core.api.service.TemplatePanelAssemblyConfigService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TechUtilManagerImpl implements TechUtilManager {
   private final TechUtilInventoryMesManager inventoryMesManager;
   private final TechUtilInventoryBridgeManager inventoryBridgeManager;
   private final TechUtilInventoryGridManager inventoryGridManager;
   private final SysStructureClassificationService structureClassificationService;
   private final SysStructureSpecService structureSpecService;
   private final SysSteelClassificationMatchService steelClassificationMatchService;
   private final SysAssembleSpecService assembleSpecService;
   private final MesBuildingProductProcessService productProcessService;
   private final SysStructureSpecNumberLinkService sysStructureSpecNumberLinkService;
   private final MesSectionWarehouseConfigDetailService mesSectionWarehouseConfigDetailService;
   private final TechArtifactService artifactService;
   private final TechAssembleService assembleService;
   private final TechMachinePartService machinePartService;
   private final TechStandardPartService standardPartService;
   private final TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   private final TechAssembleDetailService assembleDetailService;
   private final TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   private final TechArtifactStandardPartLinkService artifactStandardPartLinkService;
   private final SysSteelClassSpecNameLinkService sysSteelClassSpecNameLinkService;
   private final MesTechInventoryOperationService mesTechInventoryOperationService;
   private final TechArtifactRecordService artifactRecordService;
   private final TechMachinePartRecordService machinePartRecordService;
   private final TechAssembleRecordService assembleRecordService;
   private final TechAssembleDetailRecordService assembleDetailRecordService;
   private final TechArtifactMachinePartLinkRecordService artifactMachinePartLinkRecordService;
   private final TechStandardPartRecordService standardPartRecordService;
   private final TechArtifactStandardPartLinkRecordService artifactStandardPartLinkRecordService;
   private final TechDrawingService drawingService;
   private final TechMachineHoleRadiusLinkService machineHoleRadiusLinkService;
   private final TechAssembleMachinePartLinkRecordService assembleMachinePartLinkRecordService;
   private final ConfigService configService;
   private final SysInventoryConfigurationService inventoryConfigurationService;
   private final TemplatePanelAssemblyConfigService panelAssemblyConfigService;
   private final SysStructureSpecService sysStructureSpecService;
   private final SysAssembleSpecService sysAssembleSpecService;
   private final TechArtifactSpecAmendService artifactSpecAmendService;
   private final MesArtifactClassService mesArtifactClassService;
   private final Pattern CHINESE_PATTERN = Pattern.compile("[\\u4e00-\\u9fa5]");

   @Override
   public TechConfigUtilsDTO getTechConfigUtilsDto(Integer inventoryTypeEnum) {
      List<SysStructureClassification> structureClassificationList = this.structureClassificationService
         .list((Wrapper<SysStructureClassification>)new LambdaQueryWrapper<SysStructureClassification>().eq(SysStructureClassification::getMesProductEnum, inventoryTypeEnum));
      List<Long> purlingClassIds = structureClassificationList.stream()
         .filter(
            s -> s.getArtifactType().equals(ArtifactTypeEnum.SMALL.getType()) && SmallArtifactClassEnum.PURLIN.getType().equals(s.getSmallArtifactClassEnum())
         )
         .map(SysStructureClassification::getId)
         .collect(Collectors.toList());
      Map<String, Long> commonStructureSpecMap = this.structureSpecService
         .list(
            (Wrapper<SysStructureSpec>)(new LambdaQueryWrapper<SysStructureSpec>().eq(SysStructureSpec::getArtifactType, ArtifactTypeEnum.COMMON.getType()))
               .eq(SysStructureSpec::getMesProductEnum, inventoryTypeEnum)
         )
         .stream()
         .collect(Collectors.toMap(SysStructureSpec::getSpecPrefix, SysStructureSpec::getStructureClassificationId));
      Map<String, Map<String, Long>> smallArtifactNameMap = this.sysStructureSpecNumberLinkService
         .list(
            (Wrapper<SysStructureSpecNumberLink>)(new LambdaQueryWrapper<SysStructureSpecNumberLink>()
                  .eq(SysStructureSpecNumberLink::getMesProductEnum, inventoryTypeEnum))
               .eq(SysStructureSpecNumberLink::getArtifactType, 2)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               SysStructureSpecNumberLink::getSpecPrefix,
               Collectors.toMap(SysStructureSpecNumberLink::getSnPrefix, SysStructureSpecNumberLink::getStructureClassificationId)
            )
         );
      List<Long> boolComposeAssembleClassIds = this.structureClassificationService
         .list(
            (Wrapper<SysStructureClassification>)(new LambdaQueryWrapper<SysStructureClassification>()
                  .eq(SysStructureClassification::getMesProductEnum, inventoryTypeEnum))
               .eq(SysStructureClassification::getBoolComposeAssemble, Boolean.FALSE)
         )
         .stream()
         .map(SysStructureClassification::getId)
         .distinct()
         .collect(Collectors.toList());
      Map<String, Long> assembleSpecMap = this.assembleSpecService
         .list(
            (Wrapper<SysAssembleSpec>)(new LambdaQueryWrapper<SysAssembleSpec>().eq(SysAssembleSpec::getBoolSectionSteel, Boolean.FALSE))
               .eq(SysAssembleSpec::getMesProductEnum, inventoryTypeEnum)
         )
         .stream()
         .collect(Collectors.toMap(SysAssembleSpec::getSpecPrefix, SysAssembleSpec::getAssembleConfigId));
      Map<String, Long> machinePartSpecMap = this.steelClassificationMatchService
         .list(
            (Wrapper<SysSteelClassificationMatch>)(new LambdaQueryWrapper<SysSteelClassificationMatch>()
                  .eq(SysSteelClassificationMatch::getSteelPlateTypeEnum, SteelPlateTypeEnum.PRIMARY_MEMBER.getType()))
               .eq(SysSteelClassificationMatch::getMesProductEnum, inventoryTypeEnum)
         )
         .stream()
         .collect(Collectors.toMap(SysSteelClassificationMatch::getKeyword, SysSteelClassificationMatch::getSteelId));
      Map<String, Long> sectionMachinePartSpecMap = this.steelClassificationMatchService
         .list(
            (Wrapper<SysSteelClassificationMatch>)(new LambdaQueryWrapper<SysSteelClassificationMatch>()
                  .eq(SysSteelClassificationMatch::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECTIONSTEEL.getType()))
               .eq(SysSteelClassificationMatch::getMesProductEnum, inventoryTypeEnum)
         )
         .stream()
         .collect(Collectors.toMap(SysSteelClassificationMatch::getKeyword, SysSteelClassificationMatch::getSteelId));
      Map<String, Map<String, Long>> steelClassSpecNameLinkMap = this.sysSteelClassSpecNameLinkService
         .list((Wrapper<SysSteelClassSpecNameLink>)new LambdaQueryWrapper<SysSteelClassSpecNameLink>().eq(SysSteelClassSpecNameLink::getMesProductEnum, inventoryTypeEnum))
         .stream()
         .collect(
            Collectors.groupingBy(
               SysSteelClassSpecNameLink::getSpecPrefix, Collectors.toMap(SysSteelClassSpecNameLink::getMatchingName, SysSteelClassSpecNameLink::getSteelId)
            )
         );
      List<String> matchingNameList = this.sysSteelClassSpecNameLinkService
         .list((Wrapper<SysSteelClassSpecNameLink>)new LambdaQueryWrapper<SysSteelClassSpecNameLink>().eq(SysSteelClassSpecNameLink::getMesProductEnum, inventoryTypeEnum))
         .stream()
         .map(SysSteelClassSpecNameLink::getMatchingName)
         .collect(Collectors.toList());
      List<MesBuildingProductProcess> productProcessList = this.productProcessService
         .list((Wrapper<MesBuildingProductProcess>)new LambdaQueryWrapper<MesBuildingProductProcess>().eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE))
         .stream()
         .filter(p -> p.getTypeId() != null)
         .collect(Collectors.toList());
      List<Long> processAssembleClassIds = productProcessList.stream()
         .filter(p -> p.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType()))
         .map(MesBuildingProductProcess::getTypeId)
         .distinct()
         .collect(Collectors.toList());
      Map<Integer, Map<String, Long>> standardPartConfigMap = this.mesSectionWarehouseConfigDetailService
         .list(
            (Wrapper<MesSectionWarehouseConfigDetail>)(new LambdaQueryWrapper<MesSectionWarehouseConfigDetail>()
                  .eq(MesSectionWarehouseConfigDetail::getProductType, ProductTypeEnum.AUXILIARY_MATERIAL.getType()))
               .eq(MesSectionWarehouseConfigDetail::getProductClassificationEnum, ProductClassificationEnum.AUXILIARY_MATERIAL.getType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               MesSectionWarehouseConfigDetail::getProductSectionNameEnum,
               Collectors.toMap(MesSectionWarehouseConfigDetail::getName, MesSectionWarehouseConfigDetail::getId)
            )
         );
      List<String> mesArtifactClassNameList = this.mesArtifactClassService.list().stream().map(MesArtifactClass::getName).collect(Collectors.toList());
      return TechConfigUtilsDTO.builder()
         .commonStructureSpecMap(commonStructureSpecMap)
         .smallArtifactNameMap(smallArtifactNameMap)
         .purlinClassIds(purlingClassIds)
         .assembleSpecMap(assembleSpecMap)
         .machinePartSpecMap(machinePartSpecMap)
         .sectionMachinePartSpecMap(sectionMachinePartSpecMap)
         .standardPartConfigMap(standardPartConfigMap)
         .steelClassSpecNameLinkMap(steelClassSpecNameLinkMap)
         .matchingNameList(matchingNameList)
         .processAssembleClassIds(processAssembleClassIds)
         .boolComposeAssembleClassIds(boolComposeAssembleClassIds)
         .mesArtifactClassNameList(mesArtifactClassNameList)
         .build();
   }

   @Override
   public TechAreaProductInfoDTO getAreaProductInfo(Long areaBachId) {
      List<TechArtifact> artifactList = this.artifactService.list(Wrappers.lambdaQuery(TechArtifact.builder().areaBatchId(areaBachId).build()));
      List<TechAssemble> assembleList = this.assembleService.list(Wrappers.lambdaQuery(TechAssemble.builder().areaBatchId(areaBachId).build()));
      List<TechMachinePart> machinePartList = this.machinePartService.list(Wrappers.lambdaQuery(TechMachinePart.builder().areaBatchId(areaBachId).build()));
      List<TechStandardPart> standardPartList = this.standardPartService
         .list(
            Wrappers.lambdaQuery(
               TechStandardPart.builder().areaBatchId(areaBachId).boolArtifactImport(true).relationType(ProductTypeEnum.ARTIFACT.getType()).build()
            )
         );
      Map<String, TechArtifact> areaArtifactSnMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getSerialNumber, Function.identity()));
      Map<Long, TechAssemble> areaAssembleIdMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
      Map<String, List<TechAssemble>> areaAssembleSnGroupMap = assembleList.stream().collect(Collectors.groupingBy(TechAssemble::getSerialNumber));
      Map<Long, TechMachinePart> areaMachinePartMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      Map<String, List<TechMachinePart>> areaMachinePartSnGroupMap = machinePartList.stream().collect(Collectors.groupingBy(TechMachinePart::getSerialNumber));
      List<TechArtifactMachinePartLink> artifactMachinePartLinkList = Collections.emptyList();
      List<TechAssembleDetail> assembleDetailList = Collections.emptyList();
      List<TechArtifactStandardPartLink> artifactStandardPartLinkList = Collections.emptyList();
      List<TechAssembleMachinePartLink> assembleMachinePartLinkList = Collections.emptyList();
      if (CollectionUtils.isNotEmpty(artifactList)) {
         List<Long> artifactIds = artifactList.stream().map(TechArtifact::getId).collect(Collectors.toList());
         artifactMachinePartLinkList = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artifactIds));
         assembleDetailList = this.assembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, artifactIds));
         artifactStandardPartLinkList = this.artifactStandardPartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactStandardPartLink.class).in(TechArtifactStandardPartLink::getArtifactId, artifactIds));
      }

      if (CollectionUtils.isNotEmpty(assembleList)) {
         List<Long> assembleIds = assembleList.stream().map(TechAssemble::getId).collect(Collectors.toList());
         assembleMachinePartLinkList = this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getAssembleId, assembleIds));
      }

      Map<Long, List<TechArtifactMachinePartLink>> artifactMachinePartLinkGroupMap = artifactMachinePartLinkList.stream()
         .collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
      Map<Long, List<TechAssembleDetail>> assembleDetailGroupMap = assembleDetailList.stream()
         .collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
      Map<Long, List<TechArtifactStandardPartLink>> artifactStandardPartLinkGroupMap = artifactStandardPartLinkList.stream()
         .collect(Collectors.groupingBy(TechArtifactStandardPartLink::getArtifactId));
      Map<Long, List<TechAssembleMachinePartLink>> assembleMachinePartLinkGroupMap = assembleMachinePartLinkList.stream()
         .collect(Collectors.groupingBy(TechAssembleMachinePartLink::getAssembleId));
      return TechAreaProductInfoDTO.builder()
         .artifactList(artifactList)
         .assembleList(assembleList)
         .machinePartList(machinePartList)
         .standardPartList(standardPartList)
         .artifactSnMap(areaArtifactSnMap)
         .assembleIdMap(areaAssembleIdMap)
         .assembleSnGroupMap(areaAssembleSnGroupMap)
         .machinePartIdMap(areaMachinePartMap)
         .machinePartSnGroupMap(areaMachinePartSnGroupMap)
         .artifactMachinePartLinkGroupMap(artifactMachinePartLinkGroupMap)
         .assembleDetailGroupMap(assembleDetailGroupMap)
         .artifactStandardPartLinkGroupMap(artifactStandardPartLinkGroupMap)
         .assembleMachinePartLinkGroupMap(assembleMachinePartLinkGroupMap)
         .build();
   }

   @Override
   public TechMonomerDrawInfoDTO getMonomerDrawInfo(Long monomerId) {
      Set<String> monomerAssembleSnDrawingSet = this.drawingService
         .getDrawingMap(monomerId, TechDataTypeEnum.NC_DRAWING.getType(), ProductTypeEnum.ASSEMBLE.getType())
         .keySet();
      Map<String, List<TechDrawing>> monomerPartDrawingMap = this.drawingService.getDrawingMap(monomerId, TechDataTypeEnum.NC_DRAWING.getType(), null);
      Map<String, Long> holeNumberMap = this.machineHoleRadiusLinkService.getMachinePartHoleNumberMap(monomerId);
      return TechMonomerDrawInfoDTO.builder()
         .monomerAssembleSnDrawSet(monomerAssembleSnDrawingSet)
         .monomerPartDrawingMap(monomerPartDrawingMap)
         .holeNumberMap(holeNumberMap)
         .build();
   }

   @Override
   public List<InventoryArtifactBoxDTO> getInventoryList(Long inventoryId) {
      MesTechInventoryOperation inventoryOperation = this.mesTechInventoryOperationService.getById(inventoryId);
      Preconditions.checkArgument(inventoryOperation != null, "清单操作记录不存在!");
      List<TechArtifactRecord> artifactRecordList = this.artifactRecordService
         .list((Wrapper<TechArtifactRecord>)new LambdaQueryWrapper<TechArtifactRecord>().eq(TechArtifactRecord::getInventoryOperationId, inventoryId));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactRecordList), "操作失败,清单导入记录不存在!");
      Map<Long, TechAssembleRecord> assembleRecordMap = this.assembleRecordService
         .list((Wrapper<TechAssembleRecord>)new LambdaQueryWrapper<TechAssembleRecord>().eq(TechAssembleRecord::getInventoryOperationId, inventoryId))
         .stream()
         .collect(Collectors.toMap(TechAssembleRecord::getId, Function.identity()));
      Map<Long, TechMachinePartRecord> machinePartRecordMap = this.machinePartRecordService
         .list((Wrapper<TechMachinePartRecord>)new LambdaQueryWrapper<TechMachinePartRecord>().eq(TechMachinePartRecord::getInventoryOperationId, inventoryId))
         .stream()
         .collect(Collectors.toMap(TechMachinePartRecord::getId, Function.identity()));
      Map<Long, TechStandardPartRecord> standardPartRecordMap = this.standardPartRecordService
         .list((Wrapper<TechStandardPartRecord>)new LambdaQueryWrapper<TechStandardPartRecord>().eq(TechStandardPartRecord::getInventoryOperationId, inventoryId))
         .stream()
         .collect(Collectors.toMap(TechStandardPartRecord::getId, Function.identity()));
      Map<Long, List<TechAssembleDetailRecord>> assembleDetailRecordMap = this.assembleDetailRecordService
         .list((Wrapper<TechAssembleDetailRecord>)new LambdaQueryWrapper<TechAssembleDetailRecord>().in(TechAssembleDetailRecord::getInventoryOperationId, inventoryId))
         .stream()
         .collect(Collectors.groupingBy(TechAssembleDetailRecord::getArtifactRecordId));
      Map<Long, List<TechArtifactMachinePartLinkRecord>> machinePartLinkRecordMap = this.artifactMachinePartLinkRecordService
         .list((Wrapper<TechArtifactMachinePartLinkRecord>)new LambdaQueryWrapper<TechArtifactMachinePartLinkRecord>().in(TechArtifactMachinePartLinkRecord::getInventoryOperationId, inventoryId))
         .stream()
         .collect(Collectors.groupingBy(TechArtifactMachinePartLinkRecord::getArtifactRecordId));
      Map<Long, List<TechArtifactStandardPartLinkRecord>> standardPartLinkRecordMap = this.artifactStandardPartLinkRecordService
         .list(
            (Wrapper<TechArtifactStandardPartLinkRecord>)new LambdaQueryWrapper<TechArtifactStandardPartLinkRecord>().eq(TechArtifactStandardPartLinkRecord::getInventoryOperationId, inventoryId)
         )
         .stream()
         .collect(Collectors.groupingBy(TechArtifactStandardPartLinkRecord::getArtifactRecordId));
      Map<Long, List<TechAssembleMachinePartLinkRecord>> assembleMachinePartLinkMap = this.assembleMachinePartLinkRecordService
         .list((Wrapper<TechAssembleMachinePartLinkRecord>)new LambdaQueryWrapper<TechAssembleMachinePartLinkRecord>().eq(TechAssembleMachinePartLinkRecord::getInventoryOperationId, inventoryId))
         .stream()
         .collect(Collectors.groupingBy(TechAssembleMachinePartLinkRecord::getAssembleRecordId));
      List<InventoryArtifactBoxDTO> inventoryArtifactBoxDTOS = new ArrayList<>(36);
      artifactRecordList.forEach(artifactRecord -> {
         InventoryArtifactBoxDTO artifactBoxDTO = BeanUtil.copy(artifactRecord, InventoryArtifactBoxDTO.class);
         List<TechAssembleDetailRecord> assembleDetailRecords = assembleDetailRecordMap.get(artifactBoxDTO.getId());
         if (CollectionUtils.isNotEmpty(assembleDetailRecords)) {
            List<InventoryAssembleDTO> assembleDTOList = assembleDetailRecords.stream().map(assembleDetailRecord -> {
               TechAssembleRecord techAssembleRecord = assembleRecordMap.get(assembleDetailRecord.getAssembleRecordId());
               InventoryAssembleDTO assembleDTO = BeanUtil.copy(techAssembleRecord, InventoryAssembleDTO.class);
               assembleDTO.setQuantity(artifactRecord.getQuantity() * assembleDetailRecord.getQuantity());
               List<TechAssembleMachinePartLinkRecord> techAssembleMachinePartLinks = assembleMachinePartLinkMap.get(assembleDTO.getId());
               if (CollectionUtils.isNotEmpty(techAssembleMachinePartLinks)) {
                  List<InventoryMachinePartDTO> machinePartDTOS = techAssembleMachinePartLinks.stream().map(assembleMachinePartLink -> {
                     TechMachinePartRecord machinePartRecord = machinePartRecordMap.get(assembleMachinePartLink.getMachinePartRecordId());
                     InventoryMachinePartDTO machinePartDTO = BeanUtil.copy(machinePartRecord, InventoryMachinePartDTO.class);
                     machinePartDTO.setQuantity(assembleDTO.getQuantity() * assembleMachinePartLink.getQuantity());
                     return machinePartDTO;
                  }).collect(Collectors.toList());
                  assembleDTO.setAssembleElementMachinePartList(machinePartDTOS);
               }

               return assembleDTO;
            }).collect(Collectors.toList());
            artifactBoxDTO.setAssembleDTOList(assembleDTOList);
         }

         List<TechArtifactMachinePartLinkRecord> partLinkRecordList = machinePartLinkRecordMap.get(artifactBoxDTO.getId());
         if (CollectionUtils.isNotEmpty(partLinkRecordList)) {
            List<InventoryMachinePartDTO> machinePartDTOS = partLinkRecordList.stream().map(partLinkRecord -> {
               TechMachinePartRecord machinePartRecord = machinePartRecordMap.get(partLinkRecord.getMachinePartRecordId());
               InventoryMachinePartDTO machinePartDTO = BeanUtil.copy(machinePartRecord, InventoryMachinePartDTO.class);
               machinePartDTO.setQuantity(artifactRecord.getQuantity() * partLinkRecord.getQuantity());
               return machinePartDTO;
            }).collect(Collectors.toList());
            artifactBoxDTO.setMachinePartDTOList(machinePartDTOS);
         }

         List<TechArtifactStandardPartLinkRecord> standardPartLinkRecordList = standardPartLinkRecordMap.get(artifactBoxDTO.getId());
         if (CollectionUtils.isNotEmpty(standardPartLinkRecordList)) {
            List<InventoryStandardPartDTO> standardPartDTOS = standardPartLinkRecordList.stream().map(standardPartLinkRecord -> {
               TechStandardPartRecord techStandardPartRecord = standardPartRecordMap.get(standardPartLinkRecord.getStandardPartRecordId());
               if (techStandardPartRecord.getUseProperty().equals(AuxiliaryUsePropertyEnum.FACTORY_USE.getType())) {
                  InventoryStandardPartDTO standardPartDTO = BeanUtil.copy(techStandardPartRecord, InventoryStandardPartDTO.class);
                  standardPartDTO.setQuantity(artifactRecord.getQuantity() * standardPartLinkRecord.getQuantity());
                  return standardPartDTO;
               } else {
                  return null;
               }
            }).filter(Objects::nonNull).collect(Collectors.toList());
            artifactBoxDTO.setStandardPartDTOS(standardPartDTOS);
         }

         inventoryArtifactBoxDTOS.add(artifactBoxDTO);
      });
      return inventoryArtifactBoxDTOS;
   }

   @Override
   public List<InventoryStandardPartDTO> getInventoryStandardPartList(Long inventoryId) {
      List<TechStandardPartRecord> standardPartRecordList = this.standardPartRecordService
         .list(
            (Wrapper<TechStandardPartRecord>)(new LambdaQueryWrapper<TechStandardPartRecord>().eq(TechStandardPartRecord::getInventoryOperationId, inventoryId))
               .eq(TechStandardPartRecord::getUseProperty, AuxiliaryUsePropertyEnum.SITE_USE.getType())
         );
      return CollectionUtils.isNotEmpty(standardPartRecordList)
         ? cn.hutool.core.bean.BeanUtil.copyToList(standardPartRecordList, InventoryStandardPartDTO.class)
         : null;
   }

   @Override
   public List<MachinePartImportDtoParam> getComponentSplitWingWebV2(
      Map<String, Map<String, Long>> steelClassSpecNameLinkMap, String specPrefix, InventoryAssembleImportDTO assembleImportDtoParam
   ) {
      List<MachinePartImportDtoParam> secondaryMemberPartImportDtoParam = new ArrayList<>();
      MachinePartImportDtoParam foilPartImportDtoParamOne = new MachinePartImportDtoParam();
      MachinePartImportDtoParam foilPartImportDtoParamTwo = new MachinePartImportDtoParam();
      MachinePartImportDtoParam webPartImportDtoParam = new MachinePartImportDtoParam();
      MachinePartImportDtoParam webPartImportDtoParamTwo = new MachinePartImportDtoParam();
      String[] specList = TechUtils.getSpecList(assembleImportDtoParam.getSpecification());
      if (specPrefix.equals("BH") || specPrefix.equals("H")) {
         if (assembleImportDtoParam.getSpecification().contains("(")) {
            specList = TechUtils.getExtractNumbers(assembleImportDtoParam.getSpecification()).toArray(new String[0]);
         }

         if (specList.length == 4) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            if (assembleImportDtoParam.getSpecification().contains("-") && !assembleImportDtoParam.getSpecification().contains("(")) {
               foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[2] + "*" + specList[3]);
               foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[2]));
               foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[3]));
               webPartImportDtoParam.setSpecification(
                  webPartImportDtoParam.getSpecPrefix() + specList[1] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[2]))
               );
               webPartImportDtoParam.setThickness(new BigDecimal(specList[1]));
               webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[2])));
            } else {
               foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[3] + "*" + specList[1]);
               foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[3]));
               foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[1]));
               webPartImportDtoParam.setSpecification(
                  webPartImportDtoParam.getSpecPrefix() + specList[2] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[3]))
               );
               webPartImportDtoParam.setThickness(new BigDecimal(specList[2]));
               webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[3])));
            }

            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
         }

         if (specList.length == 5) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[3] + "*" + specList[4]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[3]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[4]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix() + specList[2] + "*" + (Double.valueOf(specList[1]) - 2.0 * Double.valueOf(specList[3]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[2]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[1]) - 2.0 * Double.valueOf(specList[3])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
         }

         if (specList.length == 6) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("上翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[2] + "*" + specList[3]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[2]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[3]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo.setSpecPrefix("PL");
            foilPartImportDtoParamTwo.setName("下翼板");
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            foilPartImportDtoParamTwo.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamTwo.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamTwo.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamTwo.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[4] + "*" + specList[5]);
            foilPartImportDtoParamTwo.setThickness(new BigDecimal(specList[4]));
            foilPartImportDtoParamTwo.setWidth(new BigDecimal(specList[5]));
            foilPartImportDtoParamTwo.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamTwo.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix()
                  + specList[1]
                  + "*"
                  + (Double.valueOf(specList[0]) - Double.valueOf(specList[2]) - Double.valueOf(specList[4]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[1]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - Double.valueOf(specList[2]) - Double.valueOf(specList[4])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
         }

         if (specList.length == 7) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("上翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[3] + "*" + specList[4]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[3]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[4]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo.setSpecPrefix("PL");
            foilPartImportDtoParamTwo.setName("下翼板");
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            foilPartImportDtoParamTwo.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamTwo.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamTwo.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamTwo.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[5] + "*" + specList[6]);
            foilPartImportDtoParamTwo.setThickness(new BigDecimal(specList[5]));
            foilPartImportDtoParamTwo.setWidth(new BigDecimal(specList[6]));
            foilPartImportDtoParamTwo.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamTwo.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix()
                  + specList[2]
                  + "*"
                  + (Double.valueOf(specList[1]) - Double.valueOf(specList[3]) - Double.valueOf(specList[5]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[2]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[1]) - Double.valueOf(specList[3]) - Double.valueOf(specList[5])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
         }
      }

      if (specPrefix.equals("BOX")) {
         if (specList.length == 2) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[1] + "*" + specList[0]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[1]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[0]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix() + specList[1] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[1]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[1]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[1])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            webPartImportDtoParamTwo = BeanUtil.copy(webPartImportDtoParam, MachinePartImportDtoParam.class);
            webPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W2");
         }

         if (specList.length == 4) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[3] + "*" + specList[1]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[3]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[1]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix() + specList[2] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[3]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[2]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[3])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            webPartImportDtoParamTwo = BeanUtil.copy(webPartImportDtoParam, MachinePartImportDtoParam.class);
            webPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W2");
         }
      }

      if (specPrefix.equals("BP")) {
         if (specList.length == 2) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[1] + "*" + specList[0]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[1]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[0]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix() + specList[1] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[1]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[1]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[1])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            webPartImportDtoParamTwo = BeanUtil.copy(webPartImportDtoParam, MachinePartImportDtoParam.class);
            webPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W2");
         }

         if (specList.length == 3) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[2] + "*" + specList[1]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[2]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[1]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix() + specList[2] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[2]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[2]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[2])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            webPartImportDtoParamTwo = BeanUtil.copy(webPartImportDtoParam, MachinePartImportDtoParam.class);
            webPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W2");
         }

         if (specList.length == 4) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[3] + "*" + specList[1]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[3]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[1]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix() + specList[2] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[3]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[2]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[3])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            webPartImportDtoParamTwo = BeanUtil.copy(webPartImportDtoParam, MachinePartImportDtoParam.class);
            webPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W2");
         }

         if (specList.length == 5 && assembleImportDtoParam.getSpecification().contains("~")) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[4] + "*" + specList[2]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[4]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[2]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix() + specList[3] + "*" + (Double.valueOf(specList[1]) - 2.0 * Double.valueOf(specList[4]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[3]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[1]) - 2.0 * Double.valueOf(specList[4])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            webPartImportDtoParamTwo = BeanUtil.copy(webPartImportDtoParam, MachinePartImportDtoParam.class);
            webPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W2");
         }

         if (specList.length == 5 && !assembleImportDtoParam.getSpecification().contains("~")) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[4] + "*" + specList[1]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[4]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[1]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix() + specList[4] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[4]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[4]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[4])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            webPartImportDtoParamTwo = BeanUtil.copy(webPartImportDtoParam, MachinePartImportDtoParam.class);
            webPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W2");
         }
      }

      if (specPrefix.equals("BT") || specPrefix.equals("T")) {
         foilPartImportDtoParamOne.setSpecPrefix("PL");
         foilPartImportDtoParamOne.setName("翼板");
         foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
         foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
         foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
         foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
         foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[2] + "*" + specList[3]);
         foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[2]));
         foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[3]));
         foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
         foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
         webPartImportDtoParam.setSpecPrefix("PL");
         webPartImportDtoParam.setName("腹板");
         webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
         webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
         webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
         webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
         webPartImportDtoParam.setSpecification(
            webPartImportDtoParam.getSpecPrefix() + specList[1] + "*" + (Double.valueOf(specList[0]) - Double.valueOf(specList[2]))
         );
         webPartImportDtoParam.setThickness(new BigDecimal(specList[1]));
         webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - Double.valueOf(specList[2])));
         webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
         webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
      }

      if (specPrefix.equals("HI")) {
         if (specList.length == 6) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("上翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[2] + "*" + specList[3]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[2]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[3]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo.setSpecPrefix("PL");
            foilPartImportDtoParamTwo.setName("下翼板");
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            foilPartImportDtoParamTwo.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamTwo.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamTwo.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamTwo.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[4] + "*" + specList[5]);
            foilPartImportDtoParamTwo.setThickness(new BigDecimal(specList[4]));
            foilPartImportDtoParamTwo.setWidth(new BigDecimal(specList[5]));
            foilPartImportDtoParamTwo.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamTwo.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix()
                  + specList[1]
                  + "*"
                  + (Double.valueOf(specList[0]) - Double.valueOf(specList[2]) - Double.valueOf(specList[4]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[1]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - Double.valueOf(specList[2]) - Double.valueOf(specList[4])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
         } else if (assembleImportDtoParam.getSpecification().contains("-")) {
            if (specList.length == 5) {
               if (!assembleImportDtoParam.getSpecification().contains("(")) {
                  foilPartImportDtoParamOne.setSpecPrefix("PL");
                  foilPartImportDtoParamOne.setName("翼板");
                  foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
                  foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
                  foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
                  foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
                  foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[3] + "*" + specList[4]);
                  foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[3]));
                  foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[4]));
                  foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
                  foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
                  webPartImportDtoParam.setSpecPrefix("PL");
                  webPartImportDtoParam.setName("腹板");
                  webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
                  webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
                  webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
                  webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
                  webPartImportDtoParam.setSpecification(
                     webPartImportDtoParam.getSpecPrefix() + specList[2] + "*" + (Double.valueOf(specList[1]) - 2.0 * Double.valueOf(specList[3]))
                  );
                  webPartImportDtoParam.setThickness(new BigDecimal(specList[2]));
                  webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[1]) - 2.0 * Double.valueOf(specList[3])));
                  webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
                  webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
                  foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
                  foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
               } else {
                  specList = TechUtils.getExtractNumbers(assembleImportDtoParam.getSpecification()).toArray(new String[0]);
                  foilPartImportDtoParamOne.setSpecPrefix("PL");
                  foilPartImportDtoParamOne.setName("翼板");
                  foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
                  foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
                  foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
                  foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
                  foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[2] + "*" + specList[3]);
                  foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[2]));
                  foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[3]));
                  foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
                  foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
                  webPartImportDtoParam.setSpecPrefix("PL");
                  webPartImportDtoParam.setName("腹板");
                  webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
                  webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
                  webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
                  webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
                  webPartImportDtoParam.setSpecification(
                     webPartImportDtoParam.getSpecPrefix() + specList[1] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[2]))
                  );
                  webPartImportDtoParam.setThickness(new BigDecimal(specList[1]));
                  webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[2])));
                  webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
                  webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
                  foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
                  foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
               }
            } else {
               foilPartImportDtoParamOne.setSpecPrefix("PL");
               foilPartImportDtoParamOne.setName("翼板");
               foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
               foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
               foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
               foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
               foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[2] + "*" + specList[3]);
               foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[2]));
               foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[3]));
               foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
               foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
               webPartImportDtoParam.setSpecPrefix("PL");
               webPartImportDtoParam.setName("腹板");
               webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
               webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
               webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
               webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
               webPartImportDtoParam.setSpecification(
                  webPartImportDtoParam.getSpecPrefix() + specList[1] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[2]))
               );
               webPartImportDtoParam.setThickness(new BigDecimal(specList[1]));
               webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[2])));
               webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
               webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
               foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
               foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            }
         } else {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[3] + "*" + specList[1]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[3]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[1]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix() + specList[2] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[3]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[2]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[3])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
         }
      }

      if (specPrefix.equals("HK")) {
         if (specList.length == 2) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[1] + "*" + specList[0]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[1]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[0]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix() + specList[1] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[1]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[1]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[1])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            webPartImportDtoParamTwo = BeanUtil.copy(webPartImportDtoParam, MachinePartImportDtoParam.class);
            webPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W2");
         }

         if (specList.length == 4) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[3] + "*" + specList[1]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[3]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[1]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix() + specList[2] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[3]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[2]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[3])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            webPartImportDtoParamTwo = BeanUtil.copy(webPartImportDtoParam, MachinePartImportDtoParam.class);
            webPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W2");
         }

         if (specList.length == 5) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[2] + "*" + specList[3]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[2]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[3]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix() + specList[1] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[2]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[1]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[2])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            webPartImportDtoParamTwo = BeanUtil.copy(webPartImportDtoParam, MachinePartImportDtoParam.class);
            webPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W2");
         }

         if (specList.length == 7) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("上翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[2] + "*" + specList[3]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[2]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[3]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo.setSpecPrefix("PL");
            foilPartImportDtoParamTwo.setName("下翼板");
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            foilPartImportDtoParamTwo.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamTwo.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamTwo.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamTwo.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[4] + "*" + specList[5]);
            foilPartImportDtoParamTwo.setThickness(new BigDecimal(specList[4]));
            foilPartImportDtoParamTwo.setWidth(new BigDecimal(specList[5]));
            foilPartImportDtoParamTwo.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamTwo.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix()
                  + specList[1]
                  + "*"
                  + (Double.valueOf(specList[0]) - Double.valueOf(specList[2]) - Double.valueOf(specList[4]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[1]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - Double.valueOf(specList[2]) - Double.valueOf(specList[4])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParamTwo = BeanUtil.copy(webPartImportDtoParam, MachinePartImportDtoParam.class);
            webPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W2");
         }
      }

      if (specPrefix.equals("PHI")) {
         if (specList.length == 6) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("上翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[2] + "*" + specList[3]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[2]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[3]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo.setSpecPrefix("PL");
            foilPartImportDtoParamTwo.setName("下翼板");
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            foilPartImportDtoParamTwo.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamTwo.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamTwo.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamTwo.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[4] + "*" + specList[5]);
            foilPartImportDtoParamTwo.setThickness(new BigDecimal(specList[4]));
            foilPartImportDtoParamTwo.setWidth(new BigDecimal(specList[5]));
            foilPartImportDtoParamTwo.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamTwo.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(webPartImportDtoParam.getSpecPrefix() + specList[1] + "*" + Double.valueOf(specList[0]));
            webPartImportDtoParam.setThickness(new BigDecimal(specList[1]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
         } else {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[3] + "*" + specList[4]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[3]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[4]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setThickness(new BigDecimal(specList[2]));
            Double maxHeight = Math.max(Convert.toDouble(specList[1]), Convert.toDouble(specList[0]));
            webPartImportDtoParam.setSpecification(webPartImportDtoParam.getSpecPrefix() + specList[2] + "*" + (maxHeight - 2.0 * Double.valueOf(specList[3])));
            webPartImportDtoParam.setWidth(BigDecimal.valueOf(maxHeight - 2.0 * Double.valueOf(specList[3])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
         }
      }

      if (specPrefix.equals("口")) {
         if (specList.length == 2) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[1] + "*" + specList[0]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[1]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[0]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix() + specList[1] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[1]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[1]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[1])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            webPartImportDtoParamTwo = BeanUtil.copy(webPartImportDtoParam, MachinePartImportDtoParam.class);
            webPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W2");
         }

         if (specList.length == 3) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[2] + "*" + specList[1]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[2]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[1]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix() + specList[2] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[2]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[2]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[2])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            webPartImportDtoParamTwo = BeanUtil.copy(webPartImportDtoParam, MachinePartImportDtoParam.class);
            webPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W2");
         }

         if (specList.length == 4) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[3] + "*" + specList[1]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[3]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[1]));
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix() + specList[2] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[3]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[2]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[3])));
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            webPartImportDtoParamTwo = BeanUtil.copy(webPartImportDtoParam, MachinePartImportDtoParam.class);
            webPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W2");
         }
      }

      if (specPrefix.equals("WI")) {
         if (specList.length == 6) {
            foilPartImportDtoParamOne.setSpecPrefix("PL");
            foilPartImportDtoParamOne.setName("翼板");
            foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
            foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
            foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
            foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
            foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
            foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[4] + "*" + specList[5]);
            foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[4]));
            foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[5]));
            webPartImportDtoParam.setSpecPrefix("PL");
            webPartImportDtoParam.setName("腹板");
            webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
            webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
            webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
            webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
            webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
            webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
            webPartImportDtoParam.setSpecification(
               webPartImportDtoParam.getSpecPrefix() + specList[1] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[4]))
            );
            webPartImportDtoParam.setThickness(new BigDecimal(specList[1]));
            webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[4])));
            foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
            foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
         }

         if (specList.length == 4) {
            if (assembleImportDtoParam.getSpecification().contains("-")) {
               foilPartImportDtoParamOne.setSpecPrefix("PL");
               foilPartImportDtoParamOne.setName("翼板");
               foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
               foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
               foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
               foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
               foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[2] + "*" + specList[3]);
               foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[2]));
               foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[3]));
               foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
               foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
               webPartImportDtoParam.setSpecPrefix("PL");
               webPartImportDtoParam.setName("腹板");
               webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
               webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
               webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
               webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
               webPartImportDtoParam.setSpecification(
                  webPartImportDtoParam.getSpecPrefix() + specList[1] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[2]))
               );
               webPartImportDtoParam.setThickness(new BigDecimal(specList[1]));
               webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[2])));
               webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
               webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
               foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
               foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            } else {
               foilPartImportDtoParamOne.setSpecPrefix("PL");
               foilPartImportDtoParamOne.setName("翼板");
               foilPartImportDtoParamOne.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F1");
               foilPartImportDtoParamOne.setInitialSerialNumber(foilPartImportDtoParamOne.getSerialNumber());
               foilPartImportDtoParamOne.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
               foilPartImportDtoParamOne.setQuantity(assembleImportDtoParam.getQuantity());
               foilPartImportDtoParamOne.setSpecification(foilPartImportDtoParamOne.getSpecPrefix() + specList[3] + "*" + specList[1]);
               foilPartImportDtoParamOne.setThickness(new BigDecimal(specList[3]));
               foilPartImportDtoParamOne.setWidth(new BigDecimal(specList[1]));
               foilPartImportDtoParamOne.setLength(assembleImportDtoParam.getLength());
               foilPartImportDtoParamOne.setMaterial(assembleImportDtoParam.getMaterial());
               webPartImportDtoParam.setSpecPrefix("PL");
               webPartImportDtoParam.setName("腹板");
               webPartImportDtoParam.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "W1");
               webPartImportDtoParam.setInitialSerialNumber(webPartImportDtoParam.getSerialNumber());
               webPartImportDtoParam.setSourcePartEnum(SourcePartEnum.COMPONENT_DISASSEMBLY.getType());
               webPartImportDtoParam.setQuantity(assembleImportDtoParam.getQuantity());
               webPartImportDtoParam.setSpecification(
                  webPartImportDtoParam.getSpecPrefix() + specList[2] + "*" + (Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[3]))
               );
               webPartImportDtoParam.setThickness(new BigDecimal(specList[2]));
               webPartImportDtoParam.setWidth(new BigDecimal(Double.valueOf(specList[0]) - 2.0 * Double.valueOf(specList[3])));
               webPartImportDtoParam.setLength(assembleImportDtoParam.getLength());
               webPartImportDtoParam.setMaterial(assembleImportDtoParam.getMaterial());
               foilPartImportDtoParamTwo = BeanUtil.copy(foilPartImportDtoParamOne, MachinePartImportDtoParam.class);
               foilPartImportDtoParamTwo.setSerialNumber(assembleImportDtoParam.getSerialNumber() + "F2");
            }
         }
      }

      if (StringUtils.isNotBlank(foilPartImportDtoParamOne.getName())) {
         double foilT = Double.parseDouble(String.valueOf(foilPartImportDtoParamOne.getThickness()));
         double foilW = Double.parseDouble(String.valueOf(foilPartImportDtoParamOne.getWidth()));
         double foilL = Double.parseDouble(String.valueOf(foilPartImportDtoParamOne.getLength()));
         foilPartImportDtoParamOne.setNetWeight(
            BigDecimal.valueOf(Math.round(foilT * foilW * foilL * 7.85 / 1000000.0 * 100.0) / 100.0).setScale(3, RoundingMode.HALF_UP)
         );
         foilPartImportDtoParamOne.setTotalNetWeight(
            foilPartImportDtoParamOne.getNetWeight().multiply(BigDecimal.valueOf(foilPartImportDtoParamOne.getQuantity().intValue()))
         );
         foilPartImportDtoParamOne.setGrossWeight(foilPartImportDtoParamOne.getNetWeight());
         foilPartImportDtoParamOne.setTotalGrossWeight(foilPartImportDtoParamOne.getTotalNetWeight());
         foilPartImportDtoParamOne.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECONDARY_MEMBER.getType());
         foilPartImportDtoParamOne.setRelationType(MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType());
         if (!CollectionUtils.isEmpty(steelClassSpecNameLinkMap)
            && steelClassSpecNameLinkMap.get(foilPartImportDtoParamOne.getSpecPrefix()) != null
            && steelClassSpecNameLinkMap.get(foilPartImportDtoParamOne.getSpecPrefix()).get(foilPartImportDtoParamOne.getName()) != null) {
            foilPartImportDtoParamOne.setSteelId(
               steelClassSpecNameLinkMap.get(foilPartImportDtoParamOne.getSpecPrefix()).get(foilPartImportDtoParamOne.getName())
            );
         }

         foilPartImportDtoParamOne.setProductClassificationEnum(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType());
         foilPartImportDtoParamOne.setBoolSendDirectly(Boolean.FALSE);
         foilPartImportDtoParamOne.setBoolAllPartSendDirectly(Boolean.FALSE);
         secondaryMemberPartImportDtoParam.add(foilPartImportDtoParamOne);
      }

      if (StringUtils.isNotBlank(foilPartImportDtoParamTwo.getName())) {
         double foilTwoT = Double.parseDouble(String.valueOf(foilPartImportDtoParamTwo.getThickness()));
         double foilTwoW = Double.parseDouble(String.valueOf(foilPartImportDtoParamTwo.getWidth()));
         double foilTwoL = Double.parseDouble(String.valueOf(foilPartImportDtoParamTwo.getLength()));
         foilPartImportDtoParamTwo.setNetWeight(
            BigDecimal.valueOf(Math.round(foilTwoT * foilTwoW * foilTwoL * 7.85 / 1000000.0 * 100.0) / 100.0).setScale(3, RoundingMode.HALF_UP)
         );
         foilPartImportDtoParamTwo.setTotalNetWeight(
            foilPartImportDtoParamTwo.getNetWeight().multiply(BigDecimal.valueOf(foilPartImportDtoParamTwo.getQuantity().intValue()))
         );
         foilPartImportDtoParamTwo.setGrossWeight(foilPartImportDtoParamTwo.getNetWeight());
         foilPartImportDtoParamTwo.setTotalGrossWeight(foilPartImportDtoParamTwo.getTotalNetWeight());
         foilPartImportDtoParamTwo.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECONDARY_MEMBER.getType());
         foilPartImportDtoParamTwo.setRelationType(MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType());
         if (!CollectionUtils.isEmpty(steelClassSpecNameLinkMap)
            && steelClassSpecNameLinkMap.get(foilPartImportDtoParamTwo.getSpecPrefix()) != null
            && steelClassSpecNameLinkMap.get(foilPartImportDtoParamOne.getSpecPrefix()).get(foilPartImportDtoParamOne.getName()) != null) {
            foilPartImportDtoParamTwo.setSteelId(
               steelClassSpecNameLinkMap.get(foilPartImportDtoParamTwo.getSpecPrefix()).get(foilPartImportDtoParamTwo.getName())
            );
         }

         foilPartImportDtoParamTwo.setProductClassificationEnum(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType());
         foilPartImportDtoParamTwo.setBoolSendDirectly(Boolean.FALSE);
         foilPartImportDtoParamTwo.setBoolAllPartSendDirectly(Boolean.FALSE);
         secondaryMemberPartImportDtoParam.add(foilPartImportDtoParamTwo);
      }

      if (StringUtils.isNotBlank(webPartImportDtoParam.getName())) {
         double webT = Double.parseDouble(String.valueOf(webPartImportDtoParam.getThickness()));
         double webW = Double.parseDouble(String.valueOf(webPartImportDtoParam.getWidth()));
         double webL = Double.parseDouble(String.valueOf(webPartImportDtoParam.getLength()));
         webPartImportDtoParam.setNetWeight(
            BigDecimal.valueOf(Math.round(webT * webW * webL * 7.85 / 1000000.0 * 100.0) / 100.0).setScale(3, RoundingMode.HALF_UP)
         );
         webPartImportDtoParam.setTotalNetWeight(
            webPartImportDtoParam.getNetWeight().multiply(BigDecimal.valueOf(webPartImportDtoParam.getQuantity().intValue()))
         );
         webPartImportDtoParam.setGrossWeight(webPartImportDtoParam.getNetWeight());
         webPartImportDtoParam.setTotalGrossWeight(webPartImportDtoParam.getTotalNetWeight());
         webPartImportDtoParam.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECONDARY_MEMBER.getType());
         webPartImportDtoParam.setRelationType(MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType());
         if (!CollectionUtils.isEmpty(steelClassSpecNameLinkMap)
            && steelClassSpecNameLinkMap.get(foilPartImportDtoParamOne.getSpecPrefix()) != null
            && steelClassSpecNameLinkMap.get(foilPartImportDtoParamOne.getSpecPrefix()).get(webPartImportDtoParam.getName()) != null) {
            webPartImportDtoParam.setSteelId(steelClassSpecNameLinkMap.get(foilPartImportDtoParamOne.getSpecPrefix()).get(webPartImportDtoParam.getName()));
         }

         webPartImportDtoParam.setProductClassificationEnum(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType());
         webPartImportDtoParam.setBoolSendDirectly(Boolean.FALSE);
         webPartImportDtoParam.setBoolAllPartSendDirectly(Boolean.FALSE);
         secondaryMemberPartImportDtoParam.add(webPartImportDtoParam);
      }

      if (StringUtils.isNotBlank(webPartImportDtoParamTwo.getName())) {
         double webT = Double.parseDouble(String.valueOf(webPartImportDtoParamTwo.getThickness()));
         double webW = Double.parseDouble(String.valueOf(webPartImportDtoParamTwo.getWidth()));
         double webL = Double.parseDouble(String.valueOf(webPartImportDtoParamTwo.getLength()));
         webPartImportDtoParamTwo.setNetWeight(
            BigDecimal.valueOf(Math.round(webT * webW * webL * 7.85 / 1000000.0 * 100.0) / 100.0).setScale(3, RoundingMode.HALF_UP)
         );
         webPartImportDtoParamTwo.setTotalNetWeight(
            webPartImportDtoParamTwo.getNetWeight().multiply(BigDecimal.valueOf(webPartImportDtoParamTwo.getQuantity().intValue()))
         );
         webPartImportDtoParamTwo.setGrossWeight(webPartImportDtoParamTwo.getNetWeight());
         webPartImportDtoParamTwo.setTotalGrossWeight(webPartImportDtoParamTwo.getTotalNetWeight());
         webPartImportDtoParamTwo.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECONDARY_MEMBER.getType());
         webPartImportDtoParamTwo.setRelationType(MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType());
         if (!CollectionUtils.isEmpty(steelClassSpecNameLinkMap)
            && steelClassSpecNameLinkMap.get(foilPartImportDtoParamOne.getSpecPrefix()) != null
            && steelClassSpecNameLinkMap.get(foilPartImportDtoParamOne.getSpecPrefix()).get(webPartImportDtoParamTwo.getName()) != null) {
            webPartImportDtoParamTwo.setSteelId(
               steelClassSpecNameLinkMap.get(foilPartImportDtoParamOne.getSpecPrefix()).get(webPartImportDtoParamTwo.getName())
            );
         }

         webPartImportDtoParamTwo.setProductClassificationEnum(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType());
         webPartImportDtoParamTwo.setBoolSendDirectly(Boolean.FALSE);
         webPartImportDtoParamTwo.setBoolAllPartSendDirectly(Boolean.FALSE);
         secondaryMemberPartImportDtoParam.add(webPartImportDtoParamTwo);
      }

      return secondaryMemberPartImportDtoParam;
   }

   @Override
   public List<ArtifactBoxImportDTO> getArtifactBoxImportDTOS(
      MultipartFile file,
      Integer inventoryTypeEnum,
      HttpServletResponse response,
      List<MistakeExportDTO> mistakeExportDTOList,
      TechConfigUtilsDTO utilsDTO,
      Long monomerId,
      Integer importType
   ) {
      if (InventoryTypeEnum.MES.getType().equals(inventoryTypeEnum)) {
         List<ZnljArtifactMachinePartImportTemplateDtoParam> importDTOS;
         try {
            importDTOS = PoiUtils.importExcel(file, 0, 1, 0, ZnljArtifactMachinePartImportTemplateDtoParam.class);
         } catch (Exception e) {
            mistakeExportDTOList.add(TechUtils.buildMistakeDTO("导入失败,Excel文件格式出现异常!"));
            return null;
         }

         for (ZnljArtifactMachinePartImportTemplateDtoParam importDTO : importDTOS) {
            if (importDTO.getOrderNo() == null && (importDTO.getName() != null || importDTO.getSerialNumber() != null || importDTO.getSpecification() != null)) {
               mistakeExportDTOList.add(TechUtils.buildMistakeDTO("导入失败,表单的序号不能为空!"));
            }
         }

         if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
            return null;
         } else {
            importDTOS = importDTOS.stream().filter(importDTOx -> importDTOx.getOrderNo() != null).collect(Collectors.toList());
            if (CollectionUtils.isEmpty(importDTOS)) {
               mistakeExportDTOList.add(TechUtils.buildMistakeDTO("导入失败,导入的表单不能为空!"));
               return null;
            } else {
               return this.inventoryMesManager.getMesConversionList(mistakeExportDTOList, importDTOS, utilsDTO, monomerId, importType);
            }
         }
      } else if (InventoryTypeEnum.BRIDGE.getType().equals(inventoryTypeEnum)) {
         List<ZnljBridgeImportTemplateDtoParam> importDTOS;
         try {
            importDTOS = PoiUtils.importExcel(file, 0, 1, 0, ZnljBridgeImportTemplateDtoParam.class);
         } catch (Exception e) {
            mistakeExportDTOList.add(TechUtils.buildMistakeDTO("导入失败,Excel文件格式出现异常!"));
            return null;
         }

         for (ZnljBridgeImportTemplateDtoParam importDTO : importDTOS) {
            if (importDTO.getOrderNo() == null
               && (
                  importDTO.getName() != null
                     || importDTO.getSerialNumber() != null
                     || importDTO.getElementNo() != null
                     || importDTO.getSpecification() != null
               )) {
               mistakeExportDTOList.add(TechUtils.buildMistakeDTO("导入失败,表单的序号不能为空!"));
            }
         }

         if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
            return null;
         } else {
            importDTOS = importDTOS.stream().filter(importTemplate -> importTemplate.getOrderNo() != null).collect(Collectors.toList());
            if (CollectionUtils.isEmpty(importDTOS)) {
               mistakeExportDTOList.add(TechUtils.buildMistakeDTO("导入失败,导入的表单不能为空!"));
               return null;
            } else {
               return this.inventoryBridgeManager.getBridgeConversionList(mistakeExportDTOList, importDTOS, utilsDTO, monomerId, importType);
            }
         }
      } else {
         if (!InventoryTypeEnum.GRID.getType().equals(inventoryTypeEnum)) {
            return null;
         }

         List<ZnljGridImportTemplateDtoParam> importDTOS;
         try {
            importDTOS = PoiUtils.importExcel(file, 0, 1, 0, ZnljGridImportTemplateDtoParam.class);
         } catch (Exception e) {
            mistakeExportDTOList.add(TechUtils.buildMistakeDTO("导入失败,Excel文件格式出现异常!"));
            return null;
         }

         for (ZnljGridImportTemplateDtoParam importDTO : importDTOS) {
            if (importDTO.getOrderNo() == null && (importDTO.getName() != null || importDTO.getSerialNumber() != null || importDTO.getSpecification() != null)) {
               mistakeExportDTOList.add(TechUtils.buildMistakeDTO("导入失败,表单的序号不能为空!"));
            }
         }

         if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
            return null;
         } else {
            importDTOS = importDTOS.stream().filter(importDTOx -> importDTOx.getOrderNo() != null).collect(Collectors.toList());
            if (CollectionUtils.isEmpty(importDTOS)) {
               mistakeExportDTOList.add(TechUtils.buildMistakeDTO("导入失败,导入的表单不能为空!"));
               return null;
            } else {
               return this.inventoryGridManager.getGridConversionList(mistakeExportDTOList, importDTOS, utilsDTO, monomerId, importType);
            }
         }
      }
   }

   private void checkImportPartEqual(
      MachinePartImportDtoParam importMachinePart,
      MachinePartImportDtoParam machinePartImportDtoParam,
      Map<Integer, InventoryConfigurationDetailDTO> configurationDetailDTOMap,
      List<MistakeExportDTO> mistakeExportDTOList
   ) {
      InventoryConfigurationDetailDTO configurationDetailDTO = configurationDetailDTOMap.get(ProductTypeEnum.MACHINE_PART.getType());
      if (!importMachinePart.getSpecification().equals(machinePartImportDtoParam.getSpecification())) {
         if (importMachinePart.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECTIONSTEEL.getType())) {
            mistakeExportDTOList.add(
               new MistakeExportDTO(machinePartImportDtoParam.getOrderNo(), "零件规格和同清单内相同编号零件规格不一致,对比的序号是" + importMachinePart.getOrderNo())
            );
         }

         if (importMachinePart.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.PRIMARY_MEMBER.getType())) {
            String partThick = TechUtils.getMachinePartThick(importMachinePart.getSpecification());
            String width = importMachinePart.getSpecification().split("\\*")[1];
            String partDTOThick = TechUtils.getMachinePartThick(machinePartImportDtoParam.getSpecification());
            String[] split = machinePartImportDtoParam.getSpecification().split("\\*");
            if (split.length != 2) {
               mistakeExportDTOList.add(
                  new MistakeExportDTO(machinePartImportDtoParam.getOrderNo(), "零件规格和同清单内相同编号零件规格不一致,对比的序号是" + importMachinePart.getOrderNo())
               );
            } else {
               String partDTOWidth = machinePartImportDtoParam.getSpecification().split("\\*")[1];
               BigDecimal thickSubtract = new BigDecimal(partThick).subtract(new BigDecimal(partDTOThick));
               if (configurationDetailDTO.getThickness().compareTo(thickSubtract.compareTo(BigDecimal.ZERO) < 0 ? thickSubtract.negate() : thickSubtract) < 0) {
                  mistakeExportDTOList.add(
                     new MistakeExportDTO(machinePartImportDtoParam.getOrderNo(), "零件规格和同清单内相同编号零件厚度不一致(超出误差范围),对比的序号是" + importMachinePart.getOrderNo())
                  );
               }

               BigDecimal widthSubtract = new BigDecimal(width).subtract(new BigDecimal(partDTOWidth));
               if (configurationDetailDTO.getWidth().compareTo(widthSubtract.compareTo(BigDecimal.ZERO) < 0 ? widthSubtract.negate() : widthSubtract) < 0) {
                  mistakeExportDTOList.add(
                     new MistakeExportDTO(machinePartImportDtoParam.getOrderNo(), "零件规格和同清单内相同编号零件宽度不一致(超出误差范围),对比的序号是" + importMachinePart.getOrderNo())
                  );
               }
            }
         }
      }

      if (!importMachinePart.getMaterial().equals(machinePartImportDtoParam.getMaterial())) {
         mistakeExportDTOList.add(new MistakeExportDTO(machinePartImportDtoParam.getOrderNo(), "零件材质和同清单内相同编号零件材质不一致,对比的序号是" + importMachinePart.getOrderNo()));
      }

      if (!importMachinePart.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
         && importMachinePart.getLength().setScale(0, RoundingMode.HALF_UP).compareTo(machinePartImportDtoParam.getLength().setScale(0, RoundingMode.HALF_UP))
            != 0) {
         BigDecimal negate = importMachinePart.getLength().subtract(machinePartImportDtoParam.getLength());
         if (configurationDetailDTO.getLength().compareTo(negate.compareTo(BigDecimal.ZERO) < 0 ? negate.negate() : negate) < 0) {
            mistakeExportDTOList.add(
               new MistakeExportDTO(machinePartImportDtoParam.getOrderNo(), "零件长度和同清单内相同编号零件长度不一致(超出误差范围),对比的序号是" + importMachinePart.getOrderNo())
            );
         }
      }

      if (!importMachinePart.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
         && importMachinePart.getNetWeight()
               .setScale(1, RoundingMode.HALF_UP)
               .compareTo(machinePartImportDtoParam.getNetWeight().setScale(1, RoundingMode.HALF_UP))
            != 0) {
         BigDecimal negate = importMachinePart.getNetWeight().subtract(machinePartImportDtoParam.getNetWeight());
         if (configurationDetailDTO.getNetWeight().compareTo(negate.compareTo(BigDecimal.ZERO) < 0 ? negate.negate() : negate) < 0) {
            mistakeExportDTOList.add(
               new MistakeExportDTO(machinePartImportDtoParam.getOrderNo(), "零件单净重和同清单内相同编号零件单净重不一致(超出误差范围),对比的序号是" + importMachinePart.getOrderNo())
            );
         }
      }

      if (!importMachinePart.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
         && importMachinePart.getSurfaceArea().compareTo(BigDecimal.ZERO) != 0
         && machinePartImportDtoParam.getSurfaceArea().compareTo(BigDecimal.ZERO) != 0) {
         boolean boolEqual = importMachinePart.getSurfaceArea()
               .divide(BigDecimal.valueOf(1000000L), 1, RoundingMode.HALF_UP)
               .compareTo(machinePartImportDtoParam.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 1, RoundingMode.HALF_UP))
            == 0;
         if (!boolEqual) {
            BigDecimal negate = importMachinePart.getSurfaceArea().subtract(machinePartImportDtoParam.getSurfaceArea());
            if (configurationDetailDTO.getSurfaceArea().compareTo(negate.compareTo(BigDecimal.ZERO) < 0 ? negate.negate() : negate) < 0) {
               mistakeExportDTOList.add(
                  new MistakeExportDTO(machinePartImportDtoParam.getOrderNo(), "零件面积和同清单内相同编号零件面积不一致(超出误差范围),对比的序号是" + importMachinePart.getOrderNo())
               );
            }
         }
      }
   }

   private void checkImportAssembleEqual(
      InventoryAssembleImportDTO assembleDtoParam,
      InventoryAssembleImportDTO assembleImportDtoParam,
      Map<Integer, InventoryConfigurationDetailDTO> configurationDetailDTOMap,
      List<MistakeExportDTO> mistakeExportDTOList
   ) {
      InventoryConfigurationDetailDTO configurationDetailDTO = configurationDetailDTOMap.get(ProductTypeEnum.ASSEMBLE.getType());
      if (!assembleDtoParam.getSpecification().equals(assembleImportDtoParam.getSpecification())) {
         mistakeExportDTOList.add(new MistakeExportDTO(assembleImportDtoParam.getOrderNo(), "部件规格和同清单内相同编号部件规格不一致,对比的序号是" + assembleDtoParam.getOrderNo()));
      }

      if (!assembleDtoParam.getMaterial().equals(assembleImportDtoParam.getMaterial())) {
         mistakeExportDTOList.add(new MistakeExportDTO(assembleImportDtoParam.getOrderNo(), "部件材质和同清单内相同编号部件材质不一致,对比的序号是" + assembleDtoParam.getOrderNo()));
      }

      if (assembleDtoParam.getLength().setScale(0, RoundingMode.HALF_UP).compareTo(assembleImportDtoParam.getLength().setScale(0, RoundingMode.HALF_UP)) != 0) {
         BigDecimal negate = assembleDtoParam.getLength().subtract(assembleImportDtoParam.getLength());
         if (configurationDetailDTO.getLength().compareTo(negate.compareTo(BigDecimal.ZERO) < 0 ? negate.negate() : negate) < 0) {
            mistakeExportDTOList.add(
               new MistakeExportDTO(assembleImportDtoParam.getOrderNo(), "部件长度和同清单内相同编号部件长度不一致(超过误差范围),对比的序号是" + assembleDtoParam.getOrderNo())
            );
         }
      }

      if (assembleDtoParam.getNetWeight().setScale(1, RoundingMode.HALF_UP).compareTo(assembleImportDtoParam.getNetWeight().setScale(1, RoundingMode.HALF_UP))
         != 0) {
         BigDecimal negate = assembleDtoParam.getNetWeight().subtract(assembleImportDtoParam.getNetWeight());
         if (configurationDetailDTO.getNetWeight().compareTo(negate.compareTo(BigDecimal.ZERO) < 0 ? negate.negate() : negate) < 0) {
            mistakeExportDTOList.add(
               new MistakeExportDTO(assembleImportDtoParam.getOrderNo(), "部件单净重和同清单内相同编号部件单净重不一致(超过误差范围),对比的序号是" + assembleDtoParam.getOrderNo())
            );
         }
      }

      if (assembleDtoParam.getSurfaceArea().compareTo(BigDecimal.ZERO) != 0 && assembleImportDtoParam.getSurfaceArea().compareTo(BigDecimal.ZERO) != 0) {
         boolean boolEqual = assembleDtoParam.getSurfaceArea()
               .divide(BigDecimal.valueOf(1000000L), 1, RoundingMode.HALF_UP)
               .compareTo(assembleImportDtoParam.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 1, RoundingMode.HALF_UP))
            == 0;
         if (!boolEqual) {
            BigDecimal negate = assembleDtoParam.getSurfaceArea().subtract(assembleImportDtoParam.getSurfaceArea());
            if (configurationDetailDTO.getSurfaceArea().compareTo(negate.compareTo(BigDecimal.ZERO) < 0 ? negate.negate() : negate) < 0) {
               mistakeExportDTOList.add(
                  new MistakeExportDTO(assembleImportDtoParam.getOrderNo(), "部件面积和同清单内相同编号部件面积不一致(超过误差范围),对比的序号是" + assembleDtoParam.getOrderNo())
               );
            }
         }
      }
   }

   @Override
   public void buildAssemblePartLinks(
      List<TechArtifactMachinePartLinkRecord> artifactMachinePartLinkList,
      List<TechMachinePartRecord> newMachinePartList,
      List<TechArtifactSpecAmend> specAmendList,
      TechAssemblyAutomaticCombinationVO automaticCombinationVO
   ) {
      AtomicReference<Boolean> flag = new AtomicReference<>(Boolean.FALSE);
      List<TemplatePanelAssemblyConfigVO> assemblyConfigList = automaticCombinationVO.getTemplatePanelAssemblyConfigVOS();
      Map<Long, SysStructureSpec> stringSysStructureSpecMap = this.sysStructureSpecService
         .list(
            (Wrapper<SysStructureSpec>)(new LambdaQueryWrapper<SysStructureSpec>()
                  .in(
                     SysStructureSpec::getStructureClassificationId,
                     assemblyConfigList.stream().map(TemplatePanelAssemblyConfigVO::getStructureClassificationId).collect(Collectors.toList())
                  ))
               .in(SysStructureSpec::getSpecPrefix, "BH", "BOX")
         )
         .stream()
         .collect(Collectors.toMap(SysStructureSpec::getStructureClassificationId, Function.identity()));
      Map<String, SysAssembleSpec> sysAssembleSpecMap = this.sysAssembleSpecService
         .list((Wrapper<SysAssembleSpec>)new LambdaQueryWrapper<SysAssembleSpec>().in(SysAssembleSpec::getSpecPrefix, "BH", "BOX"))
         .stream()
         .collect(Collectors.toMap(SysAssembleSpec::getSpecPrefix, Function.identity()));
      Map<Long, List<TechArtifactMachinePartLinkRecord>> partLinkRecordMap = artifactMachinePartLinkList.stream()
         .collect(Collectors.groupingBy(TechArtifactMachinePartLinkRecord::getArtifactRecordId));
      Map<Long, TechMachinePartRecord> techMachinePartRecordMap = newMachinePartList.stream()
         .filter(
            e -> e.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.PRIMARY_MEMBER.getType()) && !e.getBoolSendDirectly() && !e.getBoolAllPartSendDirectly()
         )
         .collect(Collectors.toMap(TechMachinePartRecord::getId, Function.identity()));
      Map<String, List<TechMachinePartRecord>> oldMachinePartRecordMap = this.machinePartRecordService
         .list(
            (Wrapper<TechMachinePartRecord>)new LambdaQueryWrapper<TechMachinePartRecord>()
               .eq(TechMachinePartRecord::getInventoryOperationId, automaticCombinationVO.getInventoryOperationId())
         )
         .stream()
         .collect(Collectors.groupingBy(e -> e.getName() + "-" + e.getSerialNumber()));
      specAmendList.forEach(
         artifactSpecAmend -> {
            List<TechArtifactMachinePartLinkRecord> techArtifactMachinePartLinkRecords = partLinkRecordMap.get(artifactSpecAmend.getArtifactId());
            Map<Long, TechArtifactMachinePartLinkRecord> machinePartLinkRecordMap = techArtifactMachinePartLinkRecords.stream()
               .collect(Collectors.toMap(TechArtifactMachinePartLinkRecord::getMachinePartRecordId, Function.identity()));
            Map<String, List<TechMachinePartRecord>> machinePartRecordMap = null;
            if (automaticCombinationVO.getRangeOfActionEnum().equals(RangeOfActionEnum.SERIAL_NUMBER.getType())) {
               machinePartRecordMap = techArtifactMachinePartLinkRecords.stream()
                  .map(e -> techMachinePartRecordMap.get(e.getMachinePartRecordId()))
                  .filter(Objects::nonNull)
                  .filter(e -> StringUtils.isNotBlank(e.getSerialNumber()))
                  .collect(Collectors.groupingBy(e -> {
                     String regex = "[a-zA-Z]+";
                     Pattern pattern = Pattern.compile(regex);
                     Matcher matcher = pattern.matcher(e.getSerialNumber());
                     return matcher.find() ? matcher.group() : "";
                  }));
            }

            if (automaticCombinationVO.getRangeOfActionEnum().equals(RangeOfActionEnum.REMARK.getType())) {
               machinePartRecordMap = techArtifactMachinePartLinkRecords.stream()
                  .map(e -> techMachinePartRecordMap.get(e.getMachinePartRecordId()))
                  .filter(Objects::nonNull)
                  .filter(e -> StringUtils.isNotBlank(e.getRemark()))
                  .collect(Collectors.groupingBy(TechMachinePartRecord::getRemark));
            }

            if (CollectionUtils.isNotEmpty(machinePartRecordMap) && machinePartRecordMap.size() > 1) {
               Map<String, List<TechMachinePartRecord>> finalMachinePartRecordMap = machinePartRecordMap;

               for (TemplatePanelAssemblyConfigVO configVO : assemblyConfigList) {
                  if (!CollectionUtils.isEmpty(configVO.getArtifactPartNumberPrefixList())) {
                     SysStructureSpec sysStructureSpec = stringSysStructureSpecMap.get(configVO.getStructureClassificationId());
                     if (sysStructureSpec != null) {
                        List<String> webPartNumberPrefixList = configVO.getWebPartNumberPrefixList();
                        List<String> sailPartNumberPrefixList = configVO.getSailPartNumberPrefixList();
                        if (!CollectionUtils.isEmpty(webPartNumberPrefixList) && !CollectionUtils.isEmpty(sailPartNumberPrefixList)) {
                           String webPartNumberPrefix = webPartNumberPrefixList.get(0);
                           String sailPartNumberPrefix = sailPartNumberPrefixList.get(0);
                           List<String> partNumberPrefixList = configVO.getArtifactPartNumberPrefixList();
                           if (partNumberPrefixList.stream().allMatch(finalMachinePartRecordMap::containsKey)) {
                              List<TechMachinePartRecord> webParts = finalMachinePartRecordMap.get(webPartNumberPrefix);
                              List<TechMachinePartRecord> sailParts = finalMachinePartRecordMap.get(sailPartNumberPrefix);
                              if (!CollectionUtils.isEmpty(webParts) && !CollectionUtils.isEmpty(sailParts)) {
                                 List<TechMachinePartRecord> machinePartRecords = new ArrayList<>();
                                 if (sysStructureSpec.getSpecPrefix().equals("BH")) {
                                    if (CollectionUtils.isNotEmpty(webParts)
                                       && CollectionUtils.isNotEmpty(sailParts)
                                       && webParts.size() == 1
                                       && sailParts.size() <= 3) {
                                       machinePartRecords.addAll(webParts);
                                       machinePartRecords.addAll(sailParts);
                                       TechMachinePartRecord webPartRecord = webParts.get(0);
                                       if (sailParts.stream()
                                             .allMatch(
                                                e -> machinePartLinkRecordMap.get(e.getId())
                                                   .getQuantity()
                                                   .equals(machinePartLinkRecordMap.get(webPartRecord.getId()).getQuantity())
                                             )
                                          || sailParts.stream()
                                             .allMatch(
                                                e -> machinePartLinkRecordMap.get(e.getId()).getQuantity()
                                                   > machinePartLinkRecordMap.get(webPartRecord.getId()).getQuantity()
                                             )) {
                                          Integer proportionQuantity = machinePartLinkRecordMap.get(webPartRecord.getId()).getQuantity();
                                          SysAssembleSpec sysAssembleSpec = sysAssembleSpecMap.get(sysStructureSpec.getSpecPrefix());
                                          Preconditions.checkArgument(sysAssembleSpec != null, "导入失败,部件未配置BH规格前缀");
                                          TechAssembleRecord techAssembleRecord = new TechAssembleRecord();
                                          techAssembleRecord.setBooInventory(false);
                                          techAssembleRecord.setProjectId(artifactSpecAmend.getProjectId());
                                          techAssembleRecord.setMonomerId(artifactSpecAmend.getMonomerId());
                                          techAssembleRecord.setAreaId(artifactSpecAmend.getAreaId());
                                          techAssembleRecord.setAreaBatchId(artifactSpecAmend.getAreaBatchId());
                                          techAssembleRecord.setInventoryOperationId(artifactSpecAmend.getInventoryOperationId());
                                          techAssembleRecord.setSerialNumber("组" + webPartRecord.getSerialNumber());
                                          List<TechAssembleRecord> oldAssembleRecords = this.artifactService
                                             .getAssembleRecordList(
                                                artifactSpecAmend.getMonomerId(),
                                                artifactSpecAmend.getAreaId(),
                                                techAssembleRecord.getSerialNumber(),
                                                artifactSpecAmend.getInventoryOperationId()
                                             );
                                          if (CollectionUtils.isNotEmpty(oldAssembleRecords)) {
                                             techAssembleRecord.setSerialNumber(techAssembleRecord.getSerialNumber() + "-" + oldAssembleRecords.size());
                                          }

                                          techAssembleRecord.setLength(webPartRecord.getLength());
                                          techAssembleRecord.setMaterial(webPartRecord.getMaterial());
                                          BigDecimal netWeight = machinePartRecords.stream()
                                             .map(
                                                record -> record.getNetWeight()
                                                   .multiply(
                                                      new BigDecimal(
                                                         artifactSpecAmend.getQuantity()
                                                            * machinePartLinkRecordMap.get(record.getId()).getQuantity()
                                                            / (proportionQuantity * artifactSpecAmend.getQuantity())
                                                      )
                                                   )
                                             )
                                             .reduce(BigDecimal.ZERO, BigDecimal::add);
                                          BigDecimal grossWeight = machinePartRecords.stream()
                                             .map(
                                                record -> record.getGrossWeight()
                                                   .multiply(
                                                      new BigDecimal(
                                                         artifactSpecAmend.getQuantity()
                                                            * machinePartLinkRecordMap.get(record.getId()).getQuantity()
                                                            / (proportionQuantity * artifactSpecAmend.getQuantity())
                                                      )
                                                   )
                                             )
                                             .reduce(BigDecimal.ZERO, BigDecimal::add);
                                          techAssembleRecord.setQuantity(proportionQuantity * artifactSpecAmend.getQuantity());
                                          techAssembleRecord.setNetWeight(netWeight);
                                          techAssembleRecord.setTotalNetWeight(
                                             techAssembleRecord.getNetWeight().multiply(new BigDecimal(techAssembleRecord.getQuantity()))
                                          );
                                          techAssembleRecord.setGrossWeight(grossWeight);
                                          techAssembleRecord.setTotalGrossWeight(
                                             techAssembleRecord.getGrossWeight().multiply(new BigDecimal(techAssembleRecord.getQuantity()))
                                          );
                                          techAssembleRecord.setSurfaceArea(webPartRecord.getSurfaceArea());
                                          techAssembleRecord.setSpecPrefix(sysStructureSpec.getSpecPrefix());
                                          String newSpecification = webPartRecord.getWidth()
                                             + "*"
                                             + webPartRecord.getThick()
                                             + "*"
                                             + sailParts.get(0).getWidth()
                                             + "*"
                                             + sailParts.get(0).getThick();
                                          techAssembleRecord.setSpecification(sysStructureSpec.getSpecPrefix() + newSpecification);
                                          techAssembleRecord.setAssembleConfigId(sysAssembleSpec.getAssembleConfigId());
                                          techAssembleRecord.setAssembleType(ProductClassificationEnum.ASSEMBLE.getType());
                                          techAssembleRecord.setUserId(webPartRecord.getUserId());
                                          this.assembleRecordService.save(techAssembleRecord);
                                          TechAssembleDetailRecord techAssembleDetailRecord = new TechAssembleDetailRecord();
                                          techAssembleDetailRecord.setInventoryOperationId(techAssembleRecord.getInventoryOperationId());
                                          techAssembleDetailRecord.setAssembleRecordId(techAssembleRecord.getId());
                                          techAssembleDetailRecord.setArtifactRecordId(artifactSpecAmend.getArtifactId());
                                          techAssembleDetailRecord.setQuantity(techAssembleRecord.getQuantity() / artifactSpecAmend.getQuantity());
                                          techAssembleDetailRecord.setBooInventory(Boolean.FALSE);
                                          this.assembleDetailRecordService.save(techAssembleDetailRecord);
                                          Map<Long, TechMachinePartRecord> partRecordMap = machinePartRecords.stream()
                                             .collect(Collectors.toMap(TechMachinePartRecord::getId, Function.identity()));
                                          machinePartRecords.forEach(
                                             part -> {
                                                TechMachinePartRecord oldTechMachinePartRecord = partRecordMap.get(part.getId());
                                                TechArtifactMachinePartLinkRecord linkRecord = machinePartLinkRecordMap.get(part.getId());
                                                oldTechMachinePartRecord.setQuantity(
                                                   oldTechMachinePartRecord.getQuantity() - linkRecord.getQuantity() * artifactSpecAmend.getQuantity()
                                                );
                                                Preconditions.checkArgument(oldTechMachinePartRecord.getQuantity() >= 0, "操作失败,数量有误!");
                                                oldTechMachinePartRecord.setTotalGrossWeight(
                                                   oldTechMachinePartRecord.getGrossWeight().multiply(new BigDecimal(oldTechMachinePartRecord.getQuantity()))
                                                );
                                                oldTechMachinePartRecord.setTotalNetWeight(
                                                   oldTechMachinePartRecord.getNetWeight().multiply(new BigDecimal(oldTechMachinePartRecord.getQuantity()))
                                                );
                                                this.machinePartRecordService.updateById(oldTechMachinePartRecord);
                                                TechMachinePartRecord techMachinePartRecord = BeanUtil.copy(
                                                   oldTechMachinePartRecord, TechMachinePartRecord.class
                                                );
                                                String webAndSailPartFix = null;
                                                if (automaticCombinationVO.getRangeOfActionEnum().equals(RangeOfActionEnum.SERIAL_NUMBER.getType())) {
                                                   String regex = "[a-zA-Z]+";
                                                   Pattern pattern = Pattern.compile(regex);
                                                   Matcher matcher = pattern.matcher(part.getSerialNumber());
                                                   webAndSailPartFix = matcher.find() ? matcher.group() : null;
                                                   Preconditions.checkArgument(StringUtils.isNotBlank(webAndSailPartFix), "操作失败,编号有误");
                                                }

                                                if (automaticCombinationVO.getRangeOfActionEnum().equals(RangeOfActionEnum.REMARK.getType())) {
                                                   webAndSailPartFix = part.getRemark();
                                                }

                                                if (webPartNumberPrefix.equals(webAndSailPartFix)) {
                                                   techMachinePartRecord.setSerialNumber(part.getSerialNumber() + "-腹");
                                                   techMachinePartRecord.setName("腹板");
                                                   techMachinePartRecord.setInitialSerialNumber(part.getSerialNumber());
                                                   techMachinePartRecord.setSourcePartEnum(SourcePartEnum.COMPONENT_COMBINATION.getType());
                                                } else {
                                                   techMachinePartRecord.setSerialNumber(part.getSerialNumber() + "-翼");
                                                   techMachinePartRecord.setName("翼缘板");
                                                   techMachinePartRecord.setInitialSerialNumber(part.getSerialNumber());
                                                   techMachinePartRecord.setSourcePartEnum(SourcePartEnum.COMPONENT_COMBINATION.getType());
                                                }

                                                List<TechMachinePartRecord> techMachinePartRecordList = oldMachinePartRecordMap.get(
                                                   techMachinePartRecord.getName() + "-" + techMachinePartRecord.getSerialNumber()
                                                );
                                                if (CollectionUtils.isEmpty(techMachinePartRecordList)) {
                                                   techMachinePartRecord.setComboId(part.getComboId());
                                                   techMachinePartRecord.setRelationType(16);
                                                   techMachinePartRecord.setQuantity(artifactSpecAmend.getQuantity() * linkRecord.getQuantity());
                                                   techMachinePartRecord.setTotalGrossWeight(
                                                      techMachinePartRecord.getGrossWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   techMachinePartRecord.setTotalNetWeight(
                                                      techMachinePartRecord.getNetWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   techMachinePartRecord.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECONDARY_MEMBER.getType());
                                                   techMachinePartRecord.setOldMachinePartId(oldTechMachinePartRecord.getId());
                                                   this.machinePartRecordService.save(techMachinePartRecord);
                                                   oldMachinePartRecordMap.put(
                                                      techMachinePartRecord.getName() + "-" + techMachinePartRecord.getSerialNumber(),
                                                      Arrays.asList(techMachinePartRecord)
                                                   );
                                                } else {
                                                   techMachinePartRecord = techMachinePartRecordList.get(0);
                                                   techMachinePartRecord.setQuantity(
                                                      techMachinePartRecord.getQuantity() + artifactSpecAmend.getQuantity() * linkRecord.getQuantity()
                                                   );
                                                   techMachinePartRecord.setTotalGrossWeight(
                                                      techMachinePartRecord.getGrossWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   techMachinePartRecord.setTotalNetWeight(
                                                      techMachinePartRecord.getNetWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   this.machinePartRecordService.updateById(techMachinePartRecord);
                                                }

                                                this.artifactMachinePartLinkRecordService
                                                   .remove(
                                                      (Wrapper<TechArtifactMachinePartLinkRecord>)((new LambdaQueryWrapper<TechArtifactMachinePartLinkRecord>()
                                                               .eq(TechArtifactMachinePartLinkRecord::getMachinePartRecordId, part.getId()))
                                                            .eq(
                                                               TechArtifactMachinePartLinkRecord::getInventoryOperationId,
                                                               artifactSpecAmend.getInventoryOperationId()
                                                            ))
                                                         .eq(TechArtifactMachinePartLinkRecord::getArtifactRecordId, artifactSpecAmend.getArtifactId())
                                                   );
                                                TechAssembleMachinePartLinkRecord techAssembleMachinePartLinkRecord = new TechAssembleMachinePartLinkRecord();
                                                techAssembleMachinePartLinkRecord.setInventoryOperationId(artifactSpecAmend.getInventoryOperationId());
                                                techAssembleMachinePartLinkRecord.setAssembleRecordId(techAssembleRecord.getId());
                                                techAssembleMachinePartLinkRecord.setMachinePartRecordId(techMachinePartRecord.getId());
                                                Integer partQuantity = artifactSpecAmend.getQuantity()
                                                   * linkRecord.getQuantity()
                                                   / techAssembleRecord.getQuantity();
                                                techAssembleMachinePartLinkRecord.setQuantity(partQuantity);
                                                this.assembleMachinePartLinkRecordService.save(techAssembleMachinePartLinkRecord);
                                             }
                                          );
                                          artifactSpecAmend.setNewStructureClassId(configVO.getStructureClassificationId());
                                          artifactSpecAmend.setNewSpecification(techAssembleRecord.getSpecification());
                                          artifactSpecAmend.setNewSpecPrefix(techAssembleRecord.getSpecPrefix());
                                          this.artifactSpecAmendService.updateById(artifactSpecAmend);
                                          flag.set(true);
                                       }
                                    }

                                    if (CollectionUtils.isNotEmpty(webParts)
                                       && CollectionUtils.isNotEmpty(sailParts)
                                       && webParts.size() == 2
                                       && sailParts.size() == 4
                                       && (
                                          sailParts.stream()
                                                .allMatch(
                                                   e -> machinePartLinkRecordMap.get(e.getId())
                                                      .getQuantity()
                                                      .equals(machinePartLinkRecordMap.get(webParts.get(0).getId()).getQuantity())
                                                )
                                             || webParts.stream()
                                                .allMatch(
                                                   e -> machinePartLinkRecordMap.get(e.getId())
                                                      .getQuantity()
                                                      .equals(machinePartLinkRecordMap.get(webParts.get(0).getId()).getQuantity())
                                                )
                                       )) {
                                       List<TechMachinePartRecord> allSailPool = new ArrayList<>(sailParts);
                                       Map<TechMachinePartRecord, List<TechMachinePartRecord>> webMatchSailGroup = new HashMap<>();

                                       for (TechMachinePartRecord webPart : webParts) {
                                          List<TechMachinePartRecord> sortedSail = allSailPool.stream().sorted((sailA, sailB) -> {
                                             BigDecimal diffA = sailA.getLength().subtract(webPart.getLength()).abs();
                                             BigDecimal diffB = sailB.getLength().subtract(webPart.getLength()).abs();
                                             int lenCompare = diffA.compareTo(diffB);
                                             if (lenCompare != 0) {
                                                return lenCompare;
                                             }

                                             BigDecimal weightDiffA = sailA.getNetWeight().subtract(webPart.getNetWeight()).abs();
                                             BigDecimal weightDiffB = sailB.getNetWeight().subtract(webPart.getNetWeight()).abs();
                                             return weightDiffA.compareTo(weightDiffB);
                                          }).collect(Collectors.toList());
                                          List<TechMachinePartRecord> matchPair = new ArrayList<>(sortedSail.subList(0, 2));
                                          webMatchSailGroup.put(webPart, matchPair);
                                          allSailPool.removeIf(matchPair::contains);
                                       }

                                       List<TechAssembleRecord> newAssembleRecords = new ArrayList<>();

                                       for (Entry<TechMachinePartRecord, List<TechMachinePartRecord>> entry : webMatchSailGroup.entrySet()) {
                                          List<TechMachinePartRecord> newMachinePartRecords = new ArrayList<>();
                                          TechMachinePartRecord webPartRecord = entry.getKey();
                                          List<TechMachinePartRecord> twoSails = entry.getValue();
                                          TechMachinePartRecord sail1 = twoSails.get(0);
                                          TechMachinePartRecord sail2 = twoSails.get(1);
                                          newMachinePartRecords.add(webPartRecord);
                                          newMachinePartRecords.addAll(twoSails);
                                          Integer proportionQuantity = machinePartLinkRecordMap.get(webPartRecord.getId()).getQuantity();
                                          SysAssembleSpec sysAssembleSpec = sysAssembleSpecMap.get(sysStructureSpec.getSpecPrefix());
                                          Preconditions.checkArgument(sysAssembleSpec != null, "导入失败,部件未配置BH规格前缀");
                                          TechAssembleRecord techAssembleRecord = new TechAssembleRecord();
                                          techAssembleRecord.setBooInventory(false);
                                          techAssembleRecord.setProjectId(artifactSpecAmend.getProjectId());
                                          techAssembleRecord.setMonomerId(artifactSpecAmend.getMonomerId());
                                          techAssembleRecord.setAreaId(artifactSpecAmend.getAreaId());
                                          techAssembleRecord.setInventoryOperationId(artifactSpecAmend.getInventoryOperationId());
                                          techAssembleRecord.setSerialNumber("组" + webPartRecord.getSerialNumber());
                                          List<TechAssembleRecord> oldAssembleRecords = this.artifactService
                                             .getAssembleRecordList(
                                                artifactSpecAmend.getMonomerId(),
                                                artifactSpecAmend.getAreaId(),
                                                techAssembleRecord.getSerialNumber(),
                                                artifactSpecAmend.getInventoryOperationId()
                                             );
                                          if (CollectionUtils.isNotEmpty(oldAssembleRecords)) {
                                             techAssembleRecord.setSerialNumber(techAssembleRecord.getSerialNumber() + "-" + oldAssembleRecords.size());
                                          }

                                          techAssembleRecord.setLength(webPartRecord.getLength());
                                          techAssembleRecord.setMaterial(webPartRecord.getMaterial());
                                          BigDecimal netWeight = newMachinePartRecords.stream()
                                             .map(
                                                record -> record.getNetWeight()
                                                   .multiply(
                                                      new BigDecimal(
                                                         artifactSpecAmend.getQuantity()
                                                            * machinePartLinkRecordMap.get(record.getId()).getQuantity()
                                                            / (proportionQuantity * artifactSpecAmend.getQuantity())
                                                      )
                                                   )
                                             )
                                             .reduce(BigDecimal.ZERO, BigDecimal::add);
                                          BigDecimal grossWeight = newMachinePartRecords.stream()
                                             .map(
                                                record -> record.getGrossWeight()
                                                   .multiply(
                                                      new BigDecimal(
                                                         artifactSpecAmend.getQuantity()
                                                            * machinePartLinkRecordMap.get(record.getId()).getQuantity()
                                                            / (proportionQuantity * artifactSpecAmend.getQuantity())
                                                      )
                                                   )
                                             )
                                             .reduce(BigDecimal.ZERO, BigDecimal::add);
                                          techAssembleRecord.setQuantity(proportionQuantity * artifactSpecAmend.getQuantity());
                                          techAssembleRecord.setNetWeight(netWeight);
                                          techAssembleRecord.setTotalNetWeight(
                                             techAssembleRecord.getNetWeight().multiply(new BigDecimal(techAssembleRecord.getQuantity()))
                                          );
                                          techAssembleRecord.setGrossWeight(grossWeight);
                                          techAssembleRecord.setTotalGrossWeight(
                                             techAssembleRecord.getGrossWeight().multiply(new BigDecimal(techAssembleRecord.getQuantity()))
                                          );
                                          techAssembleRecord.setSurfaceArea(webPartRecord.getSurfaceArea());
                                          techAssembleRecord.setSpecPrefix(sysStructureSpec.getSpecPrefix());
                                          String newSpecification = webPartRecord.getWidth()
                                             + "*"
                                             + webPartRecord.getThick()
                                             + "*"
                                             + sail1.getWidth()
                                             + "*"
                                             + sail1.getThick();
                                          techAssembleRecord.setSpecification(sysStructureSpec.getSpecPrefix() + newSpecification);
                                          techAssembleRecord.setAssembleConfigId(sysAssembleSpec.getAssembleConfigId());
                                          techAssembleRecord.setAssembleType(ProductClassificationEnum.ASSEMBLE.getType());
                                          techAssembleRecord.setUserId(webPartRecord.getUserId());
                                          this.assembleRecordService.save(techAssembleRecord);
                                          TechAssembleDetailRecord techAssembleDetailRecord = new TechAssembleDetailRecord();
                                          techAssembleDetailRecord.setInventoryOperationId(techAssembleRecord.getInventoryOperationId());
                                          techAssembleDetailRecord.setAssembleRecordId(techAssembleRecord.getId());
                                          techAssembleDetailRecord.setArtifactRecordId(artifactSpecAmend.getArtifactId());
                                          techAssembleDetailRecord.setQuantity(techAssembleRecord.getQuantity() / artifactSpecAmend.getQuantity());
                                          techAssembleDetailRecord.setBooInventory(Boolean.FALSE);
                                          this.assembleDetailRecordService.save(techAssembleDetailRecord);
                                          Map<Long, TechMachinePartRecord> partRecordMap = newMachinePartRecords.stream()
                                             .collect(Collectors.toMap(TechMachinePartRecord::getId, Function.identity()));
                                          newMachinePartRecords.forEach(
                                             part -> {
                                                TechMachinePartRecord oldTechMachinePartRecord = partRecordMap.get(part.getId());
                                                TechArtifactMachinePartLinkRecord linkRecord = machinePartLinkRecordMap.get(part.getId());
                                                oldTechMachinePartRecord.setQuantity(
                                                   oldTechMachinePartRecord.getQuantity() - linkRecord.getQuantity() * artifactSpecAmend.getQuantity()
                                                );
                                                Preconditions.checkArgument(oldTechMachinePartRecord.getQuantity() >= 0, "操作失败,数量有误!");
                                                oldTechMachinePartRecord.setTotalGrossWeight(
                                                   oldTechMachinePartRecord.getGrossWeight().multiply(new BigDecimal(oldTechMachinePartRecord.getQuantity()))
                                                );
                                                oldTechMachinePartRecord.setTotalNetWeight(
                                                   oldTechMachinePartRecord.getNetWeight().multiply(new BigDecimal(oldTechMachinePartRecord.getQuantity()))
                                                );
                                                this.machinePartRecordService.updateById(oldTechMachinePartRecord);
                                                TechMachinePartRecord techMachinePartRecord = BeanUtil.copy(
                                                   oldTechMachinePartRecord, TechMachinePartRecord.class
                                                );
                                                String webAndSailPartFix = null;
                                                if (automaticCombinationVO.getRangeOfActionEnum().equals(RangeOfActionEnum.SERIAL_NUMBER.getType())) {
                                                   String regex = "[a-zA-Z]+";
                                                   Pattern pattern = Pattern.compile(regex);
                                                   Matcher matcher = pattern.matcher(part.getSerialNumber());
                                                   webAndSailPartFix = matcher.find() ? matcher.group() : null;
                                                   Preconditions.checkArgument(StringUtils.isNotBlank(webAndSailPartFix), "操作失败,编号有误");
                                                }

                                                if (automaticCombinationVO.getRangeOfActionEnum().equals(RangeOfActionEnum.REMARK.getType())) {
                                                   webAndSailPartFix = part.getRemark();
                                                }

                                                if (webPartNumberPrefix.equals(webAndSailPartFix)) {
                                                   techMachinePartRecord.setSerialNumber(part.getSerialNumber() + "-腹");
                                                   techMachinePartRecord.setName("腹板");
                                                   techMachinePartRecord.setInitialSerialNumber(part.getSerialNumber());
                                                   techMachinePartRecord.setSourcePartEnum(SourcePartEnum.COMPONENT_COMBINATION.getType());
                                                } else {
                                                   techMachinePartRecord.setSerialNumber(part.getSerialNumber() + "-翼");
                                                   techMachinePartRecord.setName("翼缘板");
                                                   techMachinePartRecord.setInitialSerialNumber(part.getSerialNumber());
                                                   techMachinePartRecord.setSourcePartEnum(SourcePartEnum.COMPONENT_COMBINATION.getType());
                                                }

                                                List<TechMachinePartRecord> techMachinePartRecordList = oldMachinePartRecordMap.get(
                                                   techMachinePartRecord.getName() + "-" + techMachinePartRecord.getSerialNumber()
                                                );
                                                if (CollectionUtils.isEmpty(techMachinePartRecordList)) {
                                                   techMachinePartRecord.setComboId(part.getComboId());
                                                   techMachinePartRecord.setRelationType(16);
                                                   techMachinePartRecord.setQuantity(artifactSpecAmend.getQuantity() * linkRecord.getQuantity());
                                                   techMachinePartRecord.setTotalGrossWeight(
                                                      techMachinePartRecord.getGrossWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   techMachinePartRecord.setTotalNetWeight(
                                                      techMachinePartRecord.getNetWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   techMachinePartRecord.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECONDARY_MEMBER.getType());
                                                   techMachinePartRecord.setOldMachinePartId(oldTechMachinePartRecord.getId());
                                                   this.machinePartRecordService.save(techMachinePartRecord);
                                                   oldMachinePartRecordMap.put(
                                                      techMachinePartRecord.getName() + "-" + techMachinePartRecord.getSerialNumber(),
                                                      Arrays.asList(techMachinePartRecord)
                                                   );
                                                } else {
                                                   techMachinePartRecord = techMachinePartRecordList.get(0);
                                                   techMachinePartRecord.setQuantity(
                                                      techMachinePartRecord.getQuantity() + artifactSpecAmend.getQuantity() * linkRecord.getQuantity()
                                                   );
                                                   techMachinePartRecord.setTotalGrossWeight(
                                                      techMachinePartRecord.getGrossWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   techMachinePartRecord.setTotalNetWeight(
                                                      techMachinePartRecord.getNetWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   this.machinePartRecordService.updateById(techMachinePartRecord);
                                                }

                                                this.artifactMachinePartLinkRecordService
                                                   .remove(
                                                      (Wrapper<TechArtifactMachinePartLinkRecord>)((new LambdaQueryWrapper<TechArtifactMachinePartLinkRecord>()
                                                               .eq(TechArtifactMachinePartLinkRecord::getMachinePartRecordId, part.getId()))
                                                            .eq(
                                                               TechArtifactMachinePartLinkRecord::getInventoryOperationId,
                                                               artifactSpecAmend.getInventoryOperationId()
                                                            ))
                                                         .eq(TechArtifactMachinePartLinkRecord::getArtifactRecordId, artifactSpecAmend.getArtifactId())
                                                   );
                                                TechAssembleMachinePartLinkRecord techAssembleMachinePartLinkRecord = new TechAssembleMachinePartLinkRecord();
                                                techAssembleMachinePartLinkRecord.setInventoryOperationId(artifactSpecAmend.getInventoryOperationId());
                                                techAssembleMachinePartLinkRecord.setAssembleRecordId(techAssembleRecord.getId());
                                                techAssembleMachinePartLinkRecord.setMachinePartRecordId(techMachinePartRecord.getId());
                                                Integer partQuantity = artifactSpecAmend.getQuantity()
                                                   * linkRecord.getQuantity()
                                                   / techAssembleRecord.getQuantity();
                                                techAssembleMachinePartLinkRecord.setQuantity(partQuantity);
                                                this.assembleMachinePartLinkRecordService.save(techAssembleMachinePartLinkRecord);
                                             }
                                          );
                                          newAssembleRecords.add(techAssembleRecord);
                                       }

                                       TechAssembleRecord newAssembleRecord = newAssembleRecords.stream()
                                          .sorted(Comparator.comparing(TechAssembleRecord::getLength))
                                          .collect(Collectors.toList())
                                          .get(0);
                                       artifactSpecAmend.setNewStructureClassId(configVO.getStructureClassificationId());
                                       artifactSpecAmend.setNewSpecification(newAssembleRecord.getSpecification());
                                       artifactSpecAmend.setNewSpecPrefix(newAssembleRecord.getSpecPrefix());
                                       this.artifactSpecAmendService.updateById(artifactSpecAmend);
                                       flag.set(true);
                                    }
                                 }

                                 if (sysStructureSpec.getSpecPrefix().equals("BOX")) {
                                    if (CollectionUtils.isNotEmpty(webParts)
                                       && CollectionUtils.isNotEmpty(sailParts)
                                       && webParts.size() == 1
                                       && sailParts.size() == 1) {
                                       machinePartRecords.addAll(webParts);
                                       machinePartRecords.addAll(sailParts);
                                       TechMachinePartRecord webPartRecord = webParts.get(0);
                                       if (sailParts.stream()
                                          .allMatch(
                                             e -> machinePartLinkRecordMap.get(e.getId()).getQuantity() % 2 > 0
                                                && machinePartLinkRecordMap.get(e.getId())
                                                   .getQuantity()
                                                   .equals(machinePartLinkRecordMap.get(webPartRecord.getId()).getQuantity())
                                          )) {
                                          Integer proportionQuantity = machinePartLinkRecordMap.get(webPartRecord.getId()).getQuantity();
                                          SysAssembleSpec sysAssembleSpec = sysAssembleSpecMap.get(sysStructureSpec.getSpecPrefix());
                                          Preconditions.checkArgument(sysAssembleSpec != null, "导入失败,部件未配置BOX规格前缀");
                                          TechAssembleRecord techAssembleRecord = new TechAssembleRecord();
                                          techAssembleRecord.setBooInventory(false);
                                          techAssembleRecord.setProjectId(artifactSpecAmend.getProjectId());
                                          techAssembleRecord.setMonomerId(artifactSpecAmend.getMonomerId());
                                          techAssembleRecord.setAreaId(artifactSpecAmend.getAreaId());
                                          techAssembleRecord.setAreaBatchId(artifactSpecAmend.getAreaBatchId());
                                          techAssembleRecord.setInventoryOperationId(artifactSpecAmend.getInventoryOperationId());
                                          techAssembleRecord.setSerialNumber("组" + webPartRecord.getSerialNumber());
                                          List<TechAssembleRecord> oldAssembleRecords = this.artifactService
                                             .getAssembleRecordList(
                                                artifactSpecAmend.getMonomerId(),
                                                artifactSpecAmend.getAreaId(),
                                                techAssembleRecord.getSerialNumber(),
                                                artifactSpecAmend.getInventoryOperationId()
                                             );
                                          if (CollectionUtils.isNotEmpty(oldAssembleRecords)) {
                                             techAssembleRecord.setSerialNumber(techAssembleRecord.getSerialNumber() + "-" + oldAssembleRecords.size());
                                          }

                                          techAssembleRecord.setLength(webPartRecord.getLength());
                                          techAssembleRecord.setMaterial(webPartRecord.getMaterial());
                                          BigDecimal netWeight = machinePartRecords.stream()
                                             .map(
                                                record -> record.getNetWeight()
                                                   .multiply(
                                                      new BigDecimal(
                                                         artifactSpecAmend.getQuantity()
                                                            * machinePartLinkRecordMap.get(record.getId()).getQuantity()
                                                            / (proportionQuantity * artifactSpecAmend.getQuantity() / 2)
                                                      )
                                                   )
                                             )
                                             .reduce(BigDecimal.ZERO, BigDecimal::add);
                                          BigDecimal grossWeight = machinePartRecords.stream()
                                             .map(
                                                record -> record.getNetWeight()
                                                   .multiply(
                                                      new BigDecimal(
                                                         artifactSpecAmend.getQuantity()
                                                            * machinePartLinkRecordMap.get(record.getId()).getQuantity()
                                                            / (proportionQuantity * artifactSpecAmend.getQuantity() / 2)
                                                      )
                                                   )
                                             )
                                             .reduce(BigDecimal.ZERO, BigDecimal::add);
                                          techAssembleRecord.setQuantity(proportionQuantity * artifactSpecAmend.getQuantity() / 2);
                                          techAssembleRecord.setNetWeight(netWeight);
                                          techAssembleRecord.setTotalNetWeight(
                                             techAssembleRecord.getNetWeight().multiply(new BigDecimal(techAssembleRecord.getQuantity()))
                                          );
                                          techAssembleRecord.setGrossWeight(grossWeight);
                                          techAssembleRecord.setTotalGrossWeight(
                                             techAssembleRecord.getGrossWeight().multiply(new BigDecimal(techAssembleRecord.getQuantity()))
                                          );
                                          techAssembleRecord.setSurfaceArea(webPartRecord.getSurfaceArea());
                                          techAssembleRecord.setSpecPrefix(sysStructureSpec.getSpecPrefix());
                                          String newSpecification = webPartRecord.getWidth()
                                             + "*"
                                             + webPartRecord.getThick()
                                             + "*"
                                             + sailParts.get(0).getWidth()
                                             + "*"
                                             + sailParts.get(0).getThick();
                                          techAssembleRecord.setSpecification(sysStructureSpec.getSpecPrefix() + newSpecification);
                                          techAssembleRecord.setAssembleConfigId(sysAssembleSpec.getAssembleConfigId());
                                          techAssembleRecord.setAssembleType(ProductClassificationEnum.ASSEMBLE.getType());
                                          techAssembleRecord.setUserId(webPartRecord.getUserId());
                                          this.assembleRecordService.save(techAssembleRecord);
                                          TechAssembleDetailRecord techAssembleDetailRecord = new TechAssembleDetailRecord();
                                          techAssembleDetailRecord.setInventoryOperationId(techAssembleRecord.getInventoryOperationId());
                                          techAssembleDetailRecord.setAssembleRecordId(techAssembleRecord.getId());
                                          techAssembleDetailRecord.setArtifactRecordId(artifactSpecAmend.getArtifactId());
                                          techAssembleDetailRecord.setQuantity(techAssembleRecord.getQuantity() / artifactSpecAmend.getQuantity());
                                          techAssembleDetailRecord.setBooInventory(Boolean.FALSE);
                                          this.assembleDetailRecordService.save(techAssembleDetailRecord);
                                          Map<Long, TechMachinePartRecord> partRecordMap = machinePartRecords.stream()
                                             .collect(Collectors.toMap(TechMachinePartRecord::getId, Function.identity()));
                                          machinePartRecords.forEach(
                                             part -> {
                                                TechMachinePartRecord oldTechMachinePartRecord = partRecordMap.get(part.getId());
                                                TechArtifactMachinePartLinkRecord linkRecord = machinePartLinkRecordMap.get(part.getId());
                                                oldTechMachinePartRecord.setQuantity(
                                                   oldTechMachinePartRecord.getQuantity() - linkRecord.getQuantity() * artifactSpecAmend.getQuantity()
                                                );
                                                Preconditions.checkArgument(oldTechMachinePartRecord.getQuantity() >= 0, "操作失败,数量有误!");
                                                oldTechMachinePartRecord.setTotalGrossWeight(
                                                   oldTechMachinePartRecord.getGrossWeight().multiply(new BigDecimal(oldTechMachinePartRecord.getQuantity()))
                                                );
                                                oldTechMachinePartRecord.setTotalNetWeight(
                                                   oldTechMachinePartRecord.getNetWeight().multiply(new BigDecimal(oldTechMachinePartRecord.getQuantity()))
                                                );
                                                this.machinePartRecordService.updateById(oldTechMachinePartRecord);
                                                TechMachinePartRecord techMachinePartRecord = BeanUtil.copy(
                                                   oldTechMachinePartRecord, TechMachinePartRecord.class
                                                );
                                                String webAndSailPartFix = null;
                                                if (automaticCombinationVO.getRangeOfActionEnum().equals(RangeOfActionEnum.SERIAL_NUMBER.getType())) {
                                                   String regex = "[a-zA-Z]+";
                                                   Pattern pattern = Pattern.compile(regex);
                                                   Matcher matcher = pattern.matcher(part.getSerialNumber());
                                                   webAndSailPartFix = matcher.find() ? matcher.group() : null;
                                                   Preconditions.checkArgument(StringUtils.isNotBlank(webAndSailPartFix), "操作失败,编号有误");
                                                }

                                                if (automaticCombinationVO.getRangeOfActionEnum().equals(RangeOfActionEnum.REMARK.getType())) {
                                                   webAndSailPartFix = part.getRemark();
                                                }

                                                if (webPartNumberPrefix.equals(webAndSailPartFix)) {
                                                   techMachinePartRecord.setSerialNumber(part.getSerialNumber() + "-腹");
                                                   techMachinePartRecord.setName("腹板");
                                                   techMachinePartRecord.setInitialSerialNumber(part.getSerialNumber());
                                                   techMachinePartRecord.setSourcePartEnum(SourcePartEnum.COMPONENT_COMBINATION.getType());
                                                } else {
                                                   techMachinePartRecord.setSerialNumber(part.getSerialNumber() + "-翼");
                                                   techMachinePartRecord.setName("翼缘板");
                                                   techMachinePartRecord.setInitialSerialNumber(part.getSerialNumber());
                                                   techMachinePartRecord.setSourcePartEnum(SourcePartEnum.COMPONENT_COMBINATION.getType());
                                                }

                                                List<TechMachinePartRecord> techMachinePartRecordList = this.machinePartRecordService
                                                   .list(
                                                      (Wrapper<TechMachinePartRecord>)(((((new LambdaQueryWrapper<TechMachinePartRecord>()
                                                                        .eq(TechMachinePartRecord::getSerialNumber, techMachinePartRecord.getSerialNumber()))
                                                                     .eq(TechMachinePartRecord::getProjectId, techMachinePartRecord.getProjectId()))
                                                                  .eq(TechMachinePartRecord::getMonomerId, techMachinePartRecord.getMonomerId()))
                                                               .eq(TechMachinePartRecord::getName, techMachinePartRecord.getName()))
                                                            .eq(TechMachinePartRecord::getInventoryOperationId, techMachinePartRecord.getInventoryOperationId()))
                                                         .orderByDesc(BaseEntity::getCreateTime)
                                                   );
                                                if (CollectionUtils.isEmpty(techMachinePartRecordList)) {
                                                   techMachinePartRecord.setComboId(part.getComboId());
                                                   techMachinePartRecord.setRelationType(16);
                                                   techMachinePartRecord.setQuantity(artifactSpecAmend.getQuantity() * linkRecord.getQuantity());
                                                   techMachinePartRecord.setTotalGrossWeight(
                                                      techMachinePartRecord.getGrossWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   techMachinePartRecord.setTotalNetWeight(
                                                      techMachinePartRecord.getNetWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   techMachinePartRecord.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECONDARY_MEMBER.getType());
                                                   techMachinePartRecord.setOldMachinePartId(oldTechMachinePartRecord.getId());
                                                   this.machinePartRecordService.save(techMachinePartRecord);
                                                } else {
                                                   techMachinePartRecord = techMachinePartRecordList.get(0);
                                                   techMachinePartRecord.setQuantity(
                                                      techMachinePartRecord.getQuantity() + artifactSpecAmend.getQuantity() * linkRecord.getQuantity()
                                                   );
                                                   techMachinePartRecord.setTotalGrossWeight(
                                                      techMachinePartRecord.getGrossWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   techMachinePartRecord.setTotalNetWeight(
                                                      techMachinePartRecord.getNetWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   this.machinePartRecordService.updateById(techMachinePartRecord);
                                                }

                                                this.artifactMachinePartLinkRecordService
                                                   .remove(
                                                      (Wrapper<TechArtifactMachinePartLinkRecord>)((new LambdaQueryWrapper<TechArtifactMachinePartLinkRecord>()
                                                               .eq(TechArtifactMachinePartLinkRecord::getMachinePartRecordId, part.getId()))
                                                            .eq(
                                                               TechArtifactMachinePartLinkRecord::getInventoryOperationId,
                                                               artifactSpecAmend.getInventoryOperationId()
                                                            ))
                                                         .eq(TechArtifactMachinePartLinkRecord::getArtifactRecordId, artifactSpecAmend.getArtifactId())
                                                   );
                                                TechAssembleMachinePartLinkRecord techAssembleMachinePartLinkRecord = new TechAssembleMachinePartLinkRecord();
                                                techAssembleMachinePartLinkRecord.setInventoryOperationId(artifactSpecAmend.getInventoryOperationId());
                                                techAssembleMachinePartLinkRecord.setAssembleRecordId(techAssembleRecord.getId());
                                                techAssembleMachinePartLinkRecord.setMachinePartRecordId(techMachinePartRecord.getId());
                                                Integer partQuantity = artifactSpecAmend.getQuantity()
                                                   * linkRecord.getQuantity()
                                                   / techAssembleRecord.getQuantity();
                                                techAssembleMachinePartLinkRecord.setQuantity(partQuantity);
                                                this.assembleMachinePartLinkRecordService.save(techAssembleMachinePartLinkRecord);
                                             }
                                          );
                                          artifactSpecAmend.setNewStructureClassId(configVO.getStructureClassificationId());
                                          artifactSpecAmend.setNewSpecification(techAssembleRecord.getSpecification());
                                          artifactSpecAmend.setNewSpecPrefix(techAssembleRecord.getSpecPrefix());
                                          this.artifactSpecAmendService.updateById(artifactSpecAmend);
                                          flag.set(true);
                                       }
                                    }

                                    if (CollectionUtils.isNotEmpty(webParts)
                                       && CollectionUtils.isNotEmpty(sailParts)
                                       && (webParts.size() == 1 && sailParts.size() == 4 || webParts.size() == 1 && sailParts.size() == 3)) {
                                       int webPartProportionQuantity = webParts.stream()
                                          .mapToInt(part -> machinePartLinkRecordMap.get(part.getId()).getQuantity())
                                          .sum();
                                       int sailPartsProportionQuantity = sailParts.stream()
                                          .mapToInt(part -> machinePartLinkRecordMap.get(part.getId()).getQuantity())
                                          .sum();
                                       if (sailPartsProportionQuantity / webPartProportionQuantity == 4) {
                                          machinePartRecords.addAll(webParts);
                                          machinePartRecords.addAll(sailParts);
                                          TechMachinePartRecord webPartRecord = webParts.get(0);
                                          Integer proportionQuantity = machinePartLinkRecordMap.get(webPartRecord.getId()).getQuantity();
                                          SysAssembleSpec sysAssembleSpec = sysAssembleSpecMap.get(sysStructureSpec.getSpecPrefix());
                                          Preconditions.checkArgument(sysAssembleSpec != null, "导入失败,部件未配置BOX规格前缀");
                                          TechAssembleRecord techAssembleRecord = new TechAssembleRecord();
                                          techAssembleRecord.setBooInventory(false);
                                          techAssembleRecord.setProjectId(artifactSpecAmend.getProjectId());
                                          techAssembleRecord.setMonomerId(artifactSpecAmend.getMonomerId());
                                          techAssembleRecord.setAreaId(artifactSpecAmend.getAreaId());
                                          techAssembleRecord.setInventoryOperationId(artifactSpecAmend.getInventoryOperationId());
                                          techAssembleRecord.setSerialNumber("组" + webPartRecord.getSerialNumber());
                                          List<TechAssembleRecord> oldAssembleRecords = this.artifactService
                                             .getAssembleRecordList(
                                                artifactSpecAmend.getMonomerId(),
                                                artifactSpecAmend.getAreaId(),
                                                techAssembleRecord.getSerialNumber(),
                                                artifactSpecAmend.getInventoryOperationId()
                                             );
                                          if (CollectionUtils.isNotEmpty(oldAssembleRecords)) {
                                             techAssembleRecord.setSerialNumber(techAssembleRecord.getSerialNumber() + "-" + oldAssembleRecords.size());
                                          }

                                          techAssembleRecord.setLength(webPartRecord.getLength());
                                          techAssembleRecord.setMaterial(webPartRecord.getMaterial());
                                          BigDecimal netWeight = machinePartRecords.stream()
                                             .map(
                                                record -> record.getNetWeight()
                                                   .multiply(
                                                      new BigDecimal(
                                                         artifactSpecAmend.getQuantity()
                                                            * machinePartLinkRecordMap.get(record.getId()).getQuantity()
                                                            / (proportionQuantity * artifactSpecAmend.getQuantity())
                                                      )
                                                   )
                                             )
                                             .reduce(BigDecimal.ZERO, BigDecimal::add);
                                          BigDecimal grossWeight = machinePartRecords.stream()
                                             .map(
                                                record -> record.getNetWeight()
                                                   .multiply(
                                                      new BigDecimal(
                                                         artifactSpecAmend.getQuantity()
                                                            * machinePartLinkRecordMap.get(record.getId()).getQuantity()
                                                            / (proportionQuantity * artifactSpecAmend.getQuantity())
                                                      )
                                                   )
                                             )
                                             .reduce(BigDecimal.ZERO, BigDecimal::add);
                                          techAssembleRecord.setQuantity(proportionQuantity);
                                          techAssembleRecord.setNetWeight(netWeight);
                                          techAssembleRecord.setTotalNetWeight(
                                             techAssembleRecord.getNetWeight().multiply(new BigDecimal(techAssembleRecord.getQuantity()))
                                          );
                                          techAssembleRecord.setGrossWeight(grossWeight);
                                          techAssembleRecord.setTotalGrossWeight(
                                             techAssembleRecord.getGrossWeight().multiply(new BigDecimal(techAssembleRecord.getQuantity()))
                                          );
                                          techAssembleRecord.setSurfaceArea(webPartRecord.getSurfaceArea());
                                          techAssembleRecord.setSpecPrefix(sysStructureSpec.getSpecPrefix());
                                          String newSpecification = webPartRecord.getWidth()
                                             + "*"
                                             + webPartRecord.getThick()
                                             + "*"
                                             + sailParts.get(0).getWidth()
                                             + "*"
                                             + sailParts.get(0).getThick();
                                          techAssembleRecord.setSpecification(sysStructureSpec.getSpecPrefix() + newSpecification);
                                          techAssembleRecord.setAssembleConfigId(sysAssembleSpec.getAssembleConfigId());
                                          techAssembleRecord.setAssembleType(ProductClassificationEnum.ASSEMBLE.getType());
                                          techAssembleRecord.setUserId(webPartRecord.getUserId());
                                          this.assembleRecordService.save(techAssembleRecord);
                                          TechAssembleDetailRecord techAssembleDetailRecord = new TechAssembleDetailRecord();
                                          techAssembleDetailRecord.setInventoryOperationId(techAssembleRecord.getInventoryOperationId());
                                          techAssembleDetailRecord.setAssembleRecordId(techAssembleRecord.getId());
                                          techAssembleDetailRecord.setArtifactRecordId(artifactSpecAmend.getArtifactId());
                                          techAssembleDetailRecord.setQuantity(techAssembleRecord.getQuantity() / artifactSpecAmend.getQuantity());
                                          techAssembleDetailRecord.setBooInventory(Boolean.FALSE);
                                          this.assembleDetailRecordService.save(techAssembleDetailRecord);
                                          Map<Long, TechMachinePartRecord> partRecordMap = machinePartRecords.stream()
                                             .collect(Collectors.toMap(TechMachinePartRecord::getId, Function.identity()));
                                          machinePartRecords.forEach(
                                             part -> {
                                                TechMachinePartRecord oldTechMachinePartRecord = partRecordMap.get(part.getId());
                                                TechArtifactMachinePartLinkRecord linkRecord = machinePartLinkRecordMap.get(part.getId());
                                                oldTechMachinePartRecord.setQuantity(
                                                   oldTechMachinePartRecord.getQuantity() - linkRecord.getQuantity() * artifactSpecAmend.getQuantity()
                                                );
                                                Preconditions.checkArgument(oldTechMachinePartRecord.getQuantity() >= 0, "操作失败,数量有误!");
                                                oldTechMachinePartRecord.setTotalGrossWeight(
                                                   oldTechMachinePartRecord.getGrossWeight().multiply(new BigDecimal(oldTechMachinePartRecord.getQuantity()))
                                                );
                                                oldTechMachinePartRecord.setTotalNetWeight(
                                                   oldTechMachinePartRecord.getNetWeight().multiply(new BigDecimal(oldTechMachinePartRecord.getQuantity()))
                                                );
                                                this.machinePartRecordService.updateById(oldTechMachinePartRecord);
                                                TechMachinePartRecord techMachinePartRecord = BeanUtil.copy(
                                                   oldTechMachinePartRecord, TechMachinePartRecord.class
                                                );
                                                String webAndSailPartFix = null;
                                                if (automaticCombinationVO.getRangeOfActionEnum().equals(RangeOfActionEnum.SERIAL_NUMBER.getType())) {
                                                   String regex = "[a-zA-Z]+";
                                                   Pattern pattern = Pattern.compile(regex);
                                                   Matcher matcher = pattern.matcher(part.getSerialNumber());
                                                   webAndSailPartFix = matcher.find() ? matcher.group() : null;
                                                   Preconditions.checkArgument(StringUtils.isNotBlank(webAndSailPartFix), "操作失败,编号有误");
                                                }

                                                if (automaticCombinationVO.getRangeOfActionEnum().equals(RangeOfActionEnum.REMARK.getType())) {
                                                   webAndSailPartFix = part.getRemark();
                                                }

                                                if (webPartNumberPrefix.equals(webAndSailPartFix)) {
                                                   techMachinePartRecord.setSerialNumber(part.getSerialNumber() + "-腹");
                                                   techMachinePartRecord.setName("腹板");
                                                   techMachinePartRecord.setInitialSerialNumber(part.getSerialNumber());
                                                   techMachinePartRecord.setSourcePartEnum(SourcePartEnum.COMPONENT_COMBINATION.getType());
                                                } else {
                                                   techMachinePartRecord.setSerialNumber(part.getSerialNumber() + "-翼");
                                                   techMachinePartRecord.setName("翼缘板");
                                                   techMachinePartRecord.setInitialSerialNumber(part.getSerialNumber());
                                                   techMachinePartRecord.setSourcePartEnum(SourcePartEnum.COMPONENT_COMBINATION.getType());
                                                }

                                                List<TechMachinePartRecord> techMachinePartRecordList = this.machinePartRecordService
                                                   .list(
                                                      (Wrapper<TechMachinePartRecord>)(((((new LambdaQueryWrapper<TechMachinePartRecord>()
                                                                        .eq(TechMachinePartRecord::getSerialNumber, techMachinePartRecord.getSerialNumber()))
                                                                     .eq(TechMachinePartRecord::getProjectId, techMachinePartRecord.getProjectId()))
                                                                  .eq(TechMachinePartRecord::getMonomerId, techMachinePartRecord.getMonomerId()))
                                                               .eq(TechMachinePartRecord::getName, techMachinePartRecord.getName()))
                                                            .eq(TechMachinePartRecord::getInventoryOperationId, techMachinePartRecord.getInventoryOperationId()))
                                                         .orderByDesc(BaseEntity::getCreateTime)
                                                   );
                                                if (CollectionUtils.isEmpty(techMachinePartRecordList)) {
                                                   techMachinePartRecord.setComboId(part.getComboId());
                                                   techMachinePartRecord.setRelationType(16);
                                                   techMachinePartRecord.setQuantity(artifactSpecAmend.getQuantity() * linkRecord.getQuantity());
                                                   techMachinePartRecord.setTotalGrossWeight(
                                                      techMachinePartRecord.getGrossWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   techMachinePartRecord.setTotalNetWeight(
                                                      techMachinePartRecord.getNetWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   techMachinePartRecord.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECONDARY_MEMBER.getType());
                                                   techMachinePartRecord.setOldMachinePartId(oldTechMachinePartRecord.getId());
                                                   this.machinePartRecordService.save(techMachinePartRecord);
                                                } else {
                                                   techMachinePartRecord = techMachinePartRecordList.get(0);
                                                   techMachinePartRecord.setQuantity(
                                                      techMachinePartRecord.getQuantity() + artifactSpecAmend.getQuantity() * linkRecord.getQuantity()
                                                   );
                                                   techMachinePartRecord.setTotalGrossWeight(
                                                      techMachinePartRecord.getGrossWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   techMachinePartRecord.setTotalNetWeight(
                                                      techMachinePartRecord.getNetWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   this.machinePartRecordService.updateById(techMachinePartRecord);
                                                }

                                                this.artifactMachinePartLinkRecordService
                                                   .remove(
                                                      (Wrapper<TechArtifactMachinePartLinkRecord>)((new LambdaQueryWrapper<TechArtifactMachinePartLinkRecord>()
                                                               .eq(TechArtifactMachinePartLinkRecord::getMachinePartRecordId, part.getId()))
                                                            .eq(
                                                               TechArtifactMachinePartLinkRecord::getInventoryOperationId,
                                                               artifactSpecAmend.getInventoryOperationId()
                                                            ))
                                                         .eq(TechArtifactMachinePartLinkRecord::getArtifactRecordId, artifactSpecAmend.getArtifactId())
                                                   );
                                                TechAssembleMachinePartLinkRecord techAssembleMachinePartLinkRecord = new TechAssembleMachinePartLinkRecord();
                                                techAssembleMachinePartLinkRecord.setInventoryOperationId(artifactSpecAmend.getInventoryOperationId());
                                                techAssembleMachinePartLinkRecord.setAssembleRecordId(techAssembleRecord.getId());
                                                techAssembleMachinePartLinkRecord.setMachinePartRecordId(techMachinePartRecord.getId());
                                                Integer partQuantity = artifactSpecAmend.getQuantity()
                                                   * linkRecord.getQuantity()
                                                   / techAssembleRecord.getQuantity();
                                                techAssembleMachinePartLinkRecord.setQuantity(partQuantity);
                                                this.assembleMachinePartLinkRecordService.save(techAssembleMachinePartLinkRecord);
                                             }
                                          );
                                          artifactSpecAmend.setNewStructureClassId(configVO.getStructureClassificationId());
                                          artifactSpecAmend.setNewSpecification(techAssembleRecord.getSpecification());
                                          artifactSpecAmend.setNewSpecPrefix(techAssembleRecord.getSpecPrefix());
                                          this.artifactSpecAmendService.updateById(artifactSpecAmend);
                                          flag.set(true);
                                       }
                                    }

                                    if (CollectionUtils.isNotEmpty(webParts)
                                       && CollectionUtils.isNotEmpty(sailParts)
                                       && webParts.size() == 1
                                       && sailParts.size() == 2) {
                                       int webPartProportionQuantity = webParts.stream()
                                          .mapToInt(part -> machinePartLinkRecordMap.get(part.getId()).getQuantity())
                                          .sum();
                                       int sailPartsProportionQuantity = sailParts.stream()
                                          .mapToInt(part -> machinePartLinkRecordMap.get(part.getId()).getQuantity())
                                          .sum();
                                       if (sailPartsProportionQuantity / webPartProportionQuantity == 1) {
                                          machinePartRecords.addAll(webParts);
                                          machinePartRecords.addAll(sailParts);
                                          TechMachinePartRecord webPartRecord = webParts.get(0);
                                          Integer proportionQuantity = machinePartLinkRecordMap.get(webPartRecord.getId()).getQuantity();
                                          SysAssembleSpec sysAssembleSpec = sysAssembleSpecMap.get(sysStructureSpec.getSpecPrefix());
                                          Preconditions.checkArgument(sysAssembleSpec != null, "导入失败,部件未配置BOX规格前缀");
                                          TechAssembleRecord techAssembleRecord = new TechAssembleRecord();
                                          techAssembleRecord.setBooInventory(false);
                                          techAssembleRecord.setProjectId(artifactSpecAmend.getProjectId());
                                          techAssembleRecord.setMonomerId(artifactSpecAmend.getMonomerId());
                                          techAssembleRecord.setAreaId(artifactSpecAmend.getAreaId());
                                          techAssembleRecord.setInventoryOperationId(artifactSpecAmend.getInventoryOperationId());
                                          techAssembleRecord.setSerialNumber("组" + webPartRecord.getSerialNumber());
                                          List<TechAssembleRecord> oldAssembleRecords = this.artifactService
                                             .getAssembleRecordList(
                                                artifactSpecAmend.getMonomerId(),
                                                artifactSpecAmend.getAreaId(),
                                                techAssembleRecord.getSerialNumber(),
                                                artifactSpecAmend.getInventoryOperationId()
                                             );
                                          if (CollectionUtils.isNotEmpty(oldAssembleRecords)) {
                                             techAssembleRecord.setSerialNumber(techAssembleRecord.getSerialNumber() + "-" + oldAssembleRecords.size());
                                          }

                                          techAssembleRecord.setLength(webPartRecord.getLength());
                                          techAssembleRecord.setMaterial(webPartRecord.getMaterial());
                                          BigDecimal netWeight = machinePartRecords.stream()
                                             .map(
                                                record -> record.getNetWeight()
                                                   .multiply(
                                                      new BigDecimal(
                                                         artifactSpecAmend.getQuantity()
                                                            * machinePartLinkRecordMap.get(record.getId()).getQuantity()
                                                            / (proportionQuantity * artifactSpecAmend.getQuantity() / 2)
                                                      )
                                                   )
                                             )
                                             .reduce(BigDecimal.ZERO, BigDecimal::add);
                                          BigDecimal grossWeight = machinePartRecords.stream()
                                             .map(
                                                record -> record.getNetWeight()
                                                   .multiply(
                                                      new BigDecimal(
                                                         artifactSpecAmend.getQuantity()
                                                            * machinePartLinkRecordMap.get(record.getId()).getQuantity()
                                                            / (proportionQuantity * artifactSpecAmend.getQuantity() / 2)
                                                      )
                                                   )
                                             )
                                             .reduce(BigDecimal.ZERO, BigDecimal::add);
                                          techAssembleRecord.setQuantity(proportionQuantity * artifactSpecAmend.getQuantity() / 2);
                                          techAssembleRecord.setNetWeight(netWeight);
                                          techAssembleRecord.setTotalNetWeight(
                                             techAssembleRecord.getNetWeight().multiply(new BigDecimal(techAssembleRecord.getQuantity()))
                                          );
                                          techAssembleRecord.setGrossWeight(grossWeight);
                                          techAssembleRecord.setTotalGrossWeight(
                                             techAssembleRecord.getGrossWeight().multiply(new BigDecimal(techAssembleRecord.getQuantity()))
                                          );
                                          techAssembleRecord.setSurfaceArea(webPartRecord.getSurfaceArea());
                                          techAssembleRecord.setSpecPrefix(sysStructureSpec.getSpecPrefix());
                                          BigDecimal newWidth = new BigDecimal(webPartRecord.getWidth())
                                             .add(new BigDecimal(sailParts.get(0).getThick()))
                                             .add(new BigDecimal(sailParts.get(1).getThick()));
                                          String newSpecification = newWidth
                                             + "*"
                                             + sailParts.get(0).getWidth()
                                             + "*"
                                             + sailParts.get(0).getThick()
                                             + "*"
                                             + webPartRecord.getThick();
                                          techAssembleRecord.setSpecification(sysStructureSpec.getSpecPrefix() + newSpecification);
                                          techAssembleRecord.setAssembleConfigId(sysAssembleSpec.getAssembleConfigId());
                                          techAssembleRecord.setAssembleType(ProductClassificationEnum.ASSEMBLE.getType());
                                          techAssembleRecord.setUserId(webPartRecord.getUserId());
                                          this.assembleRecordService.save(techAssembleRecord);
                                          TechAssembleDetailRecord techAssembleDetailRecord = new TechAssembleDetailRecord();
                                          techAssembleDetailRecord.setInventoryOperationId(techAssembleRecord.getInventoryOperationId());
                                          techAssembleDetailRecord.setAssembleRecordId(techAssembleRecord.getId());
                                          techAssembleDetailRecord.setArtifactRecordId(artifactSpecAmend.getArtifactId());
                                          techAssembleDetailRecord.setQuantity(techAssembleRecord.getQuantity() / artifactSpecAmend.getQuantity());
                                          techAssembleDetailRecord.setBooInventory(Boolean.FALSE);
                                          this.assembleDetailRecordService.save(techAssembleDetailRecord);
                                          Map<Long, TechMachinePartRecord> partRecordMap = machinePartRecords.stream()
                                             .collect(Collectors.toMap(TechMachinePartRecord::getId, Function.identity()));
                                          machinePartRecords.forEach(
                                             part -> {
                                                TechMachinePartRecord oldTechMachinePartRecord = partRecordMap.get(part.getId());
                                                TechArtifactMachinePartLinkRecord linkRecord = machinePartLinkRecordMap.get(part.getId());
                                                oldTechMachinePartRecord.setQuantity(
                                                   oldTechMachinePartRecord.getQuantity() - linkRecord.getQuantity() * artifactSpecAmend.getQuantity()
                                                );
                                                Preconditions.checkArgument(oldTechMachinePartRecord.getQuantity() >= 0, "操作失败,数量有误!");
                                                oldTechMachinePartRecord.setTotalGrossWeight(
                                                   oldTechMachinePartRecord.getGrossWeight().multiply(new BigDecimal(oldTechMachinePartRecord.getQuantity()))
                                                );
                                                oldTechMachinePartRecord.setTotalNetWeight(
                                                   oldTechMachinePartRecord.getNetWeight().multiply(new BigDecimal(oldTechMachinePartRecord.getQuantity()))
                                                );
                                                this.machinePartRecordService.updateById(oldTechMachinePartRecord);
                                                TechMachinePartRecord techMachinePartRecord = BeanUtil.copy(
                                                   oldTechMachinePartRecord, TechMachinePartRecord.class
                                                );
                                                String webAndSailPartFix = null;
                                                if (automaticCombinationVO.getRangeOfActionEnum().equals(RangeOfActionEnum.SERIAL_NUMBER.getType())) {
                                                   String regex = "[a-zA-Z]+";
                                                   Pattern pattern = Pattern.compile(regex);
                                                   Matcher matcher = pattern.matcher(part.getSerialNumber());
                                                   webAndSailPartFix = matcher.find() ? matcher.group() : null;
                                                   Preconditions.checkArgument(StringUtils.isNotBlank(webAndSailPartFix), "操作失败,编号有误");
                                                }

                                                if (automaticCombinationVO.getRangeOfActionEnum().equals(RangeOfActionEnum.REMARK.getType())) {
                                                   webAndSailPartFix = part.getRemark();
                                                }

                                                if (webPartNumberPrefix.equals(webAndSailPartFix)) {
                                                   techMachinePartRecord.setSerialNumber(part.getSerialNumber() + "-腹");
                                                   techMachinePartRecord.setName("腹板");
                                                   techMachinePartRecord.setInitialSerialNumber(part.getSerialNumber());
                                                   techMachinePartRecord.setSourcePartEnum(SourcePartEnum.COMPONENT_COMBINATION.getType());
                                                } else {
                                                   techMachinePartRecord.setSerialNumber(part.getSerialNumber() + "-翼");
                                                   techMachinePartRecord.setName("翼缘板");
                                                   techMachinePartRecord.setInitialSerialNumber(part.getSerialNumber());
                                                   techMachinePartRecord.setSourcePartEnum(SourcePartEnum.COMPONENT_COMBINATION.getType());
                                                }

                                                List<TechMachinePartRecord> techMachinePartRecordList = this.machinePartRecordService
                                                   .list(
                                                      (Wrapper<TechMachinePartRecord>)(((((new LambdaQueryWrapper<TechMachinePartRecord>()
                                                                        .eq(TechMachinePartRecord::getSerialNumber, techMachinePartRecord.getSerialNumber()))
                                                                     .eq(TechMachinePartRecord::getProjectId, techMachinePartRecord.getProjectId()))
                                                                  .eq(TechMachinePartRecord::getMonomerId, techMachinePartRecord.getMonomerId()))
                                                               .eq(TechMachinePartRecord::getName, techMachinePartRecord.getName()))
                                                            .eq(TechMachinePartRecord::getInventoryOperationId, techMachinePartRecord.getInventoryOperationId()))
                                                         .orderByDesc(BaseEntity::getCreateTime)
                                                   );
                                                if (CollectionUtils.isEmpty(techMachinePartRecordList)) {
                                                   techMachinePartRecord.setComboId(part.getComboId());
                                                   techMachinePartRecord.setRelationType(16);
                                                   techMachinePartRecord.setQuantity(artifactSpecAmend.getQuantity() * linkRecord.getQuantity());
                                                   techMachinePartRecord.setTotalGrossWeight(
                                                      techMachinePartRecord.getGrossWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   techMachinePartRecord.setTotalNetWeight(
                                                      techMachinePartRecord.getNetWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   techMachinePartRecord.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECONDARY_MEMBER.getType());
                                                   techMachinePartRecord.setOldMachinePartId(oldTechMachinePartRecord.getId());
                                                   this.machinePartRecordService.save(techMachinePartRecord);
                                                } else {
                                                   techMachinePartRecord = techMachinePartRecordList.get(0);
                                                   techMachinePartRecord.setQuantity(
                                                      techMachinePartRecord.getQuantity() + artifactSpecAmend.getQuantity() * linkRecord.getQuantity()
                                                   );
                                                   techMachinePartRecord.setTotalGrossWeight(
                                                      techMachinePartRecord.getGrossWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   techMachinePartRecord.setTotalNetWeight(
                                                      techMachinePartRecord.getNetWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                                                   );
                                                   this.machinePartRecordService.updateById(techMachinePartRecord);
                                                }

                                                this.artifactMachinePartLinkRecordService
                                                   .remove(
                                                      (Wrapper<TechArtifactMachinePartLinkRecord>)((new LambdaQueryWrapper<TechArtifactMachinePartLinkRecord>()
                                                               .eq(TechArtifactMachinePartLinkRecord::getMachinePartRecordId, part.getId()))
                                                            .eq(
                                                               TechArtifactMachinePartLinkRecord::getInventoryOperationId,
                                                               artifactSpecAmend.getInventoryOperationId()
                                                            ))
                                                         .eq(TechArtifactMachinePartLinkRecord::getArtifactRecordId, artifactSpecAmend.getArtifactId())
                                                   );
                                                TechAssembleMachinePartLinkRecord techAssembleMachinePartLinkRecord = new TechAssembleMachinePartLinkRecord();
                                                techAssembleMachinePartLinkRecord.setInventoryOperationId(artifactSpecAmend.getInventoryOperationId());
                                                techAssembleMachinePartLinkRecord.setAssembleRecordId(techAssembleRecord.getId());
                                                techAssembleMachinePartLinkRecord.setMachinePartRecordId(techMachinePartRecord.getId());
                                                Integer partQuantity = artifactSpecAmend.getQuantity()
                                                   * linkRecord.getQuantity()
                                                   / techAssembleRecord.getQuantity();
                                                techAssembleMachinePartLinkRecord.setQuantity(partQuantity);
                                                this.assembleMachinePartLinkRecordService.save(techAssembleMachinePartLinkRecord);
                                             }
                                          );
                                          artifactSpecAmend.setNewStructureClassId(configVO.getStructureClassificationId());
                                          artifactSpecAmend.setNewSpecification(techAssembleRecord.getSpecification());
                                          artifactSpecAmend.setNewSpecPrefix(techAssembleRecord.getSpecPrefix());
                                          this.artifactSpecAmendService.updateById(artifactSpecAmend);
                                          flag.set(true);
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      );
      Preconditions.checkArgument(flag.get(), "操作失败,本次组合成功0条,请检查板拼配置或清单!");
   }

   public TechUtilManagerImpl(
      final TechUtilInventoryMesManager inventoryMesManager,
      final TechUtilInventoryBridgeManager inventoryBridgeManager,
      final TechUtilInventoryGridManager inventoryGridManager,
      final SysStructureClassificationService structureClassificationService,
      final SysStructureSpecService structureSpecService,
      final SysSteelClassificationMatchService steelClassificationMatchService,
      final SysAssembleSpecService assembleSpecService,
      final MesBuildingProductProcessService productProcessService,
      final SysStructureSpecNumberLinkService sysStructureSpecNumberLinkService,
      final MesSectionWarehouseConfigDetailService mesSectionWarehouseConfigDetailService,
      final TechArtifactService artifactService,
      final TechAssembleService assembleService,
      final TechMachinePartService machinePartService,
      final TechStandardPartService standardPartService,
      final TechArtifactMachinePartLinkService artifactMachinePartLinkService,
      final TechAssembleDetailService assembleDetailService,
      final TechAssembleMachinePartLinkService assembleMachinePartLinkService,
      final TechArtifactStandardPartLinkService artifactStandardPartLinkService,
      final SysSteelClassSpecNameLinkService sysSteelClassSpecNameLinkService,
      final MesTechInventoryOperationService mesTechInventoryOperationService,
      final TechArtifactRecordService artifactRecordService,
      final TechMachinePartRecordService machinePartRecordService,
      final TechAssembleRecordService assembleRecordService,
      final TechAssembleDetailRecordService assembleDetailRecordService,
      final TechArtifactMachinePartLinkRecordService artifactMachinePartLinkRecordService,
      final TechStandardPartRecordService standardPartRecordService,
      final TechArtifactStandardPartLinkRecordService artifactStandardPartLinkRecordService,
      final TechDrawingService drawingService,
      final TechMachineHoleRadiusLinkService machineHoleRadiusLinkService,
      final TechAssembleMachinePartLinkRecordService assembleMachinePartLinkRecordService,
      final ConfigService configService,
      final SysInventoryConfigurationService inventoryConfigurationService,
      final TemplatePanelAssemblyConfigService panelAssemblyConfigService,
      final SysStructureSpecService sysStructureSpecService,
      final SysAssembleSpecService sysAssembleSpecService,
      final TechArtifactSpecAmendService artifactSpecAmendService,
      final MesArtifactClassService mesArtifactClassService
   ) {
      this.inventoryMesManager = inventoryMesManager;
      this.inventoryBridgeManager = inventoryBridgeManager;
      this.inventoryGridManager = inventoryGridManager;
      this.structureClassificationService = structureClassificationService;
      this.structureSpecService = structureSpecService;
      this.steelClassificationMatchService = steelClassificationMatchService;
      this.assembleSpecService = assembleSpecService;
      this.productProcessService = productProcessService;
      this.sysStructureSpecNumberLinkService = sysStructureSpecNumberLinkService;
      this.mesSectionWarehouseConfigDetailService = mesSectionWarehouseConfigDetailService;
      this.artifactService = artifactService;
      this.assembleService = assembleService;
      this.machinePartService = machinePartService;
      this.standardPartService = standardPartService;
      this.artifactMachinePartLinkService = artifactMachinePartLinkService;
      this.assembleDetailService = assembleDetailService;
      this.assembleMachinePartLinkService = assembleMachinePartLinkService;
      this.artifactStandardPartLinkService = artifactStandardPartLinkService;
      this.sysSteelClassSpecNameLinkService = sysSteelClassSpecNameLinkService;
      this.mesTechInventoryOperationService = mesTechInventoryOperationService;
      this.artifactRecordService = artifactRecordService;
      this.machinePartRecordService = machinePartRecordService;
      this.assembleRecordService = assembleRecordService;
      this.assembleDetailRecordService = assembleDetailRecordService;
      this.artifactMachinePartLinkRecordService = artifactMachinePartLinkRecordService;
      this.standardPartRecordService = standardPartRecordService;
      this.artifactStandardPartLinkRecordService = artifactStandardPartLinkRecordService;
      this.drawingService = drawingService;
      this.machineHoleRadiusLinkService = machineHoleRadiusLinkService;
      this.assembleMachinePartLinkRecordService = assembleMachinePartLinkRecordService;
      this.configService = configService;
      this.inventoryConfigurationService = inventoryConfigurationService;
      this.panelAssemblyConfigService = panelAssemblyConfigService;
      this.sysStructureSpecService = sysStructureSpecService;
      this.sysAssembleSpecService = sysAssembleSpecService;
      this.artifactSpecAmendService = artifactSpecAmendService;
      this.mesArtifactClassService = mesArtifactClassService;
   }
}
