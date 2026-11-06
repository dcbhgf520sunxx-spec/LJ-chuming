package com.hzchum.scim.mes.building.core.api.service.report_work;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesReportWorkApproved;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesReportWorkUnapprovedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesTeamProductionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesTeamWageSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesReportWorkApprovedParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesReportWorkUnapprovedQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesTeamWageSummaryQuery;
import java.util.List;
import java.util.Map;

public interface MesReportWorkApprovedService extends IService<MesReportWorkApproved> {
   List<MesReportWorkUnapprovedDTO> unapprovedList(MesReportWorkUnapprovedQuery query);

   Map<String, Object> statistics(Integer year);

   Boolean approved(List<MesReportWorkApprovedParam> params);

   List<MesTeamWageSummaryDTO> teamWageSummary(MesTeamWageSummaryQuery query);

   List<MesTeamProductionDTO> teamProduction(MesTeamWageSummaryQuery query);
}
