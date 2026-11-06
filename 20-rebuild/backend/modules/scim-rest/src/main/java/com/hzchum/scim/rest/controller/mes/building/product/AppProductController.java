package com.hzchum.scim.rest.controller.mes.building.product;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.biz.ProductBiz;
import com.hzchum.scim.plan.core.api.biz.TechArtifactBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.product.PlanProjectDTOParam;
import com.hzchum.scim.plan.core.api.pojo.vo.ArtifactSimpleVO;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-产品")
@RestController
@RequestMapping("/api/app/mes/product")
public class AppProductController {
   private static final Logger log = LoggerFactory.getLogger(AppProductController.class);
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseRecordService;
   @Autowired
   private ProductBiz productBiz;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private MesBuildingCargoListProductLinkService cargoListProductLinkService;
   @Resource
   private TechArtifactBiz techArtifactBiz;

   @ApiOperation("获取可操作库存数量")
   @GetMapping("warehouse")
   @PreAuthorize("@permission.check('pack','stockLoading')")
   public ResultVO list(
      @RequestParam(required = false) Long factoryId,
      @RequestParam Long productId,
      Long taskId,
      @RequestParam Integer productType,
      Long workshopId,
      Long warehouseId,
      @RequestParam(required = false) Integer number
   ) {
      log.info("API 调用 ：获取可操作库存数量");
      return ResultBuilder.success(this.warehouseRecordService.listByProduct(factoryId, productId, taskId, productType, workshopId, warehouseId, number));
   }

   @ApiOperation("项目总览")
   @GetMapping("project")
   public ResultVO list(PlanProjectDTOParam param) {
      log.info("API 调用 ：项目总览");
      return ResultBuilder.success(this.productBiz.listMetByProduct(param));
   }

   @ApiOperation(value = "获取构件清单汇总", notes = "获取构件清单汇总")
   @GetMapping("/listByCondition/summary")
   public ResultVO listPageArtifactByConditionSummary(
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Integer status,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String material
   ) {
      log.info("API 调用 ： 获取构件清单汇总");
      return ResultBuilder.success(
         this.artifactService.appListByConditionsSummary(projectId, monomerId, areaId, status, name, serialNumber, specification, material)
      );
   }

   @ApiOperation(value = "QHSE上报根据项目id区域id和构件编号查询构件信息", notes = "QHSE上报根据项目id区域id和构件编号查询构件信息")
   @GetMapping("/listArtifactDetail")
   public ResultVO listArtifactDetail(
      @RequestParam(required = false, name = "projectId") Long projectId,
      @RequestParam(required = false, name = "areaId") Long areaId,
      @RequestParam(required = false, name = "monomerId") Long monomerId,
      @RequestParam("serialNumber") String serialNumber,
      @RequestParam(required = false) Boolean boolCompleted,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ： 构件溯源-产品信息");
      return ResultBuilder.success(this.artifactService.listArtifactDetail(projectId, areaId, monomerId, serialNumber, boolCompleted, pageNumber, pageSize));
   }

   @ApiOperation(value = "QHSE上报模糊查询构件编号", notes = "QHSE上报模糊查询构件编号")
   @GetMapping("/listSerialNumber")
   public ResultVO listSerialNumber(
      @RequestParam(required = false, name = "projectId") Long projectId,
      @RequestParam(required = false, name = "areaId") Long areaId,
      @RequestParam(required = false, name = "monomerId") Long monomerId,
      @RequestParam("serialNumber") String serialNumber,
      @RequestParam(required = false) Boolean boolCompleted,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ： 模糊查询构件编号");
      return ResultBuilder.success(this.artifactService.listSerialNumber(projectId, areaId, monomerId, serialNumber, boolCompleted, pageNumber, pageSize));
   }

   @ApiOperation(value = "构件部件溯源-产品信息", notes = "构件部件溯源-产品信息")
   @GetMapping("")
   @PreAuthorize("@permission.check('productTrance')")
   public ResultVO artifactSourceProductList(
      @RequestParam("productId") Long productId,
      @RequestParam(required = false) Integer productType,
      @RequestParam(required = false) Long taskId,
      @RequestParam(required = false) Integer number
   ) {
      log.info("API 调用 ： 构件部件溯源-产品信息");
      if (productType == null || productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         return ResultBuilder.success(this.artifactService.artifactSourceProductList(productId, productType, taskId, number));
      } else {
         return productType.equals(ProductTypeEnum.ASSEMBLE.getType())
            ? ResultBuilder.success(this.assembleService.assembleSourceProductList(productId, productType, taskId, number))
            : null;
      }
   }

   @ApiOperation(value = "构件部件溯源-生产信息(工序信息)", notes = "构件部件溯源-生产信息(工序信息)")
   @GetMapping("/source/report/list")
   @PreAuthorize("@permission.check('productTrance')")
   public ResultVO artifactSourceReportProductList(
      @RequestParam("productId") Long productId,
      @RequestParam(required = false) Integer number,
      @RequestParam(required = false) Long taskId,
      @RequestParam(required = false) Integer productType
   ) {
      log.info("API 调用 ： 构件部件溯源-生产信息(工序信息)");
      return ResultBuilder.success(this.artifactService.artifactSourceReportProductList(productId, number, taskId, productType));
   }

   @ApiOperation(value = "构件溯源-生产信息(发运信息)", notes = "构件溯源-生产信息(发运信息)")
   @GetMapping("/source/report/cargo/list")
   @PreAuthorize("@permission.check('productTrance')")
   public ResultVO artifactSourceReportCargoList(
      @RequestParam("productId") Long productId, @RequestParam(required = false) Integer number, @RequestParam(required = false) Integer taskId
   ) {
      log.info("API 调用 ： 构件溯源-生产信息(发运信息)");
      return ResultBuilder.success(this.cargoListProductLinkService.artifactSourceReportCargoList(productId, number, taskId));
   }

   @ApiOperation(value = "部件溯源-产品信息", notes = "部件溯源-产品信息")
   @GetMapping("/assemble/source")
   public ResultVO assembleSourceProductList(
      @RequestParam("productId") Long productId,
      @RequestParam(required = false) Integer productType,
      @RequestParam(required = false) Long taskId,
      @RequestParam(required = false) Integer number
   ) {
      log.info("API 调用 ： 部件溯源-产品信息");
      return ResultBuilder.success(this.assembleService.assembleSourceProductList(productId, productType, taskId, number));
   }

   @ApiOperation(value = "部件溯源-生产信息(工序信息)", notes = "部件溯源-生产信息(工序信息)")
   @GetMapping("/assemble/source/report/list")
   public ResultVO assembleSourceReportProductList(
      @RequestParam("productId") Long productId, @RequestParam(required = false) Integer number, @RequestParam(required = false) Long taskId
   ) {
      log.info("API 调用 ： 部件溯源-生产信息(工序信息)");
      return ResultBuilder.success(this.assembleService.assembleSourceReportProductList(productId, number, taskId));
   }

   @ApiOperation("app产品溯源-根据构件编号搜索")
   @GetMapping("/getArtifact")
   public ResultVO getArtifact(
      @RequestParam String serialNumber,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Integer productType,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("Api调用:app产品溯源-根据构件编号搜索");
      return ResultBuilder.success(this.techArtifactBiz.getArtifact(serialNumber, pageNumber, pageSize, projectId, monomerId, areaId, productType));
   }

   @ApiOperation("app产品溯源-根据部件编号搜索")
   @GetMapping("/getAssemble")
   public ResultVO getAssemble(
      @RequestParam String serialNumber,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("Api调用:app产品溯源-根据部件编号搜索");
      Page<ArtifactSimpleVO> page = PageHelper.startPage(pageNumber, pageSize);
      List<ArtifactSimpleVO> assemble = this.assembleService.getAssemble(serialNumber, projectId, monomerId, areaId);
      return ResultBuilder.success(new PageVO<>(page, assemble));
   }
}
