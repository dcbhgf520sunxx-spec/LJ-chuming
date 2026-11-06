package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import java.math.BigDecimal;
import java.util.List;

public interface MaterialFreezeMapper extends BaseMapper<MaterialFreeze> {
   List<MaterialFreeze> listInfo(QueryByMaterialDTOParam param);

   BigDecimal getTotalMete(Long id);

   BigDecimal getTotalQuantity(Long id);
}
