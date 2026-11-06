package com.hzchum.scim.project.core.api.biz;

import com.hzchum.scim.project.core.api.pojo.dto.sub.SubProjectDTO;
import java.util.List;

public interface ProjectSupplierAccountBiz {
   List<SubProjectDTO> listProject();

   List<SubProjectDTO> listProjectV2();

   void buildAccount(Long supplierId);

   void shutDownAccount(Long supplierId);
}
