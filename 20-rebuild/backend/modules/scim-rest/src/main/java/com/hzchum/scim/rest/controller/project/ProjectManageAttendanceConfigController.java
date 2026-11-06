package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.project.core.api.biz.attend.ProjectManageAttendanceBiz;
import com.hzchum.scim.project.core.api.biz.attend.ProjectManageAttendanceConfigBiz;
import com.hzchum.scim.project.core.api.pojo.dtoParam.put.ProjectManageAttendanceDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectManageAttendanceConfigDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目管理-考勤管理")
@RequestMapping("/api/project/attendance")
@RestController
public class ProjectManageAttendanceConfigController {
   private static final Logger log = LoggerFactory.getLogger(ProjectManageAttendanceConfigController.class);
   @Resource
   private ProjectManageAttendanceConfigBiz configBiz;
   @Resource
   private ProjectManageAttendanceBiz attendanceBiz;

   @ApiOperation("查询考勤配置信息")
   @GetMapping("/config/attendanceTime")
   public ResultVO getAttendanceTime(Long projectId) {
      log.info("API调用 ： 查询考勤配置信息");
      return ResultBuilder.success(this.configBiz.getAttendanceTime(projectId));
   }

   @ApiOperation("添加考勤配置")
   @PostMapping("/config/save")
   @SignerCheck(lockKey = "#param.projectId", message = "考勤配置正在修改请刷新稍后重试")
   public ResultVO saveConfig(@RequestBody @Validated(Add.class) ProjectManageAttendanceConfigDTOParam param) {
      log.info("API调用 ： 添加考勤配置");
      return ResultBuilder.success(this.configBiz.setAttendanceTime(param));
   }

   @ApiOperation("修改考勤配置")
   @PutMapping("/config/update")
   public ResultVO updateConfig(@RequestBody @Validated(Update.class) ProjectManageAttendanceConfigDTOParam param) {
      log.info("API调用 ： 修改考勤配置");
      return ResultBuilder.success(this.configBiz.setAttendanceTime(param));
   }

   @ApiOperation("APP考勤打卡")
   @PutMapping("/clock")
   public ResultVO attendanceClock(@RequestBody @Validated ProjectManageAttendanceDTOParam param) {
      log.info("API调用 ：APP考勤打卡");
      return ResultBuilder.success(this.attendanceBiz.saveAttendance(param));
   }

   @ApiOperation("APP登录人当日考勤信息")
   @GetMapping("/config/details")
   public ResultVO getUserConfig(@RequestParam Long projectId) {
      log.info("API调用 ：app获取登录人考勤配置");
      return ResultBuilder.success(this.attendanceBiz.getUserConfig(projectId));
   }

   @ApiOperation("PC考勤汇总")
   @GetMapping("/summary")
   public ResultVO getAttendanceSummary(@RequestParam Long projectId, @RequestParam(required = false) Long supplierId, @RequestParam LocalDate monthDate) {
      log.info("API调用 ：PC考勤汇总");
      return ResultBuilder.success(this.attendanceBiz.getAttendanceSummary(projectId, supplierId, monthDate));
   }

   @ApiOperation("PC日考勤详情")
   @GetMapping("/dayDetails")
   public ResultVO getAttendanceDayDetails(
      @RequestParam Long projectId,
      @RequestParam Boolean isSummaryDetail,
      @RequestParam(required = false) Long supplierId,
      @RequestParam(required = false) LocalDate monthDate,
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("API调用 ：PC日考勤详情");
      return ResultBuilder.success(
         this.attendanceBiz.getAttendanceDayDetails(isSummaryDetail, projectId, supplierId, monthDate, startDate, endDate, pageNumber, pageSize)
      );
   }

   @ApiOperation("PC日考勤详情下载")
   @GetMapping("/dayDetails/download")
   public void getAttendanceDayDetailsDownload(
      @RequestParam Long projectId,
      @RequestParam Boolean isSummaryDetail,
      @RequestParam(required = false) Long supplierId,
      @RequestParam(required = false) LocalDate monthDate,
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate
   ) {
      log.info("API调用 ：PC日考勤详情下载");
      this.attendanceBiz.getAttendanceDayDetailsDownload(isSummaryDetail, projectId, supplierId, monthDate, startDate, endDate);
   }

   @ApiOperation("PC月考勤详情")
   @GetMapping("/monthDetails")
   public ResultVO getAttendanceMonthDetails(
      @RequestParam Long projectId,
      @RequestParam LocalDate monthDate,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("API调用 ：PC月考勤详情信息");
      return ResultBuilder.success(this.attendanceBiz.getAttendanceMonthDetails(projectId, monthDate, pageNumber, pageSize));
   }

   @ApiOperation("PC月考勤详情下载")
   @GetMapping("/monthDetails/download")
   public void getAttendanceMonthDetailsDownload(@RequestParam Long projectId, @RequestParam LocalDate monthDate) {
      log.info("API调用 ：PC月考勤详情信息");
      this.attendanceBiz.getAttendanceMonthDetailsDownload(projectId, monthDate);
   }
}
