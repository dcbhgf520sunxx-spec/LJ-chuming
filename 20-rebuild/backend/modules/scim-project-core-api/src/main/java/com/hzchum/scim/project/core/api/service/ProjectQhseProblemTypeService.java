package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseProblemType;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseProblemTypeDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseProblemTypeDTOParam;
import java.util.List;

public interface ProjectQhseProblemTypeService extends IService<ProjectQhseProblemType> {
   List<ProjectQhseProblemTypeDTO> listTypes(String name);

   Boolean saveList(List<ProjectQhseProblemTypeDTOParam> params);

   Boolean updateType(ProjectQhseProblemTypeDTOParam param);
}
