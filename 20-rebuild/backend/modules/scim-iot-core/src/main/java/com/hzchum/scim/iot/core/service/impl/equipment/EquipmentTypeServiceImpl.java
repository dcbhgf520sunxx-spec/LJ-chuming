package com.hzchum.scim.iot.core.service.impl.equipment;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.EquipmentType;
import com.hzchum.scim.iot.core.api.service.equiment.EquipmentTypeService;
import com.hzchum.scim.iot.core.mapper.equipment.EquipmentTypeMapper;
import org.springframework.stereotype.Service;

@Service
public class EquipmentTypeServiceImpl extends ServiceImpl<EquipmentTypeMapper, EquipmentType> implements EquipmentTypeService {
   @Override
   public void deletetUnBoolen() {
      this.baseMapper.deletetUnBoolen();
   }
}
