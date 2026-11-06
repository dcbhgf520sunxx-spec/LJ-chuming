package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectAssemblingWeldingConfigLinkDetail;
import java.util.List;

public interface MesContractProjectAssemblingWeldingConfigLinkDetailService extends IService<MesContractProjectAssemblingWeldingConfigLinkDetail> {
   Boolean isIntersection(List<MesContractProjectAssemblingWeldingConfigLinkDetail> detailList);
}
