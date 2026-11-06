package com.hzchum.scim.wms.core.api.service.wmsConfig;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.WorkshopDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WarehouseDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WorkshopDTOParam;
import java.util.List;

public interface WorkshopService extends IService<Workshop> {
   PageVO<WorkshopDTO> pageInfo(Boolean enabled, Integer pageNumber, Integer pageSize, List<String> sort, Long factoryId, String name, Integer workshopType);

   Boolean updateWorkshop(WorkshopDTOParam workshopDTOParam);

   Boolean delWorkshop(List<Long> ids);

   Boolean batchAddWorkshop(List<WarehouseDTOParam> list);

   Boolean workshopEditEnabled(Long id, Boolean enabled);

   List<WorkshopDTO> getWorkshopByUser(Long workShopId);
}
