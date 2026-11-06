package com.hzchum.scim.operational.analysis.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.CompleteMeteYearDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.ProductionTypeAnalysisDO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.DateMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProjectMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.TeamProduceOperateAnalyseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.TeamProduceOperateAnalyseDetailsDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProductionSummaryDTO;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProduceAchievementBiz {
   ProductionSummaryDTO getProductionSummary(LocalDate year, Long branchCompanyId, Long workshopId);

   HashMap<String, Object> getProductionMonthly(LocalDate year, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getTargetProductionAnalysis(LocalDate year, Long branchCompanyId, Long workshopId);

   void downloadTargetProductionAnalysis(LocalDate year, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getProductionDay(LocalDate yearDate, LocalDate mouthDate, Long branchCompanyId, Long workshopId);

   List<ProjectMeteDTO> getProjectMete(LocalDate dateTime, Long branchCompanyId, Long workshopId, Boolean isMonthly);

   void getProjectMeteDownload(LocalDate dateTime, Long branchCompanyId, Long workshopId, Boolean isMonthly);

   CompleteMeteYearDTO getTargetRatio(LocalDate year, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getYearSchedulingProductionInfo(LocalDate year, Long branchCompanyId, Long workshopId);

   void getYearSchedulingProductionInfoDownload(LocalDate year, Long branchCompanyId, Long workshopId);

   List<ProjectMeteDTO> getProjectSchedulingProductionInfo(LocalDate yearMonth, Long branchCompanyId, Long workshopId);

   void getProjectSchedulingProductionInfoDownload(LocalDate year, Long branchCompanyId, Long workshopId);

   List<TeamProduceOperateAnalyseDTO> getTeamProduceOperateAnalyse(LocalDate year, Long branchCompanyId, Long workshopId, Long processId);

   PageVO<TeamProduceOperateAnalyseDetailsDTO> getTeamProduceDetailsOperateAnalyse(
      LocalDate yearDate,
      LocalDate startDate,
      LocalDate endDate,
      Long branchCompanyId,
      Long workshopId,
      Long teamId,
      Integer taskTypeEnum,
      Long processId,
      Integer pageNumber,
      Integer pageSize
   );

   void getTeamProduceDetailsOperateAnalyseDownload(
      LocalDate yearDate, LocalDate startDate, LocalDate endDate, Long branchCompanyId, Long workshopId, Long teamId, Integer taskTypeEnum, Long processId
   );

   List<ProductionTypeAnalysisDO> productionTypeAnalysisV2(LocalDate dateTime, Integer productType, Long branchCompanyId);

   Map<String, Object> getAvgProduction(LocalDate yearDate, Long branchCompanyId, Long workshopId);

   Map<String, Object> getAvgProductionYear(LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getMainOutMete(LocalDate yearDate, Long branchCompanyId, Long workshopId);

   void getMainOutMeteDownload(LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<ProjectMeteDTO> getMaterialLossDetails(LocalDate mouthDate, Long branchCompanyId, Long workshopId);

   void getMaterialLossDetailsDownload(LocalDate mouthDate, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getMainOutMeteV2(LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getMaterialLossDetailsV2(LocalDate year, Long branchCompanyId, Long workshopId);

   void getMaterialLossDetailsDownloadV2(LocalDate mouthDate, Long branchCompanyId, Long workshopId);
}
