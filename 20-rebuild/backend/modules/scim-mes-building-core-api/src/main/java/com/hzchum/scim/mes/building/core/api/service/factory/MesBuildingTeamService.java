package com.hzchum.scim.mes.building.core.api.service.factory;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.factory.MesBuildingTeamDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamLeaderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesProcessTeamListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesProcessTeamProductionLineListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.MesBuildingLeaderInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.teamForm.GroupTeamLinkDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingTeamQuery;
import java.util.List;

public interface MesBuildingTeamService extends IService<MesBuildingTeam> {
   List<MesBuildingTeam> getTeamByProductionLineIdAndProcessIdAndUserId(Long productionLineId, Long processId, Long userId, List<Long> ids);

   ListVO<ProductProcessDO> listTeamSimple(Long productionLineId);

   ListVO<ProductProcessDO> listTeamUser(Long productionLineId);

   List<MesBuildingTeam> listByCondition(MesBuildingTeamDOParam doParam);

   List<GroupTeamLinkDetailDTO> listTrees();

   List<MesProcessTeamListDTO> findProcessTeamList(Long workShopId, Long productionLineId);

   List<MesBuildingTeamLeaderDTO> findAllTeamLeader(MesBuildingTeamDOParam doParam);

   List<MesProcessTeamProductionLineListDTO> listProductionLineTrees(Long workShopId, Long productionLineId);

   List<MesBuildingLeaderInfoDTO> findAllTeamLeader(List<Long> teamIds);

   List<ShowInfo> listInfoByIds(List<Long> idList);

   List<MesBuildingTeamInfoDTO> listInfo(MesBuildingTeamQuery query);
}
