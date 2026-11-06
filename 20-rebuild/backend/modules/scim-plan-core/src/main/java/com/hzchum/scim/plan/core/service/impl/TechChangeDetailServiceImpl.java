package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechChangeDetail;
import com.hzchum.scim.plan.core.api.service.TechChangeDetailService;
import com.hzchum.scim.plan.core.mapper.TechChangeDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class TechChangeDetailServiceImpl extends ServiceImpl<TechChangeDetailMapper, TechChangeDetail> implements TechChangeDetailService {
}
