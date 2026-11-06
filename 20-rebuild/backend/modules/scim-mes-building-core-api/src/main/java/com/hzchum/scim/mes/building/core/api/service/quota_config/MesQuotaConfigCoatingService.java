package com.hzchum.scim.mes.building.core.api.service.quota_config;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigCoating;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigCoatingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigCoatingParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import java.util.List;

public interface MesQuotaConfigCoatingService extends IService<MesQuotaConfigCoating> {
   List<MesQuotaConfigCoatingDTO> listInfo(MesQuotaConfigConditionQuery query);

   Boolean add(MesQuotaConfigCoatingParam param);

   Boolean edit(MesQuotaConfigCoatingParam param);

   Boolean deleteById(Long id);
}
