package com.hzchum.scim.contract.core.mapper.finance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseType;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractExpenseTypeDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractExpenseTypeMapper extends BaseMapper<ContractExpenseType> {
   List<ContractExpenseTypeDTO> selectByCondition(@Param("name") String name);

   List<ContractExpenseTypeDTO> selectAllList(@Param("name") String name);

   List<ContractExpenseTypeDTO> selectByType(@Param("category") Integer category);
}
