package com.hzchum.scim.mes.building.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssistNumberDetail;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingAssistNumberDetailMapper extends BaseMapper<MesBuildingAssistNumberDetail> {
   List<MesBuildingAssistNumberDetail> listAssistDetails(@Param("numberInfoDTOS") List<NumberInfoDTO> numberInfoDTOS, @Param("taskType") Integer taskType);
}
