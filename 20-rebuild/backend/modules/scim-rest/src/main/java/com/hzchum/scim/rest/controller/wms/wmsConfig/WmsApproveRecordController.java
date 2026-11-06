package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveRecordDTOParam;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.system.core.api.common.enums.InstallReportClientTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-审批日志")
@Validated
@RequestMapping("/api/v2/wms/config/record")
@RestController
public class WmsApproveRecordController {
   private static final Logger log = LoggerFactory.getLogger(WmsApproveRecordController.class);
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;

   @ApiOperation("获取approveRecord分页列表")
   @GetMapping("/list")
   public ResultVO list(
      WmsApproveRecordDTOParam wmsApproveRecordDTOParam,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(name = "sort", required = false) List<String> sort
   ) {
      log.info("API 调用 ：获取approveRecord分页列表");
      return ResultBuilder.success(
         this.wmsApproveRecordService.getList(wmsApproveRecordDTOParam, pageNumber, pageSize, sort, InstallReportClientTypeEnum.PC.getType())
      );
   }

   @ApiOperation("根据审批ID获取到流程信息")
   @GetMapping("/getApproveRecordDTO/{id}")
   public ResultVO getApproveRecordDTO(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据审批ID获取到流程信息");
      return ResultBuilder.success(this.wmsApproveRecordService.getApproveRecordDTO(id));
   }

   @ApiOperation("获取当前用户可以审批的信息数量")
   @GetMapping("/getCanCheck")
   public ResultVO getCanCheck(@RequestParam(value = "componentNameList", required = false) List<String> componentNameList) {
      log.info("API 调用 ：获取当前用户可以审批的信息数量");
      return ResultBuilder.success(this.wmsApproveRecordService.getCanCheckCount(componentNameList));
   }

   @ApiOperation("获取当前用户最近七天被驳回审批的信息数量")
   @GetMapping("/getRejectedCanCheckCount")
   public ResultVO getRejectedCanCheckCount(@RequestParam(value = "componentNameList", required = false) List<String> componentNameList) {
      log.info("API 调用 ：获取当前用户最近七天被驳回审批的信息数量");
      return ResultBuilder.success(this.wmsApproveRecordService.getRejectedCanCheckCount(componentNameList));
   }

   @ApiOperation("获取当前用户提交的在审核中的信息数量")
   @GetMapping("/getSubmitAndReview")
   public ResultVO getSubmitAndReview(@RequestParam("componentNameList") List<String> componentNameList) {
      log.info("API 调用 ：获取当前用户提交的在审核中的信息数量");
      return ResultBuilder.success(this.wmsApproveRecordService.getSubmitAndReview(componentNameList));
   }

   @ApiOperation("判断该信息是否可以进行重写操作 -- 无用接口")
   @GetMapping("/judgeRewrite")
   public ResultVO judgeRewrite(@RequestParam("id") Long id) {
      log.info("API 调用 ：判断该信息是否可以进行重写操作 -- 无用接口");
      return ResultBuilder.success(this.wmsApproveRecordService.judgeRewrite(id));
   }

   @ApiOperation("根据审批主表id获取流程编号")
   @GetMapping("/getSerialNumberById")
   public ResultVO getSerialNumberById(@RequestParam(name = "id") Long id) {
      log.info("API调用:根据审批主表id获取流程编号");
      return ResultBuilder.success(this.wmsApproveRecordService.getSerialNumberById(id));
   }
}
