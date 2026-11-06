package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.MaterialWarehouseDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WmsMaterialWarehouseConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms7.0二期-物料仓库配置")
@RestController
@RequestMapping("/api/v2/config/materialWarehouse")
public class MaterialWarehouseController {
   private static final Logger log = LoggerFactory.getLogger(MaterialWarehouseController.class);
   @Resource
   WmsMaterialWarehouseConfigService wmsMaterialWarehouseConfigService;

   @ApiOperation("新增物料仓库")
   @PostMapping
   public ResultVO addWarehouse(@RequestBody MaterialWarehouseDTOParam request) {
      log.info("API 调用 ：新增物料仓库");
      return ResultBuilder.success(this.wmsMaterialWarehouseConfigService.addWmsMaterialWarehouseConfig(request));
   }

   @ApiOperation("查询物料仓库")
   @GetMapping
   public ResultVO getWmsMaterialWarehouseConfig() {
      log.info("API 调用 ：查询物料仓库");
      return ResultBuilder.success(this.wmsMaterialWarehouseConfigService.getWmsMaterialWarehouseConfig());
   }

   @ApiOperation("更新物料仓库配置")
   @PutMapping
   public ResultVO updateWmsMaterialWarehouseConfig(@RequestBody MaterialWarehouseDTOParam request) {
      log.info("API 调用 ：更新物料仓库配置");
      return ResultBuilder.success(this.wmsMaterialWarehouseConfigService.updateWmsMaterialWarehouseConfig(request));
   }

   @ApiOperation("删除物料仓库配置")
   @DeleteMapping
   public ResultVO deleteWmsMaterialWarehouseConfig(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除物料仓库配置");
      return ResultBuilder.success(this.wmsMaterialWarehouseConfigService.deleteWmsMaterialWarehouseConfig(ids));
   }
}
