package com.hzchum.scim.iot.core.service.impl.equipment;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.CorporationStructrure;
import com.hzchum.scim.iot.core.api.service.equiment.CorporationStructrureService;
import com.hzchum.scim.iot.core.mapper.equipment.CorporationStructrureMapper;
import org.springframework.stereotype.Service;

@Service
public class CorporationStructrureServiceImpl extends ServiceImpl<CorporationStructrureMapper, CorporationStructrure> implements CorporationStructrureService {
   @Override
   public void deletetUnBoolen() {
      this.baseMapper.deletetUnBoolen();
   }
}
