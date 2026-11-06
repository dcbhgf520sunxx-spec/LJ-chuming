package com.hzchum.scim.scm.core.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrderChangeRecord;
import com.hzchum.scim.scm.core.api.service.LogisticsOrderChangeRecordService;
import com.hzchum.scim.scm.core.mapper.LogisticsOrderChangeRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class LogisticsOrderChangeRecordServiceImpl
   extends ServiceImpl<LogisticsOrderChangeRecordMapper, LogisticsOrderChangeRecord>
   implements LogisticsOrderChangeRecordService {
}
