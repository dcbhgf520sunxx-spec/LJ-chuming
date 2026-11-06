package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleSpecChange;
import java.util.List;

public interface SysAssembleSpecChangeService extends IService<SysAssembleSpecChange> {
   List<SysAssembleSpecChange> listByAssembleConfigChangeId(Long assembleConfigChangeId);
}
