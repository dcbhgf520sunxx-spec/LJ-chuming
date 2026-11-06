package com.hzchum.scim.mes.building.core.api.service.wage_quota;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota.MesEnclosureProductQuotaConfigDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota.MesEnclosureProductQuotaConfigDetailDTO;
import java.util.List;
import java.util.Map;

public interface MesEnclosureProductQuotaConfigDetailService extends IService<MesEnclosureProductQuotaConfigDetail> {
   Map<Long, List<MesEnclosureProductQuotaConfigDetailDTO>> groupByQuotaConfigIds(List<Long> quotaConfigIdList);

   Boolean isIntersection(List<MesEnclosureProductQuotaConfigDetail> list);
}
