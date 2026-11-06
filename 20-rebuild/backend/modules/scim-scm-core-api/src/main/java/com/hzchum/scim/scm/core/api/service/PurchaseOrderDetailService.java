package com.hzchum.scim.scm.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import java.math.BigDecimal;
import java.util.List;

public interface PurchaseOrderDetailService extends IService<PurchaseOrderDetail> {
   void updateInboundMete(Long purchaseOrderDetailId, BigDecimal mete, BigDecimal quantity);

   List<PurchaseOrderDetail> selectPassDetailByApplyDetailIds(List<Long> applyDetailIds);
}
