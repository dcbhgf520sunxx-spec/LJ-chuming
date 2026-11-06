package com.hzchum.scim.plan.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardStorehouseMaterialsLinkBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardStorehouseMaterialsLink;
import com.hzchum.scim.plan.core.api.service.TechCappCraftCardStorehouseMaterialsLinkService;
import com.hzchum.scim.plan.core.mapper.TechCappCraftCardStorehouseMaterialsLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class TechCappCraftCardStorehouseMaterialsLinkBizImpl
   extends IBizImpl<TechCappCraftCardStorehouseMaterialsLinkService, TechCappCraftCardStorehouseMaterialsLinkMapper, TechCappCraftCardStorehouseMaterialsLink>
   implements TechCappCraftCardStorehouseMaterialsLinkBiz {
}
