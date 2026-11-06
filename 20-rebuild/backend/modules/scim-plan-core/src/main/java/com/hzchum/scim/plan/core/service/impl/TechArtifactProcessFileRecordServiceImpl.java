package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactProcessFileRecord;
import com.hzchum.scim.plan.core.api.service.TechArtifactProcessFileRecordService;
import com.hzchum.scim.plan.core.mapper.TechArtifactProcessFileRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class TechArtifactProcessFileRecordServiceImpl
   extends ServiceImpl<TechArtifactProcessFileRecordMapper, TechArtifactProcessFileRecord>
   implements TechArtifactProcessFileRecordService {
}
