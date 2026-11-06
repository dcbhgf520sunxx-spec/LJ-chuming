package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardStorehouseBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardStorehouseListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardStorehouseSaveDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardStorehouseSimpleListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardStorehouseUpdateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardStorehouseUpdateStatusDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardStorehouseDetailVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardStorehouseSimpleVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardStorehouseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "计划管理 - CAPP 焊接工艺库")
@RequestMapping("api/plan/CappCraftCardStorehouse")
public class CappCraftCardStorehouseApi {
   private static final Logger log = LoggerFactory.getLogger(CappCraftCardStorehouseApi.class);
   @Resource
   private TechCappCraftCardStorehouseBiz techCappCraftCardStorehouseBiz;

   @ApiOperation("新增 CAPP 焊接工艺库新增")
   @PostMapping("/add")
   public ResultVO<Boolean> add(@RequestBody @Valid CappCraftCardStorehouseSaveDTO saveDTO) {
      log.info("API 调用 ：新增 CAPP 焊接工艺库新增");
      return ResultBuilder.success(this.techCappCraftCardStorehouseBiz.save(saveDTO));
   }

   @ApiOperation("修改 CAPP 焊接工艺库修改")
   @PostMapping("/update")
   public ResultVO<Boolean> update(@RequestBody @Valid CappCraftCardStorehouseUpdateDTO updateDTO) {
      log.info("API 调用 ：新增 CAPP 焊接工艺库修改");
      return ResultBuilder.success(this.techCappCraftCardStorehouseBiz.update(updateDTO));
   }

   @ApiOperation("修改 CAPP 焊接工艺库状态修改")
   @PostMapping("/update/status")
   public ResultVO<Boolean> updateStatus(@RequestBody CappCraftCardStorehouseUpdateStatusDTO dto) {
      log.info("API 调用 ：修改 CAPP 焊接工艺库状态修改");
      return ResultBuilder.success(this.techCappCraftCardStorehouseBiz.updateEnabledFlag(dto));
   }

   @ApiOperation("列表 CAPP 焊接工艺列表")
   @GetMapping("/list")
   public ResultVO<PageVO<CappCraftCardStorehouseVO>> list(@Valid CappCraftCardStorehouseListDTO dto) {
      log.info("API调用:列表 CAPP 焊接工艺列表");
      return ResultBuilder.success(this.techCappCraftCardStorehouseBiz.list(dto));
   }

   @ApiOperation("简单列表 CAPP 焊接工艺简单列表")
   @GetMapping("/simple/list")
   public ResultVO<List<CappCraftCardStorehouseSimpleVO>> simpleList(CappCraftCardStorehouseSimpleListDTO dto) {
      log.info("API调用:简单列表 CAPP 焊接工艺简单列表");
      return ResultBuilder.success(this.techCappCraftCardStorehouseBiz.simpleList(dto));
   }

   @ApiOperation("详情 CAPP 焊接工艺详情")
   @GetMapping("/detail")
   public ResultVO<CappCraftCardStorehouseDetailVO> detail(@RequestParam Long id) {
      log.info("API调用:详情 CAPP 焊接工艺详情");
      return ResultBuilder.success(this.techCappCraftCardStorehouseBiz.detail(id));
   }

   @ApiOperation("详情列表 CAPP 焊接工艺详情列表")
   @GetMapping("/detail/list")
   public ResultVO<List<CappCraftCardStorehouseDetailVO>> detailList(@RequestParam List<Long> ids) {
      log.info("API调用:详情列表 CAPP 焊接工艺详情列表");
      return ResultBuilder.success(this.techCappCraftCardStorehouseBiz.detailList(ids));
   }

   @ApiOperation("删除 CAPP 焊接工艺删除")
   @DeleteMapping("/delete")
   public ResultVO<Boolean> delete(@RequestBody List<Long> ids) {
      log.info("API调用:删除 CAPP 焊接工艺删除");
      return ResultBuilder.success(this.techCappCraftCardStorehouseBiz.delete(ids));
   }
}
