package com.hzchum.scim.wms.core.api.manager;

import com.hzchum.scim.wms.core.api.pojo.dtoParam.manager.ReturnManufacturedVORequest;
import java.util.List;

public interface ReturnManufacturedMesManager {
   Boolean insertReturnManufactured(List<ReturnManufacturedVORequest> returnManufacturedVORequests);
}
