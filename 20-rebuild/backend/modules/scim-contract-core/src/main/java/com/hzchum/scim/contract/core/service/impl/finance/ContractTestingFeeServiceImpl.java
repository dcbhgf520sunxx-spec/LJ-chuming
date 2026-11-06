package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractTestingFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractTestingFeeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractTestingFeeSummaryDTO;
import com.hzchum.scim.contract.core.api.service.finance.ContractTestingFeeService;
import com.hzchum.scim.contract.core.mapper.finance.ContractTestingFeeMapper;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ContractTestingFeeServiceImpl extends ServiceImpl<ContractTestingFeeMapper, ContractTestingFee> implements ContractTestingFeeService {
   @Override
   public List<ContractTestingFeeSummaryDTO> listSummary(Integer year, Long projectId, Long testingFeeTypeId) {
      return this.baseMapper.selectTestingFeeSummary(year, projectId, testingFeeTypeId);
   }

   @Override
   public List<ContractTestingFeeDTO> selectByCondition(Integer year, Integer month, Long projectId, Long testingFeeTypeId) {
      return this.baseMapper.selectByCondition(year, month, projectId, testingFeeTypeId);
   }

   @Override
   public List<ContractTestingFeeDTO> listByProjectAndProjectYear(Integer year, Long projectId) {
      return this.baseMapper.listByProjectAndProjectYear(year, projectId);
   }

   @Override
   public List<String> selectCount(Integer year) {
      return this.baseMapper.findCount(year);
   }

   @Override
   public Map<String, Object> getSum(Long projectId, Long testingFeeTypeId) {
      return this.baseMapper.getSum(projectId, testingFeeTypeId);
   }

   @Override
   public List<MonthAmountInfo> listMonthFee(Integer startMonth, Integer endMonth) {
      return this.baseMapper.selectMonthFeeList(startMonth, endMonth);
   }
}
