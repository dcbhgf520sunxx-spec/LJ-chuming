package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.RejectDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.RejectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-退货V2")
@RestController
@RequestMapping("/api/v2/wms/reject")
public class RejectControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(RejectControllerV2.class);
   @Resource
   RejectService rejectService;

   @ApiOperation("新增退货申请")
   @PostMapping("/inbound-rejectable")
   @PreAuthorize("@permission.check('wms_rawMat_reject_application:get')")
   public ResultVO saveReject(@RequestBody RejectDTOParam param) {
      log.info("API 调用 : 新增退货申请");
      return ResultBuilder.success(this.rejectService.saveRejectV2(param));
   }

   @ApiOperation("审核退货单")
   @PutMapping("/review")
   public ResultVO review(
      @RequestParam(name = "approveRecordId", required = true) Long approveRecordId,
      @RequestParam(name = "decision", required = true) Integer decision,
      @RequestParam(name = "opinion", required = false) String opinion
   ) {
      log.info("API 调用 ：审核退货单");
      return ResultBuilder.success(this.rejectService.review(approveRecordId, decision, opinion));
   }

   @ApiOperation("撤销退货单")
   @PostMapping("/revocation/{id}")
   public ResultVO revocation(@PathVariable("id") Long id) {
      log.info("API 调用 ：撤销退货单");
      return ResultBuilder.success(this.rejectService.revocation(id));
   }
}
