package com.hzchum.scim.mes.building.core.biz.impl.process;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.process.MesBuildingNextProcessLinkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingNextProcessLink;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingNextProcessLinkService;
import com.hzchum.scim.mes.building.core.mapper.process.MesBuildingNextProcessLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingNextProcessLinkBizImpl
   extends IBizImpl<MesBuildingNextProcessLinkService, MesBuildingNextProcessLinkMapper, MesBuildingNextProcessLink>
   implements MesBuildingNextProcessLinkBiz {
}
