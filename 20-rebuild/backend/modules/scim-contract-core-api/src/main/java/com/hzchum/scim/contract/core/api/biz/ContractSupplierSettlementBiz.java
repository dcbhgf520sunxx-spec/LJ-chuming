package com.hzchum.scim.contract.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SelfEmployedSettlement;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseSettlementSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SubOrderSettlementAddParam;

public interface ContractSupplierSettlementBiz {
   Boolean saveSelfEmployed(PurchaseSettlementSaveParam param);

   ResultVO saveOaSelfEmployed(PurchaseSettlementSaveParam param);

   SelfEmployedSettlement getSupplierSettlement(Long orderId);

   Boolean saveSubcontractOrder(SubOrderSettlementAddParam param);

   SelfEmployedSettlement getSubcontractOrder(Long orderId);

   Boolean saveSubcontractOrderPre(SubOrderSettlementAddParam param);
}
