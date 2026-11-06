package com.hzchum.scim.mes.building.core.mapper.scheduling;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestTeamConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestTeamConfigDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingNestTeamConfigMapper extends BaseMapper<MesBuildingNestTeamConfig> {
   List<MesBuildingNestTeamConfigDTO> selectNestTeamConfigList();

   List<MesBuildingNestTeamConfigDTO> selectNeedNestTeamConfig(@Param("teamId") Long teamId);
}
