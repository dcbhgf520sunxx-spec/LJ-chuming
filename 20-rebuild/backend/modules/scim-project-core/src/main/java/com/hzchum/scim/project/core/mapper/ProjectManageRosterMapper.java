package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.pojo.dto.labor.ProjectManageRosterDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectManageRosterQuery;
import java.util.List;

public interface ProjectManageRosterMapper extends BaseMapper<ProjectManageRoster> {
   List<ProjectManageRosterDTO> rosterList(ProjectManageRosterQuery query);
}
