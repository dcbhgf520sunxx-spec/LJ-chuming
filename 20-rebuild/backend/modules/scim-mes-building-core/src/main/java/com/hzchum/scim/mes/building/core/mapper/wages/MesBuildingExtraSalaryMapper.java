package com.hzchum.scim.mes.building.core.mapper.wages;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.MesBuildingExtraSalary;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.OutStaffDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.OutStaffDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.OutStaffSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.OutStaffDetailsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.OutStaffSummaryDOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingExtraSalaryMapper extends BaseMapper<MesBuildingExtraSalary> {
   OutStaffDO outStaffAuditList(@Param("teamId") Long teamId, @Param("productId") Long productId, @Param("productType") Integer productType);

   List<OutStaffSummaryDO> outStaffuditSummaryList(OutStaffSummaryDOParam doParam);

   List<OutStaffDetailsDO> outStaffuditDetailsList(OutStaffDetailsDOParam doParam);
}
