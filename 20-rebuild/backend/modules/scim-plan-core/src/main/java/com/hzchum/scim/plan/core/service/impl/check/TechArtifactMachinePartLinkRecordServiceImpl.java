package com.hzchum.scim.plan.core.service.impl.check;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechArtifactMachinePartLinkRecord;
import com.hzchum.scim.plan.core.api.service.check.TechArtifactMachinePartLinkRecordService;
import com.hzchum.scim.plan.core.mapper.check.TechArtifactMachinePartLinkRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class TechArtifactMachinePartLinkRecordServiceImpl
   extends ServiceImpl<TechArtifactMachinePartLinkRecordMapper, TechArtifactMachinePartLinkRecord>
   implements TechArtifactMachinePartLinkRecordService {
}
