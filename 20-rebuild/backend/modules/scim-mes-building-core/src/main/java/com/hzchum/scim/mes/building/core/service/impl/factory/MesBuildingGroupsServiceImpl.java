package com.hzchum.scim.mes.building.core.service.impl.factory;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingFactoryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingGroupSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroups;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.factory.MesBuildingGroupsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingGroupsDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingGroupsMapper;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingGroupsServiceImpl extends ServiceImpl<MesBuildingGroupsMapper, MesBuildingGroups> implements MesBuildingGroupsService {
   @Override
   public List<MesBuildingFactoryDO> getSchedulingGroupsTree(MesBuildingGroupsDOParam doParam, Integer type) {
      return this.baseMapper.getSchedulingGroupsTree(doParam, type);
   }

   @Override
   public List<MesBuildingFactoryDO> getSchedulingGroupsTreeNesting(MesBuildingGroupsDOParam doParam, Integer type) {
      return this.baseMapper.getSchedulingGroupsTreeNesting(doParam, type);
   }

   @Override
   public List<MesBuildingFactoryDO> getDrillGroupsTree(MesBuildingGroupsDOParam doParam) {
      return this.baseMapper.getDrillGroupsTree(doParam);
   }

   @Override
   public List<MesBuildingGroupSumDO> selectGroupsByids(Set<Long> groupIds) {
      return this.baseMapper.selectGroupsByids(groupIds);
   }

   @Override
   public List<MesBuildingGroupsDTO> findTeamByGroupsId(List<Long> groupsId) {
      return this.baseMapper.findTeamByGroupsId(groupsId);
   }
}
