package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrderChange;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.change.MesBuildingChangeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.change.MesBuildingChangeDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.change.MesBuildingTaskChangeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.change.MesBuildingTaskOrderChangeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.post.TaskChangeDTOParam;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingTaskOrderChangeBiz extends IBiz<MesBuildingTaskOrderChange> {
   List<MesBuildingTaskOrderChangeDTO> getTaskOrderList(Long projectId, Integer taskTypeEnum, LocalDateTime dateTime);

   PageVO<MesBuildingTaskOrderChangeDTO> getTaskOrderPage(Long projectId, Integer taskTypeEnum, LocalDateTime dateTime, Integer pageNumber, Integer pageSize);

   List<MesBuildingTaskChangeDTO> getTaskOrderDetailsList(Long taskOrderId, Long areaId, String serialNumber, String specification);

   Boolean taskChange(List<TaskChangeDTOParam> dtoParamList);

   Boolean nestTaskChange(List<TaskChangeDTOParam> dtoParamList);

   List<MesBuildingChangeDTO> getChangeList(Integer taskTypeEnum, String userName);

   PageVO<MesBuildingChangeDTO> getChangePage(String userName, Integer taskTypeEnum, Integer pageNumber, Integer pageSize);

   List<MesBuildingChangeDetailsDTO> getChangeDetailsList(Long changeId);

   Boolean deleteOrderChanges(List<Long> orderIds);
}
