package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUserLink;
import com.hzchum.scim.system.core.api.service.ProjectInspectionUserLinkService;
import com.hzchum.scim.system.core.mapper.ProjectInspectionUserLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectInspectionUserLinkServiceImpl
   extends ServiceImpl<ProjectInspectionUserLinkMapper, ProjectInspectionUserLink>
   implements ProjectInspectionUserLinkService {
}
