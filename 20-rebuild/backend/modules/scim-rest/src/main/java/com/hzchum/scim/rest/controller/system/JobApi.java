package com.hzchum.scim.rest.controller.system;

import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.pojo.dto.JobSaveRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.JobUpdateRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.JobUserUpdateDTO;
import com.hzchum.scim.system.core.api.service.JobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-职位")
@RestController
@RequestMapping("/api/job")
public class JobApi {
   private static final Logger log = LoggerFactory.getLogger(JobApi.class);
   private final JobService jobService;

   @ApiOperation(value = "部门下所有岗位-岗位", notes = "根据部门id获取部门对应的岗位")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "deptId", value = "部门id", paramType = "query"), @ApiImplicitParam(name = "enabled", value = "职位状态", paramType = "query")}
   )
   @GetMapping("/all")
   public Result listDepartment(@Param("deptId") Long deptId, @Param("enabled") Integer enabled) {
      log.info("API 调用 ： 根据部门id获取部门对应的岗位");
      return ResultGenerator.genSuccessResult(this.jobService.listByDeptId(deptId, enabled));
   }

   @ApiOperation(value = "列表-岗位", notes = "列表-岗位")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "name", value = "职位name", paramType = "query"),
            @ApiImplicitParam(name = "enabled", value = "职位状态", paramType = "query"),
            @ApiImplicitParam(name = "jobType", value = "岗位类型(1,编制内，2编制外)", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", paramType = "query", defaultValue = "10")
      }
   )
   @GetMapping("")
   @PreAuthorize("@permission.check('job:get')")
   public Result pageByNameAndDeptId(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) Integer enabled,
      @RequestParam(required = false) Integer jobType,
      @RequestParam(required = false) String code,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ： 列表-岗位");
      return ResultGenerator.genSuccessResult(this.jobService.pageByNameAndDeptId(name, enabled, jobType, code, pageNumber, pageSize));
   }

   @ApiOperation(value = "保存职位", notes = "新增一个新的职位")
   @PostMapping("")
   @PreAuthorize("@permission.check('job:add')")
   public Result saveJob(@Valid @RequestBody JobSaveRequestVO requestVO) {
      log.info("API 调用 ：保存一个新的职位");
      return ResultGenerator.genSuccessResult(this.jobService.saveJob(requestVO));
   }

   @ApiOperation(value = "职位信息更新", notes = "更新职位id对应的的职位信息")
   @PutMapping("")
   @PreAuthorize("@permission.check('job:edit')")
   public Result updateJob(@Valid @RequestBody JobUpdateRequestVO requestVO) {
      log.info("API 调用 ： 更新职位id对应的的职位信息");
      return ResultGenerator.genSuccessResult(this.jobService.updateJob(requestVO));
   }

   @ApiOperation(value = "启用/禁用", notes = "启用/禁用")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "id", value = "职位id", paramType = "query"), @ApiImplicitParam(name = "enabled", value = "职位状态", paramType = "query")}
   )
   @PutMapping("/enabled")
   @PreAuthorize("@permission.check('job:edit')")
   public Result setEnabled(@RequestParam Long id, @RequestParam Integer enabled) {
      log.info("API 调用 ： 启用/禁用");
      return ResultGenerator.genSuccessResult(this.jobService.setEnabled(id, enabled));
   }

   @ApiOperation(value = "删除职位", notes = "批量删除职位")
   @DeleteMapping("")
   @PreAuthorize("@permission.check('job:del')")
   public Result deleteJob(@RequestBody List<Long> ids) {
      log.info("API 调用 ：批量删除职位");
      return ResultGenerator.genSuccessResult(this.jobService.deleteJobs(ids));
   }

   @ApiOperation(value = "保存岗位的人员信息", notes = "保存岗位的人员信息")
   @PostMapping("/save/user")
   @PreAuthorize("@permission.check('job:edit')")
   public Result saveJobUser(@Valid @RequestBody JobUserUpdateDTO jobUserUpdateDTO) {
      log.info("API 调用 ：保存岗位的人员信息");
      return ResultGenerator.genSuccessResult(this.jobService.saveJobUser(jobUserUpdateDTO));
   }

   @ApiOperation(value = "查询岗位的人员信息", notes = "查询岗位的人员信息")
   @ApiImplicitParam(name = "id", value = "岗位id", paramType = "query")
   @GetMapping("/query/user")
   @PreAuthorize("@permission.check('job:get')")
   public Result queryJobUser(@RequestParam Long jobId) {
      log.info("API 调用 ：查询岗位的人员信息");
      return ResultGenerator.genSuccessResult(this.jobService.getJobUser(jobId));
   }

   @ApiOperation(value = "下载岗位的人员信息", notes = "下载岗位的人员信息")
   @GetMapping("/export")
   @ApiImplicitParam(name = "enabled", value = "是否禁用", paramType = "query")
   @PreAuthorize("@permission.check('job:get')")
   public void jobExport(@RequestParam(required = false) Integer enabled, HttpServletResponse response) {
      log.info("Api 调用 : 下载岗位的人员信息");
      this.jobService.jobExport(enabled, response);
   }

   public JobApi(final JobService jobService) {
      this.jobService = jobService;
   }
}
