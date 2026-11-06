package com.hzchum.scim.mes.building.core.api.service.wages;

import com.baomidou.mybatisplus.extension.service.IService;
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

public interface MesBuildingWagesChangeService extends IService<MesBuildingWagesChange> {
   List<DistributionProductDO> distributionComplete(PriceDOParam copy);

   List<ProductClassifyDO> productClassifyList(ProductClassifyDOParam doParam);

   List<ProductDO> productList(ProductDOParam doParam);

   List<AuditDetailsListDO> auditDetailsList(Long id);

   List<ProcessPriceDO> processPriceCount(PriceDOParam doParam);

   BigDecimal reckonSummary(Long projectId, Long factoryId, Integer productType, LocalDateTime startDate, LocalDateTime endDate);
}
