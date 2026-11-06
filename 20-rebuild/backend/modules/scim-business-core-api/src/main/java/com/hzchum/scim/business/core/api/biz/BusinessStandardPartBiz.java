package com.hzchum.scim.business.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessStandardPart;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessStandardPartDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessStandardPartQueryDtoParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.StandardPartCheckInfoDTOParam;
import java.util.List;
import java.util.Map;

public interface BusinessStandardPartBiz extends IBiz<BusinessStandardPart> {
   PageVO<BusinessStandardPartDTO> pageListBusiness(BusinessStandardPartQueryDtoParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printListBusiness(BusinessStandardPartQueryDtoParam param);

   Boolean setUnitPrice(StandardPartCheckInfoDTOParam param);
}
