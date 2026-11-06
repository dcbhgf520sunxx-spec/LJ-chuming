package com.hzchum.scim.contract.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.contract.core.api.pojo.dto.SupplierSettlementDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierListDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseInvoiceSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SubOrderInvoiceAddParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierInvoiceAddDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierInvoiceSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierInvoiceUpdateDTOParam;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ContractSupplierInvoiceBiz {
   PageVO<SupplierInvoiceDTO> pageListInvoiceByCondition(
      Long orderId, Integer propertyType, Long supplierId, Integer auditStatus, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> printInvoiceByCondition(
      Long orderId, Integer propertyType, Long supplierId, Integer auditStatus, LocalDate startDate, LocalDate endDate
   );

   ListVO<SupplierInvoiceDTO> listInvoiceByUnitId(Long branchCompanyId, Long supplierId, Integer auditStatus);

   PrintVO<List<Map<String, Object>>> printInvoiceByUnitId(Long branchCompanyId, Long supplierId, Integer auditStatus);

   Boolean saveSupplierInvoice(List<SupplierInvoiceSaveDTOParam> params);

   Boolean updateSupplierInvoice(SupplierInvoiceUpdateDTOParam param);

   Boolean auditSupplierInvoice(Long id, Integer auditStatus);

   Boolean deleteById(Long id);

   Boolean addSupplierInvoiceSelfOwned(PurchaseInvoiceSaveParam param);

   List<SupplierSettlementDto> getPaymentSelfOwnedList(Long orderId);

   SupplierSettlementDto getSubcontractSelfList(Long orderId, Long auditId);

   Boolean saveSubOrderInvoice(SubOrderInvoiceAddParam param);

   Boolean AddSupplierInvoice(SupplierInvoiceAddDTOParam param);

   List<SupplierListDto> getPurchase(Long projectId, Long supplierId);

   Boolean auditSubcontractInvoice(SupplierInvoiceAddDTOParam params);

   List<SupplierListDto> getSubcontractPaymentList(Long orderId);
}
