package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCollection;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionWarningDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectIncomeExpenseDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCollectionQueryDtoParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ContractCollectionService extends IService<ContractCollection> {
   BigDecimal getCollectionAmount(Long projectId);

   List<ContractCollectionDTO> listCollection(ContractCollectionQueryDtoParam param);

   List<ContractCollectionWarningDTO> listCollectionWarning(Integer year, Long projectId, Boolean boolArrears);

   List<ProjectIncomeExpenseDTO> listIncomeExpense(Integer year, Long branchCompanyId);

   List<ContractCollection> selectIncomeAndExpenses(Long projectId, String remark, Integer collectionMode, LocalDate startDate, LocalDate endDate);

   List<ContractCollection> listCollectionLedger(Long projectId, Long collectionId);
}
