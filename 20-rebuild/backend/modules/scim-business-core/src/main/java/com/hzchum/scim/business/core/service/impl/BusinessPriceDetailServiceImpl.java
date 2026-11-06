package com.hzchum.scim.business.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceDetail;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessBriceProductDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceProductQueryParam;
import com.hzchum.scim.business.core.api.service.BusinessPriceDetailService;
import com.hzchum.scim.business.core.mapper.BusinessPriceDetailMapper;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.EnclosureCategoryEnum;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BusinessPriceDetailServiceImpl extends ServiceImpl<BusinessPriceDetailMapper, BusinessPriceDetail> implements BusinessPriceDetailService {
   @Override
   public List<BusinessBriceProductDTO> listUnPricingProduct(BusinessPriceProductQueryParam param) {
      Preconditions.checkArgument(param.getProductType() != null, "产品类型未知!");
      if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         return this.baseMapper.selectListUnPricingArtifact(param);
      } else if (param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         List<BusinessBriceProductDTO> briceProductDTOList = this.baseMapper.selectListUnPricingEnclosure(param);
         briceProductDTOList.forEach(e -> e.setEnclosureType(EnclosureCategoryEnum.getNameByCategory(e.getCategory())));
         return briceProductDTOList;
      } else {
         return param.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
            ? this.baseMapper.selectListUnPricingStandardPart(param)
            : Collections.emptyList();
      }
   }
}
