package com.hzchum.scim.contract.core.mapper.finance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGasSummary;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractGasSummaryDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractGasSummaryMapper extends BaseMapper<ContractGasSummary> {
   List<ContractGasSummaryDTO> selectByCondition(@Param("classifyId") Long classifyId, @Param("year") Integer year);

   List<MonthAmountInfo> selectGasMonthAmount(@Param("startMonth") Integer startMonth, @Param("endMonth") Integer endMonth);
}
