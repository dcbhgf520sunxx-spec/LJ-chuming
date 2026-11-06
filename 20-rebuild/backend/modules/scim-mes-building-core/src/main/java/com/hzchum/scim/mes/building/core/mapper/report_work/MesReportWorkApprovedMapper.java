package com.hzchum.scim.mes.building.core.mapper.report_work;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesReportWorkApproved;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesReportWorkUnapprovedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesTeamProductionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesTeamWageSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesReportWorkUnapprovedQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesTeamWageSummaryQuery;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesReportWorkApprovedMapper extends BaseMapper<MesReportWorkApproved> {
   List<MesReportWorkUnapprovedDTO> unapprovedList(MesReportWorkUnapprovedQuery query);

   Integer unapprovedCount(@Param("year") Integer year);

   BigDecimal cumulativeWeight(@Param("year") Integer year);

   BigDecimal approvedWeight(@Param("year") Integer year);

   List<MesTeamWageSummaryDTO> teamWageSummary(MesTeamWageSummaryQuery query);

   List<MesTeamProductionDTO> teamProduction(MesTeamWageSummaryQuery query);
}
