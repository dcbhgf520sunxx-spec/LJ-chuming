package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionTaskAbsencesRecord;
import com.hzchum.scim.system.core.api.service.ProjectInspectionTaskAbsencesRecordService;
import com.hzchum.scim.system.core.mapper.ProjectInspectionTaskAbsencesRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectInspectionTaskAbsencesRecordServiceImpl
   extends ServiceImpl<ProjectInspectionTaskAbsencesRecordMapper, ProjectInspectionTaskAbsencesRecord>
   implements ProjectInspectionTaskAbsencesRecordService {
}
