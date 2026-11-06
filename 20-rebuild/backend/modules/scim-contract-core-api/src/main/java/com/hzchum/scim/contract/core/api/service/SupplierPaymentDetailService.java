package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPaymentDetail;
import java.math.BigDecimal;

public interface SupplierPaymentDetailService extends IService<SupplierPaymentDetail> {
   BigDecimal getApplyAmount(Integer type, Long projectId, Long purchaseId, Long paymentUnitId, Long receivingUnitId);
}
