package com.hzchum.scim.mes.building.core.mapper.cargoList;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoDayOrMonthSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListArtifactTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListDriverDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListEnclosureTypeDTO;
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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingCargoListMapper extends BaseMapper<MesBuildingCargoList> {
   Long getProjectId(@Param("productId") Long productId, @Param("productType") Integer productType);

   List<CargoListDO> listByCondition(CargoListDOParam param);

   Integer countShipByProjectId(Long projectId);

   List<String> countShipByProjectIdV2(@Param("projectId") Long projectId);

   List<ShipQuantityGroupByDateDO> sumShipmentQuantityGroupByDate(@Param("projectId") Long projectId, @Param("month") String month);

   List<ProjectCargoListDTO> selectCargoFeeList(@Param("supplierId") Long supplierId, @Param("branchCompanyId") Long branchCompanyId);

   BigDecimal selectFeeSum(
      @Param("supplierId") Long supplierId, @Param("projectId") Long projectId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate
   );

   List<BimLogisticsVO> getArtifactLogisticsByBim(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaIds") List<Long> areaIds,
      @Param("productType") Integer productType,
      @Param("status") Integer status
   );

   List<CargoListKpiDO> cargoListGroupByMonth(@Param("dateTime") LocalDateTime dateTime);

   BigDecimal cargoListAmountByYear(@Param("dateTime") LocalDateTime dateTime, @Param("productType") Integer productType);

   BigDecimal cargoListAmountByDay(@Param("dateTime") LocalDateTime dateTime, @Param("productType") Integer productType);

   Integer cargoListQuantityByDay(@Param("dateTime") LocalDateTime dateTime, @Param("productType") Integer productType);

   BigDecimal stockByDay(@Param("dateTime") LocalDateTime dateTime, @Param("productType") Integer productType);

   List<CargoListKpiDO> cargoListAmountGroupByMonth(@Param("dateTime") LocalDateTime dateTime);

   List<CarModleKpiDO> carModelByYear(@Param("dateTime") LocalDateTime dateTime);

   List<ProjectCargoListKpiDO> projectCargoListByYear(@Param("dateTime") LocalDateTime dateTime);

   List<ProjectCargoListKpiDO> projectCargoListByDay(@Param("dateTime") LocalDateTime dateTime);

   List<MesBuildingCargoList> selectCargoListRecord(CargoListRecordDTOParam param);

   List<ProjectCargoListMeteDO> projectCargoListMeteSummary(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("sendStatus") Integer sendStatus,
      @Param("settled") Boolean settled,
      @Param("workshopId") Long workshopId,
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum,
      @Param("projectIds") List<Long> projectIds,
      @Param("type") Integer type,
      @Param("projectName") String projectName,
      @Param("projectStatus") Integer projectStatus
   );

   List<ProjectCargoListMeteDO> projectCargoListMeteSummaryV2(CargoListStatisticsQueryParam param);

   List<ProjectCargoListEnclosureMeteDO> projectCargoListEnclosureProjectSummary(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("sendStatus") Integer sendStatus,
      @Param("settled") Boolean settled,
      @Param("workshopId") Long workshopId,
      @Param("projectIds") List<Long> projectIds,
      @Param("type") Integer type,
      @Param("projectName") String projectName,
      @Param("projectStatus") Integer projectStatus
   );

   List<ProjectCargoListEnclosureMeteDO> projectCargoListEnclosureProjectSummaryV2(CargoListStatisticsQueryParam param);

   ProjectCargoListSumDetailDTO projectDetailSummary(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("workshopId") Long workshopId,
      @Param("dateTime") LocalDateTime dateTime,
      @Param("dateMounthTime") LocalDateTime dateMounthTime
   );

   ProjectCargoListSumDetailDTO directShipmentProjectDetailSummary(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("workshopId") Long workshopId,
      @Param("dateTime") LocalDateTime dateTime,
      @Param("dateMounthTime") LocalDateTime dateMounthTime,
      @Param("productTypeList") List<Integer> productTypeList
   );

   ProjectCargoListSumEnclosureDetailDTO projectEnclosureDetailSummary(
      @Param("projectId") Long projectId,
      @Param("category") Integer category,
      @Param("enclosurePlanId") Long enclosurePlanId,
      @Param("workshopId") Long workshopId,
      @Param("dateTime") LocalDateTime dateTime,
      @Param("dateMounthTime") LocalDateTime dateMounthTime
   );

   YearCargoListMeteDO getYearCargoListMeteSummary(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("workshopId") Long workshopId,
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum,
      @Param("projectIds") List<Long> projectIds,
      @Param("projectStatus") Integer projectStatus
   );

   YearCargoListMeteDO getYearCargoListEnclosureMeteSummary(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("workshopId") Long workshopId,
      @Param("projectIds") List<Long> projectIds,
      @Param("projectStatus") Integer projectStatus
   );

   Integer getYearCargoListNumberSummary(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("workshopId") Long workshopId,
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum,
      @Param("projectIds") List<Long> projectIds,
      @Param("projectId") Long projectId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("projectStatus") Integer projectStatus
   );

   Integer getYearCargoListEnclosureNumberSummary(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("workshopId") Long workshopId,
      @Param("projectIds") List<Long> projectIds,
      @Param("projectId") Long projectId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("projectStatus") Integer projectStatus
   );

   List<ProjectCargoListMeteDetailDTO> projectCargoListMeteDetail(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("shopId") Long shopId,
      @Param("serialNumber") String serialNumber,
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<ProjectCargoListMeteDetailDTO> directShipProjectCargoListMeteDetail(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("workshopId") Long workshopId,
      @Param("serialNumber") String serialNumber,
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum,
      @Param("productTypeList") List<Integer> productTypeList,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<ProjectCargoListEnclosureDetailDTO> projectCargoListEnclosureDetail(
      @Param("projectId") Long projectId,
      @Param("category") Integer category,
      @Param("enclosurePlanId") Long enclosurePlanId,
      @Param("workshopId") Long workshopId,
      @Param("serialNumber") String serialNumber
   );

   List<ProjectCargoListAuxiliaryDetailDTO> projectCargoListAuxiliaryDetail(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("relationType") Integer relationType,
      @Param("projectStatus") Integer projectStatus
   );

   List<ProjectCargoListAuxiliaryDetailDTO> projectCargoListAuxiliaryDetailV2(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("category") Integer category,
      @Param("enclosurePlanId") Long enclosurePlanId,
      @Param("serialNumber") String serialNumber,
      @Param("relationType") Integer relationType
   );

   BigDecimal cargoListMeteSumQuantity(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("projectId") Long projectId,
      @Param("type") Integer type,
      @Param("projectIds") List<Long> projectIds,
      @Param("auditStartDate") LocalDateTime auditStartDate,
      @Param("auditEndDate") LocalDateTime auditEndDate
   );

   BigDecimal cargoListMeteSumMete(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("projectId") Long projectId,
      @Param("type") Integer type,
      @Param("projectIds") List<Long> projectIds,
      @Param("auditStartDate") LocalDateTime auditStartDate,
      @Param("auditEndDate") LocalDateTime auditEndDate
   );

   List<ProjectCargoListMeteDTO> getYearCargoListQuantity(@Param("dateTime") LocalDateTime dateTime, @Param("projectId") Long projectId);

   List<CargoListMeteGroupMonthDTO> getCargoListGroupMonth(LocalDateTime dateTime);

   List<CargoListArtifactTypeDTO> getCargoDetailByshipEnumType(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("productSourceType") Integer productSourceType,
      @Param("workshopId") Long workshopId,
      @Param("dateTime") LocalDateTime dateTime,
      @Param("dateMounthTime") LocalDateTime dateMounthTime,
      @Param("shipEnumType") Integer shipEnumType
   );

   List<CargoListArtifactTypeDTO> getDirectShipmentCargoDetailByshipEnumType(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("workshopId") Long workshopId,
      @Param("dateTime") LocalDateTime dateTime,
      @Param("dateMounthTime") LocalDateTime dateMounthTime,
      @Param("shipEnumType") Integer shipEnumType,
      @Param("productTypeList") List<Integer> productTypeList
   );

   List<CargoListArtifactTypeDTO> getDirectShipmentCargoDetailByShipEnumTypeV2(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("productSourceType") Integer productSourceType,
      @Param("workshopId") Long workshopId,
      @Param("dateTime") LocalDateTime dateTime,
      @Param("dateMounthTime") LocalDateTime dateMounthTime,
      @Param("shipEnumType") Integer shipEnumType
   );

   List<CargoListEnclosureTypeDTO> getCargoEnclosureDetailByshipEnumType(
      @Param("projectId") Long projectId,
      @Param("category") Integer category,
      @Param("enclosurePlanId") Long enclosurePlanId,
      @Param("serialNumber") String serialNumber,
      @Param("productSourceType") Integer productSourceType,
      @Param("workshopId") Long workshopId,
      @Param("dateTime") LocalDateTime dateTime,
      @Param("dateMounthTime") LocalDateTime dateMounthTime,
      @Param("shipEnumType") Integer shipEnumType
   );

   BigDecimal selectShipMete(@Param("monomerId") Long monomerId, @Param("areaId") Long areaId);

   BigDecimal selectEnclosureShipMete(@Param("monomerId") Long monomerId, @Param("areaId") Long areaId);

   List<CargoListDriverDTO> getDriverCargoList(@Param("licensePlate") String licensePlate);

   Integer getYearCargoListAllSendSummary(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("workshopId") Long workshopId,
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum,
      @Param("projectIds") List<Long> projectIds,
      @Param("projectId") Long projectId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<CargoDayOrMonthSummaryDTO> printShipDayOrMonthSummary(
      @Param("projectId") Long projectId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("type") Integer type
   );

   List<CargoRealtimeInfoDTO> findCargoRealtimeInfo();

   List<MesBuildingWeeklyProductionReportDTO> getMonthlyDispatchReportDetails();

   List<MesBuildingWeeklyProductionReportDTO> getYearslyDispatchReportDetails();
}
