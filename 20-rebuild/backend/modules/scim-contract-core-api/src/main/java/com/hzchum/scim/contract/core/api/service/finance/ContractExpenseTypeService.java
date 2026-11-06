package com.hzchum.scim.contract.core.api.service.finance;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseType;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractExpenseTypeDTO;
import java.util.List;

public interface ContractExpenseTypeService extends IService<ContractExpenseType> {
   List<ContractExpenseTypeDTO> listByCondition(String name);

   List<ContractExpenseTypeDTO> listAll(String name);

   List<ContractExpenseTypeDTO> listByCategory(Integer category);
}
