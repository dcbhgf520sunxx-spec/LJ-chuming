package com.hzchum.scim.rest.runner.test;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

public class AreaBatchRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(AreaBatchRunner.class);
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private PlanAreaBatchService areaBatchService;
   @Resource
   private MoveOutboundDetailService outboundDetailService;

   @Override
   public void run(String... args) throws Exception {
      for (PlanAreaBatch areaBatch : this.areaBatchService.list()) {
         int areaBatchCount = this.artifactService.count(Wrappers.lambdaQuery(TechArtifact.builder().areaBatchId(areaBatch.getId()).build()));
         int outboundAreaBatchCount = this.outboundDetailService
            .count(Wrappers.lambdaQuery(MoveOutboundDetail.class).eq(MoveOutboundDetail::getAreaBatchId, areaBatch.getId()));
         if (areaBatchCount == 0 && outboundAreaBatchCount == 0) {
            this.areaBatchService.removeById(areaBatch.getId());
         }
      }
   }
}
