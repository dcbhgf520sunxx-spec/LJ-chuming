package com.hzchum.scim.rest.controller.system;

import com.hzchum.scim.system.core.api.biz.DepartmentBiz;
import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentSaveRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentUpdateRequestVO;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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

@Api(tags = "系统管理-部门")
@RestController
@RequestMapping("/api/dept")
public class DepartmentApi {
   private static final Logger log = LoggerFactory.getLogger(DepartmentApi.class);
   private final DepartmentService departmentService;
   private final DepartmentBiz departmentBiz;

   @ApiOperation(value = "部门信息", notes = "根据部门唯一标识获取其详情")
   @ApiImplicitParam(name = "id", value = "部门id", paramType = "path")
   @GetMapping("/{id}")
   public Result getDepartment(@PathVariable Long id) {
      log.info("API 调用 ：根据id获取部门详情");
      return ResultGenerator.genSuccessResult(this.departmentService.getDepartment(id));
   }

   @ApiOperation(value = "所在部门", notes = "根据用户唯一凭证获取该用户所在的部门信息")
   @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header")
   @GetMapping("/user")
   public Result getDepartmentByUserId(HttpServletRequest httpServletRequest) {
      log.info("API 调用 : 根据用户id获取该用户所在部门信息");
      SecurityUser user = (SecurityUser)httpServletRequest.getAttribute("user");
      return ResultGenerator.genSuccessResult(user.getDepartment());
   }

   @ApiOperation("公共部门树列表")
   @ApiImplicitParam(name = "hasRoot", value = "是否有根节点（不传：有）", paramType = "query")
   @GetMapping("/all/simple")
   public Result getDepartmentTree(@RequestParam(required = false, defaultValue = "true") Boolean hasRoot) {
      log.info("API 调用 ：公共部门数列表");
      return ResultGenerator.genSuccessResult(this.departmentService.getDepartmentSimpleTree(hasRoot));
   }

   @ApiOperation("公共SHR部门树列表")
   @ApiImplicitParam(name = "hasRoot", value = "是否有根节点（不传：有）", paramType = "query")
   @GetMapping("/all/simple/shr")
   public Result getSHRDepartmentSimpleTree(@RequestParam(required = false, defaultValue = "true") Boolean hasRoot) {
      log.info("API 调用 ：公共SHR部门树列表");
      return ResultGenerator.genSuccessResult(this.departmentService.getSHRDepartmentSimpleTree(hasRoot));
   }

   @ApiOperation("获取部门树")
   @ApiImplicitParam(name = "name", value = "部门名称", paramType = "query")
   @GetMapping("")
   public Result getDepartmentTree(@RequestParam(required = false) String name) {
      log.info("API 调用 ：获取部门配置树列表");
      return ResultGenerator.genSuccessResult(this.departmentService.getDepartmentTree(name, null, null, null));
   }

   @ApiOperation(value = "部门列表", notes = "获取其所有的部门列表")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('dept:get')")
   public Result listDepartment(
      String name,
      String deptCode,
      @RequestParam(required = true, defaultValue = "1") Integer enabled,
      @RequestParam(required = true, defaultValue = "1") Integer deptType
   ) {
      log.info("API 调用 ： 罗列所有的部门");
      return ResultGenerator.genSuccessResult(this.departmentService.listDepartment(name, deptCode, enabled, deptType));
   }

   @ApiOperation(value = "保存部门", notes = "新增一个新的部门")
   @PostMapping("")
   @PreAuthorize("@permission.check('dept:add')")
   public Result saveDepartment(@Valid @RequestBody DepartmentSaveRequestVO requestVO) {
      log.info("API 调用 ：保存一个新的部门");
      return ResultGenerator.genSuccessResult(this.departmentService.saveDepartment(requestVO));
   }

   @ApiOperation(value = "部门更新", notes = "更新部门的信息")
   @PutMapping("")
   @PreAuthorize("@permission.check('dept:edit')")
   public Result updateDepartment(@Valid @RequestBody DepartmentUpdateRequestVO requestVO) {
      log.info("API 调用 ： 更新部门的信息");
      return ResultGenerator.genSuccessResult(this.departmentService.updateDepartment(requestVO));
   }

   @ApiOperation(value = "部门删除", notes = "批量删除部门")
   @DeleteMapping("")
   @PreAuthorize("@permission.check('dept:del')")
   public Result removeDepartments(@RequestBody List<Long> ids) {
      log.info("API 调用 ：根据id删除部门");
      return ResultGenerator.genSuccessResult(this.departmentBiz.removeDepartments(ids));
   }

   @ApiOperation(value = "启用/禁用", notes = "启用/禁用")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "id", value = "岗位id", paramType = "query"), @ApiImplicitParam(name = "enabled", value = "岗位状态", paramType = "query")}
   )
   @PutMapping("/enabled")
   @PreAuthorize("@permission.check('dept:edit')")
   public Result setEnabled(@RequestParam Long id, @RequestParam Integer enabled) {
      log.info("API 调用 ： 启用/禁用");
      return ResultGenerator.genSuccessResult(this.departmentService.setEnabled(id, enabled));
   }

   public DepartmentApi(final DepartmentService departmentService, final DepartmentBiz departmentBiz) {
      this.departmentService = departmentService;
      this.departmentBiz = departmentBiz;
   }
}
