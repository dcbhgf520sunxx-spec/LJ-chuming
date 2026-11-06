package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.ContractWaste;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractWasteLedgerQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractWasteQueryDtoParam;
import java.util.List;

public interface ContractWasteMapper extends BaseMapper<ContractWaste> {
   List<ContractWasteDTO> selectByCondition(ContractWasteQueryDtoParam param);

   List<ContractWasteLedgerDTO> listWasteLedger(ContractWasteLedgerQueryDtoParam param);
}
