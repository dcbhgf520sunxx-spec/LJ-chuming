package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechStandardPartQueryDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryShipmentReceiveApproveDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.WmsShipmentReceiveApproveDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsShipmentReceiveApproveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
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

@Api(tags = "wms-物料发运领用信息")
@RestController
@RequestMapping("/api/wms/shipment")
public class WmsShipmentReceiveApproveController {
   private static final Logger log = LoggerFactory.getLogger(WmsShipmentReceiveApproveController.class);
   @Resource
   private WmsShipmentReceiveApproveService wmsShipmentReceiveApproveService;

   @ApiOperation("根据条件分页查询发运领用出库单列表")
   @GetMapping("/record")
   @PreAuthorize("@permission.check('wms_mes_ship_receipt_audit:get')")
   public ResultVO list(
      QueryShipmentReceiveApproveDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询发运领用出库单列表");
      return ResultBuilder.success(this.wmsShipmentReceiveApproveService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据ID获取发运领用审核详情")
   @GetMapping("/selectById/{id}")
   @PreAuthorize("@permission.check('wms_mes_ship_receipt_audit:detail')")
   public ResultVO getMatByDetailId(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID获取发运领用审核详情");
      return ResultBuilder.success(this.wmsShipmentReceiveApproveService.selectById(id));
   }

   @ApiOperation("添加发运领用信息")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('wms_mes_ship_receipt:add')")
   public ResultVO save(@RequestBody WmsShipmentReceiveApproveDTOParam param) {
      log.info("API 调用：添加发运领用信息");
      return ResultBuilder.success(this.wmsShipmentReceiveApproveService.save(param));
   }

   @ApiOperation("审核发运领用审核单")
   @PutMapping("/review")
   public ResultVO review(
      @RequestParam(name = "approveRecordId", required = true) Long approveRecordId,
      @RequestParam(name = "decision", required = true) Integer decision,
      @RequestParam(name = "opinion", required = false) String opinion
   ) {
      log.info("API 调用 ：审核发运领用审核单");
      return ResultBuilder.success(this.wmsShipmentReceiveApproveService.review(approveRecordId, decision, opinion));
   }

   @ApiOperation("撤销发运领用审核单")
   @PutMapping("/revocation")
   public ResultVO revocation(@RequestParam("id") Long id) {
      log.info("API 调用 ： 撤销发运领用审核单");
      return ResultBuilder.success(this.wmsShipmentReceiveApproveService.revocation(id));
   }

   @ApiOperation("根据配套件对照表获取库存信息")
   @GetMapping("/getInventory")
   public ResultVO getInventory(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：根据配套件对照表获取库存信息");
      return ResultBuilder.success(this.wmsShipmentReceiveApproveService.getInventory(param, pageNumber, pageSize));
   }

   @ApiOperation("查看物料发运领用信息")
   @GetMapping("/getWmsShipment")
   @PreAuthorize("@permission.check('wms_mes_ship_receipt:get')")
   public ResultVO getWmsShipment(
      @Valid TechStandardPartQueryDtoParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("API 调用：查看物料发运领用信息");
      return ResultBuilder.success(this.wmsShipmentReceiveApproveService.getWmsShipment(param, pageNumber, pageSize));
   }

   @ApiOperation("根据配套件明细集合获取配套件详情")
   @GetMapping("/getWmsShipmentByIds")
   public ResultVO getWmsShipmentByIds(@RequestParam(required = false, name = "ids") List<Long> ids) {
      log.info("API 调用：根据配套件明细集合获取配套件详情");
      return ResultBuilder.success(this.wmsShipmentReceiveApproveService.getWmsShipmentByIds(ids));
   }

   @ApiOperation("根据项目判断（结构、围护）哪个存在返回信息")
   @GetMapping("/getRelationType")
   public ResultVO getWmsShipment(Long projectId) {
      log.info("API 调用：根据项目判断（结构、围护）哪个存在返回信息");
      return ResultBuilder.success(this.wmsShipmentReceiveApproveService.getRelationType(projectId));
   }

   @ApiOperation("根据配套件明细ID查询出库信息")
   @GetMapping("/getOutboundDetails/{detailId}")
   @PreAuthorize("@permission.check('wms_mes_ship_receipt:detail')")
   public ResultVO getOutboundDetails(@PathVariable("detailId") Long detailId) {
      log.info("API 调用：根据配套件明细ID查询出库信息");
      return ResultBuilder.success(this.wmsShipmentReceiveApproveService.getOutboundDetails(detailId));
   }
}
