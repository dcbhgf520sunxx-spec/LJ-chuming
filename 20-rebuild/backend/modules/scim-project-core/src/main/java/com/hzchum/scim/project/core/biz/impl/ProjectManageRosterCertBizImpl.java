package com.hzchum.scim.project.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.project.core.api.biz.ProjectManageRosterCertBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRosterCert;
import com.hzchum.scim.project.core.api.service.ProjectManageRosterCertService;
import com.hzchum.scim.project.core.mapper.ProjectManageRosterCertMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectManageRosterCertBizImpl
   extends IBizImpl<ProjectManageRosterCertService, ProjectManageRosterCertMapper, ProjectManageRosterCert>
   implements ProjectManageRosterCertBiz {
}
