package com.hzchum.scim.rest.controller.mes.building.wage_manage;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.mes.building.core.api.biz.wage_manage.MesProductionWageBiz;
import com.hzchum.scim.mes.building.core.api.biz.wage_manage.MesYieldConfirmBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesProductionWageSaveParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "生产工资管理-产量确认")
@RequestMapping("/api/mes/building/production-wage-manage/yield-confirm")
@RestController
public class MesYieldConfirmController {
   private static final Logger log = LoggerFactory.getLogger(MesYieldConfirmController.class);
   @Autowired
   private MesYieldConfirmBiz yieldConfirmBiz;
   @Autowired
   private MesProductionWageBiz productionWageBiz;

   @ApiOperation("产量确认-未审核车间工序班组列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "workshopId", value = "车间ID", paramType = "query"),
            @ApiImplicitParam(name = "yearMonthDaySelect", value = "年月日选择(1: 今日, 2: 本月, 3: 全年)", defaultValue = "1", required = true, paramType = "query"),
            @ApiImplicitParam(name = "selectedDate", value = "已选日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "processId", value = "工序ID", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", defaultValue = "1", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", defaultValue = "20", paramType = "query")
      }
   )
   @GetMapping("unaudited-workshop-process-team-list")
   public ResultVO unauditedWorkshopProcessTeamList(
      @RequestParam(required = false) Long workshopId,
      @RequestParam Integer yearMonthDaySelect,
      @RequestParam LocalDateTime selectedDate,
      @RequestParam(required = false) Long processId,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize
   ) {
      log.info("API 调用 ：产量确认-未审核车间工序班组列表");
      return ResultBuilder.success(
         this.yieldConfirmBiz.unauditedWorkshopProcessTeamList(workshopId, yearMonthDaySelect, selectedDate, processId, pageNumber, pageSize)
      );
   }

   @ApiOperation("产量确认-未审核列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "workshopId", value = "车间ID", required = true, paramType = "query"),
            @ApiImplicitParam(name = "processId", value = "工序ID", required = true, paramType = "query"),
            @ApiImplicitParam(name = "teamLeaderName", value = "班组长名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型(ProductTypeEnum)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "yearMonthDaySelect", value = "年月日选择(1: 今日, 2: 本月, 3: 全年)", defaultValue = "1", required = true, paramType = "query"),
            @ApiImplicitParam(name = "selectedDate", value = "已选日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "projectName", value = "项目名称", paramType = "query"),
            @ApiImplicitParam(name = "productSerialNumber", value = "产品编码", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", defaultValue = "1", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", defaultValue = "20", paramType = "query")
      }
   )
   @GetMapping("unaudited-list")
   public ResultVO unauditedList(
      @RequestParam Long workshopId,
      @RequestParam Long processId,
      @RequestParam String teamLeaderName,
      @RequestParam Integer productType,
      @RequestParam Integer yearMonthDaySelect,
      @RequestParam LocalDateTime selectedDate,
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false) String productSerialNumber,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(name = "sort[]", required = false) List<String> sort
   ) {
      log.info("API 调用 ：产量确认-未审核列表");
      return ResultBuilder.success(
         this.yieldConfirmBiz
            .unauditedList(
               workshopId,
               processId,
               teamLeaderName,
               productType,
               yearMonthDaySelect,
               selectedDate,
               projectName,
               productSerialNumber,
               pageNumber,
               pageSize,
               sort
            )
      );
   }

   @ApiOperation("产量确认-通过")
   @PostMapping("approve")
   public ResultVO approve(@RequestBody @Validated(Update.class) ValidList<MesProductionWageSaveParam> saveDTOParamList) {
      log.info("API 调用 ：产量确认-批量新增");
      return ResultBuilder.success(this.productionWageBiz.approve(saveDTOParamList));
   }

   @ApiOperation("已审核车间工序班组工资报表打印")
   @GetMapping("/audited-workshop-process-team-list/print")
   @PreAuthorize("@permission.check('mes_yield_confirm_audited_list:print')")
   public ResultVO auditedWorkshopProcessTeamListPrint(@RequestParam(required = false) Integer statisticsModeEnum,
      @RequestParam(required = false) Long workshopId, @RequestParam(required = false) LocalDateTime selectedDate) {
      com.google.common.base.Preconditions.checkArgument(statisticsModeEnum != null, "统计模式不能为空");
      return ResultBuilder.success(this.yieldConfirmBiz.auditedWorkshopProcessTeamListPrint(statisticsModeEnum, workshopId, selectedDate));
   }

   @ApiOperation("分摊报表")
   @GetMapping("apportion-report")
   public ResultVO apportionReport(@RequestParam Integer year, @RequestParam(required = false) Long workshopId) {
      log.info("API 调用 ：分摊报表");
      return ResultBuilder.success(new ListVO<>(this.yieldConfirmBiz.apportionReport(year, workshopId)));
   }

   @ApiOperation("分摊报表打印下载")
   @GetMapping("apportion-report/print")
   public ResultVO apportionReportPrint(@RequestParam Integer year, @RequestParam(required = false) Long workshopId) {
      log.info("API 调用 ：分摊报表");
      return ResultBuilder.success(this.yieldConfirmBiz.apportionReportPrint(year, workshopId));
   }
}
