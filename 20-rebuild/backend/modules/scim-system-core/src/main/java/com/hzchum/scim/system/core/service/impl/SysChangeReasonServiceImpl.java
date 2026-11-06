package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysChangeReason;
import com.hzchum.scim.system.core.api.service.SysChangeReasonService;
import com.hzchum.scim.system.core.mapper.SysChangeReasonMapper;
import org.springframework.stereotype.Service;

@Service
public class SysChangeReasonServiceImpl extends ServiceImpl<SysChangeReasonMapper, SysChangeReason> implements SysChangeReasonService {
}
