package com.hzchum.scim.business.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceTemp;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceTempDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceTempDtoQueryParam;
import java.util.List;

public interface BusinessPriceTempMapper extends BaseMapper<BusinessPriceTemp> {
   List<BusinessPriceTempDTO> selectByCondition(BusinessPriceTempDtoQueryParam param);
}
