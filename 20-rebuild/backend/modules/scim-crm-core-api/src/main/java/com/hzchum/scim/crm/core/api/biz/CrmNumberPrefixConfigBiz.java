package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmNumberPrefixConfig;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmNumberPrefixConfigDTO;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmNumberPrefixConfigUpdateParam;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface CrmNumberPrefixConfigBiz extends IBiz<CrmNumberPrefixConfig> {
   List<CrmNumberPrefixConfigDTO> getList();

   Boolean updateByList(List<CrmNumberPrefixConfigUpdateParam> list);

   @Transactional
   String generateSerialNumber(Integer crmNumberPrefixConfigEnum);
}
