package com.hzchum.scim.mes.enclosure.core.server.impl.factory;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureTeamUserLink;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureTeamUserLinkService;
import com.hzchum.scim.mes.enclosure.core.mapper.factory.MesEnclosureTeamUserLinkMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureTeamUserLinkServiceImpl
   extends ServiceImpl<MesEnclosureTeamUserLinkMapper, MesEnclosureTeamUserLink>
   implements MesEnclosureTeamUserLinkService {
   @Override
   public List<MesEnclosureTeamUserLink> selectByCondition(Long processId, Long id) {
      return this.baseMapper.selectByCondition(processId, id);
   }

   @Override
   public String getLeaderName(Long teamId) {
      MesEnclosureTeamUserLink link = this.baseMapper
         .selectOne(
            (Wrapper<MesEnclosureTeamUserLink>)(Wrappers.<MesEnclosureTeamUserLink>lambdaQuery().eq(MesEnclosureTeamUserLink::getTeamId, teamId))
               .eq(MesEnclosureTeamUserLink::getBoolLeaderEnum, true)
         );
      return link == null ? null : link.getUserName();
   }

   @Override
   public Boolean checkUserExist(Long userId) {
      return this.baseMapper.selectCount(Wrappers.lambdaQuery(MesEnclosureTeamUserLink.builder().userId(userId).build())) > 0;
   }
}
