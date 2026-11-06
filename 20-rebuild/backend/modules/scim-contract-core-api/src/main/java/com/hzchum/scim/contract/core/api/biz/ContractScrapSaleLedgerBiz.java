package com.hzchum.scim.contract.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractReturnProductDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteLedgerDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ContractScrapSaleLedgerBiz {
   List<ContractWasteLedgerDTO> listScrapSaleLedger(LocalDate startDate, LocalDate endDate, Long branchCompanyId, Long contractWasteId);

   BigDecimal getSaleAmount(Long branchCompanyId, Long contractWasteId);

   PrintVO<List<ContractWasteLedgerDTO>> printListScrapSaleLedger(LocalDate startDate, LocalDate endDate, Long branchCompanyId, Long contractWasteId);

   BigDecimal getWasteCost(Long branchCompanyId, Long contractWasteId);

   PageVO<ContractReturnProductDTO> pageListWasteProduct(
      Long branchCompanyId, Long contractWasteId, Long useProjectId, Integer wasteHandleMethod, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<ContractReturnProductDTO>> printListWasteProduct(Long branchCompanyId, Long contractWasteId, Long useProjectId, Integer wasteHandleMethod);
}
