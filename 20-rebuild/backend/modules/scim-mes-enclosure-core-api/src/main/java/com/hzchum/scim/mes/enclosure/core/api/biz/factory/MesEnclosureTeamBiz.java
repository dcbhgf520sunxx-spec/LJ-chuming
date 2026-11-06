package com.hzchum.scim.mes.enclosure.core.api.biz.factory;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureFactoryDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureTeam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureTeamDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.SchedulingTeamTreeDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.UseTeamDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureTeamDTOParam;
import java.util.List;

public interface MesEnclosureTeamBiz extends IBiz<MesEnclosureTeam> {
   Boolean saveTeam(MesEnclosureTeamDTOParam dtoParam);

   Boolean teamUpdate(MesEnclosureTeamDTOParam mesEnclosureTeamDTOParam);

   boolean deleteTeamByIds(List<Long> ids);

   List<MesEnclosureTeamDTO> listByCondition(MesEnclosureTeamDTOParam dtoParam);

   MesEnclosureTeamDTO teamById(Long id);

   PageVO<MesEnclosureTeamDTO> teamPage(MesEnclosureTeamDTOParam dtoParam, Long sort, Integer pageNumber, Integer pageSize);

   List<UseTeamDTO> useTeam(Long userId);

   List<MesEnclosureFactoryDO> getSchedulingGroupsTree(SchedulingTeamTreeDTO voRequest);

   List<MesEnclosureFactoryDO> getSchedulingGroupsTreeV2(SchedulingTeamTreeDTO voRequest);

   List<IdAndNameDO> listNameByIds(List<Long> teamIds);
}
