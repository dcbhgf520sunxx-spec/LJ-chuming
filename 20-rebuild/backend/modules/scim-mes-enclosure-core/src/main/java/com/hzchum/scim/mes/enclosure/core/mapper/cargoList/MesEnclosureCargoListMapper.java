package com.hzchum.scim.mes.enclosure.core.mapper.cargoList;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.vo.BimLogisticsVO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList.CargoListDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList.ProjectCargoListMeteDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList.ShipQuantityGroupByDateDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList.YearCargoListMeteDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.kpi.CarModleKpiDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.kpi.CargoListKpiDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.kpi.ProjectCargoListKpiDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList.MesEnclosureCargoList;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.cargoList.CargoListDOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList.CargoListMeteGroupMonthDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList.ProjectCargoListDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList.ProjectCargoListMeteDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList.ProjectCargoListMeteDetailDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.cargoList.CargoListRecordDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesEnclosureCargoListMapper extends BaseMapper<MesEnclosureCargoList> {
   Long getProjectId(@Param("productId") Long productId, @Param("productType") Integer productType);

   List<CargoListDO> listByCondition(CargoListDOParam param);

   Integer countShipByProjectId(Long projectId);

   List<ShipQuantityGroupByDateDO> sumShipmentQuantityGroupByDate(@Param("projectId") Long projectId, @Param("month") String month);

   List<ProjectCargoListDTO> selectCargoFeeList(@Param("supplierId") Long supplierId, @Param("branchCompanyId") Long branchCompanyId);

   BigDecimal selectFeeSum(
      @Param("supplierId") Long supplierId, @Param("projectId") Long projectId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate
   );

   List<BimLogisticsVO> getArtifactLogisticsByBim(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("planIds") List<Long> planIds,
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

   List<MesEnclosureCargoList> selectCargoListRecord(CargoListRecordDTOParam param);

   List<ProjectCargoListMeteDO> projectCargoListMeteSummary(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("sendStatus") Integer sendStatus,
      @Param("settled") Boolean settled,
      @Param("workshopId") Long workshopId,
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum,
      @Param("projectIds") List<Long> projectIds,
      @Param("type") Integer type
   );

   YearCargoListMeteDO getYearCargoListMeteSummary(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("workshopId") Long workshopId,
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum,
      @Param("projectIds") List<Long> projectIds
   );

   Integer getYearCargoListNumberSummary(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("workshopId") Long workshopId,
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum,
      @Param("projectIds") List<Long> projectIds
   );

   List<ProjectCargoListMeteDetailDTO> projectCargoListMeteDetail(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("planId") Long planId,
      @Param("workshopId") Long workshopId,
      @Param("serialNumber") String serialNumber,
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum
   );

   BigDecimal cargoListMeteSumQuantity(
      @Param("dateTime") LocalDateTime dateTime, @Param("projectId") Long projectId, @Param("type") Integer type, @Param("projectIds") List<Long> projectIds
   );

   BigDecimal cargoListMeteSumMete(
      @Param("dateTime") LocalDateTime dateTime, @Param("projectId") Long projectId, @Param("type") Integer type, @Param("projectIds") List<Long> projectIds
   );

   List<ProjectCargoListMeteDTO> getYearCargoListQuantity(@Param("dateTime") LocalDateTime dateTime, @Param("projectId") Long projectId);

   List<CargoListMeteGroupMonthDTO> getCargoListGroupMonth(LocalDateTime dateTime);
}
