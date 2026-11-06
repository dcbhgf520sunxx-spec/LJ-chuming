package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseReimburse;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractExpenseReimburseDTO;
import com.hzchum.scim.contract.core.api.service.finance.ContractExpenseReimburseService;
import com.hzchum.scim.contract.core.mapper.finance.ContractExpenseReimburseMapper;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContractExpenseReimburseServiceImpl
   extends ServiceImpl<ContractExpenseReimburseMapper, ContractExpenseReimburse>
   implements ContractExpenseReimburseService {
   @Override
   public Boolean isExist(Long expenseTypeId, Long expenseSubjectId) {
      int count = this.baseMapper
         .selectCount(
            Wrappers.lambdaQuery(ContractExpenseReimburse.class)
               .eq(expenseTypeId != null, ContractExpenseReimburse::getExpenseTypeId, expenseTypeId)
               .eq(expenseSubjectId != null, ContractExpenseReimburse::getExpenseSubjectId, expenseSubjectId)
         );
      return count > 0;
   }

   @Override
   public List<ContractExpenseReimburseDTO> listByCondition(Integer year, Integer month, Long expenseTypeId, Long expenseSubjectId, String reimburseUserName) {
      return this.baseMapper.listByCondition(year, month, expenseTypeId, expenseSubjectId, reimburseUserName);
   }

   @Override
   public HashMap<String, Object> getSum(Integer year, int i) {
      return this.baseMapper.getSum(year, i);
   }

   @Override
   public List<MonthAmountInfo> listByMonth(Integer startMonth, Integer endMonth) {
      return this.baseMapper.selectUnProjectList(startMonth, endMonth);
   }
}
