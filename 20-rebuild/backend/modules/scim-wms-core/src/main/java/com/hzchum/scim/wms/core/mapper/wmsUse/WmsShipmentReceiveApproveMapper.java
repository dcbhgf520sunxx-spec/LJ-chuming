package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsShipmentReceiveApprove;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryShipmentReceiveApproveDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface WmsShipmentReceiveApproveMapper extends BaseMapper<WmsShipmentReceiveApprove> {
   List<WmsShipmentReceiveApprove> list(@Param("param") QueryShipmentReceiveApproveDTOParam param);

   @Select("SELECT count(1) FROM wms_shipment_receive_approve WHERE date_format(create_time, '%Y-%m-%d') = date_format(#{date}, '%Y-%m-%d')")
   Integer getCount(LocalDateTime date);
}
