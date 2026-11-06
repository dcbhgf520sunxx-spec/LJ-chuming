package com.hzchum.scim.mes.enclosure.core.api.biz.task;

import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureScheduling;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task.MesEnclosureSchedulingDTOParam;
import java.util.List;
import java.util.Map;

public interface MesEnclosureSchedulingBiz {
   Boolean saveScheduling(MesEnclosureSchedulingDTOParam schedulings);

   Boolean saveSchedulingV2(MesEnclosureSchedulingDTOParam schedulings);

   List<MesEnclosureScheduling> selectSummaryData(Long id, Long projectId);

   Map getTotalLength(Long projectId, List<Long> planIds, Integer category);

   Map getTotalLengthV2(Long projectId, List<Long> areaIds, Integer category);
}
