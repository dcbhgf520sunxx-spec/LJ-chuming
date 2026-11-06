package com.hzchum.scim.mes.enclosure.core.server.impl.factory;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureInspectionTeamUserLink;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureInspectionTeamUserLinkService;
import com.hzchum.scim.mes.enclosure.core.mapper.factory.MesEnclosureInspectionTeamUserLinkMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureInspectionTeamUserLinkServiceImpl
   extends ServiceImpl<MesEnclosureInspectionTeamUserLinkMapper, MesEnclosureInspectionTeamUserLink>
   implements MesEnclosureInspectionTeamUserLinkService {
   @Autowired
   private MesEnclosureInspectionTeamUserLinkMapper inspectionTeamUserLinkMapper;

   @Override
   public List<MesEnclosureInspectionTeamUserLink> selectByCondition(Long processId) {
      return this.inspectionTeamUserLinkMapper.selectByCondition(processId);
   }

   @Override
   public Boolean checkUserExist(Long userId) {
      return this.baseMapper.selectCount(Wrappers.lambdaQuery(MesEnclosureInspectionTeamUserLink.builder().userId(userId).build())) > 0;
   }
}
