package com.hzchum.scim.common.core.service.impl.sync;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo._do.CommonApp;
import com.hzchum.scim.common.core.api.service.sync.SyncAppService;
import com.hzchum.scim.common.core.mapper.sync.SyncAppMapper;
import org.springframework.stereotype.Service;

@Service
public class SyncAppServiceImpl extends ServiceImpl<SyncAppMapper, CommonApp> implements SyncAppService {
}
