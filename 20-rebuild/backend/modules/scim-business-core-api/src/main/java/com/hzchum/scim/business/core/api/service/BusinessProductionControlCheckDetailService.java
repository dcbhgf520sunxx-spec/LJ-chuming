package com.hzchum.scim.business.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.business.core.api.pojo._do.BusinessProductionControlCheckDetailDO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessProductionControlCheckDetail;

public interface BusinessProductionControlCheckDetailService extends IService<BusinessProductionControlCheckDetail> {
   ListVO<BusinessProductionControlCheckDetailDO> listByCheckId(Long id);
}
