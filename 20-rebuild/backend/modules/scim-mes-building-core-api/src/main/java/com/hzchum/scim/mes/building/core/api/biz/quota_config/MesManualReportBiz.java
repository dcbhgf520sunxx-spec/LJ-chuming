package com.hzchum.scim.mes.building.core.api.biz.quota_config;

import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesManualReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesManualReportQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingProduceTeamReportDTOParam;
import java.util.List;

public interface MesManualReportBiz {
   List<MesManualReportDTO> unreportedList(MesManualReportQuery query);

   List<MesManualReportDTO> flexibleProcessUnreportedList(MesManualReportQuery query);

   Boolean batchAddProduceReport(Integer productTypeEnum, List<MesBuildingProduceTeamReportDTOParam> paramList);

   Boolean flexibleProcessBatchAddProduceReport(Integer productTypeEnum, Long processId, Long teamId, List<MesBuildingProduceTeamReportDTOParam> paramList);
}
