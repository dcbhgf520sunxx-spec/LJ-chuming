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
import com.hzchum.scim.system.core.api.biz.SysAssembleConfigBiz;
import com.hzchum.scim.system.core.api.biz.SysAssembleConfigChangeBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfigChange;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleSpec;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleSpecChange;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleSpecDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.AssembleConfigChangeAuditDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.AssembleConfigUpdateDTOParam;
import com.hzchum.scim.system.core.api.service.SysAssembleClassifyLinkChangeService;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigChangeService;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import com.hzchum.scim.system.core.api.service.SysAssembleSpecChangeService;
import com.hzchum.scim.system.core.api.service.SysAssembleSpecService;
import com.hzchum.scim.system.core.mapper.SysAssembleConfigChangeMapper;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysAssembleConfigChangeBizImpl
   extends IBizImpl<SysAssembleConfigChangeService, SysAssembleConfigChangeMapper, SysAssembleConfigChange>
   implements SysAssembleConfigChangeBiz {
   private final SysAssembleConfigBiz assembleConfigBiz;
   private final SysAssembleConfigService assembleConfigService;
   private final SysAssembleSpecService assembleSpecService;
   private final SysAssembleConfigChangeService assembleConfigChangeService;
   private final SysAssembleSpecChangeService assembleSpecChangeService;
   private final SysAssembleClassifyLinkChangeService assembleClassifyLinkChangeService;
   private final ClassificationService classificationService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean change(AssembleConfigUpdateDTOParam dtoParam) {
      SysAssembleConfig assembleConfig = this.assembleConfigService.getById(dtoParam.getId());
      Preconditions.checkArgument(assembleConfig != null, "修改失败，部件数据不存在");
      Preconditions.checkArgument(dtoParam.getMesProductEnum().equals(assembleConfig.getMesProductEnum()), "操作失败,mes分类不可修改");
      List<SysAssembleSpec> spOldList = this.assembleSpecService.listByAssembleConfigId(assembleConfig.getId());
      List<AssembleSpecDTOParam> spNewList = dtoParam.getAssembleSpecList();
      ChangeInfo<AssembleSpecDTOParam> spChangeInfo = new ChangeInfo<>();
      this.compareSpec(spOldList, spNewList, spChangeInfo);
      if (CollUtil.isEmpty(spChangeInfo.getCreateList()) && CollUtil.isEmpty(spChangeInfo.getUpdateList()) && CollUtil.isEmpty(spChangeInfo.getDeleteList())) {
         this.assembleConfigBiz.updateAssembleConfig(dtoParam);
         return Boolean.TRUE;
      }

      SysAssembleConfigChange lastCcChange = this.assembleConfigChangeService.getById(assembleConfig.getLastChangeId());
      if (lastCcChange != null) {
         Preconditions.checkArgument(
            CheckStatusEnum.PASS.getType().equals(lastCcChange.getAuditStatus()) || CheckStatusEnum.FAIL.getType().equals(lastCcChange.getAuditStatus()),
            "该部件种类存在审核中的修改记录"
         );
      }

      this.assembleConfigBiz.checkUpdate(assembleConfig, dtoParam);
      SysAssembleConfigChange acChange = BeanUtil.copyProperties(dtoParam, SysAssembleConfigChange.class)
         .setId(null)
         .setAssembleConfigId(assembleConfig.getId())
         .setChangeUserId(UserUtil.getCurrentUserId())
         .setAuditStatus(CheckStatusEnum.PENDING.getType())
         .setMesProductEnum(assembleConfig.getMesProductEnum());
      this.assembleConfigChangeService.save(acChange);
      List<SysAssembleSpecChange> spChangeList = CollUtil.newArrayList();
      this.builderSpecChangeList(spChangeList, spChangeInfo.getCreateList(), ChangeTypeEnum.CREATE, assembleConfig, acChange);
      this.builderSpecChangeList(spChangeList, spChangeInfo.getUpdateList(), ChangeTypeEnum.UPDATE, assembleConfig, acChange);
      this.builderSpecChangeList(spChangeList, spChangeInfo.getDeleteList(), ChangeTypeEnum.DELETE, assembleConfig, acChange);
      this.builderSpecChangeList(spChangeList, spChangeInfo.getUnchangeList(), ChangeTypeEnum.UN_CHANGE, assembleConfig, acChange);
      this.assembleSpecChangeService.saveBatch(spChangeList);
      this.assembleConfigService
         .update(
            Wrappers.lambdaUpdate(SysAssembleConfig.class)
               .set(SysAssembleConfig::getLastChangeId, acChange.getId())
               .eq(SysAssembleConfig::getId, assembleConfig.getId())
         );
      return Boolean.TRUE;
   }

   private void compareSpec(List<SysAssembleSpec> spOldList, List<AssembleSpecDTOParam> spNewList, ChangeInfo<AssembleSpecDTOParam> spChangeInfo) {
      List<SysAssembleSpec> spOldCopyList = BeanUtil.copyToList(spOldList, SysAssembleSpec.class);

      for (AssembleSpecDTOParam spNew : spNewList) {
         AssembleSpecDTOParam spChange = AssembleSpecDTOParam.builder()
            .id(spNew.getId())
            .specPrefix(spNew.getSpecPrefix())
            .specIndex(spNew.getSpecIndex())
            .build();
         if (spNew.getId() == null) {
            spChangeInfo.getCreateList().add(spChange);
         } else {
            boolean addFlag = true;
            Iterator<SysAssembleSpec> spOldIt = spOldCopyList.iterator();

            while (true) {
               if (spOldIt.hasNext()) {
                  SysAssembleSpec spOLd = spOldIt.next();
                  if (!Objects.equals(spOLd.getId(), spNew.getId())) {
                     continue;
                  }

                  addFlag = false;
                  spOldIt.remove();
                  if (!Objects.equals(spOLd.getSpecPrefix(), spNew.getSpecPrefix())) {
                     spChangeInfo.getUpdateList().add(spChange);
                  } else {
                     spChangeInfo.getUnchangeList().add(spChange);
                  }
               }

               if (addFlag) {
                  spChangeInfo.getCreateList().add(spChange);
               }
               break;
            }
         }
      }

      if (CollUtil.isNotEmpty(spOldCopyList)) {
         for (SysAssembleSpec spOld : spOldCopyList) {
            AssembleSpecDTOParam spChange = AssembleSpecDTOParam.builder()
               .id(spOld.getId())
               .specPrefix(spOld.getSpecPrefix())
               .specIndex(spOld.getSpecIndex())
               .build();
            spChangeInfo.getDeleteList().add(spChange);
         }
      }
   }

   private void builderSpecChangeList(
      List<SysAssembleSpecChange> spChangeList,
      List<AssembleSpecDTOParam> list,
      ChangeTypeEnum changeType,
      SysAssembleConfig assembleConfig,
      SysAssembleConfigChange acChange
   ) {
      if (!CollUtil.isEmpty(list)) {
         for (AssembleSpecDTOParam dtoParam : list) {
            SysAssembleSpecChange sp = SysAssembleSpecChange.builder()
               .assembleConfigId(assembleConfig.getId())
               .assembleConfigChangeId(acChange.getId())
               .specId(dtoParam.getId())
               .specPrefix(dtoParam.getSpecPrefix())
               .specIndex(dtoParam.getSpecIndex())
               .changeType(changeType.getType())
               .mesProductEnum(assembleConfig.getMesProductEnum())
               .build();
            spChangeList.add(sp);
         }
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean audit(AssembleConfigChangeAuditDTOParam dtoParam) {
      SysAssembleConfigChange acChange = this.assembleConfigChangeService.getById(dtoParam.getId());
      Preconditions.checkArgument(acChange != null, "审批数据不存在");
      this.checkAudit(dtoParam, acChange);
      LambdaUpdateWrapper<SysAssembleConfigChange> updateWrapper = Wrappers.lambdaUpdate(SysAssembleConfigChange.class)
         .set(SysAssembleConfigChange::getAuditUserId, UserUtil.getCurrentUserId())
         .set(SysAssembleConfigChange::getAuditTime, new Date())
         .eq(SysAssembleConfigChange::getId, acChange.getId());
      if (dtoParam.getAuditType().equals(CheckStatusEnum.PASS.getType())) {
         AssembleConfigUpdateDTOParam updateDTOParam = BeanUtil.copyProperties(acChange, AssembleConfigUpdateDTOParam.class);
         updateDTOParam.setId(acChange.getAssembleConfigId());
         List<SysAssembleSpecChange> spChangeList = this.assembleSpecChangeService.listByAssembleConfigChangeId(acChange.getId());
         if (CollUtil.isNotEmpty(spChangeList)) {
            List<AssembleSpecDTOParam> spDTOParamSet = CollUtil.newArrayList();

            for (SysAssembleSpecChange spChange : spChangeList) {
               if (!ChangeTypeEnum.DELETE.getType().equals(spChange.getChangeType())) {
                  AssembleSpecDTOParam spDTOParam = AssembleSpecDTOParam.builder()
                     .specPrefix(spChange.getSpecPrefix())
                     .specIndex(spChange.getSpecIndex())
                     .build();
                  spDTOParamSet.add(spDTOParam);
               }
            }

            updateDTOParam.setAssembleSpecList(spDTOParamSet);
         }

         this.assembleConfigBiz.updateAssembleConfig(updateDTOParam);
         updateWrapper.set(SysAssembleConfigChange::getAuditStatus, CheckStatusEnum.PASS.getType());
      } else {
         if (!dtoParam.getAuditType().equals(CheckStatusEnum.FAIL.getType())) {
            throw new BusinessException("审批类型不合法");
         }

         updateWrapper.set(SysAssembleConfigChange::getAuditStatus, CheckStatusEnum.FAIL.getType());
      }

      this.assembleConfigChangeService.update(updateWrapper);
      return Boolean.TRUE;
   }

   private void checkAudit(AssembleConfigChangeAuditDTOParam dtoParam, SysAssembleConfigChange acChange) {
      Preconditions.checkArgument(CheckStatusEnum.PENDING.getType().equals(acChange.getAuditStatus()), "该变更已经审批");
      Preconditions.checkArgument(
         dtoParam.getAuditType().equals(CheckStatusEnum.PASS.getType()) || dtoParam.getAuditType().equals(CheckStatusEnum.FAIL.getType()), "审批类型不合法"
      );
      SysAssembleConfig assembleConfig = this.assembleConfigService.getById(acChange.getAssembleConfigId());
      Preconditions.checkArgument(assembleConfig != null, "部件配置不存在");
      SysAssembleConfigChange latestAcChange = this.assembleConfigChangeService.getById(assembleConfig.getLastChangeId());
      Preconditions.checkArgument(latestAcChange != null, "最新的变更数据不存在");
      Preconditions.checkArgument(Objects.equals(acChange.getId(), latestAcChange.getId()), "审批的变更数据不是最新的");
   }

   public SysAssembleConfigChangeBizImpl(
      final SysAssembleConfigBiz assembleConfigBiz,
      final SysAssembleConfigService assembleConfigService,
      final SysAssembleSpecService assembleSpecService,
      final SysAssembleConfigChangeService assembleConfigChangeService,
      final SysAssembleSpecChangeService assembleSpecChangeService,
      final SysAssembleClassifyLinkChangeService assembleClassifyLinkChangeService,
      final ClassificationService classificationService
   ) {
      this.assembleConfigBiz = assembleConfigBiz;
      this.assembleConfigService = assembleConfigService;
      this.assembleSpecService = assembleSpecService;
      this.assembleConfigChangeService = assembleConfigChangeService;
      this.assembleSpecChangeService = assembleSpecChangeService;
      this.assembleClassifyLinkChangeService = assembleClassifyLinkChangeService;
      this.classificationService = classificationService;
   }
}
