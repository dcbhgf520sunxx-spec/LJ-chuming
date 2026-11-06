package com.hzchum.scim.mes.enclosure.core.api.service.factory;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureTeamUserLink;
import java.util.List;

public interface MesEnclosureTeamUserLinkService extends IService<MesEnclosureTeamUserLink> {
   List<MesEnclosureTeamUserLink> selectByCondition(Long processId, Long id);

   String getLeaderName(Long teamId);

   Boolean checkUserExist(Long userId);
}
