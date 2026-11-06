package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingChangeLogBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingChangeLog;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingChangeLogService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingChangeLogMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingChangeLogBizImpl
   extends IBizImpl<MesBuildingChangeLogService, MesBuildingChangeLogMapper, MesBuildingChangeLog>
   implements MesBuildingChangeLogBiz {
}
