package com.hzchum.scim.mes.building.core.mapper.wages;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.AuditDetailsListDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.DistributionProductDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProcessPriceDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProductClassifyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProductDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingWagesChange;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.PriceDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.get.ProductClassifyDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.get.ProductDOParam;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingWagesChangeMapper extends BaseMapper<MesBuildingWagesChange> {
   List<DistributionProductDO> distributionComplete(PriceDOParam copy);

   List<ProductClassifyDO> productClassifyList(ProductClassifyDOParam doParam);

   List<ProductDO> productList(ProductDOParam doParam);

   List<AuditDetailsListDO> auditDetailsList(@Param("id") Long id);

   List<ProcessPriceDO> processPriceCount(PriceDOParam doParam);

   BigDecimal reckonSummary(
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("factoryId") Long factoryId,
      @Param("productType") Integer productType,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );
}
