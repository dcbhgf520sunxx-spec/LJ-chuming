package com.hzchum.scim.rest.controller.mes.building.common;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingSupplierPriceBiz;
import com.hzchum.scim.mes.building.core.api.enums.WorkShopTypeEnum;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-公共")
@RestController
@RequestMapping("/api/app/mes/building")
public class AppMesCommonController {
   private static final Logger log = LoggerFactory.getLogger(AppMesCommonController.class);
   @Autowired
   private MesBuildingSupplierPriceBiz supplierPriceBiz;
   @Autowired
   private MesBuildingFactoryService factoryService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesBuildingTeamService teamService;

   @ApiOperation("查询物流单位")
   @GetMapping("/supplier/price/simple")
   public ResultVO getPackageList(
      @RequestParam Long projectId, @RequestParam(required = false) String licensePlate, @RequestParam(required = false) Long cargoListId
   ) {
      log.info("API 调用 ：查询物流单位");
      return ResultBuilder.success(this.supplierPriceBiz.getInfo(projectId, licensePlate, cargoListId));
   }

   @ApiOperation("查询项目物流配置信息")
   @GetMapping("/supplier-licensePlate")
   public ResultVO getSupplierAndLicensePlate(@RequestParam Long projectId) {
      log.info("API 调用 ：查询项目物流配置信息");
      return ResultBuilder.success(this.supplierPriceBiz.getSupplierAndLicensePlate(projectId));
   }

   @ApiOperation("查询工厂列表")
   @GetMapping("/factory/simple")
   public ResultVO listFactory() {
      log.info("API 调用 ：查询工厂列表");
      return ResultBuilder.success(this.factoryService.listFactorySimple());
   }

   @ApiOperation("查询当前用户所在工厂列表")
   @GetMapping("/factory/user/simple")
   public ResultVO listFactoryUser() {
      log.info("API 调用 ：查询当前用户所在工厂列表");
      return ResultBuilder.success(this.factoryService.listFactoryUser());
   }

   @ApiOperation("查询车间列表")
   @GetMapping("/workshop/simple")
   public ResultVO listWorkShop(Long factoryId) {
      log.info("API 调用 ：查询车间列表");
      return ResultBuilder.success(this.workshopService.listWorkShopSimple(factoryId, WorkShopTypeEnum.BUILDING.getType()));
   }

   @ApiOperation("查询当前用户所在车间列表")
   @GetMapping("/workshop/user/simple")
   public ResultVO listWorkShopUser(Long factoryId) {
      log.info("API 调用 ：查询当前用户所在车间列表");
      return ResultBuilder.success(this.workshopService.listWorkShopUser(factoryId, WorkShopTypeEnum.BUILDING.getType()));
   }

   @ApiOperation("查询生产线列表")
   @GetMapping("/production-line/simple")
   public ResultVO listProductionLine(Long workshopId) {
      log.info("API 调用 ：查询生产线列表");
      return ResultBuilder.success(this.productionLineService.listProductionLineSimple(workshopId));
   }

   @ApiOperation("查询当前用户所在生产线列表")
   @GetMapping("/production-line/user/simple")
   public ResultVO listProductionLineUser(Long workshopId) {
      log.info("API 调用 ：查询当前用户所在生产线列表");
      return ResultBuilder.success(this.productionLineService.listProductionLineUser(workshopId));
   }

   @ApiOperation("查询当前用户所在班组工序列表")
   @GetMapping("/team/user/simple")
   public ResultVO listTeamUser(Long productionLineId) {
      log.info("API 调用 ：查询当前用户所在班组列表");
      return ResultBuilder.success(this.teamService.listTeamUser(productionLineId));
   }
}
