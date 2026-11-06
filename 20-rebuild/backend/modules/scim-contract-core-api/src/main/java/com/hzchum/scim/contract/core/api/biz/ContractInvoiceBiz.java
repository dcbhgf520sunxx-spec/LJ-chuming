package com.hzchum.scim.contract.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectIncomeAndExpenses;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectIncomingAndOutgoingsDto;
import com.hzchum.scim.contract.core.api.pojo.dto.SaveInvoiceDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCheckDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractInvoiceQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractInvoiceSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractInvoiceSaveParamV2;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ContractInvoiceEditDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ContractInvoiceBiz {
   PageVO<ContractInvoiceDTO> pageList(ContractInvoiceQueryDtoParam param, Integer pageNumber, Integer pageSize);

   BigDecimal getSummaryInvoice(ContractInvoiceQueryDtoParam param);

   PrintVO<List<Map<String, Object>>> printList(ContractInvoiceQueryDtoParam param);

   Boolean saveList(Integer type, List<ContractInvoiceSaveDTOParam> invoiceSaveDTOParams);

   Boolean auditInvoice(ContractCheckDtoParam param);

   Boolean updateInvoice(ContractInvoiceEditDTOParam editDTOParam);

   Boolean delete(Long id);

   SaveInvoiceDto getProject(Long projectId, Integer level);

   Boolean saveInvoice(ContractInvoiceSaveParamV2 saveDTOParam);

   PrintVO downloadInvoice(Long projectId, Integer level);

   PageVO<ContractInvoiceV2DTO> listPageLedger(Long projectId, Integer level, Integer pageNumber, Integer pageSize);

   PageVO<ProjectIncomeAndExpenses> projectIncomeAndExpensesList(
      Long projectId, String remark, Integer collectionMode, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize
   );

   ProjectIncomingAndOutgoingsDto projectIncomeAndExpenses(
      String projectAttribute, Long projectManagerId, Long projectId, LocalDate startDate, LocalDate endDate
   );

   SaveInvoiceDto getProject(Long projectId);

   Map<Integer, String> acquisitionStatement(Long projectId);

   PrintVO downloadIncomeAndExpensesList(Long projectId, String remark, Integer collectionMode, LocalDate startDate, LocalDate endDate);
}
