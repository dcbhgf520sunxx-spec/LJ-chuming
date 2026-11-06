package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseReimburse;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractExpenseReimburseDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractExpenseReimburseDtoParam;
import java.util.List;
import java.util.Map;

public interface ContractExpenseReimburseBiz extends IBiz<ContractExpenseReimburse> {
   PageVO<ContractExpenseReimburseDTO> listByCondition(
      Integer year, Integer month, Long expenseTypeId, Long expenseSubjectId, String reimburseUserName, Integer pageNumber, Integer pageSize
   );

   Boolean saveList(List<ContractExpenseReimburseDtoParam> paramList);

   Boolean update(ContractExpenseReimburseDtoParam param);

   Boolean deleteList(List<Long> ids);

   PrintVO<List<Map<String, Object>>> printList(Integer year, Integer month, Long expenseTypeId, Long expenseSubjectId, String reimburseUserName);
}
