package com.hzchum.scim.mes.building.core.mapper.laborManagement;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRoster;
import com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement.MesRosterDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesRosterQuery;
import java.util.List;

public interface MesRosterMapper extends BaseMapper<MesRoster> {
   List<MesRosterDTO> rosterList(MesRosterQuery query);

   List<String> nationList();
}
