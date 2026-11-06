package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.pojo.dto.labor.ProjectManageRosterDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectManageRosterQuery;
import java.util.List;

public interface ProjectManageRosterService extends IService<ProjectManageRoster> {
   List<ProjectManageRosterDTO> rosterList(ProjectManageRosterQuery query);

   List<String> nationList();

   ProjectManageRosterDTO getByUserId(Long userId);
}
