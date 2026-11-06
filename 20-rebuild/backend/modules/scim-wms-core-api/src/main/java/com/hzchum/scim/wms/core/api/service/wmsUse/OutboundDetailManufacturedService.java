package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.OutboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundManufacturedDTOParam;
import java.util.List;

public interface OutboundDetailManufacturedService extends IService<OutboundDetailManufactured> {
   List<OutboundDetailManufactured> selectList(QueryOutboundManufacturedDTOParam param);

   List<OutboundDetailManufacturedDTO> convertDetailDto(List<OutboundDetailManufactured> outboundDetailManufactureds);
}
