package com.hzchum.scim.rest.runner.test;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(4)
public class ArtifactUserNameRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ArtifactUserNameRunner.class);
   private final TechArtifactService artifactService;
   private final TechArtifactExtService artifactExtService;

   @Override
   public void run(String... args) throws Exception {
      List<TechArtifact> artifacts = this.artifactService.list();
      if (artifacts.stream().allMatch(artifactx -> StringUtils.isBlank(artifactx.getUserNames()))) {
         Map<Long, List<TechArtifactExt>> artifactExtMap = this.artifactExtService
            .list()
            .stream()
            .collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));

         for (TechArtifact artifact : artifacts) {
            List<TechArtifactExt> artifactExts = artifactExtMap.get(artifact.getId());
            if (CollectionUtils.isNotEmpty(artifactExts) && artifactExts.stream().allMatch(e -> StringUtils.isNotBlank(e.getImportUserName()))) {
               Set<String> userNameList = artifactExts.stream().map(TechArtifactExt::getImportUserName).collect(Collectors.toSet());
               artifact.setUserNames(String.join(", ", userNameList));
            }
         }

         this.artifactService.updateBatchById(artifacts, 1000);
      }
   }

   public ArtifactUserNameRunner(final TechArtifactService artifactService, final TechArtifactExtService artifactExtService) {
      this.artifactService = artifactService;
      this.artifactExtService = artifactExtService;
   }
}
