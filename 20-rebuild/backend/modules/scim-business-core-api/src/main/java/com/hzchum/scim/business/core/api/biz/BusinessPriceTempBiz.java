package com.hzchum.scim.business.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceTemp;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceTempDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceTempDtoQueryParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceTempUpdateDtoParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.PriceTempQueryDtoParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.TempToCheckSaveDtoParam;
import java.util.List;

public interface BusinessPriceTempBiz extends IBiz<BusinessPriceTemp> {
   PageVO<BusinessPriceTempDTO> pageList(BusinessPriceTempDtoQueryParam param, Integer pageNumber, Integer pageSize);

   Boolean updateTemp(List<BusinessPriceTempUpdateDtoParam> params);

   Boolean delTemp(List<Long> ids);

   Boolean commitToCheck(TempToCheckSaveDtoParam param);

   Integer priceTempCount(PriceTempQueryDtoParam param);
}
