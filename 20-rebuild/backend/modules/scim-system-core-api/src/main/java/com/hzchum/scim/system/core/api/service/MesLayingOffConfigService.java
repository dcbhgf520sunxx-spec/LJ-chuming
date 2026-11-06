package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.MesLayingOffConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesLayingOffConfigDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesLayingOffConfigSaveDTOParam;
import java.util.List;

public interface MesLayingOffConfigService extends IService<MesLayingOffConfig> {
   List<MesLayingOffConfigDTO> listInfo(Integer statisticsConfigStatisticsMode);

   MesLayingOffConfigDTO detailById(Long id);

   Boolean saveLayingOffConfig(MesLayingOffConfigSaveDTOParam param);

   Boolean batchSaveLayingOffConfig(List<MesLayingOffConfigSaveDTOParam> paramList);

   Boolean updateLayingOffConfig(MesLayingOffConfigSaveDTOParam param);

   Boolean batchDelete(List<Long> idList);

   PageVO<MesLayingOffConfigDTO> pageInfo(Integer statisticsConfigStatisticsMode, Integer pageNumber, Integer pageSize);
}
