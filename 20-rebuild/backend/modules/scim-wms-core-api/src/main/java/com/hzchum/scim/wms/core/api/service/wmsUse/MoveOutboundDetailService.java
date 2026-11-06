package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectAmountInfo;
import com.hzchum.scim.common.core.api.pojo.dto.CostSummaryValueDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProjectMeteDTO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.CommonDetailsDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.OutboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.CommonSummaryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.DeviceDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.DateCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ProjectOutSummaryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ProjectSteelPickingStatistics;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsDateMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDeviceByMaterialDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchDeviceOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.DeviceOutboundDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MoveOutboundDetailService extends IService<MoveOutboundDetail> {
   List<ProjectAmountInfo> listProjectOutboundAmount(List<Long> projectIds, Integer basicClassEnum);

   List<MonthAmountInfo> listMonthOutboundAmount(Integer startMonth, Integer endMonth, Integer basicClassEnum);

   List<CostSummaryValueDTO> getMeteByProjectId(
      List<Integer> basicClassList,
      Long projectId,
      List<LocalDate> yearMonthList,
      List<Long> notClassifyIds,
      List<Long> getClassifyIds,
      List<String> notClassifyNameList,
      List<String> getClassifyNameList,
      Boolean boolTaxIncluded
   );

   Map<Long, List<CostSummaryValueDTO>> getMeteByProjectIds(
      List<Integer> basicClassList,
      List<Long> projectIds,
      List<LocalDate> yearMonthList,
      List<Long> notClassifyIds,
      List<Long> getClassifyIds,
      List<String> notClassifyNameList,
      List<String> getClassifyNameList,
      Boolean boolTaxIncluded
   );

   List<CommonDetailsDO> groupOutboundDetail(
      List<Integer> basicClassList,
      Long projectId,
      List<LocalDate> yearMonthList,
      List<Long> notClassifyIds,
      List<Long> getClassifyIds,
      List<String> notClassifyNameList,
      List<String> getClassifyNameList
   );

   List<ProjectSteelPickingStatistics> projectSteelPickingStatistics(String time, Long workshopId);

   BigDecimal getDeliveryVolume();

   Boolean saveOutBound(BatchDeviceOutboundDTOParam batchDeviceOutboundDTOParam, DeviceOutboundDTOParam param);

   Boolean batchOutbound(BatchDeviceOutboundDTOParam param);

   List<DeviceDetailDTO> getDeviceDetail(QueryDeviceByMaterialDtoParam queryReceiveDateDTOParam);

   List<WmsDateMeteDTO> getMaterialLossMete(
      Integer basicClassEnum, List<Long> projectIds, LocalDate startDate, LocalDate endDate, Long branchCompanyId, Long workshopId
   );

   List<ProjectMeteDTO> getMaterialLossDetails(Integer basicClass, LocalDate mouthDate, Long branchCompanyId, Long workshopId);

   List<DateCostDTO> getMaterialLossCost(Integer basicClassEnum, List<Long> projectIds, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<CommonSummaryDTO> getMaterialOutMete(Integer basicClass, List<Long> classifyIds, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<MoveOutboundDetail> getOperationsAnalysisOutDetails(
      Integer basicClass, List<Long> classifyIds, Long projectId, LocalDate yearDate, LocalDate mouthDate, Long branchCompanyId, Long workshopId
   );

   List<ProjectOutSummaryDTO> getProjectOutSummaryList(Integer status, Integer basicClass, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<WmsDateMeteDTO> getMainOutMeteV2(List<LocalDate> dateList, Long branchCompanyId, Long workshopId);

   List<WmsDateMeteDTO> getMainOutMeteDetailV2(List<LocalDate> dateList, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<CommonSummaryDTO> getMaterialOutMeteV2(Integer basicClass, List<Long> classifyIds, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<OutboundDetailDO> getListNewOne(QueryDetailDTOParam queryDetailDTOParam);

   List<OutboundDetailDO> selectPassDetail(Long workshopId, LocalDateTime startDay, LocalDateTime endDay, List<Long> projectIds, Integer basicClass);
}
