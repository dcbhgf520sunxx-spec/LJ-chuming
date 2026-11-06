package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventoryManufactured;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryMaterialManufacturedDTOParam;
import java.util.List;

public interface MaterialInventoryManufacturedMapper extends BaseMapper<MaterialInventoryManufactured> {
   List<MaterialInventoryManufactured> list(QueryMaterialManufacturedDTOParam param);

   List<Long> selectProjectIds();
}
