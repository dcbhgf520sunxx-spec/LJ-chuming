package com.hzchum.scim.contract.core.api.service.finance;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractFixedAssetsDepreciation;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractFixedAssetsDepreciationDTO;
import java.util.List;

public interface ContractFixedAssetsDepreciationService extends IService<ContractFixedAssetsDepreciation> {
   List<ContractFixedAssetsDepreciationDTO> listByCondition(Integer type, String name, Boolean boolStatus);

   Boolean isExist(Integer type, String name);

   List<ContractFixedAssetsDepreciation> listByYear(Integer year);
}
