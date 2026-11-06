package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.ProjectInspectionUserLinkBiz;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUserLink;
import com.hzchum.scim.system.core.api.service.ProjectInspectionUserLinkService;
import com.hzchum.scim.system.core.mapper.ProjectInspectionUserLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectInspectionUserLinkBizImpl
   extends IBizImpl<ProjectInspectionUserLinkService, ProjectInspectionUserLinkMapper, ProjectInspectionUserLink>
   implements ProjectInspectionUserLinkBiz {
}
