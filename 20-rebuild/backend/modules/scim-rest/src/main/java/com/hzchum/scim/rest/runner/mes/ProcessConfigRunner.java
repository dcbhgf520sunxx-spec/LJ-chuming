package com.hzchum.scim.rest.runner.mes;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.mes.building.core.api.enums.ProcessInspectTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProcessReportTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductCategoryTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Order(51)
public class ProcessConfigRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ProcessConfigRunner.class);
   @Value("${module}")
   private String module;
   private final MesBuildingProcessService processService;
   private final MesBuildingProductProcessService productProcessService;
   private final MesBuildingProductProcessLinkService productProcessLinkService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) {
      List<MesBuildingProcess> process = this.processService
         .list(
            (Wrapper<MesBuildingProcess>)new LambdaQueryWrapper<MesBuildingProcess>()
               .eq(MesBuildingProcess::getProductionLineTypeEnum, ProductionLineTypeEnum.SMART_LINE.getType())
         );
      if (CollectionUtils.isNotEmpty(process)) {
         this.processService.removeByIds(process.stream().map(MesBuildingProcess::getId).collect(Collectors.toList()));
      }

      log.info("围护工序配置信息初始化开始............................................");
      List<MesBuildingProductProcess> enclosureProductProcessList = this.productProcessService
         .list((Wrapper<MesBuildingProductProcess>)Wrappers.<MesBuildingProductProcess>lambdaQuery().eq(MesBuildingProductProcess::getProductType, ProductTypeEnum.ENCLOSURE.getType()));
      if (CollectionUtils.isEmpty(enclosureProductProcessList)) {
         this.processConfig(ProductTypeEnum.ENCLOSURE.getType());
      }

      log.info("围护工序配置信息初始化结束............................................");
      log.info("零件工序配置信息初始化开始............................................");
      log.info("零件工序配置信息初始化开始............................................");
   }

   private Boolean processConfig(Integer productType) {
      MesBuildingProcess process = MesBuildingProcess.builder()
         .userId(1L)
         .productType(productType)
         .name(productType.equals(ProductTypeEnum.ENCLOSURE.getType()) ? "压板" : "制造")
         .reportType(ProcessReportTypeEnum.BATCH_UNSCAN.getType())
         .inspectType(ProcessInspectTypeEnum.BATCH_UNSCAN.getType())
         .productCategoryType(ProductCategoryTypeEnum.ENCLOSURE.getType())
         .sort(0)
         .build();
      this.processService.save(process);
      if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         MesBuildingProductProcess productProcess = MesBuildingProductProcess.builder().productType(productType).userId(1L).build();
         this.productProcessService.save(productProcess);
         this.productProcessLinkService
            .save(MesBuildingProductProcessLink.builder().processId(process.getId()).productProcessId(productProcess.getId()).sequence(0).build());
      }

      return Boolean.TRUE;
   }

   public ProcessConfigRunner(
      final MesBuildingProcessService processService,
      final MesBuildingProductProcessService productProcessService,
      final MesBuildingProductProcessLinkService productProcessLinkService
   ) {
      this.processService = processService;
      this.productProcessService = productProcessService;
      this.productProcessLinkService = productProcessLinkService;
   }
}
