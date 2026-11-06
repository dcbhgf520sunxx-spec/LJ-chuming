package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesbuildingTaskProcessAssistDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.UserLinkGroupProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.UserLinkLineProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.post.AssistDTOParam;
import java.util.List;

public interface MesBuildingAssistBiz extends IBiz<MesBuildingAssist> {
   Boolean assistSave(List<AssistDTOParam> assistList, Long id, List<Long> nextProcessIds, Long artifactTaskId);

   Boolean assistRomve(List<Long> ids);

   List<MesBuildingAssist> listUserLinkAssIst(Long taskId, List<UserLinkGroupProcessDTO> groupProcessLinks, Integer taskTypeEnum);

   List<MesBuildingAssist> listUserLinkAssIst2(Long taskId, List<UserLinkLineProcessDTO> lineProcessLinks, Integer taskTypeEnum);

   Boolean assistSaveList(List<MesbuildingTaskProcessAssistDTO> taskProcessAssistDTOS);
}
