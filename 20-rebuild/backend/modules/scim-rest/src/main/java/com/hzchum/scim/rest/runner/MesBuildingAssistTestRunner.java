package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(103)
@Component
public class MesBuildingAssistTestRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingAssistTestRunner.class);
   private final MesBuildingAssistService mesBuildingAssistService;
   private final MesBuildingTaskProcessService taskProcessService;
   private final MesBuildingProductProcessService productProcessService;

   @Override
   public void run(String... args) throws Exception {
      List<MesBuildingAssist> assistList = this.mesBuildingAssistService.list();
      if (CollectionUtils.isNotEmpty(assistList)) {
         List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService
            .listByIds(assistList.stream().map(MesBuildingAssist::getTaskProcessId).collect(Collectors.toList()));
         if (CollectionUtils.isNotEmpty(taskProcessList)) {
            Map<Long, MesBuildingProductProcess> productProcessMap = this.productProcessService
               .listByIds(taskProcessList.stream().map(MesBuildingTaskProcess::getProductProcessId).collect(Collectors.toList()))
               .stream()
               .collect(Collectors.toMap(MesBuildingProductProcess::getId, Function.identity()));
            if (CollectionUtils.isNotEmpty(productProcessMap)) {
               Map<Long, MesBuildingTaskProcess> taskProcessMap = taskProcessList.stream()
                  .collect(Collectors.toMap(MesBuildingTaskProcess::getId, Function.identity()));

               for (MesBuildingAssist assist : assistList) {
                  MesBuildingTaskProcess taskProcess = taskProcessMap.get(assist.getTaskProcessId());
                  if (taskProcess != null) {
                     MesBuildingProductProcess mesBuildingProductProcess = productProcessMap.get(taskProcess.getProductProcessId());
                     if (mesBuildingProductProcess != null) {
                        assist.setClassId(mesBuildingProductProcess.getTypeId());
                     }
                  }
               }
            }

            this.mesBuildingAssistService.updateBatchById(assistList);
         }
      }
   }

   public MesBuildingAssistTestRunner(
      final MesBuildingAssistService mesBuildingAssistService,
      final MesBuildingTaskProcessService taskProcessService,
      final MesBuildingProductProcessService productProcessService
   ) {
      this.mesBuildingAssistService = mesBuildingAssistService;
      this.taskProcessService = taskProcessService;
      this.productProcessService = productProcessService;
   }
}
