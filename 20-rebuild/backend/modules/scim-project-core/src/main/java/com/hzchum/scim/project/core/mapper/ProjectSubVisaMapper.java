package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSubVisa;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSubVisaDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectSubVisaQueryDTOParam;
import java.util.List;

public interface ProjectSubVisaMapper extends BaseMapper<ProjectSubVisa> {
   List<ProjectSubVisaDTO> selectByCondition(ProjectSubVisaQueryDTOParam param);
}
