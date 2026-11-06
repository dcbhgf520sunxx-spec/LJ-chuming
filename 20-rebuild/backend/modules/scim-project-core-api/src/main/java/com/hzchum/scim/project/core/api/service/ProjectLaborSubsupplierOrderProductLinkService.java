package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectLaborSubsupplierOrderProductLink;
import java.math.BigDecimal;

public interface ProjectLaborSubsupplierOrderProductLinkService extends IService<ProjectLaborSubsupplierOrderProductLink> {
   boolean saveInstallInfo(Long projectId, Long supplierId, Integer productType, Long productId, BigDecimal reportQuantity);
}
