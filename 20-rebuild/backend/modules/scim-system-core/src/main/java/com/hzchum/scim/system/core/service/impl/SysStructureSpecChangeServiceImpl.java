package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpecChange;
import com.hzchum.scim.system.core.api.service.SysStructureSpecChangeService;
import com.hzchum.scim.system.core.mapper.SysStructureSpecChangeMapper;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SysStructureSpecChangeServiceImpl
   extends ServiceImpl<SysStructureSpecChangeMapper, SysStructureSpecChange>
   implements SysStructureSpecChangeService {
   @Override
   public List<SysStructureSpecChange> listByStructureClassificationChangeId(Long structureClassificationChangeId) {
      Preconditions.checkArgument(structureClassificationChangeId != null, "构件种类变更id不能为空");
      List<SysStructureSpecChange> list = this.list(
         Wrappers.lambdaQuery(SysStructureSpecChange.class).eq(SysStructureSpecChange::getStructureClassificationChangeId, structureClassificationChangeId)
      );
      return CollUtil.isNotEmpty(list) ? list : Collections.emptyList();
   }
}
