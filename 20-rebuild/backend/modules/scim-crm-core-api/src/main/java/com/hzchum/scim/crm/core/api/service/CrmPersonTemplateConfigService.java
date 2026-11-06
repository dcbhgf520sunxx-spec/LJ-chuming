package com.hzchum.scim.crm.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.crm.core.api.pojo._do.CrmPersonTemplateConfig;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmPersonTemplateConfigDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmPersonTemplateConfigDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmPersonTemplateConfigUpdateParam;
import java.util.List;

public interface CrmPersonTemplateConfigService extends IService<CrmPersonTemplateConfig> {
   List<CrmPersonTemplateConfigDTO> getTemplateList();

   CrmPersonTemplateConfigDetailDTO getTemplateDetail(Integer crmPersonTemplateEnum);

   Boolean deleteTemplate(Integer crmPersonTemplateEnum);

   Boolean updateTemplate(CrmPersonTemplateConfigUpdateParam updateParam);
}
