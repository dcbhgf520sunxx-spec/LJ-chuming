package com.hzchum.scim.rest.controller.scm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.scm.core.api.biz.scm.ScmSupplierEvaluateBiz;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SupplierEvaluateQueryParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.scm.ScmSupplierEvaluateDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.scm.ScmSupplierEvaluateQueryParam;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "供应链管理-供应商评价")
@RestController
@RequestMapping("/api/scm/supplierEvaluate")
public class ScmSupplierEvaluateController {
   private static final Logger log = LoggerFactory.getLogger(ScmSupplierEvaluateController.class);
   @Resource
   private ScmSupplierEvaluateBiz scmSupplierEvaluateBiz;
   @Resource
   private SupplierService supplierService;

   @ApiOperation("新增供应商评价")
   @PostMapping("/add")
   public ResultVO addEvaluate(@RequestBody @Valid ScmSupplierEvaluateDTOParam param) {
      log.info("Api调用: 新增供应商评价, supplierId={}, templateId={}", param.getSupplierId(), param.getTemplateId());
      return ResultBuilder.success(this.scmSupplierEvaluateBiz.addEvaluate(param));
   }

   @ApiOperation("查询评价记录列表")
   @GetMapping("/list")
   public ResultVO listEvaluateRecords(ScmSupplierEvaluateQueryParam param) {
      log.info("Api调用: 查询评价记录列表");
      return ResultBuilder.success(this.scmSupplierEvaluateBiz.listEvaluateRecords(param));
   }

   @ApiOperation("根据供应商id查询今年最新评价记录")
   @GetMapping("/latest/{supplierId}")
   public ResultVO getLatestEvaluateBySupplierId(@PathVariable("supplierId") Long supplierId) {
      log.info("Api调用: 根据供应商id查询今年最新评价记录, supplierId={}", supplierId);
      return ResultBuilder.success(this.scmSupplierEvaluateBiz.getLatestEvaluateBySupplierId(supplierId));
   }

   @ApiOperation("根据评价记录id查询评价详情")
   @GetMapping("/detail/{evaluateId}")
   public ResultVO getEvaluateDetailById(@PathVariable("evaluateId") Long evaluateId) {
      log.info("Api调用: 根据评价记录id查询评价详情, evaluateId={}", evaluateId);
      return ResultBuilder.success(this.scmSupplierEvaluateBiz.getEvaluateDetailById(evaluateId));
   }

   @ApiOperation("名称简称查询供应商列表")
   @GetMapping("/evaluate/list")
   public ResultVO getEvaluateSupplierList(SupplierEvaluateQueryParam param) {
      log.info("API 调用 ：根据评价状态、分类id、名称简称查询供应商列表");
      return ResultBuilder.success(this.supplierService.getEvaluateSupplierList(param));
   }

   @ApiOperation("导出评价记录详情")
   @GetMapping("/export/{evaluateId}")
   @PreAuthorize("@permission.check('scm_supplier_evaluate:detailDownload')")
   public void exportEvaluateDetail(@PathVariable("evaluateId") Long evaluateId, HttpServletResponse response) {
      log.info("Api调用: 导出评价记录详情, evaluateId={}", evaluateId);
      this.scmSupplierEvaluateBiz.exportEvaluateDetail(evaluateId, response);
   }

   @ApiOperation("评价记录下载")
   @GetMapping("/download")
   @PreAuthorize("@permission.check('scm_supplier_evaluate:download')")
   public ResultVO listEvaluateRecordsDownload(ScmSupplierEvaluateQueryParam query, HttpServletResponse response) {
      log.info("API 调用 ：评价记录下载");
      this.scmSupplierEvaluateBiz.listEvaluateRecordsDownload(query, response);
      return ResultBuilder.success(true);
   }

   @ApiOperation("审核评价记录（通过/驳回）")
   @PutMapping("/check")
   public ResultVO checkEvaluate(
      @RequestParam("evaluateId") Long evaluateId,
      @RequestParam("decision") Integer decision,
      @RequestParam(value = "opinion", required = false) String opinion
   ) {
      log.info("Api调用: 审核评价记录, evaluateId={}, decision={}", evaluateId, decision);
      return ResultBuilder.success(this.scmSupplierEvaluateBiz.checkEvaluate(evaluateId, decision, opinion));
   }

   @ApiOperation("撤销评价审批")
   @PutMapping("/cancelApprove/{evaluateId}")
   public ResultVO cancelApproveEvaluate(@PathVariable("evaluateId") Long evaluateId) {
      log.info("Api调用: 撤销评价审批, evaluateId={}", evaluateId);
      return ResultBuilder.success(this.scmSupplierEvaluateBiz.cancelApproveEvaluate(evaluateId));
   }
}
