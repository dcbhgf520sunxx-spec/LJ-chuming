package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmInformationValidityPeriodConfig;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmInformationValidityPeriodConfigDTO;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmInformationValidityPeriodConfigUpdateParam;
import java.util.List;

public interface CrmInformationValidityPeriodConfigBiz extends IBiz<CrmInformationValidityPeriodConfig> {
   List<CrmInformationValidityPeriodConfigDTO> getList(Integer crmInformationValidityPeriodConfigEnum);

   Boolean updateByList(List<CrmInformationValidityPeriodConfigUpdateParam> list, Integer crmInformationValidityPeriodConfigEnum);

   List<CrmInformationValidityPeriodConfigDTO> getListSkipPermissions(Integer crmInformationValidityPeriodConfigEnum);
}
