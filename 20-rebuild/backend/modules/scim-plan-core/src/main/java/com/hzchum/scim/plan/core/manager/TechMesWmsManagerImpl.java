package com.hzchum.scim.plan.core.manager;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.business.core.api.pojo.dtoParam.StandardPartAddDtoParam;
import com.hzchum.scim.business.core.api.service.BusinessStandardPartService;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactNoSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingArtifactScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseSaveDTOParam;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingArtifactSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.enums.AuxiliaryUsePropertyEnum;
import com.hzchum.scim.plan.core.api.enums.DrawingProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.manager.TechMesWmsManager;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanArtifactNoSchedulingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.SubscribeAuxiliaryWarehouseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.SubscribeProductWarehouseDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechProductSubscribeUpdateVORequest;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechMesWmsManagerImpl implements TechMesWmsManager {
   private final TechArtifactService artifactService;
   private final TechEnclosureService enclosureService;
   private final MesBuildingArtifactSchedulingService artifactSchedulingService;
   private final TechDrawingService drawingService;
   private final TechArtifactExtService artifactExtService;
   private final MesBuildingWarehouseSummaryService warehouseSummaryService;
   private final MesBuildingWarehouseRecordService warehouseRecordService;
   private final TechStandardPartService standardPartService;
   private final BusinessStandardPartService businessStandardPartService;

   @Override
   public PageVO<PlanArtifactNoSchedulingDTO> listPageArtifactNoSchedulingByCondition(
      Long projectId,
      Long monomerId,
      Long areaId,
      String name,
      String serialNumber,
      String specification,
      String material,
      Long structureClassId,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort)),
         this.artifactByConditionList(projectId, monomerId, areaId, name, serialNumber, specification, material, structureClassId)
      );
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean addSubscribeArtifactQuantity(List<TechProductSubscribeUpdateVORequest> subscribeSaveVORequestList) {
      List<Long> artifactIds = subscribeSaveVORequestList.stream()
         .map(TechProductSubscribeUpdateVORequest::getProductId)
         .distinct()
         .collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactIds) && artifactIds.size() == subscribeSaveVORequestList.size(), "操作失败,参数不可为空或者重复");
      List<TechArtifact> artifacts = this.artifactService.listByIds(artifactIds);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifacts) && artifacts.size() == artifactIds.size(), "操作失败,构件清单不存在!");
      Map<Long, TechProductSubscribeUpdateVORequest> saveVORequestMap = subscribeSaveVORequestList.stream()
         .collect(Collectors.toMap(TechProductSubscribeUpdateVORequest::getProductId, Function.identity()));
      Map<Long, List<MesBuildingArtifactScheduling>> artifactSchedulingMap = this.artifactSchedulingService
         .list((Wrapper<MesBuildingArtifactScheduling>)new LambdaQueryWrapper<MesBuildingArtifactScheduling>().in(MesBuildingArtifactScheduling::getProductId, artifactIds))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingArtifactScheduling::getProductId));
      Map<Long, List<TechArtifactExt>> artifactExtMap = this.artifactExtService
         .list(
            (Wrapper<TechArtifactExt>)((new LambdaQueryWrapper<TechArtifactExt>()
                     .eq(TechArtifactExt::getBoolSubscription, Boolean.FALSE))
                  .eq(TechArtifactExt::getBoolScheduling, Boolean.FALSE))
               .in(TechArtifactExt::getArtifactId, artifactIds)
         )
         .stream()
         .collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExtMap), "操作失败,构件一物一码信息不存在");
      List<TechArtifactExt> allArtifactExts = new ArrayList<>();
      artifacts.forEach(artifact -> {
         List<MesBuildingArtifactScheduling> schedulings = artifactSchedulingMap.get(artifact.getId());
         TechProductSubscribeUpdateVORequest saveVORequest = saveVORequestMap.get(artifact.getId());
         int operableQuantity = artifact.getQuantity() - artifact.getSubscriptionQuantity() - saveVORequest.getQuantity();
         Preconditions.checkArgument(operableQuantity >= 0, "操作失败,构件" + artifact.getSerialNumber() + "可操作数量不足,请刷新页面重试!");
         if (CollectionUtils.isNotEmpty(schedulings)) {
            int sum = schedulings.stream().mapToInt(MesBuildingArtifactScheduling::getQuantity).sum();
            Preconditions.checkArgument(operableQuantity - sum >= 0, "操作失败,构件" + artifact.getSerialNumber() + "可操作数量不足,请刷新页面重试!");
         }

         List<TechArtifactExt> artifactExts = artifactExtMap.get(artifact.getId());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExts), "操作失败,构件一物一码信息不存在!");
         Preconditions.checkArgument(saveVORequest.getQuantity() <= artifactExts.size(), "操作失败,构件" + artifact.getSerialNumber() + "可操作数量不足,请刷新页面重试!");
         artifactExts.sort(Comparator.comparingInt(TechArtifactExt::getSortNumber));
         List<TechArtifactExt> extList = artifactExts.stream().limit(saveVORequest.getQuantity().intValue()).collect(Collectors.toList());
         extList.forEach(s -> s.setBoolSubscription(Boolean.TRUE));
         artifact.setSubscriptionQuantity(artifact.getSubscriptionQuantity() + saveVORequest.getQuantity());
         allArtifactExts.addAll(extList);
      });
      this.artifactService.updateBatchById(artifacts);
      this.artifactExtService.updateBatchById(allArtifactExts);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean removeSubscribeArtifactQuantity(List<TechProductSubscribeUpdateVORequest> subscribeSaveVORequestList) {
      List<Long> artifactIds = subscribeSaveVORequestList.stream()
         .map(TechProductSubscribeUpdateVORequest::getProductId)
         .distinct()
         .collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactIds) && artifactIds.size() == subscribeSaveVORequestList.size(), "操作失败,参数不可为空或者重复");
      List<TechArtifact> artifacts = this.artifactService.listByIds(artifactIds);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifacts) && artifacts.size() == artifactIds.size(), "操作失败,构件清单不存在!");
      Map<Long, List<TechArtifactExt>> artifactExtMap = this.artifactExtService
         .list(
            (Wrapper<TechArtifactExt>)((new LambdaQueryWrapper<TechArtifactExt>().eq(TechArtifactExt::getBoolSubscription, Boolean.TRUE))
                  .eq(TechArtifactExt::getBoolScheduling, Boolean.FALSE))
               .in(TechArtifactExt::getArtifactId, artifactIds)
         )
         .stream()
         .collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExtMap), "操作失败,申购的构件一物一码信息不存在");
      Map<Long, TechProductSubscribeUpdateVORequest> saveVORequestMap = subscribeSaveVORequestList.stream()
         .collect(Collectors.toMap(TechProductSubscribeUpdateVORequest::getProductId, Function.identity()));
      List<TechArtifactExt> allArtifactExts = new ArrayList<>();
      artifacts.forEach(
         artifact -> {
            TechProductSubscribeUpdateVORequest saveVORequest = saveVORequestMap.get(artifact.getId());
            Preconditions.checkArgument(
               artifact.getSubscriptionQuantity() >= saveVORequest.getQuantity(), "操作失败,构件" + artifact.getSerialNumber() + "可操作数量不足,请刷新页面重试!"
            );
            List<TechArtifactExt> artifactExts = artifactExtMap.get(artifact.getId());
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExts), "操作失败,构件一物一码信息不存在!");
            Preconditions.checkArgument(saveVORequest.getQuantity() <= artifactExts.size(), "操作失败,构件" + artifact.getSerialNumber() + "可操作数量不足,请刷新页面重试!");
            artifactExts.sort(Comparator.comparingInt(TechArtifactExt::getSortNumber));
            List<TechArtifactExt> extList = artifactExts.stream().limit(saveVORequest.getQuantity().intValue()).collect(Collectors.toList());
            extList.forEach(s -> s.setBoolSubscription(Boolean.FALSE));
            artifact.setSubscriptionQuantity(artifact.getSubscriptionQuantity() - saveVORequest.getQuantity());
            allArtifactExts.addAll(extList);
         }
      );
      this.artifactService.updateBatchById(artifacts);
      this.artifactExtService.updateBatchById(allArtifactExts);
      return Boolean.TRUE;
   }

   private List<PlanArtifactNoSchedulingDTO> artifactByConditionList(
      Long projectId, Long monomerId, Long areaId, String name, String serialNumber, String specification, String material, Long structureClassId
   ) {
      List<MesBuildingArtifactNoSchedulingDO> mesBuildingArtifactNoSchedulingDOS = this.artifactSchedulingService
         .listArtifactNoSchedulingByCondition(projectId, monomerId, areaId, name, serialNumber, specification, material, structureClassId);
      if (CollectionUtils.isNotEmpty(mesBuildingArtifactNoSchedulingDOS)) {
         List<PlanArtifactNoSchedulingDTO> planArtifactNoSchedulingDTOS = BeanUtil.copyToList(
            mesBuildingArtifactNoSchedulingDOS, PlanArtifactNoSchedulingDTO.class
         );
         Map<NameInfo, List<PlanArtifactNoSchedulingDTO>> doListMap = planArtifactNoSchedulingDTOS.stream()
            .collect(Collectors.groupingBy(PlanArtifactNoSchedulingDTO::getMonomer));
         doListMap.forEach(
            (monomer, artifactDTOList) -> {
               List<String> serialNumberList = artifactDTOList.stream().map(PlanArtifactNoSchedulingDTO::getSerialNumber).collect(Collectors.toList());
               Map<String, List<TechDrawing>> drawingListMap = this.drawingService
                  .list(
                     (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                                 .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                              .eq(TechDrawing::getProductType, DrawingProductTypeEnum.ARTIFACT.getType()))
                           .in(TechDrawing::getSerialNumber, serialNumberList))
                        .eq(TechDrawing::getMonomerId, monomer.getId())
                  )
                  .stream()
                  .collect(Collectors.groupingBy(TechDrawing::getSerialNumber));
               artifactDTOList.forEach(
                  e -> {
                     e.setProductType(ProductTypeEnum.ARTIFACT.getType());
                     if (drawingListMap.containsKey(e.getSerialNumber())) {
                        e.setNumbers(drawingListMap.get(e.getSerialNumber()).stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
                        e.setDrawingAndSerialNumber(
                           drawingListMap.get(e.getSerialNumber())
                              .stream()
                              .map(drawing -> com.hzchum.pangu.common.util.BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class))
                              .collect(Collectors.toList())
                        );
                     }
                  }
               );
            }
         );
         return planArtifactNoSchedulingDTOS;
      } else {
         return new ArrayList<>();
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void addEnclosureSubscribeQuantity(Collection<TechProductSubscribeUpdateVORequest> voRequestList) {
      if (CollectionUtils.isNotEmpty(voRequestList)) {
         List<TechEnclosure> enclosureList = this.enclosureService
            .listByIds(voRequestList.stream().map(TechProductSubscribeUpdateVORequest::getProductId).collect(Collectors.toList()));
         Map<Long, TechEnclosure> enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
         voRequestList.forEach(
            vo -> {
               TechEnclosure enclosure = enclosureMap.get(vo.getProductId());
               Preconditions.checkArgument(enclosure != null, "围护数据不存在!");
               Preconditions.checkArgument(
                  vo.getQuantity() + enclosure.getSubscribeQuantity() + enclosure.getSchedulingQuantity() <= enclosure.getQuantity(), "申购数量超出可申购数量限制!"
               );
               enclosure.setSubscribeQuantity(enclosure.getSubscribeQuantity() + vo.getQuantity());
            }
         );
         this.enclosureService.updateBatchById(enclosureList);
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void addEnclosureSubscribeQuantity(TechProductSubscribeUpdateVORequest voRequest) {
      this.addEnclosureSubscribeQuantity(Collections.singletonList(voRequest));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void removeEnclosureSubscribeQuantity(Collection<TechProductSubscribeUpdateVORequest> voRequestList) {
      if (CollectionUtils.isNotEmpty(voRequestList)) {
         List<TechEnclosure> enclosureList = this.enclosureService
            .listByIds(voRequestList.stream().map(TechProductSubscribeUpdateVORequest::getProductId).collect(Collectors.toList()));
         Map<Long, TechEnclosure> enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
         voRequestList.forEach(vo -> {
            TechEnclosure enclosure = enclosureMap.get(vo.getProductId());
            Preconditions.checkArgument(enclosure != null, "围护数据不存在!");
            enclosure.setSubscribeQuantity(enclosure.getSubscribeQuantity() - vo.getQuantity());
         });
         this.enclosureService.updateBatchById(enclosureList);
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void removeEnclosureSubscribeQuantity(TechProductSubscribeUpdateVORequest voRequest) {
      this.removeEnclosureSubscribeQuantity(Collections.singletonList(voRequest));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void saveSubscribeProductWarehouseEntry(List<SubscribeProductWarehouseDTO> productWarehouseDTOList) {
      Preconditions.checkArgument(
         productWarehouseDTOList.stream()
            .allMatch(
               e -> e.getBasicClass().equals(BasicClassEnum.STRUC_MANUFACTURED.getType())
                  || e.getBasicClass().equals(BasicClassEnum.ENCL_MANUFACTURED.getType())
            ),
         "操作失败,暂只支持构件/围护制成品申购出库!"
      );
      Map<Integer, List<SubscribeProductWarehouseDTO>> productWarehouseDTOMap = productWarehouseDTOList.stream()
         .collect(Collectors.groupingBy(SubscribeProductWarehouseDTO::getBasicClass));
      productWarehouseDTOMap.forEach((basicClassEnum, productWarehouseDTOS) -> {
         if (BasicClassEnum.STRUC_MANUFACTURED.getType().equals(basicClassEnum)) {
            this.buildArtifactWarehouseRecordInfo((List<SubscribeProductWarehouseDTO>)productWarehouseDTOS);
         }

         if (BasicClassEnum.ENCL_MANUFACTURED.getType().equals(basicClassEnum)) {
            this.buildEnclosureWarehouseRecordInfo((List<SubscribeProductWarehouseDTO>)productWarehouseDTOS);
         }
      });
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void saveSubscribeAuxiliaryWarehouseEntry(List<SubscribeAuxiliaryWarehouseDTO> productWarehouseDTOList) {
      List<WarehouseSaveDTOParam> saveDTOParamList = new ArrayList<>();

      for (SubscribeAuxiliaryWarehouseDTO warehouseDTO : productWarehouseDTOList) {
         TechStandardPart standardPart = com.hzchum.pangu.common.util.BeanUtil.copy(warehouseDTO, TechStandardPart.class);
         standardPart.setRelationType(ProductTypeEnum.AUXILIARY_MATERIAL.getType());
         standardPart.setUseProperty(AuxiliaryUsePropertyEnum.SITE_USE.getType());
         standardPart.setUserId(UserUtil.getCurrentUserId());
         standardPart.setBoolSubscription(Boolean.TRUE);
         standardPart.setProjectId(warehouseDTO.getProjectId());
         standardPart.setMaterialInventoryId(warehouseDTO.getMaterialInventoryId());
         standardPart.setOutboundDetailId(warehouseDTO.getOutboundDetailId());
         Long businessId = this.businessStandardPartService
            .addBusiness(com.hzchum.pangu.common.util.BeanUtil.copy(standardPart, StandardPartAddDtoParam.class));
         standardPart.setBusinessId(businessId);
         this.standardPartService.save(standardPart);
         WarehouseSaveDTOParam build = WarehouseSaveDTOParam.builder()
            .projectId(standardPart.getProjectId())
            .monomerId(0L)
            .areaId(0L)
            .planId(0L)
            .factoryId(0L)
            .workshopId(0L)
            .productId(standardPart.getId())
            .productType(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
            .type(WarehouseTypeEnum.INTO.getType())
            .quantity(warehouseDTO.getQuantity())
            .completeId(0L)
            .warehouseType(WarehouseTypeProductReturnEnum.SUBSCRIBE.getType())
            .productionLineId(0L)
            .materialInventoryId(warehouseDTO.getMaterialInventoryId())
            .outboundDetailId(warehouseDTO.getOutboundDetailId())
            .build();
         saveDTOParamList.add(build);
      }

      List<MesBuildingWarehouseRecord> saveRecords = new ArrayList<>();

      for (WarehouseSaveDTOParam saveDTOParam : saveDTOParamList) {
         MesBuildingWarehouseSummary summary = com.hzchum.pangu.common.util.BeanUtil.copy(saveDTOParam, MesBuildingWarehouseSummary.class);
         summary.setMaterialInventoryId(saveDTOParam.getMaterialInventoryId());
         summary.setOutboundDetailId(saveDTOParam.getOutboundDetailId());
         summary.setUserName(UserUtil.getCurrentName());
         this.warehouseSummaryService.save(summary);
         MesBuildingWarehouseRecord record = com.hzchum.pangu.common.util.BeanUtil.copy(summary, MesBuildingWarehouseRecord.class);
         record.setQuantity(saveDTOParam.getQuantity());
         record.setUserId(UserUtil.getCurrentUserId());
         record.setUserName(UserUtil.getCurrentName());
         record.setNumber(saveDTOParam.getNumber());
         record.setStatus(
            record.getType().equals(WarehouseTypeEnum.INTO.getType())
               ? WarehouseRecordStatusTypeEnum.INTO.getType()
               : WarehouseRecordStatusTypeEnum.OUT.getType()
         );
         saveRecords.add(record);
      }

      this.warehouseRecordService.saveBatch(saveRecords);
   }

   private void buildArtifactWarehouseRecordInfo(List<SubscribeProductWarehouseDTO> productWarehouseDTOS) {
      List<Long> artifactIds = productWarehouseDTOS.stream().map(SubscribeProductWarehouseDTO::getId).distinct().collect(Collectors.toList());
      Map<Long, TechArtifact> artifactMap = this.artifactService
         .listByIds(artifactIds)
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactMap) && artifactMap.size() == artifactIds.size(), "操作失败,构件清单不存在!");
      List<TechArtifactExt> artifactExtList = this.artifactExtService
         .list(
            (Wrapper<TechArtifactExt>)((new LambdaQueryWrapper<TechArtifactExt>().in(TechArtifactExt::getArtifactId, artifactIds))
                  .eq(TechArtifactExt::getBoolSubscription, Boolean.TRUE))
               .eq(TechArtifactExt::getBoolStoreSubscription, Boolean.FALSE)
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExtList), "操作失败,可入库的申购清单数量不足!");
      Map<Long, List<TechArtifactExt>> artifactExtMap = artifactExtList.stream().collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      Preconditions.checkArgument(
         productWarehouseDTOS.stream().allMatch(artifactWarehouseDTO -> artifactExtMap.get(artifactWarehouseDTO.getId()) != null), "操作失败,可入库的申购清单数量不足!"
      );
      List<WarehouseSaveDTOParam> saveDTOParamList = new ArrayList<>();
      productWarehouseDTOS.forEach(
         artifactWarehouseDTO -> {
            TechArtifact artifact = artifactMap.get(artifactWarehouseDTO.getId());
            List<TechArtifactExt> artifactExts = artifactExtMap.get(artifactWarehouseDTO.getId());
            artifactExts = artifactExts.stream().filter(artifactExt -> !artifactExt.getBoolStoreSubscription()).collect(Collectors.toList());
            Preconditions.checkArgument(artifactExts.size() >= artifactWarehouseDTO.getQuantity(), "操作失败构件" + artifact.getSerialNumber() + "可入库的申购清单数量不足!");

            for (TechArtifactExt ext : artifactExts.stream().limit(artifactWarehouseDTO.getQuantity().intValue()).collect(Collectors.toList())) {
               WarehouseSaveDTOParam saveDTOParam = WarehouseSaveDTOParam.builder()
                  .projectId(ext.getProjectId())
                  .productId(artifact.getId())
                  .productType(ProductTypeEnum.ARTIFACT.getType())
                  .number(ext.getSortNumber())
                  .areaId(artifact.getAreaId())
                  .factoryId(0L)
                  .workshopId(0L)
                  .type(1)
                  .monomerId(artifact.getMonomerId())
                  .quantity(BigDecimal.ONE)
                  .completeId(0L)
                  .warehouseType(WarehouseTypeProductReturnEnum.SUBSCRIBE.getType())
                  .productionLineId(0L)
                  .workshopId(0L)
                  .materialInventoryId(artifactWarehouseDTO.getMaterialInventoryId())
                  .build();
               ext.setBoolStoreSubscription(Boolean.TRUE);
               this.artifactExtService.updateById(ext);
               saveDTOParamList.add(saveDTOParam);
            }
         }
      );
      List<MesBuildingWarehouseRecord> saveRecords = new ArrayList<>();
      Map<String, MesBuildingWarehouseSummary> warehouseSummaryMap = this.warehouseSummaryService
         .list(
            (Wrapper<MesBuildingWarehouseSummary>)((((new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                           .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                        .eq(MesBuildingWarehouseSummary::getWarehouseType, WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()))
                     .in(MesBuildingWarehouseSummary::getProductId, artifactIds))
                  .in(
                     MesBuildingWarehouseSummary::getMaterialInventoryId,
                     saveDTOParamList.stream().map(WarehouseSaveDTOParam::getMaterialInventoryId).distinct().collect(Collectors.toList())
                  ))
               .eq(MesBuildingWarehouseSummary::getType, 1)
         )
         .stream()
         .collect(Collectors.toMap(e -> e.getProductId() + "-" + e.getMaterialInventoryId(), Function.identity()));

      for (WarehouseSaveDTOParam saveDTOParam : saveDTOParamList) {
         MesBuildingWarehouseSummary summary = warehouseSummaryMap.get(saveDTOParam.getProductId() + "-" + saveDTOParam.getMaterialInventoryId());
         if (summary != null) {
            summary.setQuantity(summary.getQuantity().add(saveDTOParam.getQuantity()));
         } else {
            summary = com.hzchum.pangu.common.util.BeanUtil.copy(saveDTOParam, MesBuildingWarehouseSummary.class);
            summary.setId(null);
            warehouseSummaryMap.put(saveDTOParam.getProductId() + "-" + saveDTOParam.getMaterialInventoryId(), summary);
         }

         MesBuildingWarehouseRecord record = com.hzchum.pangu.common.util.BeanUtil.copy(summary, MesBuildingWarehouseRecord.class);
         record.setQuantity(saveDTOParam.getQuantity());
         record.setUserId(UserUtil.getCurrentUserId());
         record.setUserName(UserUtil.getCurrentName());
         record.setNumber(saveDTOParam.getNumber());
         record.setStatus(
            record.getType().equals(WarehouseTypeEnum.INTO.getType())
               ? WarehouseRecordStatusTypeEnum.INTO.getType()
               : WarehouseRecordStatusTypeEnum.OUT.getType()
         );
         saveRecords.add(record);
      }

      this.warehouseRecordService.saveBatch(saveRecords);
      List<MesBuildingWarehouseSummary> saveSarehouseSummaryList = warehouseSummaryMap.values()
         .stream()
         .filter(e -> e.getId() == null)
         .collect(Collectors.toList());
      List<MesBuildingWarehouseSummary> updateWarehouseSummaryList = warehouseSummaryMap.values()
         .stream()
         .filter(e -> e.getId() != null)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(saveSarehouseSummaryList)) {
         this.warehouseSummaryService.saveBatch(saveSarehouseSummaryList);
      }

      if (CollectionUtils.isNotEmpty(updateWarehouseSummaryList)) {
         this.warehouseSummaryService.updateBatchById(updateWarehouseSummaryList);
      }
   }

   private void buildEnclosureWarehouseRecordInfo(List<SubscribeProductWarehouseDTO> productWarehouseDTOS) {
      List<Long> enclosureIds = productWarehouseDTOS.stream().map(SubscribeProductWarehouseDTO::getId).distinct().collect(Collectors.toList());
      Map<Long, TechEnclosure> enclosureMap = this.enclosureService
         .listByIds(enclosureIds)
         .stream()
         .collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(enclosureMap) && enclosureMap.size() == enclosureIds.size(), "操作失败,围护清单不存在!");
      List<WarehouseSaveDTOParam> saveDTOParamList = new ArrayList<>();
      productWarehouseDTOS.forEach(
         enclosureWarehouseDTO -> {
            TechEnclosure enclosure = enclosureMap.get(enclosureWarehouseDTO.getId());
            Preconditions.checkArgument(
               enclosure.getSubscribeQuantity() >= enclosureWarehouseDTO.getQuantity(), "操作失败,围护" + enclosure.getSerialNumber() + "的可申购入库数不足!"
            );
            Preconditions.checkArgument(
               enclosure.getSubscribeQuantity() - enclosure.getStoreSubscriptionQuantity() >= enclosureWarehouseDTO.getQuantity(),
               "操作失败,围护" + enclosure.getSerialNumber() + "的可申购入库数不足!"
            );
            enclosure.setStoreSubscriptionQuantity(enclosure.getStoreSubscriptionQuantity() + enclosureWarehouseDTO.getQuantity());
            Preconditions.checkArgument(
               enclosure.getSubscribeQuantity() >= enclosure.getStoreSubscriptionQuantity(), "操作失败,围护" + enclosure.getSerialNumber() + "的申购入库数不可超出已申购数!"
            );
            WarehouseSaveDTOParam saveDTOParam = WarehouseSaveDTOParam.builder()
               .projectId(enclosure.getProjectId())
               .productId(enclosure.getId())
               .productType(ProductTypeEnum.ENCLOSURE.getType())
               .planId(enclosure.getEnclosurePlanId())
               .areaId(enclosure.getAreaId())
               .factoryId(0L)
               .workshopId(0L)
               .type(1)
               .quantity(BigDecimal.valueOf(enclosureWarehouseDTO.getQuantity().intValue()))
               .completeId(0L)
               .warehouseType(WarehouseTypeProductReturnEnum.SUBSCRIBE.getType())
               .productionLineId(0L)
               .workshopId(0L)
               .materialInventoryId(enclosureWarehouseDTO.getMaterialInventoryId())
               .category(enclosure.getCategory())
               .build();
            saveDTOParamList.add(saveDTOParam);
         }
      );
      List<MesBuildingWarehouseRecord> saveRecords = new ArrayList<>();
      Map<String, MesBuildingWarehouseSummary> warehouseSummaryMap = this.warehouseSummaryService
         .list(
            (Wrapper<MesBuildingWarehouseSummary>)((((new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                           .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ENCLOSURE.getType()))
                        .eq(MesBuildingWarehouseSummary::getWarehouseType, WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()))
                     .in(MesBuildingWarehouseSummary::getProductId, enclosureIds))
                  .in(
                     MesBuildingWarehouseSummary::getMaterialInventoryId,
                     saveDTOParamList.stream().map(WarehouseSaveDTOParam::getMaterialInventoryId).distinct().collect(Collectors.toList())
                  ))
               .eq(MesBuildingWarehouseSummary::getType, 1)
         )
         .stream()
         .collect(Collectors.toMap(e -> e.getProductId() + "-" + e.getMaterialInventoryId(), Function.identity()));

      for (WarehouseSaveDTOParam saveDTOParam : saveDTOParamList) {
         MesBuildingWarehouseSummary summary = warehouseSummaryMap.get(saveDTOParam.getProductId() + "-" + saveDTOParam.getMaterialInventoryId());
         if (summary != null) {
            summary.setQuantity(summary.getQuantity().add(saveDTOParam.getQuantity()));
         } else {
            summary = com.hzchum.pangu.common.util.BeanUtil.copy(saveDTOParam, MesBuildingWarehouseSummary.class);
            summary.setId(null);
            warehouseSummaryMap.put(saveDTOParam.getProductId() + "-" + saveDTOParam.getMaterialInventoryId(), summary);
         }

         MesBuildingWarehouseRecord record = com.hzchum.pangu.common.util.BeanUtil.copy(summary, MesBuildingWarehouseRecord.class);
         record.setQuantity(saveDTOParam.getQuantity());
         record.setUserId(UserUtil.getCurrentUserId());
         record.setUserName(UserUtil.getCurrentName());
         record.setNumber(saveDTOParam.getNumber());
         record.setStatus(
            record.getType().equals(WarehouseTypeEnum.INTO.getType())
               ? WarehouseRecordStatusTypeEnum.INTO.getType()
               : WarehouseRecordStatusTypeEnum.OUT.getType()
         );
         saveRecords.add(record);
      }

      this.warehouseRecordService.saveBatch(saveRecords);
      List<MesBuildingWarehouseSummary> saveSarehouseSummaryList = warehouseSummaryMap.values()
         .stream()
         .filter(e -> e.getId() == null)
         .collect(Collectors.toList());
      List<MesBuildingWarehouseSummary> updateWarehouseSummaryList = warehouseSummaryMap.values()
         .stream()
         .filter(e -> e.getId() != null)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(saveSarehouseSummaryList)) {
         this.warehouseSummaryService.saveBatch(saveSarehouseSummaryList);
      }

      if (CollectionUtils.isNotEmpty(updateWarehouseSummaryList)) {
         this.warehouseSummaryService.updateBatchById(updateWarehouseSummaryList);
      }

      this.enclosureService.updateBatchById(enclosureMap.values());
   }

   public TechMesWmsManagerImpl(
      final TechArtifactService artifactService,
      final TechEnclosureService enclosureService,
      final MesBuildingArtifactSchedulingService artifactSchedulingService,
      final TechDrawingService drawingService,
      final TechArtifactExtService artifactExtService,
      final MesBuildingWarehouseSummaryService warehouseSummaryService,
      final MesBuildingWarehouseRecordService warehouseRecordService,
      final TechStandardPartService standardPartService,
      final BusinessStandardPartService businessStandardPartService
   ) {
      this.artifactService = artifactService;
      this.enclosureService = enclosureService;
      this.artifactSchedulingService = artifactSchedulingService;
      this.drawingService = drawingService;
      this.artifactExtService = artifactExtService;
      this.warehouseSummaryService = warehouseSummaryService;
      this.warehouseRecordService = warehouseRecordService;
      this.standardPartService = standardPartService;
      this.businessStandardPartService = businessStandardPartService;
   }
}
