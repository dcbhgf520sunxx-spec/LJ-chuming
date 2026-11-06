package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.scim.mes.building.core.api.pojo._do.device.MesWeighbridgeManagement;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.service.MesWeighbridgeManagementService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(102)
@Component
public class MesWeighbridgeManagementRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesWeighbridgeManagementRunner.class);
   private final MesWeighbridgeManagementService mesWeighbridgeManagementService;
   private final MesBuildingFactoryService factoryService;

   @Override
   public void run(String... args) throws Exception {
      log.info("地磅管理初始化");
      List<MesBuildingFactory> factoryList = this.factoryService.list();
      List<MesWeighbridgeManagement> mesWeighbridgeManagementList = this.mesWeighbridgeManagementService.list();
      if (CollectionUtils.isNotEmpty(factoryList) && CollectionUtils.isEmpty(mesWeighbridgeManagementList)) {
         factoryList.forEach(factory -> {
            MesWeighbridgeManagement mesWeighbridgeManagement = new MesWeighbridgeManagement();
            mesWeighbridgeManagement.setFactoryId(factory.getId());
            mesWeighbridgeManagement.setName("地磅");
            mesWeighbridgeManagement.setLastEditorUserId(1L);
            mesWeighbridgeManagement.setUserId(1L);
            this.mesWeighbridgeManagementService.save(mesWeighbridgeManagement);
         });
      }
   }

   public MesWeighbridgeManagementRunner(final MesWeighbridgeManagementService mesWeighbridgeManagementService, final MesBuildingFactoryService factoryService) {
      this.mesWeighbridgeManagementService = mesWeighbridgeManagementService;
      this.factoryService = factoryService;
   }
}
