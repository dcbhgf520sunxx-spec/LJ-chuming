package com.hzchum.scim.mes.building.core.service.impl.laborManagement;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesBehaviorTotalScore;
import com.hzchum.scim.mes.building.core.api.service.laborManagement.MesBehaviorTotalScoreService;
import com.hzchum.scim.mes.building.core.mapper.laborManagement.MesBehaviorTotalScoreMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.springframework.stereotype.Service;

@Service
public class MesBehaviorTotalScoreServiceImpl extends ServiceImpl<MesBehaviorTotalScoreMapper, MesBehaviorTotalScore> implements MesBehaviorTotalScoreService {
   @Override
   public MesBehaviorTotalScore getByYear(Integer year) {
      if (year == null) {
         year = LocalDate.now().getYear();
      }

      return this.baseMapper.getTotalScoreByYear(year);
   }

   @Override
   public Integer getTotalScore(MesBehaviorTotalScore behaviorTotalScore, LocalDate entryDate, Integer year) {
      if (year == null) {
         year = LocalDate.now().getYear();
      }

      if (BeanUtil.isEmpty(behaviorTotalScore)) {
         behaviorTotalScore = this.baseMapper.getTotalScoreByYear(year);
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
