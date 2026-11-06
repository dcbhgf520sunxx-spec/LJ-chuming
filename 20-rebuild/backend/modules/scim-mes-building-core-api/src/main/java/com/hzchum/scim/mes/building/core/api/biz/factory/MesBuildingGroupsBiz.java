package com.hzchum.scim.mes.building.core.api.biz.factory;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MesBuildingGroupsTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroups;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.GroupDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingFactoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingGroupsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProcessDullDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingGroupsDTOParam;
import java.util.List;

public interface MesBuildingGroupsBiz extends IBiz<MesBuildingGroups> {
   List<MesBuildingGroupsDTO> listByCondition(MesBuildingGroupsDTOParam dtoParam);

   PageVO<MesBuildingGroupsDTO> pageByCondition(MesBuildingGroupsDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize);

   Boolean saveGroups(MesBuildingGroupsDTOParam doParam);

   Boolean updateGroups(MesBuildingGroupsDTOParam copy);

   Boolean removeGroupsByIds(List<Long> ids);

   Boolean saveTeam(Long id, List<Long> teamIds);

   Boolean saveInspectionTeam(Long id, List<Long> teamIds);

   List<MesBuildingFactoryDTO> getSchedulingGroupsTree(MesBuildingGroupsDTOParam dtoParam, Integer type);

   List<MesBuildingFactoryDTO> getSchedulingGroupsTreeNesting(MesBuildingGroupsDTOParam dtoParam, Integer type);

   List<MesBuildingFactoryDTO> getDrillGroupsTree(MesBuildingGroupsDTOParam dtoParam);

   List<MesBuildingGroups> getGroupsList(Long userId);

   List<MesBuildingGroupsTreeDO> getGroupsTreeList(Long userId);

   List<MesBuildingGroupsTreeDO> getGroupsListInspection(Long userId);

   GroupDetailDTO getTreeByGroupId(Long groupsId);

   List<TaskProcessDullDTO> processDriling(Long workShopId);

   List<GroupDetailDTO> getProductionLineAndGroupsList(Integer productType, Long structureClassId);

   MesBuildingGroups selectgroupByproductionLine(String workshopName, String productionLineName, Integer productType);

   List<GroupDetailDTO> getTreeByGroupIds(List<Long> assistGroupIds);
}
