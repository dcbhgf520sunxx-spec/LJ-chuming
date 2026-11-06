package com.hzchum.scim.contract.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSummaryCargoListDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSummaryLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSummaryLogisticsOrderDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSummaryPurchaseOrderDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSummarySubOrderDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierSummaryLedgerQueryParam;
import java.util.List;

public interface ContractSupplierSummaryBiz {
   List<SupplierSummaryLedgerDTO> listSupplierLedger(SupplierSummaryLedgerQueryParam param);

   PrintVO<List<SupplierSummaryLedgerDTO>> printSupplierLedgerList(SupplierSummaryLedgerQueryParam param);

   PageVO<SupplierSummaryPurchaseOrderDTO> purchaseOrderPageList(Long supplierId, Integer pageNumber, Integer pageSize);

   PrintVO<List<SupplierSummaryPurchaseOrderDTO>> purchaseOrderListPrint(Long supplierId);

   PageVO<SupplierSummarySubOrderDTO> subOrderPageList(Long supplierId, Integer pageNumber, Integer pageSize);

   PrintVO<List<SupplierSummarySubOrderDTO>> subOrderListPrint(Long supplierId);

   PageVO<SupplierSummaryCargoListDTO> cargoListPageList(Long supplierId, Integer pageNumber, Integer pageSize);

   PrintVO<List<SupplierSummaryCargoListDTO>> cargoListPrint(Long supplierId);

   PageVO<SupplierSummaryLogisticsOrderDTO> logisticsPageList(Long supplierId, Integer pageNumber, Integer pageSize);

   PrintVO<List<SupplierSummaryLogisticsOrderDTO>> logisticsListPrint(Long supplierId);
}
