package com.hzchum.scim.mes.building.core.api.biz.product;

import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProductSumInfoDTO;
import java.math.BigDecimal;

public interface MesProductBiz {
   ProductSumInfoDTO getInfoByProduct(Long productId, Integer productType, BigDecimal quantity);

   ProductSumInfoDTO getInfoByCargoListId(Long cargoListId);
}
