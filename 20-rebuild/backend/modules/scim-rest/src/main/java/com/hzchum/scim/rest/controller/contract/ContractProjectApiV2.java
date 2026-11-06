package com.hzchum.scim.rest.controller.contract;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.biz.ContractCollectionInvoiceBiz;
import com.hzchum.scim.contract.core.api.biz.ContractInvoiceBiz;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.biz.finance.ContractProjectAssetInjectionBiz;
import com.hzchum.scim.contract.core.api.biz.finance.ContractProjectDisburseDetailBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectIncomeAndExpenses;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectLedgerV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectRelevancyDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.projectManagerLedgerDisburseDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectDisburseDetailDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectInterestFundsDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectManagerMoneyInterestsDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.PeriodCostDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectCostReportDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectElseAllDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectMaterialsAllDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectSelfSupportCostReportDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.project.ManagementFeeAllDto;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectLedgerSeltSupportPaymentDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectLedgerSupplierInvoiceDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectPaymentAllDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectLedgerDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.SupplierLedgerParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.ProjectSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.vo.save.ProjectSaveVORequest;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectManagerMoneyInterestsService;
import com.hzchum.scim.scm.core.api.biz.PurchaseOrderBiz;
import com.hzchum.scim.scm.core.api.biz.SubcontractOrderBiz;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierInvoiceDetailDto;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierPaymentDetailDto;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.PuchaseInboundDetailDTO;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-项目")
@RestController
@RequestMapping("/api/project/v2")
public class ContractProjectApiV2 {
   private static final Logger log = LoggerFactory.getLogger(ContractProjectApiV2.class);
   @Resource
   private ContractCollectionInvoiceBiz collectionInvoiceBiz;
   @Resource
   private ContractProjectBiz contractProjectBiz;
   @Resource
   private ContractInvoiceBiz invoiceBiz;
   @Resource
   private ContractProjectDisburseDetailBiz disburseDetailBiz;
   @Resource
   private ContractProjectManagerMoneyInterestsService moneyInterestService;
   @Resource
   private ContractProjectAssetInjectionBiz assetInjectionBiz;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private PurchaseOrderBiz purchaseOrderBiz;
   @Resource
   private InboundService inboundService;
   @Resource
   private SubcontractOrderBiz subcontractOrderBiz;
   @Resource
   private ContractCollectionAccess contractCollectionAccess;

   @ApiOperation("获取项目台账列表V2-内包合营")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query"),
            @ApiImplicitParam(name = "projectAttribute", value = "项目类型（自营、合营、包干制）", paramType = "query"),
            @ApiImplicitParam(name = "projectManagerId", value = "项目经理人id", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "settlementStatus", value = "状态", paramType = "query")
      }
   )
   @GetMapping("/projectManagerLedger")
   @PreAuthorize("@permission.check('inter_account:get')")
   public ResultVO<PageVO<ProjectLedgerV2DTO>> projectManagerLedger(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectAttribute,
      @RequestParam Long projectManagerId,
      Long projectId,
      String projectName,
      Integer settlementStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api 调用 ： 获取项目台账列表V2-内包合营");
      return ResultBuilder.success(
         this.contractProjectBiz
            .projectManagerLedger(startDate, endDate, projectAttribute, projectManagerId, projectId, projectName, settlementStatus, pageNumber, pageSize)
      );
   }

   @ApiOperation("获取项目台账列表V2-内包合营-收支台账")
   @GetMapping("/projectManagerLedger/disburseDetail")
   @PreAuthorize("@contractCollectionAccess.interiorProjectRead(#projectId,false)")
   public ResultVO<PageVO<projectManagerLedgerDisburseDetailDTO>> projectManagerLedgerDisburseDetail(
      @RequestParam Long projectId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api 调用 ： 获取项目台账列表V2-内包合营-收支台账");
      return ResultBuilder.success(this.contractProjectBiz.projectManagerLedgerDisburseDetail(projectId, startDate, endDate, pageNumber, pageSize));
   }

   @ApiOperation("获取项目台账列表V2-内包合营-内包制结余")
   @GetMapping("/projectManagerLedger/{projectManagerId}/amount")
   @PreAuthorize("@permission.check('inter_account:get')")
   public ResultVO projectManagerLedgerDisburseDetailSummary(@PathVariable Long projectManagerId) {
      log.info("Api 调用 ： 获取项目台账列表V2-内包合营-内包制结余");
      return ResultBuilder.success(this.contractProjectBiz.projectManagerLedgerDisburseDetailSummary(projectManagerId));
   }

   @ApiOperation("项目台账-项目支出明细V2")
   @GetMapping("/order/projectPaymentAll")
   @PreAuthorize("@contractCollectionAccess.interiorProjectRead(#projectId,false)")
   public ResultVO<PageVO<ProjectPaymentAllDTO>> orderPayment(
      @RequestParam Long projectId, Long supplierId, String number, LocalDateTime StartTime, LocalDateTime endTime, Integer pageNumber, Integer pageSize
   ) {
      log.info("Api 调用 ： 项目台账-项目支出明细V2");
      return ResultBuilder.success(this.purchaseOrderBiz.projectPaymentAll(projectId, supplierId, number, StartTime, endTime, pageNumber, pageSize));
   }

   @ApiOperation("项目台账-项目支出明细V2")
   @GetMapping("/order/projectPaymentAll/download")
   @PreAuthorize("@contractCollectionAccess.interiorProjectRead(#projectId,true)")
   public ResultVO orderPaymentDownload(@RequestParam Long projectId, Long supplierId, String number, LocalDateTime StartTime, LocalDateTime endTime) {
      log.info("Api 调用 ： 项目台账-项目支出明细V2");
      return ResultBuilder.success(this.purchaseOrderBiz.orderPaymentDownload(projectId, supplierId, number, StartTime, endTime));
   }

   @ApiOperation("根据项目属性获取项目")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectAttribute", value = "项目类型（自营、合营、包干制）", paramType = "query"),
            @ApiImplicitParam(name = "projectManagerId", value = "项目经理人id", paramType = "query")
      }
   )
   @GetMapping("/getProjectAttributeList")
   public Result<ListVO<ProjectSimpleInfoDTO>> getProjectAttributeList(String projectAttribute, Long projectManagerId, @RequestParam Integer level) {
      log.info("Api 调用 ： 根据项目属性获取项目");
      return ResultGenerator.genSuccessResult(new ListVO<>(this.contractProjectBiz.getProjectAttributeList(projectAttribute, projectManagerId, null, level)));
   }

   @ApiOperation("项目台账-收入台账-项目数据汇总")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份", paramType = "query", required = true),
            @ApiImplicitParam(name = "settlementStatus", value = "结算状态 0 未结算 1已结算", paramType = "query")
      }
   )
   @GetMapping("/projectSelfEmployed")
   @PreAuthorize("@contractCollectionAccess.selfLedgerRead(null,#level)")
   public ResultVO projectSelfEmployedPageSize(LocalDateTime year, Integer level, Integer settlementStatus) {
      log.info("Api 调用 ： 获取自营项目台账汇总");
      return ResultBuilder.success(this.contractProjectBiz.getProjectSelfEmployed(year, level, settlementStatus));
   }

   @ApiOperation("项目台账-收入台账-列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份", paramType = "query"),
            @ApiImplicitParam(name = "settlementStatus", value = "结算状态 0 未结算 1已结算", paramType = "query"),
            @ApiImplicitParam(name = "salesLeaderId", value = "销售负责人id", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query")
      }
   )
   @GetMapping("/projectSelfOwned")
   @PreAuthorize("@contractCollectionAccess.selfLedgerRead(#param.projectId,#param.level)")
   public ResultVO<PageVO<ProjectLedgerDTO>> projectSelfOwnedPageSize(
      ProjectLedgerDtoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:项目台账-收入台账-列表");
      param.setProjectAttribute(ProjectAttributeEnum.SELF_SUPPORT.getType());
      return ResultBuilder.success(this.contractProjectBiz.getProjectSelfOwnedPageSize(param, pageNumber, pageSize));
   }

   @ApiOperation("获取收支信息")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectAttribute", value = "项目类型（自营、合营、包干制）", paramType = "query"),
            @ApiImplicitParam(name = "projectManagerId", value = "项目经理id", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query")
      }
   )
   @GetMapping("/standingbook/incomeAndExpenses")
   @PreAuthorize("@contractCollectionAccess.projectFinancialRead(#projectId,false)")
   public ResultVO incomeAndExpenses(String projectAttribute, Long projectManagerId, Long projectId, LocalDate startDate, LocalDate endDate) {
      log.info("API 调用 ：获取收支信息");
      return ResultBuilder.success(this.invoiceBiz.projectIncomeAndExpenses(projectAttribute, projectManagerId, projectId, startDate, endDate));
   }

   @ApiOperation("收支明细摘要信息返回")
   @GetMapping("/getAbstract")
   @PreAuthorize("@contractCollectionAccess.projectFinancialRead(#projectId,false)")
   public ResultVO acquisitionStatement(Long projectId) {
      log.info("API 调用 ：获取收支明细摘要信息返回");
      return ResultBuilder.success(this.invoiceBiz.acquisitionStatement(projectId));
   }

   @ApiOperation("获取收支明细列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "摘要", paramType = "query"),
            @ApiImplicitParam(name = "collectionMode", value = "收入、转账类型", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query")
      }
   )
   @GetMapping("/standingbook/incomeAndExpensesList")
   @PreAuthorize("@contractCollectionAccess.projectFinancialRead(#projectId,false)")
   public ResultVO<PageVO<ProjectIncomeAndExpenses>> incomeAndExpensesList(
      Long projectId,
      String remark,
      Integer collectionMode,
      LocalDate startDate,
      LocalDate endDate,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：获取收支明细列表");
      return ResultBuilder.success(this.invoiceBiz.projectIncomeAndExpensesList(projectId, remark, collectionMode, startDate, endDate, pageNumber, pageSize));
   }

   @ApiOperation("获取收支明细列表V2")
   @GetMapping("/incomeAndExpenditureList")
   @PreAuthorize("@contractCollectionAccess.projectFinancialRead(#projectId,false)")
   public ResultVO<PageVO<ProjectIncomeAndExpenses>> incomeAndExpenditureList(
      Long projectId,
      String remark,
      Integer collectionMode,
      LocalDate startDate,
      LocalDate endDate,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：获取收支明细列表");
      return ResultBuilder.success(this.invoiceBiz.projectIncomeAndExpensesList(projectId, remark, collectionMode, startDate, endDate, pageNumber, pageSize));
   }

   @ApiOperation("下载收支明细列表")
   @GetMapping("/standingbook/download")
   @PreAuthorize("@contractCollectionAccess.projectFinancialRead(#projectId,true)")
   public ResultVO downloadIncomeAndExpensesList(Long projectId, String remark, Integer collectionMode, LocalDate startDate, LocalDate endDate) {
      log.info("API 调用 ：下载收支明细列表");
      return ResultBuilder.success(this.invoiceBiz.downloadIncomeAndExpensesList(projectId, remark, collectionMode, startDate, endDate));
   }

   @ApiOperation("(新版)项目立项")
   @PostMapping("/addContract")
   public ResultVO add(@Valid @RequestBody ProjectSaveVORequest saveVORequest) {
      log.info("API 调用 ：保存项目信息");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "新建失败，无法解析用户信息！");
      return ResultBuilder.success(this.contractProjectBiz.addContract(saveVORequest));
   }

   @ApiOperation("项目支出详情查询")
   @GetMapping("/detailList")
   @PreAuthorize("@contractCollectionAccess.projectFinancialRead(#projectId,false)")
   public ResultVO<PageVO<ContractProjectDisburseDetailDto>> detailList(
      Long projectId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：项目支出详情查询");
      return ResultBuilder.success(this.disburseDetailBiz.detailList(projectId, pageNumber, pageSize));
   }

   @ApiOperation("项目支出详情下载")
   @GetMapping("/detailList/{projectId}")
   @PreAuthorize("@contractCollectionAccess.projectFinancialRead(#projectId,true)")
   public ResultVO detailListDownload(@PathVariable Long projectId) {
      log.info("API 调用 ：项目支出详情查询");
      return ResultBuilder.success(this.disburseDetailBiz.detailListDownload(projectId));
   }

   @ApiOperation("修改项目")
   @PutMapping("")
   public ResultVO updateProject(@RequestBody ProjectSaveDTOParam projectSaveDTOParam) {
      log.info("API 调用 ：编辑-修改项目");
      return ResultBuilder.success(this.contractProjectBiz.putProject(projectSaveDTOParam));
   }

   @ApiOperation("获取项目收款信息(内包制)")
   @GetMapping("/getContractBaseByProjectId")
   public ResultVO getContractBaseByProjectId(@RequestParam("projectId") Long projectId, @RequestParam("orderId") Long orderId) {
      log.info("API 调用 : 获取项目收款信息");
      return ResultBuilder.success(this.contractProjectBiz.getProjectProcurement(projectId, orderId));
   }

   @ApiOperation("成本报表-收支汇总（合营内包制）")
   @GetMapping("/costReport")
   public ResultVO<ProjectCostReportDto> costReport(Long projectId) {
      log.info("Api调用 ： 项目台账-成本报表-收支汇总");
      return ResultBuilder.success(this.contractProjectBiz.getProjectCostReport(projectId));
   }

   @ApiOperation("一级单位-项目成本（自营）")
   @GetMapping("/selfSupportCost")
   public ResultVO<ProjectSelfSupportCostReportDTO> expenseDetail(Long projectId, LocalDateTime year) {
      log.info("Api调用 ： 项目台账-成本报表-收支汇总");
      Integer intYear = year != null ? year.getYear() : null;
      return ResultBuilder.success(this.contractProjectBiz.getSelfSupportCost(projectId, intYear));
   }

   @ApiOperation("安装单位-项目成本（自营）-下载")
   @GetMapping("/selfSupportCost/download")
   public void expenseDetailDownload(Long projectId, LocalDateTime year, HttpServletResponse response) {
      log.info("Api调用 ： 项目台账-成本报表-收支汇总-下载打印");
      Integer intYear = year != null ? year.getYear() : null;
      this.contractProjectBiz.getSelfSupportCostDownload(projectId, intYear, response);
   }

   @ApiOperation("安装单位-项目成本-材料成本列表-下载(自营)")
   @GetMapping("/selfSupportCostDetail/download")
   public ResultVO selfSupportCostDetailDownload(Long projectId, LocalDateTime year) {
      log.info("Api调用 ： 成本报表-成本科目详细信息-下载打印(自营)");
      Integer intYear = year != null ? year.getYear() : null;
      return ResultBuilder.success(this.contractProjectBiz.getSelfSupportCostDetailDownload(projectId, intYear));
   }

   @ApiOperation("安装单位-项目成本-成本列表(自营)")
   @GetMapping("/selfSupportCost/detail")
   public ResultVO<ListVO<ProjectMaterialsAllDto>> selfSupportCostDetailList(@RequestParam Long projectId, @RequestParam Integer costTypeEnum) {
      log.info("Api调用:安装单位-项目成本-成本列表(自营)");
      return ResultBuilder.success(new ListVO<>(this.contractProjectBiz.getSelfSupportCostDetailList(projectId, costTypeEnum)));
   }

   @ApiOperation("安装单位-项目成本-成本列表(自营)-打印")
   @GetMapping("/selfSupportCost/detail/print")
   public ResultVO<PrintVO<List<ProjectMaterialsAllDto>>> selfSupportCostDetailListPrint(@RequestParam Long projectId, @RequestParam Integer costTypeEnum) {
      log.info("Api调用:安装单位-项目成本-成本列表(自营)");
      return ResultBuilder.success(this.contractProjectBiz.printSelfSupportCostDetailList(projectId, costTypeEnum));
   }

   @ApiOperation("安装单位-项目成本-成本列表(自营)-付款列表")
   @GetMapping("/selfSupportCost/detail/paymentList")
   public ResultVO<ListVO<ProjectLedgerSupplierInvoiceDetailDTO>> selfSupportCostDetailPaymentList(
      @RequestParam Long orderId, @RequestParam Integer costTypeEnum
   ) {
      log.info("Api调用:安装单位-项目成本-成本列表(自营)-付款列表");
      return ResultBuilder.success(new ListVO<>(this.contractProjectBiz.getSelfSupportCostPaymentList(orderId, costTypeEnum)));
   }

   @ApiOperation("安装单位-项目成本-成本列表(自营)-付款列表-打印")
   @GetMapping("/selfSupportCost/detail/paymentList/print")
   public ResultVO<PrintVO<List<ProjectLedgerSupplierInvoiceDetailDTO>>> selfSupportCostDetailPaymentListPrint(
      @RequestParam Long orderId, @RequestParam Integer costTypeEnum
   ) {
      log.info("Api调用:安装单位-项目成本-成本列表(自营)-付款列表-打印");
      return ResultBuilder.success(this.contractProjectBiz.printSelfSupportCostPaymentList(orderId, costTypeEnum));
   }

   @ApiOperation("安装单位-项目成本-成本列表(自营)-预结算列表")
   @GetMapping("/selfSupportCost/detail/preSettleList")
   public ResultVO<ListVO<SupplierSettlementDTO>> selfSupportCostDetailPreSettlementList(@RequestParam Long orderId) {
      log.info("Api调用:安装单位-项目成本-成本列表(自营)-预结算列表");
      List<SupplierSettlementDTO> settlementDTOList = this.purchaseOrderBiz.listSettleDetail(orderId, true);
      return ResultBuilder.success(new ListVO<>(settlementDTOList));
   }

   @ApiOperation("安装单位-项目成本-成本列表(自营)-预结算列表-打印")
   @GetMapping("/selfSupportCost/detail/preSettleList/print")
   public ResultVO<PrintVO<List<SupplierSettlementDTO>>> selfSupportCostDetailPreSettlementListPrint(@RequestParam Long orderId) {
      log.info("Api调用:安装单位-项目成本-成本列表(自营)-预结算列表-打印");
      return ResultBuilder.success(this.purchaseOrderBiz.printListSettleDetail(orderId, true));
   }

   @ApiOperation("成本报表-自营收支汇总(自营)")
   @GetMapping("/selfSupportCostReport")
   public ResultVO<List<ProjectCostReportDto>> selfSupportCostReport(Long projectId, LocalDateTime year) {
      log.info("Api调用 ： 项目台账-成本报表-收支汇总");
      Integer intYear = year != null ? year.getYear() : null;
      return ResultBuilder.success(this.contractProjectBiz.getSelfSupportCostReport(projectId, intYear));
   }

   @ApiOperation("成本报表-项目台账-支出明细(自营)")
   @GetMapping("/selfSupportExpenseDetail")
   public ResultVO<ProjectLedgerSeltSupportPaymentDto> selfSupportExpenseDetail(@RequestParam Long projectId) {
      log.info("Api调用 ： 项目台账-成本报表-支出明细(自营)");
      return ResultBuilder.success(this.contractProjectBiz.getSeltSupportPayment(projectId));
   }

   @ApiOperation("成本报表-项目台账-支出明细下载(自营)")
   @GetMapping("/selfSupportExpenseDetail/{projectId}")
   public ResultVO selfSupportExpenseDetailDownload(@PathVariable Long projectId) {
      log.info("Api调用 ： 项目台账-成本报表-支出明细下载(自营)");
      return ResultBuilder.success(this.contractProjectBiz.getSeltSupportPaymentDownload(projectId));
   }

   @ApiOperation("成本报表-材料支出明细")
   @GetMapping("/costReport/material")
   public ResultVO<PageVO<ProjectMaterialsAllDto>> materialDeductDetails(
      @RequestParam Long projectId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用 ： 项目台账-成本报表-材料支出明细");
      return ResultBuilder.success(this.contractProjectBiz.getProjectMaterialDeductDetails(projectId, pageNumber, pageSize));
   }

   @ApiOperation("成本报表-其他费用明细")
   @GetMapping("/costReport/other")
   public ResultVO<PageVO<ProjectElseAllDto>> otherDetails(
      @RequestParam Long projectId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用 ： 项目台账-成本报表-其他费用明细");
      return ResultBuilder.success(this.contractProjectBiz.getProjectOtherDetails(projectId, pageNumber, pageSize));
   }

   @ApiOperation("成本报表-管理费明细")
   @GetMapping("/costReport/management")
   public ResultVO<PageVO<ManagementFeeAllDto>> managementFee(
      @RequestParam Long projectId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用 ： 项目台账-成本报表-管理费明细");
      return ResultBuilder.success(this.contractProjectBiz.getProjectManagementFeeDetails(projectId, pageNumber, pageSize));
   }

   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query")
      }
   )
   @ApiOperation("项目台账-资金利息详情")
   @GetMapping("/costReport/interest")
   public ResultVO<PageVO<ContractProjectManagerMoneyInterestsDto>> projectInterest(
      @RequestParam Long projectId,
      @RequestParam LocalDateTime startDate,
      @RequestParam LocalDateTime endDate,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用 ： 项目台账-资金利息详情");
      return ResultBuilder.success(this.moneyInterestService.getProjectInterest(projectId, pageNumber, pageSize, startDate, endDate));
   }

   @ApiOperation("项目台账-资金利息按照季度统计")
   @ApiImplicitParams(@ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"))
   @GetMapping("/costReport/quarterInterest")
   public ResultVO<List<ContractProjectInterestFundsDto>> projectQuarterInterest(
      @RequestParam Long projectId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用 ： 项目台账-资金利息按照季度统计");
      return ResultBuilder.success(this.moneyInterestService.getProjectQuarterInterest(projectId));
   }

   @ApiOperation("项目台账-注资信息下载（打印）")
   @ApiImplicitParams(@ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long"))
   @GetMapping("/costReport/download/{projectId}")
   public ResultVO projectDownload(@PathVariable Long projectId) {
      log.info("Api调用 ： 项目台账-注资信息下载（打印）");
      return ResultBuilder.success(this.assetInjectionBiz.getProjectDownload(projectId));
   }

   @ApiOperation("项目台账-支出、支出开票下载（打印）")
   @ApiImplicitParams(@ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long"))
   @GetMapping("/costReport/download/invoice")
   public ResultVO projectInvoiceDownload(@RequestParam Long projectId) {
      log.info("Api调用 ： 项目台账-支出、支出开票下载（打印）");
      return ResultBuilder.success(this.disburseDetailBiz.getSupplierInvoiceDownload(projectId));
   }

   @ApiOperation("项目台账-成本报表下载")
   @ApiImplicitParams(@ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long"))
   @GetMapping("/costReport/costStatement")
   public ResultVO projectCostStatement(@RequestParam Long projectId, HttpServletResponse response) {
      log.info("Api调用 ： 项目台账-成本报表下载");
      return ResultBuilder.success(this.contractProjectBiz.getProjectCostReportDownload(projectId, response));
   }

   @ApiOperation("项目台账-供应商台账(自营)")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long"),
            @ApiImplicitParam(name = "supplierId", value = "供应商id", dataType = "Long"),
            @ApiImplicitParam(name = "serialNumber", value = "合同号", dataType = "String"),
            @ApiImplicitParam(name = "settlementStatus", value = "结算状态", dataType = "Integer"),
            @ApiImplicitParam(name = "purchaseType", value = "采购类型", dataType = "Integer"),
            @ApiImplicitParam(name = "year", value = "年份", dataType = "LocalDateTime"),
            @ApiImplicitParam(name = "level", value = "等级", dataType = "Integer")
      }
   )
   @GetMapping("/projectLedger/supplierLedger")
   @PreAuthorize("@contractCollectionAccess.supplierLedgerRead(#param.projectId,#param.level,#branchCompanyId)")
   public ResultVO<PageVO<PurchaseOrderDTO>> projectSupplierLedger(
      SupplierLedgerParam param,
      @RequestHeader(value = "financeBranchId", required = false) Long branchCompanyId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用 ： 项目台账-供应商台账");
      param.setBranchCompanyId(branchCompanyId);
      return ResultBuilder.success(this.purchaseOrderBiz.getProjectSupplierLedger(param, pageNumber, pageSize));
   }

   @ApiOperation("项目台账-支出台账-订单编号列表(筛选框)")
   @GetMapping("/projectLedger/getOrderNumber/{level}")
   @PreAuthorize("@contractCollectionAccess.supplierLedgerRead(null,#level,#branchCompanyId)")
   public ResultVO getOrderNumber(
      @PathVariable Integer level, Integer purchaseType, @RequestHeader(value = "financeBranchId", required = false) Long branchCompanyId
   ) {
      log.info("Api调用 ： 项目台账-获取采购合同号");
      return ResultBuilder.success(this.purchaseOrderBiz.getOrderNumber(level, purchaseType, branchCompanyId));
   }

   @ApiOperation("项目台账-支出台账-项目列表(筛选框)")
   @GetMapping("/projectLedger/projectFilter")
   @PreAuthorize("#projectAttribute == 1 && @contractCollectionAccess.supplierLedgerRead(null,#level,#branchCompanyId)")
   public ResultVO<List<ProjectInfo>> projectFilter(
      @RequestParam Integer projectAttribute, @RequestParam Integer level, @RequestHeader(value = "financeBranchId", required = false) Long branchCompanyId
   ) {
      log.info("Api调用 ： 项目台账-供应商台账项目筛选");
      Integer actualLevel = this.contractCollectionAccess.supplierLedgerLevel(level, branchCompanyId);
      return ResultBuilder.success(this.contractCollectionAccess.supplierLedgerProjects(
         this.contractProjectBiz.getProjectFilter(projectAttribute, actualLevel, branchCompanyId), actualLevel, branchCompanyId));
   }

   @ApiOperation("项目台账-供应商台账-付款列表")
   @GetMapping("/projectLedger/supplierLedger/paymentList")
   @PreAuthorize("@contractCollectionAccess.supplierOrderRead(#orderId,#purchaseType)")
   public ResultVO<PageVO<SupplierPaymentDetailDto>> getSupplierLedgerPaymentList(
      Integer purchaseType,
      @RequestParam Long orderId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:项目台账-供应商台账-付款列表");
      if (purchaseType != null && purchaseType.equals(4)) {
         return ResultBuilder.success(new PageVO<>());
      } else if (purchaseType != null && purchaseType.equals(8)) {
         return ResultBuilder.success(this.subcontractOrderBiz.getPaymentList(orderId, pageNumber, pageSize));
      } else {
         return purchaseType != null && purchaseType.equals(16)
            ? ResultBuilder.success(new PageVO<>())
            : ResultBuilder.success(this.purchaseOrderBiz.getPaymentDetail(orderId, pageNumber, pageSize));
      }
   }

   @ApiOperation("项目台账-供应商台账-付款列表-打印")
   @GetMapping("/projectLedger/supplierLedger/paymentList/print")
   @PreAuthorize("@contractCollectionAccess.supplierOrderRead(#orderId,#purchaseType)")
   public ResultVO<PrintVO<List<SupplierPaymentDetailDto>>> printSupplierLedgerPaymentList(Integer purchaseType, @RequestParam Long orderId) {
      if (purchaseType != null && purchaseType.equals(4)) {
         return ResultBuilder.success(null);
      } else if (purchaseType != null && purchaseType.equals(8)) {
         return ResultBuilder.success(this.subcontractOrderBiz.printPaymentList(orderId));
      } else {
         return purchaseType != null && purchaseType.equals(16)
            ? ResultBuilder.success(null)
            : ResultBuilder.success(this.purchaseOrderBiz.getPaymentDetailDownload(orderId));
      }
   }

   @ApiOperation("项目台账-供应商台账-收票列表")
   @GetMapping("/projectLedger/supplierLedger/invoiceList")
   @PreAuthorize("@contractCollectionAccess.supplierOrderRead(#orderId,#purchaseType)")
   public ResultVO<PageVO<SupplierInvoiceDetailDto>> getSupplierLedgerInvoiceList(
      Integer purchaseType,
      @RequestParam Long orderId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:项目台账-供应商台账-收票列表");
      if (purchaseType != null && purchaseType.equals(4)) {
         return ResultBuilder.success(new PageVO<>());
      } else if (purchaseType != null && purchaseType.equals(8)) {
         return ResultBuilder.success(this.subcontractOrderBiz.getInvoiceList(orderId, pageNumber, pageSize));
      } else {
         return purchaseType != null && purchaseType.equals(16)
            ? ResultBuilder.success(new PageVO<>())
            : ResultBuilder.success(this.purchaseOrderBiz.getInvoiceDetail(orderId, pageNumber, pageSize));
      }
   }

   @ApiOperation("项目台账-供应商台账-收票列表-打印")
   @GetMapping("/projectLedger/supplierLedger/invoiceList/print")
   @PreAuthorize("@contractCollectionAccess.supplierOrderRead(#orderId,#purchaseType)")
   public ResultVO<PrintVO<List<SupplierInvoiceDetailDto>>> printSupplierLedgerInvoiceList(Integer purchaseType, @RequestParam Long orderId) {
      log.info("Api调用:项目台账-供应商台账-收票列表");
      if (purchaseType != null && purchaseType.equals(4)) {
         return ResultBuilder.success(null);
      } else if (purchaseType != null && purchaseType.equals(8)) {
         return ResultBuilder.success(this.subcontractOrderBiz.printInvoiceList(orderId));
      } else {
         return purchaseType != null && purchaseType.equals(16)
            ? ResultBuilder.success(null)
            : ResultBuilder.success(this.purchaseOrderBiz.getInvoiceDetailDownload(orderId));
      }
   }

   @ApiOperation("项目台账-供应商台账-结算列表")
   @GetMapping("/projectLedger/supplierLedger/settleList")
   @PreAuthorize("@contractCollectionAccess.supplierOrderRead(#orderId,#purchaseType)")
   public ResultVO<PageVO<SupplierSettlementDTO>> getSupplierLedgerSettleList(
      Integer purchaseType,
      @RequestParam Long orderId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:项目台账-供应商台账-结算列表");
      if (purchaseType != null && purchaseType.equals(4)) {
         return ResultBuilder.success(new PageVO<>());
      }

      if (purchaseType != null && purchaseType.equals(8)) {
         return ResultBuilder.success(new PageVO<>(this.subcontractOrderBiz.listSubOrderSettle(orderId, false)));
      }

      if (purchaseType != null && purchaseType.equals(16)) {
         return ResultBuilder.success(new PageVO<>());
      }

      List<SupplierSettlementDTO> settlementDTOList = this.purchaseOrderBiz.listSettleDetail(orderId, false);
      return ResultBuilder.success(PageUtil.listPage(pageNumber, pageSize, settlementDTOList));
   }

   @ApiOperation("项目台账-供应商台账-结算列表-打印")
   @GetMapping("/projectLedger/supplierLedger/settleList/print")
   @PreAuthorize("@contractCollectionAccess.supplierOrderRead(#orderId,#purchaseType)")
   public ResultVO<PrintVO<List<SupplierSettlementDTO>>> getSupplierLedgerSettleList(Integer purchaseType, @RequestParam Long orderId) {
      log.info("Api调用:项目台账-供应商台账-结算列表");
      if (purchaseType != null && purchaseType.equals(4)) {
         return ResultBuilder.success(null);
      } else if (purchaseType != null && purchaseType.equals(8)) {
         return ResultBuilder.success(this.subcontractOrderBiz.printListSubOrderSettle(orderId, false));
      } else {
         return purchaseType != null && purchaseType.equals(16)
            ? ResultBuilder.success(null)
            : ResultBuilder.success(this.purchaseOrderBiz.printListSettleDetail(orderId, false));
      }
   }

   @ApiOperation("项目台账-供应商台账-预结算列表")
   @GetMapping("/projectLedger/supplierLedger/preSettleList")
   @PreAuthorize("@contractCollectionAccess.supplierOrderRead(#orderId,null)")
   public ResultVO<ListVO<SupplierSettlementDTO>> getSupplierLedgerPreSettleList(@RequestParam Long orderId) {
      log.info("Api调用:项目台账-供应商台账-预结算列表");
      List<SupplierSettlementDTO> settlementDTOList = this.purchaseOrderBiz.listSettleDetail(orderId, true);
      return ResultBuilder.success(new ListVO<>(settlementDTOList));
   }

   @ApiOperation("项目台账-供应商台账-预结算列表-打印")
   @GetMapping("/projectLedger/supplierLedger/preSettleList/print")
   @PreAuthorize("@contractCollectionAccess.supplierOrderRead(#orderId,null) or @scmPurchaseOrderAccess.read(#orderId)")
   public ResultVO<PrintVO<List<SupplierSettlementDTO>>> printSupplierLedgerPreSettleList(@RequestParam Long orderId) {
      log.info("Api调用:项目台账-供应商台账-结算列表");
      return ResultBuilder.success(this.purchaseOrderBiz.printListSettleDetail(orderId, true));
   }

   @ApiOperation("项目台账-供应商台账-入库列表")
   @GetMapping("/projectLedger/supplierLedger/inboundList")
   @PreAuthorize("@contractCollectionAccess.supplierOrderRead(#orderId,null)")
   public ResultVO<ListVO<PuchaseInboundDetailDTO>> getInboundDetail(@RequestParam Long orderId, LocalDate startDate, LocalDate endDate) {
      log.info("API 调用:项目台账-供应商台账-入库列表-供应商台账-入库列表");
      return ResultBuilder.success(new ListVO<>(this.inboundService.orderDetailV2(orderId, startDate, endDate)));
   }

   @ApiOperation("项目台账-供应商台账-入库列表-打印")
   @GetMapping("/projectLedger/supplierLedger/inboundList/download")
   @PreAuthorize("@contractCollectionAccess.supplierOrderRead(#orderId,null)")
   public ResultVO getInboundDetailPrint(@RequestParam Long orderId, LocalDate startDate, LocalDate endDate) {
      log.info("API 调用:采购合同-入库详情-打印");
      return ResultBuilder.success(this.inboundService.orderDetailV2Download(orderId, startDate, endDate));
   }

   @ApiOperation("成本报表-安装单位-期间成本(自营)")
   @GetMapping("/selfSupportCost/{projectId}")
   public ResultVO<List<PeriodCostDTO>> periodCostDetail(@PathVariable Long projectId) {
      log.info("Api调用 ： 项目台账-成本报表-期间成本(自营)");
      return ResultBuilder.success(this.contractProjectBiz.getPeriodCostDetail(projectId));
   }

   @ApiOperation("成本报表-成本科目期间成本-下载打印(自营)")
   @GetMapping("/periodCost/download")
   public ResultVO selfSupportCostDetail(@RequestParam Long projectId, LocalDateTime year) {
      log.info("Api调用 ： 成本报表-成本科目期间成本-下载打印(自营)");
      Integer intYear = year != null ? year.getYear() : null;
      return ResultBuilder.success(this.contractProjectBiz.getSelfSupportCostDetail(projectId, intYear));
   }

   @ApiOperation("中南定制(获取项目的增补项目)")
   @GetMapping("/get/project/additional/project/{projectId}")
   public ResultVO<List<ProjectRelevancyDTO>> getProjectAdditionalProject(@PathVariable("projectId") Integer projectId) {
      log.info("API调用:中南定制(获取项目的增补项目)");
      return ResultBuilder.success(this.contractProjectBiz.getProjectAdditionalProject(projectId));
   }

   @ApiOperation("中南定制(批量获取项目的增补项目)")
   @PostMapping("/get/project/additional/project/batch")
   public ResultVO<Map<Integer, List<ProjectRelevancyDTO>>> getProjectAdditionalProjectBatch(@RequestBody List<Integer> projectIds) {
      log.info("API调用:中南定制(批量获取项目的增补项目)");
      return ResultBuilder.success(this.contractProjectBiz.getProjectAdditionalProjectBatch(projectIds));
   }
}
