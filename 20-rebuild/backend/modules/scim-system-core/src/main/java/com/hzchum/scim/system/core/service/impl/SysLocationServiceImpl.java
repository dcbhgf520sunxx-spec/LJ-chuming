package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysLocation;
import com.hzchum.scim.system.core.api.service.SysLocationService;
import com.hzchum.scim.system.core.mapper.SysLocationMapper;
import org.springframework.stereotype.Service;

@Service
public class SysLocationServiceImpl extends ServiceImpl<SysLocationMapper, SysLocation> implements SysLocationService {
}
