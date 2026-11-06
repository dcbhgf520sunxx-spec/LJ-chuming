package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSerialNumberPrefixChange;
import java.util.List;

public interface SysStructureSerialNumberPrefixChangeService extends IService<SysStructureSerialNumberPrefixChange> {
   List<SysStructureSerialNumberPrefixChange> listByStructureClassificationChangeId(Long structureClassificationChangeId);
}
