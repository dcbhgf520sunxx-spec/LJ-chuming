package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.OutboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AppOutboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundListDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.OutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SteelPlateOutboundDTOParam;
import java.util.List;

public interface WmsAppService {
   PageVO<OutboundDetailDO> getOutboundDetail(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   Boolean saveOutbound(SteelPlateOutboundDTOParam param);

   MaterialInventoryDTO getOutboundMaterial(String barcode);

   Boolean outPassed(OutboundDTOParam param);

   Boolean outReturned(Long id);

   OutboundDTO getByCurrentUser();

   Boolean outDeleteById(Long listId, Long materialId);

   PageVO<OutboundListDTO> outboundList(QueryOutboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   OutboundDTO getOutboundDetail(Long id);

   AppOutboundDTO getQuantity();
}
