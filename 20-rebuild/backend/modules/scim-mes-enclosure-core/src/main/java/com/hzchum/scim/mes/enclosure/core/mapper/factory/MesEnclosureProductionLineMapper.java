package com.hzchum.scim.mes.enclosure.core.mapper.factory;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureProductionLineSumDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.ProductionLineDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages.DistributionDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureProductionLine;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

public interface MesEnclosureProductionLineMapper extends BaseMapper<MesEnclosureProductionLine> {
   List<DistributionDO> listByCondition(@Param("factory") Long factory, @Param("workshopId") Long workshopId);

   List<NameInfo> listProductionLineUser(@Param("workshopId") Long workshopId, @Param("currentUserId") Long currentUserId);

   List<ProductionLineDO> productionLineList(
      @Param("factoryId") Long factoryId,
      @Param("workshopId") Long workshopId,
      @Param("productionLineId") Long productionLineId,
      @Param("productType") Integer productType
   );

   List<MesEnclosureProductionLineSumDO> selectProductLine(String factoryId, String workshopId, String productionLineId, int productType);

   List<MesEnclosureProductionLineSumDO> selectProductLineByids(@Param("lineIds") Set<Long> lineIds);

   MesEnclosureProductionLine getLineById(@Param("productionLineId") Long productionLineId);
}
