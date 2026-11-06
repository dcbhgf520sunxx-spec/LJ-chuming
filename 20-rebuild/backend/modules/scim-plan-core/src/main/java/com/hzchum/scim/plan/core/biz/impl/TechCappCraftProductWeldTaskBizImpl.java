package com.hzchum.scim.plan.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductWeldTaskBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductWeldTask;
import com.hzchum.scim.plan.core.api.service.TechCappCraftProductWeldTaskService;
import com.hzchum.scim.plan.core.mapper.TechCappCraftProductWeldTaskMapper;
import org.springframework.stereotype.Service;

@Service
public class TechCappCraftProductWeldTaskBizImpl
   extends IBizImpl<TechCappCraftProductWeldTaskService, TechCappCraftProductWeldTaskMapper, TechCappCraftProductWeldTask>
   implements TechCappCraftProductWeldTaskBiz {
}
