package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleSpec;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleSpecConfigDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleSpecDTOParam;
import java.util.List;
import java.util.Set;

public interface SysAssembleSpecService extends IService<SysAssembleSpec> {
   List<AssembleSpecDTOParam> listByCondition(Long assembleConfigId, String specPrefix, Integer mesProductEnum);

   List<AssembleSpecConfigDTOParam> getAssembleConfigToSpec(Set<Long> assembleConfigIds);

   List<SysAssembleSpec> listByAssembleConfigId(Long assembleConfigId);
}
