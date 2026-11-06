package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageBehaviorTotalScore;
import java.time.LocalDate;

public interface ProjectManageBehaviorTotalScoreService extends IService<ProjectManageBehaviorTotalScore> {
   ProjectManageBehaviorTotalScore getByYear(Long projectId, Integer year);

   Integer getTotalScore(ProjectManageBehaviorTotalScore behaviorTotalScore, LocalDate entryDate, Long projectId, Integer year);
}
