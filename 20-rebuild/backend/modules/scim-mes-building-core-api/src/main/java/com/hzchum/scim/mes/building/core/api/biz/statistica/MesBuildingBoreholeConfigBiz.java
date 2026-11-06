package com.hzchum.scim.mes.building.core.api.biz.statistica;

import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingBoreholeHoleRadiusLinkDTO;
import java.util.List;

public interface MesBuildingBoreholeConfigBiz {
   List<MesBuildingBoreholeHoleRadiusLinkDTO> getBoreholeConfigPrice(Long productId);
}
