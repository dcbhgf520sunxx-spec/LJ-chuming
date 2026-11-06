package com.hzchum.scim.contract.core.mapper.finance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractPropertyFee;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractPropertyFeeMapper extends BaseMapper<ContractPropertyFee> {
   List<MonthAmountInfo> selectMonthFeeList(@Param("startMonth") Integer startMonth, @Param("endMonth") Integer endMonth);
}
