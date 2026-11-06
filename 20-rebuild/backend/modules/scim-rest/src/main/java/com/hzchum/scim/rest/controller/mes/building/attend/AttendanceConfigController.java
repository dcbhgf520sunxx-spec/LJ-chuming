package com.hzchum.scim.rest.controller.mes.building.attend;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.mes.building.core.api.biz.attend.MesBuildingAttendanceBiz;
import com.hzchum.scim.mes.building.core.api.biz.attend.MesBuildingAttendanceOverConfigBiz;
import com.hzchum.scim.mes.building.core.api.biz.attend.MesBuildingAttendanceStandConfigBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.attend.MesBuildingAttendanceDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.attend.MesBuildingAttendanceOverConfigDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.attend.MesBuildingAttendanceStandConfigDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "工厂考勤管理")
@RestController
@RequestMapping("/api/attend/config")
public class AttendanceConfigController {
   private static final Logger log = LoggerFactory.getLogger(AttendanceConfigController.class);
   @Resource
   private MesBuildingAttendanceStandConfigBiz standConfigBiz;
   @Resource
   private MesBuildingAttendanceOverConfigBiz overConfigBiz;
   @Resource
   private MesBuildingAttendanceBiz attendanceBiz;

   @ApiOperation("查询常规考勤配置")
   @GetMapping("/standConfig")
   public ResultVO getAttendanceTime() {
      log.info("API调用 ： 查询考勤配置信息");
      return ResultBuilder.success(this.standConfigBiz.getStandConfig());
   }

   @ApiOperation("编辑常规考勤配置")
   @PostMapping("/standConfig/edit")
   @SignerCheck(boolMethodAndClassName = true, message = "考勤配置正在请刷新稍后重试")
   public ResultVO saveConfig(@RequestBody @Validated MesBuildingAttendanceStandConfigDTOParam param) {
      log.info("API调用 ： 编辑常规考勤配置");
      return ResultBuilder.success(this.standConfigBiz.editStandConfig(param));
   }

   @ApiOperation("查询加班考勤配置")
   @GetMapping("/OverConfig/page")
   public ResultVO getOverConfigPage(
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用 ： 查询加班考勤配置");
      return ResultBuilder.success(this.overConfigBiz.getOverConfigPage(startDate, endDate, pageNumber, pageSize));
   }

   @ApiOperation("查询加班配置详情")
   @GetMapping("/OverConfig/details")
   public ResultVO getOverConfigDetails(@RequestParam Long overConfigId) {
      log.info("API调用 ： 查询加班配置详情");
      return ResultBuilder.success(this.overConfigBiz.getOverConfigDetails(overConfigId));
   }

   @ApiOperation("花名册人员部门")
   @GetMapping("/dept/list")
   public ResultVO getRosterDepartmentList() {
      log.info("API调用 ： 花名册人员部门");
      return ResultBuilder.success(this.overConfigBiz.getRosterDepartmentList());
   }

   @ApiOperation("花名册部门下劳务")
   @GetMapping("/rosterByDept/list")
   public ResultVO getRosterByDepartment(@RequestParam Long deptId) {
      log.info("API调用 ： 花名册人员部门");
      return ResultBuilder.success(this.overConfigBiz.getRosterByDepartment(deptId));
   }

   @ApiOperation("编辑加班配置")
   @PostMapping("/overConfig/edit")
   public ResultVO saveConfig(@RequestBody @Validated MesBuildingAttendanceOverConfigDTOParam param) {
      log.info("API调用 ： 编辑加班配置");
      return ResultBuilder.success(this.overConfigBiz.editOverConfig(param));
   }

   @ApiOperation("删除加班配置")
   @DeleteMapping("/overConfig/delete")
   public ResultVO deleteList(@RequestParam Long id) {
      log.info("Api调用: 删除加班配置");
      return ResultBuilder.success(this.overConfigBiz.delete(id));
   }

   @ApiOperation("APP考勤打卡")
   @PutMapping("/clock")
   public ResultVO attendanceClock(@RequestBody @Validated MesBuildingAttendanceDTOParam param) {
      log.info("API调用 ：APP考勤打卡");
      return ResultBuilder.success(this.attendanceBiz.saveAttendance(param));
   }

   @ApiOperation("APP登录人当日考勤信息")
   @GetMapping("/config/details")
   public ResultVO getUserConfig() {
      log.info("API调用 ：APP登录人当日考勤信息");
      return ResultBuilder.success(this.attendanceBiz.getTodayConfig(false));
   }

   @ApiOperation("APP登录人加班通知")
   @GetMapping("/user/overConfig")
   public ResultVO getUserOverConfigList(@RequestParam LocalDate monthDate) {
      log.info("API调用 ：APP登录人加班通知");
      return ResultBuilder.success(this.overConfigBiz.getUserOverConfigList(monthDate));
   }

   @ApiOperation("表单展示")
   @GetMapping("/dayDetails")
   public ResultVO getAttendanceDayDetails(
      @RequestParam(required = false) Long deptId,
      @RequestParam(required = false) String workType,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate,
      @RequestParam(required = false) Boolean isStand,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("API调用 ：表单展示");
      return ResultBuilder.success(this.attendanceBiz.getAttendanceDayDetails(deptId, workType, name, startDate, endDate, isStand, pageNumber, pageSize));
   }

   @ApiOperation("表单展示下载")
   @GetMapping("/dayDetails/download")
   public void getAttendanceDayDetailsDownload(
      @RequestParam(required = false) Long deptId,
      @RequestParam(required = false) String workType,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate,
      @RequestParam(required = false) Boolean isStand
   ) {
      log.info("API调用 ：PC日考勤详情下载");
      this.attendanceBiz.getAttendanceDayDetailsDownload(deptId, workType, name, startDate, endDate, isStand);
   }

   @ApiOperation("卡片展示")
   @GetMapping("/summary")
   public ResultVO getAttendanceSummary(@RequestParam(required = false) Long supplierId, @RequestParam LocalDate monthDate) {
      log.info("API调用 ：卡片展示");
      return ResultBuilder.success(this.attendanceBiz.getAttendanceSummary(monthDate, supplierId));
   }

   @ApiOperation("卡片详情")
   @GetMapping("/cardDetails")
   public ResultVO getAttendanceDayDetails(
      @RequestParam LocalDate dayDate,
      @RequestParam(required = false) Long supplierId,
      @RequestParam Boolean isStand,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("API调用 ：卡片详情");
      return ResultBuilder.success(this.attendanceBiz.getCardDetails(dayDate, supplierId, isStand, pageNumber, pageSize));
   }

   @ApiOperation("卡片详情下载")
   @GetMapping("/cardDetails/download")
   public void getAttendanceDayDetailsDownload(@RequestParam LocalDate dayDate, @RequestParam(required = false) Long supplierId, @RequestParam Boolean isStand) {
      log.info("API调用 ：卡片详情下载");
      this.attendanceBiz.getCardDetailsDownload(dayDate, supplierId, isStand);
   }

   @ApiOperation("APP个人考勤汇总")
   @GetMapping("/user/attendanceSummary")
   public ResultVO getUserAttendanceSummary() {
      log.info("API调用 ：APP个人考勤汇总");
      return ResultBuilder.success(this.attendanceBiz.getUserAttendanceSummary());
   }

   @ApiOperation("APP个人月考勤详情")
   @GetMapping("/user/dayDetails")
   public ResultVO getUserAttendanceDayDetails(@RequestParam LocalDate monthDate) {
      log.info("API调用 ：APP个人月考勤详情");
      return ResultBuilder.success(this.attendanceBiz.getUserAttendanceDayDetails(monthDate));
   }

   @ApiOperation("PC月考勤详情")
   @GetMapping("/monthDetails")
   public ResultVO getAttendanceMonthDetails(
      @RequestParam LocalDate monthDate,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("API调用 ：PC月考勤详情");
      return ResultBuilder.success(this.attendanceBiz.getAttendanceMonthDetails(monthDate, pageNumber, pageSize));
   }

   @ApiOperation("PC月考勤详情下载")
   @GetMapping("/monthDetails/download")
   public void getAttendanceMonthDetailsDownload(@RequestParam LocalDate monthDate) {
      log.info("API调用 ：PC月考勤详情信息");
      this.attendanceBiz.getAttendanceMonthDetailsDownload(monthDate);
   }
}
