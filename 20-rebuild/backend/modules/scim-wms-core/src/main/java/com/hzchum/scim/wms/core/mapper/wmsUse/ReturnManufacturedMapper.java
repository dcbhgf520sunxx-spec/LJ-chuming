package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnManufactured;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryReturnManufacturedDTOParam;
import java.time.LocalDateTime;
import java.util.List;

public interface ReturnManufacturedMapper extends BaseMapper<ReturnManufactured> {
   Integer getCount(LocalDateTime date);

   List<ReturnManufactured> list(QueryReturnManufacturedDTOParam param);
}
