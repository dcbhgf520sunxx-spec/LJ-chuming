package com.hzchum.scim.scm.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderQueryDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderQueryDtoParamV2;
import java.util.List;

public interface SubcontractOrderMapper extends BaseMapper<SubcontractOrder> {
   List<SubcontractOrderDTO> selectSubcontractOrder(SubcontractOrderQueryDTOParam param);

   List<SubcontractOrder> getPageList(SubcontractOrderQueryDtoParamV2 param);
}
