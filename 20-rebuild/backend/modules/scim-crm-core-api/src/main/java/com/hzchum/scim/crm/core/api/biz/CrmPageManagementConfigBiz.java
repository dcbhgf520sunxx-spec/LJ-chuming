package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmPageManagementConfig;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmPageManagementConfigDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmStyleLayoutDTO;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmPageManagementConfigUpdateParam;
import java.util.List;

public interface CrmPageManagementConfigBiz extends IBiz<CrmPageManagementConfig> {
   List<CrmPageManagementConfigDTO> getPageDetailByPageEnum(Integer crmPageManagementConfigEnum, Integer crmCountryTypeEnum);

   List<CrmStyleLayoutDTO> getStyleLayoutList();

   Boolean updateByList(List<CrmPageManagementConfigUpdateParam> collect);
}
