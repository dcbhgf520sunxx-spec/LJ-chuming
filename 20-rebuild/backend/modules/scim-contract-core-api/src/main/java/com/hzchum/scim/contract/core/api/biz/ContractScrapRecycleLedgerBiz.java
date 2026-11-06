package com.hzchum.scim.contract.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractRecycleInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractRecyclePaymentDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractReturnLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractReturnProductDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecycleInvoiceAuditParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecycleInvoiceSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecycleInvoiceUpdateParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecyclePaymentAuditParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecyclePaymentSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecyclePaymentUpdateParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ContractScrapRecycleLedgerBiz {
   List<ContractReturnLedgerDTO> listScrapRecycleLedger(LocalDate startDate, LocalDate endDate, Long branchCompanyId, String customerUnit);

   PrintVO<List<ContractReturnLedgerDTO>> printListScrapRecycleLedger(LocalDate startDate, LocalDate endDate, Long branchCompanyId, String customerUnit);

   BigDecimal getRecycleTotalAmount(Long branchCompanyId, String customerUnit);

   PageVO<ContractReturnProductDTO> pageListReturnProduct(
      Long branchCompanyId, String customerUnit, Long projectId, Integer handleMethod, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<ContractReturnProductDTO>> printListReturnProduct(Long branchCompanyId, String customerUnit, Long projectId, Integer handleMethod);

   PageVO<ContractRecyclePaymentDTO> pageListPayment(Long branchCompanyId, String customerUnit, Integer auditStatus, Integer pageNumber, Integer pageSize);

   PrintVO<List<ContractRecyclePaymentDTO>> printListPayment(Long branchCompanyId, String customerUnit, Integer auditStatus);

   Boolean saveReturnPayment(List<RecyclePaymentSaveParam> params);

   Boolean updateReturnPayment(List<RecyclePaymentUpdateParam> params);

   Boolean auditReturnPayment(RecyclePaymentAuditParam param);

   Boolean removeReturnPayment(List<Long> ids);

   PageVO<ContractRecycleInvoiceDTO> pageListInvoice(Long branchCompanyId, String customerUnit, Integer auditStatus, Integer pageNumber, Integer pageSize);

   PrintVO<List<ContractRecycleInvoiceDTO>> printListInvoice(Long branchCompanyId, String customerUnit, Integer auditStatus);

   Boolean saveInvoice(List<RecycleInvoiceSaveParam> params);

   Boolean updateInvoice(List<RecycleInvoiceUpdateParam> paramList);

   Boolean auditInvoice(RecycleInvoiceAuditParam param);

   Boolean removeInvoice(List<Long> ids);
}
