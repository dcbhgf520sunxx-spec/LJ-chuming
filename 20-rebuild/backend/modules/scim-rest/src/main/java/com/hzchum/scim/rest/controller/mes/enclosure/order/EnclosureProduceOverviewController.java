package com.hzchum.scim.rest.controller.mes.enclosure.order;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.CategoryProduceAnalysisDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.PlateProduceAnalysisDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.TeamProduceDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.TeamProduceDetailDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.WorkshopMonthAndMeteDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.WorkshopSummaryDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "生产报表-围护")
@RestController
@RequestMapping("/api/mes/enclosure/produce/overview")
public class EnclosureProduceOverviewController {
   private static final Logger log = LoggerFactory.getLogger(EnclosureProduceOverviewController.class);
   @Resource
   private MesEnclosureTaskBiz taskBiz;

   @ApiOperation("任务跟踪查询项目下的工单生产情况(围护)")
   @GetMapping("/order/list")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "dateTime", value = "年份"),
            @ApiImplicitParam(name = "type", value = "时间类型 1:当年 2:当月"),
            @ApiImplicitParam(name = "category", value = "围护类型")
      }
   )
   @PreAuthorize("@permission.check('enclosure_production_statistics:get')")
   public ResultVO<List<WorkshopMonthAndMeteDTO>> getYearList(LocalDateTime time, Integer type, Integer category) {
      log.info("API 调用 ：任务跟踪查询项目下的工单生产情况(围护)");
      return ResultBuilder.success(this.taskBiz.getYearList(time, type, category));
   }

   @ApiOperation("任务跟踪查询项目下的工单生产情况(围护)")
   @GetMapping("/v2/order/list")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "dateTime", value = "年份"),
            @ApiImplicitParam(name = "type", value = "时间类型 1:当年 2:当月"),
            @ApiImplicitParam(name = "dictionaryId", value = "围护类型字典id")
      }
   )
   @PreAuthorize("@permission.check('enclosure_production_statistics:get')")
   public ResultVO<List<WorkshopMonthAndMeteDTO>> getYearListV2(LocalDateTime time, Integer type, Integer dictionaryId) {
      log.info("API 调用 ：任务跟踪查询项目下的工单生产情况(围护)");
      return ResultBuilder.success(this.taskBiz.getYearListV2(time, type, dictionaryId));
   }

   @ApiOperation("点击柱状图查询详情 (围护)")
   @GetMapping("/order/detail")
   @PreAuthorize("@permission.check('enclosure_production_statistics:get')")
   public ResultVO<PageVO<WorkshopSummaryDTO>> getOverviewDetail(
      LocalDateTime startTime,
      LocalDateTime endTime,
      Long projectId,
      Integer category,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：点击柱状图查询详情(围护)");
      return ResultBuilder.success(this.taskBiz.getOverviewDetail(startTime, endTime, projectId, category, pageNumber, pageSize));
   }

   @ApiOperation("点击柱状图查询详情 (围护)")
   @GetMapping("/v2/order/detail")
   @PreAuthorize("@permission.check('enclosure_production_statistics:get')")
   public ResultVO<PageVO<WorkshopSummaryDTO>> getOverviewDetailV2(
      LocalDateTime startTime,
      LocalDateTime endTime,
      Long projectId,
      Long dictionaryId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：点击柱状图查询详情(围护)");
      return ResultBuilder.success(this.taskBiz.getOverviewDetailV2(startTime, endTime, projectId, dictionaryId, pageNumber, pageSize));
   }

   @ApiOperation("打印柱状图查询详情 (围护)")
   @GetMapping("/order/detail/print")
   @PreAuthorize("@permission.check('enclosure_production_statistics:print')")
   public ResultVO<PrintVO<List<Map<String, Object>>>> getOverviewDetailPrint(LocalDateTime startTime, LocalDateTime endTime, Long projectId, Integer category) {
      log.info("API 调用 ：打印柱状图查询详情(围护)");
      return ResultBuilder.success(this.taskBiz.getOverviewDetailPrint(startTime, endTime, projectId, category));
   }

   @ApiOperation("(新)打印柱状图查询详情 (围护)")
   @GetMapping("/v2/order/detail/print")
   @PreAuthorize("@permission.check('enclosure_production_statistics:print')")
   public ResultVO<PrintVO<List<Map<String, Object>>>> getOverviewDetailPrintV2(
      LocalDateTime startTime, LocalDateTime endTime, Long projectId, Long dictionaryId
   ) {
      log.info("API 调用 ：(新)打印柱状图查询详情(围护)");
      return ResultBuilder.success(this.taskBiz.getOverviewDetailPrintV2(startTime, endTime, projectId, dictionaryId));
   }

   @ApiOperation("任务跟踪全年累计产量汇总 (围护)")
   @GetMapping("/order/total")
   @PreAuthorize("@permission.check('enclosure_production_statistics:get')")
   public ResultVO<BigDecimal> getOverviewTotal(
      @RequestParam(name = "time", required = false) LocalDateTime time, @RequestParam(name = "category", required = false) Integer category
   ) {
      log.info("API 调用 ：任务跟踪全年累计产量汇总(围护)");
      return ResultBuilder.success(this.taskBiz.getOverviewTotal(time, category));
   }

   @ApiOperation("(新)任务跟踪全年累计产量汇总 (围护)")
   @GetMapping("/v2/order/total")
   @PreAuthorize("@permission.check('enclosure_production_statistics:get')")
   public ResultVO<BigDecimal> getOverviewTotalV2(
      @RequestParam(name = "time", required = false) LocalDateTime time, @RequestParam(name = "dictionaryId", required = false) Integer dictionaryId
   ) {
      log.info("API 调用 ：任务跟踪全年累计产量汇总(围护)");
      return ResultBuilder.success(this.taskBiz.getOverviewTotalV2(time, dictionaryId));
   }

   @ApiOperation("班组产量统计 (围护)")
   @GetMapping("/order/team/produce")
   @PreAuthorize("@permission.check('enclosure_team_production:get')")
   public ResultVO<PageVO<TeamProduceDTO>> getTeamProduce(
      @RequestParam(name = "startTime", required = false) LocalDateTime startTime,
      @RequestParam(name = "endTime", required = false) LocalDateTime endTime,
      Long projectId,
      @RequestParam(name = "category", required = false) LocalDateTime category,
      @RequestParam(required = false, defaultValue = "8") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：班组产量统计(围护)");
      return ResultBuilder.success(this.taskBiz.getTeamProduce(startTime, endTime, projectId, category, projectType, lumpSumSystemType, pageNumber, pageSize));
   }

   @ApiOperation("班组产量统计打印 (围护)")
   @GetMapping("/order/team/produce/print")
   @PreAuthorize("@permission.check('enclosure_team_production:print')")
   public ResultVO<PrintVO<List<Map<String, Object>>>> getTeamProducePrint(
      @RequestParam(name = "startTime", required = false) LocalDateTime startTime,
      @RequestParam(name = "endTime", required = false) LocalDateTime endTime,
      Long projectId,
      @RequestParam(name = "category", required = false) LocalDateTime category,
      @RequestParam(required = false, defaultValue = "8") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType
   ) {
      log.info("API 调用 ：班组产量统计(围护)");
      return ResultBuilder.success(this.taskBiz.getTeamProducePrint(startTime, endTime, projectId, category, projectType, lumpSumSystemType));
   }

   @ApiOperation("班组产量统计查询详细信息 (围护)")
   @GetMapping("/order/team/produce/detail")
   @PreAuthorize("@permission.check('enclosure_team_production:detail')")
   public ResultVO<PageVO<TeamProduceDetailDTO>> getTeamProduceDetail(
      @RequestParam(name = "startTime", required = false) LocalDateTime startTime,
      @RequestParam(name = "endTime", required = false) LocalDateTime endTime,
      Long projectId,
      Long teamId,
      Long lineId,
      @RequestParam(name = "price") BigDecimal price,
      @RequestParam(name = "category", required = false) LocalDateTime category,
      @RequestParam(required = false, defaultValue = "8") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：班组产量统计查询详细信息(围护)");
      return ResultBuilder.success(
         this.taskBiz
            .getTeamProduceDetail(startTime, endTime, price, projectId, teamId, lineId, category, projectType, lumpSumSystemType, pageNumber, pageSize)
      );
   }

   @ApiOperation("班组产量统计查询详细信息打印 (围护)")
   @GetMapping("/order/team/produce/detail/print")
   @PreAuthorize("@permission.check('enclosure_team_production:printDetail')")
   public ResultVO<PrintVO<List<Map<String, Object>>>> getTeamProduceDetailPrint(
      @RequestParam(name = "startTime", required = false) LocalDateTime startTime,
      @RequestParam(name = "endTime", required = false) LocalDateTime endTime,
      Long projectId,
      Long teamId,
      Long lineId,
      @RequestParam(name = "price") BigDecimal price,
      @RequestParam(name = "category", required = false) LocalDateTime category,
      @RequestParam(required = false, defaultValue = "8") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType
   ) {
      log.info("API 调用 ：班组产量统计查询详细信息(围护)");
      return ResultBuilder.success(
         this.taskBiz.getTeamProduceDetailPrint(startTime, endTime, price, projectId, teamId, lineId, category, projectType, lumpSumSystemType)
      );
   }

   @ApiOperation("生产报表类型分析 (围护)")
   @GetMapping("/order/category/produce/analysis")
   @PreAuthorize("@permission.check('enclosure_type_analysis:get')")
   public ResultVO<List<CategoryProduceAnalysisDTO>> produceAnalysis(
      @RequestParam(name = "startTime", required = false) LocalDateTime startTime,
      @RequestParam(name = "endTime", required = false) LocalDateTime endTime,
      Long projectId
   ) {
      log.info("API 调用 ：生产报表类型分析(围护)");
      return ResultBuilder.success(this.taskBiz.produceAnalysis(startTime, endTime, projectId));
   }

   @ApiOperation("生产报表版型分析 (围护)")
   @GetMapping("/order/plate/produce/analysis")
   @PreAuthorize("@permission.check('enclosure_type_analysis:get')")
   public ResultVO<List<PlateProduceAnalysisDTO>> plateAnalysis(
      @RequestParam(name = "startTime", required = false) LocalDateTime startTime,
      @RequestParam(name = "endTime", required = false) LocalDateTime endTime,
      Long projectId,
      Integer category
   ) {
      log.info("API 调用 ：生产报表版型分析(围护)");
      return ResultBuilder.success(this.taskBiz.plateAnalysis(startTime, endTime, projectId, category));
   }
}
