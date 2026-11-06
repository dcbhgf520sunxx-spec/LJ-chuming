package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReject;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectRejectQueryDTOParam;
import java.time.LocalDateTime;
import java.util.List;

public interface ProjectRejectMapper extends BaseMapper<ProjectReject> {
   int getCount(LocalDateTime now);

   List<ProjectReject> getProjectRejectPage(ProjectRejectQueryDTOParam param);
}
