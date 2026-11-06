package com.hzchum.scim.plan.core.api.manager;

import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechConfigUtilsDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactBoxImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ZnljGridImportTemplateDtoParam;
import java.util.List;

public interface TechUtilInventoryGridManager {
   List<ArtifactBoxImportDTO> getGridConversionList(
      List<MistakeExportDTO> mistakeExportDTOList,
      List<ZnljGridImportTemplateDtoParam> importDTOS,
      TechConfigUtilsDTO utilsDTO,
      Long monomerId,
      Integer importType
   );
}
