package com.hzchum.scim.rest.runner.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(4)
public class Test4 implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(Test4.class);
   @Resource
   private MesBuildingWarehouseRecordService warehouseRecordService;
   private MesBuildingWarehouseSummaryService warehouseSummaryService;

   @Override
   public void run(String... args) throws Exception {
      List<MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService
         .list(
            (Wrapper<MesBuildingWarehouseSummary>)(new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                  .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ARTIFACT.getType()))
               .eq(MesBuildingWarehouseSummary::getType, 1)
         );
      List<Long> productIds = warehouseSummaryList.stream().map(MesBuildingWarehouseSummary::getProductId).distinct().collect(Collectors.toList());
      List<MesBuildingWarehouseRecord> recordList = this.warehouseRecordService
         .list(
            (Wrapper<MesBuildingWarehouseRecord>)((new LambdaQueryWrapper<MesBuildingWarehouseRecord>()
                     .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                  .eq(MesBuildingWarehouseRecord::getType, 1))
               .notIn(MesBuildingWarehouseRecord::getProductId, productIds)
         );
      List<MesBuildingWarehouseSummary> warehouseRecordList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(recordList)) {
         Map<String, List<MesBuildingWarehouseRecord>> collect = recordList.stream()
            .collect(Collectors.groupingBy(e -> e.getProductId() + "-" + e.getFactoryId() + "-" + e.getWorkshopId()));
         collect.forEach((ids, summaryList) -> {
            MesBuildingWarehouseRecord record = summaryList.get(0);
            MesBuildingWarehouseSummary copy = BeanUtil.copy(record, MesBuildingWarehouseSummary.class);
            warehouseRecordList.add(copy);
         });
      }

      this.warehouseSummaryService.saveBatch(warehouseRecordList);
   }

   public Test4(final MesBuildingWarehouseRecordService warehouseRecordService, final MesBuildingWarehouseSummaryService warehouseSummaryService) {
      this.warehouseRecordService = warehouseRecordService;
      this.warehouseSummaryService = warehouseSummaryService;
   }
}
