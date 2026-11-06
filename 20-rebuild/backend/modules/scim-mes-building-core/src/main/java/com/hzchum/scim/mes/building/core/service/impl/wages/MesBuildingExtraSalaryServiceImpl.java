package com.hzchum.scim.mes.building.core.service.impl.wages;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.MesBuildingExtraSalary;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.OutStaffDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.OutStaffDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.OutStaffSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.OutStaffDetailsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.OutStaffSummaryDOParam;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingExtraSalaryService;
import com.hzchum.scim.mes.building.core.mapper.wages.MesBuildingExtraSalaryMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingExtraSalaryServiceImpl
   extends ServiceImpl<MesBuildingExtraSalaryMapper, MesBuildingExtraSalary>
   implements MesBuildingExtraSalaryService {
   @Override
   public OutStaffDO outStaffAuditList(Long teamId, Long productId, Integer productType) {
      return this.baseMapper.outStaffAuditList(teamId, productId, productType);
   }

   @Override
   public Boolean saveList(List<MesBuildingExtraSalary> extraSalaries) {
      extraSalaries.forEach(e -> {
         e.setBoolUsedEnum(false);
         this.baseMapper.insert(e);
      });
      return true;
   }

   @Override
   public List<OutStaffSummaryDO> outStaffuditSummaryList(OutStaffSummaryDOParam doParam) {
      return this.baseMapper.outStaffuditSummaryList(doParam);
   }

   @Override
   public List<OutStaffDetailsDO> outStaffuditDetailsList(OutStaffDetailsDOParam doParam) {
      return this.baseMapper.outStaffuditDetailsList(doParam);
   }
}
