package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaSupplierPaymentDataIdDTO;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierListDto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierPaymentMapper extends BaseMapper<SupplierPayment> {
   List<SupplierPayment> selectByCondition(
      @Param("orderId") Long orderId,
      @Param("propertyType") Integer propertyType,
      @Param("paymentUnitId") Long paymentUnitId,
      @Param("supplierId") Long supplierId,
      @Param("auditStatus") Integer auditStatus,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate
   );

   BigDecimal selectPayAmountSum(
      @Param("supplierId") Long supplierId,
      @Param("orderId") Long orderId,
      @Param("propertyTypeList") List<Integer> propertyTypeList,
      @Param("auditStatus") Integer auditStatus
   );

   BigDecimal getPaidPaymentAmount(@Param("orderId") Long orderId, @Param("propertyType") Integer propertyType);

   SupplierPayment getLastPayment(
      @Param("orderId") Long orderId,
      @Param("propertyType") Integer propertyType,
      @Param("paymentUnitId") Long paymentUnitId,
      @Param("receivingUnitId") Long receivingUnitId
   );

   List<LogisticsDTO> summary(
      @Param("type") Integer type,
      @Param("name") String name,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate,
      @Param("projectIds") List<Long> projectIds
   );

   List<LogisticsRecordDTO> record(
      @Param("type") Integer type,
      @Param("id") Long id,
      @Param("branchCompanyId") Long branchCompanyId,
      @Param("supplierId") Long supplierId,
      @Param("changeFreight") Integer changeFreight,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate
   );

   List<LogisticsDetailDTO> material(
      @Param("projectName") String projectName,
      @Param("supplierId") Long supplierId,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate
   );

   List<LogisticsDetailDTO> manufacturedGoods(
      @Param("projectName") String projectName,
      @Param("supplierId") Long supplierId,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate
   );

   List<LogisticsDTO> summaryPaymentAndInvoice(String name);

   BigDecimal sumLedgerPayment(
      @Param("supplierId") Long supplierId,
      @Param("propertyType") Integer propertyType,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate
   );

   BigDecimal getSumPayment(@Param("supplierId") Long supplierId, @Param("paymentUnitId") Long paymentUnitId, @Param("propertyType") Integer propertyType);

   BigDecimal selectSumPayment(
      @Param("supplierId") Long supplierId,
      @Param("paymentUnitId") Long paymentUnitId,
      @Param("propertyType") Integer propertyType,
      @Param("type") Integer type,
      @Param("id") Long id
   );

   BigDecimal selectPurchasePaymentSum(
      @Param("orderId") Long orderId, @Param("supplierId") Long supplierId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate
   );

   BigDecimal selectBreachAmountSum(@Param("orderId") Long orderId, @Param("propertyType") Integer propertyType, @Param("supplierId") Long supplierId);

   List<SupplierPayment> selectEchoList(Long projectId, Long projectManagerId, Long supplierId, String purchaseContractNumber);

   List<SupplierListDto> getList(Long projectId, Long supplierId);

   List<LogisticsV2DTO> summaryV2(Integer type, Integer settlementStatus, Integer year, Integer branchCompanyId);

   Integer getVoucherNumber();

   Boolean update(Long id);

   List<OaSupplierPaymentDataIdDTO> getDataIdList(@Param("ids") List<Long> ids);
}
