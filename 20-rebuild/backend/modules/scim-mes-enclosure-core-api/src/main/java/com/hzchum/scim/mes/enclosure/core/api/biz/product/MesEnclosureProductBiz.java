package com.hzchum.scim.mes.enclosure.core.api.biz.product;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList.ProductSumInfoDTO;

public interface MesEnclosureProductBiz {
   ProductSumInfoDTO getInfoByProduct(Long productId, Integer productType, Integer quantity);
}
