package com.hzchum.scim.mes.enclosure.core.api.service.factory;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureInspectionTeamUserLink;
import java.util.List;

public interface MesEnclosureInspectionTeamUserLinkService extends IService<MesEnclosureInspectionTeamUserLink> {
   List<MesEnclosureInspectionTeamUserLink> selectByCondition(Long processId);

   Boolean checkUserExist(Long userId);
}
