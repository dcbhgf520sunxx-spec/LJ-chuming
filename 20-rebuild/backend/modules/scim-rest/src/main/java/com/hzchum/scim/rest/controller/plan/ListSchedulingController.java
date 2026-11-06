package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.plan.core.api.biz.production_scheduling.ListSchedulingBiz;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.production_scheduling.ListSchedulingSaveParam;
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

@Api(tags = "计划管理-生产排期-清单排期")
@RequestMapping("/api/plan/production-scheduling/list-scheduling")
@RestController
public class ListSchedulingController {
   private static final Logger log = LoggerFactory.getLogger(ListSchedulingController.class);
   @Autowired
   private ListSchedulingBiz listSchedulingBiz;

   @ApiOperation("项目排期列表")
   @GetMapping("project-list")
   public ResultVO projectList(
      @RequestParam Integer year,
      @RequestParam(required = false) Integer schedulingStatus,
      @RequestParam(required = false) Long projectNoOrName,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false, defaultValue = "schedulingStatus.asc") List<String> sort
   ) {
      log.info("API调用: 清单排期-项目排期列表");
      return ResultBuilder.success(this.listSchedulingBiz.projectList(year, schedulingStatus, projectNoOrName, pageNumber, pageSize, sort));
   }

   @ApiOperation("车间排期列表")
   @GetMapping("workshop-list")
   public ResultVO workshopList(@RequestParam Long projectId) {
      log.info("API调用: 清单排期-车间排期列表");
      return ResultBuilder.success(new ListVO<>(this.listSchedulingBiz.workshopList(projectId)));
   }

   @ApiOperation("车间排期明细")
   @GetMapping("workshop-scheduling-detail-page")
   public ResultVO workshopSchedulingDetailPage(
      @RequestParam Long projectId,
      @ApiParam(value = "生产方式(0: 自制, 1: 外包)", required = true) @RequestParam Integer productionWay,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) Boolean boolScheduling,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 清单排期-车间排期明细");
      return ResultBuilder.success(
         this.listSchedulingBiz.workshopSchedulingDetailPage(projectId, productionWay, workshopId, boolScheduling, pageNumber, pageSize, sort)
      );
   }

   @ApiOperation("未排期清单")
   @GetMapping("not-scheduling-list")
   public ResultVO notSchedulingList(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long artifactClassId,
      @RequestParam(required = false) Long artifactNoOrName,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 清单排期-未排期清单");
      return ResultBuilder.success(
         this.listSchedulingBiz.notSchedulingList(projectId, monomerId, areaId, artifactClassId, artifactNoOrName, pageNumber, pageSize, sort)
      );
   }

   @ApiOperation("批量保存")
   @PostMapping("batch-save")
   public ResultVO batchSave(@RequestBody ValidList<ListSchedulingSaveParam> params) {
      log.info("API调用: 清单排期-批量保存");
      return ResultBuilder.success(this.listSchedulingBiz.batchSave(params));
   }

   @ApiOperation("转产操作")
   @PostMapping("change-production-operation")
   public ResultVO beforehandSchedulingBatchUpdate(@RequestBody ValidList<ListSchedulingSaveParam> params) {
      log.info("API调用: 清单排期-转产操作");
      return ResultBuilder.success(this.listSchedulingBiz.beforehandSchedulingBatchUpdate(params));
   }
}
