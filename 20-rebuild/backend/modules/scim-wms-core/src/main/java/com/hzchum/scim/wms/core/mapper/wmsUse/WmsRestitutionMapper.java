package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsRestitution;
import java.time.LocalDateTime;

public interface WmsRestitutionMapper extends BaseMapper<WmsRestitution> {
   Integer getCount(LocalDateTime date);
}
