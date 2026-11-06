package com.hzchum.scim.scm.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrderTemp;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractOrderTempDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderTempAuditDtoParam;

public interface SubcontractOrderTempBiz extends IBiz<SubcontractOrderTemp> {
   SubcontractOrderTempDTO getTempById(Long tempId);

   Boolean auditSubOrderChange(SubcontractOrderTempAuditDtoParam param);

   void handleAuditSuccess(SubcontractOrderTemp orderTemp);
}
