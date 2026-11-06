package com.hzchum.scim.rest.runner.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageLinkService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

public class MesBuildingPackageLinkRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingPackageLinkRunner.class);
   @Resource
   private MesBuildingPackageLinkService packageLinkService;
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;

   @Override
   public void run(String... args) throws Exception {
      List<MesBuildingPackageLink> packageLinks = this.packageLinkService
         .list((Wrapper<MesBuildingPackageLink>)new LambdaQueryWrapper<MesBuildingPackageLink>().isNull(MesBuildingPackageLink::getMonomerId));
      if (CollectionUtils.isNotEmpty(packageLinks)) {
         List<MesBuildingPackageLink> collect = packageLinks.stream().filter(e -> e.getWarehouseRecordId() != null).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(collect)) {
            List<Long> warehouseRecordIds = collect.stream().map(MesBuildingPackageLink::getWarehouseRecordId).collect(Collectors.toList());
            Map<Long, MesBuildingWarehouseSummary> summaryMap = this.warehouseSummaryService
               .listByIds(warehouseRecordIds)
               .stream()
               .collect(Collectors.toMap(MesBuildingWarehouseSummary::getId, Function.identity()));

            for (MesBuildingPackageLink packageLink : collect) {
               MesBuildingWarehouseSummary summary = summaryMap.get(packageLink.getWarehouseRecordId());
               if (summary != null) {
                  packageLink.setMonomerId(summary.getMonomerId());
                  packageLink.setProjectId(summary.getProjectId());
                  packageLink.setAreaId(summary.getAreaId());
                  packageLink.setWorkshopId(summary.getWorkshopId());
                  packageLink.setPlanId(summary.getPlanId());
               }
            }

            this.packageLinkService.updateBatchById(collect);
         }
      }
   }
}
