package com.hzchum.scim.mes.building.core.api.biz.statistica;

import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingLayingOffConfigDTO;

public interface MesBuildingLayingOffConfigBiz {
   MesBuildingLayingOffConfigDTO getLayingOffConfig(Long productId, Long cutConfigId);
}
