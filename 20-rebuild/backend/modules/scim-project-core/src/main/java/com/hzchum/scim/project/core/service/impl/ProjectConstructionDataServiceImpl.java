package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.pojo._do.ProjectConstructionData;
import com.hzchum.scim.project.core.api.service.ProjectConstructionDataService;
import com.hzchum.scim.project.core.mapper.ProjectConstructionDataMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectConstructionDataServiceImpl
   extends ServiceImpl<ProjectConstructionDataMapper, ProjectConstructionData>
   implements ProjectConstructionDataService {
}
