package com.hzchum.scim.rest.runner;

import com.hzchum.scim.mes.building.core.api.service.MesBuildingWipDailySnapshotService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(108)
public class WipStatisticsRunner implements CommandLineRunner {
   private final MesBuildingWipDailySnapshotService wipDailySnapshotService;

   @Override
   public void run(String... args) throws Exception {
      this.wipDailySnapshotService.createSnapshot();
   }

   public WipStatisticsRunner(final MesBuildingWipDailySnapshotService wipDailySnapshotService) {
      this.wipDailySnapshotService = wipDailySnapshotService;
   }
}
