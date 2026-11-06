package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAreaLink;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAreaLinkService;
import com.hzchum.scim.project.core.mapper.ProjectSupplierAreaLinkMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectSupplierAreaLinkServiceImpl
   extends ServiceImpl<ProjectSupplierAreaLinkMapper, ProjectSupplierAreaLink>
   implements ProjectSupplierAreaLinkService {
   @Override
   public List<ProjectSupplierAreaLink> listBySupplierId(Long supplierId, Long projectId, Long monomerId) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
               .eq(ProjectSupplierAreaLink::getSupplierId, supplierId)
               .eq(projectId != null, ProjectSupplierAreaLink::getProjectId, projectId)
               .eq(monomerId != null, ProjectSupplierAreaLink::getMonomerId, monomerId)
               .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
               .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
         );
   }
}
