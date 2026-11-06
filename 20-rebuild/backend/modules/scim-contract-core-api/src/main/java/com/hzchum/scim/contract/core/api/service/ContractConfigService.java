package com.hzchum.scim.contract.core.api.service;

import com.hzchum.scim.contract.core.api.pojo.dto.ContractFieldConfigDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractFieldConfigDTOParam;
import java.util.List;

public interface ContractConfigService {
   List<ContractFieldConfigDTO> getContractFiledConfig();

   Boolean saveContractFiledConfig(ContractFieldConfigDTOParam dtoParam);

   Boolean updateContractFiledConfig(ContractFieldConfigDTOParam dtoParam);

   Boolean deleteContractFiledConfig(List<Long> ids);
}
