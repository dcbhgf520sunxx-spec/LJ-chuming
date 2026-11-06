package com.hzchum.scim.mes.enclosure.core.api.biz.statistica;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.statistica.MesEnclosureStructureProcessPriceDTO;
import java.util.List;
import java.util.Map;

public interface MesEnclosureGroupRivetWeldConfigBiz {
   MesEnclosureStructureProcessPriceDTO getWeldConfigPrice(Long productId, Integer taskTypeEnum, Long processId);

   Map<Long, MesEnclosureStructureProcessPriceDTO> getWeldConfigPriceMap(List<Long> productIds, Integer taskTypeEnum, Long processId);
}
