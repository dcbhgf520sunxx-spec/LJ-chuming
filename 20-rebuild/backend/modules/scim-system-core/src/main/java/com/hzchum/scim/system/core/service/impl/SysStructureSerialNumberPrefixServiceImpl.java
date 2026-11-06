package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSerialNumberPrefix;
import com.hzchum.scim.system.core.api.service.SysStructureSerialNumberPrefixService;
import com.hzchum.scim.system.core.mapper.SysStructureSerialNumberPrefixMapper;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SysStructureSerialNumberPrefixServiceImpl
   extends ServiceImpl<SysStructureSerialNumberPrefixMapper, SysStructureSerialNumberPrefix>
   implements SysStructureSerialNumberPrefixService {
   @Override
   public List<SysStructureSerialNumberPrefix> listByStructureClassificationId(Long structureClassificationId) {
      Preconditions.checkArgument(structureClassificationId != null, "构件种类id不能为空");
      List<SysStructureSerialNumberPrefix> list = this.list(
         Wrappers.lambdaQuery(SysStructureSerialNumberPrefix.class).eq(SysStructureSerialNumberPrefix::getStructureClassificationId, structureClassificationId)
      );
      return CollUtil.isNotEmpty(list) ? list : Collections.emptyList();
   }
}
