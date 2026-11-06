package com.hzchum.scim.rest.controller.system;

import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.pojo.request.PermissionTypeSaveVO;
import com.hzchum.scim.system.core.api.pojo.request.PermissionTypeUpdateVO;
import com.hzchum.scim.system.core.api.service.PermissionTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-权限类型")
@RestController
@RequestMapping("/api/permission/type")
public class PermissionTypeApi {
   private static final Logger LOGGER = LoggerFactory.getLogger(PermissionTypeApi.class);
   private final PermissionTypeService permissionTypeService;

   @ApiOperation(value = "查询权限类型列表", notes = "查询权限类型列表")
   @ApiImplicitParam(name = "blurryName", value = "权限类型名称", paramType = "query")
   @GetMapping("")
   public Result listByBlurryName(
      @RequestParam(required = false) String blurryName,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      LOGGER.info("API 调用 ：查询权限类型列表");
      return ResultGenerator.genSuccessResult(this.permissionTypeService.listByBlurryName(blurryName, pageNumber, pageSize));
   }

   @ApiOperation(value = "保存权限类型", notes = "新增一个新的权限类型")
   @PostMapping("")
   public Result savePermissionType(@Valid @RequestBody PermissionTypeSaveVO requestVO) {
      LOGGER.info("API 调用 ：保存一个新的权限类型");
      return ResultGenerator.genSuccessResult(this.permissionTypeService.savePermissionType(requestVO));
   }

   @ApiOperation(value = "权限类型信息更新", notes = "更新权限类型id对应的的权限类型信息")
   @PutMapping("")
   public Result updatePermissionType(@Valid @RequestBody PermissionTypeUpdateVO requestVO) {
      LOGGER.info("API 调用 ： 更新权限类型id对应的的权限类型信息");
      return ResultGenerator.genSuccessResult(this.permissionTypeService.updatePermissionType(requestVO));
   }

   @ApiOperation(value = "删除id对应的权限类型", notes = "根据权限类型id删除该权限类型")
   @ApiImplicitParam(name = "id", value = "权限类型id", paramType = "query")
   @DeleteMapping("")
   public Result deletePermissionType(@RequestBody List<Long> ids) {
      LOGGER.info("API 调用 ：根据权限类型id删除权限类型");
      return ResultGenerator.genSuccessResult(this.permissionTypeService.deletePermissionType(ids));
   }

   @ApiOperation("权限类型 (全部)")
   @GetMapping("/all")
   public Result listAll() {
      LOGGER.info("API 调用 ：权限类型 (全部)");
      return ResultGenerator.genSuccessResult(this.permissionTypeService.listAll());
   }

   public PermissionTypeApi(final PermissionTypeService permissionTypeService) {
      this.permissionTypeService = permissionTypeService;
   }
}
