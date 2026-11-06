package com.hzchum.scim.iot.core.biz.impl.equipment;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.iot.core.api.biz.equipment.EquipmentTypeBiz;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.EquipmentType;
import com.hzchum.scim.iot.core.api.service.equiment.EquipmentTypeService;
import com.hzchum.scim.iot.core.mapper.equipment.EquipmentTypeMapper;
import org.springframework.stereotype.Service;

@Service
public class EquipmentTypeBizImpl extends IBizImpl<EquipmentTypeService, EquipmentTypeMapper, EquipmentType> implements EquipmentTypeBiz {
}
