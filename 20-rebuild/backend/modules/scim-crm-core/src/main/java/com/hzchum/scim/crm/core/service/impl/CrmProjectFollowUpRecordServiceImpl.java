package com.hzchum.scim.crm.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectFollowUpRecord;
import com.hzchum.scim.crm.core.api.service.CrmProjectFollowUpRecordService;
import com.hzchum.scim.crm.core.mapper.CrmProjectFollowUpRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmProjectFollowUpRecordServiceImpl
   extends ServiceImpl<CrmProjectFollowUpRecordMapper, CrmProjectFollowUpRecord>
   implements CrmProjectFollowUpRecordService {
}
