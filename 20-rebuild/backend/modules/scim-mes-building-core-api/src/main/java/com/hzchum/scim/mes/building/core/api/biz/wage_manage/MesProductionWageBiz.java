package com.hzchum.scim.mes.building.core.api.biz.wage_manage;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesProductionWage;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesProductionWageReverseInferenceModeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesWageStatisticsMonthSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesWageStatisticsYearSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesProductionWageSaveParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.ReverseInferenceModeExportParam;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface MesProductionWageBiz extends IBiz<MesProductionWage> {
   List<MesWageStatisticsYearSummaryDTO> yearSummaryList(Integer year, Long workshopId, Long projectId);

   PageVO<MesWageStatisticsMonthSummaryDTO> monthSummaryPage(
      Integer year, Integer month, Long projectId, Long workshopId, Integer pageNumber, Integer pageSize, List<String> sort
   );

   Map<String, LocalDate> dateRange(Integer year, Integer month, Long projectId);

   PageVO<MesProductionWageReverseInferenceModeDTO> reverseInferenceModePage(
      Long workshopId, Long processId, String teamLeaderName, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize, List<String> sort
   );

   void monthSummaryExport(Integer year, Integer month, Long projectId, Long workshopId, HttpServletResponse response);

   void reverseInferenceModeExport(List<ReverseInferenceModeExportParam> paramList, HttpServletResponse response);

   Boolean approve(ValidList<MesProductionWageSaveParam> saveDTOParamList);
}
