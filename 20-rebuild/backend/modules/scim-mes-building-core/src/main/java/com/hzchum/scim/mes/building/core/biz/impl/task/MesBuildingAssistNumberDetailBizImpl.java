package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingAssistNumberDetailBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssistNumberDetail;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistNumberDetailService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingAssistNumberDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingAssistNumberDetailBizImpl
   extends IBizImpl<MesBuildingAssistNumberDetailService, MesBuildingAssistNumberDetailMapper, MesBuildingAssistNumberDetail>
   implements MesBuildingAssistNumberDetailBiz {
}
