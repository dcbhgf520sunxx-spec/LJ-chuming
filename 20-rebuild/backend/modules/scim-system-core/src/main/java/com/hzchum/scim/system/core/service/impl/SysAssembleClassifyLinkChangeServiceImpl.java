package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleClassifyLinkChange;
import com.hzchum.scim.system.core.api.service.SysAssembleClassifyLinkChangeService;
import com.hzchum.scim.system.core.mapper.SysAssembleClassifyLinkChangeMapper;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SysAssembleClassifyLinkChangeServiceImpl
   extends ServiceImpl<SysAssembleClassifyLinkChangeMapper, SysAssembleClassifyLinkChange>
   implements SysAssembleClassifyLinkChangeService {
   @Override
   public List<SysAssembleClassifyLinkChange> listByAssembleConfigChangeId(Long assembleConfigChangeId) {
      Preconditions.checkArgument(assembleConfigChangeId != null, "组立配置变更id不能为空");
      List<SysAssembleClassifyLinkChange> list = this.list(
         Wrappers.lambdaQuery(SysAssembleClassifyLinkChange.class).eq(SysAssembleClassifyLinkChange::getAssembleConfigChangeId, assembleConfigChangeId)
      );
      return CollUtil.isNotEmpty(list) ? list : Collections.emptyList();
   }
}
