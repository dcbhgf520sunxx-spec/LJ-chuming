package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.MesDrillHoleConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesDrillHoleConfigDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesDrillHoleConfigSaveDTOParam;
import java.util.List;

public interface MesDrillHoleConfigService extends IService<MesDrillHoleConfig> {
   List<MesDrillHoleConfigDTO> listInfo(Integer statisticsConfigStatisticsMode);

   MesDrillHoleConfigDTO detailById(Long id);

   Boolean saveDrillHoleConfig(MesDrillHoleConfigSaveDTOParam param);

   Boolean batchSaveDrillHoleConfig(List<MesDrillHoleConfigSaveDTOParam> paramList);

   Boolean updateDrillHoleConfig(MesDrillHoleConfigSaveDTOParam param);

   Boolean batchDelete(List<Long> idList);

   PageVO<MesDrillHoleConfigDTO> pageInfo(Integer statisticsConfigStatisticsMode, Integer pageNumber, Integer pageSize);
}
