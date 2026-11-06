package com.hzchum.scim.mes.building.core.api.biz.process;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.ApplyAllClassListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.AssembleConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProductProcessLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.SteelClassificationProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.StructureClassificationProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.StructureParentTypeProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.TypeProcessSelectDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingProductProcessDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.ProductProcessApplyAllDTOParam;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface MesBuildingProductProcessBiz {
   PageVO<SteelClassificationProcessDTO> oldMachinePartProcessList(Integer mesProductEnum, Integer pageNumber, Integer pageSize);

   List<MesBuildingProductProcessLinkDTO> classConfigProcessLink(Long prodLineId, Long classId, Integer taskTypeEnum);

   Boolean updateProductProcess(MesBuildingProductProcessDTOParam dtoParam);

   PageVO<StructureParentTypeProcessDTO> artifactProcessPage(
      Integer productionLineTypeEnum,
      String classificationName,
      String specPrefix,
      Integer mesProductEnum,
      String typeAndPrefixName,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<StructureClassificationProcessDTO> artifactProcessPage2(
      String classificationName, String specPrefix, Integer artifactType, Integer mesProductEnum, Integer pageNumber, Integer pageSize
   );

   List<StructureClassificationProcessDTO> artifactProcessList(
      Integer productionLineTypeEnum, String classificationName, String specPrefix, Integer mesProductEnum
   );

   PageVO<AssembleConfigDTO> assembleProcessPage(
      Boolean boolSectionSteel,
      Integer productionLineTypeEnum,
      String name,
      String specPrefix,
      Integer mesProductEnum,
      String sectionAndNameAndType,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<AssembleConfigDTO> assembleProcessPage2(Long lineId, String name, String specPrefix, Integer mesProductEnum, Integer pageNumber, Integer pageSize);

   List<AssembleConfigDTO> assembleProcessList(Integer productionLineTypeEnum, String name, String specPrefix, Integer mesProductEnum);

   List<SteelClassificationProcessDTO> machinePartProcessList(Integer productClassificationEnum, Integer mesProductEnum, String sectionAndNameAndType);

   List<String> manufactureParList(Integer mesProductEnum);

   @Transactional(rollbackFor = Exception.class)
   Boolean updateProductProcess2(MesBuildingProductProcessDTOParam dtoParam);

   List<TypeProcessSelectDTO> artifactTypeProcessSelect(Integer artifactClassification, Integer mesProductEnum);

   List<TypeProcessSelectDTO> assembleTypeProcessSelect(Integer mesProductEnum);

   List<TypeProcessSelectDTO> machinePartTypeProcessSelect(Integer machinePartClassification, Integer mesProductEnum);

   List<ApplyAllClassListDTO> applyAllClassList(Long lineId, Integer taskTypeEnum, Integer mesProductEnum);

   Boolean ApplyAll(ProductProcessApplyAllDTOParam dtoParam);
}
