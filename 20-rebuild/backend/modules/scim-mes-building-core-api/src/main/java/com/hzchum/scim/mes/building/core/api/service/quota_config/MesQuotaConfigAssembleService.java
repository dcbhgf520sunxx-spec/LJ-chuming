package com.hzchum.scim.mes.building.core.api.service.quota_config;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigAssemble;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigAssembleDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigAssembleParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import java.util.List;

public interface MesQuotaConfigAssembleService extends IService<MesQuotaConfigAssemble> {
   List<MesQuotaConfigAssembleDTO> listInfo(MesQuotaConfigConditionQuery query);

   Boolean add(MesQuotaConfigAssembleParam param);

   Boolean edit(MesQuotaConfigAssembleParam param);

   Boolean delete(Long id);
}
