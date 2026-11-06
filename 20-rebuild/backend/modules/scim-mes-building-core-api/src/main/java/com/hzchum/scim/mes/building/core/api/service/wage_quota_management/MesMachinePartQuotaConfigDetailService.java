package com.hzchum.scim.mes.building.core.api.service.wage_quota_management;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesMachinePartQuotaConfigDetail;
import java.util.List;

public interface MesMachinePartQuotaConfigDetailService extends IService<MesMachinePartQuotaConfigDetail> {
   Boolean isIntersection(List<MesMachinePartQuotaConfigDetail> list);
}
