package com.hzchum.scim.contract.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectLedgerSumDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectSimpleDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectLedgerQueryDTOParam;
import java.util.List;
import java.util.Map;

public interface ContractCollectionInvoiceBiz {
   PageVO<ContractProjectLedgerDTO> listProjectLedger(ProjectLedgerQueryDTOParam queryDTOParam, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printProjectLedgerList(ProjectLedgerQueryDTOParam queryDTOParam);

   ContractProjectLedgerSumDTO getProjectSum(ProjectLedgerQueryDTOParam param);

   ProjectSimpleDTO getProjectFinanceInfo(Long projectId);

   ContractInvoiceCollectionDTO getProjectInvoiceCollection(Long projectId);

   void checkProjectChanging(Long projectId);
}
