package com.hzchum.scim.mes.building.core.biz.impl.scheduling;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlatePartBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlatePart;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlatePartService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingNestCutPlatePartMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingNestCutPlatePartBizImpl
   extends IBizImpl<MesBuildingNestCutPlatePartService, MesBuildingNestCutPlatePartMapper, MesBuildingNestCutPlatePart>
   implements MesBuildingNestCutPlatePartBiz {
}
