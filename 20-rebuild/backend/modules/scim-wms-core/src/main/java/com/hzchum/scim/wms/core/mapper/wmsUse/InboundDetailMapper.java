package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.DownLoadDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthSummaryDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.YearSummaryDO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.CommonSummaryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.ReceiptMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.DetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundAmountDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundRecordDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.QuantityMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReconciliationDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPurchaseInboundDetailDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface InboundDetailMapper extends BaseMapper<InboundDetail> {
   @Select("SELECT MIN(COALESCE(d.real_time,d.inbound_time)) FROM wms_inbound_detail d "
      + "JOIN wms_inbound p ON p.id=d.inbound_id "
      + "WHERE d.bool_delete_enum=0 AND p.bool_delete_enum=0 AND p.review_status=2")
   LocalDateTime getFirstApprovedInboundTime();

   @Select("select basic_class from wms_inbound_detail where warehouse_id = #{id} GROUP BY basic_class")
   List<Integer> getBasicClass(Long id);

   @Select("select COUNT(*) from wms_inbound_detail where find_in_set(#{specId},specification_ids) ")
   Integer getSpecCount(Long specId);

   @Select("select reject_status from wms_inbound_detail WHERE inbound_id = #{inboundId} GROUP BY reject_status ORDER BY reject_status LIMIT 1")
   Integer getRejectStatus(Long inboundId);

   List<InboundDetailDO> getReceiptInboundDetail(QueryReportInboundDTOParam param);

   InboundDetailDO getReceiptInboundDetailCount(QueryReportInboundDTOParam param);

   List<DetailDTO> getDetailDTO(Long wapId);

   List<InboundAmountDetailDTO> getListByPOId(Long purchaseOrderId);

   Map<String, BigDecimal> getAmount(Long purchaseOrderId);

   List<InboundRecordDTO> listInboundRecord(
      @Param("purchaseId") Long purchaseId,
      @Param("supplierId") Long supplierId,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate,
      @Param("basicClass") Integer basicClass,
      @Param("classifyId") Long classifyId,
      @Param("classifyName") String classifyName,
      @Param("purchaseSn") String purchaseSn,
      @Param("inboundId") Long inboundId,
      @Param("inboundSn") String inboundSn
   );

   BigDecimal selectInboundAmount(@Param("purchaseId") Long purchaseId, @Param("supplierId") Long supplierId);

   List<MaterialInventoryDTO> getByInId(Long id);

   List<DownLoadDetailDO> getDownLoadDetail(QueryReportInboundDTOParam param);

   List<MonthSummaryDO> selectMonthTotal(LocalDateTime year, Integer basicClass, Long classifyId, Integer thickness, Long specId, Long sectionSteelSpecId);

   List<YearSummaryDO> selectYearTotalSteelPlate(LocalDateTime year, Integer basicClass);

   List<YearSummaryDO> selectYearTotalSectionSteel(LocalDateTime year, Integer basicClass);

   List<Integer> getThickness(Long classifyId);

   Map<String, Long> getQualityTestingById(Long id);

   List<InboundDetailDTO> getQualityTestingList(QueryInboundDTOParam param);

   List<InboundDetailDTO> getList(
      @Param("year") String year,
      @Param("supplierId") Long supplierId,
      @Param("classifyIds") List<Long> classifyIds,
      @Param("purchaseId") Long purchaseId,
      @Param("dateList") List<LocalDateTime> dateList
   );

   List<InboundDetail> getMeteByTimes(
      @Param("basicClass") Integer basicClass,
      @Param("times") List<LocalDateTime> times,
      @Param("spec") String spec,
      @Param("thickness") BigDecimal thickness,
      @Param("classifyId") Long classifyId,
      @Param("ids") List<Long> ids
   );

   List<MaterialInventoryDTO> getPSIInboundDetail(
      @Param("classifyId") Long classifyId,
      @Param("times") List<LocalDateTime> times,
      @Param("spec") String spec,
      @Param("width") BigDecimal width,
      @Param("length") BigDecimal length,
      @Param("thickness") BigDecimal thickness
   );

   BigDecimal getByYear(String year, int basicClass);

   List<InboundDetail> getMeteByProjectId(Long pid, String year, int basicClass);

   List<InboundDetail> getByApplyPurchaseId(Long id);

   QuantityMeteDTO getCountMete(@Param("purchaseId") Long purchaseId, @Param("status") List<Integer> status);

   BigDecimal getStorageQuantity();

   List<InboundDetail> selectPassDetailByPurchaseDetailIds(List<Long> purchaseDetailIds);

   List<InboundDetail> getInboundDetailList(
      @Param("purchaseId") Long purchaseId, @Param("purchaseDetailId") Long purchaseDetailId, @Param("reviewStatus") Integer reviewStatus
   );

   List<ReconciliationDetailDTO> orderReconciliationDetail(@Param("query") QueryPurchaseInboundDetailDTOParam queryDTOParam);

   List<CommonSummaryDTO> getMaterialInboundMete(Integer basicClass, List<Long> classifyIds, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<InboundDetail> getOperationsAnalysisInboundDetail(
      Integer basicClass, List<Long> classifyIds, LocalDate mouthDate, Long branchCompanyId, Long workshopId
   );

   List<InboundDetail> getMaterialInbound(QueryByMaterialDTOParam param);

   List<ReceiptMeteDTO> getPurchaseInboundMete(List<Long> purchaseIds);

   List<InboundDetailDO> selectPassDetail(
      @Param("workshopId") Long workshopId, @Param("startDay") LocalDateTime startDay, @Param("endDay") LocalDateTime endDay
   );
}
