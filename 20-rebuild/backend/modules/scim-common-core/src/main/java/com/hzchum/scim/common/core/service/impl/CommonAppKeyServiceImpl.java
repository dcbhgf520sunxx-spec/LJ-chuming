package com.hzchum.scim.common.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo._do.CommonAppKey;
import com.hzchum.scim.common.core.api.service.CommonAppKeyService;
import com.hzchum.scim.common.core.mapper.CommonAppKeyMapper;
import org.springframework.stereotype.Service;

@Service
public class CommonAppKeyServiceImpl extends ServiceImpl<CommonAppKeyMapper, CommonAppKey> implements CommonAppKeyService {
}
