package com.hzchum.scim.business.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.business.core.api.pojo._do.BusinessCheckDetailDO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckDetail;

public interface BusinessCheckDetailService extends IService<BusinessCheckDetail> {
   ListVO<BusinessCheckDetailDO> listByCheckId(Long checkId);
}
