package com.hzchum.scim.mes.building.core.api.service.wage_quota_management;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesPaintingQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesPaintingQuotaConfigDTO;
import java.util.List;

public interface MesPaintingQuotaConfigService extends IService<MesPaintingQuotaConfig> {
   List<MesPaintingQuotaConfigDTO> listInfo();
}
