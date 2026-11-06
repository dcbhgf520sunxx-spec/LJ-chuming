package com.hzchum.scim.crm.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseinquiriesConfigBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmEnterpriseinquiriesConfig;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmEnterpriseinquiriesConfigUpdateParam;
import com.hzchum.scim.crm.core.api.service.CrmEnterpriseinquiriesConfigService;
import com.hzchum.scim.crm.core.mapper.CrmEnterpriseinquiriesConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmEnterpriseinquiriesConfigBizImpl
   extends IBizImpl<CrmEnterpriseinquiriesConfigService, CrmEnterpriseinquiriesConfigMapper, CrmEnterpriseinquiriesConfig>
   implements CrmEnterpriseinquiriesConfigBiz {
   @Override
   public Boolean getEnterpriseinquiriesConfig() {
      CrmEnterpriseinquiriesConfig enterpriseinquiriesConfig = this.baseService.getOne(Wrappers.lambdaQuery(CrmEnterpriseinquiriesConfig.class));
      return enterpriseinquiriesConfig == null ? Boolean.FALSE : Boolean.TRUE;
   }

   @Override
   public Boolean updateEnterpriseinquiriesConfig(CrmEnterpriseinquiriesConfigUpdateParam crmEnterpriseinquiriesConfigUpdateParam) {
      CrmEnterpriseinquiriesConfig enterpriseinquiriesConfig = this.baseService.getOne(Wrappers.lambdaQuery(CrmEnterpriseinquiriesConfig.class));
      if (enterpriseinquiriesConfig == null) {
         this.baseService.save(CrmEnterpriseinquiriesConfig.builder().appCode(crmEnterpriseinquiriesConfigUpdateParam.getAppCode()).build());
      } else {
         enterpriseinquiriesConfig.setAppCode(crmEnterpriseinquiriesConfigUpdateParam.getAppCode());
         this.baseService.updateById(enterpriseinquiriesConfig);
      }

      return Boolean.TRUE;
   }
}
