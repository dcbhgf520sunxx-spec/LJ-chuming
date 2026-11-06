package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAreaLink;
import java.util.List;

public interface ProjectSupplierAreaLinkService extends IService<ProjectSupplierAreaLink> {
   List<ProjectSupplierAreaLink> listBySupplierId(Long supplierId, Long projectId, Long monomerId);
}
