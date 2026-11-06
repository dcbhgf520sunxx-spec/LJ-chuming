package com.hzchum.scim.mes.building.core.api.service.factory;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeamUserLink;
import java.util.List;

public interface MesBuildingInspectionTeamUserLinkService extends IService<MesBuildingInspectionTeamUserLink> {
   List<MesBuildingInspectionTeamUserLink> selectByCondition(Long processId);

   Boolean checkUserExist(Long userId);
}
