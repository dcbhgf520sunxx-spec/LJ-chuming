package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.contract.core.api.enums.ExpenseTypeCategoryEnum;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseType;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractExpenseTypeDTO;
import com.hzchum.scim.contract.core.api.service.finance.ContractExpenseTypeService;
import com.hzchum.scim.contract.core.mapper.finance.ContractExpenseTypeMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContractExpenseTypeServiceImpl extends ServiceImpl<ContractExpenseTypeMapper, ContractExpenseType> implements ContractExpenseTypeService {
   @Override
   public List<ContractExpenseTypeDTO> listByCondition(String name) {
      return this.baseMapper.selectByCondition(name);
   }

   @Override
   public List<ContractExpenseTypeDTO> listAll(String name) {
      return this.baseMapper.selectAllList(name);
   }

   @Override
   public List<ContractExpenseTypeDTO> listByCategory(Integer category) {
      Preconditions.checkArgument(ExpenseTypeCategoryEnum.isExist(category), "类型不存在");
      return this.baseMapper.selectByType(category);
   }
}
