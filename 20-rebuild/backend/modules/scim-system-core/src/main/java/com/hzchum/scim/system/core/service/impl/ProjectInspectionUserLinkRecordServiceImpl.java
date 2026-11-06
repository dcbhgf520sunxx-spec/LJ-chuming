package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUserLinkRecord;
import com.hzchum.scim.system.core.api.service.ProjectInspectionUserLinkRecordService;
import com.hzchum.scim.system.core.mapper.ProjectInspectionUserLinkRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectInspectionUserLinkRecordServiceImpl
   extends ServiceImpl<ProjectInspectionUserLinkRecordMapper, ProjectInspectionUserLinkRecord>
   implements ProjectInspectionUserLinkRecordService {
}
