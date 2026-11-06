package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialReturnable;

public interface MaterialReturnableService extends IService<MaterialReturnable> {
   void updateReviewById(Long id, Boolean bool);
}
