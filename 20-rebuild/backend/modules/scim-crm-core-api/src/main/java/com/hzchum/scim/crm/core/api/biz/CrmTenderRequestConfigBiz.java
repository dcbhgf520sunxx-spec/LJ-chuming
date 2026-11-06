package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmTenderRequestConfig;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTenderRequestConfigEnumListDTO;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmTenderRequestConfigUpdateParam;
import java.util.List;

public interface CrmTenderRequestConfigBiz extends IBiz<CrmTenderRequestConfig> {
   List<CrmTenderRequestConfigEnumListDTO> getList(Integer crmTenderRequestConfigEnum, Integer crmSpecialBubmissionStatusEnum);

   Boolean updateByList(List<CrmTenderRequestConfigUpdateParam> collect, Integer crmTenderRequestConfigEnum, Integer crmSpecialBubmissionStatusEnum);

   List<CrmTenderRequestConfigEnumListDTO> getListSkipPermissions(Integer crmTenderRequestConfigEnum, Integer crmSpecialBubmissionStatusEnum);

   Boolean syncTenderRequestConfig(Integer crmTenderRequestConfigEnum, String name);
}
