package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductTask;
import com.hzchum.scim.plan.core.api.service.TechCappCraftProductTaskService;
import com.hzchum.scim.plan.core.mapper.TechCappCraftProductTaskMapper;
import org.springframework.stereotype.Service;

@Service
public class TechCappCraftProductTaskServiceImpl
   extends ServiceImpl<TechCappCraftProductTaskMapper, TechCappCraftProductTask>
   implements TechCappCraftProductTaskService {
}
