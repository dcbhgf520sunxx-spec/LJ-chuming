package com.hzchum.scim.rest.runner.test;

import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(164)
@Component
public class TechAssembleTestRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(TechAssembleTestRunner.class);
   @Resource
   private TechAssembleService assembleService;

   @Override
   public void run(String... args) throws Exception {
      List<TechAssemble> assembles = this.assembleService.list();
      Map<Long, List<TechAssemble>> projectAssembleMap = assembles.stream().collect(Collectors.groupingBy(TechAssemble::getProjectId));
      projectAssembleMap.forEach((projectId, assembleList) -> {
         for (TechAssemble assemble : assembleList) {
            assemble.setInitialSerialNumber(assemble.getSerialNumber().replaceFirst("组", ""));
         }

         this.assembleService.updateBatchById(assembleList);
      });
   }
}
