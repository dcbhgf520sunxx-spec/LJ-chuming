package com.hzchum.scim.mes.building.core.api.service.quota_config;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigAssembleCondition;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigAssembleConditionDTO;
import java.util.List;

public interface MesQuotaConfigAssembleConditionService extends IService<MesQuotaConfigAssembleCondition> {
   List<MesQuotaConfigAssembleConditionDTO> listByQuotaConfigIdList(List<Long> quotaConfigIdList);

   Boolean deteleByQuotaConfigId(Long quotaConfigId);
}
