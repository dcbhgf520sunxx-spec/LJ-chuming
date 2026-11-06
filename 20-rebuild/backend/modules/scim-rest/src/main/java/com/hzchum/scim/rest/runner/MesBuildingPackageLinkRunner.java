package com.hzchum.scim.rest.runner;

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
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(103)
@Component
public class MesBuildingPackageLinkRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingPackageLinkRunner.class);
   @Resource
   private MesBuildingPackageLinkService packageLinkService;
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;

   @Override
   public void run(String... args) throws Exception {
      List<MesBuildingPackageLink> packageLinks = this.packageLinkService.list();
      Map<Long, MesBuildingWarehouseSummary> summaryMap = this.warehouseSummaryService
         .list()
         .stream()
         .collect(Collectors.toMap(MesBuildingWarehouseSummary::getId, Function.identity()));

      for (MesBuildingPackageLink packageLink : packageLinks) {
         MesBuildingWarehouseSummary warehouseSummary = summaryMap.get(packageLink.getWarehouseRecordId());
         if (warehouseSummary != null) {
            packageLink.setAreaBatchId(warehouseSummary.getAreaBatchId());
         }
      }

      this.packageLinkService.updateBatchById(packageLinks);
   }

   public MesBuildingPackageLinkRunner(final MesBuildingPackageLinkService packageLinkService, final MesBuildingWarehouseSummaryService warehouseSummaryService) {
      this.packageLinkService = packageLinkService;
      this.warehouseSummaryService = warehouseSummaryService;
   }
}
