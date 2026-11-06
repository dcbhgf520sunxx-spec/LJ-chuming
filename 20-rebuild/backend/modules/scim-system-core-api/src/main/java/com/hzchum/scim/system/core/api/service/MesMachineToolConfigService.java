package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.MesMachineToolConfig;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesMachineToolConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesMachineToolConfigSaveDTO;

public interface MesMachineToolConfigService extends IService<MesMachineToolConfig> {
   PageVO<MesMachineToolConfigDTO> findMachineToolConfigList(MesMachineToolConfigDTO toolConfig, Integer pageNumber, Integer pageSize);

   Boolean saveConfig(MesMachineToolConfigSaveDTO toolConfig);

   Boolean updateConfigStatus(MesMachineToolConfigSaveDTO toolConfig);

   Boolean delToolConfig(Long toolConfigId);
}
