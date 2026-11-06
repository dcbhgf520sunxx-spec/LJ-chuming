package com.hzchum.scim.rest.runner.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Preconditions;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

public class ChangeRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ChangeRunner.class);
   @Resource
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechMachinePartService machinePartService;

   @Override
   public void run(String... args) throws Exception {
      List<TechArtifact> artifactList = this.artifactService.list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().in(TechArtifact::getProjectId, 85, 71));
      List<TechArtifactMachinePartLink> machinePartLinkList = this.artifactMachinePartLinkService
         .list(
            (Wrapper<TechArtifactMachinePartLink>)new LambdaQueryWrapper<TechArtifactMachinePartLink>()
               .in(TechArtifactMachinePartLink::getArtifactId, artifactList.stream().map(TechArtifact::getId).collect(Collectors.toList()))
         );
      List<Long> partIdList = machinePartLinkList.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList());
      Map<Long, TechMachinePart> techMachinePartMap = this.machinePartService
         .listByIds(partIdList)
         .stream()
         .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      Map<Long, TechArtifact> techArtifactMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      Map<Long, List<TechArtifactMachinePartLink>> techMachinePartLinkListMap = machinePartLinkList.stream()
         .collect(Collectors.groupingBy(TechArtifactMachinePartLink::getMachinePartId));
      Map<Long, TechAssemble> techAssembleMap = this.assembleService
         .list((Wrapper<TechAssemble>)new LambdaQueryWrapper<TechAssemble>().in(TechAssemble::getMachinePartId, partIdList))
         .stream()
         .collect(Collectors.toMap(TechAssemble::getMachinePartId, Function.identity()));
      techMachinePartLinkListMap.forEach((key, value) -> {
         TechMachinePart techMachinePart = techMachinePartMap.get(key);
         int number = 0;

         for (TechArtifactMachinePartLink partLink : value) {
            TechArtifact techArtifact = techArtifactMap.get(partLink.getArtifactId());
            number += techArtifact.getProducedQuantity() * partLink.getQuantity();
         }

         techMachinePart.setUsedQuantity(number);
         if (techMachinePart.getProducedQuantity() < techMachinePart.getUsedQuantity()) {
            techMachinePart.setProducedQuantity(techMachinePart.getUsedQuantity());
         }

         if (techMachinePart.getRelationType().equals(MachinePartRelationTypeEnum.EQUALS_ASSEMBLE.getType())) {
            Preconditions.checkArgument(!techAssembleMap.isEmpty(), "部件数据异常");
            TechAssemble assemble = techAssembleMap.get(techMachinePart.getId());
            Preconditions.checkArgument(Objects.nonNull(assemble), "部件数据异常");
            assemble.setUsedQuantity(number);
            if (assemble.getProducedQuantity() < assemble.getUsedQuantity()) {
               assemble.setProducedQuantity(assemble.getUsedQuantity());
            }
         }
      });
      this.assembleService.updateBatchById(techAssembleMap.values());
      this.machinePartService.updateBatchById(techMachinePartMap.values());
   }
}
