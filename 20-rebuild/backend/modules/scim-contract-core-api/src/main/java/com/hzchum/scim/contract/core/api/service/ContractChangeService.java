package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractChange;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractChangeDTO;
import java.util.List;

public interface ContractChangeService extends IService<ContractChange> {
   List<ContractChangeDTO> listByCondition(
      Long userId, Long projectId, Integer year, Integer type, String name, String userName, String auditorName, Integer auditStatus
   );
}
