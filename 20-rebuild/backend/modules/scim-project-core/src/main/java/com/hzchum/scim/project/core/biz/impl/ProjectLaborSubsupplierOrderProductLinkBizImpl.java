package com.hzchum.scim.project.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.project.core.api.biz.ProjectLaborSubsupplierOrderProductLinkBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectLaborSubsupplierOrderProductLink;
import com.hzchum.scim.project.core.api.service.ProjectLaborSubsupplierOrderProductLinkService;
import com.hzchum.scim.project.core.mapper.ProjectLaborSubsupplierOrderProductLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectLaborSubsupplierOrderProductLinkBizImpl
   extends IBizImpl<ProjectLaborSubsupplierOrderProductLinkService, ProjectLaborSubsupplierOrderProductLinkMapper, ProjectLaborSubsupplierOrderProductLink>
   implements ProjectLaborSubsupplierOrderProductLinkBiz {
}
