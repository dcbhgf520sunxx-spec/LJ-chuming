package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosureChangeLog;
import com.hzchum.scim.plan.core.api.service.TechEnclosureChangeLogService;
import com.hzchum.scim.plan.core.mapper.TechEnclosureChangeLogMapper;
import org.springframework.stereotype.Service;

@Service
public class TechEnclosureChangeLogServiceImpl
   extends ServiceImpl<TechEnclosureChangeLogMapper, TechEnclosureChangeLog>
   implements TechEnclosureChangeLogService {
}
