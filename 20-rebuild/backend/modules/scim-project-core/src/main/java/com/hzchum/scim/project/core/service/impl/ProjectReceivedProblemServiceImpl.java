package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivedProblem;
import com.hzchum.scim.project.core.api.service.ProjectReceivedProblemService;
import com.hzchum.scim.project.core.mapper.ProjectReceivedProblemMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectReceivedProblemServiceImpl
   extends ServiceImpl<ProjectReceivedProblemMapper, ProjectReceivedProblem>
   implements ProjectReceivedProblemService {
}
