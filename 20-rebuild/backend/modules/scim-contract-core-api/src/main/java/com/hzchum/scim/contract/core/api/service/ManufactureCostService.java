package com.hzchum.scim.contract.core.api.service;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.CostSummaryDTO;
import com.hzchum.scim.contract.core.api.pojo._do.CommonDetailsDO;
import com.hzchum.scim.contract.core.api.pojo.dto.CostFinishedProductScrapLossDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.CostMainBusinessIncomeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.CostNonMainBusinessIncomeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.CostTransportationDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ManufactureCostAmortizationDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ManufactureCostDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ManufactureCostProductionLaborDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ReimbursementCostDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectMaterialsAllDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectLedgerSupplierInvoiceDetailDTO;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface ManufactureCostService {
   List<ProjectInfo> projectList(Integer status);

   PageVO<ManufactureCostDTO> manufactureCostPage(String year, Long projectId, Integer status, Boolean boolTaxIncluded, Integer pageNumber, Integer pageSize);

   List<ManufactureCostDTO> manufactureCostList(String year, Long projectId, Integer status, Boolean boolTaxIncluded);

   PrintVO<List<Map<String, Object>>> manufactureCostPrint(HttpServletResponse response, String year, Long projectId, Integer status, Boolean boolTaxIncluded);

   Map<String, BigDecimal> manufactureCostTotal(String year, Long projectId, Integer status, Boolean boolTaxIncluded);

   List<CostSummaryDTO> costSummary(Long projectId, Boolean boolTaxIncluded);

   void costSummaryExport(HttpServletResponse response, Long projectId, Boolean boolTaxIncluded);

   List<CostNonMainBusinessIncomeDTO> nonMainBusinessIncome(Date createTimeStartDate, Date createTimeEndDate, Long projectId);

   PrintVO<List<Map<String, Object>>> nonMainBusinessIncomePrint(Date createTimeStartDate, Date createTimeEndDate, Long projectId, Boolean boolTaxIncluded);

   List<CostMainBusinessIncomeDTO> mainBusinessIncome(Date createTimeStartDate, Date createTimeEndDate, Long projectId);

   PrintVO<List<Map<String, Object>>> mainBusinessIncomePrint(Date createTimeStartDate, Date createTimeEndDate, Long projectId, Boolean boolTaxIncluded);

   List<CostFinishedProductScrapLossDTO> finishedProductScrapLoss(Date createTimeStartDate, Date createTimeEndDate, Long projectId);

   PrintVO<List<Map<String, Object>>> finishedProductScrapLossPrint(Date createTimeStartDate, Date createTimeEndDate, Long projectId);

   List<CostTransportationDTO> transportationCost(Date createTimeStartDate, Date createTimeEndDate, Long projectId, Boolean boolTaxIncluded);

   PrintVO<List<Map<String, Object>>> transportationCostPrint(Date createTimeStartDate, Date createTimeEndDate, Long projectId, Boolean boolTaxIncluded);

   List<ManufactureCostAmortizationDTO> waterElectricityPropertyAmortization(Long projectId, List<Integer> typeList);

   PrintVO<List<Map<String, Object>>> waterElectricityPropertyAmortizationPrint(Long projectId, List<Integer> typeList);

   List<ReimbursementCostDTO> directCost(Long projectId);

   PrintVO<List<Map<String, Object>>> directCostPrint(Long projectId);

   List<ReimbursementCostDTO> amortizationCost(Long projectId);

   PrintVO<List<Map<String, Object>>> amortizationCostPrint(Long projectId);

   List<ManufactureCostAmortizationDTO> factoryDepreciation(Long projectId);

   PrintVO<List<Map<String, Object>>> factoryDepreciationPrint(Long projectId);

   List<ManufactureCostAmortizationDTO> equipmentDepreciation(Long projectId);

   PrintVO<List<Map<String, Object>>> equipmentDepreciationPrint(Long projectId);

   List<ReimbursementCostDTO> testingFee(Long projectId);

   PrintVO<List<Map<String, Object>>> testingFeePrint(Long projectId);

   List<Map<String, List<CommonDetailsDO>>> mainMaterialsStatistics(Long projectId, Integer basicMaterialClassEnum);

   PrintVO<List<Map<String, Object>>> mainMaterialsStatisticsPrint(Long projectId, Integer basicMaterialClassEnum, Boolean boolTaxIncluded);

   List<Map<String, List<CommonDetailsDO>>> auxiliaryMaterialsDirectCost(Long projectId);

   PrintVO<List<Map<String, Object>>> auxiliaryMaterialsDirectCostPrint(Long projectId, Boolean boolTaxIncluded);

   List<ManufactureCostAmortizationDTO> auxiliaryMaterialsAmortizationCost(Long projectId, Boolean boolTaxIncluded);

   PrintVO<List<Map<String, Object>>> auxiliaryMaterialsAmortizationCostPrint(Long projectId, Boolean boolTaxIncluded);

   List<Map<String, List<CommonDetailsDO>>> paintCost(Long projectId);

   PrintVO<List<Map<String, Object>>> paintCostPrint(Long projectId, Boolean boolTaxIncluded);

   List<Map<String, List<CommonDetailsDO>>> weldingConsumableCost(Long projectId);

   PrintVO<List<Map<String, Object>>> weldingConsumableCostPrint(Long projectId, Boolean boolTaxIncluded);

   List<ProjectMaterialsAllDto> getSendDirectlyConstructionSiteMaterialCostList(Long projectId);

   PrintVO<List<ProjectMaterialsAllDto>> printSendDirectlyConstructionSiteMaterialCostList(Long projectId);

   List<ProjectLedgerSupplierInvoiceDetailDTO> getSendDirectlyConstructionSiteOrderPaymentList(Long orderId);

   PrintVO<List<ProjectLedgerSupplierInvoiceDetailDTO>> printSendDirectlyConstructionSiteOrderPaymentList(Long orderId);

   List<ManufactureCostAmortizationDTO> gasFee(Long projectId, Boolean boolTaxIncluded);

   PrintVO<List<Map<String, Object>>> gasFeePrint(Long projectId, Boolean boolTaxIncluded);

   List<Map<String, List<CommonDetailsDO>>> gasDirectCost(Long projectId);

   PrintVO<List<Map<String, Object>>> gasDirectCostPrint(Long projectId, Boolean boolTaxIncluded);

   List<ManufactureCostAmortizationDTO> managerAmortizationCost(Long projectId);

   PrintVO<List<Map<String, Object>>> managerAmortizationCostPrint(Long projectId);

   List<Map<String, List<ManufactureCostProductionLaborDTO>>> productionLaborCost(Long projectId);

   PrintVO<List<Map<String, Object>>> productionLaborCostPrint(Long projectId);

   List<ManufactureCostAmortizationDTO> tempWorkAmortizationCost(Long projectId);

   PrintVO<List<Map<String, Object>>> tempWorkAmortizationCostPrint(Long projectId);

   List<ManufactureCostAmortizationDTO> otherSteelMaterialsAmortization(Long projectId, Boolean boolTaxIncluded);

   PrintVO<List<Map<String, Object>>> otherSteelMaterialsAmortizationPrint(Long projectId, Boolean boolTaxIncluded);
}
