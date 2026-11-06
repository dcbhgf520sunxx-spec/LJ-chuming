package com.hzchum.scim.mes.building.core.api.service.quota_config;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigArtifactCondition;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigArtifactConditionDTO;
import java.util.List;

public interface MesQuotaConfigArtifactConditionService extends IService<MesQuotaConfigArtifactCondition> {
   List<MesQuotaConfigArtifactConditionDTO> listByQuotaConfigIdList(List<Long> quotaConfigIdList);

   Boolean deteleByQuotaConfigId(Long quotaConfigId);
}
