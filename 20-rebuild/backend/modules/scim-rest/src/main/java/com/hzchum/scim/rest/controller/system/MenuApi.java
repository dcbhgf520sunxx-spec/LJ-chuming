package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.common.enums.MenuSystemEnum;
import com.hzchum.scim.system.core.api.pojo.dto.MenuFirst;
import com.hzchum.scim.system.core.api.pojo.dto.MenuRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.PermissionDTO;
import com.hzchum.scim.system.core.api.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-菜单")
@RestController
@RequestMapping("/api/menu")
public class MenuApi {
   private static final Logger log = LoggerFactory.getLogger(MenuApi.class);
   @Resource
   private final MenuService menuService;

   @ApiOperation(value = "获得菜单树", notes = "获取菜单树")
   @GetMapping("/tree")
   public Result getMenuTree(@RequestParam(required = false) @EnumValidator(value = MenuSystemEnum.class, message = "类型不正确") Integer systemEnum) {
      log.info("API 调用 ： 获得菜单树");
      return ResultGenerator.genSuccessResult(this.menuService.getMenuTree(systemEnum));
   }

   @ApiOperation(value = "获得菜单列表", notes = "获得菜单列表")
   @ApiImplicitParam(name = "blurryName", value = "菜单名称（模糊搜索）", paramType = "query")
   @GetMapping("")
   public Result listByName(@RequestParam(required = false) String blurryName) {
      log.info("API 调用 ： 获得菜单列表");
      return ResultGenerator.genSuccessResult(this.menuService.listByName(blurryName));
   }

   @ApiOperation(value = "菜单信息", notes = "根据菜单唯一标识获取菜单详情")
   @ApiImplicitParam(name = "id", value = "菜单id", paramType = "path")
   @GetMapping("/{id}")
   public Result getMenu(@PathVariable Long id) {
      log.info("API 调用 ：根据id获取菜单详情");
      return ResultGenerator.genSuccessResult(this.menuService.getById(id));
   }

   @ApiOperation(value = "新增菜单", notes = "新增菜单")
   @PostMapping("")
   public Result saveMenu(@Valid @RequestBody MenuRequestVO requestVO) {
      log.info("API 调用 ：保存一个新的菜单");
      return ResultGenerator.genSuccessResult(this.menuService.addMenu(requestVO));
   }

   @ApiOperation(value = "菜单更新", notes = "更新菜单的信息")
   @PutMapping("")
   public Result updateMenu(@Valid @RequestBody MenuRequestVO requestVO) {
      log.info("API 调用 ： 更新菜单的信息");
      return ResultGenerator.genSuccessResult(this.menuService.updateMenu(requestVO));
   }

   @ApiOperation(value = "删除菜单", notes = "根据菜单唯一标识删除该菜单")
   @DeleteMapping("")
   public Result removeMenu(@RequestBody List<Long> ids) {
      log.info("API 调用 ：根据id删除菜单");
      return ResultGenerator.genSuccessResult(this.menuService.removeBatchMenu(ids));
   }

   @ApiOperation(value = "根据根节点id删除对应的权限信息", notes = "根据根节点id删除对应的权限信息")
   @DeleteMapping("/deleteMenuTree")
   public Result deleteMenuTree(@RequestParam Long rootId) {
      log.info("API 调用 ：根据根节点id删除对应的权限信息");
      return ResultGenerator.genSuccessResult(this.menuService.deleteMenuTree(rootId));
   }

   @ApiOperation("管理员添加菜单")
   @PostMapping("/admin/list/{pid}")
   public Result addMenuListByAdmin(@RequestBody List<MenuFirst> menuFirst, @PathVariable Long pid) {
      log.info("API 调用 ： 管理员添加菜单");
      return ResultGenerator.genSuccessResult(this.menuService.addMenusByAdmin(menuFirst, pid));
   }

   @ApiOperation("添加菜单按钮权限")
   @PostMapping("/admin/addPermission/list/{pid}")
   public Result addPermission(@RequestBody List<PermissionDTO> permissionDTOList, @PathVariable Long pid) {
      log.info("API 调用 ： 添加菜单按钮权限");
      return ResultGenerator.genSuccessResult(this.menuService.addPermission(permissionDTOList, pid));
   }

   @ApiOperation("更新菜单id及pid")
   @PostMapping("/admin/updateIdAndPid")
   public Result updateIdAndPid() {
      log.info("API 调用 ： 更新菜单id及pid");
      return ResultGenerator.genSuccessResult(this.menuService.updateIdAndPid());
   }

   @ApiOperation("全部模块-列表")
   @ApiImplicitParam(name = "name", value = "模块名称", paramType = "query")
   @GetMapping("/list-module")
   public ResultVO<ListVO<NameInfo>> listModuleMenu(String name) {
      return ResultBuilder.success(new ListVO<>(this.menuService.listModuleMenu(name)));
   }

   public MenuApi(final MenuService menuService) {
      this.menuService = menuService;
   }
}
