package com.hzchum.scim.contract.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.ContractWaste;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractWasteLedgerQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractWasteQueryDtoParam;
import com.hzchum.scim.contract.core.api.service.ContractWasteService;
import com.hzchum.scim.contract.core.mapper.ContractWasteMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContractWasteServiceImpl extends ServiceImpl<ContractWasteMapper, ContractWaste> implements ContractWasteService {
   @Override
   public List<ContractWasteDTO> listByCondition(ContractWasteQueryDtoParam param) {
      return this.baseMapper.selectByCondition(param);
   }

   @Override
   public List<ContractWasteLedgerDTO> listWasteLedger(ContractWasteLedgerQueryDtoParam param) {
      return this.baseMapper.listWasteLedger(param);
   }
}
