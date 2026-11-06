package com.hzchum.scim.rest.runner.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.enums.ItemizedTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(99)
public class PlanAreaStandardRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(PlanAreaStandardRunner.class);
   @Resource
   private PlanAreaService planAreaService;
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Resource
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Resource
   private TechStandardPartService standardPartService;

   @Override
   public void run(String... args) throws Exception {
      List<PlanArea> areaList = this.planAreaService
         .list((Wrapper<PlanArea>)new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getItemizedType, ItemizedTypeEnum.OTHER.getType()));
      if (CollectionUtils.isNotEmpty(areaList)) {
         this.planAreaService.removeByIds(areaList.stream().map(PlanArea::getId).collect(Collectors.toList()));
      }

      List<MesBuildingWarehouseSummary> summaries = this.warehouseSummaryService
         .list(
            (Wrapper<MesBuildingWarehouseSummary>)new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
               .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.AUXILIARY_MATERIAL.getType())
         );
      if (CollectionUtils.isNotEmpty(summaries)) {
         this.warehouseSummaryService.removeByIds(summaries.stream().map(MesBuildingWarehouseSummary::getId).collect(Collectors.toList()));
      }

      List<MesBuildingWarehouseRecord> warehouseRecords = this.warehouseRecordService
         .list(
            (Wrapper<MesBuildingWarehouseRecord>)new LambdaQueryWrapper<MesBuildingWarehouseRecord>()
               .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.AUXILIARY_MATERIAL.getType())
         );
      if (CollectionUtils.isNotEmpty(warehouseRecords)) {
         this.warehouseRecordService.removeByIds(warehouseRecords.stream().map(MesBuildingWarehouseRecord::getId).collect(Collectors.toList()));
      }

      List<TechStandardPart> standardPartList = this.standardPartService.list();
      if (CollectionUtils.isNotEmpty(standardPartList)) {
         this.standardPartService.removeByIds(standardPartList.stream().map(TechStandardPart::getId).collect(Collectors.toList()));
      }
   }

   public PlanAreaStandardRunner(
      final PlanAreaService planAreaService,
      final MesBuildingWarehouseSummaryService warehouseSummaryService,
      final MesBuildingWarehouseRecordService warehouseRecordService,
      final TechStandardPartService standardPartService
   ) {
      this.planAreaService = planAreaService;
      this.warehouseSummaryService = warehouseSummaryService;
      this.warehouseRecordService = warehouseRecordService;
      this.standardPartService = standardPartService;
   }
}
