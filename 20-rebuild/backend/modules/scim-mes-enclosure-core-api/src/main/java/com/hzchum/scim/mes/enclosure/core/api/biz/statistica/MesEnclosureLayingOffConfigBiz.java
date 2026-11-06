package com.hzchum.scim.mes.enclosure.core.api.biz.statistica;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.statistica.MesEnclosureLayingOffConfigDTO;

public interface MesEnclosureLayingOffConfigBiz {
   MesEnclosureLayingOffConfigDTO getLayingOffConfig(Long productId, Long cutConfigId);
}
