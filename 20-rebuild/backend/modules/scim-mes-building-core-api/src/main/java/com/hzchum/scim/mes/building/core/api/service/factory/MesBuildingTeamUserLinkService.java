package com.hzchum.scim.mes.building.core.api.service.factory;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamByUserDTO;
import java.util.List;

public interface MesBuildingTeamUserLinkService extends IService<MesBuildingTeamUserLink> {
   List<MesBuildingTeamUserLink> selectByCondition(Long processId, Long id);

   String getLeaderName(Long teamId);

   Boolean checkUserExist(Long userId);

   List<MesBuildingTeamByUserDTO> listProductionLineAndProcessUser();

   MesBuildingTeamUserLink getTeamLeaderNameByGroupId(Long processId, Long assistGroupId);

   MesBuildingTeamUserLink getTeamLeaderNameByTeamId(Long teamId);
}
