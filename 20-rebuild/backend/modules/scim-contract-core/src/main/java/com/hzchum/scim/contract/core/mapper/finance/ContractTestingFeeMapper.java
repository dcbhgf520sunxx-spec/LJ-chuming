package com.hzchum.scim.contract.core.mapper.finance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractTestingFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractTestingFeeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractTestingFeeSummaryDTO;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractTestingFeeMapper extends BaseMapper<ContractTestingFee> {
   List<ContractTestingFeeSummaryDTO> selectTestingFeeSummary(
      @Param("year") Integer year, @Param("projectId") Long projectId, @Param("testingFeeTypeId") Long testingFeeTypeId
   );

   List<ContractTestingFeeDTO> selectByCondition(
      @Param("year") Integer year, @Param("month") Integer month, @Param("projectId") Long projectId, @Param("testingFeeTypeId") Long testingFeeTypeId
   );

   List<ContractTestingFeeDTO> listByProjectAndProjectYear(@Param("year") Integer year, @Param("projectId") Long projectId);

   HashMap<String, Object> getSum(@Param("projectId") Long projectId, @Param("testingFeeTypeId") Long testingFeeTypeId);

   List<String> findCount(@Param("year") Integer year);

   List<MonthAmountInfo> selectMonthFeeList(@Param("startMonth") Integer startMonth, @Param("endMonth") Integer endMonth);
}
