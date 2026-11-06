package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsShipmentReceiveApproveDetail;
import java.util.List;

public interface WmsShipmentReceiveApproveDetailMapper extends BaseMapper<WmsShipmentReceiveApproveDetail> {
   List<WmsShipmentReceiveApproveDetail> selectPassListByDetailId(Long detailId);
}
