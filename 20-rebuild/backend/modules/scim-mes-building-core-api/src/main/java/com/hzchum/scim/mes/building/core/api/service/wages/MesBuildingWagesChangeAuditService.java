package com.hzchum.scim.mes.building.core.api.service.wages;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.AuditListDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingWagesChangeAudit;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.AuditListDOParam;
import java.util.List;

public interface MesBuildingWagesChangeAuditService extends IService<MesBuildingWagesChangeAudit> {
   List<AuditListDO> auditList(AuditListDOParam doParam);
}
