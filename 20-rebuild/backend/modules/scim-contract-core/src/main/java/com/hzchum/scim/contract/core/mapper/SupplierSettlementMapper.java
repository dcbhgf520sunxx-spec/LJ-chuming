package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierSettlement;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Param;

public interface SupplierSettlementMapper extends BaseMapper<SupplierSettlement> {
   BigDecimal selectSettlementAmount(@Param("supplierId") Long supplierId);

   Boolean update(@Param("id") Long id);

   BigDecimal getAount(@Param("id") Long id);
}
