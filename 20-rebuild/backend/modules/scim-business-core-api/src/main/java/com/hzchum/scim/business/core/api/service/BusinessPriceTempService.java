package com.hzchum.scim.business.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceTemp;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceTempDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceTempDtoQueryParam;
import java.util.List;

public interface BusinessPriceTempService extends IService<BusinessPriceTemp> {
   List<BusinessPriceTempDTO> listByCondition(BusinessPriceTempDtoQueryParam param);
}
