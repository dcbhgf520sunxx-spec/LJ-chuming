package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.RejectDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.RejectDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.ReceiptMeteDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface RejectDetailService extends IService<RejectDetail> {
   List<RejectDetail> selectPassDetailByInboundDetailIds(List<Long> inboundDetailIds);

   List<ReceiptMeteDTO> getPurchaseRejectMete(List<Long> purchaseIds);

   List<RejectDetailDO> selectPassDetail(Long workshopId, LocalDateTime startDay, LocalDateTime endDay);
}
