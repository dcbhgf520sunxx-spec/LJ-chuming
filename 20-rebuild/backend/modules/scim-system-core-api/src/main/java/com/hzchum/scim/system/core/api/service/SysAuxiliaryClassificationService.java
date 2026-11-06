package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysAuxiliaryClassification;
import java.util.List;

public interface SysAuxiliaryClassificationService extends IService<SysAuxiliaryClassification> {
   List<SysAuxiliaryClassification> listByCondition(String name);
}
