package com.hzchum.scim.scm.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractMonomerLink;
import com.hzchum.scim.scm.core.api.pojo.dto.SubOrderMonomerDTO;
import java.util.List;

public interface SubcontractMonomerLinkService extends IService<SubcontractMonomerLink> {
   List<SubOrderMonomerDTO> listByCondition(Long projectId, Long supplierId, Long subcontractClassId);

   List<SupplierInfo> listByMonomerId(Long monomerId);
}
