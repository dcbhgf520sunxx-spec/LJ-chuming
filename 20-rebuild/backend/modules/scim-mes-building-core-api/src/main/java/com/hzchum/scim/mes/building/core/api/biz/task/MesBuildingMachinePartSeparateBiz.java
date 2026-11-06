package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartSeparate;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachinePartSeparateDTO;
import java.util.List;

public interface MesBuildingMachinePartSeparateBiz extends IBiz<MesBuildingMachinePartSeparate> {
   List<MesBuildingMachinePartSeparateDTO> getListByTaskOrderId(Long cutId, Integer processType);

   PageVO getListByTaskOrderIdPage(Long cutId, Integer processType, Integer pageSize, Integer pageNumber);

   Boolean getListByTaskOrderIdSign(Long cutId, Integer processType);
}
