package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractInvoice;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectLedgerDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectAnalysisOpenUpDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractInvoiceQueryDtoParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface ContractInvoiceService extends IService<ContractInvoice> {
   List<ContractInvoiceDTO> listInvoice(ContractInvoiceQueryDtoParam param);

   BigDecimal getInvoiceAmount(Long projectId);

   BigDecimal getSumInvoiceTax(Long projectId);

   List<ContractInvoice> selectIncomeAndExpenses(Long projectId, String remark, Integer collectionMode, LocalDate startDate, LocalDate endDate);

   List<ProjectLedgerDetailDTO> collectionAndInvoiceDetail(Long projectId);

   List<ContractInvoice> listPageLedger(Long projectId, Long invoiceUnitId);

   List<ProjectAnalysisOpenUpDTO> getAnalysisOpenUpDetails(Long projectId, Long branchCompanyId);

   void getAnalysisOpenUpDetailsDownload(Long projectId, Long branchCompanyId, HttpServletResponse response);
}
