package com.hzchum.scim.common.core.service.impl.sync;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo._do.CommonAppKey;
import com.hzchum.scim.common.core.api.service.sync.SyncAppKeyService;
import com.hzchum.scim.common.core.mapper.sync.SyncAppKeyMapper;
import org.springframework.stereotype.Service;

@Service
public class SyncAppKeyServiceImpl extends ServiceImpl<SyncAppKeyMapper, CommonAppKey> implements SyncAppKeyService {
}
