package com.hzchum.scim.mes.building.core.api.biz.largesreen;

import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ArtifactCompleteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.DateAndMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.UnfinishedTaskDTO;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CompleteLargeScreenService {
   Map<String, BigDecimal> statistics(Long factoryId, Long workshopId, Long teamId, String processName);

   List<DateAndMeteDTO> monthlyOutput(Long factoryId, Long workshop, Long teamId, String processName);

   List<UnfinishedTaskDTO> unfinishedTask(Long factoryId, Long workshopId, Long teamId, String processName);

   List<ArtifactCompleteDTO> taskCompleteList(Long factoryId, Long workshopId, Long teamId, Long taskOrderId, String processName);
}
