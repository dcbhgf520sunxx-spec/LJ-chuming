package com.hzchum.scim.mes.building.core.api.service.statistica;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingFabricatedPartConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingFabricatedPartConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.statistica.MesBuildingFabricatedPartConfigDTOParam;
import java.util.List;

public interface MesBuildingFabricatedPartConfigService extends IService<MesBuildingFabricatedPartConfig> {
   List<MesBuildingFabricatedPartConfigDTO> fabricatedParList();

   Boolean setFabricatedParts(MesBuildingFabricatedPartConfigDTOParam dto);

   Boolean removeFabricatedParts(MesBuildingFabricatedPartConfigDTOParam dto);
}
