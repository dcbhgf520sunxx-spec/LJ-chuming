package com.hzchum.scim.rest.runner.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ArtifactTestRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ArtifactTestRunner.class);
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleDetailService assembleDetailService;
   @Resource
   private TechAssembleService assembleService;

   @Override
   public void run(String... args) throws Exception {
      List<TechAssemble> assembles = this.assembleService.list((Wrapper<TechAssemble>)new LambdaQueryWrapper<TechAssemble>().likeRight(TechAssemble::getSerialNumber, "组"));
      if (CollectionUtils.isNotEmpty(assembles)) {
         List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
            .list(
               (Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>()
                  .in(TechAssembleDetail::getAssembleId, assembles.stream().map(TechAssemble::getId).collect(Collectors.toList()))
            );
         if (CollectionUtils.isNotEmpty(assembleDetailList)) {
            List<TechArtifact> artifacts = this.artifactService
               .listByIds(assembleDetailList.stream().map(TechAssembleDetail::getArtifactId).collect(Collectors.toList()));
            if (CollectionUtils.isNotEmpty(artifacts)) {
               for (TechArtifact artifact : artifacts) {
                  artifact.setBoolComposeAssemble(Boolean.TRUE);
               }

               this.artifactService.updateBatchById(artifacts);
            }
         }
      }
   }
}
