package com.hzchum.scim.mes.building.core.mapper.wage_manage;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesYieldConfirm;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.ApportionReportDataDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesYieldConfirmDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesYieldConfirmWorkshopProcessTeamDTO;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesYieldConfirmMapper extends BaseMapper<MesYieldConfirm> {
   List<MesYieldConfirmWorkshopProcessTeamDTO> unauditedWorkshopProcessTeamList(
      @Param("workshopId") Long workshopId,
      @Param("yearMonthDaySelect") Integer yearMonthDaySelect,
      @Param("selectedDate") LocalDateTime selectedDate,
      @Param("processId") Long processId
   );

   List<MesYieldConfirmDTO> unauditedList(
      @Param("workshopId") Long workshopId,
      @Param("processId") Long processId,
      @Param("teamLeaderName") String teamLeaderName,
      @Param("productType") Integer productType,
      @Param("yearMonthDaySelect") Integer yearMonthDaySelect,
      @Param("selectedDate") LocalDateTime selectedDate,
      @Param("projectName") String projectName,
      @Param("productSerialNumber") String productSerialNumber
   );

   List<MesYieldConfirmWorkshopProcessTeamDTO> auditedWorkshopProcessTeamList(
      @Param("statisticsModeEnum") Integer statisticsModeEnum, @Param("workshopId") Long workshopId, @Param("selectedDate") LocalDateTime selectedDate
   );

   List<MesYieldConfirmWorkshopProcessTeamDTO> auditedWorkshopProcessTeamUniversalConfigurationList(
      @Param("statisticsModeEnum") Integer statisticsModeEnum, @Param("workshopId") Long workshopId, @Param("selectedDate") LocalDateTime selectedDate
   );

   List<MesYieldConfirmDTO> auditedList(
      @Param("workshopId") Long workshopId,
      @Param("processId") Long processId,
      @Param("teamId") Long teamId,
      @Param("productType") Integer productType,
      @Param("selectedDate") LocalDateTime selectedDate,
      @Param("projectName") String projectName,
      @Param("productSerialNumber") String productSerialNumber
   );

   List<MesYieldConfirmDTO> auditedUniversalConfigurationList(
      @Param("workshopId") Long workshopId,
      @Param("processId") Long processId,
      @Param("teamId") Long teamId,
      @Param("productType") Integer productType,
      @Param("selectedDate") LocalDateTime selectedDate,
      @Param("projectName") String projectName,
      @Param("productSerialNumber") String productSerialNumber
   );

   List<ApportionReportDataDTO> getTotalInboundQuantity(@Param("year") Integer year, @Param("workshopId") Long workshopId);

   List<ApportionReportDataDTO> getCost(@Param("year") Integer year);

   List<ApportionReportDataDTO> getCurrencyCost(@Param("year") Integer year, @Param("workshopId") Long workshopId);
}
