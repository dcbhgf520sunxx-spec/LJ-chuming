package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsForSaleDetail;

public interface WmsForSaleDetailMapper extends BaseMapper<WmsForSaleDetail> {
   // Native draft deletion soft-deletes the outbound detail before clearing its sale rows.
   String OUTBOUND_PARENT_EXISTS_SQL = "SELECT 1 FROM wms_for_sale sale_parent "
      + "INNER JOIN wms_move_outbound_detail outbound_detail ON outbound_detail.outbound_id = sale_parent.outbound_id "
      + "WHERE sale_parent.serial_number = wms_for_sale_detail.for_sale_serial_number "
      + "AND outbound_detail.id = wms_for_sale_detail.outbound_detail_id AND sale_parent.bool_delete_enum = 0";
}
