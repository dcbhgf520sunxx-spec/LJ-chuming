package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryRejectDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryRejectInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.RejectDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.RejectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-退货")
@RestController
@RequestMapping("/api/wms/reject")
public class RejectController {
   private static final Logger log = LoggerFactory.getLogger(RejectController.class);
   @Resource
   RejectService rejectService;

   @ApiOperation("退货-批量查询入库单")
   @GetMapping("/inbound-rejectable")
   @PreAuthorize("@permission.check('wms_rawMat_reject_application:get')")
   public ResultVO getInboundList(
      QueryRejectInboundDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：退货-批量查询入库单");
      return ResultBuilder.success(this.rejectService.getInbound(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("退货-根据入库单ID获取入库详情")
   @GetMapping("/inbound-rejectable/{id}")
   @PreAuthorize("@permission.check('wms_rawMat_reject_application:get')")
   public ResultVO getInboundDetailList(@PathVariable("id") Long id) {
      log.info("API 调用 ：退货-根据入库单ID获取入库详情");
      return ResultBuilder.success(this.rejectService.getInboundDetailList(id));
   }

   @ApiOperation("申请查询退货单信息")
   @GetMapping("/application/record/raw-materials")
   @PreAuthorize("@permission.check('wms_rawMat_reject_record:get')")
   public ResultVO record(
      QueryRejectDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：申请查询退货单信息");
      return ResultBuilder.success(this.rejectService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("审核查询退货单信息")
   @GetMapping("/application/review/raw-materials")
   @PreAuthorize("@permission.check('wms_rawMat_reject_review:get')")
   public ResultVO review(
      QueryRejectDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：审核查询退货单信息");
      return ResultBuilder.success(this.rejectService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("查询退货详情")
   @GetMapping("/application/record/raw-materials/{id}")
   @PreAuthorize("@permission.check('wms_rawMat_reject_record:get')")
   public ResultVO recordList(@PathVariable("id") Long id) {
      log.info("API 调用 ：查询退货详情");
      return ResultBuilder.success(this.rejectService.detailList(id));
   }

   @ApiOperation("根据入库详请ID获取可退货物料")
   @GetMapping("/inbound-rejectable/material-match/{id}")
   @PreAuthorize("@permission.check('wms_rawMat_reject_application:get')")
   public ResultVO getMatByDetailId(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据入库详请ID获取可退货物料");
      return ResultBuilder.success(this.rejectService.getMatByDetailId(id));
   }

   @ApiOperation("查询未审核退货单ID")
   @GetMapping("/application/review/raw-materials/pending/ids")
   @PreAuthorize("@permission.check('wms_rawMat_reject_review:get')")
   public ResultVO getIds(QueryRejectDTOParam param) {
      log.info("API 调用 ：查询未审核退货单ID");
      return ResultBuilder.success(this.rejectService.getIds(param));
   }

   @ApiOperation("查询待审核退货详情")
   @GetMapping("/application/review/raw-materials/{id}")
   @PreAuthorize("@permission.check('wms_rawMat_reject_review:get','wms_rawMat_reject_review:detail')")
   public ResultVO reviewList(@PathVariable("id") Long id) {
      log.info("API 调用 ：查询待审核退货详情");
      return ResultBuilder.success(this.rejectService.detailList(id));
   }

   @ApiOperation("新增退货申请")
   @PostMapping("/inbound-rejectable")
   public ResultVO saveReject(@RequestBody RejectDTOParam param) {
      log.info("API 调用 : 新增退货申请");
      return ResultBuilder.success(this.rejectService.saveReject(param));
   }
}
