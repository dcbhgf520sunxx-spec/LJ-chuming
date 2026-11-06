package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.mes.building.core.api.enums.record.PrintTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.record.MesBuildingPrintRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingPrintRecordService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TaskPrintRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(TaskPrintRunner.class);
   @Resource
   private MesBuildingTaskService taskService;
   @Resource
   private MesBuildingPrintRecordService printRecordService;
   @Resource
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   private final InitializationService service;

   @Override
   public void run(String... args) throws Exception {
      String datasource = this.service.selectSql("SELECT DATABASE()").get(0);
      List<String> columnList = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='mes_building_print_record' AND  TABLE_SCHEMA ='" + datasource + "'");
      List<String> updateSqlList = new ArrayList<>();
      if (columnList.contains("numbers")) {
         updateSqlList.add("ALTER TABLE mes_building_print_record MODIFY COLUMN numbers text NULL;");
      }

      updateSqlList.forEach(this.service::updateSql);
      List<MesBuildingPrintRecord> printRecordList = this.printRecordService
         .list(
            (Wrapper<MesBuildingPrintRecord>)(new LambdaQueryWrapper<MesBuildingPrintRecord>().eq(MesBuildingPrintRecord::getType, PrintTypeEnum.TASK.getType()))
               .isNotNull(MesBuildingPrintRecord::getNumbers)
         );
      if (CollectionUtils.isEmpty(printRecordList)) {
         Map<Long, List<MesBuildingTaskNumberLink>> collect = this.taskNumberLinkService
            .list((Wrapper<MesBuildingTaskNumberLink>)new LambdaQueryWrapper<MesBuildingTaskNumberLink>().eq(MesBuildingTaskNumberLink::getBoolOneCode, Boolean.TRUE))
            .stream()
            .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskId));
         Map<Long, List<MesBuildingPrintRecord>> collect1 = this.printRecordService
            .list((Wrapper<MesBuildingPrintRecord>)new LambdaQueryWrapper<MesBuildingPrintRecord>().eq(MesBuildingPrintRecord::getType, PrintTypeEnum.TASK.getType()))
            .stream()
            .collect(Collectors.groupingBy(e -> e.getRelateId()));
         ArrayList<MesBuildingPrintRecord> objects = new ArrayList<>();
         collect1.forEach(
            (taskId, list) -> {
               List<MesBuildingTaskNumberLink> taskNumberLinks = collect.get(taskId);
               if (CollectionUtils.isNotEmpty(taskNumberLinks)) {
                  MesBuildingPrintRecord mesBuildingPrintRecord = list.get(0);
                  String collect2 = taskNumberLinks.stream()
                     .map(MesBuildingTaskNumberLink::getArtifactNumber)
                     .distinct()
                     .filter(Objects::nonNull)
                     .map(Object::toString)
                     .collect(Collectors.joining(","));
                  mesBuildingPrintRecord.setNumbers(collect2);
                  objects.add(mesBuildingPrintRecord);
               }
            }
         );
         if (CollectionUtils.isNotEmpty(objects)) {
            this.printRecordService.updateBatchById(objects);
         }
      }
   }

   public TaskPrintRunner(
      final MesBuildingTaskService taskService,
      final MesBuildingPrintRecordService printRecordService,
      final MesBuildingTaskNumberLinkService taskNumberLinkService,
      final InitializationService service
   ) {
      this.taskService = taskService;
      this.printRecordService = printRecordService;
      this.taskNumberLinkService = taskNumberLinkService;
      this.service = service;
   }
}
