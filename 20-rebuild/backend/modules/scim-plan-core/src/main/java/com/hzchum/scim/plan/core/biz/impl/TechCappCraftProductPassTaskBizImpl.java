package com.hzchum.scim.plan.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductPassTaskBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductPassTask;
import com.hzchum.scim.plan.core.api.service.TechCappCraftProductPassTaskService;
import com.hzchum.scim.plan.core.mapper.TechCappCraftProductPassTaskMapper;
import org.springframework.stereotype.Service;

@Service
public class TechCappCraftProductPassTaskBizImpl
   extends IBizImpl<TechCappCraftProductPassTaskService, TechCappCraftProductPassTaskMapper, TechCappCraftProductPassTask>
   implements TechCappCraftProductPassTaskBiz {
}
