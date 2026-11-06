package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAccount;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectSupplierAccountDO;
import java.util.List;

public interface ProjectSupplierAccountService extends IService<ProjectSupplierAccount> {
   List<ProjectSupplierAccountDO> listInstallSupplier(Long projectId, Long monomerId);

   Long getSupplierIdByUserId(Long userId);
}
