package com.hzchum.scim.mes.building.core.api.service.wages;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProductTypeSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingPriceChange;
import java.util.List;

public interface MesBuildingPriceChangeService extends IService<MesBuildingPriceChange> {
   List<ProductTypeSummaryDO> getProductTypeList(Long projectId, Long monomerId, Long areaId, Integer taskTypeEnum);
}
