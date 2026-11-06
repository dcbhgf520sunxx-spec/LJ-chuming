package com.hzchum.scim.contract.core.api.service.finance;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.DictionaryInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseDictionaryLink;
import java.util.List;

public interface ContractExpenseDictionaryLinkService extends IService<ContractExpenseDictionaryLink> {
   List<DictionaryInfo> listByExpenseType(Long expenseTypeId);
}
