package com.hzchum.scim.plan.core.service.impl.check;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechAssembleMachinePartLinkRecord;
import com.hzchum.scim.plan.core.api.service.check.TechAssembleMachinePartLinkRecordService;
import com.hzchum.scim.plan.core.mapper.check.TechAssembleMachinePartLinkRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class TechAssembleMachinePartLinkRecordServiceImpl
   extends ServiceImpl<TechAssembleMachinePartLinkRecordMapper, TechAssembleMachinePartLinkRecord>
   implements TechAssembleMachinePartLinkRecordService {
}
