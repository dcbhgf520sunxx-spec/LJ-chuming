package com.hzchum.scim.rest.controller.scm;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveOpinionDTOParam;
import com.hzchum.scim.contract.core.api.enums.visa.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementDTO;
import com.hzchum.scim.rest.pojo.vo.scm.purchase.QueryPurchaseOrderVOParam;
import com.hzchum.scim.scm.core.api.biz.PurchaseOrderBiz;
import com.hzchum.scim.scm.core.api.enums.PurchaseStatusEnum;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierInvoiceDetailDto;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierPaymentDetailDto;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.PurchaseOrderDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.QueryPurchaseOrderDTOParam;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.PuchaseInboundDetailDTO;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "scm-自合营内包采购")
@RestController
@RequestMapping("/api/v2/scm/purchase-order")
public class PurchaseOrderControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(PurchaseOrderControllerV2.class);
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private PurchaseOrderBiz purchaseOrderBiz;
   @Resource
   private InboundService inboundService;
   @Resource
   private InboundManufacturedService inboundManufacturedService;

   @ApiOperation("自营根据ID查询")
   @GetMapping("/{id}")
   @PreAuthorize("@permission.check('scm_purchaseOrder:detail','scm_purchaseOrder_self_v2:detail')")
   public ResultVO getById(@PathVariable("id") Long id) {
      log.info("API 调用 ：自营根据ID查询");
      return ResultBuilder.success(this.purchaseOrderService.selectByIdPurchaseOrder(id));
   }

   @ApiOperation("内包合营根据ID查询")
   @GetMapping("/innerSourcingGetById/{id}")
   @PreAuthorize("@permission.check('scm_purchaseOrder_v2:detail')")
   public ResultVO innerSourcingGetById(@PathVariable("id") Long id) {
      log.info("API 调用 ：内包合营根据ID查询");
      return ResultBuilder.success(this.purchaseOrderService.selectByIdPurchaseOrder(id));
   }

   @ApiOperation("查询订单统计记录")
   @GetMapping("/statistics")
   public ResultVO getStatistics(@RequestParam("createTime") List<LocalDateTime> createTime) {
      log.info("API 调用 : 查询订单统计记录");
      return ResultBuilder.success(this.purchaseOrderService.getStatisticsV2(createTime));
   }

   @ApiOperation("自营采购根据条件分页查询采购订单列表")
   @GetMapping
   @PreAuthorize("@permission.check('scm_purchaseOrder_self_v2:get','purchase_analysis:get')")
   public ResultVO list(
      QueryPurchaseOrderVOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：自营采购根据条件分页查询采购订单列表");
      param.setProjectAttribute("1");
      return ResultBuilder.success(this.purchaseOrderService.pageInfoV2(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("内包合营根据条件分页查询采购订单列表")
   @GetMapping("/innerSourcingList")
   @PreAuthorize("@permission.check('scm_purchaseOrder_v2:get')")
   public ResultVO innerSourcingList(
      QueryPurchaseOrderVOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：内包合营根据条件分页查询采购订单列表");
      if (StrUtil.isBlank(param.getProjectAttribute())) {
         param.setProjectAttribute(ProjectAttributeEnum.JOINT_VENTURE.getType() + "," + ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType());
      }

      return ResultBuilder.success(this.purchaseOrderService.pageInfoV2(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("查询未完成的采购订单的简单信息")
   @GetMapping("/purchasing/all/brief")
   public ResultVO listBrief(Boolean BoolAnnual, Long supplierId, Integer level, Integer dataStatus, Long workshopId, Integer orderPlace) {
      log.info("API 调用 ：查询未完成采购订单的简单信息");
      List<Integer> projectAttribute = new ArrayList<>();
      projectAttribute.add(ProjectAttributeEnum.SELF_SUPPORT.getType());
      projectAttribute.add(ProjectAttributeEnum.JOINT_VENTURE.getType());
      return ResultBuilder.success(this.purchaseOrderService.listBriefV2(BoolAnnual, supplierId, level, dataStatus, projectAttribute, workshopId, orderPlace));
   }

   @ApiOperation("查询未完成的采购订单的简单信息V2")
   @GetMapping("/purchasing/all/briefV2")
   public ResultVO listBrief(
      QueryPurchaseOrderDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：查询未完成的采购订单的简单信息V2");
      param.setProjectAttribute(ProjectAttributeEnum.SELF_SUPPORT.getType() + "," + ProjectAttributeEnum.JOINT_VENTURE.getType());
      param.setPurchaseStatus(PurchaseStatusEnum.DURING.getType());
      param.setDataStatus(2);
      param.setOrderPlace(2);
      return ResultBuilder.success(this.purchaseOrderService.getSimplePageList(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("查询未完成的采购订单的供应商信息")
   @GetMapping("/supplier/brief")
   public ResultVO listBrief(Boolean BoolAnnual, Integer level, Integer dataStatus, Integer orderPlace) {
      log.info("API 调用 ：查询未完成的采购订单的供应商信息");
      List<Integer> projectAttribute = new ArrayList<>();
      projectAttribute.add(ProjectAttributeEnum.SELF_SUPPORT.getType());
      projectAttribute.add(ProjectAttributeEnum.JOINT_VENTURE.getType());
      return ResultBuilder.success(this.purchaseOrderService.getSupplier(BoolAnnual, level, dataStatus, projectAttribute, orderPlace));
   }

   @ApiOperation("编辑自营采购单")
   @PutMapping("/updatePurchaseOrder")
   @PreAuthorize("@permission.check('scm_purchaseOrder_self_v2:edit')")
   public ResultVO updatePurchaseOrder(@RequestBody PurchaseOrderDTOParam param) {
      log.info("API 调用 ：编辑自营采购单");
      Preconditions.checkArgument(param.getIsGoForOaApproval() != null, "请先选择是否走OA");
      if (param.getIsGoForOaApproval().equals(Boolean.FALSE)) {
         log.info("--------不走OA--------------");
         return ResultBuilder.success(this.purchaseOrderService.updatePurchaseOrderV2(param));
      } else {
         log.info("--------走OA--------------");
         return ResultBuilder.success(this.purchaseOrderService.updateOaPurchaseOrderV2(param));
      }
   }

   @ApiOperation("编辑内包合营采购单")
   @PutMapping("/innerSourcingUpdatePurchaseOrder")
   @PreAuthorize("@scmPurchaseOrderAccess.edit(#param.id)")
   public ResultVO innerSourcingUpdatePurchaseOrder(@RequestBody PurchaseOrderDTOParam param) {
      log.info("API 调用 ：编辑内包合营采购单");
      return ResultBuilder.success(this.purchaseOrderService.updatePurchaseOrderV2(param));
   }

   @ApiOperation("自营修改采购状态")
   @PutMapping("/purchase-status")
   @PreAuthorize("@permission.check('scm_purchaseOrder_self_v2:editPurchaseStatus')")
   public ResultVO editPurchaseStatus(@RequestParam("id") Long id, @RequestParam("purchaseStatus") Integer purchaseStatus) {
      log.info("API 调用 : 自营修改采购状态");
      return ResultBuilder.success(this.purchaseOrderService.editPurchaseStatusV2(id, purchaseStatus));
   }

   @ApiOperation("内包合营修改采购状态")
   @PutMapping("/innerSourcingEditPurchaseStatus")
   @PreAuthorize("@permission.check('scm_purchaseOrder_v2:editPurchaseStatus')")
   public ResultVO innerSourcingEditPurchaseStatus(@RequestParam("id") Long id, @RequestParam("purchaseStatus") Integer purchaseStatus) {
      log.info("API 调用 : 内包合营修改采购状态");
      return ResultBuilder.success(this.purchaseOrderService.editPurchaseStatusV2(id, purchaseStatus));
   }

   @ApiOperation("自营查询暂存列表")
   @GetMapping("/StagingList")
   @PreAuthorize("@permission.check('scm_purchaseOrder_self_v2_storage:get')")
   public ResultVO StagingList(Integer boolTemporaryStorage) {
      log.info("API 调用 : 自营查询暂存列表");
      List<Integer> projectAttribute = new ArrayList<>();
      projectAttribute.add(ProjectAttributeEnum.SELF_SUPPORT.getType());
      return ResultBuilder.success(this.purchaseOrderService.StagingList(boolTemporaryStorage, projectAttribute));
   }

   @ApiOperation("内包合营查询暂存列表")
   @GetMapping("/innerSourcingStagingList")
   @PreAuthorize("@permission.check('scm_purchaseOrder_v2_storage:get')")
   public ResultVO innerSourcingStagingList(Integer boolTemporaryStorage) {
      log.info("API 调用 : 内包合营查询暂存列表");
      List<Integer> projectAttribute = new ArrayList<>();
      projectAttribute.add(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType());
      projectAttribute.add(ProjectAttributeEnum.JOINT_VENTURE.getType());
      return ResultBuilder.success(this.purchaseOrderService.StagingList(boolTemporaryStorage, projectAttribute));
   }

   @ApiOperation("自营查询暂存数量")
   @GetMapping("/StagingListCount")
   @PreAuthorize("@permission.check('scm_purchaseOrder_self_v2:get')")
   public ResultVO StagingListCount(Integer boolTemporaryStorage) {
      log.info("API 调用 ： 自营查询暂存数量");
      List<Integer> projectAttribute = new ArrayList<>();
      projectAttribute.add(ProjectAttributeEnum.SELF_SUPPORT.getType());
      return ResultBuilder.success(this.purchaseOrderService.StagingListCount(boolTemporaryStorage, projectAttribute));
   }

   @ApiOperation("内包合营查询暂存数量")
   @GetMapping("/innerSourcingStagingListCount")
   @PreAuthorize("@permission.check('scm_purchaseOrder_v2:get')")
   public ResultVO innerSourcingStagingListCount(Integer boolTemporaryStorage) {
      log.info("API 调用 ： 内包合营查询暂存数量");
      List<Integer> projectAttribute = new ArrayList<>();
      projectAttribute.add(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType());
      projectAttribute.add(ProjectAttributeEnum.JOINT_VENTURE.getType());
      return ResultBuilder.success(this.purchaseOrderService.StagingListCount(boolTemporaryStorage, projectAttribute));
   }

   @ApiOperation("自营一键清空暂存列表")
   @DeleteMapping("/deleteStagingPurchaseOrder")
   @PreAuthorize("@permission.check('scm_purchaseOrder_self_v2_storage:delAll')")
   public ResultVO deleteStagingPurchaseOrder() {
      log.info("API 调用 ： 自营一键清空暂存列表");
      List<Integer> projectAttribute = new ArrayList<>();
      projectAttribute.add(ProjectAttributeEnum.SELF_SUPPORT.getType());
      return ResultBuilder.success(this.purchaseOrderService.deleteStagingPurchaseOrder(projectAttribute));
   }

   @ApiOperation("内包合营一键清空暂存列表")
   @DeleteMapping("/innerSourcingDeleteStagingPurchaseOrder")
   @PreAuthorize("@permission.check('scm_purchaseOrder_v2_storage:delAll')")
   public ResultVO innerSourcingDeleteStagingPurchaseOrder() {
      log.info("API 调用 ： 内包合营一键清空暂存列表");
      List<Integer> projectAttribute = new ArrayList<>();
      projectAttribute.add(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType());
      projectAttribute.add(ProjectAttributeEnum.JOINT_VENTURE.getType());
      return ResultBuilder.success(this.purchaseOrderService.deleteStagingPurchaseOrder(projectAttribute));
   }

   @ApiOperation("自营根据ID删除暂存采购单")
   @DeleteMapping("/deleteByIdStagingPurchaseOrder")
   @PreAuthorize("@permission.check('scm_purchaseOrder_self_v2:del')")
   public ResultVO deleteByIdStagingPurchaseOrder(@RequestBody List<Long> ids) {
      log.info("API 调用 ： 自营根据ID删除自合营暂存采购单");
      return ResultBuilder.success(this.purchaseOrderService.deleteByIdStagingPurchaseOrder(ids));
   }

   @ApiOperation("内包合营根据ID删除暂存采购单")
   @DeleteMapping("/innerSourcingDeleteByIdStagingPurchaseOrder")
   @PreAuthorize("@permission.check('scm_purchaseOrder_v2:del')")
   public ResultVO innerSourcingDeleteByIdStagingPurchaseOrder(@RequestBody List<Long> ids) {
      log.info("API 调用 ： 内包合营根据ID删除自合营暂存采购单");
      return ResultBuilder.success(this.purchaseOrderService.deleteByIdStagingPurchaseOrder(ids));
   }

   @ApiOperation("提交自营合营采购单(暂存、新增)")
   @PostMapping("/submitReviewOrder")
   @PreAuthorize("@permission.check('scm_purchaseOrder_self:add','scm_requisitions_list:add','scm_purchaseOrder_self_v2:add')")
   public ResultVO submitReviewOrder(@RequestBody PurchaseOrderDTOParam param) {
      log.info("API 调用 :提交自营合营采购单(暂存、新增)");
      Preconditions.checkArgument(param.getIsGoForOaApproval() != null, "请先选择是否走OA");
      if (param.getIsGoForOaApproval().equals(Boolean.FALSE)) {
         log.info("--------不走OA--------------");
         return ResultBuilder.success(this.purchaseOrderService.submitReviewOrder(param));
      } else {
         log.info("--------走OA--------------");
         return ResultBuilder.success(this.purchaseOrderService.submitOaReviewOrder(param));
      }
   }

   @ApiOperation("提交内包合营采购单(暂存、新增)")
   @PostMapping("/innerSourcingSubmitReviewOrder")
   @PreAuthorize("@permission.check('scm_purchaseOrder_v2:add')")
   public ResultVO innerSourcingSubmitReviewOrder(@RequestBody PurchaseOrderDTOParam param) {
      log.info("API 调用 : 提交内包合营采购单(暂存、新增)");
      return ResultBuilder.success(this.purchaseOrderService.submitOaReviewOrder(param));
   }

   @ApiOperation("自营审批采购单")
   @PostMapping("/ApprovePurchaseOrder")
   public ResultVO ApprovePurchaseOrder(@RequestBody WmsApproveOpinionDTOParam wmsApproveOpinionDTOParam) {
      log.info("API 调用 ：自营审批采购单");
      return ResultBuilder.success(this.purchaseOrderService.ApprovePurchaseOrder(wmsApproveOpinionDTOParam));
   }

   @ApiOperation("内包合营审批采购单")
   @PostMapping("/innerSourcingApprovePurchaseOrder")
   public ResultVO innerSourcingApprovePurchaseOrder(@RequestBody WmsApproveOpinionDTOParam wmsApproveOpinionDTOParam) {
      log.info("API 调用 ：内包合营审批采购单");
      return ResultBuilder.success(this.purchaseOrderService.ApprovePurchaseOrder(wmsApproveOpinionDTOParam));
   }

   @ApiOperation("自营撤销采购单")
   @PostMapping("/revocation")
   public ResultVO revocation(@RequestBody String id) {
      log.info("API 调用 ：自营撤销采购单");
      JSONObject jsonObject = JSONObject.parseObject(id);
      Long idL = jsonObject.getLong("id");
      return ResultBuilder.success(this.purchaseOrderService.revocation(idL));
   }

   @ApiOperation("内包合营撤销采购单")
   @PostMapping("/innerSourcingRevocation")
   public ResultVO innerSourcingRevocation(@RequestBody String id) {
      log.info("API 调用 ：内包合营撤销采购单");
      JSONObject jsonObject = JSONObject.parseObject(id);
      Long idL = jsonObject.getLong("id");
      return ResultBuilder.success(this.purchaseOrderService.revocation(idL));
   }

   @ApiOperation("自营作废采购单")
   @PostMapping("/cancellation")
   @PreAuthorize("@permission.check('scm_purchaseOrder_self_v2:void')")
   public ResultVO cancellation(@RequestBody String id) {
      log.info("API 调用 ：自营作废采购单");
      JSONObject jsonObject = JSONObject.parseObject(id);
      Long idL = jsonObject.getLong("id");
      return ResultBuilder.success(this.purchaseOrderService.cancellation(idL));
   }

   @ApiOperation("内包合营作废采购单")
   @PostMapping("/innerSourcingCancellation")
   @PreAuthorize("@permission.check('scm_purchaseOrder_v2:void')")
   public ResultVO innerSourcingCancellation(@RequestBody String id) {
      log.info("API 调用 ：内包合营作废采购单");
      JSONObject jsonObject = JSONObject.parseObject(id);
      Long idL = jsonObject.getLong("id");
      return ResultBuilder.success(this.purchaseOrderService.cancellation(idL));
   }

   @ApiOperation("入库-查询采购详情")
   @GetMapping("/inbound/{id}")
   public ResultVO canInboundDetail(@PathVariable("id") Long id) {
      log.info("API 调用 : 入库-查询采购详情");
      return ResultBuilder.success(this.purchaseOrderService.canInboundDetailV2(id));
   }

   @ApiOperation("入库-根据车间查询自营采购供应商")
   @GetMapping("/inbound/supplier/{id}")
   public ResultVO getSuppliers(@PathVariable("id") Long id) {
      log.info("API 调用 : 入库-根据车间查询自营采购供应商");
      return ResultBuilder.success(this.purchaseOrderService.getSupplierInfo(id));
   }

   @ApiOperation("入库-查询创建过自营采购合同的车间")
   @GetMapping("/inbound/getWorkshop")
   public ResultVO getWorkshop() {
      log.info("API 调用 : 入库-查询创建过自营采购合同的车间");
      return ResultBuilder.success(this.purchaseOrderService.getMesWorkshop());
   }

   @ApiOperation("自合营下载采购详情")
   @GetMapping("/PurchaseExcel/{id}")
   @PreAuthorize("@permission.check('scm_purchaseOrder_v2:download','scm_purchaseOrder_self_v2:download')")
   public void PurchaseExcel(@PathVariable("id") Long id, HttpServletResponse response) {
      Preconditions.checkArgument(id != null && id > 0, "采购订单id不正确");
      PurchaseOrder order = this.purchaseOrderService.getById(id);
      Preconditions.checkArgument(order != null, "采购订单不存在");
      SecurityUser actor = UserUtil.getCurrentUser();
      Integer attribute = order.getProjectAttribute();
      Preconditions.checkArgument(ProjectAttributeEnum.SELF_SUPPORT.getType().equals(attribute)
         || ProjectAttributeEnum.JOINT_VENTURE.getType().equals(attribute)
         || ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType().equals(attribute), "采购订单项目属性不正确");
      String permission = ProjectAttributeEnum.SELF_SUPPORT.getType().equals(attribute)
         ? "scm_purchaseOrder_self_v2:download" : "scm_purchaseOrder_v2:download";
      Preconditions.checkArgument(actor.isAdmin() || actor.getPermissions() != null
         && actor.getPermissions().contains(permission), "无权限访问");
      java.util.Set<Long> visible = this.contractProjectService.listSimpleProject(null, null, null, null).getContent().stream()
         .map(project -> project.getId()).collect(java.util.stream.Collectors.toSet());
      Preconditions.checkArgument(StrUtil.isNotBlank(order.getProjectIds())
         && java.util.Arrays.stream(order.getProjectIds().split(",")).allMatch(project -> visible.contains(Long.valueOf(project))),
         "无权限访问该项目");
      log.info("API 调用 ：包干制下载采购详情");
      this.purchaseOrderService.purchaseExcel(id, response);
   }

   @ApiOperation("内包制或合营查询所有项目经理")
   @GetMapping("/selectProjectManger")
   public ResultVO selectProjectManger() {
      log.info("API 调用 ：内包制或合营查询所有项目经理");
      return ResultBuilder.success(this.purchaseOrderService.selectUserList());
   }

   @ApiOperation("自合营内包制共用项目查询")
   @GetMapping("/selectProjectName")
   public ResultVO selectProjectName(Long id, Integer projectAttribute) {
      log.info("API 调用 ：自合营内包制共用项目查询");
      return ResultBuilder.success(this.purchaseOrderService.selectProjectList());
   }

   @ApiOperation("查询创建过采购单的项目")
   @GetMapping("/selectCreatedProject")
   public ResultVO selectCreatedProject() {
      log.info("API 调用 ：查询创建过采购单的项目");
      return ResultBuilder.success(this.purchaseOrderService.selectCreatedProject());
   }

   @ApiOperation("采购合同-付款详情列表")
   @GetMapping("/getPurchaseOrder/paymentDetail/{orderId}")
   public ResultVO<PageVO<SupplierPaymentDetailDto>> getPaymentDetail(
      @PathVariable Long orderId,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：采购合同支出详情");
      return ResultBuilder.success(this.purchaseOrderBiz.getPaymentDetail(orderId, pageNumber, pageSize));
   }

   @ApiOperation("采购合同-付款详情列表-下载")
   @GetMapping("/getPurchaseOrder/paymentDetail/{orderId}/download")
   @PreAuthorize("@scmPurchaseOrderAccess.read(#orderId)")
   public ResultVO getPaymentDetailDownload(@PathVariable Long orderId) {
      log.info("API 调用 ：采购合同支出详情下载");
      return ResultBuilder.success(this.purchaseOrderBiz.getPaymentDetailDownload(orderId));
   }

   @ApiOperation("采购合同-收票详情列表")
   @GetMapping("/getPurchaseOrder/invoiceDetail/{orderId}")
   public ResultVO<PageVO<SupplierInvoiceDetailDto>> getInvoiceDetail(
      @PathVariable Long orderId,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：采购合同收票详情");
      return ResultBuilder.success(this.purchaseOrderBiz.getInvoiceDetail(orderId, pageNumber, pageSize));
   }

   @ApiOperation("采购合同-收票详情列表-打印")
   @GetMapping("/getPurchaseOrder/invoiceDetail/{orderId}/download")
   @PreAuthorize("@scmPurchaseOrderAccess.read(#orderId)")
   public ResultVO<PrintVO<List<SupplierInvoiceDetailDto>>> printInvoiceDetail(@PathVariable Long orderId) {
      log.info("API 调用 ：采购合同收票详情");
      return ResultBuilder.success(this.purchaseOrderBiz.getInvoiceDetailDownload(orderId));
   }

   @ApiOperation("采购合同-结算详情")
   @GetMapping("/getPurchaseOrder/settleDetail/{orderId}")
   public ResultVO<ListVO<SupplierSettlementDTO>> getSettleDetail(@PathVariable Long orderId) {
      log.info("API 调用 ：采购合同结算详情");
      return ResultBuilder.success(new ListVO<>(this.purchaseOrderBiz.listSettleDetail(orderId, false)));
   }

   @ApiOperation("采购合同-结算详情-打印")
   @GetMapping("/getPurchaseOrder/settleDetail/{orderId}/download")
   @PreAuthorize("@scmPurchaseOrderAccess.read(#orderId)")
   public ResultVO getSettleDetailPrint(@PathVariable Long orderId) {
      log.info("API 调用 ：采购合同结算详情");
      return ResultBuilder.success(this.purchaseOrderBiz.printListSettleDetail(orderId, false));
   }

   @ApiOperation("采购合同-预结算详情")
   @GetMapping("/getPurchaseOrder/preSettleDetail/{orderId}")
   public ResultVO<ListVO<SupplierSettlementDTO>> getPreSettleDetail(@PathVariable Long orderId) {
      log.info("API 调用 ：采购合同结算详情");
      List<SupplierSettlementDTO> settlementDTOList = this.purchaseOrderBiz.listSettleDetail(orderId, true);
      return ResultBuilder.success(new ListVO<>(settlementDTOList));
   }

   @ApiOperation("采购合同-预结算详情-打印")
   @GetMapping("/getPurchaseOrder/preSettleDetail/{orderId}/download")
   public ResultVO getPreSettleDetailPrint(@PathVariable Long orderId) {
      log.info("API 调用 ：采购合同结算详情");
      return ResultBuilder.success(this.purchaseOrderBiz.printListSettleDetail(orderId, true));
   }

   @ApiOperation("采购合同-入库详情")
   @GetMapping("/getPurchaseOrder/inboundDetail/{orderId}")
   @PreAuthorize("@contractCollectionAccess.purchaseInboundRead(#orderId, false)")
   public ResultVO<ListVO<PuchaseInboundDetailDTO>> getInboundDetail(@PathVariable Long orderId, LocalDate startDate, LocalDate endDate) {
      log.info("API 调用 ：采购合同-入库详情");
      return ResultBuilder.success(new ListVO<>(this.inboundService.orderDetailV2(orderId, startDate, endDate)));
   }

   @ApiOperation("采购合同-入库详情-打印")
   @GetMapping("/getPurchaseOrder/inboundDetail/{orderId}/download")
   @PreAuthorize("@contractCollectionAccess.purchaseInboundRead(#orderId, true)")
   public ResultVO getInboundDetailPrint(@PathVariable Long orderId, LocalDate startDate, LocalDate endDate) {
      log.info("API 调用:采购合同-入库详情-打印");
      return ResultBuilder.success(this.inboundService.orderDetailV2Download(orderId, startDate, endDate));
   }

   @ApiOperation("采购单编辑申请-（已通过）提交已通过的采购单")
   @PutMapping("/update/submit/purchaseOrder")
   @PreAuthorize("@scmPurchaseOrderAccess.edit(#param.id)")
   @SignerCheck(lockKey = "#param.id", message = "该单据正在编辑，请稍后再试")
   public ResultVO againSubmitPurchaseOrder(@RequestBody PurchaseOrderDTOParam param) {
      log.info("API 调用 ：采购单编辑申请-（已通过）提交已通过的采购单");
      return ResultBuilder.success(this.purchaseOrderService.againSubmitPurchaseOrder(param));
   }

   @ApiOperation("编辑申请中的采购单")
   @PutMapping("/update/under-review/purchase")
   @PreAuthorize("@scmPurchaseOrderAccess.edit(#param.id)")
   @SignerCheck(lockKey = "#param.id", message = "该单据正在编辑，请稍后再试")
   public ResultVO updateUnderReviewPurchase(@RequestBody PurchaseOrderDTOParam param) {
      log.info("API 调用 ：编辑申请中的采购单");
      return ResultBuilder.success(this.purchaseOrderService.updateUnderReviewPurchase(param));
   }

   @ApiOperation("编辑页面删除按钮调用")
   @PutMapping("/deleteType")
   public ResultVO deleteType(@RequestBody PurchaseOrderDTOParam param) {
      log.info("API 调用 ：编辑页面删除按钮调用");
      return ResultBuilder.success(this.purchaseOrderService.deleteType(param));
   }

   @ApiOperation("自营采购订单列表-打印")
   @PostMapping("/print")
   @PreAuthorize("@permission.check('scm_purchaseOrder_self_v2:get')")
   public ResultVO purchaseOrderPrint(@RequestBody QueryPurchaseOrderVOParam param) {
      log.info("API 调用 ：自营采购订单列表-打印");
      param.setProjectAttribute("1");
      return ResultBuilder.success(this.purchaseOrderService.purchaseOrderPrint(param));
   }
}
