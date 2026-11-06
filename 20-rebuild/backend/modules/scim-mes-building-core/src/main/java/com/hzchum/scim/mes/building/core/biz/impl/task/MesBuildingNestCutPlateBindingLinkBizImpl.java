package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingNestCutPlateBindingLinkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingNestCutPlateBindingLink;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingNestCutPlateBindingLinkService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingNestCutPlateBindingLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingNestCutPlateBindingLinkBizImpl
   extends IBizImpl<MesBuildingNestCutPlateBindingLinkService, MesBuildingNestCutPlateBindingLinkMapper, MesBuildingNestCutPlateBindingLink>
   implements MesBuildingNestCutPlateBindingLinkBiz {
}
