package com.hzchum.scim.common.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo._do.CommonApp;
import com.hzchum.scim.common.core.api.service.CommonAppService;
import com.hzchum.scim.common.core.mapper.CommonAppMapper;
import org.springframework.stereotype.Service;

@Service
public class CommonAppServiceImpl extends ServiceImpl<CommonAppMapper, CommonApp> implements CommonAppService {
}
