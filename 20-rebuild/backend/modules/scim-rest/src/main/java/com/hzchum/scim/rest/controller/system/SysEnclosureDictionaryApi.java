package com.hzchum.scim.rest.controller.system;

import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.pojo.request.EnclosureDictionaryDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.TrussFloorPlateSaveDTOParam;
import com.hzchum.scim.system.core.api.service.SysEnclosureDictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-围护类型字典")
@RestController
@RequestMapping("/api/enclosure/dictionaries")
public class SysEnclosureDictionaryApi {
   private static final Logger log = LoggerFactory.getLogger(SysEnclosureDictionaryApi.class);
   @Resource
   private SysEnclosureDictionaryService enclosureDictionariesService;

   @ApiOperation("根据围护类型,查询")
   @GetMapping("/dict")
   @PreAuthorize("@permission.check('enclosure_info_config:get')")
   public Result getParentList(@RequestParam Integer type) {
      log.info("API 调用 ：查询所有围护字典信息");
      return ResultGenerator.genSuccessResult(this.enclosureDictionariesService.listAllDictionary(type));
   }

   @ApiOperation("根据围护字典名称查询所有围护字典详情")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "name", value = "字典名称", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "(桁架楼承板)编号", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "围护类型 2压型彩板 4夹芯板 8桁架楼承板 16压型楼承板", paramType = "query", required = true),
            @ApiImplicitParam(name = "label", value = "字典详情名称", paramType = "query")
      }
   )
   @GetMapping("/dictDetail/all")
   @PreAuthorize("@permission.check('enclosure_info_detail:get')")
   public Result listByName(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String code,
      @RequestParam("type") Integer type,
      @RequestParam(required = false) String label
   ) {
      log.info("API 调用 ：根据围护字典名称查询所有围护字典详情");
      return ResultGenerator.genSuccessResult(this.enclosureDictionariesService.listByName(name, code, type, label));
   }

   @ApiOperation("新增-围护字典详情")
   @PostMapping("/dictDetailSave")
   @PreAuthorize("@permission.check('enclosure_info_detail:add')")
   public Result saveDictionary(@Valid @RequestBody EnclosureDictionaryDTOParam requestVO) {
      log.info("API 调用 ： 新增-围护字典详情");
      return ResultGenerator.genSuccessResult(this.enclosureDictionariesService.saveDictionary(requestVO));
   }

   @ApiOperation("新增/修改-围护-桁架楼承板字典")
   @PostMapping("/dictDetailSave/type/8")
   @PreAuthorize("@permission.check('enclosure_info_config:add')")
   public Result saveEnclosureDictionary(@Valid @RequestBody TrussFloorPlateSaveDTOParam requestVO) {
      log.info("API 调用 ： 新增-围护-桁架楼承板字典");
      return ResultGenerator.genSuccessResult(this.enclosureDictionariesService.saveUpdateEnclosureDictionary(requestVO));
   }

   @ApiOperation("修改-桁架楼承板-状态")
   @PutMapping("/updateStatus/type/8")
   @PreAuthorize("@permission.check('enclosure_info_config:editStatus')")
   public Result updateStatus(@RequestParam String code, @RequestParam Boolean status) {
      log.info("API 调用:修改-桁架楼承板-状态");
      return ResultGenerator.genSuccessResult(this.enclosureDictionariesService.updateStatus(code, status));
   }

   @ApiOperation("批量删除-桁架楼承板字典")
   @DeleteMapping("/deleteCodes")
   @PreAuthorize("@permission.check('enclosure_info_config:del')")
   public Result deleteByCode(@RequestBody List<String> codes) {
      log.info("API 调用 ：批量删除桁架楼承板编号");
      return ResultGenerator.genSuccessResult(this.enclosureDictionariesService.deleteByCodes(codes));
   }

   @ApiOperation("删除围护字典信息")
   @DeleteMapping("/dictDetail/{id}")
   @PreAuthorize("@permission.check('enclosure_info_detail:del')")
   public Result deleteDictionary(@PathVariable Long id) {
      log.info("API 调用 ：删除围护字典信息");
      return ResultGenerator.genSuccessResult(this.enclosureDictionariesService.deleteDictionary(id));
   }

   @ApiOperation("修改围护字典信息")
   @PutMapping("/dictDetail/upDate")
   @PreAuthorize("@permission.check('enclosure_info_detail:edit')")
   public Result updateDictionary(@Valid @RequestBody EnclosureDictionaryDTOParam requestVO) {
      log.info("API 调用 ： 更新围护字典信息");
      return ResultGenerator.genSuccessResult(this.enclosureDictionariesService.updateDictionary(requestVO));
   }
}
