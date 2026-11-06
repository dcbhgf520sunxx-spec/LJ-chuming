package com.hzchum.scim.rest.runner.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MesBuildingAssistTest2Runner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingAssistTest2Runner.class);
   @Resource
   private MesBuildingAssistService assistService;
   @Resource
   private MesBuildingTaskProcessService taskProcessService;
   @Resource
   private MesBuildingTeamService teamService;

   @Override
   public void run(String... args) throws Exception {
      List<MesBuildingAssist> assistList = this.assistService
         .list((Wrapper<MesBuildingAssist>)new LambdaQueryWrapper<MesBuildingAssist>().isNull(MesBuildingAssist::getTaskTypeEnum));
      if (CollectionUtils.isNotEmpty(assistList)) {
         List<Long> taskProcessIds = assistList.stream().map(MesBuildingAssist::getTaskProcessId).distinct().collect(Collectors.toList());
         Map<Long, MesBuildingTaskProcess> taskProcessMap = this.taskProcessService
            .listByIds(taskProcessIds)
            .stream()
            .collect(Collectors.toMap(MesBuildingTaskProcess::getId, Function.identity()));
         Map<Long, MesBuildingTeam> teamMap = this.teamService.list().stream().collect(Collectors.toMap(MesBuildingTeam::getId, Function.identity()));

         for (MesBuildingAssist assist : assistList) {
            MesBuildingTaskProcess taskProcess = taskProcessMap.get(assist.getTaskProcessId());
            if (taskProcess != null) {
               MesBuildingTeam team = teamMap.get(assist.getTeamId());
               assist.setProjectId(taskProcess.getProjectId());
               assist.setTaskCreateTime(taskProcess.getCreateTime());
               assist.setWorkshopId(team.getWorkshopId());
               assist.setProductionLineId(team.getProductionLineId());
               assist.setSequence(taskProcess.getSequence());
               assist.setTaskTypeEnum(taskProcess.getTaskTypeEnum());
            }
         }

         this.assistService.updateBatchById(assistList, 2000);
      }
   }
}
