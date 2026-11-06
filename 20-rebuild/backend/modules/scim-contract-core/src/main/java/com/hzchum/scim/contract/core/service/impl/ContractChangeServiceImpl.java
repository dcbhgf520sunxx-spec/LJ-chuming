package com.hzchum.scim.contract.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.ContractChange;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractChangeDTO;
import com.hzchum.scim.contract.core.api.service.ContractChangeService;
import com.hzchum.scim.contract.core.mapper.ContractChangeMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContractChangeServiceImpl extends ServiceImpl<ContractChangeMapper, ContractChange> implements ContractChangeService {
   @Override
   public List<ContractChangeDTO> listByCondition(
      Long userId, Long projectId, Integer year, Integer type, String name, String userName, String auditorName, Integer auditStatus
   ) {
      return this.baseMapper.selectByCondition(userId, projectId, year, type, name, userName, auditorName, auditStatus);
   }
}
