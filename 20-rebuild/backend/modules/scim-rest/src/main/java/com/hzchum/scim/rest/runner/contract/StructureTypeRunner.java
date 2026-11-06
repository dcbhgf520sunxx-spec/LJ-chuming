package com.hzchum.scim.rest.runner.contract;

import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractProjectTempService;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.system.core.api.service.SysStructureTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.transaction.annotation.Transactional;

public class StructureTypeRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(StructureTypeRunner.class);
   private final ContractProjectService projectService;
   private final ContractProjectTempService projectTempService;
   private final SysStructureTypeService structureTypeService;
   private final InitializationService service;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
   }

   public StructureTypeRunner(
      final ContractProjectService projectService,
      final ContractProjectTempService projectTempService,
      final SysStructureTypeService structureTypeService,
      final InitializationService service
   ) {
      this.projectService = projectService;
      this.projectTempService = projectTempService;
      this.structureTypeService = structureTypeService;
      this.service = service;
   }
}
