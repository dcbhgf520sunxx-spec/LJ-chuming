package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.SysStructureTypeBiz;
import com.hzchum.scim.system.core.api.pojo.dto.SysStructureTypeDTO;
import com.hzchum.scim.system.core.api.pojo.param.SysStructureTypeSaveParam;
import com.hzchum.scim.system.core.api.pojo.param.SysStructureTypeUpdateParam;
import com.hzchum.scim.system.core.api.pojo.request.SysStructureTypeQueryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-项目结构类型")
@Validated
@RestController
@RequestMapping("/api/config/structureType")
public class SysStructureTypeController {
   private static final Logger log = LoggerFactory.getLogger(SysStructureTypeController.class);
   private final SysStructureTypeBiz structureTypeBiz;

   @ApiOperation("列表(公共接口)")
   @GetMapping("/list/public")
   public ResultVO<ListVO<SysStructureTypeDTO>> listAll() {
      SysStructureTypeQueryParam param = SysStructureTypeQueryParam.builder().boolEnableEnum(true).build();
      log.info("Api调用:项目结构类型配置列表");
      return ResultBuilder.success(new ListVO<>(this.structureTypeBiz.listAll(param)));
   }

   @ApiOperation("列表-分页")
   @GetMapping("/list/page")
   @PreAuthorize("@permission.check('structure_type_config:get')")
   public ResultVO<PageVO<SysStructureTypeDTO>> pageList(
      SysStructureTypeQueryParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:项目结构类型配置列表");
      return ResultBuilder.success(this.structureTypeBiz.pageList(param, pageNumber, pageSize));
   }

   @ApiOperation("保存-单个")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('structure_type_config:add')")
   public ResultVO<Boolean> saveList(@RequestBody @Valid SysStructureTypeSaveParam param) {
      log.info("Api调用:新增-项目结构类型(单个)");
      return ResultBuilder.success(this.structureTypeBiz.saveList(Collections.singletonList(param)));
   }

   @ApiOperation("保存-批量")
   @PostMapping("/save/batch")
   @PreAuthorize("@permission.check('structure_type_config:add')")
   public ResultVO<Boolean> saveList(@RequestBody @Valid List<SysStructureTypeSaveParam> paramList) {
      log.info("Api调用:新增-项目结构类型(批量)");
      return ResultBuilder.success(this.structureTypeBiz.saveList(paramList));
   }

   @ApiOperation("修改")
   @PutMapping("/update")
   @PreAuthorize("@permission.check('structure_type_config:edit')")
   public ResultVO<Boolean> update(@RequestBody @Valid SysStructureTypeUpdateParam param) {
      log.info("Api调用:修改-项目结构类型");
      return ResultBuilder.success(this.structureTypeBiz.edit(param));
   }

   @ApiOperation("删除-单个")
   @DeleteMapping("/remove/{id}")
   @PreAuthorize("@permission.check('structure_type_config:del')")
   public ResultVO<Boolean> removeById(@PathVariable Long id) {
      log.info("Api调用:删除-项目结构类型");
      return ResultBuilder.success(this.structureTypeBiz.delete(Collections.singletonList(id)));
   }

   @ApiOperation("删除-批量")
   @DeleteMapping("/remove/batch")
   @PreAuthorize("@permission.check('structure_type_config:del')")
   public ResultVO<Boolean> removeList(@RequestBody List<Long> ids) {
      log.info("Api调用:删除-项目结构类型");
      return ResultBuilder.success(this.structureTypeBiz.delete(ids));
   }

   public SysStructureTypeController(final SysStructureTypeBiz structureTypeBiz) {
      this.structureTypeBiz = structureTypeBiz;
   }
}
