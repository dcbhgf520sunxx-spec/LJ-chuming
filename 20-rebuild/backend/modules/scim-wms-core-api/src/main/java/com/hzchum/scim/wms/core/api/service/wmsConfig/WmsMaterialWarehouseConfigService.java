package com.hzchum.scim.wms.core.api.service.wmsConfig;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsMaterialWarehouseConfig;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.WmsMaterialWarehouseConfigDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.MaterialWarehouseDTOParam;
import java.util.List;

public interface WmsMaterialWarehouseConfigService extends IService<WmsMaterialWarehouseConfig> {
   Boolean addWmsMaterialWarehouseConfig(MaterialWarehouseDTOParam request);

   List<WmsMaterialWarehouseConfigDTO> getWmsMaterialWarehouseConfig();

   Boolean updateWmsMaterialWarehouseConfig(MaterialWarehouseDTOParam request);

   Boolean deleteWmsMaterialWarehouseConfig(List<Long> ids);
}
