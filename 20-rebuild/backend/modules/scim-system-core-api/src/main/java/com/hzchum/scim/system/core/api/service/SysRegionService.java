package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysRegion;
import java.util.List;
import java.util.Map;

public interface SysRegionService extends IService<SysRegion> {
   Map<Long, SysRegion> listMapByIds(List<Long> regionIds);
}
