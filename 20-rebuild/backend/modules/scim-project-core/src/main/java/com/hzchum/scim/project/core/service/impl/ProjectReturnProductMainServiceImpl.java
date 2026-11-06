package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductMain;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReturnProductMainDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectReturnProductMainQueryParam;
import com.hzchum.scim.project.core.api.service.ProjectReturnProductMainService;
import com.hzchum.scim.project.core.mapper.ProjectReturnProductMainMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectReturnProductMainServiceImpl
   extends ServiceImpl<ProjectReturnProductMainMapper, ProjectReturnProductMain>
   implements ProjectReturnProductMainService {
   @Override
   public List<ProjectReturnProductMainDTO> selectByCondition(ProjectReturnProductMainQueryParam param) {
      return this.baseMapper.selectProjectReturnProductMainList(param);
   }
}
