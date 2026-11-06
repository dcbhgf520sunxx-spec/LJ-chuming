package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesDrillHoleConfigDetail;
import java.util.List;

public interface MesDrillHoleConfigDetailService extends IService<MesDrillHoleConfigDetail> {
   Boolean isIntersection(List<MesDrillHoleConfigDetail> detailList);
}
