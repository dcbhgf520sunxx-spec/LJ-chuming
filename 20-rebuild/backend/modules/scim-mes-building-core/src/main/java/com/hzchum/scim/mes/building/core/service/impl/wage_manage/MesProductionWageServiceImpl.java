package com.hzchum.scim.mes.building.core.service.impl.wage_manage;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesProductionWage;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.wage_manage.MesProductionWageService;
import com.hzchum.scim.mes.building.core.mapper.wage_manage.MesProductionWageMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactStandardPartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechArtifactStandardPartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.system.core.api.common.enums.ArtifactTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.WageConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectAssemblingWeldingConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectBoltSleeveLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectGroupWeldingConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectLayingOffConfigLinkDTO;
import com.hzchum.scim.system.core.api.service.MesContractProjectAssemblingWeldingConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesContractProjectBoltSleeveLinkService;
import com.hzchum.scim.system.core.api.service.MesContractProjectGroupWeldingConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesContractProjectLayingOffConfigLinkService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesProductionWageServiceImpl extends ServiceImpl<MesProductionWageMapper, MesProductionWage> implements MesProductionWageService {
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Autowired
   private MesBuildingTeamService teamService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesContractProjectAssemblingWeldingConfigLinkService assemblingWeldingConfigLinkService;
   @Autowired
   private TechArtifactStandardPartLinkService artifactStandardPartLinkService;
   @Autowired
   private TechStandardPartService standardPartService;
   @Autowired
   private MesContractProjectBoltSleeveLinkService boltSleeveLinkService;
   @Autowired
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesContractProjectGroupWeldingConfigLinkService groupWeldingConfigLinkService;
   @Autowired
   private TechArtifactMachinePartLinkService machinePartLinkService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private MesContractProjectLayingOffConfigLinkService layingOffConfigLinkService;

   @Override
   public List<MesProductionWage> wageHandle(MesBuildingWarehouseRecord warehouseRecord) {
      List<MesProductionWage> productionWageList = new ArrayList<>();
      TechArtifact artifact = this.artifactService.getById(warehouseRecord.getProductId());
      productionWageList.addAll(this.artifactWageHandle(warehouseRecord, artifact));
      productionWageList.addAll(this.assembleWageHandle(warehouseRecord, artifact));
      productionWageList.addAll(this.machinePartWageHandle(warehouseRecord));
      return productionWageList;
   }

   private List<MesProductionWage> artifactWageHandle(MesBuildingWarehouseRecord warehouseRecord, TechArtifact artifact) {
      List<MesProductionWage> productionWageList = new ArrayList<>();
      List<MesBuildingProduceTeamReport> produceTeamReportList = this.produceTeamReportService
         .list(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
               .eq(MesBuildingProduceTeamReport::getTaskTypeEnum, ProductTypeEnum.ARTIFACT.getType())
               .eq(MesBuildingProduceTeamReport::getProductId, warehouseRecord.getProductId())
               .eq(MesBuildingProduceTeamReport::getNumber, warehouseRecord.getNumber())
         );
      List<Long> teamIds = produceTeamReportList.stream().map(MesBuildingProduceTeamReport::getTeamId).distinct().collect(Collectors.toList());
      Map<Long, String> leaderNameMap = this.teamUserLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
               .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, true)
               .in(MesBuildingTeamUserLink::getTeamId, teamIds)
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingTeamUserLink::getTeamId, MesBuildingTeamUserLink::getUserName));
      Map<Long, MesBuildingTeam> teamMap = this.teamService
         .list(Wrappers.lambdaQuery(MesBuildingTeam.class).in(MesBuildingTeam::getId, teamIds))
         .stream()
         .collect(Collectors.toMap(MesBuildingTeam::getId, Function.identity()));
      produceTeamReportList.forEach(
         ptr -> {
            String leaderName = leaderNameMap.get(ptr.getTeamId());
            MesBuildingTeam team = teamMap.get(ptr.getTeamId());
            String artifactName = artifact.getArtifactType().equals(ArtifactTypeEnum.COMMON.getType()) ? null : artifact.getName();
            MesContractProjectAssemblingWeldingConfigLinkDTO configDTO = this.assemblingWeldingConfigLinkService
               .getOneByCondition(warehouseRecord.getProjectId(), artifact.getStructureClassId(), artifactName, ptr.getProcessId());
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(configDTO), "存在未配置工价的构件, 请先配置工价");
            BigDecimal wage = team.getOrganizationType() ? configDTO.getOrganizationInsidePrice() : configDTO.getOrganizationOutsidePrice();
            BigDecimal measurementQuantity = this.getMeasurementQuantity(
               configDTO.getMeasurementManner(), warehouseRecord.getQuantity().intValue(), artifact.getNetWeight(), artifact.getLength()
            );
            BigDecimal totalWage = measurementQuantity.multiply(wage);
            MesProductionWage artifactProductionWage = MesProductionWage.builder()
               .projectId(warehouseRecord.getProjectId())
               .monomerId(warehouseRecord.getMonomerId())
               .areaId(warehouseRecord.getAreaId())
               .productId(warehouseRecord.getProductId())
               .productType(ProductTypeEnum.ARTIFACT.getType())
               .number(warehouseRecord.getNumber())
               .workshopId(warehouseRecord.getWorkshopId())
               .inboundQuantity(warehouseRecord.getQuantity().intValue())
               .warehouseRecordId(warehouseRecord.getId())
               .inboundTime(warehouseRecord.getCreateTime())
               .processId(ptr.getProcessId())
               .teamId(ptr.getTeamId())
               .teamLeaderName(leaderName)
               .produceTeamReportId(ptr.getId())
               .produceTeamReportTime(ptr.getReportTime())
               .measurementManner(configDTO.getMeasurementManner())
               .wage(wage)
               .totalWage(totalWage)
               .measurementQuantity(measurementQuantity)
               .netWeight(artifact.getNetWeight())
               .totalNetWeight(artifact.getNetWeight().multiply(warehouseRecord.getQuantity()))
               .yield(artifact.getNetWeight().multiply(warehouseRecord.getQuantity()))
               .productProcessType(ProductTypeEnum.ARTIFACT.getType())
               .productClassId(artifact.getStructureClassId())
               .productName(artifact.getName())
               .productSerialNumber(artifact.getSerialNumber())
               .productSpecification(artifact.getSpecification())
               .productMaterial(artifact.getMaterial())
               .productNetWeight(artifact.getNetWeight())
               .yieldQuantity(warehouseRecord.getQuantity().intValue())
               .build();
            productionWageList.add(artifactProductionWage);
            List<TechArtifactStandardPartLink> artifactStandardPartLinkList = this.artifactStandardPartLinkService
               .list(Wrappers.lambdaQuery(TechArtifactStandardPartLink.class).eq(TechArtifactStandardPartLink::getArtifactId, warehouseRecord.getProductId()));
            if (CollUtil.isNotEmpty(artifactStandardPartLinkList)) {
               List<Long> standardPartIds = artifactStandardPartLinkList.stream()
                  .map(TechArtifactStandardPartLink::getStandardPartId)
                  .distinct()
                  .collect(Collectors.toList());
               Map<Long, TechStandardPart> standardPartMap = this.standardPartService
                  .list(Wrappers.lambdaQuery(TechStandardPart.class).in(TechStandardPart::getId, standardPartIds))
                  .stream()
                  .collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
               artifactStandardPartLinkList.forEach(
                  aspl -> {
                     TechStandardPart standardPart = standardPartMap.get(aspl.getStandardPartId());
                     MesContractProjectBoltSleeveLinkDTO boltSleeveLinkDTO = this.boltSleeveLinkService
                        .getOneByCondition(warehouseRecord.getProjectId(), standardPart.getName(), ptr.getProcessId());
                     if (ObjectUtil.isNotEmpty(boltSleeveLinkDTO)) {
                        BigDecimal boltSleeveWage = boltSleeveLinkDTO.getPrice();
                        BigDecimal boltSleeveMeasurementQuantity = warehouseRecord.getQuantity().multiply(BigDecimal.valueOf(aspl.getQuantity().intValue()));
                        BigDecimal boltSleeveTotalWage = boltSleeveMeasurementQuantity.multiply(boltSleeveWage);
                        MesProductionWage boltSleeveProductionWage = MesProductionWage.builder()
                           .projectId(warehouseRecord.getProjectId())
                           .monomerId(warehouseRecord.getMonomerId())
                           .areaId(warehouseRecord.getAreaId())
                           .productId(aspl.getStandardPartId())
                           .productType(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
                           .workshopId(warehouseRecord.getWorkshopId())
                           .warehouseRecordId(warehouseRecord.getId())
                           .inboundTime(warehouseRecord.getCreateTime())
                           .processId(ptr.getProcessId())
                           .teamId(ptr.getTeamId())
                           .teamLeaderName(leaderName)
                           .produceTeamReportId(ptr.getId())
                           .produceTeamReportTime(ptr.getReportTime())
                           .measurementManner(WageQuotaTypeEnum.QUANTITY_PRICE.getType())
                           .wage(boltSleeveWage)
                           .totalWage(boltSleeveTotalWage)
                           .measurementQuantity(boltSleeveMeasurementQuantity)
                           .productProcessType(ProductTypeEnum.ARTIFACT.getType())
                           .productName(standardPart.getName())
                           .productSpecification(standardPart.getSpecification())
                           .build();
                        productionWageList.add(boltSleeveProductionWage);
                     }
                  }
               );
            }
         }
      );
      return productionWageList;
   }

   private List<MesProductionWage> assembleWageHandle(MesBuildingWarehouseRecord warehouseRecord, TechArtifact artifact) {
      List<MesProductionWage> productionWageList = new ArrayList<>();
      List<MesBuildingTaskNumberLink> taskNumberLinkList = this.taskNumberLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
               .eq(MesBuildingTaskNumberLink::getArtifactId, warehouseRecord.getProductId())
               .eq(MesBuildingTaskNumberLink::getArtifactNumber, warehouseRecord.getNumber())
         );
      if (CollUtil.isNotEmpty(taskNumberLinkList)) {
         taskNumberLinkList.forEach(
            tnl -> {
               List<MesBuildingProduceTeamReport> produceTeamReportList = this.produceTeamReportService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
                        .eq(MesBuildingProduceTeamReport::getTaskTypeEnum, ProductTypeEnum.ASSEMBLE.getType())
                        .eq(MesBuildingProduceTeamReport::getProductId, tnl.getAssembleId())
                        .eq(MesBuildingProduceTeamReport::getNumber, tnl.getAssembleNumber())
                  );
               if (CollUtil.isNotEmpty(produceTeamReportList)) {
                  List<Long> teamIds = produceTeamReportList.stream().map(MesBuildingProduceTeamReport::getTeamId).distinct().collect(Collectors.toList());
                  Map<Long, String> leaderNameMap = this.teamUserLinkService
                     .list(
                        Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
                           .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, true)
                           .in(MesBuildingTeamUserLink::getTeamId, teamIds)
                     )
                     .stream()
                     .collect(Collectors.toMap(MesBuildingTeamUserLink::getTeamId, MesBuildingTeamUserLink::getUserName));
                  Map<Long, MesBuildingTeam> teamMap = this.teamService
                     .list(Wrappers.lambdaQuery(MesBuildingTeam.class).in(MesBuildingTeam::getId, teamIds))
                     .stream()
                     .collect(Collectors.toMap(MesBuildingTeam::getId, Function.identity()));
                  List<Long> productIds = produceTeamReportList.stream()
                     .map(MesBuildingProduceTeamReport::getProductId)
                     .distinct()
                     .collect(Collectors.toList());
                  Map<Long, TechAssemble> assembleMap = this.assembleService
                     .list(Wrappers.lambdaQuery(TechAssemble.class).in(TechAssemble::getId, productIds))
                     .stream()
                     .collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
                  List<Long> taskIds = produceTeamReportList.stream().map(MesBuildingProduceTeamReport::getTaskId).distinct().collect(Collectors.toList());
                  Map<Long, MesBuildingTask> taskMap = this.taskService
                     .list(Wrappers.lambdaQuery(MesBuildingTask.class).in(MesBuildingTask::getId, taskIds))
                     .stream()
                     .collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
                  produceTeamReportList.forEach(
                     ptr -> {
                        String leaderName = leaderNameMap.get(ptr.getTeamId());
                        MesBuildingTeam team = teamMap.get(ptr.getTeamId());
                        TechAssemble assemble = assembleMap.get(ptr.getProductId());
                        MesBuildingTask task = taskMap.get(ptr.getTaskId());
                        if (!ObjectUtil.isEmpty(task)) {
                           MesContractProjectGroupWeldingConfigLinkDTO configDTO = this.groupWeldingConfigLinkService
                              .getOneByCondition(warehouseRecord.getProjectId(), assemble.getAssembleConfigId(), ptr.getProcessId());
                           Preconditions.checkArgument(ObjectUtil.isNotEmpty(configDTO), "存在未配置工价的部件, 请先配置工价");
                           BigDecimal wage = team.getOrganizationType() ? configDTO.getOrganizationInsidePrice() : configDTO.getOrganizationOutsidePrice();
                           BigDecimal measurementQuantity = BigDecimal.ZERO;
                           if (configDTO.getStatisticsMode().equals(WageConfigStatisticsModeEnum.ASSEMBLE.getType())) {
                              measurementQuantity = this.getMeasurementQuantity(
                                 configDTO.getMeasurementManner(), ptr.getInspectionQuantity(), assemble.getNetWeight(), assemble.getLength()
                              );
                           }

                           if (configDTO.getStatisticsMode().equals(WageConfigStatisticsModeEnum.ARTIFACT.getType())) {
                              measurementQuantity = this.getMeasurementQuantity(
                                 configDTO.getMeasurementManner(), warehouseRecord.getQuantity().intValue(), artifact.getNetWeight(), artifact.getLength()
                              );
                           }

                           BigDecimal totalWage = measurementQuantity.multiply(wage);
                           MesProductionWage assembleProductionWage = MesProductionWage.builder()
                              .projectId(task.getProjectId())
                              .monomerId(task.getMonomerId())
                              .areaId(task.getAreaId())
                              .productId(task.getProductId())
                              .productType(ProductTypeEnum.ASSEMBLE.getType())
                              .number(ptr.getNumber())
                              .workshopId(task.getWorkshopId())
                              .inboundQuantity(ptr.getInspectionQuantity())
                              .inboundTime(warehouseRecord.getCreateTime())
                              .processId(ptr.getProcessId())
                              .teamId(ptr.getTeamId())
                              .teamLeaderName(leaderName)
                              .produceTeamReportId(ptr.getId())
                              .produceTeamReportTime(ptr.getReportTime())
                              .measurementManner(configDTO.getMeasurementManner())
                              .wage(wage)
                              .totalWage(totalWage)
                              .measurementQuantity(measurementQuantity)
                              .yield(assemble.getNetWeight().multiply(BigDecimal.valueOf(ptr.getInspectionQuantity().intValue())))
                              .productProcessType(ProductTypeEnum.ASSEMBLE.getType())
                              .productClassId(assemble.getAssembleConfigId())
                              .productName(assemble.getName())
                              .productSerialNumber(assemble.getSerialNumber())
                              .productSpecification(assemble.getSpecification())
                              .productMaterial(assemble.getMaterial())
                              .productNetWeight(assemble.getNetWeight())
                              .wageStatisticsMode(configDTO.getStatisticsMode())
                              .yieldQuantity(ptr.getInspectionQuantity())
                              .build();
                           productionWageList.add(assembleProductionWage);
                        }
                     }
                  );
               }
            }
         );
      }

      return productionWageList;
   }

   private List<MesProductionWage> machinePartWageHandle(MesBuildingWarehouseRecord warehouseRecord) {
      List<MesProductionWage> productionWageList = new ArrayList<>();
      List<TechArtifactMachinePartLink> machinePartLinkList = this.machinePartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).eq(TechArtifactMachinePartLink::getArtifactId, warehouseRecord.getProductId()));
      if (CollUtil.isNotEmpty(machinePartLinkList)) {
         List<Long> machinePartIds = machinePartLinkList.stream().map(TechArtifactMachinePartLink::getMachinePartId).distinct().collect(Collectors.toList());
         Map<Long, TechMachinePart> machinePartMap = this.machinePartService
            .list(Wrappers.lambdaQuery(TechMachinePart.class).in(TechMachinePart::getId, machinePartIds).eq(TechMachinePart::getBoolProcess, Boolean.TRUE))
            .stream()
            .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         machinePartLinkList.forEach(
            mpl -> {
               TechMachinePart machinePart = machinePartMap.get(mpl.getMachinePartId());
               if (!ObjectUtil.isEmpty(machinePart)) {
                  Long steelId = machinePart.getProductClassificationEnum().equals(ProductClassificationEnum.SECTION_PRODUCT.getType())
                     ? null
                     : machinePart.getSteelId();
                  MesContractProjectLayingOffConfigLinkDTO configDTO = this.layingOffConfigLinkService
                     .getOneByCondition(warehouseRecord.getProjectId(), machinePart.getProductClassificationEnum(), steelId, Boolean.TRUE);
                  Preconditions.checkArgument(ObjectUtil.isNotEmpty(configDTO), "存在未配置工价的零件, 请先配置工价");
                  BigDecimal wage = configDTO.getOrganizationInsidePrice();
                  BigDecimal measurementQuantity = BigDecimal.ZERO;
                  if (configDTO.getStatisticsMode().equals(WageConfigStatisticsModeEnum.MACHINE_PART.getType())) {
                     measurementQuantity = warehouseRecord.getQuantity().multiply(BigDecimal.valueOf(mpl.getQuantity().intValue()));
                  }

                  if (configDTO.getStatisticsMode().equals(WageConfigStatisticsModeEnum.ARTIFACT.getType())) {
                     measurementQuantity = warehouseRecord.getQuantity();
                  }

                  BigDecimal totalWage = measurementQuantity.multiply(wage);
                  MesProductionWage machinePartProductionWage = MesProductionWage.builder()
                     .projectId(warehouseRecord.getProjectId())
                     .monomerId(warehouseRecord.getMonomerId())
                     .areaId(warehouseRecord.getAreaId())
                     .productId(mpl.getMachinePartId())
                     .productType(ProductTypeEnum.MACHINE_PART.getType())
                     .workshopId(11L)
                     .teamId(7L)
                     .teamLeaderName("张云峰")
                     .wage(wage)
                     .totalWage(totalWage)
                     .measurementManner(WageQuotaTypeEnum.QUANTITY_PRICE.getType())
                     .measurementQuantity(measurementQuantity)
                     .inboundTime(warehouseRecord.getCreateTime())
                     .yield(machinePart.getNetWeight().multiply(warehouseRecord.getQuantity().multiply(BigDecimal.valueOf(mpl.getQuantity().intValue()))))
                     .productProcessType(ProductTypeEnum.MACHINE_PART.getType())
                     .productClassId(machinePart.getSteelId())
                     .productName(machinePart.getName())
                     .productSerialNumber(machinePart.getSerialNumber())
                     .productSpecification(machinePart.getSpecification())
                     .productMaterial(machinePart.getMaterial())
                     .productNetWeight(machinePart.getNetWeight())
                     .wageStatisticsMode(configDTO.getStatisticsMode())
                     .yieldQuantity(warehouseRecord.getQuantity().intValue() * mpl.getQuantity())
                     .build();
                  productionWageList.add(machinePartProductionWage);
               }
            }
         );
      }

      return productionWageList;
   }

   private BigDecimal getMeasurementQuantity(Integer measurementManner, Integer quantity, BigDecimal netWeight, BigDecimal length) {
      WageQuotaTypeEnum typeEnum = WageQuotaTypeEnum.getEnumByType(measurementManner);
      if (typeEnum != null) {
         switch (typeEnum) {
            case WEIGHT_PRICE:
               return netWeight.divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(quantity.intValue()));
            case LENGTH_PRICE:
               return length.divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(quantity.intValue()));
            case QUANTITY_PRICE:
               return BigDecimal.valueOf(quantity.intValue());
         }
      }

      return BigDecimal.ZERO;
   }
}
