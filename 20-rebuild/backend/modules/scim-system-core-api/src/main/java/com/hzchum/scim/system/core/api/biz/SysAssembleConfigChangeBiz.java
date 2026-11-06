package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfigChange;
import com.hzchum.scim.system.core.api.pojo.request.AssembleConfigChangeAuditDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.AssembleConfigUpdateDTOParam;

public interface SysAssembleConfigChangeBiz extends IBiz<SysAssembleConfigChange> {
   Boolean change(AssembleConfigUpdateDTOParam dtoParam);

   Boolean audit(AssembleConfigChangeAuditDTOParam dtoParam);
}
