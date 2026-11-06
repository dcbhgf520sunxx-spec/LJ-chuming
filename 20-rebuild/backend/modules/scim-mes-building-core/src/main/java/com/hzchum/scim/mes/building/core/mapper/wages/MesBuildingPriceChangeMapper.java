package com.hzchum.scim.mes.building.core.mapper.wages;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProductTypeSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingPriceChange;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingPriceChangeMapper extends BaseMapper<MesBuildingPriceChange> {
   List<ProductTypeSummaryDO> getProductTypeList(
      @Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId, @Param("taskTypeEnum") Integer taskTypeEnum
   );
}
