package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrderChangeDetails;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderChangeDetailsService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskOrderChangeDetailsMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTaskOrderChangeDetailsServiceImpl
   extends ServiceImpl<MesBuildingTaskOrderChangeDetailsMapper, MesBuildingTaskOrderChangeDetails>
   implements MesBuildingTaskOrderChangeDetailsService {
}
