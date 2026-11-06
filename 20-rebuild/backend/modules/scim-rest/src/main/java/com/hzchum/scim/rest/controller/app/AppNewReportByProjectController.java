package com.hzchum.scim.rest.controller.app;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingCargoListBiz;
import com.hzchum.scim.mes.building.core.api.biz.projectKanban.ProductKanbanBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingAreaProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingProjectProductDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES新报表中心--项目统计")
@RestController
@RequestMapping("/api/app/building/report/project")
public class AppNewReportByProjectController {
   private static final Logger log = LoggerFactory.getLogger(AppNewReportByProjectController.class);
   @Autowired
   private MesBuildingCargoListBiz cargoListBiz;
   @Autowired
   private ProductKanbanBiz productKanbanBiz;
   @Autowired
   private ContractProjectService contractProjectService;

   @ApiOperation("查询项目产品完成状态")
   @ApiImplicitParam(name = "status", value = "生产状态 1:未生产 2:生产中 4:已完成 ")
   @GetMapping("/product")
   @PreAuthorize("@permission.check('paManufacture')")
   public ResultVO productDetails(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer productType,
      String serialNumber,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "50") Integer pageSize,
      Integer status
   ) {
      log.info("API 调用 ：查询项目产品完成状态");
      return ResultBuilder.success(
         this.productKanbanBiz.appProductDetails(projectId, monomerId, areaId, productType, serialNumber, pageNumber, pageSize, status)
      );
   }

   @ApiOperation("查询项目单体下区域的生产详情")
   @GetMapping("/monomer/Details")
   @PreAuthorize("@permission.check('paManufacture')")
   public ResultVO<List<MesBuildingAreaProductDTO>> monomerDetails(Long projectId, Long monomerId, Integer productType) {
      log.info("API 调用 ：查询项目产品完成状态");
      return ResultBuilder.success(this.productKanbanBiz.monomerDetails(projectId, monomerId, productType));
   }

   @ApiOperation("查询项目生产详情")
   @GetMapping("/Details")
   @PreAuthorize("@permission.check('paManufacture')")
   public ResultVO<MesBuildingProjectProductDTO> projectDetails(Long projectId, Long monomerId, Long areaId) {
      log.info("API 调用 ：查询项目产品完成状态");
      return ResultBuilder.success(this.productKanbanBiz.projectDetails(projectId, monomerId, areaId));
   }

   @ApiOperation("获取构件工序汇总详情")
   @GetMapping("/detail/artifact")
   public ResultVO artifactDetail(Long id) {
      log.info("API 调用 ：获取构件工序汇总详情");
      return ResultBuilder.success(this.productKanbanBiz.artifactDetail(id));
   }

   @ApiOperation("获取组立工序汇总详情")
   @GetMapping("/detail/assemble")
   public ResultVO assembleDetail(Long id) {
      log.info("API 调用 ：获取组立工序汇总详情");
      return ResultBuilder.success(this.productKanbanBiz.assembleDetail(id));
   }

   @ApiOperation("获取组立工序汇总详情")
   @GetMapping("/detail/machine_part")
   public ResultVO machinePartDetail(Long id) {
      log.info("API 调用 ：获取组立工序汇总详情");
      return ResultBuilder.success(this.productKanbanBiz.machinePartDetail(id));
   }

   @ApiOperation("发运进度-项目下单体下发运信息")
   @GetMapping("/monomer/list")
   @PreAuthorize("@permission.check('paShipState')")
   public ResultVO projectByMonomerCargoList(Long projectId) {
      log.info("API 调用 ：发运进度-项目下单体下发运信息");
      return ResultBuilder.success(this.cargoListBiz.projectByMonomerCargoList(projectId));
   }

   @ApiOperation("发运进度-项目下发运记录")
   @GetMapping("/ship/list")
   @PreAuthorize("@permission.check('paShipState')")
   public ResultVO cargoListShipByProject(Long projectId) {
      log.info("API 调用 ：发运进度-项目下发运记录");
      return ResultBuilder.success(this.cargoListBiz.cargoListShipByProject(projectId));
   }

   @ApiOperation("发运进度-项目下发运信息汇总")
   @GetMapping("/cargo/summary")
   @PreAuthorize("@permission.check('paShipState')")
   public ResultVO projectCargoListSummary(Long projectId) {
      log.info("API 调用 ：发运进度-项目下发运信息汇总");
      return ResultBuilder.success(this.cargoListBiz.projectCargoListSummary(projectId));
   }

   @ApiOperation("发运进度-项目区域下发运信息")
   @GetMapping("/area/list")
   @PreAuthorize("@permission.check('paShipState')")
   public ResultVO projectByAreaCargoList(Long projectId, Long monomerId) {
      log.info("API 调用 ：发运进度-项目区域下发运信息");
      return ResultBuilder.success(this.cargoListBiz.projectByAreaCargoList(projectId, monomerId));
   }

   @ApiOperation("发运进度-项目区域下产品发运信息-分页")
   @GetMapping("/area/product/page")
   @PreAuthorize("@permission.check('paShipState')")
   @ApiImplicitParam(name = "type", value = "发运状态 1:未发运 2:部分发运 4:已发运 ")
   public ResultVO projectByAreaProductCargoPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer type,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：发运进度-项目区域下产品发运信息-分页");
      return ResultBuilder.success(this.cargoListBiz.projectByAreaProductCargoPage(projectId, monomerId, areaId, serialNumber, type, pageNumber, pageSize));
   }
}
