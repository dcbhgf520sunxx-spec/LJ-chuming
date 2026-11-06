package com.hzchum.scim.rest.controller.largeScreen;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.bim.core.api.pojo.vo.BimEngineStatusResponseVO;
import com.hzchum.scim.bim.core.api.service.BimModelCommonService;
import com.hzchum.scim.contract.core.api.pojo.vo.largeScreen.ProjectDataVO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.ResponseVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.artifactWarehouse.ArtifactWarehouseTonVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.artifactWarehouse.TonVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.carGoDetail.RecentlyDespatchVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.manufacturingDeptProduction.WorkShopTonVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.processProductionProgress.ProcessProductionProgressVO;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "大屏接口")
@RestController
@RequestMapping("/api/largeScreen")
public class LargeScreenController {
   private static final Logger log = LoggerFactory.getLogger(LargeScreenController.class);
   private final BimModelCommonService bimModelCommonService;
   private final MesBuildingWarehouseSummaryService mesBuildingWarehouseSummaryService;
   private final PlanMonomerService planMonomerService;
   private final MesBuildingQhseService mesBuildingQhseService;
   private final MesBuildingCargoListService mesBuildingCargoListService;
   private final MesBuildingTaskProcessService mesBuildingTaskProcessService;
   private final MesBuildingCompleteService mesBuildingCompleteService;
   private final ContractProjectService contractProjectService;

   @ApiOperation("获取模型信息")
   @ApiImplicitParams(@ApiImplicitParam(name = "fileId", value = "文件id", paramType = "query"))
   @ApiResponses(@ApiResponse(code = 20000, message = "操作成功", response = BimEngineStatusResponseVO.class))
   @GetMapping("/getModelInfoByFileId")
   public ResultVO<?> getModelInfoByFileId(@RequestParam Long fileId) {
      log.info("API 调用 ：获取模型信息");
      return ResultBuilder.success(this.bimModelCommonService.getModelInfoByFileId(fileId));
   }

   @ApiOperation("获取模型转换状态")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"), @ApiImplicitParam(name = "areaId", value = "区域id", paramType = "query")}
   )
   @GetMapping("/translate")
   public ResultVO translate(@RequestParam Long monomerId, @RequestParam(required = false) Long areaId) {
      log.info("API 调用 ：获取模型转换状态");
      return ResultBuilder.success(this.bimModelCommonService.getTranslate(monomerId, areaId));
   }

   @ApiOperation("年度订单量")
   @GetMapping("/yearOrderTon")
   public ResultVO<?> yearOrderTon() {
      log.info("API 调用 ：年度订单量");
      return ResultBuilder.success(this.planMonomerService.yearOrderTon());
   }

   @ApiOperation("构建出入库分析-存货总量（吨）")
   @GetMapping("/techArtifactWarehouseSummary-stock")
   public ResultVO<?> techArtifactWarehouseSummaryStock() {
      log.info("API 调用 ：构建出入库分析-存货总量（吨）");
      return ResultBuilder.success(this.mesBuildingWarehouseSummaryService.techArtifactWarehouseSummaryStock());
   }

   @ApiOperation("构建出入库分析-目标达成率")
   @GetMapping("/techArtifactWarehouseSummary-rate")
   public ResultVO<?> techArtifactWarehouseSummaryRate() {
      log.info("API 调用 ：构建出入库分析-目标达成率");
      return ResultBuilder.success(this.mesBuildingWarehouseSummaryService.techArtifactWarehouseSummaryRate());
   }

   @ApiOperation("构建出入库分析-出库入库发运")
   @ApiResponses(@ApiResponse(code = 20000, message = "操作成功", response = ArtifactWarehouseTonVO.class))
   @GetMapping("/techArtifactWarehouseSummary-warehouse")
   public ResultVO<?> techArtifactWarehouseSummaryWarehouse() {
      log.info("API 调用 ：构建出入库分析-出库入库发运");
      return ResultBuilder.success(this.mesBuildingWarehouseSummaryService.techArtifactWarehouseSummaryWarehouse());
   }

   @ApiOperation("构建出入库分析-近30天出入库趋势")
   @ApiResponses(@ApiResponse(code = 20000, message = "操作成功", response = TonVO.class))
   @GetMapping("/techArtifactWarehouseSummary-trend")
   public ResultVO<?> techArtifactWarehouseSummaryTrend() {
      log.info("API 调用 ：构建出入库分析-近30天出入库趋势");
      return ResultBuilder.success(this.mesBuildingWarehouseSummaryService.techArtifactWarehouseSummaryTrend());
   }

   @ApiOperation("综合产能")
   @ApiResponses(@ApiResponse(code = 20000, message = "操作成功", response = Map.class))
   @GetMapping("/productionCapacity")
   public ResultVO<?> productionCapacity() {
      log.info("API 调用 ：综合产能");
      return ResultBuilder.success(this.mesBuildingWarehouseSummaryService.productionCapacity());
   }

   @ApiOperation("制造部产量数据-条形统计图")
   @ApiResponses(@ApiResponse(code = 20000, message = "操作成功", response = WorkShopTonVO.class))
   @GetMapping("/manufacturingDeptProduction")
   public ResultVO<?> manufacturingDeptProduction(@RequestParam(required = false) String type) {
      log.info("API 调用 ：制造部产量数据-条形统计图");
      return ResultBuilder.success(this.mesBuildingWarehouseSummaryService.manufacturingDeptProduction(type));
   }

   @ApiOperation("制造部产量数据-当月任务达成率")
   @GetMapping("/manufacturingDeptProduction-rate")
   public ResultVO<?> manufacturingDeptProductionRate() {
      log.info("API 调用 ：制造部产量数据-当月任务达成率");
      return ResultBuilder.success(this.mesBuildingWarehouseSummaryService.manufacturingDeptProductionRate());
   }

   @ApiOperation("构件产量分析")
   @ApiResponses(@ApiResponse(code = 20000, message = "操作成功", response = TonVO.class))
   @GetMapping("/techArtifactProductionAnalysis")
   public ResultVO<?> techArtifactProductionAnalysis(@RequestParam(required = false) String type) {
      log.info("API 调用 ：构件产量分析");
      return ResultBuilder.success(this.mesBuildingWarehouseSummaryService.techArtifactProductionAnalysis(type));
   }

   @ApiOperation("生产质量分析-条形统计图")
   @ApiResponses(@ApiResponse(code = 20000, message = "操作成功", response = ResponseVO.class))
   @GetMapping("/productionQualityAnalysis")
   public ResultVO<?> productionQualityAnalysis(@RequestParam(required = false) String type, @RequestParam(required = false) String projectId) {
      log.info("API 调用 ：生产质量分析-条形统计图");
      return ResultBuilder.success(this.mesBuildingQhseService.productionQualityAnalysis(type, projectId));
   }

   @ApiOperation("生产质量分析-质检一次合格率")
   @GetMapping("/firstPassRateOfQualityInspection")
   public ResultVO<?> firstPassRateOfQualityInspection(@RequestParam(required = false) Long projectId) {
      log.info("API 调用 ：生产质量分析-质检一次合格率");
      return ResultBuilder.success(this.mesBuildingQhseService.firstPassRateOfQualityInspection(projectId));
   }

   @ApiOperation("发运分析-结构发运量及车次")
   @GetMapping("/structureDespatchAndCarNumber")
   public ResultVO<?> structureDespatchAndCarNumber(@RequestParam(required = false) Long projectId) {
      log.info("API 调用 ：发运分析-结构发运量及车次");
      return ResultBuilder.success(this.mesBuildingWarehouseSummaryService.structureDespatchAndCarNumber(projectId));
   }

   @ApiOperation("发车明细-等待装车")
   @GetMapping("/carGoDetail-wait")
   public ResultVO<?> carGoDetailWait() {
      log.info("API 调用 ：发车明细-等待装车");
      return ResultBuilder.success(this.mesBuildingCargoListService.carGoDetailWait());
   }

   @ApiOperation("发车明细-最近发运")
   @ApiResponses(@ApiResponse(code = 20000, message = "操作成功", response = RecentlyDespatchVO.class))
   @GetMapping("/carGoDetail-recentlyDespatch")
   public ResultVO<?> carGoDetailRecentlyDespatch(@RequestParam(required = false) Integer size) {
      log.info("API 调用 ：发车明细-最近发运");
      return ResultBuilder.success(this.mesBuildingCargoListService.carGoDetailRecentlyDespatch(size));
   }

   @ApiOperation("发车明细-今日车次")
   @ApiResponses(@ApiResponse(code = 20000, message = "操作成功", response = RecentlyDespatchVO.class))
   @GetMapping("/carGoDetail-carCount")
   public ResultVO<?> carGoDetailRecentlyCarCount() {
      log.info("API 调用 ：发车明细-今日车次");
      return ResultBuilder.success(this.mesBuildingCargoListService.carGoDetailRecentlyCarCount());
   }

   @ApiOperation("发车明细-今日发运量")
   @ApiResponses(@ApiResponse(code = 20000, message = "操作成功", response = RecentlyDespatchVO.class))
   @GetMapping("/carGoDetail-ton")
   public ResultVO<?> carGoDetailTon() {
      log.info("API 调用 ：发车明细-今日发运量");
      return ResultBuilder.success(this.mesBuildingWarehouseSummaryService.carGoDetailTon());
   }

   @ApiOperation("各制造部工序PK")
   @ApiResponses(@ApiResponse(code = 20000, message = "操作成功", response = ResponseVO.class))
   @GetMapping("/manufacturingDeptProductionProcesses")
   public ResultVO<?> manufacturingDeptProductionProcesses() {
      log.info("API 调用 ：各制造部工序PK");
      return ResultBuilder.success(this.mesBuildingTaskProcessService.manufacturingDeptProductionProcesses());
   }

   @ApiOperation("近7天各制造部人效（吨/工）")
   @ApiResponses(@ApiResponse(code = 20000, message = "操作成功", response = ResponseVO.class))
   @GetMapping("/manufacturingDeptProductionLaborEfficiency")
   public ResultVO<?> manufacturingDeptProductionLaborEfficiency() {
      log.info("API 调用 ：近7天各制造部人效（吨/工）");
      return ResultBuilder.success(this.mesBuildingCompleteService.manufacturingDeptProductionLaborEfficiency());
   }

   @ApiOperation("围护生产概况-饼图")
   @ApiResponses(@ApiResponse(code = 20000, message = "操作成功", response = ResponseVO.class))
   @GetMapping("/overviewOfEnclosureProduction")
   public ResultVO<?> overviewOfEnclosureProduction() {
      log.info("API 调用 ：围护生产概况-饼图");
      return ResultBuilder.success(this.mesBuildingWarehouseSummaryService.overviewOfEnclosureProduction());
   }

   @ApiOperation("围护生产概况-折线图")
   @GetMapping("/overviewOfEnclosureProductionOfMonth")
   public ResultVO<?> overviewOfEnclosureProductionOfMonth() {
      log.info("API 调用 ：围护生产概况-折线图");
      return ResultBuilder.success(this.mesBuildingWarehouseSummaryService.overviewOfEnclosureProductionOfMonth());
   }

   @ApiOperation("发运分析-围护发运量")
   @GetMapping("/trafficVolumeOfEnclosure")
   public ResultVO<?> trafficVolumeOfEnclosure() {
      log.info("API 调用 ：围护生产概况-折线图");
      return ResultBuilder.success(this.mesBuildingWarehouseSummaryService.trafficVolumeOfEnclosure());
   }

   @ApiOperation("项目汇总信息")
   @GetMapping("/projectSummaryInfo")
   public ResultVO<?> projectSummaryInfo() {
      log.info("API 调用 ：项目汇总信息");
      return ResultBuilder.success(this.contractProjectService.projectSummaryInfo());
   }

   @ApiOperation("项目列表")
   @ApiResponses(@ApiResponse(code = 20000, message = "操作成功", response = ProjectDataVO.class))
   @GetMapping("/projectList")
   public ResultVO<?> projectList() {
      log.info("API 调用 ：项目列表");
      return ResultBuilder.success(this.contractProjectService.projectList());
   }

   @ApiOperation("项目信息")
   @GetMapping("/projectInfo")
   public ResultVO<?> projectInfo(@RequestParam Long projectId) {
      log.info("API 调用 ：项目信息");
      return ResultBuilder.success(this.contractProjectService.projectInfo(projectId));
   }

   @ApiOperation("结构生产、发运信息")
   @GetMapping("/techArtifactProduceOutInfo")
   public ResultVO<?> techArtifactProduceOutInfo(@RequestParam Long projectId) {
      log.info("API 调用 ：结构生产、发运信息");
      return ResultBuilder.success(this.mesBuildingWarehouseSummaryService.techArtifactProduceOutInfo(projectId));
   }

   @ApiOperation("结构清单量信息")
   @GetMapping("/techArtifactInventoryInfo")
   public ResultVO<?> techArtifactInventoryInfo(@RequestParam Long projectId) {
      log.info("API 调用 ：结构清单量信息");
      return ResultBuilder.success(this.mesBuildingWarehouseSummaryService.techArtifactInventoryInfo(projectId));
   }

   @ApiOperation("构件、部件、零件生产分析")
   @GetMapping("/productAnalysis")
   public ResultVO<?> productAnalysis(@RequestParam Long projectId, @RequestParam(required = false) String type) {
      log.info("API 调用 ：构件、部件、零件生产分析");
      return ResultBuilder.success(this.mesBuildingCompleteService.productAnalysis(projectId, type));
   }

   @ApiOperation("工序生产进度")
   @ApiResponses(@ApiResponse(code = 20000, message = "操作成功", response = ProcessProductionProgressVO.class))
   @GetMapping("/processProductionProgress")
   public ResultVO<?> processProductionProgress(@RequestParam Long projectId) {
      log.info("API 调用 ：工序生产进度");
      return ResultBuilder.success(this.mesBuildingCompleteService.processProductionProgress(projectId));
   }

   public LargeScreenController(
      final BimModelCommonService bimModelCommonService,
      final MesBuildingWarehouseSummaryService mesBuildingWarehouseSummaryService,
      final PlanMonomerService planMonomerService,
      final MesBuildingQhseService mesBuildingQhseService,
      final MesBuildingCargoListService mesBuildingCargoListService,
      final MesBuildingTaskProcessService mesBuildingTaskProcessService,
      final MesBuildingCompleteService mesBuildingCompleteService,
      final ContractProjectService contractProjectService
   ) {
      this.bimModelCommonService = bimModelCommonService;
      this.mesBuildingWarehouseSummaryService = mesBuildingWarehouseSummaryService;
      this.planMonomerService = planMonomerService;
      this.mesBuildingQhseService = mesBuildingQhseService;
      this.mesBuildingCargoListService = mesBuildingCargoListService;
      this.mesBuildingTaskProcessService = mesBuildingTaskProcessService;
      this.mesBuildingCompleteService = mesBuildingCompleteService;
      this.contractProjectService = contractProjectService;
   }
}
