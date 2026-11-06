package com.hzchum.scim.mes.building.core.api.service.statistica;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingLayingOffConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingLayingOffConfigDTO;
import java.util.List;

public interface MesBuildingLayingOffConfigService extends IService<MesBuildingLayingOffConfig> {
   Boolean saveLayingOffList(List<MesBuildingLayingOffConfigDTO> dtoList);

   List<MesBuildingLayingOffConfigDTO> getLayingOffList();

   Boolean updateLayingOff(MesBuildingLayingOffConfigDTO dto);

   Boolean removeLayingOff(List<Long> ids);
}
