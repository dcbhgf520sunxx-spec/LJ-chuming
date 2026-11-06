package com.hzchum.scim.business.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.business.core.api.pojo._do.BusinessProductionControlCheckDetailDO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessProductionControlCheckDetail;
import java.util.List;

public interface BusinessProductionControlCheckDetailMapper extends BaseMapper<BusinessProductionControlCheckDetail> {
   List<BusinessProductionControlCheckDetailDO> listByCheckId(Long id);
}
