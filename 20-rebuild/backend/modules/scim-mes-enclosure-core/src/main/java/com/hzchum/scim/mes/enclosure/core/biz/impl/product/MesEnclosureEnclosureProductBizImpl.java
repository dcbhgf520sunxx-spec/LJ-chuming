package com.hzchum.scim.mes.enclosure.core.biz.impl.product;

import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.enclosure.core.api.biz.product.MesEnclosureProductBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList.ProductSumInfoDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList.ProductSumInfoDTO.ProductSumInfoDTOBuilder;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class MesEnclosureEnclosureProductBizImpl implements MesEnclosureProductBiz {
   @Autowired
   private TechEnclosureService enclosureService;

   @Override
   public ProductSumInfoDTO getInfoByProduct(Long productId, Integer productType, Integer quantity) {
      ProductSumInfoDTOBuilder builder = ProductSumInfoDTO.builder().quantity(quantity).productType(productType);
      BigDecimal netWeight = BigDecimal.ZERO;
      BigDecimal grossWeight = BigDecimal.ZERO;
      BigDecimal length = BigDecimal.ZERO;
      BigDecimal surfaceArea = BigDecimal.ZERO;
      BigDecimal totalLength = BigDecimal.ZERO;
      Integer category = 0;
      if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         TechEnclosure enclosure = this.enclosureService.getById(productId);
         Preconditions.checkArgument(enclosure != null, "失败：未查询到相关产品");
         totalLength = enclosure.getLength().multiply(BigDecimal.valueOf(quantity.intValue()));
         surfaceArea = enclosure.getLength().multiply(enclosure.getUnfoldedWidth()).divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP);
         length = enclosure.getLength();
         category = enclosure.getCategory();
      }

      return builder.category(category).netWeight(netWeight).grossWeight(grossWeight).length(length).surfaceArea(surfaceArea).enclLength(totalLength).build();
   }
}
