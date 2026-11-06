package com.hzchum.scim.mes.building.core.api.service.quota_config;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigMachinePart;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigMachinePartDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigMachinePartParam;
import java.util.List;

public interface MesQuotaConfigMachinePartService extends IService<MesQuotaConfigMachinePart> {
   List<MesQuotaConfigMachinePartDTO> listInfo(MesQuotaConfigConditionQuery query);

   Boolean add(MesQuotaConfigMachinePartParam param);

   Boolean edit(MesQuotaConfigMachinePartParam param);

   Boolean delete(Long id);
}
