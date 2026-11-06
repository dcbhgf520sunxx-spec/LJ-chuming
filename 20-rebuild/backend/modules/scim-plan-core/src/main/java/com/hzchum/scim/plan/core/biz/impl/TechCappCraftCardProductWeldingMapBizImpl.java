package com.hzchum.scim.plan.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardProductWeldingMapBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardProductWeldingMap;
import com.hzchum.scim.plan.core.api.service.TechCappCraftCardProductWeldingMapService;
import com.hzchum.scim.plan.core.mapper.TechCappCraftCardProductWeldingMapMapper;
import org.springframework.stereotype.Service;

@Service
public class TechCappCraftCardProductWeldingMapBizImpl
   extends IBizImpl<TechCappCraftCardProductWeldingMapService, TechCappCraftCardProductWeldingMapMapper, TechCappCraftCardProductWeldingMap>
   implements TechCappCraftCardProductWeldingMapBiz {
}
