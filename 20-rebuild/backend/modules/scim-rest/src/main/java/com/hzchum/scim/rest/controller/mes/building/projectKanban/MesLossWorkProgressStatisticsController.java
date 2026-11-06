package com.hzchum.scim.rest.controller.mes.building.projectKanban;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.mes.building.core.api.biz.task.MesLossWorkProgressStatisticsBiz;
import com.hzchum.scim.mes.building.core.api.enums.MesLossWorkProgressStatisticsEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.ProjectOrWorkShopEnum;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.WastageLossCostSummaryDTO;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES工厂报表-损耗及在制品统计")
@RestController
@RequestMapping("/api/mes/loss/progress/statistics")
public class MesLossWorkProgressStatisticsController {
   private static final Logger log = LoggerFactory.getLogger(MesLossWorkProgressStatisticsController.class);
   @Resource
   private MesLossWorkProgressStatisticsBiz workProgressStatisticsBiz;

   @ApiOperation("损耗及在制品统计列表-工序列表")
   @GetMapping("/process")
   public ResultVO projectSignageProcessList() {
      log.info("API 调用 ：损耗及在制品统计列表-工序列表");
      return ResultBuilder.success(new ListVO<>(this.workProgressStatisticsBiz.projectSignageProcessList()));
   }

   @ApiOperation("损耗及在制品统计列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "项目状态", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "List<Long>", paramType = "query"),
            @ApiImplicitParam(name = "workShopId", value = "车间id", dataType = "List<Long>", paramType = "query"),
            @ApiImplicitParam(name = "projectOrWorkShopEnum", value = "车间/项目维度", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", dataType = "int", paramType = "query")
      }
   )
   @GetMapping("/wastage/list")
   public ResultVO wastage(
      @RequestParam(required = false) Integer year,
      @RequestParam(required = false) Integer status,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam @EnumValidator(value = ProjectOrWorkShopEnum.class, message = "车间/项目参数不存在!") Integer projectOrWorkShopEnum,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：损耗及在制品统计列表");
      return ResultBuilder.success(
         this.workProgressStatisticsBiz.wastageLossList(year, status, projectId, workShopId, projectOrWorkShopEnum, pageNumber, pageSize, Boolean.FALSE)
      );
   }

   @ApiOperation("损耗及在制品统计列表下载")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "项目状态", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "projectIds", value = "项目ids", dataType = "List<Long>", paramType = "query"),
            @ApiImplicitParam(name = "workShopIds", value = "车间ids", dataType = "List<Long>", paramType = "query"),
            @ApiImplicitParam(name = "projectOrWorkShopEnum", value = "车间/项目维度", dataType = "int", paramType = "query")
      }
   )
   @GetMapping("/wastage/list/download")
   public void wastageLossListDownload(
      @RequestParam(required = false) Integer year,
      @RequestParam(required = false) Integer status,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam @EnumValidator(value = ProjectOrWorkShopEnum.class, message = "车间/项目参数不存在!") Integer projectOrWorkShopEnum,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：损耗及在制品统计列表下载");
      this.workProgressStatisticsBiz.wastageLossListDownload(year, status, projectId, workShopId, projectOrWorkShopEnum, response);
   }

   @ApiOperation("损耗及在制品汇总")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "workShopId", value = "车间id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "projectOrWorkShopEnum", value = "车间/项目维度", dataType = "int", paramType = "query")
      }
   )
   @GetMapping("/wastage/costSummary")
   public ResultVO<List<WastageLossCostSummaryDTO>> wastageLossCostSummary(
      @RequestParam(required = false) Integer year,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam @EnumValidator(value = ProjectOrWorkShopEnum.class, message = "车间/项目参数不存在!") Integer projectOrWorkShopEnum
   ) {
      return ResultBuilder.success(this.workProgressStatisticsBiz.wastageLossCostSummary(year, projectId, workShopId, projectOrWorkShopEnum, Boolean.FALSE));
   }

   @ApiOperation("损耗及在制品汇总excle下载")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "workShopId", value = "车间id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "projectOrWorkShopEnum", value = "车间/项目维度", dataType = "int", paramType = "query")
      }
   )
   @GetMapping("/wastage/costSummary/download")
   public void wastageLossCostSummaryDownload(
      HttpServletResponse response,
      @RequestParam(required = false) Integer year,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam @EnumValidator(value = ProjectOrWorkShopEnum.class, message = "车间/项目参数不存在!") Integer projectOrWorkShopEnum
   ) {
      this.workProgressStatisticsBiz.wastageLossCostSummaryDownload(response, year, projectId, workShopId, projectOrWorkShopEnum);
   }

   @ApiOperation("损耗及在制品详情(MES数据)")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "dateTimeList", value = "时间范围", dataType = "LocalDateTime", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "workShopId", value = "车间id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "taskTypeEnum", value = "产品类型", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "processId", value = "工序Id", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "产品编号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "groupId", value = "生产组Id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "productionLineId", value = "产线id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "relationType", value = "零件类型", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "projectOrWorkShopEnum", value = "车间/项目维度", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "lossWorkProgressStatisticsEnum", value = "查询状态", dataType = "int", paramType = "query")
      }
   )
   @GetMapping("/wastage/costSummary/mes/detail")
   public ResultVO wastageLossCostMesDetail(
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam Integer taskTypeEnum,
      @RequestParam(required = false) Integer processId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Long groupId,
      @RequestParam(required = false) Long productionLineId,
      @RequestParam(required = false) @EnumValidator(value = MachinePartRelationTypeEnum.class, message = "零件类型不存在!") Integer relationType,
      @RequestParam @EnumValidator(value = ProjectOrWorkShopEnum.class, message = "车间/项目参数不存在!") Integer projectOrWorkShopEnum,
      @RequestParam @EnumValidator(value = MesLossWorkProgressStatisticsEnum.class, message = "查询状态不存在!!") Integer lossWorkProgressStatisticsEnum,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      return ResultBuilder.success(
         this.workProgressStatisticsBiz
            .getPageWastageLossCostMesDetail(
               dateTimeList,
               projectId,
               workShopId,
               taskTypeEnum,
               processId,
               serialNumber,
               groupId,
               productionLineId,
               relationType,
               projectOrWorkShopEnum,
               lossWorkProgressStatisticsEnum,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("损耗及在制品详情(MES数据)下载")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "dateTimeList", value = "时间范围", dataType = "LocalDateTime", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "workShopId", value = "车间id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "taskTypeEnum", value = "产品类型", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "processId", value = "工序Id", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "产品编号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "groupId", value = "生产组Id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "productionLineId", value = "产线id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "relationType", value = "零件类型", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "projectOrWorkShopEnum", value = "车间/项目维度", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "lossWorkProgressStatisticsEnum", value = "查询状态", dataType = "int", paramType = "query")
      }
   )
   @GetMapping("/wastage/costSummary/mes/detail/download")
   public void wastageLossCostMesDetailDownload(
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam Integer taskTypeEnum,
      @RequestParam(required = false) Integer processId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Long groupId,
      @RequestParam(required = false) Long productionLineId,
      @RequestParam(required = false) @EnumValidator(value = MachinePartRelationTypeEnum.class, message = "零件类型不存在!") Integer relationType,
      @RequestParam @EnumValidator(value = ProjectOrWorkShopEnum.class, message = "车间/项目参数不存在!") Integer projectOrWorkShopEnum,
      @RequestParam @EnumValidator(value = MesLossWorkProgressStatisticsEnum.class, message = "查询状态不存在!!") Integer lossWorkProgressStatisticsEnum,
      HttpServletResponse response
   ) {
      this.workProgressStatisticsBiz
         .getPageWastageLossCostMesDetailDownload(
            dateTimeList,
            projectId,
            workShopId,
            taskTypeEnum,
            processId,
            serialNumber,
            groupId,
            productionLineId,
            relationType,
            projectOrWorkShopEnum,
            lossWorkProgressStatisticsEnum,
            response
         );
   }

   @ApiOperation("单车间/项目统计详情下载")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectIds", value = "项目ids", dataType = "List<Long>", paramType = "query"),
            @ApiImplicitParam(name = "workShopIds", value = "车间ids", dataType = "List<Long>", paramType = "query"),
            @ApiImplicitParam(name = "projectOrWorkShopEnum", value = "车间/项目维度", dataType = "int", paramType = "query")
      }
   )
   @GetMapping("/workshop/project/wastage/detail/download")
   public void workshopProjectWastageLossDetailDownload(
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam @EnumValidator(value = ProjectOrWorkShopEnum.class, message = "车间/项目参数不存在!") Integer projectOrWorkShopEnum,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：单车间/项目统计详情下载");
      this.workProgressStatisticsBiz.workshopProjectWastageLossDetailDownload(projectId, workShopId, projectOrWorkShopEnum, response);
   }

   @ApiOperation("物料领用量汇总")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "dateTimeList", value = "时间范围", dataType = "LocalDateTime", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "workShopId", value = "车间id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "basicClass", value = "物料基础类型", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "classifyName", value = "物料名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "lossWorkProgressStatisticsEnum", value = "查询状态", dataType = "int", paramType = "query")
      }
   )
   @GetMapping("/wastage/costSummary/picking/summary")
   public ResultVO getPickingSummary(
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam(required = false) Integer basicClass,
      @RequestParam(required = false) String classifyName,
      @RequestParam @EnumValidator(value = MesLossWorkProgressStatisticsEnum.class, message = "查询状态不存在!!") Integer lossWorkProgressStatisticsEnum
   ) {
      return ResultBuilder.success(
         this.workProgressStatisticsBiz.getPickingSummary(dateTimeList, lossWorkProgressStatisticsEnum, projectId, workShopId, basicClass, classifyName)
      );
   }

   @ApiOperation("物料领用详情")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "dateTimeList", value = "时间范围", dataType = "LocalDateTime", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "workShopId", value = "车间id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "basicClass", value = "物料基础类型", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "classifyName", value = "物料名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "lossWorkProgressStatisticsEnum", value = "查询状态", dataType = "int", paramType = "query")
      }
   )
   @GetMapping("/wastage/costSummary/picking/detail")
   public ResultVO getPagePickingDetailDTO(
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam(required = false) Integer basicClass,
      @RequestParam(required = false) String classifyName,
      @RequestParam @EnumValidator(value = MesLossWorkProgressStatisticsEnum.class, message = "查询状态不存在!!") Integer lossWorkProgressStatisticsEnum,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      return ResultBuilder.success(
         this.workProgressStatisticsBiz
            .getPagePickingDetailDTO(dateTimeList, lossWorkProgressStatisticsEnum, projectId, workShopId, basicClass, classifyName, pageNumber, pageSize)
      );
   }

   @ApiOperation("物料领用详情下载")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "dateTimeList", value = "时间范围", dataType = "LocalDateTime", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "workShopId", value = "车间id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "basicClass", value = "物料基础类型", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "classifyName", value = "物料名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "lossWorkProgressStatisticsEnum", value = "查询状态", dataType = "int", paramType = "query")
      }
   )
   @GetMapping("/wastage/costSummary/picking/detail/download")
   public void downloadPickingDetailDTO(
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam(required = false) Integer basicClass,
      @RequestParam(required = false) String classifyName,
      @RequestParam @EnumValidator(value = MesLossWorkProgressStatisticsEnum.class, message = "查询状态不存在!!") Integer lossWorkProgressStatisticsEnum,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：物料领用详情下载");
      this.workProgressStatisticsBiz
         .downloadPickingDetailDTO(dateTimeList, lossWorkProgressStatisticsEnum, projectId, workShopId, basicClass, classifyName, response);
   }
}
