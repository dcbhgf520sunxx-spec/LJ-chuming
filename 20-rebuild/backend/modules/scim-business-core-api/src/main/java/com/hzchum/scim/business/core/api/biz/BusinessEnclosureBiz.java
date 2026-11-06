package com.hzchum.scim.business.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessEnclosureDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.EnclosureFindDTOParam;
import java.util.List;
import java.util.Map;

public interface BusinessEnclosureBiz {
   PageVO<BusinessEnclosureDTO> pageListByCondition(EnclosureFindDTOParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printListByCondition(EnclosureFindDTOParam param);
}
