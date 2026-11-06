package com.hzchum.scim.system.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.system.core.api.biz.SysChangeReasonBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysChangeReason;
import com.hzchum.scim.system.core.api.pojo.dto.config.SysChangeReasonDTOParam;
import com.hzchum.scim.system.core.api.service.SysChangeReasonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class SysChangeReasonBizImpl implements SysChangeReasonBiz {
   @Autowired
   private SysChangeReasonService changeReasonService;

   @Override
   public ListVO list() {
      List<SysChangeReason> list = this.changeReasonService.list();
      return new ListVO<>(list);
   }

   @Override
   public boolean add(SysChangeReasonDTOParam param) {
      SysChangeReason check = this.changeReasonService.getOne((Wrapper<SysChangeReason>)Wrappers.<SysChangeReason>lambdaQuery().eq(SysChangeReason::getName, param.getName()));
      Preconditions.checkArgument(check == null, "变更原因已存在，请勿重复添加");
      SysChangeReason reason = SysChangeReason.builder().name(param.getName()).build();
      return this.changeReasonService.save(reason);
   }

   @Override
   public boolean update(SysChangeReasonDTOParam param) {
      SysChangeReason reason = this.changeReasonService.getById(param.getId());
      Preconditions.checkArgument(reason != null, "变更原因记录不存在");
      if (!param.getName().equals(reason.getName())) {
         SysChangeReason check = this.changeReasonService
            .getOne((Wrapper<SysChangeReason>)Wrappers.<SysChangeReason>lambdaQuery().eq(SysChangeReason::getName, param.getName()));
         Preconditions.checkArgument(check == null, "变更原因已存在，请勿重复添加");
      }

      reason.setName(param.getName());
      return this.changeReasonService.updateById(reason);
   }

   @Override
   public boolean delete(List<Long> ids) {
      ids.forEach(id -> {
         SysChangeReason reason = this.changeReasonService.getById(id);
         Preconditions.checkArgument(reason != null, "变更原因记录不存在");
         this.changeReasonService.removeById(id);
      });
      return true;
   }
}
