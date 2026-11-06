package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingNestingJson;
import com.hzchum.scim.system.core.api.service.MesBuildingNestingJsonService;
import com.hzchum.scim.system.core.mapper.MesBuildingNestingJsonMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingNestingJsonServiceImpl
   extends ServiceImpl<MesBuildingNestingJsonMapper, MesBuildingNestingJson>
   implements MesBuildingNestingJsonService {
}
