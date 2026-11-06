package com.hzchum.scim.business.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPrice;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessBriceProductDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceDetailDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceProjectDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceSummaryInfoDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceAddParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceCheckParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceProductQueryParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceQueryParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceUpdateParam;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface BusinessPriceBiz extends IBiz<BusinessPrice> {
   List<BusinessPriceProjectDTO> listProjectForBusiness(LocalDateTime dateTime, String name, Long branchCompanyId);

   BusinessPriceSummaryInfoDTO getPriceInfo(Long projectId, Integer productType, Long branchCompanyId);

   PageVO<BusinessBriceProductDTO> listUnPricingProduct(BusinessPriceProductQueryParam param, Integer pageNumber, Integer pageSize);

   PageVO<BusinessPriceDTO> pageListBusinessPrice(BusinessPriceQueryParam param, Integer pageNumber, Integer pageSize);

   PageVO<BusinessPriceDetailDTO> listBusinessPriceDetail(Long businessPriceId, Integer pageNumber, Integer pageSize);

   PrintVO<List<BusinessPriceDetailDTO>> printBusinessPriceDetail(Long businessPriceId);

   Boolean addBusinessPrice(BusinessPriceAddParam param);

   Boolean checkBusinessPrice(BusinessPriceCheckParam param);

   Boolean updateBusinessPrice(BusinessPriceUpdateParam param);

   Boolean removeBusinessPrice(Collection<Long> ids);
}
