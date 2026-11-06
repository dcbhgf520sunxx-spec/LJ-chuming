package com.hzchum.scim.rest.controller.largeScreen;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.rest.pojo.request.large_screen.KanbanQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "发运看板大屏")
@RestController
@RequestMapping("/api/large-screen/shipping-kanban")
public class ShippingKanbanLargeScreenController {
   private static final Logger log = LoggerFactory.getLogger(ShippingKanbanLargeScreenController.class);
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private MesBuildingCargoListService cargoListService;
   @Autowired
   private InitializationService service;

   @ApiOperation("顶部数据")
   @GetMapping("top-data")
   public ResultVO topData(KanbanQuery query) {
      log.info("API调用: 发运看板大屏-顶部数据");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      JSONObject result = new JSONObject();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(result);
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      int projectTotalQuantity = projectList.size();
      List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
         .lambdaQuery()
         .in(MesBuildingWarehouseRecord::getProjectId, projectIdList)
         .eq(query.getWorkshopId() != null, MesBuildingWarehouseRecord::getWorkshopId, query.getWorkshopId())
         .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
         .eq(MesBuildingWarehouseRecord::getWarehouseType, WarehouseTypeProductReturnEnum.NORMAL.getType())
         .list();
      List<Long> artifactIdList = warehouseRecordList.stream().map(MesBuildingWarehouseRecord::getProductId).distinct().collect(Collectors.toList());
      Map<Long, TechArtifact> artifactMap = Optional.of(artifactIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.artifactService::listByIds)
         .orElseGet(Collections::emptyList)
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      BigDecimal outboundVolume = warehouseRecordList.stream()
         .filter(warehouseRecord -> ObjectUtil.equal(warehouseRecord.getType(), 2))
         .map(
            warehouseRecord -> {
               BigDecimal weight = ObjectUtil.defaultIfNull(
                  artifactMap.getOrDefault(warehouseRecord.getProductId(), new TechArtifact()).getGrossWeight(), BigDecimal.ZERO
               );
               return warehouseRecord.getQuantity().multiply(weight).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
            }
         )
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal inboundVolume = warehouseRecordList.stream()
         .filter(warehouseRecord -> ObjectUtil.equal(warehouseRecord.getType(), 1))
         .map(
            warehouseRecord -> {
               BigDecimal weight = ObjectUtil.defaultIfNull(
                  artifactMap.getOrDefault(warehouseRecord.getProductId(), new TechArtifact()).getGrossWeight(), BigDecimal.ZERO
               );
               return warehouseRecord.getQuantity().multiply(weight).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
            }
         )
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal thisMonthInboundVolume = warehouseRecordList.stream()
         .filter(warehouseRecord -> ObjectUtil.equal(warehouseRecord.getType(), 1))
         .filter(warehouseRecord -> ObjectUtil.equal(warehouseRecord.getInYearMonthDate(), YearMonth.now().toString()))
         .map(
            warehouseRecord -> {
               BigDecimal weight = ObjectUtil.defaultIfNull(
                  artifactMap.getOrDefault(warehouseRecord.getProductId(), new TechArtifact()).getGrossWeight(), BigDecimal.ZERO
               );
               return warehouseRecord.getQuantity().multiply(weight).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
            }
         )
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal todayOutboundVolume = warehouseRecordList.stream()
         .filter(warehouseRecord -> ObjectUtil.equal(warehouseRecord.getType(), 2))
         .filter(warehouseRecord -> ObjectUtil.equal(warehouseRecord.getInYearMonthDayDate(), LocalDate.now().toString()))
         .map(
            warehouseRecord -> {
               BigDecimal weight = ObjectUtil.defaultIfNull(
                  artifactMap.getOrDefault(warehouseRecord.getProductId(), new TechArtifact()).getGrossWeight(), BigDecimal.ZERO
               );
               return warehouseRecord.getQuantity().multiply(weight).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
            }
         )
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      int todayShippedTrips = this.cargoListService
         .lambdaQuery()
         .in(MesBuildingCargoList::getProjectId, projectIdList)
         .in(MesBuildingCargoList::getStatus, 4, 8)
         .eq(MesBuildingCargoList::getDeliveryStatus, 1)
         .apply("DATE(audit_time) = {0}", LocalDate.now())
         .list()
         .size();
      result.put("projectTotalQuantity", projectTotalQuantity);
      result.put("outboundVolume", outboundVolume);
      result.put("inboundVolume", inboundVolume);
      result.put("thisMonthInboundVolume", thisMonthInboundVolume);
      result.put("todayOutboundVolume", todayOutboundVolume);
      result.put("todayShippedTrips", todayShippedTrips);
      return ResultBuilder.success(result);
   }

   @ApiOperation("实时发运数据")
   @GetMapping("real-time-shipping-data")
   public ResultVO realTimeShippingData(KanbanQuery query) {
      log.info("API调用: 发运看板大屏-实时发运数据");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      Map<Long, TechArtifact> artifactMap = this.artifactService
         .lambdaQuery()
         .in(TechArtifact::getProjectId, projectIdList)
         .list()
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      Map<Long, BigDecimal> artifactVolumeMap = artifactMap.values()
         .stream()
         .collect(
            Collectors.toMap(
               TechArtifact::getProjectId,
               v -> v.getGrossWeight().multiply(BigDecimal.valueOf(v.getQuantity().intValue())).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP),
               BigDecimal::add
            )
         );
      List<MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService
         .lambdaQuery()
         .in(MesBuildingWarehouseSummary::getProjectId, projectIdList)
         .eq(query.getWorkshopId() != null, MesBuildingWarehouseSummary::getWorkshopId, query.getWorkshopId())
         .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ARTIFACT.getType())
         .eq(MesBuildingWarehouseSummary::getWarehouseType, WarehouseTypeProductReturnEnum.NORMAL.getType())
         .list();
      Map<Long, BigDecimal> inboundVolumeMap = warehouseSummaryList.stream()
         .filter(warehouseSummary -> ObjectUtil.equal(warehouseSummary.getType(), 1))
         .collect(Collectors.toMap(MesBuildingWarehouseSummary::getProjectId, v -> {
            BigDecimal weight = ObjectUtil.defaultIfNull(artifactMap.getOrDefault(v.getProductId(), new TechArtifact()).getGrossWeight(), BigDecimal.ZERO);
            return v.getQuantity().multiply(weight).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
         }, BigDecimal::add));
      Map<Long, BigDecimal> outboundVolumeMap = warehouseSummaryList.stream()
         .filter(warehouseSummary -> ObjectUtil.equal(warehouseSummary.getType(), 2))
         .collect(Collectors.toMap(MesBuildingWarehouseSummary::getProjectId, v -> {
            BigDecimal weight = ObjectUtil.defaultIfNull(artifactMap.getOrDefault(v.getProductId(), new TechArtifact()).getGrossWeight(), BigDecimal.ZERO);
            return v.getQuantity().multiply(weight).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
         }, BigDecimal::add));
      Map<Long, BigDecimal> inventoryVolumeMap = warehouseSummaryList.stream()
         .filter(warehouseSummary -> ObjectUtil.equal(warehouseSummary.getType(), 1))
         .collect(Collectors.toMap(MesBuildingWarehouseSummary::getProjectId, v -> {
            BigDecimal weight = ObjectUtil.defaultIfNull(artifactMap.getOrDefault(v.getProductId(), new TechArtifact()).getGrossWeight(), BigDecimal.ZERO);
            BigDecimal quantity = v.getQuantity().subtract(v.getPackageQuantity()).subtract(v.getCargoQuantity());
            return quantity.multiply(weight).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
         }, BigDecimal::add));
      List<JSONObject> resultList = projectList.stream().map(project -> {
         BigDecimal inboundVolume = inboundVolumeMap.getOrDefault(project.getId(), BigDecimal.ZERO);
         BigDecimal outboundVolume = outboundVolumeMap.getOrDefault(project.getId(), BigDecimal.ZERO);
         BigDecimal inventoryVolume = inventoryVolumeMap.getOrDefault(project.getId(), BigDecimal.ZERO);
         BigDecimal shippingRate = BigDecimal.ZERO;
         if (ObjectUtil.notEqual(inboundVolume, BigDecimal.ZERO)) {
            shippingRate = outboundVolume.divide(inboundVolume, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L));
         }

         JSONObject result = new JSONObject();
         result.put("projectId", project.getId());
         result.put("projectName", project.getName());
         result.put("projectShortName", project.getShortName());
         result.put("projectSerialNumber", project.getSerialNumber());
         result.put("artifactVolume", artifactVolumeMap.getOrDefault(project.getId(), BigDecimal.ZERO));
         result.put("inboundVolume", inboundVolume);
         result.put("outboundVolume", outboundVolume);
         result.put("inventoryVolume", inventoryVolume);
         result.put("shippingRate", shippingRate);
         return result;
      }).collect(Collectors.toList());
      return ResultBuilder.success(resultList);
   }

   @ApiOperation("本月发运分析")
   @GetMapping("this-month-shipping-analysis")
   public ResultVO thisMonthShippingAnalysis(KanbanQuery query) {
      log.info("API调用: 发运看板大屏-本月发运分析");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      JSONObject result = new JSONObject();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(result);
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      Map<Long, TechArtifact> artifactMap = this.artifactService
         .lambdaQuery()
         .in(TechArtifact::getProjectId, projectIdList)
         .list()
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      YearMonth nowYearMonth = YearMonth.now();
      YearMonth lastYearMonth = nowYearMonth.minusMonths(1L);
      List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
         .lambdaQuery()
         .in(MesBuildingWarehouseRecord::getProjectId, projectIdList)
         .eq(query.getWorkshopId() != null, MesBuildingWarehouseRecord::getWorkshopId, query.getWorkshopId())
         .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
         .eq(MesBuildingWarehouseRecord::getWarehouseType, WarehouseTypeProductReturnEnum.NORMAL.getType())
         .eq(MesBuildingWarehouseRecord::getType, 2)
         .ge(MesBuildingWarehouseRecord::getInYearMonthDate, lastYearMonth)
         .list();
      BigDecimal lastMonthOutboundVolume = warehouseRecordList.stream()
         .filter(warehouseRecord -> ObjectUtil.equal(warehouseRecord.getInYearMonthDate(), lastYearMonth.toString()))
         .map(
            warehouseRecord -> {
               BigDecimal weight = ObjectUtil.defaultIfNull(
                  artifactMap.getOrDefault(warehouseRecord.getProductId(), new TechArtifact()).getGrossWeight(), BigDecimal.ZERO
               );
               return warehouseRecord.getQuantity().multiply(weight).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
            }
         )
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      Map<Long, BigDecimal> thisMonthOutboundVolumeMap = warehouseRecordList.stream()
         .filter(warehouseRecord -> ObjectUtil.equal(warehouseRecord.getInYearMonthDate(), nowYearMonth.toString()))
         .collect(Collectors.toMap(MesBuildingWarehouseRecord::getProjectId, v -> {
            BigDecimal weight = ObjectUtil.defaultIfNull(artifactMap.getOrDefault(v.getProductId(), new TechArtifact()).getGrossWeight(), BigDecimal.ZERO);
            return v.getQuantity().multiply(weight).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
         }, BigDecimal::add));
      BigDecimal thisMonthTotalOutboundVolume = thisMonthOutboundVolumeMap.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
      List<JSONObject> thisMonthOutboundList = projectList.stream().map(project -> {
         BigDecimal outboundVolume = thisMonthOutboundVolumeMap.getOrDefault(project.getId(), BigDecimal.ZERO);
         BigDecimal outboundRate = BigDecimal.ZERO;
         if (ObjectUtil.notEqual(thisMonthTotalOutboundVolume, BigDecimal.ZERO)) {
            outboundRate = outboundVolume.divide(thisMonthTotalOutboundVolume, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L));
         }

         JSONObject thisMonthOutboundInfo = new JSONObject();
         thisMonthOutboundInfo.put("projectId", project.getId());
         thisMonthOutboundInfo.put("projectName", project.getName());
         thisMonthOutboundInfo.put("projectShortName", project.getShortName());
         thisMonthOutboundInfo.put("projectSerialNumber", project.getSerialNumber());
         thisMonthOutboundInfo.put("outboundVolume", outboundVolume);
         thisMonthOutboundInfo.put("outboundRate", outboundRate);
         return thisMonthOutboundInfo;
      }).collect(Collectors.toList());
      result.put("lastMonthOutboundVolume", lastMonthOutboundVolume);
      result.put("thisMonthOutboundList", thisMonthOutboundList);
      return ResultBuilder.success(result);
   }

   @ApiOperation("本月入库分析")
   @GetMapping("this-month-inbound-analysis")
   public ResultVO thisMonthInboundAnalysis(KanbanQuery query) {
      log.info("API调用: 发运看板大屏-本月入库分析");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      JSONObject result = new JSONObject();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(result);
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      Map<Long, TechArtifact> artifactMap = this.artifactService
         .lambdaQuery()
         .in(TechArtifact::getProjectId, projectIdList)
         .list()
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      YearMonth nowYearMonth = YearMonth.now();
      YearMonth lastYearMonth = nowYearMonth.minusMonths(1L);
      List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
         .lambdaQuery()
         .in(MesBuildingWarehouseRecord::getProjectId, projectIdList)
         .eq(query.getWorkshopId() != null, MesBuildingWarehouseRecord::getWorkshopId, query.getWorkshopId())
         .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
         .eq(MesBuildingWarehouseRecord::getWarehouseType, WarehouseTypeProductReturnEnum.NORMAL.getType())
         .eq(MesBuildingWarehouseRecord::getType, 1)
         .ge(MesBuildingWarehouseRecord::getInYearMonthDate, lastYearMonth)
         .list();
      BigDecimal lastMonthInboundVolume = warehouseRecordList.stream()
         .filter(warehouseRecord -> ObjectUtil.equal(warehouseRecord.getInYearMonthDate(), lastYearMonth.toString()))
         .map(
            warehouseRecord -> {
               BigDecimal weight = ObjectUtil.defaultIfNull(
                  artifactMap.getOrDefault(warehouseRecord.getProductId(), new TechArtifact()).getGrossWeight(), BigDecimal.ZERO
               );
               return warehouseRecord.getQuantity().multiply(weight).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
            }
         )
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      Map<Long, BigDecimal> thisMonthInboundVolumeMap = warehouseRecordList.stream()
         .filter(warehouseRecord -> ObjectUtil.equal(warehouseRecord.getInYearMonthDate(), nowYearMonth.toString()))
         .collect(Collectors.toMap(MesBuildingWarehouseRecord::getProjectId, v -> {
            BigDecimal weight = ObjectUtil.defaultIfNull(artifactMap.getOrDefault(v.getProductId(), new TechArtifact()).getGrossWeight(), BigDecimal.ZERO);
            return v.getQuantity().multiply(weight).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
         }, BigDecimal::add));
      BigDecimal thisMonthTotalInboundVolume = thisMonthInboundVolumeMap.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
      List<JSONObject> thisMonthInboundList = projectList.stream().map(project -> {
         BigDecimal InboundVolume = thisMonthInboundVolumeMap.getOrDefault(project.getId(), BigDecimal.ZERO);
         BigDecimal InboundRate = BigDecimal.ZERO;
         if (ObjectUtil.notEqual(thisMonthTotalInboundVolume, BigDecimal.ZERO)) {
            InboundRate = InboundVolume.divide(thisMonthTotalInboundVolume, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L));
         }

         JSONObject thisMonthInboundInfo = new JSONObject();
         thisMonthInboundInfo.put("projectId", project.getId());
         thisMonthInboundInfo.put("projectName", project.getName());
         thisMonthInboundInfo.put("projectShortName", project.getShortName());
         thisMonthInboundInfo.put("projectSerialNumber", project.getSerialNumber());
         thisMonthInboundInfo.put("InboundVolume", InboundVolume);
         thisMonthInboundInfo.put("InboundRate", InboundRate);
         return thisMonthInboundInfo;
      }).collect(Collectors.toList());
      result.put("lastMonthInboundVolume", lastMonthInboundVolume);
      result.put("thisMonthInboundList", thisMonthInboundList);
      return ResultBuilder.success(result);
   }

   @ApiOperation("近3天发运车次")
   @GetMapping("recent-three-days-shipping-trips")
   public ResultVO recentThreeDaysShippingTrips(KanbanQuery query) {
      log.info("API调用: 发运看板大屏-近3天发运车次");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      Map<Long, ContractProject> projectMap = projectList.stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      List<Map<String, Object>> cargoListList = this.cargoListService
         .listMaps(
            ((QueryWrapper)((QueryWrapper)((QueryWrapper)((QueryWrapper)((QueryWrapper)new QueryWrapper().in("status", 4, 8)).eq("delivery_status", 1))
                        .in("project_id", projectIdList))
                     .apply("DATE(audit_time) >= {0}", LocalDate.now().minusDays(3L)))
                  .groupBy("project_id", "license_plate"))
               .select(
                  "project_id AS projectId",
                  "license_plate AS licensePlate",
                  "(sum(ifnull(total_net_weight, 0)) / 1000) AS totalNetWeight",
                  "(sum(ifnull(actual_weight, 0)) / 1000) AS actualWeight",
                  "(sum(ifnull(total_net_weight, 0)) / 1000) - (sum(ifnull(actual_weight, 0)) / 1000) AS difference"
               )
         );
      cargoListList.forEach(cl -> {
         Long projectId = MapUtil.getLong((Map<?, ?>)cl, "projectId");
         ContractProject cProject = projectMap.getOrDefault(projectId, new ContractProject());
         cl.put("projectName", cProject.getName());
         cl.put("projectShortName", cProject.getShortName());
         cl.put("projectSerialNumber", cProject.getSerialNumber());
      });
      return ResultBuilder.success(cargoListList);
   }

   @ApiOperation("制成品库存前三")
   @GetMapping("finished-products-inventory-top-three")
   public ResultVO finishedProductsInventoryTopThree(KanbanQuery query) {
      log.info("API调用: 发运看板大屏-制成品库存前三");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      Map<Long, ContractProject> projectMap = projectList.stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      List<MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService
         .lambdaQuery()
         .in(MesBuildingWarehouseSummary::getProjectId, projectIdList)
         .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ARTIFACT.getType())
         .eq(query.getWorkshopId() != null, MesBuildingWarehouseSummary::getWorkshopId, query.getWorkshopId())
         .eq(MesBuildingWarehouseSummary::getType, 1)
         .eq(MesBuildingWarehouseSummary::getWarehouseType, WarehouseTypeProductReturnEnum.NORMAL.getType())
         .apply("quantity > (package_quantity + cargo_quantity)")
         .list();
      List<Long> artifactIdList = warehouseSummaryList.stream().map(MesBuildingWarehouseSummary::getProductId).distinct().collect(Collectors.toList());
      Map<Long, TechArtifact> artifactMap = Optional.of(artifactIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.artifactService::listByIds)
         .orElseGet(Collections::emptyList)
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<JSONObject> allResultList = new ArrayList<>();
      warehouseSummaryList.stream()
         .collect(
            Collectors.groupingBy(
               MesBuildingWarehouseSummary::getProjectId,
               Collectors.mapping(
                  v -> {
                     BigDecimal inventoryQuantity = v.getQuantity().subtract(v.getPackageQuantity()).subtract(v.getCargoQuantity());
                     BigDecimal weight = Optional.ofNullable(artifactMap.get(v.getProductId()))
                        .filter(x$0 -> BeanUtil.isNotEmpty(x$0))
                        .map(TechArtifact::getGrossWeight)
                        .orElse(BigDecimal.ZERO);
                     return inventoryQuantity.multiply(weight).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
                  },
                  Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
               )
            )
         )
         .forEach((projectId, weight) -> {
            ContractProject cProject = projectMap.get(projectId);
            if (BeanUtil.isNotEmpty(cProject)) {
               JSONObject result = new JSONObject();
               result.put("projectId", projectId);
               result.put("projectName", cProject.getName());
               result.put("projectShortName", cProject.getShortName());
               result.put("projectSerialNumber", cProject.getSerialNumber());
               result.put("finishedProductWeight", weight);
               allResultList.add(result);
            }
         });
      List<JSONObject> resultList = allResultList.stream()
         .sorted(Comparator.comparing(ke -> ObjectUtil.defaultIfNull(ke.getBigDecimal("finishedProductWeight"), BigDecimal.ZERO), Comparator.reverseOrder()))
         .limit(3L)
         .collect(Collectors.toList());
      return ResultBuilder.success(resultList);
   }

   @ApiOperation("实时入库信息")
   @GetMapping("real-time-inbound-info")
   public ResultVO realTimeInboundInfo(KanbanQuery query) {
      log.info("API调用: 发运看板大屏-实时入库信息");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      String sql = "SELECT t.*, project.serial_number AS projectSerialNumber, project.short_name AS projectShortName, project.name AS projectName, monmoer.name AS monomerName, area.name AS areaName, product.serial_number AS productSerialNumber FROM ( SELECT mbwr.project_id AS projectId, mbwr.monomer_id AS monomerId, mbwr.area_id AS areaId, mbwr.product_id AS productId, SUM(IFNULL(mbwr.quantity, 0)) AS quantity FROM mes_building_warehouse_record mbwr WHERE mbwr.bool_delete_enum = 0   AND mbwr.type = 1   AND mbwr.product_type = 2   AND mbwr.project_id IN ({0})   {1}   {2} GROUP BY mbwr.project_id, mbwr.monomer_id, mbwr.area_id, mbwr.product_id ) t LEFT JOIN contract_project project ON project.bool_delete_enum = 0 AND project.id = t.projectId LEFT JOIN plan_monomer monmoer ON monmoer.bool_delete_enum = 0 AND monmoer.id = t.monomerId LEFT JOIN plan_area area ON area.bool_delete_enum = 0 AND area.id = t.areaId LEFT JOIN tech_artifact product ON product.bool_delete_enum = 0 AND product.id = t.productId";
      String param0 = CollUtil.join(projectIdList, ",");
      String param1 = Optional.ofNullable(query.getWorkshopId()).map(o -> "AND mbwr.workshop_id = " + o).orElse("");
      String param2 = "AND DATE_FORMAT(mbwr.create_time, '%Y-%m-%d %H') >= '"
         + LocalDateTime.now().minusHours(24L).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH"))
         + "'";
      String finalSql = StrUtil.indexedFormat(sql, param0, param1, param2);
      List<JSONObject> resultList = this.service.selectList(finalSql);
      return ResultBuilder.success(resultList);
   }

   @ApiOperation("装车信息")
   @GetMapping("loading-info")
   public ResultVO loadingInfo(KanbanQuery query) {
      log.info("API调用: 生产看板大屏-装车信息");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      List<MesBuildingCargoList> cargoListList = this.cargoListService
         .lambdaQuery()
         .in(MesBuildingCargoList::getProjectId, projectIdList)
         .eq(MesBuildingCargoList::getDeliveryStatus, 1)
         .apply("DATE_FORMAT(create_time, '%Y-%m-%d %H') >= DATE_FORMAT({0}, '%Y-%m-%d %H')", LocalDateTime.now().minusHours(24L))
         .list();
      List<JSONObject> resultList = cargoListList.stream().map(i -> {
         Integer goOutApprovalStatus = (i.getStatus() & 12) > 0 ? 1 : 0;
         JSONObject result = new JSONObject();
         result.put("licensePlate", i.getLicensePlate());
         result.put("emptyCars", i.getEmptyCars().divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP));
         result.put("actualWeight", i.getActualWeight().divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP));
         result.put("goOutApprovalStatus", goOutApprovalStatus);
         return result;
      }).collect(Collectors.toList());
      return ResultBuilder.success(resultList);
   }

   @ApiOperation("年度库存数据及发运数据")
   @GetMapping("year-inventory-and-shipping-data")
   public ResultVO yearInventoryAndShippingData(KanbanQuery query) {
      log.info("API调用: 发运看板大屏-年度库存数据及发运数据");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      int thisYear = YearMonth.now().getYear();
      List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
         .lambdaQuery()
         .in(MesBuildingWarehouseRecord::getProjectId, projectIdList)
         .eq(query.getWorkshopId() != null, MesBuildingWarehouseRecord::getWorkshopId, query.getWorkshopId())
         .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
         .eq(MesBuildingWarehouseRecord::getWarehouseType, WarehouseTypeProductReturnEnum.NORMAL.getType())
         .apply("YEAR(create_time) = {0}", thisYear)
         .list();
      Map<String, List<MesBuildingWarehouseRecord>> warehouseRecordGroup = warehouseRecordList.stream()
         .collect(Collectors.groupingBy(k -> k.getCreateTime().format(DateTimeFormatter.ofPattern("yy-MM"))));
      List<Long> productIdList = warehouseRecordList.stream().map(MesBuildingWarehouseRecord::getProductId).distinct().collect(Collectors.toList());
      Map<Long, TechArtifact> artifactMap = Optional.of(productIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.artifactService::listByIds)
         .orElseGet(Collections::emptyList)
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<JSONObject> resultList = new ArrayList<>();

      for (int i = 1; i <= 12; i++) {
         String yearMonth = YearMonth.of(thisYear, i).format(DateTimeFormatter.ofPattern("yy-MM"));
         List<MesBuildingWarehouseRecord> cWarehouseRecordList = warehouseRecordGroup.getOrDefault(yearMonth, Collections.emptyList());
         BigDecimal inboundWeight = cWarehouseRecordList.stream().filter(cwr -> ObjectUtil.equals(1, cwr.getType())).map(cwr -> {
            BigDecimal weight = ObjectUtil.defaultIfNull(artifactMap.getOrDefault(cwr.getProductId(), new TechArtifact()).getGrossWeight(), BigDecimal.ZERO);
            return cwr.getQuantity().multiply(weight).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
         }).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal outboundWeight = cWarehouseRecordList.stream().filter(cwr -> ObjectUtil.equals(2, cwr.getType())).map(cwr -> {
            BigDecimal weight = ObjectUtil.defaultIfNull(artifactMap.getOrDefault(cwr.getProductId(), new TechArtifact()).getGrossWeight(), BigDecimal.ZERO);
            return cwr.getQuantity().multiply(weight).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
         }).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal inventoryWeight = inboundWeight.subtract(outboundWeight);
         JSONObject result = new JSONObject();
         result.put("yearMonth", yearMonth);
         result.put("inventoryWeight", inventoryWeight);
         result.put("outboundWeight", outboundWeight);
         resultList.add(result);
      }

      return ResultBuilder.success(resultList);
   }
}
