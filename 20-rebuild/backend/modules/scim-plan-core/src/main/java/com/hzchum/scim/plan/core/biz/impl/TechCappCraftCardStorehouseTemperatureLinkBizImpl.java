package com.hzchum.scim.plan.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardStorehouseTemperatureLinkBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardStorehouseTemperatureLink;
import com.hzchum.scim.plan.core.api.service.TechCappCraftCardStorehouseTemperatureLinkService;
import com.hzchum.scim.plan.core.mapper.TechCappCraftCardStorehouseTemperatureLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class TechCappCraftCardStorehouseTemperatureLinkBizImpl
   extends IBizImpl<TechCappCraftCardStorehouseTemperatureLinkService, TechCappCraftCardStorehouseTemperatureLinkMapper, TechCappCraftCardStorehouseTemperatureLink>
   implements TechCappCraftCardStorehouseTemperatureLinkBiz {
}
