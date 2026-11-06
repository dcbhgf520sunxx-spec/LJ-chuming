package com.hzchum.scim.project.core.api.biz.attend;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendanceFence;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageAttendanceFenceDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectManageAttendanceFenceDTOParam;
import java.util.List;

public interface ProjectManageAttendanceFenceBiz extends IBiz<ProjectManageAttendanceFence> {
   Boolean setAttendanceFence(ProjectManageAttendanceFenceDTOParam param);

   List<ProjectManageAttendanceFenceDTO> getAttendanceFence(Long projectId);
}
