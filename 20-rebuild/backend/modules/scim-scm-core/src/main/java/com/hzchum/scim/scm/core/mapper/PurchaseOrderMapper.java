package com.hzchum.scim.scm.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo.dto.SupplierSettlementDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.PurchaseStandingBookDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierPaymentRecordDTO;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo.dao.PurchaseOrderGroupDetailDO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderGroupMonthDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderGroupSupplierDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderSummaryDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseSupplierSummaryDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SimpleListDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.QueryPurchaseOrderDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseOrderMapper extends BaseMapper<PurchaseOrder> {
   List<PurchaseOrder> listInfo(QueryPurchaseOrderDTOParam param);

   List<SimpleListDTO> simpleListInfo();

   Integer getCountByDate();

   Integer getCountByDateNew();

   List<SupplierPaymentRecordDTO> listByCondition(
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate,
      @Param("basicClass") Integer basicClass,
      @Param("purchaseType") Integer purchaseType,
      @Param("supplierId") Long supplierId,
      @Param("supplierName") String supplierName,
      @Param("serialNumber") String serialNumber,
      @Param("projectId") Long projectId,
      @Param("settlementStatus") Integer settlementStatus
   );

   List<PurchaseSupplierSummaryDTO> listSupplierSum(
      @Param("supplierName") String supplierName, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate
   );

   List<PurchaseOrder> selectByProjectId(Long projectId);

   BigDecimal selectPurchaseAmountSum(
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate,
      @Param("supplierId") Long supplierId,
      @Param("branchCompanyId") Long branchCompanyId,
      @Param("purchaseType") Integer purchaseType
   );

   int getCountByClassId(Long classId);

   List<PurchaseOrderDTO> getSNByYear(LocalDateTime year);

   List<PurchaseOrder> listInfoV2(QueryPurchaseOrderDTOParam param);

   List<PurchaseOrder> purchaseCount(List<LocalDateTime> createTime);

   SupplierSettlementDto getPurchaseOrder(Long orderId);

   List<PurchaseStandingBookDTO> getSecondaryUnitAll(
      @Param("supplierId") Long supplierId,
      @Param("settlementStatus") Integer settlementStatus,
      @Param("serialNumber") String serialNumber,
      @Param("basicClass") Integer basicClass,
      @Param("branchCompanyId") Long branchCompanyId
   );

   PurchaseOrder getById(Long id);

   Boolean updateBoolDeleteById(Long id);

   PurchaseOrder selectAgainOrder(String serialNumber);

   Boolean update(@Param("id") Long id);

   void initUpdateOrderPlace();

   List<PurchaseOrderSummaryDTO> getPurchaseSummary(LocalDate yearDate, Long branchCompanyId);

   List<PurchaseOrderGroupMonthDTO> getGroupMonth(LocalDate yearDate, Long branchCompanyId);

   List<PurchaseOrderGroupDetailDO> getGroupDetail(LocalDate yearDate, Boolean yearGroup, Long branchCompanyId);

   List<PurchaseOrderSummaryDTO> getSupplierSummary(LocalDate yearDate, Long branchCompanyId);

   List<PurchaseOrderGroupSupplierDetailDTO> getSupplierGroupDetail(LocalDate yearDate, Long branchCompanyId);

   List<PurchaseOrder> getPurchaseOrderList(LocalDate yearDate, Long branchCompanyId, Long supplierId);

   List<PurchaseOrder> listAllByIds(List<Long> ids);
}
