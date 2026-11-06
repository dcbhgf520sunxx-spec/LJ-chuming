package com.hzchum.scim.mes.building.core.mapper.laborManagement;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesBehaviorTotalScore;
import org.apache.ibatis.annotations.Param;

public interface MesBehaviorTotalScoreMapper extends BaseMapper<MesBehaviorTotalScore> {
   MesBehaviorTotalScore getTotalScoreByYear(@Param("year") Integer year);
}
