package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.pojo.dto.StructureClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.StructureParentTypeDTO;
import java.util.List;

public interface SysStructureClassificationService extends IService<SysStructureClassification> {
   List<StructureClassificationDTO> listByCondition(List<Long> classificationIds);

   List<Long> selectIdsByCondition(
      Integer productionLineTypeEnum, String classificationName, String specPrefix, Integer artifactType, Integer mesProductEnum, String sectionAndNameAndType
   );

   List<StructureClassificationDTO> listByCondition2(String classificationName, String specPrefix, Integer artifactType, Integer mesProductEnum);

   List<NameInfo> listAll(Integer mesProductEnum);

   List<StructureParentTypeDTO> listStructureClass(Integer productionLineTypeEnum, String classificationName);
}
