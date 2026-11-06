package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.pojo.dto.PartArtAssClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.StructureClassificationBasicDTO;
import com.hzchum.scim.system.core.api.pojo.dto.StructureClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.StructureParentTypeDTO;
import com.hzchum.scim.system.core.api.pojo.request.StructureClassificationSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.StructureClassificationUpdateTOParam;
import java.util.List;
import java.util.Map;

public interface SysStructureClassificationBiz {
   ListVO<StructureParentTypeDTO> listByCondition(
      Integer productionLineTypeEnum, String classificationName, Integer artifactType, Integer mesProductEnum, String sectionAndNameAndType
   );

   ListVO<StructureParentTypeDTO> list(Integer productionLineType, String classificationName);

   Boolean saveOne(StructureClassificationSaveDTOParam param);

   Boolean updateStructureClassification(StructureClassificationUpdateTOParam updateTOParam);

   void checkUpdateStructureClass(SysStructureClassification structureClass, StructureClassificationUpdateTOParam param);

   Boolean deleteIds(List<Long> ids);

   List<StructureClassificationDTO> listByContractProjectId(Long contractProjectId, Long monomerId, Long areaId);

   List<PartArtAssClassificationDTO> findAllTypeClassification(Integer mesProductEnum);

   Map<Integer, List<StructureClassificationDTO>> listArtifactSysAll(Integer mesProductEnum);

   Map<Integer, List<StructureClassificationBasicDTO>> listArtifactWeldingProfilessAll(Integer mesProductEnum);
}
