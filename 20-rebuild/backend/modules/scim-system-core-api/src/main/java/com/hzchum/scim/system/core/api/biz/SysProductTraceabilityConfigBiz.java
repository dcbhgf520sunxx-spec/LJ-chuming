package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysProductTraceabilityConfig;
import com.hzchum.scim.system.core.api.pojo.dto.SysProductTraceabilityConfigDTO;
import com.hzchum.scim.system.core.api.pojo.param.SysProductTraceabilityConfigParam;
import java.util.List;

public interface SysProductTraceabilityConfigBiz extends IBiz<SysProductTraceabilityConfig> {
   SysProductTraceabilityConfig getByProjectId(Long projectId);

   List<SysProductTraceabilityConfigDTO> listByCondition(Long projectId, String projectName);

   boolean saveBatch(List<SysProductTraceabilityConfigParam> paramList);

   SysProductTraceabilityConfig getDefault();

   Boolean saveDefault(SysProductTraceabilityConfigParam param);
}
