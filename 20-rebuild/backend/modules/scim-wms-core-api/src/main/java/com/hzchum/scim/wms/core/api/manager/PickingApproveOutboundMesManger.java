package com.hzchum.scim.wms.core.api.manager;

import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsPickingApproveDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPickingApproveDetailDTOParam;
import java.util.List;

public interface PickingApproveOutboundMesManger {
   Boolean boolComplete(Long id);

   List<WmsPickingApproveDetailDTO> getPickingApproveDetail(QueryPickingApproveDetailDTOParam param);

   Boolean yesProcess(List<Long> ids);

   Boolean notProcess(List<Long> ids);
}
