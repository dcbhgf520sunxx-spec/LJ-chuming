package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationConfig;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectInformationConfigEnumListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTheNumberOfCustomProjectConfigDTO;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmCustomQuantityUpdateParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmProjectInformationConfigUpdateParam;
import java.util.List;

public interface CrmProjectInformationConfigBiz extends IBiz<CrmProjectInformationConfig> {
   List<CrmProjectInformationConfigEnumListDTO> getList(Integer crmProjectInformationConfigEnum);

   Boolean updateByList(List<CrmProjectInformationConfigUpdateParam> crmProjectInformationConfigUpdateParams, Integer crmProjectInformationConfigEnum);

   List<CrmProjectInformationConfigEnumListDTO> getListSkipPermissions(Integer crmProjectInformationConfigEnum);

   List<CrmProjectInformationConfigEnumListDTO> getListSkipPermissionsAPP(Integer crmProjectInformationConfigEnum);

   Boolean customQuantityUpdate(List<CrmCustomQuantityUpdateParam> crmCustomQuantityUpdateParams);

   Boolean customQuantityClean();

   List<CrmTheNumberOfCustomProjectConfigDTO> customQuantityList(Long userId);

   Boolean syncProjectInformation(Integer crmProjectInformationConfigEnum, String name);
}
