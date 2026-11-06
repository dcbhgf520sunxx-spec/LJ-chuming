package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryReturnManufacturedDTOParam;
import java.util.List;

public interface ReturnDetailManufacturedMapper extends BaseMapper<ReturnDetailManufactured> {
   List<ReturnDetailManufactured> list(QueryReturnManufacturedDTOParam param);
}
