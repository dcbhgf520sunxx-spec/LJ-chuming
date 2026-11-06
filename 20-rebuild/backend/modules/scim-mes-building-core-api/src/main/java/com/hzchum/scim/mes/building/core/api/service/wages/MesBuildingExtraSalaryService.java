package com.hzchum.scim.mes.building.core.api.service.wages;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.MesBuildingExtraSalary;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.OutStaffDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.OutStaffDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.OutStaffSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.OutStaffDetailsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.OutStaffSummaryDOParam;
import java.util.List;

public interface MesBuildingExtraSalaryService extends IService<MesBuildingExtraSalary> {
   OutStaffDO outStaffAuditList(Long teamId, Long productId, Integer productType);

   Boolean saveList(List<MesBuildingExtraSalary> extraSalaries);

   List<OutStaffSummaryDO> outStaffuditSummaryList(OutStaffSummaryDOParam doParam);

   List<OutStaffDetailsDO> outStaffuditDetailsList(OutStaffDetailsDOParam copy);
}
