package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicCheck;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.InventoryUseConfig;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/api/v2/wms/config")
public class BasicConfigControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(BasicConfigControllerV2.class);
   @Resource
   BasicConfigService basicConfigService;

   @ApiOperation("获取入库配置V2")
   @GetMapping("/inbound/base")
   @PreAuthorize("@permission.check('config_wms_basicInbound:get')")
   public ResultVO getInboundBasicConf() {
      log.info("API 调用 ：获取入库配置");
      return ResultBuilder.success(this.basicConfigService.getInboundBasicConfV2());
   }

   @ApiOperation("获取基础审核配置")
   @GetMapping("/check/base")
   @PreAuthorize("@permission.check('config_wms_basicInbound:get')")
   public ResultVO getCheckBasicConf() {
      log.info("API 调用 ：获取全局审核配置");
      return ResultBuilder.success(this.basicConfigService.getCheckBasicConf());
   }

   @ApiOperation("修改基础审核配置")
   @PutMapping("/check/base")
   @PreAuthorize("@permission.check('config_wms_basicInbound:edit')")
   public ResultVO setCheckBasicConf(@RequestBody BasicCheck basicCheck) {
      log.info("API 调用 ：获取全局审核配置");
      return ResultBuilder.success(this.basicConfigService.setCheckBasicConf(basicCheck));
   }

   @ApiOperation("获取库存使用分析结存方式")
   @GetMapping("/inventory/base")
   public ResultVO getInventoryBasicConf() {
      log.info("API 调用 ：获取库存使用分析结存方式");
      return ResultBuilder.success(this.basicConfigService.getInventoryBasicConf());
   }

   @ApiOperation("修改库存使用分析结存方式")
   @PutMapping("/inventory/base")
   @PreAuthorize("@permission.check('wms_report_rawMat_inventory_analysus_usage:modeChange')")
   public ResultVO setInventoryBasicConf(@RequestBody InventoryUseConfig conf) {
      log.info("API 调用 ：修改库存使用分析结存方式");
      return ResultBuilder.success(this.basicConfigService.setInventoryBasicConf(conf));
   }
}
