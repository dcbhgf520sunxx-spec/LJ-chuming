package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.OutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SteelPlateOutboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsOutboundRemindService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-出库审核")
@RestController
@RequestMapping("/api/v2/wms/outbound/application")
public class OutboundReviewControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(OutboundReviewControllerV2.class);
   @Resource
   OutboundService outboundService;
   @Resource
   MoveOutboundDetailService moveOutboundDetailService;
   @Resource
   WmsOutboundRemindService outboundRemindService;

   @ApiOperation("审核页面查询")
   @GetMapping("/review/raw-materials")
   @PreAuthorize("@permission.check('wms_rawMat_outbound_review:get','wms_rawMat_outbound_review_partyA:get','wms_rawMat_outbound_review_self:get')")
   public ResultVO list(
      QueryOutboundDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：审核页面查询");
      param.setType(1);
      return ResultBuilder.success(this.outboundService.pageInfoV2(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("获取未审核出库单ID集")
   @GetMapping("/review/raw-materials/pending/ids")
   @PreAuthorize("@permission.check('wms_rawMat_outbound_review:get')")
   public ResultVO getIds(QueryOutboundDTOParam param) {
      log.info("API 调用 ：获取未审核出库单ID集");
      param.setType(1);
      return ResultBuilder.success(this.outboundService.getIds(param));
   }

   @ApiOperation("根据ID获取未出库清单V2")
   @GetMapping("/review/raw-materials/{id}")
   public ResultVO getById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID获取未出库清单V2");
      return ResultBuilder.success(this.outboundService.getOutboundByIdV2(id));
   }

   @ApiOperation("根据ID删除对应的单条出库详情")
   @PutMapping("/review/raw-materials/material-del")
   @PreAuthorize("@permission.check('wms_rawMat_outbound_review:review')")
   public ResultVO delete(Long listId, Long materialId) {
      log.info("API 调用 ：根据ID删除对应的单条出库详情");
      return ResultBuilder.success(this.outboundService.delete(listId, materialId));
   }

   @ApiOperation("查询当前用户未审核的出库单 -> 根据出库类型筛选")
   @GetMapping("/review/raw-materials/current-user")
   public ResultVO getByCurrentUser(
      @RequestParam(required = false, name = "boolPartyA") Boolean boolPartyA,
      @RequestParam(required = false, name = "outboundTypes") List<Integer> outboundTypes
   ) {
      log.info("API 调用 ：查询当前用户未审核的出库单 -> 根据出库类型筛选");
      return ResultBuilder.success(this.outboundService.getByCurrentUserV2(boolPartyA, outboundTypes));
   }

   @ApiOperation("查询当前用户未审核的出库单数量")
   @GetMapping("/review/raw-materials/current-user/detail-number")
   public ResultVO getDetailNumber(Boolean boolPartyA) {
      log.info("API 调用 ：查询当前用户未审核的出库单数量");
      return ResultBuilder.success(this.outboundService.getDetailNumberV2(boolPartyA));
   }

   @ApiOperation("外协原料用户直接提交审核")
   @PutMapping("/review/raw-materials/directSubmitReview")
   public ResultVO directSubmitReview(@RequestBody SteelPlateOutboundDTOParam param) {
      log.info("API 调用 ：外协原料用户直接提交审核");
      return ResultBuilder.success(this.outboundService.outsourcingDirectSubmitReview(param));
   }

   @ApiOperation("外协原料出库根据ID删除对应的单条出库详情")
   @PutMapping("/review/raw-materials/material-deleteOutsourcing")
   @PreAuthorize(
      "@permission.check('wms_matWarehouse_steel:outbound','wms_matWarehouse_steel_self:outbound','wms_matWarehouse_steel_partyA:outbound',"
         + "'wms_matWarehouse_auxMaterial:outbound','wms_matWarehouse_auxMaterial_self:outbound','wms_matWarehouse_auxMaterial_partyA:outbound',"
         + "'wms_matWarehouse_gas:outbound','wms_matWarehouse_gas_self:outbound','wms_matWarehouse_gas_partyA:outbound',"
         + "'wms_matWarehouse_other:outbound','wms_matWarehouse_other_self:outbound','wms_matWarehouse_other_partyA:outbound')"
   )
   public ResultVO deleteOutsourcing(Long listId, Long materialId) {
      log.info("API 调用 ：外协原料出库根据ID删除对应的单条出库详情");
      return ResultBuilder.success(this.outboundService.deleteOutsourcing(listId, materialId));
   }

   @ApiOperation("删除外协原料出库单")
   @PutMapping("/review/raw-materials/{id}/deleteOutsourcingOutbound")
   public ResultVO deleteOutsourcingOutbound(@PathVariable("id") Long id) {
      log.info("API 调用 ：删除出库单");
      return ResultBuilder.success(this.outboundService.deleteOutsourcingOutbound(id));
   }

   @ApiOperation("废料料出库根据ID删除对应的单条出库详情")
   @PutMapping("/review/raw-materials/material-deleteScraps")
   public ResultVO deleteScraps(Long listId, Long materialId) {
      log.info("API 调用 ：废料料出库根据ID删除对应的单条出库详情");
      return ResultBuilder.success(this.outboundService.deleteScraps(listId, materialId));
   }

   @ApiOperation("审核出库单V2")
   @PutMapping("/review/raw-materials")
   public ResultVO reviewOutbound(
      @RequestParam(name = "approveRecordId", required = true) Long approveRecordId,
      @RequestParam(name = "decision", required = true) Integer decision,
      @RequestParam(name = "opinion", required = false) String opinion
   ) {
      log.info("API 调用 ：审核出库单V2");
      return ResultBuilder.success(this.outboundService.reviewOutbound(approveRecordId, decision, opinion));
   }

   @ApiOperation("出库单提交审核v2")
   @PutMapping("/submit")
   @PreAuthorize(
      "@permission.check('wms_rawMat_outbound_review:review','wms_rawMat_outbound_review_self:review','wms_rawMat_outbound_review_partyA:review','materialOutBoundSave')"
   )
   public ResultVO submit(@RequestBody OutboundDTOParam param) {
      log.info("API 调用 ：出库单提交审核v2");
      return ResultBuilder.success(this.outboundService.submitReview(param));
   }

   @ApiOperation("查询外协原料出库过的项目")
   @GetMapping("/getOutsourcingProject")
   public ResultVO getOutsourcingProject() {
      log.info("API 调用 ： 查询外协原料出库过的项目");
      return ResultBuilder.success(this.outboundService.getOutsourcingProject());
   }

   @ApiOperation("撤销出库单")
   @PostMapping("/revocation/{id}")
   public ResultVO revocation(@PathVariable("id") Long id) {
      log.info("API 调用 ： 撤销出库单");
      return ResultBuilder.success(this.outboundService.revocation(id));
   }

   @ApiOperation("大屏查询领料统计")
   @GetMapping("/projectSteelPickingStatistics")
   public ResultVO projectSteelPickingStatistics(String time, Long workshopId) {
      log.info("API 调用 ：大屏查询领料统计");
      return ResultBuilder.success(this.moveOutboundDetailService.projectSteelPickingStatistics(time, workshopId));
   }

   @ApiOperation("出库成功提醒列表")
   @GetMapping("/getRemindList")
   public ResultVO getRemindList() {
      log.info("API 调用 ：出库成功提醒列表");
      return ResultBuilder.success(this.outboundRemindService.getRemindList());
   }

   @ApiOperation("出库成功提醒数量")
   @GetMapping("/getRemindNumbers")
   public ResultVO getRemindNumbers() {
      return ResultBuilder.success(this.outboundRemindService.getRemindNumbers());
   }

   @ApiOperation("关闭提醒列表")
   @PostMapping("/closeByIds")
   public ResultVO closeList(@RequestBody List<Long> ids) {
      log.info("API 调用 ：关闭提醒列表");
      return ResultBuilder.success(this.outboundRemindService.closeList(ids));
   }
}
