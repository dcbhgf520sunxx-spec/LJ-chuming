package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassLinkDTO;
import java.util.List;

public interface SysAssembleConfigService extends IService<SysAssembleConfig> {
   List<AssembleConfigDTO> listByCondition(
      Boolean boolSectionSteel, Integer productionLineType, String name, String specPrefix, Integer mesProductEnum, String sectionAndNameAndType
   );

   List<AssembleConfigDTO> listByCondition2(String name, Integer productClassificationEnum, Integer mesProductEnum);

   List<AssembleConfigDTO> listByConditionConfig(Integer productionLineTypeEnum, String name, String specPrefix, Integer mesProductEnum);

   List<String> listAssemblePrefix();

   List<SteelClassLinkDTO> listConfigIdAndClassify();

   List<SteelClassLinkDTO> listConfigIdAndClassifyV2();
}
