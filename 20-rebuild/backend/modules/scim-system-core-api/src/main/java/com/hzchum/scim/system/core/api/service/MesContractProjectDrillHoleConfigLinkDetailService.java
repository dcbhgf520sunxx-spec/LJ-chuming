package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectDrillHoleConfigLinkDetail;
import java.util.List;

public interface MesContractProjectDrillHoleConfigLinkDetailService extends IService<MesContractProjectDrillHoleConfigLinkDetail> {
   Boolean isIntersection(List<MesContractProjectDrillHoleConfigLinkDetail> detailList);
}
