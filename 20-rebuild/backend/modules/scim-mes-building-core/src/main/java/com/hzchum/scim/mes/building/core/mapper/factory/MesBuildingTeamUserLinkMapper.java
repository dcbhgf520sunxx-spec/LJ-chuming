package com.hzchum.scim.mes.building.core.mapper.factory;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamByUserDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingTeamUserLinkMapper extends BaseMapper<MesBuildingTeamUserLink> {
   List<MesBuildingTeamUserLink> selectByCondition(@Param("processId") Long processId, @Param("teamId") Long teamId);

   List<MesBuildingTeamByUserDTO> listProductionLineAndProcessUser(Long currentUserId);

   MesBuildingTeamUserLink getTeamLeaderNameByGroupId(@Param("processId") Long processId, @Param("assistGroupId") Long assistGroupId);

   MesBuildingTeamUserLink getTeamLeaderNameByTeamId(@Param("teamId") Long teamId);
}
