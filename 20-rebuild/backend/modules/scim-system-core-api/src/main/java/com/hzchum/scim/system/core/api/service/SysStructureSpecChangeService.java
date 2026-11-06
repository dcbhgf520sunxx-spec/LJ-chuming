package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpecChange;
import java.util.List;

public interface SysStructureSpecChangeService extends IService<SysStructureSpecChange> {
   List<SysStructureSpecChange> listByStructureClassificationChangeId(Long structureClassificationChangeId);
}
