package com.hzchum.scim.mes.building.core.mapper.factory;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingFactoryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingGroupSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroups;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.factory.MesBuildingGroupsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.GroupDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingGroupsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProcessDullDTO;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingGroupsMapper extends BaseMapper<MesBuildingGroups> {
   List<MesBuildingFactoryDO> getSchedulingGroupsTree(@Param("doParam") MesBuildingGroupsDOParam doParam, @Param("type") Integer type);

   List<MesBuildingFactoryDO> getSchedulingGroupsTreeNesting(@Param("doParam") MesBuildingGroupsDOParam doParam, @Param("type") Integer type);

   List<MesBuildingFactoryDO> getDrillGroupsTree(MesBuildingGroupsDOParam doParam);

   GroupDetailDTO getTreeByGroupId(@Param("groupsId") Long groupsId);

   List<TaskProcessDullDTO> processDriling(Long workShopId);

   List<MesBuildingGroupSumDO> selectGroupsByids(@Param("groupIds") Set<Long> groupIds);

   List<GroupDetailDTO> getProductionLineAndGroupsList(@Param("productType") Integer productType, @Param("structureClassId") Long structureClassId);

   MesBuildingGroups selectgroupByproductionLine(
      @Param("productionLineName") String productionLineName, @Param("groupsName") String groupsName, @Param("productType") Integer productType
   );

   List<GroupDetailDTO> getTreeByGroupIds(@Param("groupsIds") List<Long> groupsIds);

   List<MesBuildingGroupsDTO> findTeamByGroupsId(@Param("groupsIds") List<Long> groupsId);
}
