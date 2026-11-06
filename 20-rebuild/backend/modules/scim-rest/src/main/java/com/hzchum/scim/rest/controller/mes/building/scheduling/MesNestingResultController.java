package com.hzchum.scim.rest.controller.mes.building.scheduling;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.nesting_result.JobSteelPlateParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.nesting_result.NestingResultQuery;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuJobDirectoryService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuNestingResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES零件排产(套料)")
@RestController
@RequestMapping("/api/mes/building/nesting-result")
public class MesNestingResultController {
   private static final Logger log = LoggerFactory.getLogger(MesNestingResultController.class);
   @Autowired
   private MesBuildingBoChuJobDirectoryService boChuJobDirectoryService;
   @Autowired
   private MesBuildingBoChuNestingResultService boChuNestingResultService;

   @ApiOperation("获取作业分组树")
   @GetMapping("get-job-tree")
   public ResultVO getJobTree(NestingResultQuery query) {
      log.info("API 调用 ：获取作业分组树");
      return ResultBuilder.success(this.boChuJobDirectoryService.getJobTree(query));
   }

   @ApiOperation("作业零件汇总信息")
   @GetMapping("job-machine-part-summary")
   public ResultVO jobMachinePartSummary(@ApiParam(value = "作业id", required = true) @RequestParam Integer jobId) {
      log.info("API 调用 ：作业零件汇总信息");
      return ResultBuilder.success(this.boChuNestingResultService.jobMachinePartSummary(jobId));
   }

   @ApiOperation("作业下的钢板-分页")
   @GetMapping("job-steel-plate/page")
   public ResultVO jobSteelPlatePage(
      NestingResultQuery query, @RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam(required = false) List<String> sort
   ) {
      log.info("API 调用 ：作业下的钢板-分页");
      return ResultBuilder.success(this.boChuNestingResultService.pageInfo(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("作业下的钢板-列表")
   @GetMapping("job-steel-plate/list")
   public ResultVO jobSteelPlateList(NestingResultQuery query) {
      log.info("API 调用 ：作业下的钢板-列表");
      return ResultBuilder.success(this.boChuNestingResultService.listInfo(query));
   }

   @ApiOperation("作业下的钢板-批量下载报告单")
   @GetMapping("job-steel-plate/batch-download-report-form")
   public void jobSteelPlateBatchDownloadReportForm(NestingResultQuery query, HttpServletResponse response) {
      log.info("API 调用 ：作业下的钢板-批量下载报告单");
      this.boChuNestingResultService.jobSteelPlateBatchDownloadReportForm(query, response);
   }

   @ApiOperation("作业下的钢板-删除")
   @DeleteMapping("job-steel-plate/delete")
   @SignerCheck(lockKey = "#param.jobId", message = "当前作业下的钢板正在删除，请稍后重试")
   public ResultVO jobSteelPlateDelete(@RequestBody JobSteelPlateParam param) {
      log.info("API 调用 ：作业下的钢板-删除");
      return ResultBuilder.success(this.boChuNestingResultService.jobSteelPlateDelete(param));
   }

   @ApiOperation("作业下的钢板-排产")
   @PostMapping("job-steel-plate/scheduling")
   @SignerCheck(lockKey = "#param.jobId", message = "当前作业下的钢板正在排产，请稍后重试")
   public ResultVO jobSteelPlateScheduling(@RequestBody JobSteelPlateParam param) {
      log.info("API 调用 ：作业下的钢板-排产");
      return ResultBuilder.success(this.boChuNestingResultService.jobSteelPlateScheduling(param));
   }

   @ApiOperation("作业下的钢板-二次排产")
   @PostMapping("job-steel-plate/secondary-scheduling")
   @SignerCheck(lockKey = "#param.jobId", message = "当前作业下的钢板正在二次排产，请稍后重试")
   public ResultVO jobSteelPlateSecondaryScheduling(@RequestBody JobSteelPlateParam param) {
      log.info("API 调用 ：作业下的钢板-二次排产");
      return ResultBuilder.success(this.boChuNestingResultService.jobSteelPlateSecondarySchedulingV2(param));
   }

   @ApiOperation("作业下的钢板-排产撤回")
   @PostMapping("job-steel-plate/scheduling-revoke")
   @SignerCheck(lockKey = "#param.jobId", message = "当前作业下的钢板正在排产撤回，请稍后重试")
   public ResultVO jobSteelPlateSchedulingRevoke(@RequestBody JobSteelPlateParam param) {
      log.info("API 调用 ：作业下的钢板-排产撤回");
      return ResultBuilder.success(this.boChuNestingResultService.jobSteelPlateSchedulingRevoke(param));
   }

   @ApiOperation("作业下的钢板-切割代码下载")
   @GetMapping("job-steel-plate/cutting-code-download")
   public void jobSteelPlateCuttingCodeDownload(
      @ApiParam(value = "作业id", required = true) @RequestParam Integer jobId,
      @ApiParam(value = "套料成果id", required = true) @RequestParam Long nestingResultId,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：作业下的钢板-切割代码下载");
      this.boChuNestingResultService.jobSteelPlateCuttingCodeDownload(jobId, nestingResultId, response);
   }
}
