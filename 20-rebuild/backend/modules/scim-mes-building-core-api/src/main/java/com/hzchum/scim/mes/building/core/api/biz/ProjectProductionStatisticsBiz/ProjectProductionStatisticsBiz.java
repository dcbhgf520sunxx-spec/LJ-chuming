package com.hzchum.scim.mes.building.core.api.biz.ProjectProductionStatisticsBiz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics.ProjectProductionStatisticsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics.ProjectProductionTaskDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.ProjectProductionStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.ProjectProductionStatisticsDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.ProjectProductionTaskDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectWorkshopDTO;
import java.util.List;
import java.util.Map;

public interface ProjectProductionStatisticsBiz {
   ProjectProductionStatisticsDTO projectProductionStatisticsSum(ProjectProductionStatisticsDOParam param);

   ProjectProductionStatisticsDetailDTO projectProductionStatisticsDetail(ProjectProductionStatisticsDOParam param);

   List<MesBuildingProjectProcessDTO> getProjectProcessList(ProjectProductionStatisticsDOParam param);

   List<MesBuildingProjectWorkshopDTO> getProjectQueryCondition(ProjectProductionStatisticsDOParam param);

   List<ProjectProductionTaskDetailDTO> getProjectProductionTaskTeamDetail(ProjectProductionTaskDOParam param);

   List<ProjectProductionTaskDetailDTO> getProjectProductionTaskDetail(ProjectProductionTaskDOParam param);

   PageVO<ProjectProductionTaskDetailDTO> getPageProjectProductionTaskDetail(ProjectProductionTaskDOParam param);

   Map<String, Object> getProjectProductionTaskSum(ProjectProductionTaskDOParam param);

   PrintVO<List<Map<String, Object>>> printProjectProductionTaskDetail(ProjectProductionTaskDOParam param);

   PageVO<ProjectProductionTaskDetailDTO> getPageProjectProductionTaskTeamDetail(ProjectProductionTaskDOParam param);

   Map<String, Object> getProjectProductionTaskTeamSum(ProjectProductionTaskDOParam param);

   PrintVO<List<Map<String, Object>>> printProjectProductionTaskTeamDetail(ProjectProductionTaskDOParam param);
}
