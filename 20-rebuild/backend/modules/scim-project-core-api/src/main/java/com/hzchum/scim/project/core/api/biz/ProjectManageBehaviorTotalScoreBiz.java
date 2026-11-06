package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageBehaviorTotalScore;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectManageBehaviorTotalScoreParam;

public interface ProjectManageBehaviorTotalScoreBiz extends IBiz<ProjectManageBehaviorTotalScore> {
   Boolean saveOrUpdateBehaviorTotalScore(ProjectManageBehaviorTotalScoreParam param);

   ProjectManageBehaviorTotalScore behaviorTotalScoreInfo(Long projectId, Integer year);
}
