package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsBorrow;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundListDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchBorrowDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchBorrowReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SteelPlateOutboundDTOParam;
import java.util.List;

public interface WmsBorrowService extends IService<WmsBorrow> {
   List<OutboundListDTO> getWmsBorrowList(QueryOutboundDTOParam queryOutboundDTOParam);

   Boolean BatchBorrow(BatchBorrowDTOParam param);

   Boolean saveOutbound(SteelPlateOutboundDTOParam param);

   Boolean passed(Long id);

   Boolean saveBatchBorrowReturn(BatchBorrowReturnDTOParam param);

   Boolean passedBatchBorrowReturn(Long id);

   Boolean returnBatchBorrowReturn(Long id);

   Boolean saveBatchWastage(BatchBorrowReturnDTOParam param);

   Boolean passedBatchWastage(Long id);

   Boolean returnBatchWastage(Long id);
}
