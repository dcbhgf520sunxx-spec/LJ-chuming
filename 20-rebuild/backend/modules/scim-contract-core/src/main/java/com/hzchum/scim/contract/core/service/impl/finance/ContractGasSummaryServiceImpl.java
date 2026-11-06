package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGasSummary;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractGasSummaryDTO;
import com.hzchum.scim.contract.core.api.service.finance.ContractGasSummaryService;
import com.hzchum.scim.contract.core.mapper.finance.ContractGasSummaryMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContractGasSummaryServiceImpl extends ServiceImpl<ContractGasSummaryMapper, ContractGasSummary> implements ContractGasSummaryService {
   @Override
   public List<ContractGasSummaryDTO> listByCondition(Long classifyId, Integer year) {
      return this.baseMapper.selectByCondition(classifyId, year);
   }

   @Override
   public Boolean isExist(Long classifyId, Integer year, Integer month) {
      return this.baseMapper
            .selectCount(
               Wrappers.lambdaQuery(ContractGasSummary.class)
                  .eq(classifyId != null, ContractGasSummary::getClassifyId, classifyId)
                  .eq(year != null, ContractGasSummary::getYear, year)
                  .eq(month != null, ContractGasSummary::getMonth, month)
            )
         > 0;
   }

   @Override
   public List<MonthAmountInfo> listGasMonthAmount(Integer startMonth, Integer endMonth) {
      return this.baseMapper.selectGasMonthAmount(startMonth, endMonth);
   }
}
