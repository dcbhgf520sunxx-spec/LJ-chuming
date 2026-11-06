package com.hzchum.scim.wms.core.api.service.wmsConfig;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelConfig;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SectionSteelDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.BatchSectionSteelDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.SectionSteelDTOParam;

public interface SectionSteelConfigService extends IService<SectionSteelConfig> {
   PageVO<SectionSteelDTO> listInfo();

   Boolean sectionSteelUpdate(SectionSteelDTOParam param);

   Boolean BatchSectionSteelUpdate(BatchSectionSteelDTOParam param);
}
