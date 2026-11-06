package com.hzchum.scim.plan.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardProductWeldingBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardProductWelding;
import com.hzchum.scim.plan.core.api.service.TechCappCraftCardProductWeldingService;
import com.hzchum.scim.plan.core.mapper.TechCappCraftCardProductWeldingMapper;
import org.springframework.stereotype.Service;

@Service
public class TechCappCraftCardProductWeldingBizImpl
   extends IBizImpl<TechCappCraftCardProductWeldingService, TechCappCraftCardProductWeldingMapper, TechCappCraftCardProductWelding>
   implements TechCappCraftCardProductWeldingBiz {
}
