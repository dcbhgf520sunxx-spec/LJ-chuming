package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysBusinessDataStatistics;
import com.hzchum.scim.system.core.api.pojo.dto.BimModelRestrictConfigDTO;
import java.util.List;

public interface BimModelRestrictConfigService extends IService<SysBusinessDataStatistics> {
   void updateValue(List<BimModelRestrictConfigDTO> dto);
}
