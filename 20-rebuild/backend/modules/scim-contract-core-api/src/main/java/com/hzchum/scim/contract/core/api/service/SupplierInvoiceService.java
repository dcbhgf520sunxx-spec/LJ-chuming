package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.InvoiceFindDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface SupplierInvoiceService extends IService<SupplierInvoice> {
   List<SupplierInvoiceDTO> listByCondition(Long orderId, Integer propertyType, Long supplierId, Integer auditStatus, LocalDate startDate, LocalDate endDate);

   List<SupplierInvoiceDTO> listInvoiceByUnitId(Long branchCompanyId, Long supplierId, Integer auditStatus);

   PageVO<SupplierInvoiceDTO> ledgerPaymentInvoice(InvoiceFindDTOParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printPaymentInvoice(InvoiceFindDTOParam param);

   BigDecimal getSumInvoiceAmount(Long supplierId, Integer propertyType, LocalDate startDate, LocalDate endDate);

   BigDecimal getInvoiceAmount(Long orderId, Long supplierId, Integer propertyType, Long branchCompanyId);

   BigDecimal getPurchaseInvoiceSum(Long supplierId, LocalDate startDate, LocalDate endDate);

   BigDecimal getOrderInvoiceSum(Long orderId, Integer propertyType);

   Map<Long, BigDecimal> getSupplierInvoiceAmountMap(Integer propertyType, Collection<Long> supplierIds, LocalDate startDate, LocalDate endDate);
}
