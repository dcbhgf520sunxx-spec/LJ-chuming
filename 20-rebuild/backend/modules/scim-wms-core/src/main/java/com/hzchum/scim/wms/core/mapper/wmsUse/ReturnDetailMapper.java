package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.common.core.api.pojo.dto.BasicClassMeteAndAmountDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.WastageCostSummaryValueDTO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.CommonDetailsDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.ReturnDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.DownLoadDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.DetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.IdAndMete;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectPickingDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReceiveReturnDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryProjectPickingDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReceiveDateDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ReturnDetailMapper extends BaseMapper<ReturnDetail> {
   @Select("select count(mete) from wms_return_detail where return_id = #{returnId} and material_returnable_id = #{materialReturnableId}")
   BigDecimal getMete(Long returnId, Long materialReturnableId);

   List<ReturnDetailDO> getList(QueryDetailDTOParam param);

   ReturnDetailDO getListCount(QueryDetailDTOParam param);

   List<DetailDTO> getDetailDTO(Long wapId);

   List<MaterialInventoryDTO> getByReId(Long id);

   List<DownLoadDetailDO> getDownLoadDetail(QueryDetailDTOParam param);

   @Select("select ifnull(sum(mete),0) from wms_return_detail where outbound_id = #{id}")
   BigDecimal getMeteById(Long id);

   BigDecimal getAmountByDate(List<Long> ids, LocalDate localDate);

   BigDecimal getSteelTotalAmount(Long projectId, int amountType);

   BigDecimal getTotalMete(@Param("projectId") Long projectId, @Param("year") String year, @Param("basicClass") int basicClass);

   BigDecimal getTotalMeteByDate(Long projectId, LocalDateTime year, int month);

   List<ReturnDetail> queryCurrentMonth(
      @Param("materialReturnableId") Long id, @Param("times") MonthTimeRange monthTimeRange, @Param("classifyIds") List<Long> classifyIds
   );

   List<ReturnDetail> queryCurrentMonthUser(
      @Param("materialReturnableId") Long id, @Param("times") MonthTimeRange monthTimeRange, @Param("classifyIds") List<Long> classifyIds
   );

   List<ReturnDetail> getListByOutboundDetailId(String ids);

   List<ReturnDetailDTO> getListByOutboundDetailIds(List<Long> ids);

   BigDecimal getByWIdDetail(@Param("classifyId") Long classifyId, @Param("date") String date);

   ReturnDetail getByODId(Long id);

   BigDecimal getByYear(String year, int basicClass);

   List<MaterialInventoryDTO> getDetailByCondition(
      @Param("basicClass") Integer basicClass,
      @Param("projectId") Long projectId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<ReceiveReturnDetailDTO> getReturnDetails(QueryReceiveDateDTOParam queryReceiveDateDTOParam);

   List<ReturnDetail> getReturnListByOutboundDetailId(Long id);

   List<ReturnDetail> getReturnList(List<Long> materialReturnableIds);

   List<BasicClassMeteAndAmountDTO> selectCountMeteAndAmount(
      @Param("basicClassList") List<Integer> basicClassList,
      @Param("projectIds") List<Long> projectIds,
      @Param("reviewStatus") Integer reviewStatus,
      @Param("yearMonthListStr") List<String> yearMonthListStr,
      @Param("notClassifyIds") List<Long> notClassifyIds,
      @Param("getClassifyIds") List<Long> getClassifyIds
   );

   List<ReturnDetail> getReturnList();

   List<CommonDetailsDO> groupReturnDetail(
      @Param("basicClassList") List<Integer> basicClassList,
      @Param("projectId") Long projectId,
      @Param("reviewStatus") Integer reviewStatus,
      @Param("yearMonthListStr") List<String> yearMonthListStr,
      @Param("notClassifyIds") List<Long> notClassifyIds,
      @Param("getClassifyIds") List<Long> getClassifyIds
   );

   List<ReturnDetail> projectSteelPickingStatistics(@Param("time") String time, @Param("workshopId") Long workshopId, @Param("timeOne") String timeOne);

   List<ProjectPickingDTO> getProjectPickingReturnDetail(QueryProjectPickingDTOParam param);

   List<ProjectPickingDTO> getProjectPickingSteelReturnMete(QueryProjectPickingDTOParam param);

   List<ProjectPickingDTO> getProjectPickingSectionSteelReturnMete(QueryProjectPickingDTOParam param);

   List<IdAndMete> getGroupByProjectReturnMete();

   List<IdAndMete> getGroupByMesWorkshopReturnMete();

   List<WastageCostSummaryValueDTO> getGroupByMonthReturnSummary(
      Long projectId, Long workShopId, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   );

   List<ReturnDetailDO> getReturnDetailList(List<LocalDateTime> dateTimeList, Long projectId, Long workShopId, Integer basicClass, String classifyName);

   List<ReturnDetail> getOperationsAnalysisReturnDetails(
      Integer basicClass, Long classifyId, Long projectId, LocalDate yearDate, LocalDate mouthDate, Long branchCompanyId, Long workshopId
   );

   List<WastageCostSummaryValueDTO> getGroupByMonthReturn(Long projectId);

   BigDecimal getMaterialReturnMete(Long projectId, Long classifyId);

   List<ReturnDetailDO> selectPassDetail(@Param("workshopId") Long workshopId, @Param("startDay") LocalDateTime startDay, @Param("endDay") LocalDateTime endDay);
}
