package com.hzchum.scim.mes.enclosure.core.api.biz.factory;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureInspectionTeam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureInspectionTeamDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureInspectionTeamDTOParam;
import java.util.List;

public interface MesEnclosureInspectionTeamBiz extends IBiz<MesEnclosureInspectionTeam> {
   Boolean saveTeam(MesEnclosureInspectionTeamDTOParam dtoParam);

   Boolean updateTeam(MesEnclosureInspectionTeamDTOParam dtoParam);

   boolean deleteTeamByIds(List<Long> ids);

   List<MesEnclosureInspectionTeamDTO> listByCondition(MesEnclosureInspectionTeamDTOParam dtoParam);

   PageVO<MesEnclosureInspectionTeamDTO> inspectionTeamPage(MesEnclosureInspectionTeamDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize);

   MesEnclosureInspectionTeamDTO inspectionTeamById(Long id);

   List<MesEnclosureInspectionTeam> selectByLine(List<Long> collect);
}
