package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundManufacturedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-制成品入库审核")
@RestController
@RequestMapping("/api/wms/inbound/manufactured/application/review")
public class InboundManufacturedReviewController {
   private static final Logger log = LoggerFactory.getLogger(InboundManufacturedReviewController.class);
   @Autowired
   private InboundManufacturedService inboundManufacturedService;

   @ApiOperation("撤销制成品入库单")
   @PostMapping("/revocation/{id}")
   public ResultVO revocation(@PathVariable("id") Long id) {
      log.info("API 调用 ：撤销制成品入库单");
      return ResultBuilder.success(this.inboundManufacturedService.revocation(id));
   }

   @ApiOperation("审核制成品入库单")
   @PostMapping("/approval")
   @SignerCheck(lockKey = "#inboundManufacturedDTOParam.id", message = "该入库单正在审核中,请稍后刷新重试!")
   public ResultVO approvalManufacturedInbound(
      @RequestBody InboundManufacturedDTOParam inboundManufacturedDTOParam,
      @RequestParam(name = "approveRecordId", required = true) Long approveRecordId,
      @RequestParam(name = "decision", required = true) Integer decision,
      @RequestParam(name = "opinion", required = false) String opinion
   ) {
      log.info("API 调用 ：审核制成品入库单");
      return ResultBuilder.success(this.inboundManufacturedService.approvalManufacturedInbound(inboundManufacturedDTOParam, approveRecordId, decision, opinion));
   }
}
