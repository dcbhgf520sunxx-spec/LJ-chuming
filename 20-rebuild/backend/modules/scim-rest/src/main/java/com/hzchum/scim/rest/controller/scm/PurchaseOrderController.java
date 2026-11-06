package com.hzchum.scim.rest.controller.scm;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.rest.pojo.vo.scm.purchase.PurchaseOrderVORequest;
import com.hzchum.scim.rest.pojo.vo.scm.purchase.QueryPurchaseOrderVOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.PurchaseOrderDTOParam;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "scm-原材料采购")
@RestController
@RequestMapping("/api/scm/purchase-order")
public class PurchaseOrderController {
   private static final Logger log = LoggerFactory.getLogger(PurchaseOrderController.class);
   @Resource
   private PurchaseOrderService purchaseOrderService;

   @ApiOperation("查询订单编号")
   @GetMapping("/simple")
   public ResultVO simple() {
      log.info("API 调用 ：查询订单编号");
      return ResultBuilder.success(this.purchaseOrderService.simpleListInfo());
   }

   @ApiOperation("根据ID查询")
   @GetMapping("/{id}")
   public ResultVO getById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID查询");
      return ResultBuilder.success(this.purchaseOrderService.selectById(id));
   }

   @ApiOperation("查询订单统计记录")
   @GetMapping("/statistics")
   public ResultVO getStatistics() {
      log.info("API 调用 : 查询订单统计记录");
      return ResultBuilder.success(this.purchaseOrderService.getStatistics());
   }

   @ApiOperation("根据条件分页查询采购订单列表")
   @GetMapping
   @PreAuthorize("@permission.check('scm_purchaseOrder:get')")
   public ResultVO list(
      QueryPurchaseOrderVOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询采购订单列表");
      return ResultBuilder.success(this.purchaseOrderService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("查询未完成的采购订单的简单信F息")
   @GetMapping("/purchasing/all/brief")
   public ResultVO listBrief() {
      log.info("API 调用 ：查询未完成采购订单的简单信息");
      return ResultBuilder.success(this.purchaseOrderService.listBrief());
   }

   @ApiOperation("查询所有订单编号")
   @GetMapping("/purchasing/serialNumber")
   public ResultVO listBrief(@RequestParam(required = false) LocalDateTime year) {
      log.info("API 调用 ：查询所有订单编号");
      return ResultBuilder.success(this.purchaseOrderService.getSNByYear(year));
   }

   @ApiOperation("新增采购订单")
   @PostMapping
   @PreAuthorize("@permission.check('scm_purchaseOrder:add')")
   public ResultVO add(@Valid @RequestBody PurchaseOrderDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增采购订单");
      return ResultBuilder.success(this.purchaseOrderService.save(param));
   }

   @ApiOperation("修改采购订单")
   @PutMapping
   @PreAuthorize("@permission.check('scm_purchaseOrder:edit')")
   public ResultVO update(@Valid @RequestBody PurchaseOrderVORequest voRequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 修改采购订单");
      return ResultBuilder.success(this.purchaseOrderService.updatePurchaseOrder(voRequest));
   }

   @ApiOperation("修改采购状态")
   @PutMapping("/purchase-status")
   @PreAuthorize("@permission.check('scm_purchaseOrder:editPurchaseStatus')")
   public ResultVO editPurchaseStatus(@RequestParam("id") Long id, @RequestParam("purchaseStatus") Integer purchaseStatus) {
      log.info("API 调用 : 修改采购状态");
      return ResultBuilder.success(this.purchaseOrderService.editPurchaseStatus(id, purchaseStatus));
   }

   @ApiOperation("删除申购清单")
   @DeleteMapping
   @PreAuthorize("@permission.check('scm_purchaseOrder:del')")
   public ResultVO del(@RequestBody List<Long> ids) {
      log.info("API 调用 : 删除申购清单");
      return ResultBuilder.success(this.purchaseOrderService.deletePurchaseOrder(ids));
   }

   @ApiOperation("下载订单")
   @GetMapping("/export")
   @PreAuthorize("@permission.check('scm_purchaseOrder:download')")
   public void exportOrder(@RequestParam("id") Long id, HttpServletResponse response) {
      log.info("API 调用 : 下载订单");
      this.purchaseOrderService.exportOrder(id, response);
   }

   @ApiOperation("查询清单构件/围护详情")
   @GetMapping("/purchasing/artifact-enclosure-detail")
   public ResultVO getArtifactEnclosureDetail(
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long structureClassId,
      @RequestParam(required = false) Integer type,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false) Long areaId
   ) {
      log.info("API 调用 ：查询清单构件/围护详情");
      return ResultBuilder.success(
         this.purchaseOrderService.getArtifactEnclosureDetail(projectId, monomerId, structureClassId, type, areaId, pageNumber, pageSize)
      );
   }

   @ApiOperation("查询构件类型列表")
   @GetMapping("/purchasing/structure-class")
   public ResultVO getStructureClass(
      @RequestParam(required = false) Long projectId, @RequestParam(required = false) Long monomerId, @RequestParam(required = false) Long areaId
   ) {
      log.info("API 调用 ：查询构件类型列表");
      return ResultBuilder.success(this.purchaseOrderService.getStructureClass(projectId, monomerId, areaId));
   }

   @ApiOperation("入库-查询采购详情")
   @GetMapping("/inbound/{id}")
   public ResultVO canInboundDetail(@PathVariable("id") Long id) {
      log.info("API 调用 : 入库-查询采购详情");
      return ResultBuilder.success(this.purchaseOrderService.canInboundDetail(id));
   }
}
