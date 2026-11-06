package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingChangeLog;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingChangeLogService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingChangeLogMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingChangeLogServiceImpl extends ServiceImpl<MesBuildingChangeLogMapper, MesBuildingChangeLog> implements MesBuildingChangeLogService {
}
