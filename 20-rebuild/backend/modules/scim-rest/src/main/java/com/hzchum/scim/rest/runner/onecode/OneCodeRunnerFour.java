package com.hzchum.scim.rest.runner.onecode;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.AddWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingArtifactSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
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

@Order(300)
public class OneCodeRunnerFour implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(OneCodeRunnerFour.class);
   @Resource
   private MesBuildingTaskService taskService;
   @Resource
   private MesBuildingCompleteService mesBuildingCompleteService;
   @Resource
   private MesBuildingTaskNumberLinkService mesBuildingTaskNumberLinkService;
   @Resource
   private MesBuildingArtifactSchedulingService artifactSchedulingService;
   @Resource
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Resource
   private TechArtifactExtService techArtifactExtService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleDetailService assembleDetailService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Resource
   private TechMachinePartService techMachinePartService;
   @Resource
   private TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   @Resource
   private MesBuildingTaskProcessService mesBuildingTaskProcessService;

   @Transactional
   @Override
   public void run(String... args) throws Exception {
      log.info("项目数据自动完成化开始............................................");
      List<MesBuildingTaskProcess> taskProcesses = this.mesBuildingTaskProcessService
         .list(
            (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>()
                  .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType()))
               .in(MesBuildingTaskProcess::getProjectId, 44, 73, 3, 11, 2, 71)
         );
      this.mesBuildingTaskProcessService.removeByIds(taskProcesses.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList()));
      List<MesBuildingTaskProcess> tasks2 = this.mesBuildingTaskProcessService
         .list(
            (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>()
                  .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType()))
               .in(MesBuildingTaskProcess::getProjectId, 44, 73, 3, 11, 2, 71)
         );

      for (MesBuildingTaskProcess task : tasks2) {
         task.setCompleteQuantity(task.getTaskQuantity());
         task.setNeedQuantity(task.getTaskQuantity());
         task.setInspectionQuantity(task.getTaskQuantity());
         task.setProblemQuantity(0);
      }

      this.mesBuildingTaskProcessService.updateBatchById(tasks2);
      log.info("项目数据自动完成结束............................................");
   }

   void addWrehouseByCompletes(List<MesBuildingComplete> completes) {
      List<AddWarehouseDTO> addWarehouseDTOS = new ArrayList<>();

      for (MesBuildingComplete complete : completes) {
         AddWarehouseDTO build = AddWarehouseDTO.builder()
            .factoryId(complete.getFactoryId())
            .workshopId(complete.getWorkshopId())
            .productType(complete.getTaskTypeEnum())
            .productId(complete.getProductId())
            .type(WarehouseTypeEnum.INTO.getType())
            .build();
         addWarehouseDTOS.add(build);
      }

      List<MesBuildingWarehouseSummary> summaries = this.warehouseSummaryService.listWareHouseSummary(addWarehouseDTOS);
      List<MesBuildingWarehouseRecord> records = new ArrayList<>();

      for (MesBuildingComplete complete : completes) {
         MesBuildingWarehouseRecord record = BeanUtil.copy(complete, MesBuildingWarehouseRecord.class);
         record.setCompleteId(complete.getId());
         record.setQuantity(new BigDecimal(complete.getQuantity()));
         record.setUserId(1L);
         record.setUserName("超级管理员");
         record.setNumber(complete.getNumber());
         record.setProductType(complete.getTaskTypeEnum());
         record.setStatus(WarehouseRecordStatusTypeEnum.INTO.getType());
         record.setType(WarehouseTypeEnum.INTO.getType());
         records.add(record);
      }

      this.warehouseRecordService.saveBatch(records);
      Map<String, Integer> completeMap = completes.stream()
         .collect(
            Collectors.toMap(
               s -> s.getFactoryId()
                  + "_"
                  + s.getWorkshopId()
                  + "_"
                  + s.getTaskTypeEnum()
                  + "_"
                  + s.getProductId()
                  + "_"
                  + WarehouseRecordStatusTypeEnum.INTO.getType(),
               MesBuildingComplete::getQuantity,
               Integer::sum
            )
         );
      Map<String, MesBuildingWarehouseSummary> summaryMap = summaries.stream()
         .collect(
            Collectors.toMap(
               s -> s.getFactoryId() + "_" + s.getWorkshopId() + "_" + s.getProductType() + "_" + s.getProductId() + "_" + s.getType(), Function.identity()
            )
         );
      Map<String, MesBuildingWarehouseSummary> saveSummaryMap = new HashMap<>();

      for (String key : completeMap.keySet()) {
         Integer quantity = completeMap.get(key);
         MesBuildingWarehouseSummary summary = summaryMap.get(key);
         if (summary == null) {
            MesBuildingWarehouseSummary updateSummary = saveSummaryMap.get(key);
            if (updateSummary == null) {
               MesBuildingWarehouseSummary saveSummary = BeanUtil.copy(completes.get(0), MesBuildingWarehouseSummary.class);
               saveSummary.setId(null);
               saveSummary.setQuantity(new BigDecimal(quantity));
               saveSummary.setProductType(completes.get(0).getTaskTypeEnum());
               saveSummary.setType(WarehouseTypeEnum.INTO.getType());
               saveSummaryMap.put(key, saveSummary);
            } else {
               updateSummary.setQuantity(updateSummary.getQuantity().add(new BigDecimal(quantity)));
               saveSummaryMap.put(key, updateSummary);
            }
         } else {
            summary.setQuantity(summary.getQuantity().add(new BigDecimal(quantity)));
         }
      }

      this.warehouseSummaryService.saveBatch(new ArrayList<>(saveSummaryMap.values()));
      this.warehouseSummaryService.updateBatchById(new ArrayList<>(summaryMap.values()));
   }
}
