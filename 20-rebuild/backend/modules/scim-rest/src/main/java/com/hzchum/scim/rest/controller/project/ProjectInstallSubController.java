package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.project.core.api.biz.ProjectInstallBiz;
import com.hzchum.scim.project.core.api.biz.ProjectInstallStatementBiz;
import com.hzchum.scim.project.core.api.biz.attend.ProjectManageAttendanceBiz;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallStatementDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目管理-app用户报表")
@RequestMapping("/api/project/sub")
@RestController
public class ProjectInstallSubController {
   private static final Logger log = LoggerFactory.getLogger(ProjectInstallSubController.class);
   @Resource
   private ProjectInstallStatementBiz projectInstallStatementBiz;
   @Resource
   private ProjectInstallBiz installReportBiz;
   @Resource
   private ProjectManageAttendanceBiz attendanceBiz;

   @ApiOperation("分包app-安装报表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年 2022", paramType = "query", required = true),
            @ApiImplicitParam(name = "month", value = "月 8", paramType = "query")
      }
   )
   @GetMapping("/install-statement")
   public ResultVO<ListVO<ProjectInstallStatementDTO>> listInstallStatement(
      Long projectId, @RequestParam(defaultValue = "1") Integer projectType, @RequestParam Integer productType, @RequestParam Integer year, Integer month
   ) {
      log.info("Api调用: 安装报表月/日统计");
      return ResultBuilder.success(new ListVO<>(this.projectInstallStatementBiz.listInstallStatement(projectId, projectType, productType, year, month)));
   }

   @ApiOperation("图表分析")
   @GetMapping("/install-statement/chart")
   public ResultVO listChart(@RequestParam Long monomerId) {
      log.info("Api调用: 分包app-图表分析");
      return ResultBuilder.success(new ListVO<>(this.projectInstallStatementBiz.getInstallSum(monomerId)));
   }

   @ApiOperation("计划执行")
   @GetMapping("/install-statement/install-plan")
   public ResultVO listInstallPlan(@RequestParam Long projectId) {
      log.info("Api调用: 分包app-计划执行");
      return ResultBuilder.success(new ListVO<>(this.projectInstallStatementBiz.listInstallPlan(projectId)));
   }

   @ApiOperation("分包商-任务数量")
   @GetMapping("/task-quantity")
   public ResultVO<Map<String, Number>> getMyTask() {
      log.info("Api调用: 分包app-分包商任务数量");
      return ResultBuilder.success(this.projectInstallStatementBiz.getMyTaskQuantity());
   }

   @ApiOperation("项目管理APP用户任务气泡")
   @GetMapping("/user/taskQuantity")
   public ResultVO getUserTaskQuantity() {
      log.info("API调用 ：APP用户任务气泡");
      return ResultBuilder.success(this.installReportBiz.getUserTaskQuantity());
   }

   @ApiOperation("APP用户安装详情")
   @GetMapping("/user/installDetails")
   public ResultVO getUserInstallDetails(
      @RequestParam @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不正确！") Integer productType,
      @RequestParam Boolean isMe,
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("API调用 ：APP用户安装详情");
      return ResultBuilder.success(this.installReportBiz.getUserInstallDetails(productType, isMe, startDate, endDate, pageNumber, pageSize));
   }

   @ApiOperation("APP个人考勤汇总")
   @GetMapping("/user/summary")
   public ResultVO getUserSummary() {
      log.info("API调用 ：APP个人考勤汇总");
      return ResultBuilder.success(this.attendanceBiz.getUserAttendanceSummary());
   }

   @ApiOperation("APP个人月考勤详情")
   @GetMapping("/user/dayDetails")
   public ResultVO getUserAttendanceDayDetails(@RequestParam LocalDate monthDate) {
      log.info("API调用 ：PC日考勤详情");
      return ResultBuilder.success(this.attendanceBiz.getUserAttendanceDayDetails(monthDate));
   }
}
