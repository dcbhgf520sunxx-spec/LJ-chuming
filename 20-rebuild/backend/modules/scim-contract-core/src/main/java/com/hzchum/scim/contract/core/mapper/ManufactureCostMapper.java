package com.hzchum.scim.contract.core.mapper;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.CostSummaryValueDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.CostFinishedProductScrapLossDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.CostMainBusinessIncomeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.CostNonMainBusinessIncomeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.CostTransportationDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ManufactureCostAmortizationDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ManufactureCostDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ManufactureCostProductionLaborDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ReimbursementCostDTO;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManufactureCostMapper {
   List<ManufactureCostDTO> manufactureCost(
      @Param("year") String year, @Param("projectId") Long projectId, @Param("noOrProjectName") String noOrProjectName, @Param("status") Integer status
   );

   List<CostSummaryValueDTO> structuralProductOutput(@Param("projectId") Long projectId, @Param("yearMonthDateList") List<LocalDate> yearMonthDateList);

   List<CostNonMainBusinessIncomeDTO> nonMainBusinessIncome(
      @Param("createTimeStartDate") Date createTimeStartDate, @Param("createTimeEndDate") Date createTimeEndDate, @Param("projectId") Long projectId
   );

   CostNonMainBusinessIncomeDTO nonMainBusinessIncomeProject(@Param("yearMonth") String yearMonth, @Param("projectId") Long projectId);

   List<CostMainBusinessIncomeDTO> mainBusinessIncome(
      @Param("createTimeStartDate") Date createTimeStartDate, @Param("createTimeEndDate") Date createTimeEndDate, @Param("projectId") Long projectId
   );

   List<CostFinishedProductScrapLossDTO> finishedProductScrapLoss(
      @Param("createTimeStartDate") Date createTimeStartDate, @Param("createTimeEndDate") Date createTimeEndDate, @Param("projectId") Long projectId
   );

   List<CostTransportationDTO> transportationCost(
      @Param("createTimeStartDate") Date createTimeStartDate,
      @Param("createTimeEndDate") Date createTimeEndDate,
      @Param("projectId") Long projectId,
      @Param("boolTaxIncluded") Boolean boolTaxIncluded
   );

   List<CostSummaryValueDTO> transportationCostSummary(@Param("projectId") Long projectId, @Param("yearMonthDateList") List<LocalDate> yearMonthDateList);

   List<CostSummaryValueDTO> finishedProductScrapLossSummary(@Param("projectId") Long projectId, @Param("yearMonthDateList") List<LocalDate> yearMonthDateList);

   List<CostTransportationDTO> transportationCostExport(@Param("yearMonthBetweenDates") String yearMonthBetweenDates, @Param("projectId") Long projectId);

   List<ManufactureCostAmortizationDTO> waterElectricityPropertyAmortizationList(
      @Param("projectId") Long projectId, @Param("typeList") List<Integer> typeList, @Param("yearMonthDateList") List<LocalDate> yearMonthDateList
   );

   List<ReimbursementCostDTO> directCostList(@Param("projectId") Long projectId, @Param("yearMonthDateList") List<LocalDate> yearMonthDateList);

   List<ReimbursementCostDTO> amortizationCostList(@Param("projectId") Long projectId, @Param("yearMonthDateList") List<LocalDate> yearMonthDateList);

   List<ManufactureCostAmortizationDTO> factoryDepreciationList(
      @Param("projectId") Long projectId, @Param("yearMonthDateList") List<LocalDate> yearMonthDateList
   );

   List<ManufactureCostAmortizationDTO> equipmentDepreciationList(
      @Param("projectId") Long projectId, @Param("yearMonthDateList") List<LocalDate> yearMonthDateList
   );

   List<ReimbursementCostDTO> testingFeeList(@Param("projectId") Long projectId, @Param("yearMonthDateList") List<LocalDate> yearMonthDateList);

   List<ManufactureCostAmortizationDTO> getTotalYieldAndProjectYield(
      @Param("projectId") Long projectId, @Param("yearMonthDateList") List<LocalDate> yearMonthDateList
   );

   Long getsysBranchCompanyByProjectId(@Param("projectId") Long projectId);

   List<ProjectInfo> projectList(@Param("status") Integer status);

   List<ManufactureCostAmortizationDTO> managerAmortizationList(
      @Param("projectId") Long projectId, @Param("yearMonthDateList") List<LocalDate> yearMonthDateList
   );

   List<ManufactureCostProductionLaborDTO> productionLaborCostList(
      @Param("projectId") Long projectId, @Param("yearMonthDateList") List<LocalDate> yearMonthDateList
   );

   List<ManufactureCostAmortizationDTO> tempWorkAmortizationList(
      @Param("projectId") Long projectId, @Param("yearMonthDateList") List<LocalDate> yearMonthDateList
   );
}
