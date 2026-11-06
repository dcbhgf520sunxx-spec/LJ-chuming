package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPickingApproveDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsPickingApproveDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPickingApproveDetailDTOParam;
import java.util.List;

public interface WmsPickingApproveDetailMapper extends BaseMapper<WmsPickingApproveDetail> {
   List<WmsPickingApproveDetailDTO> selectPassPickingApproveDetails(QueryPickingApproveDetailDTOParam param);
}
