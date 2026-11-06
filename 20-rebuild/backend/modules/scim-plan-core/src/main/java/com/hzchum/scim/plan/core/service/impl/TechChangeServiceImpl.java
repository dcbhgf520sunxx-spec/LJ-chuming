package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechChange;
import com.hzchum.scim.plan.core.api.service.TechChangeService;
import com.hzchum.scim.plan.core.mapper.TechChangeMapper;
import org.springframework.stereotype.Service;

@Service
public class TechChangeServiceImpl extends ServiceImpl<TechChangeMapper, TechChange> implements TechChangeService {
}
