package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.common.ReceiptMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.QuantityMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReconciliationDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPurchaseInboundDetailDTOParam;
import java.util.List;

public interface InboundDetailManufacturedService extends IService<InboundDetailManufactured> {
   List<InboundDetailManufactured> selectList(QueryInboundManufacturedDTOParam queryDTOParam);

   List<InboundDetailManufacturedDTO> convertDetailDto(List<InboundDetailManufactured> inboundDetailManufactureds);

   QuantityMeteDTO getCountMete(Long purchaseId, List<Integer> status);

   List<InboundDetailManufactured> getListByApplyPurchaseId(Long applyPurchaseId);

   QuantityMeteDTO getPassQuantity(Long purchaseDetailId);

   List<InboundDetailManufactured> selectPassDetailByPurchaseDetailIds(List<Long> purchaseDetailIds);

   List<InboundDetailManufactured> getInboundDetailManufacturedList(Long purchaseId, Long purchaseDetailId, Integer reviewStatus);

   List<ReconciliationDetailDTO> orderReconciliationDetail(QueryPurchaseInboundDetailDTOParam queryDTOParam);

   List<ReceiptMeteDTO> getPurchaseRejectMete(List<Long> purchaseIds);
}
