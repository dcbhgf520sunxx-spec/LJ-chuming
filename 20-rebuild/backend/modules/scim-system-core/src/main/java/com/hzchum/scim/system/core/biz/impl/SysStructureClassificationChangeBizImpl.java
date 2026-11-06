package com.hzchum.scim.system.core.biz.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.ChangeTypeEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.pojo.common.ChangeInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.system.core.api.biz.SysStructureClassificationBiz;
import com.hzchum.scim.system.core.api.biz.SysStructureClassificationChangeBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassificationChange;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSerialNumberPrefix;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSerialNumberPrefixChange;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpec;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpecChange;
import com.hzchum.scim.system.core.api.pojo.request.StructureClassificationChangeAuditDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.StructureClassificationUpdateTOParam;
import com.hzchum.scim.system.core.api.pojo.request.StructureSerialNumberPrefixDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.StructureSpecUpdateDTOParam;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationChangeService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureSerialNumberPrefixChangeService;
import com.hzchum.scim.system.core.api.service.SysStructureSerialNumberPrefixService;
import com.hzchum.scim.system.core.api.service.SysStructureSpecChangeService;
import com.hzchum.scim.system.core.api.service.SysStructureSpecService;
import com.hzchum.scim.system.core.mapper.SysStructureClassificationChangeMapper;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysStructureClassificationChangeBizImpl
   extends IBizImpl<SysStructureClassificationChangeService, SysStructureClassificationChangeMapper, SysStructureClassificationChange>
   implements SysStructureClassificationChangeBiz {
   private final SysStructureClassificationBiz classificationBiz;
   private final SysStructureClassificationService classificationService;
   private final SysStructureSerialNumberPrefixService serialNumberPrefixService;
   private final SysStructureSpecService specService;
   private final SysStructureClassificationChangeService classificationChangeService;
   private final SysStructureSerialNumberPrefixChangeService serialNumberPrefixChangeService;
   private final SysStructureSpecChangeService specChangeService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean change(StructureClassificationUpdateTOParam dtoParam) {
      SysStructureClassification classification = this.classificationService.getById(dtoParam.getId());
      Preconditions.checkArgument(classification != null, "修改失败，构件种类信息不存在");
      Preconditions.checkArgument(dtoParam.getMesProductEnum().equals(classification.getMesProductEnum()), "操作失败,MES产品分类不可修改!");
      List<SysStructureSpec> spOldList = this.specService.listByStructureClassificationId(classification.getId());
      Set<StructureSpecUpdateDTOParam> spNewList = dtoParam.getSpecPrefixList();
      ChangeInfo<IdAndNameDO> spChangeInfo = new ChangeInfo<>();
      this.compareSpec(spOldList, spNewList, spChangeInfo);
      List<SysStructureSerialNumberPrefix> snOldList = this.serialNumberPrefixService.listByStructureClassificationId(classification.getId());
      Set<StructureSerialNumberPrefixDTOParam> snNewList = dtoParam.getSerialNumberPrefixList();
      ChangeInfo<IdAndNameDO> snChangeInfo = new ChangeInfo<>();
      this.compareSerialNumberPrefix(snOldList, snNewList, snChangeInfo);
      if (CollUtil.isEmpty(spChangeInfo.getCreateList())
         && CollUtil.isEmpty(spChangeInfo.getUpdateList())
         && CollUtil.isEmpty(spChangeInfo.getDeleteList())
         && CollUtil.isEmpty(snChangeInfo.getCreateList())
         && CollUtil.isEmpty(snChangeInfo.getUpdateList())
         && CollUtil.isEmpty(snChangeInfo.getDeleteList())) {
         this.classificationBiz.updateStructureClassification(dtoParam);
         return Boolean.TRUE;
      }

      SysStructureClassificationChange lastScChange = this.classificationChangeService.getById(classification.getLastChangeId());
      if (lastScChange != null) {
         Preconditions.checkArgument(
            CheckStatusEnum.PASS.getType().equals(lastScChange.getAuditStatus()) || CheckStatusEnum.FAIL.getType().equals(lastScChange.getAuditStatus()),
            "该构件种类存在审核中的修改记录"
         );
      }

      this.classificationBiz.checkUpdateStructureClass(classification, dtoParam);
      SysStructureClassificationChange scChange = BeanUtil.copyProperties(dtoParam, SysStructureClassificationChange.class)
         .setId(null)
         .setStructureClassificationId(classification.getId())
         .setChangeUserId(UserUtil.getCurrentUserId())
         .setAuditStatus(CheckStatusEnum.PENDING.getType());
      this.classificationChangeService.save(scChange);
      List<SysStructureSpecChange> spChangeList = CollUtil.newArrayList();
      this.builderSpecChangeList(spChangeList, spChangeInfo.getCreateList(), ChangeTypeEnum.CREATE, classification, scChange);
      this.builderSpecChangeList(spChangeList, spChangeInfo.getUpdateList(), ChangeTypeEnum.UPDATE, classification, scChange);
      this.builderSpecChangeList(spChangeList, spChangeInfo.getDeleteList(), ChangeTypeEnum.DELETE, classification, scChange);
      this.builderSpecChangeList(spChangeList, spChangeInfo.getUnchangeList(), ChangeTypeEnum.UN_CHANGE, classification, scChange);
      this.specChangeService.saveBatch(spChangeList);
      List<SysStructureSerialNumberPrefixChange> snChangeList = CollUtil.newArrayList();
      this.builderSerialNumberPrefixChangeList(snChangeList, snChangeInfo.getCreateList(), ChangeTypeEnum.CREATE, classification, scChange);
      this.builderSerialNumberPrefixChangeList(snChangeList, snChangeInfo.getUpdateList(), ChangeTypeEnum.UPDATE, classification, scChange);
      this.builderSerialNumberPrefixChangeList(snChangeList, snChangeInfo.getDeleteList(), ChangeTypeEnum.DELETE, classification, scChange);
      this.builderSerialNumberPrefixChangeList(snChangeList, snChangeInfo.getUnchangeList(), ChangeTypeEnum.UN_CHANGE, classification, scChange);
      this.serialNumberPrefixChangeService.saveBatch(snChangeList);
      this.classificationService
         .update(
            Wrappers.lambdaUpdate(SysStructureClassification.class)
               .set(SysStructureClassification::getLastChangeId, scChange.getId())
               .eq(SysStructureClassification::getId, classification.getId())
         );
      return Boolean.TRUE;
   }

   private void compareSerialNumberPrefix(
      List<SysStructureSerialNumberPrefix> snOldList, Set<StructureSerialNumberPrefixDTOParam> snNewList, ChangeInfo<IdAndNameDO> snChangeInfo
   ) {
      List<SysStructureSerialNumberPrefix> snOldCopyList = BeanUtil.copyToList(snOldList, SysStructureSerialNumberPrefix.class);

      for (StructureSerialNumberPrefixDTOParam snNew : snNewList) {
         IdAndNameDO idAndNameDO = IdAndNameDO.builder().id(snNew.getId()).name(snNew.getSerialNumberPrefix()).build();
         if (snNew.getId() == null) {
            snChangeInfo.getCreateList().add(idAndNameDO);
         } else {
            boolean addFlag = true;
            Iterator<SysStructureSerialNumberPrefix> snOLdIt = snOldCopyList.iterator();

            while (true) {
               if (snOLdIt.hasNext()) {
                  SysStructureSerialNumberPrefix snOLd = snOLdIt.next();
                  if (!Objects.equals(snOLd.getId(), snNew.getId())) {
                     continue;
                  }

                  addFlag = false;
                  snOLdIt.remove();
                  if (!Objects.equals(snOLd.getSerialNumberPrefix(), snNew.getSerialNumberPrefix())) {
                     snChangeInfo.getUpdateList().add(idAndNameDO);
                  } else {
                     snChangeInfo.getUnchangeList().add(idAndNameDO);
                  }
               }

               if (addFlag) {
                  snChangeInfo.getCreateList().add(idAndNameDO);
               }
               break;
            }
         }
      }

      if (CollUtil.isNotEmpty(snOldCopyList)) {
         for (SysStructureSerialNumberPrefix snOld : snOldCopyList) {
            IdAndNameDO idAndNameDO = IdAndNameDO.builder().id(snOld.getId()).name(snOld.getSerialNumberPrefix()).build();
            snChangeInfo.getDeleteList().add(idAndNameDO);
         }
      }
   }

   private void compareSpec(List<SysStructureSpec> spOldList, Set<StructureSpecUpdateDTOParam> spNewList, ChangeInfo<IdAndNameDO> spChangeInfo) {
      List<SysStructureSpec> spOldCopyList = BeanUtil.copyToList(spOldList, SysStructureSpec.class);

      for (StructureSpecUpdateDTOParam spNew : spNewList) {
         IdAndNameDO idAndNameDO = IdAndNameDO.builder().id(spNew.getId()).name(spNew.getSpecPrefix()).build();
         if (spNew.getId() == null) {
            spChangeInfo.getCreateList().add(idAndNameDO);
         } else {
            boolean addFlag = true;
            Iterator<SysStructureSpec> spOLdIt = spOldCopyList.iterator();

            while (true) {
               if (spOLdIt.hasNext()) {
                  SysStructureSpec spOLd = spOLdIt.next();
                  if (!Objects.equals(spOLd.getId(), spNew.getId())) {
                     continue;
                  }

                  addFlag = false;
                  spOLdIt.remove();
                  if (!Objects.equals(spOLd.getSpecPrefix(), spNew.getSpecPrefix())) {
                     spChangeInfo.getUpdateList().add(idAndNameDO);
                  } else {
                     spChangeInfo.getUnchangeList().add(idAndNameDO);
                  }
               }

               if (addFlag) {
                  spChangeInfo.getCreateList().add(idAndNameDO);
               }
               break;
            }
         }
      }

      if (CollUtil.isNotEmpty(spOldCopyList)) {
         for (SysStructureSpec spOld : spOldCopyList) {
            IdAndNameDO idAndNameDO = IdAndNameDO.builder().id(spOld.getId()).name(spOld.getSpecPrefix()).build();
            spChangeInfo.getDeleteList().add(idAndNameDO);
         }
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean audit(StructureClassificationChangeAuditDTOParam dtoParam) {
      SysStructureClassificationChange scChange = this.classificationChangeService.getById(dtoParam.getId());
      Preconditions.checkArgument(scChange != null, "审批数据不存在");
      this.checkAudit(dtoParam, scChange);
      LambdaUpdateWrapper<SysStructureClassificationChange> updateWrapper = Wrappers.lambdaUpdate(SysStructureClassificationChange.class)
         .set(SysStructureClassificationChange::getAuditUserId, UserUtil.getCurrentUserId())
         .set(SysStructureClassificationChange::getAuditTime, new Date())
         .eq(SysStructureClassificationChange::getId, scChange.getId());
      if (dtoParam.getAuditType().equals(CheckStatusEnum.PASS.getType())) {
         StructureClassificationUpdateTOParam updateDTOParam = BeanUtil.copyProperties(scChange, StructureClassificationUpdateTOParam.class);
         updateDTOParam.setId(scChange.getStructureClassificationId());
         List<SysStructureSpecChange> spChangeList = this.specChangeService.listByStructureClassificationChangeId(scChange.getId());
         if (CollUtil.isNotEmpty(spChangeList)) {
            Set<StructureSpecUpdateDTOParam> spDTOParamSet = new HashSet<>();

            for (SysStructureSpecChange spChange : spChangeList) {
               if (!ChangeTypeEnum.DELETE.getType().equals(spChange.getChangeType())) {
                  StructureSpecUpdateDTOParam spDTOParam = StructureSpecUpdateDTOParam.builder().specPrefix(spChange.getSpecPrefix()).build();
                  spDTOParamSet.add(spDTOParam);
               }
            }

            updateDTOParam.setSpecPrefixList(spDTOParamSet);
         }

         List<SysStructureSerialNumberPrefixChange> snChangeList = this.serialNumberPrefixChangeService.listByStructureClassificationChangeId(scChange.getId());
         if (CollUtil.isNotEmpty(snChangeList)) {
            Set<StructureSerialNumberPrefixDTOParam> snDTOParamSet = new HashSet<>();

            for (SysStructureSerialNumberPrefixChange snChange : snChangeList) {
               if (!ChangeTypeEnum.DELETE.getType().equals(snChange.getChangeType())) {
                  StructureSerialNumberPrefixDTOParam snDTOParam = StructureSerialNumberPrefixDTOParam.builder()
                     .serialNumberPrefix(snChange.getSerialNumberPrefix())
                     .build();
                  snDTOParamSet.add(snDTOParam);
               }
            }

            updateDTOParam.setSerialNumberPrefixList(snDTOParamSet);
         }

         this.classificationBiz.updateStructureClassification(updateDTOParam);
         updateWrapper.set(SysStructureClassificationChange::getAuditStatus, CheckStatusEnum.PASS.getType());
      } else {
         if (!dtoParam.getAuditType().equals(CheckStatusEnum.FAIL.getType())) {
            throw new BusinessException("审批类型不合法");
         }

         updateWrapper.set(SysStructureClassificationChange::getAuditStatus, CheckStatusEnum.FAIL.getType());
      }

      this.classificationChangeService.update(updateWrapper);
      return Boolean.TRUE;
   }

   private void checkAudit(StructureClassificationChangeAuditDTOParam dtoParam, SysStructureClassificationChange scChange) {
      Preconditions.checkArgument(CheckStatusEnum.PENDING.getType().equals(scChange.getAuditStatus()), "该变更已经审批");
      Preconditions.checkArgument(
         dtoParam.getAuditType().equals(CheckStatusEnum.PASS.getType()) || dtoParam.getAuditType().equals(CheckStatusEnum.FAIL.getType()), "审批类型不合法"
      );
      SysStructureClassification classification = this.classificationService.getById(scChange.getStructureClassificationId());
      Preconditions.checkArgument(classification != null, "构件种类不存在");
      SysStructureClassificationChange latestScChange = this.classificationChangeService.getById(classification.getLastChangeId());
      Preconditions.checkArgument(latestScChange != null, "最新的变更数据不存在");
      Preconditions.checkArgument(Objects.equals(scChange.getId(), latestScChange.getId()), "审批的变更数据不是最新的");
   }

   private void builderSpecChangeList(
      List<SysStructureSpecChange> spChangeList,
      List<IdAndNameDO> list,
      ChangeTypeEnum changeType,
      SysStructureClassification structureClassification,
      SysStructureClassificationChange scChange
   ) {
      if (!CollUtil.isEmpty(list)) {
         for (IdAndNameDO idAndNameDO : list) {
            SysStructureSpecChange sp = SysStructureSpecChange.builder()
               .structureClassificationId(structureClassification.getId())
               .structureClassificationChangeId(scChange.getId())
               .structureSpecId(idAndNameDO.getId())
               .specPrefix(idAndNameDO.getName())
               .changeType(changeType.getType())
               .mesProductEnum(structureClassification.getMesProductEnum())
               .build();
            spChangeList.add(sp);
         }
      }
   }

   private void builderSerialNumberPrefixChangeList(
      List<SysStructureSerialNumberPrefixChange> snChangeList,
      List<IdAndNameDO> list,
      ChangeTypeEnum changeType,
      SysStructureClassification structureClassification,
      SysStructureClassificationChange scChange
   ) {
      if (!CollUtil.isEmpty(list)) {
         for (IdAndNameDO idAndNameDO : list) {
            SysStructureSerialNumberPrefixChange sp = SysStructureSerialNumberPrefixChange.builder()
               .structureClassificationId(structureClassification.getId())
               .structureClassificationChangeId(scChange.getId())
               .structureSerialNumberPrefixId(idAndNameDO.getId())
               .serialNumberPrefix(idAndNameDO.getName())
               .changeType(changeType.getType())
               .mesProductEnum(structureClassification.getMesProductEnum())
               .build();
            snChangeList.add(sp);
         }
      }
   }

   public SysStructureClassificationChangeBizImpl(
      final SysStructureClassificationBiz classificationBiz,
      final SysStructureClassificationService classificationService,
      final SysStructureSerialNumberPrefixService serialNumberPrefixService,
      final SysStructureSpecService specService,
      final SysStructureClassificationChangeService classificationChangeService,
      final SysStructureSerialNumberPrefixChangeService serialNumberPrefixChangeService,
      final SysStructureSpecChangeService specChangeService
   ) {
      this.classificationBiz = classificationBiz;
      this.classificationService = classificationService;
      this.serialNumberPrefixService = serialNumberPrefixService;
      this.specService = specService;
      this.classificationChangeService = classificationChangeService;
      this.serialNumberPrefixChangeService = serialNumberPrefixChangeService;
      this.specChangeService = specChangeService;
   }
}
