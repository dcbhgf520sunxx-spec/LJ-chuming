package com.hzchum.scim.rest.runner;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingSpotCheckQhse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingSpotCheckQhseService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
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
import org.springframework.stereotype.Component;

@Order
@Component
public class MesBuildingCompleteRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingCompleteRunner.class);
   @Resource
   private InitializationService service;
   @Resource
   private MesBuildingCompleteService completeService;
   @Resource
   private MesBuildingSpotCheckQhseService spotCheckQhseService;
   @Resource
   private MesBuildingTaskService taskService;
   @Resource
   private TechArtifactService artifactService;

   @Override
   public void run(String... args) throws Exception {
      String datasource = this.service.selectSql("SELECT DATABASE()").get(0);
      List<MesBuildingSpotCheckQhse> spotCheckQhses = this.spotCheckQhseService.list();
      List<String> resultSql = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='mes_building_complete' AND TABLE_SCHEMA ='" + datasource + "'");
      if (resultSql.contains("bool_spot_check") && CollectionUtils.isEmpty(spotCheckQhses)) {
         List<MesBuildingComplete> completes = this.completeService
            .list((Wrapper<MesBuildingComplete>)new LambdaQueryWrapper<MesBuildingComplete>().eq(MesBuildingComplete::getBoolSpotCheck, Boolean.TRUE));
         if (CollectionUtils.isNotEmpty(completes)) {
            List<MesBuildingTask> tasks = this.taskService.listByIds(completes.stream().map(MesBuildingComplete::getTaskId).collect(Collectors.toList()));
            if (CollectionUtils.isNotEmpty(tasks)) {
               Map<Long, TechArtifact> artifactMap = this.artifactService
                  .listByIds(tasks.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList()))
                  .stream()
                  .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
               Map<Long, MesBuildingTask> taskMap = tasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
               Map<String, List<MesBuildingComplete>> completeMap = completes.stream()
                  .collect(Collectors.groupingBy(e -> e.getProductId() + "-" + e.getTaskId() + "-" + e.getSpotCheckDate() + "-" + e.getSpotCheckUserName()));
               completeMap.forEach((key, list) -> {
                  MesBuildingComplete complete = list.get(0);
                  MesBuildingTask task = taskMap.get(complete.getTaskId());
                  TechArtifact artifact = artifactMap.get(complete.getProductId());
                  if (task != null && artifact != null) {
                     MesBuildingSpotCheckQhse spotCheckQhse = BeanUtil.copy(task, MesBuildingSpotCheckQhse.class);
                     BeanUtil.copy(artifact, spotCheckQhse);
                     spotCheckQhse.setTaskId(task.getId());
                     spotCheckQhse.setSpotCheckQuantity(list.size());
                     spotCheckQhse.setTaskTypeEnum(TaskTypeEnum.ARTIFACT.getType());
                     spotCheckQhse.setQualifiedQuantity(list.stream().mapToInt(MesBuildingComplete::getQualifiedQuantity).sum());
                     spotCheckQhse.setUnQualifiedQuantity(list.stream().mapToInt(MesBuildingComplete::getUnQualifiedQuantity).sum());
                     spotCheckQhse.setSpotCheckDateTime(complete.getSpotCheckDateTime());
                     spotCheckQhse.setSpotCheckUserName(complete.getSpotCheckUserName());
                     spotCheckQhse.setSpotCheckRemark(complete.getSpotCheckRemark());
                     spotCheckQhse.setSpotCheckDate(complete.getSpotCheckDateTime().format(DatePattern.NORM_MONTH_FORMATTER));
                     spotCheckQhse.setSpotCheckDayDate(complete.getSpotCheckDateTime().format(DatePattern.NORM_DATE_FORMATTER));
                     this.spotCheckQhseService.save(spotCheckQhse);
                  }
               });
            }
         }
      }
   }
}
