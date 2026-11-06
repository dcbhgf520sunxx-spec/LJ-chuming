package com.hzchum.scim.plan.core.biz.impl.check;

import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.FlankPlateTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductCategoryTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.service.team.MesBuildingMachinePartTeamDetailService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.TechEnclosureRecord;
import com.hzchum.scim.mes.enclosure.core.api.service.check.TechEnclosureRecordService;
import com.hzchum.scim.plan.core.api.biz.check.MesTechInventoryOperationBiz;
import com.hzchum.scim.plan.core.api.enums.BuildingTypeEnum;
import com.hzchum.scim.plan.core.api.enums.DrawingProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.ImportTypeEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryReviewedEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryTypeEnum;
import com.hzchum.scim.plan.core.api.enums.OperationTypeEnum;
import com.hzchum.scim.plan.core.api.enums.SourcePartEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.manager.TechUtilManager;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactSpecAmend;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo._do.check.MesTechInventoryOperation;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechArtifactMachinePartLinkRecord;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechArtifactRecord;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechArtifactStandardPartLinkRecord;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechAssembleDetailRecord;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechAssembleMachinePartLinkRecord;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechAssembleRecord;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechMachinePartRecord;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechStandardPartRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactSpecUncorrectedDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.InventoryBridgeExportTemplateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.InventoryEnclosureExportTemplateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.InventoryExportBaseCommonTemplateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.InventoryExportTemplateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.InventoryFixUpRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.InventoryGridExportTemplateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.MesTechInventoryOperationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.MesTechInventoryOperationDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.check.TechArtifactRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.TechAssembleMachinePartRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.TechAssembleRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.TechEnclosureRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.TechMachinePartRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechAreaProductInfoDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechConfigUtilsDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactBoxImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.InventoryAssembleImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.MachinePartImportDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.StandardPartImportDTOParam;
import com.hzchum.scim.plan.core.api.pojo.vo.MachineSpecificationVO;
import com.hzchum.scim.plan.core.api.pojo.vo.TechArtifactSpecAmendUpdateVORequest;
import com.hzchum.scim.plan.core.api.pojo.vo.TechAssemblyAutomaticCombinationVO;
import com.hzchum.scim.plan.core.api.pojo.vo.TechPartRecordVO;
import com.hzchum.scim.plan.core.api.pojo.vo.TechSerialNumberQuantityVO;
import com.hzchum.scim.plan.core.api.pojo.vo.TechUnitRecordBaseVO;
import com.hzchum.scim.plan.core.api.pojo.vo.TechUnitRecordVO;
import com.hzchum.scim.plan.core.api.pojo.vo.TemplatePanelAssemblyConfigVO;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechArtifactSpecAmendService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.change.TechChangeRecordService;
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
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.enums.ProjectModeEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo._do.MonomerUserLink;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationServiceTriggerDTO;
import com.hzchum.scim.system.core.api.service.MonomerUserLinkService;
import com.hzchum.scim.system.core.api.service.SysAssembleSpecService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureSpecService;
import com.hzchum.scim.system.core.api.service.TemplatePanelAssemblyConfigService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MesTechInventoryOperationBizImpl implements MesTechInventoryOperationBiz {
   @Resource
   private MesTechInventoryOperationService mesTechInventoryOperationService;
   @Resource
   private TechEnclosureRecordService enclosureRecordService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PlanMonomerService planMonomerService;
   @Resource
   private PlanAreaService planAreaService;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private TechUtilManager techUtilManager;
   @Resource
   private TechArtifactRecordService artifactRecordService;
   @Resource
   private TechMachinePartRecordService machinePartRecordService;
   @Resource
   private TechAssembleRecordService assembleRecordService;
   @Resource
   private TechAssembleDetailRecordService assembleDetailRecordService;
   @Resource
   private TechArtifactMachinePartLinkRecordService artifactMachinePartLinkRecordService;
   @Resource
   private TechAssembleMachinePartLinkRecordService assembleMachinePartLinkRecordService;
   @Resource
   private TechStandardPartRecordService standardPartRecordService;
   @Resource
   private TechArtifactSpecAmendService artifactSpecAmendService;
   @Resource
   private TechArtifactStandardPartLinkRecordService artifactStandardPartLinkRecordService;
   @Resource
   private TechChangeRecordService changeRecordService;
   @Resource
   private TechArtifactMachinePartLinkRecordService techArtifactMachinePartLinkRecordService;
   @Resource
   private TechMachinePartRecordService techMachinePartRecordService;
   @Resource
   private MonomerUserLinkService monomerUserLinkService;
   @Resource
   private SysStructureClassificationService structureClassificationService;
   @Resource
   private PlanAreaBatchService planAreaBatchService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private PlanAreaBatchService areaBatchService;
   @Resource
   private TechDrawingService drawingService;
   @Resource
   private MesBuildingMachinePartTeamDetailService mesBuildingMachinePartTeamDetailService;
   @Resource
   private SysPushFlowConfigBiz sysPushFlowConfigBiz;
   @Resource
   private NotificationTemplateDetailsUtils detailsUtils;
   @Resource
   private TemplatePanelAssemblyConfigService panelAssemblyConfigService;
   @Resource
   private SysStructureSpecService sysStructureSpecService;
   @Resource
   private SysAssembleSpecService sysAssembleSpecService;
   @Resource
   private MoveOutboundDetailService outboundDetailService;
   @Resource
   private TechArtifactRecordService techArtifactRecordService;
   @Resource
   private TechAssembleDetailRecordService techAssembleDetailRecordService;
   @Resource
   private TechAssembleRecordService techAssembleRecordService;
   @Resource
   private TechAssembleMachinePartLinkRecordService techAssembleMachinePartLinkRecordService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void importInventory(
      MultipartFile file,
      Long monomerId,
      Long areaId,
      Integer importType,
      Integer inventoryTypeEnum,
      String remark,
      String areaBatchName,
      HttpServletResponse response
   ) {
      List<MistakeExportDTO> mistakeExportDTOList = new ArrayList<>(1024);
      PlanAreaBatch areaBach = this.planAreaBatchService
         .getOne(
            (Wrapper<PlanAreaBatch>)((new LambdaQueryWrapper<PlanAreaBatch>().eq(PlanAreaBatch::getMonomerId, monomerId))
                  .eq(PlanAreaBatch::getAreaId, areaId))
               .eq(PlanAreaBatch::getName, areaBatchName.trim())
         );

      ContractProject project;
      PlanArea area;
      PlanMonomer monomer;
      try {
         Preconditions.checkArgument(StringUtils.isNotBlank(areaBatchName.trim()), "导入失败,请检查批次是否输入!");
         Preconditions.checkArgument(ImportTypeEnum.ADD_IMPORT.getType().equals(importType), "导入失败,仅支持增量导入!");
         area = this.planAreaService.getById(areaId);
         Preconditions.checkArgument(area != null, "区域不存在!");
         monomer = this.planMonomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "单体不存在!");
         Preconditions.checkArgument(area.getMonomerId().equals(monomerId), "操作失败,所选区域和单体不一致!");
         Preconditions.checkArgument(
            monomer.getBuildingTypeEnum().equals(inventoryTypeEnum) || monomer.getBuildingTypeEnum().equals(BuildingTypeEnum.UNKNOWN.getType()),
            "该单体不可导入" + InventoryTypeEnum.getNameByType(inventoryTypeEnum) + "清单!"
         );
         project = this.projectService.checkProjectStatus(area.getProjectId());
         if (!UserUtil.getCurrentUser().isAdmin()) {
            List<MonomerUserLink> monomerUserLinkList = this.monomerUserLinkService
               .list(Wrappers.lambdaQuery(MonomerUserLink.class).eq(MonomerUserLink::getMonomerId, area.getMonomerId()));
            List<Long> deepenedPersonIds = monomerUserLinkList.stream().map(MonomerUserLink::getDeepenedPersonId).collect(Collectors.toList());
            Preconditions.checkArgument(deepenedPersonIds.contains(UserUtil.getCurrentUserId()), "您不是该单体深化负责人,不允许导入文件!");
         }

         if (areaBach != null) {
            this.mesTechInventoryOperationService
               .checkInventoryOperationByAreaBatchId(
                  areaBach.getId(), Arrays.asList(InventoryReviewedEnum.FIXUP_RECORD.getType(), InventoryReviewedEnum.UNAUDITED.getType())
               );
         }
      } catch (Exception exception) {
         mistakeExportDTOList.add(TechUtils.buildMistakeDTO(exception.getMessage()));
         TechUtils.exportMistakeList(mistakeExportDTOList, response);
         return;
      }

      TechConfigUtilsDTO utilsDTO = this.techUtilManager.getTechConfigUtilsDto(BuildingTypeEnum.getMesProductTypeByType(inventoryTypeEnum));
      List<ArtifactBoxImportDTO> artifactBoxDtoParamList = this.techUtilManager
         .getArtifactBoxImportDTOS(file, inventoryTypeEnum, response, mistakeExportDTOList, utilsDTO, area.getMonomerId(), importType);
      if (!CollectionUtils.isNotEmpty(mistakeExportDTOList) && !CollectionUtils.isEmpty(artifactBoxDtoParamList)) {
         if (areaBach == null) {
            areaBach = BeanUtil.copy(area, PlanAreaBatch.class);
            areaBach.setName(areaBatchName.trim());
            areaBach.setAreaId(area.getId());
            this.planAreaBatchService.save(areaBach);
         }

         TechAreaProductInfoDTO areaProductInfo = this.techUtilManager.getAreaProductInfo(areaBach.getId());
         MesTechInventoryOperation inventoryOperation = MesTechInventoryOperation.builder()
            .projectId(project.getId())
            .monomerId(monomerId)
            .areaId(areaId)
            .areaBatchId(areaBach.getId())
            .importType(importType)
            .operationTypeEnum(OperationTypeEnum.ADD_IMPORT.getType())
            .importUserId(UserUtil.getCurrentUserId())
            .createUserName(UserUtil.getCurrentName())
            .buildingType(inventoryTypeEnum)
            .remark(remark)
            .build();
         this.mesTechInventoryOperationService.save(inventoryOperation);
         this.buildInventoryOperationLink(artifactBoxDtoParamList, project.getMode(), areaBach, utilsDTO, areaProductInfo, inventoryOperation);
         monomer.setBuildingTypeEnum(inventoryTypeEnum);
         this.planMonomerService.updateById(monomer);
         if (CollectionUtils.isEmpty(mistakeExportDTOList)) {
            this.sysPushFlowConfigBiz
               .triggerFlow(
                  NotificationServiceTriggerDTO.builder()
                     .projectId(project.getId())
                     .monomerId(monomerId)
                     .contentDetails(this.detailsUtils.getDetailedTemplateDetails(project.getId(), monomerId, areaId, "构建", true))
                     .areaId(areaId)
                     .notificationTypeEnum(NotificationModuleTypeEnum.CREATE_DETAILED.getNotificationType())
                     .userList(new ArrayList<>())
                     .build()
               );
         }

         TechUtils.exportMistakeList(mistakeExportDTOList, response);
      } else {
         TechUtils.exportMistakeList(mistakeExportDTOList, response);
      }
   }

   @Override
   public MesTechInventoryOperationDTO getInventoryStatusByArea(Long areaBatchId) {
      MesTechInventoryOperation inventoryOperation = this.mesTechInventoryOperationService
         .getOne(
            (Wrapper<MesTechInventoryOperation>)((new LambdaQueryWrapper<MesTechInventoryOperation>()
                     .eq(MesTechInventoryOperation::getAreaBatchId, areaBatchId))
                  .orderByDesc(BaseEntity::getCreateTime))
               .last("limit 1")
         );
      MesTechInventoryOperationDTO dto = BeanUtil.copy(inventoryOperation, MesTechInventoryOperationDTO.class);
      if (dto != null) {
         dto.setBoolRevoke(dto.getImportUserId().equals(UserUtil.getCurrentUserId()));
      }

      return dto;
   }

   @Override
   public InventoryFixUpRecordDTO getRepetitionInventoryList(
      Long inventoryId,
      String serialNumber,
      String specification,
      String material,
      Long maxLength,
      Long minLength,
      Boolean boolCombination,
      Long structureClassId
   ) {
      Preconditions.checkArgument(inventoryId != null, "清单审核记录Id不能为空!");
      MesTechInventoryOperation inventoryOperation = this.mesTechInventoryOperationService.getById(inventoryId);
      Preconditions.checkArgument(inventoryOperation != null, "清单操作记录不存在!");
      Preconditions.checkArgument(inventoryOperation.getInventoryReviewedEnum().equals(InventoryReviewedEnum.FIXUP_RECORD.getType()), "操作失败,待确认的清单不存在,请刷新重试!");
      ContractProject project = this.projectService.getById(inventoryOperation.getProjectId());
      PlanMonomer monomer = this.planMonomerService.getById(inventoryOperation.getMonomerId());
      PlanArea area = this.planAreaService.getById(inventoryOperation.getAreaId());
      PlanAreaBatch areaBatch = this.areaBatchService.getById(inventoryOperation.getAreaBatchId());
      Map<Long, PlanArea> areaMap = this.planAreaService
         .list((Wrapper<PlanArea>)new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getMonomerId, inventoryOperation.getMonomerId()))
         .stream()
         .collect(Collectors.toMap(PlanArea::getId, Function.identity()));
      List<TechArtifactRecordDTO> artifactRecordDTOList = this.artifactRecordService
         .list(
            (Wrapper<TechArtifactRecord>)(new LambdaQueryWrapper<TechArtifactRecord>().eq(TechArtifactRecord::getInventoryOperationId, inventoryId))
               .eq(TechArtifactRecord::getBoolRepetition, Boolean.TRUE)
         )
         .stream()
         .map(m -> BeanUtil.copy(m, TechArtifactRecordDTO.class))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(artifactRecordDTOList)) {
         Map<String, List<TechArtifact>> monomerArtifactMap = this.artifactService
            .list(
               ((new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getMonomerId, inventoryOperation.getMonomerId()))
                     .in(
                        TechArtifact::getSerialNumber,
                        artifactRecordDTOList.stream().map(TechArtifactRecordDTO::getSerialNumber).distinct().collect(Collectors.toList())
                     ))
                  .select(TechArtifact::getSerialNumber, TechArtifact::getAreaId)
            )
            .stream()
            .collect(Collectors.groupingBy(TechArtifact::getSerialNumber));
         if (CollectionUtils.isNotEmpty(monomerArtifactMap)) {
            for (TechArtifactRecordDTO recordDTO : artifactRecordDTOList) {
               List<TechArtifact> artifacts = monomerArtifactMap.get(recordDTO.getSerialNumber());
               if (CollectionUtils.isNotEmpty(artifacts)) {
                  recordDTO.setAreaNames(artifacts.stream().map(e -> areaMap.get(e.getAreaId()).getName()).distinct().collect(Collectors.joining(",")));
               }
            }
         }
      }

      List<TechArtifactSpecUncorrectedDTO> artifactSpecUncorrectedDTOS = this.artifactSpecAmendService
         .uncorrectedList(inventoryId, serialNumber, specification, material, maxLength, minLength, structureClassId);
      this.setSpecUncorrectedDrawingNumber(artifactSpecUncorrectedDTOS, inventoryOperation);
      this.setRecordDrawingNumber(artifactRecordDTOList, inventoryOperation);
      Map<Long, SysStructureClassification> sysStructureClassificationMap = new HashMap<>();
      Map<Long, List<TechArtifactMachinePartLinkRecord>> artifactMachinePartLinkRecordMap = new HashMap<>();
      Map<Long, TechMachinePartRecord> partRecordMap = new HashMap<>();
      Map<Long, List<TechAssembleDetailRecord>> assembleDetailRecordMap = new HashMap<>();
      List<Long> oldStructureClassIdList = artifactSpecUncorrectedDTOS.stream()
         .map(TechArtifactSpecUncorrectedDTO::getOldStructureClassId)
         .filter(Objects::nonNull)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(oldStructureClassIdList)) {
         sysStructureClassificationMap = this.structureClassificationService
            .listByIds(oldStructureClassIdList)
            .stream()
            .collect(Collectors.toMap(SysStructureClassification::getId, Function.identity()));
      }

      List<Long> artifactRecordIdList = artifactSpecUncorrectedDTOS.stream()
         .map(TechArtifactSpecUncorrectedDTO::getArtifactRecordId)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(artifactRecordIdList)) {
         List<TechArtifactMachinePartLinkRecord> artifactMachinePartLinkRecords = this.techArtifactMachinePartLinkRecordService
            .list(
               (Wrapper<TechArtifactMachinePartLinkRecord>)new LambdaQueryWrapper<TechArtifactMachinePartLinkRecord>()
                  .in(TechArtifactMachinePartLinkRecord::getArtifactRecordId, artifactRecordIdList)
            );
         if (CollectionUtils.isNotEmpty(artifactMachinePartLinkRecords)) {
            artifactMachinePartLinkRecordMap = artifactMachinePartLinkRecords.stream()
               .collect(Collectors.groupingBy(TechArtifactMachinePartLinkRecord::getArtifactRecordId));
            partRecordMap = this.techMachinePartRecordService
               .listByIds(artifactMachinePartLinkRecords.stream().map(TechArtifactMachinePartLinkRecord::getMachinePartRecordId).collect(Collectors.toList()))
               .stream()
               .collect(Collectors.toMap(TechMachinePartRecord::getId, Function.identity()));
         }

         assembleDetailRecordMap = this.techAssembleDetailRecordService
            .list((Wrapper<TechAssembleDetailRecord>)new LambdaQueryWrapper<TechAssembleDetailRecord>().in(TechAssembleDetailRecord::getArtifactRecordId, artifactRecordIdList))
            .stream()
            .collect(Collectors.groupingBy(TechAssembleDetailRecord::getArtifactRecordId));
      }

      if (project.getMode().equals(ProjectModeEnum.STANDARD_MODE.getType())) {
         Map<Long, SysStructureClassification> finalSysStructureClassificationMap = sysStructureClassificationMap;
         Map<Long, List<TechArtifactMachinePartLinkRecord>> finalArtifactMachinePartLinkRecordMap = artifactMachinePartLinkRecordMap;
         Map<Long, TechMachinePartRecord> finalPartRecordMap = partRecordMap;
         Map<Long, List<TechAssembleDetailRecord>> finalAssembleDetailRecordMap = assembleDetailRecordMap;
         artifactSpecUncorrectedDTOS.forEach(
            m -> {
               if (null != m.getOldStructureClassId()) {
                  SysStructureClassification structureClassification = finalSysStructureClassificationMap.get(m.getOldStructureClassId());
                  if (null != structureClassification) {
                     m.setOldStructureClassName(structureClassification.getClassificationName());
                  }
               }

               m.setPlJudge(true);
               Long artifactRecordId = m.getArtifactId();
               List<TechArtifactMachinePartLinkRecord> techArtifactMachinePartLinkRecordList = finalArtifactMachinePartLinkRecordMap.get(artifactRecordId);
               if (CollectionUtils.isNotEmpty(techArtifactMachinePartLinkRecordList)) {
                  if (techArtifactMachinePartLinkRecordList.size() == 1) {
                     List<TechAssembleDetailRecord> techAssembleDetailRecordList = finalAssembleDetailRecordMap.get(artifactRecordId);
                     if (CollectionUtils.isNotEmpty(techAssembleDetailRecordList)) {
                        return;
                     }

                     m.setPlJudge(false);
                     return;
                  }

                  techArtifactMachinePartLinkRecordList.forEach(
                     m1 -> {
                        Long machinePartRecordId = m1.getMachinePartRecordId();
                        TechMachinePartRecord techMachinePartRecord = finalPartRecordMap.get(machinePartRecordId);
                        if (null == techMachinePartRecord
                           || !techMachinePartRecord.getSpecification().toUpperCase().startsWith("PL")
                              && techMachinePartRecord.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.PRIMARY_MEMBER.getType())) {
                           m.setPlJudge(false);
                        }
                     }
                  );
               }
            }
         );
      }

      InventoryFixUpRecordDTO fixUpRecordDTO = BeanUtil.copy(inventoryOperation, InventoryFixUpRecordDTO.class);
      fixUpRecordDTO.setProjectName(project.getName());
      fixUpRecordDTO.setMonomerName(monomer.getName());
      fixUpRecordDTO.setAreaName(area.getName());
      fixUpRecordDTO.setAreaBatchName(areaBatch.getName());
      List<TechArtifactSpecUncorrectedDTO> artifactSpecUncorrectedDTOSPL = artifactSpecUncorrectedDTOS.stream()
         .filter(TechArtifactSpecUncorrectedDTO::getPlJudge)
         .collect(Collectors.toList());
      List<TechArtifactSpecUncorrectedDTO> artifactSpecUncorrectedDTOSNoPL = artifactSpecUncorrectedDTOS.stream()
         .filter(m -> !m.getPlJudge())
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(artifactSpecUncorrectedDTOSPL)) {
         Map<Long, List<TechAssembleDetailRecord>> assembleArtifactIdRecordMap = this.techAssembleDetailRecordService
            .list(
               (Wrapper<TechAssembleDetailRecord>)(new LambdaQueryWrapper<TechAssembleDetailRecord>()
                     .in(
                        TechAssembleDetailRecord::getArtifactRecordId,
                        artifactSpecUncorrectedDTOSPL.stream().map(TechArtifactSpecUncorrectedDTO::getArtifactId).collect(Collectors.toList())
                     ))
                  .eq(TechAssembleDetailRecord::getBooInventory, Boolean.FALSE)
            )
            .stream()
            .collect(Collectors.groupingBy(TechAssembleDetailRecord::getArtifactRecordId));
         artifactSpecUncorrectedDTOSPL.forEach(m -> {
            m.setPartAmendStatus(false);
            List<TechAssembleDetailRecord> techAssembleDetailRecordList = assembleArtifactIdRecordMap.get(m.getArtifactId());
            List<String> machineSpecifications = this.getMachineSpecification(m.getArtifactId());
            List<MachineSpecificationVO> machineSpecificationVOList = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(machineSpecifications)) {
               machineSpecifications.forEach(m1 -> {
                  MachineSpecificationVO machineSpecificationVO = new MachineSpecificationVO();
                  machineSpecificationVO.setName(m1);
                  machineSpecificationVOList.add(machineSpecificationVO);
               });
            }

            m.setMachineSpecifications(machineSpecificationVOList);
            if (CollectionUtils.isNotEmpty(techAssembleDetailRecordList)) {
               m.setPartAmendStatus(true);
            }
         });
      }

      if (CollectionUtils.isNotEmpty(artifactSpecUncorrectedDTOSPL)) {
         fixUpRecordDTO.setUnBoardAssembledQuantity((int)artifactSpecUncorrectedDTOSPL.stream().filter(e -> !e.getPartAmendStatus()).count());
         fixUpRecordDTO.setBoardAssembledQuantity(
            (int)artifactSpecUncorrectedDTOSPL.stream().filter(TechArtifactSpecUncorrectedDTO::getPartAmendStatus).count()
         );
         artifactSpecUncorrectedDTOSPL = artifactSpecUncorrectedDTOSPL.stream()
            .filter(e -> e.getPartAmendStatus().equals(boolCombination))
            .sorted(
               Comparator.comparing(TechArtifactSpecUncorrectedDTO::getNewStructureClassId, Comparator.nullsFirst(Comparator.naturalOrder()))
                  .thenComparing(TechArtifactSpecUncorrectedDTO::getLength)
                  .reversed()
            )
            .collect(Collectors.toList());
      }

      fixUpRecordDTO.setArtifactRecordDTOList(artifactRecordDTOList);
      fixUpRecordDTO.setArtifactSpecUncorrectedDTOS(artifactSpecUncorrectedDTOSNoPL);
      fixUpRecordDTO.setArtifactSpecUncorrectedDTOSPL(artifactSpecUncorrectedDTOSPL);
      fixUpRecordDTO.setBoolSpecificationRevision(CollectionUtils.isNotEmpty(artifactSpecUncorrectedDTOS));
      fixUpRecordDTO.setBoolRepetition(CollectionUtils.isNotEmpty(artifactRecordDTOList));
      fixUpRecordDTO.setMesProductEnum(BuildingTypeEnum.getMesProductTypeByType(inventoryOperation.getBuildingType()));
      return fixUpRecordDTO;
   }

   private void setSpecUncorrectedDrawingNumber(List<TechArtifactSpecUncorrectedDTO> artifactSpecUncorrectedDTOS, MesTechInventoryOperation inventoryOperation) {
      if (CollectionUtils.isNotEmpty(artifactSpecUncorrectedDTOS)) {
         List<String> serialNumberList = artifactSpecUncorrectedDTOS.stream()
            .map(TechArtifactSpecUncorrectedDTO::getSerialNumber)
            .distinct()
            .collect(Collectors.toList());
         Map<String, List<TechDrawing>> drawingListMap = this.drawingService
            .list(
               (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                           .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                        .eq(TechDrawing::getProductType, DrawingProductTypeEnum.ARTIFACT.getType()))
                     .in(TechDrawing::getSerialNumber, serialNumberList))
                  .eq(TechDrawing::getMonomerId, inventoryOperation.getMonomerId())
            )
            .stream()
            .collect(Collectors.groupingBy(TechDrawing::getSerialNumber));
         artifactSpecUncorrectedDTOS.forEach(
            artifactDTO -> {
               artifactDTO.setProductType(ProductTypeEnum.ARTIFACT.getType());
               artifactDTO.setArtifactSerialNumber(artifactDTO.getSerialNumber());
               if (drawingListMap.containsKey(artifactDTO.getSerialNumber())) {
                  artifactDTO.setNumbers(drawingListMap.get(artifactDTO.getSerialNumber()).stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
                  artifactDTO.setDrawingAndSerialNumber(
                     drawingListMap.get(artifactDTO.getSerialNumber())
                        .stream()
                        .map(drawing -> BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class))
                        .collect(Collectors.toList())
                  );
               }
            }
         );
      }
   }

   private void setRecordDrawingNumber(List<TechArtifactRecordDTO> artifactRecordDTOList, MesTechInventoryOperation inventoryOperation) {
      if (CollectionUtils.isNotEmpty(artifactRecordDTOList)) {
         List<String> serialNumberList = artifactRecordDTOList.stream().map(TechArtifactRecordDTO::getSerialNumber).distinct().collect(Collectors.toList());
         Map<String, List<TechDrawing>> drawingListMap = this.drawingService
            .list(
               (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                           .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                        .eq(TechDrawing::getProductType, DrawingProductTypeEnum.ARTIFACT.getType()))
                     .in(TechDrawing::getSerialNumber, serialNumberList))
                  .eq(TechDrawing::getMonomerId, inventoryOperation.getMonomerId())
            )
            .stream()
            .collect(Collectors.groupingBy(TechDrawing::getSerialNumber));
         artifactRecordDTOList.forEach(
            artifactDTO -> {
               artifactDTO.setProductType(ProductTypeEnum.ARTIFACT.getType());
               artifactDTO.setArtifactSerialNumber(artifactDTO.getSerialNumber());
               if (drawingListMap.containsKey(artifactDTO.getSerialNumber())) {
                  artifactDTO.setNumbers(drawingListMap.get(artifactDTO.getSerialNumber()).stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
                  artifactDTO.setDrawingAndSerialNumber(
                     drawingListMap.get(artifactDTO.getSerialNumber())
                        .stream()
                        .map(drawing -> BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class))
                        .collect(Collectors.toList())
                  );
               }
            }
         );
      }
   }

   @Override
   public List<TechMachinePartRecordDTO> getRepetitionInventoryMachineList(Long artifactId) {
      Preconditions.checkArgument(artifactId != null, "清单记录Id不能为空!");
      List<TechArtifactMachinePartLinkRecord> techArtifactMachinePartLinkRecordList = this.techArtifactMachinePartLinkRecordService
         .list((Wrapper<TechArtifactMachinePartLinkRecord>)new LambdaQueryWrapper<TechArtifactMachinePartLinkRecord>().eq(TechArtifactMachinePartLinkRecord::getArtifactRecordId, artifactId));
      if (CollectionUtils.isNotEmpty(techArtifactMachinePartLinkRecordList)) {
         List<TechMachinePartRecord> machinePartRecordList = this.techMachinePartRecordService
            .list(
               (Wrapper<TechMachinePartRecord>)(new LambdaQueryWrapper<TechMachinePartRecord>()
                     .in(
                        TechMachinePartRecord::getId,
                        techArtifactMachinePartLinkRecordList.stream()
                           .map(TechArtifactMachinePartLinkRecord::getMachinePartRecordId)
                           .collect(Collectors.toList())
                     ))
                  .orderByDesc(TechMachinePartRecord::getLength)
            );
         List<TechMachinePartRecordDTO> techMachinePartRecordDTOList = new ArrayList<>();
         return CollectionUtils.isNotEmpty(machinePartRecordList)
            ? machinePartRecordList.stream().map(m -> BeanUtil.copy(m, TechMachinePartRecordDTO.class)).collect(Collectors.toList())
            : techMachinePartRecordDTOList;
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public TechAssembleMachinePartRecordDTO getRepetitionInventoryMachineListTwo(Long artifactId) {
      Preconditions.checkArgument(artifactId != null, "构件审核Id不能为空!");
      TechArtifactRecord techArtifactRecord = this.techArtifactRecordService.getById(artifactId);
      Preconditions.checkArgument(techArtifactRecord != null, "构件审核记录不存在!");
      Long inventoryOperationId = techArtifactRecord.getInventoryOperationId();
      List<TechArtifactMachinePartLinkRecord> techArtifactMachinePartLinkRecordList = this.techArtifactMachinePartLinkRecordService
         .list((Wrapper<TechArtifactMachinePartLinkRecord>)new LambdaQueryWrapper<TechArtifactMachinePartLinkRecord>().eq(TechArtifactMachinePartLinkRecord::getArtifactRecordId, artifactId));
      List<TechAssembleDetailRecord> techAssembleDetailRecordList = this.techAssembleDetailRecordService
         .list(
            (Wrapper<TechAssembleDetailRecord>)(new LambdaQueryWrapper<TechAssembleDetailRecord>()
                  .eq(TechAssembleDetailRecord::getInventoryOperationId, inventoryOperationId))
               .eq(TechAssembleDetailRecord::getArtifactRecordId, artifactId)
         );
      List<TechMachinePartRecordDTO> techMachinePartRecordDTOList = new ArrayList<>();
      List<TechAssembleRecordDTO> techAssembleRecordDTOList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(techArtifactMachinePartLinkRecordList)) {
         List<Long> machinePartRecordIdList = techArtifactMachinePartLinkRecordList.stream()
            .map(TechArtifactMachinePartLinkRecord::getMachinePartRecordId)
            .collect(Collectors.toList());
         List<TechMachinePartRecord> machinePartRecordList = this.techMachinePartRecordService
            .list(
               (Wrapper<TechMachinePartRecord>)((new LambdaQueryWrapper<TechMachinePartRecord>()
                        .in(TechMachinePartRecord::getId, machinePartRecordIdList))
                     .eq(TechMachinePartRecord::getSteelPlateTypeEnum, 1))
                  .orderByDesc(TechMachinePartRecord::getLength)
            );
         List<TechMachinePartRecord> machinePartRecordListNew = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(machinePartRecordList)) {
            Map<Long, List<TechAssembleMachinePartLinkRecord>> assembleMachinePartLinkRecordMap = this.techAssembleMachinePartLinkRecordService
               .list(
                  (Wrapper<TechAssembleMachinePartLinkRecord>)new LambdaQueryWrapper<TechAssembleMachinePartLinkRecord>()
                     .in(
                        TechAssembleMachinePartLinkRecord::getMachinePartRecordId,
                        machinePartRecordList.stream().map(TechMachinePartRecord::getId).collect(Collectors.toList())
                     )
               )
               .stream()
               .collect(Collectors.groupingBy(TechAssembleMachinePartLinkRecord::getMachinePartRecordId));
            machinePartRecordList.forEach(m -> {
               List<TechAssembleMachinePartLinkRecord> techAssembleMachinePartLinkRecordList = assembleMachinePartLinkRecordMap.get(m.getId());
               if (CollectionUtils.isEmpty(techAssembleMachinePartLinkRecordList)) {
                  machinePartRecordListNew.add(m);
               }
            });
            techMachinePartRecordDTOList = machinePartRecordListNew.stream()
               .map(m -> BeanUtil.copy(m, TechMachinePartRecordDTO.class))
               .collect(Collectors.toList());
         }
      }

      if (CollectionUtils.isNotEmpty(techAssembleDetailRecordList)) {
         List<TechAssembleRecord> assembleRecordList = this.techAssembleRecordService
            .list(
               (Wrapper<TechAssembleRecord>)(new LambdaQueryWrapper<TechAssembleRecord>()
                     .in(
                        TechAssembleRecord::getId,
                        techAssembleDetailRecordList.stream().map(TechAssembleDetailRecord::getAssembleRecordId).collect(Collectors.toList())
                     ))
                  .orderByDesc(TechAssembleRecord::getLength)
            );
         if (CollectionUtils.isNotEmpty(assembleRecordList)) {
            techAssembleRecordDTOList = assembleRecordList.stream().map(m -> BeanUtil.copy(m, TechAssembleRecordDTO.class)).collect(Collectors.toList());
            List<TechAssembleMachinePartLinkRecord> machinePartLinkRecords = this.techAssembleMachinePartLinkRecordService
               .list(
                  (Wrapper<TechAssembleMachinePartLinkRecord>)new LambdaQueryWrapper<TechAssembleMachinePartLinkRecord>()
                     .in(
                        TechAssembleMachinePartLinkRecord::getAssembleRecordId,
                        techAssembleRecordDTOList.stream().map(TechAssembleRecordDTO::getId).collect(Collectors.toList())
                     )
               );
            Map<Long, List<TechAssembleMachinePartLinkRecord>> assembleMachinePartLinkRecordMap = machinePartLinkRecords.stream()
               .collect(Collectors.groupingBy(TechAssembleMachinePartLinkRecord::getAssembleRecordId));
            techAssembleRecordDTOList.forEach(
               m -> {
                  List<TechAssembleMachinePartLinkRecord> techAssembleMachinePartLinkRecordList = assembleMachinePartLinkRecordMap.getOrDefault(
                     m.getId(), new ArrayList<>()
                  );
                  List<Long> machinePartRecordIdList = techAssembleMachinePartLinkRecordList.stream()
                     .map(TechAssembleMachinePartLinkRecord::getMachinePartRecordId)
                     .collect(Collectors.toList());
                  List<TechMachinePartRecordDTO> techMachinePartRecordDTOListAssemble = new ArrayList<>();
                  if (CollectionUtils.isNotEmpty(machinePartRecordIdList)) {
                     List<TechMachinePartRecord> techMachinePartRecordListAssemble = this.techMachinePartRecordService
                        .list((Wrapper<TechMachinePartRecord>)new LambdaQueryWrapper<TechMachinePartRecord>().in(TechMachinePartRecord::getId, machinePartRecordIdList));
                     if (CollectionUtils.isNotEmpty(techMachinePartRecordListAssemble)) {
                        techMachinePartRecordDTOListAssemble = techMachinePartRecordListAssemble.stream()
                           .map(j -> BeanUtil.copy(j, TechMachinePartRecordDTO.class))
                           .collect(Collectors.toList());
                     }
                  }

                  m.setTechAssembleRecordDTO(techMachinePartRecordDTOListAssemble);
               }
            );
         }
      }

      TechAssembleMachinePartRecordDTO techAssembleMachinePartRecordDTO = new TechAssembleMachinePartRecordDTO();
      if (CollectionUtils.isNotEmpty(techMachinePartRecordDTOList)) {
         Map<Long, List<TechArtifactMachinePartLinkRecord>> artifactMachinePartLinkRecordMap = this.techArtifactMachinePartLinkRecordService
            .list(
               (Wrapper<TechArtifactMachinePartLinkRecord>)((new LambdaQueryWrapper<TechArtifactMachinePartLinkRecord>()
                        .in(
                           TechArtifactMachinePartLinkRecord::getMachinePartRecordId,
                           techMachinePartRecordDTOList.stream().map(TechMachinePartRecordDTO::getId).collect(Collectors.toList())
                        ))
                     .eq(TechArtifactMachinePartLinkRecord::getArtifactRecordId, artifactId))
                  .eq(TechArtifactMachinePartLinkRecord::getInventoryOperationId, inventoryOperationId)
            )
            .stream()
            .collect(Collectors.groupingBy(TechArtifactMachinePartLinkRecord::getMachinePartRecordId));
         techMachinePartRecordDTOList.forEach(m -> {
            List<TechArtifactMachinePartLinkRecord> temp = artifactMachinePartLinkRecordMap.get(m.getId());
            if (CollectionUtils.isNotEmpty(temp)) {
               m.setQuantity(temp.get(0).getQuantity());
            }
         });
      }

      techAssembleMachinePartRecordDTO.setTechAssembleRecordDTO(techMachinePartRecordDTOList);
      techAssembleMachinePartRecordDTO.setTechMachinePartRecordDTO(techAssembleRecordDTOList);
      List<TechMachinePartRecordDTO> techAssembleRecordNewDTO = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(techAssembleRecordDTOList)) {
         List<Long> ids = techAssembleRecordDTOList.stream().map(TechAssembleRecordDTO::getId).collect(Collectors.toList());
         Map<Long, List<TechAssembleMachinePartLinkRecord>> assembleMachinePartRecordMap = this.techAssembleMachinePartLinkRecordService
            .list((Wrapper<TechAssembleMachinePartLinkRecord>)new LambdaQueryWrapper<TechAssembleMachinePartLinkRecord>().in(TechAssembleMachinePartLinkRecord::getAssembleRecordId, ids))
            .stream()
            .collect(Collectors.groupingBy(TechAssembleMachinePartLinkRecord::getAssembleRecordId));
         Map<Long, TechAssembleRecord> assembleRecordMap = this.techAssembleRecordService
            .list((Wrapper<TechAssembleRecord>)new LambdaQueryWrapper<TechAssembleRecord>().in(TechAssembleRecord::getId, ids))
            .stream()
            .collect(Collectors.toMap(TechAssembleRecord::getId, Function.identity()));
         techAssembleRecordDTOList.forEach(
            m -> {
               List<TechMachinePartRecordDTO> mTechAssembleRecordDTO = new ArrayList<>();
               List<TechAssembleMachinePartLinkRecord> assembleMachinePartLinkRecords = assembleMachinePartRecordMap.get(m.getId());
               if (!CollectionUtils.isEmpty(assembleMachinePartLinkRecords)) {
                  Map<Long, TechAssembleMachinePartLinkRecord> assembleMachinePartLinkRecordMap = assembleMachinePartLinkRecords.stream()
                     .collect(Collectors.toMap(TechAssembleMachinePartLinkRecord::getMachinePartRecordId, Function.identity()));
                  TechAssembleRecord assembleRecord = assembleRecordMap.get(m.getId());
                  m.getTechAssembleRecordDTO().forEach(n -> {
                     TechAssembleMachinePartLinkRecord assembleMachinePartLinkRecord = assembleMachinePartLinkRecordMap.get(n.getId());
                     int partQuantity = assembleMachinePartLinkRecord.getQuantity() * assembleRecord.getQuantity();
                     n.setBooInventory(m.getBooInventory());
                     n.setComboId(m.getId().toString());
                     n.setQuantity(partQuantity);
                     n.setSpecPrefix(m.getSpecPrefix());
                     n.setUnitQuantity(m.getQuantity());
                     n.setNewSpecification(m.getSpecification().substring(m.getSpecPrefix().length(), m.getSpecification().length()));
                     n.setAssembleConfigId(m.getAssembleConfigId());
                     if (n.getName().equals(FlankPlateTypeEnum.FLANK_PLATE_TYPE_2.getFlankPlateTypeName())) {
                        n.setFlankPlateType(2);
                     } else {
                        n.setFlankPlateType(1);
                     }

                     n.setUnitId(m.getId());
                     techAssembleRecordNewDTO.add(n);
                     mTechAssembleRecordDTO.add(n);
                  });
                  m.setTechAssembleRecordDTO(mTechAssembleRecordDTO);
               }
            }
         );
      }

      techAssembleMachinePartRecordDTO.setTechAssembleRecordNewDTO(techAssembleRecordNewDTO);
      return techAssembleMachinePartRecordDTO;
   }

   @Override
   public List<String> getMachineSpecification(Long artifactId) {
      List<TechAssembleDetailRecord> techAssembleDetailRecordList = this.techAssembleDetailRecordService
         .list((Wrapper<TechAssembleDetailRecord>)new LambdaQueryWrapper<TechAssembleDetailRecord>().eq(TechAssembleDetailRecord::getArtifactRecordId, artifactId));
      if (CollectionUtils.isNotEmpty(techAssembleDetailRecordList)) {
         List<Long> assembleRecordIdList = techAssembleDetailRecordList.stream()
            .map(TechAssembleDetailRecord::getAssembleRecordId)
            .collect(Collectors.toList());
         List<TechAssembleRecord> techAssembleRecordList = this.techAssembleRecordService
            .list((Wrapper<TechAssembleRecord>)new LambdaQueryWrapper<TechAssembleRecord>().in(TechAssembleRecord::getId, assembleRecordIdList));
         if (CollectionUtils.isNotEmpty(techAssembleRecordList)) {
            List<String> specificationList = techAssembleRecordList.stream().map(TechAssembleRecord::getSpecification).collect(Collectors.toList());
            specificationList = specificationList.stream().map(s -> s.replaceAll("[a-zA-Z]", "")).collect(Collectors.toList());
            return specificationList.stream().distinct().collect(Collectors.toList());
         }
      }

      return new ArrayList<>();
   }

   @Override
   public PageVO<MesTechInventoryOperationDTO> getInventoryList(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      String projectName,
      String createUserName,
      String reviewedName,
      Integer buildingType,
      Integer inventoryReviewedEnum,
      Integer pageNumber,
      Integer pageSize
   ) {
      if (projectId != null) {
         ContractProject project = this.projectService.getById(projectId);
         Preconditions.checkArgument(project != null, "查询失败,项目不存在!");
      }

      List<Long> projectIds = null;
      if (StringUtils.isNotBlank(projectName)) {
         projectName = projectName.trim();
         List<ContractProject> projectList = this.projectService
            .list(
               (Wrapper<ContractProject>)((new LambdaQueryWrapper<ContractProject>().like(ContractProject::getName, projectName)).or())
                  .like(ContractProject::getShortName, projectName)
            );
         if (CollectionUtils.isEmpty(projectList)) {
            return new PageVO<>();
         }

         projectIds = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      }

      Page<MesTechInventoryOperationDTO> page = PageHelper.startPage(pageNumber, pageSize);
      List<MesTechInventoryOperation> inventoryOperationList = this.mesTechInventoryOperationService
         .list(
            (Wrapper<MesTechInventoryOperation>)((((((((((new LambdaQueryWrapper<MesTechInventoryOperation>()
                                             .ne(MesTechInventoryOperation::getInventoryReviewedEnum, InventoryReviewedEnum.FIXUP_RECORD.getType()))
                                          .eq(projectId != null, MesTechInventoryOperation::getProjectId, projectId))
                                       .in(CollectionUtils.isNotEmpty(projectIds), MesTechInventoryOperation::getProjectId, projectIds))
                                    .eq(monomerId != null, MesTechInventoryOperation::getMonomerId, monomerId))
                                 .eq(areaId != null, MesTechInventoryOperation::getAreaId, areaId))
                              .eq(areaBatchId != null, MesTechInventoryOperation::getAreaBatchId, areaBatchId))
                           .eq(buildingType != null, MesTechInventoryOperation::getBuildingType, buildingType))
                        .eq(inventoryReviewedEnum != null, MesTechInventoryOperation::getInventoryReviewedEnum, inventoryReviewedEnum))
                     .like(StringUtils.isNotBlank(createUserName), MesTechInventoryOperation::getCreateUserName, createUserName))
                  .like(StringUtils.isNotBlank(reviewedName), MesTechInventoryOperation::getReviewedName, reviewedName))
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (CollectionUtils.isNotEmpty(inventoryOperationList)) {
         Map<Long, ContractProject> projectMap = this.projectService
            .listByIds(inventoryOperationList.stream().map(MesTechInventoryOperation::getProjectId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
         Map<Long, PlanMonomer> monomerMap = this.planMonomerService
            .listByIds(inventoryOperationList.stream().map(MesTechInventoryOperation::getMonomerId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
         Map<Long, PlanArea> areaMap = this.planAreaService
            .listByIds(inventoryOperationList.stream().map(MesTechInventoryOperation::getAreaId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(PlanArea::getId, Function.identity()));
         new HashMap();
         new HashMap();
         Map<Long, PlanAreaBatch> areaBatchMap = this.planAreaBatchService
            .listByIds(inventoryOperationList.stream().map(MesTechInventoryOperation::getAreaBatchId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(PlanAreaBatch::getId, Function.identity()));
         Map<Long, List<TechArtifactRecord>> artifactRecordMap = this.artifactRecordService
            .list(
               (Wrapper<TechArtifactRecord>)new LambdaQueryWrapper<TechArtifactRecord>()
                  .in(
                     TechArtifactRecord::getInventoryOperationId,
                     inventoryOperationList.stream().map(MesTechInventoryOperation::getId).collect(Collectors.toList())
                  )
            )
            .stream()
            .collect(Collectors.groupingBy(TechArtifactRecord::getInventoryOperationId));
         Map<Long, PlanAreaBatch> finalAreaBatchMap = areaBatchMap;
         Map<Long, List<TechArtifactRecord>> finalArtifactRecordMap = artifactRecordMap;
         return new PageVO<>(
            page,
            inventoryOperationList.stream()
               .map(
                  e -> {
                     MesTechInventoryOperationDTO inventoryOperationDTO = BeanUtil.copy(e, MesTechInventoryOperationDTO.class);
                     ContractProject project = projectMap.get(e.getProjectId());
                     PlanMonomer monomer = monomerMap.get(e.getMonomerId());
                     PlanArea area = areaMap.get(e.getAreaId());
                     List<TechArtifactRecord> artifactRecordList = Collections.emptyList();
                     artifactRecordList = finalArtifactRecordMap.get(e.getId());

                     inventoryOperationDTO.setProjectInfo(
                        ProjectInfo.builder().serialNumber(project.getSerialNumber()).name(project.getName()).shortName(project.getShortName()).build()
                     );
                     inventoryOperationDTO.setMonomer(NameInfo.builder().name(monomer.getName()).build());
                     inventoryOperationDTO.setArea(NameInfo.builder().name(area.getName()).build());
                     if (!inventoryOperationDTO.getBuildingType().equals(InventoryTypeEnum.ENCLOSURE.getType())) {
                        Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactRecordList), "查询失败,导入的构件清单不存在!");
                        inventoryOperationDTO.setTotalQuantity(artifactRecordList.stream().mapToInt(TechArtifactRecord::getQuantity).sum());
                        inventoryOperationDTO.setTotalWeight(
                           artifactRecordList.stream().map(TechArtifactRecord::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add)
                        );
                        inventoryOperationDTO.setTotalGrossWeight(
                           artifactRecordList.stream().map(TechArtifactRecord::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add)
                        );
                        PlanAreaBatch areaBatch = finalAreaBatchMap.get(e.getAreaBatchId());
                        if (areaBatch != null) {
                           inventoryOperationDTO.setAreaBatch(NameInfo.builder().name(areaBatch.getName()).build());
                        }
                     }

                     return inventoryOperationDTO;
                  }
               )
               .sorted(Comparator.comparing(MesTechInventoryOperationDTO::getInventoryReviewedEnum))
               .collect(Collectors.toList())
         );
      } else {
         return new PageVO<>();
      }
   }

   @Override
   public PageVO<TechArtifactRecordDTO> getInventoryDetailList(Long inventoryId, Integer pageNumber, Integer pageSize) {
      MesTechInventoryOperation inventoryOperation = this.mesTechInventoryOperationService.getById(inventoryId);
      Preconditions.checkArgument(inventoryOperation != null, "操作失败,清单导入审核记录不存在!");
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<TechArtifactRecord> artifactRecordList = this.artifactRecordService
         .list((Wrapper<TechArtifactRecord>)new LambdaQueryWrapper<TechArtifactRecord>().eq(TechArtifactRecord::getInventoryOperationId, inventoryId));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactRecordList), "操作失败,导入的构件清单记录不存在!");
      List<TechArtifactRecordDTO> techArtifactRecordDTOS = cn.hutool.core.bean.BeanUtil.copyToList(artifactRecordList, TechArtifactRecordDTO.class);
      return new PageVO<>(page, techArtifactRecordDTOS);
   }

   @Override
   public void exportInventoryDetailList(Long inventoryId, HttpServletResponse response) {
      MesTechInventoryOperation inventoryOperation = this.mesTechInventoryOperationService.getById(inventoryId);
      Preconditions.checkArgument(inventoryOperation != null, "操作失败,清单导入审核记录不存在!");
      ContractProject project = this.projectService.getById(inventoryOperation.getProjectId());
      PlanMonomer monomer = this.planMonomerService.getById(inventoryOperation.getMonomerId());
      PlanArea area = this.planAreaService.getById(inventoryOperation.getAreaId());
      PlanAreaBatch areaBatch = this.planAreaBatchService.getById(inventoryOperation.getAreaBatchId());
      String title = project.getName() + " - " + monomer.getName() + " - " + area.getName() + "-" + areaBatch.getName();
      String sheetName = "构件零件清单导入审核";
      String fileName = "构件零件清单导入审核.xlsx";
      List<TechArtifactRecord> artifactRecordList = this.artifactRecordService
         .list((Wrapper<TechArtifactRecord>)new LambdaQueryWrapper<TechArtifactRecord>().eq(TechArtifactRecord::getInventoryOperationId, inventoryId));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactRecordList), "下载失败,导入的构件清单记录不存在!");
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
         .list((Wrapper<TechAssembleDetailRecord>)new LambdaQueryWrapper<TechAssembleDetailRecord>().eq(TechAssembleDetailRecord::getInventoryOperationId, inventoryId))
         .stream()
         .collect(Collectors.groupingBy(TechAssembleDetailRecord::getArtifactRecordId));
      Map<Long, List<TechArtifactMachinePartLinkRecord>> partLinkRecordMap = this.artifactMachinePartLinkRecordService
         .list((Wrapper<TechArtifactMachinePartLinkRecord>)new LambdaQueryWrapper<TechArtifactMachinePartLinkRecord>().eq(TechArtifactMachinePartLinkRecord::getInventoryOperationId, inventoryId))
         .stream()
         .collect(Collectors.groupingBy(TechArtifactMachinePartLinkRecord::getArtifactRecordId));
      Map<Long, List<TechAssembleMachinePartLinkRecord>> assembleMachinePartLinkRecordMap = this.assembleMachinePartLinkRecordService
         .list((Wrapper<TechAssembleMachinePartLinkRecord>)new LambdaQueryWrapper<TechAssembleMachinePartLinkRecord>().eq(TechAssembleMachinePartLinkRecord::getInventoryOperationId, inventoryId))
         .stream()
         .collect(Collectors.groupingBy(TechAssembleMachinePartLinkRecord::getAssembleRecordId));
      Map<Long, List<TechArtifactStandardPartLinkRecord>> standardPartLinkRecordMap = this.artifactStandardPartLinkRecordService
         .list(
            (Wrapper<TechArtifactStandardPartLinkRecord>)new LambdaQueryWrapper<TechArtifactStandardPartLinkRecord>().eq(TechArtifactStandardPartLinkRecord::getInventoryOperationId, inventoryId)
         )
         .stream()
         .collect(Collectors.groupingBy(TechArtifactStandardPartLinkRecord::getArtifactRecordId));
      AtomicInteger orderNo = new AtomicInteger(1);
      List<InventoryExportBaseCommonTemplateDTO> exportDTOList = new ArrayList<>();

      for (TechArtifactRecord artifactRecord : artifactRecordList) {
         InventoryExportBaseCommonTemplateDTO exportTemplateDTO = BeanUtil.copy(artifactRecord, InventoryExportBaseCommonTemplateDTO.class);
         exportTemplateDTO.setArtifactNo(artifactRecord.getSerialNumber());
         exportTemplateDTO.setSerialNumber(null);
         exportTemplateDTO.setOrderNo(orderNo.getAndIncrement());
         exportTemplateDTO.setSurfaceArea(exportTemplateDTO.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 5, 4));
         exportDTOList.add(exportTemplateDTO);
         if (CollectionUtils.isNotEmpty(partLinkRecordMap)) {
            List<TechArtifactMachinePartLinkRecord> partLinkRecordList = partLinkRecordMap.get(artifactRecord.getId());
            if (CollectionUtils.isNotEmpty(partLinkRecordList)) {
               Preconditions.checkArgument(CollectionUtils.isNotEmpty(machinePartRecordMap), "下载失败,导入的零件不存在!");

               for (TechArtifactMachinePartLinkRecord machinePartLinkRecord : partLinkRecordList) {
                  TechMachinePartRecord machinePartRecord = machinePartRecordMap.get(machinePartLinkRecord.getMachinePartRecordId());
                  Preconditions.checkArgument(machinePartRecord != null, "下载失败,导入的零件不存在!");
                  InventoryExportBaseCommonTemplateDTO partExportTemplateDTO = BeanUtil.copy(machinePartRecord, InventoryExportBaseCommonTemplateDTO.class);
                  partExportTemplateDTO.setSerialNumber(machinePartRecord.getSerialNumber());
                  partExportTemplateDTO.setOrderNo(orderNo.getAndIncrement());
                  partExportTemplateDTO.setQuantity(machinePartLinkRecord.getQuantity() * artifactRecord.getQuantity());
                  partExportTemplateDTO.setTotalGrossWeight(
                     partExportTemplateDTO.getGrossWeight().multiply(BigDecimal.valueOf(partExportTemplateDTO.getQuantity().intValue()))
                  );
                  partExportTemplateDTO.setTotalNetWeight(
                     partExportTemplateDTO.getNetWeight().multiply(BigDecimal.valueOf(partExportTemplateDTO.getQuantity().intValue()))
                  );
                  if (partExportTemplateDTO.getSurfaceArea() != null) {
                     partExportTemplateDTO.setSurfaceArea(partExportTemplateDTO.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 5, 4));
                  }

                  exportDTOList.add(partExportTemplateDTO);
               }
            }
         }

         if (CollectionUtils.isNotEmpty(assembleDetailRecordMap)) {
            List<TechAssembleDetailRecord> assembleDetailRecords = assembleDetailRecordMap.get(artifactRecord.getId());
            if (CollectionUtils.isNotEmpty(assembleDetailRecords)) {
               Preconditions.checkArgument(CollectionUtils.isNotEmpty(assembleRecordMap), "下载失败,导入的部件清单不存在!");

               for (TechAssembleDetailRecord detailRecord : assembleDetailRecords) {
                  TechAssembleRecord techAssembleRecord = assembleRecordMap.get(detailRecord.getAssembleRecordId());
                  Preconditions.checkArgument(techAssembleRecord != null, "下载失败,导入的部件清单不存在!");
                  InventoryExportBaseCommonTemplateDTO assembleExportTemplateDTO = BeanUtil.copy(techAssembleRecord, InventoryExportBaseCommonTemplateDTO.class);
                  if (inventoryOperation.getBuildingType().equals(InventoryTypeEnum.BRIDGE.getType())) {
                     assembleExportTemplateDTO.setElementSn(techAssembleRecord.getSerialNumber());
                     assembleExportTemplateDTO.setSerialNumber(null);
                  }

                  assembleExportTemplateDTO.setQuantity(detailRecord.getQuantity() * artifactRecord.getQuantity());
                  assembleExportTemplateDTO.setTotalGrossWeight(
                     assembleExportTemplateDTO.getGrossWeight().multiply(BigDecimal.valueOf(assembleExportTemplateDTO.getQuantity().intValue()))
                  );
                  assembleExportTemplateDTO.setTotalNetWeight(
                     assembleExportTemplateDTO.getNetWeight().multiply(BigDecimal.valueOf(assembleExportTemplateDTO.getQuantity().intValue()))
                  );
                  assembleExportTemplateDTO.setOrderNo(orderNo.getAndIncrement());
                  if (assembleExportTemplateDTO.getSurfaceArea() != null) {
                     assembleExportTemplateDTO.setSurfaceArea(assembleExportTemplateDTO.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 5, 4));
                  }

                  exportDTOList.add(assembleExportTemplateDTO);
                  if (CollectionUtils.isNotEmpty(assembleMachinePartLinkRecordMap)) {
                     List<TechAssembleMachinePartLinkRecord> assembleMachinePartLinkRecordList = assembleMachinePartLinkRecordMap.get(
                        techAssembleRecord.getId()
                     );
                     if (CollectionUtils.isNotEmpty(assembleMachinePartLinkRecordList)) {
                        Preconditions.checkArgument(CollectionUtils.isNotEmpty(machinePartRecordMap), "下载失败,导入的零件不存在!");

                        for (TechAssembleMachinePartLinkRecord assembleMachinePartLinkRecord : assembleMachinePartLinkRecordList) {
                           TechMachinePartRecord machinePartRecord = machinePartRecordMap.get(assembleMachinePartLinkRecord.getMachinePartRecordId());
                           Preconditions.checkArgument(machinePartRecord != null, "下载失败,导入的零件不存在!");
                           InventoryExportBaseCommonTemplateDTO partExportTemplateDTO = BeanUtil.copy(
                              machinePartRecord, InventoryExportBaseCommonTemplateDTO.class
                           );
                           partExportTemplateDTO.setQuantity(assembleMachinePartLinkRecord.getQuantity() * assembleExportTemplateDTO.getQuantity());
                           partExportTemplateDTO.setTotalGrossWeight(
                              partExportTemplateDTO.getGrossWeight().multiply(BigDecimal.valueOf(partExportTemplateDTO.getQuantity().intValue()))
                           );
                           partExportTemplateDTO.setTotalNetWeight(
                              partExportTemplateDTO.getNetWeight().multiply(BigDecimal.valueOf(partExportTemplateDTO.getQuantity().intValue()))
                           );
                           partExportTemplateDTO.setOrderNo(orderNo.getAndIncrement());
                           if (partExportTemplateDTO.getSurfaceArea() != null) {
                              partExportTemplateDTO.setSurfaceArea(partExportTemplateDTO.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 5, 4));
                           }

                           exportDTOList.add(partExportTemplateDTO);
                        }
                     }
                  }
               }
            }
         }

         if (CollectionUtils.isNotEmpty(standardPartLinkRecordMap)) {
            List<TechArtifactStandardPartLinkRecord> standardPartLinkRecords = standardPartLinkRecordMap.get(artifactRecord.getId());
            if (CollectionUtils.isNotEmpty(standardPartLinkRecords)) {
               Preconditions.checkArgument(CollectionUtils.isNotEmpty(standardPartRecordMap), "下载失败,导入的配套件不存在!");

               for (TechArtifactStandardPartLinkRecord standardPartLinkRecord : standardPartLinkRecords) {
                  TechStandardPartRecord techStandardPartRecord = standardPartRecordMap.get(standardPartLinkRecord.getStandardPartRecordId());
                  Preconditions.checkArgument(techStandardPartRecord != null, "操作失败,导入的配套件不存在!");
                  InventoryExportBaseCommonTemplateDTO standardExportTemplateDTO = BeanUtil.copy(
                     techStandardPartRecord, InventoryExportBaseCommonTemplateDTO.class
                  );
                  standardExportTemplateDTO.setQuantity(standardPartLinkRecord.getQuantity() * artifactRecord.getQuantity());
                  standardExportTemplateDTO.setTotalGrossWeight(
                     standardExportTemplateDTO.getGrossWeight() == null
                        ? BigDecimal.ZERO
                        : standardExportTemplateDTO.getGrossWeight().multiply(BigDecimal.valueOf(standardExportTemplateDTO.getQuantity().intValue()))
                  );
                  standardExportTemplateDTO.setTotalNetWeight(
                     standardExportTemplateDTO.getNetWeight() == null
                        ? BigDecimal.ZERO
                        : standardExportTemplateDTO.getNetWeight().multiply(BigDecimal.valueOf(standardExportTemplateDTO.getQuantity().intValue()))
                  );
                  standardExportTemplateDTO.setOrderNo(orderNo.getAndIncrement());
                  exportDTOList.add(standardExportTemplateDTO);
               }
            }
         }
      }

      if (CollectionUtils.isNotEmpty(exportDTOList)) {
         exportDTOList.forEach(e -> {
            if (e.getSurfaceArea() != null && e.getSurfaceArea().compareTo(BigDecimal.ZERO) == 0) {
               e.setSurfaceArea(BigDecimal.ZERO);
            }

            if (e.getSurfaceArea() != null && e.getSurfaceArea().compareTo(BigDecimal.ZERO) != 0) {
               e.setTotalSurfaceArea(e.getSurfaceArea().multiply(BigDecimal.valueOf(e.getQuantity().intValue())));
            }

            if (e.getTopFlangeArea() != null && e.getTopFlangeArea().compareTo(BigDecimal.ZERO) == 0) {
               e.setTopFlangeArea(BigDecimal.ZERO);
            }

            if (e.getTopFlangeArea() != null && e.getTopFlangeArea().compareTo(BigDecimal.ZERO) != 0) {
               e.setTopFlangeArea(e.getTopFlangeArea().multiply(BigDecimal.valueOf(e.getQuantity().intValue())).divide(BigDecimal.valueOf(1000000L)));
            }

            if (e.getTopPaintArea() != null && e.getTopPaintArea().compareTo(BigDecimal.ZERO) != 0) {
               e.setTopPaintArea(e.getTopPaintArea().multiply(BigDecimal.valueOf(e.getQuantity().intValue())).divide(BigDecimal.valueOf(1000000L)));
            }

            if (e.getInnerPaintArea() != null && e.getInnerPaintArea().compareTo(BigDecimal.ZERO) != 0) {
               e.setInnerPaintArea(e.getInnerPaintArea().multiply(BigDecimal.valueOf(e.getQuantity().intValue())));
               if (inventoryOperation.getBuildingType().equals(InventoryTypeEnum.BRIDGE.getType())) {
                  e.setInnerPaintArea(e.getInnerPaintArea().divide(BigDecimal.valueOf(1000000L)));
               }
            }

            if (e.getOuterPaintArea() != null && e.getOuterPaintArea().compareTo(BigDecimal.ZERO) != 0) {
               e.setOuterPaintArea(e.getOuterPaintArea().multiply(BigDecimal.valueOf(e.getQuantity().intValue())));
               if (inventoryOperation.getBuildingType().equals(InventoryTypeEnum.BRIDGE.getType())) {
                  e.setOuterPaintArea(e.getOuterPaintArea().divide(BigDecimal.valueOf(1000000L)));
               }
            }

            if (e.getURibPaintArea() != null && e.getURibPaintArea().compareTo(BigDecimal.ZERO) != 0) {
               e.setURibPaintArea(e.getURibPaintArea().multiply(BigDecimal.valueOf(e.getQuantity().intValue())).divide(BigDecimal.valueOf(1000000L)));
               e.setUbPaintArea(e.getUbPaintArea());
            }
         });
      }

      if (inventoryOperation.getBuildingType().equals(InventoryTypeEnum.BRIDGE.getType())) {
         List<InventoryBridgeExportTemplateDTO> templateDTOS = cn.hutool.core.bean.BeanUtil.copyToList(exportDTOList, InventoryBridgeExportTemplateDTO.class);
         PoiUtils.exportExcel(templateDTOS, title, sheetName, InventoryBridgeExportTemplateDTO.class, fileName, ExcelType.XSSF, response);
      } else if (inventoryOperation.getBuildingType().equals(InventoryTypeEnum.GRID.getType())) {
         List<InventoryGridExportTemplateDTO> templateDTOS = cn.hutool.core.bean.BeanUtil.copyToList(exportDTOList, InventoryGridExportTemplateDTO.class);
         PoiUtils.exportExcel(templateDTOS, title, sheetName, InventoryGridExportTemplateDTO.class, fileName, ExcelType.XSSF, response);
      } else {
         List<InventoryExportTemplateDTO> templateDTOS = cn.hutool.core.bean.BeanUtil.copyToList(exportDTOList, InventoryExportTemplateDTO.class);
         PoiUtils.exportExcel(templateDTOS, title, sheetName, InventoryExportTemplateDTO.class, fileName, ExcelType.XSSF, response);
      }
   }

   @Override
   public void exportEnclosureInventoryDetailList(Long inventoryId, HttpServletResponse response) {
      MesTechInventoryOperation inventoryOperation = this.mesTechInventoryOperationService.getById(inventoryId);
      Preconditions.checkArgument(inventoryOperation != null, "操作失败,清单导入审核记录不存在!");
      ContractProject project = this.projectService.getById(inventoryOperation.getProjectId());
      PlanMonomer monomer = this.planMonomerService.getById(inventoryOperation.getMonomerId());
      PlanArea area = this.planAreaService.getById(inventoryOperation.getAreaId());
      String title = project.getName() + " - " + monomer.getName() + " - " + area.getName();
      String sheetName = "围护清单导入审核";
      String fileName = "围护清单导入审核.xlsx";
      List<TechEnclosureRecord> enclosureRecordList = this.enclosureRecordService
         .list((Wrapper<TechEnclosureRecord>)new LambdaQueryWrapper<TechEnclosureRecord>().eq(TechEnclosureRecord::getInventoryOperationId, inventoryId));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(enclosureRecordList), "下载失败,导入的围护清单记录不存在!");
      List<SysDictionary> sysDictionaries = this.dictionaryService.listByName("enclosure_type");
      Map<Long, String> enclosureDictMap = sysDictionaries.stream().collect(Collectors.toMap(e -> e.getId(), s -> s.getLabel()));
      AtomicInteger orderNo = new AtomicInteger(1);
      List<InventoryEnclosureExportTemplateDTO> exportDTOList = new ArrayList<>();

      for (TechEnclosureRecord enclosureRecord : enclosureRecordList) {
         InventoryEnclosureExportTemplateDTO exportTemplateDTO = BeanUtil.copy(enclosureRecord, InventoryEnclosureExportTemplateDTO.class);
         exportTemplateDTO.setOrderNo(orderNo.getAndIncrement());
         exportTemplateDTO.setDictionaryName(enclosureDictMap.get(enclosureRecord.getDictionaryId()));
         exportTemplateDTO.setSurfaceArea(exportTemplateDTO.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 6, RoundingMode.HALF_UP));
         exportTemplateDTO.setTotalArea(exportTemplateDTO.getTotalArea().divide(BigDecimal.valueOf(1000000L), 6, RoundingMode.HALF_UP));
         exportDTOList.add(exportTemplateDTO);
      }

      PoiUtils.exportExcel(exportDTOList, title, sheetName, InventoryEnclosureExportTemplateDTO.class, fileName, ExcelType.XSSF, response);
   }

   @Override
   public Boolean fixUpRecordInventory(MesTechInventoryOperationDTOParam dtoParam) {
      MesTechInventoryOperation inventoryOperation = this.mesTechInventoryOperationService.getById(dtoParam.getId());
      Preconditions.checkArgument(inventoryOperation != null, "操作失败,导入的清单记录不存在!");
      Preconditions.checkArgument(inventoryOperation.getInventoryReviewedEnum().equals(InventoryReviewedEnum.FIXUP_RECORD.getType()), "操作失败,该操作记录已确认过!");
      Preconditions.checkArgument(
         dtoParam.getCheckStatus().equals(InventoryReviewedEnum.REVOKED.getType())
            || dtoParam.getCheckStatus().equals(InventoryReviewedEnum.UNAUDITED.getType()),
         "操作失败,审核状态异常!"
      );
      if (dtoParam.getCheckStatus().equals(InventoryReviewedEnum.REVOKED.getType())) {
         inventoryOperation.setInventoryReviewedEnum(dtoParam.getCheckStatus());
         this.mesTechInventoryOperationService.updateById(inventoryOperation);
         int areaBatchCount = this.artifactService.count(Wrappers.lambdaQuery(TechArtifact.builder().areaBatchId(inventoryOperation.getAreaBatchId()).build()));
         int outboundAreaBatchCount = this.outboundDetailService
            .count(Wrappers.lambdaQuery(MoveOutboundDetail.class).eq(MoveOutboundDetail::getAreaBatchId, inventoryOperation.getAreaBatchId()));
         if (areaBatchCount == 0 && outboundAreaBatchCount == 0) {
            this.planAreaBatchService.removeById(inventoryOperation.getAreaBatchId());
         }

         return Boolean.TRUE;
      } else {
         if (CollectionUtils.isNotEmpty(dtoParam.getParamList())) {
            List<Long> artifactIds = dtoParam.getParamList().stream().map(TechArtifactSpecAmendUpdateVORequest::getArtifactId).collect(Collectors.toList());
            List<TechAssembleDetailRecord> assembleDetailRecordList = this.assembleDetailRecordService
               .list((Wrapper<TechAssembleDetailRecord>)new LambdaQueryWrapper<TechAssembleDetailRecord>().in(TechAssembleDetailRecord::getArtifactRecordId, artifactIds));
            if (CollectionUtils.isNotEmpty(assembleDetailRecordList)) {
               Map<Long, List<TechAssembleDetailRecord>> assembleDetailRecordMap = assembleDetailRecordList.stream()
                  .collect(Collectors.groupingBy(TechAssembleDetailRecord::getArtifactRecordId));
               Map<Long, TechAssembleRecord> assembleRecordMap = this.assembleRecordService
                  .list(
                     (Wrapper<TechAssembleRecord>)(new LambdaQueryWrapper<TechAssembleRecord>()
                           .in(
                              TechAssembleRecord::getId,
                              assembleDetailRecordList.stream().map(TechAssembleDetailRecord::getAssembleRecordId).collect(Collectors.toList())
                           ))
                        .likeRight(TechAssembleRecord::getSerialNumber, "组")
                  )
                  .stream()
                  .collect(Collectors.toMap(TechAssembleRecord::getId, Function.identity()));

               for (TechArtifactSpecAmendUpdateVORequest techArtifactSpecAmendUpdateVORequest : dtoParam.getParamList()) {
                  if (techArtifactSpecAmendUpdateVORequest.getPlJudge()) {
                     TechArtifactRecord techArtifactRecord = this.techArtifactRecordService.getById(techArtifactSpecAmendUpdateVORequest.getArtifactId());
                     if (techArtifactRecord != null) {
                        List<TechAssembleDetailRecord> techAssembleDetailRecords = assembleDetailRecordMap.get(techArtifactRecord.getId());
                        if (CollectionUtils.isNotEmpty(techAssembleDetailRecords)
                           && techAssembleDetailRecords.stream().anyMatch(e -> assembleRecordMap.get(e.getAssembleRecordId()) != null)) {
                           techArtifactRecord.setBoolComposeAssemble(true);
                           this.techArtifactRecordService.updateById(techArtifactRecord);
                        }
                     }
                  }
               }
            }
         }

         List<TechArtifactSpecAmend> artifactSpecAmendList = this.artifactSpecAmendService
            .list(
               (Wrapper<TechArtifactSpecAmend>)(new LambdaQueryWrapper<TechArtifactSpecAmend>()
                     .eq(TechArtifactSpecAmend::getInventoryOperationId, inventoryOperation.getId()))
                  .eq(TechArtifactSpecAmend::getBoolAmendStatus, Boolean.FALSE)
            );
         if (CollectionUtils.isNotEmpty(artifactSpecAmendList)) {
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(dtoParam.getParamList()), "操作失败,存在待确认的数据!");
            Preconditions.checkArgument(artifactSpecAmendList.stream().noneMatch(TechArtifactSpecAmend::getBoolAmendStatus), "操作失败,待规格修正的数据异常!");
            this.artifactSpecAmendService.batchUpdateSpecAmenList(dtoParam.getParamList());
         }

         List<TechArtifactSpecAmend> artifactSpecAmends = this.artifactSpecAmendService
            .list(
               (Wrapper<TechArtifactSpecAmend>)(new LambdaQueryWrapper<TechArtifactSpecAmend>()
                     .eq(TechArtifactSpecAmend::getInventoryOperationId, inventoryOperation.getId()))
                  .eq(TechArtifactSpecAmend::getBoolAmendStatus, Boolean.FALSE)
            );
         if (CollectionUtils.isEmpty(artifactSpecAmends)) {
            inventoryOperation.setInventoryReviewedEnum(dtoParam.getCheckStatus());
         }

         this.mesTechInventoryOperationService.updateById(inventoryOperation);
         return Boolean.TRUE;
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean partSave(TechUnitRecordBaseVO unitRecordBaseVO) {
      TechArtifactRecord techArtifactRecord = this.techArtifactRecordService.getById(unitRecordBaseVO.getArtifactId());
      Preconditions.checkArgument(techArtifactRecord != null, "操作失败,所选构件待确认信息不存在!");
      TechArtifactSpecAmend artifactSpecAmend = this.artifactSpecAmendService
         .getOne((Wrapper<TechArtifactSpecAmend>)new LambdaQueryWrapper<TechArtifactSpecAmend>().eq(TechArtifactSpecAmend::getArtifactId, unitRecordBaseVO.getArtifactId()));
      artifactSpecAmend.setNewStructureClassId(unitRecordBaseVO.getArtifactStructureClassId());
      artifactSpecAmend.setNewSpecPrefix(unitRecordBaseVO.getArtifactSpecPrefix());
      this.artifactSpecAmendService.updateById(artifactSpecAmend);
      unitRecordBaseVO.getUnitRecordVOList()
         .forEach(
            unit -> {
               unit.getTechPartRecordVOList().forEach(partx -> {
                  int remainder = partx.getQuantity() % partx.getUnitQuantity();
                  Preconditions.checkArgument(remainder == 0, partx.getSerialNumber() + "组合后的部件数量不符合整除的限制规则!");
               });
               List<TechPartRecordVO> techPartRecordVOList = unit.getTechPartRecordVOList();
               techPartRecordVOList = techPartRecordVOList.stream()
                  .filter(partx -> partx.getFlankPlateType() == 2)
                  .sorted(Comparator.comparing(TechPartRecordVO::getLength).reversed())
                  .collect(Collectors.toList());
               TechPartRecordVO techPartRecordVO = techPartRecordVOList.get(0);
               if (techPartRecordVO.getSerialNumber().endsWith("-腹")) {
                  techPartRecordVO.setSerialNumber("组" + techPartRecordVO.getSerialNumber().substring(0, techPartRecordVO.getSerialNumber().length() - 2));
               }

               List<TechAssembleRecord> techAssembleRecordList = this.techAssembleRecordService
                  .list(
                     (Wrapper<TechAssembleRecord>)(((new LambdaQueryWrapper<TechAssembleRecord>()
                                 .eq(TechAssembleRecord::getMonomerId, techArtifactRecord.getMonomerId()))
                              .eq(TechAssembleRecord::getAreaId, techArtifactRecord.getAreaId()))
                           .eq(TechAssembleRecord::getSerialNumber, techPartRecordVO.getSerialNumber()))
                        .eq(TechAssembleRecord::getInventoryOperationId, techArtifactRecord.getInventoryOperationId())
                  );
               if (CollectionUtils.isNotEmpty(techAssembleRecordList)) {
                  TechAssembleRecord techAssembleRecord = techAssembleRecordList.get(0);
                  List<TechAssembleMachinePartLinkRecord> techAssembleMachinePartLinkRecordList = this.techAssembleMachinePartLinkRecordService
                     .list(
                        (Wrapper<TechAssembleMachinePartLinkRecord>)(new LambdaQueryWrapper<TechAssembleMachinePartLinkRecord>()
                              .eq(TechAssembleMachinePartLinkRecord::getAssembleRecordId, techAssembleRecord.getId()))
                           .eq(TechAssembleMachinePartLinkRecord::getInventoryOperationId, techArtifactRecord.getInventoryOperationId())
                     );
                  if (CollectionUtils.isNotEmpty(techAssembleMachinePartLinkRecordList)) {
                     List<Long> assembleIdList = techAssembleMachinePartLinkRecordList.stream()
                        .map(TechAssembleMachinePartLinkRecord::getMachinePartRecordId)
                        .collect(Collectors.toList());
                     if (assembleIdList.size() != unit.getTechPartRecordVOList().size()) {
                        throw new BusinessException("操作失败,该部件已存在并且原部件与新部件数量不一致!");
                     }

                     List<TechMachinePartRecord> techMachinePartRecordList = this.techMachinePartRecordService
                        .list((Wrapper<TechMachinePartRecord>)new LambdaQueryWrapper<TechMachinePartRecord>().in(TechMachinePartRecord::getId, assembleIdList));
                     boolean flag = false;
                     Map<Long, List<TechAssembleMachinePartLinkRecord>> assembleMachinePartLinkRecordMap = this.techAssembleMachinePartLinkRecordService
                        .list(
                           (Wrapper<TechAssembleMachinePartLinkRecord>)new LambdaQueryWrapper<TechAssembleMachinePartLinkRecord>()
                              .in(
                                 TechAssembleMachinePartLinkRecord::getMachinePartRecordId,
                                 techMachinePartRecordList.stream().map(TechMachinePartRecord::getId).collect(Collectors.toList())
                              )
                        )
                        .stream()
                        .collect(Collectors.groupingBy(TechAssembleMachinePartLinkRecord::getMachinePartRecordId));

                     for (TechMachinePartRecord techMachinePartRecord : techMachinePartRecordList) {
                        int i = 0;

                        for (TechPartRecordVO part : techPartRecordVOList) {
                           i++;
                           if (part.getSerialNumber().startsWith(techMachinePartRecord.getSerialNumber())
                              && techMachinePartRecord.getSpecification().equals(part.getSpecification())
                              && techMachinePartRecord.getMaterial().equals(part.getMaterial())) {
                              TechAssembleMachinePartLinkRecord techAssembleMachinePartLinkRecord = assembleMachinePartLinkRecordMap.getOrDefault(
                                    techMachinePartRecord.getId(), new ArrayList<>()
                                 )
                                 .get(0);
                              Integer outScale = techAssembleMachinePartLinkRecord.getQuantity();
                              Integer newScale = part.getQuantity() / unit.getUnitQuantity();
                              if (outScale.equals(newScale)) {
                                 flag = true;
                                 break;
                              }
                           }

                           if (i == unit.getTechPartRecordVOList().size()) {
                              flag = false;
                           }
                        }
                     }

                     if (!flag) {
                        throw new BusinessException("操作失败,该部件已存在或者原部件与新部件下存在不同零件!");
                     }
                  }
               }

               Map<Long, TechMachinePartRecord> partRecordMap = this.techMachinePartRecordService
                  .listByIds(unit.getTechPartRecordVOList().stream().map(TechPartRecordVO::getId).collect(Collectors.toList()))
                  .stream()
                  .collect(Collectors.toMap(TechMachinePartRecord::getId, Function.identity()));
               TechMachinePartRecord tmpRecord = this.techMachinePartRecordService.getById(techPartRecordVO.getId());
               List<Long> unitIdList = techPartRecordVOList.stream().map(TechPartRecordVO::getUnitId).collect(Collectors.toList());
               unitIdList = unitIdList.stream().distinct().collect(Collectors.toList());
               unitIdList.forEach(
                  unitId -> {
                     this.techAssembleRecordService.remove((Wrapper<TechAssembleRecord>)new LambdaQueryWrapper<TechAssembleRecord>().eq(TechAssembleRecord::getId, unitId));
                     this.techAssembleMachinePartLinkRecordService
                        .remove(
                           (Wrapper<TechAssembleMachinePartLinkRecord>)new LambdaQueryWrapper<TechAssembleMachinePartLinkRecord>()
                              .eq(TechAssembleMachinePartLinkRecord::getAssembleRecordId, unitId)
                        );
                     this.techAssembleDetailRecordService
                        .remove((Wrapper<TechAssembleDetailRecord>)new LambdaQueryWrapper<TechAssembleDetailRecord>().eq(TechAssembleDetailRecord::getAssembleRecordId, unitId));
                  }
               );
               TechAssembleRecord techAssembleRecord = new TechAssembleRecord();
               techAssembleRecord.setBooInventory(false);
               techAssembleRecord.setProjectId(tmpRecord.getProjectId());
               techAssembleRecord.setMonomerId(tmpRecord.getMonomerId());
               techAssembleRecord.setAreaId(tmpRecord.getAreaId());
               techAssembleRecord.setAreaBatchId(tmpRecord.getAreaBatchId());
               techAssembleRecord.setInventoryOperationId(tmpRecord.getInventoryOperationId());
               if (tmpRecord.getSerialNumber().endsWith("-腹")) {
                  techAssembleRecord.setSerialNumber("组" + tmpRecord.getSerialNumber().substring(0, tmpRecord.getSerialNumber().length() - 2));
               } else {
                  techAssembleRecord.setSerialNumber("组" + tmpRecord.getSerialNumber());
               }

               List<TechAssembleRecord> oldAssembleRecords = this.artifactService
                  .getAssembleRecordList(
                     techArtifactRecord.getMonomerId(),
                     techArtifactRecord.getAreaId(),
                     techAssembleRecord.getSerialNumber(),
                     techArtifactRecord.getInventoryOperationId()
                  );
               if (CollectionUtils.isNotEmpty(oldAssembleRecords)) {
                  techAssembleRecord.setSerialNumber(techAssembleRecord.getSerialNumber() + "-" + oldAssembleRecords.size());
               }

               techAssembleRecord.setLength(tmpRecord.getLength());
               techAssembleRecord.setMaterial(tmpRecord.getMaterial());
               BigDecimal netWeight = unit.getTechPartRecordVOList()
                  .stream()
                  .map(vo -> partRecordMap.get(vo.getId()).getNetWeight().multiply(BigDecimal.valueOf(vo.getQuantity() / vo.getUnitQuantity())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal grossWeight = unit.getTechPartRecordVOList()
                  .stream()
                  .map(vo -> partRecordMap.get(vo.getId()).getGrossWeight().multiply(BigDecimal.valueOf(vo.getQuantity() / vo.getUnitQuantity())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               techAssembleRecord.setQuantity(unit.getUnitQuantity() * techArtifactRecord.getQuantity());
               techAssembleRecord.setNetWeight(netWeight);
               techAssembleRecord.setTotalNetWeight(techAssembleRecord.getNetWeight().multiply(new BigDecimal(techAssembleRecord.getQuantity())));
               techAssembleRecord.setGrossWeight(grossWeight);
               techAssembleRecord.setTotalGrossWeight(techAssembleRecord.getGrossWeight().multiply(new BigDecimal(techAssembleRecord.getQuantity())));
               techAssembleRecord.setSurfaceArea(tmpRecord.getSurfaceArea());
               techAssembleRecord.setSpecPrefix(unit.getSpecPrefix());
               techAssembleRecord.setSpecification(unit.getSpecPrefix() + unit.getNewSpecification());
               techAssembleRecord.setAssembleConfigId(unit.getAssembleConfigId());
               techAssembleRecord.setAssembleType(ProductClassificationEnum.ASSEMBLE.getType());
               techAssembleRecord.setBoolMainAssemble(false);
               techAssembleRecord.setUserId(tmpRecord.getUserId());
               this.techAssembleRecordService.save(techAssembleRecord);
               unit.setId(techAssembleRecord.getId());
               TechAssembleDetailRecord techAssembleDetailRecord = new TechAssembleDetailRecord();
               techAssembleDetailRecord.setInventoryOperationId(tmpRecord.getInventoryOperationId());
               techAssembleDetailRecord.setAssembleRecordId(techAssembleRecord.getId());
               techAssembleDetailRecord.setArtifactRecordId(unit.getArtifactId());
               techAssembleDetailRecord.setQuantity(unit.getUnitQuantity());
               techAssembleDetailRecord.setBooInventory(Boolean.FALSE);
               this.techAssembleDetailRecordService.save(techAssembleDetailRecord);
               unit.getTechPartRecordVOList()
                  .forEach(
                     partx -> {
                        TechMachinePartRecord oldTechMachinePartRecord = partRecordMap.get(partx.getId());
                        TechMachinePartRecord techMachinePartRecord = null;
                        if (partx.getId() != null && oldTechMachinePartRecord.getRelationType() != 16) {
                           oldTechMachinePartRecord.setQuantity(oldTechMachinePartRecord.getQuantity() - techArtifactRecord.getQuantity() * partx.getQuantity());
                           Preconditions.checkArgument(oldTechMachinePartRecord.getQuantity() >= 0, "操作失败,数量有误!");
                           oldTechMachinePartRecord.setTotalGrossWeight(
                              oldTechMachinePartRecord.getGrossWeight().multiply(new BigDecimal(oldTechMachinePartRecord.getQuantity()))
                           );
                           oldTechMachinePartRecord.setTotalNetWeight(
                              oldTechMachinePartRecord.getNetWeight().multiply(new BigDecimal(oldTechMachinePartRecord.getQuantity()))
                           );
                           oldTechMachinePartRecord.setComboId(partx.getComboId());
                           this.techMachinePartRecordService.updateById(oldTechMachinePartRecord);
                           techMachinePartRecord = BeanUtil.copy(oldTechMachinePartRecord, TechMachinePartRecord.class);
                           if (partx.getFlankPlateType() == 1) {
                              techMachinePartRecord.setSerialNumber(partx.getSerialNumber() + "-翼");
                              techMachinePartRecord.setName("翼缘板");
                              techMachinePartRecord.setInitialSerialNumber(partx.getSerialNumber());
                              techMachinePartRecord.setSourcePartEnum(SourcePartEnum.COMPONENT_COMBINATION.getType());
                           } else {
                              techMachinePartRecord.setSerialNumber(partx.getSerialNumber() + "-腹");
                              techMachinePartRecord.setName("腹板");
                              techMachinePartRecord.setInitialSerialNumber(partx.getSerialNumber());
                              techMachinePartRecord.setSourcePartEnum(SourcePartEnum.COMPONENT_COMBINATION.getType());
                           }

                           List<TechMachinePartRecord> techMachinePartRecordList = this.techMachinePartRecordService
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
                              techMachinePartRecord.setComboId(partx.getComboId());
                              techMachinePartRecord.setRelationType(16);
                              techMachinePartRecord.setQuantity(techArtifactRecord.getQuantity() * partx.getQuantity());
                              techMachinePartRecord.setTotalGrossWeight(
                                 techMachinePartRecord.getGrossWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                              );
                              techMachinePartRecord.setTotalNetWeight(
                                 techMachinePartRecord.getNetWeight().multiply(new BigDecimal(techMachinePartRecord.getQuantity()))
                              );
                              techMachinePartRecord.setSteelPlateTypeEnum(2);
                              techMachinePartRecord.setCreateTime(null);
                              techMachinePartRecord.setUpdateTime(null);
                              techMachinePartRecord.setOldMachinePartId(techMachinePartRecord.getId());
                              techMachinePartRecord.setId(null);
                              this.techMachinePartRecordService.save(techMachinePartRecord);
                           } else {
                              TechMachinePartRecord techMachinePartRecordOld = techMachinePartRecordList.get(0);
                              techMachinePartRecordOld.setQuantity(
                                 techMachinePartRecordOld.getQuantity() + techArtifactRecord.getQuantity() * partx.getQuantity()
                              );
                              techMachinePartRecordOld.setTotalGrossWeight(
                                 techMachinePartRecordOld.getGrossWeight().multiply(new BigDecimal(techMachinePartRecordOld.getQuantity()))
                              );
                              techMachinePartRecordOld.setTotalNetWeight(
                                 techMachinePartRecordOld.getNetWeight().multiply(new BigDecimal(techMachinePartRecordOld.getQuantity()))
                              );
                              this.techMachinePartRecordService.updateById(techMachinePartRecordOld);
                              techMachinePartRecord.setId(techMachinePartRecordList.get(0).getId());
                           }

                           this.techArtifactMachinePartLinkRecordService
                              .remove(
                                 (Wrapper<TechArtifactMachinePartLinkRecord>)((new LambdaQueryWrapper<TechArtifactMachinePartLinkRecord>()
                                          .eq(TechArtifactMachinePartLinkRecord::getMachinePartRecordId, partx.getId()))
                                       .eq(TechArtifactMachinePartLinkRecord::getInventoryOperationId, tmpRecord.getInventoryOperationId()))
                                    .eq(TechArtifactMachinePartLinkRecord::getArtifactRecordId, techArtifactRecord.getId())
                              );
                        }

                        if (techMachinePartRecord != null) {
                           TechAssembleMachinePartLinkRecord techAssembleMachinePartLinkRecordx = new TechAssembleMachinePartLinkRecord();
                           techAssembleMachinePartLinkRecordx.setInventoryOperationId(tmpRecord.getInventoryOperationId());
                           techAssembleMachinePartLinkRecordx.setAssembleRecordId(techAssembleRecord.getId());
                           techAssembleMachinePartLinkRecordx.setMachinePartRecordId(techMachinePartRecord.getId());
                           int remainder = partx.getQuantity() % partx.getUnitQuantity();
                           Preconditions.checkArgument(remainder == 0, "部件数量异常!");
                           Integer partQuantity = partx.getQuantity() / partx.getUnitQuantity();
                           techAssembleMachinePartLinkRecordx.setQuantity(partQuantity);
                           this.techAssembleMachinePartLinkRecordService.save(techAssembleMachinePartLinkRecordx);
                        }
                     }
                  );
            }
         );
      Long inventoryOperationId = techArtifactRecord.getInventoryOperationId();
      List<TechArtifactSpecUncorrectedDTO> artifactSpecUncorrectedDTOSPL = this.getArtifactSpecUncorrectedDTOSPL(inventoryOperationId);
      if (CollectionUtils.isNotEmpty(artifactSpecUncorrectedDTOSPL)) {
         List<TechArtifactSpecUncorrectedDTO> artifactSpecUncorrectedDTOS = artifactSpecUncorrectedDTOSPL.stream()
            .filter(e -> e.getPartAmendStatus() == null || !e.getPartAmendStatus())
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(artifactSpecUncorrectedDTOS)) {
            List<Long> artifactrecordIdList = artifactSpecUncorrectedDTOS.stream()
               .map(TechArtifactSpecUncorrectedDTO::getArtifactId)
               .collect(Collectors.toList());
            Map<Long, List<TechArtifactMachinePartLinkRecord>> artifactMachinePartLinkRecordListMap = this.techArtifactMachinePartLinkRecordService
               .list(
                  (Wrapper<TechArtifactMachinePartLinkRecord>)new LambdaQueryWrapper<TechArtifactMachinePartLinkRecord>()
                     .in(TechArtifactMachinePartLinkRecord::getArtifactRecordId, artifactrecordIdList)
               )
               .stream()
               .collect(Collectors.groupingBy(TechArtifactMachinePartLinkRecord::getArtifactRecordId));
            Map<Long, TechArtifactRecord> artifactRecordMap = this.techArtifactRecordService
               .listByIds(artifactrecordIdList)
               .stream()
               .collect(Collectors.toMap(TechArtifactRecord::getId, Function.identity()));
            List<Long> partRecordIds = unitRecordBaseVO.getUnitRecordVOList()
               .stream()
               .flatMap(e -> e.getTechPartRecordVOList().stream().map(TechPartRecordVO::getId))
               .collect(Collectors.toList());
            Map<Long, TechMachinePartRecord> machinePartRecordMap = this.techMachinePartRecordService
               .listByIds(partRecordIds)
               .stream()
               .collect(Collectors.toMap(TechMachinePartRecord::getId, Function.identity()));
            Map<Long, TechArtifactSpecAmend> artifactSpecAmendMap = this.artifactSpecAmendService
               .list((Wrapper<TechArtifactSpecAmend>)new LambdaQueryWrapper<TechArtifactSpecAmend>().in(TechArtifactSpecAmend::getArtifactId, artifactrecordIdList))
               .stream()
               .collect(Collectors.toMap(TechArtifactSpecAmend::getArtifactId, Function.identity()));
            artifactSpecUncorrectedDTOS.forEach(
               artifactSpecUncorrectedDTO -> {
                  Long artifactId = artifactSpecUncorrectedDTO.getArtifactId();
                  List<TechArtifactMachinePartLinkRecord> techArtifactMachinePartLinkRecordList = artifactMachinePartLinkRecordListMap.get(artifactId);
                  List<TechSerialNumberQuantityVO> techSerialNumberQuantityVOList = new ArrayList<>();
                  Map<Long, TechMachinePartRecord> partRecordMap = this.techMachinePartRecordService
                     .listByIds(
                        techArtifactMachinePartLinkRecordList.stream()
                           .map(TechArtifactMachinePartLinkRecord::getMachinePartRecordId)
                           .collect(Collectors.toList())
                     )
                     .stream()
                     .collect(Collectors.toMap(TechMachinePartRecord::getId, Function.identity()));

                  for (TechArtifactMachinePartLinkRecord techArtifactMachinePartLinkRecord : techArtifactMachinePartLinkRecordList) {
                     TechMachinePartRecord techMachinePartRecord = partRecordMap.get(techArtifactMachinePartLinkRecord.getMachinePartRecordId());
                     TechSerialNumberQuantityVO techSerialNumberQuantityVO = new TechSerialNumberQuantityVO();
                     techSerialNumberQuantityVO.setSerialNumber(techMachinePartRecord.getSerialNumber());
                     techSerialNumberQuantityVO.setQuantity(techArtifactMachinePartLinkRecord.getQuantity());
                     techSerialNumberQuantityVO.setArtifactRecordId(techArtifactMachinePartLinkRecord.getArtifactRecordId());
                     techSerialNumberQuantityVOList.add(techSerialNumberQuantityVO);
                  }

                  unitRecordBaseVO.getUnitRecordVOList()
                     .forEach(
                        unit -> {
                           List<TechPartRecordVO> techPartRecordVOList = unit.getTechPartRecordVOList();
                           List<TechSerialNumberQuantityVO> techSerialNumberQuantityVONewList = new ArrayList<>();

                           for (TechPartRecordVO techPartRecordVO : techPartRecordVOList) {
                              TechSerialNumberQuantityVO techSerialNumberQuantityVOxx = new TechSerialNumberQuantityVO();
                              techSerialNumberQuantityVOxx.setSerialNumber(techPartRecordVO.getSerialNumber());
                              techSerialNumberQuantityVOxx.setQuantity(techPartRecordVO.getQuantity());
                              techSerialNumberQuantityVOxx.setArtifactRecordId(unit.getArtifactId());
                              techSerialNumberQuantityVONewList.add(techSerialNumberQuantityVOxx);
                           }

                           int judgeNumber = 0;

                           for (TechSerialNumberQuantityVO techSerialNumberQuantityVOx : techSerialNumberQuantityVONewList) {
                              for (TechSerialNumberQuantityVO obj : techSerialNumberQuantityVOList) {
                                 String serialNumberA = techSerialNumberQuantityVOx.getSerialNumber();
                                 String serialNumberB = obj.getSerialNumber();
                                 if (serialNumberA.contains("-腹")) {
                                    serialNumberA = serialNumberA.split("-腹")[0];
                                 }

                                 if (serialNumberB.contains("-腹")) {
                                    serialNumberB = serialNumberB.split("-腹")[0];
                                 }

                                 if (serialNumberA.contains("-翼")) {
                                    serialNumberA = serialNumberA.split("-翼")[0];
                                 }

                                 if (serialNumberB.contains("-翼")) {
                                    serialNumberB = serialNumberB.split("-翼")[0];
                                 }

                                 if (serialNumberA.equals(serialNumberB)
                                    && !techSerialNumberQuantityVOx.getArtifactRecordId().equals(obj.getArtifactRecordId())
                                    && obj.getQuantity().equals(techSerialNumberQuantityVOx.getQuantity())) {
                                    judgeNumber++;
                                 }
                              }
                           }

                           if (judgeNumber == techSerialNumberQuantityVONewList.size()) {
                              unit.setArtifactId(artifactId);
                              TechArtifactRecord techArtifactRecordNew = artifactRecordMap.get(artifactId);
                              TechArtifactSpecAmend techArtifactSpecAmend = artifactSpecAmendMap.get(artifactId);
                              techArtifactSpecAmend.setNewStructureClassId(unitRecordBaseVO.getArtifactStructureClassId());
                              techArtifactSpecAmend.setNewSpecPrefix(unitRecordBaseVO.getArtifactSpecPrefix());
                              techPartRecordVOList = techPartRecordVOList.stream()
                                 .filter(part -> part.getFlankPlateType() == 2)
                                 .sorted(Comparator.comparing(TechPartRecordVO::getLength).reversed())
                                 .collect(Collectors.toList());
                              TechPartRecordVO techPartRecordVO = techPartRecordVOList.get(0);
                              TechMachinePartRecord tmpRecord = machinePartRecordMap.get(techPartRecordVO.getId());
                              TechAssembleRecord techAssembleRecord = new TechAssembleRecord();
                              techAssembleRecord.setBooInventory(false);
                              techAssembleRecord.setProjectId(tmpRecord.getProjectId());
                              techAssembleRecord.setMonomerId(tmpRecord.getMonomerId());
                              techAssembleRecord.setAreaId(tmpRecord.getAreaId());
                              techAssembleRecord.setAreaBatchId(tmpRecord.getAreaBatchId());
                              techAssembleRecord.setInventoryOperationId(tmpRecord.getInventoryOperationId());
                              techAssembleRecord.setSerialNumber("组" + tmpRecord.getSerialNumber());
                              List<TechAssembleRecord> oldAssembleRecords = this.artifactService
                                 .getAssembleRecordList(
                                    techArtifactRecord.getMonomerId(),
                                    techArtifactRecord.getAreaId(),
                                    techAssembleRecord.getSerialNumber(),
                                    techArtifactRecord.getInventoryOperationId()
                                 );
                              if (CollectionUtils.isNotEmpty(oldAssembleRecords)) {
                                 techAssembleRecord.setSerialNumber(techAssembleRecord.getSerialNumber() + "-" + oldAssembleRecords.size());
                              }

                              techAssembleRecord.setLength(tmpRecord.getLength());
                              techAssembleRecord.setMaterial(tmpRecord.getMaterial());
                              BigDecimal netWeight = unit.getTechPartRecordVOList()
                                 .stream()
                                 .map(
                                    vo -> machinePartRecordMap.get(vo.getId())
                                       .getNetWeight()
                                       .multiply(BigDecimal.valueOf(vo.getQuantity() / vo.getUnitQuantity()))
                                 )
                                 .reduce(BigDecimal.ZERO, BigDecimal::add);
                              BigDecimal grossWeight = unit.getTechPartRecordVOList()
                                 .stream()
                                 .map(
                                    vo -> machinePartRecordMap.get(vo.getId())
                                       .getNetWeight()
                                       .multiply(BigDecimal.valueOf(vo.getQuantity() / vo.getUnitQuantity()))
                                 )
                                 .reduce(BigDecimal.ZERO, BigDecimal::add);
                              techAssembleRecord.setQuantity(unit.getUnitQuantity() * techArtifactRecordNew.getQuantity());
                              techAssembleRecord.setNetWeight(netWeight);
                              techAssembleRecord.setTotalNetWeight(techAssembleRecord.getNetWeight().multiply(new BigDecimal(techAssembleRecord.getQuantity())));
                              techAssembleRecord.setGrossWeight(grossWeight);
                              techAssembleRecord.setTotalGrossWeight(
                                 techAssembleRecord.getGrossWeight().multiply(new BigDecimal(techAssembleRecord.getQuantity()))
                              );
                              techAssembleRecord.setSurfaceArea(tmpRecord.getSurfaceArea());
                              techAssembleRecord.setSpecPrefix(unit.getSpecPrefix());
                              techAssembleRecord.setSpecification(unit.getSpecPrefix() + unit.getNewSpecification());
                              techAssembleRecord.setAssembleConfigId(unit.getAssembleConfigId());
                              techAssembleRecord.setAssembleType(4);
                              techAssembleRecord.setBoolMainAssemble(false);
                              techAssembleRecord.setUserId(tmpRecord.getUserId());
                              this.techAssembleRecordService.save(techAssembleRecord);
                              TechAssembleDetailRecord techAssembleDetailRecord = new TechAssembleDetailRecord();
                              techAssembleDetailRecord.setInventoryOperationId(tmpRecord.getInventoryOperationId());
                              techAssembleDetailRecord.setAssembleRecordId(techAssembleRecord.getId());
                              techAssembleDetailRecord.setArtifactRecordId(unit.getArtifactId());
                              techAssembleDetailRecord.setQuantity(unit.getUnitQuantity());
                              techAssembleDetailRecord.setBooInventory(Boolean.FALSE);
                              this.techAssembleDetailRecordService.save(techAssembleDetailRecord);
                              unit.getTechPartRecordVOList()
                                 .forEach(
                                    part -> {
                                       TechMachinePartRecord oldTechMachinePartRecord = machinePartRecordMap.get(part.getId());
                                       TechMachinePartRecord techMachinePartRecordx = null;
                                       if (part.getId() != null && oldTechMachinePartRecord.getRelationType() != 16) {
                                          oldTechMachinePartRecord.setQuantity(
                                             oldTechMachinePartRecord.getQuantity() - techArtifactRecordNew.getQuantity() * part.getQuantity()
                                          );
                                          oldTechMachinePartRecord.setTotalGrossWeight(
                                             oldTechMachinePartRecord.getGrossWeight().multiply(new BigDecimal(oldTechMachinePartRecord.getQuantity()))
                                          );
                                          oldTechMachinePartRecord.setTotalNetWeight(
                                             oldTechMachinePartRecord.getNetWeight().multiply(new BigDecimal(oldTechMachinePartRecord.getQuantity()))
                                          );
                                          oldTechMachinePartRecord.setComboId(part.getComboId());
                                          this.techMachinePartRecordService.updateById(oldTechMachinePartRecord);
                                          techMachinePartRecordx = BeanUtil.copy(oldTechMachinePartRecord, TechMachinePartRecord.class);
                                          if (part.getFlankPlateType() == 1) {
                                             techMachinePartRecordx.setSerialNumber(part.getSerialNumber() + "-翼");
                                             techMachinePartRecordx.setName("翼缘板");
                                             techMachinePartRecordx.setInitialSerialNumber(part.getSerialNumber());
                                             techMachinePartRecordx.setSourcePartEnum(SourcePartEnum.COMPONENT_COMBINATION.getType());
                                          } else {
                                             techMachinePartRecordx.setSerialNumber(part.getSerialNumber() + "-腹");
                                             techMachinePartRecordx.setName("腹板");
                                             techMachinePartRecordx.setInitialSerialNumber(part.getSerialNumber());
                                             techMachinePartRecordx.setSourcePartEnum(SourcePartEnum.COMPONENT_COMBINATION.getType());
                                          }

                                          techMachinePartRecordx.setComboId(part.getComboId());
                                          techMachinePartRecordx.setRelationType(16);
                                          techMachinePartRecordx.setSteelPlateTypeEnum(2);
                                          techMachinePartRecordx.setCreateTime(null);
                                          techMachinePartRecordx.setUpdateTime(null);
                                          techMachinePartRecordx.setOldMachinePartId(techMachinePartRecordx.getId());
                                          techMachinePartRecordx.setId(null);
                                          List<TechMachinePartRecord> techMachinePartRecordList = this.techMachinePartRecordService
                                             .list(
                                                (Wrapper<TechMachinePartRecord>)(((((new LambdaQueryWrapper<TechMachinePartRecord>()
                                                                  .eq(TechMachinePartRecord::getSerialNumber, techMachinePartRecordx.getSerialNumber()))
                                                               .eq(TechMachinePartRecord::getProjectId, techMachinePartRecordx.getProjectId()))
                                                            .eq(TechMachinePartRecord::getMonomerId, techMachinePartRecordx.getMonomerId()))
                                                         .eq(TechMachinePartRecord::getName, techMachinePartRecordx.getName()))
                                                      .eq(TechMachinePartRecord::getInventoryOperationId, techMachinePartRecordx.getInventoryOperationId()))
                                                   .orderByDesc(BaseEntity::getCreateTime)
                                             );
                                          if (CollectionUtils.isEmpty(techMachinePartRecordList)) {
                                             techMachinePartRecordx.setComboId(part.getComboId());
                                             techMachinePartRecordx.setRelationType(16);
                                             techMachinePartRecordx.setQuantity(techArtifactRecordNew.getQuantity() * part.getQuantity());
                                             techMachinePartRecordx.setTotalGrossWeight(
                                                techMachinePartRecordx.getGrossWeight().multiply(new BigDecimal(techMachinePartRecordx.getQuantity()))
                                             );
                                             techMachinePartRecordx.setTotalNetWeight(
                                                techMachinePartRecordx.getNetWeight().multiply(new BigDecimal(techMachinePartRecordx.getQuantity()))
                                             );
                                             techMachinePartRecordx.setSteelPlateTypeEnum(2);
                                             techMachinePartRecordx.setCreateTime(null);
                                             techMachinePartRecordx.setUpdateTime(null);
                                             techMachinePartRecordx.setOldMachinePartId(techMachinePartRecordx.getId());
                                             techMachinePartRecordx.setId(null);
                                             this.techMachinePartRecordService.save(techMachinePartRecordx);
                                          } else {
                                             TechMachinePartRecord techMachinePartRecordOld = techMachinePartRecordList.get(0);
                                             techMachinePartRecordOld.setQuantity(
                                                techMachinePartRecordList.get(0).getQuantity() + techArtifactRecordNew.getQuantity() * part.getQuantity()
                                             );
                                             techMachinePartRecordOld.setTotalGrossWeight(
                                                techMachinePartRecordx.getGrossWeight().multiply(new BigDecimal(techMachinePartRecordx.getQuantity()))
                                             );
                                             techMachinePartRecordOld.setTotalNetWeight(
                                                techMachinePartRecordx.getNetWeight().multiply(new BigDecimal(techMachinePartRecordx.getQuantity()))
                                             );
                                             this.techMachinePartRecordService.updateById(techMachinePartRecordOld);
                                             techMachinePartRecordx.setId(techMachinePartRecordOld.getId());
                                          }

                                          this.techArtifactMachinePartLinkRecordService
                                             .remove(
                                                (Wrapper<TechArtifactMachinePartLinkRecord>)((new LambdaQueryWrapper<TechArtifactMachinePartLinkRecord>()
                                                         .eq(TechArtifactMachinePartLinkRecord::getMachinePartRecordId, part.getId()))
                                                      .eq(TechArtifactMachinePartLinkRecord::getInventoryOperationId, tmpRecord.getInventoryOperationId()))
                                                   .eq(TechArtifactMachinePartLinkRecord::getArtifactRecordId, techArtifactRecordNew.getId())
                                             );
                                       }

                                       if (techMachinePartRecordx != null) {
                                          TechAssembleMachinePartLinkRecord techAssembleMachinePartLinkRecord = new TechAssembleMachinePartLinkRecord();
                                          techAssembleMachinePartLinkRecord.setInventoryOperationId(tmpRecord.getInventoryOperationId());
                                          techAssembleMachinePartLinkRecord.setAssembleRecordId(techAssembleRecord.getId());
                                          techAssembleMachinePartLinkRecord.setMachinePartRecordId(techMachinePartRecordx.getId());
                                          Integer partQuantity = part.getQuantity() / techAssembleDetailRecord.getQuantity();
                                          int remainder = part.getQuantity() % techAssembleDetailRecord.getQuantity();
                                          Preconditions.checkArgument(remainder == 0, "部件数量异常!");
                                          techAssembleMachinePartLinkRecord.setQuantity(partQuantity);
                                          this.techAssembleMachinePartLinkRecordService.save(techAssembleMachinePartLinkRecord);
                                       }
                                    }
                                 );
                              this.artifactSpecAmendService.updateById(techArtifactSpecAmend);
                           }
                        }
                     );
               }
            );
         }
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean partDelete(List<TechUnitRecordVO> techUnitRecordVOList) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(techUnitRecordVOList), "操作失败,要删除的部件信息为空!");
      if (CollectionUtils.isNotEmpty(techUnitRecordVOList)) {
         TechArtifactRecord techArtifactRecord = this.techArtifactRecordService.getById(techUnitRecordVOList.get(0).getArtifactId());
         Preconditions.checkArgument(techArtifactRecord != null, "数据异常!");
         techUnitRecordVOList.forEach(
            unit -> {
               List<TechPartRecordVO> techPartRecordVOList = unit.getTechPartRecordVOList();
               TechAssembleRecord assembleRecord = this.techAssembleRecordService.getById(techPartRecordVOList.get(0).getUnitId());
               Preconditions.checkArgument(assembleRecord != null, "部件数据异常!");
               List<TechAssembleMachinePartLinkRecord> assembleMachinePartLinkRecords = this.techAssembleMachinePartLinkRecordService
                  .list(
                     (Wrapper<TechAssembleMachinePartLinkRecord>)new LambdaQueryWrapper<TechAssembleMachinePartLinkRecord>()
                        .eq(TechAssembleMachinePartLinkRecord::getAssembleRecordId, assembleRecord.getId())
                  );
               Preconditions.checkArgument(CollectionUtils.isNotEmpty(assembleMachinePartLinkRecords), "操作失败,部件翼腹板的关联表不存在！");
               Map<Long, TechAssembleMachinePartLinkRecord> assembleMachinePartLinkRecordMap = assembleMachinePartLinkRecords.stream()
                  .collect(Collectors.toMap(TechAssembleMachinePartLinkRecord::getMachinePartRecordId, Function.identity()));
               techPartRecordVOList.forEach(
                  part -> {
                     TechAssembleMachinePartLinkRecord assembleMachinePartLinkRecord = assembleMachinePartLinkRecordMap.get(part.getId());
                     int partQuantity = assembleMachinePartLinkRecord.getQuantity() * assembleRecord.getQuantity();
                     TechMachinePartRecord techMachinePartRecord = this.techMachinePartRecordService.getById(part.getId());
                     Preconditions.checkArgument(techMachinePartRecord != null, "数据异常!");
                     TechArtifactMachinePartLinkRecord techArtifactMachinePartLinkRecord = new TechArtifactMachinePartLinkRecord();
                     techArtifactMachinePartLinkRecord.setInventoryOperationId(techArtifactRecord.getInventoryOperationId());
                     techArtifactMachinePartLinkRecord.setArtifactRecordId(techArtifactRecord.getId());
                     techArtifactMachinePartLinkRecord.setMachinePartRecordId(part.getOldMachinePartId());
                     techArtifactMachinePartLinkRecord.setQuantity(partQuantity / techArtifactRecord.getQuantity());
                     this.techArtifactMachinePartLinkRecordService.save(techArtifactMachinePartLinkRecord);
                     techMachinePartRecord.setQuantity(techMachinePartRecord.getQuantity() - partQuantity);
                     Preconditions.checkArgument(techMachinePartRecord.getQuantity() >= 0, "数量有误");
                     if (techMachinePartRecord.getQuantity() == 0) {
                        this.techMachinePartRecordService.removeById(part.getId());
                     } else {
                        this.techMachinePartRecordService.updateById(techMachinePartRecord);
                     }

                     TechMachinePartRecord oldTechMachinePartRecord = this.techMachinePartRecordService.getById(techMachinePartRecord.getOldMachinePartId());
                     Preconditions.checkArgument(oldTechMachinePartRecord != null, "操作失败,原零件不存在！");
                     oldTechMachinePartRecord.setQuantity(oldTechMachinePartRecord.getQuantity() + partQuantity);
                     oldTechMachinePartRecord.setTotalGrossWeight(
                        techMachinePartRecord.getGrossWeight().multiply(new BigDecimal(oldTechMachinePartRecord.getQuantity()))
                     );
                     oldTechMachinePartRecord.setTotalNetWeight(
                        techMachinePartRecord.getNetWeight().multiply(new BigDecimal(oldTechMachinePartRecord.getQuantity()))
                     );
                     this.techMachinePartRecordService.updateById(oldTechMachinePartRecord);
                  }
               );
               List<Long> unitIdList = techPartRecordVOList.stream().map(TechPartRecordVO::getUnitId).collect(Collectors.toList());
               unitIdList = unitIdList.stream().distinct().collect(Collectors.toList());
               unitIdList.forEach(
                  unitId -> {
                     this.techAssembleRecordService.remove((Wrapper<TechAssembleRecord>)new LambdaQueryWrapper<TechAssembleRecord>().eq(TechAssembleRecord::getId, unitId));
                     this.techAssembleMachinePartLinkRecordService
                        .remove(
                           (Wrapper<TechAssembleMachinePartLinkRecord>)new LambdaQueryWrapper<TechAssembleMachinePartLinkRecord>()
                              .eq(TechAssembleMachinePartLinkRecord::getAssembleRecordId, unitId)
                        );
                     this.techAssembleDetailRecordService
                        .remove((Wrapper<TechAssembleDetailRecord>)new LambdaQueryWrapper<TechAssembleDetailRecord>().eq(TechAssembleDetailRecord::getAssembleRecordId, unitId));
                  }
               );
            }
         );
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveAutomaticCombinationAssemble(TechAssemblyAutomaticCombinationVO automaticCombinationVO) {
      MesTechInventoryOperation inventoryOperation = this.mesTechInventoryOperationService.getById(automaticCombinationVO.getInventoryOperationId());
      Preconditions.checkArgument(inventoryOperation != null, "清单导入记录不存在!");
      Preconditions.checkArgument(inventoryOperation.getInventoryReviewedEnum().equals(InventoryReviewedEnum.FIXUP_RECORD.getType()), "操作失败,该清单导入记录非待确认状态!");
      List<TechArtifactSpecAmend> artifactSpecAmendList = this.artifactSpecAmendService
         .list(
            (Wrapper<TechArtifactSpecAmend>)((new LambdaQueryWrapper<TechArtifactSpecAmend>()
                     .eq(TechArtifactSpecAmend::getInventoryOperationId, automaticCombinationVO.getInventoryOperationId()))
                  .eq(TechArtifactSpecAmend::getOldSpecPrefix, "PL"))
               .isNull(TechArtifactSpecAmend::getNewStructureClassId)
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactSpecAmendList), "待修正(板拼部件)的构件规格列表不存在!");
      List<TemplatePanelAssemblyConfigVO> templatePanelAssemblyConfigVOS = automaticCombinationVO.getTemplatePanelAssemblyConfigVOS();
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(templatePanelAssemblyConfigVOS), "操作失败,板拼配置不可为空!");
      if (templatePanelAssemblyConfigVOS.size() > 1) {
         List<List<String>> artifactPartNumberPrefixList = templatePanelAssemblyConfigVOS.stream()
            .map(e -> e.getArtifactPartNumberPrefixList().stream().sorted(Comparator.comparing(s -> (String)s)).collect(Collectors.toList()))
            .collect(Collectors.toList());
         Set<List<String>> uniqueLists = new HashSet<>(artifactPartNumberPrefixList);
         Preconditions.checkArgument(uniqueLists.size() == artifactPartNumberPrefixList.size(), "操作失败,不同类型的构件,零件属性列表不可一致!");
      }

      List<TechArtifactMachinePartLinkRecord> artifactMachinePartLinkRecords = this.artifactMachinePartLinkRecordService
         .list(
            (Wrapper<TechArtifactMachinePartLinkRecord>)new LambdaQueryWrapper<TechArtifactMachinePartLinkRecord>()
               .eq(TechArtifactMachinePartLinkRecord::getInventoryOperationId, automaticCombinationVO.getInventoryOperationId())
         );
      List<TechMachinePartRecord> machinePartRecords = this.machinePartRecordService
         .list(
            (Wrapper<TechMachinePartRecord>)new LambdaQueryWrapper<TechMachinePartRecord>()
               .eq(TechMachinePartRecord::getInventoryOperationId, automaticCombinationVO.getInventoryOperationId())
         );
      this.techUtilManager.buildAssemblePartLinks(artifactMachinePartLinkRecords, machinePartRecords, artifactSpecAmendList, automaticCombinationVO);
      return Boolean.TRUE;
   }

   private void buildInventoryOperationLink(
      List<ArtifactBoxImportDTO> artifactBoxDtoParamList,
      Integer projectMode,
      PlanAreaBatch areaBach,
      TechConfigUtilsDTO utilsDTO,
      TechAreaProductInfoDTO areaProductInfoDTO,
      MesTechInventoryOperation inventoryOperation
   ) {
      Map<String, Long> assembleSpecMap = utilsDTO.getAssembleSpecMap();
      List<Long> boolComposeAssembleClassIds = utilsDTO.getBoolComposeAssembleClassIds();
      Map<String, TechArtifact> areaArtifactSnMap = areaProductInfoDTO.getArtifactSnMap();
      List<TechArtifactRecord> newArtifactList = new ArrayList<>(512);
      List<TechAssembleRecord> newAssembleList = new ArrayList<>(2048);
      List<TechMachinePartRecord> newMachinePartList = new ArrayList<>(4096);
      List<TechStandardPartRecord> newStandardPartList = new ArrayList<>(16);
      List<TechArtifactRecord> artifactRecords = new ArrayList<>();
      artifactBoxDtoParamList.forEach(
         artifactBoxDtoParam -> {
            TechArtifactRecord artifact = this.buildNewArtifactRecord(artifactBoxDtoParam, areaBach, inventoryOperation.getId());
            artifact.setBoolRepetition(Boolean.FALSE);
            if (areaArtifactSnMap.containsKey(artifact.getSerialNumber())) {
               artifact.setBoolRepetition(Boolean.TRUE);
            }

            newArtifactList.add(artifact);
            this.handleMachinePartList(
               artifactBoxDtoParam.getMachinePartImportDtoParamList(), areaBach, artifact, newMachinePartList, inventoryOperation.getId(), projectMode
            );
            this.handleStandardPartList(artifactBoxDtoParam.getStandardPartImportDTOParamList(), artifact, newStandardPartList);
            List<InventoryAssembleImportDTO> elementAssembleList = artifactBoxDtoParam.getAssembleImportDtoParamList();
            elementAssembleList.forEach(
               elementMachinePartDtoParam -> {
                  if (artifact.getBoolAllPartSendDirectly()) {
                     elementMachinePartDtoParam.setName(artifact.getName());
                  }

                  this.buildNewAssemble(elementMachinePartDtoParam, artifact, assembleSpecMap, newAssembleList, inventoryOperation.getId());
                  if (CollectionUtils.isNotEmpty(elementMachinePartDtoParam.getAssembleElementMachinePartList())) {
                     this.handleMachinePartList(
                        elementMachinePartDtoParam.getAssembleElementMachinePartList(),
                        areaBach,
                        artifact,
                        newMachinePartList,
                        inventoryOperation.getId(),
                        projectMode
                     );
                  }
               }
            );
            if (ProjectModeEnum.STANDARD_MODE.getType().equals(projectMode)
               && (
                  artifact.getStructureClassId() == null
                     || artifact.getSpecPrefix().equals("PL")
                        && !artifact.getBoolComposeAssemble()
                        && !artifact.getBoolOnePartLine()
                        && inventoryOperation.getBuildingType().equals(InventoryTypeEnum.MES.getType())
                        && !boolComposeAssembleClassIds.contains(artifact.getStructureClassId())
                     || CollectionUtils.isEmpty(elementAssembleList)
                        && !artifact.getBoolComposeAssemble()
                        && !artifact.getBoolOnePartLine()
                        && inventoryOperation.getBuildingType().equals(InventoryTypeEnum.MES.getType())
                        && !boolComposeAssembleClassIds.contains(artifact.getStructureClassId())
               )) {
               artifactRecords.add(artifact);
            }

            if (ProjectModeEnum.ARTIFACT_MODE.getType().equals(projectMode) && artifact.getStructureClassId() == null) {
               artifactRecords.add(artifact);
            }
         }
      );
      this.artifactRecordService.saveBatch(newArtifactList);
      this.assembleRecordService.saveBatch(newAssembleList);
      this.machinePartRecordService.saveBatch(newMachinePartList);
      this.standardPartRecordService.saveBatch(newStandardPartList);
      List<TechArtifactSpecAmend> specAmendList = new ArrayList<>(128);
      if (CollectionUtils.isNotEmpty(artifactRecords)) {
         artifactRecords.forEach(
            record -> {
               TechArtifactSpecAmend specAmend = TechArtifactSpecAmend.builder()
                  .projectId(record.getProjectId())
                  .monomerId(record.getMonomerId())
                  .areaId(record.getAreaId())
                  .areaBatchId(record.getAreaBatchId())
                  .inventoryOperationId(inventoryOperation.getId())
                  .artifactId(record.getId())
                  .serialNumber(record.getSerialNumber())
                  .length(record.getLength())
                  .material(record.getMaterial())
                  .quantity(record.getQuantity())
                  .oldName(record.getName())
                  .oldStructureClassId(record.getStructureClassId())
                  .oldSpecification(record.getSpecification())
                  .oldSpecPrefix(record.getSpecPrefix())
                  .boolAmendStatus(Boolean.FALSE)
                  .projectMode(projectMode)
                  .build();
               if (record.getStructureClassId() != null && !record.getSpecPrefix().equals("PL")) {
                  specAmend.setNewStructureClassId(record.getStructureClassId());
                  specAmend.setNewSpecPrefix(record.getSpecPrefix());
                  specAmend.setNewSpecification(record.getSpecification());
               }

               specAmendList.add(specAmend);
            }
         );
         this.artifactSpecAmendService.saveBatch(specAmendList);
      }

      if (CollectionUtils.isNotEmpty(specAmendList) || newArtifactList.stream().anyMatch(TechArtifactRecord::getBoolRepetition)) {
         inventoryOperation.setInventoryReviewedEnum(InventoryReviewedEnum.FIXUP_RECORD.getType());
      }

      Map<String, TechArtifactRecord> newArtifactSnMap = newArtifactList.stream()
         .collect(Collectors.toMap(TechArtifactRecord::getSerialNumber, Function.identity()));
      Map<String, List<TechAssembleRecord>> newAssembleSnGroupMap = newAssembleList.stream()
         .collect(Collectors.groupingBy(TechAssembleRecord::getSerialNumber));
      Map<String, List<TechMachinePartRecord>> newMachinePartSnGroupMap = newMachinePartList.stream()
         .collect(Collectors.groupingBy(TechMachinePartRecord::getSerialNumber));
      List<TechAssembleDetailRecord> assembleDetailList = new ArrayList<>(1024);
      List<TechArtifactMachinePartLinkRecord> artifactMachinePartLinkList = new ArrayList<>(4096);
      List<TechArtifactStandardPartLinkRecord> artifactStandardPartLinkList = new ArrayList<>(1024);
      List<TechAssembleMachinePartLinkRecord> assembleMachinePartLinkList = new ArrayList<>(2048);
      Map<String, TechAssembleMachinePartLinkRecord> assembleMachinePartLinkMap = new HashMap<>();
      this.buildDetailLinkList(
         artifactBoxDtoParamList,
         newStandardPartList,
         newArtifactSnMap,
         newAssembleSnGroupMap,
         newMachinePartSnGroupMap,
         assembleDetailList,
         artifactMachinePartLinkList,
         artifactStandardPartLinkList,
         assembleMachinePartLinkList,
         assembleMachinePartLinkMap,
         inventoryOperation
      );
      this.assembleDetailRecordService.saveBatch(assembleDetailList);
      this.artifactMachinePartLinkRecordService.saveBatch(artifactMachinePartLinkList);
      this.artifactStandardPartLinkRecordService.saveBatch(artifactStandardPartLinkList);
      this.assembleMachinePartLinkRecordService.saveBatch(assembleMachinePartLinkList);
      this.mesTechInventoryOperationService.updateById(inventoryOperation);
   }

   private void buildDetailLinkList(
      List<ArtifactBoxImportDTO> artifactBoxDtoParamList,
      List<TechStandardPartRecord> newStandardPartList,
      Map<String, TechArtifactRecord> newArtifactSnMap,
      Map<String, List<TechAssembleRecord>> newAssembleSnGroupMap,
      Map<String, List<TechMachinePartRecord>> newMachinePartSnGroupMap,
      List<TechAssembleDetailRecord> assembleDetailList,
      List<TechArtifactMachinePartLinkRecord> artifactMachinePartLinkList,
      List<TechArtifactStandardPartLinkRecord> artifactStandardPartLinkList,
      List<TechAssembleMachinePartLinkRecord> assembleMachinePartLinkList,
      Map<String, TechAssembleMachinePartLinkRecord> assembleMachinePartLinkMap,
      MesTechInventoryOperation inventoryOperation
   ) {
      artifactBoxDtoParamList.forEach(
         artifactBoxDtoParam -> {
            TechArtifactRecord artifact = newArtifactSnMap.get(artifactBoxDtoParam.getSerialNumber());
            artifactBoxDtoParam.getAssembleImportDtoParamList()
               .forEach(
                  elementAssembleDtoParam -> {
                     List<TechAssembleRecord> assembleList = newAssembleSnGroupMap.get(elementAssembleDtoParam.getSerialNumber());
                     if (!CollectionUtils.isEmpty(assembleList)) {
                        List<TechAssembleRecord> assembles = assembleList.stream()
                           .filter(
                              assemblex -> assemblex.getName() == null
                                 ? elementAssembleDtoParam.getName() == null
                                 : assemblex.getName().equals(elementAssembleDtoParam.getName())
                           )
                           .filter(assemblex -> assemblex.getBoolAllPartSendDirectly().equals(elementAssembleDtoParam.getBoolAllPartSendDirectly()))
                           .filter(assemblex -> assemblex.getBoolSendDirectly().equals(elementAssembleDtoParam.getBoolSendDirectly()))
                           .filter(
                              assemblex -> assemblex.getRemark() == null
                                 ? elementAssembleDtoParam.getRemark() == null
                                 : assemblex.getRemark().equals(elementAssembleDtoParam.getRemark())
                           )
                           .collect(Collectors.toList());
                        TechAssembleRecord assemble = assembles.get(0);
                        TechAssembleDetailRecord assembleDetail = TechAssembleDetailRecord.builder()
                           .inventoryOperationId(inventoryOperation.getId())
                           .artifactRecordId(artifact.getId())
                           .assembleRecordId(assemble.getId())
                           .quantity(elementAssembleDtoParam.getQuantity() / artifactBoxDtoParam.getQuantity())
                           .booInventory(Boolean.TRUE)
                           .build();
                        assembleDetailList.add(assembleDetail);
                        if (CollectionUtils.isNotEmpty(elementAssembleDtoParam.getAssembleElementMachinePartList())) {
                           elementAssembleDtoParam.getAssembleElementMachinePartList()
                              .forEach(
                                 partDtoParam -> {
                                    List<TechMachinePartRecord> machinePartList = newMachinePartSnGroupMap.get(partDtoParam.getSerialNumber());
                                    List<TechMachinePartRecord> partList = machinePartList.stream()
                                       .filter(m -> !m.getBoolAllPartSendDirectly())
                                       .filter(m -> !m.getBoolSendDirectly())
                                       .filter(m -> m.getName() == null ? partDtoParam.getName() == null : m.getName().equals(partDtoParam.getName()))
                                       .collect(Collectors.toList());
                                    TechMachinePartRecord machinePart = partList.get(0);
                                    TechAssembleMachinePartLinkRecord assembleMachinePartLink = assembleMachinePartLinkMap.get(
                                       assemble.getId() + "-" + machinePart.getId()
                                    );
                                    if (assembleMachinePartLink != null) {
                                       Preconditions.checkArgument(
                                          assembleMachinePartLink.getQuantity().equals(partDtoParam.getQuantity() / elementAssembleDtoParam.getQuantity()),
                                          "部件零件比例不一致!!!"
                                       );
                                    } else {
                                       TechAssembleMachinePartLinkRecord link = TechAssembleMachinePartLinkRecord.builder()
                                          .inventoryOperationId(inventoryOperation.getId())
                                          .assembleRecordId(assemble.getId())
                                          .machinePartRecordId(machinePart.getId())
                                          .quantity(partDtoParam.getQuantity() / elementAssembleDtoParam.getQuantity())
                                          .build();
                                       assembleMachinePartLinkList.add(link);
                                       assembleMachinePartLinkMap.put(assemble.getId() + "-" + machinePart.getId(), link);
                                    }
                                 }
                              );
                        }
                     }
                  }
               );
            if (CollectionUtils.isNotEmpty(artifactBoxDtoParam.getMachinePartImportDtoParamList())) {
               artifactBoxDtoParam.getMachinePartImportDtoParamList()
                  .forEach(
                     machinePartDtoParam -> {
                        List<TechMachinePartRecord> machinePartList = newMachinePartSnGroupMap.get(machinePartDtoParam.getSerialNumber());
                        if (!CollectionUtils.isEmpty(machinePartList)) {
                           List<TechMachinePartRecord> machineParts = machinePartList.stream()
                              .filter(
                                 part -> part.getName() == null ? machinePartDtoParam.getName() == null : part.getName().equals(machinePartDtoParam.getName())
                              )
                              .filter(part -> part.getBoolAllPartSendDirectly().equals(machinePartDtoParam.getBoolAllPartSendDirectly()))
                              .filter(part -> part.getBoolSendDirectly().equals(machinePartDtoParam.getBoolSendDirectly()))
                              .collect(Collectors.toList());
                           TechMachinePartRecord machinePart = machineParts.get(0);
                           TechArtifactMachinePartLinkRecord link = TechArtifactMachinePartLinkRecord.builder()
                              .inventoryOperationId(inventoryOperation.getId())
                              .artifactRecordId(artifact.getId())
                              .machinePartRecordId(machinePart.getId())
                              .quantity(machinePartDtoParam.getQuantity() / artifactBoxDtoParam.getQuantity())
                              .build();
                           artifactMachinePartLinkList.add(link);
                        }
                     }
                  );
            }

            artifactBoxDtoParam.getStandardPartImportDTOParamList()
               .forEach(
                  standardPartDtoParam -> {
                     List<TechStandardPartRecord> standardPartList = newStandardPartList.stream()
                        .filter(s -> s.getName().equals(standardPartDtoParam.getName()))
                        .filter(s -> s.getSpecification().equals(standardPartDtoParam.getSpecification()))
                        .filter(s -> s.getUseProperty().equals(standardPartDtoParam.getUseProperty()))
                        .collect(Collectors.toList());
                     if (CollUtil.isNotEmpty(standardPartList)) {
                        TechStandardPartRecord standardPart = standardPartList.get(0);
                        TechArtifactStandardPartLinkRecord link = TechArtifactStandardPartLinkRecord.builder()
                           .artifactRecordId(artifact.getId())
                           .inventoryOperationId(inventoryOperation.getId())
                           .standardPartRecordId(standardPart.getId())
                           .quantity(standardPartDtoParam.getQuantity() / artifactBoxDtoParam.getQuantity())
                           .build();
                        artifactStandardPartLinkList.add(link);
                     }
                  }
               );
         }
      );
   }

   private void handleMachinePartList(
      List<MachinePartImportDtoParam> machinePartPlateList,
      PlanAreaBatch areaBach,
      TechArtifactRecord artifact,
      List<TechMachinePartRecord> newMachinePartList,
      Long inventoryOperationId,
      Integer projectMode
   ) {
      if (CollectionUtils.isNotEmpty(machinePartPlateList)) {
         machinePartPlateList.forEach(
            machinePartDtoParam -> {
               Boolean boolSendDirectly = machinePartDtoParam.getBoolSendDirectly() == null ? Boolean.FALSE : machinePartDtoParam.getBoolSendDirectly();
               Boolean allPartSendDirectly = machinePartDtoParam.getBoolAllPartSendDirectly() == null
                  ? Boolean.FALSE
                  : machinePartDtoParam.getBoolAllPartSendDirectly();
               machinePartDtoParam.setName(allPartSendDirectly ? artifact.getName() : machinePartDtoParam.getName());
               machinePartDtoParam.setBoolSendDirectly(boolSendDirectly);
               machinePartDtoParam.setBoolAllPartSendDirectly(allPartSendDirectly);
               this.buildNewMachinePart(
                  machinePartDtoParam, areaBach, allPartSendDirectly, boolSendDirectly, newMachinePartList, inventoryOperationId, projectMode
               );
            }
         );
      }
   }

   private void buildNewAssemble(
      InventoryAssembleImportDTO assembleImportDtoParam,
      TechArtifactRecord artifact,
      Map<String, Long> assembleSpecMap,
      List<TechAssembleRecord> newAssembleList,
      Long inventoryOperationId
   ) {
      boolean boolSendDirectly = assembleImportDtoParam.getBoolSendDirectly() == null ? Boolean.FALSE : assembleImportDtoParam.getBoolSendDirectly();
      assembleImportDtoParam.setBoolSendDirectly(boolSendDirectly);
      assembleImportDtoParam.setBoolAllPartSendDirectly(artifact.getBoolAllPartSendDirectly());
      List<TechAssembleRecord> oldAssembleRecordList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(newAssembleList)) {
         oldAssembleRecordList = newAssembleList.stream()
            .filter(
               oldAssemble -> oldAssemble.getName() == null
                  ? assembleImportDtoParam.getName() == null
                  : oldAssemble.getName().equals(assembleImportDtoParam.getName())
            )
            .filter(oldAssemble -> oldAssemble.getSerialNumber().equals(assembleImportDtoParam.getSerialNumber()))
            .filter(
               oldAssemble -> oldAssemble.getRemark() == null
                  ? assembleImportDtoParam.getRemark() == null
                  : oldAssemble.getRemark().equals(assembleImportDtoParam.getRemark())
            )
            .filter(oldAssemble -> oldAssemble.getBoolSendDirectly().equals(boolSendDirectly))
            .filter(oldAssemble -> oldAssemble.getBoolAllPartSendDirectly().equals(artifact.getBoolAllPartSendDirectly()))
            .collect(Collectors.toList());
      }

      if (CollectionUtils.isNotEmpty(oldAssembleRecordList)) {
         TechAssembleRecord techAssembleRecord = oldAssembleRecordList.get(0);
         techAssembleRecord.setQuantity(techAssembleRecord.getQuantity() + assembleImportDtoParam.getQuantity());
         techAssembleRecord.setTotalNetWeight(techAssembleRecord.getNetWeight().multiply(BigDecimal.valueOf(techAssembleRecord.getQuantity().intValue())));
         techAssembleRecord.setTotalGrossWeight(techAssembleRecord.getGrossWeight().multiply(BigDecimal.valueOf(techAssembleRecord.getQuantity().intValue())));
      } else {
         TechAssembleRecord assemble = BeanUtil.copy(assembleImportDtoParam, TechAssembleRecord.class);
         assemble.setInventoryOperationId(inventoryOperationId);
         assemble.setProjectId(artifact.getProjectId());
         assemble.setMonomerId(artifact.getMonomerId());
         assemble.setAreaId(artifact.getAreaId());
         assemble.setAreaBatchId(artifact.getAreaBatchId());
         assemble.setAssembleType(assembleImportDtoParam.getProductClassificationEnum());
         assemble.setBoolAllPartSendDirectly(artifact.getBoolAllPartSendDirectly());
         assemble.setBoolSendDirectly(assemble.getBoolAllPartSendDirectly() || boolSendDirectly);
         assemble.setAssembleConfigId(assembleSpecMap.get(assemble.getSpecPrefix()));
         assemble.setUserId(UserUtil.getCurrentUserId());
         assemble.setBooInventory(Boolean.TRUE);
         newAssembleList.add(assemble);
      }
   }

   private void handleStandardPartList(
      List<StandardPartImportDTOParam> standardPartDtoParamList, TechArtifactRecord artifact, List<TechStandardPartRecord> newStandardPartList
   ) {
      if (CollectionUtils.isNotEmpty(standardPartDtoParamList)) {
         standardPartDtoParamList.forEach(
            standardPartDtoParam -> {
               List<TechStandardPartRecord> newStandardParts = newStandardPartList.stream()
                  .filter(s -> s.getName().equals(standardPartDtoParam.getName()))
                  .filter(s -> s.getSpecification().equals(standardPartDtoParam.getSpecification()))
                  .filter(s -> "个".equals(s.getMeasureUnit()))
                  .filter(s -> "个".equals(s.getAccountingUnit()))
                  .filter(s -> s.getUseProperty().equals(standardPartDtoParam.getUseProperty()))
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(newStandardParts)) {
                  TechStandardPartRecord standardPart = newStandardParts.get(0);
                  standardPart.setQuantity(standardPart.getQuantity() + standardPartDtoParam.getQuantity());
                  standardPart.setMete(BigDecimal.valueOf(standardPart.getQuantity().intValue()));
               } else {
                  TechStandardPartRecord standardPart = BeanUtil.copy(standardPartDtoParam, TechStandardPartRecord.class);
                  standardPart.setSpecification(standardPartDtoParam.getSpecification());
                  standardPart.setMete(BigDecimal.valueOf(standardPart.getQuantity().intValue()));
                  standardPart.setProjectId(artifact.getProjectId());
                  standardPart.setMonomerId(artifact.getMonomerId());
                  standardPart.setAreaId(artifact.getAreaId());
                  standardPart.setAreaBatchId(artifact.getAreaBatchId());
                  standardPart.setMeasureUnit("个");
                  standardPart.setAccountingUnit("个");
                  standardPart.setBoolArtifactImport(Boolean.TRUE);
                  standardPart.setUserId(UserUtil.getCurrentUserId());
                  standardPart.setRelationType(ProductTypeEnum.ARTIFACT.getType());
                  standardPart.setInventoryOperationId(artifact.getInventoryOperationId());
                  newStandardPartList.add(standardPart);
               }
            }
         );
      }
   }

   private void buildNewMachinePart(
      MachinePartImportDtoParam machinePartDtoParam,
      PlanAreaBatch areaBach,
      Boolean boolAllPartSendDirectly,
      Boolean boolSendDirectly,
      List<TechMachinePartRecord> newMachinePartList,
      Long inventoryOperationId,
      Integer projectMode
   ) {
      List<TechMachinePartRecord> oldMachinePartRecordList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(newMachinePartList)) {
         oldMachinePartRecordList = newMachinePartList.stream()
            .filter(part -> part.getName() == null ? machinePartDtoParam.getName() == null : part.getName().equals(machinePartDtoParam.getName()))
            .filter(part -> part.getSerialNumber().equals(machinePartDtoParam.getSerialNumber()))
            .filter(part -> part.getBoolSendDirectly().equals(boolSendDirectly))
            .filter(part -> part.getBoolAllPartSendDirectly().equals(boolAllPartSendDirectly))
            .collect(Collectors.toList());
      }

      if (CollectionUtils.isNotEmpty(oldMachinePartRecordList)) {
         TechMachinePartRecord machinePartRecord = oldMachinePartRecordList.get(0);
         machinePartRecord.setQuantity(machinePartRecord.getQuantity() + machinePartDtoParam.getQuantity());
         machinePartRecord.setTotalNetWeight(machinePartRecord.getNetWeight().multiply(BigDecimal.valueOf(machinePartRecord.getQuantity().intValue())));
         machinePartRecord.setTotalGrossWeight(machinePartRecord.getGrossWeight().multiply(BigDecimal.valueOf(machinePartRecord.getQuantity().intValue())));
      } else {
         TechMachinePartRecord machinePart = BeanUtil.copy(machinePartDtoParam, TechMachinePartRecord.class);
         machinePart.setBoolProcess(Boolean.FALSE);
         machinePart.setBoolSchedulingEnum(Boolean.FALSE);
         machinePart.setInventoryOperationId(inventoryOperationId);
         machinePart.setProjectId(areaBach.getProjectId());
         machinePart.setMonomerId(areaBach.getMonomerId());
         machinePart.setAreaId(areaBach.getAreaId());
         machinePart.setAreaBatchId(areaBach.getId());
         machinePart.setAreaType(areaBach.getType());
         machinePart.setTotalNetWeight(machinePart.getNetWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
         machinePart.setTotalGrossWeight(machinePart.getGrossWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
         machinePart.setBoolAllPartSendDirectly(boolAllPartSendDirectly);
         machinePart.setBoolSendDirectly(boolAllPartSendDirectly || boolSendDirectly);
         machinePart.setMachinePartType(machinePartDtoParam.getProductClassificationEnum());
         if (machinePartDtoParam.getTotalInnerPaintArea() != null && machinePartDtoParam.getTotalInnerPaintArea().compareTo(BigDecimal.ZERO) != 0) {
            machinePart.setInnerPaintArea(
               machinePartDtoParam.getTotalInnerPaintArea().divide(BigDecimal.valueOf(machinePart.getQuantity().intValue()), 8, RoundingMode.HALF_UP)
            );
         }

         if (machinePartDtoParam.getTotalOuterPaintArea() != null && machinePartDtoParam.getTotalOuterPaintArea().compareTo(BigDecimal.ZERO) != 0) {
            machinePart.setOuterPaintArea(
               machinePartDtoParam.getTotalOuterPaintArea().divide(BigDecimal.valueOf(machinePart.getQuantity().intValue()), 8, RoundingMode.HALF_UP)
            );
         }

         if (machinePart.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.PRIMARY_MEMBER.getType())) {
            machinePart.setThick(TechUtils.getMachinePartThick(machinePart.getSpecification()));
            machinePart.setWidth(machinePartDtoParam.getWidth().toString());
            if (!projectMode.equals(ProjectModeEnum.ARTIFACT_MODE.getType())) {
               machinePart.setBoolSchedulingEnum(Boolean.TRUE);
               machinePart.setBoolProcess(Boolean.TRUE);
            }
         }

         if (machinePart.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType())) {
            machinePart.setThick(TechUtils.getMachinePartThick(machinePart.getSpecification()));
            machinePart.setWidth(machinePartDtoParam.getWidth().toString());
            if (!projectMode.equals(ProjectModeEnum.ARTIFACT_MODE.getType())) {
               machinePart.setBoolSchedulingEnum(Boolean.TRUE);
               machinePart.setBoolProcess(Boolean.TRUE);
            }
         }

         if (machinePart.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECTIONSTEEL.getType())) {
            machinePart.setThick(machinePartDtoParam.getSpecification());
            machinePart.setSteelSpec(machinePartDtoParam.getSpecification());
            List<MesBuildingMachinePartTeamDetail> mesBuildingMachinePartTeamDetailList = this.mesBuildingMachinePartTeamDetailService
               .list(
                  (Wrapper<MesBuildingMachinePartTeamDetail>)new LambdaQueryWrapper<MesBuildingMachinePartTeamDetail>()
                     .eq(MesBuildingMachinePartTeamDetail::getPartType, ProductCategoryTypeEnum.PROFILE_PART.getType())
               );
            machinePart.setBoolSchedulingEnum(Boolean.FALSE);
            machinePart.setBoolProcess(Boolean.FALSE);
            if (CollectionUtils.isNotEmpty(mesBuildingMachinePartTeamDetailList) && !projectMode.equals(ProjectModeEnum.ARTIFACT_MODE.getType())) {
               Boolean boolProcess = mesBuildingMachinePartTeamDetailList.stream()
                  .anyMatch(e -> e.getPartFeature().contains(machinePart.getSteelId().toString()));
               machinePart.setBoolSchedulingEnum(boolProcess);
               machinePart.setBoolProcess(boolProcess);
            }
         }

         machinePart.setUserId(UserUtil.getCurrentUserId());
         machinePart.setSteelSpec(machinePart.getThick());
         newMachinePartList.add(machinePart);
      }
   }

   private TechArtifactRecord buildNewArtifactRecord(ArtifactBoxImportDTO artifactBoxDtoParam, PlanAreaBatch areaBach, Long inventoryOperationId) {
      TechArtifactRecord artifact = BeanUtil.copy(artifactBoxDtoParam, TechArtifactRecord.class);
      artifact.setInventoryOperationId(inventoryOperationId);
      artifact.setProjectId(areaBach.getProjectId());
      artifact.setMonomerId(areaBach.getMonomerId());
      artifact.setAreaId(areaBach.getAreaId());
      artifact.setAreaBatchId(areaBach.getId());
      artifact.setSerialNumberPrefix(artifact.getName());
      artifact.setTotalNetWeight(artifact.getNetWeight().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())));
      artifact.setTotalGrossWeight(artifact.getGrossWeight().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())));
      artifact.setDrawingTotalWeight(
         artifact.getDrawingWeight() == null ? BigDecimal.ZERO : artifact.getDrawingWeight().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue()))
      );
      artifact.setUserId(UserUtil.getCurrentUserId());
      artifact.setUserName(UserUtil.getCurrentName());
      return artifact;
   }

   private List<TechArtifactSpecUncorrectedDTO> getArtifactSpecUncorrectedDTOSPL(Long inventoryOperationId) {
      new ArrayList(10);
      List<TechArtifactSpecUncorrectedDTO> artifactSpecUncorrectedDTOS = this.artifactSpecAmendService
         .uncorrectedList(inventoryOperationId, null, null, null, null, null, null);
      artifactSpecUncorrectedDTOS.forEach(
         m -> {
            m.setPlJudge(true);
            Long artifactRecordId = m.getArtifactId();
            List<TechArtifactMachinePartLinkRecord> techArtifactMachinePartLinkRecordList = this.techArtifactMachinePartLinkRecordService
               .list(
                  (Wrapper<TechArtifactMachinePartLinkRecord>)new LambdaQueryWrapper<TechArtifactMachinePartLinkRecord>()
                     .eq(TechArtifactMachinePartLinkRecord::getArtifactRecordId, artifactRecordId)
               );
            if (CollectionUtils.isNotEmpty(techArtifactMachinePartLinkRecordList)) {
               techArtifactMachinePartLinkRecordList.forEach(
                  m1 -> {
                     Long machinePartRecordId = m1.getMachinePartRecordId();
                     TechMachinePartRecord techMachinePartRecord = this.techMachinePartRecordService.getById(machinePartRecordId);
                     if (!techMachinePartRecord.getSpecification().toUpperCase().startsWith("PL")
                        && techMachinePartRecord.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.PRIMARY_MEMBER.getType())) {
                        m.setPlJudge(false);
                     }
                  }
               );
            }
         }
      );
      List<TechArtifactSpecUncorrectedDTO> artifactSpecUncorrectedDTOSPL = artifactSpecUncorrectedDTOS.stream()
         .filter(TechArtifactSpecUncorrectedDTO::getPlJudge)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(artifactSpecUncorrectedDTOSPL)) {
         artifactSpecUncorrectedDTOSPL.forEach(
            m -> {
               List<TechAssembleDetailRecord> techAssembleDetailRecordList = this.techAssembleDetailRecordService
                  .list((Wrapper<TechAssembleDetailRecord>)new LambdaQueryWrapper<TechAssembleDetailRecord>().eq(TechAssembleDetailRecord::getArtifactRecordId, m.getArtifactId()));
               if (CollectionUtils.isNotEmpty(techAssembleDetailRecordList)) {
                  m.setPartAmendStatus(true);
               } else {
                  m.setPartAmendStatus(null);
               }
            }
         );
      }

      return artifactSpecUncorrectedDTOSPL;
   }

   @Override
   public PageVO<TechEnclosureRecordDTO> getInventoryEnclosureDetailList(
      Long inventoryId, String dictionaryId, String serialNumber, Integer pageNumber, Integer pageSize
   ) {
      MesTechInventoryOperation inventoryOperation = this.mesTechInventoryOperationService.getById(inventoryId);
      Preconditions.checkArgument(inventoryOperation != null, "操作失败,清单导入审核记录不存在!");
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<TechEnclosureRecord> enclosureRecordList = this.enclosureRecordService
         .list(
            ((new LambdaQueryWrapper<TechEnclosureRecord>().eq(TechEnclosureRecord::getInventoryOperationId, inventoryId))
                  .eq(dictionaryId != null, TechEnclosureRecord::getDictionaryId, dictionaryId))
               .like(serialNumber != null, TechEnclosureRecord::getSerialNumber, serialNumber)
         );
      if (CollectionUtils.isEmpty(enclosureRecordList)) {
         return new PageVO<>();
      }

      List<TechEnclosureRecordDTO> techEnclosureRecordDTO = cn.hutool.core.bean.BeanUtil.copyToList(enclosureRecordList, TechEnclosureRecordDTO.class);
      List<SysDictionary> sysDictionaries = this.dictionaryService.listByName("enclosure_type");
      Map<Long, String> enclosureDictMap = sysDictionaries.stream().collect(Collectors.toMap(e -> e.getId(), s -> s.getLabel()));
      techEnclosureRecordDTO.stream().forEach(e -> {
         e.setDictionaryName(enclosureDictMap.get(e.getDictionaryId()));
         e.setSurfaceArea(e.getSurfaceArea().divide(BigDecimal.valueOf(1000000L)));
         e.setTotalArea(e.getSurfaceArea().divide(BigDecimal.valueOf(1000000L)));
      });
      return new PageVO<>(page, techEnclosureRecordDTO);
   }
}
