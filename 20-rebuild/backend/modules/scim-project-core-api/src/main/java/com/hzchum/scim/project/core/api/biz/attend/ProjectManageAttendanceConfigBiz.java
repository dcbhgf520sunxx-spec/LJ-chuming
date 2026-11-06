package com.hzchum.scim.project.core.api.biz.attend;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendanceConfig;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageAttendanceConfigDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectManageAttendanceConfigDTOParam;

public interface ProjectManageAttendanceConfigBiz extends IBiz<ProjectManageAttendanceConfig> {
   boolean setAttendanceTime(ProjectManageAttendanceConfigDTOParam param);

   ProjectManageAttendanceConfigDTO getAttendanceTime(Long projectId);
}
