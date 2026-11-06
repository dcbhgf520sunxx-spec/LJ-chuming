package com.hzchum.scim.mes.building.core.api.service.laborManagement;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesBehaviorTotalScore;
import java.time.LocalDate;

public interface MesBehaviorTotalScoreService extends IService<MesBehaviorTotalScore> {
   MesBehaviorTotalScore getByYear(Integer year);

   Integer getTotalScore(MesBehaviorTotalScore behaviorTotalScore, LocalDate entryDate, Integer year);
}
