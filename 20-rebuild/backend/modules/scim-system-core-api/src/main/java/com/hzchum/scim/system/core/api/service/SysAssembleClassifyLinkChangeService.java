package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleClassifyLinkChange;
import java.util.List;

public interface SysAssembleClassifyLinkChangeService extends IService<SysAssembleClassifyLinkChange> {
   List<SysAssembleClassifyLinkChange> listByAssembleConfigChangeId(Long assembleConfigChangeId);
}
