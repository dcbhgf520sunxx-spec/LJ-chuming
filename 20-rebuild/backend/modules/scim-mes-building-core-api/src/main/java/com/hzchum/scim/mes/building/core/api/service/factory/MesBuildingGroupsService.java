package com.hzchum.scim.mes.building.core.api.service.factory;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingFactoryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingGroupSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroups;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.factory.MesBuildingGroupsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingGroupsDTO;
import java.util.List;
import java.util.Set;

public interface MesBuildingGroupsService extends IService<MesBuildingGroups> {
   List<MesBuildingFactoryDO> getSchedulingGroupsTree(MesBuildingGroupsDOParam copy, Integer type);

   List<MesBuildingFactoryDO> getSchedulingGroupsTreeNesting(MesBuildingGroupsDOParam copy, Integer type);

   List<MesBuildingFactoryDO> getDrillGroupsTree(MesBuildingGroupsDOParam copy);

   List<MesBuildingGroupSumDO> selectGroupsByids(Set<Long> groupIds);

   List<MesBuildingGroupsDTO> findTeamByGroupsId(List<Long> groupsId);
}
