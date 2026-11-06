package com.hzchum.scim.mes.building.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
import org.apache.ibatis.annotations.Param;

public interface MesBuildingProduceInspectionTeamReportMapper extends BaseMapper<MesBuildingProduceInspectionTeamReport> {
   List<InspectionReportSourceDO> inspectionReportSourceList(@Param("id") Long id, @Param("prodcutType") Integer prodcutType);

   List<InspectionAnalysisDO> inspectionAnalysisList(@Param("dateTime") LocalDateTime dateTime);

   List<ReportDataDTO> personal(@Param("time") LocalDateTime time, @Param("workShopId") Long workShopId, @Param("userIds") List<Long> userIds);

   List<InspectionTeamRecourseDTO> listInspectionTeamByProcessIdAndProductIdAndType(Long processId, Long productId, Integer type);

   List<InspectionTeamRecourseDTO> listInspectionInfo(
      @Param("processIds") List<Long> processIds,
      @Param("productId") Long productId,
      @Param("type") Integer type,
      @Param("assitLinesIds") List<Long> assitLinesIds
   );

   List<InspectionTeamRecourseDTO> listInspectionInfoAV2(
      @Param("processId") Long processId, @Param("productId") Long productId, @Param("type") Integer type, @Param("assitLinesIds") List<Long> assitLinesIds
   );

   List<MesBuildingProduceInspectionTeamReport> listReports(@Param("numberInfoDTOS") List<NumberInfoDTO> numberInfoDTOS, @Param("taskType") Integer taskType);

   List<MesBuildingInspectCountDTO> findInspectCount(@Param("conditionalMap") Map<Long, List<Integer>> conditionalMap);

   List<MesBuildingInspectCountDTO> findInspectCountByParam(MesBuildingQhseCountParam qhseCountParam);

   List<InspectToDayListDTO> findInspectReportRealtime(Long workShopId);

   List<MonthlyFirstPassRateDTO> findInspectCountGroupMonth(Integer year);

   Integer findInspectCountByWorkshopId(Long workShopId);

   Integer getInspectionQuantity(@Param("workshopId") Long workshopId, @Param("teamId") Long teamId);
}
