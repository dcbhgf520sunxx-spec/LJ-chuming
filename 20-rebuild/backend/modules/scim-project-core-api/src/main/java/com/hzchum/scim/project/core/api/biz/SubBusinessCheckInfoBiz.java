package com.hzchum.scim.project.core.api.biz;

import com.hzchum.scim.common.core.api.pojo.dto.CheckDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.CheckInfoDTOParam;

public interface SubBusinessCheckInfoBiz {
   Boolean setUnitPrice(CheckInfoDTOParam params);

   Boolean check(CheckDTOParam param);
}
