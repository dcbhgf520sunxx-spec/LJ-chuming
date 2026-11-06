package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.ProjectPlanBiz;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ProjectPlanDetailSaveParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-项目计划")
@RequestMapping("/api/plan/project-plan")
@RestController
public class ProjectPlanController {
   private static final Logger log = LoggerFactory.getLogger(ProjectPlanController.class);
   @Autowired
   private ProjectPlanBiz projectPlanBiz;

   @ApiOperation("分页")
   @GetMapping("page")
   public ResultVO page(
      @ApiParam("年份") @RequestParam(required = false) Integer year,
      @ApiParam("项目编号或简称") @RequestParam(required = false) String projectNoOrName,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 项目计划-分页");
      return ResultBuilder.success(this.projectPlanBiz.page(year, projectNoOrName, pageNumber, pageSize, sort));
   }

   @ApiOperation("围护计划分页")
   @GetMapping("enclosure/page")
   public ResultVO enclosurePage(
      @ApiParam("年份") @RequestParam(required = false) Integer year,
      @ApiParam("项目编号或简称") @RequestParam(required = false) String projectNoOrName,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize
   ) {
      log.info("API调用: 围护计划分页");
      return ResultBuilder.success(this.projectPlanBiz.enclosurePlanPage(year, projectNoOrName, pageNumber, pageSize));
   }

   @ApiOperation("计数信息")
   @GetMapping("count-info")
   public ResultVO countInfo(
      @ApiParam("年份") @RequestParam(required = false) Integer year, @ApiParam("项目编号或简称") @RequestParam(required = false) String projectNoOrName
   ) {
      log.info("API调用: 项目计划-计数信息");
      return ResultBuilder.success(this.projectPlanBiz.countInfo(year, projectNoOrName));
   }

   @ApiOperation("详情")
   @GetMapping("detail/{projectId}")
   public ResultVO detail(@PathVariable Long projectId) {
      log.info("API调用: 项目计划-项目计划详情");
      return ResultBuilder.success(this.projectPlanBiz.DetailByProjectId(projectId));
   }

   @ApiOperation("详情批量保存")
   @PostMapping("detail-batch-save")
   @PreAuthorize("@permission.check('sectional_entry_plan:createPlan')")
   public ResultVO detailBatchSave(@RequestBody @Validated ProjectPlanDetailSaveParam param) {
      log.info("API调用: 项目计划详情");
      return ResultBuilder.success(this.projectPlanBiz.detailBatchSave(param));
   }
}
