package com.hzchum.scim.project.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageBehaviorTotalScore;
import com.hzchum.scim.project.core.api.service.ProjectManageBehaviorTotalScoreService;
import com.hzchum.scim.project.core.mapper.ProjectManageBehaviorTotalScoreMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.springframework.stereotype.Service;

@Service
public class ProjectManageBehaviorTotalScoreServiceImpl
   extends ServiceImpl<ProjectManageBehaviorTotalScoreMapper, ProjectManageBehaviorTotalScore>
   implements ProjectManageBehaviorTotalScoreService {
   @Override
   public ProjectManageBehaviorTotalScore getByYear(Long projectId, Integer year) {
      if (year == null) {
         year = LocalDate.now().getYear();
      }

      return this.getOne(
         Wrappers.lambdaQuery(ProjectManageBehaviorTotalScore.class)
            .eq(ProjectManageBehaviorTotalScore::getProjectId, projectId)
            .eq(ProjectManageBehaviorTotalScore::getYear, year)
      );
   }

   @Override
   public Integer getTotalScore(ProjectManageBehaviorTotalScore behaviorTotalScore, LocalDate entryDate, Long projectId, Integer year) {
      if (year == null) {
         year = LocalDate.now().getYear();
      }

      if (BeanUtil.isEmpty(behaviorTotalScore)) {
         behaviorTotalScore = this.getByYear(projectId, year);
      }

      if (BeanUtil.isNotEmpty(behaviorTotalScore) && entryDate != null) {
         if (behaviorTotalScore.getBoolDeduction() && behaviorTotalScore.getYear() == entryDate.getYear()) {
            BigDecimal dayScore = BigDecimal.valueOf(behaviorTotalScore.getTotalScore().intValue()).divide(BigDecimal.valueOf(365L), 3, RoundingMode.HALF_UP);
            long daysBetween = ChronoUnit.DAYS.between(entryDate, LocalDate.of(behaviorTotalScore.getYear(), 12, 31)) + 1L;
            return dayScore.multiply(BigDecimal.valueOf(daysBetween)).setScale(0, RoundingMode.HALF_UP).intValue();
         } else {
            return behaviorTotalScore.getTotalScore();
         }
      } else {
         return null;
      }
   }
}
