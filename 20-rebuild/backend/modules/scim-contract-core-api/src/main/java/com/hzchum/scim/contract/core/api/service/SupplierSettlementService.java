package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierSettlement;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SelfEmployedSettlement;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementInvoiceDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseSettlementSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SubOrderSettlementAddParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierSettlementSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierSettlementUpdateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierSettlementAddDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

public interface SupplierSettlementService extends IService<SupplierSettlement> {
   PageVO<SupplierSettlementDTO> listSupplierSettlement(Long orderId, Integer orderClass, Integer auditStatus, Integer pageNumber, Integer pageSize);

   Boolean saveSupplierSettlement(SupplierSettlementSaveDTOParam param);

   Boolean updateSupplierSettlement(SupplierSettlementUpdateDTOParam updateDTOParam);

   Boolean delSupplierSettlement(Long id);

   Boolean checkSupplierSettlement(Long id, Integer auditStatus);

   BigDecimal getSettlementAmountBySupplierId(Long supplierId);

   Map<Long, BigDecimal> getSupplierSettlementAmountMap(Integer orderClass, Collection<Long> supplierIds, LocalDate startDate, LocalDate endDate);

   Boolean saveSelfEmployed(PurchaseSettlementSaveParam param);

   ResultVO addOaSupplierSettlement(SubOrderSettlementAddParam param);

   ResultVO addOaSupplierSettlement(SupplierSettlementAddDTOParam param);

   SelfEmployedSettlement getSupplierSettlement(Long orderId);

   ResultVO saveOaSelfEmployed(PurchaseSettlementSaveParam param);

   Boolean saveSubcontractOrder(SubOrderSettlementAddParam param);

   SelfEmployedSettlement getSubcontractOrder(Long orderId);

   Boolean update(Long id);

   BigDecimal getAount(Long id);

   SupplierSettlementInvoiceDto getSupplierSettlementInner(
      Long projectId, Long projectManagerId, Long supplierId, String purchaseContractNumber, Integer pageNumber, Integer pageSize
   );
}
