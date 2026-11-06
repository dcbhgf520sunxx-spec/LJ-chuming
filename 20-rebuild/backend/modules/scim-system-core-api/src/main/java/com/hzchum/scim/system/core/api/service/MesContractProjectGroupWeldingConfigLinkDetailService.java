package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectGroupWeldingConfigLinkDetail;
import java.util.List;

public interface MesContractProjectGroupWeldingConfigLinkDetailService extends IService<MesContractProjectGroupWeldingConfigLinkDetail> {
   Boolean isIntersection(List<MesContractProjectGroupWeldingConfigLinkDetail> detailList);
}
