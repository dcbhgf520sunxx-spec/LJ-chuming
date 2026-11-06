package com.hzchum.scim.contract.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPaymentDetail;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentDetailService;
import com.hzchum.scim.contract.core.mapper.SupplierPaymentDetailMapper;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class SupplierPaymentDetailServiceImpl extends ServiceImpl<SupplierPaymentDetailMapper, SupplierPaymentDetail> implements SupplierPaymentDetailService {
   @Override
   public BigDecimal getApplyAmount(Integer type, Long projectId, Long purchaseId, Long paymentUnitId, Long receivingUnitId) {
      return this.baseMapper.selectApplyAmount(type, projectId, purchaseId, paymentUnitId, receivingUnitId);
   }
}
