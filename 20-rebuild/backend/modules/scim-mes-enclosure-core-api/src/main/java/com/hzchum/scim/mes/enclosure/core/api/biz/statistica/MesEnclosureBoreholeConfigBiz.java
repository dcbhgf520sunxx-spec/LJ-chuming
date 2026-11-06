package com.hzchum.scim.mes.enclosure.core.api.biz.statistica;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.statistica.MesEnclosureBoreholeHoleRadiusLinkDTO;
import java.util.List;

public interface MesEnclosureBoreholeConfigBiz {
   List<MesEnclosureBoreholeHoleRadiusLinkDTO> getBoreholeConfigPrice(Long productId);
}
