package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.project.core.api.pojo.dto.sub.SubcontractOrderPayInvoiceDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.SubOrderPaymentQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.sub.SubOrderPaymentCheckDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.sub.SubOrderPaymentDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.sub.SubOrderSettlementDTOParam;

public interface SubcontractOrderPaymentBiz {
   PageVO<SubcontractOrderPayInvoiceDTO> listSubOrderPayment(SubOrderPaymentQueryDTOParam param, Integer pageNumber, Integer pageSize);

   Boolean saveSubOrderPayment(SubOrderPaymentDTOParam param);

   Boolean updateSubOrderPayment(SubOrderPaymentDTOParam param);

   Boolean saveSubOrderSettle(SubOrderSettlementDTOParam param);

   Boolean updateSubOrderSettle(SubOrderSettlementDTOParam param);

   Boolean checkSubOrderPayment(SubOrderPaymentCheckDTOParam param);

   Boolean checkSubOrderSettle(Long id, Integer auditStatus);
}
