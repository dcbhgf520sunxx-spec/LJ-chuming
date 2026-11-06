package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReportSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingReportSummaryDTO;
import java.util.List;

public interface MesBuildingProduceTeamReportSummaryService extends IService<MesBuildingProduceTeamReportSummary> {
   List<MesBuildingProduceTeamReportSummary> listReportSummarysByData(List<MesBuildingReportSummaryDTO> summaryDTOS);
}
