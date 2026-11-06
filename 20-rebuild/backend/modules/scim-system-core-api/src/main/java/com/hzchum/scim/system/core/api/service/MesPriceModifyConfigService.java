package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesPriceModifyConfig;
import com.hzchum.scim.system.core.api.pojo.request.MesPriceModifyConfigSaveDTOParam;

public interface MesPriceModifyConfigService extends IService<MesPriceModifyConfig> {
   MesPriceModifyConfig getInfo();

   Boolean editPriceModifyConfig(MesPriceModifyConfigSaveDTOParam param);

   Boolean isConfigured();
}
