package com.hzchum.scim.rest.controller.mes.building.quota_config;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.mes.building.core.api.biz.quota_config.MesManualReportBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesManualReportQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingProduceTeamReportDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "人工填报")
@RequestMapping("/api/mes/building/quota-config/manual-report")
public class MesManualReportController {
   private static final Logger log = LoggerFactory.getLogger(MesManualReportController.class);
   @Autowired
   private MesManualReportBiz biz;

   @ApiOperation("未上报列表")
   @GetMapping("unreported-list")
   public ResultVO unreportedList(MesManualReportQuery query) {
      log.info("API调用: 人工填报-未上报列表");
      return ResultBuilder.success(this.biz.unreportedList(query));
   }

   @ApiOperation("灵活工序未上报列表")
   @GetMapping("flexible-process-unreported-list")
   public ResultVO flexibleProcessUnreportedList(MesManualReportQuery query) {
      log.info("API调用: 人工填报-灵活工序未上报列表");
      return ResultBuilder.success(this.biz.flexibleProcessUnreportedList(query));
   }

   @ApiOperation("批量新增生产记录")
   @PostMapping("batch-add-produce-report")
   @SignerCheck(lockKey = "#processId", message = "当前工序正在批量新增中, 请刷新后重试", timeout = 60L)
   public ResultVO batchAddProduceReport(
      @ApiParam(name = "productTypeEnum", value = "产品类型", required = true) @RequestParam Integer productTypeEnum,
      @ApiParam(name = "processId", value = "工序id", required = true) @RequestParam Long processId,
      @ApiParam(name = "teamId", value = "班组id", required = true) @RequestParam Long teamId,
      @RequestBody List<MesBuildingProduceTeamReportDTOParam> paramList
   ) {
      log.info("API调用: 人工填报-批量新增生产记录");
      return ResultBuilder.success(this.biz.batchAddProduceReport(productTypeEnum, paramList));
   }

   @ApiOperation("灵活工序批量新增生产记录")
   @PostMapping("flexible-process-batch-add-produce-report")
   @SignerCheck(lockKey = "#processId", message = "当前工序正在批量新增中, 请刷新后重试", timeout = 60L)
   public ResultVO flexibleProcessBatchAddProduceReport(
      @ApiParam(name = "productTypeEnum", value = "产品类型", required = true) @RequestParam Integer productTypeEnum,
      @ApiParam(name = "processId", value = "工序id", required = true) @RequestParam Long processId,
      @ApiParam(name = "teamId", value = "班组id", required = true) @RequestParam Long teamId,
      @RequestBody List<MesBuildingProduceTeamReportDTOParam> paramList
   ) {
      log.info("API调用: 人工填报-灵活工序批量新增生产记录");
      return ResultBuilder.success(this.biz.flexibleProcessBatchAddProduceReport(productTypeEnum, processId, teamId, paramList));
   }
}
