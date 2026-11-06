package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassLinkDTO;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import com.hzchum.scim.system.core.mapper.SysAssembleConfigMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SysAssembleConfigServiceImpl extends ServiceImpl<SysAssembleConfigMapper, SysAssembleConfig> implements SysAssembleConfigService {
   @Override
   public List<AssembleConfigDTO> listByCondition(
      Boolean boolSectionSteel, Integer productionLineTypeEnum, String name, String specPrefix, Integer mesProductEnum, String sectionAndNameAndType
   ) {
      return this.baseMapper.selectListByCondition(boolSectionSteel, name, mesProductEnum, sectionAndNameAndType);
   }

   @Override
   public List<AssembleConfigDTO> listByCondition2(String name, Integer productClassificationEnum, Integer mesProductEnum) {
      return this.baseMapper.selectListByCondition2(name, productClassificationEnum, mesProductEnum);
   }

   @Override
   public List<AssembleConfigDTO> listByConditionConfig(Integer productionLineTypeEnum, String name, String specPrefix, Integer mesProductEnum) {
      return this.baseMapper.selectListByConditionConfig(productionLineTypeEnum, name, specPrefix, mesProductEnum);
   }

   @Override
   public List<String> listAssemblePrefix() {
      return this.baseMapper.selectAllPrefix();
   }

   @Override
   public List<SteelClassLinkDTO> listConfigIdAndClassify() {
      return this.baseMapper.listConfigIdAndClassify();
   }

   @Override
   public List<SteelClassLinkDTO> listConfigIdAndClassifyV2() {
      return this.baseMapper.listConfigIdAndClassifyV2();
   }
}
