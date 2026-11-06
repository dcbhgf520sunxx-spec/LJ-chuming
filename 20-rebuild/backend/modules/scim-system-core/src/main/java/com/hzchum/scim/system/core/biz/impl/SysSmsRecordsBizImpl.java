package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.SysSmsRecordsBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysSmsRecords;
import com.hzchum.scim.system.core.api.service.SysSmsRecordsService;
import com.hzchum.scim.system.core.mapper.SysSmsRecordsMapper;
import org.springframework.stereotype.Service;

@Service
public class SysSmsRecordsBizImpl extends IBizImpl<SysSmsRecordsService, SysSmsRecordsMapper, SysSmsRecords> implements SysSmsRecordsBiz {
}
