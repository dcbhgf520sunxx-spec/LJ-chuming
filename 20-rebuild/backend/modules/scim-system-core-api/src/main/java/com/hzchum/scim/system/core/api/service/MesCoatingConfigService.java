package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesCoatingConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesCoatingConfigDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesCoatingConfigSaveDTOParam;
import java.util.List;

public interface MesCoatingConfigService extends IService<MesCoatingConfig> {
   List<MesCoatingConfigDTO> listInfo();

   MesCoatingConfigDTO detailById(Long id);

   Boolean saveCoatingConfig(MesCoatingConfigSaveDTOParam param);

   Boolean updateCoatingConfig(MesCoatingConfigSaveDTOParam param);

   Boolean updateStatus(Long id, Boolean status);

   Boolean deleteById(Long id);
}
