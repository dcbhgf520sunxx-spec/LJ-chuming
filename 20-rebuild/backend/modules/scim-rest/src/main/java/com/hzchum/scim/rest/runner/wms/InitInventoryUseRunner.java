package com.hzchum.scim.rest.runner.wms;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseStatistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseStatisticsDate;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryUseStatisticsDateService;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryUseStatisticsService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(268)
@Component
public class InitInventoryUseRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(InitInventoryUseRunner.class);
   @Resource
   private MaterialInventoryService materialInventoryService;
   @Resource
   private InventoryUseStatisticsDateService inventoryUseStatisticsDateService;
   @Resource
   private InventoryUseStatisticsService inventoryUseStatisticsService;

   @Override
   public void run(String... args) throws Exception {
      System.out.println("===========初始化库存使用信息开始===========");
      InventoryUseStatistics one = this.inventoryUseStatisticsService.getOne((Wrapper<InventoryUseStatistics>)new LambdaQueryWrapper<InventoryUseStatistics>().last("limit 1"));
      if (ObjectUtil.isNotEmpty(one)) {
         System.out.println("===========初始化库存使用信息结束===========");
      } else {
         List<MaterialInventory> materialInventories = this.materialInventoryService
            .list((Wrapper<MaterialInventory>)new LambdaQueryWrapper<MaterialInventory>().gt(MaterialInventory::getMete, BigDecimal.ZERO));
         if (CollectionUtil.isEmpty(materialInventories)) {
            System.out.println("===========初始化库存使用信息结束===========");
         } else {
            LocalDateTime nowBeginTime = LocalDateTime.now().with(LocalTime.MIN);
            InventoryUseStatisticsDate inventoryUseStatisticsDate = InventoryUseStatisticsDate.builder().startTime(nowBeginTime).boolBalance(false).build();
            this.inventoryUseStatisticsDateService.save(inventoryUseStatisticsDate);
            TreeSet<MaterialInventory> distinctMaterialInventories = new TreeSet<>(
               Comparator.comparing(
                  a -> a.getBasicClass()
                     + ";"
                     + a.getClassifyId()
                     + ";"
                     + a.getSpecification()
                     + ";"
                     + a.getModel()
                     + ";"
                     + a.getMaterialIsWhole()
                     + ";"
                     + a.getWarehouseType()
                     + ";"
                     + a.getProjectId()
                     + ";"
                     + a.getBoolPartyA()
                     + ";"
                     + a.getLength()
                     + ";"
                     + a.getWidth()
                     + ";"
                     + a.getThickness()
                     + ";"
                     + a.getBrand()
                     + ";"
                     + a.getColor()
                     + ";"
                     + a.getUnitNet()
                     + ";"
                     + a.getWarehouseId()
                     + ";"
                     + a.getStandardId()
                     + ";"
                     + a.getWorkshopId()
                     + ";"
                     + a.getSerialNumber()
               )
            );

            for (MaterialInventory materialInventory : materialInventories) {
               if (ObjectUtil.isEmpty(materialInventory.getSpecification())) {
                  materialInventory.setSpecification(null);
               }

               if (ObjectUtil.isEmpty(materialInventory.getModel())) {
                  materialInventory.setModel(null);
               }

               if (ObjectUtil.isEmpty(materialInventory.getMaterialIsWhole())) {
                  materialInventory.setMaterialIsWhole(null);
               }

               if (ObjectUtil.isEmpty(materialInventory.getWarehouseType())) {
                  materialInventory.setWarehouseType(null);
               }

               if (ObjectUtil.isEmpty(materialInventory.getProjectId())) {
                  materialInventory.setProjectId(null);
               }

               if (ObjectUtil.isEmpty(materialInventory.getBoolPartyA())) {
                  materialInventory.setBoolPartyA(null);
               }

               if (ObjectUtil.isEmpty(materialInventory.getLength())) {
                  materialInventory.setLength(null);
               }

               if (ObjectUtil.isEmpty(materialInventory.getWidth())) {
                  materialInventory.setWidth(null);
               }

               if (ObjectUtil.isEmpty(materialInventory.getThickness())) {
                  materialInventory.setThickness(null);
               }

               if (ObjectUtil.isEmpty(materialInventory.getBrand())) {
                  materialInventory.setBrand(null);
               }

               if (ObjectUtil.isEmpty(materialInventory.getColor())) {
                  materialInventory.setColor(null);
               }

               if (ObjectUtil.isEmpty(materialInventory.getUnitNet())) {
                  materialInventory.setUnitNet(null);
               }

               if (ObjectUtil.isEmpty(materialInventory.getWarehouseId())) {
                  materialInventory.setWarehouseId(null);
               }

               if (ObjectUtil.isEmpty(materialInventory.getStandardId())) {
                  materialInventory.setStandardId(null);
               }

               if (ObjectUtil.isEmpty(materialInventory.getWorkshopId())) {
                  materialInventory.setWorkshopId(null);
               }

               if (ObjectUtil.isEmpty(materialInventory.getSerialNumber())) {
                  materialInventory.setSerialNumber(null);
               }
            }

            distinctMaterialInventories.addAll(materialInventories);

            for (MaterialInventory distinctMaterialInventory : distinctMaterialInventories) {
               InventoryUseStatistics inventoryUseStatistics = BeanUtil.copy(distinctMaterialInventory, InventoryUseStatistics.class);
               List<MaterialInventory> materialInventoryList = materialInventories.stream()
                  .filter(
                     m -> ObjectUtil.equals(m.getBasicClass(), distinctMaterialInventory.getBasicClass())
                        && ObjectUtil.equals(m.getClassifyId(), distinctMaterialInventory.getClassifyId())
                        && ObjectUtil.equals(m.getSpecification(), distinctMaterialInventory.getSpecification())
                        && ObjectUtil.equals(m.getModel(), distinctMaterialInventory.getModel())
                        && ObjectUtil.equals(m.getMaterialIsWhole(), distinctMaterialInventory.getMaterialIsWhole())
                        && ObjectUtil.equals(m.getWarehouseType(), distinctMaterialInventory.getWarehouseType())
                        && ObjectUtil.equals(m.getProjectId(), distinctMaterialInventory.getProjectId())
                        && ObjectUtil.equals(m.getBoolPartyA(), distinctMaterialInventory.getBoolPartyA())
                        && ObjectUtil.equals(m.getLength(), distinctMaterialInventory.getLength())
                        && ObjectUtil.equals(m.getWidth(), distinctMaterialInventory.getWidth())
                        && ObjectUtil.equals(m.getThickness(), distinctMaterialInventory.getThickness())
                        && ObjectUtil.equals(m.getBrand(), distinctMaterialInventory.getBrand())
                        && ObjectUtil.equals(m.getColor(), distinctMaterialInventory.getColor())
                        && ObjectUtil.equals(m.getUnitNet(), distinctMaterialInventory.getUnitNet())
                        && ObjectUtil.equals(m.getWarehouseId(), distinctMaterialInventory.getWarehouseId())
                        && ObjectUtil.equals(m.getStandardId(), distinctMaterialInventory.getStandardId())
                        && ObjectUtil.equals(m.getWorkshopId(), distinctMaterialInventory.getWorkshopId())
                        && ObjectUtil.equals(m.getSerialNumber(), distinctMaterialInventory.getSerialNumber())
                  )
                  .collect(Collectors.toList());
               BigDecimal quantitySum = materialInventoryList.stream()
                  .map(MaterialInventory::getQuantity)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal meteSum = materialInventoryList.stream()
                  .map(MaterialInventory::getMete)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               inventoryUseStatistics.setBeginStageTotalQuantity(quantitySum);
               inventoryUseStatistics.setBeginStageTotalMete(meteSum);
               inventoryUseStatistics.setStatisticsDateId(inventoryUseStatisticsDate.getId());
               this.inventoryUseStatisticsService.save(inventoryUseStatistics);
            }

            System.out.println("===========初始化库存使用信息结束===========");
         }
      }
   }

   public InitInventoryUseRunner(
      final MaterialInventoryService materialInventoryService,
      final InventoryUseStatisticsDateService inventoryUseStatisticsDateService,
      final InventoryUseStatisticsService inventoryUseStatisticsService
   ) {
      this.materialInventoryService = materialInventoryService;
      this.inventoryUseStatisticsDateService = inventoryUseStatisticsDateService;
      this.inventoryUseStatisticsService = inventoryUseStatisticsService;
   }
}
