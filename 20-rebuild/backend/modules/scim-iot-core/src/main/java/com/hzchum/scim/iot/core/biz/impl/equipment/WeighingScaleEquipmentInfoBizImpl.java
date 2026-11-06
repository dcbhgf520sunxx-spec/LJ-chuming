package com.hzchum.scim.iot.core.biz.impl.equipment;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.iot.core.api.biz.equipment.WeighingScaleEquipmentInfoBiz;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.WeighingScaleEquipmentInfo;
import com.hzchum.scim.iot.core.api.service.equiment.WeighingScaleEquipmentInfoService;
import com.hzchum.scim.iot.core.mapper.equipment.WeighingScaleEquipmentInfoMapper;
import org.springframework.stereotype.Service;

@Service
public class WeighingScaleEquipmentInfoBizImpl
   extends IBizImpl<WeighingScaleEquipmentInfoService, WeighingScaleEquipmentInfoMapper, WeighingScaleEquipmentInfo>
   implements WeighingScaleEquipmentInfoBiz {
}
