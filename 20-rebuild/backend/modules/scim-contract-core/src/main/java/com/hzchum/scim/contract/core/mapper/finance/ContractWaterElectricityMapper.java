package com.hzchum.scim.contract.core.mapper.finance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWaterElectricity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractWaterElectricityMapper extends BaseMapper<ContractWaterElectricity> {
   List<MonthAmountInfo> selectMonthMeteAmount(@Param("startMonth") Integer startMonth, @Param("endMonth") Integer endMonth, @Param("type") Integer type);
}
