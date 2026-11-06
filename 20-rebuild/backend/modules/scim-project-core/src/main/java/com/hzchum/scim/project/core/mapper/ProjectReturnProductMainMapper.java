package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductMain;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReturnProductMainDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectReturnProductMainQueryParam;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectReturnProductMainMapper extends BaseMapper<ProjectReturnProductMain> {
   List<ProjectReturnProductMainDTO> selectProjectReturnProductMainList(ProjectReturnProductMainQueryParam param);
}
