package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseStorageProduct;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseStorageProductService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductWarehouseStorageRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ProductWarehouseStorageRunner.class);
   private final ContractProjectService projectService;
   private final MesBuildingWarehouseSummaryService warehouseSummaryService;
   private final MesBuildingWarehouseStorageProductService warehouseStorageProductService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      MesBuildingWarehouseStorageProduct storageProduct = this.warehouseStorageProductService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingWarehouseStorageProduct.class).gt(MesBuildingWarehouseStorageProduct::getWarehouseSummaryId, 0L).last("limit 1")
         );
      if (storageProduct == null) {
         this.set();
      }
   }

   private void set() {
      List<ContractProject> projectList = this.projectService.list();
      projectList.forEach(
         project -> {
            List<MesBuildingWarehouseStorageProduct> warehouseStorageProductList = this.warehouseStorageProductService
               .list(
                  Wrappers.lambdaQuery(MesBuildingWarehouseStorageProduct.class)
                     .eq(MesBuildingWarehouseStorageProduct::getProjectId, project.getId())
                     .eq(MesBuildingWarehouseStorageProduct::getProductType, ProductTypeEnum.ARTIFACT.getType())
               );
            if (CollectionUtils.isNotEmpty(warehouseStorageProductList)) {
               List<MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                        .eq(MesBuildingWarehouseSummary::getProjectId, project.getId())
                        .in(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ARTIFACT.getType())
                        .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                        .in(
                           MesBuildingWarehouseSummary::getWarehouseType,
                           WarehouseTypeProductReturnEnum.NORMAL.getType(),
                           WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()
                        )
                  );
               Map<String, MesBuildingWarehouseSummary> summaryMap = warehouseSummaryList.stream()
                  .collect(Collectors.toMap(s -> s.getWorkshopId() + "_" + s.getProductId(), Function.identity()));
               Map<String, List<MesBuildingWarehouseStorageProduct>> collect = warehouseStorageProductList.stream()
                  .collect(Collectors.groupingBy(s -> s.getWorkshopId() + "_" + s.getProductId()));
               collect.forEach((key, list) -> {
                  MesBuildingWarehouseSummary summary = summaryMap.get(key);
                  if (summary != null) {
                     list.forEach(s -> {
                        s.setWarehouseSummaryId(summary.getId());
                        s.setWarehouseType(summary.getWarehouseType());
                     });
                  }
               });
               this.warehouseStorageProductService.updateBatchById(warehouseStorageProductList);
            }
         }
      );
   }

   public ProductWarehouseStorageRunner(
      final ContractProjectService projectService,
      final MesBuildingWarehouseSummaryService warehouseSummaryService,
      final MesBuildingWarehouseStorageProductService warehouseStorageProductService
   ) {
      this.projectService = projectService;
      this.warehouseSummaryService = warehouseSummaryService;
      this.warehouseStorageProductService = warehouseStorageProductService;
   }
}
