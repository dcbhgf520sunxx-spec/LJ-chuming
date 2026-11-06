package com.hzchum.scim.mes.building.core.api.biz.wage_manage;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesYieldConfirm;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesYieldConfirmDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesYieldConfirmWorkshopProcessTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesYieldConfirmSaveDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MesYieldConfirmBiz extends IBiz<MesYieldConfirm> {
   PageVO<MesYieldConfirmWorkshopProcessTeamDTO> unauditedWorkshopProcessTeamList(
      Long workshopId, Integer yearMonthDaySelect, LocalDateTime selectedDate, Long processId, Integer pageNumber, Integer pageSize
   );

   PageVO<MesYieldConfirmDTO> unauditedList(
      Long workshopId,
      Long processId,
      String teamLeaderName,
      Integer productType,
      Integer yearMonthDaySelect,
      LocalDateTime selectedDate,
      String projectName,
      String productSerialNumber,
      Integer pageNum,
      Integer pageSize,
      List<String> sort
   );

   Boolean batchSaveYieldConfirm(ValidList<MesYieldConfirmSaveDTOParam> saveDTOParamList);

   List<MesYieldConfirmWorkshopProcessTeamDTO> auditedWorkshopProcessTeamList(Integer statisticsModeEnum, Long workshopId, LocalDateTime selectedDate);

   PrintVO auditedWorkshopProcessTeamListPrint(Integer statisticsModeEnum, Long workshopId, LocalDateTime selectedDate);

   PageVO<MesYieldConfirmDTO> auditedList(
      Long workshopId,
      Long processId,
      Long teamId,
      Integer productType,
      LocalDateTime selectedDate,
      String projectName,
      String productSerialNumber,
      Integer pageNumber,
      Integer pageSize
   );

   List<Map<String, Object>> apportionReport(Integer year, Long workshopId);

   PrintVO apportionReportPrint(Integer year, Long workshopId);
}
