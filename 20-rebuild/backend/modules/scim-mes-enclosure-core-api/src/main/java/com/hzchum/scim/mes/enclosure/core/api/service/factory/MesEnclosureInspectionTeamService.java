package com.hzchum.scim.mes.enclosure.core.api.service.factory;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.InspectionMeteDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.InspectionUserRecordDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureInspectionTeam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.task.InspectionDetailDOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.task.InspectionReportDOParam;
import java.util.List;

public interface MesEnclosureInspectionTeamService extends IService<MesEnclosureInspectionTeam> {
   MesEnclosureInspectionTeam getInspectionTeamBygroupsIdAndProcessIdAndUserId(Long groupsId, Long processId, Long userId);

   ListVO<InspectionMeteDO> listUserSummary(InspectionReportDOParam param);

   ListVO<InspectionUserRecordDO> listUserDetail(InspectionDetailDOParam param);

   List<MesEnclosureInspectionTeam> selectByLine(List<Long> ids);
}
