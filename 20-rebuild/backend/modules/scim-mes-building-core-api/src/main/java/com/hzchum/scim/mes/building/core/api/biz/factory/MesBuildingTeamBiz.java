package com.hzchum.scim.mes.building.core.api.biz.factory;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingMachinePartTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamByProLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamLeaderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesProcessTeamListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.UseTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingPartTeamDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingTeamDTOParam;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface MesBuildingTeamBiz extends IBiz<MesBuildingTeam> {
   Boolean saveTeam(MesBuildingTeamDTOParam dtoParam);

   @Transactional(rollbackFor = Exception.class)
   Boolean saveTeam2(MesBuildingTeamDTOParam dtoParam);

   Boolean saveMachinePartTeam(MesBuildingPartTeamDTOParam dtoParam);

   Boolean teamUpdate(MesBuildingTeamDTOParam mesBuildingTeamDTOParam);

   @Transactional(rollbackFor = Exception.class)
   Boolean machinePartTeamUpdate(MesBuildingPartTeamDTOParam dtoParam);

   boolean deleteTeamByIds(List<Long> ids);

   @Transactional(rollbackFor = Exception.class)
   boolean deleteMachinePartTeamByIds(List<Long> ids);

   List<MesBuildingTeamDTO> listByCondition(MesBuildingTeamDTOParam dtoParam);

   List<MesBuildingTeamLeaderDTO> findAllTeamLeader(MesBuildingTeamDTOParam dtoParam);

   List<MesProcessTeamListDTO> findProcessTeamList(Long workShopId, Long productionLineId);

   List<UseTeamDTO> listByProcessId(Long processId, Long workshopId);

   PageVO<MesBuildingMachinePartTeamDTO> machinePartListByCondition(MesBuildingPartTeamDTOParam dtoParam);

   MesBuildingTeamDTO teamById(Long id);

   MesBuildingMachinePartTeamDTO machinePartTeamById(Long id);

   PageVO<MesBuildingTeamDTO> teamPage(MesBuildingTeamDTOParam dtoParam, Long sort, Integer pageNumber, Integer pageSize);

   List<UseTeamDTO> useTeam(Long userId);

   boolean teamStatus(Long teamId, Boolean teamStatus);

   MesBuildingTeamByProLineDTO findProductionLineTeam(Long prodLineId);

   boolean machinePartTeamStatus(Long teamId, Boolean teamStatus);

   List<MesBuildingTeamDTO> workshopProductionLineTeamLeader(MesBuildingTeamDTOParam mesBuildingTeamDTOParam);
}
