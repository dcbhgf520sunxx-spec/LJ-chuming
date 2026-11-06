package com.hzchum.scim.rest.schedule;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hzchum.scim.mes.building.core.api.service.MesBuildingWipDailySnapshotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WipStatisticsSchedule {
   private static final Logger log = LoggerFactory.getLogger(WipStatisticsSchedule.class);
   private final MesBuildingWipDailySnapshotService wipDailySnapshotService;

   @Scheduled(cron = "0 0 2 * * ?", zone = "Asia/Shanghai")
   public void generateDailyReport() {
      log.info("开始执行在制品每日快照生成任务");

      try {
         this.wipDailySnapshotService.createSnapshot();
         log.info("在制品每日快照生成任务执行成功");
      } catch (JsonProcessingException e) {
         log.error("在制品每日快照生成任务失败 - JSON处理异常", e);
         throw new IllegalStateException("Local business task failed", e);
      } catch (Exception e) {
         log.error("在制品每日快照生成任务失败 - 系统异常", e);
         throw new IllegalStateException("Local business task failed", e);
      }
   }

   public WipStatisticsSchedule(final MesBuildingWipDailySnapshotService wipDailySnapshotService) {
      this.wipDailySnapshotService = wipDailySnapshotService;
   }
}
