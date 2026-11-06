package com.hzchum.scim.rest.runner.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(4)
public class Test8Runner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(Test8Runner.class);
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechAssembleDetailService assembleDetailService;
   @Resource
   private TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   @Resource
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;

   @Override
   public void run(String... args) throws Exception {
      List<TechArtifact> artifacts = this.artifactService.list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getAreaBatchId, 2159));
      List<TechAssemble> assembles = this.assembleService.list((Wrapper<TechAssemble>)new LambdaQueryWrapper<TechAssemble>().eq(TechAssemble::getAreaBatchId, 2159));
      List<TechMachinePart> machinePartList = this.machinePartService
         .list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getAreaBatchId, 2159));
      Map<Long, TechMachinePart> partMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      if (CollectionUtils.isNotEmpty(assembles)) {
         List<TechAssembleMachinePartLink> assembleMachinePartLinks = this.assembleMachinePartLinkService
            .list(
               (Wrapper<TechAssembleMachinePartLink>)new LambdaQueryWrapper<TechAssembleMachinePartLink>()
                  .in(TechAssembleMachinePartLink::getAssembleId, assembles.stream().map(TechAssemble::getId).collect(Collectors.toList()))
            );
         if (CollectionUtils.isNotEmpty(assembleMachinePartLinks)) {
            Map<Long, List<TechAssembleMachinePartLink>> assembleMachinePartLinkMap = assembleMachinePartLinks.stream()
               .collect(Collectors.groupingBy(TechAssembleMachinePartLink::getAssembleId));

            for (TechAssemble assemble : assembles) {
               List<TechAssembleMachinePartLink> techAssembleMachinePartLinks = assembleMachinePartLinkMap.get(assemble.getId());
               if (CollectionUtils.isNotEmpty(techAssembleMachinePartLinks)) {
                  BigDecimal reduce = techAssembleMachinePartLinks.stream()
                     .map(link -> partMap.get(link.getMachinePartId()).getInnerPaintArea().multiply(BigDecimal.valueOf(link.getQuantity().intValue())))
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  if (assemble.getInnerPaintArea().compareTo(reduce) < 0) {
                     assemble.setInnerPaintArea(reduce);
                     this.assembleService.updateById(assemble);
                  }
               }
            }
         }
      }

      Map<Long, TechAssemble> assembleMap = assembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
      Map<Long, List<TechAssembleDetail>> assembleDetailListMap = this.assembleDetailService
         .list(
            (Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>()
               .in(TechAssembleDetail::getArtifactId, artifacts.stream().map(TechArtifact::getId).collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
      Map<Long, List<TechArtifactMachinePartLink>> artifactMachinePartMap = this.artifactMachinePartLinkService
         .list(
            (Wrapper<TechArtifactMachinePartLink>)new LambdaQueryWrapper<TechArtifactMachinePartLink>()
               .in(TechArtifactMachinePartLink::getArtifactId, artifacts.stream().map(TechArtifact::getId).collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));

      for (TechArtifact artifact : artifacts) {
         BigDecimal reduce = BigDecimal.ZERO;
         List<TechAssembleDetail> assembleDetailList = assembleDetailListMap.get(artifact.getId());
         if (CollectionUtils.isNotEmpty(assembleDetailList)) {
            reduce = reduce.add(
               assembleDetailList.stream()
                  .map(link -> assembleMap.get(link.getAssembleId()).getInnerPaintArea().multiply(BigDecimal.valueOf(link.getQuantity().intValue())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
            );
         }

         List<TechArtifactMachinePartLink> machinePartLinks = artifactMachinePartMap.get(artifact.getId());
         if (CollectionUtils.isNotEmpty(machinePartLinks)) {
            reduce = reduce.add(
               machinePartLinks.stream()
                  .map(link -> partMap.get(link.getMachinePartId()).getInnerPaintArea().multiply(BigDecimal.valueOf(link.getQuantity().intValue())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
            );
         }

         if (artifact.getInnerPaintArea().compareTo(reduce) < 0) {
            artifact.setInnerPaintArea(reduce);
            this.artifactService.updateById(artifact);
         }
      }
   }

   public Test8Runner(
      final TechArtifactService artifactService,
      final TechAssembleService assembleService,
      final TechMachinePartService machinePartService,
      final TechAssembleDetailService assembleDetailService,
      final TechAssembleMachinePartLinkService assembleMachinePartLinkService,
      final TechArtifactMachinePartLinkService artifactMachinePartLinkService
   ) {
      this.artifactService = artifactService;
      this.assembleService = assembleService;
      this.machinePartService = machinePartService;
      this.assembleDetailService = assembleDetailService;
      this.assembleMachinePartLinkService = assembleMachinePartLinkService;
      this.artifactMachinePartLinkService = artifactMachinePartLinkService;
   }
}
