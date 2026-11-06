package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.OutboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundManufacturedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-制成品出库审核")
@RestController
@RequestMapping("/api/wms/outbound/manufactured/review")
public class OutboundManufacturedReviewController {
   private static final Logger log = LoggerFactory.getLogger(OutboundManufacturedReviewController.class);
   @Resource
   OutboundManufacturedService outboundManufacturedService;

   @ApiOperation("制成品出库单提交审核 -> 基于出库清单提交")
   @PutMapping("/submit")
   public ResultVO submit(@RequestBody OutboundManufacturedDTOParam param) {
      log.info("API 调用 ：制成品出库单提交审核 -> 基于出库清单提交");
      return ResultBuilder.success(this.outboundManufacturedService.submitReview(param));
   }

   @ApiOperation("审核制成品出库单")
   @PutMapping("/review")
   public ResultVO reviewOutbound(
      @RequestParam(name = "approveRecordId", required = true) Long approveRecordId,
      @RequestParam(name = "decision", required = true) Integer decision,
      @RequestParam(name = "opinion", required = false) String opinion
   ) {
      log.info("API 调用 ：审核制成品出库单");
      return ResultBuilder.success(this.outboundManufacturedService.review(approveRecordId, decision, opinion));
   }

   @ApiOperation("撤销制成品出库单")
   @PutMapping("/revocation/{id}")
   public ResultVO revocation(@PathVariable("id") Long id) {
      log.info("API 调用 ： 撤销制成品出库单");
      return ResultBuilder.success(this.outboundManufacturedService.revocation(id));
   }

   @ApiOperation("删除出库清单")
   @PutMapping("/delete/{id}")
   public ResultVO returned(@PathVariable("id") Long id) {
      log.info("API 调用 ：删除出库清单");
      return ResultBuilder.success(this.outboundManufacturedService.deleteOut(id));
   }

   @ApiOperation("删除出库单明细信息")
   @PutMapping("/delete/detail/{id}")
   public ResultVO delete(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID删除对应的单条出库详情");
      return ResultBuilder.success(this.outboundManufacturedService.deleteOutDetail(id));
   }
}
