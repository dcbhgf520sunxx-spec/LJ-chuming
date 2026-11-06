package com.hzchum.scim.scm.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LoadingChargeRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsHomeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.LogisticsSupplierSummaryDTO;
import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import com.hzchum.scim.scm.core.api.pojo.dto.LogisticsOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderFreightDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierPayableSummaryDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.QueryLogisticsOrderDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogisticsOrderMapper extends BaseMapper<LogisticsOrder> {
   List<LogisticsOrderDTO> listInfo(QueryLogisticsOrderDTOParam param);

   Integer getCreateCount();

   List<LogisticsSupplierSummaryDTO> selectSummaryOnSupplier(@Param("year") Integer year, @Param("supplierName") String supplierName);

   List<LogisticsHomeDTO> showAll(@Param("supplierName") String supplierName);

   List<PurchaseOrderFreightDTO> selectSumLogisticsFeeList(
      @Param("purchaseId") Long purchaseId, @Param("supplierId") Long supplierId, @Param("branchCompanyId") Long branchCompanyId
   );

   BigDecimal selectLogisticsFee(
      @Param("purchaseId") Long purchaseId,
      @Param("branchCompanyId") Long branchCompanyId,
      @Param("supplierId") Long supplierId,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate
   );

   List<SupplierPayableSummaryDTO> selectPayableList(
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate,
      @Param("supplierName") String supplierName,
      @Param("payable") Integer payable,
      @Param("isTaxArrears") Integer isTaxArrears
   );

   List<LoadingChargeRecordDTO> recordLoadingCharge(
      @Param("passStartDate") LocalDateTime passStartDate,
      @Param("passEndDate") LocalDateTime passEndDate,
      @Param("licensePlate") String licensePlate,
      @Param("inboundSN") String inboundSN,
      @Param("purchaseOrderSN") String purchaseOrderSN,
      @Param("userName") String userName
   );

   BigDecimal loadingChargeCount(
      LocalDateTime passStartDate, LocalDateTime passEndDate, String licensePlate, String inboundSN, String purchaseOrderSN, String userName
   );
}
