package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSerialNumberPrefix;
import java.util.List;

public interface SysStructureSerialNumberPrefixService extends IService<SysStructureSerialNumberPrefix> {
   List<SysStructureSerialNumberPrefix> listByStructureClassificationId(Long structureClassificationId);
}
