package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.common.DictionaryInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseDictionaryLink;
import com.hzchum.scim.contract.core.api.service.finance.ContractExpenseDictionaryLinkService;
import com.hzchum.scim.contract.core.mapper.finance.ContractExpenseDictionaryLinkMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContractExpenseDictionaryLinkServiceImpl
   extends ServiceImpl<ContractExpenseDictionaryLinkMapper, ContractExpenseDictionaryLink>
   implements ContractExpenseDictionaryLinkService {
   @Override
   public List<DictionaryInfo> listByExpenseType(Long expenseTypeId) {
      return this.baseMapper.selectByExpenseTypeId(expenseTypeId);
   }
}
