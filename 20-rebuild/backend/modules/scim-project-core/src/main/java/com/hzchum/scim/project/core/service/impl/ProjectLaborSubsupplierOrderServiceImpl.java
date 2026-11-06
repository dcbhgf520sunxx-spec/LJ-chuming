package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.pojo._do.ProjectLaborSubsupplierOrder;
import com.hzchum.scim.project.core.api.service.ProjectLaborSubsupplierOrderService;
import com.hzchum.scim.project.core.mapper.ProjectLaborSubsupplierOrderMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectLaborSubsupplierOrderServiceImpl
   extends ServiceImpl<ProjectLaborSubsupplierOrderMapper, ProjectLaborSubsupplierOrder>
   implements ProjectLaborSubsupplierOrderService {
}
