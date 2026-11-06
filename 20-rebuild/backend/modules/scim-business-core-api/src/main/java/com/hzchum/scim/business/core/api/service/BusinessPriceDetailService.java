package com.hzchum.scim.business.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceDetail;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessBriceProductDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceProductQueryParam;
import java.util.List;

public interface BusinessPriceDetailService extends IService<BusinessPriceDetail> {
   List<BusinessBriceProductDTO> listUnPricingProduct(BusinessPriceProductQueryParam param);
}
