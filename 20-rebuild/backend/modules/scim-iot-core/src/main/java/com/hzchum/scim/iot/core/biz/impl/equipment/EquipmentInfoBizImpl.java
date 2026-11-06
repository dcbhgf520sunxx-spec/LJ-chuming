package com.hzchum.scim.iot.core.biz.impl.equipment;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.iot.core.api.biz.equipment.EquipmentInfoBiz;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.EquipmentInfo;
import com.hzchum.scim.iot.core.api.service.equiment.EquipmentInfoService;
import com.hzchum.scim.iot.core.mapper.equipment.EquipmentInfoMapper;
import org.springframework.stereotype.Service;

@Service
public class EquipmentInfoBizImpl extends IBizImpl<EquipmentInfoService, EquipmentInfoMapper, EquipmentInfo> implements EquipmentInfoBiz {
}
