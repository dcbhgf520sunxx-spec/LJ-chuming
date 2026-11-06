package com.hzchum.scim.rest.controller.mes.building.report.app;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.pojo._do.qhse.ProduceQhseDo;
import com.hzchum.scim.mes.building.core.api.pojo._do.qhse.ProductLineInspectionDO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ReportRecordV2DTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceQhseTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES生产上报记录")
@RestController
@RequestMapping("/api/app/mes/building/report")
public class AppReportController {
   private static final Logger log = LoggerFactory.getLogger(AppReportController.class);
   @Autowired
   private MesBuildingTaskBiz taskBiz;
   @Autowired
   private MesBuildingProduceTeamReportService teamReportService;
   @Autowired
   private MesBuildingProduceQhseTeamReportService qhseTeamReportService;

   @ApiOperation("生产上报记录")
   @GetMapping("/team")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间"),
            @ApiImplicitParam(name = "taskId", value = "任务id", paramType = "query"),
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query"),
            @ApiImplicitParam(name = "boolAll", value = "是否查询所有数据"),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "reportType", value = "上报类型", paramType = "query")
      }
   )
   @PreAuthorize(
      "@permission.check('artifactCoordination','assembleCoordination','artifactManufacture','assembleManufacture','artifactCoordinationAV2','assembleCoordinationAV2','artifactManufactureAV2','assembleManufactureAV2','assembleExamineAV2')"
   )
   public ResultVO teamReportList(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "taskId", required = false) Long taskId,
      @RequestParam(name = "processId", required = false) Long processId,
      Long productId,
      @RequestParam(name = "taskProcessId", required = false) Long taskProcessId,
      @RequestParam(name = "teamId", required = false) Long teamId,
      @RequestParam(name = "taskTypeEnum") Integer taskTypeEnum,
      @RequestParam(name = "reportType", required = false) Integer reportType,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "monomerId", required = false) Long monomerId,
      @RequestParam(name = "areaId", required = false) Long areaId,
      @RequestParam(name = "areaBatchId", required = false) Long areaBatchId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "productLineId", required = false) Long productLineId,
      @RequestParam(name = "factoryId", required = false) Long factoryId,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      Boolean boolAll,
      @RequestParam(name = "isCurrentUser", required = false, defaultValue = "0") Boolean isCurrentUser,
      @RequestParam(name = "boolMarked", required = false) Boolean boolMarked,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      Preconditions.checkArgument(taskTypeEnum != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：生产上报记录");
      return ResultBuilder.success(
         this.teamReportService
            .pageByConditionByDate(
               startDate,
               endDate,
               taskId,
               processId,
               productId,
               taskTypeEnum,
               teamId,
               reportType,
               projectId,
               monomerId,
               areaId,
               areaBatchId,
               workshopId,
               productLineId,
               factoryId,
               serialNumber,
               boolAll,
               isCurrentUser,
               boolMarked,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("质检页面获取任务下的生产上报记录_一物一码定制")
   @GetMapping("/team/un_inspect/reports")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间"),
            @ApiImplicitParam(name = "taskId", value = "任务id", paramType = "query"),
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query"),
            @ApiImplicitParam(name = "boolAll", value = "是否查询所有数据"),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "reportType", value = "上报类型", paramType = "query")
      }
   )
   public ResultVO<PageVO<ReportRecordV2DTO>> teamReportListV2(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "taskId", required = false) Long taskId,
      @RequestParam(name = "processId", required = false) Long processId,
      @RequestParam(name = "productId", required = false) Long productId,
      @RequestParam(name = "taskProcessId", required = true) Long taskProcessId,
      @RequestParam(name = "groupId", required = false) Long groupId,
      @RequestParam(name = "teamId", required = false) Long teamId,
      @RequestParam(name = "taskTypeEnum", required = false) Integer taskTypeEnum,
      @RequestParam(name = "reportType", required = false) Integer reportType,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "monomerId", required = false) Long monomerId,
      @RequestParam(name = "areaId", required = false) Long areaId,
      @RequestParam(name = "areaBatchId", required = false) Long areaBatchId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "productLineId", required = false) Long productLineId,
      @RequestParam(name = "factoryId", required = false) Long factoryId,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "boolAll", required = false) Boolean boolAll,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：质检页面获取任务下的生产上报记录_一物一码定制");
      return ResultBuilder.success(
         this.teamReportService
            .pageByConditionByDateV3(
               startDate,
               endDate,
               taskId,
               taskProcessId,
               processId,
               productId,
               taskTypeEnum,
               groupId,
               teamId,
               reportType,
               projectId,
               monomerId,
               areaId,
               areaBatchId,
               workshopId,
               productLineId,
               factoryId,
               serialNumber,
               boolAll,
               false,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("生产上报记录详情")
   @GetMapping("/{id}/details")
   public ResultVO teamReportDetailList(@PathVariable("id") Long id) {
      log.info("API 调用 ：生产上报记录详情");
      return ResultBuilder.success(this.teamReportService.teamReportDetailList(id));
   }

   @ApiOperation("钢板生产上报记录")
   @GetMapping("/team/nest_cut_plate")
   public ResultVO pageTeamReportNestCutPlateList(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "processType", required = false) Integer processType,
      @RequestParam(name = "taskTypeEnum") Integer taskTypeEnum,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      Preconditions.checkArgument(taskTypeEnum != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：生产上报记录");
      return ResultBuilder.success(this.teamReportService.pageTeamReportNestCutPlateList(startDate, endDate, taskTypeEnum, processType, pageNumber, pageSize));
   }

   @ApiOperation("零件生产上报记录")
   @GetMapping("/team/machine_part")
   public ResultVO pageTeamReportMachinePartList(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "processType", required = false) Integer processType,
      @RequestParam(name = "taskTypeEnum") Integer taskTypeEnum,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "cutId") Long cutId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      Preconditions.checkArgument(taskTypeEnum != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：生产上报记录");
      return ResultBuilder.success(
         this.teamReportService
            .pageTeamReportMachinePartList(startDate, endDate, taskTypeEnum, processType, serialNumber, projectId, cutId, pageNumber, pageSize)
      );
   }

   @ApiOperation("零件生产上报记录汇总")
   @GetMapping("/team/machine_part/summary")
   public ResultVO teamReportMachinePartListSummary(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "processType", required = false) Integer processType,
      @RequestParam(name = "taskTypeEnum") Integer taskTypeEnum,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "cutId") Long cutId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      Preconditions.checkArgument(taskTypeEnum != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：生产上报记录汇总");
      return ResultBuilder.success(
         this.teamReportService
            .teamReportMachinePartListSummary(startDate, endDate, taskTypeEnum, processType, serialNumber, projectId, cutId, pageNumber, pageSize)
      );
   }

   @ApiOperation("生产上报记录汇总")
   @GetMapping("/team/summary")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间"),
            @ApiImplicitParam(name = "taskId", value = "任务id", paramType = "query"),
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "reportType", value = "上报类型", paramType = "query")
      }
   )
   @PreAuthorize(
      "@permission.check('artifactCoordination','assembleCoordination','artifactManufacture','assembleManufacture','artifactCoordinationAV2','assembleCoordinationAV2','artifactManufactureAV2','assembleManufactureAV2')"
   )
   public ResultVO teamReportListSummary(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "taskId", required = false) Long taskId,
      @RequestParam(name = "processId", required = false) Long processId,
      Long productId,
      @RequestParam(name = "teamId", required = false) Long teamId,
      @RequestParam(name = "taskTypeEnum") Integer taskTypeEnum,
      @RequestParam(name = "reportType", required = false) Integer reportType,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "monomerId", required = false) Long monomerId,
      @RequestParam(name = "areaId", required = false) Long areaId,
      @RequestParam(name = "areaBatchId", required = false) Long areaBatchId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "productLineId", required = false) Long productLineId,
      @RequestParam(name = "factoryId", required = false) Long factoryId,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "isCurrentUser", required = false, defaultValue = "0") Boolean isCurrentUser,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      Preconditions.checkArgument(taskTypeEnum != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：生产上报记录汇总");
      return ResultBuilder.success(
         this.teamReportService
            .teamReportListSummary(
               startDate,
               endDate,
               taskId,
               processId,
               productId,
               taskTypeEnum,
               teamId,
               reportType,
               projectId,
               monomerId,
               areaId,
               areaBatchId,
               workshopId,
               productLineId,
               factoryId,
               serialNumber,
               isCurrentUser,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("质检上报记录")
   @GetMapping("/inspection_team")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间"),
            @ApiImplicitParam(name = "taskId", value = "任务id", paramType = "query"),
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "boolAdoptEnum", value = "上报类型", paramType = "query", type = "boolean", required = true)
      }
   )
   public ResultVO inspectionTeamReportList(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "taskId", required = false) Long taskId,
      @RequestParam(name = "processId", required = false) Long processId,
      @RequestParam(name = "productId", required = false) Long productId,
      @RequestParam(name = "teamId", required = false) Long teamId,
      @RequestParam(name = "taskTypeEnum") Integer taskTypeEnum,
      @RequestParam(name = "boolAdoptEnum", required = false) Boolean boolAdoptEnum,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "monomerId", required = false) Long monomerId,
      @RequestParam(name = "areaId", required = false) Long areaId,
      @RequestParam(name = "areaBatchId", required = false) Long areaBatchId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "productLineId", required = false) Long productLineId,
      @RequestParam(name = "factoryId", required = false) Long factoryId,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "isCurrentUser", required = false, defaultValue = "0") Boolean isCurrentUser,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize
   ) {
      Preconditions.checkArgument(taskTypeEnum != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：质检上报记录");
      return ResultBuilder.success(
         this.teamReportService
            .inspectionPageByConditionByDate(
               startDate,
               endDate,
               taskId,
               processId,
               productId,
               teamId,
               taskTypeEnum,
               boolAdoptEnum,
               projectId,
               monomerId,
               areaId,
               areaBatchId,
               workshopId,
               productLineId,
               factoryId,
               serialNumber,
               isCurrentUser,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("质检上报记录")
   @GetMapping("/inspection_team/summary")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "startDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间"),
            @ApiImplicitParam(name = "taskId", value = "任务id", paramType = "query"),
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "boolAdoptEnum", value = "上报类型", paramType = "query", type = "boolean", required = true)
      }
   )
   public ResultVO inspectionTeamReportListSummary(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "taskId", required = false) Long taskId,
      @RequestParam(name = "processId", required = false) Long processId,
      @RequestParam(name = "productId", required = false) Long productId,
      @RequestParam(name = "teamId", required = false) Long teamId,
      @RequestParam(name = "taskTypeEnum") Integer taskTypeEnum,
      @RequestParam(name = "boolAdoptEnum", required = false) Boolean boolAdoptEnum,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "monomerId", required = false) Long monomerId,
      @RequestParam(name = "areaId", required = false) Long areaId,
      @RequestParam(name = "areaBatchId", required = false) Long areaBatchId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "productLineId", required = false) Long productLineId,
      @RequestParam(name = "factoryId", required = false) Long factoryId,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "isCurrentUser", required = false, defaultValue = "0") Boolean isCurrentUser,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize
   ) {
      Preconditions.checkArgument(taskTypeEnum != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：质检上报记录");
      return ResultBuilder.success(
         this.teamReportService
            .inspectionTeamReportListSummary(
               startDate,
               endDate,
               taskId,
               processId,
               productId,
               teamId,
               taskTypeEnum,
               boolAdoptEnum,
               projectId,
               monomerId,
               areaId,
               areaBatchId,
               workshopId,
               productLineId,
               factoryId,
               serialNumber,
               isCurrentUser,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("质检上报记录汇总")
   @GetMapping("/inspection/summary/list")
   @PreAuthorize("@permission.check('inspectionSummary')")
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
   public ResultVO inspectionTeamReportSummaryDetails(
      Long userId,
      String projectName,
      String serialNumber,
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
            .inspectionTeamReportSummaryDetailsPage(userId, projectName, serialNumber, null, projectId, startDate, endDate, productType, pageNumber, pageSize)
      );
   }

   @ApiOperation("质检上报记录详情")
   @GetMapping("/inspection/summary/details")
   @PreAuthorize("@permission.check('inspectionSummary')")
   public ResultVO inspectionReportSummaryDetails(
      Long userId,
      String projectName,
      String serialNumber,
      Long projectId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer type,
      @RequestParam(name = "productType") Integer productType
   ) {
      Preconditions.checkArgument(productType != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：质检上报记录详情");
      return ResultBuilder.success(
         new ListVO<>(
            this.qhseTeamReportService.inspectionReportSummaryDetails(userId, projectName, serialNumber, projectId, type, startDate, endDate, productType)
         )
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
   public ResultVO<PrintVO> unQualInformationualInformationPrint(Long productionLineId, Integer productType, LocalDateTime startDate, LocalDateTime endDate) {
      return ResultBuilder.success(this.qhseTeamReportService.unQualInformationPrint(productionLineId, productType, startDate, endDate));
   }

   @ApiOperation("项目筛选条件列表")
   @GetMapping("/condition/project")
   public ResultVO projectConditionList(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "taskId", required = false) Long taskId,
      @RequestParam(name = "processId", required = false) Long processId,
      Long productId,
      @RequestParam(name = "teamId", required = false) Long teamId,
      @RequestParam(name = "taskTypeEnum") Integer taskTypeEnum,
      @RequestParam(name = "reportType", required = false) Integer reportType,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "monomerId", required = false) Long monomerId,
      @RequestParam(name = "areaId", required = false) Long areaId,
      @RequestParam(name = "areaBathId", required = false) Long areaBathId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "productLineId", required = false) Long productLineId,
      @RequestParam(name = "factoryId", required = false) Long factoryId,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      Boolean boolAll
   ) {
      Preconditions.checkArgument(taskTypeEnum != null, "操作失败，产品类型不能为空");
      log.info("API 调用 ：生产上报记录");
      return ResultBuilder.success(
         this.teamReportService
            .projectConditionList(
               startDate,
               endDate,
               taskId,
               processId,
               productId,
               taskTypeEnum,
               teamId,
               reportType,
               projectId,
               monomerId,
               areaId,
               areaBathId,
               workshopId,
               productLineId,
               factoryId,
               serialNumber,
               boolAll
            )
      );
   }

   @ApiOperation("产品打标")
   @PutMapping("/team/marked")
   @SignerCheck(lockKey = "#dto.id", message = "当前上报记录正在打标中,请稍后刷新重试!")
   public ResultVO teamReportMarked(@RequestBody NameInfo dto) {
      log.info("API 调用 ：产品打标");
      return ResultBuilder.success(this.teamReportService.teamReportMarked(dto));
   }
}
