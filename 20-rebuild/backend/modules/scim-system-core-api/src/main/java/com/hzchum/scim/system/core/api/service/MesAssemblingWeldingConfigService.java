package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.MesAssemblingWeldingConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesAssemblingWeldingConfigDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesAssemblingWeldingConfigSaveDTOParam;
import java.util.List;

public interface MesAssemblingWeldingConfigService extends IService<MesAssemblingWeldingConfig> {
   List<MesAssemblingWeldingConfigDTO> listInfo();

   MesAssemblingWeldingConfigDTO detailById(Long id);

   Boolean saveAssemblingWeldingConfig(MesAssemblingWeldingConfigSaveDTOParam param);

   Boolean updateAssemblingWeldingConfig(MesAssemblingWeldingConfigSaveDTOParam param);

   Boolean deleteById(Long id);

   PageVO<MesAssemblingWeldingConfigDTO> pageInfo(Integer pageNumber, Integer pageSize);

   Boolean batchSaveAssemblingWeldingConfig(List<MesAssemblingWeldingConfigSaveDTOParam> params);
}
