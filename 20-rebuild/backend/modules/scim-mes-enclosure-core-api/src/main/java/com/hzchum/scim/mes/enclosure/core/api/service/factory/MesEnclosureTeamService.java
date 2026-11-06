package com.hzchum.scim.mes.enclosure.core.api.service.factory;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureTeam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.factory.MesEnclosureTeamDOParam;
import java.util.List;

public interface MesEnclosureTeamService extends IService<MesEnclosureTeam> {
   List<MesEnclosureTeam> listByCondition(MesEnclosureTeamDOParam doParam);
}
