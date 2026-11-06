package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.biz.wmsConfig.WasteClassificationBiz;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.WasteClassificationDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WasteClassificationDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-废料种类配置")
@Validated
@RequestMapping("/api/wms/config/wasteClassification")
@RestController
public class WasteClassificationController {
   private static final Logger log = LoggerFactory.getLogger(WasteClassificationController.class);
   private final WasteClassificationBiz wasteClassificationBiz;

   @ApiOperation("列表(公共接口-无权限)")
   @GetMapping("/all")
   public ResultVO<ListVO<WasteClassificationDTO>> listAll(String name) {
      log.info("Api调用:废料种类配置列表(公共接口)");
      return ResultBuilder.success(new ListVO<>(this.wasteClassificationBiz.listAll(name)));
   }

   @ApiOperation("列表")
   @GetMapping
   @PreAuthorize("@permission.check('config_wms_scrapConfig:get')")
   public ResultVO<PageVO<WasteClassificationDTO>> pageList(
      String name, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:废料种类配置列表");
      return ResultBuilder.success(this.wasteClassificationBiz.pageList(name, pageNumber, pageSize));
   }

   @ApiOperation("新增")
   @PostMapping
   @PreAuthorize("@permission.check('config_wms_scrapConfig:add')")
   public ResultVO saveList(@RequestBody @Valid List<WasteClassificationDtoParam> paramList) {
      log.info("Api调用:废料种类配置新增");
      return ResultBuilder.success(this.wasteClassificationBiz.saveList(paramList));
   }

   @ApiOperation("修改")
   @PutMapping
   @PreAuthorize("@permission.check('config_wms_scrapConfig:edit')")
   public ResultVO updateList(@RequestBody @Valid List<WasteClassificationDtoParam> paramList) {
      log.info("Api调用:废料种类配置修改");
      return ResultBuilder.success(this.wasteClassificationBiz.updateList(paramList));
   }

   @ApiOperation("删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('config_wms_scrapConfig:del')")
   public ResultVO deleteList(@RequestBody List<Long> ids) {
      log.info("Api调用:废料种类配置删除");
      return ResultBuilder.success(this.wasteClassificationBiz.deleteList(ids));
   }

   public WasteClassificationController(final WasteClassificationBiz wasteClassificationBiz) {
      this.wasteClassificationBiz = wasteClassificationBiz;
   }
}
