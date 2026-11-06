package com.hzchum.scim.bid.core.api.biz;

import com.hzchum.scim.bid.core.api.pojo._do.ProjectTendering;
import com.hzchum.scim.bid.core.api.pojo.dto.ProjectTenderingDTO;
import java.util.List;

public interface ProjectTenderingSupplierBiz {
   void saveSubjectAndSupplier(List<Long> supplierIds, ProjectTenderingDTO dto, ProjectTendering projectTendering);
}
