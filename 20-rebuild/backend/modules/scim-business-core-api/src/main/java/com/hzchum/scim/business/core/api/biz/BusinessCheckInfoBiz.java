package com.hzchum.scim.business.core.api.biz;

import com.hzchum.scim.business.core.api.pojo.dtoParam.CheckInfoDTOParam;
import com.hzchum.scim.common.core.api.pojo.dto.CheckDTOParam;

public interface BusinessCheckInfoBiz {
   Boolean setUnitPrice(CheckInfoDTOParam params);

   Boolean check(CheckDTOParam param);
}
