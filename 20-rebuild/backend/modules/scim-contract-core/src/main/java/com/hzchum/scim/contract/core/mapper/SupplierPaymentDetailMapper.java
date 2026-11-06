package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPaymentDetail;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Param;

public interface SupplierPaymentDetailMapper extends BaseMapper<SupplierPaymentDetail> {
   BigDecimal selectApplyAmount(
      @Param("type") Integer type,
      @Param("projectId") Long projectId,
      @Param("purchaseId") Long purchaseId,
      @Param("paymentUnitId") Long paymentUnitId,
      @Param("receivingUnitId") Long receivingUnitId
   );
}
