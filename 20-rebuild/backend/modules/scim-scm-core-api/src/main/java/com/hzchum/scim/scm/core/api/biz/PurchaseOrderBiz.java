package com.hzchum.scim.scm.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectPaymentAllDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.SupplierLedgerParam;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierInvoiceDetailDto;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierPaymentDetailDto;
import java.time.LocalDateTime;
import java.util.List;

public interface PurchaseOrderBiz {
   PageVO<PurchaseOrderDTO> getProjectSupplierLedger(SupplierLedgerParam param, Integer pageNumber, Integer pageSize);

   PageVO<SupplierPaymentDetailDto> getPaymentDetail(Long orderId, Integer pageNumber, Integer pageSize);

   PrintVO<List<SupplierPaymentDetailDto>> getPaymentDetailDownload(Long orderId);

   PageVO<SupplierInvoiceDetailDto> getInvoiceDetail(Long orderId, Integer pageNumber, Integer pageSize);

   PrintVO<List<SupplierInvoiceDetailDto>> getInvoiceDetailDownload(Long orderId);

   List<SupplierSettlementDTO> listSettleDetail(Long orderId, Boolean boolPreSettlement);

   PrintVO<List<SupplierSettlementDTO>> printListSettleDetail(Long orderId, Boolean boolPreSettlement);

   List<String> getOrderNumber(Integer level, Integer purchaseType, Long branchCompanyId);

   PageVO<ProjectPaymentAllDTO> projectPaymentAll(
      Long projectId, Long supplierId, String number, LocalDateTime startTime, LocalDateTime endTime, Integer pageNumber, Integer pageSize
   );

   PrintVO orderPaymentDownload(Long projectId, Long supplierId, String number, LocalDateTime startTime, LocalDateTime endTime);
}
