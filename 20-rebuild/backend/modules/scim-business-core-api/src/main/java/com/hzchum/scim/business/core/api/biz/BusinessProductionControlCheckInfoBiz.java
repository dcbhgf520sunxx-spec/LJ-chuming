package com.hzchum.scim.business.core.api.biz;

import com.hzchum.scim.business.core.api.pojo.dtoParam.ProductionControlCheckInfoDTOParam;
import com.hzchum.scim.common.core.api.pojo.dto.CheckDTOParam;

public interface BusinessProductionControlCheckInfoBiz {
   Boolean setLossFactor(ProductionControlCheckInfoDTOParam params);

   Boolean check(CheckDTOParam param);

   Object setProjectStatus();
}
