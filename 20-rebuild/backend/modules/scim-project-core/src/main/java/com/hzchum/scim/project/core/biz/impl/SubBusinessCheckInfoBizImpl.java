package com.hzchum.scim.project.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.pojo.dto.CheckDTOParam;
import com.hzchum.scim.project.core.api.biz.SubBusinessCheckInfoBiz;
import com.hzchum.scim.project.core.api.pojo._do.SubBusiness;
import com.hzchum.scim.project.core.api.pojo._do.SubBusinessCheckDetail;
import com.hzchum.scim.project.core.api.pojo._do.SubBusinessCheckInfo;
import com.hzchum.scim.project.core.api.pojo.dtoParam.CheckInfoDTOParam;
import com.hzchum.scim.project.core.api.service.SubBusinessCheckDetailService;
import com.hzchum.scim.project.core.api.service.SubBusinessCheckInfoService;
import com.hzchum.scim.project.core.api.service.SubBusinessService;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class SubBusinessCheckInfoBizImpl implements SubBusinessCheckInfoBiz {
   @Resource
   private SubBusinessCheckInfoService subBusinessCheckInfoService;
   @Resource
   private SubBusinessCheckDetailService subBusinessCheckDetailService;
   @Resource
   private SubBusinessService subBusinessService;

   @Override
   public Boolean setUnitPrice(CheckInfoDTOParam param) {
      SubBusinessCheckInfo info = SubBusinessCheckInfo.builder()
         .projectId(1L)
         .monomerId(param.getMonomerId())
         .status(CheckStatusEnum.PENDING.getType())
         .createUserId(1L)
         .createUserName("xx")
         .remark(param.getRemark())
         .build();
      this.subBusinessCheckInfoService.save(info);
      param.getDetails()
         .forEach(
            detail -> {
               SubBusiness business = this.subBusinessService.getById(detail.getId());
               Preconditions.checkArgument(business != null, "记录不存在");
               SubBusinessCheckDetail build = SubBusinessCheckDetail.builder()
                  .checkInfoId(info.getId())
                  .businessId(business.getId())
                  .oldUnitPrice(business.getUnitPrice())
                  .newUnitPrice(detail.getUnitPrice())
                  .build();
               this.subBusinessCheckDetailService.save(build);
            }
         );
      return true;
   }

   @Override
   public Boolean check(CheckDTOParam param) {
      SubBusinessCheckInfo info = this.subBusinessCheckInfoService.getById(param.getId());
      Preconditions.checkArgument(info != null, "审核记录不存在");
      Preconditions.checkArgument(info.getStatus().equals(CheckStatusEnum.PENDING.getType()), "审核记录已审核");
      SubBusinessCheckInfo copy = BeanUtil.copy(param, SubBusinessCheckInfo.class);
      copy.setCheckUserId(1L);
      copy.setCheckUserName("xxx");
      copy.setCheckTime(LocalDateTime.now());
      this.subBusinessCheckInfoService.updateById(copy);
      if (param.getStatus().equals(CheckStatusEnum.PASS.getType())) {
         List<SubBusinessCheckDetail> details = this.subBusinessCheckDetailService
            .list((Wrapper<SubBusinessCheckDetail>)Wrappers.<SubBusinessCheckDetail>lambdaQuery().eq(SubBusinessCheckDetail::getCheckInfoId, info.getId()));
         details.forEach(detail -> {
            SubBusiness business = SubBusiness.builder().id(detail.getBusinessId()).unitPrice(detail.getNewUnitPrice()).build();
            this.subBusinessService.updateById(business);
         });
      }

      return true;
   }
}
