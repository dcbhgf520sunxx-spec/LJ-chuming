package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesStatisticsModeConfig;
import com.hzchum.scim.system.core.api.pojo.request.MesStatisticsModeConfigSaveDTOParam;

public interface MesStatisticsModeConfigService extends IService<MesStatisticsModeConfig> {
   MesStatisticsModeConfig getInfo();

   Boolean editStatisticsModeConfig(MesStatisticsModeConfigSaveDTOParam param);
}
