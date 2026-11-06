package com.hzchum.scim.contract.core.api.service.finance;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWageSummary;
import java.math.BigDecimal;
import java.util.List;

public interface ContractWageSummaryService extends IService<ContractWageSummary> {
   List<ContractWageSummary> listByCondition(Integer year, Integer wageType);

   Integer getCount(Integer wageType, Integer year, Integer month);

   BigDecimal sumWage(Integer year, Integer month, Integer wageType);

   List<MonthAmountInfo> listMonthTotalWage(Integer startMonth, Integer endMonth);
}
