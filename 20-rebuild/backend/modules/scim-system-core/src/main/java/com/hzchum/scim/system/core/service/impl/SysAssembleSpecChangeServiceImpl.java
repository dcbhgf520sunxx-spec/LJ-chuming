package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleSpecChange;
import com.hzchum.scim.system.core.api.service.SysAssembleSpecChangeService;
import com.hzchum.scim.system.core.mapper.SysAssembleSpecChangeMapper;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SysAssembleSpecChangeServiceImpl extends ServiceImpl<SysAssembleSpecChangeMapper, SysAssembleSpecChange> implements SysAssembleSpecChangeService {
   @Override
   public List<SysAssembleSpecChange> listByAssembleConfigChangeId(Long assembleConfigChangeId) {
      Preconditions.checkArgument(assembleConfigChangeId != null, "组立配置变更id不能为空");
      List<SysAssembleSpecChange> list = this.list(
         Wrappers.lambdaQuery(SysAssembleSpecChange.class).eq(SysAssembleSpecChange::getAssembleConfigChangeId, assembleConfigChangeId)
      );
      return CollUtil.isNotEmpty(list) ? list : Collections.emptyList();
   }
}
