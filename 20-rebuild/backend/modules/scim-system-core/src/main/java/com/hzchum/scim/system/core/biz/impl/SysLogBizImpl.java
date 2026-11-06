package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.SysLogBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysLog;
import com.hzchum.scim.system.core.api.service.SysLogService;
import com.hzchum.scim.system.core.mapper.SysLogMapper;
import org.springframework.stereotype.Service;

@Service
public class SysLogBizImpl extends IBizImpl<SysLogService, SysLogMapper, SysLog> implements SysLogBiz {
}
