package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicShowConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.ConvertConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.DeficitConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.MaterialConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.MaterialWarehouseConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.OutboundUpdateConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.PartyABorrowReturnConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.PriceAbnormalConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.ReportDownload;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.ReturnConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SteelInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.TransferConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedExecutionPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms配置-基础配置")
@RestController
@RequestMapping("/api/wms/config")
public class BasicConfigController {
   private static final Logger log = LoggerFactory.getLogger(BasicConfigController.class);
   @Resource
   BasicConfigService basicConfigService;

   @ApiOperation("获取入库配置")
   @GetMapping("/inbound/base")
   @PreAuthorize("@permission.check('config_wms_basicInbound:get')")
   public ResultVO getInboundBasicConf() {
      log.info("API 调用 ：获取入库配置");
      return ResultBuilder.success(this.basicConfigService.getInboundBasicConf());
   }

   @ApiOperation("修改入库配置")
   @PutMapping("/inbound/base")
   @PreAuthorize("@permission.check('config_wms_basicInbound:edit')")
   public ResultVO setInboundBasicConf(@RequestBody BasicInbound basicInbound) {
      log.info("API 调用 ：修改入库配置");
      return ResultBuilder.success(this.basicConfigService.setInboundBasicConf(basicInbound));
   }

   @ApiOperation("获取采购物料规格修改配置")
   @GetMapping("/purchase-spec/base")
   @PreAuthorize("@permission.check('config_wms_basicPurchase:get')")
   public ResultVO getPurchaseSpecBasicConf() {
      log.info("API 调用 ：获取采购物料规格修改配置");
      return ResultBuilder.success(this.basicConfigService.getPurchaseSpecBasicConf());
   }

   @ApiOperation("编辑采购物料规格修改配置")
   @PutMapping("/purchase-spec/base")
   @PreAuthorize("@permission.check('config_wms_basicPurchase:edit')")
   public ResultVO setPurchaseSpecBasicConf(@RequestBody BasicInbound basicInbound) {
      log.info("API 调用 ：编辑采购物料规格修改配置");
      return ResultBuilder.success(this.basicConfigService.setPurchaseSpecBasicConf(basicInbound));
   }

   @ApiOperation("获取报表下载配置")
   @GetMapping("/report/download")
   @PreAuthorize("@permission.check('config_wms_reportCenter:get')")
   public ResultVO getReportDownload() {
      log.info("API 调用 ：获取报表下载配置");
      return ResultBuilder.success(this.basicConfigService.getReportDownload());
   }

   @ApiOperation("修改报表下载配置")
   @PutMapping("/report/download")
   @PreAuthorize("@permission.check('config_wms_reportCenter:edit')")
   public ResultVO setInboundBasicConf(@RequestBody ReportDownload reportDownload) {
      log.info("API 调用 ：修改报表下载配置");
      return ResultBuilder.success(this.basicConfigService.setReportDownload(reportDownload));
   }

   @ApiOperation("获取所有配置")
   @GetMapping("/all")
   public ResultVO getAllConfig() {
      log.info("API 调用 ：获取所有配置");
      return ResultBuilder.success(this.basicConfigService.getAllConfig());
   }

   @ApiOperation("获取入库钢材配置")
   @GetMapping("/inbound/steel")
   @PreAuthorize("@permission.check('config_wms_steelInbound:get')")
   public ResultVO getInboundSteelConf() {
      log.info("API 调用 ：获取入库钢材配置");
      return ResultBuilder.success(this.basicConfigService.getInboundSteelConf());
   }

   @ApiOperation("修改入库钢材配置")
   @PutMapping("/inbound/steel")
   @PreAuthorize("@permission.check('config_wms_steelInbound:edit')")
   public ResultVO setInboundSteelConf(@RequestBody SteelInbound steelInbound) {
      log.info("API 调用 ：修改入库钢材配置");
      return ResultBuilder.success(this.basicConfigService.setInboundSteelConf(steelInbound));
   }

   @ApiOperation("获取出库基础配置")
   @GetMapping("/outbound/base")
   @PreAuthorize("@permission.check('config_wms_basicOutbound:get')")
   public ResultVO getOutboundBasicConf() {
      log.info("API 调用 ：获取出库基础配置");
      return ResultBuilder.success(this.basicConfigService.getOutboundBasicConf());
   }

   @ApiOperation("设置出库基础配置")
   @PutMapping("/outbound/base")
   @PreAuthorize("@permission.check('config_wms_basicOutbound:edit')")
   public ResultVO setOutboundBasicConf(@RequestBody BasicOutbound basicOutbound) {
      log.info("API 调用 ：设置出库基础配置");
      return ResultBuilder.success(this.basicConfigService.setOutboundBasicConf(basicOutbound));
   }

   @ApiOperation("获取甲供材料归还基础配置")
   @GetMapping("/transfer/party-a-borrow-return")
   @PreAuthorize("@permission.check('config_wms_partyABorrowReturn:get')")
   public ResultVO getPartyABorrowReturnConf() {
      log.info("API 调用 ：获取甲供材料归还基础配置");
      return ResultBuilder.success(this.basicConfigService.getPartyABorrowReturnConf());
   }

   @ApiOperation("保存甲供材料归还基础配置")
   @PutMapping("/transfer/party-a-borrow-return")
   @PreAuthorize("@permission.check('config_wms_partyABorrowReturn:edit')")
   public ResultVO setPartyABorrowReturnConf(@RequestBody PartyABorrowReturnConf partyABorrowReturnConf) {
      log.info("API 调用 ：保存甲供材料归还基础配置");
      return ResultBuilder.success(this.basicConfigService.setPartyABorrowReturnConf(partyABorrowReturnConf));
   }

   @ApiOperation("获取加权模式配置")
   @GetMapping("/weighted-price")
   @PreAuthorize("@permission.check('config_wms_materialWeighting:get')")
   public ResultVO getWeightedPriceConf() {
      log.info("API 调用 ：获取加权模式配置");
      return ResultBuilder.success(this.basicConfigService.getWeightedPriceConf());
   }

   @ApiOperation("获取加权执行方式配置")
   @GetMapping("/weighted-price_type")
   public ResultVO getWeightedExecutionTypeConfig() {
      log.info("API 调用 ：获取加权执行方式配置");
      return ResultBuilder.success(this.basicConfigService.getWeightedExecutionTypeConfig());
   }

   @ApiOperation("修改加权执行方式配置")
   @PutMapping("/weighted-price_type")
   @PreAuthorize("@permission.check('config_wms_materialWeighting:edit')")
   public ResultVO setWeightedExecutionTypeConfig(@RequestBody WeightedExecutionPriceConf conf) {
      log.info("API 调用 ：修改加权执行方式配置");
      return ResultBuilder.success(this.basicConfigService.setWeightedExecutionTypeConfig(conf));
   }

   @ApiOperation("修改加权模式配置")
   @PutMapping("/weighted-price")
   @PreAuthorize("@permission.check('config_wms_materialWeighting:edit')")
   public ResultVO setWeightedPriceConf(@RequestBody WeightedPriceConf conf) {
      log.info("API 调用 ：修改加权模式配置");
      return ResultBuilder.success(this.basicConfigService.setWeightedPriceConf(conf));
   }

   @ApiOperation("获取套料获取物料模式配置")
   @GetMapping("/inventoryType")
   public ResultVO getInventoryTypeConfig() {
      log.info("API 调用 ：获取套料获取物料模式配置");
      return ResultBuilder.success(this.basicConfigService.getInventoryTypeConfig());
   }

   @ApiOperation("修改套料获取物料模式配置")
   @PutMapping("/inventoryType")
   @PreAuthorize("@permission.check('config_wms_inventory_gain_type:edit')")
   public ResultVO setInventoryTypeConfig(@RequestBody MaterialConfig conf) {
      log.info("API 调用 ：修改套料获取物料模式配置");
      return ResultBuilder.success(this.basicConfigService.setInventoryTypeConfig(conf));
   }

   @ApiOperation("获取退库设置")
   @GetMapping("/return")
   @PreAuthorize("@permission.check('config_wms_basicReturn:get')")
   public ResultVO getReturnConf() {
      log.info("API 调用 ：获取退库设置");
      return ResultBuilder.success(this.basicConfigService.getReturnConf());
   }

   @ApiOperation("修改退库配置")
   @PutMapping("/return")
   @PreAuthorize("@permission.check('config_wms_basicReturn:edit')")
   public ResultVO setReturnConf(@RequestBody ReturnConfig conf) {
      log.info("API 调用 ：修改退库配置");
      return ResultBuilder.success(this.basicConfigService.setReturnConf(conf));
   }

   @ApiOperation("获取调拨设置")
   @GetMapping("/transfer")
   @PreAuthorize("@permission.check('config_wms_transfer:get')")
   public ResultVO getTransferConf() {
      log.info("API 调用 ：获取退库设置");
      return ResultBuilder.success(this.basicConfigService.getTransferConfig());
   }

   @ApiOperation("修改调拨设置")
   @PutMapping("/transfer")
   @PreAuthorize("@permission.check('config_wms_transfer:edit')")
   public ResultVO setTransferConf(@RequestBody TransferConfig conf) {
      log.info("API 调用 ：修改退库配置");
      return ResultBuilder.success(this.basicConfigService.setTransferConfig(conf));
   }

   @ApiOperation("获取盘亏设置")
   @GetMapping("/inventory")
   public ResultVO getInventoryConf() {
      log.info("API 调用 ：获取盘亏设置");
      return ResultBuilder.success(this.basicConfigService.getInventoryConfig());
   }

   @ApiOperation("修改盘亏设置")
   @PutMapping("/inventory")
   @PreAuthorize("@permission.check('config_wms_inventory_loss:edit')")
   public ResultVO setTransferConf(@RequestBody DeficitConfig conf) {
      log.info("API 调用 ：修改盘亏设置");
      return ResultBuilder.success(this.basicConfigService.setInventoryConfig(conf));
   }

   @ApiOperation("获取物料仓分类配置")
   @GetMapping("/materialWarehouseConfig")
   public ResultVO getMaterialWarehouseConfig() {
      log.info("API 调用 ：获取物料仓分类配置");
      return ResultBuilder.success(this.basicConfigService.getMaterialWarehouseConfig());
   }

   @ApiOperation("修改物料仓分类配置")
   @PutMapping("/materialWarehouseConfig")
   @PreAuthorize("@permission.check('config_wms_factory_warehouse:edit')")
   public ResultVO setMaterialWarehouseConfig(@RequestBody MaterialWarehouseConfig conf) {
      log.info("API 调用 ：修改物料仓分类配置");
      return ResultBuilder.success(this.basicConfigService.setMaterialWarehouseConfig(conf));
   }

   @ApiOperation("获取基础显示配置")
   @GetMapping("/basicShowConfig")
   public ResultVO getBasicShowConfig() {
      log.info("API 调用 ：获取基础显示配置");
      return ResultBuilder.success(this.basicConfigService.getBasicShowConfig());
   }

   @ApiOperation("修改基础显示配置")
   @PutMapping("/basicShowConfig")
   @PreAuthorize("@permission.check('display_basic_configuration:edit')")
   public ResultVO setBasicShowConfig(@RequestBody BasicShowConfig conf) {
      log.info("API 调用 ：修改基础显示配置");
      return ResultBuilder.success(this.basicConfigService.setBasicShowConfig(conf));
   }

   @ApiOperation("获取条板转换配置")
   @GetMapping("/convert")
   @PreAuthorize("@permission.check('coil_plate_convert:get')")
   public ResultVO getConvertConfig() {
      log.info("API 调用 ：获取条板转换配置");
      return ResultBuilder.success(this.basicConfigService.getConvertConfig());
   }

   @ApiOperation("修改条板转换配置")
   @PutMapping("/convert")
   @PreAuthorize("@permission.check('coil_plate_convert:edit')")
   public ResultVO setConvertConfig(@RequestBody List<ConvertConfig> list) {
      log.info("API 调用 ：修改条板转换配置");
      return ResultBuilder.success(this.basicConfigService.setConvertConfig(list));
   }

   @ApiOperation("获取出库清单可修改字段配置")
   @GetMapping("/outboundUpdateConfig")
   @PreAuthorize("@permission.check('outbound_list_edit_able:get')")
   public ResultVO getOutboundUpdateConfig() {
      log.info("API 调用 ：获取出库清单可修改字段配置");
      return ResultBuilder.success(this.basicConfigService.getOutboundUpdateConfig());
   }

   @ApiOperation("修改出库清单可修改字段配置")
   @PutMapping("/outboundUpdateConfig")
   @PreAuthorize("@permission.check('outbound_list_edit_able:edit')")
   public ResultVO setOutboundUpdateConfig(@RequestBody OutboundUpdateConfig conf) {
      log.info("API 调用 ：修改出库清单可修改字段配置");
      return ResultBuilder.success(this.basicConfigService.setOutboundUpdateConfig(conf));
   }

   @ApiOperation("获取单价异常提醒配置")
   @GetMapping("/priceAbnormalConfig")
   @PreAuthorize("@permission.check('basic_class_price_config:get')")
   public ResultVO getPriceAbnormalConfig() {
      log.info("API 调用 ：获取单价异常提醒配置");
      return ResultBuilder.success(this.basicConfigService.getPriceAbnormalConfig());
   }

   @ApiOperation("修改单价异常提醒配置")
   @PutMapping("/priceAbnormalConfig")
   @PreAuthorize("@permission.check('basic_class_price_config:edit')")
   public ResultVO setPriceAbnormalConfig(@RequestBody List<PriceAbnormalConfig> list) {
      log.info("API 调用 ：修改单价异常提醒配置");
      return ResultBuilder.success(this.basicConfigService.setPriceAbnormalConfig(list));
   }
}
