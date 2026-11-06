package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesEnclosureWageConfig;
import com.hzchum.scim.system.core.api.pojo.request.MesEnclosureWageConfigSaveDTOParam;
import java.util.List;

public interface MesEnclosureWageConfigService extends IService<MesEnclosureWageConfig> {
   List<MesEnclosureWageConfig> listInfo();

   MesEnclosureWageConfig detailById(Long id);

   Boolean saveEnclosureWageConfig(MesEnclosureWageConfigSaveDTOParam param);

   Boolean editEnclosureWageConfig(MesEnclosureWageConfigSaveDTOParam param);

   Boolean updateStatus(Long id, Boolean status);

   Boolean deleteEnclosureWageConfigById(Long id);
}
