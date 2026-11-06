package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.OutboundManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.OutboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundManufacturedDTOParam;
import java.time.LocalDateTime;
import java.util.List;

public interface OutboundManufacturedService extends IService<OutboundManufactured> {
   PageVO<OutboundManufacturedDTO> pageInfo(QueryOutboundManufacturedDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<OutboundDetailManufacturedDTO> pageInfoDetail(QueryOutboundManufacturedDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   OutboundManufacturedDTO getOutboundById(Long id);

   Boolean save(OutboundManufacturedDTOParam param);

   Boolean saveSubmit(OutboundManufacturedDTOParam param);

   Boolean submitReview(OutboundManufacturedDTOParam param);

   Boolean review(Long approveRecordId, Integer decision, String opinion);

   Boolean revocation(Long id);

   Boolean promptlyOut(InboundManufacturedDTOParam request);

   Integer getCount(LocalDateTime dateTime);

   Boolean deleteOut(Long id);

   Boolean deleteOutDetail(Long id);
}
