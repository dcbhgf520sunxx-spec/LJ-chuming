package com.hzchum.scim.wms.core.api.service.wmsReport;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.common.core.api.pojo.vo.StatisticsPageVO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.WastageCostSummaryValueDTO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.MoveMaterialMaterialDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.OutboundDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.OutboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.RejectDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.RejectDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.ReturnDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.TransferDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WmsForSaleStatisticsDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthSummaryDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.CutSurplusDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.IdAndMete;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InventoryDetailsRecordDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.PSIRecordDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.RDFeeDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReceiveDateDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReceiveOutboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReportInboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReportOutboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WmsClosingTimeDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ClassCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ClassifyCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ConstructionInboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.DateCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryAmountDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventorySimpleDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MonthInventoryCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.RejectDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsDateMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.MonthTimeRangeDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReceiveDateDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryRejectDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryRejectDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryStatisticsDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ReportService {
   PageVO<ReportInboundDTO> getInbound(QueryReportInboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<ReportOutboundDTO> getOutbound(QueryReportOutboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   InboundDTO getInboundDetailById(Long id);

   PageVO<InboundDetailDTO> getInboundDetails(QueryReportInboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   InboundDetailDO getInboundDetailsCount(QueryReportInboundDTOParam param);

   PageVO<OutboundDetailDO> getOutboundDetail(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   OutboundDetailDO getOutboundDetailCount(QueryDetailDTOParam param);

   BigDecimal getSteelOutboundMete(QueryDetailDTOParam param);

   BigDecimal getReceiptDetailMete(QueryRejectDetailDTOParam param);

   PageVO<TransferDetailDO> getTransferDetail(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   TransferDetailDO getTransferDetailCount(QueryDetailDTOParam param);

   PageVO<ReturnDetailDO> getReturnDetail(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   ReturnDetailDO getReturnDetailCount(QueryDetailDTOParam param);

   PageVO<RejectDO> getRejectList(QueryRejectDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   RejectDO getRejectListCount(QueryRejectDTOParam param);

   PageVO<RejectDetailDO> getRejectDetailList(QueryRejectDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   RejectDetailDTO getRejectDetail(Long id);

   StatisticsPageVO<StatisticsDTO> getStatistics(QueryStatisticsDTOParam param);

   StatisticsPageVO<StatisticsDTO> getStatisticsUser(QueryStatisticsDTOParam param);

   ListVO<StatisticsDetailDTO> getStatisticsDetailUser(
      List<Long> ids, List<Long> statIds, Integer formType, LocalDateTime date, Long wmsClosingTimeId, List<LocalDateTime> dateTimeList
   );

   ListVO<StatisticsDetailDTO> getStatisticsDetail(List<Long> ids, List<Long> statIds, Integer formType, LocalDateTime date);

   Map<String, List<MonthSummaryDO>> getTotalAmount(LocalDateTime year, int amountType);

   Map<String, List<MonthSummaryDO>> getStockAmount(LocalDateTime year, int amountType);

   PageVO<RDFeeDTO> getHighTechRDFee(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<MaterialInventoryDTO> getInventory(
      Integer basicClass,
      List<Long> classifyId,
      Integer orderSupplyType,
      List<Long> workShopIds,
      String specification,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort
   );

   BigDecimal getInventoryMete(Integer basicClass, Long classifyId, List<Long> workshopIds, String specification);

   MaterialInventoryAmountDTO getInventoryAmount();

   List<WmsClosingTimeDTO> getWmsClosingTime();

   boolean setWmsClosingTime(MonthTimeRangeDTOParam monthTimeRangeDTOParam);

   StatisticsPageVO<PSIRecordDTO> getPSIList(
      Integer basicClass,
      List<LocalDateTime> times,
      String spec,
      BigDecimal thickness,
      Long classifyId,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort
   );

   PageVO<MaterialInventoryDTO> getPSIDetailList(
      Long classifyId,
      String spec,
      BigDecimal width,
      BigDecimal length,
      BigDecimal thickness,
      Integer type,
      List<LocalDateTime> times,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort
   );

   PageVO<CutSurplusDTO> getCutSurplus(Long projectId, String cutTaskId, List<LocalDateTime> endTime, Integer pageNumber, Integer pageSize, List<String> sort);

   void calculateAveragePrice(MonthTimeRange monthTimeRange, WeightedPriceConf weightedPriceConf);

   void calculateAveragePriceUser(MonthTimeRange monthTimeRange, WeightedPriceConf weightedPriceConf);

   StatisticsPageVO<StatisticsDTO> getInventoryDetailsRecord(
      List<LocalDateTime> dates, List<Long> classifyId, List<Long> workshopIds, Integer pageNumber, Integer pageSize, List<String> sort
   );

   ListVO<InventoryDetailsRecordDetailDTO> getInventoryDetailsRecordDetail(List<LocalDateTime> dates, String detailKey);

   void saveMonthRecord(MonthTimeRange monthTimeRange, WeightedPriceConf weightedPriceConf, List<Statistics> statistics);

   ReceiveDateDTO getReceiveDate(QueryReceiveDateDTOParam queryReceiveDateDTOParam);

   ReceiveDateDTO getReceiveDateDetail(QueryReceiveDateDTOParam queryReceiveDateDTOParam);

   ReceiveDateDTO getReceiveDateDetailV2(QueryReceiveDateDTOParam queryReceiveDateDTOParam);

   PrintVO<List<ReceiveOutboundDetailDTO>> receiveDatePrint(QueryReceiveDateDTOParam queryReceiveDateDTOParam);

   RejectDetailDO getRejectDetailListCount(QueryRejectDetailDTOParam param);

   PageVO<OutboundDetailDO> getOutsourcingOutboundDetail(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<OutboundDO> getScrapsOutbound(QueryOutboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<OutboundDetailDO> getForSaleOutboundDetail(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   WmsForSaleStatisticsDO getForSaleOutboundDetailCount(QueryDetailDTOParam param);

   WmsForSaleStatisticsDO forSaleStatistics();

   List<IdAndMete> getGroupByProjectOutboundMete();

   List<IdAndMete> getGroupByMesWorkshopOutboundMete();

   List<IdAndMete> getGroupByProjectReturnMete();

   List<IdAndMete> getGroupByMesWorkshopReturnMete();

   List<WastageCostSummaryValueDTO> getGroupByMonthOutboundSummary(
      Long projectId, Long workShopId, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   );

   List<WastageCostSummaryValueDTO> getGroupByMonthReturnSummary(
      Long projectId, Long workShopId, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   );

   List<OutboundDetailDO> getOutboundDetailList(List<LocalDateTime> dateTimeList, Long projectId, Long workShopId, Integer basicClass, String classifyName);

   List<ReturnDetailDO> getReturnDetailList(List<LocalDateTime> dateTimeList, Long projectId, Long workShopId, Integer basicClass, String classifyName);

   List<ConstructionInboundDetailDTO> getConstructionInboundDetailList(List<Long> detailIds);

   List<ClassCostDTO> getOperationsAnalysisInventory(LocalDate yearDate, Integer basicClass, Long branchCompanyId, Long workshopId);

   List<ClassifyCostDTO> getAuxiliaryOrOtherInventory(LocalDate yearDate, Integer basicClass, Long branchCompanyId, Long workshopId);

   PageVO<MaterialInventorySimpleDTO> getInventorySimpleDTOPage(
      LocalDate yearDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId, Integer pageNumber, Integer pageSize
   );

   List<MaterialInventorySimpleDTO> getInventorySimpleDTOList(LocalDate yearDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId);

   List<DateCostDTO> getOperationsAnalysisInventoryGroupByMonth(LocalDate yearDate, Integer basicClass, Long branchCompanyId, Long workshopId);

   PageVO<MaterialInventorySimpleDTO> getOperationsAnalysisInventoryGroupByMonthPageList(
      LocalDate yearMouthDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId, Integer pageNumber, Integer pageSize
   );

   List<MaterialInventorySimpleDTO> getOperationsAnalysisInventoryGroupByMonthList(
      LocalDate yearMouthDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId
   );

   List<ReturnDetail> getOperationsAnalysisReturnDetails(
      Integer basicClass, Long classifyId, Long projectId, LocalDate yearDate, LocalDate mouthDate, Long branchCompanyId, Long workshopId
   );

   List<DateCostDTO> getSurplusMaterialInventoryGroupByMonth(LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<WastageCostSummaryValueDTO> getGroupByMonthOutbound(Long projectId);

   List<WastageCostSummaryValueDTO> getGroupByMonthReturn(Long projectId);

   List<ClassCostDTO> getInventoryAnalysis(LocalDate yearDate, Long branchCompanyId);

   List<MonthInventoryCostDTO> getInventoryInventoryCostDetail(LocalDate yearDate, Long branchCompanyId, Integer basicClass);

   List<DateCostDTO> getInventoryGroupByMonth(LocalDate yearDate, Long branchCompanyId, Integer materialIsWhole, Integer basicClass);

   List<MonthInventoryCostDTO> getInventoryGroupByMonthDetail(LocalDate monthDate, Long branchCompanyId);

   List<WmsDateMeteDTO> getWasteSaleMeteDetail(List<LocalDate> dateList, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<WmsDateMeteDTO> getWasteSaleMete(List<LocalDate> dateList, Long branchCompanyId, Long workshopId);

   PageVO<MoveMaterialMaterialDO> getMoveMaterialDetail(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   MoveMaterialMaterialDO getMoveMaterialDetailCount(QueryDetailDTOParam param);
}
