package com.hzchum.scim.mes.building.core.api.biz.complete;

import com.hzchum.scim.mes.building.core.api.pojo._dto.complete.CompleteMeteByMonthDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.complete.CompleteProductDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingCompleteBiz {
   List<CompleteProductDTO> getTeamProduction(Long teamId, Integer productType, LocalDateTime dateTime);

   List<CompleteMeteByMonthDTO> getTeamMeteByMonth(Long teamId, Integer productType, LocalDateTime dateTime);
}
