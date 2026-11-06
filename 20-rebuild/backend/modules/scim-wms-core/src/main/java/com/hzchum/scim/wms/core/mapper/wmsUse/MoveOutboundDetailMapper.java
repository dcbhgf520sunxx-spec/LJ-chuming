package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.common.core.api.pojo.common.ProjectAmountInfo;
import com.hzchum.scim.common.core.api.pojo.dto.BasicClassMeteAndAmountDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.WastageCostSummaryValueDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProjectMeteDTO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.CommonDetailsDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.OutboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.DownLoadDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.CommonSummaryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.DeviceDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.IdAndMete;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectPickingDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.RDFeeDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReceiveOutboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.DateCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailBasicDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ProjectOutSummaryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsDateMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDeviceByMaterialDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryProjectPickingDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReceiveDateDTOParam;
import com.hzchum.scim.wms.core.common.SimpleEntityParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MoveOutboundDetailMapper extends BaseMapper<MoveOutboundDetail> {
   @Select("select outbound_time from wms_move_outbound_detail where outbound_id = #{id} ORDER BY outbound_time ")
   List<LocalDateTime> getOutboundTime(Long id);

   List<OutboundDetailDO> getList(QueryDetailDTOParam param);

   List<OutboundDetailDO> getListById(List<Long> ids);

   OutboundDetailDO getListCount(QueryDetailDTOParam param);

   List<DownLoadDetailDO> getDownLoadDetail(QueryDetailDTOParam param);

   BigDecimal getAmountByDate(List<Long> ids, LocalDate localDate);

   List<RDFeeDTO> getRDFeeDetail(QueryDetailDTOParam param);

   BigDecimal getSteelTotalAmount(Long projectId, int amountType);

   BigDecimal getTotalMete(@Param("projectId") Long projectId, @Param("year") String year, @Param("basicClass") int basicClass);

   List<SimpleEntityParam<Integer, BigDecimal>> getMeteByProjectId(Long projectId, LocalDateTime year);

   List<MaterialInventoryDTO> getPSIOutboundDetail(
      @Param("classifyId") Long classifyId,
      @Param("times") List<LocalDateTime> times,
      @Param("spec") String spec,
      @Param("width") BigDecimal width,
      @Param("length") BigDecimal length,
      @Param("thickness") BigDecimal thickness
   );

   List<MaterialInventoryDTO> getPSIOutboundDetailByClassifyIdsAndTimes(@Param("classifyIds") List<Long> classifyIds, @Param("times") List<LocalDateTime> times);

   List<MoveOutboundDetail> queryCurrentMonth(
      @Param("wapId") Long wapId,
      @Param("times") MonthTimeRange monthTimeRange,
      @Param("classifyIds") List<Long> classifyIds,
      @Param("outboundTypeSelection") List<Integer> outboundTypeSelection
   );

   List<MoveOutboundDetail> queryCurrentMonthZi(
      @Param("wapId") Long wapId,
      @Param("times") MonthTimeRange monthTimeRange,
      @Param("classifyIds") List<Long> classifyIds,
      @Param("outboundTypeSelection") List<Integer> outboundTypeSelection
   );

   List<MoveOutboundDetail> getUseDetail(
      @Param("projectId") Long projectId,
      @Param("basicClass") Integer basicClass,
      @Param("classifyIds") List<Long> classifyIds,
      @Param("thickness") BigDecimal thickness,
      @Param("spec") String spec
   );

   List<BriefIdAndNameDTO> getClassIds(@Param("year") String year, @Param("basicClass") int basicClass, @Param("now") LocalDateTime now);

   List<MaterialInventoryDTO> getByWIdDetail(@Param("date") String date, @Param("basicClass") int basicClass);

   BigDecimal getByYear(String year, @Param("basicClass") Integer basicClass);

   List<ProjectAmountInfo> selectProjectOutAmount(@Param("projectIds") List<Long> projectIds, @Param("basicClassEnum") Integer basicClassEnum);

   List<MonthAmountInfo> selectMonthOutAmount(
      @Param("startMonth") Integer startMonth, @Param("endMonth") Integer endMonth, @Param("basicClassEnum") Integer basicClassEnum
   );

   BigDecimal getDeliveryVolume();

   List<OutboundDetailDTO> getDetailByCondition(
      @Param("basicClass") Integer basicClass,
      @Param("projectId") Long projectId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<OutboundDetailBasicDTO> getMeteByProject(
      @Param("basicClass") Integer basicClass,
      @Param("projectIds") List<Long> projectIds,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<BasicClassMeteAndAmountDTO> selectCountMeteAndAmount(
      @Param("basicClassList") List<Integer> basicClassList,
      @Param("projectIds") List<Long> projectIds,
      @Param("reviewStatus") Integer reviewStatus,
      @Param("yearMonthListStr") List<String> yearMonthListStr,
      @Param("notClassifyIds") List<Long> notClassifyIds,
      @Param("getClassifyIds") List<Long> getClassifyIds
   );

   List<CommonDetailsDO> groupOutboundDetail(
      @Param("basicClassList") List<Integer> basicClassList,
      @Param("projectId") Long projectId,
      @Param("reviewStatus") Integer reviewStatus,
      @Param("yearMonthListStr") List<String> yearMonthListStr,
      @Param("notClassifyIds") List<Long> notClassifyIds,
      @Param("getClassifyIds") List<Long> getClassifyIds
   );

   List<ReceiveOutboundDetailDTO> getMoveOutboundDetails(QueryReceiveDateDTOParam queryReceiveDateDTOParam);

   List<OutboundDetailDO> getListV2(QueryDetailDTOParam param);

   List<DownLoadDetailDO> getDownLoadOutsourcingOrScrapsDetail(QueryDetailDTOParam param);

   BigDecimal steelCountMete(QueryDetailDTOParam param);

   List<MoveOutboundDetail> projectSteelPickingStatistics(@Param("time") String time, @Param("workshopId") Long workshopId, @Param("timeOne") String timeOne);

   List<DeviceDetailDTO> getDeviceDetail(QueryDeviceByMaterialDtoParam queryReceiveDateDTOParam);

   List<ProjectPickingDTO> getProjectPicking(QueryProjectPickingDTOParam param);

   List<ProjectPickingDTO> getProjectPickingSteelMete(QueryProjectPickingDTOParam param);

   List<ProjectPickingDTO> getProjectPickingSectionSteelMete(QueryProjectPickingDTOParam param);

   List<IdAndMete> getGroupByProjectOutboundMete();

   List<IdAndMete> getGroupByMesWorkshopOutboundMete();

   List<WastageCostSummaryValueDTO> getGroupByMonthOutboundSummary(
      Long projectId, Long workShopId, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   );

   List<OutboundDetailDO> getOutboundDetailList(List<LocalDateTime> dateTimeList, Long projectId, Long workShopId, Integer basicClass, String classifyName);

   List<WmsDateMeteDTO> getMaterialLossMete(
      Integer basicClassEnum, List<Long> projectIds, LocalDate startDate, LocalDate endDate, Long branchCompanyId, Long workshopId
   );

   List<WmsDateMeteDTO> getMainOutMeteV2(List<LocalDate> dateList, Long branchCompanyId, Long workshopId);

   List<WmsDateMeteDTO> getMainOutMeteDetailV2(List<LocalDate> dateList, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<ProjectMeteDTO> getMaterialLossDetails(Integer basicClass, LocalDate mouthDate, Long branchCompanyId, Long workshopId);

   List<DateCostDTO> getMaterialLossCost(Integer basicClassEnum, List<Long> projectIds, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<CommonSummaryDTO> getMaterialOutMete(Integer basicClass, List<Long> classifyIds, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<MoveOutboundDetail> getOperationsAnalysisOutDetails(
      Integer basicClass, List<Long> classifyIds, Long projectId, LocalDate yearDate, LocalDate mouthDate, Long branchCompanyId, Long workshopId
   );

   List<ProjectOutSummaryDTO> getProjectOutSummaryList(Integer status, Integer basicClass, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<WastageCostSummaryValueDTO> getGroupByMonthOutbound(Long projectId);

   List<CommonSummaryDTO> getMaterialOutMeteV2(Integer basicClass, List<Long> classifyIds, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   BigDecimal getMaterialOutboundMete(Long projectId, Long classifyId);

   List<OutboundDetailDO> getListNewOne(QueryDetailDTOParam queryDetailDTOParam);

   List<OutboundDetailDO> selectPassDetail(
      @Param("workshopId") Long workshopId,
      @Param("startDay") LocalDateTime startDay,
      @Param("endDay") LocalDateTime endDay,
      @Param("projectIds") List<Long> projectIds,
      @Param("basicClass") Integer basicClass
   );
}
