package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSerialNumberPrefixChange;
import com.hzchum.scim.system.core.api.service.SysStructureSerialNumberPrefixChangeService;
import com.hzchum.scim.system.core.mapper.SysStructureSerialNumberPrefixChangeMapper;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SysStructureSerialNumberPrefixChangeServiceImpl
   extends ServiceImpl<SysStructureSerialNumberPrefixChangeMapper, SysStructureSerialNumberPrefixChange>
   implements SysStructureSerialNumberPrefixChangeService {
   @Override
   public List<SysStructureSerialNumberPrefixChange> listByStructureClassificationChangeId(Long structureClassificationChangeId) {
      Preconditions.checkArgument(structureClassificationChangeId != null, "构件种类变更id不能为空");
      List<SysStructureSerialNumberPrefixChange> list = this.list(
         Wrappers.lambdaQuery(SysStructureSerialNumberPrefixChange.class)
            .eq(SysStructureSerialNumberPrefixChange::getStructureClassificationChangeId, structureClassificationChangeId)
      );
      return CollUtil.isNotEmpty(list) ? list : Collections.emptyList();
   }
}
