package com.hzchum.scim.mes.building.core.api.service.laborManagement;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRoster;
import com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement.MesRosterDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesRosterQuery;
import java.util.List;

public interface MesRosterService extends IService<MesRoster> {
   List<MesRosterDTO> rosterList(MesRosterQuery query);

   List<String> nationList();

   MesRosterDTO getByUserId(Long userId);
}
