package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractPropertyFee;
import com.hzchum.scim.contract.core.api.service.finance.ContractPropertyFeeService;
import com.hzchum.scim.contract.core.mapper.finance.ContractPropertyFeeMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContractPropertyFeeServiceImpl extends ServiceImpl<ContractPropertyFeeMapper, ContractPropertyFee> implements ContractPropertyFeeService {
   @Override
   public List<ContractPropertyFee> listByCondition(Integer year) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractPropertyFee.class)
               .eq(year != null, ContractPropertyFee::getYear, year)
               .orderByDesc(ContractPropertyFee::getYear)
               .orderByAsc(ContractPropertyFee::getMonth)
         );
   }

   @Override
   public Boolean isExist(Integer year, Integer month) {
      return this.baseMapper
            .selectCount(
               Wrappers.lambdaQuery(ContractPropertyFee.class).eq(ContractPropertyFee::getYear, year).eq(month != null, ContractPropertyFee::getMonth, month)
            )
         > 0;
   }

   @Override
   public List<MonthAmountInfo> listMonthFee(Integer startMonth, Integer endMonth) {
      return this.baseMapper.selectMonthFeeList(startMonth, endMonth);
   }
}
