package com.hzchum.scim.rest.runner.test;

import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingAreaScheduling;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingAreaSchedulingService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(99)
public class MesBuildingAreaSchedulingRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingAreaSchedulingRunner.class);
   @Resource
   private MesBuildingAreaSchedulingService mesBuildingAreaSchedulingService;
   @Resource
   private PlanAreaBatchService areaBatchService;

   @Override
   public void run(String... args) throws Exception {
      List<PlanAreaBatch> areaBatchList = this.areaBatchService.list();
      Map<Long, MesBuildingAreaScheduling> areaSchedulingMap = this.mesBuildingAreaSchedulingService
         .list()
         .stream()
         .collect(Collectors.toMap(MesBuildingAreaScheduling::getAreaId, Function.identity()));

      for (PlanAreaBatch areaBatch : areaBatchList) {
         MesBuildingAreaScheduling mesBuildingAreaScheduling = areaSchedulingMap.get(areaBatch.getAreaId());
         if (mesBuildingAreaScheduling != null) {
            MesBuildingAreaScheduling copy = BeanUtil.copy(mesBuildingAreaScheduling, MesBuildingAreaScheduling.class);
            copy.setAreaBatchId(areaBatch.getId());
            this.mesBuildingAreaSchedulingService.save(copy);
         }
      }

      this.mesBuildingAreaSchedulingService.removeByIds(areaSchedulingMap.keySet());
   }

   public MesBuildingAreaSchedulingRunner(final MesBuildingAreaSchedulingService mesBuildingAreaSchedulingService, final PlanAreaBatchService areaBatchService) {
      this.mesBuildingAreaSchedulingService = mesBuildingAreaSchedulingService;
      this.areaBatchService = areaBatchService;
   }
}
