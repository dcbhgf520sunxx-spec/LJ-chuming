package com.hzchum.scim.rest.runner.plan;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.plan.core.api.enums.BuildingTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MonomerBuildingTypeRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MonomerBuildingTypeRunner.class);
   private final PlanMonomerService monomerService;
   private final TechArtifactService artifactService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      List<PlanMonomer> monomerList = this.monomerService
         .list(Wrappers.lambdaQuery(PlanMonomer.builder().buildingTypeEnum(BuildingTypeEnum.UNKNOWN.getType()).build()));
      monomerList.forEach(monomer -> {
         int count = this.artifactService.count(Wrappers.lambdaQuery(TechArtifact.builder().monomerId(monomer.getId()).build()));
         if (count > 0) {
            monomer.setBuildingTypeEnum(BuildingTypeEnum.BUILDING.getType());
         }
      });
      this.monomerService.updateBatchById(monomerList);
   }

   public MonomerBuildingTypeRunner(final PlanMonomerService monomerService, final TechArtifactService artifactService) {
      this.monomerService = monomerService;
      this.artifactService = artifactService;
   }
}
