package com.hzchum.scim.wms.core.mapper.wmsConfig;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warning;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.WarningDTO;
import java.util.List;

public interface WarningMapper extends BaseMapper<Warning> {
   List<WarningDTO> list(Long workshopId, Long classificationId, List<Long> ids, String specification);
}
