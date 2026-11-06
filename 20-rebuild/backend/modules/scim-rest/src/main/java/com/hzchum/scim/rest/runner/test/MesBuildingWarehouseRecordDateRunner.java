package com.hzchum.scim.rest.runner.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureProduceTeamReport;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureProduceTeamReportService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(300)
public class MesBuildingWarehouseRecordDateRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingWarehouseRecordDateRunner.class);
   @Resource
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Resource
   private MesBuildingProduceTeamReportService teamReportService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private MesBuildingTeamService teamService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechEnclosureService enclosureService;
   @Resource
   private MesEnclosureProduceTeamReportService enclosureProduceTeamReportService;

   @Override
   public void run(String... args) throws Exception {
      Map<Long, MesBuildingTeam> teamMap = this.teamService.list().stream().collect(Collectors.toMap(MesBuildingTeam::getId, Function.identity()));
      List<MesBuildingProduceTeamReport> produceTeamReports = this.teamReportService
         .list((Wrapper<MesBuildingProduceTeamReport>)new LambdaQueryWrapper<MesBuildingProduceTeamReport>().isNull(MesBuildingProduceTeamReport::getProjectId));
      if (CollectionUtils.isNotEmpty(produceTeamReports)) {
         Map<Integer, List<MesBuildingProduceTeamReport>> produceTeamReportMap = produceTeamReports.stream()
            .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getTaskTypeEnum));
         produceTeamReportMap.forEach(
            (productType, produceTeamReportList) -> {
               if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
                  Map<Long, TechArtifact> artifactMap = this.artifactService
                     .list(
                        new LambdaQueryWrapper<TechArtifact>()
                           .select(TechArtifact::getId, TechArtifact::getProjectId, TechArtifact::getMonomerId, TechArtifact::getAreaId)
                     )
                     .stream()
                     .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));

                  for (MesBuildingProduceTeamReport teamReportxxx : produceTeamReportList) {
                     TechArtifact artifact = artifactMap.get(teamReportxxx.getProductId());
                     MesBuildingTeam teamxxx = teamMap.get(teamReportxxx.getTeamId());
                     if (artifact != null) {
                        teamReportxxx.setProjectId(artifact.getProjectId());
                        teamReportxxx.setMonomerId(artifact.getMonomerId());
                        teamReportxxx.setAreaId(artifact.getAreaId());
                     }

                     if (teamxxx != null) {
                        teamReportxxx.setWorkshopId(teamxxx.getWorkshopId());
                        teamReportxxx.setProductionLineId(teamxxx.getProductionLineId());
                     }
                  }

                  this.teamReportService.updateBatchById(produceTeamReportList, 5000);
               }

               if (ProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
                  Map<Long, TechAssemble> assembleMap = this.assembleService
                     .list(
                        new LambdaQueryWrapper<TechAssemble>()
                           .select(TechAssemble::getId, TechAssemble::getProjectId, TechAssemble::getMonomerId, TechAssemble::getAreaId)
                     )
                     .stream()
                     .collect(Collectors.toMap(TechAssemble::getId, Function.identity()));

                  for (MesBuildingProduceTeamReport teamReportxx : produceTeamReportList) {
                     TechAssemble assemble = assembleMap.get(teamReportxx.getProductId());
                     MesBuildingTeam teamxx = teamMap.get(teamReportxx.getTeamId());
                     if (assemble != null) {
                        teamReportxx.setProjectId(assemble.getProjectId());
                        teamReportxx.setMonomerId(assemble.getMonomerId());
                        teamReportxx.setAreaId(assemble.getAreaId());
                     }

                     if (teamxx != null) {
                        teamReportxx.setWorkshopId(teamxx.getWorkshopId());
                        teamReportxx.setProductionLineId(teamxx.getProductionLineId());
                     }
                  }

                  this.teamReportService.updateBatchById(produceTeamReportList, 5000);
               }

               if (ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
                  Map<Long, TechMachinePart> machinePartMap = this.machinePartService
                     .list(
                        new LambdaQueryWrapper<TechMachinePart>()
                           .select(TechMachinePart::getId, TechMachinePart::getProjectId, TechMachinePart::getMonomerId, TechMachinePart::getAreaId)
                     )
                     .stream()
                     .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));

                  for (MesBuildingProduceTeamReport teamReportx : produceTeamReportList) {
                     TechMachinePart machinePart = machinePartMap.get(teamReportx.getProductId());
                     MesBuildingTeam teamx = teamMap.get(teamReportx.getTeamId());
                     if (machinePart != null) {
                        teamReportx.setProjectId(machinePart.getProjectId());
                        teamReportx.setMonomerId(machinePart.getMonomerId());
                        teamReportx.setAreaId(machinePart.getAreaId());
                     }

                     if (teamx != null) {
                        teamReportx.setWorkshopId(teamx.getWorkshopId());
                        teamReportx.setProductionLineId(teamx.getProductionLineId());
                     }
                  }

                  this.teamReportService.updateBatchById(produceTeamReportList, 5000);
               }
            }
         );
      }

      List<MesEnclosureProduceTeamReport> enclosureProduceTeamReports = this.enclosureProduceTeamReportService
         .list((Wrapper<MesEnclosureProduceTeamReport>)new LambdaQueryWrapper<MesEnclosureProduceTeamReport>().isNull(MesEnclosureProduceTeamReport::getProjectId));
      if (CollectionUtils.isNotEmpty(enclosureProduceTeamReports)) {
         for (MesEnclosureProduceTeamReport teamReport : enclosureProduceTeamReports) {
            Map<Long, TechEnclosure> enclosureMap = this.enclosureService
               .list(new LambdaQueryWrapper<TechEnclosure>().select(TechEnclosure::getId, TechEnclosure::getProjectId, TechEnclosure::getEnclosurePlanId))
               .stream()
               .collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
            TechEnclosure enclosure = enclosureMap.get(teamReport.getProductId());
            MesBuildingTeam team = teamMap.get(teamReport.getTeamId());
            if (enclosure != null) {
               teamReport.setProjectId(enclosure.getProjectId());
               teamReport.setEnclosurePlanId(enclosure.getEnclosurePlanId());
            }

            if (team != null) {
               teamReport.setWorkshopId(team.getWorkshopId());
               teamReport.setProductionLineId(team.getProductionLineId());
            }

            this.enclosureProduceTeamReportService.updateBatchById(enclosureProduceTeamReports, 5000);
         }
      }
   }
}
