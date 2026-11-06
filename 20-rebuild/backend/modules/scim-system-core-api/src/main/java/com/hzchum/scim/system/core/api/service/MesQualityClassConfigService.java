package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.MesQualityClassConfig;
import com.hzchum.scim.system.core.api.pojo.dto.config.ChangStatusDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesQualityClassConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesQualityClassConfigSaveDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesQualityClassConfigTreeDTO;
import java.util.List;

public interface MesQualityClassConfigService extends IService<MesQualityClassConfig> {
   PageVO<MesQualityClassConfigDTO> findQualityClassConfigList(Long qualityClassId, Integer factoryOrConstructionSite, Integer pageNumber, Integer pageSize);

   Boolean saveClassConfig(MesQualityClassConfigSaveDTO classConfig);

   Boolean updateConfig(MesQualityClassConfigDTO classConfig);

   Boolean delClassConfig(Long calssId);

   Boolean changeState(ChangStatusDTO classConfig);

   List<MesQualityClassConfigTreeDTO> findQualityClassConfigTree(Integer factoryOrConstructionSite);
}
