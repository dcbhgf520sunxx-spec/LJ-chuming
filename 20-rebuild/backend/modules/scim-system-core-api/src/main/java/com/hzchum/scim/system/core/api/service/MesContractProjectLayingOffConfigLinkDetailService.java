package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectLayingOffConfigLinkDetail;
import java.util.List;

public interface MesContractProjectLayingOffConfigLinkDetailService extends IService<MesContractProjectLayingOffConfigLinkDetail> {
   Boolean isIntersection(List<MesContractProjectLayingOffConfigLinkDetail> detailList);
}
