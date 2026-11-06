package com.hzchum.scim.scm.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchaseDetail;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Param;

public interface ApplyPurchaseDetailMapper extends BaseMapper<ApplyPurchaseDetail> {
   void updateStatus(
      @Param("detailId") Long applyPurchaseDetailId, @Param("mete") BigDecimal mete, @Param("quantity") BigDecimal quantity, @Param("status") boolean status
   );

   BigDecimal getTotalMete(Long id);
}
