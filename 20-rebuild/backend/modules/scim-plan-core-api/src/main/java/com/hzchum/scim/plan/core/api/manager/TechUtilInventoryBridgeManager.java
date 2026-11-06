package com.hzchum.scim.plan.core.api.manager;

import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechConfigUtilsDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactBoxImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ZnljBridgeImportTemplateDtoParam;
import java.util.List;

public interface TechUtilInventoryBridgeManager {
   List<ArtifactBoxImportDTO> getBridgeConversionList(
      List<MistakeExportDTO> mistakeExportDTOList,
      List<ZnljBridgeImportTemplateDtoParam> importDTOS,
      TechConfigUtilsDTO utilsDTO,
      Long monomerId,
      Integer importType
   );
}
