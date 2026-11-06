package com.hzchum.scim.business.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPrice;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceQueryParam;
import com.hzchum.scim.business.core.api.service.BusinessPriceService;
import com.hzchum.scim.business.core.mapper.BusinessPriceMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BusinessPriceServiceImpl extends ServiceImpl<BusinessPriceMapper, BusinessPrice> implements BusinessPriceService {
   @Override
   public List<BusinessPrice> listByCondition(BusinessPriceQueryParam param) {
      return this.baseMapper.selectListByCondition(param);
   }
}
