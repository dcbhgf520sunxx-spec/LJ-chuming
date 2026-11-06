package com.hzchum.scim.plan.core.api.manager;

import java.util.List;

public interface ProjectLevelManager {
   void saveAreaByType(Long projectId, Integer type);

   void updateAreaByType(Long projectId, Long areaId, Integer oldType, Integer newType);

   void removeAreaByIds(List<Long> areaIds);

   void updateProjectBranchCompany(Long projectId, Long branchCompanyId);

   void boolUpdateProjectBranchCompany(Long projectId, Long branchCompanyId);
}
