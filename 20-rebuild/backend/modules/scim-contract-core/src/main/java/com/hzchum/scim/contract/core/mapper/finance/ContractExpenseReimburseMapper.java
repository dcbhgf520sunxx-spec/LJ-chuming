package com.hzchum.scim.contract.core.mapper.finance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseReimburse;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractExpenseReimburseDTO;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractExpenseReimburseMapper extends BaseMapper<ContractExpenseReimburse> {
   List<ContractExpenseReimburseDTO> listByCondition(
      @Param("year") Integer year,
      @Param("month") Integer month,
      @Param("expenseTypeId") Long expenseTypeId,
      @Param("expenseSubjectId") Long expenseSubjectId,
      @Param("reimburseUserName") String reimburseUserName
   );

   List<MonthAmountInfo> selectUnProjectList(@Param("startMonth") Integer startMonth, @Param("endMonth") Integer endMonth);

   HashMap<String, Object> getSum(@Param("year") Integer year, @Param("month") int i);
}
