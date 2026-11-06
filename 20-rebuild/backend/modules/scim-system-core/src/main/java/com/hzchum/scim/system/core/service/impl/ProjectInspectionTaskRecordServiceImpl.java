package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionTaskRecord;
import com.hzchum.scim.system.core.api.service.ProjectInspectionTaskRecordService;
import com.hzchum.scim.system.core.mapper.ProjectInspectionTaskRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectInspectionTaskRecordServiceImpl
   extends ServiceImpl<ProjectInspectionTaskRecordMapper, ProjectInspectionTaskRecord>
   implements ProjectInspectionTaskRecordService {
}
