package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.project.core.api.biz.ProjectReceivedProblemBiz;
import com.hzchum.scim.project.core.api.biz.ProjectReceivingBiz;
import com.hzchum.scim.project.core.api.enums.StoreTypeEnum;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingBoardDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingInstallDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingInstallSumDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingRecordDTO;
import com.hzchum.scim.project.core.api.pojo.dto.mes.ProjectCargoListProductDTO;
import com.hzchum.scim.project.core.api.pojo.dto.mes.ProjectCargoListReceivingDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.put.ProjectReceivedProblemPutDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.CargoListQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectBaseQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ReceivingBoardQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ReceivingStatementQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectConfirmCargoListReceivingDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectConfirmCargoListReceivingDTOParamV2;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectPurchaseReceivingDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectReceivingSummaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目管理-收货管理")
@RestController
@RequestMapping("/api/project/receiving")
public class ProjectReceivingController {
   private static final Logger log = LoggerFactory.getLogger(ProjectReceivingController.class);
   @Resource
   private ProjectReceivingBiz projectReceivingBiz;
   @Resource
   private ProjectReceivingSummaryService receivingSummaryService;
   @Resource
   private ProjectReceivedProblemBiz problemBiz;

   @ApiOperation("自制收货-发运列表")
   @GetMapping("/listReceiving")
   public ResultVO<PageVO<ProjectCargoListReceivingDTO>> listCargoListReceiving(
      @Valid CargoListQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:自制收货列表");
      return ResultBuilder.success(this.projectReceivingBiz.listProjectSelfReceiving(param, pageNumber, pageSize));
   }

   @ApiOperation("根据发运ID,查询产品列表")
   @ApiImplicitParam(name = "cargoListId", value = "发货记录id", paramType = "path", required = true)
   @GetMapping("/listProduct/{cargoListId}")
   public ResultVO<ListVO<ProjectCargoListProductDTO>> listCargoListProduct(@PathVariable Long cargoListId, @RequestParam Long projectId) {
      log.info("Api调用:收货产品列表");
      return ResultBuilder.success(this.projectReceivingBiz.listCargoListProduct(cargoListId, projectId));
   }

   @ApiOperation("根据发运ID,查询产品列表")
   @ApiImplicitParam(name = "cargoListId", value = "发货记录id", paramType = "path", required = true)
   @GetMapping("/listProductUp/{cargoListId}")
   public ResultVO<ListVO<ProjectCargoListProductDTO>> listCargoListProductUp(@PathVariable Long cargoListId, @RequestParam Long projectId) {
      log.info("Api调用:收货产品列表");
      return ResultBuilder.success(this.projectReceivingBiz.listCargoListProductUp(cargoListId, projectId));
   }

   @ApiOperation("打印-发运产品列表")
   @ApiImplicitParam(name = "cargoListId", value = "发货记录id", paramType = "path", required = true)
   @GetMapping("/listProductUp/{cargoListId}/print")
   public ResultVO printListCargoListProductUp(@PathVariable Long cargoListId, @RequestParam Long projectId) {
      log.info("Api调用:打印收货产品列表");
      return ResultBuilder.success(this.projectReceivingBiz.printListCargoListProductUp(cargoListId, projectId));
   }

   @ApiOperation("打印-发运产品列表")
   @ApiImplicitParam(name = "cargoListId", value = "发货记录id", paramType = "path", required = true)
   @GetMapping("/listProduct/{cargoListId}/print")
   @PreAuthorize("@permission.check('homemade_delivery:print')")
   public ResultVO printListReceivingProduct(@PathVariable Long cargoListId, @RequestParam Long projectId) {
      log.info("Api调用:打印收货产品列表");
      return ResultBuilder.success(this.projectReceivingBiz.printListCargoListProduct(cargoListId, projectId));
   }

   @ApiOperation("自制产品确认收货")
   @PostMapping("/confirmReceiving")
   @PreAuthorize("@permission.check('homemade_delivery:audit')")
   public ResultVO confirmReceiving(@RequestBody ProjectConfirmCargoListReceivingDTOParam param) {
      log.info("Api调用:确收收货");
      return ResultBuilder.success(this.projectReceivingBiz.confirmCargoListReceiving(param));
   }

   @ApiOperation("根据发运ID,可收货产品列表")
   @ApiImplicitParam(name = "cargoListId", value = "发货记录id", paramType = "path", required = true)
   @GetMapping("/listCanReceiveProduct/{cargoListId}")
   public ResultVO<ListVO<ProjectCargoListProductDTO>> listCargoListCanReceiveProduct(@PathVariable Long cargoListId) {
      log.info("Api调用:可收货产品列表");
      return ResultBuilder.success(this.projectReceivingBiz.listCargoListProductV2(cargoListId));
   }

   @ApiOperation("自制产品确认收货V2")
   @PostMapping("/confirmReceivingV2")
   @SignerCheck(lockKey = {"#param.projectId", "#param.cargoListId"}, message = "操作失败,请稍后刷新重试!")
   public ResultVO confirmReceiving(@RequestBody @Valid ProjectConfirmCargoListReceivingDTOParamV2 param) {
      log.info("Api调用:自制产品确认收货V2");
      return ResultBuilder.success(this.projectReceivingBiz.confirmCargoListReceivingV2(param));
   }

   @ApiOperation("外购收货-合同简单信息(新)")
   @GetMapping("/orderSimpleInfo")
   public ResultVO getPurchaseOrderSimpleInfo(@RequestParam Long projectId, @RequestParam Long supplierId) {
      log.info("Api调用:外购合同简单信息");
      return ResultBuilder.success(this.projectReceivingBiz.getPurchaseOrderSimpleInfo(projectId, supplierId));
   }

   @ApiOperation("外购收货-创建采购合同的供应商")
   @GetMapping("/orderSupplier/list")
   public ResultVO getPurchaseOrderSupplier(@RequestParam Long projectId) {
      log.info("Api调用: 创建采购合同的供应商");
      return ResultBuilder.success(this.projectReceivingBiz.getPurchaseOrderSupplier(projectId));
   }

   @ApiOperation("外购收货-可收货产品(新)")
   @GetMapping("/purchaseProductDetails")
   public ResultVO getPurchaseProductDetailsInfo(
      @RequestParam Long contractId,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String material
   ) {
      log.info("Api调用:外购收货可收货产品");
      return ResultBuilder.success(this.projectReceivingBiz.getPurchaseProductDetailsInfo(contractId, name, serialNumber, specification, material));
   }

   @ApiOperation("外购收货-确认收货(新)")
   @PostMapping("/purchaseReceiving")
   @SignerCheck(lockKey = {"#param.projectId", "#param.contractId"}, message = "操作失败,请稍后刷新重试!")
   public ResultVO purchaseReceiving(@RequestBody @Valid ProjectPurchaseReceivingDTOParam param) {
      log.info("Api调用:外购产品确认收货");
      return ResultBuilder.success(this.projectReceivingBiz.purchaseReceiving(param));
   }

   @ApiOperation("外购收货-创建列表(新)")
   @GetMapping("/operateRecordPage")
   public ResultVO getOperateRecordPage(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long supplierId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 外购收货-创建列表");
      return ResultBuilder.success(this.projectReceivingBiz.getOperateRecordPage(projectId, supplierId, pageNumber, pageSize));
   }

   @ApiOperation("外购收货-创建详情(新)")
   @GetMapping("/operateDetails")
   public ResultVO getOperateRecordDetails(@RequestParam Long operateId) {
      log.info("Api调用:外购收货-创建详情");
      return ResultBuilder.success(this.projectReceivingBiz.getOperateRecordDetails(operateId));
   }

   @ApiOperation("外购收货-详情打印(新)")
   @GetMapping("/operateDetails/{operateId}/print")
   public ResultVO listCargoListCanReceiveProductPrint(@PathVariable Long operateId) {
      log.info("Api调用:外购收货-详情打印");
      return ResultBuilder.success(this.projectReceivingBiz.operateRecordDetailsPrint(operateId));
   }

   @ApiOperation("打印-可收货产品列表")
   @ApiImplicitParam(name = "cargoListId", value = "发货记录id", paramType = "path", required = true)
   @GetMapping("/listCanReceiveProduct/{cargoListId}/print")
   public ResultVO listCargoListCanReceiveProductPrint(@PathVariable Long cargoListId, @RequestParam Long projectId) {
      log.info("Api调用:打印收货产品列表");
      return ResultBuilder.success(this.projectReceivingBiz.listCargoListCanReceiveProductPrint(cargoListId, projectId));
   }

   @ApiOperation("收货报表")
   @GetMapping("/receiving-statement")
   @PreAuthorize("@permission.check('delivery_report_list:get')")
   public ResultVO<PageVO<ProjectReceivingRecordDTO>> listReceivingStatement(
      @Valid ReceivingStatementQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 查看收货报表");
      return ResultBuilder.success(this.projectReceivingBiz.listReceivingRecord(param, pageNumber, pageSize));
   }

   @ApiOperation("收货报表V2")
   @GetMapping("/receiving-statementV2")
   public ResultVO<PageVO<ProjectReceivingRecordDTO>> listReceivingRecordV2(
      @Valid ReceivingStatementQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 查看收货报表");
      return ResultBuilder.success(this.projectReceivingBiz.listReceivingRecordV2(param, pageNumber, pageSize));
   }

   @ApiOperation("打印收货报表")
   @GetMapping("/receiving-statement/print")
   @PreAuthorize("@permission.check('delivery_report_list:print')")
   public ResultVO printListReceivingStatement(@Valid ReceivingStatementQueryDTOParam param) {
      log.info("Api调用: 打印收货报表");
      return ResultBuilder.success(this.projectReceivingBiz.printListReceivingRecord(param));
   }

   @ApiOperation("打印收货报表")
   @GetMapping("/receiving-statement/printV2")
   public ResultVO printListReceivingRecordV2(@Valid ReceivingStatementQueryDTOParam param) {
      log.info("Api调用: 打印收货报表");
      return ResultBuilder.success(this.projectReceivingBiz.printListReceivingRecordV2(param));
   }

   @ApiOperation("收货看板")
   @GetMapping("/receiving-board")
   @PreAuthorize("@permission.check('delivery_report_dashboard:get')")
   public ResultVO<PageVO<ProjectReceivingBoardDTO>> listReceivingBoard(
      @Valid ReceivingBoardQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 查看收货看板");
      return ResultBuilder.success(this.projectReceivingBiz.listReceivingBoard(param, pageNumber, pageSize));
   }

   @ApiOperation("收安报表")
   @GetMapping("/receiving-install-statement")
   @PreAuthorize("@permission.check('delivery_install_list:get')")
   public ResultVO<PageVO<ProjectReceivingInstallDTO>> listReceivingInstallStatement(
      @Valid ProjectBaseQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 收货安装报表");
      return ResultBuilder.success(this.projectReceivingBiz.listReceivingInstall(param, pageNumber, pageSize));
   }

   @ApiOperation("打印收安报表")
   @GetMapping("/receiving-install-statement/print")
   @PreAuthorize("@permission.check('delivery_install_list:print')")
   public ResultVO printListReceivingInstallStatement(@Valid ProjectBaseQueryDTOParam param) {
      log.info("Api调用: 打印收货安装报表");
      return ResultBuilder.success(this.projectReceivingBiz.printListReceivingInstall(param));
   }

   @ApiOperation("收安报表统计信息")
   @GetMapping("/receiving-install-sum")
   @PreAuthorize("@permission.check('delivery_install_list:get')")
   public ResultVO<ProjectReceivingInstallSumDTO> getReceivingInstallSum(@Valid ProjectBaseQueryDTOParam param) {
      log.info("Api调用: 查询收安报表统计信息");
      return ResultBuilder.success(this.projectReceivingBiz.getReceivingInstallSum(param));
   }

   @ApiOperation("收货问题记录")
   @GetMapping("/problem/page")
   @PreAuthorize("@permission.check('issue_record:get')")
   public ResultVO getProblemPage(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long supplierId,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("Api调用: 收货问题记录");
      return ResultBuilder.success(this.problemBiz.getProblemPage(projectId, supplierId, pageNumber, pageSize));
   }

   @ApiOperation("收货问题详情")
   @GetMapping("/problem/details")
   @PreAuthorize("@permission.check('issue_record:detail')")
   public ResultVO getProblemDetails(@RequestParam Long problemId) {
      log.info("Api调用: 收货问题详情");
      return ResultBuilder.success(this.problemBiz.getProblemDetails(problemId));
   }

   @ApiOperation("收货问题关闭")
   @PutMapping("/problem/close")
   @PreAuthorize("@permission.check('issue_record:closeIssue')")
   public ResultVO getProblemDetails(@RequestBody @Validated ProjectReceivedProblemPutDTOParam param) {
      log.info("Api调用: 收货问题关闭");
      return ResultBuilder.success(this.problemBiz.closeProblem(param));
   }

   @ApiOperation("收安存汇总")
   @GetMapping("/receivedInstallStore/summary")
   public ResultVO getReceivedInstallStore(@RequestParam LocalDate year, @RequestParam Long projectId, @RequestParam Integer productType) {
      log.info("Api调用: 收安存汇总");
      return ResultBuilder.success(this.projectReceivingBiz.getReceivedInstallStore(year, projectId, productType));
   }

   @ApiOperation("收安存详情")
   @GetMapping("/receivedInstallStore/details")
   public ResultVO getReceivedInstallStoreDetails(
      @RequestParam String yearMonth,
      @RequestParam Long projectId,
      @RequestParam Integer productType,
      @RequestParam @EnumValidator(value = StoreTypeEnum.class, message = "详情类型不正确!") Integer storeType,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("Api调用: 收安存详情");
      return ResultBuilder.success(this.projectReceivingBiz.getReceivedInstallStoreDetails(yearMonth, projectId, productType, storeType, pageNumber, pageSize));
   }

   @ApiOperation("收货记录")
   @GetMapping("/received/page")
   public ResultVO getReceivedPage(
      @RequestParam Long projectId,
      @RequestParam Integer sourceType,
      @RequestParam(required = false) Integer productType,
      @RequestParam(required = false) Long supplierId,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) LocalDate startTime,
      @RequestParam(required = false) LocalDate endTime,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("Api调用: 收货记录");
      return ResultBuilder.success(
         this.projectReceivingBiz.getReceivedPage(projectId, sourceType, productType, supplierId, name, serialNumber, startTime, endTime, pageNumber, pageSize)
      );
   }

   @ApiOperation("打印-收货记录")
   @GetMapping("/received/print")
   public ResultVO getReceivedPrint(
      @RequestParam Long projectId,
      @RequestParam Integer sourceType,
      @RequestParam(required = false) Integer productType,
      @RequestParam(required = false) Long supplierId,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) LocalDate startTime,
      @RequestParam(required = false) LocalDate endTime
   ) {
      log.info("打印-收货记录");
      return ResultBuilder.success(
         this.projectReceivingBiz.getReceivedPrint(projectId, sourceType, productType, supplierId, name, serialNumber, startTime, endTime)
      );
   }
}
