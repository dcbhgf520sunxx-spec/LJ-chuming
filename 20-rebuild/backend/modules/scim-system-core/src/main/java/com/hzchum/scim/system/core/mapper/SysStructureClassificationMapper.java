package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.pojo.dto.StructureClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.StructureParentTypeDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysStructureClassificationMapper extends BaseMapper<SysStructureClassification> {
   List<StructureClassificationDTO> selectListByCondition(@Param("classificationIds") List<Long> classificationIds);

   List<Long> selectIdsByCondition(
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum,
      @Param("classificationName") String classificationName,
      @Param("specPrefix") String specPrefix,
      @Param("artifactType") Integer artifactType,
      @Param("mesProductEnum") Integer mesProductEnum,
      @Param("sectionAndNameAndType") String sectionAndNameAndType
   );

   List<StructureParentTypeDTO> selectLisStructureClass(
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum, @Param("classificationName") String classificationName
   );

   List<StructureClassificationDTO> selectListByCondition2(
      @Param("classificationName") String classificationName,
      @Param("specPrefix") String specPrefix,
      @Param("artifactType") Integer artifactType,
      @Param("mesProductEnum") Integer mesProductEnum
   );
}
