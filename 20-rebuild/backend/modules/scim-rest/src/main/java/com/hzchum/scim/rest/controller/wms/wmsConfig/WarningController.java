package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WarningDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InventoryNotifyConfDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms配置-物料预警配置")
@RestController
@RequestMapping("/api/wms/material/inventory-warning")
public class WarningController {
   private static final Logger log = LoggerFactory.getLogger(WarningController.class);
   @Resource
   WarningService warningService;

   @ApiOperation("获取预警列表")
   @GetMapping
   @PreAuthorize("@permission.check('wms_rawMat_inventoryWarning:get')")
   public ResultVO list(
      @RequestParam(name = "factoryId", required = false) Long factoryId,
      @RequestParam(name = "classifyId", required = false) Long classifyId,
      @RequestParam(name = "classifySpec", required = false) String classifySpec,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：获取预警列表");
      return ResultBuilder.success(this.warningService.pageInfo(factoryId, classifyId, classifySpec, pageNumber, pageSize, sort));
   }

   @ApiOperation("新增预警配置")
   @PostMapping("/batch")
   @PreAuthorize("@permission.check('wms_rawMat_inventoryWarning:add')")
   public ResultVO add(@RequestBody List<WarningDTOParam> params) {
      log.info("API 调用 ：新增预警配置");
      return ResultBuilder.success(this.warningService.saveWarning(params));
   }

   @ApiOperation("修改预警配置")
   @PutMapping("/minimumInventory")
   @PreAuthorize("@permission.check('wms_rawMat_inventoryWarning:edit')")
   public ResultVO update(
      @RequestParam("id") Long id, @RequestParam("minimumInventory") BigDecimal minimumInventory, @RequestParam("workshopId") Long workshopId
   ) {
      log.info("API 调用 ：修改预警配置");
      return ResultBuilder.success(this.warningService.updateWarning(id, minimumInventory, workshopId));
   }

   @ApiOperation("修改预警使用状态")
   @PutMapping("/enabled")
   @PreAuthorize("@permission.check('wms_rawMat_inventoryWarning:edit')")
   public ResultVO update(@RequestParam("id") Long id, @RequestParam("enabled") Boolean enabled) {
      log.info("API 调用 ：修改预警使用状态");
      return ResultBuilder.success(this.warningService.updateEnabled(id, enabled));
   }

   @ApiOperation("删除物料预警配置")
   @DeleteMapping
   @PreAuthorize("@permission.check('wms_rawMat_inventoryWarning:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除物料预警配置");
      return ResultBuilder.success(this.warningService.delete(ids));
   }

   @ApiOperation("获取预警通知人员配置")
   @GetMapping("/notify-config")
   @PreAuthorize("@permission.check('wms_rawMat_inventoryWarning:get')")
   public ResultVO getInventoryNotifyConf() {
      log.info("API 调用 ：获取预警通知配置");
      return ResultBuilder.success(this.warningService.getInventoryNotifyConf());
   }

   @ApiOperation("保存库存预警通知人员配置")
   @PutMapping("/notify-config")
   @PreAuthorize("@permission.check('wms_rawMat_inventoryWarning:edit')")
   public ResultVO setInventoryNotifyConf(@RequestBody List<InventoryNotifyConfDTOParam> requests) {
      log.info("API 调用 ：保存库存预警通知配置");
      return ResultBuilder.success(this.warningService.setInventoryNotifyConf(requests));
   }
}
