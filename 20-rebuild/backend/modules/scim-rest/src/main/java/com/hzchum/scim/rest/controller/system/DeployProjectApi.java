package com.hzchum.scim.rest.controller.system;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectPersonnelSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectPersonnelUpdateDTOParam;
import com.hzchum.scim.system.core.api.service.SysProjectPersonnelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

@Api(tags = "系统管理-项目人员模板配置")
@RestController
@RequestMapping("/api/deploy/project")
public class DeployProjectApi {
   private static final Logger LOGGER = LoggerFactory.getLogger(DeployProjectApi.class);
   private final SysProjectPersonnelService projectPersonnelService;

   @ApiOperation("查询模板列表")
   @GetMapping("/template")
   @PreAuthorize("@permission.check('member-config:get','contract_project:get')")
   public ResultVO getTemplateList(
      String templateName, Integer status, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      LOGGER.info("API 调用 : 查询-项目人员模板列表");
      return ResultBuilder.success(this.projectPersonnelService.listAllTemplate(templateName, status, pageNumber, pageSize));
   }

   @ApiOperation("查询-项目人员信息")
   @GetMapping("/template/details")
   @PreAuthorize("@permission.check('member-config:get','contract_project:get')")
   @ApiImplicitParam(name = "id", value = "模板id", paramType = "query", required = true)
   public ResultVO getTemplateDetails(@RequestParam Long id) {
      LOGGER.info("API 调用 : 查询-项目人员信息");
      return ResultBuilder.success(this.projectPersonnelService.detailsTemplate(id));
   }

   @ApiOperation("修改模板状态")
   @PutMapping("/status")
   @PreAuthorize("@permission.check('member-config:edit')")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "id", value = "模板id", paramType = "query", required = true),
            @ApiImplicitParam(name = "status", value = "状态 1启用 0禁用 ", paramType = "query", required = true)
      }
   )
   public ResultVO updateStatus(@RequestParam Long id, @RequestParam Integer status) {
      LOGGER.info("API 调用 : 修改-模板状态");
      return ResultBuilder.success(this.projectPersonnelService.updateStatus(id, status));
   }

   @ApiOperation("新增-项目人员模板信息")
   @PostMapping("/templateSave")
   @PreAuthorize("@permission.check('member-config:add')")
   public ResultVO saveTemplate(@Valid @RequestBody ProjectPersonnelSaveDTOParam requestVO) {
      LOGGER.info("API 调用 : 新增-项目人员模板信息");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "添加失败,未获取到操作用户信息!");
      return ResultBuilder.success(this.projectPersonnelService.saveTemplate(requestVO));
   }

   @ApiOperation("删除-项目人员模板")
   @DeleteMapping("/remove/{id}")
   @ApiImplicitParam(name = "id", value = "模板id", paramType = "path", required = true)
   @PreAuthorize("@permission.check('member-config:del')")
   public ResultVO deleteTemplate(@PathVariable Long id) {
      LOGGER.info("API 调用 : 删除-项目人员模板");
      return ResultBuilder.success(this.projectPersonnelService.removeTemplate(id));
   }

   @ApiOperation("编辑-项目人员模板信息")
   @PutMapping("/template/Update")
   @PreAuthorize("@permission.check('member-config:edit')")
   public ResultVO updateTemplate(@Valid @RequestBody ProjectPersonnelUpdateDTOParam updateDTOParam) {
      LOGGER.info("API 调用 : 编辑-项目人员模板信息");
      return ResultBuilder.success(this.projectPersonnelService.updateTemplate(updateDTOParam));
   }

   @ApiOperation("修改默认状态")
   @PutMapping("{id}/default/{isDefault}")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "id", value = "模板id", paramType = "path", required = true),
            @ApiImplicitParam(name = "isDefault", value = " true设为默认,false设为非默认", paramType = "path", required = true)
      }
   )
   @PreAuthorize("@permission.check('member-config:edit')")
   public ResultVO list(@PathVariable Long id, @PathVariable Boolean isDefault) {
      LOGGER.info("API 调用 : 修改默认");
      return ResultBuilder.success(this.projectPersonnelService.setDefault(id, isDefault));
   }

   public DeployProjectApi(final SysProjectPersonnelService projectPersonnelService) {
      this.projectPersonnelService = projectPersonnelService;
   }
}
