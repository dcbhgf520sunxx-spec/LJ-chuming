package com.hzchum.scim.mes.building.core.api.biz.ProjectProductionStatisticsBiz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics.MesDailyProductionTaskDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics.ProjectProductionStatisticsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.MesDailyProductionArtifactSumDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.MesDayProductionDetailClassDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectWorkshopDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface MesDailyProductionStatisticsBiz {
   List<MesBuildingProjectWorkshopDTO> getWorkAndLineQueryCondition(ProjectProductionStatisticsDOParam param);

   List<MesDailyProductionArtifactSumDTO> getDayProductionTaskSum(MesDailyProductionTaskDOParam param);

   void printDayProductionTaskSum(MesDailyProductionTaskDOParam param, HttpServletResponse response);

   PageVO getPackDateailList(Long projectId, Long workShopId, LocalDateTime dateTime, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printPackDateailList(Long projectId, Long workShopId, LocalDateTime dateTime, Integer pageNumber, Integer pageSize);

   List<MesDayProductionDetailClassDTO> getProductionDetailList(
      Long projectId, Long workShopId, Long teamId, Long monomerId, LocalDateTime dateTime, Long processId, Integer meteUnitEnum
   );

   PrintVO<List<Map<String, Object>>> printProductionDetailList(
      Long projectId, Long workShopId, Long teamId, Long monomerId, LocalDateTime dateTime, Long processId, Integer meteUnitEnum
   );
}
