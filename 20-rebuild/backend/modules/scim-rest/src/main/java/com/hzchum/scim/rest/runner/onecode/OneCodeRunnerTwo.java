package com.hzchum.scim.rest.runner.onecode;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingInProduction;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReportSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageLinkService;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingInProductionService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportSummaryService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleClassifyLink;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleSpec;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassificationMatch;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.SysAssembleClassifyLinkService;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import com.hzchum.scim.system.core.api.service.SysAssembleSpecService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationMatchService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Order(200)
public class OneCodeRunnerTwo implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(OneCodeRunnerTwo.class);
   private final InitializationService service;
   @Resource
   private TechAssembleService techAssembleService;
   @Resource
   private TechMachinePartService techMachinePartService;
   @Resource
   private TechAssembleDetailService assembleDetailService;
   @Resource
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Resource
   private SysSteelClassificationMatchService sysSteelClassificationMatchService;
   @Resource
   private TechAssembleExtService assembleExtService;
   @Resource
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Resource
   private MesBuildingCompleteService mesBuildingCompleteService;
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Resource
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Resource
   private MesBuildingPackageLinkService packageLinkService;
   @Resource
   private MesBuildingPackageNumberLinkService packageNumberLinkService;
   @Resource
   private MesBuildingCargoListProductLinkService cargoListProductLinkService;
   @Resource
   private MesBuildingCargoListProductNumberLinkService cargoListProductNumberLinkService;
   @Resource
   private MesBuildingTaskService mesBuildingTaskService;
   @Resource
   private MesBuildingTaskProcessService mesBuildingTaskProcessService;
   @Resource
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Resource
   private MesBuildingProduceTeamReportSummaryService produceTeamReportSummaryService;
   @Resource
   private MesBuildingInProductionService inProductionService;
   @Resource
   private SysAssembleConfigService assembleConfigService;
   @Resource
   private SysAssembleClassifyLinkService assembleClassifyLinkService;
   @Resource
   private SysAssembleSpecService assembleSpecService;
   @Resource
   private MesBuildingProductProcessService productProcessService;
   @Resource
   private MesBuildingProductProcessLinkService productProcessLinkService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechArtifactExtService artifactExtService;
   @Resource
   private UserService userService;

   @Transactional
   @Override
   public void run(String... args) throws Exception {
      log.info("修改清单初始化开始............................................");
      Map<String, Long> sectionMachinePartSpecMap = this.sysSteelClassificationMatchService
         .list(
            (Wrapper<SysSteelClassificationMatch>)new LambdaQueryWrapper<SysSteelClassificationMatch>()
               .eq(SysSteelClassificationMatch::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECTIONSTEEL.getType())
         )
         .stream()
         .collect(Collectors.toMap(SysSteelClassificationMatch::getKeyword, SysSteelClassificationMatch::getSteelId));
      this.One();
      this.two(sectionMachinePartSpecMap);
      this.Three(sectionMachinePartSpecMap);
      this.four(sectionMachinePartSpecMap);
      List<TechMachinePart> assembleParts = this.techMachinePartService
         .list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().isNull(TechMachinePart::getSteelPlateTypeEnum));
      if (!assembleParts.isEmpty()) {
         List<TechArtifactMachinePartLink> assembleMachinePartLinks = this.artifactMachinePartLinkService
            .list(
               (Wrapper<TechArtifactMachinePartLink>)new LambdaQueryWrapper<TechArtifactMachinePartLink>()
                  .in(TechArtifactMachinePartLink::getMachinePartId, assembleParts.stream().map(TechMachinePart::getId).collect(Collectors.toList()))
            );
         this.artifactMachinePartLinkService
            .removeByIds(assembleMachinePartLinks.stream().map(TechArtifactMachinePartLink::getId).collect(Collectors.toList()));
         this.techMachinePartService.removeByIds(assembleParts.stream().map(TechMachinePart::getId).collect(Collectors.toList()));
         log.info("修改清单初始化结束............................................");
         List<SysAssembleConfig> sysAssembleConfigs = this.assembleConfigService
            .list((Wrapper<SysAssembleConfig>)new LambdaQueryWrapper<SysAssembleConfig>().eq(SysAssembleConfig::getBoolSectionSteel, Boolean.TRUE));
         List<SysAssembleClassifyLink> classifyLinks = this.assembleClassifyLinkService.list();
         List<SysAssembleSpec> sysAssembleSpecs = this.assembleSpecService
            .list((Wrapper<SysAssembleSpec>)new LambdaQueryWrapper<SysAssembleSpec>().eq(SysAssembleSpec::getBoolSectionSteel, Boolean.TRUE));
         List<MesBuildingProductProcess> productProcesses = this.productProcessService
            .list(
               (Wrapper<MesBuildingProductProcess>)(new LambdaQueryWrapper<MesBuildingProductProcess>()
                     .eq(MesBuildingProductProcess::getProductType, ProductTypeEnum.ASSEMBLE.getType()))
                  .in(MesBuildingProductProcess::getTypeId, sysAssembleConfigs.stream().map(SysAssembleConfig::getId).collect(Collectors.toList()))
            );
         if (CollectionUtils.isNotEmpty(productProcesses)) {
            List<MesBuildingProductProcessLink> productProcessLinks = this.productProcessLinkService
               .list(
                  (Wrapper<MesBuildingProductProcessLink>)new LambdaQueryWrapper<MesBuildingProductProcessLink>()
                     .in(
                        MesBuildingProductProcessLink::getProductProcessId,
                        productProcesses.stream().map(MesBuildingProductProcess::getId).collect(Collectors.toList())
                     )
               );
            this.productProcessLinkService.removeByIds(productProcessLinks.stream().map(MesBuildingProductProcessLink::getId).collect(Collectors.toList()));
            this.productProcessService.removeByIds(productProcesses.stream().map(MesBuildingProductProcess::getId).collect(Collectors.toList()));
         }

         this.assembleSpecService.removeByIds(sysAssembleSpecs.stream().map(SysAssembleSpec::getId).collect(Collectors.toList()));
         this.assembleClassifyLinkService.removeByIds(classifyLinks.stream().map(SysAssembleClassifyLink::getId).collect(Collectors.toList()));
         this.assembleConfigService.removeByIds(sysAssembleConfigs.stream().map(SysAssembleConfig::getId).collect(Collectors.toList()));
         List<TechArtifact> artifactList = this.artifactService.list();
         Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
         Map<Long, List<TechArtifactExt>> artifactExtMap = this.artifactExtService
            .list()
            .stream()
            .collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));

         for (TechArtifact artifact : artifactList) {
            artifact.setSerialNumberPrefix(artifact.getName());

            for (TechArtifactExt artifactExt : artifactExtMap.get(artifact.getId())) {
               artifactExt.setImportUserId(artifact.getUserId());
               artifactExt.setImportUserName(userMap.get(artifact.getUserId()).getName());
            }
         }

         this.artifactService.updateBatchById(artifactList);
         this.artifactExtService.updateBatchById(artifactExtMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList()));
         String datasource = this.service.selectSql("SELECT DATABASE()").get(0);
         log.info("修改bim表结构开始............................................");
         List<String> updateSqlList = new ArrayList<>();
         List<String> resultSql = this.service
            .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='tech_assemble' AND  TABLE_SCHEMA ='" + datasource + "'");
         if (resultSql.contains("machine_part_id")) {
            updateSqlList.add("ALTER TABLE tech_assemble MODIFY column machine_part_id bigint(20)  DEFAULT NULL;");
         }

         updateSqlList.forEach(this.service::updateSql);
      }
   }

   private void four(Map<String, Long> sectionMachinePartSpecMap) {
      List<TechAssemble> sendDirectlyAssembleList = this.techAssembleService
         .list(
            (Wrapper<TechAssemble>)((new LambdaQueryWrapper<TechAssemble>().eq(TechAssemble::getBoolSectionSteel, Boolean.TRUE))
                  .eq(TechAssemble::getBoolProcess, Boolean.TRUE))
               .eq(TechAssemble::getBoolSendDirectly, Boolean.FALSE)
         );
      Map<Long, TechAssemble> assembleMap1 = sendDirectlyAssembleList.stream().collect(Collectors.toMap(TechAssemble::getMachinePartId, Function.identity()));
      if (!CollectionUtils.isEmpty(sendDirectlyAssembleList)) {
         List<TechMachinePart> machinePartList = this.techMachinePartService
            .listByIds(sendDirectlyAssembleList.stream().map(TechAssemble::getMachinePartId).collect(Collectors.toList()));

         for (TechMachinePart machinePart : machinePartList) {
            machinePart.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECTIONSTEEL.getType());
            machinePart.setProductClassificationEnum(ProductClassificationEnum.SECTION_PRODUCT.getType());
            machinePart.setSteelId(sectionMachinePartSpecMap.get(machinePart.getSpecPrefix()));
            machinePart.setRelationType(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType());
            machinePart.setBoolProcess(Boolean.FALSE);
            machinePart.setBoolSchedulingEnum(Boolean.FALSE);
            machinePart.setThick(machinePart.getSpecification());
            machinePart.setSpecPrefix(assembleMap1.get(machinePart.getId()).getSpecPrefix());
            machinePart.setSteelSpec(machinePart.getSpecification());
         }

         this.techMachinePartService.updateBatchById(machinePartList);
         List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
            .list(
               (Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>()
                  .in(TechAssembleDetail::getAssembleId, sendDirectlyAssembleList.stream().map(TechAssemble::getId).collect(Collectors.toList()))
            );
         this.assembleDetailService.removeByIds(assembleDetailList.stream().map(TechAssembleDetail::getId).collect(Collectors.toList()));
         List<Long> assembleIds = sendDirectlyAssembleList.stream().map(TechAssemble::getId).collect(Collectors.toList());
         List<MesBuildingTask> removeTaskList = this.mesBuildingTaskService
            .list(
               (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>().eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType()))
                  .in(MesBuildingTask::getProductId, assembleIds)
            );
         this.mesBuildingTaskService.removeByIds(removeTaskList.stream().map(MesBuildingTask::getId).collect(Collectors.toList()));
         List<MesBuildingTaskProcess> removeTaskProcessList = this.mesBuildingTaskProcessService
            .list(
               (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>()
                     .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType()))
                  .in(MesBuildingTaskProcess::getProductId, assembleIds)
            );
         this.mesBuildingTaskProcessService.removeByIds(removeTaskProcessList.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList()));
         List<MesBuildingProduceTeamReport> produceTeamReports = this.produceTeamReportService
            .list(
               (Wrapper<MesBuildingProduceTeamReport>)(new LambdaQueryWrapper<MesBuildingProduceTeamReport>()
                     .eq(MesBuildingProduceTeamReport::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType()))
                  .in(MesBuildingProduceTeamReport::getProductId, assembleIds)
            );
         this.produceTeamReportService.removeByIds(produceTeamReports.stream().map(MesBuildingProduceTeamReport::getId).collect(Collectors.toList()));
         List<MesBuildingProduceTeamReportSummary> produceTeamReportSummaries = this.produceTeamReportSummaryService
            .list(
               (Wrapper<MesBuildingProduceTeamReportSummary>)(new LambdaQueryWrapper<MesBuildingProduceTeamReportSummary>()
                     .eq(MesBuildingProduceTeamReportSummary::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType()))
                  .in(MesBuildingProduceTeamReportSummary::getProductId, assembleIds)
            );
         this.produceTeamReportSummaryService
            .removeByIds(produceTeamReportSummaries.stream().map(MesBuildingProduceTeamReportSummary::getId).collect(Collectors.toList()));
         List<MesBuildingInProduction> inProductionList = this.inProductionService
            .list(
               (Wrapper<MesBuildingInProduction>)(new LambdaQueryWrapper<MesBuildingInProduction>()
                     .eq(MesBuildingInProduction::getProductType, TaskTypeEnum.ASSEMBLE.getType()))
                  .in(MesBuildingInProduction::getProductId, assembleIds)
            );
         this.inProductionService.removeByIds(inProductionList.stream().map(MesBuildingInProduction::getId).collect(Collectors.toList()));
         List<MesBuildingComplete> mesBuildingCompletes = this.mesBuildingCompleteService
            .list(
               (Wrapper<MesBuildingComplete>)(new LambdaQueryWrapper<MesBuildingComplete>()
                     .eq(MesBuildingComplete::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType()))
                  .in(MesBuildingComplete::getProductId, assembleIds)
            );
         this.mesBuildingCompleteService.removeByIds(mesBuildingCompletes.stream().map(MesBuildingComplete::getId).collect(Collectors.toList()));
         this.techAssembleService.removeByIds(assembleIds);
      }
   }

   private void Three(Map<String, Long> sectionMachinePartSpecMap) {
      List<TechAssemble> sendDirectlyAssembleList = this.techAssembleService
         .list(
            (Wrapper<TechAssemble>)((new LambdaQueryWrapper<TechAssemble>().eq(TechAssemble::getBoolSectionSteel, Boolean.TRUE))
                  .eq(TechAssemble::getBoolProcess, Boolean.FALSE))
               .eq(TechAssemble::getBoolSendDirectly, Boolean.TRUE)
         );
      Map<Long, TechAssemble> assembleMap1 = sendDirectlyAssembleList.stream().collect(Collectors.toMap(TechAssemble::getMachinePartId, Function.identity()));
      List<Long> sendDirectlyAssembleIds = sendDirectlyAssembleList.stream().map(TechAssemble::getId).collect(Collectors.toList());
      if (!CollectionUtils.isEmpty(sendDirectlyAssembleIds)) {
         List<TechMachinePart> machinePartList = this.techMachinePartService
            .listByIds(sendDirectlyAssembleList.stream().map(TechAssemble::getMachinePartId).collect(Collectors.toList()));

         for (TechMachinePart machinePart : machinePartList) {
            machinePart.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECTIONSTEEL.getType());
            machinePart.setProductClassificationEnum(ProductClassificationEnum.SECTION_PRODUCT.getType());
            machinePart.setSteelId(sectionMachinePartSpecMap.get(machinePart.getSpecPrefix()));
            machinePart.setRelationType(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType());
            machinePart.setSpecPrefix(assembleMap1.get(machinePart.getId()).getSpecPrefix());
            machinePart.setThick(machinePart.getSpecification());
            machinePart.setSteelSpec(machinePart.getSpecification());
         }

         this.techMachinePartService.updateBatchById(machinePartList);
         List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
            .list(
               (Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>()
                  .in(TechAssembleDetail::getAssembleId, sendDirectlyAssembleList.stream().map(TechAssemble::getId).collect(Collectors.toList()))
            );
         this.assembleDetailService.removeByIds(assembleDetailList.stream().map(TechAssembleDetail::getId).collect(Collectors.toList()));
         Map<Long, TechAssemble> assembleMap = sendDirectlyAssembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         List<MesBuildingComplete> completeList = this.mesBuildingCompleteService
            .list(
               (Wrapper<MesBuildingComplete>)(new LambdaQueryWrapper<MesBuildingComplete>()
                     .eq(MesBuildingComplete::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType()))
                  .in(MesBuildingComplete::getProductId, sendDirectlyAssembleIds)
            );

         for (MesBuildingComplete complete : completeList) {
            complete.setTaskTypeEnum(TaskTypeEnum.MACHINE_PART.getType());
            if (assembleMap.get(complete.getProductId()) == null) {
               System.out.println(1);
            }

            complete.setProductId(assembleMap.get(complete.getProductId()).getMachinePartId());
            complete.setNumber(null);
            complete.setNumberLinkId(null);
         }

         this.mesBuildingCompleteService.updateBatchById(completeList);
         List<MesBuildingWarehouseRecord> warehouseRecords = this.warehouseRecordService
            .list(
               (Wrapper<MesBuildingWarehouseRecord>)(new LambdaQueryWrapper<MesBuildingWarehouseRecord>()
                     .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ASSEMBLE.getType()))
                  .in(MesBuildingWarehouseRecord::getProductId, sendDirectlyAssembleIds)
            );

         for (MesBuildingWarehouseRecord warehouseRecord : warehouseRecords) {
            warehouseRecord.setProductType(ProductTypeEnum.MACHINE_PART.getType());
            warehouseRecord.setProductId(assembleMap.get(warehouseRecord.getProductId()).getMachinePartId());
            warehouseRecord.setNumber(null);
         }

         this.warehouseRecordService.updateBatchById(warehouseRecords);
         List<MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService
            .list(
               (Wrapper<MesBuildingWarehouseSummary>)(new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                     .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ASSEMBLE.getType()))
                  .in(MesBuildingWarehouseSummary::getProductId, sendDirectlyAssembleIds)
            );

         for (MesBuildingWarehouseSummary warehouseSummary : warehouseSummaryList) {
            warehouseSummary.setProductType(ProductTypeEnum.MACHINE_PART.getType());
            warehouseSummary.setProductId(assembleMap.get(warehouseSummary.getProductId()).getMachinePartId());
         }

         this.warehouseSummaryService.updateBatchById(warehouseSummaryList);
         List<MesBuildingPackageLink> packageLinkList = this.packageLinkService
            .list(
               (Wrapper<MesBuildingPackageLink>)(new LambdaQueryWrapper<MesBuildingPackageLink>()
                     .eq(MesBuildingPackageLink::getProductType, ProductTypeEnum.ASSEMBLE.getType()))
                  .in(MesBuildingPackageLink::getProductId, sendDirectlyAssembleIds)
            );
         if (CollectionUtils.isNotEmpty(packageLinkList)) {
            for (MesBuildingPackageLink packageLink : packageLinkList) {
               packageLink.setProductType(ProductTypeEnum.MACHINE_PART.getType());
               packageLink.setProductId(assembleMap.get(packageLink.getProductId()).getMachinePartId());
            }

            this.packageLinkService.updateBatchById(packageLinkList);
         }

         List<MesBuildingPackageNumberLink> packageNumberLinks = this.packageNumberLinkService
            .list(
               (Wrapper<MesBuildingPackageNumberLink>)(new LambdaQueryWrapper<MesBuildingPackageNumberLink>()
                     .eq(MesBuildingPackageNumberLink::getProductType, ProductTypeEnum.ASSEMBLE.getType()))
                  .in(MesBuildingPackageNumberLink::getProductId, sendDirectlyAssembleIds)
            );
         if (CollectionUtils.isNotEmpty(packageNumberLinks)) {
            this.packageLinkService.removeByIds(packageNumberLinks.stream().map(MesBuildingPackageNumberLink::getId).collect(Collectors.toList()));
         }

         List<MesBuildingCargoListProductLink> cargoListProductLinkList = this.cargoListProductLinkService
            .list(
               (Wrapper<MesBuildingCargoListProductLink>)(new LambdaQueryWrapper<MesBuildingCargoListProductLink>()
                     .eq(MesBuildingCargoListProductLink::getProductType, ProductTypeEnum.ASSEMBLE.getType()))
                  .in(MesBuildingCargoListProductLink::getProductId, sendDirectlyAssembleIds)
            );
         if (CollectionUtils.isNotEmpty(cargoListProductLinkList)) {
            for (MesBuildingCargoListProductLink productLink : cargoListProductLinkList) {
               productLink.setProductType(ProductTypeEnum.MACHINE_PART.getType());
               productLink.setProductId(assembleMap.get(productLink.getProductId()).getMachinePartId());
            }

            this.cargoListProductLinkService.updateBatchById(cargoListProductLinkList);
         }

         List<MesBuildingCargoListProductNumberLink> cargoListProductNumberLinks = this.cargoListProductNumberLinkService
            .list(
               (Wrapper<MesBuildingCargoListProductNumberLink>)(new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                     .eq(MesBuildingCargoListProductNumberLink::getProductType, ProductTypeEnum.ASSEMBLE.getType()))
                  .in(MesBuildingCargoListProductNumberLink::getProductId, sendDirectlyAssembleIds)
            );
         if (CollectionUtils.isNotEmpty(cargoListProductNumberLinks)) {
            this.cargoListProductNumberLinkService
               .removeByIds(cargoListProductNumberLinks.stream().map(MesBuildingCargoListProductNumberLink::getId).collect(Collectors.toList()));
         }

         this.techAssembleService.removeByIds(sendDirectlyAssembleList.stream().map(TechAssemble::getId).collect(Collectors.toList()));
      }
   }

   private void two(Map<String, Long> sectionMachinePartSpecMap) {
      List<TechAssemble> assembleList = this.techAssembleService
         .list(
            (Wrapper<TechAssemble>)((new LambdaQueryWrapper<TechAssemble>().eq(TechAssemble::getBoolSectionSteel, Boolean.TRUE))
                  .eq(TechAssemble::getBoolProcess, Boolean.FALSE))
               .eq(TechAssemble::getBoolSendDirectly, Boolean.FALSE)
         );
      if (!CollectionUtils.isEmpty(assembleList)) {
         List<TechMachinePart> equalsAssembleMachinePartList = this.techMachinePartService
            .list(
               (Wrapper<TechMachinePart>)((new LambdaQueryWrapper<TechMachinePart>()
                        .eq(TechMachinePart::getRelationType, MachinePartRelationTypeEnum.EQUALS_ASSEMBLE.getType()))
                     .eq(TechMachinePart::getBoolSendDirectly, Boolean.FALSE))
                  .eq(TechMachinePart::getBoolProcess, Boolean.FALSE)
            );
         List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
            .list(
               (Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>()
                  .in(TechAssembleDetail::getAssembleId, assembleList.stream().map(TechAssemble::getId).collect(Collectors.toList()))
            );
         this.assembleDetailService.removeByIds(assembleDetailList.stream().map(TechAssembleDetail::getId).collect(Collectors.toList()));
         List<TechMachinePart> steelMachineParts = this.techMachinePartService
            .list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getRelationType, MachinePartRelationTypeEnum.FOR_ARTIFACT.getType()));
         steelMachineParts.forEach(part -> {
            part.setProductClassificationEnum(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType());
            part.setSteelPlateTypeEnum(SteelPlateTypeEnum.PRIMARY_MEMBER.getType());
         });
         this.techMachinePartService.updateBatchById(steelMachineParts, steelMachineParts.size());
         List<TechMachinePart> forAssembleMachineParts = this.techMachinePartService
            .list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getRelationType, MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType()));
         forAssembleMachineParts.forEach(part -> {
            part.setProductClassificationEnum(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType());
            part.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECONDARY_MEMBER.getType());
         });
         this.techMachinePartService.updateBatchById(forAssembleMachineParts);
         Map<Long, TechMachinePart> equalsAssembleMachinePartMap = equalsAssembleMachinePartList.stream()
            .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         assembleList.forEach(assemble -> {
            TechMachinePart machinePart = equalsAssembleMachinePartMap.get(assemble.getMachinePartId());
            if (machinePart == null) {
               System.out.println(1);
            }

            machinePart.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECTIONSTEEL.getType());
            machinePart.setProductClassificationEnum(ProductClassificationEnum.SECTION_PRODUCT.getType());
            machinePart.setSteelId(sectionMachinePartSpecMap.get(machinePart.getSpecPrefix()));
            machinePart.setSpecPrefix(assemble.getSpecPrefix());
            machinePart.setSteelSpec(machinePart.getSpecification());
            machinePart.setThick(machinePart.getSpecification());
            machinePart.setRelationType(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType());
         });
         this.techMachinePartService.updateBatchById(equalsAssembleMachinePartMap.values());
         this.techAssembleService.removeByIds(assembleList.stream().map(TechAssemble::getId).collect(Collectors.toList()));
      }
   }

   private void One() {
      List<TechAssemble> assembleList = this.techAssembleService
         .list((Wrapper<TechAssemble>)new LambdaQueryWrapper<TechAssemble>().eq(TechAssemble::getBoolSectionSteel, Boolean.TRUE));
      if (!CollUtil.isEmpty(assembleList)) {
         List<Long> assembleIds = this.techAssembleService
            .list((Wrapper<TechAssemble>)new LambdaQueryWrapper<TechAssemble>().eq(TechAssemble::getBoolSectionSteel, Boolean.FALSE))
            .stream()
            .map(TechAssemble::getId)
            .collect(Collectors.toList());
         List<TechAssembleExt> assembleExtList = this.assembleExtService
            .list(
               (Wrapper<TechAssembleExt>)new LambdaQueryWrapper<TechAssembleExt>()
                  .in(TechAssembleExt::getAssembleId, assembleList.stream().map(TechAssemble::getId).collect(Collectors.toList()))
            );
         List<MesBuildingTaskNumberLink> taskNumberLinkList = this.taskNumberLinkService
            .list(
               (Wrapper<MesBuildingTaskNumberLink>)new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                  .in(MesBuildingTaskNumberLink::getAssembleId, assembleList.stream().map(TechAssemble::getId).collect(Collectors.toList()))
            );
         Map<Long, List<MesBuildingTaskNumberLink>> taskNumberLinkMap = taskNumberLinkList.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactId));
         Map<Long, List<TechAssembleDetail>> assembleDetailMap = this.assembleDetailService
            .list()
            .stream()
            .collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
         taskNumberLinkMap.forEach(
            (artifactId, numberLinkList) -> {
               List<TechAssembleDetail> assembleDetailList = assembleDetailMap.get(artifactId);
               if (assembleDetailList.stream().anyMatch(e -> assembleIds.contains(e.getAssembleId()))) {
                  this.taskNumberLinkService.removeByIds(numberLinkList.stream().map(MesBuildingTaskNumberLink::getId).collect(Collectors.toList()));
               } else {
                  List<Long> assembleIdList = numberLinkList.stream().map(MesBuildingTaskNumberLink::getAssembleId).distinct().collect(Collectors.toList());
                  if (assembleIdList.size() == 1) {
                     if (assembleDetailList.size() != 1) {
                        System.out.println("数据错了1111111111111");
                     }

                     Preconditions.checkArgument(assembleDetailList.size() == 1, "操作失败,！！！！！");

                     for (MesBuildingTaskNumberLink numberLink : numberLinkList) {
                        numberLink.setAssembleId(null);
                        numberLink.setAssembleNumber(null);
                        numberLink.setAssembleTaskProcessId(null);
                        numberLink.setAssembleTaskId(null);
                     }

                     this.taskNumberLinkService.updateBatchById(numberLinkList);
                  } else {
                     Map<Integer, List<MesBuildingTaskNumberLink>> linkList = numberLinkList.stream()
                        .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactNumber));
                     linkList.forEach((artifactNumber, list) -> {
                        for (int i = 0; i < list.size(); i++) {
                           MesBuildingTaskNumberLink numberLinkx = list.get(i);
                           if (i == 0) {
                              numberLinkx.setAssembleId(null);
                              numberLinkx.setAssembleNumber(null);
                              numberLinkx.setAssembleTaskProcessId(null);
                              numberLinkx.setAssembleTaskId(null);
                              this.taskNumberLinkService.updateById(numberLinkx);
                           } else {
                              this.taskNumberLinkService.removeById(numberLinkx.getId());
                           }
                        }
                     });
                  }
               }
            }
         );
         Map<Long, List<TechAssembleExt>> collect = assembleExtList.stream().collect(Collectors.groupingBy(TechAssembleExt::getProjectId));
         collect.forEach((projectId, list) -> this.assembleExtService.removeByIds(list.stream().map(TechAssembleExt::getId).collect(Collectors.toList())));
      }
   }

   public OneCodeRunnerTwo(
      final InitializationService service,
      final TechAssembleService techAssembleService,
      final TechMachinePartService techMachinePartService,
      final TechAssembleDetailService assembleDetailService,
      final TechArtifactMachinePartLinkService artifactMachinePartLinkService,
      final SysSteelClassificationMatchService sysSteelClassificationMatchService,
      final TechAssembleExtService assembleExtService,
      final MesBuildingTaskNumberLinkService taskNumberLinkService,
      final MesBuildingCompleteService mesBuildingCompleteService,
      final MesBuildingWarehouseSummaryService warehouseSummaryService,
      final MesBuildingWarehouseRecordService warehouseRecordService,
      final MesBuildingPackageLinkService packageLinkService,
      final MesBuildingPackageNumberLinkService packageNumberLinkService,
      final MesBuildingCargoListProductLinkService cargoListProductLinkService,
      final MesBuildingCargoListProductNumberLinkService cargoListProductNumberLinkService,
      final MesBuildingTaskService mesBuildingTaskService,
      final MesBuildingTaskProcessService mesBuildingTaskProcessService,
      final MesBuildingProduceTeamReportService produceTeamReportService,
      final MesBuildingProduceTeamReportSummaryService produceTeamReportSummaryService,
      final MesBuildingInProductionService inProductionService,
      final SysAssembleConfigService assembleConfigService,
      final SysAssembleClassifyLinkService assembleClassifyLinkService,
      final SysAssembleSpecService assembleSpecService,
      final MesBuildingProductProcessService productProcessService,
      final MesBuildingProductProcessLinkService productProcessLinkService,
      final TechArtifactService artifactService,
      final TechArtifactExtService artifactExtService,
      final UserService userService
   ) {
      this.service = service;
      this.techAssembleService = techAssembleService;
      this.techMachinePartService = techMachinePartService;
      this.assembleDetailService = assembleDetailService;
      this.artifactMachinePartLinkService = artifactMachinePartLinkService;
      this.sysSteelClassificationMatchService = sysSteelClassificationMatchService;
      this.assembleExtService = assembleExtService;
      this.taskNumberLinkService = taskNumberLinkService;
      this.mesBuildingCompleteService = mesBuildingCompleteService;
      this.warehouseSummaryService = warehouseSummaryService;
      this.warehouseRecordService = warehouseRecordService;
      this.packageLinkService = packageLinkService;
      this.packageNumberLinkService = packageNumberLinkService;
      this.cargoListProductLinkService = cargoListProductLinkService;
      this.cargoListProductNumberLinkService = cargoListProductNumberLinkService;
      this.mesBuildingTaskService = mesBuildingTaskService;
      this.mesBuildingTaskProcessService = mesBuildingTaskProcessService;
      this.produceTeamReportService = produceTeamReportService;
      this.produceTeamReportSummaryService = produceTeamReportSummaryService;
      this.inProductionService = inProductionService;
      this.assembleConfigService = assembleConfigService;
      this.assembleClassifyLinkService = assembleClassifyLinkService;
      this.assembleSpecService = assembleSpecService;
      this.productProcessService = productProcessService;
      this.productProcessLinkService = productProcessLinkService;
      this.artifactService = artifactService;
      this.artifactExtService = artifactExtService;
      this.userService = userService;
   }
}
