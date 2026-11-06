package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpec;
import java.util.List;
import java.util.Map;

public interface SysStructureSpecService extends IService<SysStructureSpec> {
   List<String> listSpecPrefix(Integer mesProductEnum);

   Map<String, SysStructureSpec> getCommonArtifactMap();

   List<SysStructureSpec> listByStructureClassificationId(Long structureClassificationId);
}
