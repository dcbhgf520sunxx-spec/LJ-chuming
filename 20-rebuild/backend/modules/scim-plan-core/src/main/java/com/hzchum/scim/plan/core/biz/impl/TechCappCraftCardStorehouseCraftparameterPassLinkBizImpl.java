package com.hzchum.scim.plan.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardStorehouseCraftparameterPassLinkBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardStorehouseCraftParameterPassLink;
import com.hzchum.scim.plan.core.api.service.TechCappCraftCardStorehouseCraftparameterPassLinkService;
import com.hzchum.scim.plan.core.mapper.TechCappCraftCardStorehouseCraftParameterPassLinkMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TechCappCraftCardStorehouseCraftparameterPassLinkBizImpl
   extends IBizImpl<TechCappCraftCardStorehouseCraftparameterPassLinkService, TechCappCraftCardStorehouseCraftParameterPassLinkMapper, TechCappCraftCardStorehouseCraftParameterPassLink>
   implements TechCappCraftCardStorehouseCraftparameterPassLinkBiz {
   @Override
   public List<TechCappCraftCardStorehouseCraftParameterPassLink> getAllList() {
      return this.baseMapper.getAllList();
   }
}
