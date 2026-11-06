package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysProvinceNew;
import java.util.List;
import java.util.Map;

public interface SysProvinceNewService extends IService<SysProvinceNew> {
   Map<Long, SysProvinceNew> listMapByIds(List<Long> provinceIds);
}
