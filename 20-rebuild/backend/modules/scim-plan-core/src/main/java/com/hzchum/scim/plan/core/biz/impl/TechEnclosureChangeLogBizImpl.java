package com.hzchum.scim.plan.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.TechEnclosureChangeLogBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosureChangeLog;
import com.hzchum.scim.plan.core.api.service.TechEnclosureChangeLogService;
import com.hzchum.scim.plan.core.mapper.TechEnclosureChangeLogMapper;
import org.springframework.stereotype.Service;

@Service
public class TechEnclosureChangeLogBizImpl
   extends IBizImpl<TechEnclosureChangeLogService, TechEnclosureChangeLogMapper, TechEnclosureChangeLog>
   implements TechEnclosureChangeLogBiz {
}
