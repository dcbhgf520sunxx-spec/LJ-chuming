package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.SysInventoryConfiguration;
import com.hzchum.scim.system.core.api.pojo.dto.InventoryConfigurationDTO;
import com.hzchum.scim.system.core.api.pojo.vo.InventoryConfigurationVO;

public interface SysInventoryConfigurationService extends IService<SysInventoryConfiguration> {
   Boolean saveInventoryConfiguration(InventoryConfigurationVO configurationVO);

   Boolean updateInventoryConfiguration(InventoryConfigurationVO configurationVO);

   PageVO<InventoryConfigurationDTO> getInventoryConfigurationList(Boolean boolGeneralConfig, Long projectId, Integer pageNumber, Integer pageSize);

   InventoryConfigurationDTO getInventoryConfigurationList(Long projectId);

   Boolean deleteInventoryConfiguration(Long projectId);
}
