package com.hzchum.scim.mes.building.core.api.service.wage_quota;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota.MesTempWorkQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota.MesTempWorkQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota.MesTempWorkQuotaConfigParam;
import java.util.List;

public interface MesTempWorkQuotaConfigService extends IService<MesTempWorkQuotaConfig> {
   List<MesTempWorkQuotaConfigDTO> listInfo();

   Boolean add(MesTempWorkQuotaConfigParam param);

   Boolean edit(MesTempWorkQuotaConfigParam param);

   Boolean editStatus(Long id, Boolean status);

   Boolean deleteById(Long id);
}
