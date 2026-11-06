package com.hzchum.scim.mes.building.core.service.impl.process;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingNextProcessLink;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingNextProcessLinkService;
import com.hzchum.scim.mes.building.core.mapper.process.MesBuildingNextProcessLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingNextProcessLinkServiceImpl
   extends ServiceImpl<MesBuildingNextProcessLinkMapper, MesBuildingNextProcessLink>
   implements MesBuildingNextProcessLinkService {
}
