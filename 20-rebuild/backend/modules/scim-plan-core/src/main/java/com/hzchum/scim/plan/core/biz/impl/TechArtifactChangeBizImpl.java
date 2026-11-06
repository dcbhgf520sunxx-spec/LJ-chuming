package com.hzchum.scim.plan.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessArtifact;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckDetail;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceTemp;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactEditDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.MachinePartEditDtoParam;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.business.core.api.service.BusinessCheckDetailService;
import com.hzchum.scim.business.core.api.service.BusinessCheckInfoService;
import com.hzchum.scim.business.core.api.service.BusinessMachinePartService;
import com.hzchum.scim.business.core.api.service.BusinessPriceTempService;
import com.hzchum.scim.common.core.api.enums.BoolStatusEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.common.core.api.utils.ListPageUtil;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.ChangeLogTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingArtifactScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingChangeLog;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingArtifactSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingChangeLogService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.biz.TechArtifactChangeBiz;
import com.hzchum.scim.plan.core.api.enums.HandleStatusEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactChange;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ArtifactQuantityChangeDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechArtifactChangeDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactChangeQueryDtoParam;
import com.hzchum.scim.plan.core.api.service.TechArtifactChangeService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.mapper.TechArtifactChangeMapper;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysChangeReason;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.service.SysChangeReasonService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class TechArtifactChangeBizImpl
   extends IBizImpl<TechArtifactChangeService, TechArtifactChangeMapper, TechArtifactChange>
   implements TechArtifactChangeBiz {
   private final ContractProjectService projectService;
   private final TechArtifactService artifactService;
   private final TechMachinePartService machinePartService;
   private final TechAssembleService assembleService;
   private final TechAssembleDetailService assembleDetailService;
   private final TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   private final BusinessArtifactService businessArtifactService;
   private final BusinessCheckInfoService businessCheckInfoService;
   private final BusinessCheckDetailService businessCheckDetailService;
   private final BusinessPriceTempService businessPriceTempService;
   private final BusinessMachinePartService businessMachinePartService;
   private final TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   private final MesBuildingWarehouseSummaryService mesBuildingWarehouseSummaryService;
   private final MesBuildingArtifactSchedulingService artifactSchedulingService;
   private final MesBuildingTaskBiz mesBuildingTaskBiz;
   private final SysChangeReasonService changeReasonService;
   private final SysStructureClassificationService structureClassificationService;
   @Autowired
   private MesBuildingChangeLogService changeLogService;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Resource
   private TechArtifactMachinePartLinkService techArtifactMachinePartLinkService;

   @Override
   public PageVO<TechArtifactChangeDTO> pageList(TechArtifactChangeQueryDtoParam param, Integer pageNumber, Integer pageSize) {
      return null;
   }

   @Override
   public PageVO<TechArtifactChangeDTO> warehousingList(TechArtifactChangeQueryDtoParam param, Integer pageNumber, Integer pageSize) {
      List<TechArtifactChange> allChanges = this.baseService
         .listNewChanges(
            param.getProjectId(),
            param.getMonomerId(),
            param.getAreaId(),
            param.getName(),
            param.getSerialNumber(),
            param.getSpecification(),
            param.getStartDate(),
            param.getEndDate()
         );
      if (CollectionUtils.isEmpty(allChanges)) {
         return new PageVO<>();
      }

      List<Long> changeIds = allChanges.stream().map(TechArtifactChange::getId).collect(Collectors.toList());
      List<MesBuildingChangeLog> quantityChanges = this.changeLogService
         .list(
            Wrappers.lambdaQuery(MesBuildingChangeLog.class)
               .in(MesBuildingChangeLog::getChangeId, changeIds)
               .eq(MesBuildingChangeLog::getType, ChangeLogTypeEnum.WAREHOUSE_RECORD.getType())
               .eq(MesBuildingChangeLog::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
         );
      List<Long> quantityChangeIds = quantityChanges.stream().map(MesBuildingChangeLog::getChangeId).collect(Collectors.toList());
      List<TechArtifactChange> weightChanges = allChanges.stream()
         .filter(s -> s.getOldNetWeight().compareTo(s.getNewNetWeight()) != 0 || s.getOldGrossWeight().compareTo(s.getNewGrossWeight()) != 0)
         .filter(s -> !quantityChangeIds.contains(s.getId()))
         .collect(Collectors.toList());
      List<Long> weightChangeIds = weightChanges.stream().map(TechArtifactChange::getId).collect(Collectors.toList());
      List<TechArtifactChangeDTO> quantitySummarys = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(quantityChangeIds)) {
         quantitySummarys = this.warehouseRecordService.listQuantityChanges(quantityChangeIds);
      }

      List<TechArtifactChangeDTO> weightSummarys = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(weightChangeIds)) {
         weightSummarys = this.warehouseRecordService.listWeightChanges(weightChangeIds);
      }

      List<TechArtifactChangeDTO> allSummarys = new ArrayList<>();
      allSummarys.addAll(quantitySummarys);
      allSummarys.addAll(weightSummarys);
      Map<Long, List<TechArtifactChangeDTO>> recordMap = allSummarys.stream().collect(Collectors.groupingBy(TechArtifactChangeDTO::getArtifactId));
      List<Long> artIds = new ArrayList<>(recordMap.keySet());
      Collections.sort(artIds);
      List<TechArtifactChangeDTO> dtos = new ArrayList<>();

      for (Long artId : artIds) {
         List<TechArtifactChangeDTO> dto = recordMap.get(artId);
         TechArtifactChangeDTO techArtifactChangeDTO = dto.get(0);
         techArtifactChangeDTO.setOldQuantity(dto.stream().mapToInt(TechArtifactChangeDTO::getOldQuantity).sum());
         techArtifactChangeDTO.setNewQuantity(dto.stream().mapToInt(TechArtifactChangeDTO::getNewQuantity).sum());
         techArtifactChangeDTO.setTotalNewNetWeight(dto.stream().map(TechArtifactChangeDTO::getTotalNewNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
         techArtifactChangeDTO.setTotalOldNetWeight(dto.stream().map(TechArtifactChangeDTO::getTotalOldNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
         dtos.add(techArtifactChangeDTO);
      }

      return ListPageUtil.getPages(pageNumber == null ? 1 : pageNumber, pageSize == null ? dtos.size() : pageSize, dtos);
   }

   @Override
   public Boolean changeArtifactQuantity(ArtifactQuantityChangeDTOParam param) {
      Long artifactId = param.getId();
      TechArtifact artifact = this.artifactService.getById(artifactId);
      Preconditions.checkArgument(artifact != null, "构件不存在!");
      this.projectService.checkProjectStatus(artifact.getProjectId());
      Preconditions.checkArgument(artifact.getBoolStatusEnum().equals(BoolStatusEnum.NORMAL.getType()), "构件处于暂停状态!");
      boolean boolChangeWeight = artifact.getNetWeight().compareTo(param.getNetWeight()) != 0
         || artifact.getGrossWeight() == null && param.getGrossWeight() != null
         || artifact.getGrossWeight() != null && param.getGrossWeight() != null && param.getGrossWeight().compareTo(artifact.getGrossWeight()) != 0;
      Preconditions.checkArgument(boolChangeWeight || !param.getQuantity().equals(artifact.getQuantity()), "构件数据未做修改!");
      Preconditions.checkArgument(!boolChangeWeight || param.getGrossWeight().compareTo(param.getNetWeight()) >= 0, "构件毛重不能小于构件净重!");
      int count = this.baseService
         .count(Wrappers.lambdaQuery(TechArtifactChange.builder().artifactId(artifactId).handleStatusEnum(HandleStatusEnum.UN.getType()).build()));
      Preconditions.checkArgument(count == 0, "构件处于变更待审核状态!");
      SysChangeReason changeReason = this.changeReasonService.getById(param.getReasonId());
      Preconditions.checkArgument(changeReason != null, "变更原因未配置!");
      List<MesBuildingWarehouseSummary> warehouseSummaryList = this.mesBuildingWarehouseSummaryService
         .list(
            Wrappers.lambdaQuery(
               MesBuildingWarehouseSummary.builder()
                  .productId(artifactId)
                  .type(WarehouseTypeEnum.INTO.getType())
                  .productType(ProductTypeEnum.ARTIFACT.getType())
                  .build()
            )
         );
      BigDecimal sumPackageQuantity = warehouseSummaryList.stream()
         .map(MesBuildingWarehouseSummary::getPackageQuantity)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal sumCargoQuantity = warehouseSummaryList.stream().map(MesBuildingWarehouseSummary::getCargoQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
      int sumQuantity = Integer.parseInt(sumCargoQuantity.add(sumPackageQuantity).toString());
      Preconditions.checkArgument(sumQuantity < artifact.getQuantity() || param.getQuantity() > artifact.getQuantity(), "提交失败,构件已全部打包装车或发运!");
      if (param.getQuantity() > 0) {
         Preconditions.checkArgument(param.getQuantity() >= sumQuantity, "构件已打包或装车发运[" + sumQuantity + "]件,修改数量不能小于" + sumQuantity);
      } else {
         Preconditions.checkArgument(sumQuantity == 0, "构件已打包或者装车发运[" + sumQuantity + "]件,不能删除构件!");
      }

      Preconditions.checkArgument(
         sumQuantity == 0 || param.getNetWeight().compareTo(artifact.getNetWeight()) == 0 && param.getGrossWeight().compareTo(artifact.getGrossWeight()) == 0,
         "构件已打包或者装车发运,不能变更重量!"
      );
      List<MesBuildingArtifactScheduling> artifactSchedulingList = this.artifactSchedulingService
         .list(Wrappers.lambdaQuery(MesBuildingArtifactScheduling.builder().productId(artifactId).build()));
      int taskQuantity = artifactSchedulingList.stream().mapToInt(MesBuildingArtifactScheduling::getTaskQuantity).sum();
      TechArtifactChange artifactChange = TechArtifactChange.builder()
         .artifactId(artifactId)
         .projectId(artifact.getProjectId())
         .monomerId(artifact.getMonomerId())
         .areaBatchId(artifact.getAreaBatchId())
         .areaId(artifact.getAreaId())
         .name(artifact.getName())
         .serialNumber(artifact.getSerialNumber())
         .specification(artifact.getSpecification())
         .oldQuantity(artifact.getQuantity())
         .newQuantity(param.getQuantity())
         .oldNetWeight(artifact.getNetWeight())
         .newNetWeight(param.getNetWeight())
         .oldGrossWeight(artifact.getGrossWeight())
         .newGrossWeight(param.getGrossWeight())
         .userId(UserUtil.getCurrentUserId())
         .reasonId(param.getReasonId())
         .changeRemark(param.getChangeRemark())
         .attachmentIds(CollectionUtils.isNotEmpty(param.getAttachments()) ? StringUtils.join(param.getAttachments(), ",") : null)
         .build();
      if (param.getQuantity() >= artifact.getQuantity()) {
         this.baseService.save(artifactChange);
         if (boolChangeWeight) {
            artifactChange.setHandleStatusEnum(HandleStatusEnum.UN.getType());
         } else {
            this.changeArtifact(artifact, param);
            artifactChange.setHandleStatusEnum(HandleStatusEnum.PASS.getType());
            artifactChange.setHandleUserId(UserUtil.getCurrentUserId());
            artifactChange.setHandleTime(LocalDateTime.now());
         }
      } else if (param.getQuantity() >= taskQuantity) {
         this.baseService.save(artifactChange);
         if (boolChangeWeight) {
            artifactChange.setHandleStatusEnum(HandleStatusEnum.UN.getType());
         } else {
            this.mesBuildingTaskBiz.artifactChange(artifactChange.getId(), artifactId, param.getQuantity());
            this.changeArtifact(artifact, param);
            artifactChange.setHandleStatusEnum(HandleStatusEnum.PASS.getType());
            artifactChange.setHandleUserId(UserUtil.getCurrentUserId());
            artifactChange.setHandleTime(LocalDateTime.now());
         }
      } else {
         Boolean B = this.mesBuildingTaskBiz.checkBoolChangeWithIdenticalSens(param.getId(), param.getQuantity());
         this.baseService.save(artifactChange);
         Preconditions.checkArgument(artifact.getProductionLineTypeEnum().equals(ProductionLineTypeEnum.TRADITIONAL_LINE.getType()), "暂不支持智能线-构件变更!");
         SysStructureClassification classification = this.structureClassificationService.getById(artifact.getStructureClassId());
         artifact.setBoolStatusEnum(false);
         this.artifactService.updateById(artifact);
         artifactChange.setHandleStatusEnum(HandleStatusEnum.UN.getType());
      }

      this.baseService.updateById(artifactChange);
      return Boolean.TRUE;
   }

   private void changeArtifact(TechArtifact artifact, ArtifactQuantityChangeDTOParam param) {
      Preconditions.checkArgument(param.getQuantity() >= 0, "构件数量不能为负数!");
      if (artifact.getBusinessId() != null) {
         this.updateBusiness(artifact, param);
      }

      this.updateMachinePart(artifact, param);
      this.updateAssemble(artifact, param);
      if (param.getQuantity() > 0) {
         TechArtifact newArtifact = TechArtifact.builder()
            .id(artifact.getId())
            .quantity(param.getQuantity())
            .netWeight(param.getNetWeight())
            .grossWeight(param.getGrossWeight())
            .totalNetWeight(param.getNetWeight().multiply(BigDecimal.valueOf(param.getQuantity().intValue())))
            .totalGrossWeight(param.getGrossWeight() != null ? param.getGrossWeight().multiply(BigDecimal.valueOf(param.getQuantity().intValue())) : null)
            .build();
         this.artifactService.updateById(newArtifact);
      } else {
         this.artifactService.removeById(artifact.getId());
         this.artifactMachinePartLinkService.remove(Wrappers.lambdaQuery(TechArtifactMachinePartLink.builder().artifactId(artifact.getId()).build()));
         this.assembleDetailService.remove(Wrappers.lambdaQuery(TechAssembleDetail.builder().artifactId(artifact.getId()).build()));
      }
   }

   private void updateBusiness(TechArtifact artifact, ArtifactQuantityChangeDTOParam param) {
      ArtifactEditDTOParam editDtoParam = ArtifactEditDTOParam.builder()
         .businessId(artifact.getBusinessId())
         .quantity(param.getQuantity() - artifact.getQuantity())
         .totalWeight(
            param.getGrossWeight()
               .multiply(BigDecimal.valueOf(param.getQuantity().intValue()))
               .subtract(artifact.getGrossWeight().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())))
         )
         .totalLength(
            artifact.getLength()
               .multiply(BigDecimal.valueOf(param.getQuantity() - artifact.getQuantity()))
               .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
         )
         .build();
      this.businessArtifactService.editBusinessInfo(editDtoParam);
      BusinessArtifact businessArtifact = this.businessArtifactService.getById(artifact.getBusinessId());
      if (businessArtifact == null) {
         this.businessPriceTempService
            .remove(
               Wrappers.lambdaQuery(
                  BusinessPriceTemp.builder()
                     .projectType(ProjectTypeEnum.MES.getType())
                     .type(ProductTypeEnum.ARTIFACT.getType())
                     .businessId(artifact.getBusinessId())
                     .build()
               )
            );
         List<BusinessCheckDetail> checkDetailList = this.businessCheckDetailService
            .list(
               Wrappers.lambdaQuery(
                  BusinessCheckDetail.builder()
                     .projectType(ProjectTypeEnum.MES.getType())
                     .type(ProductTypeEnum.ARTIFACT.getType())
                     .businessId(artifact.getBusinessId())
                     .build()
               )
            );
         if (CollectionUtils.isNotEmpty(checkDetailList)) {
            Map<Long, List<BusinessCheckDetail>> checkInfoIdGroupMap = checkDetailList.stream()
               .collect(Collectors.groupingBy(BusinessCheckDetail::getCheckInfoId));
            List<BusinessCheckDetail> checkDetails = this.businessCheckDetailService
               .list(
                  Wrappers.lambdaQuery(BusinessCheckDetail.class)
                     .eq(BusinessCheckDetail::getProjectType, ProjectTypeEnum.MES.getType())
                     .eq(BusinessCheckDetail::getType, ProductTypeEnum.ARTIFACT.getType())
                     .in(BusinessCheckDetail::getCheckInfoId, checkInfoIdGroupMap.keySet())
               );
            Map<Long, List<BusinessCheckDetail>> checkInfoIdDetailsMap = checkDetails.stream()
               .collect(Collectors.groupingBy(BusinessCheckDetail::getCheckInfoId));
            checkInfoIdGroupMap.forEach((checkInfoId, details) -> {
               List<BusinessCheckDetail> detailList = checkInfoIdDetailsMap.get(checkInfoId);
               this.businessCheckDetailService.removeByIds(details.stream().map(BusinessCheckDetail::getId).collect(Collectors.toList()));
               if (details.size() == detailList.size()) {
                  this.businessCheckInfoService.removeById(checkInfoId);
               }
            });
         }
      }
   }

   private void updateMachinePart(TechArtifact artifact, ArtifactQuantityChangeDTOParam param) {
      List<TechArtifactMachinePartLink> artifactMachinePartLinkList = this.artifactMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.builder().artifactId(artifact.getId()).build()));
      if (CollectionUtils.isNotEmpty(artifactMachinePartLinkList)) {
         List<TechMachinePart> machinePartList = this.machinePartService
            .listByIds(artifactMachinePartLinkList.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()));
         Map<Long, TechMachinePart> machinePartMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         List<Long> removeMachinePartIds = new ArrayList<>(32);
         artifactMachinePartLinkList.forEach(
            link -> {
               TechMachinePart machinePart = machinePartMap.get(link.getMachinePartId());
               int partUpdateQuantity = (param.getQuantity() - artifact.getQuantity()) * link.getQuantity();
               machinePart.setQuantity(machinePart.getQuantity() + partUpdateQuantity);
               machinePart.setTotalNetWeight(machinePart.getNetWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
               machinePart.setTotalGrossWeight(machinePart.getGrossWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
               if (machinePart.getQuantity() == 0) {
                  removeMachinePartIds.add(machinePart.getId());
               }

               if (machinePart.getBoolAllPartSendDirectly()) {
                  BigDecimal businessWeight = machinePart.getGrossWeight().compareTo(BigDecimal.ZERO) > 0
                     ? machinePart.getGrossWeight()
                     : machinePart.getNetWeight();
                  MachinePartEditDtoParam editDtoParam = MachinePartEditDtoParam.builder()
                     .businessId(machinePart.getBusinessId())
                     .quantity(partUpdateQuantity)
                     .totalWeight(businessWeight.multiply(BigDecimal.valueOf(partUpdateQuantity)))
                     .totalLength(machinePart.getLength().multiply(BigDecimal.valueOf(partUpdateQuantity)).divide(BigDecimal.valueOf(1000L)))
                     .build();
                  this.businessMachinePartService.editBusinessInfo(editDtoParam);
               }
            }
         );
         this.machinePartService.updateBatchById(machinePartList);
         this.machinePartService.removeByIds(removeMachinePartIds);
      }
   }

   private void updateAssemble(TechArtifact artifact, ArtifactQuantityChangeDTOParam param) {
      List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
         .list(Wrappers.lambdaQuery(TechAssembleDetail.builder().artifactId(artifact.getId()).build()));
      if (CollectionUtils.isNotEmpty(assembleDetailList)) {
         List<Long> assembleIds = assembleDetailList.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList());
         List<TechAssemble> assembleList = this.assembleService.listByIds(assembleIds);
         Map<Long, TechAssemble> assembleMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         List<TechAssembleMachinePartLink> assembleMachinePartLinkList = this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getAssembleId, assembleIds));
         Map<Long, List<TechAssembleMachinePartLink>> assembleIdLinkListMap = Collections.emptyMap();
         Map<Long, TechMachinePart> assemblePartMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(assembleMachinePartLinkList)) {
            assembleIdLinkListMap = assembleMachinePartLinkList.stream().collect(Collectors.groupingBy(TechAssembleMachinePartLink::getAssembleId));
            assemblePartMap = this.machinePartService
               .listByIds(assembleMachinePartLinkList.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         }

         Map<Long, List<TechAssembleMachinePartLink>> finalAssembleIdLinkListMap = assembleIdLinkListMap;
         Map<Long, TechMachinePart> finalAssemblePartMap = assemblePartMap;
         List<Long> removeAssembleIds = new ArrayList<>(16);
         assembleDetailList.forEach(assembleDetail -> {
            TechAssemble assemble = assembleMap.get(assembleDetail.getAssembleId());
            int assembleUpdateQuantity = (param.getQuantity() - artifact.getQuantity()) * assembleDetail.getQuantity();
            assemble.setQuantity(assemble.getQuantity() + assembleUpdateQuantity);
            assemble.setTotalNetWeight(assemble.getNetWeight().multiply(BigDecimal.valueOf(assemble.getQuantity().intValue())));
            if (assemble.getQuantity() == 0) {
               removeAssembleIds.add(assemble.getId());
            }

            if (finalAssembleIdLinkListMap.containsKey(assemble.getId())) {
               List<TechAssembleMachinePartLink> assembleMachinePartLinks = finalAssembleIdLinkListMap.get(assemble.getId());
               assembleMachinePartLinks.forEach(link -> {
                  TechMachinePart assemblePart = finalAssemblePartMap.get(link.getMachinePartId());
                  assemblePart.setQuantity(assemblePart.getQuantity() + assembleUpdateQuantity * link.getQuantity());
                  assemblePart.setTotalNetWeight(assemblePart.getNetWeight().multiply(BigDecimal.valueOf(assemblePart.getQuantity().intValue())));
                  assemblePart.setTotalGrossWeight(assemblePart.getGrossWeight().multiply(BigDecimal.valueOf(assemblePart.getQuantity().intValue())));
                  this.machinePartService.updateById(assemblePart);
                  if (assemblePart.getQuantity() == 0) {
                     this.machinePartService.removeById(assemblePart.getId());
                  }
               });
            }
         });
         this.assembleService.updateBatchById(assembleList);
         if (CollectionUtils.isNotEmpty(removeAssembleIds)) {
            this.assembleService.removeByIds(removeAssembleIds);
            this.assembleMachinePartLinkService
               .remove(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getAssembleId, removeAssembleIds));
         }
      }
   }

   @Override
   public void warehousingListChangeDownload(HttpServletResponse response, TechArtifactChangeQueryDtoParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      PageVO<TechArtifactChangeDTO> pageVO = this.warehousingList(param, null, null);
      List<TechArtifactChangeDTO> artifactChangeDTOList = pageVO.getContent();

      for (TechArtifactChangeDTO d : artifactChangeDTOList) {
         if (d.getNewQuantity().equals(0)) {
            d.setNewQuantity(0);
            d.setNewGrossWeight(BigDecimal.ZERO);
            d.setNewNetWeight(BigDecimal.ZERO);
            d.setTotalNewNetWeight(BigDecimal.ZERO);
            d.setNewLength("-");
            d.setNewMaterial("-");
            d.setNewSpecification("-");
            d.setNewSerialNumber("-");
            d.setNewName("-");
         } else {
            d.setNewLength(d.getLength());
            d.setNewMaterial(d.getMaterial());
            d.setNewSpecification(d.getSpecification());
            d.setNewSerialNumber(d.getSerialNumber());
            d.setNewName(d.getName());
         }
      }

      Map<String, Object> map = new HashMap<>();
      map.put("artifactChangeDTOList", artifactChangeDTOList);
      map.put("projectName", artifactChangeDTOList.get(0).getProject().getName());
      String resourcePath = "files/WarehousingListChangeTemplate.xlsx";
      String tempFileName = "WarehousingListChangeTemplate";
      String exportFileName = "成品变更清单.xlsx";
      PoiUtils.downLoadExcel(resourcePath, tempFileName, exportFileName, map, response);
   }

   public TechArtifactChangeBizImpl(
      final ContractProjectService projectService,
      final TechArtifactService artifactService,
      final TechMachinePartService machinePartService,
      final TechAssembleService assembleService,
      final TechAssembleDetailService assembleDetailService,
      final TechArtifactMachinePartLinkService artifactMachinePartLinkService,
      final BusinessArtifactService businessArtifactService,
      final BusinessCheckInfoService businessCheckInfoService,
      final BusinessCheckDetailService businessCheckDetailService,
      final BusinessPriceTempService businessPriceTempService,
      final BusinessMachinePartService businessMachinePartService,
      final TechAssembleMachinePartLinkService assembleMachinePartLinkService,
      final MesBuildingWarehouseSummaryService mesBuildingWarehouseSummaryService,
      final MesBuildingArtifactSchedulingService artifactSchedulingService,
      final MesBuildingTaskBiz mesBuildingTaskBiz,
      final SysChangeReasonService changeReasonService,
      final SysStructureClassificationService structureClassificationService
   ) {
      this.projectService = projectService;
      this.artifactService = artifactService;
      this.machinePartService = machinePartService;
      this.assembleService = assembleService;
      this.assembleDetailService = assembleDetailService;
      this.artifactMachinePartLinkService = artifactMachinePartLinkService;
      this.businessArtifactService = businessArtifactService;
      this.businessCheckInfoService = businessCheckInfoService;
      this.businessCheckDetailService = businessCheckDetailService;
      this.businessPriceTempService = businessPriceTempService;
      this.businessMachinePartService = businessMachinePartService;
      this.assembleMachinePartLinkService = assembleMachinePartLinkService;
      this.mesBuildingWarehouseSummaryService = mesBuildingWarehouseSummaryService;
      this.artifactSchedulingService = artifactSchedulingService;
      this.mesBuildingTaskBiz = mesBuildingTaskBiz;
      this.changeReasonService = changeReasonService;
      this.structureClassificationService = structureClassificationService;
   }
}
