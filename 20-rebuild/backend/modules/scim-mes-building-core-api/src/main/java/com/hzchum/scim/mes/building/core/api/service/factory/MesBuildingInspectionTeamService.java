package com.hzchum.scim.mes.building.core.api.service.factory;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.InspectionMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.InspectionUserRecordDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.InspectionDetailDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.InspectionReportDOParam;
import java.util.List;

public interface MesBuildingInspectionTeamService extends IService<MesBuildingInspectionTeam> {
   MesBuildingInspectionTeam getInspectionTeamBygroupsIdAndProcessIdAndUserId(Long groupsId, Long processId, Long userId);

   MesBuildingInspectionTeam getInspectionTeamByLineIdAndProcessIdAndUserId(Long lineId, Long processId, Long userId, Boolean teamType);

   ListVO<InspectionMeteDO> listUserSummary(InspectionReportDOParam param);

   ListVO<InspectionUserRecordDO> listUserDetail(InspectionDetailDOParam param);

   List<MesBuildingInspectionTeam> selectByLine(List<Long> ids);
}
