package com.hzchum.scim.rest.runner.onecode;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.base.Preconditions;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactSpecAmend;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactSpecAmendService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(201)
public class OneCodeRunnerThree implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(OneCodeRunnerThree.class);
   private final TechArtifactSpecAmendService artifactSpecAmendService;
   private final TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   private final TechMachinePartService machinePartService;
   @Value("${chum.config.companyName}")
   private String companyName;

   @Override
   public void run(String... args) throws Exception {
      List<TechArtifactSpecAmend> artifactSpecAmendList = this.artifactSpecAmendService
         .list((Wrapper<TechArtifactSpecAmend>)new LambdaQueryWrapper<TechArtifactSpecAmend>().isNull(TechArtifactSpecAmend::getInventoryOperationId));
      if (CollectionUtils.isEmpty(artifactSpecAmendList)) {
         this.artifactSpecAmendService.removeByIds(artifactSpecAmendList.stream().map(TechArtifactSpecAmend::getId).collect(Collectors.toList()));
      }

      if (this.companyName.contains("金山") || this.companyName.contains("富煌")) {
         List<TechAssembleMachinePartLink> list = this.assembleMachinePartLinkService.list();
         if (CollectionUtils.isNotEmpty(list)) {
            List<TechMachinePart> machinePartList = this.machinePartService
               .listByIds(list.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toList()));
            Preconditions.checkArgument(
               machinePartList.stream().allMatch(e -> e.getRelationType().equals(MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType())), "操作失败"
            );
            this.machinePartService.removeByIds(machinePartList.stream().map(TechMachinePart::getId).collect(Collectors.toList()));
            this.assembleMachinePartLinkService.removeByIds(list.stream().map(TechAssembleMachinePartLink::getId).collect(Collectors.toList()));
         }
      }
   }

   public OneCodeRunnerThree(
      final TechArtifactSpecAmendService artifactSpecAmendService,
      final TechAssembleMachinePartLinkService assembleMachinePartLinkService,
      final TechMachinePartService machinePartService
   ) {
      this.artifactSpecAmendService = artifactSpecAmendService;
      this.assembleMachinePartLinkService = assembleMachinePartLinkService;
      this.machinePartService = machinePartService;
   }
}
