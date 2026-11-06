package com.hzchum.scim.contract.core.api.service.finance;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractPropertyFee;
import java.util.List;

public interface ContractPropertyFeeService extends IService<ContractPropertyFee> {
   List<ContractPropertyFee> listByCondition(Integer year);

   Boolean isExist(Integer year, Integer month);

   List<MonthAmountInfo> listMonthFee(Integer startMonth, Integer endMonth);
}
