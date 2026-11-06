package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductDeepenMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.PlanProjectDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProjectProductMeteSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.TechProductDTO;

public interface ProductBiz {
   PageVO<ProjectProductMeteSumDTO> listMetByProduct(PlanProjectDTOParam param);

   TechProductDTO getProductInfoBy(Long productId, Integer productType);

   TechProductDTO getProductIgnoreDelete(Long productId, Integer productType);

   ProductMeteDTO getDeepenMete(Long monomerId, Integer areaProductType);

   ProductMeteDTO getDeepenMete(Long projectId, Long monomerId, Long areaId, Integer productType);

   ProductMeteDTO getDeepenMete(Long areaId);

   ProductMeteDTO getDeepenMeteV2(Long areaId);

   ProductDeepenMeteDTO getDeepenMete(Integer productType, Long productId);

   void checkChangeArea(Long areaId);
}
