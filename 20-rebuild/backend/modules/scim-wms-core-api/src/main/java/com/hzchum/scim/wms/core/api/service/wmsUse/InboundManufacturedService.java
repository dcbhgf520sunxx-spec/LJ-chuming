package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.PuchaseInboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundManufacturedDTOParam;
import java.util.List;

public interface InboundManufacturedService extends IService<InboundManufactured> {
   PageVO<InboundManufacturedDTO> pageInfo(QueryInboundManufacturedDTOParam queryDTOParam, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<InboundDetailManufacturedDTO> pageInfoDetail(QueryInboundManufacturedDTOParam queryDTOParam, Integer pageNumber, Integer pageSize, List<String> sort);

   InboundManufacturedDTO getList(Long id);

   Boolean saveInboundManufactured(InboundManufacturedDTOParam dtoParam);

   Boolean returnUpdateInboundManufactured(InboundManufacturedDTOParam dtoParam);

   Boolean revocation(Long id);

   Boolean approvalManufacturedInbound(InboundManufacturedDTOParam inboundManufacturedDTOParam, Long approveRecordId, Integer decision, String opinion);

   List<PuchaseInboundDetailDTO> orderDetailV2(Long orderId, List<Long> orderDetailIds);
}
