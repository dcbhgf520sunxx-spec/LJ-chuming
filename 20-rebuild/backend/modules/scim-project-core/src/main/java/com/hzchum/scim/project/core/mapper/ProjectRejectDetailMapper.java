package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.ProjectRejectDetail;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectRejectDetailDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectRejectDetailQueryDTOParam;
import java.util.List;

public interface ProjectRejectDetailMapper extends BaseMapper<ProjectRejectDetail> {
   List<ProjectRejectDetailDTO> getProjectRejectDetailList(ProjectRejectDetailQueryDTOParam param);
}
