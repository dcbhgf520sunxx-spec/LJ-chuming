package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssistNumberDetail;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistNumberDetailService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingAssistNumberDetailMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingAssistNumberDetailServiceImpl
   extends ServiceImpl<MesBuildingAssistNumberDetailMapper, MesBuildingAssistNumberDetail>
   implements MesBuildingAssistNumberDetailService {
   @Override
   public List<MesBuildingAssistNumberDetail> listAssistDetails(List<NumberInfoDTO> numberInfoDTOS, Integer taskType) {
      return this.baseMapper.listAssistDetails(numberInfoDTOS, taskType);
   }
}
