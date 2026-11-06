package com.hzchum.scim.rest.controller.cut.lantek;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.cut.core.api.pojo._do.CutTaskProject;
import com.hzchum.scim.cut.core.api.service.CutTaskProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "切割套料对接")
@RestController
@RequestMapping("/api/radan")
public class RadanController {
   private static final Logger log = LoggerFactory.getLogger(RadanController.class);
   @Resource
   private CutTaskProjectService cutTaskProjectService;

   @ApiOperation("查看项目概况")
   @GetMapping("/getPartByProjectId")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true),
            @ApiImplicitParam(name = "projectId", value = "Long", required = false, dataType = "Long")
      }
   )
   public ResultVO getPartByProjectId(
      Integer pageNumber,
      Integer pageSize,
      Long projectId,
      String projectName,
      @RequestParam(required = false, name = "sort") List<String> sort,
      Long nestingState,
      String importTime
   ) {
      return this.cutTaskProjectService.getPartByProjectId(pageNumber, pageSize, projectId, projectName, sort, nestingState, importTime);
   }

   @ApiOperation("项目id查看项目零件")
   @GetMapping("/getTaskByProjectId")
   @ApiImplicitParams(@ApiImplicitParam(name = "projectId", value = "项目id", required = true, dataType = "Long"))
   @PreAuthorize("@permission.check('nest_work_list:get')")
   public ResultVO getTaskByProjectId(Long projectId, Long monomerId, Long areaId) {
      return this.cutTaskProjectService.getTaskByProjectId(projectId, monomerId, areaId);
   }

   @ApiOperation("接收钢板信息报告")
   @PostMapping("/setPlantReport")
   public ResultVO setPlateReport(@RequestBody String plateReport) {
      return this.cutTaskProjectService.setPlateReport(plateReport);
   }

   @ApiOperation("任务id查零件清单")
   @PostMapping("/getPartByCutTaskId")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true),
            @ApiImplicitParam(name = "cutTaskId", value = "cutTaskId", required = true, dataType = "String")
      }
   )
   public ResultVO getPartByCutTaskId(Integer pageNumber, Integer pageSize, String cutTaskId) {
      return this.cutTaskProjectService.getPartByCutTaskId(pageNumber, pageSize, cutTaskId);
   }

   @ApiOperation("打印零件清单")
   @GetMapping("/PrintPartByCutTaskId/{cutTaskId}")
   public ResultVO PrintPartByCutTaskId(@PathVariable String cutTaskId) {
      return ResultBuilder.success(this.cutTaskProjectService.printPartByCutTaskId(cutTaskId));
   }

   @ApiOperation("项目id查看任务包")
   @GetMapping("/getTaskPack")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true),
            @ApiImplicitParam(name = "projectId", value = "Long", required = false, dataType = "Long")
      }
   )
   public ResultVO getTaskPack(
      Integer pageNumber,
      Integer pageSize,
      Long projectId,
      String projectName,
      String monomerValue,
      String areaValue,
      String thick,
      String importTime,
      String state
   ) {
      if (pageNumber == null) {
         pageNumber = 1;
      }

      if (pageSize == null) {
         pageSize = 50;
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<CutTaskProject> list = this.cutTaskProjectService
         .list(
            ((((((new LambdaQueryWrapper<CutTaskProject>()
                                 .like(StrUtil.isNotBlank(projectName), CutTaskProject::getProjectName, projectName))
                              .like(StrUtil.isNotBlank(monomerValue), CutTaskProject::getAreaName, monomerValue))
                           .like(StrUtil.isNotBlank(areaValue), CutTaskProject::getAreaName, areaValue))
                        .eq(projectId != null, CutTaskProject::getProjectId, projectId))
                     .eq(StrUtil.isNotBlank(thick), CutTaskProject::getThick, thick))
                  .eq(StrUtil.isNotBlank(state), CutTaskProject::getState, state))
               .eq(StrUtil.isNotBlank(importTime), CutTaskProject::getImportTime, importTime)
         );
      return ResultBuilder.success(new PageVO<>(list));
   }

   @ApiOperation("任务id查询任务包")
   @GetMapping("/getTask/{cutTaskId}")
   public ResultVO getTask(@PathVariable("cutTaskId") String cutTaskId) {
      CutTaskProject one = this.cutTaskProjectService
         .getOne(new LambdaQueryWrapper<CutTaskProject>().eq(StrUtil.isNotBlank(cutTaskId), CutTaskProject::getCutTaskId, cutTaskId));
      return ResultBuilder.success(one);
   }

   @ApiOperation("项目信息总览")
   @GetMapping("/getProjectInfo")
   public ResultVO getProjectInfo() {
      return this.cutTaskProjectService.getProjectInfo();
   }
}
