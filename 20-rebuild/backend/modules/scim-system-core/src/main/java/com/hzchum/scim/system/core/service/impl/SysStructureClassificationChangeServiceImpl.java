package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassificationChange;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationChangeService;
import com.hzchum.scim.system.core.mapper.SysStructureClassificationChangeMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SysStructureClassificationChangeServiceImpl
   extends ServiceImpl<SysStructureClassificationChangeMapper, SysStructureClassificationChange>
   implements SysStructureClassificationChangeService {
   @Override
   public SysStructureClassificationChange getLatest(Long structureClassificationId) {
      Preconditions.checkArgument(structureClassificationId != null, "构件种类id不能为空");
      List<SysStructureClassificationChange> list = this.list(
         Wrappers.lambdaQuery(SysStructureClassificationChange.class)
            .eq(SysStructureClassificationChange::getStructureClassificationId, structureClassificationId)
            .orderByDesc(SysStructureClassificationChange::getId)
      );
      return CollUtil.isNotEmpty(list) ? list.get(0) : null;
   }
}
