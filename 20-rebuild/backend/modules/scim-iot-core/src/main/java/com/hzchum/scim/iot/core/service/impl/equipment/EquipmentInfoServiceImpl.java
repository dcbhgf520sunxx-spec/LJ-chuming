package com.hzchum.scim.iot.core.service.impl.equipment;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.EquipmentInfo;
import com.hzchum.scim.iot.core.api.service.equiment.EquipmentInfoService;
import com.hzchum.scim.iot.core.mapper.equipment.EquipmentInfoMapper;
import org.springframework.stereotype.Service;

@Service
public class EquipmentInfoServiceImpl extends ServiceImpl<EquipmentInfoMapper, EquipmentInfo> implements EquipmentInfoService {
   @Override
   public void deletetUnBoolen() {
      this.baseMapper.deletetUnBoolen();
   }
}
