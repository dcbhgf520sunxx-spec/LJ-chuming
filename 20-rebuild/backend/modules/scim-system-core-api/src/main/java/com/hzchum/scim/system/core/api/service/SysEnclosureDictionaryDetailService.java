package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysEnclosureDictionaryDetail;

public interface SysEnclosureDictionaryDetailService extends IService<SysEnclosureDictionaryDetail> {
   SysEnclosureDictionaryDetail selectDetail(Integer type, String name, String label);
}
