package com.hzchum.scim.contract.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.contract.core.api.pojo.dto.LogisticsPaymentInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.LogisticsStandingBookDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.LogisticsSupplierSummaryDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.LogisticsSupplierPaymentSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.LogisticsSupplierPaymentUpdateDTOParam;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface LogisticsBiz {
   PageVO<LogisticsDTO> summary(Integer type, String name, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize);

   PageVO<LogisticsStandingBookDTO> showLogisticsLedger(
      Integer executeStatus, Integer type, Integer level, LocalDate date, Integer pageNumber, Integer pageSize
   );

   PageVO<LogisticsRecordDTO> record(
      Integer type,
      Long id,
      Long branchCompanyId,
      Long supplierId,
      Integer changeFreight,
      LocalDate startDate,
      LocalDate endDate,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO printRecord(Integer type, Long id, Long branchCompanyId, Long supplierId, Integer changeFreight, LocalDate startDate, LocalDate endDate);

   ListVO<LogisticsDTO> summaryPaymentAndInvoice(String name);

   PageVO<LogisticsSupplierSummaryDTO> listSummaryOnSupplier(Integer year, String supplierName, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printSummaryOnSupplier(Integer year, String supplierName);

   ListVO<LogisticsPaymentInfoDTO> listBySupplierIdAndBranchCompanyId(Long supplierId, Long branchCompanyId);

   Boolean saveLogisticsPayment(LogisticsSupplierPaymentSaveDTOParam saveDTOParam);

   Boolean updateLogisticsPayment(LogisticsSupplierPaymentUpdateDTOParam updateDTOParam);

   ListVO<LogisticsPaymentInfoDTO> listBySupplierId(Long supplierId, Long branchCompanyId);

   PageVO<LogisticsV2DTO> summaryV2(Integer type, Integer settlementStatus, Integer year, Integer branchCompanyId, Integer pageNumber, Integer pageSize);

   void loadingChargeExport(
      LocalDateTime passStartDate,
      LocalDateTime passEndDate,
      String licensePlate,
      String inboundSN,
      String purchaseOrderSN,
      String userName,
      HttpServletResponse response
   );

   PageVO<LogisticsLedgerDTO> getMaterialFlowLedger(
      Integer year, Integer statusEnum, Integer propertyType, Long branchCompanyId, Integer pageNumber, Integer pageSize
   );
}
