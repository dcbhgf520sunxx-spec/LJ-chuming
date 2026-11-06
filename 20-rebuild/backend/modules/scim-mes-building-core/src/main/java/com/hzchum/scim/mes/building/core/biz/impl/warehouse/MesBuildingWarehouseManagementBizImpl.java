package com.hzchum.scim.mes.building.core.biz.impl.warehouse;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.WarehouseNumberModeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.MesBuildingWarehouseManagementBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWarehouse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseStorageProduct;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.WarehouseProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.WorkshopWarehouseSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.AppWarehouseProductDetailSaveParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.AppWarehouseProductSaveParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.AppWarehouseProductScanQrCodeParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseManagementQueryParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseProductMoveDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseProductSaveParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWarehouseService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseStorageProductService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.system.core.api.common.enums.ArtifactTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinishedProductWareConfigDTO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingWarehouseManagementBizImpl implements MesBuildingWarehouseManagementBiz {
   private final ConfigService configService;
   private final TechArtifactService artifactService;
   private final TechArtifactExtService artifactExtService;
   private final MesBuildingTaskService taskService;
   private final MesBuildingWarehouseRecordService warehouseRecordService;
   private final MesBuildingWarehouseSummaryService warehouseSummaryService;
   private final MesBuildingWarehouseStorageProductService warehouseStorageProductService;
   private final MesBuildingWarehouseService warehouseService;
   private final MesBuildingWorkshopService workshopService;
   private final ContractProjectService projectService;
   private final PlanMonomerService monomerService;
   private final PlanAreaService areaService;

   @Override
   public PageVO<WarehouseProductDTO> listUnSaveWarehouseProduct(WarehouseManagementQueryParam param, Integer pageNumber, Integer pageSize) {
      Preconditions.checkArgument(param.getProductType() == null || param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()), "仅支持构件产品!");
      if (param.getProductType() == null) {
         param.setProductType(ProductTypeEnum.ARTIFACT.getType());
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<WarehouseProductDTO> unSavedWarehouseProductList = this.warehouseStorageProductService.listUnSavedWarehouseProduct(param);
      if (CollectionUtils.isNotEmpty(unSavedWarehouseProductList)) {
         FinishedProductWareConfigDTO productWareConfig = this.configService.getFinishedProductWareConfig();
         Integer warehouseNumberModeEnum = productWareConfig.getWarehouseNumberModeEnum();
         List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
            .list(
               Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
                  .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
                  .eq(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.INTO.getType())
                  .in(
                     MesBuildingWarehouseRecord::getWarehouseType,
                     WarehouseTypeProductReturnEnum.NORMAL.getType(),
                     WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()
                  )
                  .in(
                     MesBuildingWarehouseRecord::getProjectId,
                     unSavedWarehouseProductList.stream().map(un -> un.getProject().getId()).collect(Collectors.toSet())
                  )
                  .in(
                     MesBuildingWarehouseRecord::getMonomerId,
                     unSavedWarehouseProductList.stream().map(un -> un.getMonomer().getId()).collect(Collectors.toSet())
                  )
                  .in(MesBuildingWarehouseRecord::getAreaId, unSavedWarehouseProductList.stream().map(un -> un.getArea().getId()).collect(Collectors.toSet()))
                  .in(MesBuildingWarehouseRecord::getProductType, param.getProductType())
                  .in(
                     MesBuildingWarehouseRecord::getProductId,
                     unSavedWarehouseProductList.stream().map(WarehouseProductDTO::getProductId).collect(Collectors.toSet())
                  )
            );
         Map<Long, Integer> warehouseRecordIdSaveNumberMap = this.warehouseStorageProductService
            .list(
               Wrappers.lambdaQuery(MesBuildingWarehouseStorageProduct.class)
                  .in(
                     MesBuildingWarehouseStorageProduct::getWarehouseRecordId,
                     warehouseRecordList.stream().map(MesBuildingWarehouseRecord::getId).collect(Collectors.toList())
                  )
            )
            .stream()
            .filter(s -> s.getNumber() != null)
            .collect(Collectors.toMap(MesBuildingWarehouseStorageProduct::getWarehouseRecordId, MesBuildingWarehouseStorageProduct::getNumber));
         Map<String, List<Integer>> collect = warehouseRecordList.stream()
            .filter(wr -> wr.getNumber() != null)
            .filter(wr -> !warehouseRecordIdSaveNumberMap.containsKey(wr.getId()))
            .collect(
               Collectors.groupingBy(
                  s -> s.getWorkshopId() + "_" + s.getProductId(), Collectors.mapping(MesBuildingWarehouseRecord::getNumber, Collectors.toList())
               )
            );
         unSavedWarehouseProductList.forEach(un -> {
            un.setWarehouseNumberModeEnum(warehouseNumberModeEnum);
            un.setNumberList(Collections.emptyList());
            if (warehouseNumberModeEnum.equals(WarehouseNumberModeEnum.MANUAL_MODE.getType())) {
               un.setNumberList(collect.getOrDefault(un.getWorkshop().getId() + "_" + un.getProductId(), Collections.emptyList()));
            }
         });
      }

      return new PageVO<>(unSavedWarehouseProductList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveWarehouseProduct(List<WarehouseProductSaveParam> paramList) {
      FinishedProductWareConfigDTO productWareConfig = this.configService.getFinishedProductWareConfig();
      Preconditions.checkArgument(productWareConfig.getBoolEnableWarehouse(), "系统未开启库位管理功能!");
      this.saveList(paramList, productWareConfig.getWarehouseNumberModeEnum());
      return true;
   }

   private void saveList(List<WarehouseProductSaveParam> paramList, Integer warehouseNumberModeEnum) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(paramList), "保存失败,未选择产品!");
      Set<Integer> productTypeList = paramList.stream().map(WarehouseProductSaveParam::getProductType).collect(Collectors.toSet());
      Preconditions.checkArgument(productTypeList.size() == 1 && productTypeList.iterator().next().equals(ProductTypeEnum.ARTIFACT.getType()), "暂时仅支持构件类型!");
      Set<Long> productIds = paramList.stream().map(WarehouseProductSaveParam::getProductId).collect(Collectors.toSet());
      List<TechArtifact> artifactList = this.artifactService.listByIds(productIds);
      Preconditions.checkArgument(productIds.size() == artifactList.size(), "构件不存在!");
      Set<Long> workshopIds = paramList.stream().map(WarehouseProductSaveParam::getWorkshopId).collect(Collectors.toSet());
      List<MesBuildingWarehouseRecord> mesBuildingWarehouseRecordList = this.getWarehouseRecordList(workshopIds, productIds);
      Set<Long> savedWarehouseRecordIds = this.warehouseStorageProductService
         .listByWarehouseRecordIds(mesBuildingWarehouseRecordList.stream().map(MesBuildingWarehouseRecord::getId).collect(Collectors.toList()))
         .stream()
         .map(MesBuildingWarehouseStorageProduct::getWarehouseRecordId)
         .collect(Collectors.toSet());
      Map<String, List<MesBuildingWarehouseRecord>> warehouseRecordListMap = mesBuildingWarehouseRecordList.stream()
         .collect(Collectors.groupingBy(s -> s.getWorkshopId() + "_" + s.getProductType() + "_" + s.getProductId()));
      List<MesBuildingWarehouseSummary> warehouseSummaryList = this.getWarehouseSummaryList(workshopIds, productIds);
      Map<String, MesBuildingWarehouseSummary> warehouseSummaryMap = warehouseSummaryList.stream()
         .collect(Collectors.toMap(s -> s.getWorkshopId() + "_" + s.getProductType() + "_" + s.getProductId(), Function.identity()));
      Map<Long, MesBuildingWarehouse> warehouseMap = this.warehouseService
         .list()
         .stream()
         .collect(Collectors.toMap(MesBuildingWarehouse::getId, Function.identity()));
      List<MesBuildingWarehouseStorageProduct> warehouseStorageProductList = new ArrayList<>(
         paramList.stream().mapToInt(WarehouseProductSaveParam::getQuantity).sum()
      );
      paramList.forEach(
         param -> {
            MesBuildingWarehouse warehouse = warehouseMap.get(param.getWarehouseId());
            Preconditions.checkArgument(warehouse != null, "选择库位不存在!");
            List<MesBuildingWarehouseRecord> warehouseRecordList = warehouseRecordListMap.get(
               param.getWorkshopId() + "_" + param.getProductType() + "_" + param.getProductId()
            );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(warehouseRecordList), "选择产品已出库!!请刷新重试!!");
            warehouseRecordList = warehouseRecordList.stream()
               .filter(wr -> !savedWarehouseRecordIds.contains(wr.getId()))
               .sorted(Comparator.comparing(MesBuildingWarehouseRecord::getNumber))
               .collect(Collectors.toList());
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(warehouseRecordList), "选择产品已存入库位!!请刷新重试!!");
            int unSavedQuantitySum = warehouseRecordList.stream().mapToInt(s -> s.getQuantity().intValue()).sum();
            Preconditions.checkArgument(param.getQuantity() <= unSavedQuantitySum, "产品数量不足!!!请刷新重试!!!");
            MesBuildingWarehouseSummary warehouseSummary = warehouseSummaryMap.get(
               param.getWorkshopId() + "_" + param.getProductType() + "_" + param.getProductId()
            );
            Preconditions.checkArgument(warehouseSummary != null, "选择产品已出库!!请刷新重试!!");
            if (warehouseNumberModeEnum.equals(WarehouseNumberModeEnum.MANUAL_MODE.getType())) {
               Set<Integer> warehouseRecordNumberList = warehouseRecordList.stream()
                  .map(MesBuildingWarehouseRecord::getNumber)
                  .filter(Objects::nonNull)
                  .collect(Collectors.toSet());
               Preconditions.checkArgument(param.getNumberList().isEmpty() || warehouseRecordNumberList.containsAll(param.getNumberList()), "码号选择有误!!");
            }

            List<MesBuildingWarehouseStorageProduct> storageProductList;
            if (warehouseNumberModeEnum.equals(WarehouseNumberModeEnum.AUTO_MODE.getType())) {
               storageProductList = this.buildWarehouseStorageProductList(warehouseRecordList, warehouseSummary.getId(), param.getQuantity(), warehouse);
            } else {
               storageProductList = this.buildWarehouseStorageProductList(
                  warehouseRecordList, warehouseSummary.getId(), param.getNumberList(), param.getQuantity(), warehouse
               );
            }

            warehouseStorageProductList.addAll(storageProductList);
         }
      );
      this.warehouseStorageProductService.saveBatch(warehouseStorageProductList);
   }

   @Override
   public List<ProjectInfo> listWarehouseProject() {
      List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
               .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
               .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
               .eq(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.INTO.getType())
               .in(
                  MesBuildingWarehouseRecord::getWarehouseType,
                  WarehouseTypeProductReturnEnum.NORMAL.getType(),
                  WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()
               )
         );
      if (warehouseRecordList.isEmpty()) {
         return Collections.emptyList();
      }

      List<MesBuildingWarehouseStorageProduct> warehouseStorageProductList = this.warehouseStorageProductService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouseStorageProduct.class)
               .in(
                  MesBuildingWarehouseStorageProduct::getWarehouseRecordId,
                  warehouseRecordList.stream().map(MesBuildingWarehouseRecord::getId).collect(Collectors.toList())
               )
         );
      return warehouseStorageProductList.isEmpty()
         ? Collections.emptyList()
         : this.projectService
            .listInfoByIdList(warehouseStorageProductList.stream().map(MesBuildingWarehouseStorageProduct::getProjectId).collect(Collectors.toSet()));
   }

   @Override
   public List<WorkshopWarehouseSummaryDTO> listWorkshopWarehouseSummary(Long projectId) {
      List<MesBuildingWarehouse> mesBuildingWarehouseList = this.warehouseService.list();
      if (mesBuildingWarehouseList.isEmpty()) {
         return Collections.emptyList();
      }

      List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
               .eq(projectId != null, MesBuildingWarehouseRecord::getProjectId, projectId)
               .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
               .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
               .eq(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.INTO.getType())
               .in(
                  MesBuildingWarehouseRecord::getWarehouseType,
                  WarehouseTypeProductReturnEnum.NORMAL.getType(),
                  WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()
               )
         );
      if (warehouseRecordList.isEmpty()) {
         return Collections.emptyList();
      }

      List<MesBuildingWarehouseStorageProduct> warehouseStorageProductList = this.warehouseStorageProductService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouseStorageProduct.class)
               .in(
                  MesBuildingWarehouseStorageProduct::getWarehouseRecordId,
                  warehouseRecordList.stream().map(MesBuildingWarehouseRecord::getId).collect(Collectors.toList())
               )
         );
      if (warehouseStorageProductList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, NameInfo> workshopMap = this.workshopService
         .list()
         .stream()
         .map(ws -> NameInfo.builder().id(ws.getId()).name(ws.getName()).build())
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      Map<Long, NameInfo> warehouseMap = mesBuildingWarehouseList.stream()
         .map(wh -> NameInfo.builder().id(wh.getId()).name(wh.getName()).build())
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      Map<Long, BigDecimal> artifactIdNetWeightMap = this.artifactService
         .list(
            Wrappers.lambdaQuery(TechArtifact.class)
               .in(TechArtifact::getId, warehouseStorageProductList.stream().map(MesBuildingWarehouseStorageProduct::getProductId).collect(Collectors.toSet()))
               .in(
                  TechArtifact::getProjectId,
                  warehouseStorageProductList.stream().map(MesBuildingWarehouseStorageProduct::getProjectId).collect(Collectors.toSet())
               )
         )
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, TechArtifact::getNetWeight));
      Map<Long, Set<Long>> workshopIdWarehouseIdProductIdQuantityMap = warehouseStorageProductList.stream()
         .collect(
            Collectors.groupingBy(
               MesBuildingWarehouseStorageProduct::getWarehouseWorkshopId,
               TreeMap::new,
               Collectors.mapping(MesBuildingWarehouseStorageProduct::getWarehouseId, Collectors.toCollection(TreeSet::new))
            )
         );
      Map<Long, Map<Long, Integer>> workshopIdWarehouseIdQuantityMap = warehouseStorageProductList.stream()
         .collect(
            Collectors.groupingBy(
               MesBuildingWarehouseStorageProduct::getWarehouseWorkshopId,
               Collectors.groupingBy(MesBuildingWarehouseStorageProduct::getWarehouseId, Collectors.summingInt(MesBuildingWarehouseStorageProduct::getQuantity))
            )
         );
      Map<Long, Map<Long, BigDecimal>> workshopIdWarehouseIdWeightMap = warehouseStorageProductList.stream()
         .collect(
            Collectors.groupingBy(
               MesBuildingWarehouseStorageProduct::getWarehouseWorkshopId,
               Collectors.groupingBy(
                  MesBuildingWarehouseStorageProduct::getWarehouseId,
                  Collectors.reducing(
                     BigDecimal.ZERO,
                     s -> artifactIdNetWeightMap.getOrDefault(s.getProductId(), BigDecimal.ZERO).multiply(BigDecimal.valueOf(s.getQuantity().intValue())),
                     BigDecimal::add
                  )
               )
            )
         );
      List<WorkshopWarehouseSummaryDTO> workshopWarehouseSummaryList = new ArrayList<>(workshopIdWarehouseIdProductIdQuantityMap.keySet().size());
      workshopIdWarehouseIdProductIdQuantityMap.forEach(
         (wsId, warehouseIds) -> {
            Map<Long, Integer> warehouseIdQuantityMap = workshopIdWarehouseIdQuantityMap.get(wsId);
            Map<Long, BigDecimal> warehouseIdWeightMap = workshopIdWarehouseIdWeightMap.get(wsId);
            List<WorkshopWarehouseSummaryDTO> warehouseList = new ArrayList<>(warehouseIds.size());
            warehouseIds.forEach(
               warehouseId -> {
                  WorkshopWarehouseSummaryDTO warehouse = WorkshopWarehouseSummaryDTO.builder()
                     .warehouse(warehouseMap.get(warehouseId))
                     .quantity(warehouseIdQuantityMap.get(warehouseId))
                     .totalWeight(warehouseIdWeightMap.get(warehouseId).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP))
                     .build();
                  warehouseList.add(warehouse);
               }
            );
            WorkshopWarehouseSummaryDTO workshop = WorkshopWarehouseSummaryDTO.builder()
               .workshop(workshopMap.get(wsId))
               .quantity(warehouseIdQuantityMap.values().stream().mapToInt(Integer::intValue).sum())
               .totalWeight(
                  warehouseIdWeightMap.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP)
               )
               .warehouseList(warehouseList)
               .build();
            workshopWarehouseSummaryList.add(workshop);
         }
      );
      return workshopWarehouseSummaryList;
   }

   @Override
   public PageVO<WarehouseProductDTO> listSaveWarehouseProduct(WarehouseManagementQueryParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<WarehouseProductDTO> warehouseStorageProductList = this.warehouseStorageProductService.getUnOutWarehouseProductList(param);
      if (CollectionUtils.isNotEmpty(warehouseStorageProductList)) {
         FinishedProductWareConfigDTO finishedProductWareConfig = this.configService.getFinishedProductWareConfig();
         Integer warehouseNumberModeEnum = finishedProductWareConfig.getWarehouseNumberModeEnum();
         List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
            .list(
               Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
                  .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
                  .eq(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.INTO.getType())
                  .in(
                     MesBuildingWarehouseRecord::getWarehouseType,
                     WarehouseTypeProductReturnEnum.NORMAL.getType(),
                     WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()
                  )
                  .in(
                     MesBuildingWarehouseRecord::getProjectId,
                     warehouseStorageProductList.stream().map(un -> un.getProject().getId()).collect(Collectors.toSet())
                  )
                  .in(
                     MesBuildingWarehouseRecord::getMonomerId,
                     warehouseStorageProductList.stream().map(un -> un.getMonomer().getId()).collect(Collectors.toSet())
                  )
                  .in(MesBuildingWarehouseRecord::getAreaId, warehouseStorageProductList.stream().map(un -> un.getArea().getId()).collect(Collectors.toSet()))
                  .in(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
                  .in(
                     MesBuildingWarehouseRecord::getProductId,
                     warehouseStorageProductList.stream().map(WarehouseProductDTO::getProductId).collect(Collectors.toSet())
                  )
            );
         Map<String, List<Integer>> collect = this.warehouseStorageProductService
            .list(
               Wrappers.lambdaQuery(MesBuildingWarehouseStorageProduct.class)
                  .in(
                     MesBuildingWarehouseStorageProduct::getWarehouseRecordId,
                     warehouseRecordList.stream().map(MesBuildingWarehouseRecord::getId).collect(Collectors.toList())
                  )
            )
            .stream()
            .filter(s -> s.getNumber() != null)
            .collect(
               Collectors.groupingBy(
                  s -> s.getProductId() + "_" + s.getWarehouseId(), Collectors.mapping(MesBuildingWarehouseStorageProduct::getNumber, Collectors.toList())
               )
            );
         warehouseStorageProductList.forEach(s -> {
            s.setWarehouseNumberModeEnum(warehouseNumberModeEnum);
            s.setNumberList(collect.getOrDefault(s.getProductId() + "_" + s.getWarehouseId(), Collections.emptyList()));
         });
      }

      return new PageVO<>(warehouseStorageProductList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean moveWarehouse(List<WarehouseProductMoveDTOParam> paramList) {
      FinishedProductWareConfigDTO productWareConfig = this.configService.getFinishedProductWareConfig();
      Preconditions.checkArgument(productWareConfig.getBoolEnableWarehouse(), "系统未开启库位管理功能!");
      Integer warehouseNumberModeEnum = productWareConfig.getWarehouseNumberModeEnum();
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(paramList), "未选择数据!");
      Set<Long> moveWarehouseIds = paramList.stream().map(WarehouseProductMoveDTOParam::getMoveWarehouseId).collect(Collectors.toSet());
      Preconditions.checkArgument(moveWarehouseIds.size() == 1, "仅能选择一个目的仓库!");
      Long moveWarehouseId = moveWarehouseIds.iterator().next();
      MesBuildingWarehouse moveWarehouse = this.warehouseService.getById(moveWarehouseId);
      Preconditions.checkArgument(moveWarehouse != null, "移动目的仓库不存在!");
      Set<Long> productIds = paramList.stream().map(WarehouseProductMoveDTOParam::getProductId).collect(Collectors.toSet());
      Map<Long, TechArtifact> artifactMap = this.artifactService
         .listByIds(productIds)
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      Preconditions.checkArgument(productIds.size() == artifactMap.values().size(), "构件不存在!");
      List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
               .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
               .in(MesBuildingWarehouseRecord::getProductId, productIds)
               .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
               .eq(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.INTO.getType())
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(warehouseRecordList), "选择产品已出库!请刷新重试!");
      List<MesBuildingWarehouseStorageProduct> storageProductList = this.warehouseStorageProductService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouseStorageProduct.class)
               .in(
                  MesBuildingWarehouseStorageProduct::getWarehouseRecordId,
                  warehouseRecordList.stream().map(MesBuildingWarehouseRecord::getId).collect(Collectors.toSet())
               )
         );
      Map<Long, Map<Long, List<MesBuildingWarehouseStorageProduct>>> productIdWarehouseIdStorageProductListMap = storageProductList.stream()
         .collect(
            Collectors.groupingBy(MesBuildingWarehouseStorageProduct::getProductId, Collectors.groupingBy(MesBuildingWarehouseStorageProduct::getWarehouseId))
         );
      List<MesBuildingWarehouseStorageProduct> newBuildingWarehouseStorageProductList = new ArrayList<>(512);
      paramList.forEach(
         param -> {
            Preconditions.checkArgument(!param.getMoveWarehouseId().equals(param.getWarehouseId()), " 转移仓库不能和原仓库相同!");
            List<MesBuildingWarehouseStorageProduct> warehouseStorageProductList = productIdWarehouseIdStorageProductListMap.getOrDefault(
                  param.getProductId(), Collections.emptyMap()
               )
               .getOrDefault(param.getWarehouseId(), Collections.emptyList());
            int storageSum = warehouseStorageProductList.stream().mapToInt(MesBuildingWarehouseStorageProduct::getQuantity).sum();
            Preconditions.checkArgument(param.getQuantity() <= storageSum, "仓库库存数量不足!请刷新重试!");
            if (warehouseNumberModeEnum.equals(WarehouseNumberModeEnum.MANUAL_MODE.getType())) {
               Set<Integer> storageProductNumberList = warehouseStorageProductList.stream()
                  .map(MesBuildingWarehouseStorageProduct::getNumber)
                  .filter(Objects::nonNull)
                  .collect(Collectors.toSet());
               Preconditions.checkArgument(
                  storageProductNumberList.isEmpty() && param.getNumberList().isEmpty()
                     || !storageProductNumberList.isEmpty() && !param.getNumberList().isEmpty() && storageProductNumberList.containsAll(param.getNumberList()),
                  "码号选择有误!"
               );
            }

            List<MesBuildingWarehouseStorageProduct> newStorageProductList;
            if (warehouseNumberModeEnum.equals(WarehouseNumberModeEnum.AUTO_MODE.getType())) {
               newStorageProductList = this.getMoveStorageProductList(warehouseStorageProductList, param.getQuantity(), moveWarehouse);
            } else {
               newStorageProductList = this.getMoveStorageProductList(warehouseStorageProductList, param.getNumberList(), param.getQuantity(), moveWarehouse);
            }

            newBuildingWarehouseStorageProductList.addAll(newStorageProductList);
         }
      );
      this.warehouseStorageProductService.updateBatchById(storageProductList);
      this.warehouseStorageProductService.saveBatch(newBuildingWarehouseStorageProductList);
      return true;
   }

   @Override
   public Map<String, Object> scanQrCodeWarehouse(AppWarehouseProductScanQrCodeParam param) {
      Preconditions.checkArgument(param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()), "仅支持构件产品!");
      TechArtifact artifact = this.artifactService.getById(param.getProductId());
      Preconditions.checkArgument(artifact != null, "构件不存在!");
      if (param.getWorkshopId() == null) {
         Preconditions.checkArgument(param.getTaskId() != null || param.getWarehouseId() != null, "构件扫码失败!!数据有误!!");
         if (param.getTaskId() != null) {
            MesBuildingTask task = this.taskService.getById(param.getTaskId());
            Preconditions.checkArgument(task != null, "构件任务不存在!");
            param.setWorkshopId(task.getWorkshopId());
         } else {
            MesBuildingWarehouseSummary summary = this.warehouseSummaryService.getById(param.getWarehouseId());
            Preconditions.checkArgument(summary != null, "构件库存记录不存在!");
            param.setWorkshopId(summary.getWorkshopId());
         }
      }

      boolean boolOneCode = artifact.getArtifactType().equals(ArtifactTypeEnum.COMMON.getType())
         || artifact.getCodingType().equals(CodingTypeEnum.SINGLE.getType());
      if (boolOneCode && artifact.getSubscriptionQuantity() == 0) {
         Preconditions.checkArgument(param.getNumber() != null, "未传一物一码号!");
         TechArtifactExt artifactExt = this.artifactExtService.getOne(param.getProductId(), param.getNumber());
         Preconditions.checkArgument(artifactExt != null, "一物一码号有误!");
      } else {
         param.setNumber(null);
      }

      List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
               .eq(MesBuildingWarehouseRecord::getProductType, param.getProductType())
               .eq(MesBuildingWarehouseRecord::getProductId, param.getProductId())
               .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
               .ne(MesBuildingWarehouseRecord::getWarehouseType, WarehouseTypeProductReturnEnum.REPAIR.getType())
               .eq(param.getNumber() != null, MesBuildingWarehouseRecord::getNumber, param.getNumber())
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(warehouseRecordList), "构件尚未完成生产!!");
      warehouseRecordList = warehouseRecordList.stream().filter(wr -> wr.getWorkshopId().equals(param.getWorkshopId())).collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(warehouseRecordList), "构件生产车间有误!!");
      warehouseRecordList = warehouseRecordList.stream()
         .filter(s -> s.getStatus().equals(WarehouseRecordStatusTypeEnum.INTO.getType()))
         .collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(warehouseRecordList), "构件已出库!!");
      List<Long> warehouseRecordIds = warehouseRecordList.stream().map(MesBuildingWarehouseRecord::getId).collect(Collectors.toList());
      List<MesBuildingWarehouseStorageProduct> warehouseStorageProductList = this.warehouseStorageProductService.listByWarehouseRecordIds(warehouseRecordIds);
      Preconditions.checkArgument(warehouseRecordList.size() > warehouseStorageProductList.size(), "构件已存入库位!!");
      Map<Long, MesBuildingWarehouseStorageProduct> warehouseRecordIdStorageMap = warehouseStorageProductList.stream()
         .collect(Collectors.toMap(MesBuildingWarehouseStorageProduct::getWarehouseRecordId, Function.identity()));
      warehouseRecordList = warehouseRecordList.stream().filter(wr -> !warehouseRecordIdStorageMap.containsKey(wr.getId())).collect(Collectors.toList());
      BigDecimal quantity = warehouseRecordList.stream().map(MesBuildingWarehouseRecord::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
      HashMap<String, Object> map = new HashMap<>(16);
      map.put("workshop", this.workshopService.getSimpleById(param.getWorkshopId()));
      map.put("project", this.projectService.getSimpleById(artifact.getProjectId()));
      map.put("monomer", this.monomerService.getSimpleById(artifact.getMonomerId()));
      map.put("area", this.areaService.getSimpleById(artifact.getAreaId()));
      map.put("productType", param.getProductType());
      map.put("productId", param.getProductId());
      map.put(
         "boolOneCode",
         artifact.getArtifactType().equals(ArtifactTypeEnum.COMMON.getType())
            || artifact.getCodingType().equals(CodingTypeEnum.SINGLE.getType()) && artifact.getSubscriptionQuantity() == 0
      );
      map.put("name", artifact.getName());
      map.put("serialNumber", artifact.getSerialNumber());
      map.put("specification", artifact.getSpecification());
      map.put("length", artifact.getLength());
      map.put("quantity", quantity.intValue());
      map.put("netWeight", artifact.getNetWeight());
      map.put("totalNetWeight", artifact.getNetWeight().multiply(quantity));
      map.put("numberList", param.getNumber() != null ? Collections.singletonList(param.getNumber()) : Collections.emptyList());
      return map;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean appScanQrCodeSave(AppWarehouseProductSaveParam param) {
      FinishedProductWareConfigDTO productWareConfig = this.configService.getFinishedProductWareConfig();
      Preconditions.checkArgument(productWareConfig.getBoolEnableWarehouse(), "系统未开启库位管理功能!");
      Set<Long> productIds = param.getProductList().stream().map(AppWarehouseProductDetailSaveParam::getProductId).collect(Collectors.toSet());
      List<TechArtifact> artifactList = this.artifactService.listByIds(productIds);
      Map<Long, TechArtifact> artifactMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<WarehouseProductSaveParam> saveParamList = new ArrayList<>(param.getProductList().size());
      param.getProductList()
         .forEach(
            s -> {
               TechArtifact artifact = artifactMap.get(s.getProductId());
               Preconditions.checkArgument(artifact != null, "构件不存在!");
               boolean boolOneCode = artifact.getCodingType().equals(CodingTypeEnum.SINGLE.getType())
                  || artifact.getArtifactType().equals(ArtifactTypeEnum.COMMON.getType());
               if (boolOneCode && artifact.getSubscriptionQuantity() == 0) {
                  Preconditions.checkArgument(CollectionUtils.isNotEmpty(s.getNumberList()), "构件码号有误!");
                  Preconditions.checkArgument(s.getNumberList().stream().allMatch(Objects::nonNull), "构件码号不能为空!");
                  Preconditions.checkArgument(new HashSet<>(s.getNumberList()).size() == s.getNumberList().size(), "构件码号出现重复!!");
               } else {
                  s.setNumberList(Collections.emptyList());
               }

               WarehouseProductSaveParam saveParam = BeanUtil.copy(s, WarehouseProductSaveParam.class);
               saveParam.setWarehouseId(param.getWarehouseLocationId());
               saveParam.setNumberList(s.getNumberList());
               saveParamList.add(saveParam);
            }
         );
      this.saveList(saveParamList, WarehouseNumberModeEnum.MANUAL_MODE.getType());
      return true;
   }

   @Override
   public List<ProjectInfo> getUnIntoWarehouseLocationProjectList() {
      List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
               .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
               .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
               .eq(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.INTO.getType())
               .in(
                  MesBuildingWarehouseRecord::getWarehouseType,
                  WarehouseTypeProductReturnEnum.NORMAL.getType(),
                  WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()
               )
         );
      if (CollectionUtils.isNotEmpty(warehouseRecordList)) {
         List<Long> warehouseRecordIds = warehouseRecordList.stream().map(MesBuildingWarehouseRecord::getId).collect(Collectors.toList());
         List<Long> projectIds = warehouseRecordList.stream().map(MesBuildingWarehouseRecord::getProjectId).collect(Collectors.toList());
         List<Long> saveWarehouseLocationRecordIds = this.warehouseStorageProductService
            .list(
               Wrappers.lambdaQuery(MesBuildingWarehouseStorageProduct.class)
                  .in(MesBuildingWarehouseStorageProduct::getWarehouseRecordId, warehouseRecordIds)
                  .in(MesBuildingWarehouseStorageProduct::getProjectId, projectIds)
            )
            .stream()
            .map(MesBuildingWarehouseStorageProduct::getWarehouseRecordId)
            .collect(Collectors.toList());
         warehouseRecordList = warehouseRecordList.stream().filter(wr -> !saveWarehouseLocationRecordIds.contains(wr.getId())).collect(Collectors.toList());
         if (warehouseRecordList.isEmpty()) {
            return Collections.emptyList();
         }

         List<ProjectInfo> projectInfoList = this.projectService
            .listInfoByIdList(warehouseRecordList.stream().map(MesBuildingWarehouseRecord::getProjectId).collect(Collectors.toList()));
         return projectInfoList.stream().sorted(Comparator.comparing(ProjectInfo::getId).reversed()).collect(Collectors.toList());
      } else {
         return Collections.emptyList();
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean appManualSelectCodeSave(AppWarehouseProductSaveParam param) {
      FinishedProductWareConfigDTO productWareConfig = this.configService.getFinishedProductWareConfig();
      Preconditions.checkArgument(productWareConfig.getBoolEnableWarehouse(), "系统未开启库位管理功能!");
      List<WarehouseProductSaveParam> saveParamList = param.getProductList().stream().map(s -> {
         WarehouseProductSaveParam saveParam = BeanUtil.copy(s, WarehouseProductSaveParam.class);
         saveParam.setWarehouseId(param.getWarehouseLocationId());
         saveParam.setNumberList(s.getNumberList());
         return saveParam;
      }).collect(Collectors.toList());
      this.saveList(saveParamList, WarehouseNumberModeEnum.AUTO_MODE.getType());
      return true;
   }

   private List<MesBuildingWarehouseStorageProduct> getMoveStorageProductList(
      List<MesBuildingWarehouseStorageProduct> warehouseStorageProductList, Integer moveQuantity, MesBuildingWarehouse moveWarehouse
   ) {
      List<MesBuildingWarehouseStorageProduct> newWarehouseStorageProductList = new ArrayList<>(warehouseStorageProductList.size());

      for (MesBuildingWarehouseStorageProduct storageProduct : warehouseStorageProductList) {
         if (moveQuantity <= 0) {
            break;
         }

         if (storageProduct.getQuantity() <= moveQuantity) {
            storageProduct.setWarehouseId(moveWarehouse.getId());
            storageProduct.setWarehouseWorkshopId(moveWarehouse.getWorkshopId());
            storageProduct.setWarehouseFactoryId(moveWarehouse.getFactoryId());
            storageProduct.setUserId(UserUtil.getCurrentUserId());
            moveQuantity = moveQuantity - storageProduct.getQuantity();
         } else {
            storageProduct.setQuantity(storageProduct.getQuantity() - moveQuantity);
            MesBuildingWarehouseStorageProduct newStorageProduct = BeanUtil.copy(storageProduct, MesBuildingWarehouseStorageProduct.class);
            newStorageProduct.setQuantity(moveQuantity);
            newStorageProduct.setWarehouseId(moveWarehouse.getId());
            newStorageProduct.setWarehouseWorkshopId(moveWarehouse.getWorkshopId());
            newStorageProduct.setWarehouseFactoryId(moveWarehouse.getFactoryId());
            newStorageProduct.setUserId(UserUtil.getCurrentUserId());
            newWarehouseStorageProductList.add(newStorageProduct);
            moveQuantity = 0;
         }
      }

      return newWarehouseStorageProductList;
   }

   private List<MesBuildingWarehouseStorageProduct> getMoveStorageProductList(
      List<MesBuildingWarehouseStorageProduct> warehouseStorageProductList, List<Integer> numberList, Integer moveQuantity, MesBuildingWarehouse moveWarehouse
   ) {
      if (CollectionUtils.isEmpty(numberList)) {
         return this.getMoveStorageProductList(warehouseStorageProductList, moveQuantity, moveWarehouse);
      }

      Map<Integer, List<MesBuildingWarehouseStorageProduct>> numberStorageProductListMap = warehouseStorageProductList.stream()
         .filter(sp -> sp.getNumber() != null)
         .collect(Collectors.groupingBy(MesBuildingWarehouseStorageProduct::getNumber));
      List<MesBuildingWarehouseStorageProduct> newWarehouseStorageProductList = new ArrayList<>(warehouseStorageProductList.size());

      for (Integer number : numberList) {
         List<MesBuildingWarehouseStorageProduct> storageProductList = numberStorageProductListMap.get(number);
         Preconditions.checkArgument(storageProductList != null, "码号选择有误!");
         List<MesBuildingWarehouseStorageProduct> newStorageProductList = this.getMoveStorageProductList(storageProductList, moveQuantity, moveWarehouse);
         newWarehouseStorageProductList.addAll(newStorageProductList);
      }

      return newWarehouseStorageProductList;
   }

   private List<MesBuildingWarehouseRecord> getWarehouseRecordList(Collection<Long> workshopIds, Collection<Long> productIds) {
      return this.warehouseRecordService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
               .in(CollectionUtils.isNotEmpty(workshopIds), MesBuildingWarehouseRecord::getWorkshopId, workshopIds)
               .in(CollectionUtils.isNotEmpty(productIds), MesBuildingWarehouseRecord::getProductId, productIds)
               .in(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
               .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
               .eq(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.INTO.getType())
               .in(
                  MesBuildingWarehouseRecord::getWarehouseType,
                  WarehouseTypeProductReturnEnum.NORMAL.getType(),
                  WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()
               )
         );
   }

   private List<MesBuildingWarehouseSummary> getWarehouseSummaryList(Collection<Long> workshopIds, Collection<Long> productIds) {
      return this.warehouseSummaryService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
               .in(MesBuildingWarehouseSummary::getWorkshopId, workshopIds)
               .in(MesBuildingWarehouseSummary::getProductId, productIds)
               .in(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ARTIFACT.getType())
               .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
               .in(
                  MesBuildingWarehouseSummary::getWarehouseType,
                  WarehouseTypeProductReturnEnum.NORMAL.getType(),
                  WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()
               )
         );
   }

   private List<MesBuildingWarehouseStorageProduct> buildWarehouseStorageProductList(
      List<MesBuildingWarehouseRecord> warehouseRecordList, Long warehouseSummaryId, Integer quantity, MesBuildingWarehouse warehouse
   ) {
      List<MesBuildingWarehouseStorageProduct> warehouseStorageProductList = new ArrayList<>(warehouseRecordList.size());

      for (MesBuildingWarehouseRecord warehouseRecord : warehouseRecordList) {
         if (quantity > 0) {
            Integer saveQuantity = warehouseRecord.getQuantity().intValue() <= quantity ? warehouseRecord.getQuantity().intValue() : quantity;
            MesBuildingWarehouseStorageProduct storageProduct = this.buildingWarehouseStorageProduct(
               warehouseRecord, warehouseSummaryId, saveQuantity, warehouse
            );
            warehouseStorageProductList.add(storageProduct);
            quantity = quantity - warehouseRecord.getQuantity().intValue();
         }
      }

      return warehouseStorageProductList;
   }

   private List<MesBuildingWarehouseStorageProduct> buildWarehouseStorageProductList(
      List<MesBuildingWarehouseRecord> warehouseRecordList,
      Long warehouseSummaryId,
      List<Integer> numberList,
      Integer saveQuantity,
      MesBuildingWarehouse warehouse
   ) {
      numberList = numberList.stream().filter(Objects::nonNull).distinct().collect(Collectors.toList());
      if (numberList.isEmpty()) {
         return this.buildWarehouseStorageProductList(warehouseRecordList, warehouseSummaryId, saveQuantity, warehouse);
      }

      List<MesBuildingWarehouseStorageProduct> warehouseStorageProductList = new ArrayList<>(warehouseRecordList.size());
      Map<Integer, MesBuildingWarehouseRecord> numberWarehouseRecordMap = warehouseRecordList.stream()
         .filter(wr -> Objects.nonNull(wr.getNumber()))
         .collect(Collectors.toMap(MesBuildingWarehouseRecord::getNumber, Function.identity()));

      for (Integer number : numberList) {
         MesBuildingWarehouseRecord warehouseRecord = numberWarehouseRecordMap.get(number);
         Preconditions.checkArgument(warehouseRecord != null, "码号已保存仓库!");
         if (saveQuantity > 0) {
            Integer quantity = warehouseRecord.getQuantity().intValue() <= saveQuantity ? warehouseRecord.getQuantity().intValue() : saveQuantity;
            MesBuildingWarehouseStorageProduct storageProduct = this.buildingWarehouseStorageProduct(warehouseRecord, warehouseSummaryId, quantity, warehouse);
            warehouseStorageProductList.add(storageProduct);
            saveQuantity = saveQuantity - warehouseRecord.getQuantity().intValue();
         }
      }

      if (saveQuantity > 0) {
         List<MesBuildingWarehouseRecord> recordList = warehouseRecordList.stream().filter(wr -> Objects.isNull(wr.getNumber())).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(recordList)) {
            List<MesBuildingWarehouseStorageProduct> storageProductList = this.buildWarehouseStorageProductList(
               recordList, warehouseSummaryId, saveQuantity, warehouse
            );
            warehouseStorageProductList.addAll(storageProductList);
         }
      }

      return warehouseStorageProductList;
   }

   private MesBuildingWarehouseStorageProduct buildingWarehouseStorageProduct(
      MesBuildingWarehouseRecord warehouseRecord, Long warehouseSummaryId, Integer quantity, MesBuildingWarehouse warehouse
   ) {
      return MesBuildingWarehouseStorageProduct.builder()
         .warehouseRecordId(warehouseRecord.getId())
         .warehouseSummaryId(warehouseSummaryId)
         .factoryId(warehouseRecord.getFactoryId())
         .workshopId(warehouseRecord.getWorkshopId())
         .projectId(warehouseRecord.getProjectId())
         .monomerId(warehouseRecord.getMonomerId())
         .areaId(warehouseRecord.getAreaId())
         .productType(warehouseRecord.getProductType())
         .productId(warehouseRecord.getProductId())
         .quantity(quantity)
         .number(warehouseRecord.getNumber())
         .warehouseType(warehouseRecord.getWarehouseType())
         .warehouseId(warehouse.getId())
         .warehouseWorkshopId(warehouse.getWorkshopId())
         .warehouseFactoryId(warehouse.getFactoryId())
         .userId(UserUtil.getCurrentUserId())
         .build();
   }

   public MesBuildingWarehouseManagementBizImpl(
      final ConfigService configService,
      final TechArtifactService artifactService,
      final TechArtifactExtService artifactExtService,
      final MesBuildingTaskService taskService,
      final MesBuildingWarehouseRecordService warehouseRecordService,
      final MesBuildingWarehouseSummaryService warehouseSummaryService,
      final MesBuildingWarehouseStorageProductService warehouseStorageProductService,
      final MesBuildingWarehouseService warehouseService,
      final MesBuildingWorkshopService workshopService,
      final ContractProjectService projectService,
      final PlanMonomerService monomerService,
      final PlanAreaService areaService
   ) {
      this.configService = configService;
      this.artifactService = artifactService;
      this.artifactExtService = artifactExtService;
      this.taskService = taskService;
      this.warehouseRecordService = warehouseRecordService;
      this.warehouseSummaryService = warehouseSummaryService;
      this.warehouseStorageProductService = warehouseStorageProductService;
      this.warehouseService = warehouseService;
      this.workshopService = workshopService;
      this.projectService = projectService;
      this.monomerService = monomerService;
      this.areaService = areaService;
   }
}
