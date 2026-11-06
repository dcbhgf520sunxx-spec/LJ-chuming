package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.pojo.dto.StructureClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.StructureParentTypeDTO;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import com.hzchum.scim.system.core.mapper.SysStructureClassificationMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SysStructureClassificationServiceImpl
   extends ServiceImpl<SysStructureClassificationMapper, SysStructureClassification>
   implements SysStructureClassificationService {
   @Override
   public List<StructureClassificationDTO> listByCondition(List<Long> classificationIds) {
      return this.baseMapper.selectListByCondition(classificationIds);
   }

   @Override
   public List<Long> selectIdsByCondition(
      Integer productionLineTypeEnum, String classificationName, String specPrefix, Integer artifactType, Integer mesProductEnum, String sectionAndNameAndType
   ) {
      return this.baseMapper.selectIdsByCondition(productionLineTypeEnum, classificationName, specPrefix, artifactType, mesProductEnum, sectionAndNameAndType);
   }

   @Override
   public List<StructureClassificationDTO> listByCondition2(String classificationName, String specPrefix, Integer artifactType, Integer mesProductEnum) {
      return this.baseMapper.selectListByCondition2(classificationName, specPrefix, artifactType, mesProductEnum);
   }

   @Override
   public List<NameInfo> listAll(Integer mesProductEnum) {
      return this.baseMapper
         .selectList((Wrapper<SysStructureClassification>)new LambdaQueryWrapper<SysStructureClassification>().eq(SysStructureClassification::getMesProductEnum, mesProductEnum))
         .stream()
         .map(s -> NameInfo.builder().id(s.getId()).name(s.getClassificationName()).build())
         .collect(Collectors.toList());
   }

   @Override
   public List<StructureParentTypeDTO> listStructureClass(Integer productionLineTypeEnum, String classificationName) {
      return this.baseMapper.selectLisStructureClass(productionLineTypeEnum, classificationName);
   }
}
