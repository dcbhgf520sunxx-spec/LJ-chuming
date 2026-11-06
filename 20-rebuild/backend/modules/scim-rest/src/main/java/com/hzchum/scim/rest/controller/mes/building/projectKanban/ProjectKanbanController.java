package com.hzchum.scim.rest.controller.mes.building.projectKanban;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.projectKanban.ProjectKanbanBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.ProjectSummaryDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.projectKanban.get.ProjectSummaryVORequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES项目看板")
@RestController
@RequestMapping("/api/mes/building/kanban/project")
public class ProjectKanbanController {
   private static final Logger log = LoggerFactory.getLogger(ProjectKanbanController.class);
   @Autowired
   private ProjectKanbanBiz projectKanbanBiz;

   @ApiOperation("获取构件生产报表汇总")
   @GetMapping("/artifact/summary")
   public ResultVO projectSummary(ProjectSummaryVORequest voRequest) {
      log.info("API 调用 ：获取构件生产报表汇总");
      return ResultBuilder.success(this.projectKanbanBiz.projectSummary(BeanUtil.copy(voRequest, ProjectSummaryDTOParam.class)));
   }

   @ApiOperation("获取当年的项目")
   @GetMapping("/year/page")
   public ResultVO projectSummaryYearPage(
      LocalDateTime date,
      Integer status,
      String name,
      @RequestParam(required = false, defaultValue = "1") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取当年的项目");
      return ResultBuilder.success(this.projectKanbanBiz.projectSummaryYearPage(date, status, name, pageNumber, pageSize, projectType, lumpSumSystemType));
   }

   @ApiOperation("获取工序下构件零件的清单数")
   @GetMapping("/process/summary")
   public ResultVO processSummary(
      Long projectId, Long monomerId, Long areaId, Long productionLineId, Integer productType, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   ) {
      log.info("API 调用 ：获取工序下构件零件的清单数");
      return ResultBuilder.success(
         this.projectKanbanBiz.processSummary(projectId, monomerId, areaId, null, productionLineId, productType, startDate, endDate, workshopId)
      );
   }

   @ApiOperation("获取生产明细详情")
   @GetMapping("/process/summary/detail/page")
   public ResultVO processSummaryDetailPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productionLineId,
      String serialNumber,
      Integer productType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer status,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取生产明细详情");
      return ResultBuilder.success(
         this.projectKanbanBiz
            .processSummaryDetailPage(
               projectId,
               monomerId,
               areaId,
               null,
               workshopId,
               productionLineId,
               serialNumber,
               productType,
               processId,
               startDate,
               endDate,
               status,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("打印生产明细详情")
   @GetMapping("/process/summary/detail/print")
   public ResultVO processSummaryDetailPrint(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productionLineId,
      String serialNumber,
      Integer productType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer status
   ) {
      log.info("API 调用 ：打印生产明细详情");
      return ResultBuilder.success(
         this.projectKanbanBiz
            .processSummaryDetailPrint(
               projectId, monomerId, areaId, workshopId, productionLineId, serialNumber, productType, processId, startDate, endDate, status
            )
      );
   }

   @ApiOperation("获取班组任务详情")
   @GetMapping("/group/task/detail/page")
   public ResultVO groupTaskDetailPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long productId,
      Long productionLineId,
      Integer productType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取班组任务详情");
      return ResultBuilder.success(
         this.projectKanbanBiz
            .groupTaskDetailPage(projectId, monomerId, areaId, productionLineId, productId, productType, processId, startDate, endDate, pageNumber, pageSize)
      );
   }

   @ApiOperation("获取班组任务详情")
   @GetMapping("/workshop")
   public ResultVO findHasTaskWorkShop() {
      log.info("API 调用 ：获取班组任务详情");
      return ResultBuilder.success(this.projectKanbanBiz.findHasTaskWorkShop());
   }

   @ApiOperation("项目树")
   @GetMapping("/trees")
   public ResultVO getProjectKanbanTrees(Long workshopId, Integer status, LocalDateTime dateTime) {
      log.info("API 调用 ：项目树");
      return ResultBuilder.success(this.projectKanbanBiz.getProjectKanbanTrees(workshopId, status, dateTime));
   }

   @ApiOperation("项目状态数汇总")
   @GetMapping("/status/summary")
   public ResultVO getProjectStatusSummary(Long workshopId, LocalDateTime dateTime) {
      log.info("API 调用 ：项目状态数汇总");
      return ResultBuilder.success(this.projectKanbanBiz.getProjectStatusSummary(workshopId, dateTime));
   }

   @ApiOperation("项目状态数汇总")
   @GetMapping("/product/summary")
   public ResultVO getProductTaskSummary(List<Long> areaIds) {
      log.info("API 调用 ：项目状态数汇总");
      return ResultBuilder.success(this.projectKanbanBiz.getProductTaskSummary(areaIds));
   }

   @ApiOperation("项目状态数汇总")
   @GetMapping("/product/list")
   public ResultVO findProjectProductProcessInfos(
      List<Long> areaIds,
      Long monmerId,
      Long areaId,
      Long classId,
      String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：项目状态数汇总");
      return ResultBuilder.success(this.projectKanbanBiz.findProjectProductProcessInfos(areaIds, monmerId, areaId, classId, serialNumber, pageNumber, pageSize));
   }

   @ApiOperation("项目状态数汇总")
   @GetMapping("/product/detail")
   public ResultVO findProductProcessDetails(Long productId, Long processId, Long classId, String serialNumber, Integer taskTypeEnum, Integer type) {
      log.info("API 调用 ：项目状态数汇总");
      return ResultBuilder.success(this.projectKanbanBiz.findProductProcessDetails(productId, processId, classId, serialNumber, taskTypeEnum, type));
   }
}
