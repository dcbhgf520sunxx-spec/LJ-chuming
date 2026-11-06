package com.hzchum.scim.business.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPrice;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceQueryParam;
import java.util.List;

public interface BusinessPriceService extends IService<BusinessPrice> {
   List<BusinessPrice> listByCondition(BusinessPriceQueryParam param);
}
