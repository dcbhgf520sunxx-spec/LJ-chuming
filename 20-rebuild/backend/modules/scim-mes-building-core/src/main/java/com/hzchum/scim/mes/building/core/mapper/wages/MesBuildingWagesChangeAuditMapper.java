package com.hzchum.scim.mes.building.core.mapper.wages;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.AuditListDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingWagesChangeAudit;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.AuditListDOParam;
import java.util.List;

public interface MesBuildingWagesChangeAuditMapper extends BaseMapper<MesBuildingWagesChangeAudit> {
   List<AuditListDO> auditList(AuditListDOParam doParam);
}
