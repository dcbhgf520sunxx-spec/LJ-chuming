package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.VirtualWarehouse;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import java.util.List;

public interface VirtualWarehouseService extends IService<VirtualWarehouse> {
   PageVO<VirtualWarehouse> pageInfo(QueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   void setOutbound();

   void setOutboundUser(MonthTimeRange monthTimeRange);
}
