package com.hzchum.scim.contract.core.api.service.finance;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseReimburse;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractExpenseReimburseDTO;
import java.util.HashMap;
import java.util.List;

public interface ContractExpenseReimburseService extends IService<ContractExpenseReimburse> {
   Boolean isExist(Long expenseTypeId, Long dictionaryId);

   List<ContractExpenseReimburseDTO> listByCondition(Integer year, Integer month, Long expenseTypeId, Long expenseSubjectId, String reimburseUserName);

   List<MonthAmountInfo> listByMonth(Integer startMonth, Integer endMonth);

   HashMap<String, Object> getSum(Integer year, int i);
}
