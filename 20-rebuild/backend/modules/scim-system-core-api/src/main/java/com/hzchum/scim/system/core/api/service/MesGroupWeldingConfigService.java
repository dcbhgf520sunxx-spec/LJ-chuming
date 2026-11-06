package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.MesGroupWeldingConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesGroupWeldingConfigDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesGroupWeldingConfigSaveDTOParam;
import java.util.List;

public interface MesGroupWeldingConfigService extends IService<MesGroupWeldingConfig> {
   List<MesGroupWeldingConfigDTO> listInfo();

   MesGroupWeldingConfigDTO detailById(Long id);

   Boolean saveMesGroupWeldingConfig(MesGroupWeldingConfigSaveDTOParam param);

   Boolean batchSaveMesGroupWeldingConfig(List<MesGroupWeldingConfigSaveDTOParam> paramList);

   Boolean updateMesGroupWeldingConfig(MesGroupWeldingConfigSaveDTOParam param);

   Boolean batchDelete(List<Long> idList);

   PageVO<MesGroupWeldingConfigDTO> pageInfo(Integer pageNumber, Integer pageSize);
}
