package com.hzchum.scim.rest.controller.contract;

import org.springframework.security.access.prepost.PreAuthorize;
import cn.hutool.core.date.DateUtil;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.common.core.api.enums.HandleMethodEnum;
import com.hzchum.scim.common.core.api.enums.WasteHandleMethodEnum;
import com.hzchum.scim.common.core.api.pojo.dto.CostSummaryDTO;
import com.hzchum.scim.contract.core.api.biz.ContractScrapRecycleLedgerBiz;
import com.hzchum.scim.contract.core.api.biz.ContractScrapSaleLedgerBiz;
import com.hzchum.scim.contract.core.api.enums.finance.WaterElectricityPropertyFeeTypeEnum;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractReturnProductDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.CostFinishedProductScrapLossDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.CostMainBusinessIncomeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.CostNonMainBusinessIncomeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.CostTransportationDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectMaterialsAllDto;
import com.hzchum.scim.contract.core.api.service.ManufactureCostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "制造成本统计")
@Validated
@RestController
@RequestMapping("/api/contract/manufacturecost")
public class ManufactureCostController {
   private static final Logger log = LoggerFactory.getLogger(ManufactureCostController.class);
   @Resource
   private ManufactureCostService manufactureCostService;
   @Resource
   private ContractScrapRecycleLedgerBiz contractScrapRecycleLedgerBiz;
   @Resource
   private ContractScrapSaleLedgerBiz contractScrapSaleLedgerBiz;

   @ApiOperation("制造成本统计 获取项目下拉框")
   @GetMapping("/project-list")
   public ResultVO projectList(@RequestParam(required = false) Integer status) {
      return ResultBuilder.success(this.manufactureCostService.projectList(status));
   }

   @ApiOperation("制造成本统计 制造成本统计")
   @GetMapping("/manufactureCost/page")
   @PreAuthorize("@permission.check('fabricating_cost_statistics:get')")
   public ResultVO manufactureCost(
      @RequestParam(required = false) String year,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Integer status,
      @RequestParam(defaultValue = "true") Boolean boolTaxIncluded,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      return ResultBuilder.success(this.manufactureCostService.manufactureCostPage(year, projectId, status, boolTaxIncluded, pageNumber, pageSize));
   }

   @ApiOperation("制造成本统计 制造成本统计-导出")
   @GetMapping("/manufactureCost/print")
   @PreAuthorize("@permission.check('fabricating_cost_statistics:print')")
   @SignerCheck(boolMethodAndClassName = true, message = "当前正在打印中, 请稍后重试", timeout = 60L)
   public ResultVO manufactureCostPrint(
      HttpServletResponse response,
      @RequestParam(required = false) String year,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Integer status,
      @RequestParam(defaultValue = "true") Boolean boolTaxIncluded
   ) {
      log.info("API调用: 制造成本统计-制造成本统计-导出");
      return ResultBuilder.success(this.manufactureCostService.manufactureCostPrint(response, year, projectId, status, boolTaxIncluded));
   }

   @ApiOperation("制造成本统计 制造成本统计-合计")
   @GetMapping("/manufactureCost/total")
   @PreAuthorize("@permission.check('fabricating_cost_statistics:get')")
   public ResultVO manufactureCostTotal(
      @RequestParam(required = false) String year,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Integer status,
      @RequestParam(defaultValue = "true") Boolean boolTaxIncluded
   ) {
      log.info("API调用: 制造成本统计-制造成本统计-合计");
      return ResultBuilder.success(this.manufactureCostService.manufactureCostTotal(year, projectId, status, boolTaxIncluded));
   }

   @ApiOperation("制造成本统计 成本汇总")
   @GetMapping("/costSummary")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO<List<CostSummaryDTO>> costSummary(
      @RequestParam(required = false) Long projectId, @RequestParam(defaultValue = "true") Boolean boolTaxIncluded
   ) {
      return ResultBuilder.success(this.manufactureCostService.costSummary(projectId, boolTaxIncluded));
   }

   @ApiOperation("制造成本统计 成本汇总excel导出")
   @GetMapping("/costSummaryExport")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public void costSummaryExport(
      HttpServletResponse response, @RequestParam(required = false) Long projectId, @RequestParam(defaultValue = "true") Boolean boolTaxIncluded
   ) {
      this.manufactureCostService.costSummaryExport(response, projectId, boolTaxIncluded);
   }

   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "createTimeStart", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "createTimeEnd", value = "结束时间", paramType = "query"),
            @ApiImplicitParam(name = "projectName", value = "项目名称", paramType = "query")
      }
   )
   @ApiOperation("制造成本统计 非主营业务收入")
   @GetMapping("/nonMainBusinessIncome")
   @PreAuthorize("@permission.check('fortune_report_cost:non_main_business_income')")
   public ResultVO<List<CostNonMainBusinessIncomeDTO>> nonMainBusinessIncome(
      @RequestParam(required = false) String createTimeStart,
      @RequestParam(required = false) String createTimeEnd,
      @RequestParam(required = false) Long projectId
   ) {
      Date createTimeStartDate = null;
      Date createTimeEndDate = null;
      if (createTimeStart != null && createTimeEnd != null) {
         createTimeStartDate = new Date(Long.parseLong(createTimeStart));
         createTimeEndDate = new Date(Long.parseLong(createTimeEnd));
         createTimeStartDate = DateUtil.beginOfDay(createTimeStartDate);
         createTimeEndDate = DateUtil.endOfDay(createTimeEndDate);
      }

      log.info("制造成本统计 非主营业务收入 createTimeStart:{},createTimeEnd:{},projectId:{}", createTimeStart, createTimeEnd, projectId);
      return ResultBuilder.success(this.manufactureCostService.nonMainBusinessIncome(createTimeStartDate, createTimeEndDate, projectId));
   }

   @ApiOperation("制造成本统计 非主营业务收入打印")
   @GetMapping("/nonMainBusinessIncome/print")
   @PreAuthorize("@permission.check('fortune_report_cost:non_main_business_income_print')")
   public ResultVO<PrintVO> nonMainBusinessIncomePrint(
      @RequestParam(required = false) String createTimeStart,
      @RequestParam(required = false) String createTimeEnd,
      Boolean boolTaxIncluded,
      @RequestParam(required = false) Long projectId
   ) {
      Date createTimeStartDate = null;
      Date createTimeEndDate = null;
      if (createTimeStart != null && createTimeEnd != null) {
         createTimeStartDate = new Date(Long.parseLong(createTimeStart));
         createTimeEndDate = new Date(Long.parseLong(createTimeEnd));
         createTimeStartDate = DateUtil.beginOfDay(createTimeStartDate);
         createTimeEndDate = DateUtil.endOfDay(createTimeEndDate);
      }

      log.info("制造成本统计 非主营业务收入打印 createTimeStart:{},createTimeEnd:{},projectId:{}", createTimeStart, createTimeEnd, projectId);
      return ResultBuilder.success(this.manufactureCostService.nonMainBusinessIncomePrint(createTimeStartDate, createTimeEndDate, projectId, boolTaxIncluded));
   }

   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "createTimeStart", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "createTimeEnd", value = "结束时间", paramType = "query"),
            @ApiImplicitParam(name = "projectName", value = "项目名称", paramType = "query")
      }
   )
   @ApiOperation("制造成本统计 主营收入")
   @GetMapping("/mainBusinessIncome")
   @PreAuthorize("@permission.check('fortune_report_cost:main_business_income')")
   public ResultVO<List<CostMainBusinessIncomeDTO>> mainBusinessIncome(
      @RequestParam(required = false) String createTimeStart,
      @RequestParam(required = false) String createTimeEnd,
      @RequestParam(required = false) Long projectId
   ) {
      Date createTimeStartDate = null;
      Date createTimeEndDate = null;
      if (createTimeStart != null && createTimeEnd != null) {
         createTimeStartDate = new Date(Long.parseLong(createTimeStart));
         createTimeEndDate = new Date(Long.parseLong(createTimeEnd));
         createTimeStartDate = DateUtil.beginOfDay(createTimeStartDate);
         createTimeEndDate = DateUtil.endOfDay(createTimeEndDate);
      }

      log.info("制造成本统计 非主营业务收入 createTimeStart:{},createTimeEnd:{},projectId:{}", createTimeStart, createTimeEnd, projectId);
      return ResultBuilder.success(this.manufactureCostService.mainBusinessIncome(createTimeStartDate, createTimeEndDate, projectId));
   }

   @ApiOperation("制造成本统计 主营收入打印")
   @GetMapping("/mainBusinessIncome/print")
   @PreAuthorize("@permission.check('fortune_report_cost:main_business_income_print')")
   public ResultVO<PrintVO> mainBusinessIncomePrint(
      @RequestParam(required = false) String createTimeStart,
      @RequestParam(required = false) String createTimeEnd,
      Boolean boolTaxIncluded,
      @RequestParam(required = false) Long projectId
   ) {
      Date createTimeStartDate = null;
      Date createTimeEndDate = null;
      if (createTimeStart != null && createTimeEnd != null) {
         createTimeStartDate = new Date(Long.parseLong(createTimeStart));
         createTimeEndDate = new Date(Long.parseLong(createTimeEnd));
         createTimeStartDate = DateUtil.beginOfDay(createTimeStartDate);
         createTimeEndDate = DateUtil.endOfDay(createTimeEndDate);
      }

      log.info("制造成本统计 非主营业务收入 createTimeStart:{},createTimeEnd:{},projectId:{}", createTimeStart, createTimeEnd, projectId);
      return ResultBuilder.success(this.manufactureCostService.mainBusinessIncomePrint(createTimeStartDate, createTimeEndDate, projectId, boolTaxIncluded));
   }

   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "createTimeStart", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "createTimeEnd", value = "结束时间", paramType = "query"),
            @ApiImplicitParam(name = "projectName", value = "项目名称", paramType = "query")
      }
   )
   @ApiOperation("制造成本统计 制成品报废损失")
   @GetMapping("/finishedProductScrapLoss")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO<List<CostFinishedProductScrapLossDTO>> scrapLoss(
      @RequestParam(required = false) String createTimeStart,
      @RequestParam(required = false) String createTimeEnd,
      @RequestParam(required = false) Long projectId
   ) {
      Date createTimeStartDate = null;
      Date createTimeEndDate = null;
      if (createTimeStart != null && createTimeEnd != null) {
         createTimeStartDate = new Date(Long.parseLong(createTimeStart));
         createTimeEndDate = new Date(Long.parseLong(createTimeEnd));
         createTimeStartDate = DateUtil.beginOfDay(createTimeStartDate);
         createTimeEndDate = DateUtil.endOfDay(createTimeEndDate);
      }

      log.info("制造成本统计 制成品报废损失 createTimeStart:{},createTimeEnd:{},projectId:{}", createTimeStart, createTimeEnd, projectId);
      return ResultBuilder.success(this.manufactureCostService.finishedProductScrapLoss(createTimeStartDate, createTimeEndDate, projectId));
   }

   @ApiOperation("制造成本统计 制成品报废损失打印")
   @GetMapping("/finishedProductScrapLoss/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO<PrintVO<List<Map<String, Object>>>> finishedProductScrapLossPrint(
      @RequestParam(required = false) String createTimeStart,
      @RequestParam(required = false) String createTimeEnd,
      @RequestParam(required = false) Long projectId
   ) {
      Date createTimeStartDate = null;
      Date createTimeEndDate = null;
      if (createTimeStart != null && createTimeEnd != null) {
         createTimeStartDate = new Date(Long.parseLong(createTimeStart));
         createTimeEndDate = new Date(Long.parseLong(createTimeEnd));
         createTimeStartDate = DateUtil.beginOfDay(createTimeStartDate);
         createTimeEndDate = DateUtil.endOfDay(createTimeEndDate);
      }

      log.info("制造成本统计 制成品报废损失打印 createTimeStart:{},createTimeEnd:{},projectId:{}", createTimeStart, createTimeEnd, projectId);
      return ResultBuilder.success(this.manufactureCostService.finishedProductScrapLossPrint(createTimeStartDate, createTimeEndDate, projectId));
   }

   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "createTimeStart", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "createTimeEnd", value = "结束时间", paramType = "query"),
            @ApiImplicitParam(name = "projectName", value = "项目名称", paramType = "query")
      }
   )
   @ApiOperation("")
   @GetMapping("/transportationCost")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO<List<CostTransportationDTO>> transportationCost(
      @RequestParam(required = false) String createTimeStart,
      @RequestParam(required = false) String createTimeEnd,
      @RequestParam Long projectId,
      @RequestParam Boolean boolTaxIncluded
   ) {
      Date createTimeStartDate = null;
      Date createTimeEndDate = null;
      if (createTimeStart != null && createTimeEnd != null) {
         createTimeStartDate = new Date(Long.parseLong(createTimeStart));
         createTimeEndDate = new Date(Long.parseLong(createTimeEnd));
         createTimeStartDate = DateUtil.beginOfDay(createTimeStartDate);
         createTimeEndDate = DateUtil.endOfDay(createTimeEndDate);
      }

      log.info("制造成本统计 运输费 createTimeStart:{},createTimeEnd:{},projectId:{}", createTimeStart, createTimeEnd, projectId);
      return ResultBuilder.success(this.manufactureCostService.transportationCost(createTimeStartDate, createTimeEndDate, projectId, boolTaxIncluded));
   }

   @ApiOperation("制造成本统计-运输费打印")
   @GetMapping("/transportationCost/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO<PrintVO<List<Map<String, Object>>>> transportationCostPrint(
      @RequestParam Long projectId,
      @RequestParam Boolean boolTaxIncluded,
      @RequestParam(required = false) String createTimeStart,
      @RequestParam(required = false) String createTimeEnd
   ) {
      log.info("API调用: 制造成本统计-运输费打印");
      Date createTimeStartDate = null;
      Date createTimeEndDate = null;
      if (createTimeStart != null && createTimeEnd != null) {
         createTimeStartDate = new Date(Long.parseLong(createTimeStart));
         createTimeEndDate = new Date(Long.parseLong(createTimeEnd));
         createTimeStartDate = DateUtil.beginOfDay(createTimeStartDate);
         createTimeEndDate = DateUtil.endOfDay(createTimeEndDate);
      }

      return ResultBuilder.success(this.manufactureCostService.transportationCostPrint(createTimeStartDate, createTimeEndDate, projectId, boolTaxIncluded));
   }

   @ApiOperation("制造成本统计-返厂维修产品列表")
   @GetMapping("/repair/list")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO<List<ContractReturnProductDTO>> listReturnRepair(@RequestParam Long projectId) {
      log.info("Api调用:制造成本统计-返厂维修产品列表");
      PageVO<ContractReturnProductDTO> returnProductDTOPageVO = this.contractScrapRecycleLedgerBiz
         .pageListReturnProduct(null, null, projectId, HandleMethodEnum.REPAIR.getType(), 1, 1);
      long totalElements = returnProductDTOPageVO.getTotalElements();
      if (totalElements != 0L) {
         returnProductDTOPageVO = this.contractScrapRecycleLedgerBiz
            .pageListReturnProduct(null, null, projectId, HandleMethodEnum.REPAIR.getType(), 1, Math.toIntExact(totalElements));
      }

      return ResultBuilder.success(returnProductDTOPageVO.getContent());
   }

   @ApiOperation("制造成本统计-返厂维修产品列表-打印")
   @GetMapping("/repair/list/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO<PrintVO<List<ContractReturnProductDTO>>> printListReturnRepair(@RequestParam Long projectId) {
      log.info("Api调用:制造成本统计-项目返厂维修产品列表-打印");
      PrintVO<List<ContractReturnProductDTO>> printVO = this.contractScrapRecycleLedgerBiz
         .printListReturnProduct(null, null, projectId, HandleMethodEnum.REPAIR.getType());
      return ResultBuilder.success(printVO);
   }

   @ApiOperation("制造成本统计-二次利用产品列表")
   @GetMapping("/reuse/list")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO<List<ContractReturnProductDTO>> listReturnReuse(@RequestParam Long projectId) {
      PageVO<ContractReturnProductDTO> pageVO = this.contractScrapSaleLedgerBiz
         .pageListWasteProduct(null, null, projectId, WasteHandleMethodEnum.REUSE.getType(), 1, 1);
      long totalElements = pageVO.getTotalElements();
      if (totalElements != 0L) {
         pageVO = this.contractScrapSaleLedgerBiz
            .pageListWasteProduct(null, null, projectId, HandleMethodEnum.REPAIR.getType(), 1, Math.toIntExact(totalElements));
      }

      return ResultBuilder.success(pageVO.getContent());
   }

   @ApiOperation("制造成本统计-二次利用产品列表-打印")
   @GetMapping("/reuse/list/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO<PrintVO<List<ContractReturnProductDTO>>> printListReturnReuse(@RequestParam Long projectId) {
      log.info("Api调用:制造成本统计-项目二次利用产品列表-打印");
      return ResultBuilder.success(this.contractScrapSaleLedgerBiz.printListWasteProduct(null, null, projectId, HandleMethodEnum.REPAIR.getType()));
   }

   @ApiOperation("制造成本统计-水电费")
   @GetMapping("/water-electricity-amortization")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO waterElectricityAmortization(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-水电费");
      return ResultBuilder.success(
         this.manufactureCostService
            .waterElectricityPropertyAmortization(
               projectId, Arrays.asList(WaterElectricityPropertyFeeTypeEnum.WATER_FEE.getType(), WaterElectricityPropertyFeeTypeEnum.ELECTRICITY_FEE.getType())
            )
      );
   }

   @ApiOperation("制造成本统计-水电费-打印")
   @GetMapping("/water-electricity-amortization/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO waterElectricityAmortizationPrint(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-水电费-打印");
      return ResultBuilder.success(
         this.manufactureCostService
            .waterElectricityPropertyAmortizationPrint(
               projectId, Arrays.asList(WaterElectricityPropertyFeeTypeEnum.WATER_FEE.getType(), WaterElectricityPropertyFeeTypeEnum.ELECTRICITY_FEE.getType())
            )
      );
   }

   @ApiOperation("制造成本统计-物业费")
   @GetMapping("/property-amortization")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO propertyAmortization(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-物业费");
      return ResultBuilder.success(
         this.manufactureCostService.waterElectricityPropertyAmortization(projectId, Arrays.asList(WaterElectricityPropertyFeeTypeEnum.PROPERTY_FEE.getType()))
      );
   }

   @ApiOperation("制造成本统计-物业费-打印")
   @GetMapping("/property-amortization/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO propertyAmortizationPrint(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-物业费-打印");
      return ResultBuilder.success(
         this.manufactureCostService
            .waterElectricityPropertyAmortizationPrint(projectId, Arrays.asList(WaterElectricityPropertyFeeTypeEnum.PROPERTY_FEE.getType()))
      );
   }

   @ApiOperation("制造成本统计-期间直接成本费用")
   @GetMapping("/direct-cost")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO directCost(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-期间直接成本费用");
      return ResultBuilder.success(this.manufactureCostService.directCost(projectId));
   }

   @ApiOperation("制造成本统计-期间直接成本费用-打印")
   @GetMapping("/direct-cost/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO directCostPrint(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-期间直接成本费用-打印");
      return ResultBuilder.success(this.manufactureCostService.directCostPrint(projectId));
   }

   @ApiOperation("制造成本统计-期间摊销成本费用")
   @GetMapping("/amortization-cost")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO amortizationCost(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-期间摊销成本费用");
      return ResultBuilder.success(this.manufactureCostService.amortizationCost(projectId));
   }

   @ApiOperation("制造成本统计-期间摊销成本费用-打印")
   @GetMapping("/amortization-cost/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO amortizationCostPrint(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-期间摊销成本费用-打印");
      return ResultBuilder.success(this.manufactureCostService.amortizationCostPrint(projectId));
   }

   @ApiOperation("制造成本统计-厂房折旧")
   @GetMapping("/factory-depreciation")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO factoryDepreciation(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-厂房折旧");
      return ResultBuilder.success(this.manufactureCostService.factoryDepreciation(projectId));
   }

   @ApiOperation("制造成本统计-厂房折旧-打印")
   @GetMapping("/factory-depreciation/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO factoryDepreciationPrint(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-厂房折旧-打印");
      return ResultBuilder.success(this.manufactureCostService.factoryDepreciationPrint(projectId));
   }

   @ApiOperation("制造成本统计-设备折旧")
   @GetMapping("/equipment-depreciation")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO equipmentDepreciation(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-设备折旧");
      return ResultBuilder.success(this.manufactureCostService.equipmentDepreciation(projectId));
   }

   @ApiOperation("制造成本统计-设备折旧-打印")
   @GetMapping("/equipment-depreciation/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO equipmentDepreciationPrint(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-设备折旧-打印");
      return ResultBuilder.success(this.manufactureCostService.equipmentDepreciationPrint(projectId));
   }

   @ApiOperation("制造成本统计-检测费")
   @GetMapping("/testing-fee")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO testingFee(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-检测费");
      return ResultBuilder.success(this.manufactureCostService.testingFee(projectId));
   }

   @ApiOperation("制造成本统计-检测费-打印")
   @GetMapping("/testing-fee/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO testingFeePrint(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-检测费-打印");
      return ResultBuilder.success(this.manufactureCostService.testingFeePrint(projectId));
   }

   @ApiOperation("制造成本统计-主材统计")
   @GetMapping("/main-materials-statistics")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO mainMaterialsStatistics(
      @ApiParam(value = "项目ID", required = true) @RequestParam Long projectId,
      @ApiParam(value = "基础物料分类(1: 钢板, 2: 型材, 4: 钢卷, 256: 其它钢材)", required = true) @RequestParam Integer basicMaterialClassEnum
   ) {
      log.info("API调用: 制造成本统计-主材统计");
      return ResultBuilder.success(this.manufactureCostService.mainMaterialsStatistics(projectId, basicMaterialClassEnum));
   }

   @ApiOperation("制造成本统计-主材统计-打印")
   @GetMapping("/main-materials-statistics/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO mainMaterialsStatisticsPrint(
      @ApiParam(value = "项目ID", required = true) @RequestParam Long projectId,
      @ApiParam(value = "基础物料分类(1: 钢板, 2: 型材, 4: 钢卷, 256: 其它钢材)", required = true) @RequestParam Integer basicMaterialClassEnum,
      @RequestParam(defaultValue = "true") Boolean boolTaxIncluded
   ) {
      log.info("API调用: 制造成本统计-主材统计-打印");
      return ResultBuilder.success(this.manufactureCostService.mainMaterialsStatisticsPrint(projectId, basicMaterialClassEnum, boolTaxIncluded));
   }

   @ApiOperation("制造成本统计-其它钢材摊销")
   @GetMapping("/other-steel-materials-amortization")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO otherSteelMaterialsAmortization(
      @ApiParam(name = "projectId", value = "项目ID", required = true) @RequestParam Long projectId, @RequestParam(defaultValue = "true") Boolean boolTaxIncluded
   ) {
      log.info("API调用: 制造成本统计-其它钢材摊销");
      return ResultBuilder.success(this.manufactureCostService.otherSteelMaterialsAmortization(projectId, boolTaxIncluded));
   }

   @ApiOperation("制造成本统计-其它钢材摊销-打印")
   @GetMapping("/other-steel-materials-amortization/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO otherSteelMaterialsAmortizationPrint(
      @ApiParam(name = "projectId", value = "项目ID", required = true) @RequestParam Long projectId, @RequestParam(defaultValue = "true") Boolean boolTaxIncluded
   ) {
      log.info("API调用: 制造成本统计-其它钢材摊销-打印");
      return ResultBuilder.success(this.manufactureCostService.otherSteelMaterialsAmortizationPrint(projectId, boolTaxIncluded));
   }

   @ApiOperation("制造成本统计-辅材直接成本")
   @GetMapping("/auxiliary-materials-direct-cost")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO auxiliaryMaterialsDirectCost(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-辅材直接成本");
      return ResultBuilder.success(this.manufactureCostService.auxiliaryMaterialsDirectCost(projectId));
   }

   @ApiOperation("制造成本统计-辅材直接成本-打印")
   @GetMapping("/auxiliary-materials-direct-cost/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO auxiliaryMaterialsDirectCostPrint(
      @ApiParam(value = "项目ID", required = true) @RequestParam Long projectId, @RequestParam(defaultValue = "true") Boolean boolTaxIncluded
   ) {
      log.info("API调用: 制造成本统计-辅材直接成本-打印");
      return ResultBuilder.success(this.manufactureCostService.auxiliaryMaterialsDirectCostPrint(projectId, boolTaxIncluded));
   }

   @ApiOperation("制造成本统计-辅材摊销成本")
   @GetMapping("/auxiliary-materials-amortization-cost")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO auxiliaryMaterialsAmortizationCost(
      @ApiParam(value = "项目ID", required = true) @RequestParam Long projectId, @RequestParam(defaultValue = "true") Boolean boolTaxIncluded
   ) {
      log.info("API调用: 制造成本统计-辅材摊销成本");
      return ResultBuilder.success(this.manufactureCostService.auxiliaryMaterialsAmortizationCost(projectId, boolTaxIncluded));
   }

   @ApiOperation("制造成本统计-辅材摊销成本-打印")
   @GetMapping("/auxiliary-materials-amortization-cost/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO auxiliaryMaterialsAmortizationCostPrint(
      @ApiParam(value = "项目ID", required = true) @RequestParam Long projectId, @RequestParam(defaultValue = "true") Boolean boolTaxIncluded
   ) {
      log.info("API调用: 制造成本统计-辅材摊销成本-打印");
      return ResultBuilder.success(this.manufactureCostService.auxiliaryMaterialsAmortizationCostPrint(projectId, boolTaxIncluded));
   }

   @ApiOperation("制造成本统计-油漆成本")
   @GetMapping("/paint-cost")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO paintCost(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-油漆成本");
      return ResultBuilder.success(this.manufactureCostService.paintCost(projectId));
   }

   @ApiOperation("制造成本统计-油漆成本-打印")
   @GetMapping("/paint-cost/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO paintCostPrint(
      @ApiParam(value = "项目ID", required = true) @RequestParam Long projectId, @RequestParam(defaultValue = "true") Boolean boolTaxIncluded
   ) {
      log.info("API调用: 制造成本统计-油漆成本-打印");
      return ResultBuilder.success(this.manufactureCostService.paintCostPrint(projectId, boolTaxIncluded));
   }

   @ApiOperation("制造成本统计-焊材成本")
   @GetMapping("/welding-consumable-cost")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO weldingConsumableCost(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-焊材成本");
      return ResultBuilder.success(this.manufactureCostService.weldingConsumableCost(projectId));
   }

   @ApiOperation("制造成本统计-焊材成本-打印")
   @GetMapping("/welding-consumable-cost/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO weldingConsumableCostPrint(
      @ApiParam(value = "项目ID", required = true) @RequestParam Long projectId, @RequestParam(defaultValue = "true") Boolean boolTaxIncluded
   ) {
      log.info("API调用: 制造成本统计-焊材成本-打印");
      return ResultBuilder.success(this.manufactureCostService.weldingConsumableCostPrint(projectId, boolTaxIncluded));
   }

   @ApiOperation("直发工地原材料-成本(订单列表)")
   @GetMapping("/send-directly-site-material-cost")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO<List<ProjectMaterialsAllDto>> getSendDirectlyConstructionSiteMaterialCost(@RequestParam Long projectId) {
      log.info("API调用: 直发工地材料成本列表");
      return ResultBuilder.success(this.manufactureCostService.getSendDirectlyConstructionSiteMaterialCostList(projectId));
   }

   @ApiOperation("直发工地原材料-成本(订单列表)-打印")
   @GetMapping("/send-directly-site-material-cost/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO<PrintVO<List<ProjectMaterialsAllDto>>> printSendDirectlyConstructionSiteMaterialCost(@RequestParam Long projectId) {
      log.info("API调用: 直发工地材料成本列表-打印");
      return ResultBuilder.success(this.manufactureCostService.printSendDirectlyConstructionSiteMaterialCostList(projectId));
   }

   @ApiOperation("直发工地原材料订单-付款列表")
   @GetMapping("/send-directly-site-material-order-payment")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO getSendDirectlyConstructionSiteMaterialOrderPaymentList(@RequestParam Long orderId) {
      log.info("API调用:直发工地原材料订单-付款列表");
      return ResultBuilder.success(this.manufactureCostService.getSendDirectlyConstructionSiteOrderPaymentList(orderId));
   }

   @ApiOperation("直发工地原材料订单-付款列表-打印")
   @GetMapping("/send-directly-site-material-order-payment/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO printSendDirectlyConstructionSiteMaterialOrderPaymentList(@RequestParam Long orderId) {
      log.info("API调用:直发工地原材料订单-付款列表-打印");
      return ResultBuilder.success(this.manufactureCostService.printSendDirectlyConstructionSiteOrderPaymentList(orderId));
   }

   @ApiOperation("制造成本统计-气体费摊销")
   @GetMapping("/gas-fee")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO gasFee(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId, @RequestParam(defaultValue = "true") Boolean boolTaxIncluded) {
      log.info("API调用: 制造成本统计-气体费摊销");
      return ResultBuilder.success(this.manufactureCostService.gasFee(projectId, boolTaxIncluded));
   }

   @ApiOperation("制造成本统计-气体费摊销-打印")
   @GetMapping("/gas-fee/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO gasFeePrint(
      @ApiParam(value = "项目ID", required = true) @RequestParam Long projectId, @RequestParam(defaultValue = "true") Boolean boolTaxIncluded
   ) {
      log.info("API调用: 制造成本统计-气体费摊销-打印");
      return ResultBuilder.success(this.manufactureCostService.gasFeePrint(projectId, boolTaxIncluded));
   }

   @ApiOperation("制造成本统计-气体费直接成本")
   @GetMapping("/gas-direct-cost")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO gasDirectCost(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-气体费直接成本");
      return ResultBuilder.success(this.manufactureCostService.gasDirectCost(projectId));
   }

   @ApiOperation("制造成本统计-气体费直接成本-打印")
   @GetMapping("/gas-direct-cost/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO gasDirectCostPrint(
      @ApiParam(value = "项目ID", required = true) @RequestParam Long projectId, @RequestParam(defaultValue = "true") Boolean boolTaxIncluded
   ) {
      log.info("API调用: 制造成本统计-气体费直接成本-打印");
      return ResultBuilder.success(this.manufactureCostService.gasDirectCostPrint(projectId, boolTaxIncluded));
   }

   @ApiOperation("制造成本统计-管理人员摊销成本")
   @GetMapping("manager-amortization-cost")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO managerAmortizationCost(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-管理人员摊销成本");
      return ResultBuilder.success(this.manufactureCostService.managerAmortizationCost(projectId));
   }

   @ApiOperation("制造成本统计-管理人员摊销成本-打印")
   @GetMapping("manager-amortization-cost/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO managerAmortizationCostPrint(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-管理人员摊销成本-打印");
      return ResultBuilder.success(this.manufactureCostService.managerAmortizationCostPrint(projectId));
   }

   @ApiOperation("制造成本统计-零工摊销成本")
   @GetMapping("temp-work-amortization-cost")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO tempWorkAmortizationCost(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-零工摊销成本");
      return ResultBuilder.success(this.manufactureCostService.tempWorkAmortizationCost(projectId));
   }

   @ApiOperation("制造成本统计-零工摊销成本-打印")
   @GetMapping("temp-work-amortization-cost/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO tempWorkAmortizationCostPrint(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-零工摊销成本-打印");
      return ResultBuilder.success(this.manufactureCostService.tempWorkAmortizationCostPrint(projectId));
   }

   @ApiOperation("制造成本统计-生产人工成本")
   @GetMapping("production-labor-cost")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost')")
   public ResultVO productionLaborCost(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-生产人工成本");
      return ResultBuilder.success(this.manufactureCostService.productionLaborCost(projectId));
   }

   @ApiOperation("制造成本统计-生产人工成本-打印")
   @GetMapping("production-labor-cost/print")
   @PreAuthorize("@permission.check('fortune_report_cost:cumulative_cost_download')")
   public ResultVO productionLaborCostPrint(@ApiParam(value = "项目ID", required = true) @RequestParam Long projectId) {
      log.info("API调用: 制造成本统计-生产人工成本-打印");
      return ResultBuilder.success(this.manufactureCostService.productionLaborCostPrint(projectId));
   }
}
