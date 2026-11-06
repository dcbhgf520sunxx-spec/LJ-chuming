package com.hzchum.scim.rest.schedule;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageBehaviorTotalScore;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.service.ProjectManageBehaviorTotalScoreService;
import com.hzchum.scim.project.core.api.service.ProjectManageRosterService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProjectBehaviorScoreSchedule {
   private static final Logger log = LoggerFactory.getLogger(ProjectBehaviorScoreSchedule.class);
   @Resource
   private ProjectManageBehaviorTotalScoreService totalScoreService;
   @Resource
   private ProjectManageRosterService rosterService;
   @Resource
   private UserService userService;
   @Resource
   private ContractProjectService projectService;

   @Scheduled(cron = "0 0 0 1 1 ?")
   public void task() {
      log.info("-----------------  新一年的行为总分设置开始 -----------------");
      int currentYear = LocalDate.now().getYear();
      List<ProjectManageBehaviorTotalScore> lastYearConfigList = this.totalScoreService
         .list(Wrappers.lambdaQuery(ProjectManageBehaviorTotalScore.class).eq(ProjectManageBehaviorTotalScore::getYear, currentYear - 1));
      if (!CollUtil.isEmpty(lastYearConfigList)) {
         Map<Long, ProjectManageBehaviorTotalScore> behaviorTotalScoreMap = lastYearConfigList.stream()
            .collect(Collectors.toMap(ProjectManageBehaviorTotalScore::getProjectId, Function.identity()));

         for (Long projectId : behaviorTotalScoreMap.keySet()) {
            ContractProject project = this.projectService.getById(projectId);
            if (project != null && !SettlementStatusEnum.SETTLED.getType().equals(project.getSettlementStatus())
               && ProjectStatusEnum.PROCESSING.getType().equals(project.getStatus())) {
               ProjectManageBehaviorTotalScore currentYearTotalScore = this.totalScoreService.getByYear(projectId, currentYear);
               if (BeanUtil.isEmpty(currentYearTotalScore)) {
                  currentYearTotalScore = behaviorTotalScoreMap.get(projectId);
                  currentYearTotalScore.setId(null);
                  currentYearTotalScore.setCreateTime(null);
                  currentYearTotalScore.setUpdateTime(null);
                  currentYearTotalScore.setYear(currentYear);
                  this.totalScoreService.save(currentYearTotalScore);
                  List<ProjectManageRoster> rosterList = this.rosterService
                     .list(Wrappers.lambdaQuery(ProjectManageRoster.class).eq(ProjectManageRoster::getProjectId, projectId));
                  ProjectManageBehaviorTotalScore finalCurrentYearTotalScore = currentYearTotalScore;
                  List<ProjectManageRoster> updateRosters = rosterList.stream()
                     .peek(
                        roster -> {
                           Integer currentBehaviorTotalScore = this.totalScoreService
                              .getTotalScore(finalCurrentYearTotalScore, roster.getEntryDate(), projectId, currentYear);
                           roster.setBehaviorTotalScore(currentBehaviorTotalScore);
                        }
                     )
                     .collect(Collectors.toList());
                  this.rosterService.updateBatchById(updateRosters);
               }
            }
         }

         log.info("-----------------  新一年的行为总分设置结束 -----------------");
      }
   }
}
