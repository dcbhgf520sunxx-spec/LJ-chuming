package com.hzchum.scim.mes.building.core.api.service.cargoList;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.vo.BimLogisticsVO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.CargoListDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ProjectCargoListEnclosureMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ProjectCargoListMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ShipQuantityGroupByDateDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.YearCargoListMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.CarModleKpiDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.CargoListKpiDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.ProjectCargoListKpiDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.cargoList.CargoListDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.CargoRealtimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.AppEmptyCarsWeighingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoDayOrMonthSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListArtifactTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListDriverDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListEnclosureTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListMaterialDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListMeteGroupMonthDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListAuxiliaryDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListEnclosureDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListMeteDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListSumDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListSumEnclosureDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingWeeklyProductionReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListRecordDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListStatisticsQueryParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save.AppEmptyCarsWeighingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.carGoDetail.RecentlyDespatchVO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingCargoListService extends IService<MesBuildingCargoList> {
   PageVO<CargoListDO> pageByCondition(CargoListDOParam param);

   List<CargoListDO> listByCondition(CargoListDOParam param);

   Integer countShipByProjectId(Long projectId);

   List<String> countShipByProjectIdV2(Long projectId);

   void checkIsLoad(Long projectId, Boolean isModifyTransportMode, Boolean isModifyStructureMeasureMode, List<Integer> categoryList);

   List<ShipQuantityGroupByDateDO> sumShipmentQuantityGroupByDate(Long projectId, String month);

   List<MesBuildingCargoList> countByStatus(int status);

   List<ProjectCargoListDTO> getLogisticsFees(Long supplierId, Long branchCompanyId);

   BigDecimal getShipFeeSum(Long supplierId, Long projectId, LocalDate startDate, LocalDate endDate);

   List<BimLogisticsVO> getArtifactLogisticsByBim(Long projectId, Long monomerId, List<Long> areaIds, Integer productType, Integer status);

   List<CargoListKpiDO> cargoListGroupByMonth(LocalDateTime dateTime);

   BigDecimal cargoListAmountByYear(LocalDateTime dateTime, Integer productType);

   BigDecimal cargoListAmountByDay(LocalDateTime dateTime, Integer productType);

   Integer cargoListQuantityByDay(LocalDateTime dateTime, Integer productType);

   BigDecimal stockByDay(LocalDateTime dateTime, Integer productType);

   List<CargoListKpiDO> cargoListAmountGroupByMonth(LocalDateTime dateTime);

   List<CarModleKpiDO> carModelByYear(LocalDateTime dateTime);

   List<ProjectCargoListKpiDO> projectCargoListByYear(LocalDateTime dateTime);

   List<ProjectCargoListKpiDO> projectCargoListByDay(LocalDateTime dateTime);

   List<MesBuildingCargoList> listCargoRecord(CargoListRecordDTOParam param);

   Boolean saveEmptyCargoList(AppEmptyCarsWeighingDTOParam param);

   Boolean updateEmptyCargoList(AppEmptyCarsWeighingDTOParam param);

   ListVO<AppEmptyCarsWeighingDTO> getEmptyCargoList();

   List<ProjectCargoListMeteDO> projectCargoListMeteSummary(
      LocalDateTime dateTime,
      Integer sendStatus,
      Boolean settled,
      Long workshopId,
      Integer productionLineTypeEnum,
      List<Long> projectIds,
      Integer type,
      String projectName,
      Integer projectStatus
   );

   List<ProjectCargoListMeteDO> projectCargoListMeteSummaryV2(CargoListStatisticsQueryParam param);

   List<ProjectCargoListEnclosureMeteDO> projectCargoListEnclosureProjectSummary(
      LocalDateTime dateTime,
      Integer sendStatus,
      Boolean settled,
      Long workshopId,
      List<Long> projectIds,
      Integer type,
      String projectName,
      Integer projectStatus
   );

   List<ProjectCargoListEnclosureMeteDO> projectCargoListEnclosureProjectSummaryV2(CargoListStatisticsQueryParam param);

   ProjectCargoListSumDetailDTO projectDetailSummary(
      Long projectId, Long monomerId, Long areaId, Long workshopId, LocalDateTime dateTime, LocalDateTime dateMounthTime
   );

   ProjectCargoListSumDetailDTO directShipmentProjectDetailSummary(
      Long projectId, Long monomerId, Long areaId, Long workshopId, LocalDateTime dateTime, LocalDateTime dateMounthTime, List<Integer> productTypeList
   );

   ProjectCargoListSumEnclosureDetailDTO projectEnclosureDetailSummary(
      Long projectId, Integer category, Long enclosurePlanId, Long workshopId, LocalDateTime dateTime, LocalDateTime dateMounthTime
   );

   YearCargoListMeteDO getYearCargoListMeteSummary(
      LocalDateTime dateTime, Long workshopId, Integer productionLineTypeEnum, List<Long> projectIds, Integer projectStatus
   );

   YearCargoListMeteDO getYearCargoListEnclosureMeteSummary(LocalDateTime dateTime, Long workshopId, List<Long> projectIds, Integer projectStatus);

   Integer getYearCargoListNumberSummary(
      LocalDateTime dateTime,
      Long workshopId,
      Integer productionLineTypeEnum,
      List<Long> projectIds,
      Long projectId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer projectStatus
   );

   Integer getYearCargoListEnclosureNumberSummary(
      LocalDateTime dateTime, Long workshopId, List<Long> projectIds, Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer projectStatus
   );

   List<ProjectCargoListMeteDetailDTO> projectCargoListMeteDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      String serialNumber,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate
   );

   List<ProjectCargoListMeteDetailDTO> directShipmentProjectCargoListMeteDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      String serialNumber,
      Integer productionLineTypeEnum,
      List<Integer> productTypeList,
      LocalDateTime startDate,
      LocalDateTime endDate
   );

   List<ProjectCargoListEnclosureDetailDTO> projectCargoListEnclosureDetail(
      Long projectId, Integer category, Long enclosurePlanId, Long workshopId, String serialNumber
   );

   List<ProjectCargoListAuxiliaryDetailDTO> projectCargoListAuxiliaryDetail(
      Long projectId, Long monomerId, Long areaId, Integer category, Long enclosurePlanId, String serialNumber, Integer relationType, Integer projectStatus
   );

   BigDecimal cargoListMeteSumQuantity(
      LocalDateTime dateTime, Long projectId, Integer type, List<Long> projectIds, LocalDateTime auditStartDate, LocalDateTime auditEndDate
   );

   BigDecimal cargoListMeteSumMete(
      LocalDateTime dateTime, Long projectId, Integer type, List<Long> projectIds, LocalDateTime auditStartDate, LocalDateTime auditEndDate
   );

   List<ProjectCargoListMeteDTO> getYearCargoListQuantity(LocalDateTime dateTime, Long projectId);

   List<CargoListMeteGroupMonthDTO> getCargoListGroupMonth(LocalDateTime dateTime);

   List<String> carGoDetailWait();

   List<RecentlyDespatchVO> carGoDetailRecentlyDespatch(Integer size);

   Integer carGoDetailRecentlyCarCount();

   List<CargoListArtifactTypeDTO> projectDetailType(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      LocalDateTime dateMounthTime,
      Integer shipEnumType
   );

   List<CargoListArtifactTypeDTO> directShipmentProjectDetailType(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      LocalDateTime dateTime,
      LocalDateTime dateMounthTime,
      Integer shipEnumType,
      List<Integer> productTypeList
   );

   List<CargoListArtifactTypeDTO> directShipmentProjectDetailTypeV2(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      LocalDateTime dateMounthTime,
      Integer shipEnumType
   );

   List<CargoListEnclosureTypeDTO> projectEnclosureDetailType(
      Long projectId,
      Integer category,
      Long enclosurePlanId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      LocalDateTime dateMounthTime,
      Integer shipEnumType
   );

   BigDecimal getShipMete(Long monomerId, Long areaId);

   BigDecimal getEnclosureShipMete(Long monomerId, Long areaId);

   ListVO<CargoListDriverDTO> getDriverCargoList(String licensePlate);

   CargoListMaterialDTO materialInput(Long deviceId);

   Integer getYearCargoListAllSendSummary(
      LocalDateTime dateTime,
      Long workshopId,
      Integer productionLineTypeEnum,
      List<Long> projectIds,
      Long projectId,
      LocalDateTime startDate,
      LocalDateTime endDate
   );

   List<CargoDayOrMonthSummaryDTO> printShipDayOrMonthSummary(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer type);

   List<MesBuildingWeeklyProductionReportDTO> getMonthlyDispatchReportDetails();

   List<CargoRealtimeInfoDTO> findCargoRealtimeInfo();
}
