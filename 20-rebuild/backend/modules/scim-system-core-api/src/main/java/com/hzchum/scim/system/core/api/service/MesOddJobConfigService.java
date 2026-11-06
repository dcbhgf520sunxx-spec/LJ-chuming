package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.MesOddJobConfig;
import com.hzchum.scim.system.core.api.pojo.request.MesOddJobConfigSaveDTOParam;
import java.util.List;

public interface MesOddJobConfigService extends IService<MesOddJobConfig> {
   PageVO<MesOddJobConfig> pageInfo(Integer pageNumber, Integer pageSize, List<String> sort);

   List<MesOddJobConfig> listInfo();

   MesOddJobConfig detailById(Long id);

   Boolean saveOddJobConfig(MesOddJobConfigSaveDTOParam param);

   Boolean editOddJobConfig(MesOddJobConfigSaveDTOParam param);

   Boolean updateStatus(Long id, Boolean status);

   Boolean deleteOddJobConfigById(Long id);
}
