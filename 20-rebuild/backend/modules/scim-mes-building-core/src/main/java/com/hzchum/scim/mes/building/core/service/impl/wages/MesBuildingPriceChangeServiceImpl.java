package com.hzchum.scim.mes.building.core.service.impl.wages;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProductTypeSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingPriceChange;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingPriceChangeService;
import com.hzchum.scim.mes.building.core.mapper.wages.MesBuildingPriceChangeMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingPriceChangeServiceImpl
   extends ServiceImpl<MesBuildingPriceChangeMapper, MesBuildingPriceChange>
   implements MesBuildingPriceChangeService {
   @Override
   public List<ProductTypeSummaryDO> getProductTypeList(Long projectId, Long monomerId, Long areaId, Integer taskTypeEnum) {
      return this.baseMapper.getProductTypeList(projectId, monomerId, areaId, taskTypeEnum);
   }
}
