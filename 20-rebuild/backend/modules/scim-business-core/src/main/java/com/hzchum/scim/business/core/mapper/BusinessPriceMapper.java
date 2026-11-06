package com.hzchum.scim.business.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPrice;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceQueryParam;
import java.util.List;

public interface BusinessPriceMapper extends BaseMapper<BusinessPrice> {
   List<BusinessPrice> selectListByCondition(BusinessPriceQueryParam param);
}
