package com.hzchum.scim.mes.building.core.mapper.wage_quota;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota.MesEnclosureProductQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota.MesEnclosureProductQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota.MesEnclosureProductQuotaConfigQuery;
import java.util.List;

public interface MesEnclosureProductQuotaConfigMapper extends BaseMapper<MesEnclosureProductQuotaConfig> {
   List<MesEnclosureProductQuotaConfigDTO> listInfo(MesEnclosureProductQuotaConfigQuery query);

   Integer getMaxNumber();
}
