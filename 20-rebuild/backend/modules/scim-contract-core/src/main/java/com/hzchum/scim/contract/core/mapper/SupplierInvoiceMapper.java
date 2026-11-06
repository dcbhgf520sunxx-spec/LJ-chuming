package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierInvoiceMapper extends BaseMapper<SupplierInvoice> {
   List<SupplierInvoice> selectByCondition(
      @Param("orderId") Long orderId,
      @Param("propertyType") Integer propertyType,
      @Param("supplierId") Long supplierId,
      @Param("auditStatus") Integer auditStatus,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate
   );

   BigDecimal sumInvoiceAmount(
      @Param("supplierId") Long supplierId,
      @Param("propertyType") Integer propertyType,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate
   );

   BigDecimal selectSumInvoice(
      @Param("orderId") Long orderId,
      @Param("supplierId") Long supplierId,
      @Param("propertyType") Integer propertyType,
      @Param("branchCompanyId") Long branchCompanyId
   );

   BigDecimal selectPurchaseInvoiceSum(@Param("supplierId") Long supplierId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
