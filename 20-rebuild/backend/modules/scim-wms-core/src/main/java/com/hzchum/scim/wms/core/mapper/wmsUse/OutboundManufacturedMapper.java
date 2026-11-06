package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.OutboundManufactured;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundManufacturedDTOParam;
import java.time.LocalDateTime;
import java.util.List;

public interface OutboundManufacturedMapper extends BaseMapper<OutboundManufactured> {
   List<OutboundManufactured> list(QueryOutboundManufacturedDTOParam param);

   Integer getCount(LocalDateTime date);
}
