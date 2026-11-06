package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.MesSafetyClassConfig;
import com.hzchum.scim.system.core.api.pojo.dto.config.ChangStatusDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesSafetyClassConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesSafetyClassConfigSaveDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesSafetyClassConfigTreeDTO;
import java.util.List;

public interface MesSafetyClassConfigService extends IService<MesSafetyClassConfig> {
   PageVO<MesSafetyClassConfigDTO> findSafetyClassConfigList(Long safetyClassId, Integer factoryOrConstructionSite, Integer pageNumber, Integer pageSize);

   Boolean saveFirstClassConfig(MesSafetyClassConfigSaveDTO classConfig);

   Boolean updateConfig(MesSafetyClassConfigDTO classConfig);

   Boolean delClassConfig(Long classConfigId);

   Boolean changeState(ChangStatusDTO classConfig);

   List<MesSafetyClassConfigTreeDTO> findsSafetyClassConfigTree(Integer type, Integer factoryOrConstructionSite);
}
