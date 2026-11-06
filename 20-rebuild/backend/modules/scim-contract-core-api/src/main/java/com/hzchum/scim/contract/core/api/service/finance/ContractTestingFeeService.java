package com.hzchum.scim.contract.core.api.service.finance;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractTestingFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractTestingFeeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractTestingFeeSummaryDTO;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface ContractTestingFeeService extends IService<ContractTestingFee> {
   List<ContractTestingFeeSummaryDTO> listSummary(Integer year, Long projectId, Long testingFeeTypeId);

   List<ContractTestingFeeDTO> selectByCondition(Integer year, Integer month, Long projectId, Long testingFeeTypeId);

   List<ContractTestingFeeDTO> listByProjectAndProjectYear(Integer year, Long projectId);

   List<String> selectCount(Integer year);

   Map<String, Object> getSum(@Param("projectId") Long projectId, @Param("testingFeeTypeId") Long testingFeeTypeId);

   List<MonthAmountInfo> listMonthFee(Integer startMonth, Integer endMonth);
}
