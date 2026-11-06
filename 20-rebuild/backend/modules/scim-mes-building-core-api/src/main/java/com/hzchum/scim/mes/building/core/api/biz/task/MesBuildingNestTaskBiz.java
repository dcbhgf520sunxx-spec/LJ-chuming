package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.scim.mes.building.core.api.pojo._dto.IdAndRecelveQuantityDTO;
import java.util.List;

public interface MesBuildingNestTaskBiz {
   Boolean saveNestCutPlateReport(Long nestCutPlateId, List<Long> partIds, String ncCode, Boolean reportType, List<IdAndRecelveQuantityDTO> parts);

   Boolean saveDrillNestCutPlateReport(Long nestCutPlateId, List<IdAndRecelveQuantityDTO> parts, Boolean reportType);
}
