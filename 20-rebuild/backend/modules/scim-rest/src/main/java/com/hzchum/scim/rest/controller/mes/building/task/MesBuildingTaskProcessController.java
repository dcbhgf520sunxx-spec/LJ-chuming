package com.hzchum.scim.rest.controller.mes.building.task;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo.vo.MesBuildingWIPStatisticsVO;
import com.hzchum.scim.mes.building.core.api.biz.MesBuildingWipDailySnapshotBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskProcessBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES任务工序")
@RestController
@RequestMapping("/api/mes/building/task/process")
public class MesBuildingTaskProcessController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingTaskProcessController.class);
   @Resource
   private MesBuildingTaskProcessBiz taskProcessBiz;
   @Resource
   private MesBuildingWipDailySnapshotBiz snapshotBiz;

   @ApiOperation("根据任务工单获取工序列表")
   @GetMapping("/list")
   public ResultVO getProcessList(Integer productType, Long orderId) {
      log.info("API 调用 ：根据任务工单获取工序列表");
      return ResultBuilder.success(this.taskProcessBiz.getProcessList(productType, orderId));
   }

   @ApiOperation("获取任务清单")
   @GetMapping("/product/task/list/page")
   @PreAuthorize("@permission.check('mes_work_order_artifact:detail')")
   public ResultVO getProductTaskListPage(
      Long projectId,
      Long processId,
      Long orderId,
      Integer productType,
      Integer type,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false, defaultValue = "0") Boolean boolAccurateQuery,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取任务清单");
      return ResultBuilder.success(
         this.taskProcessBiz
            .getProductTaskListPage(
               projectId,
               processId,
               orderId,
               productType,
               type,
               productionLineTypeEnum,
               startDate,
               endDate,
               serialNumber,
               specification,
               boolAccurateQuery,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("获取工单能否删除")
   @GetMapping("/task_order/revoke")
   public ResultVO getProductTaskListPage(
      Long projectId,
      Long processId,
      Long orderId,
      Integer productType,
      Integer type,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false, defaultValue = "0") Boolean boolAccurateQuery
   ) {
      log.info("API 调用 ：获取工单能否删除");
      return ResultBuilder.success(
         this.taskProcessBiz
            .getTaskOrderRevoke(
               projectId, processId, orderId, productType, type, productionLineTypeEnum, startDate, endDate, serialNumber, specification, boolAccurateQuery
            )
      );
   }

   @ApiOperation("打印任务清单")
   @GetMapping("/product/task/list/print")
   @PreAuthorize("@permission.check('mes_work_order_artifact:print')")
   public ResultVO getProductTaskListPrint(
      Long projectId,
      Long processId,
      Long orderId,
      Integer productType,
      Integer type,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      log.info("API 调用 ：打印任务清单");
      return ResultBuilder.success(
         this.taskProcessBiz.getProductTaskListPrint(projectId, processId, orderId, productType, type, productionLineTypeEnum, startDate, endDate)
      );
   }

   @ApiOperation("多任务单号打印任务清单")
   @GetMapping("/product/tasks/list/print")
   @PreAuthorize("@permission.check('mes_work_order_artifact:print')")
   public ResultVO getProductTasksListPrint(
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long processId,
      @RequestParam(required = true) List<Long> orderIds,
      @RequestParam(required = true) Integer productType,
      @RequestParam(required = false) Integer type,
      @RequestParam(required = true) Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      log.info("API 调用 ：打印任务清单");
      return ResultBuilder.success(
         this.taskProcessBiz.getProductTasksListPrint(projectId, processId, orderIds, productType, type, productionLineTypeEnum, startDate, endDate)
      );
   }

   @ApiOperation("多任务单号打印任务清单")
   @GetMapping("/product/tasks/list/printV2")
   @PreAuthorize("@permission.check('mes_work_order_artifact:print')")
   public ResultVO getProductTasksListPrintV2(
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long processId,
      @RequestParam(required = true) List<Long> orderIds,
      @RequestParam(required = false) Integer productType,
      @RequestParam(required = false) Integer type,
      @RequestParam(required = true) Integer productionLineTypeEnum,
      @RequestParam(required = false) LocalDateTime startDate,
      @RequestParam(required = false) LocalDateTime endDate
   ) {
      log.info("API 调用 ：打印任务清单");
      return ResultBuilder.success(
         this.taskProcessBiz.getProductTasksListPrintV2(projectId, processId, orderIds, productType, type, productionLineTypeEnum, startDate, endDate)
      );
   }

   @ApiOperation("打印任务清单标记")
   @GetMapping("/task/list/sign")
   public ResultVO getProductTaskListPrint(Long orderId) {
      log.info("API 调用 ：打印任务清单标记");
      return ResultBuilder.success(this.taskProcessBiz.getProductTaskListPrintSign(orderId));
   }

   @ApiOperation("零件工序进度")
   @GetMapping("/machine_part/process")
   public ResultVO taskMachinePartProcess(
      Long topTaskOrderId, Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId, Integer productType
   ) {
      log.info("API 调用 ：零件工序进度");
      return ResultBuilder.success(
         this.taskProcessBiz.taskMachinePartProcess(topTaskOrderId, projectId, monomerId, areaId, workshopId, productionLineId, productType)
      );
   }

   @ApiOperation("构件部件工序进度")
   @GetMapping("/artifact/process")
   public ResultVO taskArtifactProcess(Long topTaskOrderId, Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId) {
      log.info("API 调用 ：构件部件工序进度");
      return ResultBuilder.success(this.taskProcessBiz.taskArtifactProcess(topTaskOrderId, projectId, monomerId, null, workshopId, productionLineId));
   }

   @ApiOperation("获取智能线构件工序进度")
   @GetMapping("/artifact/page")
   public ResultVO taskArtifactPage(
      Long topTaskOrderId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productionLineId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取智能线构件工序进度");
      return ResultBuilder.success(
         this.taskProcessBiz.taskArtifactPage(topTaskOrderId, projectId, monomerId, areaId, workshopId, productionLineId, pageNumber, pageSize)
      );
   }

   @ApiOperation("工序进度详情-分页")
   @GetMapping("/product/page")
   public ResultVO taskProcessProductPage(
      Long processId,
      Integer taskType,
      Long orderId,
      Long groupId,
      String name,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：工序进度详情-分页");
      return ResultBuilder.success(
         this.taskProcessBiz
            .taskProcessProductPage(processId, taskType, orderId, groupId, name, projectId, monomerId, areaId, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("工序进度详情打印")
   @GetMapping("/product/print")
   @PreAuthorize("@permission.check('mes_work_order_tracking:print')")
   public ResultVO taskProcessProductPrint(
      LocalDateTime dateTime,
      Long processId,
      Integer taskType,
      Long orderId,
      Long groupId,
      String name,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber
   ) {
      log.info("API 调用 ：工序进度详情打印");
      return ResultBuilder.success(
         this.taskProcessBiz.taskProcessProductPrint(dateTime, processId, taskType, orderId, groupId, name, projectId, monomerId, areaId, serialNumber)
      );
   }

   @ApiOperation("工序呆滞")
   @GetMapping("/dull/process")
   @PreAuthorize("@permission.check('mes_process_sluggish:get')")
   public ResultVO taskDullProcess(Long workShopId) {
      log.info("API 调用 ：工序呆滞");
      return ResultBuilder.success(this.taskProcessBiz.taskDullProcess(workShopId));
   }

   @ApiOperation("工序呆滞详情-分页")
   @GetMapping("/dull/process/detail/page")
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

   @ApiOperation("打印工序呆滞详情")
   @GetMapping("/dull/process/detail/print")
   @PreAuthorize("@permission.check('mes_process_sluggish:print')")
   public ResultVO taskDullProcessDetailPrint(
      Integer productType, Long processId, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber, Long groupId
   ) {
      log.info("API 调用 ：打印工序呆滞详情");
      return ResultBuilder.success(
         this.taskProcessBiz.taskDullProcessDetailPrint(productType, processId, productionLineId, projectId, monomerId, areaId, serialNumber, groupId)
      );
   }

   @ApiOperation("工序呆滞V2")
   @GetMapping("/dull/processV2")
   @PreAuthorize("@permission.check('mes_delay_notify:get')")
   public ResultVO taskDullProcessV2(
      @RequestParam(required = false) Long workShopId,
      @RequestParam(required = false) Long productionLineId,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long processId,
      @RequestParam(required = false) Long teamId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：工序呆滞");
      return ResultBuilder.success(this.taskProcessBiz.taskDullProcessV2(workShopId, productionLineId, projectId, processId, teamId, pageNumber, pageSize));
   }

   @ApiOperation("工序呆滞详情-分页V2")
   @GetMapping("/dull/process/detail/pageV2")
   @PreAuthorize("@permission.check('mes_delay_notify:detail')")
   public ResultVO taskDullProcessDetailPageV2(
      Integer productType,
      Long processId,
      Long productionLineId,
      @RequestParam(name = "projectId") Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      @RequestParam(name = "teamId") Long groupId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：工序呆滞详情-分页");
      return ResultBuilder.success(
         this.taskProcessBiz
            .taskDullProcessDetailPageV2(productType, processId, productionLineId, projectId, monomerId, areaId, serialNumber, groupId, pageNumber, pageSize)
      );
   }

   @ApiOperation("打印工序呆滞详情")
   @GetMapping("/dull/process/detail/printV2")
   @PreAuthorize("@permission.check('mes_delay_notify:print')")
   public ResultVO taskDullProcessDetailPrintV2(
      Integer productType, Long processId, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber, Long teamId
   ) {
      log.info("API 调用 ：打印工序呆滞详情");
      return ResultBuilder.success(
         this.taskProcessBiz.taskDullProcessDetailPrintV2(productType, processId, productionLineId, projectId, monomerId, areaId, serialNumber, teamId)
      );
   }

   @ApiOperation("构件生产跟踪")
   @GetMapping("/artifact/process/track")
   public ResultVO pageArtifactProcess(
      @RequestParam Long areaId,
      Long areaBatchId,
      Long factoryId,
      Long classificationId,
      Long productionLineId,
      String serialNumber,
      String specification,
      String material,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("Api 调用: 构件生产跟踪");
      return ResultBuilder.success(
         this.taskProcessBiz
            .pageArtifactProcessByCondition(
               areaId, areaBatchId, factoryId, classificationId, productionLineId, serialNumber, specification, material, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("部件生产跟踪")
   @GetMapping("/assemble/process/track")
   public ResultVO pageAssembleProcess(
      @RequestParam Long areaId,
      Long areaBatchId,
      Long factoryId,
      Long classificationId,
      Long productionLineId,
      String serialNumber,
      String specification,
      String material,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("Api 调用: 部件生产跟踪");
      return ResultBuilder.success(
         this.taskProcessBiz
            .pageAssembleProcessByCondition(
               areaId, areaBatchId, factoryId, classificationId, productionLineId, serialNumber, specification, material, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("生产跟踪-生产线筛选条件列表")
   @GetMapping("/assemble/process/track/prodLineList")
   public ResultVO prodLineList(
      @RequestParam Long areaId,
      Long areaBatchId,
      Long factoryId,
      Long classificationId,
      Long productionLineId,
      String serialNumber,
      String specification,
      String material,
      Integer taskTypeEnum
   ) {
      log.info("Api 调用: 生产跟踪-生产线筛选条件列表");
      return ResultBuilder.success(
         this.taskProcessBiz
            .pageArtifactOrAssembleProdLineList(
               areaId, areaBatchId, factoryId, classificationId, productionLineId, serialNumber, specification, material, taskTypeEnum
            )
      );
   }

   @ApiOperation("生产跟踪-Excel文档下载")
   @GetMapping("/assemble/process/track/print")
   public void pageProcessPrint(
      Long projectId,
      @RequestParam Long areaId,
      Long areaBatchId,
      Long factoryId,
      Long classificationId,
      Long productionLineId,
      String serialNumber,
      String specification,
      String material,
      Integer processType,
      HttpServletResponse response
   ) {
      log.info("Api 调用: 生产跟踪-Excel文档下载");
      this.taskProcessBiz
         .pageArtifactOrAssemblePrint(
            projectId, areaId, areaBatchId, factoryId, classificationId, productionLineId, serialNumber, specification, material, processType, response
         );
   }

   @ApiOperation("获取构部件类型汇总列表")
   @GetMapping("/type/list")
   public ResultVO getProductTypeList(@RequestParam Long areaId, Long areaBatchId, Long factoryId, Integer taskTypeEnum) {
      log.info("API 调用 ：获取构部件类型汇总列表");
      return ResultBuilder.success(new ListVO<>(this.taskProcessBiz.getProductTypeList(areaId, areaBatchId, factoryId, taskTypeEnum)));
   }

   @ApiOperation("生产统计")
   @GetMapping("/produce/statistics")
   public ResultVO produceStatistics(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer status,
      Long workshopId,
      @RequestParam(required = false, defaultValue = "1") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      return ResultBuilder.success(
         this.taskProcessBiz.produceStatistics(startDate, endDate, status, workshopId, projectType, lumpSumSystemType, pageNumber, pageSize)
      );
   }

   @ApiOperation("生产统计打印")
   @GetMapping("/produce/statistics/print")
   public ResultVO produceStatisticsPrint(LocalDateTime startDate, LocalDateTime endDate, Integer status, Long workshopId) {
      return ResultBuilder.success(this.taskProcessBiz.produceStatisticsPrint(startDate, endDate, status, workshopId));
   }

   @ApiOperation("生产统计--钢材累计出库记录")
   @GetMapping("/produce/statistics/outBound/page")
   public ResultVO produceStatisticsOutBoundPage(
      Long projectId,
      Integer type,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：生产统计--钢材累计出库记录");
      return ResultBuilder.success(this.taskProcessBiz.projectProgressingOutBoundPage(projectId, type, startDate, endDate, pageNumber, pageSize));
   }

   @ApiOperation("生产统计--钢材累计出库记录打印")
   @GetMapping("/produce/statistics/outBound/print")
   public ResultVO produceStatisticsOutBoundPrint(Long projectId, Integer type, LocalDateTime startDate, LocalDateTime endDate) {
      log.info("API 调用 ：生产统计--钢材累计出库记录打印");
      return ResultBuilder.success(this.taskProcessBiz.projectProgressingOutBoundPrint(projectId, type, startDate, endDate));
   }

   @ApiOperation("生产统计--任务记录")
   @GetMapping("/produce/statistics/task/page")
   public ResultVO produceStatisticsTaskPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long workshopId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：生产统计--排产记录");
      return ResultBuilder.success(
         this.taskProcessBiz.projectProgressingTaskPage(projectId, monomerId, areaId, serialNumber, startDate, endDate, workshopId, pageNumber, pageSize)
      );
   }

   @ApiOperation("生产统计--任务记录打印")
   @GetMapping("/produce/statistics/task/print")
   public ResultVO produceStatisticsTaskPrint(
      Long projectId, Long monomerId, Long areaId, String serialNumber, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   ) {
      log.info("API 调用 ：生产统计--任务记录打印");
      return ResultBuilder.success(this.taskProcessBiz.projectProgressingTaskPrint(projectId, monomerId, areaId, serialNumber, startDate, endDate, workshopId));
   }

   @ApiOperation("生产统计--工序记录")
   @GetMapping("/produce/statistics/process/page")
   public ResultVO produceStatisticsProcessPage(
      Long projectId,
      Long processId,
      Integer taskTypeEnum,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long workshopId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：生产统计--工序记录");
      return ResultBuilder.success(
         this.taskProcessBiz
            .projectProgressingProcessPage(projectId, processId, taskTypeEnum, monomerId, areaId, serialNumber, workshopId, pageNumber, pageSize)
      );
   }

   @ApiOperation("生产统计--工序记录")
   @GetMapping("/produce/statistics/process/print")
   public ResultVO produceStatisticsProcessPrint(
      Long projectId, Long processId, Integer taskTypeEnum, Long monomerId, Long areaId, String serialNumber, Long workshopId
   ) {
      log.info("API 调用 ：生产统计--工序记录");
      return ResultBuilder.success(
         this.taskProcessBiz.projectProgressingProcessPrint(projectId, processId, taskTypeEnum, monomerId, areaId, serialNumber, workshopId)
      );
   }

   @ApiOperation("生产统计--制成品记录")
   @GetMapping("/produce/statistics/finish/page")
   public ResultVO produceStatisticsFinishPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long workshopId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：生产统计--制成品记录");
      return ResultBuilder.success(
         this.taskProcessBiz.produceStatisticsFinishPage(projectId, monomerId, areaId, serialNumber, startDate, endDate, workshopId, pageNumber, pageSize)
      );
   }

   @ApiOperation("生产统计--制成品记录打印")
   @GetMapping("/produce/statistics/finish/print")
   public ResultVO produceStatisticsFinishPrint(
      Long projectId, Long monomerId, Long areaId, String serialNumber, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   ) {
      log.info("API 调用 ：生产统计--制成品记录打印");
      return ResultBuilder.success(this.taskProcessBiz.produceStatisticsFinishPrint(projectId, monomerId, areaId, serialNumber, startDate, endDate, workshopId));
   }

   @ApiOperation("在制品统计--在制品")
   @GetMapping("/produce/statistics/list")
   @PreAuthorize("@permission.check('mes_work_in_progress_statistics:get')")
   public ResultVO findWipStatisticsList(MesBuildingWIPStatisticsVO dto) throws IOException {
      log.info("API 调用 ：在制品统计--在制品");
      return ResultBuilder.success(this.snapshotBiz.findWipStatisticsList(dto));
   }

   @ApiOperation("在制品统计--在制品")
   @GetMapping("/produce/statistics/list/download")
   @PreAuthorize("@permission.check('mes_work_in_progress_statistics:export')")
   public void findWipStatisticsListDownload(MesBuildingWIPStatisticsVO dto, HttpServletResponse servletResponse) throws IOException {
      log.info("API 调用 ：在制品统计--在制品");
      this.snapshotBiz.findWipStatisticsListDownload(dto, servletResponse);
   }

   @ApiOperation("在制品统计--在制品工序列表")
   @GetMapping("/produce/statistics/process_list")
   @PreAuthorize("@permission.check('mes_work_in_progress_statistics:get')")
   public ResultVO findWipStatisticsProcessList(MesBuildingWIPStatisticsVO dto) throws IOException {
      log.info("API 调用 ：在制品统计--在制品工序列表");
      return ResultBuilder.success(this.snapshotBiz.findWipStatisticsProcessList(dto));
   }

   @ApiOperation("在制品统计--在制品详情")
   @GetMapping("/produce/statistics/detail")
   @PreAuthorize("@permission.check('mes_work_in_progress_statistics:get')")
   public ResultVO findWipStatisticsDetail(
      MesBuildingWIPStatisticsVO dto,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) throws IOException {
      log.info("API 调用 ：在制品统计--在制品详情");
      return ResultBuilder.success(this.snapshotBiz.findWipStatisticsDetail(dto, pageNumber, pageSize));
   }

   @ApiOperation("在制品统计--在制品详情打印")
   @GetMapping("/produce/statistics/detail/print")
   @PreAuthorize("@permission.check('mes_work_in_progress_statistics:get')")
   public ResultVO findWipStatisticsDetailPrint(MesBuildingWIPStatisticsVO dto) throws IOException {
      log.info("API 调用 ：在制品统计--在制品详情打印");
      return ResultBuilder.success(this.snapshotBiz.findWipStatisticsDetailPrint(dto));
   }
}
