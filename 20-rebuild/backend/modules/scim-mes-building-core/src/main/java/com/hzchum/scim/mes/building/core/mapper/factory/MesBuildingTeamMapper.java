package com.hzchum.scim.mes.building.core.mapper.factory;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.factory.MesBuildingTeamDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamLeaderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesProcessTeamListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesProcessTeamProductionLineListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.UseTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.MesBuildingLeaderInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.teamForm.GroupTeamLinkDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingTeamQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingTeamMapper extends BaseMapper<MesBuildingTeam> {
   List<MesBuildingTeam> getTeamByProductionLineIdAndProcessIdAndUserId(
      @Param("productionLineId") Long productionLineId, @Param("processId") Long processId, @Param("userId") Long userId, @Param("ids") List<Long> ids
   );

   List<ProductProcessDO> listTeamSimple(Long productionLineId);

   List<ProductProcessDO> listTeamUser(@Param("productionLineId") Long productionLineId, @Param("currentUserId") Long currentUserId);

   List<MesBuildingTeam> listByCondition(MesBuildingTeamDOParam doParam);

   List<GroupTeamLinkDetailDTO> listTrees();

   List<MesBuildingTeam> listByLineId(@Param("prodLineId") Long prodLineId);

   List<MesBuildingTeamLeaderDTO> findAllTeamLeader(MesBuildingTeamDOParam doParam);

   List<MesProcessTeamListDTO> findProcessTeamList(@Param("workShopId") Long workShopId, @Param("productionLineId") Long productionLineId);

   List<MesProcessTeamProductionLineListDTO> listProductionLineTrees(@Param("workShopId") Long workShopId, @Param("productionLineId") Long productionLineId);

   List<MesBuildingLeaderInfoDTO> findLeaderInfoByTeamIds(@Param("teamIds") List<Long> teamIds);

   List<UseTeamDTO> listByProcessId(@Param("processId") Long processId, @Param("workshopId") Long workshopId);

   List<ShowInfo> listInfoByIds(@Param("idList") List<Long> idList);

   List<MesBuildingTeamInfoDTO> listInfo(MesBuildingTeamQuery query);
}
