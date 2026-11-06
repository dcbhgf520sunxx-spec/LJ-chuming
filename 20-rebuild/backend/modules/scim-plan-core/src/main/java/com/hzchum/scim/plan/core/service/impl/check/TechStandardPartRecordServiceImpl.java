package com.hzchum.scim.plan.core.service.impl.check;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechStandardPartRecord;
import com.hzchum.scim.plan.core.api.service.check.TechStandardPartRecordService;
import com.hzchum.scim.plan.core.mapper.check.TechStandardPartRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class TechStandardPartRecordServiceImpl
   extends ServiceImpl<TechStandardPartRecordMapper, TechStandardPartRecord>
   implements TechStandardPartRecordService {
}
