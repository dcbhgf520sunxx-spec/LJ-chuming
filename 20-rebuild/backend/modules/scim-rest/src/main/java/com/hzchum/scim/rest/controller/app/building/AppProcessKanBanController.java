package com.hzchum.scim.rest.controller.app.building;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.AverageTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.ProcessKanBanOverdueOverDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.ProcessKanBanQhseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.ProcessKanBanSummaryDTO;
import com.hzchum.scim.mes.building.core.api.service.app.ProcessKanBanBiz;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-工序看板")
@RestController
@RequestMapping("/api/app/process/kanban")
public class AppProcessKanBanController {
   private static final Logger log = LoggerFactory.getLogger(AppProcessKanBanController.class);
   @Resource
   private ProcessKanBanBiz processKanBanBiz;

   @ApiOperation("工序看板汇总")
   @GetMapping("/summary")
   public ResultVO<ProcessKanBanSummaryDTO> getProcessKanBanSummary(LocalDateTime year, Long processId) {
      log.info("API 调用 ：工序看板汇总");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未获取到用户信息,查询失败!");
      return ResultBuilder.success(this.processKanBanBiz.getProcessKanBanSummary(year, processId, user.getId()));
   }

   @ApiOperation("月度产量分析")
   @GetMapping("/monthly/output")
   public ResultVO<Map<Integer, Integer>> getMonthlyOutputByYear(LocalDateTime year, Long processId) {
      log.info("API 调用 ：月度产量分析");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未获取到用户信息,查询失败!");
      return ResultBuilder.success(this.processKanBanBiz.getMonthlyOutputByYear(year, processId, user.getId()));
   }

   @ApiOperation("质量事件统计")
   @GetMapping("/qhse/count")
   public ResultVO<Map<Integer, Integer>> getQhseCountByYear(LocalDateTime year, Long processId) {
      log.info("API 调用 ：质量事件统计");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未获取到用户信息,查询失败!");
      return ResultBuilder.success(this.processKanBanBiz.getQhseCountByYear(year, processId, user.getId()));
   }

   @ApiOperation("质量事件分析")
   @GetMapping("/qhse/analyse")
   public ResultVO<List<ProcessKanBanQhseDTO>> getQhseAnalyseByYear(LocalDateTime year, Long processId) {
      log.info("API 调用 ：质量事件分析");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未获取到用户信息,查询失败!");
      return ResultBuilder.success(this.processKanBanBiz.getQhseAnalyseByYear(year, processId, user.getId()));
   }

   @ApiOperation("平均任务达成率")
   @GetMapping("/task/completion/rate")
   public ResultVO<AverageTaskDTO> getAverageTaskCompletionRate(LocalDateTime year, Long processId) {
      log.info("API 调用 ：平均任务达成率");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未获取到用户信息,查询失败!");
      return ResultBuilder.success(this.processKanBanBiz.getAverageTaskCompletionRate(year, processId, user.getId()));
   }

   @ApiOperation("逾期工单")
   @GetMapping("/overdue/order")
   public ResultVO<ProcessKanBanOverdueOverDTO> getOverdueOrderInfo(Long processId) {
      log.info("API 调用 ：逾期工单");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未获取到用户信息,查询失败!");
      return ResultBuilder.success(this.processKanBanBiz.getOverdueOrderInfo(processId, user.getId()));
   }
}
