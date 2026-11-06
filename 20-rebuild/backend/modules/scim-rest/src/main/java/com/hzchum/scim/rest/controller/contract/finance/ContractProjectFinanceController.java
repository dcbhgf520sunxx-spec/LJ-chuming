package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.finance.ContractProjectFinanceBiz;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-项目业财报表")
@RestController
@RequestMapping("/api/contract/project-finance")
public class ContractProjectFinanceController {
   private static final Logger log = LoggerFactory.getLogger(ContractProjectFinanceController.class);
   @Resource
   private ContractProjectFinanceBiz contractProjectFinanceBiz;

   @ApiOperation("项目业财报表")
   @GetMapping
   @PreAuthorize("@permission.check('fortune_report_cost:get')")
   public ResultVO listProjectCost(
      Integer year,
      Long projectId,
      Integer businessType,
      Integer projectType,
      Integer orderSourceType,
      Integer status,
      Integer settlementStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:项目业财报表列表");
      return ResultBuilder.success(
         this.contractProjectFinanceBiz
            .listProjectFinance(year, projectId, businessType, projectType, orderSourceType, status, settlementStatus, pageNumber, pageSize)
      );
   }

   @ApiOperation("项目业财报表-打印下载")
   @GetMapping("/print")
   @PreAuthorize("@permission.check('fortune_report_cost:print')")
   public ResultVO printListProjectCost(
      Integer year, Long projectId, Integer businessType, Integer projectType, Integer orderSourceType, Integer status, Integer settlementStatus
   ) {
      log.info("Api调用:项目业财报表列表-打印下载");
      return ResultBuilder.success(
         this.contractProjectFinanceBiz.printListProjectFinance(year, projectId, businessType, projectType, orderSourceType, status, settlementStatus)
      );
   }

   @ApiOperation("主材和辅材出库列表")
   @ApiImplicitParam(name = "basicClassEnum", value = "基础物料类型 7主材 8辅材", required = true)
   @GetMapping("/list-outbound")
   @PreAuthorize("@permission.check('fortune_report_cost_detail:detail')")
   public ResultVO<PageVO<OutboundDetailDTO>> listDepreciationFee(
      @RequestParam Long projectId,
      @RequestParam Integer basicClassEnum,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:主材和辅材出库列表");
      return ResultBuilder.success(this.contractProjectFinanceBiz.listProjectOutbound(projectId, basicClassEnum, pageNumber, pageSize));
   }

   @ApiOperation("主材和辅材出库列表-打印")
   @ApiImplicitParam(name = "basicClassEnum", value = "基础物料类型 7主材 8辅材", required = true)
   @GetMapping("/list-outbound/print")
   @PreAuthorize("@permission.check('fortune_report_cost_detail:print')")
   public ResultVO printListDepreciationFee(@RequestParam Long projectId, @RequestParam Integer basicClassEnum) {
      log.info("Api调用:主材和辅材出库列表");
      return ResultBuilder.success(this.contractProjectFinanceBiz.printListProjectOutbound(projectId, basicClassEnum));
   }

   @ApiOperation("折旧费列表")
   @GetMapping("/list-depreciation")
   @PreAuthorize("@permission.check('fortune_report_cost_detail:detail')")
   public ResultVO listDepreciationFee(@RequestParam Long projectId) {
      log.info("Api调用:项目折旧费列表");
      return ResultBuilder.success(new ListVO<>(this.contractProjectFinanceBiz.listDepreciationFee(projectId)));
   }

   @ApiOperation("折旧费列表-打印")
   @GetMapping("/list-depreciation/print")
   @PreAuthorize("@permission.check('fortune_report_cost_detail:print')")
   public ResultVO printListDepreciationFee(@RequestParam Long projectId) {
      log.info("Api调用:项目折旧费列表打印");
      return ResultBuilder.success(this.contractProjectFinanceBiz.printListDepreciationFee(projectId));
   }

   @ApiOperation("人工费列表")
   @GetMapping("/list-wage")
   @PreAuthorize("@permission.check('fortune_report_cost_detail:detail')")
   public ResultVO listProcessWage(@RequestParam Long projectId) {
      log.info("Api调用:项目折旧费列表");
      return ResultBuilder.success(new ListVO<>(this.contractProjectFinanceBiz.listLaborFee(projectId)));
   }

   @ApiOperation("人工费列表-打印")
   @GetMapping("/list-wage/print")
   @PreAuthorize("@permission.check('fortune_report_cost_detail:print')")
   public ResultVO printListProcessWage(@RequestParam Long projectId) {
      log.info("Api调用:项目折旧费列表打印");
      return ResultBuilder.success(this.contractProjectFinanceBiz.printListLaborFee(projectId));
   }

   @ApiOperation("检测费列表")
   @GetMapping("/list-testing")
   @PreAuthorize("@permission.check('fortune_report_cost_detail:detail')")
   public ResultVO listTestingFee(@RequestParam Long projectId) {
      log.info("Api调用:项目检测费列表");
      return ResultBuilder.success(new ListVO<>(this.contractProjectFinanceBiz.listTestingFee(projectId)));
   }

   @ApiOperation("检测费列表-打印")
   @GetMapping("/list-testing/print")
   @PreAuthorize("@permission.check('fortune_report_cost_detail:print')")
   public ResultVO printListTestingFee(@RequestParam Long projectId) {
      log.info("Api调用:项目检测费列表打印");
      return ResultBuilder.success(this.contractProjectFinanceBiz.printListTestingFee(projectId));
   }

   @ApiOperation("分包费列表")
   @GetMapping("/list-sub")
   @PreAuthorize("@permission.check('fortune_report_cost_detail:detail')")
   public ResultVO listSubFee(@RequestParam Long projectId) {
      log.info("Api调用:项目分包费列表");
      return ResultBuilder.success(new ListVO<>(this.contractProjectFinanceBiz.listSubFee(projectId)));
   }

   @ApiOperation("分包费列表-打印")
   @GetMapping("/list-sub/print")
   @PreAuthorize("@permission.check('fortune_report_cost_detail:print')")
   public ResultVO printListSubFee(@RequestParam Long projectId) {
      log.info("Api调用:项目分包费列表打印");
      return ResultBuilder.success(this.contractProjectFinanceBiz.printListSubFee(projectId));
   }

   @ApiOperation("管理费列表")
   @GetMapping("/list-manage")
   @PreAuthorize("@permission.check('fortune_report_cost_detail:detail')")
   public ResultVO listManageFee(@RequestParam Long projectId) {
      log.info("Api调用:管理费列表");
      return ResultBuilder.success(new ListVO<>(this.contractProjectFinanceBiz.listManagerFee(projectId)));
   }

   @ApiOperation("管理费列表-打印")
   @GetMapping("/list-manage/print")
   @PreAuthorize("@permission.check('fortune_report_cost_detail:print')")
   public ResultVO printListManageFee(@RequestParam Long projectId) {
      log.info("Api调用:管理费列表打印");
      return ResultBuilder.success(this.contractProjectFinanceBiz.printListManagerFee(projectId));
   }

   @ApiOperation("水电气费列表")
   @GetMapping("/list-water")
   @PreAuthorize("@permission.check('fortune_report_cost_detail:detail')")
   public ResultVO listWaterEleFee(@RequestParam Long projectId) {
      log.info("Api调用:水电气费列表");
      return ResultBuilder.success(new ListVO<>(this.contractProjectFinanceBiz.listWaterEleFee(projectId)));
   }

   @ApiOperation("水电气费列表-打印")
   @GetMapping("/list-water/print")
   @PreAuthorize("@permission.check('fortune_report_cost_detail:print')")
   public ResultVO printListWaterEleFee(@RequestParam Long projectId) {
      log.info("Api调用:水电气费列表打印");
      return ResultBuilder.success(this.contractProjectFinanceBiz.printListWaterEleFee(projectId));
   }
}
