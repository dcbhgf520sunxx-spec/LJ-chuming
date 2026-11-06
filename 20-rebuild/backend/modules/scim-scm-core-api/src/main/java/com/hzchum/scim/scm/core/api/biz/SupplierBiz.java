package com.hzchum.scim.scm.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierPayableSummaryDTO;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface SupplierBiz {
   ListVO<SupplierPayableSummaryDTO> summaryPayable(
      Integer supplierClassification, String supplierName, LocalDate startDate, LocalDate endDate, Boolean payable, Boolean isTaxArrears
   );

   ListVO<SupplierPayableSummaryDTO> summaryPayableV2(
      Integer supplierClassification, String supplierName, LocalDate startDate, LocalDate endDate, Boolean payable, Boolean isTaxArrears
   );

   PrintVO<List<Map<String, Object>>> printListSummaryPayable(
      Integer supplierClassification, String supplierName, LocalDate startDate, LocalDate endDate, Boolean payable, Boolean isTaxArrears
   );

   PrintVO<List<Map<String, Object>>> printListSummaryPayableV2(
      Integer supplierClassification, String supplierName, LocalDate startDate, LocalDate endDate, Boolean payable, Boolean isTaxArrears
   );
}
