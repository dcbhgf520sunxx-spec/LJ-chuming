package com.hzchum.scim.rest.runner.mes;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.mes.building.core.api.enums.ProcessInspectTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProcessReportTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Order(60)
@Component
public class MachinePartProcessConfigRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MachinePartProcessConfigRunner.class);
   private final MesBuildingProcessService processService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) {
      log.info("6.0零件工序配置信息初始化开始............................................");
      List<MesBuildingProcess> processList = this.processService
         .list((Wrapper<MesBuildingProcess>)Wrappers.<MesBuildingProcess>lambdaQuery().eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType()));
      if (processList.size() == 1) {
         this.processConfig(processList.get(0).getId());
      }

      log.info("6.0零件工序配置信息初始化结束............................................");
   }

   private void processConfig(Long id) {
      this.processService.updateById(MesBuildingProcess.builder().id(id).type(ProcessTypeEnum.MAKINGS.getType()).name("下料").build());
      MesBuildingProcess drillProcess = MesBuildingProcess.builder()
         .userId(1L)
         .productType(ProductTypeEnum.MACHINE_PART.getType())
         .name("钻孔")
         .reportType(ProcessReportTypeEnum.BATCH_UNSCAN.getType())
         .inspectType(ProcessInspectTypeEnum.BATCH_UNSCAN.getType())
         .type(ProcessTypeEnum.DRILL_HOLE.getType())
         .sort(1)
         .build();
      this.processService.save(drillProcess);
   }

   public MachinePartProcessConfigRunner(final MesBuildingProcessService processService) {
      this.processService = processService;
   }
}
