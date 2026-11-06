package com.hzchum.scim.mes.building.core.api.biz.report_work;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesReportWorkApproved;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesReportWorkUnapprovedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesTeamProductionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesTeamWageSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesReportWorkApprovedParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesReportWorkUnapprovedQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesTeamWageSummaryQuery;
import java.util.List;
import java.util.Map;

public interface MesReportWorkApprovedBiz extends IBiz<MesReportWorkApproved> {
   PageVO<MesReportWorkUnapprovedDTO> unapprovedPage(MesReportWorkUnapprovedQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   Map<String, Object> statistics(Integer year);

   Boolean elimination(List<MesReportWorkApprovedParam> params);

   Boolean approved(List<MesReportWorkApprovedParam> params);

   PageVO<MesTeamWageSummaryDTO> teamWageSummaryPage(MesTeamWageSummaryQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   PrintVO<List<Map<String, Object>>> teamWageSummaryPrint(MesTeamWageSummaryQuery query);

   Map<String, Object> teamWageSummaryStatistics(MesTeamWageSummaryQuery query);

   PageVO<MesTeamProductionDTO> teamProductionPage(MesTeamWageSummaryQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   PrintVO<List<Map<String, Object>>> teamProductionPrint(MesTeamWageSummaryQuery query);
}
