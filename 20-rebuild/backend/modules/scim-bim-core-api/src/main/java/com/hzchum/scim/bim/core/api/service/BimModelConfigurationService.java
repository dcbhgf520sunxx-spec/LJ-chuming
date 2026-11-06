package com.hzchum.scim.bim.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelConfigurationDO;
import com.hzchum.scim.bim.core.api.pojo.dto.BimModelConfigurationDTO;
import com.hzchum.scim.bim.core.api.pojo.vo.BimModelConfigurationVO;

public interface BimModelConfigurationService extends IService<BimModelConfigurationDO> {
   BimModelConfigurationVO getModelConfigure(Long monomerId);

   Boolean setModelConfigure(BimModelConfigurationDTO configurationDTO);
}
