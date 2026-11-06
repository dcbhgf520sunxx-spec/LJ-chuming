package com.hzchum.scim.scm.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.ReceiptMeteDTO;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseOrderDetailMapper extends BaseMapper<PurchaseOrderDetail> {
   void updateInboundMete(Long purchaseOrderDetailId, BigDecimal mete, BigDecimal quantity);

   List<PurchaseOrderDetail> getUnderReviewDetailsByApplyId(@Param("applyPurchaseDetail") Long applyPurchaseDetail);

   List<PurchaseOrderDetail> selectPassDetailByApplyDetailIds(@Param("applyDetailIds") List<Long> applyDetailIds);

   List<ReceiptMeteDTO> getPurchaseRejectMete(List<Long> purchaseIds);
}
