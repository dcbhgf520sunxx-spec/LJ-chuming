package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AppInboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ConstructionInboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundDTOParam;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface InboundMapper extends BaseMapper<Inbound> {
   List<Inbound> listInfo(QueryInboundDTOParam dtoParam);

   @Select(
      "SELECT establish_quantity FROM wms_inbound WHERE date_format(create_time, '%Y-%m-%d') = date_format(#{date}, '%Y-%m-%d') and bool_rebuild = 0 order by establish_quantity desc LIMIT 1"
   )
   Integer getMaxDayNumber(LocalDateTime date);

   BigDecimal selectInboundSum(@Param("purchaseOrderId") Long purchaseOrderId, @Param("reviewStatus") Integer reviewStatus);

   void updateEditable(@Param("id") Long id, @Param("value") Integer value);

   List<Inbound> list(QueryReportInboundDTOParam param);

   BigDecimal selectInboundAmountSum(@Param("purchaseId") Long purchaseId, @Param("supplierId") Long supplierId);

   BigDecimal selectInboundAmountSumV2(@Param("purchaseId") Long purchaseId, @Param("supplierId") Long supplierId);

   List<AppInboundDetailDTO> selectAPPInboundDetailDTO(QueryInboundDTOParam dtoParam);

   List<ConstructionInboundDetailDTO> getConstructionInboundDetailList(List<Long> detailIds);
}
