package com.hzchum.scim.plan.core.service.impl.check;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechAssembleDetailRecord;
import com.hzchum.scim.plan.core.api.service.check.TechAssembleDetailRecordService;
import com.hzchum.scim.plan.core.mapper.check.TechAssembleDetailRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class TechAssembleDetailRecordServiceImpl
   extends ServiceImpl<TechAssembleDetailRecordMapper, TechAssembleDetailRecord>
   implements TechAssembleDetailRecordService {
}
