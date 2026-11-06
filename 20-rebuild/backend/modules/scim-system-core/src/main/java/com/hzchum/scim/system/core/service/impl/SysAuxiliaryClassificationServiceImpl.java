package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysAuxiliaryClassification;
import com.hzchum.scim.system.core.api.service.SysAuxiliaryClassificationService;
import com.hzchum.scim.system.core.mapper.SysAuxiliaryClassificationMapper;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class SysAuxiliaryClassificationServiceImpl
   extends ServiceImpl<SysAuxiliaryClassificationMapper, SysAuxiliaryClassification>
   implements SysAuxiliaryClassificationService {
   @Override
   public List<SysAuxiliaryClassification> listByCondition(String name) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SysAuxiliaryClassification.class)
               .like(StringUtils.isNotBlank(name), SysAuxiliaryClassification::getName, name)
               .orderByAsc(SysAuxiliaryClassification::getSort)
         );
   }
}
