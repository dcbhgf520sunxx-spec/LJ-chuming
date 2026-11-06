package com.hzchum.scim.mes.building.core.api.service.app;

import com.hzchum.scim.mes.building.core.api.pojo._dto.app.AverageTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.ProcessKanBanOverdueOverDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.ProcessKanBanQhseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.ProcessKanBanSummaryDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ProcessKanBanBiz {
   ProcessKanBanSummaryDTO getProcessKanBanSummary(LocalDateTime year, Long processId, Long userId);

   Map<Integer, Integer> getMonthlyOutputByYear(LocalDateTime year, Long processId, Long userId);

   Map<Integer, Integer> getQhseCountByYear(LocalDateTime year, Long processId, Long userId);

   List<ProcessKanBanQhseDTO> getQhseAnalyseByYear(LocalDateTime year, Long processId, Long userId);

   AverageTaskDTO getAverageTaskCompletionRate(LocalDateTime year, Long processId, Long userId);

   ProcessKanBanOverdueOverDTO getOverdueOrderInfo(Long processId, Long userId);
}
