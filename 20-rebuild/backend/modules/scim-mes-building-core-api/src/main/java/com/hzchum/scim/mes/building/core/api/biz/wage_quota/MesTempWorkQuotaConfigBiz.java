package com.hzchum.scim.mes.building.core.api.biz.wage_quota;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota.MesTempWorkQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota.MesTempWorkQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota.MesTempWorkQuotaConfigParam;
import java.util.List;

public interface MesTempWorkQuotaConfigBiz extends IBiz<MesTempWorkQuotaConfig> {
   List<MesTempWorkQuotaConfigDTO> listInfo();

   Boolean add(MesTempWorkQuotaConfigParam param);

   Boolean edit(MesTempWorkQuotaConfigParam param);

   Boolean editStatus(Long id, Boolean status);

   Boolean deleteById(Long id);
}
