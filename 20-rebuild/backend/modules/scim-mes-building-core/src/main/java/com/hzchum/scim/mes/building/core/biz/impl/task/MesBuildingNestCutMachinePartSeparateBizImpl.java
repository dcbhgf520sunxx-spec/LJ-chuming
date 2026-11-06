package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingNestCutMachinePartSeparateBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingNestCutMachinePartSeparate;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingNestCutMachinePartSeparateService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingNestCutMachinePartSeparateMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingNestCutMachinePartSeparateBizImpl
   extends IBizImpl<MesBuildingNestCutMachinePartSeparateService, MesBuildingNestCutMachinePartSeparateMapper, MesBuildingNestCutMachinePartSeparate>
   implements MesBuildingNestCutMachinePartSeparateBiz {
}
