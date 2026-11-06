package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWageSummary;
import com.hzchum.scim.contract.core.api.service.finance.ContractWageSummaryService;
import com.hzchum.scim.contract.core.mapper.finance.ContractWageSummaryMapper;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContractWageSummaryServiceImpl extends ServiceImpl<ContractWageSummaryMapper, ContractWageSummary> implements ContractWageSummaryService {
   @Override
   public List<ContractWageSummary> listByCondition(Integer year, Integer wageType) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractWageSummary.class)
               .eq(year != null, ContractWageSummary::getYear, year)
               .eq(wageType != null, ContractWageSummary::getWageType, wageType)
               .orderByDesc(ContractWageSummary::getYear)
               .orderByAsc(ContractWageSummary::getWageType)
               .orderByAsc(ContractWageSummary::getMonth)
         );
   }

   @Override
   public Integer getCount(Integer wageType, Integer year, Integer month) {
      return this.baseMapper
         .selectCount(
            Wrappers.lambdaQuery(ContractWageSummary.class)
               .eq(ContractWageSummary::getWageType, wageType)
               .eq(ContractWageSummary::getYear, year)
               .eq(ContractWageSummary::getMonth, month)
         );
   }

   @Override
   public BigDecimal sumWage(Integer year, Integer month, Integer wageType) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractWageSummary.class)
               .eq(year != null, ContractWageSummary::getYear, year)
               .eq(month != null, ContractWageSummary::getMonth, month)
               .eq(wageType != null, ContractWageSummary::getWageType, wageType)
         )
         .stream()
         .map(ContractWageSummary::getTotalWage)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public List<MonthAmountInfo> listMonthTotalWage(Integer startMonth, Integer endMonth) {
      return this.baseMapper.selectMonthTotalWage(startMonth, endMonth);
   }
}
