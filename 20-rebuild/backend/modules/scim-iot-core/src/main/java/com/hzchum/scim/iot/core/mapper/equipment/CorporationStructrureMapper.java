package com.hzchum.scim.iot.core.mapper.equipment;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.CorporationStructrure;

public interface CorporationStructrureMapper extends BaseMapper<CorporationStructrure> {
   void deletetUnBoolen();
}
