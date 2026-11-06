package com.hzchum.scim.rest.runner.mes.enclosure;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.process.MesEnclosureProcess;
import com.hzchum.scim.mes.enclosure.core.api.service.process.MesEnclosureProcessService;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(61)
@Component
public class enclosureProcessRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(enclosureProcessRunner.class);
   @Resource
   private MesEnclosureProcessService processService;

   @Override
   public void run(String... args) throws Exception {
      log.info("围护工序初始化开始............................................");
      List<MesEnclosureProcess> list = this.processService.list();
      if (CollectionUtils.isEmpty(list)) {
         this.processService.save(MesEnclosureProcess.builder().name("压板").reportType(1).inspectType(1).sort(1).userId(1L).build());
      }

      log.info("围护工序初始化结束............................................");
   }

   public enclosureProcessRunner(final MesEnclosureProcessService processService) {
      this.processService = processService;
   }
}
