package com.hzchum.scim.plan.core.biz.impl;

import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactAddDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactEditDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.MachinePartAddDtoParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.MachinePartEditDtoParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.StandardPartAddDtoParam;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.business.core.api.service.BusinessMachinePartService;
import com.hzchum.scim.business.core.api.service.BusinessStandardPartService;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.MesProductEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.WarehouseBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseSaveDTOParam;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingArtifactSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.biz.TechArtifactMachinePartBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductTaskBiz;
import com.hzchum.scim.plan.core.api.biz.TechStandardPartBiz;
import com.hzchum.scim.plan.core.api.enums.AuxiliaryUsePropertyEnum;
import com.hzchum.scim.plan.core.api.enums.BuildingTypeEnum;
import com.hzchum.scim.plan.core.api.enums.DrawingProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.ImportTypeEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryReviewedEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryTypeEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.manager.TechUtilManager;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactStandardPartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardProductLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductTask;
import com.hzchum.scim.plan.core.api.pojo._do.TechDeepenRecord;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeRecordDetail;
import com.hzchum.scim.plan.core.api.pojo._do.check.MesTechInventoryOperation;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.InventoryBridgeExportTemplateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.InventoryExportBaseCommonTemplateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.InventoryExportTemplateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.InventoryGridExportTemplateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.MesTechInventoryOperationDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechAreaProductInfoDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechConfigUtilsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechMonomerDrawInfoDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.InventoryArtifactBoxDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.InventoryAssembleDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.InventoryMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.InventoryStandardPartDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.MonomerAndProductIdVO;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechArtifactStandardPartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechCappCraftCardProductLinkService;
import com.hzchum.scim.plan.core.api.service.TechDeepenRecordService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.plan.core.api.service.change.TechChangeRecordDetailService;
import com.hzchum.scim.plan.core.api.service.check.MesTechInventoryOperationService;
import com.hzchum.scim.plan.core.api.service.check.TechMachinePartRecordService;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.enums.ProjectModeEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo._do.MesAuxiliary;
import com.hzchum.scim.system.core.api.pojo._do.MonomerUserLink;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationServiceTriggerDTO;
import com.hzchum.scim.system.core.api.service.MesAuxiliaryService;
import com.hzchum.scim.system.core.api.service.MonomerUserLinkService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.TransactionalException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechArtifactMachinePartBizImpl implements TechArtifactMachinePartBiz {
   private static final Logger log = LoggerFactory.getLogger(TechArtifactMachinePartBizImpl.class);
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechAssembleDetailService assembleDetailService;
   @Resource
   private BusinessArtifactService businessArtifactService;
   @Resource
   private TechDrawingService drawingService;
   @Resource
   private TechDeepenRecordService deepenRecordService;
   @Resource
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private SysPushFlowConfigBiz sysPushFlowConfigBiz;
   @Resource
   private NotificationTemplateDetailsUtils detailsUtils;
   @Resource
   private MesBuildingArtifactSchedulingService artifactSchedulingService;
   @Resource
   private BusinessMachinePartService businessMachinePartService;
   @Resource
   private TechArtifactExtService artifactExtService;
   @Resource
   private TechAssembleExtService assembleExtService;
   @Resource
   private TechChangeRecordDetailService changeRecordDetailService;
   @Resource
   private TechUtilManager techUtilManager;
   @Resource
   private TechStandardPartService standardPartService;
   @Resource
   private MesTechInventoryOperationService inventoryOperationService;
   @Resource
   private BusinessStandardPartService businessStandardPartService;
   @Resource
   private TechArtifactStandardPartLinkService artifactStandardPartLinkService;
   @Resource
   private MesTechInventoryOperationService mesTechInventoryOperationService;
   @Resource
   private TechMachinePartRecordService machinePartRecordService;
   @Resource
   private MonomerUserLinkService monomerUserLinkService;
   @Resource
   private PlanAreaBatchService areaBatchService;
   @Resource
   private MesAuxiliaryService mesAuxiliaryService;
   @Resource
   private WarehouseBiz warehouseBiz;
   @Resource
   private MesBuildingCompleteService completeService;
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Resource
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Resource
   private MoveOutboundDetailService outboundDetailService;
   @Resource
   private TechStandardPartBiz techStandardPartBiz;
   @Resource
   private TechCappCraftCardProductLinkService techCappCraftCardProductLinkService;
   @Resource
   private TechCappCraftProductTaskBiz techCappCraftProductTaskBiz;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean inventoryCheck(MesTechInventoryOperationDTOParam dtoParam) {
      MesTechInventoryOperation inventoryOperation = this.inventoryOperationService.getById(dtoParam.getId());
      Preconditions.checkArgument(InventoryReviewedEnum.UNAUDITED.getType().equals(inventoryOperation.getInventoryReviewedEnum()), "操作失败,该操作记录非待审核状态");
      PlanArea area = this.areaService.getById(inventoryOperation.getAreaId());
      Preconditions.checkArgument(area != null, "区域不存在!");
      PlanAreaBatch areaBatch = this.areaBatchService.getById(inventoryOperation.getAreaBatchId());
      Preconditions.checkArgument(areaBatch != null, "批次不存在!");
      ContractProject project = this.projectService.checkProjectStatus(area.getProjectId());
      inventoryOperation.setInventoryReviewedEnum(dtoParam.getCheckStatus());
      inventoryOperation.setReviewedBy(UserUtil.getCurrentUserId());
      inventoryOperation.setReviewedName(UserUtil.getCurrentName());
      inventoryOperation.setReviewedTime(LocalDateTime.now());
      if (dtoParam.getCheckStatus().equals(InventoryReviewedEnum.REVOKED.getType())) {
         Preconditions.checkArgument(inventoryOperation.getImportUserId().equals(UserUtil.getCurrentUserId()), "仅导入人可撤回!!!");
      }

      this.inventoryOperationService.updateById(inventoryOperation);
      if (!InventoryReviewedEnum.PASSED.getType().equals(dtoParam.getCheckStatus())) {
         int areaBatchCount = this.artifactService.count(Wrappers.lambdaQuery(TechArtifact.builder().areaBatchId(areaBatch.getId()).build()));
         int outboundAreaBatchCount = this.outboundDetailService
            .count(Wrappers.lambdaQuery(MoveOutboundDetail.class).eq(MoveOutboundDetail::getAreaBatchId, areaBatch.getId()));
         if (areaBatchCount == 0 && outboundAreaBatchCount == 0) {
            this.areaBatchService.removeById(areaBatch.getId());
         }

         return Boolean.TRUE;
      } else {
         List<TechDeepenRecord> deepenRecordList = new ArrayList<>(16);
         if (inventoryOperation.getImportType().equals(ImportTypeEnum.ADD_IMPORT.getType())) {
            TechAreaProductInfoDTO areaProductInfo = this.techUtilManager.getAreaProductInfo(areaBatch.getId());
            List<InventoryArtifactBoxDTO> inventoryDTOList = this.techUtilManager.getInventoryList(inventoryOperation.getId());
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(inventoryDTOList), "操作失败,导入的清单不存在!");
            Map<String, TechArtifact> artifactSnMap = areaProductInfo.getArtifactSnMap();
            List<InventoryArtifactBoxDTO> inventoryArtifactBoxDTOS = inventoryDTOList.stream()
               .filter(inventoryDTO -> artifactSnMap.containsKey(inventoryDTO.getSerialNumber()))
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(inventoryArtifactBoxDTOS)) {
               inventoryArtifactBoxDTOS.forEach(artifactBoxDtoParam -> {
                  TechArtifact artifact = artifactSnMap.get(artifactBoxDtoParam.getSerialNumber());
                  this.updateArtifactQuantity(artifact, artifactBoxDtoParam.getQuantity(), areaProductInfo);
                  List<String> userNameList = new ArrayList<>();
                  if (artifact.getUserNames() != null) {
                     userNameList = Arrays.stream(artifact.getUserNames().split(",")).collect(Collectors.toList());
                  }

                  if (!userNameList.contains(artifactBoxDtoParam.getUserName())) {
                     userNameList.add(artifactBoxDtoParam.getUserName());
                     artifact.setUserNames(String.join(", ", userNameList));
                  }

                  if (StringUtils.isNotBlank(artifactBoxDtoParam.getPrintedCode())) {
                     artifact.setPrintedCode(artifactBoxDtoParam.getPrintedCode());
                  }

                  TechDeepenRecord deepenRecord = this.deepenRecordService.buildDeepenRecord(artifact, artifactBoxDtoParam.getQuantity());
                  deepenRecordList.add(deepenRecord);
               });
               this.artifactService.updateBatchById(artifactSnMap.values());
               List<TechArtifactExt> artifactExtList = this.buildArtifactExt(
                  area.getMonomerId(), new ArrayList<>(artifactSnMap.values()), inventoryOperation.getImportUserId(), inventoryOperation.getCreateUserName()
               );
               this.artifactExtService.saveBatch(artifactExtList);
               this.assembleService.updateBatchById(areaProductInfo.getAssembleList());
               this.assembleExtService
                  .saveBatch(this.buildOldAssembleExt(area.getMonomerId(), new ArrayList<>(artifactSnMap.values()), areaProductInfo.getAssembleList()));
               this.machinePartService.updateBatchById(areaProductInfo.getMachinePartList());
            }

            List<InventoryArtifactBoxDTO> saveArtifactBoxDtoParamList = inventoryDTOList.stream()
               .filter(inventoryDTO -> !artifactSnMap.containsKey(inventoryDTO.getSerialNumber()))
               .collect(Collectors.toList());
            this.buildNewArtifactList(
               saveArtifactBoxDtoParamList,
               project.getMode(),
               area,
               this.techUtilManager.getTechConfigUtilsDto(BuildingTypeEnum.getMesProductTypeByType(inventoryOperation.getBuildingType())),
               areaProductInfo,
               deepenRecordList,
               inventoryOperation
            );
            this.deepenRecordService.saveBatch(deepenRecordList);
            this.buildSiteUseStandPart(inventoryOperation, areaProductInfo);
            this.updateDrawing(inventoryOperation, areaBatch);
         }

         this.sysPushFlowConfigBiz
            .triggerFlow(
               NotificationServiceTriggerDTO.builder()
                  .projectId(inventoryOperation.getProjectId())
                  .monomerId(inventoryOperation.getMonomerId())
                  .contentDetails(
                     this.detailsUtils
                        .getDetailedTemplateDetails(
                           inventoryOperation.getProjectId(), inventoryOperation.getMonomerId(), inventoryOperation.getAreaId(), "构件", true
                        )
                  )
                  .areaId(inventoryOperation.getAreaId())
                  .notificationTypeEnum(NotificationModuleTypeEnum.CREATE_DETAILED.getNotificationType())
                  .userList(new ArrayList<>())
                  .build()
            );
         return Boolean.TRUE;
      }
   }

   private void updateDrawing(MesTechInventoryOperation inventoryOperation, PlanAreaBatch areaBatch) {
      List<TechDrawing> drawingList = this.drawingService
         .list(
            (Wrapper<TechDrawing>)((new LambdaQueryWrapper<TechDrawing>()
                     .eq(TechDrawing::getMonomerId, inventoryOperation.getMonomerId()))
                  .eq(TechDrawing::getProductType, ProductTypeEnum.ALL_PRODUCT.getType()))
               .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType())
         );
      if (CollectionUtils.isNotEmpty(drawingList)) {
         Map<String, List<TechDrawing>> drawingMap = drawingList.stream().collect(Collectors.groupingBy(TechDrawing::getSerialNumber));
         List<TechArtifact> artifacts = this.artifactService
            .list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getAreaBatchId, areaBatch.getId()));
         List<TechAssemble> assembles = this.assembleService
            .list((Wrapper<TechAssemble>)new LambdaQueryWrapper<TechAssemble>().eq(TechAssemble::getAreaBatchId, areaBatch.getId()));
         List<TechMachinePart> machineParts = this.machinePartService
            .list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getAreaBatchId, areaBatch.getId()));
         List<TechDrawing> updateDrawingList = new ArrayList<>();
         machineParts.forEach(part -> {
            List<TechDrawing> techDrawings = drawingMap.get(part.getSerialNumber());
            if (CollectionUtils.isNotEmpty(techDrawings)) {
               techDrawings.forEach(drawing -> drawing.setProductType(ProductTypeEnum.MACHINE_PART.getType()));
               updateDrawingList.addAll(techDrawings);
            }
         });
         assembles.forEach(assemble -> {
            List<TechDrawing> techDrawings = drawingMap.get(assemble.getSerialNumber());
            if (CollectionUtils.isNotEmpty(techDrawings)) {
               techDrawings.forEach(drawing -> drawing.setProductType(ProductTypeEnum.ASSEMBLE.getType()));
               updateDrawingList.addAll(techDrawings);
            }
         });
         artifacts.forEach(artifact -> {
            List<TechDrawing> techDrawings = drawingMap.get(artifact.getSerialNumber());
            if (CollectionUtils.isNotEmpty(techDrawings)) {
               techDrawings.forEach(drawing -> drawing.setProductType(ProductTypeEnum.ARTIFACT.getType()));
               updateDrawingList.addAll(techDrawings);
            }
         });
         List<TechDrawing> distinctUpdate = updateDrawingList.stream().distinct().collect(Collectors.toList());
         this.drawingService.updateBatchById(distinctUpdate);
      }
   }

   private void buildSiteUseStandPart(MesTechInventoryOperation inventoryOperation, TechAreaProductInfoDTO areaProductInfo) {
      List<InventoryStandardPartDTO> standardPartDTOS = this.techUtilManager.getInventoryStandardPartList(inventoryOperation.getId());
      if (CollectionUtils.isNotEmpty(standardPartDTOS)) {
         Map<Long, WarehouseSaveDTOParam> saveDTOParamHashMap = new HashMap<>();
         List<TechStandardPart> newStandardPartList = new ArrayList<>(16);
         this.handleStandardPartList(standardPartDTOS, areaProductInfo.getStandardPartList(), newStandardPartList, saveDTOParamHashMap);
         if (CollectionUtils.isNotEmpty(newStandardPartList)) {
            newStandardPartList.forEach(standardPart -> {
               Long businessId = this.businessStandardPartService.addBusiness(BeanUtil.copy(standardPart, StandardPartAddDtoParam.class));
               standardPart.setBusinessId(businessId);
            });
            this.standardPartService.saveBatch(newStandardPartList);
            boolean booLink = this.techStandardPartBiz.checkWmsLink(inventoryOperation.getProjectId());
            if (!booLink) {
               for (TechStandardPart standardPart : newStandardPartList) {
                  WarehouseSaveDTOParam build = WarehouseSaveDTOParam.builder()
                     .projectId(standardPart.getProjectId())
                     .monomerId(standardPart.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType()) ? standardPart.getMonomerId() : 0L)
                     .areaId(standardPart.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType()) ? standardPart.getAreaId() : 0L)
                     .planId(standardPart.getRelationType().equals(ProductTypeEnum.ENCLOSURE.getType()) ? standardPart.getEnclosurePlanId() : 0L)
                     .factoryId(0L)
                     .workshopId(0L)
                     .productId(standardPart.getId())
                     .productType(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
                     .type(WarehouseTypeEnum.INTO.getType())
                     .quantity(standardPart.getQuantity())
                     .build();
                  this.intoWarehouse(build);
               }

               for (WarehouseSaveDTOParam saveDTOParam : saveDTOParamHashMap.values()) {
                  this.intoWarehouse(saveDTOParam);
               }
            }
         }
      }
   }

   private void buildNewArtifactList(
      List<InventoryArtifactBoxDTO> artifactBoxDtoParamList,
      Integer projectMode,
      PlanArea area,
      TechConfigUtilsDTO utilsDto,
      TechAreaProductInfoDTO areaProductInfoDto,
      List<TechDeepenRecord> deepenRecordList,
      MesTechInventoryOperation inventoryOperation
   ) {
      TechMonomerDrawInfoDTO monomerDrawInfoDto = this.techUtilManager.getMonomerDrawInfo(area.getMonomerId());
      Map<String, List<TechAssemble>> oldAssembleSnGroupMap = areaProductInfoDto.getAssembleSnGroupMap();
      Map<String, List<TechMachinePart>> oldMachinePartSnGroupMap = areaProductInfoDto.getMachinePartSnGroupMap();
      List<TechStandardPart> oldStandardPartList = areaProductInfoDto.getStandardPartList();
      List<TechArtifact> newArtifactList = new ArrayList<>(512);
      List<TechAssemble> newAssembleList = new ArrayList<>(2048);
      List<TechMachinePart> newMachinePartList = new ArrayList<>(4096);
      List<TechStandardPart> newStandardPartList = new ArrayList<>(16);
      artifactBoxDtoParamList.forEach(
         artifactBoxDtoParam -> {
            TechArtifact artifact = this.buildNewArtifact(artifactBoxDtoParam, area);
            newArtifactList.add(artifact);
            Map<Long, WarehouseSaveDTOParam> saveDTOParamHashMap = new HashMap<>();
            if (CollectionUtils.isNotEmpty(artifactBoxDtoParam.getStandardPartDTOS())) {
               List<InventoryStandardPartDTO> standardPartDTOS = artifactBoxDtoParam.getStandardPartDTOS()
                  .stream()
                  .filter(e -> AuxiliaryUsePropertyEnum.FACTORY_USE.getType().equals(e.getUseProperty()))
                  .collect(Collectors.toList());
               this.handleStandardPartList(standardPartDTOS, oldStandardPartList, newStandardPartList, saveDTOParamHashMap);
            }

            this.handleMachinePartList(artifactBoxDtoParam.getMachinePartDTOList(), area, monomerDrawInfoDto, oldMachinePartSnGroupMap, newMachinePartList);
            this.handAssembleList(
               projectMode,
               area,
               utilsDto,
               areaProductInfoDto,
               monomerDrawInfoDto,
               oldAssembleSnGroupMap,
               oldMachinePartSnGroupMap,
               newAssembleList,
               newMachinePartList,
               artifact,
               artifactBoxDtoParam.getAssembleDTOList()
            );
         }
      );
      this.artifactService.saveBatch(newArtifactList);
      List<TechArtifactExt> artifactExtList = this.buildArtifactExt(
         area.getMonomerId(), newArtifactList, inventoryOperation.getImportUserId(), inventoryOperation.getCreateUserName()
      );
      this.artifactExtService.saveBatch(artifactExtList);
      this.assembleService.saveBatch(newAssembleList);
      this.machinePartService.saveBatch(newMachinePartList);
      this.assembleService.updateBatchById(oldAssembleSnGroupMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList()));
      this.machinePartService.updateBatchById(oldMachinePartSnGroupMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList()));
      this.standardPartService.updateBatchById(oldStandardPartList);
      newStandardPartList.forEach(standardPart -> {
         if (standardPart.getUseProperty().equals(AuxiliaryUsePropertyEnum.SITE_USE.getType())) {
            Long businessId = this.businessStandardPartService.addBusiness(BeanUtil.copy(standardPart, StandardPartAddDtoParam.class));
            standardPart.setBusinessId(businessId);
         }
      });
      this.standardPartService.saveBatch(newStandardPartList);
      List<TechDeepenRecord> deepenRecords = newArtifactList.stream()
         .map(artifact -> this.deepenRecordService.buildDeepenRecord(artifact, artifact.getQuantity()))
         .collect(Collectors.toList());
      deepenRecordList.addAll(deepenRecords);
      Map<String, TechArtifact> newArtifactSnMap = newArtifactList.stream().collect(Collectors.toMap(TechArtifact::getSerialNumber, Function.identity()));
      areaProductInfoDto.getAssembleList().addAll(newAssembleList);
      areaProductInfoDto.getMachinePartList().addAll(newMachinePartList);
      areaProductInfoDto.getStandardPartList().addAll(newStandardPartList);
      Map<String, List<TechAssemble>> areaAssembleSnGroupMap = areaProductInfoDto.getAssembleList()
         .stream()
         .collect(Collectors.groupingBy(TechAssemble::getSerialNumber));
      Map<String, List<TechMachinePart>> areaMachinePartSnGroupMap = areaProductInfoDto.getMachinePartList()
         .stream()
         .collect(Collectors.groupingBy(TechMachinePart::getSerialNumber));
      List<TechStandardPart> areaStandardPartList = areaProductInfoDto.getStandardPartList();
      List<TechAssembleDetail> assembleDetailList = new ArrayList<>(1024);
      Map<String, TechAssembleDetail> assembleDetailMap = new HashMap<>();
      List<TechArtifactMachinePartLink> artifactMachinePartLinkList = new ArrayList<>(4096);
      List<TechArtifactStandardPartLink> artifactStandardPartLinkList = new ArrayList<>(1024);
      List<TechAssembleMachinePartLink> assembleMachinePartLinkList = new ArrayList<>(2048);
      Map<String, TechAssembleMachinePartLink> assembleMachinePartLinkMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(areaProductInfoDto.getAssembleList().stream().map(TechAssemble::getId).collect(Collectors.toList()))) {
         assembleMachinePartLinkMap = this.assembleMachinePartLinkService
            .list(
               (Wrapper<TechAssembleMachinePartLink>)new LambdaQueryWrapper<TechAssembleMachinePartLink>()
                  .in(
                     TechAssembleMachinePartLink::getAssembleId,
                     areaProductInfoDto.getAssembleList().stream().map(TechAssemble::getId).collect(Collectors.toList())
                  )
            )
            .stream()
            .collect(Collectors.toMap(e -> e.getAssembleId() + "-" + e.getMachinePartId(), Function.identity()));
      }

      Map<String, TechAssembleMachinePartLink> finalAssembleMachinePartLinkMap = assembleMachinePartLinkMap;
      artifactBoxDtoParamList.forEach(
         artifactBoxDtoParam -> {
            TechArtifact artifact = newArtifactSnMap.get(artifactBoxDtoParam.getSerialNumber());
            if (CollectionUtils.isNotEmpty(artifactBoxDtoParam.getAssembleDTOList())) {
               artifactBoxDtoParam.getAssembleDTOList()
                  .forEach(
                     elementAssembleDtoParam -> {
                        log.info("部件编号------------------------------------------------------:" + elementAssembleDtoParam.getSerialNumber());
                        List<TechAssemble> oldAssembleList = areaAssembleSnGroupMap.getOrDefault(elementAssembleDtoParam.getSerialNumber(), new ArrayList<>());
                        List<TechAssemble> assembles = oldAssembleList.stream()
                           .filter(
                              oldAssemble -> oldAssemble.getName() == null
                                 ? elementAssembleDtoParam.getName() == null
                                 : oldAssemble.getName().equals(elementAssembleDtoParam.getName())
                           )
                           .filter(
                              oldAssemble -> oldAssemble.getRemark() == null
                                 ? elementAssembleDtoParam.getRemark() == null
                                 : oldAssemble.getRemark().equals(elementAssembleDtoParam.getRemark())
                           )
                           .filter(oldAssemble -> oldAssemble.getBoolSendDirectly().equals(elementAssembleDtoParam.getBoolSendDirectly()))
                           .filter(oldAssemble -> oldAssemble.getBoolAllPartSendDirectly().equals(elementAssembleDtoParam.getBoolAllPartSendDirectly()))
                           .filter(oldAssemble -> oldAssemble.getSpecification().equals(elementAssembleDtoParam.getSpecification()))
                           .collect(Collectors.toList());
                        TechAssemble assemble = assembles.get(0);
                        if (!assembleDetailMap.containsKey(artifact.getId() + "-" + assemble.getId())) {
                           TechAssembleDetail assembleDetail = TechAssembleDetail.builder()
                              .artifactId(artifact.getId())
                              .assembleId(assemble.getId())
                              .quantity(elementAssembleDtoParam.getQuantity() / artifactBoxDtoParam.getQuantity())
                              .build();
                           assembleDetailList.add(assembleDetail);
                           assembleDetailMap.put(artifact.getId() + "-" + assemble.getId(), assembleDetail);
                        }

                        if (CollectionUtils.isNotEmpty(elementAssembleDtoParam.getAssembleElementMachinePartList())) {
                           elementAssembleDtoParam.getAssembleElementMachinePartList()
                              .forEach(
                                 partDtoParam -> {
                                    log.info("零件编号------------------------------------------------------:" + partDtoParam);
                                    List<TechMachinePart> oldMachinePartList = areaMachinePartSnGroupMap.get(partDtoParam.getSerialNumber());
                                    List<TechMachinePart> partList = oldMachinePartList.stream()
                                       .filter(part -> part.getName() == null ? partDtoParam.getName() == null : part.getName().equals(partDtoParam.getName()))
                                       .filter(part -> part.getSerialNumber().equals(partDtoParam.getSerialNumber()))
                                       .filter(
                                          part -> part.getRemark() == null
                                             ? partDtoParam.getRemark() == null
                                             : part.getRemark().equals(partDtoParam.getRemark())
                                       )
                                       .filter(part -> part.getBoolSendDirectly().equals(partDtoParam.getBoolSendDirectly()))
                                       .filter(part -> part.getBoolAllPartSendDirectly().equals(partDtoParam.getBoolAllPartSendDirectly()))
                                       .filter(part -> part.getSteelPlateTypeEnum().equals(partDtoParam.getSteelPlateTypeEnum()))
                                       .filter(part -> part.getSpecification().equals(partDtoParam.getSpecification()))
                                       .collect(Collectors.toList());
                                    TechMachinePart machinePart = partList.get(0);
                                    TechAssembleMachinePartLink assembleMachinePartLink = finalAssembleMachinePartLinkMap.get(
                                       assemble.getId() + "-" + machinePart.getId()
                                    );
                                    if (assembleMachinePartLink != null) {
                                       if (!assembleMachinePartLink.getQuantity().equals(partDtoParam.getQuantity() / elementAssembleDtoParam.getQuantity())) {
                                          Preconditions.checkArgument(
                                             assembleMachinePartLink.getQuantity().equals(partDtoParam.getQuantity() / elementAssembleDtoParam.getQuantity()),
                                             "部件零件比例不一致!!!"
                                          );
                                       }

                                       Preconditions.checkArgument(
                                          assembleMachinePartLink.getQuantity().equals(partDtoParam.getQuantity() / elementAssembleDtoParam.getQuantity()),
                                          "部件零件比例不一致!!!"
                                       );
                                    } else {
                                       TechAssembleMachinePartLink link = TechAssembleMachinePartLink.builder()
                                          .assembleId(assemble.getId())
                                          .machinePartId(machinePart.getId())
                                          .quantity(partDtoParam.getQuantity() / elementAssembleDtoParam.getQuantity())
                                          .build();
                                       assembleMachinePartLinkList.add(link);
                                       finalAssembleMachinePartLinkMap.put(assemble.getId() + "-" + machinePart.getId(), link);
                                    }
                                 }
                              );
                        }
                     }
                  );
            }

            if (CollectionUtils.isNotEmpty(artifactBoxDtoParam.getMachinePartDTOList())) {
               artifactBoxDtoParam.getMachinePartDTOList()
                  .forEach(
                     machinePartDtoParam -> {
                        List<TechMachinePart> oldMachinePartList = areaMachinePartSnGroupMap.get(machinePartDtoParam.getSerialNumber());
                        List<TechMachinePart> machineParts = oldMachinePartList.stream()
                           .filter(
                              part -> part.getName() == null ? machinePartDtoParam.getName() == null : part.getName().equals(machinePartDtoParam.getName())
                           )
                           .filter(part -> part.getSerialNumber().equals(machinePartDtoParam.getSerialNumber()))
                           .filter(
                              part -> part.getRemark() == null
                                 ? machinePartDtoParam.getRemark() == null
                                 : part.getRemark().equals(machinePartDtoParam.getRemark())
                           )
                           .filter(part -> part.getBoolSendDirectly().equals(machinePartDtoParam.getBoolSendDirectly()))
                           .filter(part -> part.getBoolAllPartSendDirectly().equals(machinePartDtoParam.getBoolAllPartSendDirectly()))
                           .filter(part -> part.getSteelPlateTypeEnum().equals(machinePartDtoParam.getSteelPlateTypeEnum()))
                           .filter(part -> part.getSpecification().equals(machinePartDtoParam.getSpecification()))
                           .collect(Collectors.toList());
                        TechMachinePart machinePart = machineParts.get(0);
                        TechArtifactMachinePartLink link = TechArtifactMachinePartLink.builder()
                           .artifactId(artifact.getId())
                           .machinePartId(machinePart.getId())
                           .quantity(machinePartDtoParam.getQuantity() / artifactBoxDtoParam.getQuantity())
                           .build();
                        artifactMachinePartLinkList.add(link);
                     }
                  );
            }

            if (CollectionUtils.isNotEmpty(artifactBoxDtoParam.getStandardPartDTOS())) {
               artifactBoxDtoParam.getStandardPartDTOS()
                  .forEach(
                     standardPartDtoParam -> {
                        Integer useProperty = standardPartDtoParam.getUseProperty();
                        if (AuxiliaryUsePropertyEnum.FACTORY_USE.getType().equals(useProperty)) {
                           List<TechStandardPart> standardPartList = areaStandardPartList.stream()
                              .filter(s -> s.getName().equals(standardPartDtoParam.getName()))
                              .filter(s -> s.getSpecification().equals(standardPartDtoParam.getSpecification()))
                              .filter(s -> "个".equals(s.getMeasureUnit()))
                              .filter(s -> "个".equals(s.getAccountingUnit()))
                              .filter(s -> s.getUseProperty().equals(useProperty))
                              .filter(s -> s.getBoolArtifactImport().equals(standardPartDtoParam.getBoolArtifactImport()))
                              .collect(Collectors.toList());
                           TechStandardPart standardPart = standardPartList.get(0);
                           TechArtifactStandardPartLink link = TechArtifactStandardPartLink.builder()
                              .artifactId(artifact.getId())
                              .standardPartId(standardPart.getId())
                              .quantity(standardPartDtoParam.getQuantity() / artifactBoxDtoParam.getQuantity())
                              .build();
                           artifactStandardPartLinkList.add(link);
                        }
                     }
                  );
            }
         }
      );
      this.assembleDetailService.saveBatch(assembleDetailList);
      this.assembleExtService.saveBatch(this.buildNewAssembleExt(area.getMonomerId(), newArtifactList, assembleDetailList));
      this.artifactMachinePartLinkService.saveBatch(artifactMachinePartLinkList);
      this.assembleMachinePartLinkService.saveBatch(assembleMachinePartLinkList);
      this.artifactStandardPartLinkService.saveBatch(artifactStandardPartLinkList);
      newMachinePartList.forEach(
         machinePart -> {
            if (machinePart.getSerialNumber().endsWith("-翼") || machinePart.getSerialNumber().endsWith("-腹")) {
               String serialNumber = machinePart.getSerialNumber().substring(0, machinePart.getSerialNumber().length() - 2);
               newAssembleList.forEach(
                  assemble -> {
                     if (assemble.getSerialNumber().equals(serialNumber)) {
                        newMachinePartList.forEach(
                           updateMachinePart -> {
                              List<TechAssembleMachinePartLink> techAssembleMachinePartLinkList = assembleMachinePartLinkList.stream()
                                 .filter(link -> link.getAssembleId().equals(assemble.getId()))
                                 .filter(link -> link.getMachinePartId().equals(updateMachinePart.getId()))
                                 .collect(Collectors.toList());
                              if (CollectionUtils.isNotEmpty(techAssembleMachinePartLinkList)
                                 && (updateMachinePart.getSerialNumber().endsWith("-翼") || updateMachinePart.getSerialNumber().endsWith("-腹"))) {
                                 updateMachinePart.setQuantity(assemble.getQuantity() * techAssembleMachinePartLinkList.get(0).getQuantity());
                                 updateMachinePart.setTotalNetWeight(machinePart.getNetWeight().multiply(new BigDecimal(machinePart.getQuantity())));
                                 updateMachinePart.setTotalGrossWeight(machinePart.getGrossWeight().multiply(new BigDecimal(machinePart.getQuantity())));
                                 this.machinePartService.updateById(updateMachinePart);
                              }
                           }
                        );
                     }
                  }
               );
            }
         }
      );
   }

   private void gridIntoWarehouse(List<TechArtifactExt> artifactExtList) {
      artifactExtList.forEach(
         ext -> {
            MesBuildingComplete complete = MesBuildingComplete.builder()
               .projectId(ext.getProjectId())
               .monomerId(ext.getMonomerId())
               .areaId(ext.getAreaId())
               .areaBatchId(ext.getAreaBatchId())
               .planId(0L)
               .productId(ext.getArtifactId())
               .number(ext.getSortNumber())
               .quantity(ext.getQuantity())
               .factoryId(0L)
               .workshopId(0L)
               .productionLineId(0L)
               .teamId(0L)
               .groupsId(0L)
               .taskId(0L)
               .taskTypeEnum(TaskTypeEnum.ARTIFACT.getType())
               .boolAbnormalEnum(false)
               .parentType(TaskTypeEnum.ARTIFACT.getType())
               .userId(UserUtil.getCurrentUserId())
               .build();
            this.completeService.save(complete);
            this.warehouseBiz
               .setStockQuantity(
                  WarehouseSaveDTOParam.builder()
                     .projectId(ext.getProjectId())
                     .monomerId(ext.getMonomerId())
                     .areaId(ext.getAreaId())
                     .areaBatchId(ext.getAreaBatchId())
                     .number(ext.getSortNumber())
                     .planId(0L)
                     .factoryId(0L)
                     .workshopId(0L)
                     .productId(ext.getArtifactId())
                     .productType(ProductTypeEnum.ARTIFACT.getType())
                     .type(WarehouseTypeEnum.INTO.getType())
                     .quantity(new BigDecimal(ext.getQuantity()))
                     .build()
               );
         }
      );
   }

   private void intoWarehouse(WarehouseSaveDTOParam build) {
      this.warehouseBiz.setStockQuantity(build);
   }

   private void handAssembleList(
      Integer projectMode,
      PlanArea area,
      TechConfigUtilsDTO utilsDto,
      TechAreaProductInfoDTO areaProductInfoDto,
      TechMonomerDrawInfoDTO monomerDrawInfoDto,
      Map<String, List<TechAssemble>> oldAssembleSnGroupMap,
      Map<String, List<TechMachinePart>> oldMachinePartSnGroupMap,
      List<TechAssemble> newAssembleList,
      List<TechMachinePart> newMachinePartList,
      TechArtifact artifact,
      List<InventoryAssembleDTO> elementAssembleList
   ) {
      if (CollectionUtils.isNotEmpty(elementAssembleList)) {
         elementAssembleList.forEach(
            elementMachinePartDtoParam -> {
               List<TechAssemble> oldAssembleList = oldAssembleSnGroupMap.getOrDefault(elementMachinePartDtoParam.getSerialNumber(), new ArrayList<>(8));
               List<TechAssemble> assembleList = oldAssembleList.stream()
                  .filter(
                     oldAssemble -> oldAssemble.getName() == null
                        ? elementMachinePartDtoParam.getName() == null
                        : oldAssemble.getName().equals(elementMachinePartDtoParam.getName())
                  )
                  .filter(
                     oldAssemble -> oldAssemble.getRemark() == null
                        ? elementMachinePartDtoParam.getRemark() == null
                        : oldAssemble.getRemark().equals(elementMachinePartDtoParam.getRemark())
                  )
                  .filter(oldAssemble -> oldAssemble.getSpecification().equals(elementMachinePartDtoParam.getSpecification()))
                  .filter(oldAssemble -> oldAssemble.getBoolSendDirectly().equals(elementMachinePartDtoParam.getBoolSendDirectly()))
                  .filter(oldAssemble -> oldAssemble.getBoolAllPartSendDirectly().equals(elementMachinePartDtoParam.getBoolAllPartSendDirectly()))
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(assembleList)) {
                  TechAssemble assemble = assembleList.get(0);
                  this.updateAssembleQuantity(assemble, elementMachinePartDtoParam.getQuantity(), areaProductInfoDto);
                  if (CollectionUtils.isNotEmpty(elementMachinePartDtoParam.getAssembleElementMachinePartList())) {
                     this.handleMachinePartList(
                        elementMachinePartDtoParam.getAssembleElementMachinePartList(), area, monomerDrawInfoDto, oldMachinePartSnGroupMap, newMachinePartList
                     );
                  }
               } else {
                  List<TechAssemble> techAssembles = newAssembleList.stream()
                     .filter(
                        oldAssemble -> oldAssemble.getName() == null
                           ? elementMachinePartDtoParam.getName() == null
                           : oldAssemble.getName().equals(elementMachinePartDtoParam.getName())
                     )
                     .filter(
                        oldAssemble -> oldAssemble.getRemark() == null
                           ? elementMachinePartDtoParam.getRemark() == null
                           : oldAssemble.getRemark().equals(elementMachinePartDtoParam.getRemark())
                     )
                     .filter(oldAssemble -> oldAssemble.getSpecification().equals(elementMachinePartDtoParam.getSpecification()))
                     .filter(oldAssemble -> oldAssemble.getBoolSendDirectly().equals(elementMachinePartDtoParam.getBoolSendDirectly()))
                     .filter(oldAssemble -> oldAssemble.getBoolAllPartSendDirectly().equals(elementMachinePartDtoParam.getBoolAllPartSendDirectly()))
                     .filter(oldAssemble -> oldAssemble.getSerialNumber().equals(elementMachinePartDtoParam.getSerialNumber()))
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(techAssembles)) {
                     TechAssemble assemble = techAssembles.get(0);
                     this.updateAssembleQuantity(assemble, elementMachinePartDtoParam.getQuantity(), areaProductInfoDto);
                     if (CollectionUtils.isNotEmpty(elementMachinePartDtoParam.getAssembleElementMachinePartList())) {
                        this.handleMachinePartList(
                           elementMachinePartDtoParam.getAssembleElementMachinePartList(),
                           area,
                           monomerDrawInfoDto,
                           oldMachinePartSnGroupMap,
                           newMachinePartList
                        );
                     }
                  } else {
                     TechAssemble assemble = this.buildNewAssemble(
                        elementMachinePartDtoParam, artifact, projectMode, utilsDto, monomerDrawInfoDto.getMonomerAssembleSnDrawSet()
                     );
                     newAssembleList.add(assemble);
                     if (CollectionUtils.isNotEmpty(elementMachinePartDtoParam.getAssembleElementMachinePartList())) {
                        this.handleMachinePartList(
                           elementMachinePartDtoParam.getAssembleElementMachinePartList(),
                           area,
                           monomerDrawInfoDto,
                           oldMachinePartSnGroupMap,
                           newMachinePartList
                        );
                     }
                  }
               }
            }
         );
      }
   }

   private TechAssemble buildNewAssemble(
      InventoryAssembleDTO inventoryAssembleDTO,
      TechArtifact artifact,
      Integer projectMode,
      TechConfigUtilsDTO configUtilsDTO,
      Set<String> monomerAssembleSnDrawSet
   ) {
      TechAssemble assemble = BeanUtil.copy(inventoryAssembleDTO, TechAssemble.class);
      assemble.setAreaType(artifact.getAreaType());
      assemble.setBoolSchedulingEnum(
         projectMode.equals(ProjectModeEnum.STANDARD_MODE.getType()) && configUtilsDTO.getProcessAssembleClassIds().contains(assemble.getAssembleConfigId())
      );
      assemble.setBoolProcess(assemble.getBoolSchedulingEnum());
      assemble.setBoolHaveNC1(monomerAssembleSnDrawSet.contains(assemble.getSerialNumber()));
      if (assemble.getBoolAllPartSendDirectly()) {
         MachinePartAddDtoParam addDtoParam = BeanUtil.copy(assemble, MachinePartAddDtoParam.class);
         addDtoParam.setTotalWeight(assemble.getTotalNetWeight());
         addDtoParam.setTotalLength(
            assemble.getLength().multiply(BigDecimal.valueOf(assemble.getQuantity().intValue())).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
         );
         addDtoParam.setProductType(ProductTypeEnum.ASSEMBLE.getType());
         Long businessId = this.businessMachinePartService.addBusinessInfo(addDtoParam);
         assemble.setBusinessId(businessId);
      }

      return assemble;
   }

   private TechArtifact buildNewArtifact(InventoryArtifactBoxDTO artifactBoxDtoParam, PlanArea area) {
      TechArtifact artifact = BeanUtil.copy(artifactBoxDtoParam, TechArtifact.class);
      artifact.setAreaType(area.getType());
      Preconditions.checkArgument(artifact.getStructureClassId() != null, "操作失败,构件数据有误!");
      if (!artifact.getBoolAllPartSendDirectly()) {
         ArtifactAddDTOParam dtoParam = BeanUtil.copy(artifact, ArtifactAddDTOParam.class);
         dtoParam.setTotalWeight(artifact.getTotalNetWeight());
         dtoParam.setTotalLength(
            artifact.getLength().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
         );
         Long businessId = this.businessArtifactService.addBusinessInfo(dtoParam);
         artifact.setBusinessId(businessId);
      }

      return artifact;
   }

   private void handleStandardPartList(
      List<InventoryStandardPartDTO> standardPartDtoParamList,
      List<TechStandardPart> oldStandardPartList,
      List<TechStandardPart> newStandardPartList,
      Map<Long, WarehouseSaveDTOParam> saveDTOParamHashMap
   ) {
      if (CollectionUtils.isNotEmpty(standardPartDtoParamList)) {
         standardPartDtoParamList.forEach(
            standardPartDtoParam -> {
               Integer useProperty = standardPartDtoParam.getUseProperty();
               List<TechStandardPart> oldStandardParts = oldStandardPartList.stream()
                  .filter(s -> s.getName().equals(standardPartDtoParam.getName()))
                  .filter(s -> s.getSpecification().equals(standardPartDtoParam.getSpecification()))
                  .filter(s -> "个".equals(s.getMeasureUnit()))
                  .filter(s -> "个".equals(s.getAccountingUnit()))
                  .filter(s -> s.getUseProperty().equals(useProperty))
                  .filter(s -> s.getBoolArtifactImport().equals(standardPartDtoParam.getBoolArtifactImport()))
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(oldStandardParts)) {
                  TechStandardPart standardPart = oldStandardParts.get(0);
                  WarehouseSaveDTOParam saveDTOParam = saveDTOParamHashMap.get(standardPart.getId());
                  if (saveDTOParam == null) {
                     WarehouseSaveDTOParam build = WarehouseSaveDTOParam.builder()
                        .projectId(standardPart.getProjectId())
                        .monomerId(standardPart.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType()) ? standardPart.getMonomerId() : 0L)
                        .areaId(standardPart.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType()) ? standardPart.getAreaId() : 0L)
                        .planId(standardPart.getRelationType().equals(ProductTypeEnum.ENCLOSURE.getType()) ? standardPart.getEnclosurePlanId() : 0L)
                        .factoryId(0L)
                        .workshopId(0L)
                        .productId(standardPart.getId())
                        .productType(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
                        .type(WarehouseTypeEnum.INTO.getType())
                        .quantity(BigDecimal.valueOf(standardPartDtoParam.getQuantity().intValue()))
                        .build();
                     saveDTOParamHashMap.put(standardPart.getId(), build);
                  } else {
                     saveDTOParam.setQuantity(saveDTOParam.getQuantity().add(BigDecimal.valueOf(standardPartDtoParam.getQuantity().intValue())));
                  }

                  standardPart.setQuantity(standardPart.getQuantity().add(BigDecimal.valueOf(standardPartDtoParam.getQuantity().intValue())));
                  standardPart.setMete(standardPart.getQuantity());
                  if (standardPart.getUseProperty().equals(AuxiliaryUsePropertyEnum.SITE_USE.getType())) {
                     if (standardPart.getBusinessId() != null) {
                        this.businessStandardPartService
                           .editBusiness(
                              standardPart.getBusinessId(), BigDecimal.valueOf(standardPartDtoParam.getQuantity().intValue()), standardPartDtoParam.getMete()
                           );
                     } else {
                        standardPart.setBusinessId(this.businessStandardPartService.addBusiness(BeanUtil.copy(standardPart, StandardPartAddDtoParam.class)));
                     }
                  }
               } else {
                  List<TechStandardPart> newStandardParts = newStandardPartList.stream()
                     .filter(s -> s.getName().equals(standardPartDtoParam.getName()))
                     .filter(s -> s.getSpecification().equals(standardPartDtoParam.getSpecification()))
                     .filter(s -> "个".equals(s.getMeasureUnit()))
                     .filter(s -> "个".equals(s.getAccountingUnit()))
                     .filter(s -> s.getUseProperty().equals(useProperty))
                     .filter(s -> s.getBoolArtifactImport().equals(standardPartDtoParam.getBoolArtifactImport()))
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(newStandardParts)) {
                     TechStandardPart standardPart = newStandardParts.get(0);
                     standardPart.setQuantity(standardPart.getQuantity().add(BigDecimal.valueOf(standardPartDtoParam.getQuantity().intValue())));
                     standardPart.setMete(standardPart.getQuantity());
                  } else {
                     boolean booLink = this.techStandardPartBiz.checkWmsLink(standardPartDtoParam.getProjectId());
                     Map<String, MesAuxiliary> auxiliaryMap = this.mesAuxiliaryService.list().stream().flatMap(auxiliary -> {
                        String[] names = auxiliary.getAuxiliaryName().split(",");
                        return Arrays.stream(names).map(name -> new SimpleEntry<>(name.trim() + "_" + auxiliary.getAccountingUnit(), auxiliary));
                     }).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
                     TechStandardPart standardPart = BeanUtil.copy(standardPartDtoParam, TechStandardPart.class);
                     standardPart.setBusinessId(0L);
                     standardPart.setBoolWmsLink(booLink);
                     if (!booLink) {
                        standardPart.setOriginalId(0L);
                     }

                     standardPart.setConfigStatus(
                        !booLink || auxiliaryMap.get(standardPartDtoParam.getName() + "_" + standardPartDtoParam.getAccountingUnit()) != null
                     );
                     standardPart.setQuantity(BigDecimal.valueOf(standardPartDtoParam.getQuantity().intValue()));
                     standardPart.setBoolArtifactImport(
                        standardPart.getUseProperty().equals(AuxiliaryUsePropertyEnum.SITE_USE.getType()) ? Boolean.FALSE : Boolean.TRUE
                     );
                     newStandardPartList.add(standardPart);
                  }
               }
            }
         );
      }
   }

   @Override
   public void exportArtifactPartTemplate(Integer mesInventoryProductEnum, HttpServletResponse response) {
      String resourcePath = "template/ZnljArtifactMachinePartImportTemplate.xlsx";
      if (MesProductEnum.BRIDGE.getType().equals(mesInventoryProductEnum)) {
         resourcePath = "template/BridgeMachinePartImportTemplate.xlsx";
      }

      if (MesProductEnum.GRID.getType().equals(mesInventoryProductEnum)) {
         resourcePath = "template/GridMachinePartImportTemplate.xlsx";
      }

      String exportFileName = "零构件清单导入模版.xlsx";
      ClassPathResource resource = new ClassPathResource(resourcePath);
      File file = null;

      try (InputStream inputStream = resource.getInputStream()) {
         file = File.createTempFile(exportFileName, "xls");
         FileUtil.copyInputStreamToFile(inputStream, file);
      } catch (IOException e) {
         log.error("文件下载异常，请联系管理员, {}", e.getMessage());
      }

      assert file != null;
      FileUtil.downloadFile(file, exportFileName);
   }

   private List<TechArtifactExt> buildArtifactExt(Long monomerId, List<TechArtifact> artifactList, Long importUserId, String importUserName) {
      List<TechArtifactExt> artifactExtList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(artifactList)) {
         List<TechArtifactExt> artifactExts = this.artifactExtService
            .listAllArtifactExt(monomerId, artifactList.stream().map(TechArtifact::getSerialNumber).collect(Collectors.toList()));
         Map<String, List<TechArtifactExt>> serialNumberExtListMap = artifactExts.stream().collect(Collectors.groupingBy(TechArtifactExt::getSerialNumber));
         Map<String, List<TechArtifact>> artifactSnListGroupMap = artifactList.stream().collect(Collectors.groupingBy(TechArtifact::getSerialNumber));
         artifactSnListGroupMap.forEach(
            (serialNumber, artifacts) -> {
               List<TechArtifactExt> extList = serialNumberExtListMap.get(serialNumber);
               Map<Long, List<TechArtifactExt>> artifactIdExtListMap = Collections.emptyMap();
               int maxSortNumber = 0;
               if (extList != null) {
                  maxSortNumber = Collections.max(extList.stream().map(TechArtifactExt::getSortNumber).collect(Collectors.toList()));
                  artifactIdExtListMap = extList.stream().filter(e -> !e.getBoolDeleteEnum()).collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
               }

               Map<Long, List<TechArtifactExt>> finalArtifactIdExtListMap = artifactIdExtListMap;
               int finalMaxSortNumber = maxSortNumber;
               artifacts.forEach(
                  artifact -> {
                     List<TechArtifactExt> exts = finalArtifactIdExtListMap.get(artifact.getId());
                     if (exts == null || exts.size() < artifact.getQuantity()) {
                        int size = exts != null ? exts.size() : 0;

                        for (int i = 1; i <= artifact.getQuantity() - size; i++) {
                           TechArtifactExt ext = TechArtifactExt.builder()
                              .projectId(artifact.getProjectId())
                              .monomerId(artifact.getMonomerId())
                              .areaId(artifact.getAreaId())
                              .areaBatchId(artifact.getAreaBatchId())
                              .importUserId(importUserId)
                              .importUserName(importUserName)
                              .artifactId(artifact.getId())
                              .serialNumber(artifact.getSerialNumber())
                              .quantity(1)
                              .sortNumber(finalMaxSortNumber + i)
                              .build();
                           artifactExtList.add(ext);
                        }
                     }
                  }
               );
            }
         );
      }

      return artifactExtList;
   }

   private List<TechAssembleExt> buildOldAssembleExt(Long monomerId, List<TechArtifact> areaArtifactList, List<TechAssemble> oldAssembleList) {
      List<TechAssembleExt> assembleExtList = new ArrayList<>();
      Map<Long, TechAssemble> assembleMap = new LinkedHashMap<>(512);
      if (CollectionUtils.isNotEmpty(areaArtifactList)) {
         Map<Long, TechArtifact> oldArtifactMap = areaArtifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         Map<Long, TechAssemble> oldAssembleMap = oldAssembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
            .list(
               Wrappers.lambdaQuery(TechAssembleDetail.class)
                  .in(TechAssembleDetail::getArtifactId, areaArtifactList.stream().map(TechArtifact::getId).collect(Collectors.toList()))
            );
         if (CollectionUtils.isNotEmpty(assembleDetailList)) {
            assembleDetailList.forEach(assembleDetail -> {
               TechArtifact artifact = oldArtifactMap.get(assembleDetail.getArtifactId());
               TechAssemble assemble = oldAssembleMap.get(assembleDetail.getAssembleId());
               TechAssemble techAssemble = assembleMap.get(assembleDetail.getAssembleId());
               if (techAssemble != null) {
                  techAssemble.setQuantity(techAssemble.getQuantity() + artifact.getQuantity() * assembleDetail.getQuantity());
               } else {
                  techAssemble = BeanUtil.copy(assemble, TechAssemble.class);
                  techAssemble.setQuantity(artifact.getQuantity() * assembleDetail.getQuantity());
                  assembleMap.put(assembleDetail.getAssembleId(), techAssemble);
               }
            });
         }
      }

      if (CollectionUtils.isNotEmpty(assembleMap)) {
         List<TechAssembleExt> allAssembleExts = this.assembleExtService
            .listAllAssembleExt(monomerId, assembleMap.values().stream().map(TechAssemble::getSerialNumber).collect(Collectors.toList()));
         Map<String, List<TechAssembleExt>> snAllExtListMap = allAssembleExts.stream().collect(Collectors.groupingBy(TechAssembleExt::getSerialNumber));
         Map<String, List<TechAssembleExt>> assembleExtMap = allAssembleExts.stream()
            .filter(e -> !e.getBoolDeleteEnum())
            .collect(Collectors.toList())
            .stream()
            .collect(Collectors.groupingBy(TechAssembleExt::getSerialNumber));
         Map<String, List<TechAssemble>> assembleSnListGroupMap = assembleMap.values().stream().collect(Collectors.groupingBy(TechAssemble::getSerialNumber));
         snAllExtListMap.forEach(
            (serialNumber, exts) -> {
               List<TechAssemble> assembles = assembleSnListGroupMap.get(serialNumber);
               Map<Long, List<TechAssembleExt>> techAssembleExtsMap = assembleExtMap.get(serialNumber)
                  .stream()
                  .collect(Collectors.groupingBy(TechAssembleExt::getAssembleId));
               Integer[] maxSortNumber = new Integer[]{Collections.max(exts.stream().map(TechAssembleExt::getSortNumber).collect(Collectors.toList()))};
               assembles.forEach(
                  assemble -> {
                     for (int i = 1; i <= assemble.getQuantity() - techAssembleExtsMap.get(assemble.getId()).size(); i++) {
                        TechAssembleExt ext = TechAssembleExt.builder()
                           .projectId(assemble.getProjectId())
                           .monomerId(assemble.getMonomerId())
                           .areaId(assemble.getAreaId())
                           .areaBatchId(assemble.getAreaBatchId())
                           .serialNumber(assemble.getSerialNumber())
                           .assembleId(assemble.getId())
                           .sortNumber(maxSortNumber[0] + i)
                           .build();
                        assembleExtList.add(ext);
                     }

                     maxSortNumber[0] = maxSortNumber[0] + (assemble.getQuantity() - techAssembleExtsMap.get(assemble.getId()).size());
                  }
               );
            }
         );
      }

      return assembleExtList;
   }

   private List<TechAssembleExt> buildNewAssembleExt(Long monomerId, List<TechArtifact> newArtifactList, List<TechAssembleDetail> newAssembleDetailList) {
      List<TechAssembleExt> assembleExtList = new ArrayList<>(1024);
      if (CollectionUtils.isEmpty(newAssembleDetailList)) {
         return assembleExtList;
      }

      Map<Long, Map<Long, TechAssembleDetail>> artifactIdAssembleIdRateMap = newAssembleDetailList.stream()
         .collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId, Collectors.toMap(TechAssembleDetail::getAssembleId, Function.identity())));
      List<TechAssemble> assembleList = this.assembleService
         .listByIds(newAssembleDetailList.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()));
      Map<Long, TechAssemble> newAssembleMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
      Map<Long, TechAssemble> assembleMap = new LinkedHashMap<>(512);
      newArtifactList.forEach(artifact -> {
         Map<Long, TechAssembleDetail> assembleIdRateMap = artifactIdAssembleIdRateMap.get(artifact.getId());
         if (assembleIdRateMap != null) {
            assembleIdRateMap.forEach((assembleId, link) -> {
               TechAssemble assemble = newAssembleMap.get(assembleId);
               if (assemble != null) {
                  TechAssemble techAssemble = assembleMap.get(assemble.getId());
                  if (techAssemble != null) {
                     techAssemble.setQuantity(techAssemble.getQuantity() + artifact.getQuantity() * link.getQuantity());
                  } else {
                     techAssemble = BeanUtil.copy(assemble, TechAssemble.class);
                     techAssemble.setQuantity(artifact.getQuantity() * link.getQuantity());
                     assembleMap.put(assembleId, techAssemble);
                  }
               }
            });
         }
      });
      if (CollectionUtils.isNotEmpty(assembleMap)) {
         List<String> assembleSnList = assembleMap.values().stream().map(TechAssemble::getSerialNumber).collect(Collectors.toList());
         List<TechAssembleExt> allTechAssembleExts = this.assembleExtService.listAllAssembleExt(monomerId, assembleSnList);
         Map<String, List<TechAssembleExt>> snExtListMap = allTechAssembleExts.stream().collect(Collectors.groupingBy(TechAssembleExt::getSerialNumber));
         Map<String, List<TechAssemble>> assembleSnListGroupMap = assembleMap.values().stream().collect(Collectors.groupingBy(TechAssemble::getSerialNumber));
         assembleSnListGroupMap.forEach(
            (sn, assembles) -> {
               List<TechAssembleExt> extList = snExtListMap.get(sn);
               int maxSortNumber = 0;
               if (extList != null) {
                  maxSortNumber = Collections.max(extList.stream().map(TechAssembleExt::getSortNumber).collect(Collectors.toList()));
               }

               int[] finalMaxSortNumber = new int[]{maxSortNumber};
               assembles.forEach(
                  assemble -> {
                     for (int i = 1; i <= assemble.getQuantity(); i++) {
                        TechAssembleExt ext = TechAssembleExt.builder()
                           .projectId(assemble.getProjectId())
                           .monomerId(assemble.getMonomerId())
                           .areaId(assemble.getAreaId())
                           .areaBatchId(assemble.getAreaBatchId())
                           .serialNumber(assemble.getSerialNumber())
                           .assembleId(assemble.getId())
                           .sortNumber(finalMaxSortNumber[0] + i)
                           .build();
                        assembleExtList.add(ext);
                     }

                     finalMaxSortNumber[0] += assemble.getQuantity();
                  }
               );
            }
         );
      }

      return assembleExtList;
   }

   private void handleMachinePartList(
      List<InventoryMachinePartDTO> machinePartPlateList,
      PlanArea area,
      TechMonomerDrawInfoDTO monomerDrawInfoDto,
      Map<String, List<TechMachinePart>> areaMachinePartSnGroupMap,
      List<TechMachinePart> newMachinePartList
   ) {
      if (CollectionUtils.isNotEmpty(machinePartPlateList)) {
         machinePartPlateList.forEach(
            machinePartDtoParam -> {
               List<TechMachinePart> oldMachinePartList = areaMachinePartSnGroupMap.getOrDefault(machinePartDtoParam.getSerialNumber(), new ArrayList<>(8));
               List<TechMachinePart> oldFilterMachinePartList = oldMachinePartList.stream()
                  .filter(part -> part.getName() == null ? machinePartDtoParam.getName() == null : part.getName().equals(machinePartDtoParam.getName()))
                  .filter(part -> part.getSerialNumber().equals(machinePartDtoParam.getSerialNumber()))
                  .filter(part -> part.getSpecification().equals(machinePartDtoParam.getSpecification()))
                  .filter(part -> part.getRemark() == null ? machinePartDtoParam.getRemark() == null : part.getRemark().equals(machinePartDtoParam.getRemark()))
                  .filter(part -> part.getBoolSendDirectly().equals(machinePartDtoParam.getBoolSendDirectly()))
                  .filter(part -> part.getBoolAllPartSendDirectly().equals(machinePartDtoParam.getBoolAllPartSendDirectly()))
                  .filter(part -> part.getSteelPlateTypeEnum().equals(machinePartDtoParam.getSteelPlateTypeEnum()))
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(oldFilterMachinePartList)) {
                  TechMachinePart machinePart = oldFilterMachinePartList.get(0);
                  this.updateMachinePartQuantity(machinePart, machinePartDtoParam.getQuantity());
               } else {
                  List<TechMachinePart> machinePartList = newMachinePartList.stream()
                     .filter(part -> part.getName() == null ? machinePartDtoParam.getName() == null : part.getName().equals(machinePartDtoParam.getName()))
                     .filter(part -> part.getSerialNumber().equals(machinePartDtoParam.getSerialNumber()))
                     .filter(part -> part.getSpecification().equals(machinePartDtoParam.getSpecification()))
                     .filter(
                        part -> part.getRemark() == null ? machinePartDtoParam.getRemark() == null : part.getRemark().equals(machinePartDtoParam.getRemark())
                     )
                     .filter(part -> part.getBoolSendDirectly().equals(machinePartDtoParam.getBoolSendDirectly()))
                     .filter(part -> part.getBoolAllPartSendDirectly().equals(machinePartDtoParam.getBoolAllPartSendDirectly()))
                     .filter(part -> part.getSteelPlateTypeEnum().equals(machinePartDtoParam.getSteelPlateTypeEnum()))
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(machinePartList)) {
                     TechMachinePart machinePart = machinePartList.get(0);
                     this.updateMachinePartQuantity(machinePart, machinePartDtoParam.getQuantity());
                  } else {
                     TechMachinePart machinePart = this.buildNewMachinePart(machinePartDtoParam, area, monomerDrawInfoDto);
                     oldMachinePartList.add(machinePart);
                     areaMachinePartSnGroupMap.put(machinePartDtoParam.getSerialNumber(), oldMachinePartList);
                     newMachinePartList.add(machinePart);
                  }
               }
            }
         );
      }
   }

   private TechMachinePart buildNewMachinePart(InventoryMachinePartDTO elementMachinePartDtoParam, PlanArea area, TechMonomerDrawInfoDTO monomerDrawInfoDto) {
      TechMachinePart machinePart = BeanUtil.copy(elementMachinePartDtoParam, TechMachinePart.class);
      machinePart.setBoolHaveHole(monomerDrawInfoDto.getHoleNumberMap().containsKey(machinePart.getSerialNumber()));
      machinePart.setHoleNumber(monomerDrawInfoDto.getHoleNumberMap().getOrDefault(machinePart.getSerialNumber(), 0L));
      if (monomerDrawInfoDto.getMonomerPartDrawingMap().containsKey(machinePart.getSerialNumber())) {
         TechDrawing drawing = monomerDrawInfoDto.getMonomerPartDrawingMap().get(machinePart.getSerialNumber()).get(0);
         machinePart.setPath(drawing.getCloudPath());
         machinePart.setOssRelativePath(area.getProjectId() + "/" + area.getMonomerId() + "/" + drawing.getFileName());
      }

      if (machinePart.getBoolAllPartSendDirectly()) {
         MachinePartAddDtoParam addDtoParam = BeanUtil.copy(machinePart, MachinePartAddDtoParam.class);
         addDtoParam.setTotalWeight(machinePart.getTotalNetWeight());
         addDtoParam.setTotalLength(
            machinePart.getLength()
               .multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue()))
               .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
         );
         addDtoParam.setProductType(ProductTypeEnum.MACHINE_PART.getType());
         Long businessId = this.businessMachinePartService.addBusinessInfo(addDtoParam);
         machinePart.setBusinessId(businessId);
      }

      return machinePart;
   }

   private void updateArtifactQuantity(TechArtifact artifact, Integer quantity, TechAreaProductInfoDTO areaProductInfoDto) {
      artifact.setQuantity(artifact.getQuantity() + quantity);
      artifact.setTotalNetWeight(artifact.getNetWeight().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())));
      artifact.setTotalGrossWeight(artifact.getGrossWeight().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())));
      artifact.setTotalDrawingWeight(
         artifact.getDrawingWeight() == null ? BigDecimal.ZERO : artifact.getDrawingWeight().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue()))
      );
      List<TechArtifactMachinePartLink> artifactMachinePartLinkList = areaProductInfoDto.getArtifactMachinePartLinkGroupMap()
         .getOrDefault(artifact.getId(), Collections.emptyList());
      Map<Long, TechMachinePart> machinePartIdMap = areaProductInfoDto.getMachinePartIdMap();
      artifactMachinePartLinkList.forEach(link -> {
         TechMachinePart machinePart = machinePartIdMap.get(link.getMachinePartId());
         this.updateMachinePartQuantity(machinePart, quantity * link.getQuantity());
      });
      List<TechAssembleDetail> assembleDetailList = areaProductInfoDto.getAssembleDetailGroupMap().getOrDefault(artifact.getId(), Collections.emptyList());
      Map<Long, TechAssemble> areaAssembleIdMap = areaProductInfoDto.getAssembleIdMap();
      assembleDetailList.forEach(assembleDetail -> {
         Integer addAssembleQuantity = quantity * assembleDetail.getQuantity();
         TechAssemble assemble = areaAssembleIdMap.get(assembleDetail.getAssembleId());
         this.updateAssembleQuantity(assemble, addAssembleQuantity, areaProductInfoDto);
      });
      List<TechArtifactStandardPartLink> artifactStandardPartLinkList = areaProductInfoDto.getArtifactStandardPartLinkGroupMap()
         .getOrDefault(artifact.getId(), Collections.emptyList());
      Map<Long, TechStandardPart> standardPartIdMap = areaProductInfoDto.getStandardPartList()
         .stream()
         .collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
      artifactStandardPartLinkList.forEach(link -> {
         TechStandardPart standardPart = standardPartIdMap.get(link.getStandardPartId());
         standardPart.setQuantity(standardPart.getQuantity().add(BigDecimal.valueOf((long)quantity.intValue() * link.getQuantity().intValue())));
         standardPart.setMete(standardPart.getQuantity());
      });
      if (artifact.getBusinessId() != null) {
         ArtifactEditDTOParam editDTOParam = ArtifactEditDTOParam.builder()
            .businessId(artifact.getBusinessId())
            .quantity(quantity)
            .totalWeight(artifact.getGrossWeight().multiply(BigDecimal.valueOf(quantity.intValue())))
            .totalLength(artifact.getLength().multiply(BigDecimal.valueOf(quantity.intValue())).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP))
            .build();
         this.businessArtifactService.editBusinessInfo(editDTOParam);
      }
   }

   private void updateAssembleQuantity(TechAssemble assemble, Integer addQuantity, TechAreaProductInfoDTO areaProductInfoDto) {
      assemble.setQuantity(assemble.getQuantity() + addQuantity);
      assemble.setTotalNetWeight(assemble.getNetWeight().multiply(BigDecimal.valueOf(assemble.getQuantity().intValue())));
      assemble.setTotalGrossWeight(
         assemble.getGrossWeight() != null ? assemble.getGrossWeight().multiply(BigDecimal.valueOf(assemble.getQuantity().intValue())) : null
      );
      if (assemble.getBoolAllPartSendDirectly()) {
         MachinePartEditDtoParam editDtoParam = MachinePartEditDtoParam.builder()
            .businessId(assemble.getBusinessId())
            .quantity(addQuantity)
            .totalWeight(assemble.getNetWeight().multiply(BigDecimal.valueOf(addQuantity.intValue())))
            .totalLength(assemble.getLength().multiply(BigDecimal.valueOf(addQuantity.intValue())).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP))
            .build();
         this.businessMachinePartService.editBusinessInfo(editDtoParam);
      }

      List<TechAssembleMachinePartLink> assembleMachinePartLinkList = areaProductInfoDto.getAssembleMachinePartLinkGroupMap()
         .getOrDefault(assemble.getId(), Collections.emptyList());
      if (CollectionUtils.isNotEmpty(assembleMachinePartLinkList)) {
         Map<Long, TechMachinePart> machinePartIdMap = areaProductInfoDto.getMachinePartIdMap();
         assembleMachinePartLinkList.forEach(link -> {
            TechMachinePart machinePart = machinePartIdMap.get(link.getMachinePartId());
            this.updateMachinePartQuantity(machinePart, addQuantity * link.getQuantity());
         });
      }
   }

   private void updateMachinePartQuantity(TechMachinePart machinePart, Integer addQuantity) {
      machinePart.setQuantity(machinePart.getQuantity() + addQuantity);
      machinePart.setTotalNetWeight(machinePart.getNetWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
      machinePart.setTotalGrossWeight(machinePart.getGrossWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
      if (machinePart.getBoolAllPartSendDirectly()) {
         MachinePartEditDtoParam editDtoParam = MachinePartEditDtoParam.builder()
            .businessId(machinePart.getBusinessId())
            .quantity(addQuantity)
            .totalWeight(machinePart.getNetWeight().multiply(BigDecimal.valueOf(addQuantity.intValue())))
            .totalLength(
               machinePart.getLength().multiply(BigDecimal.valueOf(addQuantity.intValue())).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
            )
            .build();
         this.businessMachinePartService.editBusinessInfo(editDtoParam);
      }
   }

   @Override
   public PageVO<TechArtifactDTO> listArtifactDTOByConditions(
      Long areaId,
      Long areaBatchId,
      String artifactName,
      String artifactSerialNumber,
      String specification,
      String material,
      String machinePartSerialNumber,
      Boolean boolMyself,
      String assembleSerialNumber,
      List<LocalDateTime> dateTimeList,
      String userName,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      Integer permissionCheck,
      Boolean boolImportDrawing
   ) {
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域不存在!");
      if (UserUtil.getCurrentUser().isAdmin()) {
         permissionCheck = null;
      }

      if (permissionCheck != null) {
         List<MonomerUserLink> monomerUserLinkList = this.monomerUserLinkService
            .list(
               Wrappers.lambdaQuery(MonomerUserLink.class)
                  .eq(MonomerUserLink::getMonomerId, area.getMonomerId())
                  .eq(MonomerUserLink::getDeepenedPersonId, UserUtil.getCurrentUser().getId())
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(monomerUserLinkList), "您没有查看此清单的权限!");
      }

      if (CollectionUtils.isNotEmpty(sort)) {
         PageHelper.startPage(pageNumber, pageSize, com.hzchum.pangu.common.util.StringUtils.analyzeSortConditions(sort));
      } else {
         PageHelper.startPage(pageNumber, pageSize);
      }

      Long userId = null;
      List<TechArtifactDTO> artifactDTOList = this.listByCondition(
         area.getMonomerId(),
         areaId,
         areaBatchId,
         artifactName,
         artifactSerialNumber,
         specification,
         material,
         machinePartSerialNumber,
         userId,
         assembleSerialNumber,
         permissionCheck,
         dateTimeList,
         userName
      );
      if (boolImportDrawing != null && boolImportDrawing) {
         artifactDTOList = artifactDTOList.stream().filter(e -> CollectionUtils.isNotEmpty(e.getDrawingAndSerialNumber())).collect(Collectors.toList());
      }

      if (boolImportDrawing != null && !boolImportDrawing) {
         artifactDTOList = artifactDTOList.stream().filter(e -> CollectionUtils.isEmpty(e.getDrawingAndSerialNumber())).collect(Collectors.toList());
      }

      return new PageVO<>(PageUtils.getPageVO(artifactDTOList, pageNumber, pageSize));
   }

   private List<TechArtifactDTO> listByCondition(
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      String artifactName,
      String artifactSerialNumber,
      String specification,
      String material,
      String machinePartSerialNumber,
      Long userId,
      String assembleSerialNumber,
      Integer permissionCheck,
      List<LocalDateTime> dateTimeList,
      String userName
   ) {
      List<TechArtifactDTO> techArtifactDTOS = this.artifactMachinePartLinkService
         .listArtifactPartByConditions(
            areaId,
            areaBatchId,
            artifactName,
            artifactSerialNumber,
            specification,
            material,
            machinePartSerialNumber,
            UserUtil.getCurrentUserId(),
            assembleSerialNumber,
            permissionCheck,
            dateTimeList,
            userName
         );
      if (CollectionUtils.isNotEmpty(techArtifactDTOS)) {
         List<String> serialNumberList = techArtifactDTOS.stream().map(TechArtifactDTO::getSerialNumber).collect(Collectors.toList());
         List<Long> artifactIds = techArtifactDTOS.stream().map(TechArtifactDTO::getId).collect(Collectors.toList());
         Map<String, List<TechDrawing>> drawingListMap = this.drawingService
            .list(
               (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                           .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                        .eq(TechDrawing::getProductType, DrawingProductTypeEnum.ARTIFACT.getType()))
                     .in(TechDrawing::getSerialNumber, serialNumberList))
                  .eq(TechDrawing::getMonomerId, monomerId)
            )
            .stream()
            .collect(Collectors.groupingBy(TechDrawing::getSerialNumber));
         List<TechArtifactExt> artifactExtList = this.artifactExtService
            .list(
               (Wrapper<TechArtifactExt>)((new LambdaQueryWrapper<TechArtifactExt>().eq(TechArtifactExt::getAreaId, areaId))
                     .eq(userId != null, TechArtifactExt::getImportUserId, userId))
                  .in(TechArtifactExt::getArtifactId, artifactIds)
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExtList), "操作失败,构件一物一码号缺失!");
         Map<Long, List<TechArtifactExt>> artifactExtMap = artifactExtList.stream().collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
         techArtifactDTOS.forEach(
            artifactDTO -> {
               if (drawingListMap.containsKey(artifactDTO.getSerialNumber())) {
                  artifactDTO.setNumbers(drawingListMap.get(artifactDTO.getSerialNumber()).stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
                  artifactDTO.setDrawingAndSerialNumber(
                     drawingListMap.get(artifactDTO.getSerialNumber())
                        .stream()
                        .map(drawing -> BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class))
                        .collect(Collectors.toList())
                  );
               }

               List<TechArtifactExt> artifactExts = artifactExtMap.get(artifactDTO.getId());
               Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExtList), "操作失败,构件一物一码号缺失!");
               artifactDTO.setUserName(artifactExts.stream().map(TechArtifactExt::getImportUserName).distinct().collect(Collectors.joining(",")));
            }
         );
      }

      return techArtifactDTOS;
   }

   @Override
   public void exportArtifactPartList(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      String artifactName,
      String artifactSerialNumber,
      String specification,
      String material,
      String machinePartSerialNumber,
      Long userId,
      String assembleSerialNumber,
      HttpServletResponse response
   ) {
      PlanAreaBatch areaBatch = this.areaBatchService.getById(areaBatchId);
      Preconditions.checkArgument(areaBatch != null, "批次不存在!");
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域不存在!");
      PlanMonomer monomer = this.monomerService.getById(area.getMonomerId());
      Preconditions.checkArgument(monomer != null, "单体不存在");
      ContractProject project = this.projectService.getById(area.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在!");
      String title = project.getName() + " - " + monomer.getName() + " - " + area.getName();
      String sheetName = monomer.getName() + "-" + area.getName() + "-构件清单";
      String fileName = monomer.getName() + "-" + area.getName() + "-构件清单.xlsx";
      List<TechArtifact> artifactRecordList = this.artifactService
         .list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getAreaBatchId, areaBatchId));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactRecordList), "下载失败,导入的构件清单记录不存在!");
      List<Long> artifactIds = artifactRecordList.stream().map(TechArtifact::getId).collect(Collectors.toList());
      Map<Long, TechAssemble> assembleRecordMap = this.assembleService
         .list((Wrapper<TechAssemble>)new LambdaQueryWrapper<TechAssemble>().eq(TechAssemble::getAreaBatchId, areaBatchId))
         .stream()
         .collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
      Set<Long> assembleIds = assembleRecordMap.keySet();
      Map<Long, TechMachinePart> machinePartRecordMap = this.machinePartService
         .list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getAreaBatchId, areaBatchId))
         .stream()
         .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      Map<Long, TechStandardPart> standardPartRecordMap = this.standardPartService
         .list((Wrapper<TechStandardPart>)new LambdaQueryWrapper<TechStandardPart>().eq(TechStandardPart::getAreaBatchId, areaBatchId))
         .stream()
         .collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
      Map<Long, List<TechAssembleDetail>> assembleDetailRecordMap = this.assembleDetailService
         .list((Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>().in(TechAssembleDetail::getArtifactId, artifactIds))
         .stream()
         .collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
      Map<Long, List<TechArtifactMachinePartLink>> partLinkRecordMap = this.artifactMachinePartLinkService
         .list((Wrapper<TechArtifactMachinePartLink>)new LambdaQueryWrapper<TechArtifactMachinePartLink>().in(TechArtifactMachinePartLink::getArtifactId, artifactIds))
         .stream()
         .collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
      Map<Long, List<TechAssembleMachinePartLink>> assembleMachinePartLinkRecordMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(assembleIds)) {
         assembleMachinePartLinkRecordMap = this.assembleMachinePartLinkService
            .list((Wrapper<TechAssembleMachinePartLink>)new LambdaQueryWrapper<TechAssembleMachinePartLink>().in(TechAssembleMachinePartLink::getAssembleId, assembleIds))
            .stream()
            .collect(Collectors.groupingBy(TechAssembleMachinePartLink::getAssembleId));
      }

      Map<Long, List<TechArtifactStandardPartLink>> standardPartLinkRecordMap = this.artifactStandardPartLinkService
         .list((Wrapper<TechArtifactStandardPartLink>)new LambdaQueryWrapper<TechArtifactStandardPartLink>().in(TechArtifactStandardPartLink::getArtifactId, artifactIds))
         .stream()
         .collect(Collectors.groupingBy(TechArtifactStandardPartLink::getArtifactId));
      AtomicInteger orderNo = new AtomicInteger(1);
      List<InventoryExportBaseCommonTemplateDTO> exportDTOList = new ArrayList<>();

      for (TechArtifact artifactRecord : artifactRecordList) {
         InventoryExportBaseCommonTemplateDTO exportTemplateDTO = BeanUtil.copy(artifactRecord, InventoryExportBaseCommonTemplateDTO.class);
         exportTemplateDTO.setArtifactNo(artifactRecord.getSerialNumber());
         exportTemplateDTO.setSerialNumber(null);
         exportTemplateDTO.setOrderNo(orderNo.getAndIncrement());
         exportTemplateDTO.setSurfaceArea(exportTemplateDTO.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 5, 4));
         exportDTOList.add(exportTemplateDTO);
         if (CollectionUtils.isNotEmpty(partLinkRecordMap)) {
            List<TechArtifactMachinePartLink> partLinkRecordList = partLinkRecordMap.get(artifactRecord.getId());
            if (CollectionUtils.isNotEmpty(partLinkRecordList)) {
               Preconditions.checkArgument(CollectionUtils.isNotEmpty(machinePartRecordMap), "下载失败,导入的零件不存在!");

               for (TechArtifactMachinePartLink machinePartLinkRecord : partLinkRecordList) {
                  TechMachinePart machinePartRecord = machinePartRecordMap.get(machinePartLinkRecord.getMachinePartId());
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
            List<TechAssembleDetail> assembleDetailRecords = assembleDetailRecordMap.get(artifactRecord.getId());
            if (CollectionUtils.isNotEmpty(assembleDetailRecords)) {
               Preconditions.checkArgument(CollectionUtils.isNotEmpty(assembleRecordMap), "下载失败,导入的部件清单不存在!");

               for (TechAssembleDetail detailRecord : assembleDetailRecords) {
                  TechAssemble techAssembleRecord = assembleRecordMap.get(detailRecord.getAssembleId());
                  Preconditions.checkArgument(techAssembleRecord != null, "下载失败,导入的部件清单不存在!");
                  InventoryExportBaseCommonTemplateDTO assembleExportTemplateDTO = BeanUtil.copy(techAssembleRecord, InventoryExportBaseCommonTemplateDTO.class);
                  if (monomer.getBuildingTypeEnum().equals(InventoryTypeEnum.BRIDGE.getType())) {
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
                     List<TechAssembleMachinePartLink> assembleMachinePartLinkRecordList = assembleMachinePartLinkRecordMap.get(techAssembleRecord.getId());
                     if (CollectionUtils.isNotEmpty(assembleMachinePartLinkRecordList)) {
                        Preconditions.checkArgument(CollectionUtils.isNotEmpty(machinePartRecordMap), "下载失败,导入的零件不存在!");

                        for (TechAssembleMachinePartLink assembleMachinePartLinkRecord : assembleMachinePartLinkRecordList) {
                           TechMachinePart machinePartRecord = machinePartRecordMap.get(assembleMachinePartLinkRecord.getMachinePartId());
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
                           partExportTemplateDTO.setSerialNumber(machinePartRecord.getSerialNumber());
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
            List<TechArtifactStandardPartLink> standardPartLinkRecords = standardPartLinkRecordMap.get(artifactRecord.getId());
            if (CollectionUtils.isNotEmpty(standardPartLinkRecords)) {
               Preconditions.checkArgument(CollectionUtils.isNotEmpty(standardPartRecordMap), "下载失败,导入的配套件不存在!");

               for (TechArtifactStandardPartLink standardPartLinkRecord : standardPartLinkRecords) {
                  TechStandardPart techStandardPartRecord = standardPartRecordMap.get(standardPartLinkRecord.getStandardPartId());
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
               e.setSingleArea(BigDecimal.ZERO);
            } else if (e.getSurfaceArea() != null && e.getSurfaceArea().compareTo(BigDecimal.ZERO) > 0) {
               e.setSingleArea(e.getSurfaceArea());
               e.setSurfaceArea(e.getSurfaceArea().multiply(BigDecimal.valueOf(e.getQuantity().intValue())));
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
               if (monomer.getBuildingTypeEnum().equals(InventoryTypeEnum.BRIDGE.getType())) {
                  e.setInnerPaintArea(e.getInnerPaintArea().divide(BigDecimal.valueOf(1000000L)));
               }
            }

            if (e.getOuterPaintArea() != null && e.getOuterPaintArea().compareTo(BigDecimal.ZERO) != 0) {
               e.setOuterPaintArea(e.getOuterPaintArea().multiply(BigDecimal.valueOf(e.getQuantity().intValue())));
               if (monomer.getBuildingTypeEnum().equals(InventoryTypeEnum.BRIDGE.getType())) {
                  e.setOuterPaintArea(e.getOuterPaintArea().divide(BigDecimal.valueOf(1000000L)));
               }
            }

            if (e.getURibPaintArea() != null && e.getURibPaintArea().compareTo(BigDecimal.ZERO) != 0) {
               e.setURibPaintArea(e.getURibPaintArea().multiply(BigDecimal.valueOf(e.getQuantity().intValue())).divide(BigDecimal.valueOf(1000000L)));
               e.setUbPaintArea(e.getURibPaintArea());
            }
         });
      }

      if (monomer.getBuildingTypeEnum().equals(InventoryTypeEnum.BRIDGE.getType())) {
         List<InventoryBridgeExportTemplateDTO> templateDTOS = cn.hutool.core.bean.BeanUtil.copyToList(exportDTOList, InventoryBridgeExportTemplateDTO.class);
         PoiUtils.exportExcel(templateDTOS, title, sheetName, InventoryBridgeExportTemplateDTO.class, fileName, ExcelType.XSSF, response);
      } else if (monomer.getBuildingTypeEnum().equals(InventoryTypeEnum.GRID.getType())) {
         List<InventoryGridExportTemplateDTO> templateDTOS = cn.hutool.core.bean.BeanUtil.copyToList(exportDTOList, InventoryGridExportTemplateDTO.class);
         PoiUtils.exportExcel(templateDTOS, title, sheetName, InventoryGridExportTemplateDTO.class, fileName, ExcelType.XSSF, response);
      } else {
         List<InventoryExportTemplateDTO> templateDTOS = cn.hutool.core.bean.BeanUtil.copyToList(exportDTOList, InventoryExportTemplateDTO.class);
         PoiUtils.exportExcel(templateDTOS, title, sheetName, InventoryExportTemplateDTO.class, fileName, ExcelType.XSSF, response);
      }
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updateStatus(Integer productType, Long id, Boolean status) {
      if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         TechMachinePart machinePart = this.machinePartService.getById(id);
         Preconditions.checkArgument(machinePart != null, "零件不存在,传入的零件id可能有误!");
         this.projectService.checkProjectStatus(machinePart.getProjectId());
         machinePart.setBoolStatusEnum(status);
         this.machinePartService.updateById(machinePart);
      }

      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         TechArtifact artifact = this.artifactService.getById(id);
         Preconditions.checkArgument(artifact != null, "构件不存在,传入的构件id可能有误!");
         this.projectService.checkProjectStatus(artifact.getProjectId());
         List<TechChangeRecordDetail> recordDetails = this.changeRecordDetailService
            .listChangeRecordDetailList(Collections.singletonList(id), CheckStatusEnum.PENDING.getType());
         Preconditions.checkArgument(CollectionUtils.isEmpty(recordDetails), "构件正处于变更待审核状态!");
         artifact.setBoolStatusEnum(status);
         this.artifactService.updateById(artifact);
      }

      if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         TechAssemble assemble = this.assembleService.getById(id);
         Preconditions.checkArgument(assemble != null, "构件不存在,传入的部件id可能有误!");
         this.projectService.checkProjectStatus(assemble.getProjectId());
         assemble.setBoolStatusEnum(status);
         this.assembleService.updateById(assemble);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteArtifact(MonomerAndProductIdVO vo) {
      this.mesTechInventoryOperationService
         .checkInventoryOperationByMonomerId(
            vo.getMonomerId(), Arrays.asList(InventoryReviewedEnum.FIXUP_RECORD.getType(), InventoryReviewedEnum.UNAUDITED.getType())
         );
      List<TechArtifactExt> artifactExtList = this.artifactExtService
         .list(
            (Wrapper<TechArtifactExt>)(new LambdaQueryWrapper<TechArtifactExt>().eq(TechArtifactExt::getImportUserId, UserUtil.getCurrentUserId()))
               .in(TechArtifactExt::getArtifactId, vo.getArtifactIds())
         );
      List<TechArtifact> artifactList = this.artifactService.listByIds(vo.getArtifactIds());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactList) && artifactList.size() == vo.getArtifactIds().size(), "删除失败,构件不存在!");
      Preconditions.checkArgument(artifactList.stream().allMatch(TechArtifact::getBoolStatusEnum), "构件处于暂停状态,不可删除!");
      Preconditions.checkArgument(artifactList.stream().map(TechArtifact::getAreaId).distinct().count() == 1L, "删除失败,所选构件不是同一个区域");
      Preconditions.checkArgument(artifactList.stream().map(TechArtifact::getAreaBatchId).distinct().count() == 1L, "删除失败,所选构件不是同一个批次");
      this.projectService.checkProjectStatus(artifactList.get(0).getProjectId());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExtList), "删除失败,仅可删除自己导入的清单!");
      Map<Long, List<TechArtifactExt>> artifactExtMap = artifactExtList.stream().collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      Preconditions.checkArgument(artifactExtMap.size() == vo.getArtifactIds().size(), "删除失败,仅可删除自己导入的清单!");
      Preconditions.checkArgument(artifactExtList.stream().noneMatch(TechArtifactExt::getBoolScheduling), "删除失败,构件已排产不可删除!");
      Preconditions.checkArgument(artifactExtList.stream().noneMatch(TechArtifactExt::getBoolSubscription), "删除失败,构件已办理申购不可删除!");
      Preconditions.checkArgument(artifactExtList.stream().allMatch(TechArtifactExt::getBoolStatusEnum), "删除识别,构件处于暂停状态,不可删除!");
      PlanArea area = this.areaService.getById(artifactList.get(0).getAreaId());
      PlanAreaBatch areaBatch = this.areaBatchService.getById(artifactList.get(0).getAreaBatchId());
      Preconditions.checkArgument(areaBatch != null, "操作失败,批次不存在!");

      for (TechArtifact artifact : artifactList) {
         artifact.setQuantity(artifact.getQuantity() - artifactExtMap.get(artifact.getId()).size());
         this.businessArtifactService
            .editBusinessInfo(
               ArtifactEditDTOParam.builder()
                  .businessId(artifact.getBusinessId())
                  .quantity(-artifactExtMap.get(artifact.getId()).size())
                  .totalWeight(artifact.getNetWeight().multiply(BigDecimal.valueOf(artifactExtMap.get(artifact.getId()).size())).negate())
                  .totalLength(
                     artifact.getLength().multiply(BigDecimal.valueOf(artifactExtMap.get(artifact.getId()).size())).divide(BigDecimal.valueOf(1000L)).negate()
                  )
                  .build()
            );
      }

      Map<Long, Integer> schedulingQuantityMap = this.artifactSchedulingService.getSchedulingQuantityMap(artifactList.get(0).getAreaId());

      for (TechArtifact artifact : artifactList) {
         this.projectService.checkProjectStatus(artifact.getProjectId());
         Preconditions.checkArgument(!schedulingQuantityMap.containsKey(artifact.getId()), "构件已排产,不能删除构件!");
      }

      if (CollectionUtils.isNotEmpty(artifactList)) {
         List<TechCappCraftProductTask> techCappCraftProductTasks = this.techCappCraftProductTaskBiz
            .list(
               Wrappers.lambdaQuery(TechCappCraftProductTask.class)
                  .eq(TechCappCraftProductTask::getProductType, ProductTypeEnum.ARTIFACT.getType())
                  .eq(TechCappCraftProductTask::getMonomerId, vo.getMonomerId())
                  .in(TechCappCraftProductTask::getProductId, artifactList.stream().map(TechArtifact::getId).collect(Collectors.toList()))
            );
         Preconditions.checkArgument(CollectionUtils.isEmpty(techCappCraftProductTasks), "当前区域存在构件焊接任务不可删除!!!");
      }

      this.deleteArtifactList(artifactExtMap, artifactList.stream().filter(e -> e.getQuantity() == 0).map(TechArtifact::getId).collect(Collectors.toList()));
      List<TechArtifact> update = artifactList.stream().filter(e -> e.getQuantity() != 0).collect(Collectors.toList());
      List<TechArtifact> remove = artifactList.stream().filter(e -> e.getQuantity() == 0).collect(Collectors.toList());
      this.techCappCraftCardProductLinkService
         .remove(
            Wrappers.lambdaQuery(TechCappCraftCardProductLink.class)
               .eq(TechCappCraftCardProductLink::getMonomerId, vo.getMonomerId())
               .eq(TechCappCraftCardProductLink::getProductType, ProductTypeEnum.ARTIFACT.getType())
               .in(TechCappCraftCardProductLink::getProductId, artifactList.stream().map(TechArtifact::getId).collect(Collectors.toList()))
         );
      this.artifactExtService.removeByIds(artifactExtList.stream().map(TechArtifactExt::getId).collect(Collectors.toList()));
      this.artifactService.updateBatchById(update);
      if (CollectionUtils.isNotEmpty(remove)) {
         this.artifactService.removeByIds(remove.stream().map(TechArtifact::getId).collect(Collectors.toList()));

         for (TechArtifact artifact : remove) {
            this.deepenRecordService.deleteDeepenRecord(ProductTypeEnum.ARTIFACT.getType(), artifact.getId());
         }
      }

      int count = this.artifactService.count(Wrappers.lambdaQuery(TechArtifact.builder().monomerId(area.getMonomerId()).build()));
      if (count == 0) {
         PlanMonomer monomer = PlanMonomer.builder().id(area.getMonomerId()).buildingTypeEnum(BuildingTypeEnum.UNKNOWN.getType()).build();
         this.monomerService.updateById(monomer);
      }

      int areaBatchCount = this.artifactService.count(Wrappers.lambdaQuery(TechArtifact.builder().areaBatchId(areaBatch.getId()).build()));
      int outboundAreaBatchCount = this.outboundDetailService
         .count(Wrappers.lambdaQuery(MoveOutboundDetail.class).eq(MoveOutboundDetail::getAreaBatchId, areaBatch.getId()));
      if (areaBatchCount == 0 && outboundAreaBatchCount == 0) {
         this.areaBatchService.removeById(areaBatch.getId());
      }

      this.sysPushFlowConfigBiz
         .triggerFlow(
            NotificationServiceTriggerDTO.builder()
               .projectId(remove.get(0).getProjectId())
               .monomerId(remove.get(0).getMonomerId())
               .contentDetails(
                  this.detailsUtils
                     .getDetailedTemplateDetails(remove.get(0).getProjectId(), remove.get(0).getMonomerId(), remove.get(0).getAreaId(), "构件", false)
               )
               .areaId(remove.get(0).getAreaId())
               .notificationTypeEnum(NotificationModuleTypeEnum.DELETE_DETAILED.getNotificationType())
               .userList(new ArrayList<>())
               .build()
         );
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean oneClearArtifact(Long areaId, Long monomerId, Long areaBatchId) {
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域不存在!");
      PlanAreaBatch areaBatch = this.areaBatchService.getById(areaBatchId);
      Preconditions.checkArgument(areaBatch != null, "操作失败,批次不存在!");
      Preconditions.checkArgument(areaBatch.getAreaId().equals(areaId), "操作失败,批次所在区域异常!");
      this.projectService.checkProjectStatus(area.getProjectId());
      this.mesTechInventoryOperationService
         .checkInventoryOperationByMonomerId(monomerId, Arrays.asList(InventoryReviewedEnum.FIXUP_RECORD.getType(), InventoryReviewedEnum.UNAUDITED.getType()));
      List<TechArtifactExt> userArtifactExts = this.artifactExtService
         .list(
            (Wrapper<TechArtifactExt>)(new LambdaQueryWrapper<TechArtifactExt>().eq(TechArtifactExt::getAreaId, areaId))
               .eq(TechArtifactExt::getImportUserId, UserUtil.getCurrentUserId())
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(userArtifactExts), "操作失败,只有导入人才有删除清单的权限!");
      List<TechArtifactExt> artifactExts = this.artifactExtService
         .list(
            (Wrapper<TechArtifactExt>)((((new LambdaQueryWrapper<TechArtifactExt>()
                           .eq(TechArtifactExt::getAreaId, areaId))
                        .eq(TechArtifactExt::getAreaBatchId, areaBatchId))
                     .eq(TechArtifactExt::getImportUserId, UserUtil.getCurrentUserId()))
                  .eq(TechArtifactExt::getBoolScheduling, Boolean.FALSE))
               .eq(TechArtifactExt::getBoolSubscription, Boolean.FALSE)
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExts), "操作失败,清单已排产!");
      Preconditions.checkArgument(artifactExts.stream().allMatch(TechArtifactExt::getBoolStatusEnum), "操作失败,构件处于暂停状态,不可删除!!");
      Map<Long, List<TechArtifactExt>> artifactExtMap = artifactExts.stream().collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      List<TechArtifact> artifactList = this.artifactService.listByIds(artifactExts.stream().map(TechArtifactExt::getArtifactId).collect(Collectors.toList()));

      for (TechArtifact artifact : artifactList) {
         List<TechArtifactExt> artifactExts1 = artifactExtMap.get(artifact.getId());
         artifact.setQuantity(artifact.getQuantity() - artifactExts1.size());
         this.businessArtifactService
            .editBusinessInfo(
               ArtifactEditDTOParam.builder()
                  .businessId(artifact.getBusinessId())
                  .quantity(-artifactExtMap.get(artifact.getId()).size())
                  .totalWeight(artifact.getNetWeight().multiply(BigDecimal.valueOf(artifactExtMap.get(artifact.getId()).size())).negate())
                  .totalLength(
                     artifact.getLength().multiply(BigDecimal.valueOf(artifactExtMap.get(artifact.getId()).size())).divide(BigDecimal.valueOf(1000L)).negate()
                  )
                  .build()
            );
      }

      List<TechCappCraftProductTask> techCappCraftProductTasks = this.techCappCraftProductTaskBiz
         .list(
            Wrappers.lambdaQuery(TechCappCraftProductTask.class)
               .eq(TechCappCraftProductTask::getProductType, ProductTypeEnum.ARTIFACT.getType())
               .eq(TechCappCraftProductTask::getMonomerId, monomerId)
               .eq(TechCappCraftProductTask::getAreaId, areaId)
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(techCappCraftProductTasks), "当前区域存在构件焊接任务不可删除!!!");
      this.deleteArtifactList(artifactExtMap, artifactList.stream().filter(e -> e.getQuantity() == 0).map(TechArtifact::getId).collect(Collectors.toList()));
      List<TechArtifact> update = artifactList.stream().filter(e -> e.getQuantity() != 0).collect(Collectors.toList());
      List<TechArtifact> remove = artifactList.stream().filter(e -> e.getQuantity() == 0).collect(Collectors.toList());
      this.techCappCraftCardProductLinkService
         .remove(
            Wrappers.lambdaQuery(TechCappCraftCardProductLink.class)
               .eq(TechCappCraftCardProductLink::getMonomerId, monomerId)
               .eq(TechCappCraftCardProductLink::getAreaId, areaId)
               .eq(TechCappCraftCardProductLink::getProductType, ProductTypeEnum.ARTIFACT.getType())
               .in(TechCappCraftCardProductLink::getProductId, artifactList.stream().map(TechArtifact::getId).collect(Collectors.toList()))
         );
      this.artifactExtService.removeByIds(artifactExts.stream().map(TechArtifactExt::getId).collect(Collectors.toList()));
      this.artifactService.updateBatchById(update);
      if (CollectionUtils.isNotEmpty(remove)) {
         this.artifactService.removeByIds(remove.stream().map(TechArtifact::getId).collect(Collectors.toList()));

         for (TechArtifact artifact : remove) {
            this.deepenRecordService.deleteDeepenRecord(ProductTypeEnum.ARTIFACT.getType(), artifact.getId());
         }
      }

      int count = this.artifactService.count(Wrappers.lambdaQuery(TechArtifact.builder().monomerId(area.getMonomerId()).build()));
      if (count == 0) {
         PlanMonomer monomer = PlanMonomer.builder().id(area.getMonomerId()).buildingTypeEnum(BuildingTypeEnum.UNKNOWN.getType()).build();
         this.monomerService.updateById(monomer);
      }

      int areaBatchCount = this.artifactService.count(Wrappers.lambdaQuery(TechArtifact.builder().areaBatchId(areaBatch.getId()).build()));
      int outboundAreaBatchCount = this.outboundDetailService
         .count(Wrappers.lambdaQuery(MoveOutboundDetail.class).eq(MoveOutboundDetail::getAreaBatchId, areaBatch.getId()));
      if (areaBatchCount == 0 && outboundAreaBatchCount == 0) {
         this.areaBatchService.removeById(areaBatch.getId());
      }

      this.sysPushFlowConfigBiz
         .triggerFlow(
            NotificationServiceTriggerDTO.builder()
               .projectId(area.getProjectId())
               .monomerId(area.getMonomerId())
               .contentDetails(this.detailsUtils.getDetailedTemplateDetails(area.getProjectId(), area.getMonomerId(), area.getId(), "构件", false))
               .areaId(area.getId())
               .notificationTypeEnum(NotificationModuleTypeEnum.DELETE_DETAILED.getNotificationType())
               .userList(new ArrayList<>())
               .build()
         );
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void deleteArtifactList(Map<Long, List<TechArtifactExt>> artifactMap, List<Long> removeArtifactIdList) {
      if (!CollectionUtils.isEmpty(artifactMap) && !CollUtil.isEmpty(removeArtifactIdList)) {
         Set<Long> artifactIds = artifactMap.keySet();
         List<TechArtifactMachinePartLink> artifactMachinePartLinkList = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artifactIds));
         if (CollectionUtils.isNotEmpty(artifactMachinePartLinkList)) {
            Map<Long, Map<Long, Integer>> artifactMachinePartRateMap = artifactMachinePartLinkList.stream()
               .collect(
                  Collectors.groupingBy(
                     TechArtifactMachinePartLink::getArtifactId,
                     Collectors.toMap(TechArtifactMachinePartLink::getMachinePartId, TechArtifactMachinePartLink::getQuantity)
                  )
               );
            List<Long> machinePartIds = artifactMachinePartLinkList.stream()
               .map(TechArtifactMachinePartLink::getMachinePartId)
               .distinct()
               .collect(Collectors.toList());
            List<TechMachinePart> machinePartList = this.machinePartService.listByIds(machinePartIds);
            Map<Long, TechMachinePart> machinePartMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            List<Long> removeMachinePartIds = new ArrayList<>(1024);
            artifactMap.forEach(
               (artifactId, artifactExtList) -> {
                  int quantity = artifactExtList.stream().mapToInt(TechArtifactExt::getQuantity).sum();
                  if (artifactMachinePartRateMap.containsKey(artifactId)) {
                     Map<Long, Integer> machinePartRateMap = artifactMachinePartRateMap.get(artifactId);
                     machinePartRateMap.forEach(
                        (machinePartId, rate) -> {
                           TechMachinePart machinePart = machinePartMap.get(machinePartId);
                           int reduceQuantity = quantity * rate;
                           machinePart.setQuantity(machinePart.getQuantity() - reduceQuantity);
                           machinePart.setTotalNetWeight(machinePart.getNetWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
                           machinePart.setTotalGrossWeight(machinePart.getGrossWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
                           if (machinePart.getBoolAllPartSendDirectly()) {
                              BigDecimal businessWeight = machinePart.getGrossWeight().compareTo(BigDecimal.ZERO) > 0
                                 ? machinePart.getGrossWeight()
                                 : machinePart.getNetWeight();
                              MachinePartEditDtoParam editDtoParam = MachinePartEditDtoParam.builder()
                                 .businessId(machinePart.getBusinessId())
                                 .quantity(-reduceQuantity)
                                 .totalWeight(businessWeight.multiply(BigDecimal.valueOf(reduceQuantity)).negate())
                                 .totalLength(machinePart.getLength().multiply(BigDecimal.valueOf(reduceQuantity)).negate())
                                 .build();
                              this.businessMachinePartService.editBusinessInfo(editDtoParam);
                           }

                           Preconditions.checkArgument(machinePart.getQuantity() >= 0, "操作失败,删除后的零件数量不可小于0");
                           if (machinePart.getQuantity() == 0) {
                              Preconditions.checkArgument(removeArtifactIdList.contains(artifactId), "操作失败,数据异常请联系管理员");
                              removeMachinePartIds.add(machinePartId);
                           }
                        }
                     );
                  }
               }
            );
            this.machinePartService.updateBatchById(machinePartList);
            this.machinePartService.removeByIds(removeMachinePartIds);
            if (CollectionUtils.isNotEmpty(removeArtifactIdList)) {
               this.artifactMachinePartLinkService
                  .remove(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, removeArtifactIdList));
            }
         }

         List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, artifactIds));
         if (CollectionUtils.isNotEmpty(assembleDetailList)) {
            Map<Long, Map<Long, Integer>> artifactAssembleRateMap = assembleDetailList.stream()
               .collect(
                  Collectors.groupingBy(TechAssembleDetail::getArtifactId, Collectors.toMap(TechAssembleDetail::getAssembleId, TechAssembleDetail::getQuantity))
               );
            List<Long> assembleIds = assembleDetailList.stream().map(TechAssembleDetail::getAssembleId).distinct().collect(Collectors.toList());
            List<TechAssemble> assembleList = this.assembleService.listByIds(assembleIds);
            Map<Long, TechAssemble> assembleMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
            List<Long> removeAssembleIds = new ArrayList<>(256);
            Map<Long, Integer> reduceAssembleQuantityMap = new HashMap<>(128);
            Map<Long, Map<Long, Integer>> reduceArtifactIdAssembleIdQuantityMap = new HashMap<>(512);
            artifactMap.forEach((artifactId, artifactExtList) -> {
               int quantity = artifactExtList.stream().mapToInt(TechArtifactExt::getQuantity).sum();
               if (artifactAssembleRateMap.containsKey(artifactId)) {
                  Map<Long, Integer> assembleIdQuantityMap = new HashMap<>(16);
                  Map<Long, Integer> assembleRateMap = artifactAssembleRateMap.get(artifactId);
                  assembleRateMap.forEach((assembleId, rate) -> {
                     TechAssemble assemble = assembleMap.get(assembleId);
                     Integer reduceAssembleQuantity = quantity * rate;
                     assemble.setQuantity(assemble.getQuantity() - reduceAssembleQuantity);
                     assemble.setTotalNetWeight(assemble.getNetWeight().multiply(BigDecimal.valueOf(assemble.getQuantity().intValue())));
                     if (reduceAssembleQuantityMap.containsKey(assembleId)) {
                        reduceAssembleQuantityMap.put(assembleId, reduceAssembleQuantityMap.get(assembleId) + reduceAssembleQuantity);
                     } else {
                        reduceAssembleQuantityMap.put(assembleId, reduceAssembleQuantity);
                     }

                     assembleIdQuantityMap.put(assembleId, reduceAssembleQuantity);
                     Preconditions.checkArgument(assemble.getQuantity() >= 0, "操作失败,删除后的部件数量不可小于0");
                     if (assemble.getQuantity() == 0) {
                        Preconditions.checkArgument(removeArtifactIdList.contains(artifactId), "操作失败,数据异常请联系管理员");
                        removeAssembleIds.add(assembleId);
                     }
                  });
                  reduceArtifactIdAssembleIdQuantityMap.put(artifactId, assembleIdQuantityMap);
               }
            });
            this.assembleService.updateBatchById(assembleList);
            this.assembleService.removeByIds(removeAssembleIds);
            if (CollectionUtils.isNotEmpty(removeArtifactIdList)) {
               this.assembleDetailService.remove(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, removeArtifactIdList));
            }

            this.delAssembleExt(artifactMap, reduceArtifactIdAssembleIdQuantityMap);
            List<TechAssembleMachinePartLink> assembleMachinePartLinkList = this.assembleMachinePartLinkService
               .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getAssembleId, assembleIds));
            if (CollectionUtils.isNotEmpty(assembleMachinePartLinkList)) {
               Map<Long, Map<Long, Integer>> assembleAssemblePartRateMap = assembleMachinePartLinkList.stream()
                  .collect(
                     Collectors.groupingBy(
                        TechAssembleMachinePartLink::getAssembleId,
                        Collectors.toMap(TechAssembleMachinePartLink::getMachinePartId, TechAssembleMachinePartLink::getQuantity)
                     )
                  );
               List<Long> machinePartIds = assembleMachinePartLinkList.stream()
                  .map(TechAssembleMachinePartLink::getMachinePartId)
                  .distinct()
                  .collect(Collectors.toList());
               List<TechMachinePart> machinePartList = this.machinePartService.listByIds(machinePartIds);
               Map<Long, TechMachinePart> machinePartMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
               List<Long> removePartIds = new ArrayList<>(128);
               assembleMap.forEach((assembleId, assemble) -> {
                  if (assembleAssemblePartRateMap.containsKey(assembleId)) {
                     Map<Long, Integer> machinePartRateMap = assembleAssemblePartRateMap.get(assembleId);
                     Integer reduceAssembleQuantity = reduceAssembleQuantityMap.get(assembleId);
                     machinePartRateMap.forEach((machinePartId, rate) -> {
                        TechMachinePart machinePart = machinePartMap.get(machinePartId);
                        machinePart.setQuantity(machinePart.getQuantity() - reduceAssembleQuantity * rate);
                        machinePart.setTotalNetWeight(machinePart.getNetWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
                        machinePart.setTotalGrossWeight(machinePart.getGrossWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
                        Preconditions.checkArgument(machinePart.getQuantity() >= 0, "操作失败,删除后的翼腹板数量不可小于0");
                        if (machinePart.getQuantity() == 0) {
                           removePartIds.add(machinePartId);
                        }
                     });
                  }
               });
               this.machinePartService.updateBatchById(machinePartList);
               this.machinePartService.removeByIds(removePartIds);
               if (CollectionUtils.isNotEmpty(removeAssembleIds)) {
                  this.assembleMachinePartLinkService
                     .remove(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getAssembleId, removeAssembleIds));
               }
            }
         }

         List<TechArtifactStandardPartLink> artifactStandardPartLinkList = this.artifactStandardPartLinkService
            .list((Wrapper<TechArtifactStandardPartLink>)new LambdaQueryWrapper<TechArtifactStandardPartLink>().in(TechArtifactStandardPartLink::getArtifactId, artifactIds));
         if (CollectionUtils.isNotEmpty(artifactStandardPartLinkList)) {
            Map<Long, Map<Long, Integer>> artifactStandardPartRateMap = artifactStandardPartLinkList.stream()
               .collect(
                  Collectors.groupingBy(
                     TechArtifactStandardPartLink::getArtifactId,
                     Collectors.toMap(TechArtifactStandardPartLink::getStandardPartId, TechArtifactStandardPartLink::getQuantity)
                  )
               );
            List<Long> standPartIds = artifactStandardPartLinkList.stream().map(TechArtifactStandardPartLink::getStandardPartId).collect(Collectors.toList());
            Map<Long, TechStandardPart> standardPartMap = this.standardPartService
               .listByIds(standPartIds)
               .stream()
               .collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
            List<Long> removeStandardPartIds = new ArrayList<>(1024);
            artifactMap.forEach(
               (artifactId, artifactExtList) -> {
                  int quantity = artifactExtList.stream().mapToInt(TechArtifactExt::getQuantity).sum();
                  if (artifactStandardPartRateMap.containsKey(artifactId)) {
                     Map<Long, Integer> standardPartRateMap = artifactStandardPartRateMap.get(artifactId);
                     standardPartRateMap.forEach(
                        (machinePartId, rate) -> {
                           TechStandardPart standardPart = standardPartMap.get(machinePartId);
                           int reduceQuantity = quantity * rate;
                           standardPart.setQuantity(standardPart.getQuantity().subtract(BigDecimal.valueOf(reduceQuantity)));
                           standardPart.setMete(standardPart.getQuantity());
                           this.businessStandardPartService
                              .editBusiness(standardPart.getBusinessId(), BigDecimal.valueOf(-reduceQuantity), BigDecimal.valueOf(-reduceQuantity));
                           Preconditions.checkArgument(standardPart.getQuantity().compareTo(BigDecimal.ZERO) >= 0, "操作失败,删除后的配套件数量不可小于0");
                           if (standardPart.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
                              removeStandardPartIds.add(machinePartId);
                           }
                        }
                     );
                  }
               }
            );
            this.standardPartService.updateBatchById(standardPartMap.values());
            if (CollectionUtils.isNotEmpty(removeStandardPartIds)) {
               this.standardPartService.removeByIds(removeStandardPartIds);
            }

            if (CollectionUtils.isNotEmpty(removeArtifactIdList)) {
               this.artifactMachinePartLinkService
                  .remove(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, removeArtifactIdList));
            }
         }
      }
   }

   private void delAssembleExt(Map<Long, List<TechArtifactExt>> artifactMap, Map<Long, Map<Long, Integer>> reduceArtifactIdAssembleIdQuantityMap) {
      if (CollectionUtils.isNotEmpty(reduceArtifactIdAssembleIdQuantityMap)) {
         Map<Long, Integer> finalReduceAssembleExtMap = new HashMap<>(512);
         reduceArtifactIdAssembleIdQuantityMap.forEach((artifactId, map) -> {
            List<TechArtifactExt> artifactExts = artifactMap.get(artifactId);
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExts), "操作失败,数据有误");
            map.forEach((assembleId, quantity) -> finalReduceAssembleExtMap.put(assembleId, finalReduceAssembleExtMap.getOrDefault(assembleId, 0) + quantity));
         });
         if (CollectionUtils.isNotEmpty(finalReduceAssembleExtMap)) {
            List<TechAssembleExt> assembleExtList = this.assembleExtService
               .list(
                  Wrappers.lambdaQuery(TechAssembleExt.class)
                     .eq(TechAssembleExt::getBoolTask, Boolean.FALSE)
                     .in(TechAssembleExt::getAssembleId, finalReduceAssembleExtMap.keySet())
               );
            Map<Long, List<TechAssembleExt>> assembleIdExtListMap = assembleExtList.stream().collect(Collectors.groupingBy(TechAssembleExt::getAssembleId));
            List<Long> assembleExtIdList = new ArrayList<>(1024);
            finalReduceAssembleExtMap.forEach(
               (assembleId, quantity) -> {
                  List<TechAssembleExt> extList = assembleIdExtListMap.get(assembleId);
                  List<Long> extIds = extList.stream()
                     .sorted(Comparator.comparing(TechAssembleExt::getSortNumber).reversed())
                     .limit(quantity.intValue())
                     .map(TechAssembleExt::getId)
                     .collect(Collectors.toList());
                  assembleExtIdList.addAll(extIds);
               }
            );
            this.assembleExtService.removeByIds(assembleExtIdList);
         }
      }
   }

   @Override
   public void exportArtifactPartChangeTemplate(HttpServletResponse response) {
      String resourcePath = "template/ArtifactMachinePartChangeTemplate.xlsx";
      String exportFileName = "零构件清单变更模版.xlsx";
      ClassPathResource resource = new ClassPathResource(resourcePath);
      File file = null;

      try (InputStream inputStream = resource.getInputStream()) {
         file = File.createTempFile(exportFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
      } catch (IOException e) {
         log.error("文件下载异常，请联系管理员, {}", e.getMessage());
      }

      assert file != null;
      FileUtil.downloadFile(file, exportFileName);
   }
}
