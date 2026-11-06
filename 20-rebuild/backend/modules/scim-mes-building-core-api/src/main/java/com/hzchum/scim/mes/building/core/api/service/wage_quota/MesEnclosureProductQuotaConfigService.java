package com.hzchum.scim.mes.building.core.api.service.wage_quota;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota.MesEnclosureProductQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota.MesEnclosureProductQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota.MesEnclosureProductQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota.MesEnclosureProductQuotaConfigQuery;
import java.util.List;

public interface MesEnclosureProductQuotaConfigService extends IService<MesEnclosureProductQuotaConfig> {
   List<MesEnclosureProductQuotaConfigDTO> listInfo(MesEnclosureProductQuotaConfigQuery query);

   Boolean add(MesEnclosureProductQuotaConfigParam param);

   Boolean edit(MesEnclosureProductQuotaConfigParam param);

   Boolean deleteById(Long id);
}
