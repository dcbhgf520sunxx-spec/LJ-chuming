package com.hzchum.scim.plan.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.plan.core.api.enums.InventoryReviewedEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactSpecAmend;
import com.hzchum.scim.plan.core.api.pojo._do.check.MesTechInventoryOperation;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechArtifactRecord;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechMachinePartRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactSpecAmendDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactSpecUncorrectedDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.TechArtifactSpecAmendUpdateVORequest;
import com.hzchum.scim.plan.core.api.service.TechArtifactSpecAmendService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.check.MesTechInventoryOperationService;
import com.hzchum.scim.plan.core.api.service.check.TechArtifactMachinePartLinkRecordService;
import com.hzchum.scim.plan.core.api.service.check.TechArtifactRecordService;
import com.hzchum.scim.plan.core.api.service.check.TechAssembleDetailRecordService;
import com.hzchum.scim.plan.core.api.service.check.TechAssembleMachinePartLinkRecordService;
import com.hzchum.scim.plan.core.api.service.check.TechAssembleRecordService;
import com.hzchum.scim.plan.core.api.service.check.TechMachinePartRecordService;
import com.hzchum.scim.plan.core.api.util.TechUtils;
import com.hzchum.scim.plan.core.mapper.TechArtifactSpecAmendMapper;
import com.hzchum.scim.system.core.api.common.enums.ArtifactTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpec;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpecNumberLink;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureSpecNumberLinkService;
import com.hzchum.scim.system.core.api.service.SysStructureSpecService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechArtifactSpecAmendServiceImpl extends ServiceImpl<TechArtifactSpecAmendMapper, TechArtifactSpecAmend> implements TechArtifactSpecAmendService {
   @Autowired
   private MesTechInventoryOperationService techInventoryOperationService;
   @Autowired
   private SysStructureClassificationService structureClassificationService;
   @Autowired
   private SysStructureSpecService structureSpecService;
   @Autowired
   private TechArtifactRecordService techArtifactRecordService;
   @Autowired
   private SysStructureSpecNumberLinkService sysStructureSpecNumberLinkService;
   @Resource
   private TechAssembleDetailRecordService techAssembleDetailRecordService;
   @Resource
   private TechAssembleMachinePartLinkRecordService techAssembleMachinePartLinkRecordService;
   @Resource
   private TechArtifactMachinePartLinkRecordService techArtifactMachinePartLinkRecordService;
   @Resource
   private TechAssembleRecordService assembleRecordService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechMachinePartRecordService techMachinePartRecordService;
   @Resource
   private SysAssembleConfigService sysAssembleConfigService;
   @Resource
   private MesBuildingProductProcessLinkService mesBuildingProductProcessLinkService;

   @Override
   public List<TechArtifactSpecAmendDTO> listByCondition(
      Long projectId,
      Long monomerId,
      Long areaId,
      String name,
      String serialNumber,
      String oldSpecification,
      String newSpecification,
      String specification,
      Boolean boolAmendStatus
   ) {
      return this.baseMapper
         .selectListByCondition(projectId, monomerId, areaId, name, serialNumber, oldSpecification, newSpecification, specification, boolAmendStatus);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveOne(TechArtifact artifact) {
      TechArtifactSpecAmend specAmend = BeanUtil.copy(artifact, TechArtifactSpecAmend.class);
      specAmend.setArtifactId(artifact.getId());
      specAmend.setOldSpecification(artifact.getSpecification());
      specAmend.setOldSpecPrefix(artifact.getSpecPrefix());
      specAmend.setBoolAmendStatus(false);
      specAmend.setId(null);
      specAmend.setUserId(null);
      this.baseMapper.insert(specAmend);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delByArtifactIds(List<Long> artifactIds) {
      if (CollectionUtils.isNotEmpty(artifactIds)) {
         List<TechArtifactSpecAmend> specAmendList = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(TechArtifactSpecAmend.class)
                  .in(TechArtifactSpecAmend::getArtifactId, artifactIds)
                  .eq(TechArtifactSpecAmend::getBoolAmendStatus, false)
            );
         List<Long> specAmendIds = specAmendList.stream().map(TechArtifactSpecAmend::getId).collect(Collectors.toList());
         this.baseMapper.deleteBatchIds(specAmendIds);
         List<Long> inventoryOperationIds = specAmendList.stream().map(TechArtifactSpecAmend::getInventoryOperationId).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(inventoryOperationIds)) {
            List<MesTechInventoryOperation> mesTechInventoryOperations = this.techInventoryOperationService.listByIds(inventoryOperationIds);
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesTechInventoryOperations), "操作失败,待确认的清单导入记录不存在!");
            Map<Long, List<TechArtifactSpecAmend>> artifactSpecAmendMap = this.baseMapper
               .selectList((Wrapper<TechArtifactSpecAmend>)new LambdaQueryWrapper<TechArtifactSpecAmend>().in(TechArtifactSpecAmend::getInventoryOperationId, inventoryOperationIds))
               .stream()
               .collect(Collectors.groupingBy(TechArtifactSpecAmend::getInventoryOperationId));

            for (MesTechInventoryOperation inventoryOperation : mesTechInventoryOperations) {
               if ((CollectionUtils.isEmpty(artifactSpecAmendMap) || CollectionUtils.isEmpty(artifactSpecAmendMap.get(inventoryOperation.getId())))
                  && inventoryOperation.getInventoryReviewedEnum().equals(InventoryReviewedEnum.FIXUP_RECORD.getType())) {
                  inventoryOperation.setInventoryReviewedEnum(InventoryReviewedEnum.UNAUDITED.getType());
               }
            }

            this.techInventoryOperationService.updateBatchById(mesTechInventoryOperations);
         }
      }

      return true;
   }

   @Override
   public List<TechArtifactSpecUncorrectedDTO> uncorrectedList(
      Long inventoryOperationId, String serialNumber, String specification, String material, Long maxLength, Long minLength, Long structureClassId
   ) {
      MesTechInventoryOperation techInventoryOperation = this.techInventoryOperationService.getById(inventoryOperationId);
      Preconditions.checkArgument(techInventoryOperation != null, "操作失败,清单操作记录不存在!");
      if (!InventoryReviewedEnum.FIXUP_RECORD.getType().equals(techInventoryOperation.getInventoryReviewedEnum())) {
         return new ArrayList<>();
      }

      List<TechArtifactSpecUncorrectedDTO> dtoList = this.baseMapper
         .uncorrectedList(inventoryOperationId, serialNumber, specification, material, maxLength, minLength, structureClassId);
      if (CollUtil.isEmpty(dtoList)) {
         return new ArrayList<>();
      }

      Preconditions.checkArgument(dtoList.stream().noneMatch(TechArtifactSpecUncorrectedDTO::getBoolAmendStatus), "操作失败,待规则修正的清单状态异常!");
      return dtoList;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchUpdateSpecAmenList(List<TechArtifactSpecAmendUpdateVORequest> paramList) {
      List<TechArtifactSpecAmend> techArtifactSpecAmendList = this.baseMapper
         .selectBatchIds(paramList.stream().map(TechArtifactSpecAmendUpdateVORequest::getId).collect(Collectors.toList()));
      Preconditions.checkArgument(CollUtil.isNotEmpty(techArtifactSpecAmendList) && paramList.size() == techArtifactSpecAmendList.size(), "数据错误");
      Preconditions.checkArgument(techArtifactSpecAmendList.stream().noneMatch(TechArtifactSpecAmend::getBoolAmendStatus), "包含审核状态为已修正的数据");
      List<Long> inventoryOperationIdList = techArtifactSpecAmendList.stream()
         .map(TechArtifactSpecAmend::getInventoryOperationId)
         .distinct()
         .collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(inventoryOperationIdList) && inventoryOperationIdList.size() == 1, "操作失败,待修正的数据非同一次操作记录!");
      MesTechInventoryOperation techInventoryOperation = this.techInventoryOperationService.getById(inventoryOperationIdList.get(0));
      Preconditions.checkArgument(
         techInventoryOperation != null && InventoryReviewedEnum.FIXUP_RECORD.getType().equals(techInventoryOperation.getInventoryReviewedEnum()),
         "当前数据审核状态需为待确认"
      );
      List<TechArtifactSpecAmend> artifactSpecAmendList = this.baseMapper
         .selectList(
            (Wrapper<TechArtifactSpecAmend>)new LambdaQueryWrapper<TechArtifactSpecAmend>().eq(TechArtifactSpecAmend::getInventoryOperationId, inventoryOperationIdList.get(0))
         );
      Map<Long, TechArtifactSpecAmend> artifactSpecAmendMap = artifactSpecAmendList.stream()
         .collect(Collectors.toMap(TechArtifactSpecAmend::getId, Function.identity()));
      List<Long> newStructureClassIdList = paramList.stream().map(TechArtifactSpecAmendUpdateVORequest::getNewStructureClassId).collect(Collectors.toList());
      Map<Long, SysStructureClassification> classificationMap = this.structureClassificationService
         .listByIds(newStructureClassIdList)
         .stream()
         .collect(Collectors.toMap(SysStructureClassification::getId, Function.identity()));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(classificationMap), "操作失败,修正后的构件种类配置不存在!");
      Map<Long, List<SysStructureSpecNumberLink>> sysStructureNameLinkMap = this.sysStructureSpecNumberLinkService
         .list(
            (Wrapper<SysStructureSpecNumberLink>)new LambdaQueryWrapper<SysStructureSpecNumberLink>().in(SysStructureSpecNumberLink::getStructureClassificationId, newStructureClassIdList)
         )
         .stream()
         .collect(Collectors.groupingBy(SysStructureSpecNumberLink::getStructureClassificationId));
      Map<Long, List<SysStructureSpec>> structureSpecMap = this.structureSpecService
         .list((Wrapper<SysStructureSpec>)new LambdaQueryWrapper<SysStructureSpec>().in(SysStructureSpec::getStructureClassificationId, newStructureClassIdList))
         .stream()
         .collect(Collectors.groupingBy(SysStructureSpec::getStructureClassificationId));
      Map<Long, TechArtifactRecord> artifactRecordMap = this.techArtifactRecordService
         .listByIds(techArtifactSpecAmendList.stream().map(TechArtifactSpecAmend::getArtifactId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(TechArtifactRecord::getId, Function.identity()));
      Preconditions.checkArgument(
         CollectionUtils.isNotEmpty(artifactRecordMap) && artifactRecordMap.size() == techArtifactSpecAmendList.size(), "操作失败,构件待审核记录不存在!"
      );
      paramList.forEach(
         param -> {
            Preconditions.checkArgument(!Character.isDigit(param.getNewSpecPrefix().charAt(0)), "规格前缀不能为数字");
            Preconditions.checkArgument(TechUtils.checkSpecification(param.getNewSpecification()), "名称(" + param.getNewName() + ")的规格中两组数字之间存在非法符号!");
            TechArtifactSpecAmend techArtifactSpecAmend = artifactSpecAmendMap.get(param.getId());
            Preconditions.checkArgument(techArtifactSpecAmend != null, "操作失败,待修正的数据不存在!");
            SysStructureClassification classification = classificationMap.get(param.getNewStructureClassId());
            Preconditions.checkArgument(classification != null, "操作失败,修正后的构件种类配置不存在!");
            List<SysStructureSpec> sysStructureSpecs = structureSpecMap.get(param.getNewStructureClassId());
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(sysStructureSpecs), "操作失败,修正后的规格前缀未配置!");
            Preconditions.checkArgument(
               sysStructureSpecs.stream().anyMatch(specs -> specs.getSpecPrefix().equals(param.getNewSpecPrefix())), "操作失败,修正后的规格前缀未匹配!"
            );
            TechArtifactRecord techArtifactRecord = artifactRecordMap.get(techArtifactSpecAmend.getArtifactId());
            techArtifactRecord.setStructureClassId(param.getNewStructureClassId());
            techArtifactRecord.setSpecPrefix(param.getNewSpecPrefix());
            if (param.getNewSpecification().startsWith("PL")) {
               param.setNewSpecification(param.getNewSpecification().split("PL")[1]);
            }

            if (param.getNewSpecification().startsWith(param.getNewSpecPrefix())) {
               techArtifactRecord.setSpecification(param.getNewSpecification());
            } else {
               techArtifactRecord.setSpecification(param.getNewSpecPrefix() + param.getNewSpecification());
            }

            techArtifactRecord.setName(param.getNewName());
            techArtifactRecord.setArtifactType(classification.getArtifactType());
            techArtifactRecord.setSerialNumberPrefix(techArtifactRecord.getName());
            SysStructureClassification newClassification = classificationMap.get(param.getNewStructureClassId());
            if (newClassification.getArtifactType().equals(ArtifactTypeEnum.SMALL.getType())) {
               techArtifactRecord.setCodingType(newClassification.getCodingType());
            } else {
               techArtifactRecord.setCodingType(CodingTypeEnum.SINGLE.getType());
            }

            techArtifactSpecAmend.setNewSpecification(param.getNewSpecification());
            techArtifactSpecAmend.setNewStructureClassId(param.getNewStructureClassId());
            techArtifactSpecAmend.setNewName(param.getNewName());
            techArtifactSpecAmend.setNewSpecPrefix(param.getNewSpecPrefix());
            techArtifactSpecAmend.setUserId(UserUtil.getCurrentUserId());
            techArtifactSpecAmend.setBoolAmendStatus(Boolean.TRUE);
            Long projectId = techArtifactSpecAmend.getProjectId();
            Long monomerId = techArtifactSpecAmend.getMonomerId();
            Long areaId = techArtifactSpecAmend.getAreaId();
            List<TechMachinePartRecord> techMachinePartRecordList = this.techMachinePartRecordService
               .list(
                  (Wrapper<TechMachinePartRecord>)(((new LambdaQueryWrapper<TechMachinePartRecord>()
                              .eq(TechMachinePartRecord::getProjectId, projectId))
                           .eq(TechMachinePartRecord::getMonomerId, monomerId))
                        .eq(TechMachinePartRecord::getAreaId, areaId))
                     .eq(TechMachinePartRecord::getQuantity, 0)
               );
            techMachinePartRecordList.forEach(techMachinePartRecord -> this.techMachinePartRecordService.removeById(techMachinePartRecord.getId()));
         }
      );
      this.techArtifactRecordService.updateBatchById(artifactRecordMap.values());
      this.updateBatchById(artifactSpecAmendMap.values());
      return Boolean.TRUE;
   }
}
