package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.alibaba.fastjson.JSONObject;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-入库审核V2")
@RestController
@RequestMapping("/api/v2/wms/inbound/application/review/")
public class InboundReviewControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(InboundReviewControllerV2.class);
   @Autowired
   private InboundService inboundService;

   @ApiOperation("审核自购入库单")
   @PostMapping("/selfBuying/approval")
   public ResultVO approvalSelfBuyingInbound(
      @RequestBody InboundDTOParam inboundDTOParam,
      @RequestParam(name = "approveRecordId", required = true) Long approveRecordId,
      @RequestParam(name = "decision", required = true) Integer decision,
      @RequestParam(name = "opinion", required = false) String opinion
   ) {
      log.info("API 调用 ：审核自购入库单");
      return ResultBuilder.success(this.inboundService.approvalSelfBuyingInbound(inboundDTOParam, approveRecordId, decision, opinion));
   }

   @ApiOperation("审核甲供入库单")
   @PostMapping("/partyA/approval")
   public ResultVO approvalPartyAInbound(
      @RequestBody InboundDTOParam inboundDTOParam,
      @RequestParam(name = "approveRecordId", required = true) Long approveRecordId,
      @RequestParam(name = "decision", required = true) Integer decision,
      @RequestParam(name = "opinion", required = false) String opinion
   ) {
      log.info("API 调用 ：审核甲供入库单");
      return ResultBuilder.success(this.inboundService.approvalPartyAInbound(inboundDTOParam, approveRecordId, decision, opinion));
   }

   @ApiOperation("撤销入库单")
   @PostMapping("/revocation")
   public ResultVO revocation(@RequestBody String id) {
      log.info("API 调用 ：撤销入库单");
      JSONObject jsonObject = JSONObject.parseObject(id);
      Long idL = jsonObject.getLong("id");
      return ResultBuilder.success(this.inboundService.revocation(idL));
   }
}
