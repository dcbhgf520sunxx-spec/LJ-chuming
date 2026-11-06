package com.hzchum.scim.mes.building.core.api.service.wage_quota_management;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesAssembleQuotaConfigDetail;
import java.util.List;

public interface MesAssembleQuotaConfigDetailService extends IService<MesAssembleQuotaConfigDetail> {
   Boolean isIntersection(List<MesAssembleQuotaConfigDetail> list);
}
