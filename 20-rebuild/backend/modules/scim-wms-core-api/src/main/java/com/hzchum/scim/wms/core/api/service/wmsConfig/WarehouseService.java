package com.hzchum.scim.wms.core.api.service.wmsConfig;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.WarehouseDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WarehouseDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchWarehouseDTOParam;
import java.util.List;

public interface WarehouseService extends IService<Warehouse> {
   List<BriefIdAndNameDTO> getWorkshopList();

   List<BriefIdAndNameDTO> getWorkshopListV2();

   PageVO<Warehouse> pageInfo(Boolean enabled, Long workshopId, Integer page, Integer size, List<String> sort);

   PageVO<WarehouseDTO> pageInfoV2(Boolean enabled, Long workshopId, Integer materialType, Integer page, Integer size, List<String> sort, String name);

   List<Warehouse> listInfo(Boolean enabled, Long workshopId);

   List<WarehouseDTO> listInfoV2(Boolean enabled, Long workshopId, Integer materialType, String Name);

   Boolean addWarehouse(List<WarehouseDTOParam> dtoParams);

   Boolean updateWarehouse(WarehouseDTOParam dtoParam);

   Boolean delete(List<Long> ids);

   Boolean editEnabled(Long id, Boolean enabled);

   Boolean batchAddWarehouse(BatchWarehouseDTOParam param);

   List<BriefIdAndNameDTO> getWorkshopListV2One();
}
