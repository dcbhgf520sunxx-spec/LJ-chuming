package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssistNumberDetail;
import java.util.List;

public interface MesBuildingAssistNumberDetailService extends IService<MesBuildingAssistNumberDetail> {
   List<MesBuildingAssistNumberDetail> listAssistDetails(List<NumberInfoDTO> numberInfoDTOS, Integer taskType);
}
