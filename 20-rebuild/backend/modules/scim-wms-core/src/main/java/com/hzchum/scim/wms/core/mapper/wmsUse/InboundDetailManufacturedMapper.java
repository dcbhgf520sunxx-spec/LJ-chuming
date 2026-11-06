package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.common.ReceiptMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.QuantityMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReconciliationDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPurchaseInboundDetailDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InboundDetailManufacturedMapper extends BaseMapper<InboundDetailManufactured> {
   List<InboundDetailManufactured> list(QueryInboundManufacturedDTOParam queryDTOParam);

   QuantityMeteDTO getCountMete(@Param("purchaseId") Long purchaseId, @Param("status") List<Integer> status);

   List<InboundDetailManufactured> getByApplyPurchaseId(Long applyPurchaseId);

   QuantityMeteDTO getPassQuantity(@Param("purchaseDetailId") Long purchaseDetailId);

   List<InboundDetailManufactured> selectPassDetailByPurchaseDetailIds(@Param("purchaseDetailIds") List<Long> purchaseDetailIds);

   List<InboundDetailManufactured> getInboundDetailManufacturedList(
      @Param("purchaseId") Long purchaseId, @Param("purchaseDetailId") Long purchaseDetailId, @Param("reviewStatus") Integer reviewStatus
   );

   List<ReconciliationDetailDTO> orderReconciliationDetail(@Param("query") QueryPurchaseInboundDetailDTOParam queryDTOParam);

   List<ReceiptMeteDTO> getPurchaseRejectMete(List<Long> purchaseIds);
}
