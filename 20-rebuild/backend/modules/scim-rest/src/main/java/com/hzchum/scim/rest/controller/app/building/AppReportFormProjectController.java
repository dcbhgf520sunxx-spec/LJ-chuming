package com.hzchum.scim.rest.controller.app.building;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.biz.ContractVisaBiz;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.enums.visa.VisaModeEnum;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingCargoListBiz;
import com.hzchum.scim.mes.building.core.api.biz.complete.MesBuildingCompleteBiz;
import com.hzchum.scim.mes.building.core.api.biz.projectKanban.ProductKanbanBiz;
import com.hzchum.scim.mes.building.core.api.biz.projectKanban.ProjectKanbanBiz;
import com.hzchum.scim.mes.building.core.api.biz.qhse.MesBuildingQhseBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseArtifactFindDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseEnclosureFindDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListShipDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.ProductKanbanDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.projectKanban.get.ProductKanbanVORequest;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES发运-装车")
@RestController
@RequestMapping("/api/app/report_form")
public class AppReportFormProjectController {
   private static final Logger log = LoggerFactory.getLogger(AppReportFormProjectController.class);
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ContractProjectBiz projectBiz;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingQhseBiz qhseBiz;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Autowired
   private ProductKanbanBiz productKanbanBiz;
   @Autowired
   private ContractVisaBiz visaBiz;
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Autowired
   private MesBuildingCargoListBiz cargoListBiz;
   @Autowired
   private MesBuildingCompleteBiz completeBiz;
   @Autowired
   private ProjectKanbanBiz projectKanbanBiz;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Autowired
   private MesBuildingProduceTeamReportService reportService;

   @ApiOperation("我的项目列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header", required = true),
            @ApiImplicitParam(name = "status", value = "项目状态 1进行中 2暂停 4已完工", paramType = "query"),
            @ApiImplicitParam(name = "year", value = "项目年份 例如 2021", paramType = "query"),
            @ApiImplicitParam(name = "noName", value = "编号或简称", paramType = "query"),
            @ApiImplicitParam(name = "lumpSumSystemType", value = "包干制项目管理类型", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "条数", paramType = "query", defaultValue = "20")
      }
   )
   @GetMapping("/project/listMy")
   public ResultVO<PageVO<ProjectSimpleInfoDTO>> listSimpleProject(
      Integer status,
      Integer year,
      @RequestParam(value = "noOrName", required = false) String noName,
      @RequestParam(required = false) Integer lumpSumSystemType,
      @RequestParam(required = false) Integer level,
      Integer pageNumber,
      Integer pageSize
   ) {
      log.info("API 调用 ：查询用户相关的项目列表");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未获取到用户信息,查询失败!");
      return ResultBuilder.success(
         this.projectBiz
            .listMyProjects(
               status,
               null,
               year,
               noName,
               ProjectTypeEnum.MES.getType() | ProjectTypeEnum.BRIDGE.getType() | ProjectTypeEnum.BRIDGE.getType(),
               lumpSumSystemType,
               level,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("获取区域生产汇总")
   @GetMapping("/area/complete/sum")
   @PreAuthorize("@permission.check('paManufacture')")
   public ResultVO taskSum(
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "monomerId", required = false) Long monomerId,
      @RequestParam(name = "productType") Integer productType
   ) {
      log.info("API 调用 ：获取区域生产汇总");
      return ResultBuilder.success(new ListVO<>(this.taskService.completeSum(projectId, monomerId, productType)));
   }

   @ApiOperation("获取出库信息汇总")
   @GetMapping("/area/dispatch/sum")
   @PreAuthorize("@permission.check('paManufacture')")
   public ResultVO dispatchSum(
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "monomerId", required = false) Long monomerId,
      @RequestParam(name = "productType") Integer productType
   ) {
      log.info("API 调用 ：获取出库信息汇总");
      return ResultBuilder.success(new ListVO<>(this.warehouseRecordService.dispatchSum(projectId, monomerId, productType)));
   }

   @ApiOperation("分页获取QHSE列表")
   @GetMapping("/qhse/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "QhseSaveVORequest", value = "QhseSaveVORequest", paramType = "query", dataType = "long"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   @PreAuthorize("@permission.check('paQHSE')")
   public ResultVO qhsePage(
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "userName", required = false) String userName,
      @RequestParam(name = "dutyName", required = false) String dutyName,
      @RequestParam(name = "type", required = false) Integer type,
      @RequestParam(name = "status", required = false) Integer status,
      @RequestParam(name = "boolApp", required = false, defaultValue = "true") Boolean boolApp,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize,
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate
   ) {
      log.info("API 调用 ：分页获取QHSE列表");
      if (boolApp == null) {
         boolApp = true;
      }

      return ResultBuilder.success(
         this.qhseBiz
            .qhsePage(
               null,
               projectId,
               userName,
               dutyName,
               null,
               null,
               type,
               status,
               boolApp,
               UserUtil.getCurrentUserId(),
               sort,
               pageNumber,
               pageSize,
               startDate,
               endDate,
               null,
               null,
               null,
               null,
               null
            )
      );
   }

   @ApiOperation("获取签证列表")
   @GetMapping("/foreign")
   @PreAuthorize("@permission.check('paFeeVisa')")
   public ResultVO listForeign(Long projectId, Integer status, String userName, String checkUerName, String year, Integer businessType, Integer type) {
      log.info("API 调用 ：获取对外签证列表");
      return ResultBuilder.success(this.visaBiz.appVisa(projectId, status, userName, checkUerName, VisaModeEnum.FOREIGN.getType(), year, businessType, type));
   }

   @ApiOperation("获取项目收款开票信息")
   @GetMapping("/collection")
   @PreAuthorize("@permission.check('paInvoicing')")
   public ResultVO collectionInfo(Long projectId) {
      log.info("API 调用 ：获取项目收款开票信息");
      return ResultBuilder.success(this.projectBiz.collectionInfo(projectId));
   }

   @ApiOperation("获取产品生产报表汇总")
   @GetMapping("/product/page")
   @PreAuthorize("@permission.check('paManufacture')")
   public ResultVO productSummary(
      ProductKanbanVORequest voRequest,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize
   ) {
      log.info("API 调用 ：获取产品生产报表汇总");
      return ResultBuilder.success(this.productKanbanBiz.productKanbanPage(BeanUtil.copy(voRequest, ProductKanbanDTOParam.class), pageNumber, pageSize));
   }

   @ApiOperation("出入库看板-构件")
   @GetMapping("/warehouse/artifact/page")
   @PreAuthorize("@permission.check('paManufacture')")
   public ResultVO pageArtifact(WarehouseArtifactFindDOParam param) {
      log.info("API 调用 ：出入库看板-构件");
      return ResultBuilder.success(this.warehouseSummaryService.pageArtifact(param));
   }

   @ApiOperation("出入库看板-围护")
   @GetMapping("/warehouse/enclosure/page")
   public ResultVO getWarehouseRecordListPage(WarehouseEnclosureFindDOParam param) {
      log.info("API 调用 ：出入库看板-围护");
      return ResultBuilder.success(this.warehouseSummaryService.pageEnclosure(param));
   }

   @ApiOperation("发运记录-列表")
   @GetMapping("/ship")
   public ResultVO ship(CargoListShipDTOParam param) {
      log.info("API 调用 ：发运记录-列表");
      return ResultBuilder.success(this.cargoListBiz.pageShip(param));
   }

   @ApiOperation("获取班组当日生产记录")
   @GetMapping("/team/production")
   public ResultVO teamProduction(
      @RequestParam("teamId") Long teamId, @RequestParam("productType") Integer productType, @RequestParam("dateTime") LocalDateTime dateTime
   ) {
      log.info("API 调用 ：获取班组当日生产记录");
      return ResultBuilder.success(new ListVO<>(this.completeBiz.getTeamProduction(teamId, productType, dateTime)));
   }

   @ApiOperation("获取班组全年产量汇总，按月分组")
   @GetMapping("/team/month/production")
   public ResultVO teamMonthProduction(
      @RequestParam("teamId") Long teamId, @RequestParam("productType") Integer productType, @RequestParam("dateTime") LocalDateTime dateTime
   ) {
      log.info("API 调用 ：获取班组全年产量汇总，按月分组");
      return ResultBuilder.success(new ListVO<>(this.completeBiz.getTeamMeteByMonth(teamId, productType, dateTime)));
   }

   @ApiOperation("当前用户所在工序,产线列表")
   @GetMapping("/process/user/list")
   public ResultVO listProductionLineAndProcessUser() {
      log.info("API 调用 ：当前用户所在工序,产线列表");
      return ResultBuilder.success(this.teamUserLinkService.listProductionLineAndProcessUser());
   }

   @ApiOperation("当前用户所在工序的数据")
   @GetMapping("/process/produce/kanban")
   public ResultVO processProduceKanban(@RequestParam("teamId") Long teamId, @RequestParam("processId") Long processId, @RequestParam("groupsId") Long groupsId) {
      log.info("API 调用 ：当前用户所在工序的数据");
      return ResultBuilder.success(this.reportService.processProduceKanban(teamId, processId, groupsId));
   }

   @ApiOperation("获取工序下构件零件的清单数")
   @GetMapping("/process/summary")
   public ResultVO processSummary(Long projectId, Long monomerId, Long areaId, LocalDateTime dateTime) {
      log.info("API 调用 ：获取工序下构件零件的清单数");
      return ResultBuilder.success(this.projectKanbanBiz.processSummary(projectId, monomerId, areaId, dateTime, null, null, null, null, null));
   }

   @ApiOperation("获取生产明细详情")
   @GetMapping("/process/summary/detail/page")
   public ResultVO processSummaryDetailPage(
      Long projectId,
      Integer productType,
      Long processId,
      LocalDateTime dateTime,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取生产明细详情");
      return ResultBuilder.success(
         this.projectKanbanBiz
            .processSummaryDetailPage(projectId, null, null, dateTime, null, null, null, productType, processId, null, null, null, pageNumber, pageSize)
      );
   }
}
