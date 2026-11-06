package com.hzchum.scim.wms.core.mapper.wmsConfig;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelSpec;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SectionSteelSpecDetailDTO;
import java.util.List;

public interface SectionSteelSpecMapper extends BaseMapper<SectionSteelSpec> {
   List<SectionSteelSpecDetailDTO> getByConfigId(Long configId, String specification);

   List<String> getSpecBySectionSteelId(Long id);
}
