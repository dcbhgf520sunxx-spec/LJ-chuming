package com.hzchum.scim.rest.controller.scm;

import com.alibaba.fastjson.JSONObject;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveOpinionDTOParam;
import com.hzchum.scim.scm.core.api.biz.ApplyPurchaseBiz;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.ApplyPurchaseDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.ApplyPurchaseStatusDTOParam;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.time.LocalDateTime;
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

@Api(tags = "scm-材料申购")
@RestController
@RequestMapping("/api/v2/scm/apply-purchase")
public class ApplyPurchaseControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(ApplyPurchaseControllerV2.class);
   @Resource
   private ApplyPurchaseService applyPurchaseService;
   @Resource
   private ApplyPurchaseBiz applyPurchaseBiz;

   @ApiOperation("查询申购单")
   @GetMapping
   @PreAuthorize("@permission.check('scm_requisitions_v2:get')")
   public ResultVO simple(
      @RequestParam(required = false) List<LocalDateTime> times,
      @RequestParam(required = false) Integer materialType,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Integer status,
      @RequestParam(required = false) Boolean enabled,
      @RequestParam(required = false) Boolean boolInitiateApprove,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort,
      @RequestParam(required = false, name = "departmentName") String departmentName,
      @RequestParam(required = false, name = "applicantName") String applicantName,
      @RequestParam(required = false, name = "projectId") Long projectId,
      @RequestParam(required = false, name = "projectAttribute") Integer projectAttribute,
      @RequestParam(required = false, name = "purchaseCreationState") Integer purchaseCreationState,
      @RequestParam(required = false, name = "level") Integer level,
      @RequestParam(required = false) Long branchCompanyId
   ) {
      log.info("API 调用 ：查询申购单");
      return ResultBuilder.success(
         this.applyPurchaseService
            .pageInfoV2(
               times,
               materialType,
               serialNumber,
               status,
               enabled,
               boolInitiateApprove,
               pageNumber,
               pageSize,
               sort,
               departmentName,
               applicantName,
               projectId,
               projectAttribute,
               purchaseCreationState,
               level,
               branchCompanyId
            )
      );
   }

   @ApiOperation("获取当前登录人暂存申购单信息")
   @GetMapping("/getTS")
   public ResultVO getTSApplyPurchase() {
      log.info("API 调用 ：获取当前登录人暂存申购单信息系");
      return ResultBuilder.success(this.applyPurchaseService.getTSApplyPurchase());
   }

   @ApiOperation("获取当前登录人暂存申购单数量")
   @GetMapping("/getTSCount")
   public ResultVO getTSCount() {
      log.info("API 调用 ：获取单签登录人暂存申购单数量");
      return ResultBuilder.success(this.applyPurchaseService.getTSCount());
   }

   @ApiOperation("暂存申购单")
   @PostMapping("/saveTS")
   @PreAuthorize("@permission.check('scm_requisitions_v2:add','scm_requisitions_v2:edit','config_wms_auditing:rewrite')")
   public ResultVO saveTS(@RequestBody ApplyPurchaseDTOParam param) {
      log.info("API 调用 : 暂存申购单");
      return ResultBuilder.success(this.applyPurchaseService.saveTS(param));
   }

   @ApiOperation("一键清空当前登录人创建的暂存数据")
   @DeleteMapping("/clearTS")
   public ResultVO approvalApplyPurchase() {
      log.info("API 调用 ：一键清空当前登录人创建的暂存数据");
      return ResultBuilder.success(this.applyPurchaseService.removeTs());
   }

   @ApiOperation("提交审核申购单")
   @PostMapping("/saveCheck")
   @PreAuthorize("@permission.check('scm_requisitions_v2:add','scm_requisitions_v2:edit','config_wms_auditing:rewrite')")
   public ResultVO saveCheck(@RequestBody ApplyPurchaseDTOParam param) {
      log.info("API 调用 : 提交审核申购单");
      return ResultBuilder.success(this.applyPurchaseService.saveCheck(param));
   }

   @ApiOperation("根据ID查询申购单详情")
   @GetMapping("/{id}")
   @PreAuthorize("@permission.check('scm_requisitions_v2:detail','scm_requisitions:detail')")
   public ResultVO getById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID查询申购单详情");
      return ResultBuilder.success(this.applyPurchaseService.selectByIdV2(id));
   }

   @ApiOperation("删除申购单")
   @DeleteMapping
   @PreAuthorize("@permission.check('scm_requisitions_v2:del')")
   public ResultVO delete(Long id) {
      log.info("API 调用 ：删除申购单");
      return ResultBuilder.success(this.applyPurchaseService.deleteV2(id));
   }

   @ApiOperation("审批申购单")
   @PostMapping("/approval")
   public ResultVO approvalApplyPurchase(@RequestBody WmsApproveOpinionDTOParam wmsApproveOpinionDTOParam) {
      log.info("API 调用 ：审批申购单");
      return ResultBuilder.success(this.applyPurchaseService.approvalApplyPurchase(wmsApproveOpinionDTOParam));
   }

   @ApiOperation("获取当前登录用户可以审核的信息")
   @GetMapping("/getCanCheck")
   public ResultVO getCanCheck() {
      log.info("API 调用 ：获取当前登录用户可以审核的信息");
      return ResultBuilder.success(this.applyPurchaseService.getCanCheck());
   }

   @ApiOperation("获取当前登录用户可以审核的信息数量")
   @GetMapping("/getCanCheckCount")
   public ResultVO getCanCheckCount() {
      log.info("API 调用 ：获取当前登录用户可以审核的信息数量");
      return ResultBuilder.success(this.applyPurchaseService.getCanCheckCount());
   }

   @ApiOperation("查询简单申购单信息")
   @GetMapping("/brief")
   public ResultVO briefList(
      @RequestParam(name = "times") List<LocalDateTime> times,
      Integer materialType,
      Boolean filterUseInventory,
      Integer purchaseCreationState,
      Integer level,
      Integer projectAttribute,
      Long branchCompanyId,
      Long projectId
   ) {
      log.info("API 调用 ：查询简单申购单信息");
      return ResultBuilder.success(
         this.applyPurchaseService
            .briefListV2(times, materialType, filterUseInventory, purchaseCreationState, level, projectAttribute, branchCompanyId, projectId)
      );
   }

   @ApiOperation("制成品查询简单申购单信息")
   @GetMapping("/manufactured/brief")
   public ResultVO manufacturedBriefList(
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "materialType", required = false) Integer materialType,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId
   ) {
      log.info("API 调用 ：制成品查询简单申购单信息");
      return ResultBuilder.success(this.applyPurchaseService.manufacturedBriefList(projectId, materialType, branchCompanyId));
   }

   @ApiOperation("查询可采购物料详情V2")
   @GetMapping("/can-purchase-detail")
   public ResultVO canPurchaseDetail(@RequestParam("ids") List<Long> ids) {
      log.info("API 调用 ：查询可采购物料详情V2");
      return ResultBuilder.success(this.applyPurchaseService.canPurchaseDetailV2(ids));
   }

   @ApiOperation("撤销申购单")
   @PostMapping("/revocation")
   public ResultVO revocation(@RequestBody String id) {
      log.info("API 调用 ：撤销申购单");
      JSONObject jsonObject = JSONObject.parseObject(id);
      Long idL = jsonObject.getLong("id");
      return ResultBuilder.success(this.applyPurchaseService.revocation(idL));
   }

   @ApiOperation("作废申购单")
   @PostMapping("/cancellation")
   @PreAuthorize("@permission.check('scm_requisitions_v2:void')")
   public ResultVO cancellation(@RequestBody String id) {
      log.info("API 调用 ：作废申购单");
      JSONObject jsonObject = JSONObject.parseObject(id);
      Long idL = jsonObject.getLong("id");
      return ResultBuilder.success(this.applyPurchaseService.cancellation(idL));
   }

   @ApiOperation("根据申购单ID修改申购单采购创建状态")
   @PostMapping("/updatePurchaseCreationStateById")
   @PreAuthorize("@permission.check('scm_requisitions_v2:editStatus','scm_requisitions_v2:procurementStatus')")
   public ResultVO updatePurchaseCreationStateById(@RequestBody List<ApplyPurchaseStatusDTOParam> list) {
      log.info("API 调用 ：根据ID修改申购单采购创建状态");
      return ResultBuilder.success(this.applyPurchaseService.updatePurchaseCreationStateById(list));
   }

   @ApiOperation("申购单导出Excel")
   @GetMapping("/export/{id}")
   @PreAuthorize("@permission.check('scm_requisitions_v2:print')")
   public void export(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
      log.info("API 调用 ：申购单导出Excel");
      this.applyPurchaseBiz.export(id, response);
   }

   @ApiOperation("查询申购单加上明细")
   @GetMapping("/getListAndDetail")
   @PreAuthorize("@permission.check('scm_requisitions_list:get')")
   public ResultVO getListAndDetail(
      @RequestParam(required = false) List<LocalDateTime> times,
      @RequestParam(required = false) Integer materialType,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Integer status,
      @RequestParam(required = false) Boolean enabled,
      @RequestParam(required = false) Boolean boolInitiateApprove,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort,
      @RequestParam(required = false, name = "departmentName") String departmentName,
      @RequestParam(required = false, name = "applicantName") String applicantName,
      @RequestParam(required = false, name = "projectId") Long projectId,
      @RequestParam(required = false, name = "projectAttribute") Integer projectAttribute,
      @RequestParam(required = false, name = "purchaseCreationState") Integer purchaseCreationState,
      @RequestParam(required = false, name = "level") Integer level,
      @RequestParam(required = false) Long branchCompanyId
   ) {
      log.info("API 调用 ：查询申购单加上明细");
      return ResultBuilder.success(
         this.applyPurchaseService
            .getListAndDetailPageInfoV2(
               times,
               materialType,
               serialNumber,
               status,
               enabled,
               boolInitiateApprove,
               pageNumber,
               pageSize,
               sort,
               departmentName,
               applicantName,
               projectId,
               projectAttribute,
               purchaseCreationState,
               level,
               branchCompanyId
            )
      );
   }

   @ApiOperation("申购单编辑申请-（已通过）提交已通过的申购单")
   @PutMapping("/update/submit/applyPurchase")
   @SignerCheck(lockKey = "#param.id", message = "该单据正在编辑，请稍后再试")
   public ResultVO againSubmitApplyPurchase(@RequestBody ApplyPurchaseDTOParam param) {
      log.info("API 调用 ：申购单编辑申请-（已通过）提交已通过的申购单");
      return ResultBuilder.success(this.applyPurchaseService.againSubmitApplyPurchase(param));
   }

   @ApiOperation("编辑申请中的申购单")
   @PutMapping("/update/under-review/applyPurchase")
   @SignerCheck(lockKey = "#param.id", message = "该单据正在编辑，请稍后再试")
   public ResultVO updateUnderReviewPurchase(@RequestBody ApplyPurchaseDTOParam param) {
      log.info("API 调用 ：编辑申请中的申购单");
      return ResultBuilder.success(this.applyPurchaseService.updateUnderReviewApplyPurchase(param));
   }

   @ApiOperation("编辑页面删除按钮调用")
   @PutMapping("/deleteType")
   public ResultVO deleteType(@RequestBody ApplyPurchaseDTOParam param) {
      log.info("API 调用 ：编辑页面删除按钮调用");
      return ResultBuilder.success(this.applyPurchaseService.deleteType(param));
   }

   @ApiOperation("根据申购单明细ID获取采购信息")
   @GetMapping("/purchase/detail/{id}")
   public ResultVO getPurchaseDetailById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据申购单明细ID获取采购信息");
      return ResultBuilder.success(this.applyPurchaseService.getPurchaseDetailById(id));
   }

   @ApiOperation("申购采购跟踪导出excel")
   @GetMapping("/track/export/{id}")
   @PreAuthorize("@permission.check('scm_requisitions_v2:trackPrint')")
   public void applyTrackExport(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
      log.info("API 调用 ：申购采购跟踪导出excel");
      this.applyPurchaseBiz.applyTrackExport(id, response);
   }

   @ApiOperation("根据申购单明细ID获取入库信息")
   @GetMapping("/inbound/detail/{id}")
   public ResultVO getInboundDetailById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据申购单明细ID获取入库信息");
      return ResultBuilder.success(this.applyPurchaseService.getInboundDetailById(id));
   }
}
