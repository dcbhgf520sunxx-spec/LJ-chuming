package com.hzchum.scim.rest.controller.mes.building.craft;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.biz.craft.MesPaintConfigBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintConfigQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "油漆配置")
@RestController
@RequestMapping("/api/mes/building/craft/paint-config")
public class MesPaintConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesPaintConfigController.class);
   @Autowired
   private MesPaintConfigBiz biz;

   @ApiOperation("分页")
   @GetMapping("page")
   @PreAuthorize("@permission.check('mes_paint_technology:config')")
   public ResultVO pageInfo(
      MesPaintConfigQuery query,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false, defaultValue = "id.asc") List<String> sort
   ) {
      log.info("API调用: 油漆配置-分页查询");
      return ResultBuilder.success(this.biz.pageInfo(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("新增")
   @PostMapping
   @PreAuthorize("@permission.check('mes_paint_technology:config')")
   public ResultVO add(@RequestBody @Validated(Add.class) MesPaintConfigParam param) {
      log.info("API调用: 油漆配置-新增");
      return ResultBuilder.success(this.biz.add(param));
   }

   @ApiOperation("修改")
   @PutMapping
   @PreAuthorize("@permission.check('mes_paint_technology:config')")
   public ResultVO edit(@RequestBody @Validated(Update.class) MesPaintConfigParam param) {
      log.info("API调用: 油漆配置-修改");
      return ResultBuilder.success(this.biz.edit(param));
   }

   @ApiOperation("导入模板下载")
   @GetMapping("template-download")
   @PreAuthorize("@permission.check('mes_paint_technology:config')")
   public void templateDownload(HttpServletResponse response) {
      log.info("API调用: 油漆配置-导入模板下载");
      this.biz.templateDownload(response);
   }

   @ApiOperation("导入")
   @PostMapping("import")
   @PreAuthorize("@permission.check('mes_paint_technology:config')")
   public void importData(@RequestPart MultipartFile file, HttpServletResponse response) {
      log.info("API调用: 油漆配置-导入");
      this.biz.importData(file, response);
   }

   @ApiOperation("删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('mes_paint_technology:config')")
   public ResultVO delete(@RequestParam Long id) {
      log.info("API调用: 油漆配置-删除");
      return ResultBuilder.success(this.biz.deleteById(id));
   }

   @ApiOperation("涂装工艺油漆选择列表")
   @GetMapping("painting-craft-select-list")
   public ResultVO paintingCraftSelectList(MesPaintConfigQuery query) {
      log.info("API调用: 油漆配置-涂装工艺油漆选择列表");
      return ResultBuilder.success(new ListVO<>(this.biz.paintingCraftSelectList(query)));
   }

   @ApiOperation("油漆品牌(公共接口)")
   @GetMapping("paint-brand-list")
   public ResultVO paintBrandList(@RequestParam(required = false) String paintBrand) {
      log.info("API调用: 油漆配置-油漆品牌(公共接口)");
      return ResultBuilder.success(new ListVO<>(this.biz.paintBrandList(paintBrand)));
   }

   @ApiOperation("油漆列表(公共接口)")
   @GetMapping("common/paint-list")
   public ResultVO commonPaintList(
      @RequestParam(required = false) List<Integer> paintingTypeEnumList,
      @RequestParam(required = false) List<String> paintBrandList,
      @RequestParam(required = false) List<String> paintTypeList
   ) {
      log.info("API调用: 油漆配置-油漆列表(公共接口)");
      return ResultBuilder.success(new ListVO<>(this.biz.commonPaintList(paintingTypeEnumList, paintBrandList, paintTypeList)));
   }

   @ApiOperation("油漆选择(公共接口)")
   @GetMapping("paint-select-list")
   public ResultVO paintSelectList(@RequestParam(required = false) Integer paintingTypeEnum) {
      log.info("API调用: 油漆配置-油漆选择(公共接口)");
      return ResultBuilder.success(new ListVO<>(this.biz.paintSelectList(paintingTypeEnum)));
   }

   @ApiOperation("清空")
   @DeleteMapping("clear")
   @PreAuthorize("@permission.check('mes_paint_technology:config')")
   public ResultVO clear() {
      log.info("API 调用 ：油漆配置-清空");
      return ResultBuilder.success(this.biz.clear());
   }

   @ApiOperation("油漆配置-列表(公共接口)")
   @GetMapping("/listAll")
   public ResultVO<ListVO<Map<String, Object>>> listAllPaintConfig(Integer paintingTypeEnum) {
      log.info("Api调用:获取油漆配置列表");
      return ResultBuilder.success(new ListVO<>(this.biz.listAllPaintConfig(paintingTypeEnum)));
   }
}
