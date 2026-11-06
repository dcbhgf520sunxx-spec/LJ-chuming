package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.OutboundDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutboundMapper extends BaseMapper<Outbound> {
   Integer getCount(LocalDateTime date);

   List<Outbound> getOutboundList(QueryOutboundDTOParam param);

   List<BriefIdAndSNDTO> getSNById(@Param("ids") List<Long> ids);

   List<OutboundDetailDTO> getByOutId(Long id);

   Integer getUnReviewed(Long projectId, Integer reviewStatus);

   List<Outbound> getOutboundListV2(QueryOutboundDTOParam param);

   List<OutboundDO> getList(QueryOutboundDTOParam param);

   List<Outbound> getNestingDockingOutboundList(QueryOutboundDTOParam param);

   List<Outbound> list(QueryReportOutboundDTOParam param);

   List<MoveOutboundDetail> getPassOrderDetail(@Param("basicClass") Integer basicClass, @Param("workshopId") Long workshopId, @Param("size") int size);
}
