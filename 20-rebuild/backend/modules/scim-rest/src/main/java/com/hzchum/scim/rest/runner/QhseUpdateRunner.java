package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.system.core.api.pojo._do.MesQualityClassConfig;
import com.hzchum.scim.system.core.api.pojo._do.MesSafetyClassConfig;
import com.hzchum.scim.system.core.api.service.MesQualityClassConfigService;
import com.hzchum.scim.system.core.api.service.MesSafetyClassConfigService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(105)
@Component
public class QhseUpdateRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(QhseUpdateRunner.class);
   @Resource
   private MesBuildingQhseService mesBuildingQhseService;
   @Resource
   private MesQualityClassConfigService mesQualityClassConfigService;
   @Resource
   private MesSafetyClassConfigService mesSafetyClassConfigService;

   @Override
   public void run(String... args) throws Exception {
      log.info("开始更新Qhse数据...");
      List<MesBuildingQhse> qhseList = this.mesBuildingQhseService.list();
      List<MesBuildingQhse> buildingQhses = qhseList.stream()
         .filter(ex -> ex.getPenalty() != null && ex.getBehaviorScore() != null)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(buildingQhses)) {
         log.info("Qhse数据Runner已执行过，跳过本次执行");
      } else {
         int updatedCount = 0;

         for (MesBuildingQhse qhse : qhseList) {
            try {
               if (qhse.getType() != 1 && qhse.getType() != 8) {
                  if ((qhse.getType() == 2 || qhse.getType() == 4) && qhse.getLevelTwoType() != null) {
                     MesSafetyClassConfig safetyConfig = this.mesSafetyClassConfigService.getById(qhse.getLevelTwoType());
                     if (safetyConfig != null) {
                        qhse.setBehaviorScore(BigDecimal.valueOf(safetyConfig.getBehaviorScore().intValue()));
                        qhse.setPenalty(safetyConfig.getPenalty());
                        updatedCount++;
                     } else {
                        qhse.setBehaviorScore(BigDecimal.ZERO);
                        qhse.setPenalty(BigDecimal.ZERO);
                     }

                     this.mesBuildingQhseService.updateById(qhse);
                  }
               } else if (qhse.getLevelTwoType() != null) {
                  MesQualityClassConfig qualityConfig = this.mesQualityClassConfigService.getById(qhse.getLevelTwoType());
                  if (qualityConfig != null) {
                     qhse.setBehaviorScore(BigDecimal.valueOf(qualityConfig.getBehaviorScore().intValue()));
                     qhse.setPenalty(qualityConfig.getPenalty());
                     updatedCount++;
                  } else {
                     qhse.setBehaviorScore(BigDecimal.ZERO);
                     qhse.setPenalty(BigDecimal.ZERO);
                  }

                  this.mesBuildingQhseService.updateById(qhse);
               }
            } catch (Exception e) {
               log.error("更新Qhse数据失败，id: {}", qhse.getId(), e);
            }
         }

         log.info("Qhse数据更新完成，共更新{}条数据", updatedCount);
      }
   }
}
