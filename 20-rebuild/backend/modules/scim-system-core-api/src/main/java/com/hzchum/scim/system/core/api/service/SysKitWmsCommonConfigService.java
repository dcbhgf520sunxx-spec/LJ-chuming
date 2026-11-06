package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.KitWmsCommonConfigDTO;
import com.hzchum.scim.system.core.api.pojo._do.SysKitWmsCommonConfig;
import com.hzchum.scim.system.core.api.pojo.vo.KitWmsCommonConfigVO;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

public interface SysKitWmsCommonConfigService extends IService<SysKitWmsCommonConfig> {
   @Transactional(rollbackFor = TransactionException.class)
   Boolean saveKitWmsCommonConfig(KitWmsCommonConfigVO configurationVO);

   @Transactional(rollbackFor = TransactionException.class)
   Boolean updateKitWmsCommonConfig(KitWmsCommonConfigVO configurationVO);

   KitWmsCommonConfigDTO getKitWmsCommonConfigList(Boolean boolGeneralConfig, Long projectId, Integer pageNumber, Integer pageSize);

   KitWmsCommonConfigDTO getKitWmsCommonConfigList(Long projectId);

   Boolean deleteKitWmsCommonConfig(Long projectId);
}
