package com.hzchum.scim.mes.building.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReportSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingReportSummaryDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingProduceTeamReportSummaryMapper extends BaseMapper<MesBuildingProduceTeamReportSummary> {
   List<MesBuildingProduceTeamReportSummary> listReportSummarysByData(@Param("summarys") List<MesBuildingReportSummaryDTO> summarys);
}
