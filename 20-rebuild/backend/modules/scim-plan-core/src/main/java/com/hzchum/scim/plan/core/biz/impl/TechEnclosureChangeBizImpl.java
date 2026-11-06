package com.hzchum.scim.plan.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.TechEnclosureChangeBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosureChange;
import com.hzchum.scim.plan.core.api.service.TechEnclosureChangeService;
import com.hzchum.scim.plan.core.mapper.TechEnclosureChangeMapper;
import org.springframework.stereotype.Service;

@Service
public class TechEnclosureChangeBizImpl
   extends IBizImpl<TechEnclosureChangeService, TechEnclosureChangeMapper, TechEnclosureChange>
   implements TechEnclosureChangeBiz {
}
