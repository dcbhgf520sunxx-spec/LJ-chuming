package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskNumberLinkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskNumberLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTaskNumberLinkBizImpl
   extends IBizImpl<MesBuildingTaskNumberLinkService, MesBuildingTaskNumberLinkMapper, MesBuildingTaskNumberLink>
   implements MesBuildingTaskNumberLinkBiz {
}
