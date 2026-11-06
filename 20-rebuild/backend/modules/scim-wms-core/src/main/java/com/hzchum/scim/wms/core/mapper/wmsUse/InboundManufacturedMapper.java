package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundManufactured;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundManufacturedDTOParam;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface InboundManufacturedMapper extends BaseMapper<InboundManufactured> {
   List<InboundManufactured> listInfo(QueryInboundManufacturedDTOParam queryDTOParam);

   @Select(
      "SELECT establish_quantity FROM wms_inbound_manufactured WHERE date_format(create_time, '%Y-%m-%d') = date_format(#{date}, '%Y-%m-%d') and bool_rebuild = 0 order by establish_quantity desc LIMIT 1"
   )
   Integer getMaxDayNumber(LocalDateTime now);

   void updateEditable(@Param("id") Long id, @Param("value") Integer value);

   BigDecimal selectSunAmount(Long purchaseId);
}
