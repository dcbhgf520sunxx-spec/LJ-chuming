package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesPartProcessConfig;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesPartProcessConfigDTO;
import java.util.List;

public interface MesPartProcessConfigService extends IService<MesPartProcessConfig> {
   List<MesPartProcessConfigDTO> listInfo();

   MesPartProcessConfigDTO detailById(Long id);

   Boolean savePartProcessConfig(MesPartProcessConfigDTO param);

   Boolean updatePartProcessConfig(MesPartProcessConfigDTO param);

   Boolean deleteById(Long id);
}
