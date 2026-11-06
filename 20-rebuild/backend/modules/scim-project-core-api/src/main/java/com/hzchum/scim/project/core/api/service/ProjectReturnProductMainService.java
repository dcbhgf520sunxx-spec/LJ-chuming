package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductMain;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReturnProductMainDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectReturnProductMainQueryParam;
import java.util.List;

public interface ProjectReturnProductMainService extends IService<ProjectReturnProductMain> {
   List<ProjectReturnProductMainDTO> selectByCondition(ProjectReturnProductMainQueryParam param);
}
