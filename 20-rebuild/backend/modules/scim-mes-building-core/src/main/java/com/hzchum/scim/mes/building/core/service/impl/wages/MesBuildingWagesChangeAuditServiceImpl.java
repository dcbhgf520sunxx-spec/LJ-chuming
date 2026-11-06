package com.hzchum.scim.mes.building.core.service.impl.wages;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.AuditListDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingWagesChangeAudit;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.AuditListDOParam;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingWagesChangeAuditService;
import com.hzchum.scim.mes.building.core.mapper.wages.MesBuildingWagesChangeAuditMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingWagesChangeAuditServiceImpl
   extends ServiceImpl<MesBuildingWagesChangeAuditMapper, MesBuildingWagesChangeAudit>
   implements MesBuildingWagesChangeAuditService {
   @Override
   public List<AuditListDO> auditList(AuditListDOParam doParam) {
      return this.baseMapper.auditList(doParam);
   }
}
