package com.hzchum.scim.contract.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.common.core.api.pojo.vo.StatisticsPageVO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.OutsourcingBookDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.PurchaseStandingBookDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SelfEmployedPaymentAndFinishDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierJointlyOwnedProjectDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierPaymentDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierPaymentRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PaymentCheckDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PaymentFindDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchasePaymentSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseSupplierPaymentInsourcingAddDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseSupplierPaymentSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseSupplierPaymentUpdateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SubOrderPaymentAddDtoParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface ContractSupplierPaymentBiz {
   PageVO<SupplierPaymentRecordDTO> pageOrderPayments(
      Integer purchaseType,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      String serialNumber,
      Long supplierId,
      String supplierName,
      Long projectId,
      Integer settlementStatus,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<SupplierPaymentRecordDTO> pageOrderPaymentsV2(
      Integer purchaseType,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      String serialNumber,
      Long supplierId,
      String supplierName,
      Long projectId,
      Integer settlementStatus,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> printPurchaseOrderPayInfo(
      Integer purchaseType,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      String serialNumber,
      Long supplierId,
      String supplierName,
      Integer settlementStatus
   );

   void exportPurchaseOrderPayInfoList(
      Integer purchaseType,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      String serialNumber,
      Long supplierId,
      String supplierName,
      Integer settlementStatus,
      HttpServletResponse response
   );

   PageVO pageSupplierPayments(String supplierName, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printSupplierPayments(String supplierName, LocalDate startDate, LocalDate endDate);

   PageVO<SupplierPaymentDTO> ledgerPayment(PaymentFindDTOParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printLedgerPayment(PaymentFindDTOParam param);

   PageVO listInboundRecord(
      Long purchaseId,
      Long supplierId,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      Long classifyId,
      String classifyName,
      String purchaseSn,
      Long inboundId,
      String inboundSn,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO listInboundRecordV2(
      Long purchaseId,
      Long supplierId,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      Long classifyId,
      String classifyName,
      String purchaseSn,
      Long inboundId,
      String inboundSn,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> printInboundRecord(
      Long purchaseId,
      Long supplierId,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      Long classifyId,
      String classifyName,
      String purchaseSn,
      Long inboundId,
      String inboundSn
   );

   StatisticsPageVO supplierOrAcceptanceRecord(
      String year, Long supplierId, Long classifyId, Long purchaseOrderId, List<LocalDateTime> inboundTime, Integer pageNumber, Integer pageSize, int type
   );

   void supplierAndAcceptanceExport(
      String year, Long supplierId, Long classifyId, Long purchaseOrderId, List<LocalDateTime> dates, int type, HttpServletResponse response
   );

   void supplierAndAcceptanceExportV2(
      String year, Long supplierId, Long classifyId, Long purchaseOrderId, List<LocalDateTime> dates, int type, HttpServletResponse response
   );

   Map<String, BigDecimal> supplierReconciliationSummary(String year, Long supplierId);

   Map<String, BigDecimal> supplierReconciliationSummaryV2(String year, Long supplierId);

   PageVO<SupplierPaymentDTO> listPayment(
      Long orderId,
      Integer propertyType,
      Long paymentUnitId,
      Long supplierId,
      Integer auditStatus,
      LocalDate startDate,
      LocalDate endDate,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> printPaymentList(
      Long orderId, Integer propertyType, Long paymentUnitId, Long supplierId, Integer auditStatus, LocalDate startDate, LocalDate endDate
   );

   Boolean saveSupplierPayment(PurchaseSupplierPaymentSaveDTOParam param);

   Boolean auditSupplierPayment(PaymentCheckDTOParam param);

   Boolean updatePayment(PurchaseSupplierPaymentUpdateDTOParam param);

   Boolean deletePayment(List<Long> ids);

   Boolean addSelfOwned(PurchasePaymentSaveParam param);

   ResultVO addOaSelfOwned(PurchasePaymentSaveParam param);

   List<SupplierJointlyOwnedProjectDto> getProjectByManagerId(Long projectManagerId);

   Map<Long, String> getSupplierByManagerIdAndProjectId(Long projectManagerId, Long projectId);

   Boolean addSupplierPayment(PurchaseSupplierPaymentInsourcingAddDTOParam param);

   void deductProjectMoney(ContractProject project, SupplierPayment supplierPayment);

   ResultVO addOaSupplierPayment(PurchaseSupplierPaymentInsourcingAddDTOParam param);

   Map<Long, String> getSupplierNumber(Long projectManagerId, Long projectId, Long supplierId);

   PageVO<PurchaseStandingBookDTO> listInboundV2(
      Long supplierId, Integer settlementStatus, String serialNumber, Integer basicClass, Long branchCompanyId, Integer pageNumber, Integer pageSize
   );

   PageVO<OutsourcingBookDTO> outsourcingList(
      LocalDateTime year, Integer type, String serialNumber, String projectName, String supplierName, Integer pageNumber, Integer pageSize
   );

   Boolean addPacketsPayment(PurchaseSupplierPaymentInsourcingAddDTOParam param);

   SelfEmployedPaymentAndFinishDTO getPaymentDetailById(List<Long> orderIds);

   Boolean addSelfOwnedSubcontractPayment(SubOrderPaymentAddDtoParam param);

   Map<Long, String> getSubcontractSupplierInfo(Long supplierId, Long projectId, Boolean boolSettleUse);

   Map<String, BigDecimal> assetInjectionCheck(Long projectId);
}
