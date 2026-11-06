package com.hzchum.scim.wms.core.api.manager;

import com.hzchum.scim.wms.core.api.pojo.dtoParam.manager.OutboundManufacturedVORequest;
import java.util.List;

public interface OutboundManufacturedMesManager {
   Boolean insertOutManufactured(List<OutboundManufacturedVORequest> outboundManufacturedVORequests);
}
