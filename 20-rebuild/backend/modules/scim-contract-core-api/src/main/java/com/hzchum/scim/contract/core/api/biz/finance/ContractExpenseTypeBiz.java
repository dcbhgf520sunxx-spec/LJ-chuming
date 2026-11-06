package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseType;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractExpenseTypeDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ExpenseTypeSaveDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ExpenseTypeUpdateDTOParam;
import java.util.List;

public interface ContractExpenseTypeBiz extends IBiz<ContractExpenseType> {
   PageVO<ContractExpenseTypeDTO> listByCondition(String name, Integer pageNumber, Integer pageSize);

   Boolean deleteExpenseType(List<Long> ids);

   Boolean updateExpenseType(ExpenseTypeUpdateDTOParam param);

   Boolean saveExpenseType(ExpenseTypeSaveDtoParam param);
}
