package com.hzchum.scim.rest.controller.app;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingCargoListBiz;
import com.hzchum.scim.mes.building.core.api.biz.projectKanban.ProductKanbanBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskProcessBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.AnalysisQhseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.PersonalDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.QhseDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TrackSteelDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TrackSummaryDTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES新报表中心")
@RestController
@RequestMapping("/api/app/building/report")
public class AppNewReportController {
   private static final Logger log = LoggerFactory.getLogger(AppNewReportController.class);
   @Autowired
   private MesBuildingTaskOrderBiz taskOrderBiz;
   @Autowired
   private MesBuildingTaskProcessBiz taskProcessBiz;
   @Autowired
   private MesBuildingTaskBiz taskBiz;
   @Autowired
   private MesBuildingCompleteService completeService;
   @Autowired
   private MesBuildingCargoListBiz cargoListBiz;
   @Autowired
   private ProductKanbanBiz productKanbanBiz;
   @Resource
   private InboundDetailService inboundDetailService;
   @Resource
   private OutboundService outboundService;
   @Resource
   private MaterialInventoryService materialInventoryService;

   @ApiOperation("零件工单跟踪列表")
   @GetMapping("/tracking/machine_part/page")
   @PreAuthorize("@permission.check('taskOrderSummary')")
   public ResultVO taskTrackMachinePartPage(
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      Long projectId,
      Integer productType,
      Integer status,
      String orderNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：零件工单跟踪列表");
      return ResultBuilder.success(
         this.taskOrderBiz
            .taskTrackMachinePartPage(dateTime, workshopId, productionLineId, projectId, null, null, productType, status, orderNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("构件工单跟踪列表")
   @GetMapping("/tracking/artifact/page")
   @PreAuthorize("@permission.check('taskOrderSummary')")
   public ResultVO taskTrackArtifactPage(
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      Long projectId,
      Integer productType,
      Integer status,
      String orderNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：构件工单跟踪列表");
      return ResultBuilder.success(
         this.taskOrderBiz
            .taskTrackArtifactPage(dateTime, workshopId, productionLineId, projectId, null, null, null, productType, status, orderNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("零件工序进度")
   @GetMapping("/machine_part/process")
   @PreAuthorize("@permission.check('taskOrderSummary')")
   public ResultVO taskMachinePartProcess(Long topTaskOrderId, Long workshopId, Long productionLineId, Integer productType) {
      log.info("API 调用 ：零件工序进度");
      return ResultBuilder.success(this.taskProcessBiz.taskMachinePartProcess(topTaskOrderId, null, null, null, workshopId, productionLineId, productType));
   }

   @ApiOperation("构件部件工序进度")
   @GetMapping("/artifact/process")
   @PreAuthorize("@permission.check('taskOrderSummary')")
   public ResultVO taskArtifactProcess(Long topTaskOrderId, Long workshopId, Long productionLineId) {
      log.info("API 调用 ：构件部件工序进度");
      return ResultBuilder.success(this.taskProcessBiz.taskArtifactProcess(topTaskOrderId, null, null, null, workshopId, productionLineId));
   }

   @ApiOperation("获取智能线构件工序进度")
   @GetMapping("/artifact/page")
   @PreAuthorize("@permission.check('taskOrderSummary')")
   public ResultVO taskArtifactPage(
      Long topTaskOrderId,
      Long workshopId,
      Long productionLineId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取智能线构件工序进度");
      return ResultBuilder.success(this.taskProcessBiz.taskArtifactPage(topTaskOrderId, null, null, null, workshopId, productionLineId, pageNumber, pageSize));
   }

   @ApiOperation("工序进度详情-分页")
   @GetMapping("/product/page")
   @PreAuthorize("@permission.check('taskOrderSummary')")
   public ResultVO taskProcessProductPage(
      Long processId,
      Integer taskType,
      Long orderId,
      Long groupId,
      String name,
      Long monomerId,
      Long areaId,
      String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：工序进度详情-分页");
      return ResultBuilder.success(
         this.taskProcessBiz.appTaskProcessProductPage(processId, taskType, orderId, groupId, name, monomerId, areaId, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("月度任务跟踪--按月分组")
   @GetMapping("/tracking/month")
   @PreAuthorize("@permission.check('monthlyTaskTrance')")
   public ResultVO taskTrackingMonth(LocalDateTime dateTime, Long workshopId, Long productionLineId) {
      log.info("API 调用 ：月度任务跟踪--按月分组");
      return ResultBuilder.success(this.taskBiz.taskTrackingMonth(dateTime, workshopId, productionLineId));
   }

   @ApiOperation("获取某月的任务跟踪列表-分页")
   @GetMapping("/tracking/month/page")
   @PreAuthorize("@permission.check('monthlyTaskTrance')")
   public ResultVO taskTrackingMonthPage(
      LocalDateTime dateTime,
      Long workShopId,
      Long productionLineId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取某月的任务跟踪列表-分页");
      return ResultBuilder.success(this.taskBiz.taskTrackingMonthPage(dateTime, workShopId, productionLineId, pageNumber, pageSize));
   }

   @ApiOperation("产线列表")
   @GetMapping("/tracking/productionLine")
   public ResultVO taskProductionLineList(LocalDateTime startTime, LocalDateTime endTime, Integer productType, Integer type, Long processId) {
      log.info("API 调用 ：产线列表");
      return ResultBuilder.success(this.taskBiz.taskProductionLineList(startTime, endTime, productType, type, processId));
   }

   @ApiOperation("工序呆滞")
   @GetMapping("/dull/process/list")
   @PreAuthorize("@permission.check('processSluggish')")
   public ResultVO taskDullProcess(Long workshopId) {
      log.info("API 调用 ：工序呆滞");
      return ResultBuilder.success(this.taskProcessBiz.taskDullProcess(workshopId));
   }

   @ApiOperation("工序呆滞详情-分页")
   @GetMapping("/dull/process/detail/page")
   @PreAuthorize("@permission.check('processSluggish')")
   public ResultVO taskDullProcessDetailPage(
      Integer productType,
      Long processId,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long groupId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：工序呆滞详情-分页");
      return ResultBuilder.success(
         this.taskProcessBiz
            .taskDullProcessDetailPage(productType, processId, productionLineId, projectId, monomerId, areaId, serialNumber, groupId, pageNumber, pageSize)
      );
   }

   @ApiOperation("查询工序呆滞的所有项目")
   @GetMapping("/dull/process/project/list")
   public ResultVO taskDullProcessProject(Integer productType, Long processId, Long productionLineId) {
      log.info("API 调用 ：查询工序呆滞的所有项目");
      return ResultBuilder.success(this.taskProcessBiz.taskDullProcessProject(productType, processId, productionLineId));
   }

   @ApiOperation("获取当年车间/产线产量汇总")
   @GetMapping("/workshop/mete/summary")
   @PreAuthorize("@permission.check('manufactureSummary')")
   public ResultVO getWorkshopMeteSummary(LocalDateTime dateTime, Long workshopId, Long productionLineId) {
      log.info("API 调用 ：获取当年车间/产线产量汇总");
      return ResultBuilder.success(this.completeService.getWorkshopMeteSummary(dateTime, workshopId, productionLineId));
   }

   @ApiOperation("获取当年车间/产线每月产量")
   @GetMapping("/workshop/mete/month")
   @PreAuthorize("@permission.check('manufactureSummary')")
   public ResultVO getWorkshopMeteByMonth(LocalDateTime dateTime, Long workshopId, Long productionLineId) {
      log.info("API 调用 ：获取当年车间/产线每月产量");
      return ResultBuilder.success(this.completeService.getWorkshopMeteByMonth(dateTime, workshopId, productionLineId));
   }

   @ApiOperation("获取当年车间/产线每月产量详情")
   @GetMapping("/workshop/mete/month/detail")
   @PreAuthorize("@permission.check('manufactureSummary')")
   public ResultVO getWorkshopMeteByMonthDetail(LocalDateTime dateTime, Long workshopId, Long productionLineId) {
      log.info("API 调用 ：获取当年车间/产线每月产量详情");
      return ResultBuilder.success(this.completeService.getWorkshopMeteByMonthDetail(dateTime, workshopId, productionLineId));
   }

   @ApiOperation("获取当年车间/产线每天产量")
   @GetMapping("/workshop/mete/day")
   @PreAuthorize("@permission.check('manufactureSummary')")
   public ResultVO getWorkshopMeteByDay(LocalDateTime dateTime, Long workshopId, Long productionLineId) {
      log.info("API 调用 ：获取当月车间/产线每天产量");
      return ResultBuilder.success(this.completeService.getWorkshopMeteByDay(dateTime, workshopId, productionLineId));
   }

   @ApiOperation("当年发运信息汇总")
   @GetMapping("/year/summary")
   @PreAuthorize("@permission.check('shipSummary')")
   public ResultVO getYearCargoListSummary(@RequestParam LocalDateTime dateTime, @RequestParam(required = false) Integer projectStatus) {
      log.info("API 调用 ：当年发运信息汇总");
      return ResultBuilder.success(this.cargoListBiz.getYearCargoListSummary(dateTime, projectStatus));
   }

   @ApiOperation("当年每月发运数据")
   @GetMapping("/year/cargo/month")
   @PreAuthorize("@permission.check('shipSummary')")
   public ResultVO getCargoListGroupMonth(@RequestParam LocalDateTime dateTime) {
      log.info("API 调用 ：当年每月发运数据");
      return ResultBuilder.success(this.cargoListBiz.getCargoListGroupMonth(dateTime));
   }

   @ApiOperation("查询项目发运信息统计")
   @GetMapping("/project/summary/list")
   @PreAuthorize("@permission.check('shipSummary')")
   public ResultVO projectCargoListSummaryList(LocalDateTime dateTime, @RequestParam(required = false) Integer projectStatus) {
      log.info("API 调用 ：查询项目发运信息统计");
      return ResultBuilder.success(this.cargoListBiz.projectCargoListSummaryList(dateTime, projectStatus));
   }

   @ApiOperation("APP主材跟踪汇总数据")
   @GetMapping("/track/summary")
   @PreAuthorize("@permission.check('paSteelUsage')")
   public ResultVO<TrackSummaryDTO> trackSummary(Long projectId) {
      log.info("API 调用 ：APP主材跟踪汇总数据");
      return ResultBuilder.success(this.taskBiz.trackSummary(projectId));
   }

   @ApiOperation("APP主材跟踪钢板用量分析")
   @GetMapping("/track/steel")
   @PreAuthorize("@permission.check('paSteelUsage')")
   public ResultVO<List<TrackSteelDTO>> trackSteel(Long projectId) {
      log.info("API 调用 ：APP主材跟踪钢板用量分析");
      return ResultBuilder.success(this.taskBiz.trackSteel(projectId));
   }

   @ApiOperation("APP主材跟踪型材用量分析")
   @GetMapping("/track/section")
   @PreAuthorize("@permission.check('paSteelUsage')")
   public ResultVO<List<TrackSteelDTO>> trackSection(Long projectId) {
      log.info("API 调用 ：APP主材跟踪型材用量分析");
      return ResultBuilder.success(this.taskBiz.trackSection(projectId));
   }

   @ApiOperation("APP质检数据个人绩效")
   @GetMapping("/personal/list")
   @PreAuthorize("@permission.check('inspectionSummary')")
   public ResultVO<List<PersonalDTO>> personal(LocalDateTime time, Long workshopId) {
      log.info("API 调用 ：APP质检数据个人绩效");
      return ResultBuilder.success(this.taskBiz.personal(time, workshopId));
   }

   @ApiOperation("APP质检数据个人绩效汇总")
   @GetMapping("/personal/summary")
   @PreAuthorize("@permission.check('inspectionSummary')")
   public ResultVO personalSummary(LocalDateTime time, Long workshopId) {
      log.info("API 调用 ：APP质检数据个人绩效");
      return ResultBuilder.success(this.taskBiz.personalSummary(time, workshopId));
   }

   @ApiOperation("APP质检分析-年度问题")
   @GetMapping("/analysis/qhse")
   @PreAuthorize("@permission.check('inspectionSummary')")
   public ResultVO<List<AnalysisQhseDTO>> analysisQhse(LocalDateTime time, Long workshopId) {
      log.info("API 调用 ：APP质检分析-年度问题");
      return ResultBuilder.success(this.taskBiz.analysisQhse(time, workshopId));
   }

   @ApiOperation("APP质检分析-质量数据")
   @GetMapping("/analysis/data")
   @PreAuthorize("@permission.check('inspectionSummary')")
   public ResultVO<List<QhseDetailsDTO>> analysisData(LocalDateTime time, Long workshopId) {
      log.info("API 调用 ：APP质检分析-质量数据");
      return ResultBuilder.success(this.taskBiz.analysisData(time, workshopId));
   }

   @ApiOperation("APP原材料统计-入出库统计")
   @GetMapping("/wms/inbound-outbound")
   @PreAuthorize("@permission.check('steelInOutSummary')")
   public ResultVO inbound(String year, int type) {
      log.info("API 调用 ：APP原材料统计-入出库统计");
      return type == 1 ? ResultBuilder.success(this.inboundDetailService.getMeteByYear(year)) : ResultBuilder.success(this.outboundService.getMeteByYear(year));
   }

   @ApiOperation("APP原材料统计-现库存")
   @GetMapping("/wms/inventory")
   @PreAuthorize("@permission.check('steelInOutSummary')")
   public ResultVO inventory() {
      log.info("API 调用 ：APP原材料统计-现库存");
      Map<String, BigDecimal> map = new HashMap<>();
      map.put(
         "steelPlate",
         this.materialInventoryService
            .getInventoryDetails(BasicClassEnum.STEEL_PLATE.getType())
            .stream()
            .map(MaterialInventory::getMete)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
      );
      map.put(
         "sectionSteel",
         this.materialInventoryService
            .getInventoryDetails(BasicClassEnum.SECTION_STEEL.getType())
            .stream()
            .map(MaterialInventory::getMete)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
      );
      return ResultBuilder.success(map);
   }
}
