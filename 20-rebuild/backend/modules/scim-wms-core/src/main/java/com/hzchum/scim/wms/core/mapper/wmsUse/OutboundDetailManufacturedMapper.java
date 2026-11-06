package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.OutboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundManufacturedDTOParam;
import java.util.List;

public interface OutboundDetailManufacturedMapper extends BaseMapper<OutboundDetailManufactured> {
   List<OutboundDetailManufactured> list(QueryOutboundManufacturedDTOParam param);
}
