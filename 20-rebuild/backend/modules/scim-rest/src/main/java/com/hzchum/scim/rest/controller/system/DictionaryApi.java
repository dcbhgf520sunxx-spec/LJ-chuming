package com.hzchum.scim.rest.controller.system;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.pojo.common.DictionaryInfo;
import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo.request.DictionarySaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.DictionaryUpdateRequestVO;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-字典表")
@RestController
@RequestMapping("/api")
public class DictionaryApi {
   private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryApi.class);
   private final ConfigProperties configProperties;
   private final SysDictionaryService dictionaryService;

   @ApiOperation(value = "列表-字典", notes = "获取字典类型")
   @GetMapping("/dict")
   public Result getParentList(String blurry) {
      LOGGER.info("API 调用 ：查询所有字典信息");
      return ResultGenerator.genSuccessResult(this.dictionaryService.listAllDictionary(blurry));
   }

   @ApiOperation("字典分页")
   @GetMapping("/dict/page")
   public ResultVO dictPage(@RequestParam(required = false) String blurry, @RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
      LOGGER.info("API 调用 ：字典分页");
      return ResultBuilder.success(this.dictionaryService.pageInfo(blurry, pageNumber, pageSize));
   }

   @ApiOperation(value = "列表-字典详情", notes = "根据字典名称分页查询字典详情")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "name", value = "字典名称", paramType = "query"),
            @ApiImplicitParam(name = "label", value = "字典详情名称", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", paramType = "query", defaultValue = "10")
      }
   )
   @GetMapping("/dictDetail")
   public Result pageByNameAndLabelLike(
      @RequestParam String name,
      @RequestParam(required = false) String label,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      LOGGER.info("API 调用 ：查询所有字典信息");
      return ResultGenerator.genSuccessResult(this.dictionaryService.pageByNameAndLabelLike(name, label, pageNumber, pageSize));
   }

   @ApiOperation(value = "列表-字典详情", notes = "根据字典名称分页查询字典详情")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "name", value = "字典名称", paramType = "query"),
            @ApiImplicitParam(name = "label", value = "字典详情名称", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", paramType = "query", defaultValue = "10")
      }
   )
   @GetMapping("/more/dictDetail")
   public Result pageByNameAndLabelLike(@RequestParam List<String> names) {
      LOGGER.info("API 调用 ：查询所有字典信息");
      return ResultGenerator.genSuccessResult(this.dictionaryService.moreDistNameAndLabelLike(names));
   }

   @ApiOperation(value = "所有字典标签-字典详情", notes = "根据字典名称查询所有字典详情")
   @ApiImplicitParam(name = "name", value = "字典名称", paramType = "query")
   @GetMapping("/dictDetail/all")
   public Result listByName(@RequestParam String name) {
      LOGGER.info("API 调用 ：根据字典名称查询所有字典详情");
      return ResultGenerator.genSuccessResult(new ListVO<>(this.dictionaryService.listByName(name)));
   }

   @ApiOperation(value = "所有字典标签-字典详情", notes = "根据字典名称查询所有字典详情")
   @GetMapping("/enclosure/dictionary")
   public Result listByName() {
      LOGGER.info("API 调用 ：根据字典名称查询所有字典详情");
      return ResultGenerator.genSuccessResult(new ListVO<>(this.dictionaryService.listByName("enclosure_type")));
   }

   @ApiOperation(value = "更新字典信息", notes = "更新字典信息")
   @PutMapping("/dictDetail")
   public Result updateDictionary(@Valid @RequestBody DictionaryUpdateRequestVO requestVO) {
      LOGGER.info("API 调用 ： 更新字典信息");
      return ResultGenerator.genSuccessResult(this.dictionaryService.updateDictionary(requestVO));
   }

   @ApiOperation(value = "添加-字典详情", notes = "添加-字典详情")
   @PostMapping("/dictDetail")
   public Result saveDictionary(@Valid @RequestBody DictionarySaveDTOParam saveDTOParam) {
      LOGGER.info("API 调用 ： 添加-字典详情");
      return ResultGenerator.genSuccessResult(this.dictionaryService.saveDictionary(saveDTOParam));
   }

   @ApiOperation(value = "删除字典信息", notes = "根据id删除字典信息")
   @DeleteMapping("/dictDetail/{id}")
   public Result deleteDictionary(@PathVariable Long id) {
      LOGGER.info("API 调用 ：根据id删除字典信息");
      return ResultGenerator.genSuccessResult(this.dictionaryService.deleteDictionary(id));
   }

   @ApiOperation(value = "所有字典标签-字典详情(钉钉使用)", notes = "根据字典名称查询所有字典详情(钉钉使用)")
   @ApiImplicitParam(name = "name", value = "字典名称", paramType = "query")
   @GetMapping("/dictDetail/dd")
   public Result<ListVO<SysDictionary>> listByNameToOA(@RequestHeader("accessToken") String accessToken, @RequestParam String name) {
      Preconditions.checkArgument(this.configProperties.getAccessToken().equals(accessToken), "传入的accessToken错误");
      Preconditions.checkArgument(
         DictionaryEnum.MATERIAL_SUPPLIER_FEE_TYPE.getName().equals(name) || DictionaryEnum.LOGISTICS_SUPPLIER_FEE_TYPE.getName().equals(name), "非法字典名称"
      );
      LOGGER.info("API 调用 ：根据字典名称查询所有字典详情(钉钉使用)");
      return ResultGenerator.genSuccessResult(new ListVO<>(this.dictionaryService.listByName(name)));
   }

   @ApiOperation("根据字典名称 查询 字典简单信息列表")
   @ApiImplicitParam(name = "name", value = "字典名称", paramType = "query", required = true)
   @GetMapping("/listSimple")
   public Result<ListVO<DictionaryInfo>> listSimpleByName(@RequestParam(defaultValue = "reimbursement_type") String name) {
      LOGGER.info("API 调用 ：根据字典名称 查询 字典简单信息列表");
      return ResultGenerator.genSuccessResult(this.dictionaryService.listDictionaryInfo(name));
   }

   public DictionaryApi(final ConfigProperties configProperties, final SysDictionaryService dictionaryService) {
      this.configProperties = configProperties;
      this.dictionaryService = dictionaryService;
   }
}
