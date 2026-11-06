package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaSupplierPaymentDataIdDTO;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsInvoiceDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsPaymentDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dto.project.ProjectSupplierDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.PaymentDetailDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectLedgerSupplierInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SelfEmployedPaymentAndFinishDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierListDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierPaymentDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.LogisticsInvoiceSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SporadicLogisticsSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierPaymentSaveDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.annotations.Param;

public interface SupplierPaymentService extends IService<SupplierPayment> {
   List<SupplierPayment> listByCondition(
      Long orderId, Integer propertyType, Long paymentUnitId, Long supplierId, Integer auditStatus, LocalDate startDate, LocalDate endDate
   );

   SupplierPayment getLastPayment(Long orderId, Integer propertyType, Long paymentUnitId, Long receivingUnitId);

   List<LogisticsDTO> summary(Integer type, String name, LocalDate startDate, LocalDate endDate, List<Long> projectIds);

   List<LogisticsRecordDTO> record(Integer type, Long id, Long branchCompanyId, Long supplierId, Integer changeFreight, LocalDate startDate, LocalDate endDate);

   Map<String, Object> detail(String projectName, Long supplierId, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize);

   Map<String, Object> showAll(Integer settlementStatus, String supplierName, Integer auditStatus, Integer pageNumber, Integer pageSize);

   LogisticsPaymentDetailDTO paymentDetails(Long supplierId);

   LogisticsInvoiceDetailDTO invoicePayment(Long supplierId);

   Boolean saveLogisticsPayment(SupplierPaymentSaveDTOParam saveDTOParam);

   Boolean saveLogisticsInvoice(LogisticsInvoiceSaveDTOParam saveDTOParam);

   Boolean saveSporadicLogistics(SporadicLogisticsSaveDTOParam saveDTOParam);

   List<LogisticsDTO> summaryPaymentAndInvoice(String name);

   BigDecimal getSumPaymentAmount(
      @Param("supplierId") Long supplierId,
      @Param("propertyType") Integer propertyType,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate
   );

   BigDecimal getSumPayment(Long supplierId, Long paymentUnitId, Integer propertyType, Integer type, Long id);

   BigDecimal getSumPayment(Long supplierId, Long paymentUnitId, Integer propertyType);

   Boolean exportPaymentList(
      Long orderId,
      Integer propertyType,
      Long paymentUnitId,
      Long supplierId,
      Integer auditStatus,
      LocalDate startDate,
      LocalDate endDate,
      HttpServletResponse response
   );

   List<Map<String, Object>> listPaymentMap(
      Long orderId, Integer propertyType, Long paymentUnitId, Long supplierId, Integer auditStatus, LocalDate startDate, LocalDate endDate
   );

   SupplierPaymentDTO getDetailById(Long id);

   BigDecimal getPurchasePaymentSum(Long orderId, Long supplierId, LocalDate startDate, LocalDate endDate);

   BigDecimal getBreachAmountSum(Long orderId, Integer propertyType, Long supplierId);

   BigDecimal getOrderPaymentSum(Long orderId, Integer propertyType);

   BigDecimal getPaidPaymentAmount(Long orderId, Integer propertyType);

   Map<Long, BigDecimal> getSupplierPaymentAmountMap(Integer propertyType, Collection<Long> supplierIds, LocalDate startDate, LocalDate endDate);

   Map<Long, String> getSupplierList();

   Map<Long, String> getPaymentDetailList(Long supplierId, Boolean boolSettleUse, Boolean boolPreSettleUse);

   SelfEmployedPaymentAndFinishDTO getSupplierPaymentList(List<Long> orderIds);

   ProjectLedgerSupplierInvoiceDTO projectPaymentDetailList(Long projectId, Long supplierId, Long orderId, Integer incomeExpendType);

   PrintVO projectPaymentDetailListPrint(Long projectId, Long supplierId, Long orderId, Integer incomeExpendType);

   List<SupplierListDto> getPaymentDetailById(Long projectId, Long supplierId);

   PageVO<PaymentDetailDto> getDetailList(
      Long orderId, Long supplierId, Long projectManagerId, Long projectId, Integer type, Integer pageNumber, Integer pageSize
   );

   List<LogisticsV2DTO> summaryV2(Integer type, Integer settlementStatus, Integer year, Integer branchCompanyId);

   Integer getVoucherNumber();

   ProjectSupplierDto getSubcontractDetailById(Long subcontractId);

   Boolean update(Long id);

   List<OaSupplierPaymentDataIdDTO> getDataIdList(List<Long> orderIds);
}
