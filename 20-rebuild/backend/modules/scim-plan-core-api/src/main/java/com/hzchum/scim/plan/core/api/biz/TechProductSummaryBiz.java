package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductMeteGroupDTO;
import java.util.Map;

public interface TechProductSummaryBiz {
   void summaryProductData(Long projectId, Long monomerId, Long areaId, Integer productType);

   ListVO<ProductMeteGroupDTO> summaryProduct(Long projectId, Long monomerId, Integer productType, Integer category, Integer permissionCheck);

   Map<String, Object> summaryProject(Long projectId, Integer productType);
}
