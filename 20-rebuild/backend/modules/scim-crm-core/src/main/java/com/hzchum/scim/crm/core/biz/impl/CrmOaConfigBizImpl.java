package com.hzchum.scim.crm.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmOaConfigBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmOaConfig;
import com.hzchum.scim.crm.core.api.service.CrmOaConfigService;
import com.hzchum.scim.crm.core.mapper.CrmOaConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmOaConfigBizImpl extends IBizImpl<CrmOaConfigService, CrmOaConfigMapper, CrmOaConfig> implements CrmOaConfigBiz {
   @Override
   public CrmOaConfig getOaConfig() {
      CrmOaConfig config = this.baseService.getOne(Wrappers.lambdaQuery(CrmOaConfig.class));
      return config == null ? CrmOaConfig.builder().enabled(Boolean.TRUE).build() : config;
   }

   @Override
   public Boolean updateOaConfig(Boolean enabled) {
      CrmOaConfig config = this.baseService.getOne(Wrappers.lambdaQuery(CrmOaConfig.class));
      if (config == null) {
         this.baseService.save(CrmOaConfig.builder().enabled(Boolean.TRUE.equals(enabled)).build());
      } else {
         config.setEnabled(Boolean.TRUE.equals(enabled));
         this.baseService.updateById(config);
      }

      return Boolean.TRUE;
   }
}
