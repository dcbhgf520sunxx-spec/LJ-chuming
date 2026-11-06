package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesGroupWeldingConfigDetail;
import java.util.List;

public interface MesGroupWeldingConfigDetailService extends IService<MesGroupWeldingConfigDetail> {
   Boolean isIntersection(List<MesGroupWeldingConfigDetail> list);
}
