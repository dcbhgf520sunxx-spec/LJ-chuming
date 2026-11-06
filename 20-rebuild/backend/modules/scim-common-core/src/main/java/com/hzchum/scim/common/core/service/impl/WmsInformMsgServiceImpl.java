package com.hzchum.scim.common.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.InformTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReadStatusEnum;
import com.hzchum.scim.common.core.api.enums.SkipPageEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.pojo._do.WmsInformMsg;
import com.hzchum.scim.common.core.api.pojo.dto.WmsInformMsgDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.service.WmsInformMsgService;
import com.hzchum.scim.common.core.mapper.WmsInformMsgMapper;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class WmsInformMsgServiceImpl extends ServiceImpl<WmsInformMsgMapper, WmsInformMsg> implements WmsInformMsgService {
   @Resource
   private WmsInformMsgMapper wmsInformMsgMapper;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private WmsApproveRecordDetailService wmsApproveRecordDetailService;

   @Override
   public List<WmsInformMsgDTO> getAll(Integer status) {
      Long currentUserId = UserUtil.getCurrentUserId();
      List<WmsInformMsg> wmsInformMsgs = this.wmsInformMsgMapper
         .selectList(
            (Wrapper<WmsInformMsg>)(new LambdaQueryWrapper<WmsInformMsg>().eq(status != null, WmsInformMsg::getStatus, status))
               .eq(WmsInformMsg::getUserId, currentUserId)
         );
      return BeanUtil.copyToList(wmsInformMsgs, WmsInformMsgDTO.class);
   }

   @Override
   public Boolean updateStatusById(Long id, Boolean status) {
      return this.wmsInformMsgMapper
            .update(
               null, (Wrapper<WmsInformMsg>)(new LambdaUpdateWrapper<WmsInformMsg>().eq(WmsInformMsg::getId, id)).set(WmsInformMsg::getStatus, status)
            )
         == 1;
   }

   @Override
   public Boolean readAll() {
      Long currentUserId = UserUtil.getCurrentUserId();
      this.wmsInformMsgMapper
         .update(
            null,
            (Wrapper<WmsInformMsg>)(new LambdaUpdateWrapper<WmsInformMsg>().eq(WmsInformMsg::getUserId, currentUserId))
               .set(WmsInformMsg::getStatus, ReadStatusEnum.READ.getType())
         );
      return true;
   }

   @Override
   public Boolean cleanReadAll() {
      Long currentUserId = UserUtil.getCurrentUserId();
      this.wmsInformMsgMapper
         .update(
            null,
            (Wrapper<WmsInformMsg>)((new LambdaUpdateWrapper<WmsInformMsg>().eq(WmsInformMsg::getUserId, currentUserId))
                  .eq(WmsInformMsg::getStatus, ReadStatusEnum.READ.getType()))
               .set(BaseEntity::getBoolDeleteEnum, Boolean.TRUE)
         );
      return true;
   }

   @Override
   public Boolean del(List<Long> ids) {
      this.wmsInformMsgMapper.deleteBatchIds(ids);
      return true;
   }

   @Override
   public Integer getSkipPage(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      WmsInformMsg wmsInformMsg = this.wmsInformMsgMapper.selectById(id);
      Preconditions.checkArgument(wmsInformMsg.getInformType().equals(InformTypeEnum.APPROVE_NOTICE.getType()), "该通知信息不为审批通知，获取失败");
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .getOne((Wrapper<WmsApproveRecord>)new LambdaQueryWrapper<WmsApproveRecord>().eq(WmsApproveRecord::getSerialNumber, wmsInformMsg.getApproveRecordSerialNumber()));
      WmsApproveRecordDetail wmsApproveRecordDetail = this.wmsApproveRecordDetailService
         .getOne(
            (Wrapper<WmsApproveRecordDetail>)((new LambdaQueryWrapper<WmsApproveRecordDetail>()
                     .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, wmsInformMsg.getApproveRecordSerialNumber()))
                  .eq(WmsApproveRecordDetail::getCheckUserId, wmsInformMsg.getUserId()))
               .eq(WmsApproveRecordDetail::getStatus, ApproveRecordStatusEnum.UNDERWAY.getType())
         );
      if (ObjectUtil.isNotEmpty(wmsApproveRecordDetail)) {
         return SkipPageEnum.CHECK.getType();
      } else {
         return wmsApproveRecord.getBoolRewrite() && wmsApproveRecord.getApplicantId().equals(currentUser.getId())
            ? SkipPageEnum.REWRITE.getType()
            : SkipPageEnum.DETAILS.getType();
      }
   }
}
