package com.hzchum.scim.rest.runner.onecode;

import com.hzchum.scim.business.core.api.pojo.doModel.BusinessArtifact;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingArtifactScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingArtifactSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeRecord;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.change.TechChangeRecordService;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Order(300)
public class OneCodeRunnerFive implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(OneCodeRunnerFive.class);
   @Resource
   private PlanAreaService areaService;
   @Resource
   private PlanAreaBatchService planAreaBatchService;
   @Resource
   private TechArtifactExtService artifactExtService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechAssembleExtService assembleExtService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private MesBuildingArtifactSchedulingService artifactSchedulingService;
   @Resource
   private MesBuildingTaskService taskService;
   @Resource
   private MesBuildingCompleteService mesBuildingCompleteService;
   @Resource
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Resource
   private MesBuildingWarehouseSummaryService mesBuildingWarehouseSummaryService;
   @Resource
   private TechChangeRecordService changeRecordService;
   @Resource
   private BusinessArtifactService businessArtifactService;

   @Transactional
   @Override
   public void run(String... args) throws Exception {
      List<PlanAreaBatch> areaBatchList = this.planAreaBatchService.list();
      areaBatchList.forEach(e -> e.setAreaId(e.getId()));
      this.planAreaBatchService.updateBatchById(areaBatchList);
      List<TechArtifact> artifacts = this.artifactService.list();
      artifacts.forEach(e -> e.setAreaBatchId(e.getAreaId()));
      this.artifactService.updateBatchById(artifacts);
      List<TechArtifactExt> artifactExtList = this.artifactExtService.list();
      artifactExtList.forEach(e -> e.setAreaBatchId(e.getAreaId()));
      this.artifactExtService.updateBatchById(artifactExtList);
      List<TechAssemble> assembles = this.assembleService.list();
      assembles.forEach(e -> e.setAreaBatchId(e.getAreaId()));
      this.assembleService.updateBatchById(assembles);
      List<TechAssembleExt> assembleExtList = this.assembleExtService.list();
      assembleExtList.forEach(e -> e.setAreaBatchId(e.getAreaId()));
      this.assembleExtService.updateBatchById(assembleExtList);
      List<TechMachinePart> parts = this.machinePartService.list();
      parts.forEach(e -> e.setAreaBatchId(e.getAreaId()));
      this.machinePartService.updateBatchById(parts);
      List<MesBuildingArtifactScheduling> artifactSchedulingList = this.artifactSchedulingService.list();
      artifactSchedulingList.forEach(e -> e.setAreaBatchId(e.getAreaId()));
      this.artifactSchedulingService.updateBatchById(artifactSchedulingList);
      List<MesBuildingTask> taskList = this.taskService.list();
      taskList.forEach(e -> e.setAreaBatchId(e.getAreaId()));
      this.taskService.updateBatchById(taskList);
      List<MesBuildingComplete> completes = this.mesBuildingCompleteService.list();
      completes.forEach(e -> e.setAreaBatchId(e.getAreaBatchId()));
      this.mesBuildingCompleteService.updateBatchById(completes);
      List<MesBuildingWarehouseRecord> recordList = this.warehouseRecordService.list();
      recordList.forEach(e -> e.setAreaBatchId(e.getAreaId()));
      this.warehouseRecordService.updateBatchById(recordList);
      List<MesBuildingWarehouseSummary> summaries = this.mesBuildingWarehouseSummaryService.list();
      summaries.forEach(e -> e.setAreaBatchId(e.getAreaBatchId()));
      this.mesBuildingWarehouseSummaryService.updateBatchById(summaries);
      List<TechChangeRecord> techChangeRecords = this.changeRecordService.list();
      techChangeRecords.forEach(e -> e.setAreaBatchId(e.getAreaId()));
      this.changeRecordService.updateBatchById(techChangeRecords);
      List<BusinessArtifact> businessArtifacts = this.businessArtifactService.list();
      businessArtifacts.forEach(e -> e.setAreaBatchId(e.getAreaId()));
      this.businessArtifactService.updateBatchById(businessArtifacts);
   }
}
