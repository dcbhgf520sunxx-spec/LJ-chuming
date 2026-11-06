package com.hzchum.scim.bid.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.bid.core.api.pojo._do.TenderNotice;
import com.hzchum.scim.bid.core.api.pojo.dto.TenderNoticeDTO;
import com.hzchum.scim.bid.core.api.pojo.vo.TenderNoticeVO;
import com.hzchum.scim.bid.core.api.service.TenderNoticeService;
import com.hzchum.scim.bid.core.mapper.TenderNoticeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@DS("master")
@Service
public class TenderNoticeImpl extends ServiceImpl<TenderNoticeMapper, TenderNotice> implements TenderNoticeService {
   @Override
   public TenderNoticeVO getMaterial(Integer type) {
      TenderNotice tenderNotices = this.baseMapper.selectOne((Wrapper<TenderNotice>)new LambdaQueryWrapper<TenderNotice>().eq(TenderNotice::getType, type));
      if (tenderNotices == null) {
         return null;
      }

      TenderNoticeVO tenderNoticeVO = null;

      try {
         tenderNoticeVO = JSON.parseObject(tenderNotices.getValue(), TenderNoticeVO.class);
         tenderNoticeVO.setType(type);
      } catch (Exception e) {
         this.log.error("获取招标公告模板失败", e);
      }

      return tenderNoticeVO;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Integer updateNotice(TenderNoticeDTO tenderNoticeDTO) {
      String value = JSON.toJSONString(tenderNoticeDTO);
      TenderNotice tenderNotice = this.baseMapper
         .selectOne((Wrapper<TenderNotice>)new LambdaQueryWrapper<TenderNotice>().eq(TenderNotice::getType, tenderNoticeDTO.getType()));
      Preconditions.checkArgument(tenderNotice != null, "更新失败，公告模板信息不存在");
      tenderNotice.setValue(value);
      int update = this.baseMapper.updateById(tenderNotice);
      Preconditions.checkArgument(update == 1, "更新失败，请刷新重试");
      return update;
   }
}
