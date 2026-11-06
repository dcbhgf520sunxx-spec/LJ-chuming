package com.hzchum.scim.contract.core.mapper.finance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.DictionaryInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseDictionaryLink;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractExpenseDictionaryLinkMapper extends BaseMapper<ContractExpenseDictionaryLink> {
   List<DictionaryInfo> selectByExpenseTypeId(@Param("expenseTypeId") Long expenseTypeId);
}
