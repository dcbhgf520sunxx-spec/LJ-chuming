package com.hzchum.scim.mes.building.core.api.service.quota_config;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigMachinePartCondition;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigMachinePartConditionDTO;
import java.util.List;

public interface MesQuotaConfigMachinePartConditionService extends IService<MesQuotaConfigMachinePartCondition> {
   List<MesQuotaConfigMachinePartConditionDTO> listByQuotaConfigIdList(List<Long> quotaConfigIdList);

   Boolean deteleByQuotaConfigId(Long quotaConfigId);
}
