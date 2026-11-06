package com.hzchum.scim.rest.runner;

import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingArtifactSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Order(160)
public class TestRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(TestRunner.class);
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechAssembleExtService assembleExtService;
   @Resource
   private TechArtifactService techArtifactService;
   @Resource
   private TechArtifactExtService artifactExtService;
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Resource
   private MesBuildingArtifactSchedulingService mesBuildingArtifactSchedulingService;

   @Transactional
   @Override
   public void run(String... args) throws Exception {
   }

   public TestRunner(
      final TechAssembleService assembleService,
      final TechAssembleExtService assembleExtService,
      final TechArtifactService techArtifactService,
      final TechArtifactExtService artifactExtService,
      final MesBuildingTaskNumberLinkService taskNumberLinkService,
      final MesBuildingArtifactSchedulingService mesBuildingArtifactSchedulingService
   ) {
      this.assembleService = assembleService;
      this.assembleExtService = assembleExtService;
      this.techArtifactService = techArtifactService;
      this.artifactExtService = artifactExtService;
      this.taskNumberLinkService = taskNumberLinkService;
      this.mesBuildingArtifactSchedulingService = mesBuildingArtifactSchedulingService;
   }
}
