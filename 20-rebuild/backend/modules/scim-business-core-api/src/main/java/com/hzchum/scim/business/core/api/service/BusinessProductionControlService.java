package com.hzchum.scim.business.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessProductionControl;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ProductionControlConditionFindDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ProductionControlQuantityChangeDTOParam;

public interface BusinessProductionControlService extends IService<BusinessProductionControl> {
   void updateControlList(ProductionControlQuantityChangeDTOParam param);

   void removeControlList(ProductionControlQuantityChangeDTOParam param);

   ListVO<BusinessProductionControl> listByCondition(ProductionControlConditionFindDTOParam param);
}
