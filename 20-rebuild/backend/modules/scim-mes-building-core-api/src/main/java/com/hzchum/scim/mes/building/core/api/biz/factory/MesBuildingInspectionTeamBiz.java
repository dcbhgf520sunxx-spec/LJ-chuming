package com.hzchum.scim.mes.building.core.api.biz.factory;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroups;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingInspectionTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingInspectionTeamDTOParam;
import java.util.List;

public interface MesBuildingInspectionTeamBiz extends IBiz<MesBuildingInspectionTeam> {
   Boolean saveTeam(MesBuildingInspectionTeamDTOParam dtoParam);

   Boolean updateTeam(MesBuildingInspectionTeamDTOParam dtoParam);

   boolean deleteTeamByIds(List<Long> ids);

   List<MesBuildingInspectionTeamDTO> listByCondition(MesBuildingInspectionTeamDTOParam dtoParam);

   PageVO<MesBuildingInspectionTeamDTO> inspectionTeamPage(MesBuildingInspectionTeamDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize);

   MesBuildingInspectionTeamDTO inspectionTeamById(Long id);

   List<MesBuildingInspectionTeam> selectByLine(List<Long> collect);

   List<MesBuildingGroups> selectGroupByLine(List<Long> lineIds);
}
