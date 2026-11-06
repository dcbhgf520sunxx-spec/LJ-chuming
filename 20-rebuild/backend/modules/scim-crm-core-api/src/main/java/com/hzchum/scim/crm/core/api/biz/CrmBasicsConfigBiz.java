package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBasicsConfig;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBasicsConfigEnumListDTO;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmBasicsConfigUpdateParam;
import java.util.List;

public interface CrmBasicsConfigBiz extends IBiz<CrmBasicsConfig> {
   List<CrmBasicsConfigEnumListDTO> getList(Integer crmBasicsConfigEnum);

   Boolean updateByList(List<CrmBasicsConfigUpdateParam> crmBasicsConfigUpdateParams, Integer crmBasicsConfigEnum);

   List<CrmBasicsConfigEnumListDTO> getListSkipPermissions(Integer crmBasicsConfigEnum);

   Boolean syncBasicsConfigInformation(Integer crmProjectInformationConfigEnum, String name);
}
