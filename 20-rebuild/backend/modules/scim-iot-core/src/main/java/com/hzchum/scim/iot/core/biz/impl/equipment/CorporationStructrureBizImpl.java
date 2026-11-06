package com.hzchum.scim.iot.core.biz.impl.equipment;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.iot.core.api.biz.equipment.CorporationStructrureBiz;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.CorporationStructrure;
import com.hzchum.scim.iot.core.api.service.equiment.CorporationStructrureService;
import com.hzchum.scim.iot.core.mapper.equipment.CorporationStructrureMapper;
import org.springframework.stereotype.Service;

@Service
public class CorporationStructrureBizImpl
   extends IBizImpl<CorporationStructrureService, CorporationStructrureMapper, CorporationStructrure>
   implements CorporationStructrureBiz {
}
