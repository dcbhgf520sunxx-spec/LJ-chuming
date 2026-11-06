package com.hzchum.scim.mes.enclosure.core.mapper.factory;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.InspectionMeteDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.InspectionUserRecordDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureInspectionTeam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.task.InspectionDetailDOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.task.InspectionReportDOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesEnclosureInspectionTeamMapper extends BaseMapper<MesEnclosureInspectionTeam> {
   MesEnclosureInspectionTeam getInspectionTeamBygroupsIdAndProcessIdAndUserId(
      @Param("groupsId") Long groupsId, @Param("processId") Long processId, @Param("userId") Long userId
   );

   List<InspectionMeteDO> listUserSummary(InspectionReportDOParam param);

   List<InspectionUserRecordDO> listUserDetail(InspectionDetailDOParam param);

   List<MesEnclosureInspectionTeam> inspectionTeamBy(List<Long> ids);
}
