package com.hzchum.scim.plan.core.api.manager;

import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechConfigUtilsDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactBoxImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ZnljArtifactMachinePartImportTemplateDtoParam;
import java.util.List;

public interface TechUtilInventoryMesManager {
   List<ArtifactBoxImportDTO> getMesConversionList(
      List<MistakeExportDTO> mistakeExportDTOList,
      List<ZnljArtifactMachinePartImportTemplateDtoParam> importDTOS,
      TechConfigUtilsDTO utilsDTO,
      Long monomerId,
      Integer importType
   );
}
