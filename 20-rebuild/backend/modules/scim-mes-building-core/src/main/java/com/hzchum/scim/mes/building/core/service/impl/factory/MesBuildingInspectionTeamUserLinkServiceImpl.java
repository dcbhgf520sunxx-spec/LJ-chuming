package com.hzchum.scim.mes.building.core.service.impl.factory;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeamUserLink;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingInspectionTeamUserLinkService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingInspectionTeamUserLinkMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingInspectionTeamUserLinkServiceImpl
   extends ServiceImpl<MesBuildingInspectionTeamUserLinkMapper, MesBuildingInspectionTeamUserLink>
   implements MesBuildingInspectionTeamUserLinkService {
   @Autowired
   private MesBuildingInspectionTeamUserLinkMapper inspectionTeamUserLinkMapper;

   @Override
   public List<MesBuildingInspectionTeamUserLink> selectByCondition(Long processId) {
      return this.inspectionTeamUserLinkMapper.selectByCondition(processId);
   }

   @Override
   public Boolean checkUserExist(Long userId) {
      return this.baseMapper.selectCount(Wrappers.lambdaQuery(MesBuildingInspectionTeamUserLink.builder().userId(userId).build())) > 0;
   }
}
