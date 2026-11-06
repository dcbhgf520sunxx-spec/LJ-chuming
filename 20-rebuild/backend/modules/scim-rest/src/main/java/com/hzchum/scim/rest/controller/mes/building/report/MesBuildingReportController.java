package com.hzchum.scim.rest.controller.mes.building.report;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.pojo._do.qhse.ProduceQhseDo;
import com.hzchum.scim.mes.building.core.api.pojo._do.qhse.ProductLineInspectionDO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceQhseTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES生产上报记录")
@RestController
@RequestMapping("/api/mes/building/report")
public class MesBuildingReportController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingReportController.class);
   @Autowired
   private MesBuildingProduceTeamReportService teamReportService;
   @Autowired
   private MesBuildingProduceQhseTeamReportService qhseTeamReportService;

   @ApiOperation("生产上报记录")
   @GetMapping("/team")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "date", value = "日期", paramType = "query"),
            @ApiImplicitParam(name = "taskId", value = "任务id", paramType = "query"),
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "reportType", value = "上报类型", paramType = "query")
      }
   )
   public ResultVO teamReportList(
      @RequestParam(name = "date", required = false) String date,
      @RequestParam(name = "taskId", required = false) Long taskId,
      @RequestParam(name = "productId", required = false) Long productId,
      @RequestParam(name = "teamId", required = false) Long teamId,
      @RequestParam(name = "productType") Integer taskTypeEnum,
      @RequestParam(name = "reportType", required = false) Integer reportType,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "monomerId", required = false) Long monomerId,
      @RequestParam(name = "areaId", required = false) Long areaId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "productLineId", required = false) Long productLineId,
      @RequestParam(name = "factoryId", required = false) Long factoryId,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize
   ) {
      Preconditions.checkArgument(taskTypeEnum != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：生产上报记录");
      return ResultBuilder.success(
         this.teamReportService
            .pageByCondition(
               date,
               taskId,
               productId,
               taskTypeEnum,
               teamId,
               reportType,
               projectId,
               monomerId,
               areaId,
               workshopId,
               productLineId,
               factoryId,
               serialNumber,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("生产上报待质检记录")
   @GetMapping("/team/un_inspection/page")
   public ResultVO teamReportUnInspectionList(
      @RequestParam(name = "taskTypeEnum") Integer taskTypeEnum,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "monomerId", required = false) Long monomerId,
      @RequestParam(name = "areaId", required = false) Long areaId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "productLineId", required = false) Long productLineId,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize
   ) {
      Preconditions.checkArgument(taskTypeEnum != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：生产上报待质检记录");
      return ResultBuilder.success(
         this.teamReportService
            .unInspectionPageByCondition(taskTypeEnum, projectId, monomerId, areaId, workshopId, productLineId, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("质检上报记录")
   @GetMapping("/inspection_team")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "date", value = "日期", paramType = "query"),
            @ApiImplicitParam(name = "taskId", value = "任务id", paramType = "query"),
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "boolAdoptEnum", value = "上报类型", paramType = "query", type = "boolean", required = true)
      }
   )
   public ResultVO inspectionTeamReportList(
      @RequestParam(name = "date", required = false) String date,
      @RequestParam(name = "taskId", required = false) Long taskId,
      @RequestParam(name = "productId", required = false) Long productId,
      @RequestParam(name = "teamId", required = false) Long teamId,
      @RequestParam(name = "productType") Integer taskTypeEnum,
      @RequestParam(name = "boolAdoptEnum", required = false) Boolean boolAdoptEnum,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "monomerId", required = false) Long monomerId,
      @RequestParam(name = "areaId", required = false) Long areaId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "productLineId", required = false) Long productLineId,
      @RequestParam(name = "factoryId", required = false) Long factoryId,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize
   ) {
      Preconditions.checkArgument(taskTypeEnum != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：质检上报记录");
      return ResultBuilder.success(
         this.teamReportService
            .inspectionPageByCondition(
               date,
               taskId,
               productId,
               teamId,
               taskTypeEnum,
               boolAdoptEnum,
               projectId,
               monomerId,
               areaId,
               workshopId,
               productLineId,
               factoryId,
               serialNumber,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("质检上报记录汇总")
   @GetMapping("/inspection/summary/list")
   @PreAuthorize("@permission.check('mes_quality_inspection_report:get')")
   public ResultVO inspectionTeamReportSummary(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      Long projectId,
      @RequestParam(name = "productType") Integer productType
   ) {
      Preconditions.checkArgument(productType != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：质检上报记录汇总");
      return ResultBuilder.success(new ListVO<>(this.qhseTeamReportService.inspectionTeamReportSummary(startDate, endDate, projectId, productType)));
   }

   @ApiOperation("质检上报记录汇总-分页")
   @GetMapping("/inspection/summary/page")
   @PreAuthorize("@permission.check('mes_quality_inspection_report:get')")
   public ResultVO inspectionTeamReportSummaryPage(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "productType") Integer productType,
      Long projectId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      Preconditions.checkArgument(productType != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：质检上报记录汇总-分页");
      return ResultBuilder.success(this.qhseTeamReportService.inspectionTeamReportSummaryPage(startDate, endDate, projectId, productType, pageNumber, pageSize));
   }

   @ApiOperation("质检上报记录汇总详情")
   @GetMapping("/inspection/summary/details/list")
   @PreAuthorize("@permission.check('mes_quality_inspection_report:detail')")
   public ResultVO inspectionTeamReportSummaryDetails(
      Long userId,
      String projectName,
      String serialNumber,
      Long projectId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(name = "productType") Integer productType
   ) {
      Preconditions.checkArgument(productType != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：质检上报记录汇总详情");
      return ResultBuilder.success(
         new ListVO<>(
            this.qhseTeamReportService.inspectionTeamReportSummaryDetails(userId, projectName, serialNumber, projectId, startDate, endDate, productType)
         )
      );
   }

   @ApiOperation("质检上报记录汇总详情-分页")
   @GetMapping("/inspection/summary/details/page")
   @PreAuthorize("@permission.check('mes_quality_inspection_report:detail')")
   public ResultVO inspectionTeamReportSummaryDetails(
      Long userId,
      String projectName,
      String serialNumber,
      Long processId,
      Long projectId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(name = "productType") Integer productType,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      Preconditions.checkArgument(productType != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：质检上报记录汇总详情-分页");
      return ResultBuilder.success(
         this.qhseTeamReportService
            .inspectionTeamReportSummaryDetailsPage(
               userId, projectName, serialNumber, processId, projectId, startDate, endDate, productType, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("质检上报记录汇总详情下载")
   @GetMapping("/inspection/summary/details/print")
   @PreAuthorize("@permission.check('mes_quality_inspection_report:detail')")
   public ResultVO inspectionTeamReportSummaryDetailsPrint(
      Long userId,
      String projectName,
      String serialNumber,
      Long processId,
      Long projectId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer productType,
      HttpServletResponse response
   ) {
      Preconditions.checkArgument(productType != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：质检上报记录汇总详情");
      return ResultBuilder.success(
         this.qhseTeamReportService
            .inspectionTeamReportSummaryDetailsPrint(userId, projectName, serialNumber, processId, projectId, startDate, endDate, productType, response)
      );
   }

   @ApiOperation("质检上报记录汇总详情-相关工序列表")
   @GetMapping("/inspection/summary/details/getprocesslist")
   @PreAuthorize("@permission.check('mes_quality_inspection_report:detail')")
   public ResultVO inspectionTeamReportSummaryDetailsProcessList(
      Long userId,
      String projectName,
      String serialNumber,
      Long projectId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(name = "productType") Integer productType
   ) {
      Preconditions.checkArgument(productType != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：质检上报记录汇总详情-相关工序列表");
      return ResultBuilder.success(
         this.qhseTeamReportService.inspectionTeamReportSummaryProcessList(userId, projectName, serialNumber, projectId, startDate, endDate, productType)
      );
   }

   @ApiOperation("查询构件产线-工序合格率汇总信息")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间"),
            @ApiImplicitParam(name = "pageNumber", value = "页码"),
            @ApiImplicitParam(name = "factoryId", value = "工厂id"),
            @ApiImplicitParam(name = "workshopId", value = "车间id"),
            @ApiImplicitParam(name = "productionLineId", value = "产线id"),
            @ApiImplicitParam(name = "productType", value = "类型"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小")
      }
   )
   @GetMapping("/inspection/summary/passrate")
   @PreAuthorize("@permission.check('mes_production_line_report:get')")
   public ResultVO<List<ProductLineInspectionDO>> productLinePassRate(
      String factoryId,
      String productionLineId,
      Integer productType,
      String workshopId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：查询构件工厂-产线-工序合格率汇总信息");
      return ResultBuilder.success(
         this.qhseTeamReportService.productLinePassRate(factoryId, productionLineId, productType, workshopId, startDate, endDate, pageNumber, pageSize)
      );
   }

   @ApiOperation("查询构件产线-产线不合格的详细信息")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productionLineId", value = "产线id"),
            @ApiImplicitParam(name = "productType", value = "类型"),
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "pageNumber", value = "页码"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小"),
            @ApiImplicitParam(name = "productType", value = "类型"),
            @ApiImplicitParam(name = "endDate", value = "结束时间")
      }
   )
   @GetMapping("/inspection/summary/review")
   @PreAuthorize("@permission.check('mes_production_line_report:detail')")
   public ResultVO<List<ProduceQhseDo>> unQualInformation(
      Long productionLineId,
      Integer productType,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      return ResultBuilder.success(this.qhseTeamReportService.unQualInformation(productionLineId, productType, startDate, endDate, pageNumber, pageSize));
   }

   @ApiOperation("查询构件产线-产线不合格的详细信息")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productionLineId", value = "产线id"),
            @ApiImplicitParam(name = "productType", value = "类型"),
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "pageNumber", value = "页码"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小"),
            @ApiImplicitParam(name = "productType", value = "类型"),
            @ApiImplicitParam(name = "endDate", value = "结束时间")
      }
   )
   @GetMapping("/inspection/summary/review/page")
   @PreAuthorize("@permission.check('mes_production_line_report:detail')")
   public ResultVO<PageVO<ProduceQhseDo>> unQualInformationPage(
      Long productionLineId,
      Integer productType,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      return ResultBuilder.success(this.qhseTeamReportService.unQualInformationPage(productionLineId, productType, startDate, endDate, pageNumber, pageSize));
   }

   @ApiOperation("打印-产线不合格的详细信息")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productionLineId", value = "产线id"),
            @ApiImplicitParam(name = "productType", value = "类型"),
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间")
      }
   )
   @GetMapping("/inspection/summary/review/print")
   @PreAuthorize("@permission.check('mes_production_line_report:print')")
   public ResultVO<PrintVO> unQualInformationualInformationPrint(Long productionLineId, Integer productType, LocalDateTime startDate, LocalDateTime endDate) {
      return ResultBuilder.success(this.qhseTeamReportService.unQualInformationPrint(productionLineId, productType, startDate, endDate));
   }

   @ApiOperation("当前车间对应的工序列表")
   @ApiImplicitParams(@ApiImplicitParam(name = "workshopId", value = "车间id"))
   @GetMapping("/workshop/process/list")
   public ResultVO getWorkshopByProcessList(Long workshopId) {
      return ResultBuilder.success(this.teamReportService.getWorkshopByProcessListV2(workshopId));
   }

   @ApiOperation("班组报表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "workshopId", value = "车间id"),
            @ApiImplicitParam(name = "processId", value = "工序id"),
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间")
      }
   )
   @GetMapping("/product/team/summary/list")
   public ResultVO productTeamSummaryReport(
      Long workshopId,
      Long projectId,
      Long processId,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(required = false, defaultValue = "1") Integer taskReportTypeEnum
   ) {
      return ResultBuilder.success(
         this.teamReportService.productTeamSummaryReportV2(workshopId, projectId, processId, null, taskTypeEnum, startDate, endDate, taskReportTypeEnum)
      );
   }

   @ApiOperation("班组报表下载")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "workshopId", value = "车间id"),
            @ApiImplicitParam(name = "processId", value = "工序id"),
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间")
      }
   )
   @GetMapping("/product/team/summary/download")
   public void productTeamSummaryReportDownload(
      Long workshopId,
      Long projectId,
      Long processId,
      @RequestParam List<Long> teamIds,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(required = false, defaultValue = "1") Integer taskReportTypeEnum,
      HttpServletResponse response
   ) throws IOException {
      this.teamReportService
         .productTeamSummaryReportDownload(workshopId, projectId, processId, teamIds, taskTypeEnum, startDate, endDate, taskReportTypeEnum, response);
   }

   @ApiOperation("班组产量")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "workshopId", value = "车间id"),
            @ApiImplicitParam(name = "projectId", value = "项目id"),
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间")
      }
   )
   @GetMapping("/team/produce/list")
   public ResultVO findEachTeamProduceInfo(Long workshopId, Long projectId, LocalDateTime startDate, LocalDateTime endDate) {
      return ResultBuilder.success(this.teamReportService.findEachTeamProduceInfo(workshopId, projectId, startDate, endDate));
   }

   @ApiOperation("班组产量详情")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "workshopId", value = "车间id"),
            @ApiImplicitParam(name = "projectId", value = "项目id"),
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间")
      }
   )
   @GetMapping("/team/produce/detail")
   public ResultVO findEachTeamProduceDetail(
      Long workshopId, Long projectId, Long monomerId, Long areaId, Long teamId, Long processId, LocalDateTime startDate, LocalDateTime endDate
   ) {
      return ResultBuilder.success(
         this.teamReportService.findEachTeamProduceDetail(workshopId, projectId, monomerId, areaId, teamId, processId, startDate, endDate)
      );
   }

   @ApiOperation("班组产量详情打印")
   @GetMapping("/team/produce/detail/print")
   public ResultVO findEachTeamProduceDetailPrint(
      Long workshopId, Long projectId, Long monomerId, Long areaId, Long teamId, Long processId, LocalDateTime startDate, LocalDateTime endDate
   ) {
      log.info("API 调用 ：班组产量详情打印");
      return ResultBuilder.success(
         this.teamReportService.findEachTeamProduceDetailPrint(workshopId, projectId, monomerId, areaId, teamId, processId, startDate, endDate)
      );
   }

   @ApiOperation("班组能力分析")
   @GetMapping("/capacity_analysis")
   public ResultVO findTeamCapacityAnalysis(
      Long workShopId,
      LocalDateTime date,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：班组能力分析");
      return ResultBuilder.success(this.teamReportService.findTeamCapacityAnalysisV2(workShopId, date, pageNumber, pageSize));
   }

   @ApiOperation("班组能力分析下载")
   @GetMapping("/capacity_analysis/download")
   public void findTeamCapacityAnalysisDownload(Long workShopId, @RequestParam LocalDateTime date) {
      log.info("API 调用 ：班组能力分析下载");
      this.teamReportService.findTeamCapacityAnalysisDownload(workShopId, date);
   }

   @ApiOperation("班组报表详情")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "workshopId", value = "车间id"),
            @ApiImplicitParam(name = "processId", value = "工序id"),
            @ApiImplicitParam(name = "projectId", value = "项目id"),
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间")
      }
   )
   @GetMapping("/product/team/summary/review")
   public ResultVO productTeamSummaryReportDetailPage(
      Long workshopId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long groupsId,
      Long teamId,
      Long processId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      return ResultBuilder.success(
         this.teamReportService
            .productTeamSummaryReportDetailPage(
               workshopId,
               projectId,
               monomerId,
               areaId,
               areaBatchId,
               groupsId,
               teamId,
               processId,
               serialNumber,
               taskTypeEnum,
               startDate,
               endDate,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("班组报表详情V2")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "workshopId", value = "车间id"),
            @ApiImplicitParam(name = "processId", value = "工序id"),
            @ApiImplicitParam(name = "projectId", value = "项目id"),
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间")
      }
   )
   @GetMapping("/product/team/summary/reviewV2")
   public ResultVO productTeamSummaryReportDetailPageV2(
      Long workshopId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long groupsId,
      Long teamId,
      @RequestParam Long processId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(required = false, defaultValue = "1") Integer taskReportTypeEnum,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      return ResultBuilder.success(
         this.teamReportService
            .productTeamSummaryReportDetailPageV2(
               workshopId,
               projectId,
               monomerId,
               areaId,
               areaBatchId,
               groupsId,
               teamId,
               processId,
               serialNumber,
               taskTypeEnum,
               startDate,
               endDate,
               taskReportTypeEnum,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("班组报表详情打印")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "workshopId", value = "车间id"),
            @ApiImplicitParam(name = "processId", value = "工序id"),
            @ApiImplicitParam(name = "projectId", value = "工序id"),
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间")
      }
   )
   @GetMapping("/product/team/summary/review/print")
   public ResultVO productTeamSummaryReportDetailPrint(
      Long workshopId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long groupsId,
      Long teamId,
      Long processId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(required = false, defaultValue = "1") Integer taskReportTypeEnum
   ) {
      return ResultBuilder.success(
         this.teamReportService
            .productTeamSummaryReportDetailPrint(
               workshopId,
               projectId,
               monomerId,
               areaId,
               areaBatchId,
               groupsId,
               teamId,
               processId,
               serialNumber,
               taskTypeEnum,
               startDate,
               endDate,
               taskReportTypeEnum
            )
      );
   }

   @ApiOperation("车间下班组实时信息")
   @ApiImplicitParams(@ApiImplicitParam(name = "workshopId", value = "车间id"))
   @GetMapping("/product/realtime/info")
   public ResultVO productTeamReportRealTimeInfo(Long workshopId) {
      return ResultBuilder.success(this.teamReportService.productTeamReportRealTimeInfo(workshopId));
   }

   @ApiOperation("个人产量统计")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id"),
            @ApiImplicitParam(name = "taskTypeEnum", value = "任务类型"),
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间")
      }
   )
   @GetMapping("/user/production/summary")
   public ResultVO UserProductionSummary(Long projectId, Integer taskTypeEnum, LocalDateTime startDate, LocalDateTime endDate) {
      return ResultBuilder.success(this.teamReportService.UserProductionSummary(projectId, taskTypeEnum, startDate, endDate));
   }

   @ApiOperation("个人产量统计下载")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id"),
            @ApiImplicitParam(name = "taskTypeEnum", value = "任务类型"),
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间")
      }
   )
   @GetMapping("/user/production/summary/download")
   public void UserProductionSummaryDownload(Long projectId, Integer taskTypeEnum, LocalDateTime startDate, LocalDateTime endDate, HttpServletResponse response) {
      this.teamReportService.UserProductionSummaryDownload(projectId, taskTypeEnum, startDate, endDate, response);
   }

   @ApiOperation("个人产量详情")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id"),
            @ApiImplicitParam(name = "monomerId", value = "产品id"),
            @ApiImplicitParam(name = "serialNumber", value = "产品编号"),
            @ApiImplicitParam(name = "taskTypeEnum", value = "任务类型"),
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间"),
            @ApiImplicitParam(name = "userId", value = "用户id")
      }
   )
   @GetMapping("/user/production/detail")
   public ResultVO UserProductionDetailList(
      Long projectId,
      Long monomerId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long userId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      return ResultBuilder.success(
         this.teamReportService.UserProductionDetailList(projectId, monomerId, serialNumber, taskTypeEnum, startDate, endDate, userId, pageNumber, pageSize)
      );
   }

   @ApiOperation("个人产量详情下载")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id"),
            @ApiImplicitParam(name = "monomerId", value = "产品id"),
            @ApiImplicitParam(name = "serialNumber", value = "产品编号"),
            @ApiImplicitParam(name = "taskTypeEnum", value = "任务类型"),
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间"),
            @ApiImplicitParam(name = "userId", value = "用户id")
      }
   )
   @GetMapping("/user/production/detail/download")
   public void UserProductionDetailDownload(
      Long projectId,
      Long monomerId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long userId,
      HttpServletResponse response
   ) {
      this.teamReportService.UserProductionDetailDownload(projectId, monomerId, serialNumber, taskTypeEnum, startDate, endDate, userId, response);
   }
}
