package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.dto.BasicClassMeteAndAmountDTO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.RejectDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.DownLoadDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.RejectDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.ReceiptMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.DetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryRejectDetailDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RejectDetailMapper extends BaseMapper<RejectDetail> {
   List<DetailDTO> getDetailDTO(Long wapId);

   List<MaterialInventoryDTO> getByReId(Long id);

   List<RejectDetail> getDetailByInboundDetailId(Long id);

   List<RejectDetail> getDetailByInboundDetailIds(List<Long> ids);

   BigDecimal getByYear(String year, int basicClass);

   List<RejectDetailDO> getList(QueryRejectDetailDTOParam param);

   RejectDetailDO getListCount(QueryRejectDetailDTOParam param);

   List<DownLoadDetailDO> getDownLoadDetail(QueryRejectDetailDTOParam param);

   List<BasicClassMeteAndAmountDTO> selectCountMeteAndAmount(
      @Param("basicClass") Integer basicClass,
      @Param("time") List<LocalDate> timeList,
      @Param("reviewStatus") Integer reviewStatus,
      @Param("projectId") Long projectId,
      @Param("notClassifyIds") List<Long> notClassifyIds,
      @Param("getClassifyIds") List<Long> getClassifyIds
   );

   List<RejectDetail> selectPassDetailByInboundDetailIds(@Param("inboundDetailIds") List<Long> inboundDetailIds);

   List<ReceiptMeteDTO> getPurchaseRejectMete(List<Long> purchaseIds);

   List<RejectDetailDO> selectPassDetail(@Param("workshopId") Long workshopId, @Param("startDay") LocalDateTime startDay, @Param("endDay") LocalDateTime endDay);
}
