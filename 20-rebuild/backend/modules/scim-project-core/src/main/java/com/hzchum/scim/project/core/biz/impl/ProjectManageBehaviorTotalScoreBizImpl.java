package com.hzchum.scim.project.core.biz.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.project.core.api.biz.ProjectManageBehaviorTotalScoreBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageBehaviorTotalScore;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectManageBehaviorTotalScoreParam;
import com.hzchum.scim.project.core.api.service.ProjectManageBehaviorTotalScoreService;
import com.hzchum.scim.project.core.api.service.ProjectManageRosterService;
import com.hzchum.scim.project.core.mapper.ProjectManageBehaviorTotalScoreMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectManageBehaviorTotalScoreBizImpl
   extends IBizImpl<ProjectManageBehaviorTotalScoreService, ProjectManageBehaviorTotalScoreMapper, ProjectManageBehaviorTotalScore>
   implements ProjectManageBehaviorTotalScoreBiz {
   @Autowired
   private ProjectManageRosterService rosterService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveOrUpdateBehaviorTotalScore(ProjectManageBehaviorTotalScoreParam param) {
      Integer year = LocalDate.now().getYear();
      ProjectManageBehaviorTotalScore projectConfig = this.baseService.getByYear(param.getProjectId(), year);
      if (projectConfig == null) {
         projectConfig = BeanUtil.toBean(param, ProjectManageBehaviorTotalScore.class);
         projectConfig.setYear(year);
      } else {
         BeanUtil.copyProperties(param, projectConfig);
      }

      this.baseService.saveOrUpdate(projectConfig);
      List<ProjectManageRoster> rosters = this.rosterService
         .list(Wrappers.lambdaQuery(ProjectManageRoster.class).eq(ProjectManageRoster::getProjectId, projectConfig.getProjectId()))
         .stream()
         .peek(roster -> {
            Integer currentBehaviorTotalScore = this.baseService.getTotalScore(null, roster.getEntryDate(), param.getProjectId(), year);
            roster.setBehaviorTotalScore(currentBehaviorTotalScore);
         })
         .collect(Collectors.toList());
      this.rosterService.updateBatchById(rosters);
      return true;
   }

   @Override
   public ProjectManageBehaviorTotalScore behaviorTotalScoreInfo(Long projectId, Integer year) {
      return this.baseService.getByYear(projectId, year);
   }
}
