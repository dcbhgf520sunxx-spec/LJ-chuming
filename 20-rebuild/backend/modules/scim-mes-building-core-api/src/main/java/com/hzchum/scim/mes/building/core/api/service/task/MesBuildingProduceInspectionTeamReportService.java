package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.InspectionAnalysisDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.InspectionReportSourceDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.qhse.MesBuildingQhseCountParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.InspectToDayListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.MonthlyFirstPassRateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.InspectionTeamRecourseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingInspectCountDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ReportDataDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MesBuildingProduceInspectionTeamReportService extends IService<MesBuildingProduceInspectionTeamReport> {
   List<InspectionReportSourceDO> inspectionReportSourceList(Long id, Integer prodcutType);

   List<InspectionAnalysisDO> inspectionAnalysisList(LocalDateTime dateTime);

   List<ReportDataDTO> personal(LocalDateTime time, Long workShopId, List<Long> userIds);

   List<InspectionTeamRecourseDTO> listInspectionTeamByProcessIdAndProductIdAndType(Long processId, Long productId, Integer type);

   List<InspectionTeamRecourseDTO> listInspectionInfo(List<Long> processId, Long productId, Integer type, List<Long> assitLinesIds);

   List<InspectionTeamRecourseDTO> listInspectionInfoAV2(Long processId, Long productId, Integer type, List<Long> assitLinesIds);

   List<MesBuildingProduceInspectionTeamReport> listReports(List<NumberInfoDTO> numberInfoDTOS, Integer taskType);

   List<MesBuildingInspectCountDTO> findInspectCount(Map<Long, List<Integer>> conditionalMap);

   List<MesBuildingInspectCountDTO> findInspectCountByParam(MesBuildingQhseCountParam qhseCountParam);

   List<InspectToDayListDTO> findInspectReportRealtime(Long workShopId);

   List<MonthlyFirstPassRateDTO> findInspectCountGroupMonth(Integer year);

   Integer findInspectCountByWorkshopId(Long workShopId);

   Integer getInspectionQuantity(Long workshopId, Long teamId);
}
