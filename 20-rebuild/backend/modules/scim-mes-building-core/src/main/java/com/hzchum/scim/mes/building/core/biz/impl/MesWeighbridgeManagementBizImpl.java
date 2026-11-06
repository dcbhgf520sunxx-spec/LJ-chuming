package com.hzchum.scim.mes.building.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.MesWeighbridgeManagementBiz;
import com.hzchum.scim.mes.building.core.api.pojo._do.device.MesWeighbridgeManagement;
import com.hzchum.scim.mes.building.core.api.service.MesWeighbridgeManagementService;
import com.hzchum.scim.mes.building.core.mapper.MesWeighbridgeManagementMapper;
import org.springframework.stereotype.Service;

@Service
public class MesWeighbridgeManagementBizImpl
   extends IBizImpl<MesWeighbridgeManagementService, MesWeighbridgeManagementMapper, MesWeighbridgeManagement>
   implements MesWeighbridgeManagementBiz {
}
