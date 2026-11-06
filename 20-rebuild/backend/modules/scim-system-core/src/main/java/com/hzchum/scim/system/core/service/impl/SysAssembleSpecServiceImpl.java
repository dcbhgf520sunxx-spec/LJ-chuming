package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleSpec;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleSpecConfigDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleSpecDTOParam;
import com.hzchum.scim.system.core.api.service.SysAssembleSpecService;
import com.hzchum.scim.system.core.mapper.SysAssembleSpecMapper;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class SysAssembleSpecServiceImpl extends ServiceImpl<SysAssembleSpecMapper, SysAssembleSpec> implements SysAssembleSpecService {
   @Override
   public List<AssembleSpecDTOParam> listByCondition(Long assembleConfigId, String specPrefix, Integer mesProductEnum) {
      return this.baseMapper.selectByCondition(assembleConfigId, specPrefix, mesProductEnum);
   }

   @Override
   public List<AssembleSpecConfigDTOParam> getAssembleConfigToSpec(Set<Long> assembleConfigIds) {
      return this.baseMapper.getAssembleConfigToSpec(assembleConfigIds);
   }

   @Override
   public List<SysAssembleSpec> listByAssembleConfigId(Long assembleConfigId) {
      Preconditions.checkArgument(assembleConfigId != null, "组立配置id不能为空");
      List<SysAssembleSpec> list = this.list(Wrappers.lambdaQuery(SysAssembleSpec.class).eq(SysAssembleSpec::getAssembleConfigId, assembleConfigId));
      return CollUtil.isNotEmpty(list) ? list : Collections.emptyList();
   }
}
