package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.project.core.api.biz.ProjectSubVisaBiz;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectVisaReasonDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectVisaReasonDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectVisaReasonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目管理-签证原因")
@RestController
@RequestMapping("/api/project/visa-reason")
public class ProjectVisaReasonController {
   private static final Logger log = LoggerFactory.getLogger(ProjectVisaReasonController.class);
   @Resource
   ProjectVisaReasonService projectVisaReasonService;
   @Resource
   ProjectSubVisaBiz projectVisaBiz;

   @ApiOperation("签证原因列表")
   @GetMapping
   @PreAuthorize("@permission.check('project_visa_reason_config:get')")
   public ResultVO<ListVO<ProjectVisaReasonDTO>> list(String name) {
      log.info("Api调用: 签证原因列表");
      return ResultBuilder.success(new ListVO<>(this.projectVisaReasonService.listVisaReason(name)));
   }

   @ApiOperation("签证原因列表")
   @GetMapping("/app")
   public ResultVO<ListVO<ProjectVisaReasonDTO>> listApp(String name) {
      log.info("Api调用: 签证原因列表");
      return ResultBuilder.success(new ListVO<>(this.projectVisaReasonService.listVisaReason(name)));
   }

   @ApiOperation("新增-签证原因")
   @PostMapping
   @PreAuthorize("@permission.check('project_visa_reason_config:add')")
   public ResultVO save(@RequestBody @Valid List<ProjectVisaReasonDTOParam> params) {
      log.info("Api调用: 新增-签证原因");
      return ResultBuilder.success(this.projectVisaReasonService.saveVisaReason(params));
   }

   @ApiOperation("修改-签证原因")
   @PutMapping
   @PreAuthorize("@permission.check('project_visa_reason_config:edit')")
   public ResultVO update(@RequestBody @Valid ProjectVisaReasonDTOParam param) {
      log.info("Api调用: 修改-签证原因");
      return ResultBuilder.success(this.projectVisaReasonService.updateVisaReason(param));
   }

   @ApiOperation("删除-签证原因")
   @DeleteMapping
   @PreAuthorize("@permission.check('project_visa_reason_config:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("Api调用: 删除-签证原因");
      return ResultBuilder.success(this.projectVisaBiz.delVisaReason(ids));
   }

   @ApiOperation("签证原因列表-公共接口")
   @GetMapping("/all")
   public ResultVO<ListVO<ProjectVisaReasonDTO>> listAll(String name) {
      log.info("Api调用: 签证原因列表");
      return ResultBuilder.success(new ListVO<>(this.projectVisaReasonService.listVisaReason(name)));
   }
}
