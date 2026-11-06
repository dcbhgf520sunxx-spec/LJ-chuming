package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPicking;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsPickingDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.WmsPickingDTOParam;
import java.util.List;

public interface WmsPickingMapper extends BaseMapper<WmsPicking> {
   List<WmsPickingDTO> getWmsPickingList(WmsPickingDTOParam param);

   List<WmsPickingDTO> getPickingDTOByIds(List<Long> ids);
}
