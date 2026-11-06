package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingNestingTeam;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesBuildingNestingTeamDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingNestingTeamMapper extends BaseMapper<MesBuildingNestingTeam> {
   List<MesBuildingNestingTeamDTO> selectListMesBuildingNestingTeam(@Param("workshopId") Long workshopId);

   List<MesBuildingNestingTeamDTO> selectListMesBuildingNestingTeamAll(@Param("workshopId") Long workshopId);

   MesBuildingNestingTeamDTO getByIdMesBuildingNestingTeam(Long id);
}
