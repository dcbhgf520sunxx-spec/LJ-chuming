package com.hzchum.scim.rest.controller.mes.building.projectKanban;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.mes.building.core.api.biz.projectKanban.ProductionSignageBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductKanBanCompanyStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductKanBanEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductStatusEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

@Api(tags = "MES项目看板V2")
@RestController
@RequestMapping("/api/mes/building/production/signage/project")
public class ProjectProductionSignageController {
   private static final Logger log = LoggerFactory.getLogger(ProjectProductionSignageController.class);
   @Resource
   private ProductionSignageBiz productionSignageBiz;

   @ApiOperation("获取项目生产看板汇总")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "workShopId", value = "车间Id", paramType = "query"),
            @ApiImplicitParam(name = "productionLineId", value = "产线Id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query"),
            @ApiImplicitParam(name = "areaIds", value = "区域Ids", paramType = "query"),
            @ApiImplicitParam(name = "areaBatchIds", value = "批次Id", paramType = "query")
      }
   )
   @GetMapping("/production/sum")
   @PreAuthorize("@permission.check('mes_project_panel:get','mes_project_panel_form_list:get','mes_project_panel_card_list:get')")
   public ResultVO projectSignageProductionSum(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam(required = false) Long productionLineId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) List<Long> areaIds,
      @RequestParam(required = false) List<Long> areaBatchIds
   ) {
      log.info("API 调用 ：获取项目生产看板汇总");
      return ResultBuilder.success(
         this.productionSignageBiz.projectSignageProductionSum(projectId, workShopId, productionLineId, monomerId, areaIds, areaBatchIds)
      );
   }

   @ApiOperation("获取项目生产看板产品类型列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "workShopId", value = "车间Id", paramType = "query"),
            @ApiImplicitParam(name = "productionLineId", value = "产线Id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query"),
            @ApiImplicitParam(name = "areaIds", value = "区域Ids", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "areaBatchIds", value = "批次Id", paramType = "query")
      }
   )
   @GetMapping("/artifact/class")
   @PreAuthorize("@permission.check('mes_project_panel_form_list:get','mes_project_panel_form_detail_task:detail')")
   public ResultVO projectSignageArtifactClass(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam(required = false) Long productionLineId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) List<Long> areaIds,
      @RequestParam Integer productType,
      @RequestParam(required = false) List<Long> areaBatchIds,
      @RequestParam(required = false, defaultValue = "false") Boolean boolNotIssued
   ) {
      log.info("API 调用 ：获取项目生产看板构件类型列表");
      return ResultBuilder.success(
         new ListVO<>(
            this.productionSignageBiz
               .projectSignageArtifactClass(projectId, workShopId, productionLineId, monomerId, areaIds, productType, areaBatchIds, boolNotIssued)
         )
      );
   }

   @ApiOperation("获取项目生产看板-工序列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query", required = true),
            @ApiImplicitParam(name = "areaIds", value = "区域Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "workshopId", value = "车间Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productionLineId", value = "产线Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "areaBatchId", value = "批次Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "assembleSerialNumber", value = "部件编号", paramType = "query", required = true)
      }
   )
   @GetMapping("/process")
   @PreAuthorize("@permission.check('mes_project_panel_form_list:get','mes_project_panel_form_goujian:detail')")
   public ResultVO projectSignageProcessList(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) List<Long> areaIds,
      @RequestParam(required = false) Long classId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) Long productionLineId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) List<Long> areaBatchIds,
      @RequestParam(required = false) String assembleSerialNumber
   ) {
      log.info("API 调用 ：获取项目生产看板-工序列表");
      return ResultBuilder.success(
         new ListVO<>(
            this.productionSignageBiz
               .projectSignageProcessList(
                  projectId, monomerId, areaIds, classId, workshopId, productionLineId, serialNumber, areaBatchIds, assembleSerialNumber
               )
         )
      );
   }

   @ApiOperation("获取项目生产看板-零件工序(切割方式)列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "workShopId", value = "车间Id", paramType = "query"),
            @ApiImplicitParam(name = "productionLineId", value = "产线Id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query"),
            @ApiImplicitParam(name = "areaIds", value = "区域Ids", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "areaBatchIds", value = "批次Id", paramType = "query")
      }
   )
   @GetMapping("/part/process")
   @PreAuthorize("@permission.check('mes_project_panel_form_detail_task:detail')")
   public ResultVO findProjectPartProcessList(
      @RequestParam Long projectId,
      @RequestParam(required = false) Integer productType,
      @RequestParam(required = false) Long workShopId,
      @RequestParam(required = false) Long productionLineId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) List<Long> areaIds,
      @RequestParam(required = false) List<Long> areaBatchIds
   ) {
      log.info("API 调用 ：获取项目生产看板-零件工序(切割方式)列表");
      return ResultBuilder.success(
         new ListVO<>(
            this.productionSignageBiz.findProjectPartProcessList(projectId, productType, workShopId, productionLineId, monomerId, areaIds, areaBatchIds)
         )
      );
   }

   @ApiOperation("获取项目生产看板-工序生产列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "workShopId", value = "车间Id", paramType = "query"),
            @ApiImplicitParam(name = "productionLineId", value = "产线Id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query"),
            @ApiImplicitParam(name = "areaIds", value = "区域Ids", paramType = "query"),
            @ApiImplicitParam(name = "classId", value = "构件种类Id", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "构件编号", paramType = "query"),
            @ApiImplicitParam(name = "assembleSerialNumber", value = "部件编号", paramType = "query"),
            @ApiImplicitParam(name = "dateTimeList", value = "排产时间", paramType = "query"),
            @ApiImplicitParam(name = "areaBatchIds", value = "批次Ids", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "20", dataType = "int", required = true)
      }
   )
   @GetMapping("/page/process/product")
   @PreAuthorize("@permission.check('mes_project_panel_form_list:get')")
   public ResultVO projectSignageProcessProductList(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long productionLineId,
      @RequestParam(required = false) List<Long> areaIds,
      @RequestParam(required = false) Long classId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String assembleSerialNumber,
      @RequestParam(required = false) @EnumValidator(value = ProductKanBanEnum.class, message = "状态不存在!") Integer productKanBanEnum,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(required = false) List<Long> areaBatchIds,
      @RequestParam(required = false) Long processId,
      @RequestParam(required = false) Integer processStatus,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：获取项目生产看板-工序生产列表");
      return ResultBuilder.success(
         this.productionSignageBiz
            .projectSignageProcessProductList(
               projectId,
               workShopId,
               productionLineId,
               monomerId,
               areaIds,
               classId,
               serialNumber,
               productKanBanEnum,
               dateTimeList,
               areaBatchIds,
               assembleSerialNumber,
               processId,
               processStatus,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("获取项目生产看板-下载")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "workShopId", value = "车间Id", paramType = "query"),
            @ApiImplicitParam(name = "productionLineId", value = "产线Id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query"),
            @ApiImplicitParam(name = "areaIds", value = "区域Ids", paramType = "query"),
            @ApiImplicitParam(name = "classId", value = "构件种类Id", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "构件编号", paramType = "query"),
            @ApiImplicitParam(name = "assembleSerialNumber", value = "部件编号", paramType = "query"),
            @ApiImplicitParam(name = "dateTimeList", value = "排产时间", paramType = "query")
      }
   )
   @GetMapping("/page/process/product/download")
   @PreAuthorize("@permission.check('mes_project_production_panel:download')")
   public void projectSignageProcessProductDownload(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long productionLineId,
      @RequestParam(required = false) List<Long> areaIds,
      @RequestParam(required = false) Long classId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String assembleSerialNumber,
      @RequestParam(required = false) @EnumValidator(value = ProductKanBanEnum.class, message = "状态不存在!") Integer productKanBanEnum,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(required = false) Long processId,
      @RequestParam(required = false) Integer processStatus,
      HttpServletResponse response
   ) throws IOException {
      log.info("API 调用 ：获取项目生产看板-工序生产列表");
      this.productionSignageBiz
         .projectSignageProcessProductDownload(
            projectId,
            workShopId,
            productionLineId,
            monomerId,
            areaIds,
            classId,
            serialNumber,
            assembleSerialNumber,
            productKanBanEnum,
            dateTimeList,
            processId,
            processStatus,
            response
         );
   }

   @ApiOperation("获取项目生产看板-工序任务生产详情")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "artifactTaskId", value = "构件任务Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "processId", value = "工序Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query", required = true),
            @ApiImplicitParam(name = "processType", value = "工序类型", paramType = "query", required = true)
      }
   )
   @GetMapping("/process/product/detail")
   @PreAuthorize("@permission.check('mes_project_panel_form_goujian:detail')")
   public ResultVO projectSignageProcessProductDetailList(
      @RequestParam Long artifactTaskId, @RequestParam Long processId, @RequestParam Integer productType, @RequestParam Integer processType
   ) {
      log.info("API 调用 ：获取项目生产看板-工序任务生产详情");
      return ResultBuilder.success(this.productionSignageBiz.projectSignageProcessProductDetailList(artifactTaskId, processId, productType, processType));
   }

   @ApiOperation("分页获取项目生产看板-产品生产状态")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query"),
            @ApiImplicitParam(name = "areaIds", value = "区域Ids", paramType = "query"),
            @ApiImplicitParam(name = "classId", value = "产品种类Id", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "产品编号", paramType = "query"),
            @ApiImplicitParam(name = "workShopId", value = "车间Id", paramType = "query"),
            @ApiImplicitParam(name = "productionLineId", value = "产线Id", paramType = "query"),
            @ApiImplicitParam(name = "processId", value = "工序Id", paramType = "query"),
            @ApiImplicitParam(name = "dateTimeList", value = "时间范围", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "productKanBanCompanyStatusEnum", value = "生产状态", paramType = "query"),
            @ApiImplicitParam(name = "productClassificationEnum", value = "产品分类", paramType = "query"),
            @ApiImplicitParam(name = "boolNotIssued", value = "是否仅看未下发", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query", required = true)
      }
   )
   @GetMapping("/page/product/production/state")
   @PreAuthorize("@permission.check('mes_project_panel_form_detail_task:detail')")
   public ResultVO pageProjectSignageProductProductionStateList(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) List<Long> areaIds,
      @RequestParam(required = false) Long classId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Long workShopId,
      @RequestParam(required = false) Long productionLineId,
      @RequestParam(required = false) Long processId,
      @RequestParam(required = false) Integer productClassificationEnum,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam Integer productType,
      @RequestParam(required = false) @EnumValidator(value = ProductKanBanCompanyStatusEnum.class, message = "状态不存在!") Integer productKanBanCompanyEnum,
      @RequestParam(required = false) List<Long> areaBatchIds,
      @RequestParam(required = false, defaultValue = "false") Boolean boolNotlssued,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：分页获取项目生产看板-产品生产状态");
      return ResultBuilder.success(
         this.productionSignageBiz
            .pageProjectSignageProductProductionStateList(
               projectId,
               monomerId,
               areaIds,
               classId,
               serialNumber,
               workShopId,
               productionLineId,
               processId,
               productClassificationEnum,
               dateTimeList,
               productType,
               productKanBanCompanyEnum,
               areaBatchIds,
               boolNotlssued,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("打印项目生产看板-产品生产状态")
   @GetMapping("/product/production/state/print")
   @PreAuthorize("@permission.check('mes_project_panel_form_print_task:print')")
   public ResultVO printProjectSignageProductProductionStateList(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) List<Long> areaIds,
      @RequestParam(required = false) Long classId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Long workShopId,
      @RequestParam(required = false) Long productionLineId,
      @RequestParam(required = false) Long processId,
      @RequestParam(required = false) Integer productClassificationEnum,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam Integer productType,
      @RequestParam(required = false) @EnumValidator(value = ProductKanBanCompanyStatusEnum.class, message = "状态不存在!") Integer productKanBanCompanyEnum,
      @RequestParam(required = false) List<Long> areaBatchIds,
      @RequestParam(required = false, defaultValue = "false") Boolean boolNotIssued
   ) {
      log.info("API 调用 ：打印项目生产看板-产品生产状态");
      return ResultBuilder.success(
         this.productionSignageBiz
            .printProjectSignageProductProductionStateList(
               projectId,
               monomerId,
               areaIds,
               classId,
               serialNumber,
               workShopId,
               productionLineId,
               processId,
               productClassificationEnum,
               dateTimeList,
               productType,
               productKanBanCompanyEnum,
               areaBatchIds,
               boolNotIssued
            )
      );
   }

   @ApiOperation("获取项目构件生产看板(卡片展示)")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域Id", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "构件编号", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "构件名称", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "构件规格", paramType = "query"),
            @ApiImplicitParam(name = "material", value = "构件材质", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "生产状态", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "20", dataType = "int", required = true)
      }
   )
   @GetMapping("/page/production/cardDisplay")
   @PreAuthorize("@permission.check('mes_project_panel_card_list:get')")
   public ResultVO projectProductionDashboardCardDisplay(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String material,
      @RequestParam(required = false) @EnumValidator(value = ProductStatusEnum.class, message = "生产状态不存在") Integer status,
      @RequestParam(required = false) Long areaBatchId
   ) {
      log.info("API 调用 ：获取项目构件生产看板(卡片展示)");
      return ResultBuilder.success(
         this.productionSignageBiz
            .projectProductionDashboardCardDisplay(projectId, monomerId, areaId, serialNumber, name, specification, material, status, areaBatchId)
      );
   }

   @ApiOperation("获取项目构件生产看板详情(卡片展示)")
   @ApiImplicitParams(@ApiImplicitParam(name = "productId", value = "产品Id", paramType = "query", required = true))
   @GetMapping("/page/production/cardDisplay/detail")
   @PreAuthorize("@permission.check('mes_project_panel_card_lingbujian:detail')")
   public ResultVO projectProductionDashboardCardDisplayDetail(@RequestParam Long productId) {
      log.info("API 调用 ：获取项目构件生产看板详情(卡片展示)");
      return ResultBuilder.success(this.productionSignageBiz.projectProductionDashboardCardDisplayDetail(productId));
   }

   @ApiOperation("获取项目构件生产看板任务工序详情(卡片展示)")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productId", value = "产品Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "artifactId", value = "构件Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query", required = true)
      }
   )
   @GetMapping("/page/production/cardDisplay/process/detail")
   @PreAuthorize("@permission.check('mes_project_panel_card_process:detail')")
   public ResultVO projectProductionDashboardCardDisplayProcessDetail(
      @RequestParam Long productId, @RequestParam Integer artifactId, @RequestParam Integer productType
   ) {
      log.info("API 调用 ：获取项目构件生产看板任务工序详情(卡片展示)");
      return ResultBuilder.success(
         new ListVO<>(this.productionSignageBiz.projectProductionDashboardCardDisplayProcessDetail(productId, artifactId, productType))
      );
   }

   @ApiOperation("获取车间产线班组列表")
   @ApiImplicitParams(@ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query", required = true))
   @GetMapping("/workshop/list")
   @PreAuthorize("@permission.check('mes_work_reporting_record:get')")
   public ResultVO getTeamReportProductWorkList(@RequestParam Integer productType) {
      log.info("API 调用 ：获取车间产线班组列表");
      return ResultBuilder.success(this.productionSignageBiz.getTeamReportProductWorkList(productType));
   }

   @ApiOperation("获取上报记录分页列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query", required = true),
            @ApiImplicitParam(name = "workShopId", value = "车间Id", paramType = "query"),
            @ApiImplicitParam(name = "productionLineId", value = "产线Id", paramType = "query"),
            @ApiImplicitParam(name = "teamId", value = "班组id", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域Id", paramType = "query"),
            @ApiImplicitParam(name = "areaBatchId", value = "批次Id", paramType = "query"),
            @ApiImplicitParam(name = "processId", value = "工序Id", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "产品编号", paramType = "query"),
            @ApiImplicitParam(name = "dateTimeList", value = "上报时间范围", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "20", dataType = "int", required = true)
      }
   )
   @GetMapping("/page/teamReport/product")
   @PreAuthorize("@permission.check('mes_work_reporting_record:get')")
   public ResultVO pageTeamReportProductList(
      @RequestParam Integer productType,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) Long productionLineId,
      @RequestParam(required = false) Long teamId,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long areaBatchId,
      @RequestParam(required = false) Long processId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "100") Integer pageSize
   ) {
      log.info("API 调用 ：获取上报记录分页列表");
      return ResultBuilder.success(
         this.productionSignageBiz
            .pageTeamReportProductList(
               productType,
               workshopId,
               productionLineId,
               teamId,
               projectId,
               monomerId,
               areaId,
               areaBatchId,
               processId,
               serialNumber,
               dateTimeList,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("打印上报记录列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query", required = true),
            @ApiImplicitParam(name = "workShopId", value = "车间Id", paramType = "query"),
            @ApiImplicitParam(name = "productionLineId", value = "产线Id", paramType = "query"),
            @ApiImplicitParam(name = "teamId", value = "班组id", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域Id", paramType = "query"),
            @ApiImplicitParam(name = "areaBatchId", value = "批次Id", paramType = "query"),
            @ApiImplicitParam(name = "processId", value = "工序Id", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "产品编号", paramType = "query"),
            @ApiImplicitParam(name = "dateTimeList", value = "上报时间范围", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "20", dataType = "int", required = true)
      }
   )
   @GetMapping("/teamReport/product/print")
   @PreAuthorize("@permission.check('mes_work_reporting_record:print')")
   public ResultVO printTeamReportProductList(
      @RequestParam Integer productType,
      @RequestParam(required = false) Long workShopId,
      @RequestParam(required = false) Long productionLineId,
      @RequestParam(required = false) Long teamId,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long areaBatchId,
      @RequestParam(required = false) Long processId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList
   ) {
      log.info("API 调用 ：打印上报记录列表");
      return ResultBuilder.success(
         this.productionSignageBiz
            .printTeamReportProductList(
               productType, workShopId, productionLineId, teamId, projectId, monomerId, areaId, areaBatchId, processId, serialNumber, dateTimeList
            )
      );
   }
}
