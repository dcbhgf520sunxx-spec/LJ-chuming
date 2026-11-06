package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractFixedAssetsDepreciation;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractFixedAssetsDepreciationDTO;
import com.hzchum.scim.contract.core.api.service.finance.ContractFixedAssetsDepreciationService;
import com.hzchum.scim.contract.core.mapper.finance.ContractFixedAssetsDepreciationMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContractFixedAssetsDepreciationServiceImpl
   extends ServiceImpl<ContractFixedAssetsDepreciationMapper, ContractFixedAssetsDepreciation>
   implements ContractFixedAssetsDepreciationService {
   @Override
   public List<ContractFixedAssetsDepreciationDTO> listByCondition(Integer type, String name, Boolean boolStatus) {
      return this.baseMapper.selectByCondition(type, name, boolStatus);
   }

   @Override
   public Boolean isExist(Integer type, String name) {
      return this.baseMapper.selectCount(Wrappers.lambdaQuery(ContractFixedAssetsDepreciation.builder().type(type).name(name).build())) == 1;
   }

   @Override
   public List<ContractFixedAssetsDepreciation> listByYear(Integer year) {
      return this.baseMapper.selectByYear(year);
   }
}
