package com.hzchum.scim.rest.runner.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.plan.core.api.enums.BuildingTypeEnum;
import com.hzchum.scim.plan.core.api.manager.TechUtilManager;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechConfigUtilsDTO;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Order(4)
public class TestRunner2 implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(TestRunner2.class);
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechUtilManager techUtilManager;

   @Transactional
   @Override
   public void run(String... args) throws Exception {
      TechConfigUtilsDTO utilsDTO = this.techUtilManager.getTechConfigUtilsDto(BuildingTypeEnum.getMesProductTypeByType(1));
      Map<String, Map<String, Long>> smallArtifactNameMap = utilsDTO.getSmallArtifactNameMap();

      for (TechArtifact artifact : this.artifactService.list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().isNull(TechArtifact::getStructureClassId))) {
         Map<String, Long> stringLongMap = smallArtifactNameMap.get(artifact.getSpecPrefix());
         if (stringLongMap != null) {
            Long sId = stringLongMap.get(artifact.getName());
            if (sId != null) {
               artifact.setStructureClassId(sId);
               artifact.setBoolSchedulingEnum(Boolean.TRUE);
               this.artifactService.updateById(artifact);
            }
         }

         if (artifact.getStructureClassId() == null) {
            if (artifact.getName().equals("檩托") && stringLongMap != null) {
               Long sId = stringLongMap.get("檩托板");
               if (sId != null) {
                  artifact.setStructureClassId(sId);
                  artifact.setBoolSchedulingEnum(Boolean.TRUE);
                  this.artifactService.updateById(artifact);
               }
            }

            if (artifact.getName().equals("方管柱")) {
               artifact.setSpecification("P12*250");
               artifact.setSpecPrefix("P");
               artifact.setStructureClassId(57L);
               artifact.setBoolSchedulingEnum(Boolean.TRUE);
               this.artifactService.updateById(artifact);
            }
         }
      }
   }

   public TestRunner2(final TechArtifactService artifactService, final TechUtilManager techUtilManager) {
      this.artifactService = artifactService;
      this.techUtilManager = techUtilManager;
   }
}
