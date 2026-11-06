package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractWaste;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractWasteLedgerQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractWasteQueryDtoParam;
import java.util.List;

public interface ContractWasteService extends IService<ContractWaste> {
   List<ContractWasteDTO> listByCondition(ContractWasteQueryDtoParam param);

   List<ContractWasteLedgerDTO> listWasteLedger(ContractWasteLedgerQueryDtoParam param);
}
