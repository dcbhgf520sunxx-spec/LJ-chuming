package com.hzchum.scim.business.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceTemp;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceTempDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceTempDtoQueryParam;
import com.hzchum.scim.business.core.api.service.BusinessPriceTempService;
import com.hzchum.scim.business.core.mapper.BusinessPriceTempMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BusinessPriceTempServiceImpl extends ServiceImpl<BusinessPriceTempMapper, BusinessPriceTemp> implements BusinessPriceTempService {
   @Override
   public List<BusinessPriceTempDTO> listByCondition(BusinessPriceTempDtoQueryParam param) {
      return this.baseMapper.selectByCondition(param);
   }
}
