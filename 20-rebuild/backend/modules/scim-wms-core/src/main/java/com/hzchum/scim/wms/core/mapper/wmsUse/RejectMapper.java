package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.RejectDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Reject;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.QuantityMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryRejectDTOParam;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface RejectMapper extends BaseMapper<Reject> {
   @Select("SELECT count(*) FROM wms_reject WHERE bool_delete_enum = 0 AND date_format(create_time, '%Y-%m-%d') = date_format(#{date}, '%Y-%m-%d')")
   Integer getMaxDayNumber(LocalDateTime date);

   List<RejectDO> getList(QueryRejectDTOParam param);

   RejectDO getListCount(QueryRejectDTOParam param);

   @Select("select sum(amount_excluding_vat) from wms_reject where inbound_id = #{id}")
   BigDecimal getAmount(Long id);

   @Select("select sum(amount_excluding_vat_no_freight) from wms_reject where inbound_id = #{id}")
   BigDecimal getAmountNoFreight(Long id);

   BigDecimal selectSumRejectAmount(@Param("purchaseOrderId") Long purchaseOrderId, @Param("supplierId") Long supplierId, @Param("inboundId") Long inboundId);

   BigDecimal selectSumRejectAmountV2(@Param("purchaseOrderId") Long purchaseOrderId, @Param("supplierId") Long supplierId, @Param("inboundId") Long inboundId);

   BigDecimal getTotalAmount(List<Long> inboundIds);

   QuantityMeteDTO getCountMete(Long purchaseId, List<Integer> status);
}
