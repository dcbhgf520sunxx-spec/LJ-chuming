package com.hzchum.scim.bid.core.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectSupplier;
import com.hzchum.scim.bid.core.api.service.ProjectSupplierService;
import com.hzchum.scim.bid.core.mapper.ProjectSupplierMapper;
import org.springframework.stereotype.Service;

@Service
@DS("bidding")
public class ProjectSupplierServiceImpl extends ServiceImpl<ProjectSupplierMapper, ProjectSupplier> implements ProjectSupplierService {
}
