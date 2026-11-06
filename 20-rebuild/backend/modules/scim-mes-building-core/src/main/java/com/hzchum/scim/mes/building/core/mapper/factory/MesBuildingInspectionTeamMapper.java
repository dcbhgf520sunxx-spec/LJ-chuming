package com.hzchum.scim.mes.building.core.mapper.factory;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.InspectionMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.InspectionUserRecordDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.InspectionDetailDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.InspectionReportDOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingInspectionTeamMapper extends BaseMapper<MesBuildingInspectionTeam> {
   MesBuildingInspectionTeam getInspectionTeamBygroupsIdAndProcessIdAndUserId(
      @Param("groupsId") Long groupsId, @Param("processId") Long processId, @Param("userId") Long userId
   );

   MesBuildingInspectionTeam getInspectionTeamByLineIdAndProcessIdAndUserId(
      @Param("lineId") Long lineId, @Param("processId") Long processId, @Param("userId") Long userId, @Param("teamType") Boolean teamType
   );

   List<InspectionMeteDO> listUserSummary(InspectionReportDOParam param);

   List<InspectionUserRecordDO> listUserDetail(InspectionDetailDOParam param);

   List<MesBuildingInspectionTeam> inspectionTeamBy(List<Long> ids);
}
