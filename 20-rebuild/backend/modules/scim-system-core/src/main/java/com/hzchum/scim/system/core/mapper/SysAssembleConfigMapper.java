package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAssembleConfigMapper extends BaseMapper<SysAssembleConfig> {
   List<AssembleConfigDTO> selectListByCondition(
      @Param("boolSectionSteel") Boolean boolSectionSteel,
      @Param("name") String name,
      @Param("mesProductEnum") Integer mesProductEnum,
      @Param("sectionAndNameAndType") String sectionAndNameAndType
   );

   List<AssembleConfigDTO> selectListByCondition2(
      @Param("name") String name, @Param("productClassificationEnum") Integer productClassificationEnum, @Param("mesProductEnum") Integer mesProductEnum
   );

   List<AssembleConfigDTO> selectListByConditionConfig(
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum,
      @Param("name") String name,
      @Param("specPrefix") String specPrefix,
      @Param("mesProductEnum") Integer mesProductEnum
   );

   List<String> selectAllPrefix();

   List<SteelClassLinkDTO> listConfigIdAndClassify();

   List<SteelClassLinkDTO> listConfigIdAndClassifyV2();
}
