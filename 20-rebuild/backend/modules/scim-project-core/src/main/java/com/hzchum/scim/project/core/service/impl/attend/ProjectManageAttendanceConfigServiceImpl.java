package com.hzchum.scim.project.core.service.impl.attend;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendanceConfig;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageAttendanceConfigService;
import com.hzchum.scim.project.core.mapper.attend.ProjectManageAttendanceConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectManageAttendanceConfigServiceImpl
   extends ServiceImpl<ProjectManageAttendanceConfigMapper, ProjectManageAttendanceConfig>
   implements ProjectManageAttendanceConfigService {
}
