package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportAdjustDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.AdjustDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsAdjustService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
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

@Api(tags = "wms-入库价格调整单")
@RestController
@RequestMapping("/api/wms/adjust")
public class AdjustController {
   private static final Logger log = LoggerFactory.getLogger(AdjustController.class);
   @Resource
   WmsAdjustService wmsAdjustService;

   @ApiOperation("根据条件分页调整记录")
   @GetMapping("/record/raw-adjust")
   @PreAuthorize("@permission.check('inbound_adjust_price_application:get')")
   public ResultVO list(
      QueryReportAdjustDTOParam queryInboundDTOParam,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页调整记录");
      return ResultBuilder.success(this.wmsAdjustService.pageInfo(queryInboundDTOParam, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据条件分页入库价格调整记录明细页面")
   @GetMapping("/record/raw-adjustDetail")
   @PreAuthorize("@permission.check('inbound_adjust_price_application:detail','wms_report_rawMat_inbound_adjust_amount:get')")
   public ResultVO adjustDetailList(
      QueryReportAdjustDTOParam queryInboundDTOParam,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页入库价格调整记录页面");
      return ResultBuilder.success(this.wmsAdjustService.adjustDetailList(queryInboundDTOParam, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据调整单ID查询详情")
   @GetMapping("/receipt/{id}")
   @PreAuthorize("@permission.check('inbound_adjust_price_audit:detail')")
   public ResultVO list(@PathVariable("id") Long id) {
      log.info("API 调用 ：报表-根据调整单ID查询详情");
      return ResultBuilder.success(this.wmsAdjustService.getInboundDetailById(id));
   }

   @ApiOperation("入库价格调整单保存")
   @PutMapping("/saveConvert")
   @PreAuthorize("@permission.check('inbound_adjust_price_application:add')")
   public ResultVO saveConvert(@RequestBody ArrayList<AdjustDetailDTOParam> param) {
      log.info("API 调用 ：入库价格调整单保存");
      return ResultBuilder.success(this.wmsAdjustService.saveWmsAdjust(param));
   }

   @ApiOperation("撤销入库价格调整单")
   @PostMapping("/revocation/{id}")
   public ResultVO revocation(@PathVariable("id") Long id) {
      log.info("API 调用 ：撤销入库价格调整单");
      return ResultBuilder.success(this.wmsAdjustService.revocation(id));
   }

   @ApiOperation("审核入库价格调整单")
   @PostMapping("/approval")
   public ResultVO approvalAdjust(
      @RequestParam(name = "id", required = true) Long id,
      @RequestParam(name = "approveRecordId", required = true) Long approveRecordId,
      @RequestParam(name = "decision", required = true) Integer decision,
      @RequestParam(name = "opinion", required = false) String opinion
   ) {
      log.info("API 调用 ：审核入库价格调整单");
      return ResultBuilder.success(this.wmsAdjustService.approvalAdjust(id, approveRecordId, decision, opinion));
   }
}
