package com.hzchum.scim.mes.building.core.api.service.wage_quota_management;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesArtifactQuotaConfigDetail;
import java.util.List;

public interface MesArtifactQuotaConfigDetailService extends IService<MesArtifactQuotaConfigDetail> {
   Boolean isIntersection(List<MesArtifactQuotaConfigDetail> list);
}
