package com.hzchum.scim.project.core.api.service.attend;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendanceFence;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageAttendanceFenceDTO;
import java.util.List;

public interface ProjectManageAttendanceFenceService extends IService<ProjectManageAttendanceFence> {
   List<ProjectManageAttendanceFenceDTO> getAttendanceFence(Long projectId);
}
