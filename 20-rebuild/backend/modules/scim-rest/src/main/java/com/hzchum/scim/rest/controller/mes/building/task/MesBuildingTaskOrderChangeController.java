package com.hzchum.scim.rest.controller.mes.building.task;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderChangeBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.post.TaskChangeDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.task.post.NestTaskChangeRequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.task.post.TaskChangeRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES-任务工单变更")
@RestController
@RequestMapping("/api/mes/building/task/change")
public class MesBuildingTaskOrderChangeController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingTaskOrderChangeController.class);
   @Autowired
   private MesBuildingTaskOrderChangeBiz changeBiz;

   @ApiOperation("可变更的任务工单列表")
   @GetMapping("/task_order/page")
   @PreAuthorize("@permission.check('mes_production_line_assistance:get')")
   public ResultVO getTaskOrderPage(
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "taskTypeEnum") Integer taskTypeEnum,
      @RequestParam(name = "dateTime", required = false) LocalDateTime dateTime,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：可变更的任务工单列表");
      return ResultBuilder.success(this.changeBiz.getTaskOrderPage(projectId, taskTypeEnum, dateTime, pageNumber, pageSize));
   }

   @ApiOperation("可变更的任务工单详情列表")
   @GetMapping("/task_order/{taskOrderId}/list")
   public ResultVO getTaskOrderDetailsList(
      @PathVariable("taskOrderId") Long taskOrderId,
      @RequestParam(name = "areaId", required = false) Long areaId,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "specification", required = false) String specification
   ) {
      log.info("API 调用 ：可变更的任务工单列表");
      return ResultBuilder.success(new ListVO<>(this.changeBiz.getTaskOrderDetailsList(taskOrderId, areaId, serialNumber, specification)));
   }

   @ApiOperation("变更的任务工单")
   @PostMapping("")
   @PreAuthorize("@permission.check('mes_production_line_assistance:save')")
   public ResultVO taskChange(@RequestBody @Validated List<TaskChangeRequest> requestList) {
      log.info("API 调用 ：变更的任务工单");
      return ResultBuilder.success(
         this.changeBiz.taskChange(requestList.stream().map(e -> BeanUtil.copy(e, TaskChangeDTOParam.class)).collect(Collectors.toList()))
      );
   }

   @ApiOperation("变更的切割任务")
   @PostMapping("/nest")
   @PreAuthorize("@permission.check('mes_production_line_assistance:save')")
   public ResultVO nestTaskChange(@RequestBody List<NestTaskChangeRequest> requestList) {
      log.info("API 调用 ：变更的切割任务");
      return ResultBuilder.success(
         this.changeBiz.nestTaskChange(requestList.stream().map(e -> BeanUtil.copy(e, TaskChangeDTOParam.class)).collect(Collectors.toList()))
      );
   }

   @ApiOperation("获取变更记录-分页")
   @GetMapping("/page")
   @PreAuthorize("@permission.check('mes_production_line_assistance:get')")
   public ResultVO getChangePage(
      @RequestParam(name = "userName", required = false) String userName,
      @RequestParam(name = "taskTypeEnum", defaultValue = "1") Integer taskTypeEnum,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：获取变更记录-分页");
      return ResultBuilder.success(this.changeBiz.getChangePage(userName, taskTypeEnum, pageNumber, pageSize));
   }

   @ApiOperation("获取变更记录详情-列表")
   @GetMapping("/{changeId}/details/list")
   public ResultVO getChangeDetailsList(@PathVariable(name = "changeId") Long changeId) {
      log.info("API 调用 ：获取变更记录详情-列表");
      return ResultBuilder.success(this.changeBiz.getChangeDetailsList(changeId));
   }
}
