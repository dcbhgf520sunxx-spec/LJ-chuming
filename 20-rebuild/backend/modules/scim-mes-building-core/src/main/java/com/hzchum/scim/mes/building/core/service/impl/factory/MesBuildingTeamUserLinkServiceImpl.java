package com.hzchum.scim.mes.building.core.service.impl.factory;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamByUserDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingTeamUserLinkMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTeamUserLinkServiceImpl
   extends ServiceImpl<MesBuildingTeamUserLinkMapper, MesBuildingTeamUserLink>
   implements MesBuildingTeamUserLinkService {
   @Override
   public List<MesBuildingTeamUserLink> selectByCondition(Long processId, Long id) {
      return this.baseMapper.selectByCondition(processId, id);
   }

   @Override
   public String getLeaderName(Long teamId) {
      MesBuildingTeamUserLink link = this.baseMapper
         .selectOne(
            (Wrapper<MesBuildingTeamUserLink>)(Wrappers.<MesBuildingTeamUserLink>lambdaQuery().eq(MesBuildingTeamUserLink::getTeamId, teamId))
               .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, true)
         );
      return link == null ? null : link.getUserName();
   }

   @Override
   public Boolean checkUserExist(Long userId) {
      return this.baseMapper.selectCount(Wrappers.lambdaQuery(MesBuildingTeamUserLink.builder().userId(userId).build())) > 0;
   }

   @Override
   public List<MesBuildingTeamByUserDTO> listProductionLineAndProcessUser() {
      return this.baseMapper.listProductionLineAndProcessUser(UserUtil.getCurrentUserId());
   }

   @Override
   public MesBuildingTeamUserLink getTeamLeaderNameByGroupId(Long processId, Long assistGroupId) {
      return this.baseMapper.getTeamLeaderNameByGroupId(processId, assistGroupId);
   }

   @Override
   public MesBuildingTeamUserLink getTeamLeaderNameByTeamId(Long teamId) {
      return this.baseMapper.getTeamLeaderNameByTeamId(teamId);
   }
}
