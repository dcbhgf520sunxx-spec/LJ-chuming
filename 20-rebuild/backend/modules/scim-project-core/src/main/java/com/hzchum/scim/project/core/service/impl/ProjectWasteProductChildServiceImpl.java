package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.pojo._do.ProjectWasteProductChild;
import com.hzchum.scim.project.core.api.service.ProjectWasteProductChildService;
import com.hzchum.scim.project.core.mapper.ProjectWasteProductChildMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectWasteProductChildServiceImpl
   extends ServiceImpl<ProjectWasteProductChildMapper, ProjectWasteProductChild>
   implements ProjectWasteProductChildService {
}
