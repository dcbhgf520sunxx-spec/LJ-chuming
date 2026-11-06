package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.project.core.api.biz.ProjectQhseProblemTypeBiz;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseProblemTypeDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseProblemTypeDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectQhseProblemTypeService;
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

@Api(tags = "项目管理-质安问题类型配置")
@RestController
@RequestMapping("api/project/qhse-problem-type")
public class ProjectQhseProblemTypeController {
   private static final Logger log = LoggerFactory.getLogger(ProjectQhseProblemTypeController.class);
   @Resource
   private ProjectQhseProblemTypeService qhseProblemTypeService;
   @Resource
   private ProjectQhseProblemTypeBiz qhseProblemTypeBiz;

   @ApiOperation("质安问题类型列表")
   @GetMapping
   @PreAuthorize("@permission.check('project_problem_config:get','siteQhse')")
   public ResultVO<ListVO<ProjectQhseProblemTypeDTO>> list(String name) {
      log.info("Api调用: 质安问题类型列表");
      return ResultBuilder.success(new ListVO<>(this.qhseProblemTypeService.listTypes(name)));
   }

   @ApiOperation("新增-质安问题类型")
   @PostMapping
   @PreAuthorize("@permission.check('project_problem_config:add','siteQhse')")
   public ResultVO<Boolean> saveList(@RequestBody @Valid List<ProjectQhseProblemTypeDTOParam> params) {
      log.info("Api调用: 新增-质安问题类型");
      return ResultBuilder.success(this.qhseProblemTypeService.saveList(params));
   }

   @ApiOperation("修改-质安问题类型")
   @PutMapping
   @PreAuthorize("@permission.check('project_problem_config:edit','siteQhse')")
   public ResultVO<Boolean> update(@RequestBody @Valid ProjectQhseProblemTypeDTOParam param) {
      log.info("Api调用: 修改-质安问题类型");
      return ResultBuilder.success(this.qhseProblemTypeService.updateType(param));
   }

   @ApiOperation("删除-质安问题类型")
   @DeleteMapping
   @PreAuthorize("@permission.check('project_problem_config:del','siteQhse')")
   public ResultVO<Boolean> delete(@RequestBody List<Long> ids) {
      log.info("Api调用: 删除-质安问题类型");
      return ResultBuilder.success(this.qhseProblemTypeBiz.delete(ids));
   }

   @ApiOperation("质安问题类型列表-公共接口")
   @GetMapping("/all")
   public ResultVO<ListVO<ProjectQhseProblemTypeDTO>> listAll(String name) {
      log.info("Api调用: 质安问题类型列表");
      return ResultBuilder.success(new ListVO<>(this.qhseProblemTypeService.listTypes(name)));
   }
}
