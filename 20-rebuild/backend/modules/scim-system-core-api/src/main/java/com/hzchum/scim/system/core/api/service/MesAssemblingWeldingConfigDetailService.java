package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesAssemblingWeldingConfigDetail;
import java.util.List;

public interface MesAssemblingWeldingConfigDetailService extends IService<MesAssemblingWeldingConfigDetail> {
   Boolean isIntersection(List<MesAssemblingWeldingConfigDetail> detailList);
}
