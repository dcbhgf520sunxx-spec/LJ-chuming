package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.common.enums.ArtifactTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpec;
import com.hzchum.scim.system.core.api.service.SysStructureSpecService;
import com.hzchum.scim.system.core.mapper.SysStructureSpecMapper;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SysStructureSpecServiceImpl extends ServiceImpl<SysStructureSpecMapper, SysStructureSpec> implements SysStructureSpecService {
   @Override
   public List<String> listSpecPrefix(Integer mesProductEnum) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SysStructureSpec.class)
               .eq(SysStructureSpec::getArtifactType, ArtifactTypeEnum.COMMON.getType())
               .eq(mesProductEnum != null, SysStructureSpec::getMesProductEnum, mesProductEnum)
         )
         .stream()
         .map(SysStructureSpec::getSpecPrefix)
         .distinct()
         .sorted()
         .collect(Collectors.toList());
   }

   @Override
   public Map<String, SysStructureSpec> getCommonArtifactMap() {
      return this.baseMapper
         .selectList(Wrappers.lambdaQuery(SysStructureSpec.builder().artifactType(ArtifactTypeEnum.COMMON.getType()).build()))
         .stream()
         .collect(Collectors.toMap(SysStructureSpec::getSpecPrefix, Function.identity()));
   }

   @Override
   public List<SysStructureSpec> listByStructureClassificationId(Long structureClassificationId) {
      Preconditions.checkArgument(structureClassificationId != null, "构件种类id不能为空");
      List<SysStructureSpec> list = this.list(
         Wrappers.lambdaQuery(SysStructureSpec.class).eq(SysStructureSpec::getStructureClassificationId, structureClassificationId)
      );
      return CollUtil.isNotEmpty(list) ? list : Collections.emptyList();
   }
}
