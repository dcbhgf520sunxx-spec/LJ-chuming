package com.hzchum.scim.mes.building.core.api.service.quota_config;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigEnclosure;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigEnclosureDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigEnclosureParam;
import java.util.List;

public interface MesQuotaConfigEnclosureService extends IService<MesQuotaConfigEnclosure> {
   List<MesQuotaConfigEnclosureDTO> listInfo(MesQuotaConfigConditionQuery query);

   Boolean add(MesQuotaConfigEnclosureParam param);

   Boolean edit(MesQuotaConfigEnclosureParam param);

   Boolean deleteById(Long id);
}
