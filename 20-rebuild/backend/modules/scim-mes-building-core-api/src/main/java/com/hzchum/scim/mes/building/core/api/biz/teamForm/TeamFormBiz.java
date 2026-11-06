package com.hzchum.scim.mes.building.core.api.biz.teamForm;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.teamForm.TeamFormArtifactAssembleProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.teamForm.TeamFormDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.teamForm.TeamFormDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.teamForm.TeamFormEnclosureDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.teamForm.TeamFormEnclosureDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.teamForm.TeamFormDTOParam;
import java.util.List;
import java.util.Map;

public interface TeamFormBiz {
   List<TeamFormDTO> teamFormProcessSummary(TeamFormDTOParam dtoParam);

   List<TeamFormDetailsDTO> teamFormProcessDetails(TeamFormDTOParam dtoParam);

   PageVO<TeamFormDetailsDTO> teamFormProcessDetailsPage(TeamFormDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> teamFormProcessDetailsPrint(TeamFormDTOParam param);

   List<TeamFormEnclosureDTO> teamFormEnclosure(TeamFormDTOParam dtoParam);

   List<TeamFormEnclosureDetailsDTO> teamFormEnclosureDetails(TeamFormDTOParam dtoParam);

   PrintVO<List<Map<String, Object>>> teamFormEnclosureDetailsPrint(TeamFormDTOParam param);

   List<TeamFormArtifactAssembleProcessDTO> teamFormProcess(TeamFormDTOParam copy);

   PageVO<TeamFormArtifactAssembleProcessDTO> teamFormProcessPage(TeamFormDTOParam copy, String sort, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> teamFormProcessPrint(TeamFormDTOParam param);
}
