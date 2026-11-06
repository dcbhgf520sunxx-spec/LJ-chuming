package com.hzchum.scim.mes.building.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.qhse.ProduceQhseDo;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.InspectionTeamReportSummaryByteamDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.InspectionTeamReportSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.InspectionTeamReportSummaryDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceQhseTeamReport;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingProduceQhseTeamReportMapper extends BaseMapper<MesBuildingProduceQhseTeamReport> {
   List<InspectionTeamReportSummaryDO> inspectionTeamReportSummary(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("productType") Integer productType
   );

   List<InspectionTeamReportSummaryDetailsDO> inspectionTeamReportSummaryDetails(
      @Param("userId") Long userId,
      @Param("projectName") String projectName,
      @Param("serialNumber") String serialNumber,
      @Param("processId") Long processId,
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("productType") Integer productType
   );

   List<InspectionTeamReportSummaryDetailsDO> inspectionReportSummaryDetails(
      @Param("userId") Long userId,
      @Param("projectName") String projectName,
      @Param("serialNumber") String serialNumber,
      @Param("projectId") Long projectId,
      @Param("type") Integer type,
      @Param("projectIds") List<Long> projectIds,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("productType") Integer productType
   );

   List<InspectionTeamReportSummaryDetailsDO> newInspectionTeamReportSummary(
      @Param("userId") Long userId,
      @Param("projectName") String projectName,
      @Param("serialNumber") String serialNumber,
      @Param("processId") Long processId,
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("productType") Integer productType
   );

   List<InspectionTeamReportSummaryByteamDO> selectlistByTeam(
      @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("ids") List<Long> ids
   );

   List<ProduceQhseDo> selectQhseTeamReport(
      @Param("ids") List<Long> ids,
      @Param("productType") Integer productType,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("lineId") Long lineId,
      @Param("groups") List<Long> groups
   );
}
