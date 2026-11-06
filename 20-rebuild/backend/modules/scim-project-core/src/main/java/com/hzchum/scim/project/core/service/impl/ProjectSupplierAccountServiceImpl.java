package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAccount;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectSupplierAccountDO;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAccountService;
import com.hzchum.scim.project.core.mapper.ProjectSupplierAccountMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectSupplierAccountServiceImpl
   extends ServiceImpl<ProjectSupplierAccountMapper, ProjectSupplierAccount>
   implements ProjectSupplierAccountService {
   @Override
   public List<ProjectSupplierAccountDO> listInstallSupplier(Long projectId, Long monomerId) {
      return this.baseMapper.selectSubSupplier(projectId, monomerId);
   }

   @Override
   public Long getSupplierIdByUserId(Long userId) {
      ProjectSupplierAccount supplierAccount = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(ProjectSupplierAccount.class).eq(ProjectSupplierAccount::getUserId, userId).eq(ProjectSupplierAccount::getBoolStatus, true)
         );
      Preconditions.checkArgument(supplierAccount != null, "分包商用户已被禁用");
      return supplierAccount.getSupplierId();
   }
}
