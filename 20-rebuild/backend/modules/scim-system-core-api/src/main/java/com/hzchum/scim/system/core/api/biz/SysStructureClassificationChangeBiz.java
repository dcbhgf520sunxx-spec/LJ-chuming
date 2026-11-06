package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassificationChange;
import com.hzchum.scim.system.core.api.pojo.request.StructureClassificationChangeAuditDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.StructureClassificationUpdateTOParam;

public interface SysStructureClassificationChangeBiz extends IBiz<SysStructureClassificationChange> {
   Boolean change(StructureClassificationUpdateTOParam dtoParam);

   Boolean audit(StructureClassificationChangeAuditDTOParam dtoParam);
}
