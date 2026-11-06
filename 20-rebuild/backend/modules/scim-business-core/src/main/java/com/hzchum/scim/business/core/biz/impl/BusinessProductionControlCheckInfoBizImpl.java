package com.hzchum.scim.business.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.business.core.api.biz.BusinessProductionControlCheckInfoBiz;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessProductionControl;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessProductionControlCheckDetail;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessProductionControlCheckInfo;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ProductionControlCheckInfoDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessProductionControlCheckDetailService;
import com.hzchum.scim.business.core.api.service.BusinessProductionControlCheckInfoService;
import com.hzchum.scim.business.core.api.service.BusinessProductionControlService;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.pojo.dto.CheckDTOParam;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class BusinessProductionControlCheckInfoBizImpl implements BusinessProductionControlCheckInfoBiz {
   @Resource
   private BusinessProductionControlCheckInfoService businessProductionControlCheckInfoService;
   @Resource
   private BusinessProductionControlCheckDetailService businessProductionControlCheckDetailService;
   @Resource
   private BusinessProductionControlService businessProductionControlService;

   @Override
   public Boolean setLossFactor(ProductionControlCheckInfoDTOParam param) {
      BusinessProductionControlCheckInfo info = BusinessProductionControlCheckInfo.builder()
         .projectId(param.getProjectId())
         .status(CheckStatusEnum.PENDING.getType())
         .createUserId(UserUtil.getCurrentUserId())
         .createUserName(UserUtil.getCurrentName())
         .remark(param.getRemark())
         .build();
      this.businessProductionControlCheckInfoService.save(info);
      param.getDetails()
         .forEach(
            detail -> {
               BusinessProductionControl control = this.businessProductionControlService.getById(detail.getId());
               Preconditions.checkArgument(control != null, "记录不存在");
               if (control.getLossFactor() != null) {
                  Preconditions.checkArgument(StringUtils.isNotBlank(param.getRemark()), "备注不能为空");
               }

               BusinessProductionControlCheckDetail build = BusinessProductionControlCheckDetail.builder()
                  .checkInfoId(info.getId())
                  .productionControlId(control.getId())
                  .oldBoolEnableEnum(control.getBoolEnableEnum())
                  .newBoolEnableEnum(detail.getBoolEnableEnum())
                  .oldLossFactor(control.getLossFactor())
                  .newLossFactor(detail.getLossFactor())
                  .build();
               this.businessProductionControlCheckDetailService.save(build);
            }
         );
      return true;
   }

   @Override
   public Boolean check(CheckDTOParam param) {
      BusinessProductionControlCheckInfo info = this.businessProductionControlCheckInfoService.getById(param.getId());
      Preconditions.checkArgument(info != null, "审核记录不存在");
      Preconditions.checkArgument(info.getStatus().equals(CheckStatusEnum.PENDING.getType()), "审核记录已审核");
      BusinessProductionControlCheckInfo copy = BeanUtil.copy(param, BusinessProductionControlCheckInfo.class);
      copy.setCheckUserId(UserUtil.getCurrentUserId());
      copy.setCheckUserName(UserUtil.getCurrentName());
      copy.setCheckTime(LocalDateTime.now());
      this.businessProductionControlCheckInfoService.updateById(copy);
      List<BusinessProductionControlCheckDetail> details = this.businessProductionControlCheckDetailService
         .list((Wrapper<BusinessProductionControlCheckDetail>)Wrappers.<BusinessProductionControlCheckDetail>lambdaQuery().eq(BusinessProductionControlCheckDetail::getCheckInfoId, info.getId()));
      details.forEach(
         detail -> {
            BusinessProductionControl control = BusinessProductionControl.builder()
               .id(detail.getProductionControlId())
               .boolEnableEnum(detail.getNewBoolEnableEnum())
               .lossFactor(detail.getNewLossFactor())
               .build();
            this.businessProductionControlService.updateById(control);
         }
      );
      return true;
   }

   @Override
   public Object setProjectStatus() {
      return null;
   }
}
