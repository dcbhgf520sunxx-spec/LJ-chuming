package com.hzchum.scim.mes.building.core.api.biz.statistica;

import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingStructureProcessPriceDTO;
import java.util.List;
import java.util.Map;

public interface MesBuildingGroupRivetWeldConfigBiz {
   MesBuildingStructureProcessPriceDTO getWeldConfigPrice(Long productId, Integer taskTypeEnum, Long processId);

   Map<Long, MesBuildingStructureProcessPriceDTO> getWeldConfigPriceMap(List<Long> productIds, Integer taskTypeEnum, Long processId);
}
