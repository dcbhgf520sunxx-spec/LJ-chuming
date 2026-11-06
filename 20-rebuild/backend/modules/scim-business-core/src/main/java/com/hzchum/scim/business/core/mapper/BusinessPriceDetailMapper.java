package com.hzchum.scim.business.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceDetail;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessBriceProductDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceProductQueryParam;
import java.util.List;

public interface BusinessPriceDetailMapper extends BaseMapper<BusinessPriceDetail> {
   List<BusinessBriceProductDTO> selectListUnPricingArtifact(BusinessPriceProductQueryParam param);

   List<BusinessBriceProductDTO> selectListUnPricingEnclosure(BusinessPriceProductQueryParam param);

   List<BusinessBriceProductDTO> selectListUnPricingStandardPart(BusinessPriceProductQueryParam param);
}
