package com.hzchum.scim.contract.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.contract.core.mapper.ProjectBranchCompanyLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectBranchCompanyLinkServiceImpl
   extends ServiceImpl<ProjectBranchCompanyLinkMapper, ProjectBranchCompanyLink>
   implements ProjectBranchCompanyLinkService {
}
