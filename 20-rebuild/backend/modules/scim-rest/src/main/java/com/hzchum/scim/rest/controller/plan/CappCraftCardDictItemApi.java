package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardDictItemBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardDictItemListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardDictItemSaveDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardDictItemUpdateDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardDictItemVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "计划管理 - CAPP 工艺卡字典项")
@RequestMapping("api/plan/cappCraftCardDictItem")
public class CappCraftCardDictItemApi {
   private static final Logger log = LoggerFactory.getLogger(CappCraftCardDictItemApi.class);
   @Resource
   private TechCappCraftCardDictItemBiz techCappCraftCardDictItemBiz;

   @ApiOperation("新增 CAPP 工艺卡字典项")
   @PostMapping("/add")
   public ResultVO<Boolean> add(@RequestBody @Valid CappCraftCardDictItemSaveDTO saveDTO) {
      log.info("API 调用 ：新增 CAPP 工艺卡字典项");
      return ResultBuilder.success(this.techCappCraftCardDictItemBiz.save(saveDTO));
   }

   @ApiOperation("修改 CAPP 工艺卡字典项")
   @PostMapping("/update")
   public ResultVO<Boolean> update(@RequestBody @Valid CappCraftCardDictItemUpdateDTO updateDTO) {
      log.info("API 调用 ：修改 CAPP 工艺卡字典项");
      return ResultBuilder.success(this.techCappCraftCardDictItemBiz.update(updateDTO));
   }

   @ApiOperation("修改 CAPP 工艺卡字典项启用状态")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "id", value = "字典值id", paramType = "query"), @ApiImplicitParam(name = "enabledFlag", value = "是否启用", paramType = "query")}
   )
   @PostMapping("/updateEnabledFlag")
   public ResultVO<Boolean> updateEnabledFlag(
      @RequestParam @NotNull(message = "字典值id不能为空") Long id, @RequestParam @NotNull(message = "是否启用不能为空") Boolean enabledFlag
   ) {
      log.info("API 调用 ：修改 CAPP 工艺卡字典项启用状态");
      return ResultBuilder.success(this.techCappCraftCardDictItemBiz.updateEnabledFlag(id, enabledFlag));
   }

   @ApiOperation("删除 CAPP 工艺卡字典项")
   @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "字典值id", paramType = "query"))
   @PostMapping("/delete")
   public ResultVO<Boolean> delete(@RequestParam @NotNull(message = "字典值id不能为空") Long id) {
      log.info("API 调用 ：删除 CAPP 工艺卡字典项");
      return ResultBuilder.success(this.techCappCraftCardDictItemBiz.delete(id));
   }

   @ApiOperation("查询 CAPP 工艺卡字典项列表")
   @GetMapping("/list")
   public ResultVO<List<CappCraftCardDictItemVO>> list(@Valid CappCraftCardDictItemListDTO listDTO) {
      log.info("API 调用 ：查询 CAPP 工艺卡字典项列表");
      return ResultBuilder.success(this.techCappCraftCardDictItemBiz.getList(listDTO));
   }

   @ApiOperation("查询 CAPP 工艺卡字典项下拉选数据")
   @GetMapping("/options")
   public ResultVO<Map<String, List<CappCraftCardDictItemVO>>> options() {
      log.info("API 调用 ：查询 CAPP 工艺卡字典项下拉选数据");
      return ResultBuilder.success(this.techCappCraftCardDictItemBiz.getMapByDictType());
   }
}
