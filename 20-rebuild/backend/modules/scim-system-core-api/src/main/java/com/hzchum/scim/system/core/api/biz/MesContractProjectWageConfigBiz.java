package com.hzchum.scim.system.core.api.biz;

public interface MesContractProjectWageConfigBiz {
   Boolean saveContractProjectWageConfig(Long projectId);

   Boolean existsConfig(Long projectId);

   Boolean deleteContractProjectWageConfig(Long projectId);
}
